package logical.example.domain;

public abstract class Money implements Comparable<Money>{
	
	public abstract float getValue();
	
	public abstract void incrementCount() ;

	public abstract int getCount();
	
}
