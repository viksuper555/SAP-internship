
public class Deposit extends BankProduct{

	private double montlyPayment;
	
	
	
	public Deposit(double amount, int period, double annualInterestPercent)
	{
		super(amount,period, annualInterestPercent);
		this.montlyPayment = amount/period;
	}
	
	public Deposit(double amount, int period, double annualInterestPercent, String name, double montlyPayment) {
		super(amount, period, annualInterestPercent, name);
		this.montlyPayment = montlyPayment;
	}
	
	@Override
	public String toString()
	{
		String amount = String.format("%.2f", super.GetAmount());
		String montlyPayment = String.format("%.2f", this.montlyPayment);
		
		return "Deposit: " + super.GetName() + "\n" + 
		"Amount, period and interest: " + amount + " " + super.GetPeriod() +  " " + super.GetInterest()
		+ " \nMontly Payment: " + montlyPayment + "\n";
	}
	
}
