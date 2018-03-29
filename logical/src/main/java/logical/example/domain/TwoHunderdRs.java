package logical.example.domain;

public class TwoHunderdRs extends Money{

	private static final float value = 200.00f;

	private static Integer count = 0;
	
	public int compareTo(Money money) {
		return -(int) (value - money.getValue());
	}

	@Override
	public float getValue() {
		return value;
	}

	public void incrementCount() {
		count++;
	}

	@Override
	public int getCount() {
		return count;
	}
}
