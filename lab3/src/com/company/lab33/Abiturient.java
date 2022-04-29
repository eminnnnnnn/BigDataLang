package com.company.lab33;

import java.util.Arrays;

public class Abiturient {

    private int id;
    private String fName;
    private String lName;
    private String pName;
    private String address;
    private String phone;
    private int[] marks;

    public Abiturient() {
        id = -1;
        fName = new String("");
        lName = new String("");
        pName = new String("");
        address = new String("");
        phone = new String("");
        marks = new int[0];
    }

    public Abiturient(int id, String lName, String fName, String pName, String address, String phone, int[] marks) {
        this.id = id;
        this.fName = new String(fName);
        this.lName = new String(lName);
        this.pName = new String(pName);
        this.address = new String(address);
        this.phone = new String(phone);
        this.marks = Arrays.copyOf(marks, marks.length);
    }

    @Override
    public String toString() {
        StringBuilder abiturient = new StringBuilder(String.format(
            "ID: %d\nФИО: %s %s %s\nАдрес: %s\nТелефон: %s\nОценки: ",
            id, lName, fName, pName, address, phone
        ));
        for (int mark : marks) {
            abiturient.append(mark + " ");
        }
        abiturient.append("\n");
        return abiturient.toString();
    }

    public int getId() { return id; }
    public String getFName() { return fName; }
    public String getLName() { return lName; }
    public String getPName() { return pName; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public int[] getMarks() { return marks; }

    public void setId(int id) { this.id = id; }
    public void setFName(String fName) { this.fName = new String(fName); }
    public void setLName(String lName) { this.lName = new String(lName); }
    public void setPName(String pName) { this.pName = new String(pName); }
    public void setAddress(String address) { this.address = new String(address); }
    public void setPhone(String phone) { this.phone = new String(phone); }
    public void setMarks(int[] marks) { this.marks = Arrays.copyOf(marks, marks.length); }

}