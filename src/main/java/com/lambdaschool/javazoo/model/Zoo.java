package com.lambdaschool.javazoo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.lambdaschool.javazoo.view.View;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
public class Zoo
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long zooid;

	@Column(unique = true)
	@JsonView(View.AnimalsOnly.class)
	private String zooname;

	@OneToMany(mappedBy = "zoo",
			   cascade = CascadeType.ALL,
			   orphanRemoval = true,
			   fetch = FetchType.LAZY)
	@JsonIgnoreProperties("zoo")
	private List<Telephone> telephones = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "zooanimal",
			   joinColumns = {@JoinColumn(name = "zooid")},
			   inverseJoinColumns = {@JoinColumn(name = "animalid")})
	@JsonIgnoreProperties("zoos")
	private List<Animal> animals = new ArrayList<>();

	public Zoo()
	{
	}

	public Zoo(String zooname, List<Telephone> telephones, List<Animal> animals)
	{
		this.zooname = zooname;
		this.telephones = telephones;
		this.animals = animals;
	}

	public long getZooid()
	{
		return zooid;
	}

	public void setZooid(long zooid)
	{
		this.zooid = zooid;
	}

	public String getZooname()
	{
		return zooname;
	}

	public void setZooname(String zooname)
	{
		this.zooname = zooname;
	}

	public List<Telephone> getTelephones()
	{
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones)
	{
		this.telephones = telephones;
	}

	public List<Animal> getAnimals()
	{
		return animals;
	}

	public void setAnimals(List<Animal> animals)
	{
		this.animals = animals;
	}
}
