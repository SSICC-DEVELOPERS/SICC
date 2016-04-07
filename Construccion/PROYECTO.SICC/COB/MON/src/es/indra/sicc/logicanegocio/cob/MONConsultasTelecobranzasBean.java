/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOEBuscarConsultorasTelecobranza;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOEBuscarHistoricoCobranza;
import es.indra.sicc.dtos.cob.DTOEBuscarCobranzaExterna;

public class MONConsultasTelecobranzasBean implements SessionBean 
{
  private DTOSalida dtoS;
  SessionContext ctx;
  
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx){
    this.ctx = ctx;
  }
  /**
   * @author pperanzola
   * @date 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   *  Proceso: 
      -> Tomar el dto de entrada como parámetro para la siguiente llamada 
      -> Llamar al método "DAOConsultasTelecobranzas.buscarConsultorasPorCPago(dto : DTOEBuscarConsultorasTelecobranza) : DTOSalida" 
      -> Devolver el dto de respuesta a la llamada anterior
   */
  public DTOSalida buscarConsultorasPorCPago(DTOEBuscarConsultorasTelecobranza dto) throws MareException{
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarConsultorasPorCPago(DTOEBuscarConsultorasTelecobranza dto): Entrada");
  
      DAOConsultasTelecobranzas daoConTele = new DAOConsultasTelecobranzas();
      dtoS= daoConTele.buscarConsultorasPorCPago(dto);
      
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarConsultorasPorCPago(DTOEBuscarConsultorasTelecobranza dto): Salida");
      
      return dtoS;
  }
  /**
   * 
   * @date 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   * MONConsultasTelecobranzas.buscarConsultorasPorTAccion(dto : DTOEBuscarConsultorasTelecobranza) : DTOSalida 
      Entrada: 
      - dto : DTOEBuscarConsultorasTelecobranza 
      Proceso: 
      -> Tomar el dto de entrada como parámetro para la siguiente llamada 
      -> Llamar al método "DAOConsultasTelecobranzas.buscarConsultorasPorTAccion(dto : DTOEBuscarConsultorasTelecobranza) : DTOSalida" 
      -> Devolver el dto de respuesta a la llamada anterior
   */
  public DTOSalida buscarConsultorasPorTAccion(DTOEBuscarConsultorasTelecobranza dto) throws MareException{
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarConsultorasPorTAccion(DTOEBuscarConsultorasTelecobranza dto): Entrada");
  
      DAOConsultasTelecobranzas daoTele = new DAOConsultasTelecobranzas();
      dtoS= daoTele.buscarConsultorasPorTAccion(dto);
      
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarConsultorasPorTAccion(DTOEBuscarConsultorasTelecobranza dto): Salida");
      
      return dtoS;
  }
  
  /**
   * 
   * @date 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   * MONConsultasTelecobranzas.buscarConsultorasPorGestionPago(dto : DTOEBuscarConsultorasTelecobranza) : DTOSalida 
      Entrada: 
      - dto : DTOEBuscarConsultorasTelecobranza 
      Proceso: 
      -> Tomar el dto de entrada como parámetro para la siguiente llamada 
      -> Llamar al método "DAOConsultasTelecobranzas.buscarConsultorasPorGestionPago(dto : DTOEBuscarConsultorasTelecobranza) : DTOSalida" 
      -> Devolver el dto de respuesta a la llamada anterior
   */

  public DTOSalida buscarConsultorasPorGestionPago(DTOEBuscarConsultorasTelecobranza dto) throws MareException{
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarConsultorasPorGestionPago(DTOEBuscarConsultorasTelecobranza dto): Entrada");
  
      DAOConsultasTelecobranzas daoTele = new DAOConsultasTelecobranzas(ctx);
      dtoS= daoTele.buscarConsultorasPorGestionPago(dto);
      
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarConsultorasPorGestionPago(DTOEBuscarConsultorasTelecobranza dto): Salida");
      
      return dtoS;
  }

  /**
   * 
   * @date 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   * MONConsultasTelecobranzas.obtenerEstadosAsignacion(dto : DTOBelcorp) : DTOSalida
    Entrada: 
    - dto : DTOBelcorp 
    Proceso: 
    -> Tomar el dto de entrada como parámetro para la siguiente llamada 
    -> Llamar al método DAOConsultasTelecobranzas.obtenerEstadosAsignacion(dto : DTOBelcorp) : DTOSalida 
    -> Devolver DTOSalida obtenido de la llamada anterior
   */
  public DTOSalida obtenerEstadosAsignacion(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("MONConsultasTelecobranzasBean.obtenerEstadosAsignacion(DTOBelcorp dto): Entrada");
  
      DAOConsultasTelecobranzas daoTele = new DAOConsultasTelecobranzas();
      dtoS= daoTele.obtenerEstadosAsignacion(dto);
      
        UtilidadesLog.info("MONConsultasTelecobranzasBean.obtenerEstadosAsignacion(DTOBelcorp dto): Salida");
      
      return dtoS;

  }
  /**
   * 
   * @date 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   *  MONConsultasTelecobranzas.buscarHistoricoCobranza(dto : DTOEBuscarHistoricoCobranza) : DTOSalida 
      Entrada: 
      - dto : DTOEBuscarHistoricoCobranza 
      Proceso: 
      -> Llamar al método "DAOConsultasTelecobranzas.buscarHistoricoCobranza(dto : DTOEBuscarHistoricoCobranza) : DTOSalida" 
      -> Devolver DTOSalida de respuesta
   */
  public DTOSalida buscarHistoricoCobranza(DTOEBuscarHistoricoCobranza dto) throws MareException{
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarHistoricoCobranza(DTOEBuscarHistoricoCobranza dto): Entrada");
  
      DAOConsultasTelecobranzas daoTele = new DAOConsultasTelecobranzas();
      dtoS= daoTele.buscarHistoricoCobranza(dto);
      
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarHistoricoCobranza(DTOEBuscarHistoricoCobranza dto): Salida");
      
      return dtoS;
  }

  /**
   * 
   * @date 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   * MONConsultasTelecobranzas.buscarCobranzaExterna(dto : DTOEBuscarCobranzaExterna) : DTOSalida 
      Entrada: 
      - dto : DTOEBuscarHistoricoCobranza 
      Proceso: 
      -> Llamar al método "DAOConsultasTelecobranzas.buscarCobranzaExterna(dto : DTOEBuscarCobranzaExterna) : DTOSalida" 
      -> Devolver DTOSalida de respuesta 
   */
  public DTOSalida buscarCobranzaExterna(DTOEBuscarCobranzaExterna dto) throws MareException{
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarCobranzaExterna(DTOEBuscarCobranzaExterna dto): Entrada");
  
      DAOConsultasTelecobranzas daoTele = new DAOConsultasTelecobranzas();
      dtoS= daoTele.buscarCobranzaExterna(dto);
      
        UtilidadesLog.info("MONConsultasTelecobranzasBean.buscarCobranzaExterna(DTOEBuscarCobranzaExterna dto): Salida");
      
      return dtoS;
  }

}