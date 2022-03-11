/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;
import java.util.logging.Logger;
import javafx.scene.control.TextField;


/**
 *
 * @author achou
 */
public class Produit {
    

    private int idP;
    private String nomP;
    private Double prixP;
    private String descP;
    private String dispoP;
    private String couleurP;
    private int quantiteP;
    private String tailleP;
    
   

    public Produit() {
    }

    public Produit(int idP, String nomP, Double prixP,String descP,String dispoP,String couleurP,int quantiteP,String tailleP) {
        this.idP = idP;
        this.nomP = nomP;
        this.prixP = prixP;
        this.descP = descP;
        this.dispoP = dispoP;
        this.couleurP = couleurP;
        this.quantiteP = quantiteP;
        this.tailleP = tailleP;


    }
    
     public Produit( String nomP, Double prixP,String descP,String dispoP,String couleurP,int quantiteP,String tailleP) {
        
        this.nomP = nomP;
        this.prixP = prixP;
        this.descP = descP;
        this.dispoP = dispoP;
        this.couleurP = couleurP;
        this.quantiteP = quantiteP;
        this.tailleP = tailleP;
    }
     public Produit(int idP) {
        this.idP = idP;}

    public Produit(String nomP, Double prixP, String descP, String dispoP, String couleurP, String quantiteP, String tailleP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produit(int aInt, String string, String string0, int aInt0, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produit(String nomP, String prixP, String descP, String dispoP, String couleurP, int quantiteP, String tailleP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produit(TextField nomP, TextField prixP, TextField descP, TextField dispoP, TextField couleurP, TextField quantiteP, TextField tailleP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produit(String nomP, Double prixP, String dispoP, String couleurP, int quantiteP, String tailleP) {
    
        this.nomP = nomP;
        this.prixP = prixP;
        this.dispoP = dispoP;
        this.couleurP = couleurP;
        this.quantiteP = quantiteP;
        this.tailleP = tailleP;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public Double getPrixP() {
        return prixP;
    }

    public void setPrixP(Double prixP) {
        this.prixP = prixP;
    }

    public String getDescP() {
        return descP;
    }

    public void setDescP(String descP) {
        this.descP = descP;
    }

    public String getDispoP() {
        return dispoP;
    }

    public void setDispoP(String dispoP) {
        this.dispoP = dispoP;
    }

    public String getCouleurP() {
        return couleurP;
    }

    public void setCouleurP(String couleurP) {
        this.couleurP = couleurP;
    }

    public int getQuantiteP() {
        return quantiteP;
    }

    public void setQuantiteP(int quantiteP) {
        this.quantiteP = quantiteP;
    }

    public String getTailleP() {
        return tailleP;
    }

    public void setTailleP(String tailleP) {
        this.tailleP = tailleP;
    }

    @Override
    public String toString() {
        return "Produit{" + "idP=" + idP + ", nomP=" + nomP + ", prixP=" + prixP + ", descP=" + descP + ", dispoP=" + dispoP + ", couleurP=" + couleurP + ", quantiteP=" + quantiteP + ", tailleP=" + tailleP + '}';
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idP;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.idP != other.idP) {
            return false;
        }
        return true;
    }

    

    

   

    

   
    }

    

    
    

    
    
    

  
    
    
   
    

