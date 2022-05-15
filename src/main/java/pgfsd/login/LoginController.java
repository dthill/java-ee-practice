package pgfsd.login;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login-controller")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if(checkCredentials(email,password)){
            session.setAttribute("email", email);
            dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request,response);
        } else {
            dispatcher = request.getRequestDispatcher("login.jsp");
            session.invalidate();
            request.setAttribute("error", "Email or password are not correct");
            dispatcher.include(request,response);
        }
    }

    private boolean checkCredentials(String email, String password){
        return email != null
                && password != null
                && email.equalsIgnoreCase("test@test.com")
                && password.equals("test");
    }
}
