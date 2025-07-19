package com.report.tms.service;

import com.report.tms.model.UserInformation;
import com.report.tms.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TmsUserDetailsService implements UserDetailsService {
    @Autowired
    public UserInfoRepo userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInformation userInformation =userInfoRepo.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("username not found"));
        return new TmsUserDetails(userInformation);
    }

}
