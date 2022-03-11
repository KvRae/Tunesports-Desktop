/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;



/**
 *
 * @author achou
 */
public class Commande {
    private int idC;
    private String adresseC;
    private Date dateC;
    private String statusC;
   private int idP;
    //private int idMen;
    //private Produit produit;
    

   /* public Commande(int idC, String adresseC, Date dateC, String statusC, Produit produit) {
        this.idC = idC;
        this.adresseC = adresseC;
        this.dateC = dateC;
        this.statusC = statusC;
        this.produit = produit;
    }*/

   /* public Commande(String adresseC, Date dateC, String statusC, Produit produit) {
        this.adresseC = adresseC;
        this.dateC = dateC;
        this.statusC = statusC;
        this.produit = produit;
    }*/
    

    public Commande() {
    }

    public Commande(int idC, String adresseC, Date dateC,String statusC) {
        this.idC = idC;
        this.adresseC = adresseC;
        this.dateC = dateC;
        this.statusC = statusC;
    }

    public Commande(int idC, String adresseC, Date dateC, String statusC, int idP) {
        this.idC = idC;
        this.adresseC = adresseC;
        this.dateC = dateC;
        this.statusC = statusC;
        this.idP = idP;
        //this.idMen = idMen;
    }
     public Commande( String adresseC, Date dateC, String statusC, int idP) {
       
        this.adresseC = adresseC;
        this.dateC = dateC;
        this.statusC = statusC;
        this.idP = idP;
        //this.idMen = idMen;
    }
       
        public Commande( String adresseC,Date dateC,String statusC) {
        this.adresseC = adresseC;
        this.dateC = dateC;
        this.statusC = statusC;
                

    }
         public Commande(int id) {
        this.idC = id;
         }

    public Commande(String adresseC,  String statusC, int idP) {
       this.adresseC = adresseC;
        this.statusC = statusC;
        this.idP=idP;
    }

    /*public Commande(String adresseC, String statusC, Produit produit) {
        this.adresseC = adresseC;
        this.statusC = statusC;
        this.produit = produit;
    }*/
         

   

  
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

    public Date getDateC() {
        return dateC;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

   

    public String getStatusC() {
        return statusC;
    }

    public void setStatusC(String statusC) {
        this.statusC = statusC;
    }

    /*public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }*/

   /* public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }*/

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }
    
    

   /* public int getIdMen() {
        return idMen;
    }

    public void setIdMen(int idMen) {
        this.idMen = idMen;
    }
*/
   @Override
    public String toString() {
        return "Commande{" + "idC=" + idC + ", adresseC=" + adresseC + ", dateC=" + dateC + ", statusC=" + statusC + ", idP=" + idP + '}';
    }

   /* @Override
    public String toString() {
        return "Commande{" + "idC=" + idC + ", adresseC=" + adresseC + ", dateC=" + dateC + ", statusC=" + statusC + ", produit=" + produit + '}';
    }*/

   

    
    

    }

    
   
    
    

