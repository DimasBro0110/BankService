package ru.dimas.brosalin.Models;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by DmitriyBrosalin on 08/10/2016.
 */

@Entity
@Table(name = "USER")
public class User implements Serializable{

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId = 0L;

    @Column(name = "FIRST_NAME")
    private String userFirstName;

    @Column(name = "LAST_NAME")
    private String userLastName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "AGE")
    private int age;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy="user"
    )
    private Account account;

    public User(){}

    public User(int i, String name, String lastname,
                String pass, int age, String gender,
                String mail)
    {

        this.userId = i;
        this.userFirstName = name;
        this.userLastName = lastname;
        this.password = pass;
        this.age = age;
        this.gender = gender;
        this.email = mail;

    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(int iserId) {
        this.userId = iserId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){

        return "FirstName:" + getUserFirstName()
                + "\nLastName:" + getUserLastName()
                + "\nAge:" + getAge()
                + "\nGender:" + getGender()
                + "\nEmail:" + getEmail()
                + "\nPassword:" + getPassword();

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public JsonObject toJson(){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("USER_ID", this.getUserId());
        jsonObject.addProperty("FirstName", this.getUserFirstName());
        jsonObject.addProperty("LastName", this.getUserLastName());
        jsonObject.addProperty("Gender", this.getGender());
        jsonObject.addProperty("Age", this.getAge());
        jsonObject.addProperty("Email", this.getEmail());
        return jsonObject;

    }
}
