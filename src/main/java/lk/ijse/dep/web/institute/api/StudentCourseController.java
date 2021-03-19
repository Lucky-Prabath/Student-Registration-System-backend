package lk.ijse.dep.web.institute.api;

import lk.ijse.dep.web.institute.business.custom.StudentCourseBO;
import lk.ijse.dep.web.institute.dto.StudentCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-19
 **/

@RequestMapping("/api/v1/register")
@CrossOrigin
@RestController
public class StudentCourseController {

    @Autowired
    private StudentCourseBO studentCourseBO;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody StudentCourseDTO dto) throws Exception {
        studentCourseBO.register(dto);
    }
}
