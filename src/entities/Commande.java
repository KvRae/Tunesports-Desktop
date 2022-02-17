/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author achou
 */
public class Commande {
    private int idC;
    private String adresseC;
    private String dateC;
    private String statusC;
    

    public Commande() {
    }

    public Commande(int id, String adresse, String date,String status) {
        this.idC = id;
        this.adresseC = adresse;
        this.dateC = date;
        this.statusC = status;
    }
       
        public Commande( String adresse, String date,String status) {
        this.adresseC = adresse;
        this.dateC = date;
        this.statusC = status;
                

    }
         public Commande(int id) {
        this.idC = id;
         }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getAdresseC() {
        return adresseC;
    }

    public void setAdresseC(String adresseC) {
        this.adresseC = adresseC;
    }

    public String getDateC() {
        return dateC;
    }

    public void setDateC(String dateC) {
        this.dateC = dateC;
    }

    public String getStatusC() {
        return statusC;
    }

    public void setStatusC(String statusC) {
        this.statusC = statusC;
    }

    @Override
    public String toString() {
        return "Commande{" + "idC=" + idC + ", adresseC=" + adresseC + ", dateC=" + dateC + ", statusC=" + statusC + '}';
    }

    }

    
   
    
    

