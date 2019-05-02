package it.flavio.goods;

import java.math.BigDecimal;

/**
 * Abstract class to keep the behavior common to all goods
 * @author flavio
 */
public abstract class GoodBase implements Good {

	private String description;
	private BigDecimal rawPrice;
	private boolean imported;
	
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
	 * Gets the description
	 * @return
	 */
	protected String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("1");
		if (imported) {
			sb.append(" imported");
		}
		sb.append(" ").append(description).append(": ").append(getTaxedPrice());
		return sb.toString();
	}
	
}
