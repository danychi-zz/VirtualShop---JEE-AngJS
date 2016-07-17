package pfc.virtualshopws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfc.virtualshopws.dao.PaymentDetailsDao;
import pfc.virtualshopws.entity.PaymentDetails;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

	@Autowired
	private PaymentDetailsDao paymentDetailsDao;

	@Override
	public PaymentDetails findById(Long id) {
		return paymentDetailsDao.find(id);
	}

	@Override
	public PaymentDetails update(PaymentDetails paymentDetail) {
		return paymentDetailsDao.update(paymentDetail);
	}

	@Override
	public PaymentDetails create(PaymentDetails paymentDetail) {
		return paymentDetailsDao.create(paymentDetail);
	}

	@Override
	public void delete(PaymentDetails paymentMethod) {
		paymentDetailsDao.delete(paymentMethod.getPaymentDetailId());

	}

	@Override
	public List<PaymentDetails> findAll() {
		return paymentDetailsDao.findAll();
	}

	@Override
	public PaymentDetails findPaymentDetailByOrderId(Long orderId) {
		return paymentDetailsDao.findPaymentDetailByOrderId(orderId);
	}

	@Override
	public void deleteByOrderId(Long orderId) {
		paymentDetailsDao.deleteByOrderId(orderId);
	}

}
