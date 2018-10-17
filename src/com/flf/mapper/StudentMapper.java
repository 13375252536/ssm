package com.flf.mapper;

import com.flf.entity.Student;

import java.util.List;
import java.util.Map;

    /**
     * @ClassName: StudentService
     * @Description: //TODO
     * @Author: Mr.Chan
     * @Data: 2018/8/22 15:30
     * @Version: 1.0
     */
    public interface StudentMapper {


     /**
     * @Author Mr.Chan
     * @Description //TODO   通过Student对象插入学生数据
     * @Date 2018/8/22 16:35
     * @Param [student]
     * @return void
     */
    void insertStudent(Student student);
    /**
     * @Author Mr.Chan
     * @Description //TODO   通过学生数据库的主键序号修改学生信息
     * @Date 2018/8/22 17:13
     * @Param [id]  学生数据库的主键序号
     * @return void
     */
    void updateStudent(Student student);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询学生信息
     * @Date 2018/8/22 19:13
     * @Param [student]
     * @return java.util.List<com.flf.entity.Student>
     */
    List<Student> listPageStudent(Student student);


    /**
     * @Author Mr.Chan
     * @Description //TODO   通过学生数据库的主键序号删除学生信息
     * @Date 2018/8/22 15:42
     * @Param [id]  学生数据库的主键序号
     * @return void
     */
    void deleteStudent(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询性别种类
     * @Date 2018/8/23 12:18
     * @Param []
     * @return java.util.List<java.lang.String>
     */
    List<String> selectGender();
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询班级种类
     * @Date 2018/8/23 12:18
     * @Param []
     * @return java.util.List<java.lang.String>
     */
    List<String> selectGrade();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询学生信息  通过学号
     * @Date 2018/8/23 12:20
     * @Param [sno]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> selectStudentBySno(String sno);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询学生信息  通过身份证号
     * @Date 2018/8/23 12:20
     * @Param [idNum]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> selectStudentByIdNum(String idNum);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询学生信息  通过id  数据库主键
     * @Date 2018/8/23 17:13
     * @Param [id]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> selectStudentById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除此人照片 通过id
     * @Date 2018/8/24 16:04
     * @Param [id]
     * @return void
     */
    void deletePortrait(Integer id);

    /**
     * @Author Mr.Chan
     * @Description //TODO 通过id得到某人portrait
     * @Date 2018/8/27 15:22
     * @Param [id]
     * @return java.lang.String
     */
    String getPortrait(Integer id);
}
