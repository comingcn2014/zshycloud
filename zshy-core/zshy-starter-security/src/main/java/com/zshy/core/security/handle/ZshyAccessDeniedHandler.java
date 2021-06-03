package com.zshy.core.security.handle;

import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import com.zshy.core.common.api.Result;
import com.zshy.core.common.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ZshyAccessDeniedHandler implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
		ResponseUtil.responseWriter(httpServletResponse, MediaType.APPLICATION_JSON_VALUE, HttpServletResponse.SC_FORBIDDEN, Result.fail("没有访问权限"));
	}
}
