package com.spring.ex.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.BDao;

public class BModifyService implements BService {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao  dao = new BDao();
		dao.modify(bId, bName, bTitle, bContent);
	}

}
