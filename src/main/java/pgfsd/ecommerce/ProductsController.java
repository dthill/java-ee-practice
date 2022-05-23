package pgfsd.ecommerce;

import pgfsd.bean.Product;
import pgfsd.bean.SearchTerm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ProductsController", value = "/products-controller")
public class ProductsController extends HttpServlet {
    private ProductsService productsService;

    @Override
    public void init() {
        productsService = new ProductsService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SearchTerm searchTerm = new SearchTerm();
        searchTerm.setSearchTerm(request.getParameter("search"));
        List<Product> result = productsService.findProduct(searchTerm);
        PrintWriter out = response.getWriter();
        if(result.size() == 0){
            out.println("<tr><td></td><td>No products found with the given id or product name</td></tr>");
        } else {
            Iterator<Product> iterator = result.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                out.println("<tr><td>" + product.getId() + "</td><td>" + product.getName() + "</td></tr>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
