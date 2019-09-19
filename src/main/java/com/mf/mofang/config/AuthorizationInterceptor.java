

package com.mf.mofang.config;


import freemarker.template.Configuration;
import freemarker.template.Template;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

/**
 * 权限(Token)验证
 *
 * @author pt
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    Configuration configuration;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        } else {
            return true;
        }

        if (annotation == null) {
            return true;
        }

        //获取用户凭证
        String token = request.getHeader("token");
        //凭证为空
        if (StringUtils.isBlank(token)
                || (JwtUtil.getClaimByToken(token)) == null
                || JwtUtil.getClaimByToken(token).getSubject() == null) {

            Template t = configuration.getTemplate("login.ftl");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            Writer out = response.getWriter();
            t.process(new ModelMap(), out);
            out.flush();

            return false;
        }


        return true;
    }
}
