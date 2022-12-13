
import java.util.List;
import java.util.Scanner;

public class Rental
{
    static private final String PASSWORD = "Admin";
    private static String item;
    private static FakeDB fakeDB;
    private static String itemList;

    public Rental(FakeDB db)
    {
        this.fakeDB = db;
        menu();
    }
    public static void menu()
    {
        Scanner option = new Scanner(System.in);

        System.out.println("Menu wypozyczalni");
        System.out.println("1. Wypozycz ksiazke");
        System.out.println("2. Wypozycz film");
        System.out.println("3. Wypozycz album");
        System.out.println("4. Zaloguj sie");
        System.out.println("5. Wyjdz");

            try
            {
               int options = Integer.parseInt(option.nextLine());

                switch(options)
                {
                    case 1:
                        System.out.println("Wypozyczasz ksiazke");
                        itemList = "ksiazek";
                        item = "ksiazke";

                         userMenu(fakeDB.books.GetList());

                        break;
                    case 2:
                        System.out.println("Wypozyczasz film");
                        itemList = "filmow";
                        item = "film";
                      userMenu(fakeDB.movies.GetList());
                        break;
                    case 3:
                        System.out.println("Wypozyczasz album");
                        itemList = "albumow";
                        item = "album";
                     userMenu(fakeDB.albums.GetList());
                        break;
                    case 4:
                        System.out.println("Podaj haslo");
                        String password = option.nextLine();
                        if(PASSWORD.equals(password))
                        {
                            System.out.println("Jaka baza chcesz zarzadzac?");
                            System.out.println("1. Ksiazek");
                            System.out.println("2. Filmow");
                            System.out.println("3. Albumow");
                            System.out.println("4. Cofnij");
                            Scanner input =  new Scanner(System.in);

                            String provided = input.nextLine();

                            switch(provided)
                            {
                                case "1":
                                adminMenu(fakeDB.books.GetList());
                                    break;
                                case "2":
                                adminMenu(fakeDB.movies.GetList());
                                    break;
                                case "3":
                                  adminMenu(fakeDB.albums.GetList());
                                    break;
                                case "4":
                                   menu();
                                default:
                                    System.out.println("Nie ma takiej opcji");
                                    menu();
                            }
                        }
                        else
                        {
                            System.out.println("Bledne haslo " + password);
                        }

                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Wybrales opcje ktorej nie ma");
                        menu();
                        break;
                }

            }
            catch(NumberFormatException exception)
            {
                System.out.println("Wybrales opcje ktorej nie ma");
                menu();
            }

    }
    public static void adminMenu(List<Item> list)
    {
        Scanner option = new Scanner(System.in);
        try
        {

            System.out.println("1.Dodaj artykul do wypozyczalni");
            System.out.println("2.Usun artykul z wypozyczalni");
            System.out.println("3.Cofnij");
            System.out.println("4.Wyswietl pelna liste");
            System.out.println("5.Wyjdz");

            int options = Integer.parseInt(option.nextLine());

            switch(options)
            {
                case 1:
                   if(list.equals(fakeDB.albums.GetList()))
                   {
                       fakeDB.albums.AddItem();
                   }
                   else if(list.equals(fakeDB.books.GetList()))
                   {
                       fakeDB.books.AddItem();
                   }
                   else
                   {
                       fakeDB.movies.AddItem();
                   }
                    break;
                case 2:
                    System.out.println("Usuwasz artykul");
                    break;
                case 3:
                    menu();
                    break;
                case 4:
                    list.forEach(Item::info);
                    adminMenu(list);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Wybrales opcje ktorej nie ma");
                    adminMenu(list);
                    break;
            }

        }
        catch(NumberFormatException exception)
        {
            System.out.println("Wybrales opcje ktorej nie ma");
            adminMenu(list);
        }

    }

    public static void userMenu(List<Item> list)
    {
        Scanner option = new Scanner(System.in);

        try
        {
            System.out.println("1.Lista "+ itemList);
            System.out.println("2.Wyszukaj "+ item);
            System.out.println("3.Cofnij");
            System.out.println("4.Wyjdz");
            int options = Integer.parseInt(option.nextLine());

            switch(options)
            {
                case 1:
                   System.out.println("Lista "+ itemList);
                   System.out.println("");
                   list.forEach(Item::info);
                   System.out.println(" ");
                   userMenu(list);
                    break;
                case 2:
                    if(list.equals(fakeDB.albums.GetList()))
                    {
                        fakeDB.albums.FindItem();
                    }
                    else if(list.equals(fakeDB.books.GetList()))
                    {
                        fakeDB.books.FindItem();
                    }
                    else
                    {
                        fakeDB.movies.FindItem();
                    }
                    break;
                case 3:
                    menu();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Wybrales opcje ktorej nie ma");
                    userMenu(list);
                    break;
            }

        }
        catch(NumberFormatException exception)
        {
            System.out.println("Wybrales opcje ktorej nie ma");
            userMenu(list);
        }

    }


  }






