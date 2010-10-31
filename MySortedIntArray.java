class MySortedIntArray implements MyIntSet {
  private int[] array;
  /* När vi utför en sökning sparar vi det sökta elementet i denna variabel. */
  private int element;
  
  /**
   * Konstruerar en MySortedIntArray utifrån argumentet
   * @param int[] array En sorterad lista av integers.
   */
  
  public MySortedIntArray(int[] array) {
    this.array = array;
  }
  
  /**
   * Meddelar om värdet finns i listan {this.list}
   * @return Boolean Returnerar sant om ingående värde finns i angiven lista {this.list}
   * @param int element Värdet som ska hittas i listan {this.list}
   */
  public boolean member(int element){
    this.element = element;
    return this.find();
  }
  

  /* Find realiserar en binärsökningsalgoritm. 
   * Find() startar sökningen från index 0 till listans längd minus ett...
   */
  private boolean find(){
    return this.find(0, this.list.length - 1);
  }
  
  
  /*
   * ... därefter anropas find(low,high) rekursivt tills vi hittar talet i fråga eller vi är säkra på att det inte finns i listan.
   */
  private boolean find(int low, int high){
    
    /* Uppstår endast om det sökta talet inte finns i listan */
    if(low > high) return false;
    
    /* Hämtar ut mittersta indexet */
    int mid = (low + high)/2;
    
    /* Hämtar ut mittersta värdet */
    int x = list[mid];
  
    /* Har vi hittar numret? */
    if(x == this.find)     return true;
    
    /* Om x är mindre än det sökta värdet, letar vi vidare på högersidan av listan */
    else if(x < this.find) return this.find(value + 1, high);
    
    /* Annars letar vi vidare på vänstersidan av listan */
    else                   return this.find(low, value - 1);
  }
  
  
}