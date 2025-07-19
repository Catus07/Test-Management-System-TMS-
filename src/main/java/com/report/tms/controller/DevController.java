package com.report.tms.controller;

import com.report.tms.model.Sub_Form;
import com.report.tms.model.UserInformation;
import com.report.tms.repo.FileRepo;
import com.report.tms.service.DevService;
import com.report.tms.service.UploadFileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/developer")
@Tag(name="Developers APIs", description="upload,get,status")
public class DevController {
    @Autowired
    public FileController fileController;

    @Autowired
    public FileRepo fileRepo;

    @Autowired
    public DevService devService;

    @Autowired
    public UploadFileService uploadFileService;

    @GetMapping("/home")
    public String home(){
        return "log-in successful  -- developer ";
    }

    //1.pass -- file download developer able to download test report
    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadAllUser(@PathVariable Long id){
        return fileController.downloadFile(id);
    }

    // pass --- file upload developer
    @PostMapping("/upload")
    public Sub_Form uploadFileDev(MultipartFile file){
        try {
            return uploadFileService.store(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 3.pass  ----- able to see all tester and dev submitted report
    @GetMapping("/tester/report")
    public List<Sub_Form> getOnlyTesterReport(){
        try {
            return devService.getTesterReport();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
