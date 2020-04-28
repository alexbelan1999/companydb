import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pckg.*;

public class TeacherSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Teacher object = new Teacher();
        object.setName(req.getParameter("name"));
        object.setSurname(req.getParameter("surname"));
        object.setPatronomyc(req.getParameter("patronomyc"));
            String cathedra = req.getParameter("cathedraId");
            try {
                for(Cathedra p: Storage.readAllCathedras()){
                    if(cathedra.equals(p.getName())){
                        object.setCathedraId(p.getId());
                    }
                }
            }
            catch(SQLException e){}
        object.setPost(req.getParameter("post"));
        if(object.getPost().equals("manager")){
            object.setRate(1);
            object.setRight(true);
            object.setLectionHours(70);
            object.setPracticeHours(70);
            object.setLabsHours(70);
            object.setConsultHours(70);
            object.setExamHours(70);
            object.setCreditHours(70);
            object.setTestHours(70);
            object.setAudienceHours(70);
            object.setNonAudienceHours(70);
        }
        else if(object.getPost().equals("professor")){
            object.setLectionHours(100);
            object.setPracticeHours(130);
            object.setLabsHours(70);
            object.setConsultHours(70);
            object.setExamHours(70);
            object.setCreditHours(70);
            object.setTestHours(70);
            object.setAudienceHours(70);
            object.setNonAudienceHours(70);
            object.setRate(1);
            object.setRight(false);
        }
        else if(object.getPost().equals("docent")){
            object.setLectionHours(150);
            object.setPracticeHours(130);
            object.setLabsHours(70);
            object.setConsultHours(70);
            object.setExamHours(100);
            object.setCreditHours(70);
            object.setTestHours(70);
            object.setAudienceHours(70);
            object.setNonAudienceHours(70);
            object.setRate(1);
            object.setRight(false);
        }
        else if(object.getPost().equals("seniorTeacher")){
            object.setLectionHours(100);
            object.setPracticeHours(130);
            object.setLabsHours(100);
            object.setConsultHours(100);
            object.setExamHours(70);
            object.setCreditHours(100);
            object.setTestHours(100);
            object.setAudienceHours(100);
            object.setNonAudienceHours(70);
            object.setRate(1);
            object.setRight(false);
        }
        else if(object.getPost().equals("teacher")){
            object.setLectionHours(150);
            object.setPracticeHours(130);
            object.setLabsHours(100);
            object.setConsultHours(100);
            object.setExamHours(100);
            object.setCreditHours(100);
            object.setTestHours(100);
            object.setAudienceHours(150);
            object.setNonAudienceHours(100);
            object.setRate(1);
            object.setRight(false);
        }
        object.setTotalHours(object.getLectionHours() + object.getPracticeHours() + object.getLabsHours()
        + object.getConsultHours() + object.getExamHours() + object.getCreditHours() + object.getTestHours()
        + object.getAudienceHours() + object.getNonAudienceHours());

        try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        }
        catch(NumberFormatException e){
            object.setId(0);
        }

        try {
            if(Integer.valueOf(object.getId()) == 0) {
                Storage.createTeacher(object);
            } else {
                Storage.updateTeacher(object);
            }

        } catch(SQLException e) {
            throw new ServletException(e);
        }


        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}