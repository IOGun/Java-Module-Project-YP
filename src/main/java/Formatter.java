public class Formatter {
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
