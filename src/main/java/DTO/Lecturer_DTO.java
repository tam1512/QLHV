/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Lecturer_DTO {
    
    private String lectID;
    private String lastName;
    private String stName;
    private Date hiringDate;

    public Lecturer_DTO() {
    }

    public Lecturer_DTO(String lectID, String lastName, String stName, Date hiringDate) {
        this.lectID = lectID;
        this.lastName = lastName;
        this.stName = stName;
        this.hiringDate = hiringDate;
    }

    public String getLectID() {
        return lectID;
    }

    public void setLectID(String lectID) {
        this.lectID = lectID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }
    
}
