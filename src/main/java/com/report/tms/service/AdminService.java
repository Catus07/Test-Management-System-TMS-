package com.report.tms.service;

import com.report.tms.dto.RegistrationFormDto;
import com.report.tms.model.Sub_Form;
import com.report.tms.model.UserInformation;
import com.report.tms.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    public UserInfoRepo userInfoRepo;

    @Autowired
    public PasswordEncoder passwordEncoder;

    //pass ------   register user, tester, admin
    public UserInformation registrationMethod(RegistrationFormDto dto){
        UserInformation user =new UserInformation();
        user.setUsername(dto.getUsername());
        user.setDepartment(dto.getDepartment());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setFirstname(dto.getFirstname());
        user.setSecondName(dto.getSecondName());
        user.setId(dto.getId());

        String encodedPassword =passwordEncoder.encode(dto.getPassword());
        user.setPassword(encodedPassword);
        return userInfoRepo.save(user);
    }

    // pass  -------  delete registered user by id
    public void deleteMethod(Long id) {
        userInfoRepo.deleteById(id);
    }

    //pass -------- get all users
    public List<UserInformation> allUser() {
        return userInfoRepo.findAll();
    }

    // pass -------- get all user based on role
    public List<UserInformation> getUserByRole(UserInformation userInformation){
        return userInfoRepo.findByRole(userInformation.getRole());
    }

    //get user by id
    public Optional<UserInformation> userId(Long id){
        return userInfoRepo.findById(id);

    }
    // get upload tester report
   }





