package entities;

import java.sql.Date;

public class Mise_a_jour {

  int idmise;
  String nomjeu;
  Date pubmise;
  String versionmise;
  int taillemise;
  String descmise;
  // Jeux  jeux;
  String nomjeux;
  int idjeux;

  public Mise_a_jour(Date pubmise, String versionmise, int taillemise,
                     String descmise, int idjeux) {
    this.pubmise = pubmise;
    this.versionmise = versionmise;
    this.taillemise = taillemise;
    this.descmise = descmise;
    this.idjeux = idjeux;
  }

  public Mise_a_jour(String nomjeu, Date pubmise, String versionmise,
                     int taillemise, String descmise, int idjeux) {

    this.nomjeu = nomjeu;
    this.pubmise = pubmise;
    this.versionmise = versionmise;
    this.taillemise = taillemise;
    this.descmise = descmise;
    this.idjeux = idjeux;
  }

  public Mise_a_jour(int idmise, String nomjeu, Date pubmise,
                     String versionmise, int taillemise, String descmise,
                     int idjeux) {
    this.idmise = idmise;
    this.nomjeu = nomjeu;
    this.pubmise = pubmise;
    this.versionmise = versionmise;
    this.taillemise = taillemise;
    this.descmise = descmise;
    this.idjeux = idjeux;
  }

  public Mise_a_jour(int idmise) { this.idmise = idmise; }

  public Mise_a_jour(int idjeux, String nomjeu, Date pubmise,
                     String versionmise, int taillemise, String descmise) {
    this.idjeux = idjeux;
    this.nomjeux = nomjeu;
    this.pubmise = pubmise;
    this.versionmise = versionmise;
    this.taillemise = taillemise;
    this.descmise = descmise;
  }

  public Mise_a_jour(int idJ, int idmise, String nomj, Date pubmise,
                     String versionmise, int taillemise, String descmise) {}

  public Mise_a_jour() {
    // TODO Auto-generated constructor stub
  }

  public int getidjeux() { return idjeux; }

  public void setidjeux(int idjeux) { this.idjeux = idjeux; }

  public int getIdmise() { return idmise; }

  public void setIdmise(int idmise) { this.idmise = idmise; }

  public String getNomjeu() { return nomjeu; }

  public void setNomjeu(String nomjeu) { this.nomjeu = nomjeu; }

  public Date getPubmise() { return pubmise; }

  public void setPubmise(Date pubmise) { this.pubmise = pubmise; }

  public String getVersionmise() { return versionmise; }

  public void setVersionmise(String versionmise) {
    this.versionmise = versionmise;
  }

  public int getTaillemise() { return taillemise; }

  public void setTaillemise(int taillemise) { this.taillemise = taillemise; }

  public String getDescmise() { return descmise; }

  public void setDescmise(String descmise) { this.descmise = descmise; }

  // public int getidjeux() {
  //	return jeux.getIdjeux();
  // }
  //
  // public void setidjeux(int idjeux) {
  //	this.jeux.idjeux = jeux.getIdjeux();
  // }

  //
  @Override
  public String toString() {
    return "Mise_a_jour [idmise=" + idmise + ", nomjeu=" + nomjeu +
        ", pubmise=" + pubmise + ", versionmise=" + versionmise +
        ", taillemise=" + taillemise + ", descmise=" + descmise +
        ", idjeux=" + idjeux + "]";
  }

  //@Override
  // public String toString() {
  // return "Mise_a_jour [nomjeux=" + nomjeux + ", pubmise=" + pubmise + ",
  // versionmise="
  //+ versionmise + ", taillemise=" + taillemise + ", descmise=" + descmise + ",
  //idjeux=" + idjeux +"]";
  //}
}
