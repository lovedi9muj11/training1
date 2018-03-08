/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.maximus.bean;

/**
 *
 * @author xxx
 */
public class Major {
    private Integer id;
    private String name;
    private String description;
    private Integer facultyID;
    private String facultyLabel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Integer facultyID) {
        this.facultyID = facultyID;
    }

    public String getFacultyLabel() {
        return facultyLabel;
    }

    public void setFacultyLabel(String facultyLabel) {
        this.facultyLabel = facultyLabel;
    }
    
}
