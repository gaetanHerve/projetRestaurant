package model;

import java.util.List;

public class Carte {
	private List<Article> articles;

	public Carte() {
		super();
	}

	public Carte(List<Article> articles) {
		super();
		this.articles = articles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public Article getArticleByRef(int ref) {
		Article article = null;
		for (Article a : articles) {
			if (a.getRef() == ref) {
				article = a;
				break;
			}
		}
		return article;
	}

	@Override
	public String toString() {
		return "Carte [articles=" + articles + "]";
	}
	
}
