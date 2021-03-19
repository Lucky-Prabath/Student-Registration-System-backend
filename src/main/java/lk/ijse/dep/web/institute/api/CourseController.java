package lk.ijse.dep.web.institute.api;

import lk.ijse.dep.web.institute.business.custom.CourseBO;
import lk.ijse.dep.web.institute.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-19
 **/

@RequestMapping("/api/v1/courses")
@CrossOrigin
@RestController
public class CourseController {

    @Autowired
    private CourseBO courseBO;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDTO> getAllCourses() throws Exception {
        return courseBO.findAllCourses();
    }

    @GetMapping(value = "/{code:C\\d{3}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseDTO getCourse(@PathVariable String code) throws Exception{
        return courseBO.findCourse(code);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveCourse(@RequestBody CourseDTO courseDTO)throws Exception{
        courseBO.saveCourse(courseDTO);
        return courseDTO.getCode();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{code:C\\d{3}}")
    public void deleteCourse(@PathVariable String code) throws Exception{
        courseBO.deleteCourse(code);
    }

    @PutMapping(value = "/{code:C\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCourse(@RequestBody CourseDTO courseDTO) throws Exception{
        courseBO.updateCourse(courseDTO);
    }
}
