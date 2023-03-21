package com.CustomSoft.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CustomSoft.Service.PapagoApiService;
import com.CustomSoft.db.PapagoDto;

@Controller
@RequestMapping("/api/*")
public class PapagoApiController {
	
	@Autowired
	PapagoApiService service;
	
	@RequestMapping("papagoApiGo")
	public String papagoApi() {
		return "/api/papagoApiGo";
	}
	
	//중국어 번역 리턴
	@PostMapping("papagoApiCh")
	@ResponseBody
	public String papagoApich(@RequestParam(value =  "korean", required = false) String korean) {
		Map<String, String> map = new HashMap<>();
		PapagoDto dto = service.papago(korean);
		dto.setKorean(korean);
		map.put("china", dto.getChinese());
		return map.get("china");
	}
	
	//영어 번역 리턴
	@PostMapping("papagoApiEn")
	@ResponseBody
	public String papagoApiEn(@RequestParam(value =  "korean", required = false) String korean) {
		Map<String, String> map = new HashMap<>();
		PapagoDto dto = service.papago(korean);
		dto.setKorean(korean);
		map.put("english", dto.getEnglish());
		return map.get("english");
	}



	

}
