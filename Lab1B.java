import java.util.*;
import java.io.*;

class Lab1B {
  public static void main(String[] args){
    /* För få argument */
    if(args.length != 2){
      System.err.println("Too few or invalid arguments.");
      System.exit(1);
    }
    
    int element = Integer.valueOf(args[0]);
    String strLine;
    String s = "";
    
    BufferedReader br = null;
    int n = 0;
    String[] values;
    
    try{
      br = new BufferedReader(new FileReader(args[1]));
      while ((strLine = br.readLine()) != null) s += " " + strLine;
    } catch(Exception e){
      e.printStackTrace();
      System.err.println("An error occured.");
      System.exit(1);
    }
    
    values = s.split("\\s");
    Integer[] save = new Integer[values.length];
    for(String value : values){
      try {
        save[n++] = Integer.valueOf(value);
      } catch(NumberFormatException e){}
    }
    
    MySortedArray sorted = new MySortedArray(save);
    System.out.println(sorted.member(element));
  }
}