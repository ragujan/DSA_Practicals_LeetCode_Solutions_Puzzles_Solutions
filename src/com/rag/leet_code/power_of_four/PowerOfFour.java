package com.rag.leet_code.power_of_four;

public class PowerOfFour {
	public static void main(String[] args) {
		int x = 64;
		System.out.println(doThis(64));
	}

	public static boolean doThis(int x) {
		if (x % 4 == 0) {
			System.out.println("ok ");
			int xxx = x / 4;
			if (xxx % 4 == 0) {
				doThis(xxx);
			} else {
				return false;
			}
		} else {
			return false;
		}
		return false;
	}
}
