package com.spring.ex.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.BDao;
import com.spring.ex.dto.BDto;

public class BListService implements BService {

	@Override
	public void execute(Model model) {

		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}

}
