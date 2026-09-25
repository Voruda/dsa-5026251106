

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int charge = 20000;
        if (getDays() <= 3) {
            charge += getDays() * 60000;
        }
        else {
            charge += (3 * 60000) + ((getDays() - 3) * 45000);
        }
        return charge;
    }

    @Override
    public String label() {
        return "Projector";
    }
}