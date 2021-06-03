package com.zshy.system.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import com.zshy.core.common.exception.PreviewException;
import com.zshy.core.common.util.RequestHolder;
import com.zshy.core.common.util.TraceUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 演示环境拦截器
 * @author yanghaifeng
 */
@Slf4j
@Aspect
@Component
public class PreviewAspect {

    @Value("${zshy.preview.enable}")
    private boolean isPreview = false;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Around(
            "execution(static com.zshy.core.common.api.Result *(..)) || " +
                    "(@within(org.springframework.stereotype.Controller) || " +
                    "@within(org.springframework.web.bind.annotation.RestController))"
    )
    public Object aroundApi(ProceedingJoinPoint point) throws Throwable {
        //　获取request
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        if (StringUtils.equalsIgnoreCase(request.getMethod(), HttpMethod.POST.name()) && isPreview
        && !(antPathMatcher.match(request.getRequestURI(), "/provider/log/set"))) {
            log.error("演示环境不能操作！");
            throw new PreviewException("演示环境不能操作！");
        }
        log.error("Request: url:{}", request.getRequestURI());
        TraceUtil.mdcTraceId(TraceUtil.getTraceId(request));
        return point.proceed();
    }
}
