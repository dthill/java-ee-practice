package pgfsd.controllers.products;

import pgfsd.entities.Product;
import pgfsd.entities.ProductDetails;
import pgfsd.services.products.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDetailsController", value = "/product-details-controller")
public class ProductDetailsController extends HttpServlet {
    private ProductsService productsService;

    @Override
    public void init(){
        productsService = new ProductsService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Integer id = -1;
        Product product = null;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            product = productsService.getProductById(id);
            if (product == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            out.println("<tr><td>ERROR: Product not found. Please check the product id.</td></tr>");
            return;
        }
        StringBuilder res = new StringBuilder()
                .append("<tr><td>id</td><td>name</td></tr>")
                .append("<tr><td>")
                .append(product.getId())
                .append("</td><td>")
                .append(product.getName())
                .append("</td></tr>");
        out.println(res);
        request.getSession().setAttribute("edit-product",product);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Product product = (Product) httpSession.getAttribute("edit-product");
        ProductDetails productDetails = new ProductDetails();
        productDetails.setDescription(request.getParameter("description"));
        productDetails.setOrigin(request.getParameter("origin"));
        productDetails.setOrigin(request.getParameter("transport"));
        boolean success = productsService.updateProductDetails(product, productDetails);
    }
}
