package pl.edu.agh.internetshop.search;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class SearchByPrice implements ISearchStrategy{
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;
    public SearchByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
    @Override
    public boolean filter(Order order) {
        BigDecimal orderPrice = getPrice(order);
        return minPrice.compareTo(orderPrice) <= 0 && orderPrice.compareTo(maxPrice) <= 0;
    }

    public BigDecimal getPrice(Order order) {
        return order.getPrice();
    }
}
