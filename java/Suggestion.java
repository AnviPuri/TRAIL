package com.anvipuri.trail;



public class Suggestion {

    private int id;
    private String city;
    private String place1;
    private String place2;
    private String place3;
    private String place4;
    private String place5;
    private String place6;
    private String place7;
    private String place8;
    private String place9;
    private String place10;

    public Suggestion() {
    }

    public Suggestion(int id, String city, String place1, String place2, String place3, String place4, String place5, String place6, String place7, String place8, String place9, String place10) {
        this.id = id;
        this.city=city;
        this.place1 = place1;
        this.place2 = place2;
        this.place3 = place3;
        this.place4 = place4;
        this.place5 = place5;
        this.place6 = place6;
        this.place7 = place7;
        this.place8 = place8;
        this.place9 = place9;
        this.place10 = place10;
    }

    public Suggestion(String city, String place1, String place2, String place3, String place4, String place5, String place6, String place7, String place8, String place9, String place10) {
        this.city=city;
        this.place1 = place1;
        this.place2 = place2;
        this.place3 = place3;
        this.place4 = place4;
        this.place5 = place5;
        this.place6 = place6;
        this.place7 = place7;
        this.place8 = place8;
        this.place9 = place9;
        this.place10 = place10;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public String getPlace3() {
        return place3;
    }

    public void setPlace3(String place3) {
        this.place3 = place3;
    }

    public String getPlace4() {
        return place4;
    }

    public void setPlace4(String place4) {
        this.place4 = place4;
    }

    public String getPlace5() {
        return place5;
    }

    public void setPlace5(String place5) {
        this.place5 = place5;
    }

    public String getPlace6() {
        return place6;
    }

    public void setPlace6(String place6) {
        this.place6 = place6;
    }

    public String getPlace7() {
        return place7;
    }

    public void setPlace7(String place7) {
        this.place7 = place7;
    }

    public String getPlace8() {
        return place8;
    }

    public void setPlace8(String place8) {
        this.place8 = place8;
    }

    public String getPlace9() {
        return place9;
    }

    public void setPlace9(String place9) {
        this.place9 = place9;
    }

    public String getPlace10() {
        return place10;
    }

    public void setPlace10(String place10) {
        this.place10 = place10;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}


