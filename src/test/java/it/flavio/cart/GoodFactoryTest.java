package it.flavio.cart;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import it.flavio.cart.constants.Constants.Category;
import it.flavio.goods.BasicGood;
import it.flavio.goods.Good;
import it.flavio.goods.GoodFactory;
import it.flavio.goods.TaxFreeGood;

public class GoodFactoryTest {

	@Test
	public void evaluateBasicGoods() {
		Good good = GoodFactory.getGood(Category.OTHER, true, BigDecimal.ZERO, null, 1);
		Assert.assertTrue(good instanceof BasicGood);
	}
	
	@Test
	public void evaluateTaxFreeGoods() {
		Good good = GoodFactory.getGood(Category.BOOK, true, BigDecimal.ZERO, null, 1);
		Assert.assertTrue(good instanceof TaxFreeGood);
		
		good = GoodFactory.getGood(Category.FOOD, true, BigDecimal.ZERO, null, 1);
		Assert.assertTrue(good instanceof TaxFreeGood);
		
		good = GoodFactory.getGood(Category.MEDICAL, true, BigDecimal.ZERO, null, 1);
		Assert.assertTrue(good instanceof TaxFreeGood);
	}
	
}
