package com.report.tms.service;

import com.report.tms.model.Sub_Form;
import com.report.tms.model.UserInformation;
import com.report.tms.repo.FileRepo;
import com.report.tms.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class UploadFileService {
    @Autowired
    public FileRepo fileRepo;

    @Autowired
    public UserInfoRepo userInfoRepo;

    //pass -- file uploaded successful
    public Sub_Form store(MultipartFile file) throws IOException{

        LocalDateTime today = LocalDateTime.now();
        Sub_Form subForm = new Sub_Form();
        subForm.setTest_type("web");
        subForm.setFileSize(file.getBytes()); //size of file
        subForm.setTest_category("functional"); //test category
        subForm.setFiletype(file.getContentType()); //file type img,doc
        subForm.setTitle(file.getOriginalFilename()); //title of the file
        subForm.setUpload_date(today); //date of uploaded file4

        //It gets the currently logged-in username from the Spring Security context
        //Then retrieves the full user info (UserInformation) from the database using that username
        Optional<UserInformation> currentUser = getCurrentUser();
        currentUser.ifPresent(user -> subForm.setRole(user.getRole()));
        currentUser.ifPresent(user -> subForm.setUploader_name(user.getUsername()));
        currentUser.ifPresent(user -> subForm.setEmail(user.getEmail()));


        return fileRepo.save(subForm);

    }

    //Fetches the currently logged-in user from the database.
    public Optional<UserInformation> getCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userInfoRepo.findByUsername(username);
    }

    public Optional<Sub_Form> getFileId(Long id){
        return fileRepo.findById(id);
    }
}
