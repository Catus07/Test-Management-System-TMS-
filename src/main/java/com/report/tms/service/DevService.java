package com.report.tms.service;

import com.report.tms.model.Sub_Form;
import com.report.tms.model.UserInformation;
import com.report.tms.repo.FileRepo;
import com.report.tms.repo.UserInfoRepo;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevService {
    @Autowired
    public UserInfoRepo userInfoRepo;

    @Autowired
    public UploadFileService uploadFileService;

    @Autowired
    public FileRepo fileRepo;


    //get only tester report by taking role variable
    public List<Sub_Form> getTesterReport() throws Exception{
        return fileRepo.findAll() ;
    }
}
