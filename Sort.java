public class Sort {
  private int[] list;
  private int find;
  
  public Sort(int[] list){
    this.list = list;
  }
  
  /**
   * Meddelar om värdet finns i listan {this.list}
   * @return Boolean Retunerar sant om ingående värde finns i angiven lista {this.list}
   * @param int find Värdet som ska hittas i listan {this.list}
   */
  public boolean member(int find){
    this.find = find;
    return this.find();
  }
  
  /**
   * Startar igång sökningen med noll (0) och högsta indexet - 1 
   * @see {this.find()}
   */
  private boolean find(){
    return this.find(0, this.list.length - 1);
  }
  
  /**
   * Letar upp värdet {this.find} i {this.list}
   * @return Boolean Retunerar sant när {this.find} hittas i listan {this.list}, annars falskt
   * @param int low Lägsta indexet vi letar på i listan
   * @param int high Högsta indexet vi letar på i listan
   */  
  private boolean find(int low, int high){
    
    /* Nu har vi gått lite för långt */
    if(low > high) return false;
    
    /* Hämtar ut mitterna indexet */
    int value = (low + high)/2;
    
    /* Hämtar ut mitterna värdet */
    int x = list[value];
  
    /* Har vi hittar nummret ? */
    if(x == this.find)     return true;
    
    /* Vi letar vidare på högersidan av listan */
    else if(x < this.find) return this.find(value + 1, high);
    
    /* Vi letar vidare på vänstersidan av listan */
    else                   return this.find(low, value - 1);
  }
}