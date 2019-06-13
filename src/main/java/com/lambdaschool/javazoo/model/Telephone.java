package com.lambdaschool.javazoo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephone")
public class Telephone
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long phoneid;

	private String phonetype;
	private String phonenumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zooid")
	@JsonIgnoreProperties("telephones")
	private Zoo zoo;

	public Telephone()
	{
	}

	public Telephone(String phonetype, String phonenumber)
	{
		this.phonetype = phonetype;
		this.phonenumber = phonenumber;
	}

	public long getPhoneid()
	{
		return phoneid;
	}

	public void setPhoneid(long phoneid)
	{
		this.phoneid = phoneid;
	}

	public String getPhonetype()
	{
		return phonetype;
	}

	public void setPhonetype(String phonetype)
	{
		this.phonetype = phonetype;
	}

	public String getPhonenumber()
	{
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber)
	{
		this.phonenumber = phonenumber;
	}

	public Zoo getZoo()
	{
		return zoo;
	}

	public void setZoo(Zoo zoo)
	{
		this.zoo = zoo;
	}
}
