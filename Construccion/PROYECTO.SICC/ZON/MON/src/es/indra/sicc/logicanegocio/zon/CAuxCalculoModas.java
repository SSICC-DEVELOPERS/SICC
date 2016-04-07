package es.indra.sicc.logicanegocio.zon;
import es.indra.sicc.dtos.zon.DTOLISTUniNSE;
import es.indra.sicc.dtos.zon.DTOUniNSE;
import es.indra.sicc.util.UtilidadesLog;
import java.util.*;


public class CAuxCalculoModas 
{
  public CAuxCalculoModas()
  {
  }

  public void calcularModaNSE(DTOLISTUniNSE arg, String []outNSE)
  {
     UtilidadesLog.info("CAuxCalculoModas.calcularModaNSE(DTOLISTUniNSE arg, String []outNSE): Entrada");
     
     Hashtable hNSE1 = new Hashtable();
     Hashtable hNSE2 = new Hashtable();     
     Hashtable hNSE3 = new Hashtable();     
     ArrayList aList = arg.getArrayDTOUniNSE();
     DTOUniNSE dtoElemento = null;
     String sNSE1 = null;
     String sNSE2 = null;
     String sNSE3 = null;
     Integer nBuffer1 = null;
     Integer nBuffer2 = null;
     Integer nBuffer3 = null;

     Iterator it = aList.iterator();
     
     while ( it.hasNext() )
     {
        dtoElemento = (DTOUniNSE) it.next();
        // Toma el valor de NSE x del DTO.
        sNSE1 = dtoElemento.getNSE1();
        UtilidadesLog.debug("sNSE1: " + sNSE1);
        
        sNSE2 = dtoElemento.getNSE2();
        UtilidadesLog.debug("sNSE2: " + sNSE2);
        
        sNSE3 = dtoElemento.getNSE3();
        UtilidadesLog.debug("sNSE3: " + sNSE3);
      
		if (sNSE1 != null) {
	        // Chequea si existe este key en el Hashtable.
			nBuffer1 =(Integer) hNSE1.get( sNSE1 );
			// Si no existe en el HashTable un registro para este key,
			// crea uno con sNSEn como key, y un Integer con valor 1.
			// Si existe, le suma 1 al valor del elemento.
			if (nBuffer1 == null)
			{
			  hNSE1.put(sNSE1, new Integer(1));
			} else
			{
			  nBuffer1 = new Integer( nBuffer1.intValue() + 1 );
			  hNSE1.put(sNSE1, nBuffer1);
			}
		}

		if (sNSE2 != null) {
	        // Chequea si existe este key en el Hashtable.
			nBuffer2 =(Integer) hNSE2.get( sNSE2 );
			// Si no existe en el HashTable un registro para este key,
			// crea uno con sNSEn como key, y un Integer con valor 1.
			// Si existe, le suma 1 al valor del elemento.
			if (nBuffer2 == null)
			{
			   hNSE2.put(sNSE2, new Integer(1));          
			} else
			{
			  nBuffer2 = new Integer( nBuffer2.intValue() + 1 );       
			  hNSE2.put(sNSE2, nBuffer2);                    
			}
		}

		if (sNSE3 != null) {
	        // Chequea si existe este key en el Hashtable.
			nBuffer3 =(Integer) hNSE3.get( sNSE3 ); 
			// Si no existe en el HashTable un registro para este key,
			// crea uno con sNSEn como key, y un Integer con valor 1.
			// Si existe, le suma 1 al valor del elemento.
			if (nBuffer3 == null)
			{
			   hNSE3.put(sNSE3, new Integer(1));          
			} else
			{
			  nBuffer3 = new Integer( nBuffer3.intValue() + 1 );       
			  hNSE3.put(sNSE3, nBuffer3);                    
			}   
		 }
	 }
   
     UtilidadesLog.debug("hNSE1: " + hNSE1);
     UtilidadesLog.debug("hNSE2: " + hNSE2);
     UtilidadesLog.debug("hNSE3: " + hNSE3);

     outNSE[0] = retornaModa(hNSE1);
     outNSE[1] = retornaModa(hNSE2);
     outNSE[2] = retornaModa(hNSE3);
     
     UtilidadesLog.info("CAuxCalculoModas.calcularModaNSE(DTOLISTUniNSE arg, String []outNSE): Salida");

  }

  private String retornaModa(Hashtable hNSE1)
  {
     UtilidadesLog.info("CAuxCalculoModas.retornaModa(Hashtable hNSE1): Entrada");

     // Una vez teniendo los HASTable Completos, lo recorre y chequea cuál es la 
     // moda. Si se da el caso que dos elementos tengan la misma moda en un momento
     // dado, se selecciona el de menor valor (ya que se toman como Integers).
     Integer nMax = null; // Contiene la moda.
     String sKey = ""; // Contiene el key con moda.
     
     // Todos los valores son nulos
     if(hNSE1.size()==0) {
        return null;
     }

     Enumeration keysE = hNSE1.keys();

     // Contendran los valores temporales correspondientes 
     // a la fila del HashTable donde se halle el cursor en 
     // ese momento.
     String sKeyBuffer = null; 
     Integer nValorTable = null;

     while ( keysE.hasMoreElements() )
     {
        sKeyBuffer = (String) keysE.nextElement();  // Obtiene el key.
        nValorTable = (Integer) hNSE1.get( sKeyBuffer ); // Obtiene el elemento del key corresp.
        if (nMax == null || (nValorTable.intValue() > nMax.intValue()) )
        {
            // Si nMax es null, o el valor actual tomado del HashTable
            // es mayor que nMax, lo reemplaza en nMin y en sKey
            nMax = new Integer( nValorTable.intValue() );
            sKey = sKeyBuffer.toString();
            
        } else if (nValorTable.intValue() == nMax.intValue() )
        {
            // Al coincidir dos valores en la moda, chequea cual es el de menor 
            // valor (en el key) y cambia el valor del key actual por ese.
            // NO HACE FALTA CAMBIAR EL VALOR YA QUE SON IGUALES!!!
            
            String nTableKeyValue = sKeyBuffer;
            String nCurrKeyValue = sKey;
            if ( nTableKeyValue.compareTo(nCurrKeyValue) > 0)
              sKey = sKeyBuffer.toString();
        }
     }
     UtilidadesLog.info("CAuxCalculoModas.retornaModa(Hashtable hNSE1): Salida");
     
     return sKey;
  }
}
