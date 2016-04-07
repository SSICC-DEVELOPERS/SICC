package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;

public abstract class DocumentoFAC 
{
  private DTOClienteSolicitud dtoClienteSolicitud;

  public DocumentoFAC()
  {
  }

  public void componerFactura(DTODocLegal datosDocLegal) throws MareException
  {
    
  }
  
  //por la señora LP (ssaavedr)
  public void componerFactura(DTOFACConsolidado datosConsolidado) throws MareException
  {
    
  }   

  public String verificarSignoImporte(Float entrada)
{
  String salida="";
  if(entrada.floatValue()<0)
  {
     salida+="("+entrada.floatValue()+")"; 
  }
  
  return salida;
}


public String negador(Float entrada)
{
  
  String salida="";
  float aux= entrada.floatValue()*(-1);
  if(aux<0)
  {
    salida+="("+String.valueOf(aux)+")"; 
  }
  else
  {
    salida=String.valueOf(aux);
  }
  
  
  return salida;
}
    
public abstract byte[] getDocument();
    
protected String validarToString(Object objetoEntrada)
{
String salida=" ";
if(objetoEntrada!=null)
{
  salida=objetoEntrada.toString();
}

return salida;  
}
    
 public String calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada)
    {
     UtilidadesLog.info("DocumentoFAC.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Entrada"); 
     
     UtilidadesLog.debug("ESTOS SON LOS PARAMETROS QUE ME ENTRAN: " + codPeriodoEntrada+" "+codVenta+" "+precioCatalogoUnitLocalEntrada);
     
     String salida="";
     if(codPeriodoEntrada.length()>2){
     salida=codPeriodoEntrada.substring(codPeriodoEntrada.length()-2 ,codPeriodoEntrada.length());
     }
     else
     {
     salida=codPeriodoEntrada;  
     }
     
     if(codVenta.length()>5){
     salida+=codVenta.substring(0,5);
     }
     else
     {
       salida+=codVenta;
     }
     
     if(precioCatalogoUnitLocalEntrada.floatValue()==0)
     {
       salida+="0";
     }
     else
     {
       salida+="8";
     }
     
     UtilidadesLog.debug("Y ESTA ES LA SALIDA: "+ salida);
     UtilidadesLog.info("DocumentoFAC.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Salida"); 
     return salida;
    }
    
    //esta clase añade un cero a los float (siempre que sea necesario) 
    //para que aparezcan siempre con dos decimales
    public String anadirCeroFloat(String value)
    {
        UtilidadesLog.debug("DocumentoFAC.anadirCero(String value): Entrada");
        //lo pasamos a float
        String valorFloat = new Float(value).toString();
        //averiguamos la posicion del punto
        int posicionPunto = valorFloat.lastIndexOf(".");
        //comprobamos cuantas posiciones hay después del punto
        int posicionDpPunto =  (valorFloat.length()-1)-posicionPunto;
        if (posicionDpPunto<2) 
        {
            //agregamos un cero más al string
            valorFloat+="0";
        }
        
        UtilidadesLog.debug("DocumentoFAC.anadirCero(String value): Salida");
        return valorFloat;
    }

  public DTOClienteSolicitud getDtoClienteSolicitud()
  {
    return dtoClienteSolicitud;
  }

  public void setDtoClienteSolicitud(DTOClienteSolicitud dtoClienteSolicitud)
  {
    this.dtoClienteSolicitud = dtoClienteSolicitud;
  }
  
  public String[] dividirCadena(String cadena, int iLongMax) {
        int posi = 0;
        if (cadena.length()<iLongMax){
            return new String[] { cadena};
        }
        ArrayList array = new ArrayList();
        while (true){
            if ((posi+iLongMax)>=cadena.length()){
                String s = cadena.substring(posi,cadena.length());            
                array.add(s);
                break;
            }else{
                String s = cadena.substring(posi,posi+iLongMax);            
                array.add(s);
            }
            posi = posi+iLongMax;            
        }
        String[] back = new String [array.size()];
        array.toArray(back);
        return back;        
    }

   public String formatearDecimales (String saldoTotal) {
       String totalFormateado1 = null;
       String totalFormateado2 = null;
       String totalFormateado3 = null;
       String totalFormateado4 = null;
       String parteEntera = null;
       String parteDecimal = null;
       
       int posicionPunto = saldoTotal.lastIndexOf(".");       
       int lenSaldo = saldoTotal.length();
       
       if (posicionPunto != -1) {
           parteDecimal = new String(saldoTotal.substring(posicionPunto + 1, lenSaldo).toString());  
           parteEntera = new String(saldoTotal.substring(0, posicionPunto).toString());         
       } else {            
           parteEntera = new String(saldoTotal.toString());         
       }
       int lenDato = parteEntera.length();
       
       if (lenDato > 3) {
          totalFormateado1 = new String(parteEntera.substring(lenDato - 3, lenDato).toString());            
          if (lenDato > 6) {
              totalFormateado2 = new String(parteEntera.substring(lenDato - 6, lenDato - 3).toString());                
              if (lenDato > 9) {
                  totalFormateado3 = new String(parteEntera.substring(lenDato - 9, lenDato - 6).toString());                    
                  if (lenDato > 12) {
                      totalFormateado4 = new String(parteEntera.substring(lenDato - 12, lenDato - 9).toString());                        
                  } else {
                    totalFormateado4 = new String(parteEntera.substring(0, lenDato - 9).toString());  
                  }
              } else {
                totalFormateado3 = new String(parteEntera.substring(0, lenDato - 6).toString());  
              }
          } else {
            totalFormateado2 = new String(parteEntera.substring(0, lenDato - 3).toString());  
          }
      } else {
        totalFormateado1 = new String(parteEntera.toString());  
      }
      
      String totalFor = new String();

      if (totalFormateado4 != null) {
        totalFor = totalFormateado4.toString() + ".";
      }

      if (totalFormateado3 != null) {
        totalFor += totalFormateado3.toString() + ".";
      }

      if (totalFormateado2 != null) {
        totalFor += totalFormateado2.toString() + ".";
      }      
      totalFor += totalFormateado1.toString();
      if (parteDecimal != null) {
        totalFor += "." + parteDecimal.toString();
      }
     
      return totalFor.toString();
    }

    public String cerosIzq(String cadena1, int cantidad) {
        UtilidadesLog.info("CuponDePagoColombia.cerosIzq(String cadena1, int cantidad): Entrada");
        StringBuffer cantCeros = new StringBuffer("");
        for(int i=0; i < cantidad - cadena1.length() ;i++) {
            cantCeros.append("0");
        }
      
        StringBuffer cadena2 = new StringBuffer(cantCeros.toString());
        cadena2.append(cadena1);
        UtilidadesLog.info("CuponDePagoColombia.cerosIzq(String cadena1, int cantidad): Salida");
        return cadena2.toString();
    }

    public Float valorAbsoluto (Float numero) {
        if (numero != null && numero.floatValue() < 0) {
            numero = new Float(numero.floatValue() * (-1));
        }
        return numero;
    }

}