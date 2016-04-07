 /**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.cmn.negocio.print;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.print.DAOPrinterSystem;
import es.indra.sicc.cmn.negocio.print.SpoolConfiguration;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class SpoolManagerBean implements SessionBean, IImpresion  {

	private SessionContext ctx;

	private SpoolConfiguration spoolConfiguration;     
	private static final Long timeOutBlock  = new Long(30000);
    private Long subaccesoFicticio =new Long("888");
    private UtilidadesLog log = new UtilidadesLog();

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

  
    public Long addPrintableDocuments(DTODocumento dtoDocumento, Long idSpool) throws MareException {

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("*** Metodo SpoolManager.addPrintableDocuments: Entrada Spool= "+idSpool);
            UtilidadesLog.debug(" DTODocuemento.getTipodocumento = "+dtoDocumento.getTipoDocumento());
            UtilidadesLog.debug(" DTODocuemento.getNumSecuencia = "+dtoDocumento.getNumSecuencia());
            UtilidadesLog.debug(" DTODocuemento.getDocumentoByte = "+dtoDocumento.getDocumentoByte());
        }              
            
        DAOPrinterSystem dao = new DAOPrinterSystem(ctx);
        Long numSecue = null;
        if (dtoDocumento.getNumSecuencia()!=null){
            numSecue = new Long(dtoDocumento.getNumSecuencia().intValue());            
        }
        Long clave = dao.addDocument(idSpool, numSecue, dtoDocumento.getDocumentoByte(), dtoDocumento.getTipoDocumento());
        
        UtilidadesLog.debug("*** Metodo SpoolManager.addPrintableDocuments: Salida ***");
        return clave;
    }


    public void closeSpool(Long idSpool) throws MareException {
        UtilidadesLog.debug("*** Metodo SpoolManager.closeSpool: Entrada ***");
		try{
            IMPSpoolLocalHome spoolHome = new IMPSpoolLocalHome();
            IMPSpoolLocal spoolLocal = spoolHome.findByPrimaryKey(idSpool);
            boolean active = spoolLocal.getActive().booleanValue();
            DAOPrinterSystem daoP = new DAOPrinterSystem(ctx);
            daoP.closeSpool(idSpool);
            
            if (active){
                DAOPrinterConfiguration dao = new DAOPrinterConfiguration();        
                Vector config = dao.recoverConfiguration(idSpool);
                for (int i = 0 ; i < config.size() ; i++ ){
                    PrinterConfiguration pc = (PrinterConfiguration)config.get(i);
                    getSpoolManagerLocalHome().create().closeQueue(pc);
                }
                daoP.desactivateSpool(idSpool);
                this.nextActivate(idSpool);
            }else{
                UtilidadesLog.debug("El spool esta desactivo");
                spoolLocal.setIndPeticionCierre(Boolean.TRUE);
                try {
                    spoolHome.merge(spoolLocal);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error al hacer merge en IMPSpoolLocal", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }            
        }catch (Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR AL CERRAR EL SPOOL",e);
            throw new MareException(e);
        }
        
		UtilidadesLog.debug("*** Metodo SpoolManager.closeSpool: Salida ***");
	}

    public void closeSpoolEtiquetas(Long idSpool) throws MareException {
        UtilidadesLog.debug("SpoolManagerBean.closeSpool(Long idSpool): Entrada");
        try{
            IMPSpoolLocalHome spoolHome = new IMPSpoolLocalHome();
            IMPSpoolLocal spoolLocal = spoolHome.findByPrimaryKey(idSpool);
            boolean active = spoolLocal.getActive().booleanValue();
            DAOPrinterSystem daoP = new DAOPrinterSystem(ctx);
            daoP.closeSpool(idSpool);
            
            if (active){
                DAOPrinterConfiguration dao = new DAOPrinterConfiguration();        
                Vector config = dao.recoverConfigurationEtiquetas(idSpool);
                for (int i = 0 ; i < config.size() ; i++ ){
                    PrinterConfiguration pc = (PrinterConfiguration)config.get(i);
                    getSpoolManagerLocalHome().create().closeQueue(pc);
                }
                daoP.desactivateSpool(idSpool);
                this.nextActivate(idSpool);
            }else{
                UtilidadesLog.debug("El spool esta desactivo");
                spoolLocal.setIndPeticionCierre(Boolean.TRUE);
                try {
                    spoolHome.merge(spoolLocal);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }            
        }catch (Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR AL CERRAR EL SPOOL",e);
            throw new MareException(e);
        }
        
        UtilidadesLog.debug("SpoolManagerBean.closeSpool(Long idSpool): Entrada");
    }


    
    private PrinterSystemEJBLocalHome getPrinterSystemEJBLocalHome() throws MareException {
        UtilidadesLog.debug("****Metodo getPrinterSystemEJBLocalHome: Entrada");
        PrinterSystemEJBLocalHome printerSystemEJBLocalHome=(PrinterSystemEJBLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/PrinterSystemEJB");
        UtilidadesLog.debug("****Metodo getPrinterSystemEJBLocalHome: Entrada");
        return printerSystemEJBLocalHome;
    }

    public Long openSpool(Long subacceso) throws MareException{
        UtilidadesLog.debug("SpoolManager.openSpool con SUBACCESO");

        DAOPrinterSystem dao = new DAOPrinterSystem(ctx);

        Long clave = dao.createSpool(new Timestamp(System.currentTimeMillis()), subacceso); // camabiado por 15675

        DAOPrinterConfiguration daoP = new DAOPrinterConfiguration();

        boolean multiSpoolEnable = daoP.recoverMultiSpoolEnable();
        if (! multiSpoolEnable){
            dao.desactivateAll(subacceso, clave);
        }
        
        if (subacceso.longValue() == subaccesoFicticio.longValue() || dao.isSpoolVoid(subacceso).booleanValue() == true){
            UtilidadesLog.debug("Spool Manager Activamos El Spoool " + clave);
            //-Si devuelve FALSE llamo al método activateSpool del SpoolConfiguration pasandole el oidSpool (obtenido en el punto 1). 
            dao.activateSpool(clave);
        }		//5.- Devolvemos el Long que obtuvimos en el psao 1.
        UtilidadesLog.debug("*** Metodo SpoolManager.openSpool: conSUBACCESO Salida ***");
        UtilidadesLog.debug("*** \n\n Acabado openSpoolcon SUBACCESO\n\n ***");
        return clave;
    }
    
    
    
    /* dmorello 21/06/2007: deja de recibir sublinea, recibe impresoraEtiquetas */
    public Long openSpoolEtiquetas(Long subacceso, Long impresoraEtiquetas) throws MareException{
        UtilidadesLog.debug("SpoolManagerBean.openSpoolEtiquetas(Long subacceso, Long sublinea): Entrada");

        DAOPrinterSystem dao = new DAOPrinterSystem(ctx);

        Long clave = dao.createSpool(new Timestamp(System.currentTimeMillis()), subacceso, impresoraEtiquetas);

        DAOPrinterConfiguration daoP = new DAOPrinterConfiguration();

        boolean multiSpoolEnable = daoP.recoverMultiSpoolEnable();
        if (! multiSpoolEnable){
            dao.desactivateAll(subacceso, clave);
        }
        
        if (subacceso.longValue() == subaccesoFicticio.longValue() || dao.isSpoolVoid(subacceso).booleanValue() == true){
            UtilidadesLog.debug("Spool Manager Activamos El Spoool " + clave);
            //-Si devuelve FALSE llamo al método activateSpool del SpoolConfiguration pasandole el oidSpool (obtenido en el punto 1). 
            dao.activateSpool(clave);
        }		//5.- Devolvemos el Long que obtuvimos en el psao 1.
        UtilidadesLog.debug("SpoolManagerBean.openSpool(Long subacceso, Long sublinea): Salida");
        return clave;
    }
    

    public void nextActivate(Long idSpool) throws MareException{
        //Documentation
		//ENTRADA: 
		//RESUMEN: El objetivo de este método es activar el siguiente spool una vez
		//se ha cerrado el que estaba activo. 
		try{
            UtilidadesLog.debug("*** Metodo SpoolManager.nextActivation: Entrada ***");
		//1.- Creamos una instancia del objeto DAOPrinterSystem y llamamos al 
		//método getNextActive(). Si devuelve null no hago nada, 
		//si es != null entonces llamo al método activateSpool del SpoolConfiguration 
		//pasando el Long que devuelve el dao.

            DAOPrinterSystem dao = new DAOPrinterSystem();
            Long idSpool2 = dao.getNextActive(idSpool);
            if (idSpool2 != null){
                IMPSpoolLocalHome spoolHome = new IMPSpoolLocalHome();
                IMPSpoolLocal spoolLocal = spoolHome.findByPrimaryKey(idSpool2);
                spoolLocal.setActive(Boolean.TRUE);
                try {
                    spoolHome.merge(spoolLocal);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                if (spoolLocal.getIndPeticionCierre()!=null && spoolLocal.getIndPeticionCierre().booleanValue()){
                    this.getSpoolManagerLocalHome().create().closeSpool(idSpool2);
                }
            }
        }catch(Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        
        }
            UtilidadesLog.debug("*** Metodo SpoolManager.nextActivation: Salida ***");
    }

    public void closeQueue(PrinterConfiguration pc) throws MareException{
        RecordSet rs=null;
        DAOPrinterSystem daoActivo= new DAOPrinterSystem();
        while (!(rs=daoActivo.checkBuffer(pc.getIdQueue(),pc.getBufferSize())).esVacio()){
            printDocuments(rs, pc);
        }
    }
    
    /**
     * CHANGELOG
     * ---------
     * Incidencia SiCC 20090869 - dmorello, 01/04/2009 04:00 a.m.
     *   - Se incluye en el proyecto la libreria Oracle JDBC
     *   - Se reemplaza el uso de Entity Beans por JDBC
     */
    protected void printDocuments(RecordSet documentos, PrinterConfiguration pc) throws MareException{//se le pasa boolean

        DAOPrinterSystem dao = new DAOPrinterSystem();
        
        byte[] documentoFinal= null;
    
        if(!documentos.esVacio()){
            for(int i=0; i<documentos.getRowCount();i++){
                try{
                    Long oidDocumImpri = new Long(((BigDecimal)documentos.getValueAt(i,"OID_DOCU_IMPR")).longValue());
                    byte[] arrayBytes = dao.obtenerBytesDocumento(oidDocumImpri);
                    String cadenaBytes="";
                    if (arrayBytes !=null)
                    cadenaBytes= new String(arrayBytes);
                    documentos.setValueAt(cadenaBytes,i,5);
                }catch (NoResultException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR",e);
                    throw new MareException(e);
                }catch (PersistenceException e) {
                    ctx.setRollbackOnly();    
                    UtilidadesLog.error("ERROR",e);
                    throw new MareException(e);
                }catch (Exception e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR",e);
                    throw new MareException(e);
                }
            }
            FactoriaFormateadores factoria= new FactoriaFormateadores();
            documentoFinal = factoria.formater(pc.getTecnologiaImpresion(),documentos);
            pc.getPrintType().print(documentoFinal);
            dao.updatePrinterDocuments(documentos);
                
        }
        UtilidadesLog.info("PrinterQueues.printDocuments(): Salida");
	}

    private SpoolManagerLocalHome getSpoolManagerLocalHome() throws NamingException{
        final InitialContext context = new InitialContext();
        return (SpoolManagerLocalHome)context.lookup("java:comp/env/ejb/local/SpoolManager");
    }

    public void closeSpoolColombia(Long idSpool) throws MareException {
        UtilidadesLog.debug("*** Metodo SpoolManager.closeSpoolColombia: Entrada ***");
		try{
            IMPSpoolLocalHome spoolHome = new IMPSpoolLocalHome();
            IMPSpoolLocal spoolLocal = spoolHome.findByPrimaryKey(idSpool);
            boolean active = spoolLocal.getActive().booleanValue();
            DAOPrinterSystem daoP = new DAOPrinterSystem(ctx);
            daoP.closeSpool(idSpool);
            
            if (active){
                DAOPrinterConfiguration dao = new DAOPrinterConfiguration();        
                Vector config = dao.recoverConfiguration(idSpool);
                for (int i = 0 ; i < config.size() ; i++ ){
                    PrinterConfiguration pc = (PrinterConfiguration)config.get(i);
                    getSpoolManagerLocalHome().create().closeQueueColombia(pc);
                }
                daoP.desactivateSpool(idSpool);
                this.nextActivate(idSpool);
            }else{
                UtilidadesLog.debug("El spool esta desactivo");
                spoolLocal.setIndPeticionCierre(Boolean.TRUE);
                try {
                    spoolHome.merge(spoolLocal);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e);
                }
            }            
        }catch (Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR AL CERRAR EL SPOOL DE Colombia",e);
            throw new MareException(e);
        }
        
		UtilidadesLog.debug("*** Metodo SpoolManager.closeSpoolColombia: Salida ***");
    
    }

    public void closeQueueColombia(PrinterConfiguration pc) throws MareException {
        RecordSet rs=null;
        DAOPrinterSystem daoActivo= new DAOPrinterSystem();
        while (!(rs = daoActivo.checkBuffer(pc.getIdQueue(),pc.getBufferSize())).esVacio()){
            printDocumentsColombia(rs, pc);
        }
    }

    protected void printDocumentsColombia(RecordSet documentos, PrinterConfiguration pc) throws MareException{//se le pasa boolean
        DAOPrinterSystem dao = new DAOPrinterSystem();
        byte[] documentoFinal= null;
 
        if(!documentos.esVacio()){
            for(int i=0; i<documentos.getRowCount();i++){
                try{
                    Long oidDocumImpri = new Long(((BigDecimal)documentos.getValueAt(i,"OID_DOCU_IMPR")).longValue());
                    byte[] arrayBytes = dao.obtenerBytesDocumento(oidDocumImpri);
                    
                    String cadenaBytes="";
                    if (arrayBytes !=null)
                    cadenaBytes= new String(arrayBytes);

                    documentos.setValueAt(cadenaBytes,i,5);
                }catch (PersistenceException e) {
                    UtilidadesLog.error("ERROR",e);
                    throw new MareException(e);
                }catch (Exception e) {
                    UtilidadesLog.error("ERROR",e);
                    throw new MareException(e);
                }
            }
            
            FactoriaFormateadores factoria= new FactoriaFormateadores();
            documentoFinal = factoria.formatearColombia(pc.getTecnologiaImpresion(),documentos);
            pc.getPrintType().print(documentoFinal);
            dao.updatePrinterDocuments(documentos);
                
        }
        UtilidadesLog.info("PrinterQueues.printDocuments(): Salida");
	}


}