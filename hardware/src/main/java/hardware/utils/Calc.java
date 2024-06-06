package hardware.utils;

public class Calc {
	public static int convertBoolArrayToDecimal(boolean[] boolArray) {
		int decimal = 0;
		for (int i = 0; i < boolArray.length; i++) {
			if (boolArray[boolArray.length - 1 - i]) {
				decimal += (int) Math.pow(2, i);
			}
		}
		return decimal;
	}
}
