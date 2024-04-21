public class Cart {
    private int customerId;
    private int itemsCount=0;
    int nProducts;
    Product[] products;
    Customer customer;

    public Cart(int customerId,int nProducts){
        this.customerId = customerId;
        this.nProducts = nProducts;
        products = new Product[nProducts];
    }
    public void addProduct(Product product){
        if(itemsCount == nProducts)
            System.out.println("cart is full");

        else{
            itemsCount++;
            products[itemsCount-1] = product;
        }
    }
    public void removeProduct(Product product){
        int productIndex=-1;

        for(int i=0;i<products.length;i++){
            if(products[i] == product){
                productIndex = i;
            }
        }
        if(productIndex == -1){
            System.out.println("product not found");
        }
        else{
            while (productIndex < itemsCount-1){
                products[productIndex]=products[productIndex+1];
                productIndex++;
            }
            products[productIndex]=null;
            itemsCount--;
        }
    }
    public float calculatePrice(Product[] products){
        float sum = 0;
        for(int i=0;i<products.length;i++){
            sum= sum + products[i].getPrice();
        }
        return sum;
    }
    public Order placeOrder(){
        Order order = new Order(this);
        return order;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getnProducts() {
        return nProducts;
    }

    public void setnProducts(int nProducts) {
        if(nProducts < itemsCount)
            System.out.println("can not change to smaller cart");
        else{
            this.nProducts = nProducts;
            Product[] products1 = new Product[nProducts];
            for(int i=0; i<itemsCount;i++){
                products1[i] = products[i];
            }
            products = products1;
        }
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
