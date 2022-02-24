/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Date;
public class Evenement {
  private int id_event;
  private String nomevent;
  private Date datedebevent;
  private Date datefinevent;
  private String descevent;
  // private String utilisateur;

  public Evenement() {}

  public Evenement(int id_event, String nomevent, Date datedebevent,
                   Date datefinevent, String descevent) {
    this.id_event = id_event;
    this.nomevent = nomevent;
    this.datedebevent = datedebevent;
    this.datefinevent = datefinevent;
    this.descevent = descevent;
  }

  public Evenement(int id_event) { this.id_event = id_event; }

  public Evenement(int id_event, String nomevent, String descevent) {
    this.id_event = id_event;
    this.nomevent = nomevent;
    this.descevent = descevent;
  }

  public Evenement(Date datedebevent) { this.datedebevent = datedebevent; }

  public int getId_event() { return id_event; }

  public String getNomevent() { return nomevent; }

  public Date getDatedebevent() { return datedebevent; }

  public Date getDatefinevent() { return datefinevent; }

  public String getDescevent() { return descevent; }

  public void setId_event(int id_event) { this.id_event = id_event; }

  public void setNomevent(String nomevent) { this.nomevent = nomevent; }

  public void setDatedebevent(Date datedebevent) {
    this.datedebevent = datedebevent;
  }

  public void setDatefinevent(Date datefinevent) {
    this.datefinevent = datefinevent;
  }

  public void setDescevent(String descevent) { this.descevent = descevent; }
  @Override
  public String toString() {
    return "Evenement{"
        + "id_event=" + id_event + ", nomevent=" + nomevent +
        ", datedebevent=" + datedebevent + ", datefinevent=" + datefinevent +
        ", descevent=" + descevent + '}';
  }
}
