package Entities;

import java.util.Date;
import java.util.List;

public class Coach extends Utilisateur{
    private String nickname;
    private Jeux specialite;
    private String rank ;
    private List<Rating> listRat;
    private List<Reservation> listRes;
    private double prixUnit;

    public Coach(String nickname, Jeux specialite, String rank, List<Rating> listRat, List<Reservation> listRes, double prixUnit) {
        this.nickname = nickname;
        this.specialite = specialite;
        this.rank = rank;
        this.listRat = listRat;
        this.listRes = listRes;
        this.prixUnit = prixUnit;
    }

    public Coach() {
    }

    public Coach(int id, int tel, String nom, String prenom, String email, String mdp, String role, Date date, String nickname, Jeux specialite, String rank, List<Rating> listRat, List<Reservation> listRes, double prixUnit) {
        super(id, tel, nom, prenom, email, mdp, role, date);
        this.nickname = nickname;
        this.specialite = specialite;
        this.rank = rank;
        this.listRat = listRat;
        this.listRes = listRes;
        this.prixUnit = prixUnit;
    }

    public Coach(int id, String nickname, Jeux specialite, String rank, List<Rating> listRat, List<Reservation> listRes, double prixUnit) {
        super(id);
        this.nickname = nickname;
        this.specialite = specialite;
        this.rank = rank;
        this.listRat = listRat;
        this.listRes = listRes;
        this.prixUnit = prixUnit;
    }

    public Coach(String nom, String prenom, String nickname, Jeux specialite, String rank, List<Rating> listRat, List<Reservation> listRes, double prixUnit) {
        super(nom, prenom);
        this.nickname = nickname;
        this.specialite= specialite;
        this.rank = rank;
        this.listRat = listRat;
        this.listRes = listRes;
        this.prixUnit = prixUnit;
    }

    public Coach(String nickname) {
        this.nickname = nickname;
    }
    public Coach(int id)
    {super(id);}

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Jeux getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Jeux specialite) {
        this.specialite = specialite;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<Rating> getListRat() {
        return listRat;
    }

    public void setListRat(List<Rating> listRat) {
        this.listRat = listRat;
    }

    public List<Reservation> getListRes() {
        return listRes;
    }

    public void setListRes(List<Reservation> listRes) {
        this.listRes = listRes;
    }

    public double getPrixUnit() {
        return prixUnit;
    }

    public void setPrixUnit(double prixUnit) {
        this.prixUnit = prixUnit;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "nickname='" + nickname + '\'' +
                ", specialite=" + specialite +
                ", rank='" + rank + '\'' +
                ", listRat=" + listRat +
                ", listRes=" + listRes +
                ", prixUnit=" + prixUnit +
                '}';
    }


}
