/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

public class Jeux {
    Integer idjeux ;
     String nomjeux;
     Date datesortjeux;
     int  taillejeux;
     String descjeux;
     String platdispojeux;
     String conreqjeux;
    
    

    

    


    public Jeux(int idjeux, String nomjeux, Date datesortjeux, int taillejeux, String descjeux,
			String platdispojeux, String conreqjeux) {
		this.idjeux = idjeux;
		this.nomjeux = nomjeux;
		this.datesortjeux = datesortjeux;
		this.taillejeux = taillejeux;
		this.descjeux = descjeux;
		this.platdispojeux = platdispojeux;
		this.conreqjeux = conreqjeux;
	}
    
    




	public Jeux(String nomjeux, Date datesortjeux, int taillejeux, String descjeux, String platdispojeux,
			String conreqjeux) {
		
		this.nomjeux = nomjeux;
		this.datesortjeux = datesortjeux;
		this.taillejeux = taillejeux;
		this.descjeux = descjeux;
		this.platdispojeux = platdispojeux;
		this.conreqjeux = conreqjeux;
	}




	public Jeux(int idjeux) {
		
		this.idjeux = idjeux;
	}




	public Jeux(String nomjeux) {
		super();
		this.nomjeux = nomjeux;
	}






	public Jeux() {
	}






	public int getIdjeux() {
		return idjeux;
	}




	public void setIdjeux(int idjeux) {
		this.idjeux = idjeux;
	}




	public String getNomjeux() {
		return nomjeux;
	}




	public void setNomjeux(String nomjeux) {
		this.nomjeux = nomjeux;
	}




	public Date getDatesortjeux() {
		return datesortjeux;
	}




	public void setDatesortjeux(Date datesortjeux) {
		this.datesortjeux = datesortjeux;
	}




	public int getTaillejeux() {
		return taillejeux;
	}




	public void setTaillejeux(int taillejeux) {
		this.taillejeux = taillejeux;
	}




	public String getDescjeux() {
		return descjeux;
	}




	public void setDescjeux(String descjeux) {
		this.descjeux = descjeux;
	}




	public String getPlatdispojeux() {
		return platdispojeux;
	}




	public void setPlatdispojeux(String platdispojeux) {
		this.platdispojeux = platdispojeux;
	}




	public String getConreqjeux() {
		return conreqjeux;
	}




	public void setConreqjeux(String conreqjeux) {
		this.conreqjeux = conreqjeux;
	}




	@Override
	public String toString() {
		return "Jeux [idjeux=" + idjeux + ", nomjeux=" + nomjeux + ", datesortjeux=" + datesortjeux + ", taillejeux="
				+ taillejeux + ", descjeuxt=" + descjeux + ", platdispojeux=" + platdispojeux + ", conreqjeux="
				+ conreqjeux + "]";
	}




	
    
   
    
}
