package lk.ijse.dep.web.institute.api;

import lk.ijse.dep.web.institute.exception.ResponseExceptionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-07
 **/
@WebServlet(name = "StudentCourseServlet", urlPatterns = "/api/v1/register/*")
public class StudentCourseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo:complete method for register to course
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo:complete method for edit the registrations
    }


}
