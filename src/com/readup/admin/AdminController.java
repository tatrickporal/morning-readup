package com.readup.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.readup.domain.entity.Article;
import com.readup.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/")
	public String index() {
		return "/admin/index";
	}
	
	@RequestMapping(value="/form")
	public String form(Model model) {
		model.addAttribute("article",new Article());
		return "/admin/form";
	}
	
	@RequestMapping(value="/submit")
	public String submit(HttpServletRequest request, Model model) {
//		model.addAttribute(new Article());
		Article article = new Article();
		if(request != null && model != null) {
			article = adminService.createArticleFromRequest(request,model);
		}
		System.out.println("Next step is to insert into DB " + article.toString());
		model.addAttribute("article",article);
		return "/admin/submit";
	}
}
