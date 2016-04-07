package es.indra.sicc.ped.applet.util;

import java.util.GregorianCalendar;
import java.util.StringTokenizer;
 
public class DateValidation {
    
    private CharacterValidation cVal = null;
    private StringValidation sVal = null;
    
    public DateValidation() {
        sVal = new StringValidation();
        cVal = new CharacterValidation();
    }
    
    public boolean isValid(String date) {
        if (this.sVal.isNull(date)) {
            return false;
        }
        
      
        date = this.formatDate(date);
        
        if(date.length() != 8) {
          return false;
        }
        
        if (!this.sVal.isNumeric(date)) {
            return false;
        }
        
        int m = this.getMonth(date);
        int d = this.getDate(date);
        int y = this.getYear(date);
        
        if (m < 1 || m > 12)
            return false;
        if (d < 1 || d > 31)
            return false;
        if (d > 30 && (m == 4 || m == 6 || m == 9 || m == 11))
            return false;
        if (m == 2) {
            if (d > 29)
                return false;
            if (d > 28) {
                if (y % 100 == 0) {
                    if (y % 400 > 0)
                        return false;
                }
                else {
                    if (y % 4 > 0)
                        return false;
                }
            }
        }
        return true;
    }
    
    public boolean isPast(String date) {
        if (!this.isValid(date)) {
            return false;
        }
        
        date = this.formatDate(date);
        
        int m = this.getMonth(date);
        int d = this.getDate(date);
        int y = this.getYear(date);
        
        GregorianCalendar dateIn = new GregorianCalendar(y, m-1, d, 0, 0, 0);
        GregorianCalendar temp = new GregorianCalendar();
        GregorianCalendar today = new GregorianCalendar(temp.get(GregorianCalendar.YEAR), temp.get(GregorianCalendar.MONTH),
        temp.get(GregorianCalendar.DATE), 0, 0, 0);
        
        if (dateIn.before(today)) {
            return true;
        }
        return false;
    }
    
    public boolean isFuture(String date) {
        if (!this.isValid(date)) {
            return false;
        }
        
        date = this.formatDate(date);
        
        int m = this.getMonth(date);
        int d = this.getDate(date);
        int y = this.getYear(date);
        
        GregorianCalendar dateIn = new GregorianCalendar(y, m-1, d, 0, 0, 0);
        GregorianCalendar temp = new GregorianCalendar();
        GregorianCalendar today = new GregorianCalendar(temp.get(GregorianCalendar.YEAR), temp.get(GregorianCalendar.MONTH),
        temp.get(GregorianCalendar.DATE), 0, 0, 0);
        
        if (dateIn.after(today)) {
            return true;
        }
        return false;
    }
    
    public boolean isToday(String date) {
        if (!this.isValid(date)) {
            return false;
        }
        if ( !this.isPast(date) && !this.isFuture(date) ) {
            return true;
        }
        return false;
    }
    
    public boolean isAfter(String date1, String date2) {
        if ( (!this.isValid(date1)) || (!this.isValid(date2)) ) {
            return false;
        }
        
        date1 = this.formatDate(date1);
        date2 = this.formatDate(date2);
        
        GregorianCalendar calOne = this.getGregorianCalendar(date1);
        GregorianCalendar calTwo = this.getGregorianCalendar(date2);
        
        if ( !calOne.after(calTwo)) {
            return false;
        }
        return true;
    }
    
    public boolean isBefore(String date1, String date2) {
        if ( (!this.isValid(date1)) || (!this.isValid(date2)) ) {
            return false;
        }
        
        date1 = this.formatDate(date1);
        date2 = this.formatDate(date2);
        
        GregorianCalendar calOne = this.getGregorianCalendar(date1);
        GregorianCalendar calTwo = this.getGregorianCalendar(date2);
        
        if ( !calOne.before(calTwo)) {
            return false;
        }
        return true;
    }
    
    public boolean isEqual(String date1, String date2) {
        if ( (!this.isValid(date1)) || (!this.isValid(date2)) ) {
            return false;
        }
        
        date1 = this.formatDate(date1);
        date2 = this.formatDate(date2);
        
        GregorianCalendar calOne = this.getGregorianCalendar(date1);
        GregorianCalendar calTwo = this.getGregorianCalendar(date2);
        
        if ( !calOne.equals(calTwo)) {
            return false;
        }
        return true;
    }
    
    protected String formatDate(String d) {
        if (this.sVal.isLength(d, 10)) {
            String newDate = "";
            for (int i = 0; i < 10; i++) {
                switch(i) {
                    case 2:
                        continue;
                    case 5:
                        continue;
                    default:
                        newDate = newDate + d.charAt(i);
                        break;
                }
            }
            d = newDate;
        } else {
          d = d.replaceAll("-", "/");
          StringTokenizer st = new StringTokenizer(d, "/");
          int cont = 0;
          String aux = "";
          while(st.hasMoreTokens()) {
            ++cont;
            String token = st.nextToken();
            if(cont != 3 && token.length() < 2) {
              aux = aux + "0" + token + "/";
            } else if(cont == 3 && token.length() == 2) {
              aux = aux + "20" + token;
            } 
          }
          d = this.formatDate(aux);
          
        }
        return d;
    }
    
    protected int getMonth(String s) {
        int m = Integer.parseInt(s.substring(2,4)) ;
        return m;
    }
    
    protected int getYear(String s) {
        int y = Integer.parseInt(s.substring(4,8));
        return y;
    }
    
    protected int getDate(String s) {
        int d = Integer.parseInt(s.substring(0,2));
        return d;
    }
    
    protected GregorianCalendar getGregorianCalendar(String date) {
        int m = this.getMonth(date);
        int y = this.getYear(date);
        int d = this.getDate(date);
        
        GregorianCalendar cal = new GregorianCalendar(y, m-1, d);
        return cal;
    }
    
    public static void main(String []args) {
      String fecha = "13/03/2005";
      DateValidation date = new DateValidation();
      if(date.isPast(fecha)) {
        System.out.println("La fecha es pasada");
      }
    }
}