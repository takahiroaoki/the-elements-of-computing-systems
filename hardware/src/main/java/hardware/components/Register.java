package hardware.components;

public class Register {
	private final BitRegister[] bitRegisters;
	private final int width = 16;

	Register() {
		bitRegisters = new BitRegister[width];
		for (int i = 0; i < width; i++) {
			bitRegisters[i] = new BitRegister();
		}
	}

	public void clock() {
		for (int i = 0; i < width; i++) {
			bitRegisters[i].clock();
		}
	}

	public boolean[] read() {
		boolean[] out = new boolean[width];
		for (int i = 0; i < width; i++) {
			out[i] = bitRegisters[i].read();
		}
		return out;
	}

	public void write(boolean[] in) {
		for (int i = 0; i < width; i++) {
			bitRegisters[i].write(in[i]);
		}
	}
}
