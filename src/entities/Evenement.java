/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Date;
public class Evenement {
    private int id_event ;
    private String nomevent;
    private String datedebevent;
    private String datefinevent;
    private String descevent;
    
    

    public Evenement() {
    }

    public Evenement(int id_event, String nomevent,String datedebevent,String datefinevent, String descevent) {
        this.id_event = id_event;
        this.nomevent=nomevent;
        this.datedebevent = datedebevent;
        this.datefinevent = datefinevent;
        this.descevent = descevent;
    }


    public int getId_event() {
        return id_event;
    }

    public String getNomevent() {
        return nomevent;
    }

    public String getDatedebevent() {
        return datedebevent;
    }

    public String getDatefinevent() {
        return datefinevent;
    }
    
    public String getDescevent() {
        return descevent;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setNomevent(String nomevent) {
        this.nomevent = nomevent;
    }

    public void setDatedebevent(String datedebevent) {
        this.datedebevent = datedebevent;
    }

    public void setDatefinevent(String datefinevent) {
        this.datefinevent = datefinevent;
    }

    public void setDescevent(String descevent) {
        this.descevent = descevent;
    }
    @Override
    public String toString() {
        return "Evenement{" + "id_event=" + id_event + ", nomevent=" + nomevent + ", datedebevent=" + datedebevent + ", datefinevent=" + datefinevent + ", descevent=" + descevent + '}';
    }
    
    
   
    
}
