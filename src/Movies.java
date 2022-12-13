import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movies implements OperationsOnLists
{

    private List<Item> moviesList = new ArrayList<>();

    public Movies() {

        moviesList.add(new Movie(null,
                25,
                "GUILLERMO DEL TORO: PINOKIO",
                "Mark Gustafson, Guillermo del Toro",
                "Gris Grimly, Matthew Robbins",
                "Animacja, Fantasy, Musical",
                "Francja,USA,Meksyk"));

    }
    @Override
    public List<Item> GetList() {
        return moviesList;
    }

    @Override
    public void FindItem() {

        Scanner input = new Scanner(System.in);

        boolean exist = false;
        int index = 0;

        System.out.println("Podaj tytul do odnalezienia w bazie: ");

        String title = input.nextLine();

        for (int x = 0; x < moviesList.size(); x++) {

            if (title.equals(moviesList.get(x).getTitle())) {
                exist = true;
                index = x;
            }

        }

        if (exist) {
            System.out.println("Film znajduje sie w naszej wypozyczalni.");
            System.out.println("Pelna informacja o Filmie: ");
            moviesList.get(index).info();
            System.out.println("Czy chcesz ja wypozyczyc?.");
            System.out.println("Wpisz tak lub nie");

            String decision = input.nextLine();
            if (decision.equals("Tak") || decision.equals("tak")) {
                System.out.println("Wypozyczyles film pod tytulem: " + moviesList.get(index).getTitle());
                Rental.userMenu(moviesList);
            } else {
                Rental.userMenu(moviesList);
            }

        } else if (!exist) {
            System.out.println("Nie mamy takiego filmu.");
            System.out.println("Chcesz wpisac ponownie tytul?");
            System.out.println("Wpisz tak lub nie");
            String decision = input.nextLine();
            if (decision.equals("Tak") || decision.equals("tak")) {
                FindItem();
            } else {
                Rental.userMenu(moviesList);
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

        for (int x = 0; x < moviesList.size(); x++) {

            if (title.equals(moviesList.get(x).getTitle())) {
                exist = true;
                index = x;
            }

        }

        if (exist) {
            moviesList.remove(index);
        } else {
            System.out.println("Nie ma takiej pozycji w bazie.");
            System.out.println("Chcesz wpisac ponownie tytul?");
            System.out.println("Wpisz tak lub nie");
            String decision = input.nextLine();
            if (decision.equals("Tak") || decision.equals("tak")) {
                DeleteItem();
            } else {
                Rental.userMenu(moviesList);
            }
        }

    }

    @Override
    public void AddItem() {
        Scanner input = new Scanner(System.in);
        Double cena = null;

        System.out.println("Dodajesz: ");
        System.out.println("Podaj cene wypozyczenia: ");

        try {
            cena = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Kwota powinna byc zapisana jako liczba");
            AddItem();
        }

        System.out.println("Podaj autora: ");
        String wykonawca = input.nextLine();

        System.out.println("Podaj wydawnictwo: ");
        String wytwornia = input.nextLine();

        System.out.println("Podaj tytul ksiazki: ");
        String tytul = input.nextLine();

        moviesList.add(new Album(null, cena, tytul, wykonawca, wytwornia));

        Rental.adminMenu(moviesList);
    }
}
