package Practice.InsuranceCompany.Design.src.model.payment;

import Practice.InsuranceCompany.Design.src.enums.PaymentType;
import Practice.InsuranceCompany.Design.src.model.contract.Contract;

public class PaymentForm {

	private String paymentFormID;
	private String contractID;
	private String customerId;

	private PaymentType paymentType;
	private Payment payment;
	// 수정
	private boolean examinationResult;

	public PaymentForm(){
		this.examinationResult=false;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;

		if(paymentType.equals(PaymentType.payout)){
			this.payment = new ClaimsPaid();
		}
		else if(paymentType.equals(PaymentType.maturity)){
			this.payment = new MaturityDividend();
		}
		else if(paymentType.equals(PaymentType.cancellation)){
			this.payment = new CancellationReturn();
		}
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getPaymentFormID() {
		return paymentFormID;
	}

	public void setPaymentFormID(String paymentFormID) {
		this.paymentFormID = paymentFormID;
	}

	public String getContractID() {
		return contractID;
	}

	public String getCustomerId() {
		return customerId;
	}

	public boolean isExaminationResult() {
		return examinationResult;
	}


	public String getPaymentFormId() {
		return this.paymentFormID;
	}

	public String getPaymentFormInfo(Contract contract) {
		if (paymentType.equals(PaymentType.payout)){
			return "         "+paymentFormID+ "               " + paymentType.getDetail() + "            "+customerId+ "           " + contract.getInsuranceID() + "       " + contract.getPremium();
		}
		return "         "+paymentFormID+ "               " + paymentType.getDetail() + "         "+customerId  + "           " + contract.getInsuranceID() + "       " + contract.getPremium();
	}

	public void setCustomerId(String customerID) {
		this.customerId = customerID;
	}

	public void setExaminationResult(boolean examinationResult) {
		this.examinationResult = examinationResult;
	}

	public void setPaymentFormId(String paymentFormId) {
		this.paymentFormID = paymentFormId;
	}

}