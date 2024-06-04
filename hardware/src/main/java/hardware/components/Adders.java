package hardware.components;

public class Adders {
	/**
	 * HalfAdder
	 * 
	 * @param a
	 * @param b
	 * @return {carry, sum}
	 */
	public static boolean[] halfAdder(boolean a, boolean b) {
		boolean[] out = {
				Gates.and(a, b),
				Gates.xor(a, b),
		};
		return out;
	}

	/**
	 * FullAdder
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return {carry, sum}
	 */
	public static boolean[] fullAdder(boolean a, boolean b, boolean c) {
		boolean[] halfAdded = halfAdder(a, b);

		boolean[] out = {
				Gates.or(halfAdded[0], Gates.and(halfAdded[1], c)),
				Gates.xor(halfAdded[1], c),
		};
		return out;
	}

	/**
	 * Add16
	 * 
	 * @param a boolean[16]
	 * @param b boolean[16]
	 * @return
	 */
	public static boolean[] add16(boolean[] a, boolean[] b) {
		boolean[] prv = { false, false };
		boolean[] out = {
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
		for (int i = 15; i >= 0; i--) {
			prv = fullAdder(a[i], b[i], prv[0]);
			out[i] = prv[1];
		}

		return out;
	}
}
