package model;

public class Complement {
	private String adresse;
	private String telephone;
	private String instructions;
	
	public Complement() {
		super();
	}
	public Complement(String adresse, String telephone, String instructions) {
		super();
		this.adresse = adresse;
		this.telephone = telephone;
		this.instructions = instructions;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	@Override
	public String toString() {
		return "Complement [adresse=" + adresse + ", telephone=" + telephone + ", instructions=" + instructions + "]";
	}
	
	
	
	
}
