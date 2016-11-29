package pfc.virtualshopws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfc.virtualshopws.dao.OrdersDao;
import pfc.virtualshopws.entity.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;

	@Override
	public Orders findById(Long id) {
		return ordersDao.find(id);
	}

	@Override
	public Orders update(Orders order) {
		return ordersDao.update(order);
	}

	@Override
	public Orders create(Orders order) {
		return ordersDao.create(order);
	}

	@Override
	public void delete(Orders order) {
		ordersDao.delete(order.getOrderId());

	}

	@Override
	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	@Override
	public List<Orders> findOrdersByUserId(long userId) {
		return ordersDao.findOrdersByUserId(userId);
	}

}
