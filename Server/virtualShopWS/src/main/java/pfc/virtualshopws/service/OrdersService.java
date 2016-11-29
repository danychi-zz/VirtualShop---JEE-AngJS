package pfc.virtualshopws.service;

import java.util.List;

import pfc.virtualshopws.entity.Orders;

public interface OrdersService {

	public Orders findById(Long id);

	public Orders update(Orders order);

	public Orders create(Orders order);

	public void delete(Orders order);

	List<Orders> findAll();

	public List<Orders> findOrdersByUserId(long userId);

}
