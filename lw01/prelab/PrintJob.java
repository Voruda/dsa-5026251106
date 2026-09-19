public abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    public PrintJob(String id, int pages) {
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }
    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int copies){
        return calculateCharge() * copies;
    }

    public String label(){
        return "Print";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}