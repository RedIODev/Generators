import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface Iter<T> extends Iterable<T> {
    
    Optional<T> next();

    @Override 
    default Iterator<T> iterator() {

        class IterImpl implements Iterator<T> {
            Optional<T> nextValue = Optional.empty();
            
            @Override
            public boolean hasNext() {
                this.nextValue = Iter.this.next();
                return this.nextValue.isPresent();
            }
        
            public T next() {
                return nextValue.orElseThrow(NoSuchElementException::new);
            }
        }

        return new IterImpl();
    }
    
}

