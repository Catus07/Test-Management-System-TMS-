package com.report.tms.repo;

import com.report.tms.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserInfoRepo extends JpaRepository<UserInformation, Long> {
     Optional<UserInformation>findByUsername(String username);
     List<UserInformation> findByRole(String role);
}
