package masterSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String hello(@RequestParam("name") String userName, Model model){
		model.addAttribute("message", "Witaj, " + userName + "!");
		return "resultPage";
	}
	
	public String hello(@RequestParam(required=false)Model model){
		model.addAttribute("message", "Witaj, Świecie!");
		return "resultPage";
	}
}
