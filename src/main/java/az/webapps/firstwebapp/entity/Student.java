//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.webapps.firstwebapp.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private String surname;
    private int ID;
    private String email;
    private String phone;


    public Student( int ID, String name, String surname,  String phone, String email) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public Student() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        String var10001 = name.substring(0, 1).toUpperCase();
        this.name = var10001 + name.substring(1);
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        String var10001 = surname.substring(0, 1).toUpperCase();
        this.surname = var10001 + surname.substring(1);
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        Scanner sc = new Scanner(System.in);

        for(String regexPattern = "^(.+)@(.+)$"; !Pattern.compile(regexPattern).matcher(email).matches(); email = sc.nextLine()) {
            System.out.println("Invalid input. Please enter the real email: ");
        }

        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        Scanner sc = new Scanner(System.in);

        for(String regexPattern = "[0-9]+"; !Pattern.compile(regexPattern).matcher(phone).matches(); phone = sc.nextLine()) {
            System.out.println("Invalid input. Please enter the real phone number: ");
        }

        this.phone = phone;
    }

    public String toString() {
        return "Student {  ID = '" + this.ID + "' Name = '" + this.name + "', Surname = '" + this.surname + "', Email = '" + this.email + "', Phone = '" + this.phone + "'}";
    }
}
