package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.OrderHistory;
import pl.edu.agh.internetshop.Product;
import pl.edu.agh.internetshop.User;
import pl.edu.agh.internetshop.search.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    @Test
    public void testSearchBySurname() {
        //given
        Product product1 = new Product("p1", BigDecimal.valueOf(17.76), BigDecimal.valueOf(0));
        Product product2 = new Product("p2", BigDecimal.valueOf(0.02), BigDecimal.valueOf(0));

        User person1 = new User("George", "Washington");
        User person2 = new User("King", "of the United Kingdom");

        OrderHistory orderHistory = new OrderHistory();
        Order order1 = new Order(Arrays.asList(product1, product1, product2), BigDecimal.valueOf(0), person1);
        Order order2 = new Order(product1, BigDecimal.valueOf(0), person1);

        orderHistory.addOrder(new Order(product2, BigDecimal.valueOf(0)));
        orderHistory.addOrder(new Order(product2, BigDecimal.valueOf(0), person2));
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        // when
        ISearchStrategy searchStrategy = new SearchBySurname("Washington");
        Filter filter = new Filter(orderHistory, searchStrategy);

        // then
        List<Order> result = filter.filterOrders();

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

    @Test
    public void testSearchByProductName() {
        //given
        Product whiskey = new Product("Whiskey", BigDecimal.valueOf(17.76), BigDecimal.valueOf(0));
        Product beer = new Product("Beer", BigDecimal.valueOf(0.27), BigDecimal.valueOf(0));
        Product liquor = new Product("Liquor", BigDecimal.valueOf(1.22), BigDecimal.valueOf(0));

        OrderHistory orderHistory = new OrderHistory();
        Order order1 = new Order(Arrays.asList(liquor, beer, whiskey, liquor), BigDecimal.valueOf(0));
        Order order2 = new Order(liquor, BigDecimal.valueOf(0));

        orderHistory.addOrder(new Order(beer, BigDecimal.valueOf(0)));
        orderHistory.addOrder(new Order(Arrays.asList(whiskey, beer, beer), BigDecimal.valueOf(0)));
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        // when
        ISearchStrategy searchStrategy = new SearchByProductName("liquor");
        Filter filter = new Filter(orderHistory, searchStrategy);

        // then
        List<Order> result = filter.filterOrders();

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

    @Test
    public void testSearchByPrice() {
        //given
        Product whiskey = new Product("Whiskey", BigDecimal.valueOf(17.76), BigDecimal.valueOf(0));
        Product beer = new Product("Beer", BigDecimal.valueOf(0.27), BigDecimal.valueOf(0));
        Product liquor = new Product("Liquor", BigDecimal.valueOf(1.22), BigDecimal.valueOf(0));

        OrderHistory orderHistory = new OrderHistory();
        Order order1 = new Order(Arrays.asList(liquor, liquor, liquor), BigDecimal.valueOf(0));
        Order order2 = new Order(whiskey, BigDecimal.valueOf(0));

        orderHistory.addOrder(new Order(beer, BigDecimal.valueOf(0)));
        orderHistory.addOrder(new Order(Arrays.asList(whiskey, whiskey), BigDecimal.valueOf(0)));
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        // when
        ISearchStrategy searchStrategy = new SearchByPrice(
                BigDecimal.valueOf(3.65), BigDecimal.valueOf(17.80));
        Filter filter = new Filter(orderHistory, searchStrategy);

        // then
        List<Order> result = filter.filterOrders();

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

}
