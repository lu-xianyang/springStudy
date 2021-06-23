package com.luxiany.service.impl;

import com.luxiany.dao.StudentDao;
import com.luxiany.domain.Student;
import com.luxiany.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
   private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
      int count = studentDao.insertStudent(student);
        return count;
    }

    @Override
    public List<Student> selectStudent() {
        List<Student> list = studentDao.selectStudent();
        return list;
    }
}
