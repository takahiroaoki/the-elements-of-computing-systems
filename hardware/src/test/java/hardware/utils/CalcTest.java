package hardware.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalcTest {
	@Test
	void testConvertBoolArrayToDecimal() {
		boolean[] in1 = { false, false, false };
		assertEquals(0, Calc.convertBoolArrayToDecimal(in1));

		boolean[] in2 = { false, false, true, false };
		assertEquals(2, Calc.convertBoolArrayToDecimal(in2));

		boolean[] in3 = { true, true, true, true };
		assertEquals(15, Calc.convertBoolArrayToDecimal(in3));
	}
}
