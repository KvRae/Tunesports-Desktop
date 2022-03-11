/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.time.LocalDate;

public class Jeux {
    int idjeux ;
     String nomjeux;
     Date datesortjeux;
     String  taillejeux;
     String descjeux;
     String platdispojeux;
     String conreqjeux;
    
    

    

    


    public Jeux(int idjeux, String nomjeux, Date datesortjeux, String taillejeux, String descjeux,
			String platdispojeux, String conreqjeux) {
		this.idjeux = idjeux;
		this.nomjeux = nomjeux;
		this.datesortjeux = datesortjeux;
		this.taillejeux = taillejeux;
		this.descjeux = descjeux;
		this.platdispojeux = platdispojeux;
		this.conreqjeux = conreqjeux;
	}
    
    




	public Jeux(String nomjeux, Date datesortjeux, String taillejeux, String descjeux, String platdispojeux,
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

    public Jeux(Date datesortjeux) {
        this.datesortjeux = datesortjeux;
    }


  



	public Jeux() {
	}

    

    

    public Jeux(String idjeux, String nomjeux, Date dde, String taillejeux, String descjeux, String platdispojeux, String conreqjeux) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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




	public String getTaillejeux() {
		return taillejeux;
	}




	public void setTaillejeux(String taillejeux) {
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
		return "Jeux [ nomjeux=" + nomjeux + ", datesortjeux=" + datesortjeux + ", taillejeux="
				+ taillejeux + ", descjeuxt=" + descjeux + ", platdispojeux=" + platdispojeux + ", conreqjeux="
				+ conreqjeux + "]";
	}




	
    
   
    
}
