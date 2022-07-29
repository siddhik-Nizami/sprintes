/**
 * 
 */
package com.website.App.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 10698333
 *
 */

@Entity
@Table(name="Employee")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="isActive")
	private boolean isActive;
	
}
