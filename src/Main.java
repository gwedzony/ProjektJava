/*
Wybarny temat:
3.Wypozyczalnia ksiazek, filmow, albumow
-dodawanie obiektu do bazy
-wyszukiwanie obiektu
-usuwanie obiektu
-interfejs uzytkownika

dokumentacja projektu komentarze w kodzie zrodlowym
graficzny schemat(diagram klas)
wstep( cel i opis podjetego problemu)
instrukcja instalacji oraz uruchomienia aplikacji
przypadki uzycia, podsumowanie

2.1.1
1.Wyszukaj ksiazke
2.Lista ksiazek

 */

public class Main {
    public static void main(String[] args)
    {
         FakeDB inicjator = new FakeDB();
         Rental rental = new Rental(inicjator);
    }
}