import java.util.*;

class MySortedArray<E> implements MySet<E> {
  private E[] array;
  private E element;
  private Comparator comparator;
  
  public MySortedArray(E[] array) {
    this.array = array;
    this.comparator = new DefaultComparator<E>();
  }
  
  public MySortedArray(E[] array, Comparator comparator) {
    this(array);
    this.comparator = comparator;
  }
  
  public boolean member (E element) {
    this.element = element;
    return find();
  }
  
  private boolean find() {
    return find(0, array.length - 1);
  }
  
  /* A default comparator which compares elements using their natural order. */
  private class DefaultComparator<E> implements Comparator<E> {
    /* Tries to cast the first element as a comparable */
    public int compare(E a, E b) throws ClassCastException {
      return ((Comparable<E>) a).compareTo(b);
    }
  }
  
  private boolean find(int low, int high) {
    /* Uppstår endast om det sökta elementet inte finns i listan */
    if(low > high) return false;
    
    /* Hämtar ut mittersta indexet */
    int mid = (low + high)/2;
    
    /* Hämtar ut mittersta värdet */
    E x = array[mid];
  
    try {
      /* Har vi hittar numret? */
      if(x.equals(this.element)) return true;
      /* Om x är mindre än det sökta värdet, letar vi vidare på högersidan av listan */
      else if (comparator.compare(x, element) > 0) return this.find(mid + 1, high);
      /* Annars letar vi vidare i vänstra delen av listan. */
      else return this.find(low, mid - 1);
    } catch (ClassCastException e) {
      e.printStackTrace();
      System.err.println("An error occured: objects not comparable.");
      System.exit(1);
    }
    
    /* Return statement so that the compiler doesn't take a shit and die... */
    return false;
  }
}