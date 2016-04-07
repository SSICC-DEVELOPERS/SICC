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
 *
 */
package es.indra.sicc.logicanegocio.dto;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.sicc.util.DTOOID; 
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesLog;


/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:           
 * Componente:        MONRevertirDescuentosBean
 * Fecha:             28/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 *
 * @version           1.0
 * @autor             Cristian Valenzuela
 */

public class MONRevertirDescuentosBean implements SessionBean {
    private SessionContext ctx;

    public void setSessionContext(SessionContext ctx) { this.ctx = ctx; }
    public void ejbCreate() { }
    public void ejbActivate() {}
    public void ejbPassivate() { }
    public void ejbRemove() { }    

    /**
     * Cristian Valenzuela
     * 10/08/2004
     * 
     */

  public void revertirDescuentos(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONRevertirDescuentos.revertirDescuentos(): Entrada");
      /*1° Llamar al método "MONHistoricoDTO.borrarHistoricoSolicitud(dto : DTOOID) : void" 
        pasando el dto de entrada 
        2° Llamar al método "DAOSolicitud.actualizarMontoDescuento3(oidCabecera : Long, montoDescuento3 : BigDecimal) : 
        void" pasando el oid del dto de entrada y 0 para el monto. 
        3° Llamar al método "DAOSolicitud.obtenerPosicionesDTO(oidCabecera : Long) : DTOSalida" 
        pasando el oid del dto de entrada.
        4° Recorrer el RecordSet anterior  Para cada registro hacer:  Tomar el oid de la posición de solicitud
        5° Llamar al método "DAOSolicitud.actualizarPorcentajeDescuento(oidPosicion : Long, porcentaje : BigDecimal, 
        descuento : BigDecimal) : void" pasando el oid de la posición y 0 para las dos cantidades: porcentaje y descuento.
         */

      try {
        //1°
        MONHistoricoDTOHome mhdh = this.getMONHistoricoDTOHome();
        MONHistoricoDTO mhd = mhdh.create();
        mhd.borrarHistoricoSolicitud(dto);

        //2°
        DAOSolicitud dao = new DAOSolicitud();
        Long oidCabecera = dto.getOid();
        BigDecimal montoDescuento = new BigDecimal(0);
        
        //jrivas 10/5/2005
        //INC 17873
        dao.actualizarMontoDescuento3(oidCabecera, montoDescuento, null, null);

        //3°
        DTOSalida dtoSal = new DTOSalida();
        dtoSal = dao.obtenerPosicionesDTO(oidCabecera);
        RecordSet rs = dtoSal.getResultado();

        //4°
        for(int pos=0; pos< rs.getRowCount(); pos++) {
          BigDecimal oidSoliPosi = (BigDecimal)rs.getValueAt(pos,"OIDSOLICITUDPOSICION");
          Long lSoliPosi = new Long(oidSoliPosi.longValue());
          
          BigDecimal porcentaje = new BigDecimal(0);
          BigDecimal descuento = new BigDecimal(0);
          
          //5°
          //jrivas 10/5/2005
          //INC 17873          
          dao.actualizarPorcentajeDescuento(lSoliPosi, porcentaje, descuento, null, null);
        }      
      }
      catch (Exception ne) {
        UtilidadesLog.error("ERROR",ne);
        ctx.setRollbackOnly();
        if (ne instanceof MareException)throw (MareException)ne;
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
        UtilidadesLog.info("MONRevertirDescuentos.revertirDescuentos(): Salida");
    }


    private MONHistoricoDTOHome getMONHistoricoDTOHome() throws MareException {

        MONHistoricoDTOHome home = null;
        BelcorpService bs = null;
        
        try {
              bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            home = (MONHistoricoDTOHome) bs.ejbLocator.getHome(
                   "MONHistoricoDTO", MONHistoricoDTOHome.class);
        } catch (MareServiceException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ) );
        }
        return home;                                        
    }

  
}