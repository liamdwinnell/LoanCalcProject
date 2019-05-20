package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	@FXML
	private TextField InterestRate;
	@FXML
	private TextField NbrOfYears;
	@FXML
	private TextField AdditionalPayment;
	
	@FXML
	private Label lblTotalPayemnts;
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
	
		LoanCalc loanCalculator = new LoanCalc();
		
		loanCalculator.setLoanAmount(Double.parseDouble(LoanAmount.getText()));
		loanCalculator.setInterestRate(Double.parseDouble(InterestRate.getText()));
		loanCalculator.setNbrOfYears(Double.parseDouble(NbrOfYears.getText()));
		loanCalculator.setAdditionalPayment(Double.parseDouble(AdditionalPayment.getText()));
		
		//use functions from loan calculator after setting the amounts
		lblTotalPayemnts.setText(Double.toString(loanCalculator.totalPayment()));
		lblTotalInterest.setText(Double.toString(loanCalculator.totalInterest()));
		
		LocalDate localDate = PaymentStartDate.getValue();
	 
		System.out.println(localDate);
	}
}
