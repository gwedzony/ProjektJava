import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Books implements OperationsOnLists
{
    private List<Item> booksList = new ArrayList<>();
    public Books()
    {
        booksList.add(new Book(null, 5, "Cay Horstmann", "Helion", "Java. Podstawy."));
        booksList.add(new Book(null, 10, "Larry Rockoff", "Helion", "Język SQL. Przyjazny podręcznik."));
        booksList.add(new Book(null, 8, "Herbert Schildt", "Helion", "Java. Przewodnik dla początkujących."));
        booksList.add(new Book(null, 6, "Joseph Albahari, Ben Albahari", "Helion", "C# 10. Leksykon kieszonkowy."));
    }

    @Override
    public List<Item> GetList() {
        return booksList;
    }

    @Override
    public void FindItem() {

        Scanner input = new Scanner(System.in);

        boolean exist = false;
        int index = 0;

        System.out.println("Podaj tytul do odnalezienia w bazie: ");

        String title = input.nextLine();

        for (int x = 0; x < booksList.size(); x++)
        {

            if (title.equals(booksList.get(x).getTitle())) {
                exist = true;
                index = x;
            }

        }
        if (exist)
        {
            System.out.println("Ksiazka znajduje sie w naszej wypozyczalni.");
            System.out.println("Pelna informacja o ksiazce: ");
            booksList.get(index).info();
            System.out.println("Czy chcesz ja wypozyczyc?.");
            System.out.println("Wpisz tak lub nie");

            String decision = input.nextLine();
            if (decision.equals("Tak") || decision.equals("tak")) {
                System.out.println("Wypozyczyles ksiazke pod tytulem: " +  booksList.get(index).getTitle());
                Rental.userMenu(booksList);
            }
            else
            {
                Rental.userMenu(booksList);
            }

        }
        else if(!exist)
        {
            System.out.println("Nie mamy takiej ksiazki .");
            System.out.println("Chcesz wpisac ponownie tytul?");
            System.out.println("Wpisz tak lub nie");
            String decision = input.nextLine();
            if(decision.equals("Tak") || decision.equals("tak"))
            {
                FindItem();
            }
            else
            {
                Rental.userMenu(booksList);
            }
        }
    }

    @Override
    public void DeleteItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj tytul do usuniecia: ");

        String title = input.nextLine();

        boolean exist = false;
        int index = 0;

        for (int x = 0; x < booksList.size(); x++)
        {

            if (title.equals(booksList.get(x).getTitle())) {
                exist = true;
                index = x;
            }

        }

        if (exist)
        {
            booksList.remove(index);
        }
        else
        {
            System.out.println("Nie ma takiej pozycji w bazie.");
            System.out.println("Chcesz wpisac ponownie tytul?");
            System.out.println("Wpisz tak lub nie");
            String decision = input.nextLine();
            if(decision.equals("Tak") || decision.equals("tak"))
            {
                DeleteItem();
            }
            else
            {
                Rental.userMenu(booksList);
            }
        }
    }

    @Override
    public void AddItem() {
        Scanner input = new Scanner(System.in);
        Double cena = null;

        System.out.println("Dodajesz ");
        System.out.println("Podaj cene wypozyczenia: ");

        try
        {
            cena = Double.parseDouble(input.nextLine());
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Kwota powinna byc zapisana jako liczba");
            AddItem();
        }

        System.out.println("Podaj autora: ");
        String autor = input.nextLine();

        System.out.println("Podaj wydawnictwo: ");
        String wydawnictwo = input.nextLine();

        System.out.println("Podaj tytul ksiazki: ");
        String tytul = input.nextLine();

        booksList.add(new Book(null, cena, autor, wydawnictwo, tytul));
        Rental.adminMenu(booksList);
    }
}
