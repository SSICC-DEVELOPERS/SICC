package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ped.DTOLoteSolicitudes;
import es.indra.sicc.dtos.ped.DTORegistrarSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudRegistro;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import javax.ejb.CreateException;

import es.indra.sicc.logicanegocio.bel.ConstantesBEL;

import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.SecuenciadorOID;

import es.indra.sicc.entidades.ped.RegistroSolicitudLocalHome;
import es.indra.sicc.entidades.ped.RegistroSolicitudLocal;

import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.ConstantesProcesosPED;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import java.util.Vector;

import javax.persistence.PersistenceException;

public class MONRegistrarSolicitudBean implements SessionBean  {

  private SessionContext ctx;

  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }

    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       29/12/2004
    * @version     3.3
    * @autor       Pablo Perez (pperez)
    * Descripcion: 
    * @param    
    * @return   
    * @throws es.indra.mare.common.exception.MareException
    */
  public void validarProcesoRegistro(DTOOID dtoe) throws MareException {
    
    UtilidadesLog.info("MONRegistrarSolicitudBean.validarProcesoRegistro(DTOOID dtoe): Entrada ");
    // Valida que el tipo de solicitud recibido permita el proceso "Registro de pedidos" 
    
    //resultado = DAOValidaciones.validarProceso(DTOE.oid, ConstantesPED.GP1, ConstantesProcesosPED.REGISTRAR_SOLICITUD) 
    DAOValidaciones daoValidaciones = new DAOValidaciones();
    Boolean resultado = daoValidaciones.validarProceso(dtoe.getOid(), ConstantesPED.GP1, ConstantesProcesosPED.REGISTRAR_SOLICITUD);

    UtilidadesLog.debug("resultado: " + resultado);

    if (!resultado.booleanValue())  {
        UtilidadesLog.info("MONRegistrarSolicitudBean.validarProcesoRegistro(DTOOID dtoe): Salida ");
        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED + ErroresNegocio.PED_034));
        // Lanza una MareException con código de error: PED-0034         
    }
    UtilidadesLog.info("MONRegistrarSolicitudBean.validarProcesoRegistro(DTOOID dtoe): Salida ");
  }

    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       29/12/2004
    * @version     3.3
    * @autor       Pablo Perez (pperez)
    * Descripcion: Realiza el registro de una solicitud 
    * @param    
    * @return   
    * @throws es.indra.mare.common.exception.MareException
    */

  public DTOLoteSolicitudes grabarLote(DTOLoteSolicitudes dtoe) throws MareException {
    UtilidadesLog.info("MONRegistrarSolicitudBean.grabarLote(DTOLoteSolicitudes dtoe): Entrada ");
    Vector parametros = new Vector();

    BelcorpService bs;

    try {
        bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("Exception: ",e);
        throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    
    // Primero valida los códigos de cliente recibidos 
    
    Date fechaDelSistema = new Date(System.currentTimeMillis());
    dtoe = validarClientes(dtoe);
    
        if (dtoe.getOk().booleanValue())  {
            if (dtoe.getOidLote() == null)  {
                /* esperando el oc4j904, usamos sql pues el segundo create necesita del primeros
                 * lotesLHome = getLotesLocalHome();
                 * lotesLocal = lotesLHome.create(dtoe.getNumeroLote(),fechaDelSistema,dtoe.getPeriodo(), dtoe.getTipoSolicitud());
                 * dtoe.setOidLote(lotesLocal.getOid());                
                 */
                Long oidLote = SecuenciadorOID.obtenerSiguienteValor("PED_LOTE_SEQ");
                dtoe.setOidLote(oidLote);
                StringBuffer query = new StringBuffer("");
                query.append(" INSERT INTO PED_LOTE ( ");
                query.append(" OID_LOTE, ");
                query.append(" NUM_LOTE, ");
                query.append(" FEC_REGI, ");
                query.append(" PERD_OID_PERI, ");
                query.append(" TSPA_OID_TIPO_SOLI_PAIS ");          
                query.append(" ) VALUES ( ?, ?, ?, ?, ? ) "); 
                parametros.add(oidLote);
                parametros.add(dtoe.getNumeroLote());
                parametros.add(fechaDelSistema);
                parametros.add(dtoe.getPeriodo());
                parametros.add(dtoe.getTipoSolicitud());

                // se ejecuta la sentencia		
                try {
                    bs.dbService.executePreparedUpdate(query.toString(), parametros);
                } catch (Exception e) {
                    UtilidadesLog.debug("Creacion de Lote: " + e.getMessage());
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Exception: ",e);
                    throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
            
            ArrayList aClientes = dtoe.getClientes();
            
            for (int i=0; i< aClientes.size(); i++)  {
                DTORegistrarSolicitud dtoRegistrarSol = (DTORegistrarSolicitud) aClientes.get(i);
                registrarClienteSolicitud(dtoRegistrarSol, dtoe.getOidLote());
            }
            
            if ((dtoe.getNumeroSolicitudes() != null) && (dtoe.getNumeroSolicitudesLote() != null)){
            
                if (dtoe.getNumeroSolicitudes().longValue() == dtoe.getNumeroSolicitudesLote().longValue()) {
    
                    DTOOID dtoOid = new DTOOID();
                    dtoOid.setOidPais(dtoe.getOidPais());
                    dtoOid.setOidIdioma(dtoe.getOidIdioma());
                    dtoe.setNumeroLote(generarNumeroDocumento(dtoOid).getOid());
                    dtoe.setOidLote(null);
                    
                }
           }
        } 
        UtilidadesLog.info("MONRegistrarSolicitudBean.grabarLote(DTOLoteSolicitudes dtoe): Salida ");
        return dtoe;
  }


    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       29/12/2004
    * @version     3.3
    * @autor       Pablo Perez (pperez)
    * Descripcion: 
    * @param    
    * @return   
    * @throws es.indra.mare.common.exception.MareException
    */

  public DTOOID generarNumeroDocumento(DTOOID dtoOid) throws MareException {
        UtilidadesLog.info("MONRegistrarSolicitudBean.generarNumeroDocumento(DTOOID dtoOid): Entrada ");
      
      DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
      
      dtoNumeroSolicitud.setOidPais(dtoOid.getOidPais());
      dtoNumeroSolicitud.setOidIdioma(dtoOid.getOidIdioma());
      dtoNumeroSolicitud.setOidCanal(null);
      dtoNumeroSolicitud.setOidAcceso(null);
      dtoNumeroSolicitud.setOidSubacceso(null);
      dtoNumeroSolicitud.setOperacion(ConstantesBEL.COD_PED001);
      
      Long numeroDocumento = null;

      try {

          MONProcesosPEDHome mprHome = (MONProcesosPEDHome) UtilidadesEJB.getHome("MONProcesosPED", MONProcesosPEDHome.class);
          MONProcesosPED mpr = mprHome.create();
          numeroDocumento = new Long(mpr.generaNumeroDocumento(dtoNumeroSolicitud));

      } catch (RemoteException re)  {
          UtilidadesLog.error("Exception: ",re);
          ctx.setRollbackOnly();
          throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException ex)  {
          UtilidadesLog.error("Exception: ",ex);
          ctx.setRollbackOnly();
          throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } 
      
      DTOOID dtoSalida = new DTOOID();
      dtoSalida.setOid(numeroDocumento);
      dtoSalida.setOidPais(dtoOid.getOidPais());
      dtoSalida.setOidIdioma(dtoOid.getOidIdioma());
      UtilidadesLog.info("MONRegistrarSolicitudBean.generarNumeroDocumento(DTOOID dtoOid): Salida ");
      return dtoSalida;
  }

    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       29/12/2004
    * @version     3.3
    * @autor       Pablo Perez (pperez)
    * Descripcion: 
    * @param    
    * @return   
    * @throws es.indra.mare.common.exception.MareException
    */
  
  public void registrarClienteSolicitud(DTORegistrarSolicitud dtoRegistrarSolicitud, Long oidLote) throws MareException {
        UtilidadesLog.info("MONRegistrarSolicitudBean.registrarClienteSolicitud(DTORegistrarSolicitud dtoRegistrarSolicitud, Long oidLote): Entrada ");
      RegistroSolicitudLocalHome registroSolLHome = null;
      RegistroSolicitudLocal registroSolLocal = null;
      
      try  {
          registroSolLHome = new RegistroSolicitudLocalHome();
          registroSolLocal = registroSolLHome.create(dtoRegistrarSolicitud.getOidCliente(),
                                                     oidLote,
                                                     dtoRegistrarSolicitud.getZona());
                                                     
          registroSolLocal.setNumRegistradas(new Long(1));
          registroSolLocal.setNumDigitadas(new Long(0));
          
          registroSolLHome.merge(registroSolLocal);
          
      } catch (PersistenceException ex)  {
          ctx.setRollbackOnly();
          UtilidadesLog.error("Exception: ",ex);
          throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      } 
        UtilidadesLog.info("MONRegistrarSolicitudBean.registrarClienteSolicitud(DTORegistrarSolicitud dtoRegistrarSolicitud, Long oidLote): Salida ");
  }

    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       29/12/2004
    * @version     3.3
    * @autor       Pablo Perez (pperez)
    * Descripcion: 
    * @param    
    * @return   
    * @throws es.indra.mare.common.exception.MareException
    */

  public DTOLoteSolicitudes validarClientes(DTOLoteSolicitudes dtoe) throws MareException {
    UtilidadesLog.info("MONRegistrarSolicitudBean.validarClientes(DTOLoteSolicitudes dtoe): Entrada ");
    DAOValidaciones daoValidaciones = new DAOValidaciones();

    ArrayList aClientes = dtoe.getClientes();
    int numeroClientes = aClientes.size();
    
    for (int i=0; i< numeroClientes ; i++)  {
        DTORegistrarSolicitud dtoRegistrarSolicitud = (DTORegistrarSolicitud) aClientes.get(i);        
        dtoRegistrarSolicitud = daoValidaciones.validarClienteRegistro(dtoe.getPeriodo(),dtoRegistrarSolicitud);
        if (!dtoRegistrarSolicitud.getOk().booleanValue())  {
            dtoe.setOk(Boolean.FALSE);
        }
        
        aClientes.set(i,dtoRegistrarSolicitud);
    }
    UtilidadesLog.info("MONRegistrarSolicitudBean.validarClientes(DTOLoteSolicitudes dtoe): Salida ");
    return dtoe;    
  }

    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       29/12/2004
    * @version     3.3
    * @autor       Pablo Perez (pperez)
    * Descripcion: 
    * @param    
    * @return   
    * @throws es.indra.mare.common.exception.MareException
    */

  public DTOTipoSolicitudRegistro obtenerValoresAsociadosTipoSolicitud(DTOTipoSolicitudRegistro dtoe) throws MareException {
    UtilidadesLog.info("MONRegistrarSolicitudBean.obtenerValoresAsociadosTipoSolicitud(DTOTipoSolicitudRegistro dtoe): Entrada ");
    DAOSolicitud daoSolicitud = new DAOSolicitud();

    // Obtiene los valores asociados al tipo de solicitud 
    RecordSet resultado = daoSolicitud.obtenerValoresTSRegistro(dtoe.getOidTipoSolicitudPais());

    //<inicio>Modificado por Sapaza, corregimos el seteo de Marca y Canal
    dtoe.setOidCanal(objectToLong(resultado.getValueAt(0,"CANAL")));
    dtoe.setOidMarca(objectToLong(resultado.getValueAt(0,"MARCA")));
    //<fin>
    dtoe.setNumeroSolicitudesLote(objectToLong(resultado.getValueAt(0,"NSL")));

    DTOOID dtoOid = new DTOOID();
    dtoOid.setOidIdioma(dtoe.getOidIdioma());
    dtoOid.setOidPais(dtoe.getOidPais());
    
    dtoOid = generarNumeroDocumento(dtoOid);
    dtoe.setNumeroLote(dtoOid.getOid());
    UtilidadesLog.info("MONRegistrarSolicitudBean.obtenerValoresAsociadosTipoSolicitud(DTOTipoSolicitudRegistro dtoe): Salida ");
    return dtoe;
  }


    private String objectToString(Object oString){
      if (oString != null)
          return (String) oString;
      else
        return null;

  }

  private Long objectToLong(Object oBigDecimal){
      if (oBigDecimal != null)
          return new Long(((BigDecimal)oBigDecimal).longValue());
      else 
          return null;
  }
  
  private Integer objectToInteger(Object oBigDecimal){
      if (oBigDecimal != null)
          return new Integer(((BigDecimal)oBigDecimal).intValue());
      else 
          return null;
  }

  private Date objectToDate(Object oDate){
      if (oDate != null)
          return (Date)oDate;
      else 
          return null;
  }  
  
}