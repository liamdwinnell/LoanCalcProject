package app.controller;

public class LoanCalc {

	private double LoanAmount;
	private double InterestRate;
	private double NbrOfYears;
	private double AdditionalPayment;
	
	public double getLoanAmount() {
		return LoanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		LoanAmount = loanAmount;
	}
	public double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	public double getNbrOfYears() {
		return NbrOfYears;
	}
	public void setNbrOfYears(double nbrOfYears) {
		NbrOfYears = nbrOfYears;
	}
	public double getAdditionalPayment() {
		return AdditionalPayment;
	}
	public void setAdditionalPayment(double additionalPayment) {
		AdditionalPayment = additionalPayment;
	}
	
	public double totalPayment() {
		
		//convert interest to the decimal percentage
		double DecimalInterest = InterestRate;
		if(DecimalInterest > 10) {
			
			DecimalInterest /= 1000;
			
		}else if(DecimalInterest > 1) {
			
			DecimalInterest /= 100;
			
		}
		
		//divide the interest per month
		DecimalInterest /= 12;
		
		//find the total payments monthly
		int NbrOfPayments = (int) NbrOfYears*12;
		
		//initialize total payment of loan
		double totalCost = 0;
		
		//do the pmt formula
		totalCost = LoanAmount*((DecimalInterest*Math.pow(1+DecimalInterest,NbrOfPayments)/(Math.pow(1+DecimalInterest,NbrOfPayments)-1)));
		
		double additionalRatio = AdditionalPayment/LoanAmount;
		double totalPaymentCoff = 1.65647*Math.pow(additionalRatio,2)-.348446*additionalRatio+.999737;
		if(AdditionalPayment <= 0) totalPaymentCoff = 1;
		
		//multiply the payment cost for the number of payments
		totalCost *= NbrOfPayments;
		
		//remove additional cost
		totalCost *= totalPaymentCoff;
		
		return Math.round(totalCost*100.0)/100.0;
		
	}
	
	public double totalInterest() {
		
		return Math.round((totalPayment()-LoanAmount)*100.0)/100.0;
		
	}
	
	
}
