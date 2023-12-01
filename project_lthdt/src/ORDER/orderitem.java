package ORDER;

public class orderitem {
        private String product; // Tên sản phẩm
        private int quantity; // Số lượng sản phẩm
    
        // Phương thức setter cho thuộc tính product
        public void setProduct(String product) {
            this.product = product;
        }
    
        // Phương thức getter cho thuộc tính product
        public String getProduct() {
            return product;
        }
    
        // Phương thức setter cho thuộc tính quantity
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    
        // Phương thức getter cho thuộc tính quantity
        public int getQuantity() {
            return quantity;
        }
    
        // Phương thức tính tổng giá trị sản phẩm
        public double calculateTotalValue(double pricePerUnit) {
            return quantity * pricePerUnit;
        }
    
        public static void main(String[] args) {
            // orderitem orderItem = new orderitem();
            // orderItem.setProduct("Áo thun");
            // orderItem.setQuantity(3);
    
            // double pricePerUnit = 10.99;
            // double totalValue = orderItem.calculateTotalValue(pricePerUnit);
    
            // System.out.println("Sản phẩm: " + orderItem.getProduct());
            // System.out.println("Số lượng: " + orderItem.getQuantity());
            // System.out.println("Tổng giá trị sản phẩm: $" + totalValue);
        }
    }   

