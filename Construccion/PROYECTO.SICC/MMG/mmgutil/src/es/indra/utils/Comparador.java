package es.indra.utils;
import java.util.Comparator;

/**
 * 
 * @date 
 * @author pperanzola
 */
public class Comparador implements Comparator
{
  /**
   * 
   * @date 
   */
  public Comparador()
  {
  
  
  }
  public int compare(Object o1, Object o2) {
      if (((String)o1).equals((String)o2)) return 1;
      return ((String)o1).compareTo((String)o2);
  }
          
  public boolean equals(Object obj) {
      return false;   
  }
        

}