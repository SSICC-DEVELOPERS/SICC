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
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOEBuscarCompromisosPago;
import es.indra.sicc.util.UtilidadesLog;


public class MONCompromisosPagoBean implements SessionBean 
{
    SessionContext ctx= null;
    
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

    public void setSessionContext(SessionContext ctx)
    {
        this.ctx =  ctx;
    }
      /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOEBuscarCompromisosPago dto
  * @return DTOSalida
  * @exception MareException 
  * @author cargain
  * @referencia DMCO-COB-Unoficial-N36-02-03-05
  */

    public DTOSalida buscarCompromisosPago(DTOEBuscarCompromisosPago dto) throws MareException{
        UtilidadesLog.info("MONCompromisosPagoBean.buscarCompromisosPago(DTOEBuscarCompromisosPago dto): Entrada");
    
    /*
    Proceso: 
-> Tomar el dto de entrada como parámetro para la llamada siguiente: 
-> Llamar al método "DAOCompromisosPago.buscarCompromisosPago(dto : DTOEBuscarCompromisosPago) : DTOSalida" 
-> Devolver el DTOSalida obtenido en la llamada anterior*/
        DAOCompromisosPago daoCompPago = new DAOCompromisosPago();
        DTOSalida dtoS = daoCompPago.buscarCompromisosPago(dto);
        
        UtilidadesLog.info("MONCompromisosPagoBean.buscarCompromisosPago(DTOEBuscarCompromisosPago dto): Salida");
        
        return dtoS;
    }
}