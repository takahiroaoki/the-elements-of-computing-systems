package hardware.components;

public class BitRegister {
	private final DFF dff = new DFF();
	private boolean load = false;
	private boolean in = false;

	public void clock() {
		dff.clock(Gates.mux(dff.read(), in, load));
		load = false;
	}

	public boolean read() {
		return dff.read();
	}

	public void write(boolean in) {
		this.in = in;
		this.load = true;
	}
}
