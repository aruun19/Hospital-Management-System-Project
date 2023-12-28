package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Payment;

public interface PaymentService {
	public void addPayment(Payment payment);
	public List<Payment>findALL();
	public Optional<Payment> findpatientBypaymentId(int paymentId);
	//public void updatePayment(Payment payment);
	//public void updatePayment(Payment s);
	//public void deleteById(int paymentId);
	void deletePayment(int paymentId);
	public void savepayment(Payment p);
}