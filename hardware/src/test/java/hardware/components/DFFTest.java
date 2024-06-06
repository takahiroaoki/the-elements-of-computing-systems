package hardware.components;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DFFTest {
	@Test
	void testClock() {
		DFF dff = new DFF();

		dff.clock(true);
		assertFalse(dff.read());

		dff.clock(false);
		assertTrue(dff.read());

		dff.clock(false);
		assertFalse(dff.read());

		dff.clock(true);
		assertFalse(dff.read());
	}
}
