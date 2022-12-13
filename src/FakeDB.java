public class FakeDB
{
    public Books books;
    public Movies movies;
    public Albums albums;

    public FakeDB()
    {

       albums = new Albums();
       movies = new Movies();
       books = new Books();
    }
 }
