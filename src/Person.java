package src;

import java.util.Date;

public class Person {
    private long ID;
    private String name;
    private String address;
    private Date birthDay;
    private long  numberPhone;
    private String sex;

    public Person() {
    }

    public Person(long ID, String name, String address, Date birthDay, long numberPhone, String sex) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.numberPhone = numberPhone;
        this.sex = sex;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(long numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
