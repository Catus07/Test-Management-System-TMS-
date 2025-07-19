package com.report.tms.repo;

import com.report.tms.model.Sub_Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<Sub_Form, Long> {

}
