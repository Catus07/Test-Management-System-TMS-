package com.report.tms.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UploadForm {
    public Long id;
    public String title;
    public String test_type;
    public String filetype;
    public String test_category;
    public Date uploade_date;
    public byte[] fileSize;
}
