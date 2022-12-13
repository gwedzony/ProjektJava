import java.util.Date;


abstract class Item {

    private Date rentTime;
    private double rentPrize;

    public Item(Date czas, double cena) {
        this.rentTime = czas;
        this.rentPrize = cena;

    }

    abstract String getTitle();

    abstract void info();
}
