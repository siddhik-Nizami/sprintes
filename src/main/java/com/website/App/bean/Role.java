/**
 * 
 */
package com.website.App.bean;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author 10698333 Role class contained the different Role in the Application
 *         Role class throw we can achive the authorization of the application
 */
@Entity
@Table(name = "role")
public class Role {
	/**
	 * @param name
	 */
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	 @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
	    private Collection<User> users;
	 public Collection<User> getUsers() {
	        return users;
	    }

	    public void setUsers(Collection<User> users) {
	        this.users = users;
	    }
	public Role() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", users=" + users + "]";
	}

	
	

}
