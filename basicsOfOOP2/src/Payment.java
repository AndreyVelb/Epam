import java.util.ArrayList;
import java.util.List;

public class Payment {
    private String shopName;
    private static List<Product> productDataBase = new ArrayList<>();

    public Payment(String shopName) {
        this.shopName = shopName;
    }

    public void setProductDateBase(String productName, int productCost){
        for(Product product : productDataBase){
            if(product.getName() == productName){
                System.out.println("Данный продукт уже внесен в реестр");
                return;
            }
        }
        Product product = new Product( productName, productCost);
        productDataBase.add(product);
    }

    public void removeProduct(String productName){
        for(Product product : productDataBase){
            if(product.getName() == productName){
                productDataBase.remove(product);
                return;
            }
        }
        System.out.println("Такого продукта нет в реестре");
    }

    public void changeCost(String productName, int replacementCost){
        for(Product product : productDataBase){
            if(product.getName() == productName){
                product.setCost(replacementCost);
                return;
            }
        }
    }

    public void printCost(String productName){
        for(Product product : productDataBase){
            if(product.getName() == productName){
                System.out.println(product.getCost());
                return;
            }
        }
        System.out.println("Такого продукта нет в реестре");
    }

    public void buyerNeed(String...productNames){
        int totalCost = 0;
        boolean isOnDataBase = false;
        for(int i = 0; i < productNames.length; i++) {
            for (int j = 0; j < productDataBase.size(); j++) {
                if (productNames[i] == productDataBase.get(j).getName()) {
                    System.out.println("Вы приобрели " + productDataBase.get(j).getName() + " стоимостью " + productDataBase.get(j).getCost() + " рублей");
                    System.out.println("=================================================");
                    totalCost += productDataBase.get(j).getCost();
                    isOnDataBase = true;
                }
            }
            if(!isOnDataBase){
                System.out.println("Товара " + productNames[i] + " в магазине нет");
                System.out.println("=================================================");
                isOnDataBase = true;
            }
            isOnDataBase = false;
        }
        System.out.println("Общая сумма к оплате составила " + totalCost);
    }
    private class Product{
        private int cost;
        private String name;

        public Product( String name, int cost) {
            this.cost = cost;
            this.name = name;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
