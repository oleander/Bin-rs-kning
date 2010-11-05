class Testing {
  
  /**
   * Testar vår binärsökning
   */
  public static void testingIntArray(){
    int [] list = {1,2,3,3,4,4,5,6,6,7};
    Testing.testingIntArray(list);
  }
   
  public static void testingIntArray(int[] list){
    MySortedIntArray sorted = new MySortedIntArray(list);
    boolean result;
    
    /* Kontrollerar att vårat värde finns i en helt vanlig lista */
    for (int a = -10; a < 20; a++) {
      result = sorted.member(a);
      
      if(result && !(a > 0 && a < 11)){
        System.err.println("Failed (1)");
        System.exit(1);
      }
    }
    
    /* Kontrollerar så att inga värden hittas i en tom lista */
    int[] empty = {};
    sorted = new MySortedIntArray(empty);
    for (int a = -10; a < 20; a++) {
      result = sorted.member(a);

      if(result){
        System.err.println("Failed (2)");
        System.exit(1);
      }
    }
    
    /* Kontrollerar att våra värden inte hittas i en lista utanför vårt spann */
    int[] not = {1,2,3,4,5,6,7,8};
    sorted = new MySortedIntArray(not);
    for (int a = 9; a < 20; a++) {
      result = sorted.member(a);

      if(result){
        System.err.println("Failed (3)");
        System.exit(1);
      }
    }
    
    System.out.println("OK IntArray");
  }

  public static void testingArray(){
    String [] list = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    Testing.testingArray(list);
  }
   
  public static void testingArray(String[] list){
    MySortedArray sorted = new MySortedArray(list);
    boolean result;
    
    /* Kontrollerar att vårat värde finns i en helt vanlig lista */
    for (String comp : list) {
      result = sorted.member(comp);
      
      if(!result){
        System.err.println("Failed (1)");
        System.exit(1);
      }
    }
    
    String[] ref2 = {};
    sorted = new MySortedArray(ref2);
    /* Kontrollerar att vårat värde finns inte finns i en tom lista */
    for (String comp : list) {
      result = sorted.member(comp);

      if(result){
        System.err.println("Failed (2)");
        System.exit(1);
      }
    }
      
    String[] ref3 = {"J", "K", "L", "M", "N", "O", "P", "Q"};
    sorted = new MySortedArray(ref3);
    /* Kontrollerar att vårat värde finns inte finns i listan ovan */
    for (String comp : list) {
      result = sorted.member(comp);
      
      if(result){
        System.err.println("Failed (3)");
        System.exit(1);
      }
    }
    
    System.out.println("OK Array");
  }
  
  public static void main(String[] args){
    Testing.testingIntArray();
    Testing.testingArray();
  }
  
}