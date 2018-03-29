package logical.example.domain;

public class FiftyPaisa extends Money{

	private static float value = 0.5f;

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
