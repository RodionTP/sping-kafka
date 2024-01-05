package org.example.ordercommon.model;

public class OrderEvent {
    private String product;
    private int quantity;

    public OrderEvent() {
    }

    public OrderEvent(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public static OrderEvent fromOrder(Order order) {
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setProduct(order.getProduct());
        orderEvent.setQuantity(order.getQuantity());
        return orderEvent;
    }
}
