package com.example.studentmanagement.model;

import java.io.Serializable;

public class ContactModel implements Serializable {

    public ContactModel(int mId, String mName, String mBirthday, String mPhone, String mCode, String mAddress){
        this.Id       = mId;
        this.Name     = mName;
        this.Birthday = mBirthday;
        this.Phone    = mPhone;
        this.Code     = mCode;
        this.Address  = mAddress;
    }

    private int Id;
    private String Name;
    private String Birthday;
    private String Phone;
    private String Code;
    private String Address;

    public int getId() {
        return Id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
