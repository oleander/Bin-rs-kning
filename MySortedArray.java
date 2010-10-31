class MySortedArray<E> implements MySet {
  private E[] array;
  private E element;
  private Comparator comparator;
  
  public MySortedArray(E[] array) {
    this.array = array;
    this.comparator = null;
  }
  
  public MySortedArray(E[] array, Comparator comparator) {
    this(array);
    this.
  }
  
  
  public boolean member (E element) {
    this.element = element;
    return find();
  }
  
  private boolean find() {
    return find(0, array.size - 1);
  }
  
  private boolean find(int low, int high) {
    /* Uppstår endast om det sökta elementet inte finns i listan */
    if(low > high) return false;
    
    /* Hämtar ut mittersta indexet */
    int mid = (low + high)/2;
    
    /* Hämtar ut mittersta värdet */
    E x = array[mid];
  
    /* Har vi hittar numret? */
    if(x.equals(this.element))              return true;
    
    /* Om x är mindre än det sökta värdet, letar vi vidare på högersidan av listan */
    else if(x.compareTo(this.element) < 0)  return this.find(mid + 1, high);
    
    /* Annars letar vi vidare på vänstersidan av listan */
    else                                    return this.find(low, mid - 1);
  }
}