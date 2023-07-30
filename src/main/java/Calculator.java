public class Calculator {
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
