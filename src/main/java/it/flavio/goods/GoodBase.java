package it.flavio.goods;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract class to keep the behavior common to all goods
 * @author flavio
 */
public abstract class GoodBase implements Good {
	
	private static final BigDecimal ROUND_INCREMENT = new BigDecimal("0.05");

	private String description;
	private BigDecimal rawPrice;
	private boolean imported;
	private int quantity;

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setRawPrice(BigDecimal rawPrice) {
		this.rawPrice = rawPrice;
	}
	
	@Override
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	
	/**
	 * Gets the raw price
	 * @return the raw price
	 */
	protected BigDecimal getRawPrice() {
		return rawPrice;
	}
	
	/**
	 * Get the imported flag
	 * @return true if the good has been imported; false otherwise
	 */
	protected boolean isImported() {
		return imported;
	}
	
	/**
	 * Get the quantity
	 * @return the item quantity
	 */
	protected int getQuantity() {
		return quantity;
	}
	
	/**
	 * Gets the description
	 * @return
	 */
	protected String getDescription() {
		return description;
	}

	/**
	 * Rounds up to the nearest 0.05
	 * @param value the value to round
	 * @return the rounded value
	 */
	public BigDecimal round(BigDecimal value) {
		BigDecimal divided = value.divide(ROUND_INCREMENT, 0, RoundingMode.UP);
		BigDecimal result = divided.multiply(ROUND_INCREMENT);
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getQuantity());
		if (imported) {
			sb.append(" imported");
		}
		sb.append(" ").append(description).append(": ").append(getTaxedPrice());
		return sb.toString();
	}
	
}
