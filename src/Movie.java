import java.util.Date;


public class Movie extends Item {
    private String title;
    private String director;
    private String script;
    private String genre;
    private String production;

    public Movie(Date czas, double cena, String _title, String _director, String _script, String _genre, String production) {
        super(czas,cena);
    this.title = _title;
    this.director = _director;
    this.script = _script;
    this.genre = _genre;
    this.production = production;


    }

    @Override
    String getTitle()
    {
       return title;
    }

    @Override
    void info()
    {
        System.out.println("Tytul filmu: " + title +" rezyseria: " + director +" scenariusz: " + script +" gatunek"+ genre +" produckja: "+ production);
    }



}
