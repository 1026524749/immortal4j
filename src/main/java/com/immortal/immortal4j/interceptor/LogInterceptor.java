package com.immortal.immortal4j.interceptor;

import com.alibaba.fastjson.JSON;
import com.immortal.immortal4j.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/10/7 21:14
 */
public class LogInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    private final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocalStartTime");
    private final ThreadLocal<Object> currentUserThreadLocal = new NamedThreadLocal<Object>("ThreadLocalCurrentUser");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UUID uid = UUID.randomUUID();
        String serialId = uid.toString().replace("-","");
        MDC.put("serialId",serialId );
        String requestURL = request.getRequestURI();
        logger.debug("当前请求的URL：【{}】", requestURL);
        logger.debug("执行目标方法: {}", handler);
        String params = JSON.toJSONString(WebUtil.getParameterMap(request));
        logger.debug("当前请求参数打印：{}", JSON.toJSONString(params));
        startTimeThreadLocal.set(System.currentTimeMillis());
        currentUserThreadLocal.set(WebUtil.getCurrentUser(request));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        final Long startTime = startTimeThreadLocal.get();
        final Long endTime = System.currentTimeMillis();
        logger.debug("请求处理时长: {}", endTime-startTime);
    }
}
