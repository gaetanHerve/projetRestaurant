package model;

import java.util.List;

public class Panier {
	private List<LignePanier> lignes;

	public Panier() {
		super();
	}

	public Panier(List<LignePanier> lignes) {
		super();
		this.lignes = lignes;
	}

	public List<LignePanier> getLignes() {
		return lignes;
	}

	public void setLignes(List<LignePanier> lignes) {
		this.lignes = lignes;
	}
	
	public double getTotal() {
		double result = 0;
		for (LignePanier ligne : lignes) {
			result += ligne.getArticle().getTarif() * ligne.getQte();
		}
		return result;
	}

	@Override
	public String toString() {
		return "Panier [lignes=" + lignes + "]";
	}
	
}
