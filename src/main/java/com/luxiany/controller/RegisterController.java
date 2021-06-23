package com.luxiany.controller;

import com.luxiany.domain.Student;
import com.luxiany.service.StudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
       // String config = "applicationContext.xml";
        //StudentService ss  = (StudentService) new ClassPathXmlApplicationContext(config).getBean("studentService");

       /* String key  = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        Object attr = this.getServletContext().getAttribute(key);
        if (attr!=null){
            ctx = (WebApplicationContext) attr;
        }*/

       //使用框架中的一个方法获取容器对象
        WebApplicationContext ctx  = null;
        ServletContext sc = this.getServletContext();
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        StudentService ss  = (StudentService) ctx.getBean("studentService");
        Student student = new Student(Integer.valueOf(id),name,email,Integer.valueOf(age));
        int count = ss.addStudent(student);
       if (count==1){
           response.sendRedirect("success.jsp");
       }else{

       }

    }
}
