import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	
	private String name, address;
	
	private List<Credit> credits = new ArrayList<>();
	private List<Deposit> deposits = new ArrayList<>();
	private List<Client> clients = new ArrayList<>();
	
	private double balance, reserve;
	
	public Bank(String name, String address)
	{
		this.name = name;
		this.address = address;
		balance = 0;
		reserve = 0;
	}
	public Bank(String name, String address, double balance, double reserve)
	{
		this.name = name;
		this.address = address;
		this.balance = balance;
		this.reserve = reserve;
	}
	
	public void AddClient(Client client)
	{
		clients.add(client);
	}
	
	public void AcceptDeposit(double amount, int period, double annualInterestPercent)
	{
		this.balance += amount;
		this.reserve += amount * 0.9;
		
		Deposit deposit = new Deposit(amount, period, annualInterestPercent);
		deposits.add(deposit);
	}
	
	public void PayDebts()
	{
		for(Deposit d : deposits)
		{
			
			double fee = d.CountInterest();
			
			d.addAmount(fee);
			this.balance -= fee;
		}
	}
	
	public boolean GrantCredit(Credit creditCandidate, String clientName)
	{
		double amount = creditCandidate.GetAmount();
		int period = creditCandidate.GetPeriod();
		double interest = creditCandidate.GetInterest();
		
		Client client = null;
		for(Client c : clients)
		{
			if(c.GetName() == clientName)
			{
				client = c;
				break;
			}
		}
		
		double clientSalary = client.GetSalary();
		List<Credit> clientCredits = client.GetCreditStatus();
		double creditSum = 0;
		
		for(Credit credit : clientCredits)
		{
			creditSum += credit.GetMontlyFee();
		}
		
		double depositSum = 0;
		for(Deposit deposit : deposits)
		{
			depositSum += deposit.GetAmount();
		}
		
		if(creditSum <= clientSalary * 0.5 && amount <= reserve && balance - amount > depositSum * 0.1)
		{
			Credit newCredit = new Credit(amount, period, interest, 
					creditCandidate.GetName(), creditCandidate.GetMontlyFee());
			credits.add(newCredit);
			client.AddCredit(newCredit);
			balance -= amount;
			return true;
		}
			
		
		return false;
	}

	public double GetBalance()
	{
		return balance;
	}
	
	public double GetReserve()
	{
		return reserve;
	}

	public List<Credit> GetCreditStatus()
	{
		return credits;
	}
	
	public List<Deposit> GetDepositstatus()
	{
		return deposits;
	}

	@Override
	public String toString()
	{
		String balance = String.format("%.2f", this.balance); 
		String reserve = String.format("%.2f", this.reserve); 

		if(address != null)
			return "Bank: " + name + " " + address + "\n" + 
				"balance and reserve: " + balance + " " + reserve + "\n" + 
						"clients/credits/deposits: " + clients.size() + " " + credits.size() + " " + deposits.size();
		return "Bank: " + name + "\n" + 
		"balance and reserve: " + balance + " " + reserve + "\n" + 
		"clients/credits/deposits: " + clients.size() + " " + credits.size() + " " + deposits.size();
	}
}
