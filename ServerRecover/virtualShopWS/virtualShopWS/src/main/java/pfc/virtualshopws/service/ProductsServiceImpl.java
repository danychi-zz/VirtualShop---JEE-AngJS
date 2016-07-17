package pfc.virtualshopws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfc.virtualshopws.dao.ProductsDao;
import pfc.virtualshopws.entity.Products;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsDao ProductsDao;

	@Override
	public Products findById(Long id) {
		return ProductsDao.find(id);
	}

	@Override
	public Products update(Products product) {
		return ProductsDao.update(product);
	}

	@Override
	public Products create(Products product) {
		return ProductsDao.create(product);
	}

	@Override
	public void delete(Products product) {
		ProductsDao.delete(product.getProductId());

	}

	@Override
	public List<Products> findAll() {
		return ProductsDao.findAll();
	}

	@Override
	public List<Products> getProductsByProductsId(List<Long> productsId) {
		return ProductsDao.getProductsByProductsId(productsId);
	}

}
