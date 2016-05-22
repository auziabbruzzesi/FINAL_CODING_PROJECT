package rocket.app.view;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	@FXML
	private TextField txtIncome;
	
	@FXML
	private TextField txtExpenses;
	
	@FXML
	private TextField txtCreditScore;
	
	@FXML
	private TextField txtHouseCost;

	@FXML
	private ComboBox<Integer> cmbTerm;
	ObservableList<Integer> year = FXCollections.observableArrayList(30, 15);
	
	@FXML
	private TextField txtDownPayment;
	
	
	
	
	

	
	
	@FXML
	private Button btnPayment;
	@FXML
	private Label lblMortgagePayment;
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)
	@FXML
    private void initialize() {
    	cmbTerm.setItems(year);
    	lblMortgagePayment.setVisible(false);
    }

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		 
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		lq.setIncome(Double.parseDouble((txtIncome.getText())));
		lq.setExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiTerm(cmbTerm.getValue());
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));
		//	TODONE - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		lblMortgagePayment.setVisible(true);
		if (!RateBLL.enoughMula(lRequest.getIncome(),lRequest.getExpenses(),lRequest.getdPayment())){
			lblMortgagePayment.setText("Not enough Income!!!!");
			lblMortgagePayment.setTextFill(Color.RED);
			
		}else if(lRequest.getdRate()==0){
			lblMortgagePayment.setText("Credit Score Too Low!!!!");
			lblMortgagePayment.setTextFill(Color.RED);
		}
		else{
	
		
		lblMortgagePayment.setText("$"+Double.toString(RateBLL.round(Math.abs(lRequest.getdPayment()),2)));
		lblMortgagePayment.setTextFill(Color.GREEN);
		System.out.print(lRequest.getdPayment());
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
	}}
}
