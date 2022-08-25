package com.lab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	    @Id 
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    @Column
	    private String email;
	     @Column
	    private String password;
	     
	    @Enumerated(EnumType.STRING)
	    private Role role;
	 
	     
	    public User(String email, String password, Role role) {
	        this.email = email;
	        this.password = password;
	        this.role = role;
	    }
}

