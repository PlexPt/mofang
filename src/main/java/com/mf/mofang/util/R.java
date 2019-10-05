package com.mf.mofang.util;

import lombok.Data;

import java.util.HashMap;

@Data
public class R extends HashMap {

    int code = 0;

    String msg = "操作成功";

    Object data;

    public static R ok() {
        return ok("操作成功");
    }

    public static R ok(String msg) {

        R r = new R();
        r.setCode(0);
        r.setMsg(msg);

        return r;

    }


    public static R error() {
        return error("操作失败");
    }

    public static R error(String msg) {

        R r = new R();
        r.setCode(500);
        r.setMsg(msg);

        return r;

    }


    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
