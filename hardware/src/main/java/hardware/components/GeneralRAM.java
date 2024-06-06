package hardware.components;

import hardware.utils.Calc;

public class GeneralRAM {
	private final int size;
	private final Register[] registers;

	GeneralRAM(int size) {
		this.size = size;
		registers = new Register[size];
		for (int i = 0; i < size; i++) {
			registers[i] = new Register();
		}
	}

	public void clock() {
		for (int i = 0; i < size; i++) {
			registers[i].clock();
		}
	}

	public boolean[] read(boolean[] address) {
		return registers[Calc.convertBoolArrayToDecimal(address)].read();
	}

	public void write(boolean[] in, boolean[] address) {
		registers[Calc.convertBoolArrayToDecimal(address)].write(in);
	}
}
