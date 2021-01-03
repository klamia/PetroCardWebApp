package dz.com.naftal.petrocard.security;

import dz.com.naftal.petrocard.model.Acteur;





public class UserProfile {

	private Acteur acteur;

	private String userName;

	private String fullName;

	private String fonction;

	private String structure;

	public Acteur getActeur() {
		return acteur;
	}

	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFeullName() {
		return fullName;
	}

	public void setFeullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getStructur() {
		return structure;
	}

	public void setStructur(String structure) {
		this.structure = structure;
	}

	
}
