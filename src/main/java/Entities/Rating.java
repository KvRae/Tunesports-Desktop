/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Entities;

import java.util.Date;

public class Rating {

    private int idRat ;
    private String titleRat ;
    private Date dateRat ;
    private int valueRat ;


    //****************************************************Constructors*********************************

    public Rating() {
    }

    public Rating(String titleRat, Date dateRat, int valueRat) {
        this.titleRat = titleRat;
        this.dateRat = dateRat;
        this.valueRat = valueRat;
    }

    public Rating(int idRat, String titleRat, Date dateRat, int valueRat) {
        this.idRat = idRat;
        this.titleRat = titleRat;
        this.dateRat = dateRat;
        this.valueRat = valueRat;
    }

    public Rating(int idRat) {
        this.idRat = idRat;
    }

    //***********************************************Getters&Setters**********************************************

    public int getIdRat() {
        return idRat;
    }

    public void setIdRat(int idRat) {
        this.idRat = idRat;
    }

    public String getTitleRat() {
        return titleRat;
    }

    public void setTitleRat(String titleRat) {
        this.titleRat = titleRat;
    }

    public Date getDateRat() {
        return dateRat;
    }

    public void setDateRat(Date dateRat) {
        this.dateRat = dateRat;
    }

    public int getValueRat() {return valueRat;}

    public void setValueRat(int valueRat) {this.valueRat =valueRat;}

//***********************************************ToString = Display**********************************************

    @Override
    public String toString() {
        return "RatingService{" +
                "idRat='" + idRat + '\'' +
                ", titleRat='" + titleRat + '\'' +
                ", dateRat='" + dateRat + '\'' +
                ", valueRat='" + valueRat + '\'' +
                '}';
    }
}
