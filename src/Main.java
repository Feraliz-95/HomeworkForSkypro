
public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        Product product1 = new Product(1, "Монитор", 25000, "Мониторы");
        System.out.println(product1);
        Product product2 = new Product(2, "Умная колонка", 15000, "Электроника");
        System.out.println(product2);
        Product product3 = new Product(2, "Smart Часы", 23000, "Гаджеты");
        System.out.println(product3);
        Product product4 = new Product(1, "Монитор", 25000, "Мониторы");
        System.out.println(product4);
        Product product5 = new Product(1, "Смартфон", 47000, "Гаджеты");
        System.out.println(product5);

        System.out.println("Задание 2");
        System.out.println(product1.equals(product4));


        System.out.println("Задание 3");


        Product[] basket1 = {product1, product2};
        Product[] basket2 = {product1, product3};
        Order order1 = new Order("Customer1", basket1);
        Order order2 = new Order("Customer2", basket2);

        System.out.println(order1);
        System.out.println(order2);

        System.out.println("order1 equals order2: " + order1.equals(order2));


    }


}





































