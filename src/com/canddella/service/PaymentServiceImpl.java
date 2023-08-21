package com.canddella.service;


import java.util.List;

import com.canddella.dao.PaymentDAOImpl;
import com.canddella.entity.Payment;

public class PaymentServiceImpl implements PaymentService {
	PaymentDAOImpl paymentdaoimpl = new PaymentDAOImpl();


	@Override
	public void savePayment(Payment payment) {
		paymentdaoimpl.savePayment(payment);
		
	}


	@Override
	public Payment viewPayment(String paymentId) {
		return paymentdaoimpl.viewPayment(paymentId);
	}


	@Override
	public Payment deletePayment(String paymentId) {
		
		return paymentdaoimpl.deletePayment(paymentId);
	}


	@Override
	public List<Payment> listAllPayment() {
		
		return paymentdaoimpl.listAllPayment();
	}

}
