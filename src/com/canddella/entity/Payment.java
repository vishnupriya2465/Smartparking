package com.canddella.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Payment {
private String paymentId;
private Customer customer;
private Reservation reservation;
private LocalTime paymentTime;
private LocalDate paymentDate;
private double amount;
public Payment(String paymentId, Customer customer, Reservation reservation, LocalTime paymentTime,
		LocalDate paymentDate, double amount) {
	super();
	this.paymentId = paymentId;
	this.customer = customer;
	this.reservation = reservation;
	this.paymentTime = paymentTime;
	this.paymentDate = paymentDate;
	this.amount = amount;
}
public String getPaymentId() {
	return paymentId;
}
public void setPaymentId(String paymentId) {
	this.paymentId = paymentId;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Reservation getReservation() {
	return reservation;
}
public void setReservation(Reservation reservation) {
	this.reservation = reservation;
}
public LocalTime getPaymentTime() {
	return paymentTime;
}
public void setPaymentTime(LocalTime paymentTime) {
	this.paymentTime = paymentTime;
}
public LocalDate getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(LocalDate paymentDate) {
	this.paymentDate = paymentDate;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
}
