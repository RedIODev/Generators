import java.util.Iterator;
import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var randomNumber = (Iter<Double>)() -> Optional.of(Math.random());

        var randomOld = new Iterator<>() {

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public Double next() {
                // TODO Auto-generated method stub
                return Math.random();
            }
            
        };
        for (var i : iter(randomOld)) {
            System.out.println(i);
        }
    }

    public static<T> Iterable<T> iter(Iterator<T> iterator) {
        return () -> iterator;
    }
}
