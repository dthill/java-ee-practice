package pgfsd.controllers.products;

import pgfsd.dto.SearchTerm;
import pgfsd.entities.Product;
import pgfsd.services.products.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductsController", value = "/product-list-controller")
public class ProductListController extends HttpServlet {
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
        if (result.size() == 0) {
            out.println("<tr><td></td><td>No products found with the given id or product name</td></tr>");
        } else {
            for (Product product : result) {
                StringBuilder res = new StringBuilder()
                        .append("<tr><td>")
                        .append(product.getId())
                        .append("</td><td>")
                        .append(product.getName())
                        .append("</td><td>")
                        .append(String.format("%.2f", product.getPrice()))
                        .append("</td><td>")
                        .append(String.format(
                                "<a href=\"product-details.jsp?id=%d\">View Details</a>", product.getId())
                        )
                        .append("</td><td>")
                        .append((String.format(
                                "<a href=\"product-details-edit.jsp?id=%d\">Edit  Details</a>", product.getId())
                        ))
                        .append("</td></tr>");
                out.println(res);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
