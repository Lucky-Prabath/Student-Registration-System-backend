package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.StudentCourseBO;
import lk.ijse.dep.web.institute.business.util.DEPTransaction;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.custom.StudentCourseDAO;
import lk.ijse.dep.web.institute.dto.StudentCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-03
 **/

@Component
public class StudentCourseBOImpl implements StudentCourseBO {

    private EntityManager em;
    @Autowired
    private StudentCourseDAO studentCourseDAO;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public StudentCourseBOImpl() {
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        studentCourseDAO.setEntityManager(em);
    }

    @Override
    public EntityManager getEntityManger() {
        return this.em;
    }

    @DEPTransaction
    @Override
    public void register(StudentCourseDTO dto) throws Exception{
            studentCourseDAO.save(mapper.getStudentCourse(dto));
            em.getTransaction().commit();
    }

    //todo:- check whole class
}
