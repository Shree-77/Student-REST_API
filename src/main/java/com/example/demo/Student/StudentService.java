package com.example.demo.Student;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;




@Service
public interface StudentService extends CrudRepository<Student , Long> {

}
