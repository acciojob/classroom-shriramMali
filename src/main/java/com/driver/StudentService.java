package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
@Autowired
StudentRepository studentRepository;

  public void addTeacher( Teacher teacher){
  studentRepository.saveTeacher(teacher);
  }
   public void addStudent(Student student){
    studentRepository.saveStudent(student);
  }

  public void createStudentTeacherPair(String student,String teacher){
   studentRepository.saveTeacherStudentMapping(student,teacher);
  }
    public Student findStudent( String currStudent){
    return studentRepository.findStudent(currStudent);
  }

    public Teacher findTeacher( String currTeacher){
        return studentRepository.findTeacher(currTeacher);
  }
    public List<String> findTeacherbyStudent(String teacher){
        return studentRepository.findteacherStudent(teacher);
    }

    public List<String> findAllStudents(){
        return studentRepository.findallStudent();
    }
    public void deleteTeacher(String teacher){
        studentRepository.deleteAllStudentByTeacher(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllStudentAndteacher();
    }


}
