/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;
import java.util.logging.Logger;


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

    

   

    

   
    }

    

    
    

    
    
    

  
    
    
   
    

