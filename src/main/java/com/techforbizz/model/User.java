package com.techforbizz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@NotNull
	@Column(name="firstname")
	private String firstname;
	
	@NotNull
	@Column(name="lastname")
	private String lastname;
	
	@NotNull
	@Column(name="emailid")
	private String emailid;
	
	@NotNull
	@Column(name="enabled")
	private boolean enabled;

	public long getId() { return id; }

	public void setId(long id) { this.id = id; }

	public String getFirstname() { return firstname; }

	public void setFirstname(String firstname) { this.firstname = firstname; }

	public String getLastname() { return lastname; }

	public void setLastname(String lastname) { this.lastname = lastname; }

	public String getEmailid() { return emailid; }

	public void setEmailid(String emailid) { this.emailid = emailid; }

	public boolean isEnabled() { return enabled; }

	public void setEnabled(boolean enabled) { this.enabled = enabled; }
	
}
