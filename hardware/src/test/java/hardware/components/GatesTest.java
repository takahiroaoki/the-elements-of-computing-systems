package hardware.components;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import hardware.consts.BitArrayConsts;

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
		assertEquals(false, Gates.xor(true, true));
		assertEquals(true, Gates.xor(true, false));
		assertEquals(true, Gates.xor(false, true));
		assertEquals(false, Gates.xor(false, false));
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
		assertArrayEquals(BitArrayConsts.false16, Gates.not16(BitArrayConsts.true16));
		assertArrayEquals(BitArrayConsts.true16, Gates.not16(BitArrayConsts.false16));
	}

	@Test
	void testAnd16() {
		assertArrayEquals(BitArrayConsts.true16, Gates.and16(BitArrayConsts.true16, BitArrayConsts.true16));
		assertArrayEquals(BitArrayConsts.false16, Gates.and16(BitArrayConsts.true16, BitArrayConsts.false16));
		assertArrayEquals(BitArrayConsts.false16, Gates.and16(BitArrayConsts.false16, BitArrayConsts.true16));
		assertArrayEquals(BitArrayConsts.false16, Gates.and16(BitArrayConsts.false16, BitArrayConsts.false16));
	}

	@Test
	void testOr16() {
		assertArrayEquals(BitArrayConsts.true16, Gates.or16(BitArrayConsts.true16, BitArrayConsts.true16));
		assertArrayEquals(BitArrayConsts.true16, Gates.or16(BitArrayConsts.true16, BitArrayConsts.false16));
		assertArrayEquals(BitArrayConsts.true16, Gates.or16(BitArrayConsts.false16, BitArrayConsts.true16));
		assertArrayEquals(BitArrayConsts.false16, Gates.or16(BitArrayConsts.false16, BitArrayConsts.false16));
	}

	@Test
	void testMux16() {
		assertArrayEquals(BitArrayConsts.true16, Gates.mux16(BitArrayConsts.true16, BitArrayConsts.true16, false));
		assertArrayEquals(BitArrayConsts.true16, Gates.mux16(BitArrayConsts.true16, BitArrayConsts.false16, false));
		assertArrayEquals(BitArrayConsts.false16, Gates.mux16(BitArrayConsts.false16, BitArrayConsts.true16, false));
		assertArrayEquals(BitArrayConsts.false16, Gates.mux16(BitArrayConsts.false16, BitArrayConsts.false16, false));
		assertArrayEquals(BitArrayConsts.true16, Gates.mux16(BitArrayConsts.false16, BitArrayConsts.true16, true));
		assertArrayEquals(BitArrayConsts.false16, Gates.mux16(BitArrayConsts.false16, BitArrayConsts.false16, true));
		assertArrayEquals(BitArrayConsts.true16, Gates.mux16(BitArrayConsts.true16, BitArrayConsts.true16, true));
		assertArrayEquals(BitArrayConsts.false16, Gates.mux16(BitArrayConsts.true16, BitArrayConsts.false16, true));
	}

	@Test
	void testOr8Way() {
		assertEquals(true, Gates.or8Way(BitArrayConsts.true16));
		assertEquals(false, Gates.or8Way(BitArrayConsts.false16));
	}

	@Test
	void testMux4Way16() {
		boolean[] sel1 = { false, false };
		boolean[] sel2 = { false, true };
		boolean[] sel3 = { true, false };
		boolean[] sel4 = { true, true };

		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux4Way16(BitArrayConsts.true16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, sel1));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux4Way16(BitArrayConsts.false16, BitArrayConsts.true16, BitArrayConsts.false16,
						BitArrayConsts.false16, sel2));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux4Way16(BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.true16,
						BitArrayConsts.false16, sel3));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux4Way16(BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.true16, sel4));
	}

	@Test
	void testMux8Way16() {
		boolean[] sel1 = { false, false, false };
		boolean[] sel2 = { false, false, true };
		boolean[] sel3 = { false, true, false };
		boolean[] sel4 = { false, true, true };
		boolean[] sel5 = { true, false, false };
		boolean[] sel6 = { true, false, true };
		boolean[] sel7 = { true, true, false };
		boolean[] sel8 = { true, true, true };

		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux8Way16(BitArrayConsts.true16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, sel1));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux8Way16(BitArrayConsts.false16, BitArrayConsts.true16, BitArrayConsts.false16,
						BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, sel2));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux8Way16(BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.true16,
						BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, sel3));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux8Way16(BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.true16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, sel4));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux8Way16(BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, BitArrayConsts.true16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, sel5));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux8Way16(BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.true16, BitArrayConsts.false16,
						BitArrayConsts.false16, sel6));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux8Way16(BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.true16,
						BitArrayConsts.false16, sel7));
		assertArrayEquals(BitArrayConsts.true16,
				Gates.mux8Way16(BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
						BitArrayConsts.true16, sel8));
	}

	@Test
	void testDMux4Way() {
		boolean[] sel1 = { false, false };
		boolean[] sel2 = { false, true };
		boolean[] sel3 = { true, false };
		boolean[] sel4 = { true, true };
		boolean[][] out1 = { BitArrayConsts.true16, BitArrayConsts.false16, BitArrayConsts.false16,
				BitArrayConsts.false16 };
		boolean[][] out2 = { BitArrayConsts.false16, BitArrayConsts.true16, BitArrayConsts.false16,
				BitArrayConsts.false16 };
		boolean[][] out3 = { BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.true16,
				BitArrayConsts.false16 };
		boolean[][] out4 = { BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
				BitArrayConsts.true16 };

		assertArrayEquals(out1, Gates.dmux4Way(BitArrayConsts.true16, sel1));
		assertArrayEquals(out2, Gates.dmux4Way(BitArrayConsts.true16, sel2));
		assertArrayEquals(out3, Gates.dmux4Way(BitArrayConsts.true16, sel3));
		assertArrayEquals(out4, Gates.dmux4Way(BitArrayConsts.true16, sel4));
	}

	@Test
	void testDMux8Way() {
		boolean[] sel1 = { false, false, false };
		boolean[] sel2 = { false, false, true };
		boolean[] sel3 = { false, true, false };
		boolean[] sel4 = { false, true, true };
		boolean[] sel5 = { true, false, false };
		boolean[] sel6 = { true, false, true };
		boolean[] sel7 = { true, true, false };
		boolean[] sel8 = { true, true, true };
		boolean[][] out1 = { BitArrayConsts.true16, BitArrayConsts.false16, BitArrayConsts.false16,
				BitArrayConsts.false16,
				BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16 };
		boolean[][] out2 = { BitArrayConsts.false16, BitArrayConsts.true16, BitArrayConsts.false16,
				BitArrayConsts.false16,
				BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16 };
		boolean[][] out3 = { BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.true16,
				BitArrayConsts.false16,
				BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16 };
		boolean[][] out4 = { BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
				BitArrayConsts.true16,
				BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16 };
		boolean[][] out5 = { BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
				BitArrayConsts.false16,
				BitArrayConsts.true16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16 };
		boolean[][] out6 = { BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
				BitArrayConsts.false16,
				BitArrayConsts.false16, BitArrayConsts.true16, BitArrayConsts.false16, BitArrayConsts.false16 };
		boolean[][] out7 = { BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
				BitArrayConsts.false16,
				BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.true16, BitArrayConsts.false16 };
		boolean[][] out8 = { BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16,
				BitArrayConsts.false16,
				BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.false16, BitArrayConsts.true16 };

		assertArrayEquals(out1, Gates.dmux8Way(BitArrayConsts.true16, sel1));
		assertArrayEquals(out2, Gates.dmux8Way(BitArrayConsts.true16, sel2));
		assertArrayEquals(out3, Gates.dmux8Way(BitArrayConsts.true16, sel3));
		assertArrayEquals(out4, Gates.dmux8Way(BitArrayConsts.true16, sel4));
		assertArrayEquals(out5, Gates.dmux8Way(BitArrayConsts.true16, sel5));
		assertArrayEquals(out6, Gates.dmux8Way(BitArrayConsts.true16, sel6));
		assertArrayEquals(out7, Gates.dmux8Way(BitArrayConsts.true16, sel7));
		assertArrayEquals(out8, Gates.dmux8Way(BitArrayConsts.true16, sel8));
	}
}
