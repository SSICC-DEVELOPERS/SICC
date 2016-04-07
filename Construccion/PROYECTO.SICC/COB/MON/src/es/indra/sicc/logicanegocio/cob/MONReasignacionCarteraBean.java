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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.sicc.dtos.cob.DTOCronogramaCobranza;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.entidades.cob.AsignacionCobranzaLocal;
import es.indra.sicc.entidades.cob.AsignacionCobranzaLocalHome;
import es.indra.sicc.entidades.cob.CronogramaCobranzaLocal;
import es.indra.sicc.entidades.cob.CronogramaCobranzaLocalHome;
import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaCabeceraLocalHome;
import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaDetalleLocalHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.cob.ConstantesCOB;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.rmi.RemoteException;


import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;
//Estos import de arriba se van a usar cuando se resuelvan las incidencias NO QUITAR

public class MONReasignacionCarteraBean implements SessionBean 
{
  private SessionContext ctx;
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
    this.ctx = ctx;
  }
  /** 
  * Metodo para reasignar una cartera de cobranza
  * @param DTOAsignacionesCobranza dto
  * @return void
  * @exception MareException 
  * @author enozigli 21/02/2005
  * @referencia SICC-DMCO-COB-201-324-N037, inc 13067, inc 13608
  */
  public void reasignarCartera(DTOAsignacionesCobranza dto) throws MareException{
    UtilidadesLog.info("MONReasignacionCarteraBean.reasignarCartera(DTOAsignacionesCobranza dto): Entrada");
      
      DAOReasignacionCartera daoReasCar = new DAOReasignacionCartera();
      RecordSet rsAsigCobInd = daoReasCar.buscarAsignacionesCobranzaIndividuales(dto).getResultado();
      
      int rows = rsAsigCobInd.getRowCount();
      try
      {
        AsignacionCobranzaLocalHome aclh = (AsignacionCobranzaLocalHome)this.getAsignacionCobranzaLocalHome();
        CronogramaCobranzaLocalHome cclh = (CronogramaCobranzaLocalHome)this.getCronogramaCobranzaLocalHome();
        MONProcesosPEDHome mpph = (MONProcesosPEDHome)this.getMONProcesosPEDHome();
        MONProcesosPED monProcesosPED = mpph.create();
        
        for(int i=0;i<rows;i++) {
            AsignacionCobranzaLocal asignacionCobranzaOrigen = (AsignacionCobranzaLocal)aclh.findByPrimaryKey(BigToLong(rsAsigCobInd.getValueAt(i,"OID_ASIG_COBR")));
            asignacionCobranzaOrigen.setOidEstadoAsignacion(ConstantesCOB.OID_ESTA_ASIG_REASIGNADA);
            
            aclh.merge(asignacionCobranzaOrigen);                
            
            CronogramaCobranzaLocal cronogramaOrigen = cclh.findByPrimaryKey(asignacionCobranzaOrigen.getCartera());//cartera es el oidCronogramaCobranza
            DTOCronogramaCobranza filtroCronograma = new DTOCronogramaCobranza();
            filtroCronograma.setOidPais(dto.getOidPais());
            filtroCronograma.setOidPeriodo(dto.getPeriodo());
            filtroCronograma.setOidTerritorio(cronogramaOrigen.getTerritorio());
            filtroCronograma.setOidZona(cronogramaOrigen.getZona());
            filtroCronograma.setOidSeccion(cronogramaOrigen.getSeccion());
            filtroCronograma.setOidSubgerenciaVentas(cronogramaOrigen.getSubgerenciaVentas());
            filtroCronograma.setOidRegion(cronogramaOrigen.getRegion());
            filtroCronograma.setOidTipoCargo(cronogramaOrigen.getTipoCargo()); //inc 13613
            filtroCronograma.setOidEtapa(dto.getEtapaDeuda());
            filtroCronograma.setOidUsuarioCobranza(dto.getUsuarioDestino());
            
            Long cronogramaExistente = daoReasCar.obtenerOIDCronogramaFiltro(filtroCronograma);
            
            if (cronogramaExistente == null){
                DTONumeroSolicitud numeroSolicitud = new DTONumeroSolicitud();
                numeroSolicitud.setOidPais(dto.getOidPais());
                numeroSolicitud.setOidIdioma(dto.getOidIdioma());
                numeroSolicitud.setOperacion(new String("COB077"));
                String sidCartera = monProcesosPED.generaNumeroDocumento(numeroSolicitud);
                Long idCartera = Long.valueOf(sidCartera);
                
                CronogramaCobranzaLocal cronogramaCobranza = cclh.create(idCartera,asignacionCobranzaOrigen.getFechaAsignacion(),dto.getOidPais(),dto.getPeriodo(),cronogramaOrigen.getSubgerenciaVentas() ,cronogramaOrigen.getTipoCargo(),dto.getEtapaDeuda(),dto.getUsuarioDestino());
                cronogramaCobranza.setFechaEvaluacion(asignacionCobranzaOrigen.getFechaAsignacion());
                cronogramaCobranza.setFechaAuditoria(asignacionCobranzaOrigen.getFechaAsignacion());
                cronogramaCobranza.setObservaciones(null);
                cronogramaCobranza.setFechaAsignacion(asignacionCobranzaOrigen.getFechaAsignacion());
                cronogramaCobranza.setZona(cronogramaOrigen.getZona());
                cronogramaCobranza.setTerritorio(cronogramaOrigen.getTerritorio());
                cronogramaCobranza.setRegion(cronogramaOrigen.getRegion());
                cronogramaCobranza.setSeccion(cronogramaOrigen.getSeccion());
                
                cclh.merge(cronogramaCobranza);         
                
                cronogramaExistente = cronogramaCobranza.getOid();   
            }
            
            AsignacionCobranzaLocal asignacionCobranzaDestino = aclh.create(asignacionCobranzaOrigen.getPais(),asignacionCobranzaOrigen.getDatosMovimientosCCC(),asignacionCobranzaOrigen.getSociedad(),cronogramaExistente);
            
              asignacionCobranzaDestino.setFechaAsignacion(asignacionCobranzaOrigen.getFechaAsignacion());
              asignacionCobranzaDestino.setImporteDeudaAsignada(asignacionCobranzaOrigen.getImporteDeudaAsignada());
              asignacionCobranzaDestino.setImporteDeudaCancelada(asignacionCobranzaOrigen.getImporteDeudaCancelada());
              asignacionCobranzaDestino.setImporteOriginalDeuda(asignacionCobranzaOrigen.getImporteOriginalDeuda());
              asignacionCobranzaDestino.setLiquidacion(asignacionCobranzaOrigen.getLiquidacion());
              asignacionCobranzaDestino.setOidEstadoAsignacion(ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
              asignacionCobranzaDestino.setOidTipoCargoAbono(asignacionCobranzaOrigen.getOidTipoCargoAbono());
              
              aclh.merge(asignacionCobranzaDestino);   
            
        }//fin for rsAsigCobInd
         
      }catch (RemoteException ne) {
          ctx.setRollbackOnly();
          UtilidadesLog.error(ne);
          throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));             
      }catch (NamingException ne) {
          ctx.setRollbackOnly();
          UtilidadesLog.error(ne);
          throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
      } catch(NoResultException nre) {
          ctx.setRollbackOnly();
          nre.printStackTrace();
          throw new MareException(nre, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch(PersistenceException pex) {
          ctx.setRollbackOnly();
          pex.printStackTrace();
          throw new MareException(pex, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      } catch (CreateException ne) {
          ctx.setRollbackOnly();
          UtilidadesLog.error(ne);
          throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      
    UtilidadesLog.info("MONReasignacionCarteraBean.reasignarCartera(DTOAsignacionesCobranza dto): Salida");
  }
  
  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOAsignacionesCobranza dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida buscarAsignacionesCobranza(DTOAsignacionesCobranza dto) throws MareException
  {
    DAOReasignacionCartera daoReasCar = new DAOReasignacionCartera();
    return daoReasCar.buscarAsignacionesCobranza(dto);
  }


    private Integer BigToInteger(Object num) {
      if (num != null) {
          return (new Integer(((BigDecimal) num).intValue()));
      } else {
          return null;
      }
  }

  private Long BigToLong(Object num) {
      if (num != null) {
          return (new Long(((BigDecimal) num).longValue()));
      } else {
          return null;
      }
  }  

  private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
  }

private AsignacionCobranzaLocalHome getAsignacionCobranzaLocalHome() 
  {
    return new AsignacionCobranzaLocalHome();
  }
  
  private CronogramaCobranzaLocalHome getCronogramaCobranzaLocalHome()
  {
    return new CronogramaCobranzaLocalHome();
  }  

    private UsuariosEtapaCobranzaCabeceraLocalHome getUsuariosEtapaCobranzaCabecera()
  {
    return new UsuariosEtapaCobranzaCabeceraLocalHome();
  }

  private UsuariosEtapaCobranzaDetalleLocalHome getUsuariosEtapaCobranzaDetalle() 
  {
    return new UsuariosEtapaCobranzaDetalleLocalHome();
  }

}