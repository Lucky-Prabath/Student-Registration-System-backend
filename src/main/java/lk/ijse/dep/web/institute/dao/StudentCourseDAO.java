package lk.ijse.dep.web.institute.dao;

import lk.ijse.dep.web.institute.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-03
 **/
public interface StudentCourseDAO extends JpaRepository<StudentCourse, String> {
}
