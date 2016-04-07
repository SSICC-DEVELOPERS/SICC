package es.indra.sicc.dtos.inc;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;

public class DTOListaMetasVentaProyectada extends DTOBelcorp 
{
  private ArrayList listaMetas;

  public ArrayList getListaMetas()
  {
    return listaMetas;
  }

  public void setListaMetas(ArrayList listaMetas)
  {
    this.listaMetas = listaMetas;
  }

  /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   14/09/2006
     * @version 1.00
     * @autor   Viviana Bongiovanni
     * Inc DBLG500000222
     */
  public void agregarActivaInicial(DTOMetasVentaProyectada dtoMetasVentaEntrada) throws MareException {
  
      UtilidadesLog.info("DTOListaMetasVentaProyectada.agregarActivaInicial(DTOMetasVentaProyectada dtoMetasVentaEntrada):Entrada");
  
      int cant = listaMetas.size();
      DTOMetasVentaProyectada dtoMetasVentaProyectada= null;
      long totalNumActivasIniciales = 0;
      
      UtilidadesLog.debug("dtoMetasVentaEntrada.getOidUA(): " + dtoMetasVentaEntrada.getOidUA());
      UtilidadesLog.debug("dtoMetasVentaEntrada.getOidCliente(): " + dtoMetasVentaEntrada.getOidCliente());
      
      for(int i=0; i< cant; i++){
          dtoMetasVentaProyectada = (DTOMetasVentaProyectada)listaMetas.get(i);
          
          UtilidadesLog.debug("dtoMetasVentaProyectada.getOidUA(): " + dtoMetasVentaProyectada.getOidUA());
          UtilidadesLog.debug("dtoMetasVentaProyectada.getOidCliente(): " + dtoMetasVentaProyectada.getOidCliente());
          
          if((dtoMetasVentaProyectada.getOidUA().equals(dtoMetasVentaEntrada.getOidUA()))
             && (dtoMetasVentaProyectada.getOidCliente().equals(dtoMetasVentaEntrada.getOidCliente()))){
             
             UtilidadesLog.debug("coinciden");
             
             totalNumActivasIniciales = dtoMetasVentaProyectada.getNumActivasIniciales().longValue() +
                                        dtoMetasVentaEntrada.getNumActivasIniciales().longValue();
             
             UtilidadesLog.debug("totalNumActivasIniciales: " + totalNumActivasIniciales);                                        
                                        
             dtoMetasVentaProyectada.setNumActivasIniciales(new Long(totalNumActivasIniciales));  
             
             UtilidadesLog.info("DTOListaMetasVentaProyectada.agregarActivaInicial(DTOMetasVentaProyectada dtoMetasVentaEntrada):Salida");
             
             return;
          }
      }
      
      UtilidadesLog.debug("no se encontro se agrega");
      listaMetas.add(dtoMetasVentaEntrada);      
      
      UtilidadesLog.info("DTOListaMetasVentaProyectada.agregarActivaInicial(DTOMetasVentaProyectada dtoMetasVentaEntrada):Salida");
  }
  
  /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   14/09/2006
     * @version 1.00
     * @autor   Viviana Bongiovanni
     * Inc DBLG500000222
     */
  public Long obtenerActivasIniciales(DTOMetasVentaProyectada dtoMetasVentaEntrada) throws MareException {
  
      UtilidadesLog.info("DTOListaMetasVentaProyectada.obtenerActivasIniciales(DTOMetasVentaProyectada dtoMetasVentaEntrada):Entrada");
  
      int cant = listaMetas.size();
      DTOMetasVentaProyectada dtoMetasVentaProyectada= null;
      long totalNumActivasIniciales = 0;
      
      UtilidadesLog.debug("dtoMetasVentaEntrada.getOidUA(): " + dtoMetasVentaEntrada.getOidUA());
      UtilidadesLog.debug("dtoMetasVentaEntrada.getOidCliente(): " + dtoMetasVentaEntrada.getOidCliente());
      
      for(int i=0; i< cant; i++){
          dtoMetasVentaProyectada = (DTOMetasVentaProyectada)listaMetas.get(i);
          
          UtilidadesLog.debug("dtoMetasVentaProyectada.getOidUA(): " + dtoMetasVentaProyectada.getOidUA());
          UtilidadesLog.debug("dtoMetasVentaProyectada.getOidCliente(): " + dtoMetasVentaProyectada.getOidCliente());
          
          if((dtoMetasVentaProyectada.getOidUA().equals(dtoMetasVentaEntrada.getOidUA()))
             && (dtoMetasVentaProyectada.getOidCliente().equals(dtoMetasVentaEntrada.getOidCliente()))){
             
             UtilidadesLog.debug("coinciden");
             
             UtilidadesLog.info("DTOListaMetasVentaProyectada.obtenerActivasIniciales(DTOMetasVentaProyectada dtoMetasVentaEntrada):Salida");
             
             return dtoMetasVentaProyectada.getNumActivasIniciales();
          }
      }
      
      UtilidadesLog.debug("no se encontro");
      
      UtilidadesLog.info("DTOListaMetasVentaProyectada.agregarActivaInicial(DTOMetasVentaProyectada dtoMetasVentaEntrada):Salida");
      
      return new Long(0);
  }
  
}

