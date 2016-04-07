package es.indra.sicc.logicanegocio.bel;
import es.indra.sicc.dtos.bel.DTOPosicionCambioVenta;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;

public class AnalisisCombinatorio 
{
  private ArrayList posicionesSolicitud = null;
  private BigDecimal montoDevuelve = null;
  private BigDecimal montoMaximoTemporal = null;
  private BigDecimal montoMaxDiferencia = null;
  private BigDecimal montoMaximo = null;
  private ArrayList pilaOptima = null;
  private ArrayList pilaInicial = null;
  private ArrayList pila = null;
  
  
  public AnalisisCombinatorio(ArrayList posiciones, BigDecimal devuelve, BigDecimal diferencia)
  {
    // Inicializamos las variables
    posicionesSolicitud = posiciones;
    montoDevuelve = devuelve;
    montoMaxDiferencia = diferencia;
    montoMaximoTemporal = new BigDecimal(0);
    
    // Calcula el monto máximo
    montoMaximo = montoDevuelve.add(montoMaxDiferencia);
  }
  
  /**
  * @throws java.lang.Exception
  * @return void
  * @param n
  * @param posicion
  * @autor jquiroga
  */  
  public void combinar (int posicion, int n) throws Exception {
    UtilidadesLog.info("AnalisisCombinatorio.combinar (int posicion, int n):Entrada");
    int i; 
    
    for(i=posicion; i<n; i++) {
      // Añadimos una nueva posición a la pila
      pila.add(posicionesSolicitud.get(i));
    
      // Evaluamos el estado actual de la pila 
      evaluarPila(); 
    
      // Buscamos posibles combinaciones a partir del estado actual de la pila 
      combinar(i+1, n); 
    
      // Saco el último elemento de la pila para proseguir con nuevas combinaciones 
      pila.remove(pila.size()-1);
    }
    UtilidadesLog.info("AnalisisCombinatorio.combinar (int posicion, int n):Salida");    
  }
  
  /**
  * @throws java.lang.Exception
  * @return void
  * @autor jquiroga
  */    
  private void evaluarPila () throws Exception {
    UtilidadesLog.info("AnalisisCombinatorio.evaluarPila():Entrada");
    double suma = 0.0; 
    int i; 
    
    // Recorre la pila y suma sus componentes 
    for(i=0; i<pila.size();i++) { 
      DTOPosicionCambioVenta posicion = (DTOPosicionCambioVenta)pila.get(i); 
      suma = suma + ((BigDecimal)posicion.getPrecioFacturaUnitarioLocal()).doubleValue(); 
    }
    
    if(suma == montoMaximo.doubleValue()) { 
      montoMaximoTemporal = montoMaximo; 
      pilaOptima = (ArrayList)pila.clone(); 
    }
    else { 
      if(suma > montoMaximo.doubleValue() && ((suma < montoMaximoTemporal.doubleValue()) || montoMaximoTemporal.doubleValue() == 0.0)) {
        montoMaximoTemporal = new BigDecimal(suma); 
        pilaOptima = (ArrayList)pila.clone(); 
      } 
    }
    
    UtilidadesLog.info("AnalisisCombinatorio.evaluarPila():Salida");
  }
  
  /**
  * @throws java.lang.Exception
  * @return void
  * @autor jquiroga
  */    
  public void obtenerMinimoOptimo () throws Exception {
    UtilidadesLog.info("AnalisisCombinatorio.obtenerMinimoOptimo():Entrada");
    double suma = 0.0; 
    int i; 
    
    // Recorre la pila y suma sus componentes 
    for(i=0; i<pilaInicial.size();i++) { 
      DTOPosicionCambioVenta posicion = (DTOPosicionCambioVenta)pilaInicial.get(i); 
      suma = suma + ((BigDecimal)posicion.getPrecioFacturaUnitarioLocal()).doubleValue(); 
    }
    
    pilaOptima = (ArrayList)pilaInicial.clone(); 
    UtilidadesLog.info("AnalisisCombinatorio.obtenerMinimoOptimo():Salida");
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