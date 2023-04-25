package model;

import java.util.List;

public class Commande {
	private int id;
	private int idClient;
	private String jour;
	private double prixTotal;
	private Panier panier;
	private String infos;
	
	public Commande() {
		super();
	}

	public Commande(int idClient, String jour, double prixTotal) {
		super();
		this.idClient = idClient;
		this.jour = jour;
		this.prixTotal = prixTotal;
	}
	
	public Commande(int idClient, String jour, double prixTotal, Panier panier, String infos) {
		super();
		this.idClient = idClient;
		this.jour = jour;
		this.prixTotal = prixTotal;
		this.panier = panier;
		this.infos = infos;
	}

	public Commande(int id, int idClient, String jour, double prixTotal) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.jour = jour;
		this.prixTotal = prixTotal;
	}
	
	public Commande(int id, int idClient, String jour, double prixTotal, String infos) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.jour = jour;
		this.prixTotal = prixTotal;
		this.infos = infos;
	}

	public Commande(int id, int idClient, String jour, double prixTotal, Panier panier, String infos) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.jour = jour;
		this.prixTotal = prixTotal;
		this.panier = panier;
		this.infos = infos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public void generateInfos() {
		String result = "";
		// prendre le panier => générer la string
		this.setInfos(result);
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", idClient=" + idClient + ", jour=" + jour + ", prixTotal=" + prixTotal
				+ ", panier=" + panier + "]";
	}
	
}
