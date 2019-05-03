package it.flavio.goods;

import java.math.BigDecimal;

import it.flavio.cart.constants.Constants;

/**
 * Represents a basic good, subject to regular taxes
 * @author flavio
 */
public class BasicGood extends GoodBase implements Good {

	private static final BigDecimal BASIC_SALES_TAX_PCT = BigDecimal.valueOf(0.10);
	
	@Override
	public BigDecimal getTaxedPrice() {
		BigDecimal taxedPrice = getSalesTaxes().add(getRawPrice());
		return taxedPrice;
	}

	@Override
	public BigDecimal getSalesTaxes() {
		BigDecimal taxToApply = isImported() ? BASIC_SALES_TAX_PCT.add(Constants.IMPORTED_SALES_TAX_PCT) : BASIC_SALES_TAX_PCT;
		BigDecimal deltaPrice = round(BigDecimal.valueOf(getQuantity()).multiply(taxToApply).multiply(getRawPrice()));
		return deltaPrice;
	}

}
