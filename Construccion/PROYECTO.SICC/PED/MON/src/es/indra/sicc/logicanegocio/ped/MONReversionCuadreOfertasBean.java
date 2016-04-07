package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.pre.MONCuadreOfertasHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class MONReversionCuadreOfertasBean implements SessionBean  {
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

    /**
      // Revierte el cuadre realizado a una solicitud 
      Llama al método IServiceCuadreOfertas.revertirCuadre(DTOE) 

      Crea un DTOEstatusSolicitud con: 
      - status = ConstantesPED.ESTADO_SOLICITUD_VALIDADO 

      Devuelve DTOEstatusSolicitud 
    *
    *@autor jpbosnja
    **/
    public DTOEstatusSolicitud revertirCuadreOfertas(DTOSolicitudValidacion dtoe) throws MareException {
        UtilidadesLog.info("MONReversionCuadreOfertasBean.revertirCuadreOfertas(DTOSolicitudValidacion dtoe): Entrada ");
        try{
            getMONCuadreOfertasHome().create().revertirCuadre(dtoe);
        }catch (NamingException e){
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("Exception: ",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }     
        DTOEstatusSolicitud dtoS = new DTOEstatusSolicitud();
        dtoS.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONReversionCuadreOfertasBean.revertirCuadreOfertas(DTOSolicitudValidacion dtoe): Salida ");
        return dtoS;
    }

    private MONCuadreOfertasHome getMONCuadreOfertasHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONCuadreOfertasHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreOfertas"), MONCuadreOfertasHome.class);
    }
}