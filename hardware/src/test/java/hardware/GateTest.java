package hardware;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GateTest {
	@Test
	void testNand() {
		assertEquals(false, Gate.nand(true, true));
		assertEquals(true, Gate.nand(true, false));
		assertEquals(true, Gate.nand(false, true));
		assertEquals(true, Gate.nand(false, false));
	}

	@Test
	void testNot() {
		assertEquals(false, Gate.not(true));
		assertEquals(true, Gate.not(false));
	}

	@Test
	void testAnd() {
		assertEquals(true, Gate.and(true, true));
		assertEquals(false, Gate.and(true, false));
		assertEquals(false, Gate.and(false, true));
		assertEquals(false, Gate.and(false, false));
	}

	@Test
	void testOr() {
		assertEquals(true, Gate.or(true, true));
		assertEquals(true, Gate.or(true, false));
		assertEquals(true, Gate.or(false, true));
		assertEquals(false, Gate.or(false, false));
	}

	@Test
	void testXor() {
		assertEquals(true, Gate.xor(true, true));
		assertEquals(false, Gate.xor(true, false));
		assertEquals(false, Gate.xor(false, true));
		assertEquals(true, Gate.xor(false, false));
	}

	@Test
	void testMux() {
		assertEquals(false, Gate.mux(false, false, false));
		assertEquals(false, Gate.mux(false, true, false));
		assertEquals(true, Gate.mux(true, false, false));
		assertEquals(true, Gate.mux(true, true, false));
		assertEquals(false, Gate.mux(false, false, true));
		assertEquals(true, Gate.mux(false, true, true));
		assertEquals(false, Gate.mux(true, false, true));
		assertEquals(true, Gate.mux(true, true, true));
	}

	@Test
	void testDmux() {
		boolean[] out1 = { false, true };
		assertArrayEquals(out1, Gate.dmux(true, true));

		boolean[] out2 = { false, false };
		assertArrayEquals(out2, Gate.dmux(false, true));

		boolean[] out3 = { true, false };
		assertArrayEquals(out3, Gate.dmux(true, false));

		boolean[] out4 = { false, false };
		assertArrayEquals(out4, Gate.dmux(false, false));
	}

	@Test
	void testNot16() {
		boolean[] trues = {
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
				true,
		};
		boolean[] falses = {
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
				false,
				false,
		};
		assertArrayEquals(falses, Gate.not16(trues));
		assertArrayEquals(trues, Gate.not16(falses));
	}

	@Test
	void testAnd16() {
		boolean[] trues = {
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
				true,
		};
		boolean[] falses = {
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
				false,
				false,
		};
		assertArrayEquals(trues, Gate.and16(trues, trues));
		assertArrayEquals(falses, Gate.and16(trues, falses));
		assertArrayEquals(falses, Gate.and16(falses, trues));
		assertArrayEquals(falses, Gate.and16(falses, falses));
	}

	@Test
	void testOr16() {
		boolean[] trues = {
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
				true,
		};
		boolean[] falses = {
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
				false,
				false,
		};
		assertArrayEquals(trues, Gate.or16(trues, trues));
		assertArrayEquals(trues, Gate.or16(trues, falses));
		assertArrayEquals(trues, Gate.or16(falses, trues));
		assertArrayEquals(falses, Gate.or16(falses, falses));
	}

	@Test
	void testMux16() {
		boolean[] trues = {
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
				true,
		};
		boolean[] falses = {
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
				false,
				false,
		};
		assertArrayEquals(trues, Gate.mux16(trues, trues, false));
		assertArrayEquals(trues, Gate.mux16(trues, falses, false));
		assertArrayEquals(falses, Gate.mux16(falses, trues, false));
		assertArrayEquals(falses, Gate.mux16(falses, falses, false));
		assertArrayEquals(trues, Gate.mux16(falses, trues, true));
		assertArrayEquals(falses, Gate.mux16(falses, falses, true));
		assertArrayEquals(trues, Gate.mux16(trues, trues, true));
		assertArrayEquals(falses, Gate.mux16(trues, falses, true));
	}

	@Test
	void testOr8Way() {
		boolean[] trues = {
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
				true,
		};
		boolean[] falses = {
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
				false,
				false,
		};
		assertEquals(true, Gate.or8Way(trues));
		assertEquals(false, Gate.or8Way(falses));
	}

	@Test
	void testMux4Way16() {
		boolean[] trues = {
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
				true,
		};
		boolean[] falses = {
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
				false,
				false,
		};
		boolean[] sel1 = { false, false };
		boolean[] sel2 = { false, true };
		boolean[] sel3 = { true, false };
		boolean[] sel4 = { true, true };

		assertArrayEquals(trues, Gate.mux4Way16(trues, falses, falses, falses, sel1));
		assertArrayEquals(trues, Gate.mux4Way16(falses, trues, falses, falses, sel2));
		assertArrayEquals(trues, Gate.mux4Way16(falses, falses, trues, falses, sel3));
		assertArrayEquals(trues, Gate.mux4Way16(falses, falses, falses, trues, sel4));
	}

	@Test
	void testMux8Way16() {
		boolean[] trues = {
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
				true,
		};
		boolean[] falses = {
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
				false,
				false,
		};
		boolean[] sel1 = { false, false, false };
		boolean[] sel2 = { false, false, true };
		boolean[] sel3 = { false, true, false };
		boolean[] sel4 = { false, true, true };
		boolean[] sel5 = { true, false, false };
		boolean[] sel6 = { true, false, true };
		boolean[] sel7 = { true, true, false };
		boolean[] sel8 = { true, true, true };

		assertArrayEquals(trues, Gate.mux8Way16(trues, falses, falses, falses, falses, falses, falses, falses, sel1));
		assertArrayEquals(trues, Gate.mux8Way16(falses, trues, falses, falses, falses, falses, falses, falses, sel2));
		assertArrayEquals(trues, Gate.mux8Way16(falses, falses, trues, falses, falses, falses, falses, falses, sel3));
		assertArrayEquals(trues, Gate.mux8Way16(falses, falses, falses, trues, falses, falses, falses, falses, sel4));
		assertArrayEquals(trues, Gate.mux8Way16(falses, falses, falses, falses, trues, falses, falses, falses, sel5));
		assertArrayEquals(trues, Gate.mux8Way16(falses, falses, falses, falses, falses, trues, falses, falses, sel6));
		assertArrayEquals(trues, Gate.mux8Way16(falses, falses, falses, falses, falses, falses, trues, falses, sel7));
		assertArrayEquals(trues, Gate.mux8Way16(falses, falses, falses, falses, falses, falses, falses, trues, sel8));
	}

	@Test
	void testDMux4Way() {
		boolean[] trues = {
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
				true,
		};
		boolean[] falses = {
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
				false,
				false,
		};
		boolean[] sel1 = { false, false };
		boolean[] sel2 = { false, true };
		boolean[] sel3 = { true, false };
		boolean[] sel4 = { true, true };
		boolean[][] out1 = { trues, falses, falses, falses };
		boolean[][] out2 = { falses, trues, falses, falses };
		boolean[][] out3 = { falses, falses, trues, falses };
		boolean[][] out4 = { falses, falses, falses, trues };

		assertArrayEquals(out1, Gate.dmux4Way(trues, sel1));
		assertArrayEquals(out2, Gate.dmux4Way(trues, sel2));
		assertArrayEquals(out3, Gate.dmux4Way(trues, sel3));
		assertArrayEquals(out4, Gate.dmux4Way(trues, sel4));
	}

	@Test
	void testDMux8Way() {
		boolean[] trues = {
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
				true,
		};
		boolean[] falses = {
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
				false,
				false,
		};
		boolean[] sel1 = { false, false, false };
		boolean[] sel2 = { false, false, true };
		boolean[] sel3 = { false, true, false };
		boolean[] sel4 = { false, true, true };
		boolean[] sel5 = { true, false, false };
		boolean[] sel6 = { true, false, true };
		boolean[] sel7 = { true, true, false };
		boolean[] sel8 = { true, true, true };
		boolean[][] out1 = { trues, falses, falses, falses, falses, falses, falses, falses };
		boolean[][] out2 = { falses, trues, falses, falses, falses, falses, falses, falses };
		boolean[][] out3 = { falses, falses, trues, falses, falses, falses, falses, falses };
		boolean[][] out4 = { falses, falses, falses, trues, falses, falses, falses, falses };
		boolean[][] out5 = { falses, falses, falses, falses, trues, falses, falses, falses };
		boolean[][] out6 = { falses, falses, falses, falses, falses, trues, falses, falses };
		boolean[][] out7 = { falses, falses, falses, falses, falses, falses, trues, falses };
		boolean[][] out8 = { falses, falses, falses, falses, falses, falses, falses, trues };

		assertArrayEquals(out1, Gate.dmux8Way(trues, sel1));
		assertArrayEquals(out2, Gate.dmux8Way(trues, sel2));
		assertArrayEquals(out3, Gate.dmux8Way(trues, sel3));
		assertArrayEquals(out4, Gate.dmux8Way(trues, sel4));
		assertArrayEquals(out5, Gate.dmux8Way(trues, sel5));
		assertArrayEquals(out6, Gate.dmux8Way(trues, sel6));
		assertArrayEquals(out7, Gate.dmux8Way(trues, sel7));
		assertArrayEquals(out8, Gate.dmux8Way(trues, sel8));
	}
}
