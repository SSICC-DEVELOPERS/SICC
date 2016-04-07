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

import es.indra.sicc.cmn.negocio.print.IMPPrintableDocumentLocal;
import es.indra.sicc.cmn.negocio.print.IMPPrintableDocumentLocalHome;
import es.indra.sicc.cmn.negocio.print.IMPQueueLocal;
import es.indra.sicc.cmn.negocio.print.IMPQueueLocalHome;
import es.indra.sicc.cmn.negocio.print.IMPSpoolLocal;
import es.indra.sicc.cmn.negocio.print.IMPSpoolLocalHome;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACFormulario;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError; 
import es.indra.sicc.util.UtilidadesLog;


import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import oracle.sql.BLOB;


public class DAOPrinterSystem {

	private SessionContext ctx=null;

    public DAOPrinterSystem() {
		super();
    }

	public DAOPrinterSystem(SessionContext ctx){
		this.ctx= ctx;
	}
/*
    public Long createSpool(Timestamp startOwner, String serverID)
        throws MareException {
        UtilidadesLog.debug("***DAOPrinterSystem.createSpool: Entrada");

        IMPSpoolLocal local = null;

        try {
            IMPSpoolLocalHome home = this.getIMPSpoolLocalHome();

            //(Timestamp start, Boolean active, String serverID, Boolean open)
            local = home.create(startOwner, Boolean.TRUE, Boolean.TRUE, new Long("3"));

          // Crea nuevo registro en la tabla SPOOL.
            //                1.- Hacemos un create del entity Spool con los valores q se nos pasan por cabecera
              //                      y poniendo TRUE al atributo open y el atributo active.
                //                            Devolvemos la pk donde inserta el nuevo registro
                   
        } catch (MareException me) {
            throw new MareException("falla al recoger la referencia localHome DAOPrinterSystem.createSpool",
                me);
        } catch (CreateException ce) {
            throw new MareException("falla el create en DAOPrinterSystem.createSpool",
                ce);
        }

        UtilidadesLog.debug("***Spool creado:= " +(Long) local.getPrimaryKey());
        UtilidadesLog.debug("***DAOPrinterSystem.createSpool: Salida");

        return ((Long) local.getPrimaryKey());
    }
    */
    //*****************************Metodo Cambiado  *************15675*******************************
    
    public Long createSpool(Timestamp startOwner, Long subAcceso) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.createSpool(): Entrada");

        IMPSpoolLocal local = null;

        try {
            IMPSpoolLocalHome home = new IMPSpoolLocalHome();

            local = home.create(startOwner, Boolean.FALSE, Boolean.TRUE, subAcceso);
            local.setIndPeticionCierre(Boolean.FALSE);
            
            try {
                home.merge(local);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            RecordSet r = buscarColas(subAcceso);
            
            int countColas = r.getRowCount();
            
            for (int i = 0; i<countColas;i++){
                Long impre = new Long(r.getValueAt(i,0).toString());
                createQueue(((Long) local.getPrimaryKey()), impre);
            }

        } catch (PersistenceException e) {
            throw new MareException("falla el create en DAOPrinterSystem.createSpool",
                e);
        }

        UtilidadesLog.debug("***Spool creado:= " +(Long) local.getPrimaryKey());
        UtilidadesLog.info("DAOPrinterSystem.createSpool(): Salida");

        return ((Long) local.getPrimaryKey());
    }
    
    
    public Long createSpool(Timestamp startOwner, Long subAcceso, Long impresoraEtiquetas) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.createSpool(Timestamp startOwner, Long subAcceso, Long sublinea): Entrada");

        IMPSpoolLocal local = null;

        try {
            IMPSpoolLocalHome home = new IMPSpoolLocalHome();

            local = home.create(startOwner, Boolean.FALSE, Boolean.TRUE, subAcceso);
            local.setIndPeticionCierre(Boolean.FALSE);
            
            try {
                home.merge(local);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            
            //RecordSet r = this.buscarImpresorasEtiquetas(subAcceso, sublinea);
            /* dmorello, 21/06/2007 */
            //RecordSet r = this.buscarImpresorasEtiquetas(sublinea);
            //int countImpr = r.getRowCount();
            
            //for (int i = 0; i < countImpr; i++){
            //    Long impre = new Long(r.getValueAt(i,0).toString());
            //    createQueue(((Long) local.getPrimaryKey()), impre);
            //}
            createQueue((Long)local.getPrimaryKey(), impresoraEtiquetas);
            /* Fin dmorello 21/06/2007 */

         } catch (PersistenceException e) {
             throw new MareException("falla el create en DAOPrinterSystem.createSpool",
                 e);
         }


        UtilidadesLog.debug("***Spool creado:= " +(Long) local.getPrimaryKey());
        UtilidadesLog.info("DAOPrinterSystem.createSpool(Timestamp startOwner, Long subAcceso, Long sublinea): Entrada");

        return ((Long) local.getPrimaryKey());
    }
    
    public RecordSet buscarColas(Long subacceso) throws MareException {
        RecordSet rs3 = null;
        StringBuffer consulta = new StringBuffer("");

        consulta.append( " select distinct f.OID_IMPR from fac_impre_virtu f, fac_formu fa , fac_asign_impre fs where ");
        consulta.append( " f.OID_IMPR = fs.IMVI_OID_IMPR ");
        consulta.append( " and fs.FORS_OID_form = fa.OID_form ");
        consulta.append( " and fs.SBAC_OID_SBAC =  "+subacceso);
            
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
        try {
            rs3 = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR AL BUSCAR LAS COLAS",e);
            throw new MareException(e);
        }
        return rs3;
    }

    
    //public RecordSet buscarImpresorasEtiquetas(Long subacceso, Long sublinea) throws MareException {
    public RecordSet buscarImpresorasEtiquetas(Long sublinea) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.buscarImpresorasEtiquetas(Long subacceso, Long sublinea): Entrada");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT DISTINCT impresora.oid_impr ");
        consulta.append("   FROM fac_impre_virtu impresora, ape_asign_impre asign ");
        consulta.append("  WHERE impresora.oid_impr = asign.imvi_oid_impr ");
        //consulta.append("    AND asign.sbac_oid_sbac = ").append(subacceso);
        consulta.append("    AND asign.sbar_oid_subl_arma = ").append(sublinea);
            
        RecordSet rs = null;                    
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR AL BUSCAR LAS COLAS",e);
            throw new MareException(e);
        }

        UtilidadesLog.info("DAOPrinterSystem.buscarImpresorasEtiquetas(Long subacceso, Long sublinea): Entrada");
        return rs;
    }
    
    //*********************************************************************************************

    public Long createQueue(Long idSpool, Long idType) throws MareException { //modificado por BEL 11123
        UtilidadesLog.info("DAOPrinterSystem.createSpool(): Entrada");
        UtilidadesLog.debug("***Long idSpool = "+ idSpool);
        UtilidadesLog.debug("***Long idType = "+ idType);
        
        //RESUMEN: Crea un registro en la tabla QUEUE con toda la información
        //para representar una cola de impresion.
        //1.- Hacemos un create del entity Queue rellenando los campos usando los argumentos
        //de entrada del método y devolviendo la clave consecutiva que nos devuelve la base de datos
        IMPQueueLocal local=null;
        try{
            IMPQueueLocalHome home= new IMPQueueLocalHome();
            //(Long lastSequence, Timestamp startOwner, Long idType, Long idSpool)
            UtilidadesLog.debug("Antes de hacer el create(idType idSpool) ");
            local=home.create(idType,idSpool);
            UtilidadesLog.debug("Despues de hace rel create (idType idSpool) ");
                
        }catch(PersistenceException e){
            ctx.setRollbackOnly();
            throw new MareException("falla el create en DAOPrinterSystem.createQueue", e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }catch(Exception ce){
            ctx.setRollbackOnly();
            throw new MareException("falla el create en DAOPrinterSystem.createQueue", ce);
        }
        
        UtilidadesLog.debug("***DAOPrinterSystem.createQueue: ");
        UtilidadesLog.debug("***IDcola: "+local.getIdQueue());
        UtilidadesLog.debug("***IdSpool: "+local.getIdSpool());
        UtilidadesLog.debug("***getIdType: "+local.getIdType());
                

        UtilidadesLog.debug("***DAOPrinterSystem.createQueue: Salida  Cola Creada "+(Long) local.getPrimaryKey());
        UtilidadesLog.info("DAOPrinterSystem.createSpool(): Salida");
        return ((Long) local.getPrimaryKey()); //en el diseño viene boolean
    }


    ///Modificada la cabecera por BELC300011133
    public Long addDocument(Long idQueue, Long numSecuencia, byte[] buffer, boolean ghostDoc) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.addDocument(): Entrada");
        UtilidadesLog.debug("idQueue="+ idQueue);

        IMPPrintableDocumentLocal local = null;

        try {
            //BEL 11133 fALTA EL CAMPO OBLIGATORIO IDQUEUE
            //oracle.sql.BLOB orBlob = null;
            //java.sql.Blob blob = null;

            //RESUMEN: Añade un registro a la tabla PrintableDocument. 
            IMPPrintableDocumentLocalHome home = new IMPPrintableDocumentLocalHome();

            local = home.create(idQueue);
            local.setNumSecuencia(numSecuencia);
            local.setBuffer(buffer);
            local.setPrint(Boolean.FALSE);//indicado en incidencia BELC300011832
          
            if (ghostDoc == true) {
                local.setGhostDoc(Boolean.TRUE);
            } else {
                local.setGhostDoc(Boolean.FALSE);
            }
            
            home.merge(local);
            
            //Hago un create del entity PrintableDocument rellenando sus campos: 
            //-numSecuencia = numSecuencia (parametro cabecera) 
            //-buffer: buffer (parametro cabecera) 
            //-ghostDoc = ghostDoc (parametro cabecera) 
            //2.- Devolvemos la clave del nuevo registro
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR",e);
            throw new MareException("falla el create en DAOPrinterSystem.addDocument",
                e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR",e);
            throw new MareException("falla el create en DAOPrinterSystem.addDocument",
                e);
        }
        
         /*UtilidadesLog.debug("Hemos insertado el documento : ");
         UtilidadesLog.debug("PrintableDocument.getPrimaryKey:" + (Long) local.getPrimaryKey());
         UtilidadesLog.debug("PrintableDocument.getIdQueue:" + local.getIdQueue());
         UtilidadesLog.debug("PrintableDocument.getNumSecuencia:" + local.getNumSecuencia());
         UtilidadesLog.debug("PrintableDocument.getBuffer"  + local.getBuffer());
         UtilidadesLog.debug("PrintableDocument.getGhostDoc"  + local.getGhostDoc());*/
        //catch(SQLException se){
        //	throw new MareException("falla el create en DAOPrinterSystem.addDocument", se);
        //}
        UtilidadesLog.debug("documento = "+(Long) local.getPrimaryKey());

        UtilidadesLog.info("DAOPrinterSystem.addDocument(): Salida");
        return ((Long) local.getPrimaryKey());
    }
    
    public Long addDocument(Long idSpool, Long numSecuencia, byte[] buffer, Long idImpre) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.addDocument(): Entrada");

        IMPPrintableDocumentLocal local = null;

        try {
            UtilidadesLog.debug("Busco la cola - idSpool: " + idSpool + " - idImpre: " + idImpre);
            IMPQueueLocalHome queueHome = new IMPQueueLocalHome();
            IMPQueueLocal queueLocal = queueHome.findByUK(idSpool, idImpre);
            queueLocal.setLastSequence(numSecuencia);
            
            try {
                queueHome.merge(queueLocal);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("Excepcion al hacer el merge de IMPQueueLocal", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            IMPPrintableDocumentLocalHome home = new IMPPrintableDocumentLocalHome();

            local = home.create(queueLocal.getIdQueue());
            local.setNumSecuencia(numSecuencia);
            local.setBuffer(buffer);
            local.setPrint(Boolean.FALSE);//indicado en incidencia BELC300011832
            
            try {
                home.merge(local);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("Excepcion al hacer el merge de IMPPrintableDocumentLocalHome", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
          

            //Hago un create del entity PrintableDocument rellenando sus campos: 
            //-numSecuencia = numSecuencia (parametro cabecera) 
            //-buffer: buffer (parametro cabecera) 
            //-ghostDoc = ghostDoc (parametro cabecera) 
            //2.- Devolvemos la clave del nuevo registro
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR",e);
            throw new MareException("falla el finder en DAOPrinterSystem.addDocument",
                e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR",e);
            throw new MareException("falla el create en DAOPrinterSystem.addDocument",
                e);
        }
        
         /*UtilidadesLog.debug("Hemos insertado el documento : ");
         UtilidadesLog.debug("PrintableDocument.getPrimaryKey:" + (Long) local.getPrimaryKey());
         UtilidadesLog.debug("PrintableDocument.getIdQueue:" + local.getIdQueue());
         UtilidadesLog.debug("PrintableDocument.getNumSecuencia:" + local.getNumSecuencia());
         UtilidadesLog.debug("PrintableDocument.getBuffer"  + local.getBuffer());
         UtilidadesLog.debug("PrintableDocument.getGhostDoc"  + local.getGhostDoc());*/
        //catch(SQLException se){
        //	throw new MareException("falla el create en DAOPrinterSystem.addDocument", se);
        //}
        UtilidadesLog.debug("documento = "+(Long) local.getPrimaryKey());

        UtilidadesLog.info("DAOPrinterSystem.addDocument(): Salida");
        return ((Long) local.getPrimaryKey());
    }
	

    public void deleteSpool(Long idSpool) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.deleteSpool(): Entrada");
        UtilidadesLog.debug("borramos "+idSpool);

        //RESUMEN: El objetivo de este método es borrar un registro de spool 
        IMPSpoolLocalHome home = new IMPSpoolLocalHome();
        IMPSpoolLocal local = null;

        try {
            this.deleteQueues(idSpool);
            local = home.findByPrimaryKey(idSpool);
            
            try {
                home.remove(local);
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException("falla el Finder en DAOPrinterSystem.deleteSpool",
                nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }

        //1.- Llamamos al método del dao deleteQueues(idSpool). 
        //2.- Mediante el entity Spool borramos el registro con pk=idSpool 
        UtilidadesLog.info("DAOPrinterSystem.deleteSpool(): Salida");
    }


    public RecordSet checkBuffer(Long idQueue,  Long bufferSize) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.checkBuffer(): Entrada");
        UtilidadesLog.debug("idcola "+idQueue);

        RecordSet rs3 = null;
        StringBuffer consulta = new StringBuffer("");
        Vector parametros = new Vector();

        UtilidadesLog.debug("BUFFERSIZE: "+bufferSize);
        consulta.append( " select * from ( ");
        consulta.append( " SELECT OID_DOCU_IMPR, NUM_SECU, IND_IMPR, IND_DOCU_FANT, GCOL_OID_COLA, NULL FROM  GEN_DOCUM_IMPRI WHERE  GCOL_OID_COLA = ? ");
        parametros.add(idQueue);
        consulta.append("AND IND_IMPR= ?  ");
        parametros.add(Boolean.FALSE);
        consulta.append(" ORDER BY num_secu, OID_DOCU_IMPR ) x");
        consulta.append(" WHERE rownum <= ?");
        parametros.add(bufferSize);
            
        String codigoError = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
        try {
            rs3 = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("recoverConfiguration: Exception", e);
            this.logSql("recoverConfiguration. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }        

        UtilidadesLog.debug("***recordSet de salida rs3 =" +rs3);
        UtilidadesLog.info("DAOPrinterSystem.checkBuffer(): Salida");
        return rs3;
    }

    public void updatePrinterDocuments(RecordSet rs) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.updatePrinterDocuments(): Entrada");

        IMPPrintableDocumentLocal local = null;

        /*ENTRADA: documentos: RecordSet
        SALIDA:
        RESUMEN: Marca como impresos los documentos que recibe por cabecera en la base de datos.
                PrintableDocumentLocal
        1.- Para cada registro de documentos hacer:
        - findByUk del entity PrintableDocument del registro correspondiente a la vuelta del bucle.
        - cambio su atributo print a TRUE. */
        if (rs != null) {
            if (!rs.esVacio()) {
                for (int i = 0; i < rs.getRowCount(); i++) {
                    // REcogemos el oid de printable documet
                    if (rs.getValueAt(i, "OID_DOCU_IMPR") != null) {
                        Long oidpriDocu = new Long(((BigDecimal) rs.getValueAt(
                                    i, "OID_DOCU_IMPR")).intValue());

                        try{
                            StringBuffer update = new StringBuffer("update gen_docum_impri set IND_IMPR = 1 where OID_DOCU_IMPR ="+oidpriDocu);
                            BelcorpService bs = UtilidadesEJB.getBelcorpService();
                            bs.dbService.executeUpdate(update.toString());
                        }catch(Exception e){
                            UtilidadesLog.error("ERROR", e);
                            throw new MareException("falla al recoger la referencia localHome DAOPrinterSystem.updatePrinterDocuments", e);
                        }
                    }
                     //El del ifrs.getValueAt
                }
                 //for
            }
             //res vacio
        }
         //if nula
        UtilidadesLog.info("DAOPrinterSystem.updatePrinterDocuments(): Salida");
    }


    public Long getNextActive() throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.getNextActive(): Entrada");

        /*
         * ENTRADA:
        SALIDA: Long
        RESUMEN: Chequea cual es el siguiente spool que se debe activarse.

        1.- Devuelvo la clave mas pequeña de la tabla SPOOL. Se hace a traves de una Select
        * */
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT MIN(OID_SPOO) FROM  GEN_SPOOL ");

        RecordSet rs = new RecordSet();
        Long res = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(consulta.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception ex) {
            UtilidadesLog.error("getNextActive: Exception", ex);
            this.logSql("getNextActive. SQL: ", consulta.toString(), null);

            //De momento los errores con asi, no tenemos codigos de error
        }

        if (rs.getValueAt(0, 0) != null) {
            res = new Long(((BigDecimal) (rs.getValueAt(0, 0))).longValue());
        }

        UtilidadesLog.info("DAOPrinterSystem.getNextActive(): Salida");

        return res;
    }
    
        //****************Cambios por 15675  lo sobrecargo por seguridad**************************************************************************************
    public Long getNextActive(Long oidspool) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.getNextActive(): Entrada");
         /*Operation Long getNextActive (Long oidSpool), in Class DAOPrinterSystem
        
        Documentation
        ENTRADA: oidSpool: Long 
        SALIDA: Long 
        RESUMEN: Chequea cual es el siguiente spool que se debe activarse. 
        
        1.- Nos fijamos en el registro con oidSpool en la tabla Spool y 
        buscamos el siguiente spool que se abrio con el mismo subacceso, 
        para ello nos fijaremos en el subacceso y 
        en la fecha de apertura que tendra que ser de todas las mayores la mas pequeña.
        
             * */
             IMPSpoolLocalHome home = new IMPSpoolLocalHome();
             IMPSpoolLocal local =null;
             Long acceso=null;
             try{
                 local=home.findByPrimaryKey(oidspool);
                 acceso=local.getAccesoFisico();
             } catch (PersistenceException e){
                 UtilidadesLog.debug(" Fallo al Buscar en entity IMPSpoll, PersistenceException");
                 UtilidadesLog.error(e);
             }
             
             

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append(" SELECT  OID_SPOO, FEC_APER ");
        consulta.append(" FROM GEN_SPOOL ");
        consulta.append(" WHERE VAL_ACCE_FISI = ? ");
        consulta.append(" AND IND_APER =1 ");
        parametros.add(acceso);
        consulta.append(" AND OID_SPOO <> ? ");
        parametros.add(oidspool);
        consulta.append(" ORDER BY (FEC_APER) "); //si ordenamos por fecha y luego cogemos el primero y listo


        RecordSet rs = new RecordSet();
        Long res = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (MareException me) {
            throw me;
        } catch (Exception ex) {
            UtilidadesLog.error("getNextActive: Exception", ex);
            this.logSql("getNextActive. SQL: ", consulta.toString(), null);

            //De momento los errores con asi, no tenemos codigos de error
        }
        if(rs!=null){
            if(!rs.esVacio()){
                res= new Long(((BigDecimal) (rs.getValueAt(0, 0))).longValue());
            }
        }
        UtilidadesLog.info("DAOPrinterSystem.getNextActive(): Salida");

        return res;
    }

   
    public boolean isSpoolOpen(Long idSpool) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.isSpoolOpen(): Entrada");

        IMPSpoolLocal local = null;
        Boolean es = null;

        try {
            IMPSpoolLocalHome home = new IMPSpoolLocalHome();

            local = home.findByPrimaryKey(idSpool);

            if (local.getOpen() != null) {
                if (local.getOpen().booleanValue() == true) {
                    es = Boolean.TRUE;
                } else {
                    es = Boolean.FALSE;
                }
            }

            /*Crea nuevo registro en la tabla SPOOL.
                            1.- Hacemos un create del entity Spool con los valores q se nos pasan por cabecera
                                    y poniendo TRUE al atributo open y el atributo active.
                                            Devolvemos la pk donde inserta el nuevo registro
                    */
        } catch (NoResultException ce) {
            ctx.setRollbackOnly();
            throw new MareException("falla el Finder en DAOPrinterSystem.isSpoolOpen",
                ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOPrinterSystem.isSpoolOpen(): Salida");
        return es.booleanValue();
    }


    public void activateSpool(Long oidSpool) throws MareException { //en el diseño no pone lo que devuelve tal vez sea Boolean
        UtilidadesLog.info("DAOPrinterSystem.activateSpool(): Entrada");

        //RESUMEN: Activa un spool de la base de datos. 
        //1.- Hago un findByPk del entity Spool pasandole el idSpool y 
        //pongo su atributo activo= TRUE. 
        IMPSpoolLocal local = null;
        Boolean es = null;

        try {
            IMPSpoolLocalHome home = new IMPSpoolLocalHome();

            local = home.findByPrimaryKey(oidSpool);
            local.setActive(Boolean.TRUE);
            
            try {
                home.merge(local);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("Error al hacer merge de IMPSpoolLocal", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            /*Crea nuevo registro en la tabla SPOOL.
                1.- Hacemos un create del entity Spool con los valores q se nos pasan por cabecera
                        y poniendo TRUE al atributo open y el atributo active.
                                Devolvemos la pk donde inserta el nuevo registro
            */
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            throw new MareException("falla el Finder en DAOPrinterSystem.activateSpool",
                e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            throw new MareException("falla el Finder en DAOPrinterSystem.activateSpool",
                e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOPrinterSystem.activateSpool(): Salida");
    }


    public Boolean checkActive(Long idQueue) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.checkActive(): Entrada");
        UtilidadesLog.debug("idQueue" +idQueue);

        /*
        ENTRADA: idCola: Long
        SALIDA: boolean
        RESUMEN: Valida si una cola pertenece a un Spool que esta activo.

        1.- Miro que la cola pertenece a un Spool con su campo "ACTIVO" a TRUE.
        */
        StringBuffer consulta = new StringBuffer();
        Vector param = new Vector();
        consulta.append(
            " SELECT IND_ACTI FROM  GEN_SPOOL WHERE OID_SPOO =(SELECT GSPO_OID_SPOOL FROM  GEN_COLAS WHERE OID_COLA= ?) ");
        param.add(idQueue);

        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        Boolean res = new Boolean(false);

        try {
            rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),
                    param);
        } catch (MareException me) {
            throw me;
        } catch (Exception ex) {
            UtilidadesLog.error("getNextActive: Exception", ex);
            //De momento los errores con asi, no tenemos codigos de error
        }

        if (rs.getValueAt(0, 0) != null) {
            int valor = ((BigDecimal) (rs.getValueAt(0, 0))).intValue();

            if (valor == 1) {
                res = new Boolean(true);
            } else {
                res = new Boolean(false);
            }
        }
        UtilidadesLog.debug("***DAOPrinterSystem.checkActive: Salida res= "+res);
        UtilidadesLog.info("DAOPrinterSystem.checkActive(): Salida");
        return res;
    }


    public void closeSpool(Long oidSpool) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.closeSpool(): Entrada");

        //1. Hago un findByPk del entity Spool pasandole el idSpool
        //y poniendo su atributo open a FALSE
        IMPSpoolLocal local = null;
        Boolean es = null;

        try {
            IMPSpoolLocalHome home = new IMPSpoolLocalHome();

            local = home.findByPrimaryKey(oidSpool);
            local.setOpen(Boolean.FALSE);
            
            try {
                home.merge(local);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("Error al hacer el merge de IMPSpoolLocal", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            throw new MareException("falla el Finder en DAOPrinterSystem.closeSpool",
                e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOPrinterSystem.closeSpool(): Salida");
    }

/*  ANTIGIUO
    public Boolean isSpoolVoid(Long idSpool) throws MareException {
        UtilidadesLog.debug("***DAOPrinterSystem.isSpoolVoid: Entrada");

        
       // ENTRADA: idSpool: Long
        //SALIDA: boolean
       //7 RESUMEN: Mira si hay algún spool activo en la entidad Spool

        //1.-Consulto si hay algún registro con el campo active=TRUE en la entidad Spool. Si es asi devuelvo FALSE, si no TRUE.
         
        StringBuffer consulta = new StringBuffer();

        consulta.append(
            " SELECT COUNT(*) FROM  GEN_SPOOL WHERE IND_ACTI = " + 1);

        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        Long res = null;

        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("getNextActive: Exception", ex);
            this.logSql("getNextActive. SQL: ", consulta.toString(), null);

            //De momento los errores con asi, no tenemos codigos de error
        }

        if (rs.getValueAt(0, 0) != null) {
            res = new Long(((BigDecimal) (rs.getValueAt(0, 0))).longValue());
        }

        UtilidadesLog.debug("***DAOPrinterSystem.isSpoolVoid: Salida");

        if (res.intValue() != 0) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }*/
    
    //********************************* Cambio hecho en 15675********************************************
    //antes recibia el idSpool y ahora recibe el subacceso:
    
     public Boolean isSpoolVoid(Long subacceso) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.isSpoolVoid(): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros= new Vector();
      
        consulta.append(" SELECT COUNT(*) ");
        consulta.append(" FROM GEN_SPOOL ");
        consulta.append(" WHERE IND_ACTI =1 ");
        consulta.append(" AND IND_APER=1");
        consulta.append(" AND VAL_ACCE_FISI= ? ");
        parametros.add(subacceso);
        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        Long res = null;

        try {
            rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception ex) {
            UtilidadesLog.error("getNextActive: Exception", ex);
            this.logSql("getNextActive. SQL: ", consulta.toString(), null);

            //De momento los errores con asi, no tenemos codigos de error
        }
        if (rs.getValueAt(0, 0) != null) {
            res = new Long(((BigDecimal) (rs.getValueAt(0, 0))).longValue());
        }
        
        UtilidadesLog.debug(res.toString());
        UtilidadesLog.info("DAOPrinterSystem.isSpoolVoid(): Salida");
        if (res.intValue() != 0) {
         UtilidadesLog.debug("Devolvemos FALSE .isSpoolVoid: No se va a activar el spool. RES = "+res.intValue());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void deleteQueues(Long idSpool) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.deleteQueues(): Entrada");

        /*ENTRADA: idSpool: Long
        SALIDA:
        RESUMEN: Vacia y borra las colas pertenecientes a un determinado Spool.

        1.- Componemos un Vector con todos los idQueue de los registros en de la tabla QUEUE que tengan el idSpool que se pasa por cabecera. (es decir los identificadores de las colas que pertenecen a ese spool)
        2.- Para cada registro de ese Vector hacemos:
        -Llamamos al método del dao deleteDocuments() pasandole el idQueue contenido
        en la posicion del vector que corresponda a la vuelta del bucle.
        3.- Borramos todos los registros de la tabla Queue que tengan el idSpool que se nos pasa por cabecera.
        */
        StringBuffer consulta = new StringBuffer();
        Vector param = new Vector();
        consulta.append(
            " SELECT OID_COLA FROM  GEN_COLAS WHERE GSPO_OID_SPOOL = ?");
        param.add(idSpool);

        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), param);
        } catch (Exception ex) {
            UtilidadesLog.error("getNextActive: Exception", ex);
            this.logSql("getNextActive. SQL: ", consulta.toString(), null);

            //De momento los errores con asi, no tenemos codigos de error
        }

        IMPQueueLocalHome queueLocalHome = new IMPQueueLocalHome();
        IMPQueueLocal queueLocal = null;

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal numero = (BigDecimal) rs.getValueAt(i, 0);
            Long numLong = new Long(numero.longValue());
            this.deleteDocuments(numLong);

            try {
                queueLocal = queueLocalHome.findByPrimaryKey(numLong);
                try {
                    queueLocalHome.remove(queueLocal);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("deleteQueues: PersistenceException al borrar", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            } catch (NoResultException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("deleteQueues: NoResultException", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("deleteQueues: PersistenceException", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

        UtilidadesLog.info("DAOPrinterSystem.deleteQueues(): Salida");
    }

    public void deleteDocuments(Long idQueue) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.deleteDocuments(): Entrada");

        //RESUMEN: Borra todos los documentos pertenecientes a una cola. 
        //1.- Borra todos los registros de la tabla PrintableDocuments 
        //que contengan el idQueue que se pasa por cabecera.
        IMPPrintableDocumentLocal local = null;
        Collection coleccion = null;
        Iterator iterator = null;
        StringBuffer consulta = new StringBuffer("");
        Vector parametros = new Vector();
        consulta.append(
            "SELECT * FROM  GEN_DOCUM_IMPRI WHERE GCOL_OID_COLA= ?");
        parametros.add(idQueue);

        String codigoError = null;

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("recoverConfiguration: Exception", e);
            this.logSql("recoverConfiguration. SQL: ", consulta.toString(), null);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs != null) {
            if (!rs.esVacio()) {
                for (int i = 0; i < rs.getRowCount(); i++) {
                    // REcogemos el oid de printable documet
                    if (rs.getValueAt(i, "OID_DOCU_IMPR") != null) {
                        Long oidpriDocu = new Long(((BigDecimal) rs.getValueAt(
                                    i, "OID_IMPR")).intValue());

                        try {
                            //RESUMEN: Añade un registro a la tabla PrintableDocument. 
                            IMPPrintableDocumentLocalHome home = new IMPPrintableDocumentLocalHome();
                            IMPPrintableDocumentLocal printDoc = home.findByPrimaryKey(oidpriDocu);
                            try {
                                home.remove(printDoc);
                            } catch (PersistenceException e) {
                                ctx.setRollbackOnly();
                                UtilidadesLog.debug("Error al eliminar de IMPPrintableDocument", e);
                                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                            }
                        } catch (NoResultException e) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.debug("Sin datos en IMPPrintableDocument", e);
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                        } catch (PersistenceException e) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.debug("Error en finder de IMPPrintableDocument", e);
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                    }
                     //El del iff
                }
                 //for
            }
             //res vacio
        }
         //if nula
        UtilidadesLog.info("DAOPrinterSystem.deleteDocuments(): Salida");
    }


    private void logError(String mensaje, Throwable e) {
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " +
            e.getMessage());
        this.logStackTrace(e);
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
    }

    private void logStackTrace(Throwable e) {
        try {
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            UtilidadesLog.error(out, e);
            UtilidadesLog.error(pila.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }

    //**************************METODO CREADO NUEVO POR 15675*************************
    public void desactivateSpool(Long idSpool) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.desactivateSpool(): Entrada");
    /*
     Operation void desactivateSpool (Long idSpool), in Class DAOPrinterSystem
    Documentation
    ENTRADA: idSpool:Long 
    SALIDA: 
    RESUMEN: Desactiva un spool. 
    1. Hago un findByPk del entity Spool pasandole el idSpool y poniendo su atributo active a FALSE. 
*/
     IMPSpoolLocal local = null;
   
            IMPSpoolLocalHome home = new IMPSpoolLocalHome();

            try{
                local = home.findByPrimaryKey(idSpool);
                local.setActive(Boolean.FALSE);
                local.setIndPeticionCierre(Boolean.FALSE);
                
                try {
                    home.merge(local);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.debug("Error al hacer merge de IMPSpoolLocal", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
            }catch (PersistenceException e){
                UtilidadesLog.debug("Falla al buscar en impSpoll ");
                UtilidadesLog.error(e);
            }
        UtilidadesLog.info("DAOPrinterSystem.desactivateSpool(): Salida");
    }
    
    
     public void desactivateAll (Long subacceso, Long oidSpool) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.desactivateAll(): Entrada");
       StringBuffer consulta = new StringBuffer("");
       Vector parametros= new Vector();
      
      consulta.append(" UPDATE GEN_SPOOL SET  IND_APER= 0 WHERE IND_APER=1 AND VAL_ACCE_FISI = ? AND OID_SPOO <> ? ");
      parametros.add(subacceso);
      parametros.add(oidSpool);
      
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        int elementosCambiados;
        try {
            elementosCambiados= bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("recoverConfiguration: Exception", e);
            this.logSql("recoverConfiguration. SQL: ", consulta.toString(), null);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
         consulta = new StringBuffer("");
         consulta.append(" UPDATE GEN_SPOOL SET  IND_ACTI= 0  WHERE IND_ACTI= 1 AND VAL_ACCE_FISI = ? AND OID_SPOO <> ? ");
        
      
        int elementosCambiadosactivo;
        try {
            elementosCambiadosactivo= bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("recoverConfiguration: Exception", e);
            this.logSql("recoverConfiguration. SQL: ", consulta.toString(), null);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

      
      
       UtilidadesLog.debug("*** elementosCambiadosAbiaertos = "+ elementosCambiados );
       UtilidadesLog.debug("***elementosCambiadosactivo = "+ elementosCambiadosactivo );
        UtilidadesLog.info("DAOPrinterSystem.desactivateAll(): Salida");
     }

    
    //añadido por la incidencia 19633
    public RecordSet checkBufferSequence (Long oidCola, Long tamanoVentana) throws MareException
    {
        UtilidadesLog.info("DAOPrinterSystem.checkBufferSequence(): Entrada");
        StringBuffer consulta = new StringBuffer("");
        Vector parametros= new Vector();
        //OJO: HAY QUE MODIFICARLA
        
        consulta.append(" SELECT doc.* ");
        consulta.append(" FROM GEN_COLAS col, GEN_DOCUM_IMPRI doc ");
        consulta.append(" WHERE col.OID_COLA = doc.GCOL_OID_COLA ");
        consulta.append(" AND col.OID_COLA = ? ");
        parametros.add(oidCola);
        consulta.append(" AND doc.IND_DOCU_FANT = ? ");
        parametros.add(Boolean.FALSE);
        consulta.append(" AND doc.NUM_SECU > col.NUM_ULTI_SECU ");
        consulta.append(" AND (doc.NUM_SECU <= (col.NUM_ULTI_SECU + ? )) ");
        parametros.add(tamanoVentana);
        consulta.append(" ORDER BY doc.NUM_SECU ");
        /*consulta.append(" SELECT doc.OID_DOCU_IMPR, doc.VAL_BUFF ");
        consulta.append(" FROM GEN_COLAS col, GEN_DOCUM_IMPRI doc ");
        consulta.append(" WHERE col.OID_COLA = doc.GCOL_OID_COLA ");
        consulta.append(" AND (doc.IND_DOCU_FANT = 0 OR doc.IND_DOCU_FANT IS NULL) ");
        consulta.append(" and col.OID_COLA = ? ");
        parametros.add(oidCola);
        consulta.append(" AND col.NUM_SEC_ULTI > ");
        consulta.append(" (SELECT NUM_SECU FROM ");
        consulta.append(" (SELECT * FROM GEN_DOCUM_IMPRI ");
        consulta.append(" ORDER BY OID_DOCU_IMPR DESC) ");
        consulta.append(" WHERE RowNum=1) ");
        consulta.append(" AND col.NUM_SEC_ULTI < ");
        consulta.append(" ((SELECT * FROM GEN_DOCUM_IMPRI ORDER BY OID_DOCU_IMPR DESC) ");
        consulta.append(" WHERE RowNum=1) + ?) ");
        parametros.add(tamanoVentana);
        consulta.append(" ORDER BY NUM_SEC_ULTI ");*/
        String codigoError = null;

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" checkBufferSequence: Exception",e);
            this.logSql("checkBufferSequence. SQL: ", consulta.toString(), null);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOPrinterSystem.checkBufferSequence(): Salida");
        return rs;
    }
    
    //añadido por la incidencia 19633
    public ArrayList getDocumentosImprimiblesEnSubAcceso (Long spool) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.getDocumentosImprimiblesEnSubAcceso(): Entrada");
        DTOFACFormulario dto = null;
        StringBuffer consulta;
        Vector parametros;
        BelcorpService bs=null;
        RecordSet rs = null;
        String codigoError=null;
        Long subAcceso=null;
        
        consulta = new StringBuffer("");
        parametros =new Vector();
        consulta.append(" SELECT c.SBAC_OID_SBAC ");
        consulta.append(" FROM GEN_SPOOL a, GEN_COLAS b, FAC_ASIGN_IMPRE c");
        consulta.append(" WHERE a.OID_SPOO=b.GSPO_OID_SPOOL ");
        //consulta.append(" AND b.IMVI_OID_IMPR=c.OID_ASIG_IMPR ");
        consulta.append(" AND b.IMVI_OID_IMPR=c.IMVI_OID_IMPR ");
        consulta.append(" AND a.OID_SPOO = ? ");
        parametros.add(spool);
        
        bs = UtilidadesEJB.getBelcorpService();
        
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" getDocumentosImprimiblesEnSubAcceso: Exception",e);
            this.logSql("getDocumentosImprimiblesEnSubAcceso. SQL: ", consulta.toString(), null);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (!rs.esVacio()) 
        {
            
            subAcceso = new Long(((BigDecimal)rs.getValueAt(0,"SBAC_OID_SBAC")).longValue());
        }else
        {
            //lanzamos la excepcion
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("DAOPrinterSystem.getDocumentosImprimiblesEnSubAcceso oidSpool="+spool, 
                                UtilidadesError.armarCodigoError(codigoError));
        }
       
        
        consulta = new StringBuffer("");
        parametros =new Vector();
        consulta.append(" SELECT a.OID_ASIG_IMPR, a.IMVI_OID_IMPR, ");
        consulta.append(" a.SBAC_OID_SBAC, a.FORS_OID_FORM, b.VAL_RUTI_DISE_FORM ");
        consulta.append(" FROM FAC_ASIGN_IMPRE a, ");
        consulta.append(" FAC_FORMU b ");
        consulta.append(" WHERE b.OID_FORM = a.FORS_OID_FORM ");
        consulta.append(" AND a.SBAC_OID_SBAC = ? ");
        parametros.add(subAcceso);
        
        bs = UtilidadesEJB.getBelcorpService();
        
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" getDocumentosImprimiblesEnSubAcceso: Exception",e);
            this.logSql("getDocumentosImprimiblesEnSubAcceso. SQL: ", consulta.toString(), null);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        ArrayList array = new ArrayList();
        if (rs != null) {
            if (!rs.esVacio()) 
            {
                UtilidadesLog.debug("***recordSet rs =" +rs);
                for (int i = 0; i < rs.getRowCount(); i++) {
                    dto=new DTOFACFormulario();
                    dto.setOidImpresoraVirtual(new Long(((BigDecimal)rs.getValueAt(i,"IMVI_OID_IMPR")).longValue()));
                    dto.setRutinaDiseñoFormulario((String)rs.getValueAt(i,"VAL_RUTI_DISE_FORM"));
                    array.add(dto);
                }//fin for
            }//fin if es vacio
        }//fin if null
        UtilidadesLog.info("DAOPrinterSystem.getDocumentosImprimiblesEnSubAcceso(): Salida");
        return array;
    }
    
    //añadido por incidencia 19633
    public void updatePrinterQueues (Long oidQueue, Long lastSequence) throws MareException
    {
        UtilidadesLog.info("DAOPrinterSystem.updatePrinterQueues(): Entrada");
        IMPQueueLocal local=null;
       
        IMPQueueLocalHome home= new IMPQueueLocalHome();
        try 
        {
            local=home.findByPrimaryKey(oidQueue);
            UtilidadesLog.debug("El registro a modificar es: "+local.getIdQueue());
        } catch (NoResultException e) {
            UtilidadesLog.error("updatePrinterQueues: NoResultException", e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException e){
            UtilidadesLog.error("updatePrinterQueues: PersistenceException", e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        //actualizamos el registro
        local.setLastSequence(lastSequence);
        
        try {
            home.merge(local);
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.debug("Error al hacer merge de IMPQueueLocal", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOPrinterSystem.updatePrinterQueues(): Salida");
    }
    
    
    /**
     * Creado por incidencia SiCC 20090869
     * Obtiene los bytes del documento imprimible cuyo OID se recibe por parametro
     * @author dmorello
     * @since 01-abr-2009 04:00 a.m.
     */
    public byte[] obtenerBytesDocumento(Long oidDocumImpri) throws MareException {
        UtilidadesLog.info("DAOPrinterSystem.obtenerBytesDocumento(Long oidDocumImpri): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String query = "SELECT VAL_BUFF FROM GEN_DOCUM_IMPRI WHERE OID_DOCU_IMPR = " + oidDocumImpri;
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        byte[] bytes = null;
        try {
            BLOB blob = (BLOB)rs.getValueAt(0,0);
            java.io.InputStream in = blob.getBinaryStream();
            java.io.ByteArrayOutputStream out = new ByteArrayOutputStream();
            for (int c = 0; (c = in.read()) != -1; out.write(c));
            in.close();
            out.close();
            bytes = out.toByteArray();
        } catch (Exception e) {
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
        
        
        UtilidadesLog.info("DAOPrinterSystem.obtenerBytesDocumento(Long oidDocumImpri): Salida");
        return bytes;
    }
    
}
