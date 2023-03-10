package com.driver;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;


    public StudentRepository(){

        super();
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

   public void saveStudent(Student student){
        studentMap.put(student.getName(),student);
   }
    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }

    public void saveTeacherStudentMapping(String student,String teacher) {

       if(teacherMap.containsKey(teacher) && studentMap.containsKey(student) ){
           List<String> current=new ArrayList<>();

           if(teacherStudentMapping.containsKey(teacher))
           current=teacherStudentMapping.get(teacher);

           current.add(student);

           teacherStudentMapping.put(teacher,current);
       }

    }

   public Student findStudent(String student){
        Student student1=null;
        if(studentMap.containsKey(student)){
            return studentMap.get(student);
        }
   return student1;
   }

    public Teacher findTeacher(String teacher){
        Teacher teacher1=null;
        if(teacherMap.containsKey(teacher)){
            return teacherMap.get(teacher);
        }

        return teacher1;
    }
  public List<String> findteacherStudent(String teacher){
  List<String> allStudent=new ArrayList<>();

  if(teacherStudentMapping.containsKey(teacher)) allStudent=teacherStudentMapping.get(teacher);

  return allStudent;
  }

  public List<String> findallStudent(){
   return new ArrayList<>(studentMap.keySet());
  }

 public void deleteAllStudentByTeacher( String teacher){
 List<String> students=new ArrayList<>();
 if(teacherStudentMapping.containsKey(teacher)){
     students=teacherStudentMapping.get(teacher);

     for(String s:students){
         if(studentMap.containsKey(s)){
             studentMap.remove(s);
            }
        }
    teacherStudentMapping.remove(teacher);
 }
if (teacherMap.containsKey(teacher)) teacherMap.remove(teacher);

 }

 public void deleteAllStudentAndteacher(){
     HashSet<String> studentsSet = new HashSet<String>();
     teacherMap=new HashMap<>();

     for(String teacher :teacherStudentMapping.keySet()){

         for(String stud :teacherStudentMapping.get(teacher)){
             studentsSet.add(stud);
         }

     }
    for (String student :studentsSet){
        if (studentMap.containsKey(student)){
            studentMap.remove(student);
        }
    }
 teacherStudentMapping =new HashMap<>();
    }

}
