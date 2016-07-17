package pfc.virtualshopws.dao;

import java.util.List;

import pfc.virtualshopws.entity.OrderDetails;

public interface OrderDetailsDao extends GenericDao<OrderDetails> {

	public List<Long> getProductsIdByOrderId(Long orderId);

	List<OrderDetails> getOrderDetailsByOrderId(Long orderId);

	void deleteByOrderId(Long orderId);

}
