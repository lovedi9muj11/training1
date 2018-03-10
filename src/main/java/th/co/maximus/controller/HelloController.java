package th.co.maximus.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import th.co.maximus.bean.Employee;
import th.co.maximus.service.HelloService;

@Controller
public class HelloController {
	
	@Autowired HelloService service;
	
	@GetMapping("/")
	public String savePage(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("allEmployees", new ArrayList<Employee>());
//		(ArrayList<Employee>)employeeServiceInterface.getAllEmployees()
		return "index";
	}
	
	@PostMapping("/insert/save")
	public String save(@ModelAttribute("student") Employee employee, final RedirectAttributes redirectAttributes) {
		if(service.insert(employee)) {
			redirectAttributes.addFlashAttribute("saveStudent", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveStudent", "unsuccess");
		}
		
		return "redirect:/";
	}

}
