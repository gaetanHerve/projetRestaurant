package model;

import model.ECategorie;

public class Article {
	private int ref;
	private String nom;
	private String description;
	private ECategorie categorie;
	private double tarif;
	private String urlImage;
	
	public Article() {
		super();
	}

	public Article(int ref, String nom, String description, double tarif, String urlImage) {
		super();
		this.ref = ref;
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.urlImage = urlImage;
	}

	
	public Article(int ref, String nom, String description, double tarif, String urlImage, ECategorie categorie) {
		super();
		this.ref = ref;
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.tarif = tarif;
		this.urlImage = urlImage;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ECategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(ECategorie categorie) {
		this.categorie = categorie;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "Article [ref=" + ref + ", nom=" + nom + ", description=" + description + ", categorie=" + categorie
				+ ", tarif=" + tarif + ", urlImage=" + urlImage + "]";
	}
	
}
