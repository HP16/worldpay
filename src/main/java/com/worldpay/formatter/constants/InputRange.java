package com.worldpay.formatter.constants;

public enum InputRange {

	MAX_VALUE(999999999), MIN_VALUE(0);

	private int value;

	private InputRange(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
