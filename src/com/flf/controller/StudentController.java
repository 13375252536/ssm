package com.flf.controller;

import com.flf.entity.Student;
import com.flf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StudentController
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/8/22 15:57
 * @Version: 1.0
 */
@Controller
@RequestMapping(value="/student",produces = "text/html;charset=utf-8")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询学生信息 学生界面
     * @Date 2018/8/23 12:37
     * @Param [student]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping
    public ModelAndView list(Student student){
        List<Student> selectStudent = studentService.selectStudent(student);
        List<String> genderList = studentService.selectGender();
        List<String> gradeList = studentService.selectGrade();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student");
        mv.addObject("selectStudent",selectStudent);
        mv.addObject("genderList",genderList);
        mv.addObject("gradeList",gradeList);
        mv.addObject("student",student);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   插入学生信息
     * @Date 2018/8/22 19:40
     * @Param [student]
     * @return void
     */
    @RequestMapping(value = "/insertStudent",produces = "text/html;charset=utf-8")
    public ModelAndView insertStudent(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   插入信息保存
     * @Date 2018/8/23 16:58
     * @Param [student]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/save",produces = "text/html;charset=utf-8")
    public ModelAndView saveStudent(@RequestParam(value="file",required=false)MultipartFile file, Student student, Map map,HttpServletRequest req){
        ModelAndView mv = new ModelAndView();
        map = studentService.uploadFile(file,req);
        if (file==null||file.isEmpty()){
           student.setPortrait(studentService.getPortrait(student.getId()));
        }else {
            student.setPortrait("/image/"+map.get("fileUrl"));
        }
        if (studentService.selectStudentById(student.getId()).isEmpty()){
            mv.addObject("msg",studentService.insertStudent(student));
        }else {
            mv.addObject("msg",studentService.update(student));
        }
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * @Author Mr.Chan
     * @Description //TODO   修改学生信息
     * @Date 2018/8/23 12:35
     * @Param [id]
     * @return void
     */
    @RequestMapping(value = "/updateStudent",produces = "text/html;charset=utf-8")
    public ModelAndView updateStudent(@RequestParam("id") int id,Student student){
        List<Map<String, Object>> mapList = studentService.selectStudentById(id);
        student.setId((Integer)mapList.get(0).get("id"));
        student.setSno((String)mapList.get(0).get("sno"));
        student.setAge((Integer) mapList.get(0).get("age"));
        student.setGrade((String) mapList.get(0).get("grade"));
        student.setIdNum((String) mapList.get(0).get("idNum"));
        student.setGender((String) mapList.get(0).get("gender"));
        student.setName((String) mapList.get(0).get("name"));
        student.setPortrait((String) mapList.get(0).get("portrait"));
        ModelAndView mv = new ModelAndView();
        mv.addObject("student",student);
        mv.setViewName("student_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   删除学生信息  通过学生数据库的主键序号
     * @Date 2018/8/22 16:13
     * @Param [stuId, out]  stuId:学生数据库的主键序号
     * @return void
     */
    @RequestMapping(value="/deleteStudent",produces = "text/html;charset=utf-8")
    public void deleteStudent(@RequestParam("id") Integer id, PrintWriter out){
        studentService.deleteStudent(id);
        out.write("success");
        out.close();
    }

    @RequestMapping(value = "/deletePortrait",produces = "text/html;charset=utf-8")
    public void deletePortrait(@RequestParam("id") Integer id,PrintWriter out){
        studentService.deletePortrait(id);
        out.write("success");
        out.close();
    }

}
