package pfc.virtualshopws.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pfc.virtualshopws.entity.PaymentDetails;

@Repository
public class PaymentDetailsDaoImpl extends GenericDaoImpl<PaymentDetails>implements PaymentDetailsDao {

	@Override
	public PaymentDetails findPaymentDetailByOrderId(Long orderId) {
		String sqlString = "SELECT u FROM PaymentDetails u WHERE u.orderId = ?1";

		Query query = entityManager.createQuery(sqlString, PaymentDetails.class);

		query.setParameter(1, orderId);

		return (PaymentDetails) query.getSingleResult();
	}

	@Override
	public void deleteByOrderId(Long orderId) {
		String sqlString = "DELETE FROM PaymentDetails WHERE orderId = ?1";

		Query query = entityManager.createQuery(sqlString);

		query.setParameter(1, orderId);

		query.executeUpdate();

	}
}
