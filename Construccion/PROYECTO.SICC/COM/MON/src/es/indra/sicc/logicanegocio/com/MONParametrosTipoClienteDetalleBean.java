package es.indra.sicc.logicanegocio.com;
import es.indra.sicc.entidades.com.TipoClienteComisionesDetalleLocal;
import es.indra.sicc.entidades.com.TipoClienteComisionesDetalleLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.com.DTOTipoClienteComDetalle;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.i18n.MONI18n;
import es.indra.sicc.cmn.negocio.i18n.MONI18nHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;



public class MONParametrosTipoClienteDetalleBean implements SessionBean 
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
    { this.ctx = ctx; }

    public DTOSalida obtenerTipoClienteCOMGerente(DTOBelcorp dtoE) throws MareException
    {
		UtilidadesLog.info("MONParametrosTipoClienteDetalleBean.obtenerTipoClienteCOMGerente - Entrada");
        
        /*
            -> Crear DTOSalida dto 
            -> dto = DAOParametrosTipoClienteDetalle(dto:DTOBelcorp):DTOSalida 
            -> Retornar dto
        */

		DAOParametrosTipoClienteDetalle dao = new DAOParametrosTipoClienteDetalle();
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida = dao.obtenerTipoClienteCOMGerente(dtoE);
        
		UtilidadesLog.info("MONParametrosTipoClienteDetalleBean.obtenerTipoClienteCOMGerente - Salida");
        
        return dtoSalida;        
    }

    public void guardarTipoClienteComDetalle(DTOTipoClienteComDetalle dtoE) throws MareException
    {
		UtilidadesLog.info("MONParametrosTipoClienteDetalleBean.guardarTipoClienteComDetalle - Entrada");
       
        /*
            Proceso: 
            Si dto.get(oid) == null 
                -> Hacer un create en la entidad COM-TipoClienteComisionesDetalle con los atributos seteados en el dto recibido por parámetro 
                -> MONI18N.insertarTraducciones ('COM_TIPO_CLIEN_COMIS_DETAL', oid, dto.getvectorTraducciones) 
            sino 
                -> MONI18N.actualizarTraducciones('COM_TIPO_CLIEN_COMIS_DETAL', dto.get(oid), dto.getvectorTraducciones) 
        */
        
        Long oid = null;
        
        if (dtoE.getOidTipoClienteComDetalle() == null) 
        {
           try {
                TipoClienteComisionesDetalleLocalHome tipoClieComDetalleHome = this.getTipoClienteComisionesDetalleLocalHome();
                TipoClienteComisionesDetalleLocal tipoClieComDetalleLocal = 
                    tipoClieComDetalleHome.create(dtoE.getIdSubclasificacion(), dtoE.getOidTipoCliente());
                
                if (dtoE.getOidClasificacion() != null) 
                {
                    tipoClieComDetalleLocal.setClasOidClas(dtoE.getOidClasificacion());
                }
                
                if (dtoE.getOidSubtipoCliente() != null) 
                {
                    tipoClieComDetalleLocal.setSbtiOidSubtClie(dtoE.getOidSubtipoCliente());
                }
                
                if (dtoE.getOidTipoClasificacion() != null)
                {
                    tipoClieComDetalleLocal.setTcclOidTipoClas(dtoE.getOidTipoClasificacion());
                }
                
                tipoClieComDetalleHome.merge(tipoClieComDetalleLocal);
                
                oid = tipoClieComDetalleLocal.getOid();
            } catch(PersistenceException e) {
                 ctx.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", e);
                 throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }      
        }
        else
        {
            oid = dtoE.getOidTipoClienteComDetalle();
        }
        
        try {
            MONI18n idioma = this.getMONi18n();
            idioma.insertarTraducciones("COM_TIPO_CLIEN_COMIS_DETAL", oid, dtoE.getVectorTraducciones());
        } catch(RemoteException rm){
            this.loguearError("guardarTipoClienteComDetalle: RemoteException:MONI18n",rm);
            throw new MareException(rm,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
        }


		UtilidadesLog.info("MONParametrosTipoClienteDetalleBean.guardarTipoClienteComDetalle - Salida");
   
    }

    public DTOSalida buscarTipoClienteComDetalle(DTOTipoClienteComDetalle dtoE) throws MareException
    {
    
		UtilidadesLog.info("MONParametrosTipoClienteDetalleBean.buscarTipoClienteComDetalle - Entrada");

        /*
            -> Crear DTOSalida dtoSalida 
            -> dtoSalida = DAPParametrosTipoClienteComDetalle.buscarTipoClienteComDetalle(dtoE) 
            -> retornar dtoSalida
        */

		DAOParametrosTipoClienteDetalle dao = new DAOParametrosTipoClienteDetalle();
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida = dao.buscarTipoClienteComDetalle(dtoE);
        
		UtilidadesLog.info("MONParametrosTipoClienteDetalleBean.buscarTipoClienteComDetalle - Salida");
        
        return dtoSalida;    
    }
    
    private MONI18n getMONi18n() throws MareException 
    {
        // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  getMONi18n: Entrada");				
        MONI18nHome home = (MONI18nHome)UtilidadesEJB.getHome(
        "MONI18n", MONI18nHome.class);
            
        // Se obtiene el interfaz remoto
        MONI18n ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.loguearError("*** Error en getMONi18n",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.debug("****Metodo  getMONi18n: Salida");		        
        return ejb;
    }
    
    
   	private void loguearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		UtilidadesLog.error(e);
	}

    private MONI18nHome getMONI18nHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONI18nHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONI18n"), MONI18nHome.class);
    }


    public void eliminarTipoClienteComDetalle(DTOOIDs dto) throws MareException
    {
    
        UtilidadesLog.info("***MONParametrosTipoClienteDetalleBean.eliminarTipoClienteComDetalle - Entrada");
 
        TipoClienteComisionesDetalleLocalHome tipoClieComDetalleHome;
        TipoClienteComisionesDetalleLocal tipoClieComDetalleLocal;

        try{
        
            tipoClieComDetalleHome = this.getTipoClienteComisionesDetalleLocalHome();
        
            Long[] vec=dto.getOids();
            for(int i=0; vec.length>i; i++) {
                     tipoClieComDetalleLocal = tipoClieComDetalleHome.findByPrimaryKey(vec[i]); 
                     
                    try{ 
                        tipoClieComDetalleHome.remove(tipoClieComDetalleLocal);                   
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        throw new MareException(pe, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }                    
            }
        } catch(NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException pex) {
            ctx.setRollbackOnly();
            throw new MareException(pex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("***MONParametrosTipoClienteDetalleBean.eliminarTipoClienteComDetalle - Salida");
    
    }
    
    private TipoClienteComisionesDetalleLocalHome getTipoClienteComisionesDetalleLocalHome()  throws MareException {
            
       return new TipoClienteComisionesDetalleLocalHome();
    }
   
}