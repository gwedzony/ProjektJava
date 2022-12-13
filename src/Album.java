import java.util.Date;

public class Album extends Item
{

    private String title;
    private String performer;
    private String musicLabel;

    public Album(Date czas, double cena, String _title, String _performer, String _musicLabel)
    {
        super(czas,cena);
        this.title = _title;
        this.performer = _performer;
        this.musicLabel = _musicLabel;
    }

    @Override
    public String getTitle()
    {
        /*TODO*/
        return null;
    }

    @Override
    void info()
    {
        System.out.println("Wykonawca: "+ performer + " Wytwornia: "+ musicLabel +" Tytul: "+ title);
    }



}
