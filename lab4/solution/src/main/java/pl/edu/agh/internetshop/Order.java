package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23);
    private BigDecimal discount;
	private final UUID id;
    private final List<Product> products;
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;
    private User user;

    public Order(Product product, BigDecimal discount) {
        this.products = new ArrayList<>();
        this.products.add(product);
        id = UUID.randomUUID();
        paid = false;
        this.discount = discount;
    }

    public Order(List<Product> products, BigDecimal discount) {
        this.products = products;
        id = UUID.randomUUID();
        paid = false;
        this.discount = discount;
    }

    public Order(Product product, BigDecimal discount, User user) {
        this.products = new ArrayList<>();
        this.products.add(product);
        id = UUID.randomUUID();
        paid = false;
        this.discount = discount;
        this.user = user;
    }

    public Order(List<Product> products, BigDecimal discount, User user) {
        this.products = products;
        id = UUID.randomUUID();
        paid = false;
        this.discount = discount;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Shipment getShipment() {
        return shipment;
    }


    public BigDecimal getPrice() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : this.products) {
            sum = sum.add(product.getPrice());
        }
        return sum.subtract(sum.multiply(discount));
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public User getCustomer(){
        return this.user;
    }
}
