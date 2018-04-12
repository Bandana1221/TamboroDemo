package com.tamborodemo.questionone;

public class HSVModel {

	private int hue;
	private int saturtion;
	private int value;

	/**
	 * @return the hue
	 */
	public int getHue() {
		return hue;
	}

	/**
	 * @param hue
	 *            the hue to set
	 */
	public void setHue(int hue) {
		this.hue = hue;
	}

	/**
	 * @return the saturtion
	 */
	public int getSaturtion() {
		return saturtion;
	}

	/**
	 * @param saturtion
	 *            the saturtion to set
	 */
	public void setSaturtion(int saturtion) {
		this.saturtion = saturtion;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hue;
		result = prime * result + saturtion;
		result = prime * result + value;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HSVModel other = (HSVModel) obj;
		if (hue != other.hue)
			return false;
		if (saturtion != other.saturtion)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HSVModel [hue=" + hue + ", saturtion=" + saturtion + ", value="
				+ value + "]";
	}
}