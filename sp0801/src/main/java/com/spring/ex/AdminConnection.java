package com.spring.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {

	private Environment env;
	private String adminId;
	private String adminPw;
	
	@Override
	public void setEnvironment(Environment env) {
		System.out.println("setEnvironment()");
		// Bean 생성 전 호출
		setEnv(env);
	}
	
	public void setEnv(Environment env) {
		this.env = env;
	}
	
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
	public String getAdminId() {
		return adminId;
	}
	
	public String getAdminPw() {
		return adminPw;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		setAdminId(env.getProperty("admin.id"));
		setAdminPw(env.getProperty("admin.pw"));
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()");
	}

}
