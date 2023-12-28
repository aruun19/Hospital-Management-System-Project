package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PaymentDao;
import com.example.demo.entity.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentDao dao;

	@Override
	public List<Payment> findALL() {
		// TODO Auto-generated method stub
		return this.dao.findAll();
	}

	@Override
	public Optional<Payment> findpatientBypaymentId(int paymentId) {
		// TODO Auto-generated method stub
		return this.dao.findById(paymentId);
	}

	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		this.dao.save(payment);
	}
	
	
	
	/*@Override
	public void deleteById(int paymentId) {
		// TODO Auto-generated method stub
		dao.deleteById(paymentId);
	}*/
	
	@Override
	public void deletePayment(int paymentId) {
		// TODO Auto-generated method stub
		dao.findById(paymentId);		
		if (dao.existsById(paymentId)) {
		    dao.deleteById(paymentId);
		}
	}
	
	
	/*public Payment addPay(Payment payment, int pid, int bookingId) {
	 
		
		//payment.setBooking(booking_id);
		//payment.setCardNumber();(order.getTotalPrice());
		//payment.setPaidDate(LocalDate.now());
		//payment.setPaidAmount(order.getTotalPrice());
		//if (payment.getTotalPrice() == payment.getPaidAmount()) {
			//order.setStatus("Paid");
		//} else {

			CrudRepository<Payment, Integer> PaymentDao = null;
		//order.setStatus("Not Paid");
		//}
		//Customer customer = customerService.findUserById(customerId).orElse(null);
		//payment.setCustomer(customer);
    	return PaymentDao.save(payment);
	}*/
	
	/*@Override
	public void updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		this.dao.save(payment);	
	}*/
	
	@Override
	public void savepayment(Payment p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	

	

	/*@Override
	public void updatePayment(Payment s) {
		// TODO Auto-generated method stub
		this.dao.save(s);
	}*/

}
