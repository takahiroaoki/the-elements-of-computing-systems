package hardware;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GatesTest {
	@Test
	void testNand() {
		assertEquals(false, Gates.nand(true, true));
		assertEquals(true, Gates.nand(true, false));
		assertEquals(true, Gates.nand(false, true));
		assertEquals(true, Gates.nand(false, false));
	}

	@Test
	void testNot() {
		assertEquals(false, Gates.not(true));
		assertEquals(true, Gates.not(false));
	}

	@Test
	void testAnd() {
		assertEquals(true, Gates.and(true, true));
		assertEquals(false, Gates.and(true, false));
		assertEquals(false, Gates.and(false, true));
		assertEquals(false, Gates.and(false, false));
	}

	@Test
	void testOr() {
		assertEquals(true, Gates.or(true, true));
		assertEquals(true, Gates.or(true, false));
		assertEquals(true, Gates.or(false, true));
		assertEquals(false, Gates.or(false, false));
	}

	@Test
	void testXor() {
		assertEquals(true, Gates.xor(true, true));
		assertEquals(false, Gates.xor(true, false));
		assertEquals(false, Gates.xor(false, true));
		assertEquals(true, Gates.xor(false, false));
	}

	@Test
	void testMux() {
		assertEquals(false, Gates.mux(false, false, false));
		assertEquals(false, Gates.mux(false, true, false));
		assertEquals(true, Gates.mux(true, false, false));
		assertEquals(true, Gates.mux(true, true, false));
		assertEquals(false, Gates.mux(false, false, true));
		assertEquals(true, Gates.mux(false, true, true));
		assertEquals(false, Gates.mux(true, false, true));
		assertEquals(true, Gates.mux(true, true, true));
	}

	@Test
	void testDmux() {
		boolean[] out1 = { false, true };
		assertArrayEquals(out1, Gates.dmux(true, true));

		boolean[] out2 = { false, false };
		assertArrayEquals(out2, Gates.dmux(false, true));

		boolean[] out3 = { true, false };
		assertArrayEquals(out3, Gates.dmux(true, false));

		boolean[] out4 = { false, false };
		assertArrayEquals(out4, Gates.dmux(false, false));
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
		assertArrayEquals(falses, Gates.not16(trues));
		assertArrayEquals(trues, Gates.not16(falses));
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
		assertArrayEquals(trues, Gates.and16(trues, trues));
		assertArrayEquals(falses, Gates.and16(trues, falses));
		assertArrayEquals(falses, Gates.and16(falses, trues));
		assertArrayEquals(falses, Gates.and16(falses, falses));
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
		assertArrayEquals(trues, Gates.or16(trues, trues));
		assertArrayEquals(trues, Gates.or16(trues, falses));
		assertArrayEquals(trues, Gates.or16(falses, trues));
		assertArrayEquals(falses, Gates.or16(falses, falses));
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
		assertArrayEquals(trues, Gates.mux16(trues, trues, false));
		assertArrayEquals(trues, Gates.mux16(trues, falses, false));
		assertArrayEquals(falses, Gates.mux16(falses, trues, false));
		assertArrayEquals(falses, Gates.mux16(falses, falses, false));
		assertArrayEquals(trues, Gates.mux16(falses, trues, true));
		assertArrayEquals(falses, Gates.mux16(falses, falses, true));
		assertArrayEquals(trues, Gates.mux16(trues, trues, true));
		assertArrayEquals(falses, Gates.mux16(trues, falses, true));
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
		assertEquals(true, Gates.or8Way(trues));
		assertEquals(false, Gates.or8Way(falses));
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

		assertArrayEquals(trues, Gates.mux4Way16(trues, falses, falses, falses, sel1));
		assertArrayEquals(trues, Gates.mux4Way16(falses, trues, falses, falses, sel2));
		assertArrayEquals(trues, Gates.mux4Way16(falses, falses, trues, falses, sel3));
		assertArrayEquals(trues, Gates.mux4Way16(falses, falses, falses, trues, sel4));
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

		assertArrayEquals(trues, Gates.mux8Way16(trues, falses, falses, falses, falses, falses, falses, falses, sel1));
		assertArrayEquals(trues, Gates.mux8Way16(falses, trues, falses, falses, falses, falses, falses, falses, sel2));
		assertArrayEquals(trues, Gates.mux8Way16(falses, falses, trues, falses, falses, falses, falses, falses, sel3));
		assertArrayEquals(trues, Gates.mux8Way16(falses, falses, falses, trues, falses, falses, falses, falses, sel4));
		assertArrayEquals(trues, Gates.mux8Way16(falses, falses, falses, falses, trues, falses, falses, falses, sel5));
		assertArrayEquals(trues, Gates.mux8Way16(falses, falses, falses, falses, falses, trues, falses, falses, sel6));
		assertArrayEquals(trues, Gates.mux8Way16(falses, falses, falses, falses, falses, falses, trues, falses, sel7));
		assertArrayEquals(trues, Gates.mux8Way16(falses, falses, falses, falses, falses, falses, falses, trues, sel8));
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

		assertArrayEquals(out1, Gates.dmux4Way(trues, sel1));
		assertArrayEquals(out2, Gates.dmux4Way(trues, sel2));
		assertArrayEquals(out3, Gates.dmux4Way(trues, sel3));
		assertArrayEquals(out4, Gates.dmux4Way(trues, sel4));
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

		assertArrayEquals(out1, Gates.dmux8Way(trues, sel1));
		assertArrayEquals(out2, Gates.dmux8Way(trues, sel2));
		assertArrayEquals(out3, Gates.dmux8Way(trues, sel3));
		assertArrayEquals(out4, Gates.dmux8Way(trues, sel4));
		assertArrayEquals(out5, Gates.dmux8Way(trues, sel5));
		assertArrayEquals(out6, Gates.dmux8Way(trues, sel6));
		assertArrayEquals(out7, Gates.dmux8Way(trues, sel7));
		assertArrayEquals(out8, Gates.dmux8Way(trues, sel8));
	}
}
