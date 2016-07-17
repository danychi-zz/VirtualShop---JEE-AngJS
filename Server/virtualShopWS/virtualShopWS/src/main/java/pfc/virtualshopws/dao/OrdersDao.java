package pfc.virtualshopws.dao;

import java.util.List;

import pfc.virtualshopws.entity.Orders;

public interface OrdersDao extends GenericDao<Orders> {

	public List<Orders> findOrdersByUserId(long userId);

}
