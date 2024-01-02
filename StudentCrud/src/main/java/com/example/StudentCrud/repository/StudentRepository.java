package com.example.StudentCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentCrud.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {  // Student, bu repository'nin yöneteceği varlık (entity) tipini temsil eder. Yani, bu repository üzerinde öğrenci nesneleri ile çalışacaktır.
	//o nesne de id
}