import java.util.ArrayList;
import java.util.List;

public class StartUp {
	
	public static void main(String args[])
	{
		
		Bank bank = new Bank("Bank1", "bul. Tsar Boris III 137", 1000, 500);
		
		Deposit shortDeposit = new Deposit(100, 3, 3);
		Deposit longDeposit = new Deposit(200, 12, 5);
		
		Credit homeCredit = new Credit(100,6 ,6);
		Credit consumerCredit = new Credit(100,10,10);
		
		Client c1 = new Client("Gosho", 3000, 2000);
		Client c2 = new Client("Pesho", 2000, 800);
		Client c3 = new Client("Ivan", 200, 700);
		Client c4 = new Client("Gosho2", 3000, 2000);
		Client c5 = new Client("Pesho2", 2000, 800);
		Client c6 = new Client("Ivan2", 200, 700);
		Client c7 = new Client("Gosho2", 3000, 2000);
		Client c8 = new Client("Pesho2", 2000, 800);
		Client c9 = new Client("Ivan3", 200, 700);
		Client c10 = new Client("Ivan4", 500, 700);

		List<Client> clients = new ArrayList<>();
		clients.add(c1);
		clients.add(c2);
		clients.add(c3);
		clients.add(c4);
		clients.add(c5);
		clients.add(c6);
		clients.add(c7);
		clients.add(c8);
		clients.add(c9);
		clients.add(c10);
		
		bank.AddClient(c1);
		bank.AddClient(c2);
		bank.AddClient(c3);
		bank.AddClient(c4);
		bank.AddClient(c5);
		bank.AddClient(c6);
		bank.AddClient(c7);
		bank.AddClient(c8);
		bank.AddClient(c9);
		bank.AddClient(c10);
		
		for(Client client : clients)					//7 step
		{
			double amount = (Math.random() * 0.2 + 0.8) * client.GetBalance();
			int period = shortDeposit.GetPeriod();
			double interest = shortDeposit.GetInterest();
			
			client.OpenDeposit(amount, period, interest);
			bank.AcceptDeposit(amount, period, interest);
		}
		
		
		System.out.println("Bank balance and reserve: " + (int)bank.GetBalance() + " "+ (int)bank.GetReserve());
		
		for(Client client : clients)					
		{
			double amount = (Math.random() * 300 + 10);
			int period = consumerCredit.GetPeriod();
			double interest = consumerCredit.GetInterest();
			
			Credit credit = new Credit(amount,period,interest, "TestCredit", 3);
			if(bank.GrantCredit(credit, client.GetName()))
				client.AddCredit(credit);
		}
		
		
		
		
		for(Client client : clients)					
		{
			System.out.println(client.toString());
		}
		
		for(Credit credit : bank.GetCreditStatus())					
		{
			System.out.println(credit.toString());
		}
		
		for(Deposit deposit : bank.GetDepositstatus())					
		{
			System.out.println(deposit.toString());
		}
		
		System.out.println(bank.toString());
	}
	
	
}
