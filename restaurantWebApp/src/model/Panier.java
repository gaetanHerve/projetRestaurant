package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Panier {
	private List<LignePanier> lignes;

	public Panier() {
		super();
		lignes = new ArrayList<LignePanier>();
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
	
	public int getArticleIndexInPanier(int articleRef) {
		int result = -1;
		if (!lignes.isEmpty()) {
			for (int i = 0; i < lignes.size(); i++) {
				if (lignes.get(i).getArticle().getRef() == articleRef) {
					result = i;
					break;
				}
			}
		}
		return result;
	}
	
	public double getTotal() {
		double result = 0.0;
		if (!lignes.isEmpty()) {
			for (LignePanier ligne : lignes) {
				result += ligne.getArticle().getTarif() * ligne.getQte();
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Panier [lignes=" + lignes + "]";
	}
	
}
