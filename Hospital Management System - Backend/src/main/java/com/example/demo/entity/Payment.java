package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name="payment")
@Entity
public class Payment {
	@Column(name="paymentId")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paymentId;
	
	@NotNull(message = "patient id can not be empty")
	@Column(name="pId")
	private int pId;
	
	@Column(name = "consultationFee")
	private double consultationFee;
	
	@NotNull(message = "cardNumber can not be empty")
	//@Size(max = 16,message = "cardNumber can't be more than 16 characters")
	//@Size(min=16, message="cardNumber must be more than 16 characters")
	@Column(name = "cardNumber")
	private long cardNumber;
	
	@NotNull(message = "cvv can not be empty")
	//@Size(max = 3,message = "cvv can't be more than 3 characters")
	//@Size(min=3, message="cvv must be more than 3 characters")
	@Column(name = "cvv")
	private int cvv;
	
	@NotNull(message = "cardHolderName can not be empty")
	//@Size(max = 20, message = "cardHolderName can't be more than 20 characters")
	//@Size(min = 2, message = "cardHolderName must be more than 2 characters")
	@Column(name = "cardHolderName")
	private String cardHolderName;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "bookingId") private BookingDoctor bookingId;
	 */
	public Payment()
	{
		
	}

	public Payment(int paymentId, @NotNull(message = "patient id can not be empty") int pId, double consultationFee,
			@NotNull(message = "cardNumber can not be empty") @Size(max = 16, message = "cardNumber can't be more than 16 characters") @Size(min = 16, message = "cardNumber must be more than 16 characters") long cardNumber,
			@NotNull(message = "cvv can not be empty") @Size(max = 3, message = "cvv can't be more than 3 characters") @Size(min = 3, message = "cvv must be more than 3 characters") int cvv,
			@NotNull(message = "cardHolderName can not be empty") @Size(max = 20, message = "cardHolderName can't be more than 20 characters") @Size(min = 2, message = "cardHolderName must be more than 2 characters") String cardHolderName) {
		super();
		this.paymentId = paymentId;
		this.pId = pId;
		this.consultationFee = consultationFee;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.cardHolderName = cardHolderName;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", pId=" + pId + ", consultationFee=" + consultationFee
				+ ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", cardHolderName=" + cardHolderName + "]";
	}
}
