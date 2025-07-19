package com.report.tms.service;

import com.report.tms.controller.DevController;
import com.report.tms.controller.FileController;
import com.report.tms.model.Sub_Form;
import com.report.tms.model.UserInformation;
import com.report.tms.repo.FileRepo;
import com.report.tms.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TesterService {
    @Autowired
    public UserInfoRepo userInfoRepo;

    @Autowired
    public DevController devController;

    @Autowired
    public UploadFileService uploadFileService;

    @Autowired
    public FileRepo fileRepo;

    @Autowired
    public FileController fileController;

    // pass --- get all tester uploaded report
    public List<Sub_Form> getUploadedReport(){
        try {
            return fileRepo.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //download submitted report
    public ResponseEntity<?> download(Long id){
        return fileController.downloadFile(id);
    }



    // -get only tester report by taking role variable
    public List<Sub_Form> getTesterReport() throws Exception{
        Sub_Form user =new Sub_Form();
        List<UserInformation> role =userInfoRepo.findByRole(user.getRole());
        return fileRepo.findAll();
    }

    // -get only test-case report from developer
    public List<UserInformation> getDevReport() throws Exception{
        UserInformation user =new UserInformation();
        List<UserInformation> role =userInfoRepo.findByRole(user.getRole());
        return userInfoRepo.findByRole(String.valueOf(role));
    }

//    // -uploaded test-case by admin
//    public ResponseEntity<?> upLoadedTestCase(MultipartFile file){
//
//        return devController.uploadFileDev(file);
//    }
}

