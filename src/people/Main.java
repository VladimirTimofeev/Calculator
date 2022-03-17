package people;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Broun");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        Long stream = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(stream);

        List<String> stream1 = persons.stream()
                .filter(x -> x.getSex().equals(Sex.MAN))
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(stream1);

        List<Person> stream2 = persons.stream()
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .filter(x ->
                    (x.getSex().equals(Sex.MAN) && x.getAge() >= 18 && x.getAge() < 65) ||
                    (x.getSex().equals(Sex.WOMAN) && x.getAge() >= 18 && x.getAge() < 60)
                )
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(stream2);
        System.out.println();

        Predicate<Person> m = x -> x.getSex().equals(Sex.MAN) && x.getAge() >= 18 && x.getAge() < 65;
        Predicate<Person> w = x -> x.getSex().equals(Sex.WOMAN) && x.getAge() >= 18 && x.getAge() < 60;
        List<Person> stream3 = persons.stream()
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .filter(m)
                .filter(w)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(stream3);
    }
}
