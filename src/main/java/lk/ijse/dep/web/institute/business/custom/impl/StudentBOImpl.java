package lk.ijse.dep.web.institute.business.custom.impl;

import lk.ijse.dep.web.institute.business.custom.StudentBO;
import lk.ijse.dep.web.institute.business.util.EntityDTOMapper;
import lk.ijse.dep.web.institute.dao.custom.StudentDAO;
import lk.ijse.dep.web.institute.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Service
@Transactional
public class StudentBOImpl implements StudentBO {

    private final EntityDTOMapper mapper = EntityDTOMapper.instance;
    @Autowired
    private StudentDAO studentDAO;

    public StudentBOImpl() {
    }

    @Override
    public void saveStudent(StudentDTO dto) throws Exception {
        studentDAO.save(mapper.getStudent(dto));
    }

    @Override
    public void updateStudent(StudentDTO dto) throws Exception {
        studentDAO.update(mapper.getStudent(dto));
    }

    @Override
    public void deleteStudent(Integer studentId) throws Exception {
        studentDAO.delete(studentId);
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        List<StudentDTO> studentDTOS = mapper.getStudentDTOs(studentDAO.getAll());
        return studentDTOS;
    }

    @Override
    public StudentDTO getStudent(Integer studentId) throws Exception {
        StudentDTO studentDTO = mapper.getStudentDTO(studentDAO.get(studentId));
        return studentDTO;
    }
}
