package it.flavio.goods;

import java.math.BigDecimal;

import it.flavio.cart.constants.Constants;

/**
 * Represents a tax free good
 * 
 * @author flavio
 */
public class TaxFreeGood extends GoodBase implements Good {

	@Override
	public BigDecimal getSalesTaxes() {
		BigDecimal taxToApply = isImported() ? Constants.IMPORTED_SALES_TAX_PCT : BigDecimal.ZERO;
		BigDecimal deltaPrice = round(BigDecimal.valueOf(getQuantity()).multiply(taxToApply).multiply(getRawPrice()));
		return deltaPrice;
	}

}
