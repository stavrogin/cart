package it.flavio.cart.constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Projects constants are defined here
 * 
 * @author flavio
 */
public class Constants {

	public static final BigDecimal IMPORTED_SALES_TAX_PCT = new BigDecimal("0.05");

	public enum Category {
		BOOK(true), FOOD(true), MEDICAL(true), OTHER(false);

		private boolean taxFree;

		private Category(boolean taxFree) {
			this.taxFree = taxFree;
		}

		public boolean isTaxFree() {
			return taxFree;
		}
	};

}
