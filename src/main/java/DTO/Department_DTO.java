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
public class Department_DTO {
    
    private String dpmID;
    private String name;
    private Date publishDate;
    private String administrator;

    public Department_DTO() {
    }

    public Department_DTO(String dpmID, String name, Date publishDate, String administrator) {
        this.dpmID = dpmID;
        this.name = name;
        this.publishDate = publishDate;
        this.administrator = administrator;
    }

    public String getDpmID() {
        return dpmID;
    }

    public void setDpmID(String dpmID) {
        this.dpmID = dpmID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }
    
    
    
}
