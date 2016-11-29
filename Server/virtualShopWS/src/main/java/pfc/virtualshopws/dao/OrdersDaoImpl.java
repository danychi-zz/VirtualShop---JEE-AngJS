package pfc.virtualshopws.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pfc.virtualshopws.entity.Orders;

@Repository
public class OrdersDaoImpl extends GenericDaoImpl<Orders>implements OrdersDao {

	@Override
	public List<Orders> findOrdersByUserId(long userId) {

		String sqlString = "SELECT u FROM Orders u WHERE u.userId = ?1";

		Query query = entityManager.createQuery(sqlString, Orders.class);

		query.setParameter(1, userId);

		return (List<Orders>) query.getResultList();

	}

}
