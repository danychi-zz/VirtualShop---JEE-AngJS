package pfc.virtualshopws.dao;

import java.util.List;

import pfc.virtualshopws.entity.Products;

public interface ProductsDao extends GenericDao<Products> {

	List<Products> getProductsByProductsId(List<Long> productsId);

}
