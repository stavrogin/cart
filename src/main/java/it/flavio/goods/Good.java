package it.flavio.goods;

import java.math.BigDecimal;

import it.flavio.cart.constants.Constants.Category;

/**
 * Interface representing a good
 * @author flavio
 */
public interface Good {

	/**
	 * Sets the category (e.g.: medical)
	 * @param category the good category
	 */
	void setCategory(Category category);
	
	/**
	 * Sets the imported flag
	 * @param true if the good has been imported; false otherwise
	 */
	void setImported(boolean imported);
	
	/**
	 * Sets the tax-free price
	 * @param rawPrice the tax-free price
	 */
	void setRawPrice(BigDecimal rawPrice);
	
	/**
	 * Gets the taxed price
	 * @return the taxed price
	 */
	BigDecimal getTaxedPrice();
	
}
