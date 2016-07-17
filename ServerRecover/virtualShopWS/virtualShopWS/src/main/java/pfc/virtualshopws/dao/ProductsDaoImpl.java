package pfc.virtualshopws.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pfc.virtualshopws.entity.Products;

@Repository
public class ProductsDaoImpl extends GenericDaoImpl<Products>implements ProductsDao {

	@Override
	public List<Products> getProductsByProductsId(List<Long> productsId) {

		String sqlString = "SELECT u FROM Products u WHERE u.productId IN ?1";

		Query query = entityManager.createQuery(sqlString, Products.class);

		query.setParameter(1, productsId);

		return (List<Products>) query.getResultList();

	}

}
