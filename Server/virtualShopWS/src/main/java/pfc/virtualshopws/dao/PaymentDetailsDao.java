package pfc.virtualshopws.dao;

import pfc.virtualshopws.entity.PaymentDetails;

public interface PaymentDetailsDao extends GenericDao<PaymentDetails> {

	public PaymentDetails findPaymentDetailByOrderId(Long orderId);

	public void deleteByOrderId(Long orderId);
}
