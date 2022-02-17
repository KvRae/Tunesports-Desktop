/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author achou
 */
public class Produit {
    

    private int idP;
    private String nomP;
    private int prixP;
    private String descP;
    private String dispoP;
    private String couleurP;
   

    public Produit() {
    }

    public Produit(int idP, String nomP, int prixP,String descP,String dispoP,String couleurP) {
        this.idP = idP;
        this.nomP = nomP;
        this.prixP = prixP;
        this.descP = descP;
        this.dispoP = dispoP;
        this.couleurP = couleurP;

    }
    
     public Produit( String nomP, int prixP,String descP,String dispoP,String couleurP) {
        
        this.nomP = nomP;
        this.prixP = prixP;
        this.descP = descP;
        this.dispoP = dispoP;
        this.couleurP = couleurP;

    }
     public Produit(int idP) {
        this.idP = idP;}

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

    public int getPrixP() {
        return prixP;
    }

    public void setPrixP(int prixP) {
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

    @Override
    public String toString() {
        return "Produit{" + "idP=" + idP + ", nomP=" + nomP + ", prixP=" + prixP + ", descP=" + descP + ", dispoP=" + dispoP + ", couleurP=" + couleurP + '}';
    }

   

    

   
    }

    

    
    

    
    
    

  
    
    
   
    

