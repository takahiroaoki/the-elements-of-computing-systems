package hardware.components;

import hardware.consts.BitArrayConsts;

public class ArithmeticLogicalUnit {
	public class Input {
		public boolean[] x;// 16bits
		public boolean[] y;// 16bits
		public boolean zx;
		public boolean nx;
		public boolean zy;
		public boolean ny;
		public boolean f;
		public boolean no;

		public Input(boolean[] x, boolean[] y, boolean zx, boolean nx, boolean zy, boolean ny, boolean f, boolean no) {
			this.x = x;
			this.y = y;
			this.zx = zx;
			this.nx = nx;
			this.zy = zy;
			this.ny = ny;
			this.f = f;
			this.no = no;
		}
	}

	public class Output {
		public boolean[] out;// 16bits
		public boolean zr;
		public boolean ng;

		Output(boolean[] out, boolean zr, boolean ng) {
			this.out = out;
			this.zr = zr;
			this.ng = ng;
		}
	}

	public static Output calc(Input in) {
		if (in.zx) {
			in.x = BitArrayConsts.false16;
		}

		if (in.nx) {
			in.x = inverseBits(in.x);
		}

		if (in.zy) {
			in.y = BitArrayConsts.false16;
		}
		if (in.ny) {
			in.y = inverseBits(in.y);
		}

		boolean[] out = new boolean[16];
		if (in.f) {
			out = Adders.add16(in.x, in.y);
		} else {
			for (int i = 0; i < in.x.length; i++) {
				out[i] = Gates.and(in.x[i], in.y[i]);
			}
		}

		if (in.no) {
			out = inverseBits(out);
		}

		Output output = new ArithmeticLogicalUnit().new Output(
				out,
				isZero(out),
				isNegative(out));

		return output;
	}

	/**
	 * Inverse all bits
	 * 
	 * @param in
	 * @return
	 */
	private static boolean[] inverseBits(boolean[] in) {
		for (int i = 0; i < in.length; i++) {
			in[i] = Adders.halfAdder(in[i], true)[1];
		}
		return in;
	}

	/**
	 * Judge wether the input is zero.
	 * 
	 * @param in
	 * @return
	 */
	private static boolean isZero(boolean[] in) {
		for (boolean bit : in) {
			if (bit) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Judge wether the input is negative.
	 * 
	 * @param in
	 * @return
	 */
	private static boolean isNegative(boolean[] in) {
		return in[0];
	}
}
