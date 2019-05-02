package it.flavio.goods;

import java.math.BigDecimal;
import java.math.RoundingMode;

import it.flavio.cart.constants.Constants;

/**
 * Represents a tax free good
 * @author flavio
 */
public class TaxFreeGood extends GoodBase implements Good {

	@Override
	public BigDecimal getTaxedPrice() {
		BigDecimal taxedPrice = getSalesTaxes().add(getRawPrice());
		return taxedPrice;
	}

	@Override
	public BigDecimal getSalesTaxes() {
		BigDecimal taxToApply = isImported() ? Constants.IMPORTED_SALES_TAX_PCT : BigDecimal.ZERO;
		BigDecimal deltaPrice = taxToApply.multiply(getRawPrice()).setScale(2, RoundingMode.HALF_UP);
		return deltaPrice;
	}

}
