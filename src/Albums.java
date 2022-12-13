import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Albums implements OperationsOnLists
{
    private static List<Item> albumsList = new ArrayList<>();
    public Albums()
    {
        albumsList.add(new Album(null, 7, "ASKING ALEXANDRIA SEE WHAT'S ON THE INSIDE LP RED", "ASKING ALEXANDRIA", "Membran"));
    }


    @Override
    public List<Item> GetList() {
        return albumsList;
    }

    @Override
    public void FindItem() {
        Scanner input = new Scanner(System.in);

        boolean exist = false;
        int index = 0;

        System.out.println("Podaj tytul do odnalezienia w bazie: ");

        String title = input.nextLine();

        for (int x = 0; x < albumsList.size(); x++)
        {

            if (title.equals(albumsList.get(x).getTitle())) {
                exist = true;
                index = x;
            }

        }

        if (exist)
        {
            System.out.println("Album znajduje sie w naszej wypozyczalni.");
            System.out.println("Pelna informacja o albumie: ");
            albumsList.get(index).info();
            System.out.println("Czy chcesz ja wypozyczyc?.");
            System.out.println("Wpisz tak lub nie");

            String decision = input.nextLine();
            if (decision.equals("Tak") || decision.equals("tak")) {
                System.out.println("Wypozyczyles album pod tytulem: " +  albumsList.get(index).getTitle());
                Rental.userMenu(albumsList);
            }
            else
            {
                Rental.userMenu(albumsList);
            }

        }
        else if(!exist)
        {
            System.out.println("Nie mamy takiego albumu.");
            System.out.println("Chcesz wpisac ponownie tytul?");
            System.out.println("Wpisz tak lub nie");
            String decision = input.nextLine();
            if(decision.equals("Tak") || decision.equals("tak"))
            {
                FindItem();
            }
            else
            {
                Rental.userMenu(albumsList);
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

        for (int x = 0; x < albumsList.size(); x++)
        {

            if (title.equals(albumsList.get(x).getTitle())) {
                exist = true;
                index = x;
            }

        }

        if (exist)
        {
            albumsList.remove(index);
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
                Rental.userMenu(albumsList);
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
        System.out.println("Podaj tytul: ");
        String tytul = input.nextLine();
        System.out.println("Podaj wykonawce: ");
        String wykonawca = input.nextLine();
        System.out.println("Podaj wytwornie: ");
        String wytwornia = input.nextLine();

        // String _tytul,String _wykonawca, String _wytwornia
        albumsList.add(new Album(null, cena, tytul, wykonawca, wytwornia));
        Rental.adminMenu(albumsList);
    }
}
