package model;

public class Article {
	private int ref;
	private String nom;
	private String description;
	private ECategorie categorie;
	private int prix;
	private String imageUrl;
	
	public Article() {
		super();
	}

	public Article(int ref, String nom, String description, ECategorie categorie, int prix, String imageUrl) {
		super();
		this.ref = ref;
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.prix = prix;
		this.imageUrl = imageUrl;
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

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Article [ref=" + ref + ", nom=" + nom + ", description=" + description + ", categorie=" + categorie
				+ ", prix=" + prix + ", imageUrl=" + imageUrl + "]";
	}
	
}
