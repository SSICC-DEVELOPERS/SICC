package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.ConstantesPedFaltantes;
import es.indra.sicc.dtos.ped.DTOEInformeFaltantes;
import es.indra.sicc.dtos.ped.DTOInformeFaltantes;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocalHome;
import es.indra.sicc.entidades.ped.ReporteFaltantesLocalHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class MONInformeFaltantesBean implements SessionBean  {
  SessionContext ctx;
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
      this.ctx=ctx;
  }

  public DTOInformeFaltantes ejecuta(DTOEInformeFaltantes DTO) throws MareException {
        UtilidadesLog.info("MONInformeFaltantesBean.ejecuta(DTOEInformeFaltantes DTO): Entrada ");
          /*
              1.- CNInformeFaltantes control = obtieneControl(); 
              2.- Se invoca a la operación correspondiente: 
              - Si dto.operacion == ConstantesPedFaltantes.OP_GENERA hace: 
              control.generaNuevo(dto); 
              - Si dto.operacion == ConstantesPedFaltantes.OP_APRUEBA hace: 
              control.aprueba(dto); 
              - Si dto.operacion == ConstantesPedFaltantes.OP_MUESTRA hace: 
              control.muestra(dto);
           */
         try{
            UtilidadesLog.debug("DTO QUE LLEGA A EJECUTA"+DTO);
             CNInformeFaltantes control = obtieneControl(); 
             if  (DTO.getOperacion() == ConstantesPedFaltantes.OP_GENERA){
                  UtilidadesLog.info("MONInformeFaltantesBean.ejecuta(DTOEInformeFaltantes DTO): Salida ");
                  return control.generaNuevo(DTO);
             } 
             if  (DTO.getOperacion() == ConstantesPedFaltantes.OP_APRUEBA){
                  UtilidadesLog.info("MONInformeFaltantesBean.ejecuta(DTOEInformeFaltantes DTO): Salida ");
                  return control.aprueba(DTO, ctx.getCallerPrincipal().getName().toString());
             }
             if  (DTO.getOperacion() == ConstantesPedFaltantes.OP_MUESTRA){
                  UtilidadesLog.info("MONInformeFaltantesBean.ejecuta(DTOEInformeFaltantes DTO): Salida ");
                  return control.muestra(DTO);
             }
             UtilidadesLog.info("MONInformeFaltantesBean.ejecuta(DTOEInformeFaltantes DTO): Salida ");
             return null;
         }catch(Exception e){
            ctx.setRollbackOnly();
            if (e instanceof MareException){
                throw (MareException)e;
            }
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e,UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
  }  

  public CNInformeFaltantes obtieneControl() throws MareException
  {
    return new CNInformeFaltantes(ctx);
  }

  private MONMantenimientoMFHome getMONMantenimientoMFHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONMantenimientoMFHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoMF"), MONMantenimientoMFHome.class);
  }


    private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException 
  {
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
  }


    public DTOOID cargaValidarFaltantes(DTOBelcorp dto) throws MareException
  {
/*
    Proceso 
    ======== 
    RecordSet registro = DAOInformeFaltantes.obtieneReportesNoAprobados(dto) 
    
    Se crea un DTOOID (dtoS) que se carga con: 
    Si registro contiene elementos 
    dtoS.oid = registro(0).oid 
    Si no 
    dtoS.oid = null 
    Fin del Si 
    
    Se retorna dtoS
    */
    UtilidadesLog.info("MONInformeFaltantesBean.cargaValidarFaltantes(DTOBelcorp dto): Entrada ");
    DAOInformesFaltantes dao = new DAOInformesFaltantes();
    UtilidadesLog.debug("antes obtieneReportesNoAprovados");
    RecordSet registro = dao.obtieneReportesNoAprovados(dto);
    DTOOID dtoS = new DTOOID();    
    if (!registro.esVacio()&&registro.existeFila(0)&&registro.getRowCount()>0){
      UtilidadesLog.debug("registro no vacio");        
      dtoS.setOid(BigToLong(registro.getValueAt(0,"OID")));      
      UtilidadesLog.info("MONInformeFaltantesBean.cargaValidarFaltantes(DTOBelcorp dto): Salida ");
      return dtoS;
    } else { 
      UtilidadesLog.debug("registro vacio");
      UtilidadesLog.info("MONInformeFaltantesBean.cargaValidarFaltantes(DTOBelcorp dto): Salida ");
      return dtoS;
    }
  }
  private Long BigToLong(Object num) {
      if (num != null) {
          return (new Long(((BigDecimal) num).longValue()));
      } else {
          return null;
      }
  }

}