package lk.ijse.dep.web.institute.api;

import lk.ijse.dep.web.institute.business.custom.StudentBO;
import lk.ijse.dep.web.institute.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-19
 **/

@RequestMapping("/api/v1/students")
@CrossOrigin
@RestController
public class StudentController {

    @Autowired
    private StudentBO studentBO;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getAllStudents() throws Exception {
        return studentBO.findAllStudents();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO getStudent(@PathVariable Integer id) throws Exception{
        return studentBO.findStudent(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer saveStudent(@RequestBody StudentDTO studentDTO)throws Exception{
        studentBO.saveStudent(studentDTO);
        return studentDTO.getId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable Integer id) throws Exception{
        studentBO.deleteStudent(id);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody StudentDTO studentDTO) throws Exception{
        studentBO.updateStudent(studentDTO);
    }
}
