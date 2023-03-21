package com.CustomSoft.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CustomSoft.Service.JqgridService;
import com.CustomSoft.db.MemberDto;

@Controller
@RequestMapping("/jqgridapi/*")
public class JqgridController {
	
	@Autowired
	JqgridService service;
	
	//jsp 호출
	@RequestMapping("jqGrid")
	public String jqgrid() {
		return "jqgridapi/jqGrid";
	}
	
	//Jqgrid DB연동
	@PostMapping("jqGridGo")
	@ResponseBody
	public List<MemberDto> jqgridGo(MemberDto dto, Model model) {
		List<MemberDto> list = service.Jqgrid();
		model.addAttribute("list", list);
		return list;
	}
	
	
}	
