package hardware.components;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import hardware.consts.BitArrayConsts;

public class RegisterTest {
	@Test
	void testClock() {
		Register reg = new Register();
		reg.write(BitArrayConsts.true16);
		reg.clock();
		assertArrayEquals(BitArrayConsts.false16, reg.read());

		reg.write(BitArrayConsts.false16);
		reg.clock();
		assertArrayEquals(BitArrayConsts.true16, reg.read());

		reg.clock();
		assertArrayEquals(BitArrayConsts.false16, reg.read());
	}
}
