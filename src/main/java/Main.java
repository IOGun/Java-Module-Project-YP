import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int persons;

        while(true){
            System.out.println("На скольких человек необходимо разделить счёт?");
            persons = scanner.nextInt();
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
                //double price = Double.parseDouble(scanner.next()); // Ввод числа через точку. Например: 12.0 <Enter>
                double price =scanner.nextDouble(); // Ввод числа через запятую. Например: 12,1 <Enter>
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

class Calculator {
    String products = "";
    double totalPrice;
    void addNewProduct(Product newProduct){
        products += newProduct.name.concat("\n");
        totalPrice += newProduct.price;
    }
    double moneyForEach(int persons){
        return totalPrice/persons;
    }
}

class Product {
    String name;
    double price;
}

class Formatter {
    double price;
    String messageTemlate = "%.2f %s";
    Formatter(double price){
        this.price = price;
    }
    double roundUpPrice() {
        return Math.floor(price);
    }
    String formatOut() {
        double price = roundUpPrice();
        if(price == 1) {
            return String.format(messageTemlate, this.price , "рубль");
        } else if ((price > 1) && (price <= 4) ) {
            return String.format(messageTemlate, this.price , "рубля");
        } else {
            return String.format(messageTemlate, this.price , "рублей");
        }
    }
}