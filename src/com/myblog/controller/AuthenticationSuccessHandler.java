package com.myblog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class AuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		// Find the saved request
System.out.println("login successfull");
		SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(
				request, response);

		if (savedRequest != null)
			request.getSession().setAttribute("redirectUrl",
					savedRequest.getRedirectUrl());

		request.getSession().setAttribute("remoteAddress",
				request.getRemoteAddr());
		response.sendRedirect("admin/processlogin.html");
	}
}
