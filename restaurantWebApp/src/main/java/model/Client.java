package model;

public class Client {
	private int id;
	private String password;
	private String nom;
	private String prenom;
	private Complement complement;

	public Client() {
		
	}
	
	public Client(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Client(int id, String password, String nom, String prenom) {
		super();
		this.id = id;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Client(int id, String password, String nom, String prenom, Complement complement) {
		super();
		this.id = id;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.complement = complement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Complement getComplement() {
		return complement;
	}

	public void setComplement(Complement complement) {
		this.complement = complement;
	}

	@Override
	public String toString() {
		String str = "Client id=" + id + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom;
		if (complement != null) {
			str += " " + complement;
		}
		return str;
	}
	
	
	
	
	
}
