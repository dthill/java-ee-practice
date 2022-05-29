package pgfsd.controllers.products;

import pgfsd.entities.Product;
import pgfsd.services.products.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductAddController", value = "/product-add-controller")
public class ProductAddController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String priceString = request.getParameter("price");
        Double price = null;
        Product product = new Product();
        if (name.equals("")) {
            out.println("Name is not a valid value,");
            return;
        }
        product.setName(name);
        try {
            if (priceString == null || priceString.equals("")) {
                throw new NumberFormatException();
            }
            price = Double.parseDouble(priceString);
            if (price < 0) {
                throw new NumberFormatException();
            }
            product.setPrice(price);
        } catch (NumberFormatException e) {
            out.println("Price is not a valid value.");
            return;
        }
        boolean success = new ProductsService().addProduct(product);
        if (!success) {
            out.println("Could not add the new product as the given ID already exists, please try again");
            return;
        }
        out.println("Product added successfully");
    }
}
