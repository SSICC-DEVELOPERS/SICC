package es.indra.sicc.logicanegocio.bel;
import es.indra.sicc.dtos.bel.DTOPosicionCambioVenta;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Mochila 
{
    private ArrayList posicionesSolicitud = null;
    private ArrayList pilaOptima = null;
    private ArrayList pilaInicial = null;
    private BigDecimal montoDevuelve = null;
    private BigDecimal montoMaxDiferencia = null;
    private BigDecimal montoMaximo = null;

    public Mochila(ArrayList posiciones, BigDecimal devuelve, BigDecimal diferencia)
    {
        // Inicializamos las variables
        posicionesSolicitud = posiciones;
        montoDevuelve = devuelve;
        montoMaxDiferencia = diferencia;
        
        // Calcula el monto m�ximo
        montoMaximo = new BigDecimal((montoDevuelve==null?0:montoDevuelve.doubleValue())+(montoMaxDiferencia==null?0:montoMaxDiferencia.doubleValue()));
    }
    
   /**
   * @throws java.lang.Exception
   * @return boolean
   * @param n
   * @param posicion
   * @autor jquiroga
   */
    public boolean llenar () throws Exception{ //Modificada por Inc BELC300014198
      UtilidadesLog.info("Mochila.llenar():Entrada");
      int i;
      // Llena el ArrayList pilaOptima con las posiciones de la solicitud hasta encontrar el �ptimo
      for(i=0; i<posicionesSolicitud.size(); i++) {
        // A�ade la posici�n al ArrayList pilaOptima
        pilaOptima.add(posicionesSolicitud.get(i));

        // Evaluaci�n de la pila. Si alcanzamos el �ptimo regresamos
        if(evaluarPila()) {
          UtilidadesLog.info("Mochila.llenar():Salida");
          return true;
          
        }
      }
      UtilidadesLog.info("Mochila.llenar():Salida");
      return false;  
    }
    
    /**
    * @throws java.lang.Exception
    * @return boolean
    * @autor jquiroga
    */
    private boolean evaluarPila() throws Exception{
      // Evalua el estado actual de la pila sumando el valor de precioFacturaUnitarioLocal
      // para cada posici�n Recorre la pila y suma sus componentes 
      UtilidadesLog.info("Mochila.evaluarPila():Entrada");
      DTOPosicionCambioVenta posicion;
      double suma = 0.0; 
      int i;

      for(i=0; i<pilaOptima.size();i++) { 
        posicion = (DTOPosicionCambioVenta)pilaOptima.get(i); 
        suma = suma + ((BigDecimal)posicion.getPrecioFacturaUnitarioLocal()).doubleValue(); 
      }
      
      if(suma >= montoMaximo.doubleValue()) {
        UtilidadesLog.info("Mochila.evaluarPila():Salida");
        return true; 
      } else {
        UtilidadesLog.info("Mochila.evaluarPila():Salida");
        return false;      
      }
    }
    
    /**
    * @throws java.lang.Exception
    * @return void
    * @autor jquiroga
    */
    public void obtenerMinimoOptimo () throws Exception{
      UtilidadesLog.info("Mochila.obtenerMinimoOptimo():Entrada");
      double suma = 0.0;
      int i;
      DTOPosicionCambioVenta posicion=null;
      
      // Si entre todas las combinaciones no hemos encontrado ninguna que satisface el criterio de selecci�n nos quedamos con el m�nimo �ptimo, es decir la pila inicial 
      for(i=0; i<pilaInicial.size(); i++) {
        // Obtiene la siguiente posici�n de la pila 
        posicion = (DTOPosicionCambioVenta)pilaInicial.get(i);
      
        // Actualiza el valor de la suma 
        suma = suma + ((BigDecimal)posicion.getPrecioFacturaUnitarioLocal()).doubleValue();
      } 
      
      // Actualiza la pila optima con la pila inicial
      UtilidadesLog.info("Mochila.obtenerMinimoOptimo():Salida");
      pilaOptima = (ArrayList)pilaInicial.clone();   
    }


  public ArrayList getPosicionesSolicitud()
  {
    return posicionesSolicitud;
  }

  public ArrayList getPilaOptima()
  {
    return pilaOptima;
  }

  public void setPilaInicial(ArrayList pilaInicial)
  {
    this.pilaInicial = pilaInicial;
  }
}