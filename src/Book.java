import java.util.Date;

public class Book extends Item
{
    private String author;
    private String publishingHouse;
    private String title;


    public Book(Date czas, double cena, String _author, String _publishingHouse, String _title)
    {
        super(czas, cena);
        this.author = _author;
        this.publishingHouse = _publishingHouse;
        this.title = _title;

    }

    @Override
    public void info()
    {
         System.out.println("Autor: "+ author + " , Wydawnictwo: "+ publishingHouse +" ," + "Tytul: "+ title);
    }

    public String getTitle()
    {
        return title;
    }




}

