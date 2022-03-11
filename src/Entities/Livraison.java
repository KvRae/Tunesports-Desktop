package Entities;

import java.util.List;

public class Livraison {
	
	
	

	private int idliv;
	private String adressel;
	private Double prixp;
	private int idc;
     private String validation;
	
	
	
	
public Livraison(int idliv) {
		
		this.idliv = idliv;
	}

    public Livraison(int idliv, String adressel, Double prixp, int idc) {
        this.idliv = idliv;
        this.adressel = adressel;
        this.prixp = prixp;
        this.idc = idc;
    }

    public Livraison(String adressel, Double prixp, int idc) {
        this.adressel = adressel;
        this.prixp = prixp;
        this.idc = idc;
    }
       public Livraison(String adressel, Double prixp, int idc,String validation) {
        this.adressel = adressel;
        this.prixp = prixp;
        this.idc = idc;
        this.validation=validation;
    }

    public Livraison() {
    }

    public Livraison(String idc, String adressel, String prixp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Livraison(String idc, String adressel, Double prixp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Livraison(String adressel, Double prixp, String idc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Livraison(String i, String adressel, Double prixp, int idc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public Livraison(String nomj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Livraison(int idliv, String adressel, Double prixp, int idc, String validation) {
        this.idliv = idliv;
        this.adressel = adressel;
        this.prixp = prixp;
        this.idc = idc;
        this.validation = validation;
    }

    

    public String getValidation() {
        return validation;
    }

    public void setValidation(String Validation) {
        this.validation = Validation;
    }

   

    public int getIdliv() {
        return idliv;
    }

    public String getAdressel() {
        return adressel;
    }

    public Double getPrixp() {
        return prixp;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdliv(int idliv) {
        this.idliv = idliv;
    }

    public void setAdressel(String adressel) {
        this.adressel = adressel;
    }

    public void setPrixp(Double prixp) {
        this.prixp = prixp;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    @Override
    public String toString() {
        return "Livraison{" + "idliv=" + idliv + ", adressel=" + adressel + ", prixp=" + prixp + ", idc=" + idc + ", Validation=" + validation + '}';
    }

   
	

	
	

}
