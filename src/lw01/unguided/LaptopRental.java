public class LaptopRental extends Rental {
    public LaptopRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int dailyCost = getDays() * 40000;
        return (dailyCost + 10000);
    }

    @Override 
    public String label() {
        return "Laptop";
    }
}