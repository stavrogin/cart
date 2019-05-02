package it.flavio.goods;

import java.math.BigDecimal;

import it.flavio.cart.constants.Constants.Category;

/**
 * Abstract class to keep the behavior common to all goods
 * @author flavio
 */
public abstract class GoodBase implements Good {

	private Category category;
	private BigDecimal rawPrice;
	private boolean imported;
	
	@Override
	public void setCategory(Category category) {
		this.category = category;
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
	
}
