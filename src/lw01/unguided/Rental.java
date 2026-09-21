

public abstract class Rental implements Chargeable {
    private String id;
    private int days;

    public Rental(String id, int days){
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than 0");
        }
        this.id = id;
        this.days = days;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int units){
        if (units <= 0) {
            throw new IllegalArgumentException("Units must be greater than 0");
        }
        return calculateCharge() * units;
    }

    public String label(){
        return "Rental: ";
    }

    public String summary(){
        return id + " | " + label();
    }

}