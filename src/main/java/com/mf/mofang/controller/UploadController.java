

package com.mf.mofang.controller;

import com.mf.mofang.config.DateUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 文件上传
 *
 * @author pt
 */
@RestController()
@RequestMapping("upload")
@Slf4j
public class UploadController {

    @Value("${wwwroot}")
    String wwwroot = "/app/www/";

    @Value("${domain}")
    String domain = "http://img.sczhmf.com";

    /**
     * 上传
     */
    @PostMapping("/file")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("上传文件不能为空");
        }

        String url = save(file);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("url", url);

        return map;
    }


    public String save(MultipartFile file) {

        //上传的文件
        //后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //当前时间
        String time = DateUtils.format(new Date(), "yyyyMMddHHmmss");

        //文件名
        String name = time + "-" + uuid + suffix;

        // 文件上传的路径
        String filePath = wwwroot + "file/";

        //当前jar路径
//        String currentpath = System.getProperty("user.dir");

        log.info("保存文件到 " + filePath);

        // fileName处理
        String fileName = filePath + name;
        // 文件对象
        File dest = new File(fileName);
        // 创建路径
        if (!FileUtil.exist(filePath)) {
            FileUtil.mkdir(filePath);
        }

        //判断文件是否已经存在
        if (dest.exists()) {
            throw new RuntimeException("文件已经存在");
        }

        try {
            //保存文件
            file.transferTo(dest);
        } catch (IOException e) {
            log.error("上传文件失败", e.getCause());
            throw new RuntimeException(e.getMessage());
        }

        String url = domain + "/file/"  + name;

        return url;
    }


}
