package hardware.components;

import hardware.consts.BitArrayConsts;

public class Gates {
	/**
	 * NAND (base bool gate)
	 * 
	 * @param a
	 * @param b
	 * @return If a=b=1 then return 0 else return 1
	 */
	public static boolean nand(boolean a, boolean b) {
		return !(a && b);
	}

	/**
	 * NOT
	 * 
	 * @param in
	 * @return if in=1 then return 0 else return 1
	 */
	public static boolean not(boolean in) {
		return nand(in, in);
	}

	/**
	 * AND
	 * 
	 * @param a
	 * @param b
	 * @return if a=b=1 then return 1 else return 0
	 */
	public static boolean and(boolean a, boolean b) {
		return !nand(a, b);
	}

	/**
	 * OR
	 * 
	 * @param a
	 * @param b
	 * @return if a=b=0 then return 0 else return 1
	 */
	public static boolean or(boolean a, boolean b) {
		return nand(not(a), not(b));
	}

	/**
	 * XOR
	 * 
	 * @param a
	 * @param b
	 * @return if a!=b then return 1 else return 0
	 */
	public static boolean xor(boolean a, boolean b) {
		return not(or(and(a, b), and(not(a), not(b))));
	}

	/**
	 * Mux
	 * 
	 * @param a
	 * @param b
	 * @param sel
	 * @return if sel=0 then return a else return b
	 */
	public static boolean mux(boolean a, boolean b, boolean sel) {
		return or(and(a, not(sel)), and(b, sel));
	}

	/**
	 * DMux
	 * 
	 * @param in
	 * @param sel
	 * @return if sel=0 then return {in, 0} else return {0, in}
	 */
	public static boolean[] dmux(boolean in, boolean sel) {
		boolean[] out = { and(in, not(sel)), and(in, sel) };
		return out;
	}

	/**
	 * Not16
	 * 
	 * @param in boolean[16]
	 * @return for i=0...15 out[i]=Not(in[i])
	 */
	public static boolean[] not16(boolean[] in) {
		boolean[] out = {
				not(in[0]),
				not(in[1]),
				not(in[2]),
				not(in[3]),
				not(in[4]),
				not(in[5]),
				not(in[6]),
				not(in[7]),
				not(in[8]),
				not(in[9]),
				not(in[10]),
				not(in[11]),
				not(in[12]),
				not(in[13]),
				not(in[14]),
				not(in[15]),
		};
		return out;
	}

	/**
	 * And16
	 * 
	 * @param a boolean[16]
	 * @param b boolean[16]
	 * @return for i=0...15 out[i]=And(a[i], b[i])
	 */
	public static boolean[] and16(boolean[] a, boolean[] b) {
		boolean[] out = {
				and(a[0], b[0]),
				and(a[1], b[1]),
				and(a[2], b[2]),
				and(a[3], b[3]),
				and(a[4], b[4]),
				and(a[5], b[5]),
				and(a[6], b[6]),
				and(a[7], b[7]),
				and(a[8], b[8]),
				and(a[9], b[9]),
				and(a[10], b[10]),
				and(a[11], b[11]),
				and(a[12], b[12]),
				and(a[13], b[13]),
				and(a[14], b[14]),
				and(a[15], b[15]),
		};
		return out;
	}

	/**
	 * Or16
	 * 
	 * @param a boolean[16]
	 * @param b boolean[16]
	 * @return for i=0...15 out[i]=Or(a[i], b[i])
	 */
	public static boolean[] or16(boolean[] a, boolean[] b) {
		boolean[] out = {
				or(a[0], b[0]),
				or(a[1], b[1]),
				or(a[2], b[2]),
				or(a[3], b[3]),
				or(a[4], b[4]),
				or(a[5], b[5]),
				or(a[6], b[6]),
				or(a[7], b[7]),
				or(a[8], b[8]),
				or(a[9], b[9]),
				or(a[10], b[10]),
				or(a[11], b[11]),
				or(a[12], b[12]),
				or(a[13], b[13]),
				or(a[14], b[14]),
				or(a[15], b[15]),
		};
		return out;
	}

	/**
	 * Mux16
	 * 
	 * @param a   boolean[16]
	 * @param b   boolean[16]
	 * @param sel
	 * @return if sel=0 then return a else return b
	 */
	public static boolean[] mux16(boolean[] a, boolean[] b, boolean sel) {
		boolean[] out = {
				mux(a[0], b[0], sel),
				mux(a[1], b[1], sel),
				mux(a[2], b[2], sel),
				mux(a[3], b[3], sel),
				mux(a[4], b[4], sel),
				mux(a[5], b[5], sel),
				mux(a[6], b[6], sel),
				mux(a[7], b[7], sel),
				mux(a[8], b[8], sel),
				mux(a[9], b[9], sel),
				mux(a[10], b[10], sel),
				mux(a[11], b[11], sel),
				mux(a[12], b[12], sel),
				mux(a[13], b[13], sel),
				mux(a[14], b[14], sel),
				mux(a[15], b[15], sel),
		};
		return out;
	}

	/**
	 * Or8Way
	 * 
	 * @param in boolean[8]
	 * @return return Or(in[0],...in[7])
	 */
	public static boolean or8Way(boolean[] in) {
		return or(in[0],
				or(in[1],
						or(in[2],
								or(in[3],
										or(in[4],
												or(in[5],
														or(in[6],
																or(in[7], in[8]))))))));
	}

	/**
	 * Mux4Way16
	 * 
	 * @param a   boolean[16]
	 * @param b   boolean[16]
	 * @param c   boolean[16]
	 * @param d   boolean[16]
	 * @param sel boolean[2]
	 * @return if sel={false,false} return a
	 *         else if sel={false,true} return b
	 *         else if sel={true,false} return c
	 *         else if sel={true,true} return d
	 */
	public static boolean[] mux4Way16(
			boolean[] a,
			boolean[] b,
			boolean[] c,
			boolean[] d,
			boolean[] sel) {
		return mux16(mux16(a, b, sel[1]), mux16(c, d, sel[1]), sel[0]);
	}

	/**
	 * Mux8Way16
	 * 
	 * @param a   boolean[16]
	 * @param b   boolean[16]
	 * @param c   boolean[16]
	 * @param d   boolean[16]
	 * @param e   boolean[16]
	 * @param f   boolean[16]
	 * @param g   boolean[16]
	 * @param h   boolean[16]
	 * @param sel boolean[3]
	 * @return if sel={false,false,false} return a
	 *         else if sel={false,false,true} return b
	 *         else if sel={false,true,false} return c
	 *         else if sel={false,true,true} return d
	 *         else if sel={true,false,false} return e
	 *         else if sel={true,false,true} return f
	 *         else if sel={true,true,false} return g
	 *         else if sel={true,true,true} return h
	 */
	public static boolean[] mux8Way16(
			boolean[] a,
			boolean[] b,
			boolean[] c,
			boolean[] d,
			boolean[] e,
			boolean[] f,
			boolean[] g,
			boolean[] h,
			boolean[] sel) {

		boolean[] selRest = { sel[1], sel[2] };
		return mux16(
				mux4Way16(a, b, c, d, selRest),
				mux4Way16(e, f, g, h, selRest),
				sel[0]);
	}

	/**
	 * DMux4Way
	 * 
	 * @param in  boolean[16]
	 * @param sel boolean[2]
	 * @return if sel={false,false} return {in, falses, falses, falses}
	 *         else if sel={false,true} return {falses, in, falses, falses}
	 *         else if sel={true,false} return {falses, falses, in, falses}
	 *         else if sel={true,true} return {falses, falses, falses, in}
	 */
	public static boolean[][] dmux4Way(boolean[] in, boolean[] sel) {
		boolean[][] out = {
				mux16(BitArrayConsts.false16, in, and(not(sel[0]), not(sel[1]))),
				mux16(BitArrayConsts.false16, in, and(not(sel[0]), sel[1])),
				mux16(BitArrayConsts.false16, in, and(sel[0], not(sel[1]))),
				mux16(BitArrayConsts.false16, in, and(sel[0], sel[1])),
		};
		return out;
	}

	/**
	 * DMux8Way
	 * 
	 * @param in  boolean[16]
	 * @param sel boolean[3]
	 * @return if sel={false,false,false} return {in, falses, falses, falses, false,
	 *         falses, falses, falses}
	 *         else if sel={false,false,true} return {falses, in, falses, falses,
	 *         false, falses, falses, falses}
	 *         else if sel={false,true,false} return {falses, falses, in, falses,
	 *         false, falses, falses, falses}
	 *         else if sel={false,true,true} return {falses, falses, falses, in,
	 *         false, falses, falses, falses}
	 *         else if sel={true,true,false} return {falses, falses, falses, falses,
	 *         in, falses, falses, falses}
	 *         else if sel={true,true,true} return {falses, falses, falses, falses,
	 *         false, in, falses, falses}
	 *         else if sel={true,true,true} return {falses, falses, falses, falses,
	 *         false, falses, in, falses}
	 *         else if sel={true,true,true} return {falses, falses, falses, falses,
	 *         false, falses, falses, in}
	 */
	public static boolean[][] dmux8Way(boolean[] in, boolean[] sel) {
		boolean[][] out = {
				mux16(BitArrayConsts.false16, in, and(not(sel[0]), and(not(sel[1]), not(sel[2])))),
				mux16(BitArrayConsts.false16, in, and(not(sel[0]), and(not(sel[1]), sel[2]))),
				mux16(BitArrayConsts.false16, in, and(not(sel[0]), and(sel[1], not(sel[2])))),
				mux16(BitArrayConsts.false16, in, and(not(sel[0]), and(sel[1], sel[2]))),
				mux16(BitArrayConsts.false16, in, and(sel[0], and(not(sel[1]), not(sel[2])))),
				mux16(BitArrayConsts.false16, in, and(sel[0], and(not(sel[1]), sel[2]))),
				mux16(BitArrayConsts.false16, in, and(sel[0], and(sel[1], not(sel[2])))),
				mux16(BitArrayConsts.false16, in, and(sel[0], and(sel[1], sel[2]))),
		};
		return out;
	}
}
