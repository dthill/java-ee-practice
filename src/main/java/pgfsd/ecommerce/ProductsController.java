package pgfsd.ecommerce;

import pgfsd.db.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ProductsController", value = "/products-controller")
public class ProductsController extends HttpServlet {

    private Connection connection;

    @Override
    public void init(){
        connection = DBConnection.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String sql = "SELECT * FROM Products";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                out.println("<p>"+ resultSet.getInt("id")+ " | " + resultSet.getString("name")+"</p>");
            }
        } catch (SQLException e) {
            out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
