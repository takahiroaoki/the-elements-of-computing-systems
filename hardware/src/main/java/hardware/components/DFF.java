package hardware.components;

public class DFF {
	private boolean out = false;// initial state
	private boolean prv = false;// initial state

	public void clock(boolean in) {
		out = prv;
		prv = in;
	}

	public boolean read() {
		return out;
	}
}
