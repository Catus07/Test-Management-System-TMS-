package com.report.tms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;


@Entity
@Table(name = "uploaded_form")
@Data
public class Sub_Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotEmpty
    @Column(name = "Title")
    public String title;

    @NotEmpty
    @Column(name = "Test_type")
    public String test_type;

    @NotEmpty
    @Column(name = "FileType")
    public String filetype;

    @NotEmpty
    @Column(name = "Test_category")
    public String test_category;

    @Column(name = "Submission_Date")
    public LocalDateTime upload_date;

    @Lob
    @Column(name = "file", columnDefinition = "LONGBLOB")
    public byte[] fileSize;

    @NotEmpty
    @Column(name = "role")
    public String role;

    @NotEmpty
    @Column(name="uploader_name")
    public String uploader_name;

    @Email
    @Column(name = "email")
    public String email;

}