package model;


public class LignePanier {
	private Article article;
	private int qte;
	
	public LignePanier() {
		super();
	}

	public LignePanier(Article article, int qte) {
		super();
		this.article = article;
		this.qte = qte;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
	
	public double getPrixTotal() {
		return article.getTarif() * qte;
	}

	@Override
	public String toString() {
		return "LignePanier [article=" + article + ", qte=" + qte + "]";
	}
	
}
