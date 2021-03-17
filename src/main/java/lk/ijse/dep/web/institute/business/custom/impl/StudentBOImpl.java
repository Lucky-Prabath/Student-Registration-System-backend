package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.StudentBO;
import lk.ijse.dep.web.institute.business.util.DEPTransaction;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.custom.StudentDAO;
import lk.ijse.dep.web.institute.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Component
public class StudentBOImpl implements StudentBO {

    @Autowired
    private StudentDAO studentDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public StudentBOImpl() {
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        studentDAO.setEntityManager(em);
    }

    @Override
    public EntityManager getEntityManger() {
        return this.em;
    }

    @DEPTransaction
    @Override
    public void saveStudent(StudentDTO dto) throws Exception {
            studentDAO.save(mapper.getStudent(dto));
    }

    @DEPTransaction
    @Override
    public void updateStudent(StudentDTO dto) throws Exception {
            studentDAO.update(mapper.getStudent(dto));
    }

    @DEPTransaction
    @Override
    public void deleteStudent(Integer studentId) throws Exception {
            studentDAO.delete(studentId);
    }

    @DEPTransaction
    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
            List<StudentDTO> studentDTOS = mapper.getStudentDTOs(studentDAO.getAll());
            return studentDTOS;
    }

    @DEPTransaction
    @Override
    public StudentDTO getStudent(Integer studentId) throws Exception {
            StudentDTO studentDTO = mapper.getStudentDTO(studentDAO.get(studentId));
            return studentDTO;
    }
}
