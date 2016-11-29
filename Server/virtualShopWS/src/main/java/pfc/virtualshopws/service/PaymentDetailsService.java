package pfc.virtualshopws.service;

import java.util.List;

import pfc.virtualshopws.entity.PaymentDetails;

public interface PaymentDetailsService {
	public PaymentDetails findById(Long id);

	public PaymentDetails update(PaymentDetails paymentMethod);

	public PaymentDetails create(PaymentDetails paymentMethod);

	public void delete(PaymentDetails paymentMethod);

	List<PaymentDetails> findAll();

	public PaymentDetails findPaymentDetailByOrderId(Long orderId);

	public void deleteByOrderId(Long orderId);

}
