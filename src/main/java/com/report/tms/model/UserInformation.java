package com.report.tms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "User_data")
public class UserInformation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        @NotEmpty
        @Column(name = "Firstname")
        public String firstname;

        @NotEmpty
        @Column(name = "SecondName")
        public String SecondName;

        @NotEmpty
        @Column(name = "username")
        public String username;

        @NotEmpty
        @Column(name = "Department")
        public String department;

        @NotEmpty
        @Column(name="Role")
        public String role;

        @NotEmpty
        @Column(name = "Password")
        public String password;

        @NotEmpty
        @Email
        public String email;

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setSecondName(String secondName) {
            SecondName = secondName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getUsername() {
            return username;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getSecondName() {
            return SecondName;
        }

        public String getDepartment() {
            return department;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }

        public String getRole() {
            return role;
        }
}
