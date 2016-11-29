package pfc.virtualshopws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfc.virtualshopws.dao.OrderDetailsDao;
import pfc.virtualshopws.entity.OrderDetails;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsDao OrderDetailsDao;

	@Override
	public OrderDetails findById(Long id) {
		return OrderDetailsDao.find(id);
	}

	@Override
	public OrderDetails update(OrderDetails orderDetail) {
		return OrderDetailsDao.update(orderDetail);
	}

	@Override
	public OrderDetails create(OrderDetails orderDetail) {
		return OrderDetailsDao.create(orderDetail);
	}

	@Override
	public void delete(OrderDetails orderDetail) {
		OrderDetailsDao.delete(orderDetail.getOrderDetailId());

	}

	@Override
	public List<OrderDetails> findAll() {
		return OrderDetailsDao.findAll();
	}

	@Override
	public List<Long> getProductsIdByOrderId(Long orderId) {
		return OrderDetailsDao.getProductsIdByOrderId(orderId);
	}

	@Override
	public List<OrderDetails> getOrderDetailsByOrderId(Long orderId) {
		return OrderDetailsDao.getOrderDetailsByOrderId(orderId);
	}

	@Override
	public void deleteByOrderId(Long orderId) {
		OrderDetailsDao.deleteByOrderId(orderId);
	}
}
