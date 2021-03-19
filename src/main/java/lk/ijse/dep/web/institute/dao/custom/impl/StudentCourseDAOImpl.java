package lk.ijse.dep.web.institute.dao.custom.impl;

import lk.ijse.dep.web.institute.dao.CrudDAOImpl;
import lk.ijse.dep.web.institute.dao.custom.StudentCourseDAO;
import lk.ijse.dep.web.institute.entity.StudentCourse;
import org.springframework.stereotype.Repository;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-03
 **/

@Repository
public class StudentCourseDAOImpl extends CrudDAOImpl<StudentCourse, String> implements StudentCourseDAO {

}
