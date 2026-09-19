public class ColourPrint extends PrintJob {
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int charge = 2000;
        
        if (getPages() <= 10) {
            charge += getPages() * 1500;
        }
        else {
            charge += (10 * 1500) + ((getPages() - 10) * 1000);
        }
        return charge;
    }

    @Override
    public String label() {
        return "Colour";
    }
}