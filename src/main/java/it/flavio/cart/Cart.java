package it.flavio.cart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import it.flavio.goods.Good;

/**
 * Class representing a cart to check out
 * @author flavio
 */
public class Cart {
	
	private List<Good> goods;
	private BigDecimal salesTaxes;
	private BigDecimal total;

	public Cart(List<Good> goods) {
		this.goods = goods;
	}
	
	/**
	 * Processes the cart by calculating sales taxes and totals
	 */
	public void processCart() {
		salesTaxes = BigDecimal.ZERO;
		total = BigDecimal.ZERO;
		for (Good g : goods) {
			salesTaxes = salesTaxes.add(g.getSalesTaxes());
			total = total.add(g.getTaxedPrice());
		}
		salesTaxes = salesTaxes.setScale(2, RoundingMode.HALF_UP);
		total = total.setScale(2, RoundingMode.HALF_UP);
	}
	
	/**
	 * Writes the cart output
	 */
	public void writeOutput() {
		goods.forEach(g -> System.out.println(g));
		System.out.println("Sales Taxes: " + salesTaxes);
		System.out.println("Total: " + total);
		System.out.println();
	}

	public BigDecimal getSalesTaxes() {
		return salesTaxes;
	}

	public BigDecimal getTotal() {
		return total;
	}
	
}
