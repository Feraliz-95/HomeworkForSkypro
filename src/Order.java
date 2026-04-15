import java.util.Arrays;
import java.util.Objects;

class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }


    public String getCustomer() {
        return customer;
    }

    public Product[] getBasket() {
        return basket;
    }


    @Override
    public String toString() {
        return "Order{customer='" + customer + "', basket=" + Arrays.toString(basket) + "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;


        if (!Objects.equals(customer, order.customer)) return false;


        if (basket == null && order.basket == null) return true;
        if (basket == null || order.basket == null) return false;
        if (basket.length != order.basket.length) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(customer);
        result = 31 * result + Arrays.hashCode(basket);
        return result;

    }
}
