package hardware.components;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import hardware.consts.BitArrayConsts;

public class GeneralRAMTest {
	@Test
	void testClock() {
		boolean[] address = { false, false, false };
		GeneralRAM ram = new GeneralRAM(8);

		ram.write(BitArrayConsts.true16, address);
		ram.clock();
		assertArrayEquals(BitArrayConsts.false16, ram.read(address));

		ram.write(BitArrayConsts.false16, address);
		ram.clock();
		assertArrayEquals(BitArrayConsts.true16, ram.read(address));

		ram.clock();
		assertArrayEquals(BitArrayConsts.false16, ram.read(address));
	}
}
