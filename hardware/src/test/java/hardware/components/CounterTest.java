package hardware.components;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import hardware.consts.BitArrayConsts;

public class CounterTest {
	@Test
	void testClock() {
		Counter counter = new Counter();
		counter.reset();
		counter.clock();
		counter.clock();
		assertArrayEquals(BitArrayConsts.false16, counter.read());

		counter.write(BitArrayConsts.true16);
		counter.clock();
		counter.clock();
		assertArrayEquals(BitArrayConsts.true16, counter.read());

		counter.reset();
		counter.clock();
		counter.inc();
		counter.clock();
		assertArrayEquals(BitArrayConsts.false16, counter.read());
		counter.clock();
		assertArrayEquals(BitArrayConsts.one16, counter.read());

	}
}
