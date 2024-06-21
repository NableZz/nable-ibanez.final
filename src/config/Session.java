
package config;

import java.util.Date;


public class Session {
    private static Session instance;
    private int id;
    private String fullname;
    private String contactNumber;    
    private String gender;
    private String address;
    private String password;
    private String status;
    
    private Session(){
        //private contructors to prevent instance
    }

    public static synchronized Session getInstance() {
        if(instance == null){
            instance = new Session();
        }
        return instance;
    }

    public static boolean isIntanceEmpty() {
        return instance == null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}


