package it.flavio.goods;

import java.math.BigDecimal;

import it.flavio.cart.constants.Constants.Category;

/**
 * Factory to get goods to be taxed depending on the category
 * @author flavio
 */
public class GoodFactory {

	/**
	 * Get filled good by passed-in parameters
	 * @param category the category
	 * @param imported flag to tell if the good has been imported or not
	 * @param rawPrice the tax-free price
	 * @return the correct good implementation
	 */
	public static Good getGood(Category category, boolean imported, BigDecimal rawPrice) {
		Good good = getGoodByCategory(category);
		good.setImported(imported);
		good.setRawPrice(rawPrice);
		good.setCategory(category);
		return good;
	}
	
	/**
	 * Gets an empty good by category
	 * @param category
	 * @return
	 */
	private static Good getGoodByCategory(Category category) {
		if (category.isTaxFree()) {
			return new TaxFreeGood();
		} 
		return new BasicGood();
	}
	
}
