package entities;

import java.util.List;

public class Livraison {
	
	
	
	public Livraison(String nomliv, int telliv, int fraisliv, int prixltot, String lieuxliv) {
		this.nomliv = nomliv;
		this.telliv = telliv;
		this.fraisliv = fraisliv;
		this.prixltot = prixltot;
		this.lieuxliv = lieuxliv;
	}
	private int idliv;
	private int idcom;
	private String nomliv;
	private int telliv;
	private int fraisliv;
	private int prixltot;
	private String lieuxliv;
	
	
	
	
public Livraison(int idliv) {
		
		this.idliv = idliv;
	}
	
public Livraison(int idcom, String nomliv, int telliv, int fraisliv, int prixltot, String lieuxliv) {
	this.idcom = idcom;
	this.nomliv = nomliv;
	this.telliv = telliv;
	this.fraisliv = fraisliv;
	this.prixltot = prixltot;
	this.lieuxliv = lieuxliv;
}


public Livraison(int idliv, int idcom,String nomliv, int telliv, int fraisliv, int prixltot,
		String lieuxliv) {
	
	this.idliv = idliv;
	this.idcom = idcom;
	this.nomliv = nomliv;
	this.telliv = telliv;
	this.fraisliv = fraisliv;
	this.prixltot = prixltot;
	this.lieuxliv = lieuxliv;
}

	public Livraison() {
	// TODO Auto-generated constructor stub
}

	public int getIdliv() {
		return idliv;
	}
	public void setIdliv(int idliv) {
		this.idliv = idliv;
	}
	public int getIdcom() {
		return idcom;
	}
	public void setIdcom(int idcom) {
		this.idcom = idcom;
	}
	
	
	
	public String getNomliv() {
		return nomliv;
	}
	public void setNomliv(String nomliv) {
		this.nomliv = nomliv;
	}
	public int getTelliv() {
		return telliv;
	}
	public void setTelliv(int telliv) {
		this.telliv = telliv;
	}
	public int getFraisliv() {
		return fraisliv;
	}
	public void setFraisliv(int fraisliv) {
		this.fraisliv = fraisliv;
	}
	public int getPrixltot() {
		return prixltot;
	}
	public void setPrixltot(int prixltot) {
		this.prixltot = prixltot;
	}
	public String getLieuxliv() {
		return lieuxliv;
	}
	public void setLieuxliv(String lieuxliv) {
		this.lieuxliv = lieuxliv;
	}
	@Override
	public String toString() {
		return "Livraison [idliv=" + idliv + ", idcom=" + idcom + " , nomliv=" + nomliv + ", telliv=" + telliv + ", fraisliv=" + fraisliv + ", prixltot=" + prixltot
				+ ", lieuxliv=" + lieuxliv + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
