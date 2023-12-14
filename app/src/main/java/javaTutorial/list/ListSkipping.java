package javaTutorial.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListSkipping {

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        numbers.add("One");
        numbers.add("Two");
        numbers.add("Three");
        numbers.add("Four");
        numbers.add("Five");
        numbers.add("Six");
        numbers.add("Seven");
        numbers.add("Eight");
        numbers.add("Nine");
        numbers.add("Ten");

        List<String> list = numbers.stream().skip(numbers.size()-3).limit(3).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
