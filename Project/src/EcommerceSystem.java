import java.util.Scanner;

public class EcommerceSystem {
    public static void main(String[] args) {
        ElectronicProduct phone = new ElectronicProduct(1,"smartphone",599.9f,"Samsung",1);
        ClothingProduct shirt = new ClothingProduct(2,"T-shirt",19.99f,"Medium","Cotton");
        BookProduct book = new BookProduct(3,"OOP",39.99f,"O'Reilly","X Publications");
        Customer me = new Customer();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to E-Commerce System!");
        System.out.println("Please enter your id");
        int id = input.nextInt();
        me.setCustomerId(id);
        System.out.println("Please enter your name");
        String name = input.next();
        me.setName(name);
        System.out.println("Please enter your address");
        String address = input.next();
        me.setAddress(address);
        System.out.println("How many products do you want to add to your cart?");
        int nproducts = input.nextInt();
        Cart shoppingCart = new Cart(me.getCustomerId(),nproducts);
        for(int i=0;i<shoppingCart.getnProducts();i++){
            System.out.print("which product would you like to add?");
            System.out.print("1- Smartphone 2- T-Shirt 3- OOP");
            int answer = input.nextInt();
            if (answer ==phone.getProductId())
                shoppingCart.addProduct(phone);
            else if (answer == shirt.getProductId())
                shoppingCart.addProduct(shirt);
            else
                shoppingCart.addProduct(book);
        }
        System.out.println("your total is"+shoppingCart.calculatePrice(shoppingCart.products));
        System.out.println("Would you like to place the order? 1- Yes 2- No");
        int answer = input.nextInt();
        if ( answer == 1){
            Order order =shoppingCart.placeOrder();
            order.printOrderInfo();
        }
        else
            System.out.println("Thank you for your service.");
    }
}