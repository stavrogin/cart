package it.flavio.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.flavio.cart.constants.Constants.Category;
import it.flavio.goods.Good;
import it.flavio.goods.GoodFactory;

public class CartTest {
	
	private List<Good> goods;
	
	@Before
	public void setUp() {
		goods = new ArrayList<>();
	}

	@Test
	public void evaluateInput1() {
		Good good1 = GoodFactory.getGood(Category.BOOK, false, BigDecimal.valueOf(12.49), "book", 1);
		Good good2 = GoodFactory.getGood(Category.OTHER, false, BigDecimal.valueOf(14.99), "music CD", 1);
		Good good3 = GoodFactory.getGood(Category.FOOD, false, BigDecimal.valueOf(0.85), "chocolate bar", 1);

		goods.add(good1);
		goods.add(good2);
		goods.add(good3);
		
		Cart cart = new Cart(goods);
		cart.processCart();
		cart.writeOutput();
		
		Assert.assertTrue(good1.getTaxedPrice().compareTo(BigDecimal.valueOf(12.49)) == 0);
		Assert.assertTrue(good2.getTaxedPrice().compareTo(BigDecimal.valueOf(16.49)) == 0);
		Assert.assertTrue(good3.getTaxedPrice().compareTo(BigDecimal.valueOf(0.85)) == 0);

		Assert.assertTrue(cart.getSalesTaxes().compareTo(BigDecimal.valueOf(1.50)) == 0);
		Assert.assertTrue(cart.getTotal().compareTo(BigDecimal.valueOf(29.83)) == 0);
	}
	
	@Test
	public void evaluateInput2() {
		Good good1 = GoodFactory.getGood(Category.FOOD, true, BigDecimal.valueOf(10.00), "box of chocolates", 1);
		Good good2 = GoodFactory.getGood(Category.OTHER, true, BigDecimal.valueOf(47.50), "bottle of perfume", 1);
		
		goods.add(good1);
		goods.add(good2);
		
		Cart cart = new Cart(goods);
		cart.processCart();
		cart.writeOutput();
		
		Assert.assertTrue(good1.getTaxedPrice().compareTo(BigDecimal.valueOf(10.50)) == 0);
		Assert.assertTrue(good2.getTaxedPrice().compareTo(BigDecimal.valueOf(54.65)) == 0);
		
		Assert.assertTrue(cart.getSalesTaxes().compareTo(BigDecimal.valueOf(7.65)) == 0);
		Assert.assertTrue(cart.getTotal().compareTo(BigDecimal.valueOf(65.15)) == 0);
	}
	
	@Test
	public void evaluateInput3() {
		Good good1 = GoodFactory.getGood(Category.OTHER, true, BigDecimal.valueOf(27.99), "bottle of perfume", 1);
		Good good2 = GoodFactory.getGood(Category.OTHER, false, BigDecimal.valueOf(18.99), "bottle of perfume", 1);
		Good good3 = GoodFactory.getGood(Category.MEDICAL, false, BigDecimal.valueOf(9.75), "headache pills", 1);
		Good good4 = GoodFactory.getGood(Category.FOOD, true, BigDecimal.valueOf(11.25), "chocolates", 1);
		
		goods.add(good1);
		goods.add(good2);
		goods.add(good3);
		goods.add(good4);
		
		Cart cart = new Cart(goods);
		cart.processCart();
		cart.writeOutput();
		
		Assert.assertTrue(good1.getTaxedPrice().compareTo(BigDecimal.valueOf(32.19)) == 0);
		Assert.assertTrue(good2.getTaxedPrice().compareTo(BigDecimal.valueOf(20.89)) == 0);
		Assert.assertTrue(good3.getTaxedPrice().compareTo(BigDecimal.valueOf(9.75)) == 0);
		Assert.assertTrue(good4.getTaxedPrice().compareTo(BigDecimal.valueOf(11.85)) == 0);
		
		Assert.assertTrue(cart.getSalesTaxes().compareTo(BigDecimal.valueOf(6.70)) == 0);
		Assert.assertTrue(cart.getTotal().compareTo(BigDecimal.valueOf(74.68)) == 0);
	}
	
}
