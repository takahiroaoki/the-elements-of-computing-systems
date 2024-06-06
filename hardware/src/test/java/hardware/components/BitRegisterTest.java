package hardware.components;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BitRegisterTest {
	@Test
	void testClock() {
		BitRegister reg = new BitRegister();
		reg.write(true);
		reg.clock();
		assertFalse(reg.read());

		reg.write(false);
		reg.clock();
		assertTrue(reg.read());

		reg.clock();
		assertFalse(reg.read());

		reg.clock();
		// assertFalse(reg.read());
	}
}
