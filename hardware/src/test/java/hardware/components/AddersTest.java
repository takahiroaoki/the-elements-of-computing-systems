package hardware.components;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import hardware.consts.BitArrayConsts;

public class AddersTest {
	@Test
	void testHalfAdder() {
		boolean[] out1 = { false, false };
		boolean[] out2 = { false, true };
		boolean[] out3 = { true, false };

		assertArrayEquals(out1, Adders.halfAdder(false, false));
		assertArrayEquals(out2, Adders.halfAdder(false, true));
		assertArrayEquals(out2, Adders.halfAdder(true, false));
		assertArrayEquals(out3, Adders.halfAdder(true, true));
	}

	@Test
	void testFullAdder() {
		boolean[] out1 = { false, false };
		boolean[] out2 = { false, true };
		boolean[] out3 = { true, false };
		boolean[] out4 = { true, true };

		assertArrayEquals(out1, Adders.fullAdder(false, false, false));
		assertArrayEquals(out2, Adders.fullAdder(false, false, true));
		assertArrayEquals(out2, Adders.fullAdder(false, true, false));
		assertArrayEquals(out3, Adders.fullAdder(false, true, true));
		assertArrayEquals(out2, Adders.fullAdder(true, false, false));
		assertArrayEquals(out3, Adders.fullAdder(true, false, true));
		assertArrayEquals(out3, Adders.fullAdder(true, true, false));
		assertArrayEquals(out4, Adders.fullAdder(true, true, true));
	}

	@Test
	void testAdder() {
		boolean[] max = {
				false,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
		};

		boolean[] maxComp = {
				true,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				true,
		};

		assertArrayEquals(BitArrayConsts.false16, Adders.add16(BitArrayConsts.false16, BitArrayConsts.false16));
		assertArrayEquals(BitArrayConsts.true16, Adders.add16(BitArrayConsts.false16, BitArrayConsts.true16));
		assertArrayEquals(BitArrayConsts.false16, Adders.add16(max, maxComp));
	}
}
