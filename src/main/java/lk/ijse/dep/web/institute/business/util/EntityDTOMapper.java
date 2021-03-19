package lk.ijse.dep.web.institute.business.util;

import lk.ijse.dep.web.institute.dto.CourseDTO;
import lk.ijse.dep.web.institute.dto.StudentCourseDTO;
import lk.ijse.dep.web.institute.dto.StudentDTO;
import lk.ijse.dep.web.institute.entity.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-02
 **/
@Mapper(componentModel = "spring")
public abstract class EntityDTOMapper {

//    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    @Mapping(source = ".", target = "address")
    @Mapping(source = ".", target = "dob", qualifiedByName = "dob")
    public abstract Student getStudent(StudentDTO dto);

    @InheritInverseConfiguration
    @Mapping(source = ".", target = "no", qualifiedByName = "no")
    @Mapping(source = ".", target = "addressLine1", qualifiedByName = "addressLine1")
    @Mapping(source = ".", target = "addressLine2", qualifiedByName = "addressLine2")
    @Mapping(source = ".", target = "city", qualifiedByName = "city")
    public abstract StudentDTO getStudentDTO(Student student);

    public abstract Course getCourse(CourseDTO dto);

    public abstract CourseDTO getCourseDTO(Course course);

    public abstract List<CourseDTO> getCourseDTOs(List<Course> course);

    public abstract List<StudentDTO> getStudentDTOs(List<Student> student);

    @Mapping(source = ".", target = "studentCoursePK")
    @Mapping(source = ".", target = "registerDate", qualifiedByName = "registerDate")
    public abstract StudentCourse getStudentCourse(StudentCourseDTO dto);

    @InheritInverseConfiguration
    @Mapping(source = ".", target = "studentId", qualifiedByName = "studentId")
    @Mapping(source = ".", target = "courseCode", qualifiedByName = "courseCode")
    public abstract StudentCourseDTO getStudentCourseDTO(StudentCourse studentCourse);

    /*methods for get student from dto*/
    public Address getAddress(StudentDTO dto){
        return new Address(dto.getNo(), dto.getAddressLine1(), dto.getAddressLine2(), dto.getCity());
    }

    @Named("dob")
    public Date toDate(StudentDTO dto){
        return Date.valueOf(dto.getDob());
    }

    /*get dto from student*/
    @Named("no")
    public String getNo(Student student){ return student.getAddress().getNo(); }

    @Named("addressLine1")
    public String getAddressLine1(Student student){ return student.getAddress().getAddressLine1(); }

    @Named("addressLine2")
    public String getAddressLine2(Student student){ return student.getAddress().getAddressLine2(); }

    @Named("city")
    public String getCity(Student student){ return student.getAddress().getCity(); }


    /*method for get StudentCourse*/

    public StudentCoursePK getStudentCoursePK(StudentCourseDTO dto){
        return new StudentCoursePK(dto.getStudentId(), dto.getCourseCode());
    }

    @Named("registerDate")
    public Date toDate(StudentCourseDTO dto){
        return Date.valueOf(dto.getRegisterDate());
    }

    /*methods for get StudentCourseDTOs*/

    @Named("studentId")
    public int getStudentId(StudentCourse studentCourse){
        return studentCourse.getStudentCoursePK().getStudentId();
    }

    @Named("courseCode")
    public String getCourseCode(StudentCourse studentCourse){
        return studentCourse.getStudentCoursePK().getCourseCode();
    }
}
