package hardware.components;

import hardware.consts.BitArrayConsts;

public class Counter {
	private boolean reset = false;
	private boolean inc = false;
	private boolean load = false;
	private boolean[] in = BitArrayConsts.false16;
	private Register register = new Register();

	public void clock() {
		boolean[] sel = { reset, load, inc };
		boolean[] whenReset = BitArrayConsts.false16;
		boolean[] whenLoad = in;
		boolean[] whenInc = Adders.add16(register.read(), BitArrayConsts.one16);

		register.write(
				Gates.mux8Way16(register.read(), whenInc, whenLoad, whenLoad, whenReset, whenReset, whenReset,
						whenReset, sel));
		reset = false;
		load = false;
		inc = false;
		register.clock();
	}

	public void reset() {
		this.reset = true;
	}

	public void inc() {
		this.inc = true;
	}

	public void write(boolean[] in) {
		load = true;
		this.in = in;
	}

	public boolean[] read() {
		return register.read();
	}
}
