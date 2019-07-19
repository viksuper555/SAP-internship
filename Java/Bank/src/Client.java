import java.util.ArrayList;
import java.util.List;

public class Client {

	private String name, address;
	
	private double balance, salary;
	
	private List<Credit> credits = new ArrayList<>();

	private List<Deposit> deposits = new ArrayList<>();

	
	public Client(String name, double balance, double salary)
	{
		this.name = name;
		this.balance = balance;
		this.salary = salary;
	}
	
	public void OpenDeposit(double amount, int period, double annualInterestPercent)
	{
		if(balance >= amount && amount >= 0)
		{
			Deposit deposit = new Deposit(amount, period, annualInterestPercent);
			deposits.add(deposit);
			balance -= amount;
		}
	}
	
	public String GetName()
	{
		return name;
	}
	public double GetSalary() {
		return salary;
	}
	public List<Credit> GetCreditStatus()
	{
		return credits;
	}
	
	public void importMoney(int amount, String creditName)
	{
		if(balance >= amount)
		{
			for(Credit c : credits)
			{
				if(c.GetName() == creditName)
				{
					c.addAmount(amount);
					break;
				}
			}
		}
	}

	public void AddCredit(Credit credit)
	{
		credits.add(credit);
		balance += credit.GetAmount();
	}
	public double GetBalance()
	{
		return balance;
	}

	@Override
	public String toString()
	{
		String balance = String.format("%.2f", this.balance); 
		String salary = String.format("%.2f", this.salary); 

		if(address != null)
			return "Client: " + name + " " + address + "\n" + 
				"balance and salary: " + balance + " " + salary + "\n";
		return "Client: " + name + "\n" + 
		"balance and salary: " + balance + " " + salary + "\n";
	}
}
