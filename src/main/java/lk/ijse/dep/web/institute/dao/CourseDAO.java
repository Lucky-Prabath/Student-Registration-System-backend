package lk.ijse.dep.web.institute.dao;

import lk.ijse.dep.web.institute.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/
public interface CourseDAO extends JpaRepository<Course, String> {
}
