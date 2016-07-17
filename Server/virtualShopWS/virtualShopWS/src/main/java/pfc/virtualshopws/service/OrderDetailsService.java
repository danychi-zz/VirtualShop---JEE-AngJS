package pfc.virtualshopws.service;

import java.util.List;

import pfc.virtualshopws.entity.OrderDetails;

public interface OrderDetailsService {

	public OrderDetails findById(Long id);

	public OrderDetails update(OrderDetails orderDetail);

	public OrderDetails create(OrderDetails orderDetail);

	public void delete(OrderDetails orderDetail);

	List<OrderDetails> findAll();

	public List<Long> getProductsIdByOrderId(Long orderId);

	public List<OrderDetails> getOrderDetailsByOrderId(Long orderId);

	public void deleteByOrderId(Long orderId);

}
