package com.luxiany.dao;

import com.luxiany.domain.Student;

import java.util.List;

public interface StudentDao {
   int insertStudent(Student student);
   List<Student> selectStudent();

}
