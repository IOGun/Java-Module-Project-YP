import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int persons = 0;

        while(true){
            System.out.println("На скольких человек необходимо разделить счёт?");
            try {
                persons = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Программа остановлена.");
                return;
            }
            if (persons > 1) {
                break;
            } else if (persons == 1) {
                System.out.println("Нет смысла ничего считать и делить.");
            } else {
                System.out.println("Это некорректное значение для подсчёта.");
            }
        }


        Calculator calculator = new Calculator();
        Product product = new Product();

        while (true){
            System.out.println("Введите название товара");
            product.name = scanner.next();
            while(true){
                System.out.println("Введите стоимость товара \"" + product.name + "\"");
                double price;
                try {
                    price = scanner.nextDouble();
                } catch (Exception e) {
                    System.out.println("Ошибка ввода! Программа остановлена.");
                    return;
                }
                if(correctPrice(price)){
                    product.price = price;
                    break;
                } else {
                    System.out.println("Введено некорректное значение");
                }
            }

            calculator.addNewProduct(product);
            System.out.println("Товар \"" + product.name +  "\" успешно добавлен");

            System.out.println("Хотите добавить ещё один товар?");
            if(scanner.next().equalsIgnoreCase("завершить")) {
                break;
            }
        }

        Formatter formatter = new Formatter(calculator.moneyForEach(persons));
        System.out.println("Добавленные товары:\n" + calculator.products +
                           "Итого с каждого человека: " + formatter.formatOut());
        scanner.close();
    }

    public static boolean correctPrice(double price) {
       if(price < 0) {
            return false;
        } else {
           return true;
       }

    }
}
