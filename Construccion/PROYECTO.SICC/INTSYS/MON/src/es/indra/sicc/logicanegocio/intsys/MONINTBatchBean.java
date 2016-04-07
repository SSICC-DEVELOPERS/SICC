package es.indra.sicc.logicanegocio.intsys;
import es.indra.sicc.util.DTOOID;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
//import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;
import es.indra.sicc.util.DTOString;

import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;



import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.logicanegocio.intsys.MONINTSAP;
import es.indra.sicc.logicanegocio.intsys.MONINTSAPHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONINTBatchBean implements SessionBean  {
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    public DTOSalidaBatch generarEntradaSAP(DTOBatch dto) throws MareException {
        /**
         * MODIFICADO POR INCIDENCIA BELC300012386
         * IMareDTO dto = dtoe.getDTOOnline()
         * - se obtiene el oid del pais, a partir del código:
         * Pais pais = PaisHome.findByUK( dto.getString( "codigoPais" ) )"
         * MONINTSAP.generarEntradaSAP( new DTOOID( pais.oid ) ) 
         * Retornar new DTOBatch( 0, "Proceso generarEntrada finalizado" ) 
         *  
         */
         
         
        //Modificado por incidencia BELC300012386 y pendiente incidencia 12777
        UtilidadesLog.info("MONINTBatchBean.generarEntradaSAP(DTOBatch dto): Entrada");
        MONINTSAP monINTSAP = this.getMONINTSAP();
        IMareDTO dtoPais = (DTOString)dto.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
          paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
          dtoOid.setOid(paisLocal.getOid());
          monINTSAP.generarEntradaSAP(dtoOid);
        }catch (NoResultException fe) {
            UtilidadesLog.error(
                "MONINTBatch.generarEntradaSAP: FinderException, no existe Pais = "+dtoPais.getString("cadena"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException re){
              UtilidadesLog.error(re);
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
          } 
        
        UtilidadesLog.info("MONINTBatchBean.generarEntradaSAP(DTOBatch dto): Salida");
        return new DTOSalidaBatch(0,"Proceso generarEntrada finalizado");
        
    }

    public DTOSalidaBatch recepcionarNegocio(DTOBatch dtoe) throws MareException {
         /*DTOBelcorp dtoPais = dtoe.getDTOOnline() 
        - se obtiene el oid del pais, a partir del código: 
        Pais pais = PaisHome.findByUK( dtoPais.codigoPais ) 
        MONINTSAP.recepcionarNegocio( new DTOOID( pais.oid ) ) 
        Retornar new DTOBatch( 0, "Proceso recepcionarNegocio finalizado" )*/
        UtilidadesLog.info("MONINTBatchBean.recepcionarNegocio(DTOBatch dtoe): Entrada");
        MONINTSAP monINTSAP = this.getMONINTSAP();
        IMareDTO dtoPais = (DTOString)dtoe.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        //dtoPais.getString(dtoe.getDTOOnline().getString("PE"))
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
          paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
          dtoOid.setOid(paisLocal.getOid());
          dtoOid.setOidPais(paisLocal.getOid());
          monINTSAP.recepcionarNegocio(dtoOid);
        }catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.recepcionarNegocio: FinderException, no existe Pais = "+dtoPais.getString("codigoPais"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException re){              
              UtilidadesLog.error(re);
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
          } 
        UtilidadesLog.info("MONINTBatchBean.recepcionarNegocio(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0,"Proceso recepcionarNegocio finalizado");
    }

    public DTOSalidaBatch recepcionarSupergenerico(DTOBatch dtoe) throws MareException {
        /*DTOBelcorp dtoPais = dtoe.getDTOOnline() 
        - se obtiene el oid del pais, a partir del código: 
        Pais pais = PaisHome.findByUK( dtoPais.codigoPais ) 
        MONINTSAP.recepcionarSupergenerico( new DTOOID( pais.oid ) ) 
        Retornar new DTOBatch( 0, "Proceso recepcionarSupergenerico finalizado" ) */
        UtilidadesLog.info("MONINTBatchBean.recepcionarSupergenerico(): Entrada");
        MONINTSAP monINTSAP = this.getMONINTSAP();
        IMareDTO dtoPais = dtoe.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
          paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
          dtoOid.setOid(paisLocal.getOid());
          dtoOid.setOidPais(paisLocal.getOid());
          monINTSAP.recepcionarSupergenerico(dtoOid);
        }catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.recepcionarSuperNegocio: FinderException, no existe Pais = "+dtoPais.getString("codigoPais"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException re){
              UtilidadesLog.error(re);
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
          } 
        
        UtilidadesLog.info("MONINTBatchBean.recepcionarSupergenerico(): Salida");
        return new DTOSalidaBatch(0,"Proceso recepcionarSuperNegocio finalizado");
    }

    public DTOSalidaBatch recepcionarGenerico(DTOBatch dtoe) throws MareException {
         /*DTOBelcorp dtoPais = dtoe.getDTOOnline() 
        - se obtiene el oid del pais, a partir del código: 
        Pais pais = PaisHome.findByUK( dtoPais.codigoPais ) 
        MONINTSAP.recepcionarGenerico( new DTOOID( pais.oid ) ) 
        Retornar new DTOBatch( 0, "Proceso recepcionarGenerico finalizado" ) */
        UtilidadesLog.info("MONINTBatchBean.recepcionarGenerico(DTOBatch dtoe): Entrada");
        MONINTSAP monINTSAP = this.getMONINTSAP();
        IMareDTO dtoPais = (DTOString)dtoe.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
          paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
          dtoOid.setOid(paisLocal.getOid());
          dtoOid.setOidPais(paisLocal.getOid());
          monINTSAP.recepcionarGenerico(dtoOid);
        }catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.recepcionarGenerico: FinderException, no existe Pais = "+dtoPais.getString("codigoPais"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException re){              
              UtilidadesLog.error(re);
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
          } 
        UtilidadesLog.info("MONINTBatchBean.recepcionarGenerico(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0,"Proceso recepcionarGenerico finalizado");
    }

    public DTOSalidaBatch recepcionarProductos(DTOBatch dtoe) throws MareException {
         UtilidadesLog.info("MONINTBatchBean.recepcionarProductos(DTOBatch dtoe): Entrada");
        /*
                     * Documentation
            DTOBelcorp dtoPais = dtoe.getDTOOnline() 
            - se obtiene el oid del pais, a partir del código: 
            Pais pais = PaisHome.findByUK( dtoPais.codigoPais ) 
            MONINTSAP.recepcionarProductos( new DTOOID( pais.oid ) ) 
            Retornar new DTOBatch( 0, "Proceso recepcionarProductos finalizado" ) 

         * */
        MONINTSAP monINTSAP = this.getMONINTSAP();
        IMareDTO dtoPais = dtoe.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
          paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
          dtoOid.setOid(paisLocal.getOid());
          monINTSAP.recepcionarProductos(dtoOid);
        }catch (NoResultException fe) {
            UtilidadesLog.error(
                "MONINTBatch.recepcionarProductos: FinderException, no existe Pais = "+dtoPais.getString("codigoPais"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException re){              
              UtilidadesLog.debug("***MONINTBatch.recepcionarProductos: error RemoteException");
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
          } 
        UtilidadesLog.info("MONINTBatchBean.recepcionarProductos(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0,"Proceso recepcionarProductos finalizado");    
    }

    public DTOSalidaBatch recepcionarDescripcionProductosIdioma(DTOBatch dtoe) throws MareException {
         UtilidadesLog.info("MONINTBatchBean.recepcionarDescripcionProductosIdioma(DTOBatch dtoe): Entrada");
        /*
             DTOBelcorp dtoPais = dtoe.getDTOOnline() 
            - se obtiene el oid del pais, a partir del código: 
            Pais pais = PaisHome.findByUK( dtoPais.codigoPais ) 
            MONINTSAP.recepcionarDescripcionProductosIdioma( new DTOOID( pais.oid ) ) 
            Retornar new DTOBatch( 0, "Proceso recepcionarDescripcionProductosIdioma 
            finalizado" ) 

         * */
        MONINTSAP monINTSAP = this.getMONINTSAP();
        IMareDTO dtoPais = dtoe.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
          paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
          dtoOid.setOid(paisLocal.getOid());
          monINTSAP.recepcionarDescripcionProductosIdioma(dtoOid);
        }catch (NoResultException fe) {
            UtilidadesLog.error(
                "MONINTBatch.recepcionarDescripcionProductosIdioma: FinderException, no existe Pais = "+dtoPais.getString("codigoPais"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException re){              
              UtilidadesLog.error(re);
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
          } 
        
        UtilidadesLog.info("MONINTBatchBean.recepcionarDescripcionProductosIdioma(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0,"Proceso recepcionarDescripcionProductosIdioma finalizado");
    
    }

    public DTOSalidaBatch recepcionarStocksDiarios(DTOBatch dtoe) throws MareException {
         UtilidadesLog.info("MONINTBatchBean.recepcionarStocksDiarios(DTOBatch dtoe): Entrada");
        /*
                      
            DTOBelcorp dtoPais = dtoe.getDTOOnline() 
            - se obtiene el oid del pais, a partir del código: 
            Pais pais = PaisHome.findByUK( dtoPais.codigoPais ) 
            MONINTSAP.recepcionarStocksDiarios( new DTOOID( pais.oid ) ) 
            Retornar new DTOBatch( 0, "Proceso recepcionarStocksDiarios finalizado" ) 
        * */
        MONINTSAP monINTSAP = this.getMONINTSAP();
        IMareDTO dtoPais = dtoe.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
          paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
          dtoOid.setOid(paisLocal.getOid());
          monINTSAP.recepcionarStocksDiarios(dtoOid);
        }catch (NoResultException fe) {
            UtilidadesLog.error(
                "MONINTBatch.recepcionarStocksDiarios: FinderException, no existe Pais = "+dtoPais.getString("codigoPais"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException re){
              UtilidadesLog.error(re);
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
          } 
        UtilidadesLog.info("MONINTBatchBean.recepcionarStocksDiarios(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0,"Proceso recepcionarStocksDiarios finalizado");
    }

    private MONINTSAP getMONINTSAP() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTBatchBean.getMONINTSAP(): Entrada");
        MONINTSAPHome home = (MONINTSAPHome)UtilidadesEJB.getHome(
        "MONINTSAP", MONINTSAPHome.class);
        // Se obtiene el interfaz remoto
        MONINTSAP ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
        UtilidadesLog.info("MONINTBatchBean.getMONINTSAP(): Salida");	        
        return ejb;
	}      

    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     * 
     * Descripc.: (PTL-2)
     */    
    public DTOSalidaBatch recepcionarInfoEtiquetasBatch(DTOBatch dtoe) throws MareException {
    
        UtilidadesLog.info("MONINTBatchBean.recepcionarInfoEtiquetasBatch(DTOBatch dtoe): Entrada");

        MONINTPTL monINTPTL = this.getMONINTPTL();
        
        UtilidadesLog.debug("   - SAP601: antes del 'getDTOOnline()'.... ");
        IMareDTO dtoPais = dtoe.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        
        try{
            UtilidadesLog.debug("   - SAP601: hace el findByUK! ");
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            dtoOid.setOidPais(paisLocal.getOid());
                      
            UtilidadesLog.debug("   - SAP601: llama a 'recepcionarInformacionEtiquetas' ");
            monINTPTL.recepcionarInformacionEtiquetas(dtoOid);
            UtilidadesLog.debug("   - SAP601: retornó ! ");
          
        } catch (NoResultException fe) {
            UtilidadesLog.error(
                "MONINTBatch.recepcionarInfoEtiquetasBatch: FinderException, no existe Pais = "+dtoPais.getString("codigoPais"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException re){              
            UtilidadesLog.debug("***MONINTBatch.recepcionarInfoEtiquetasBatch: error RemoteException");
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
        } 
        
        UtilidadesLog.info("MONINTBatchBean.recepcionarInfoEtiquetasBatch(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0,"Proceso recepcionarInfoEtiquetasBatch finalizado");    
    }
    
    
    private MONINTPTL getMONINTPTL() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTBatchBean.getMONINTPTL(): Entrada");
        MONINTPTLHome home = (MONINTPTLHome)UtilidadesEJB.getHome(
        "MONINTPTL", MONINTPTLHome.class);
        // Se obtiene el interfaz remoto
        MONINTPTL ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
        UtilidadesLog.info("MONINTBatchBean.getMONINTPTL(): Salida");	        
        return ejb;
	} 

   /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     * 
     * Descripc.: (PTL-3)
     */    
    public DTOSalidaBatch recepcionarPedProcesPTLBatch(DTOBatch dtoe) throws MareException {
    
        UtilidadesLog.info("MONINTBatchBean.recepcionarPedProcesPTLBatch(DTOBatch dtoe): Entrada");

        MONINTPTL monINTPTL = this.getMONINTPTL();
        
        UtilidadesLog.debug("   - SAP601: antes del 'getDTOOnline()'.... ");
        IMareDTO dtoPais = dtoe.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        
        try{
            UtilidadesLog.debug("   - SAP601: hace el findByUK! ");
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            dtoOid.setOidPais(paisLocal.getOid());
          
            UtilidadesLog.debug("   - SAP601: llama a 'recepcionarPedidosProcesadosPTL' ");
            monINTPTL.recepcionarPedidosProcesadosPTL(dtoOid);
            UtilidadesLog.debug("   - SAP601: retornó ! ");
          
        } catch (NoResultException fe) {
            UtilidadesLog.error(
                "MONINTBatch.recepcionarPedProcesPTLBatch: FinderException, no existe Pais = "+dtoPais.getString("codigoPais"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException re){              
            UtilidadesLog.debug("***MONINTBatch.recepcionarPedProcesPTLBatch: error RemoteException");
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
        } 
        
        UtilidadesLog.info("MONINTBatchBean.recepcionarPedProcesPTLBatch(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0,"Proceso recepcionarPedProcesPTLBatch finalizado");    
    }
    
    private PaisLocalHome getPaisLocalHome() {
            return new PaisLocalHome();
    }

    
    
    
  
}