package it.flavio.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
		goods.add(GoodFactory.getGood(Category.BOOK, false, new BigDecimal("12.49"), "book"));
		goods.add(GoodFactory.getGood(Category.OTHER, false, new BigDecimal("14.99"), "music CD"));
		goods.add(GoodFactory.getGood(Category.FOOD, false, new BigDecimal("0.85"), "chocolate bar"));
		
		Cart cart = new Cart(goods);
		cart.processCart();
		cart.writeOutput();
	}
	
	@Test
	public void evaluateInput2() {
		goods.add(GoodFactory.getGood(Category.FOOD, true, new BigDecimal("10.00"), "box of chocolates"));
		goods.add(GoodFactory.getGood(Category.OTHER, true, new BigDecimal("47.50"), "bottle of perfume"));
		
		Cart cart = new Cart(goods);
		cart.processCart();
		cart.writeOutput();
	}
	
	@Test
	public void evaluateInput3() {
		goods.add(GoodFactory.getGood(Category.OTHER, true, new BigDecimal("27.99"), "bottle of perfume"));
		goods.add(GoodFactory.getGood(Category.OTHER, false, new BigDecimal("18.99"), "bottle of perfume"));
		goods.add(GoodFactory.getGood(Category.MEDICAL, false, new BigDecimal("9.85"), "headache pills"));
		goods.add(GoodFactory.getGood(Category.FOOD, true, new BigDecimal("11.25"), "chocolates"));
		
		Cart cart = new Cart(goods);
		cart.processCart();
		cart.writeOutput();
	}
	
}
