package springpojos;

public class purchase {
    private int purchaseId;
    private String purchaseDate;
    private productDemo product;

    public purchase(int purchaseId, String purchaseDate, productDemo product) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
        this.product = product;
    }

    public void showDetails() {
        System.out.println("Purchase ID: " + purchaseId);
        System.out.println("Purchase Date: " + purchaseDate);
        product.showDetails();
    }
}
