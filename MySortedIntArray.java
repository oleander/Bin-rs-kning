class MySortedIntArray implements MyIntSet {
  private int[] array;
  /* När vi utför en sökning sparar vi det sökta elementet i denna variabel. */
  private int element;
  
  /**
   * Konstruerar en MySortedIntArray utifrån argumentet
   * @param int[] array En sorterad lista av integers.
   */
  
  public MySortedIntArray(int[] array) {
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
    return this.find(0, this.array.length - 1);
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
    int x = array[mid];
  
    /* Har vi hittar numret? */
    if(x == this.element)     return true;
    
    /* Om x är mindre än det sökta värdet, letar vi vidare på högersidan av listan */
    else if(x < this.element) return this.find(mid + 1, high);
    
    /* Annars letar vi vidare på vänstersidan av listan */
    else                   return this.find(low, mid - 1);
  }
  
  /**
   * Testar vår binärsökning
   */
  public static void testing(){
    int[] list = {1,2,3,4,5,6,7,8,9,10};
    MySortedIntArray sorted = new MySortedIntArray(list);
    boolean result;
    String print;
    
    for (int a = -10; a < 20; a++) {
      result = sorted.member(a);
      print = "Talet " + a + " finns " + (sorted.member(a) ? "" : "ej");
      if(result){
        System.out.println("===> " + print);
      } else {
        System.out.println(print);
      }
    }
  }
  
}