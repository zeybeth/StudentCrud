package com.example.StudentCrud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //sınıfın bir veritabanı tablosuna karşılık geleceği ve JPA tarafından yönetileceği anlamına gelir.
public class Student {

	@Id//@Id annotasyonu, id alanının bu sınıfın birincil anahtarı (primary key) olduğunu belirtir.
    @GeneratedValue(strategy= GenerationType.IDENTITY) //id alanının otomatik olarak artan bir şekilde (identity) oluşturulacağını belirtir.
    private Long id;
    private String studentname;
    private String course;
    private int fee;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Long id, String studentname, String course, int fee) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.course = course;
		this.fee = fee;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
}
