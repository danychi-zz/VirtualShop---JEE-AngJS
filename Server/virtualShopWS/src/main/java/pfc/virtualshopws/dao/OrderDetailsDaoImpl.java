package pfc.virtualshopws.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pfc.virtualshopws.entity.OrderDetails;

@Repository
public class OrderDetailsDaoImpl extends GenericDaoImpl<OrderDetails>implements OrderDetailsDao {

	@Override
	public List<Long> getProductsIdByOrderId(Long orderId) {
		String sqlString = "SELECT u.productId FROM OrderDetails u WHERE u.orderId = ?1";

		Query query = entityManager.createQuery(sqlString, Long.class);

		query.setParameter(1, orderId);

		return (List<Long>) query.getResultList();

	}

	@Override
	public List<OrderDetails> getOrderDetailsByOrderId(Long orderId) {
		String sqlString = "SELECT u FROM OrderDetails u WHERE u.orderId = ?1";

		Query query = entityManager.createQuery(sqlString, OrderDetails.class);

		query.setParameter(1, orderId);

		return (List<OrderDetails>) query.getResultList();

	}

	@Override
	public void deleteByOrderId(Long orderId) {
		String sqlString = "DELETE FROM OrderDetails WHERE orderId = ?1";

		Query query = entityManager.createQuery(sqlString);

		query.setParameter(1, orderId);

		query.executeUpdate();

	}

}
