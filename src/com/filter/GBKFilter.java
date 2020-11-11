package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GBKFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("正在销毁filter过滤器对象....");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		    request.setCharacterEncoding("utf-8");
		    response.setCharacterEncoding("utf-8");
		    System.out.println("正在过滤");
		    chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("正在创建filter过滤器对象");
		
	}

}
