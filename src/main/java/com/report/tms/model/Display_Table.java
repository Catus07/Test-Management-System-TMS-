package com.report.tms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name = "view_table")
public class Display_Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotEmpty
    @Column(name = "Test_type")
    public String test_type;

    @NotEmpty
    @Column(name = "Title")
    public String title;

    @NotEmpty
    @Column(name = "Test_category")
    public String test_category;

    @NotEmpty
    @Column(name = "Date")
    public Date date;

    @NotEmpty
    @Column(name = "Status")
    public String status;

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public void setTest_category(String test_category) {
        this.test_category = test_category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTest_type() {
        return test_type;
    }

    public String getTest_category() {
        return test_category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

}
