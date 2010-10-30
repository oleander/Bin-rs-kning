import java.util.*;
import java.io.*;

class FindFile {
  public static void main(String[] args){
    /* För få argument */
    if(args.length != 2){
      System.err.println("För få eller fel argument");
      System.exit(1);
    }
    
    int find = Integer.valueOf(args[0]);
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
      System.err.println("Något gick fel");
      System.exit(1);
    }
    
    values = s.split("\\s");
    int[] save = new int[values.length];
    for(String value : values){
      try {
        save[n++] = Integer.valueOf(value);
      } catch(NumberFormatException e){}
    }
    
    Sort sort = new Sort(save);
    System.out.println(sort.member(find));
  }
}