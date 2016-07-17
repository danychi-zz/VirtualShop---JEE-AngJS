package pfc.virtualshopws.service;

import java.util.List;

import pfc.virtualshopws.entity.Products;

public interface ProductsService {

	public Products findById(Long id);

	public Products update(Products product);

	public Products create(Products product);

	public void delete(Products product);

	List<Products> findAll();

	public List<Products> getProductsByProductsId(List<Long> productsId);

}
