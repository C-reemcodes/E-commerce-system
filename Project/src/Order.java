public class Order{
    public static int orderCount;
    private int orderId;
    private int customerId;
    private float totalPrice;
    private Product[] products;


    public Order(Cart cart) {
        orderCount++;
        this.orderId=orderCount;
        this.customerId=cart.getCustomerId();
        this.products= cart.getProducts();
        this.totalPrice = cart.calculatePrice(cart.products);
    }
    public void printOrderInfo(){
        System.out.println("Here's your order's summary:");
        System.out.println("Order ID: "+orderId);
        System.out.println("Customer ID: "+customerId);
        System.out.println("Products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].name+" - "+products[i].price);
        }
        System.out.println("Total price:"+totalPrice);
        System.out.println("Thank you for your service");
    }
}
