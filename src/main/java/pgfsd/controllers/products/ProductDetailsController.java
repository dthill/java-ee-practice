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
    public void init() {
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
        String res = htmlProductwithDetails(product);
        out.println(res);
        request.getSession().setAttribute("edit-product", product);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        PrintWriter out = response.getWriter();
        Product product = (Product) httpSession.getAttribute("edit-product");
        httpSession.removeAttribute("edit-product");
        ProductDetails productDetails = new ProductDetails();
        productDetails.setDescription(request.getParameter("description"));
        productDetails.setOrigin(request.getParameter("origin"));
        productDetails.setTransport(request.getParameter("transport"));
        boolean success = productsService.updateProductDetails(product, productDetails);
        if (success) {
            out.println("Product details updated successfully");
            out.println(htmlProductwithDetails(product));
        } else {
            out.println("Error updating product details please try again");
        }
    }

    private String htmlProductwithDetails(Product product) {
        String res = "<tr><td>id</td><td>name</td><td>description</td><td>origin</td><td>transport</td></tr>" +
                "<tr><td>" +
                product.getId() +
                "</td><td>" +
                product.getName() +
                "</td>";
        ProductDetails productDetails = product.getDetails();
        if (productDetails != null) {
            res += "<td>" +
                    productDetails.getDescription() +
                    "</td><td>" +
                    productDetails.getOrigin() +
                    "</td><td>" +
                    productDetails.getTransport() +
                    "</td>";
        }
        res += "</tr>";
        return res;
    }
}
