package com.report.tms.controller;

import com.report.tms.model.Sub_Form;
import com.report.tms.model.UserInformation;
import com.report.tms.service.TesterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/tester")
@Tag(name = "Tester APIs", description = "upload,download,update")
public class TesterController {
    @Autowired
    public FileController fileController;

    @Autowired
    public TesterService testerService;

    @GetMapping("/home")
    public String home(){
        return "tester home";
    }


    // -- pass fetch all tester uploaded report
    @GetMapping("/report")
    public List<Sub_Form> myReport(){
        return testerService.getUploadedReport();
    }
    // -- pass fetch all tester report
    @GetMapping("/testerReport")
    public List<Sub_Form> onlyTester(){
        try {
            return testerService.getTesterReport();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // 2.pass tester download report by id
    @GetMapping("/Download/{id}")
    @PreAuthorize("hasRole('TESTER')")
    public ResponseEntity<?> testerDownload(@PathVariable Long id){
        return fileController.downloadFile(id);
    }


}
