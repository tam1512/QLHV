/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class OnsiteCourse_DTO {
    
    private String courseID;
    private String location;
    private String schedule;

    public OnsiteCourse_DTO() {
    }

    public OnsiteCourse_DTO(String courseID, String location, String schedule) {
        this.courseID = courseID;
        this.location = location;
        this.schedule = schedule;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    
}
