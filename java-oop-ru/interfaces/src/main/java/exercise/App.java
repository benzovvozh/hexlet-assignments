package exercise;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;


// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homesList, int n) {
        homesList.sort(Comparator.comparingDouble(Home::getArea));
        List<String> stringList = new ArrayList<>();
        if (!homesList.isEmpty()) {
            for (int i = 0; i < n; i++) {
                stringList.add(homesList.get(i).toString());
            }
        }
        return stringList;
    }

    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
        CharSequence text = new ReversedSequence("abcdef");

        System.out.println(text.toString());
        System.out.println(text.charAt(1));
        System.out.println(text.length());
        System.out.println(text.subSequence(1, 4).toString());
    }
}
// END
