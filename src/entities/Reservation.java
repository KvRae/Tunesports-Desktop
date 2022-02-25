package entities;

public class Reservation {
    private int idRes ;
    private String dateRes;
    private String heureRes;
    private String dispoRes;
    private double prixRes ;

    public Reservation() {
    }

    public Reservation( String dateRes, String heureRes, String dispoRes, double prixRes) {
        this.dateRes = dateRes;
        this.heureRes = heureRes;
        this.dispoRes = dispoRes;
        this.prixRes = prixRes;
    }

    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    public String getDateRes() {
        return dateRes;
    }

    public void setDateRes(String dateRes) {
        this.dateRes = dateRes;
    }

    public String getHeureRes() {
        return heureRes;
    }

    public void setHeureRes(String heureRes) {
        this.heureRes = heureRes;
    }

    public String getDispoRes() {
        return dispoRes;
    }

    public void setDispoRes(String dispoRes) {
        this.dispoRes = dispoRes;
    }

    public double getPrixRes() {
        return prixRes;
    }

    public void setPrixRes(double prixRes) {
        this.prixRes = prixRes;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "idRes=" + idRes +
                ", dateRes='" + dateRes + '\'' +
                ", heureRes=" + heureRes +
                ", dispoRes=" + dispoRes +
                ", prixRes=" + prixRes +
                '}';
    }
}
