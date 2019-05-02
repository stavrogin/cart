
package it.flavio.goods;

import java.math.BigDecimal;

/**
 * Interface representing a good
 * @author flavio
 */
public interface Good {
	
	/**
	 * Sets the item quantity
	 * @param the item quantity
	 */
	void setQuantity(int quantity);
	
	/**
	 * Sets the item description
	 * @param the item description
	 */
	void setDescription(String description);

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
	
	/**
	 * Gets the sales taxes
	 * @return the sales taxes
	 */
	BigDecimal getSalesTaxes();
	
}
