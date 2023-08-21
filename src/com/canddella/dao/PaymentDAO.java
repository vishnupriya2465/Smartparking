package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Payment;


public interface PaymentDAO {
	public void savePayment(Payment payment);
	public Payment viewPayment(String  paymentId);
	public Payment deletePayment(String  paymentId);
	public List<Payment>listAllPayment();

}
