package com.lab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String email;
	private String password;
}
