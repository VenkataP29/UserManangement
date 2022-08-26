package com.lab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
	
	public Staff(String name, String email, String password, int age) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String name;
	private String email;
	private String password;
	private int age;
}
