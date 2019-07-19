
public class Credit extends BankProduct{
	
	private double montlyFee;
	
	public Credit(double amount, int period, double annualInterestPercent)
	{
		super(amount,period, annualInterestPercent);
		this.montlyFee = amount/period;
	}
	
	public Credit(double amount, int period, double annualInterestPercent, String name, double montlyFee)
	{
		super(amount, period, annualInterestPercent, name);
		this.montlyFee = montlyFee;
		
	}

	public double GetMontlyFee()
	{
		return this.montlyFee;
	}
	
	@Override
	public String toString()
	{
		String amount = String.format("%.2f", super.GetAmount());
		String montlyFee = String.format("%.2f", this.montlyFee);

		return "Credit: " + super.GetName() + "\n" + 
		"amount, period and interest: " + amount + " " + super.GetPeriod() +  " " + super.GetInterest()
		+ " \nMontly Fee: " + montlyFee + "\n";
	}
}
