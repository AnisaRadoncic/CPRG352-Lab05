/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;


public class LoginServlet extends HttpServlet {

   
   
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        String logout = request.getParameter("logout");
        
        if (logout != null) {
            session.invalidate(); 
            request.setAttribute("loggedOut", "You have been successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
            
        
    }
         User user = (User) session.getAttribute("user");
        
        if(user != null) {
            response.sendRedirect("home");
           
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(); 
        String username = request.getParameter("username");
        String password = request.getParameter("password"); 
        
        if(username == null || username == "" || password == null || password == "") {
            request.setAttribute("invalidLogin", "Invaid username or password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
    }
        
 else {
            AccountService accountUser = new AccountService();
            User user = new User();
            user = accountUser.login(username, password);
            
            if(user == null) {
                request.setAttribute("invalidLogin", "Invaid username or password");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
                
        }
            else {
                session.setAttribute("user", user);
                response.sendRedirect("home");
                return;
            }


    
}
}
}
