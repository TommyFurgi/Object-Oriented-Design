package pl.edu.agh.to.lab4.data;

import pl.edu.agh.to.lab4.SuspectAggregate;
import pl.edu.agh.to.lab4.suspects.Student;
import pl.edu.agh.to.lab4.suspects.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentsDataProvider implements SuspectAggregate {
    private final Collection<Student> students = new ArrayList<>();

    public StudentsDataProvider() {
        students.add(new Student("Alicja", "Kątek", "123333", 2001));
        students.add(new Student("Mirosław", "Kamień", "871432", 1939));
        students.add(new Student("Nikodem", "Marzec", "999997", 2008));
    }
    @Override
    public Iterator<Suspect> iterator() {
        return ((Collection<Suspect>)(Collection<?>) students).iterator();
    }
}
