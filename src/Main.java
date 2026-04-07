
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
        Order o1 = new Order("Иван", new Product[]{product1, product2, product3});
        Order o2 = new Order("Петр", new Product[]{product2, product5, product4});
        Order o3 = new Order("Иван", new Product[]{product4, product3, product1});
        System.out.println("Order 1: " + o1);
        System.out.println("Order 2: " + o2);
        System.out.println("Order 3: " + o3);
        System.out.println(product1.equals(product3));

    }


}





































