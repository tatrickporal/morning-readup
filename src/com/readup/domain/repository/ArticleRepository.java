package com.readup.domain.repository;



import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.readup.domain.entity.Article;

@Repository
@Transactional
public class ArticleRepository {
	@Autowired
	private SessionFactory sessionFactory;

	public Article saveArticle(Article article) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(article.toString());
		session.save(article);
		return article;
	}
}
