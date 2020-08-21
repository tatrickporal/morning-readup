package com.readup.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.readup.domain.entity.Article;
import com.readup.domain.repository.ArticleRepository;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdminService {

	@Autowired
	private ArticleRepository articleRepository;
	
	public Article createArticleFromRequest(HttpServletRequest request, Model model) {
		Article ret = new Article();
		if(request != null && model != null) {
			
			String url = request.getParameter("url");
			String paywall = request.getParameter("paywall");
			String domain = request.getParameter("domain");
			String notes = request.getParameter("notes");
			if(url != null && !url.isEmpty()) {
				ret.setUrl(url);
			}
			if(paywall != null) {
				ret.setPaywall("y");
			}
			if(domain != null && !domain.isEmpty()) {
				ret.setDomain(domain);
			}
			if(notes != null && !notes.isEmpty()) {
				ret.setNotes(notes);
			}
			ret = this.saveArticle(ret);
		}
		
		
		return ret;
	}
	
	private Article saveArticle(Article article) {
		if(article == null) {
			return null;
		}
		article = this.articleRepository.saveArticle(article);
		return article;
	}
}
