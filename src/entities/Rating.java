package entities;

public class Rating {
    private int idRat ;
    private String titleRat ;
    private String descRat ;
    private int valueRat ;

    public Rating() {
    }

    public Rating(String titleRat, String descRat, int valueRat) {
        this.titleRat = titleRat;
        this.descRat = descRat;
        this.valueRat = valueRat;
    }

    public int getIdRat() {
        return idRat;
    }

    public void setIdRat(int idRat) {
        this.idRat = idRat;
    }

    public String getTitle() {
        return titleRat;
    }

    public void setTitle(String titleRat) {
        this.titleRat = titleRat;
    }

    public String getDescRat() {
        return descRat;
    }

    public void setDescRat(String descRat) {
        this.descRat = descRat;
    }

    public int getValue() {return valueRat;}

    public void setValue(int valueRat) {this.valueRat =valueRat;}


    @Override
    public String toString() {
        return "RatingService{" +
                "idRat='" + idRat + '\'' +
                ", titleRat='" + titleRat + '\'' +
                ", DescRat='" + descRat + '\'' +
                ", valueRat='" + valueRat + '\'' +
                '}';
    }
}
