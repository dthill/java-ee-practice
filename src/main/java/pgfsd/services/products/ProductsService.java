package pgfsd.services.products;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pgfsd.dto.SearchTerm;
import pgfsd.entities.Product;
import pgfsd.services.db.DBUtil;

import java.util.Arrays;
import java.util.List;

public class ProductsService {

    public List<Product> findProduct(SearchTerm searchTerm) {
        SessionFactory factory = DBUtil.sessionFactory;
        Session session = factory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        CriteriaQuery<Product> allProducts = criteriaQuery.select(root);
        List<Product> result;
        if (searchTerm.getSearchTerm() == null || searchTerm.getSearchTerm().equals("")) {
            result = session.createQuery(allProducts).getResultList();
        } else {
            Integer searchId;
            try {
                searchId = Integer.parseInt(searchTerm.getSearchTerm());
            } catch (NumberFormatException e) {
                searchId = null;
            }
            CriteriaQuery<Product> matchingProducts;
            if (searchId != null) {
                matchingProducts = criteriaQuery.where(
                        criteriaBuilder.or(
                                criteriaBuilder.equal(root.get("id"), searchId),
                                criteriaBuilder.like(root.get("name"), "%" + searchTerm.getSearchTerm() + "%")
                        )
                );
            } else {
                matchingProducts = criteriaQuery.where(
                        criteriaBuilder.like(root.get("name"), "%" + searchTerm.getSearchTerm() + "%")
                );
            }
            result = session.createQuery(matchingProducts).getResultList();
        }
        session.close();
        return result;
    }

    public boolean addProduct(Product product) {
        SessionFactory factory = DBUtil.sessionFactory;
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(product);
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            if (transaction != null) {
                transaction.rollback();
            }
            session.close();
            return false;
        }
    }
}
