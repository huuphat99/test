package com.example.sample1.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 @Column(name = "username")
	 private String username;
	 @Column(name = "password")
	 private String password;
	 @Column(name = "address")
	 private String address;
	 @Column(name = "email")
	 private String email;
}


