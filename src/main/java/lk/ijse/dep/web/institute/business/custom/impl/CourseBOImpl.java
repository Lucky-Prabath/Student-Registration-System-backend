package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.CourseBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.custom.CourseDAO;
import lk.ijse.dep.web.institute.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Service
@Transactional
public class CourseBOImpl implements CourseBO {

    private final EntityDTOMapper mapper = EntityDTOMapper.instance;
    @Autowired
    private CourseDAO courseDAO;

    public CourseBOImpl() {
    }


    @Override
    public void saveCourse(CourseDTO dto) throws Exception {
        courseDAO.save(mapper.getCourse(dto));
    }

    @Override
    public void updateCourse(CourseDTO dto) throws Exception {
        courseDAO.update(mapper.getCourse(dto));
    }

    @Override
    public void deleteCourse(String courseId) throws Exception {
        courseDAO.delete(courseId);
    }

    @Override
    public List<CourseDTO> findAllCourses() throws Exception {
        List<CourseDTO> courseDTOS = mapper.getCourseDTOs(courseDAO.getAll());
        return courseDTOS;
    }

    @Override
    public CourseDTO findCourse(String code) throws Exception {
        return mapper.getCourseDTO(courseDAO.get(code));
    }
}
