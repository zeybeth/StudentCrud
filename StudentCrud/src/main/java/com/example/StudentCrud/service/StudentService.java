package com.example.StudentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.repository.StudentRepository;

@Service //@Service annotasyonu, bu sınıfın bir Spring servisi olduğunu belirtir. Spring bu sınıfı bir servis olarak tanımlayarak, uygun bir şekilde yönetebilir ve diğer bileşenlere enjekte edebilir.
public class StudentService {
    
    @Autowired
    private StudentRepository repo;
    
    public List<Student> listAll() {
        return repo.findAll();
    }
     
    public void save(Student std) {
        repo.save(std);
    }
     
    public Student get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}