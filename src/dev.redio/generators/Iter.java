import java.lang.Iterable;
import java.lang.Iterator;
import java.lang.Optional;

public interface Iter<T> extends Iterable<T> {
    
    Optional<T> next();

    @Override 
    default Iterator<T> iterator() {
        return new IterImpl();
    }

    default void reset() {
        throw new UnsupportedOperationException();
    }
    private class IterImpl implements Iterator<T> {
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
}