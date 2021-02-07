package com.inpg.paytm.gRPC.entities;

import javax.persistence.*;

@Entity
//this is the entitymodule class
@Table(name="userdata")
public class UserEntity {

    private Integer userid;
    private String userName;
    private String firstName;
    private String lastName;
    private Integer mobileNumber;
    private String emailid;
    private String address1;
    private String address2;

    //using super class constructor

    public UserEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    //mapping of entity variables
    public UserEntity(Integer userid, String userName, String firstName, String lastName, Integer mobileNumber, String emailid,
                      String address1, String address2) {
        super();
        this.userid = userid;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailid = emailid;
        this.address1 = address1;
        this.address2 = address2;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //methods for the entity attributes
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

}

