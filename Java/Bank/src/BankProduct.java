

public abstract class BankProduct {
	
	private String name;
	
	private double annualInterestPercent, amount;
	
	private int period;
	
	public BankProduct(double amount, int period, double annualInterestPercent) {
		this.amount = amount;
		this.period = period;
		this.name = String.format("%.2f", this.amount) + " " + period;
		this.annualInterestPercent = annualInterestPercent;
	}
	
	public BankProduct(double amount, int period, double annualInterestPercent, String name)
	{
		this.name = name;
		this.annualInterestPercent = annualInterestPercent;
		this.amount = amount;
		this.period = period;
		
	}

	public String GetName()
	{
		return name;
	}
	
	public void addAmount(double amount)
	{
		this.amount += amount;
	}
	public double GetAmount()
	{
		return this.amount;
	}
	
	public double CountInterest()
	{
		return annualInterestPercent*amount/100;
	}
	public int GetPeriod()
	{
		return period;
	}
	
	public double GetInterest()
	{
		return annualInterestPercent;
	}
	
	@Override
	public String toString()
	{
		String amount = String.format("%.2f", this.amount);
		
		return  name + "\n" + 
		"amount, period and interest: " + amount + " " + period +  " " + annualInterestPercent;
	}
}
