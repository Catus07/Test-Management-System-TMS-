package com.report.tms.controller;

import com.report.tms.dto.RegistrationFormDto;
import com.report.tms.model.Sub_Form;
import com.report.tms.model.UserInformation;
import com.report.tms.repo.FileRepo;
import com.report.tms.service.AdminService;
import com.report.tms.service.DevService;
import com.report.tms.service.TesterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin")
@Tag(name="Admin APIs",description = "add,delete,update")
public class AdminController {
    @Autowired
    public AdminService adminService;

    @Autowired
    public FileController fileController;

    @Autowired
    public DevService devService;

    @Autowired
    public TesterService testerService;

    @Autowired
    public FileRepo fileRepo;

    @GetMapping("/home")
    public String name(){
        return "login successful -- /home";
    }

    @PostMapping("/registration") // pass ---- user registration
    public UserInformation regMethod(@RequestBody RegistrationFormDto reg){
        return adminService.registrationMethod(reg);
    }

    @DeleteMapping("/delete/{id}") //pass ---- user deletion
    public void deletionMethod(@PathVariable Long id) {
        adminService.deleteMethod(id);
    }

    @GetMapping("/users") // pass ---- get all users
    public List<UserInformation> getAllUser(){
        return adminService.allUser();
    }

    @GetMapping("/users/tester") // pass --- get all tester
    public List<UserInformation> getTester(UserInformation userInformation) {
     return adminService.userInfoRepo.findByRole("ROLE_TESTER");
    }

    @GetMapping("/users/developers") // pass --- get all developers
    public List<UserInformation> getDevelop(UserInformation userInformation) {
        return adminService.userInfoRepo.findByRole("ROLE_DEVELOPER");
    }

    @GetMapping ("/users/{id}") // pass --- get users by id
    public Optional<UserInformation> getUserById(@PathVariable Long id){
        return adminService.userId(id);
        // need to captured for no-existing id
    }


        /**
         * put mapping
         */

    @GetMapping("/download/{id}") //download submitted file
    public ResponseEntity<?> adminDownloadFile(Long id){
        return fileController.downloadFile(id);
    }


    @GetMapping("/report/dev") //getting only tester report
    public List<Sub_Form> getTesterRepo() {
            return fileRepo.findAll();
    }

    @GetMapping("/report/tester") // getting only developer Report
    public List<Sub_Form> getOnlyDevReport(){
        try {
                return devService.getTesterReport();
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }


}


