package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.ped.NumerosSolicitudLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocalHome;

import es.indra.sicc.util.BelcorpService;

import java.util.ArrayList;

public class MONProcesosPEDBean implements SessionBean, IGenerarNumeroDocumento   {

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

  public String generaNumeroDocumento(DTONumeroSolicitud dto) throws MareException {
    UtilidadesLog.info("MONProcesosPEDBean.generaNumeroDocumento(DTONumeroSolicitud dto): Entrada ");
    try{
        CNGeneraNumeroSolicitud numDoc = new CNGeneraNumeroSolicitud();
        UtilidadesLog.info("MONProcesosPEDBean.generaNumeroDocumento(DTONumeroSolicitud dto): Salida ");
        return numDoc.generaNumero(dto);
    }catch (MareException e){
        ctx.setRollbackOnly();
        throw e;
    }
  }
  
  public String generaSecuenciaDocumento(DTONumeroSolicitud dto) throws MareException {
    UtilidadesLog.info("MONProcesosPEDBean.generaSecuenciaDocumento(DTONumeroSolicitud dto): Entrada ");
    try{
        CNGeneraNumeroSolicitud numDoc = new CNGeneraNumeroSolicitud();
        UtilidadesLog.info("MONProcesosPEDBean.generaSecuenciaDocumento(DTONumeroSolicitud dto): Salida ");
        return numDoc.generaSecuencia(dto);
    }catch (MareException e){
        ctx.setRollbackOnly();
        throw e;
    }
  }


    public String ejecutarFuncionNumeroSolicitud(ArrayList arrayParametros) throws MareException {
        String numeroSolicitud = null;
        try {       
          numeroSolicitud = BelcorpService.getInstance().dbService.ExecuteFunction("OBT_NUMER_SOLIC", arrayParametros);        
        } catch(Exception e) {
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
        } 
        return numeroSolicitud;
    }

    private MONProcesosPEDLocalHome getMONProcesosPEDLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONProcesosPEDLocalHome) context.lookup( "java:comp/env/ejb/local/MONProcesosPED" );
    }
}
