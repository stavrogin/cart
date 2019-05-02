package it.flavio.goods;

import java.math.BigDecimal;
import java.math.RoundingMode;

import it.flavio.cart.constants.Constants;

/**
 * Represents a basic good, subject to regular taxes
 * @author flavio
 */
public class BasicGood extends GoodBase implements Good {

	private static final BigDecimal BASIC_SALES_TAX_PCT = new BigDecimal("0.10");
	
	@Override
	public BigDecimal getTaxedPrice() {
		BigDecimal taxToApply = isImported() ? BASIC_SALES_TAX_PCT.add(Constants.IMPORTED_SALES_TAX_PCT) : BASIC_SALES_TAX_PCT;
		BigDecimal deltaPrice = taxToApply.multiply(getRawPrice()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal taxedPrice = deltaPrice.add(getRawPrice());
		return taxedPrice;
	}

}
