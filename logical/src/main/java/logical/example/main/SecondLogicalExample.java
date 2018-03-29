package logical.example.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.TreeSet;

import logical.example.domain.FiftyPaisa;
import logical.example.domain.FiveHundredRs;
import logical.example.domain.FiveRs;
import logical.example.domain.HunderdRs;
import logical.example.domain.Money;
import logical.example.domain.Rs;
import logical.example.domain.TenRs;
import logical.example.domain.ThousandRs;
import logical.example.domain.TwentyFivePaisa;
import logical.example.domain.TwentyRs;
import logical.example.domain.TwoHunderdRs;
import logical.example.domain.TwoThousandRs;

public class SecondLogicalExample {

	public static void main(String[] args) {
		
		// create all money objects
		Money twoThousandRs = new TwoThousandRs();
		Money thousandRs = new ThousandRs();
		Money twoHundred = new TwoHunderdRs();
		Money hundred = new HunderdRs();
		Money fiveHundred = new FiveHundredRs();
		Money twentyRs = new TwentyRs();
		Money tenRs = new TenRs();
		Money fiveRs = new FiveRs();
		Money rs = new Rs();
		Money fiftyPaisa = new FiftyPaisa();
		Money twentyFivePaisa = new TwentyFivePaisa();
		
		
		// add all money objects in ascending order and preserve order for later retrival
		Collection<Money> moneyBag = new TreeSet<Money>();
		moneyBag.add(twoHundred);
		moneyBag.add(twentyRs);
		moneyBag.add(tenRs);
		moneyBag.add(fiftyPaisa);
		moneyBag.add(fiveHundred);
		moneyBag.add(twentyFivePaisa);
		moneyBag.add(twoThousandRs);
		moneyBag.add(thousandRs);
		moneyBag.add(fiveRs);
		moneyBag.add(rs);
		moneyBag.add(hundred);
		
		float input = 0.00f;
		
		// Read Input	
		System.out.println("Input : ");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			input = Float.parseFloat(reader.readLine());
		} catch (Exception e) {
			System.out.println("Invalid Input");
			return;
		} finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// Check if input is larger than 0 to avoid unneccssary iterations
		if(input > 0){
			float difference = input;
			
			for (Money money : moneyBag) {
				difference = substractAndGetDifference(difference, money);
				if(difference <= 0){
					break;
				}
			}
		}
		
		// print bag contents
		System.out.println("Counts of bag contents : ");
		int totalNotesCount = 0;
		for (Money money : moneyBag) {
			totalNotesCount += money.getCount();
			System.out.println(money.getValue() + " X " + money.getCount() + " = " + (money.getValue() * money.getCount()));
		}
		
		System.out.println("Total Notes/Coins: " + totalNotesCount);
		
	}
	
	private static float substractAndGetDifference(float difference, Money money){
		
		while(difference >= money.getValue()){
			money.incrementCount();
			difference -= money.getValue();
		}
		return difference;
	}

}
