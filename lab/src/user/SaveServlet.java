package user;
import java.net.*; 
import java.io.*; 
import java.util.*; 
import javax.net.ssl.*;
import java.security.*;
import java.security.MessageDigest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.Base64;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveUserServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        User object = new User();
        object.setLogin(req.getParameter("login"));     
        String pswd=req.getParameter("password");
        byte[] bytes = pswd.getBytes("UTF-8") ;
		String encoded = Base64.getEncoder().encodeToString(bytes);		
        object.setPassword(encoded);
        object.setRole_id(Integer.parseInt(req.getParameter("role")));
        try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
            Users.insert(object);
        } else {
            Users.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
	}

}
