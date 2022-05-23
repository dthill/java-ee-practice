package pgfsd.ecommerce;

import pgfsd.bean.Product;
import pgfsd.bean.SearchTerm;
import pgfsd.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductsService {

    public List<Product> findProduct(SearchTerm searchTerm) {
        Connection connection = DBConnection.getConnection();
        String searchText = searchTerm.getSearchTerm();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> result = new LinkedList<>();
        try {
            if (searchText == null || searchText == "") {
                statement = connection.prepareStatement("SELECT * FROM Products");
            } else {
                statement = connection.prepareStatement("SELECT * FROM Products WHERE id = ? OR name LIKE ?");
                statement.setString(1, searchText);
                statement.setString(2, "%" + searchText + "%");
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                result.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                DBConnection.closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
