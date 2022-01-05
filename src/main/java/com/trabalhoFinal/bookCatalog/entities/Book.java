package com.trabalhoFinal.bookCatalog.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String author;
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date startReading;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date endReading;
	
	@ManyToMany
	@JoinTable(name = "tb_book_user", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_book_genre", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private Set<Genre> genres = new HashSet<>();
	
	
	public Book() {
	}

	public Book(Long id, String name, String author, String description, Date startReading, Date endReading) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
		this.startReading = startReading;
		this.endReading = endReading;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartReading() {
		return startReading;
	}

	public void setStartReading(Date startReading) {
		this.startReading = startReading;
	}

	public Date getEndReading() {
		return endReading;
	}

	public void setEndReading(Date endReading) {
		this.endReading = endReading;
	}
	
	public Set<User> getUsers() {
		return users;
	}

	public Set<Genre> getGenre() {
		return genres;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
}
