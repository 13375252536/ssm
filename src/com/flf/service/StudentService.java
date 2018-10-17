package com.flf.service;

import com.flf.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StudentService
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/8/22 15:48
 * @Version: 1.0
 */

public interface StudentService {

    String insertStudent(Student student);

    List<Student> selectStudent(Student student);

    String update(Student student);

    void deleteStudent(Integer id);

    List<String> selectGender();

    List<String> selectGrade();

    String selectStudentBySno(String sno);

    String selectStudentByIdNum(String idNum);

    List<Map<String,Object>> selectStudentById(Integer id);

    Map<String,String> uploadFile(MultipartFile file, HttpServletRequest req);

    void deletePortrait(Integer id);

    String getPortrait(Integer id);
}
