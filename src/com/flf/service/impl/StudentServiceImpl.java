package com.flf.service.impl;

import com.flf.entity.Student;
import com.flf.mapper.StudentMapper;
import com.flf.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: StudentServiceImpl
 * @Description: //TODO  service层实现类
 * @Author: Mr.Chan
 * @Data: 2018/8/22 15:52
 * @Version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }


    @Override
    public String insertStudent(Student student) {
        if (selectStudentBySno(student.getSno()).equals("1")){
            return "snoExist";
        }else if (selectStudentByIdNum(student.getIdNum()).equals("1")){
            return "idNumExist";
        }else {
            studentMapper.insertStudent(student);
            return "success";
        }
    }

    @Override
    public String update(Student student) {
        if (student.getSno().equals(selectStudentById(student.getId()).get(0).get("sno")) && student.getIdNum().equals(selectStudentById(student.getId()).get(0).get("idNum"))) {
//           if ()
            studentMapper.updateStudent(student);
            return "success";
        }
        if (!student.getSno().equals(selectStudentById(student.getId()).get(0).get("sno")) && !student.getIdNum().equals(selectStudentById(student.getId()).get(0).get("idNum"))) {
            if (selectStudentBySno(student.getSno()).equals("0")) {
                if (selectStudentByIdNum(student.getIdNum()).equals("0")) {
                    studentMapper.updateStudent(student);
                    return "success";
                } else {
                    return "idNumExist";
                }
            } else {
                return "snoExist";
            }
        }
        if (student.getSno().equals(selectStudentById(student.getId()).get(0).get("sno")) && !student.getIdNum().equals(selectStudentById(student.getId()).get(0).get("idNum"))) {
            if (selectStudentByIdNum(student.getIdNum()).equals("0")) {
                studentMapper.updateStudent(student);
                return "success";
            } else {
                return "idNumExist";
            }
        }
        if (!student.getSno().equals(selectStudentById(student.getId()).get(0).get("sno")) && student.getIdNum().equals(selectStudentById(student.getId()).get(0).get("idNum"))) {
            if (selectStudentBySno(student.getSno()).equals("0")) {
                studentMapper.updateStudent(student);
                return "success";
            } else {
                return "snoExist";
            }
        }
        return "";
    }

    @Override
    public List<Student> selectStudent(Student student) {
        List<Student> studentList = studentMapper.listPageStudent(student);
        return studentList;
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
    }


    @Override
    public List<String> selectGender() {
        List<String> genderList = studentMapper.selectGender();
        return genderList;
    }

    @Override
    public List<String> selectGrade() {
        List<String> gradeList = studentMapper.selectGrade();
        return gradeList;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO
     * @Date 2018/8/23 12:31
     * @Param [sno]
     * @return java.lang.String  0 代表存在学生信息,1  代表不存在学生信息
     */
    @Override
    public String selectStudentBySno(String sno) {
        List<Map<String,Object>> mapList = studentMapper.selectStudentBySno(sno);
        if (mapList.isEmpty()){
            return "0";
        }
        return "1";
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO
     * @Date 2018/8/23 12:30
     * @Param [idNum]
     * @return java.lang.String  0 代表存在学生信息,1  代表不存在学生信息
     */
    @Override
    public String selectStudentByIdNum(String idNum) {
        List<Map<String,Object>> mapList = studentMapper.selectStudentByIdNum(idNum);
        if (mapList.isEmpty()){
            return "0";
        }
        return "1";
    }

    @Override
    public List<Map<String, Object>> selectStudentById(Integer id) {
        List<Map<String, Object>> mapList = studentMapper.selectStudentById(id);
        return mapList;
    }
    @Override
   public Map<String,String> uploadFile(MultipartFile file, HttpServletRequest req) {
        String path = "D:\\Subversion\\ssm\\WebRoot\\studentPortrait\\image";
        String fileName = file.getOriginalFilename();
        fileName = UUID.randomUUID() + "_" + fileName;
        File newFile = new File(path, fileName);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,String> map = new HashMap<String,String>();
        map.put("fileUrl",fileName);
        return map;
    }

    @Override
    public void deletePortrait(Integer id) {
        studentMapper.deletePortrait(id);
    }

    @Override
    public String getPortrait(Integer id) {
        String path = studentMapper.getPortrait(id);
        return path;
    }
}
