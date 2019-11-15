package model;

import java.util.ArrayList;
import java.util.List;

public class ESoftwarica {

    private String name,address;
    private int age;
    // private int img;
    private String gender;
    static List<ESoftwarica> eSoftwaricaList1 = new ArrayList<>();

    public ESoftwarica(String name, String address, int age,  String gender) {
        this.name = name;
        this.address = address;
        this.age = age;
        // this.img=img;
        this.gender = gender;
    }

    public List<ESoftwarica> getStudentList() {
        return eSoftwaricaList1;
    }
    public void setStudentList(List<ESoftwarica> eSoftwaricaList) {
        this.eSoftwaricaList1 = eSoftwaricaList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
