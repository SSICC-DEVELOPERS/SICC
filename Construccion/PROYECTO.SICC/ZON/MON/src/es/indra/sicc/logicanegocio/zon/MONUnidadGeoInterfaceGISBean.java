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
package es.indra.sicc.logicanegocio.zon;

import es.indra.sicc.util.UtilidadesLog;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.dtos.zon.DTOListaFicheroDisp;
import es.indra.sicc.dtos.zon.DTOUnidadGeoCabecera;
import es.indra.sicc.dtos.zon.DTOUnidadGeoRegistro;

import es.indra.sicc.entidades.seg.NivelSocioeconomicoBelcorpLocal;
import es.indra.sicc.logicanegocio.zon.DAOZON;
import es.indra.sicc.logicanegocio.zon.MONEstructuraGeoPoliticaHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficasHome;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;

import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;

import es.indra.sicc.entidades.zon.ZonLogLocalHome;
import es.indra.sicc.entidades.zon.ZonLogLocal;

import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocalHome;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.zon.ErroresDeNegocio;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.FinderException;


import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;


import es.indra.sicc.logicanegocio.zon.IManagerFileInterface;

import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.entidades.seg.NivelSocioeconomicoBelcorpLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/**
 * Sistema:           Belcorp - SICC
 * Modulo:            ZON - Zonificacion
 * Componente:        MONUnidadGeoInterfaceGIS
 * Fecha:             13/11/2003
 * Documentacion:     
 * Observaciones:     
 *
 * @version           1.0
 * @author            Viviana Bongiovanni
 */ 


public class MONUnidadGeoInterfaceGISBean implements SessionBean, IManagerFileInterface  {

    private SessionContext ctx;
    
    private String ipCliente;
    private String programa;

    private final static String TYPE_PROC_ASOCIAR_TERRITORIO = "ZONProcesarFicheroAsociarTerritorio";
    private final static String TYPE_PROC_UG = "ZONProcesarFicheroUG";    
    private String terminoOK = "S";   
    
    private boolean hacerRollback = false;
   
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
    

    public Boolean validarCabecera(Object datos, String typeProc, String filePath, String filename) throws MareException {
    
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.validarCabecera(Object datos, String typeProc, String filePath, String filename): Entrada");
      
        UtilidadesLog.debug("************* datos: " + datos);
        UtilidadesLog.debug("************* typeProc: " + typeProc);
        UtilidadesLog.debug("************* filePath: " + filePath);
        UtilidadesLog.debug("************* filename: " + filename);  

        String paisSession = ((DTOBelcorp)datos).getOidPais().toString();
        UtilidadesLog.debug("************* paisSession: " + paisSession);
        DTOUnidadGeoCabecera dtoCab;

        UnidadGeoFileWrapper fr = null;

        try {
          // Abro el archivo   
          fr = new UnidadGeoFileWrapper(filePath, filename);
        }
        catch(Exception ex) {                
          UtilidadesLog.debug("********* entro al catch Exception");
          UtilidadesLog.debug(ex);
        }       

        // Lee la cabecera
        try {
            dtoCab = (DTOUnidadGeoCabecera)fr.leerCabecera();
        } catch(MareException me) {
            UtilidadesLog.debug("************* Entro al catch");
            throw new MareException(me,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CABECERA_FICHERO_NO_VALIDA));            
        }    

        Long oidPais;    

        // Convierte el codigo de pais a oid de pais
        try {
            oidPais = getMONMantenimientoSEG().obtenerOidPais(dtoCab.getPais());
        } catch(RemoteException re) {
            UtilidadesLog.debug("************* Entro al catch RemoteException");
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(MareException me) {
            UtilidadesLog.debug("************* Entro al catch MareException");
            UtilidadesLog.debug(me);
            throw new MareException(me, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CABECERA_FICHERO_NO_VALIDA));            
        }    
        
        // Cerrar el archivo
        fr.cerrarArchivo();

        // Valida el pais del fichero con el de session del usuario activo
        if(oidPais.toString().equals(paisSession)) {
            UtilidadesLog.debug("************* Devuelve TRUE");
            UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.validarCabecera(Object datos, String typeProc, String filePath, String filename): Salida");
            return Boolean.TRUE;            
        } else {
            UtilidadesLog.debug("************* Devuelve FALSE");
            UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.validarCabecera(Object datos, String typeProc, String filePath, String filename): Salida");
            return Boolean.FALSE;
        }
        
    }

    /* 
     * Autor: Cortaberria
     * Fecha: 27/06/2005
     * En base al atributo privado hacerRollback se hace o no el rollback de la transaccion, despues
     * de haber consultado el resultado de la operación, y aque si se hace antes se genera error.
     */ 
    public DTOManagerFileResult procesarsinc(DTOFicheroDisp datos) throws MareException {
      UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.procesarsinc(DTOFicheroDisp datos): Entrada");
      
      this.ipCliente = datos.getIpCliente();
      this.programa = datos.getPrograma();
     
      // Valida la cabecera
      if(!validarCabecera(datos.getDatos(),datos.getTypeProc(), datos.getPathFichero(),datos.getNombreFichero()).booleanValue()){
        UtilidadesLog.debug("********* validarCabecera es distinto de true");
      	throw new MareException(null, null,
			  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PAIS_DE_FICHERO_DIFERENTE_PAIS_ACTIVO));
      }

      // Abre un log para el proceso
      Long idProc;
      try {
        idProc = this.getMONZONLog().crearLogProceso(datos.getTypeProc());
      }
      catch(RemoteException re) {
        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }

      hacerRollback = false;
      try {
          // Procesa el archivo
          procesar(idProc,datos.getPathFichero(),datos.getTypeProc(),datos.getNombreFichero());
      } catch (MareException e) {
           UtilidadesLog.error(e);
          hacerRollback = true;
      }
      // Devuelve un resultado
      DTOManagerFileResult dtoResult = this.obtenerResultado(idProc);        
      if(hacerRollback) {
          ctx.setRollbackOnly();
      }
      
      UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.procesarsinc(DTOFicheroDisp datos): Salida");
      return dtoResult;
    }    
    
    /*
     * Autor: Cortaberria
     * Fecha: 27/06/2005
     * Se setea el atributo privado que indica si se debe hacer rollbak al finalizar el proceso
     */
    public void procesar(Long idProc, String filePath, String typeProc, String filename) throws MareException {
      UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.procesar(Long idProc, String filePath, String typeProc, String filename): Entrada");
      
      if(typeProc.equals(this.TYPE_PROC_UG)) {
        UtilidadesLog.debug("********* Llamando a procesarMantener");
        hacerRollback = !this.procesarMantener(idProc, filePath, filename);
      } else if(typeProc.equals(this.TYPE_PROC_ASOCIAR_TERRITORIO)) {
        UtilidadesLog.debug("********* Llamando a procesarAsociarTerritorio");
        hacerRollback = !this.procesarAsociarTerritorio(idProc, filePath, filename);
      }
      
      UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.procesar(Long idProc, String filePath, String typeProc, String filename): Salida");
    } 
    
    /*
     * Autor: Cortaberria
     * Fecha: 27/06/2005
     * Se modifica el tipo de retorno de manera que retorne true si la operacion se realizo ok
     * o si no se debe ejecutar el rollback, y false en el caso contrario.
     * Se realizo este cambio debido a que si se hace el rollback aqui y luego se intenta consultar
     * en la bd el resultado de la operación se genera un error.
     */
    public boolean procesarMantener(Long idProc, String filePath, String filename) throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.procesarMantener(Long idProc, String filePath, String filename): Entrada");
        
        DTOUnidadGeoCabecera dtoCab = new DTOUnidadGeoCabecera();
        DTOUnidadGeoRegistro dtoReg = new DTOUnidadGeoRegistro();
        Object reg;

        // Logueo el inicio del proceso        
        MONZONLog log;

        log = this.getMONZONLog();

        this.reportarResultado(log, idProc,this.TYPE_PROC_UG, IManagerFileInterface.EN_EJECUCION,"");        

        // Abro el archivo
        UnidadGeoFileWrapper fr = new UnidadGeoFileWrapper(filePath, filename);

        // Lee la cabecera
        try {
          dtoCab = (DTOUnidadGeoCabecera)fr.leerCabecera();
        }
        catch(MareException me) {
          // Error critico            
          UtilidadesLog.debug("********* Entro al catch M00012");
          UtilidadesLog.debug(me);
          this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00012","");
          this.reportarResultado(log, idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00012");
          return false;  //hace rollback 
        }    

        UtilidadesLog.debug("********* dtoCab " + dtoCab);

        Long oidPais;    

        // Convierte el codigo de pais a oid de pais
        try {
          oidPais = getMONMantenimientoSEG().obtenerOidPais(dtoCab.getPais());
        }
        catch(RemoteException re) {
          UtilidadesLog.debug("********* Entro al catch por RemoteException");
          UtilidadesLog.debug(re);
          throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch(MareException me) {
          UtilidadesLog.debug("********* Entro al catch por MareException");
          UtilidadesLog.debug(me);
          throw new MareException(me, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CABECERA_FICHERO_NO_VALIDA));                    
        }       

        // Validación si tiene Estructura Geopolitica  
        MONEstructuraGeoPoliticaHome estGeoHome = getMONEstructuraGeoPoliticaHome();

        try {
            MONEstructuraGeoPolitica estGeo = estGeoHome.create();

            if(!estGeo.paisTieneEG(oidPais)) {
                // Error critico                
                UtilidadesLog.debug("********* paisTieneEG es distinto de true - M00006");
                log.agregarDetalle(idProc,this.TYPE_PROC_UG, "M00006", "");
                log.reportarResultado(idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00006");
                return false; //hace rollback
            }
            
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }


        // Obtiene Niveles
        DAOZON daozon = new DAOZON();

        Long numNiveles = daozon.obtenerNivelesEstructuraGeoPolitica(oidPais);
        UtilidadesLog.debug("********* numNiveles: " + numNiveles);

        // Proceso
        
        MONUnidadesGeograficasHome uniGeoHome = getMONUnidadesGeograficasHome();
        MONUnidadesGeograficas uniGeo;
        
        try {
            uniGeo = uniGeoHome.create();
        } catch(RemoteException re) {
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        // Proceso
        UtilidadesLog.debug("********* Llamando a leerRegistro dentro del while");
         while((reg = this.leerRegistro(log, fr,idProc, this.TYPE_PROC_UG))!=null) {
         
            if(reg instanceof String && ((String)reg).equals("Rollback")) {
                System.out.println("Error de linea no valida");
                return false;
            }
        
            dtoReg = (DTOUnidadGeoRegistro)reg;
            UtilidadesLog.debug("*********** dtoReg " + dtoReg);

            // Valida el nivel del UBIGEO
            try {

                try {
                    if(!uniGeo.validarNivelUBIGEO(new Integer(numNiveles.intValue()), dtoReg.getDato1()).booleanValue()) {
                        // Error critico
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_UG,  "M00014", logString(dtoReg.dumpToString(),log));                                   

                        this.reportarResultado(log,idProc,this.TYPE_PROC_UG,  IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00014");
                        
                        // Deshace la transacción                                               
                        return false; //hace rollback
                    }

                } catch(MareException me) {
                        UtilidadesLog.debug("********* Entro al catch M00009");
                        // Error critico
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00009", logString(dtoReg.dumpToString(),log));                                                                     
                        this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00009");                                    
                        // Deshace la transacción                                   
                        return false; //hace rollback
                }

                // Valida NSE1 y NSE2
                Collection nivel1= null;
                Collection nivel2= null;

                try{                
                    NivelSocioeconomicoBelcorpLocalHome nivelSocioBel= this.getNivelSocioeconomicoBelcorpLocalHome();

                    /*
                     * DBLG400000308 - dmorello, 09/03/2006
                     * Debido a la forma en que se hace la lectura y el parseo del
                     * registro, los campos vacíos quedan como espacios en blanco.
                     * Por lo tanto, debe verificarse que NSE1 y NSE2 no sean " "
                     * antes de realizar el findByUK de NivelSocioEconomico. Se
                     * agregan dos IF para efectuar dicha verificación.
                     */
                     
                    /* Verifico si vino un valor de NSE1 en el registro */
                    if (" ".equals(dtoReg.getDato4())) {
                        // Si es un espacio en blanco, NSE1 será NULL en BD
                        dtoReg.setDato4(null);
                    } else {
                        // Si no es un espacio en blanco, hay que validarlo
                        UtilidadesLog.debug("********* Llamando al findByUK - NivelSocioeconomicoBelcorpLocalHome");

                        // Valida NSE1
                        try {
                            NivelSocioeconomicoBelcorpLocal nivelLocal = nivelSocioBel.findByUK(dtoReg.getDato4());
                        } catch (NoResultException e) {
                            UtilidadesLog.debug("********* nivel1 isEmpty verdadero - M00041");
                            // Error critico
                            this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00041", logString(dtoReg.dumpToString(),log));                                   
                            this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00041");
                            // Deshace la transacción                                   
                            return false; //hace rollback
                         }  catch (PersistenceException ce) {   
                             UtilidadesLog.error("ERROR ", ce);
                             throw new MareException(ce, 
                             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    }

                    /* Verifico si vino un valor de NSE2 en el registro */
                    if (" ".equals(dtoReg.getDato5())) {
                        // Si es un espacio en blanco, NSE2 será NULL en BD
                        dtoReg.setDato5(null);
                    } else {
                        // Si no es un espacio en blanco, hay que validarlo
                        UtilidadesLog.debug("********* Llamando al findByUK - NivelSocioeconomicoBelcorpLocalHome");
                        
                        //Valida NSE2
                        try {
                            NivelSocioeconomicoBelcorpLocal nivelLocal = nivelSocioBel.findByUK(dtoReg.getDato5());
                        } catch (NoResultException e) {
                            UtilidadesLog.debug("********* nivel1 isEmpty verdadero - M00042");
                            // Error critico
                            this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00042", logString(dtoReg.dumpToString(),log));                                   
                            this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00042");
                            // Deshace la transacción                                   
                            return false; //hace rollback
                         }  catch (PersistenceException ce) {   
                             UtilidadesLog.error("ERROR ", ce);
                             throw new MareException(ce, 
                             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    }
                    /* Fin modif. DBLG400000308 por dmorello */
                    
                } catch(NoResultException fex) {      
                    throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                /* Fin modif. */
                          
                // Procesa la operación
                if(dtoReg.getTipoOP().equals("A")) {
                    UtilidadesLog.debug("********* dtoReg - getTipoOP - equals - A");
                    // Alta
                    try {
                        // Verifica si el registro ya ha sido insertado
                        String[] ubigeoArray = obtenerUbigeo(dtoReg.getDato1());
                        
                        ValoresEstructuraGeopoliticaLocalHome localHomeVal = this.getValoresEstructuraGeopoliticaLocalHome();

                        UtilidadesLog.debug("                   ********* Llamando a 'findByUbigeo' con estos paràmetros");
                        UtilidadesLog.debug(ubigeoArray[0] + " " + ubigeoArray[1] + " " + ubigeoArray[2] + " " + ubigeoArray[3] + " " + 
                                            ubigeoArray[4] + " " + ubigeoArray[5] + " " + ubigeoArray[6] + " " + ubigeoArray[7] + " " + 
                                            ubigeoArray[8] + " " + oidPais);
                        
                        
                        Collection ubigeos1 = localHomeVal.findByUbigeo(ubigeoArray[0], ubigeoArray[1], ubigeoArray[2], ubigeoArray[3], 
                                                  ubigeoArray[4], ubigeoArray[5], ubigeoArray[6], ubigeoArray[7], 
                                                  ubigeoArray[8], oidPais);

                        // Busca los activos                                              
                        Iterator iteUbigeos = ubigeos1.iterator();  
                        ValoresEstructuraGeopoliticaLocal valoresEstrucGeopLocal = null;
                        Collection valoresEstrucGeop = new Vector();
                        
                        while(iteUbigeos.hasNext()){
                            valoresEstrucGeopLocal = (ValoresEstructuraGeopoliticaLocal)iteUbigeos.next();
                
                            if(valoresEstrucGeopLocal.getInd_borr().equals(new Long(0))){
                                UtilidadesLog.debug("********* valoresEstrucGeopLocal - getIndborr es cero");
                                valoresEstrucGeop.add(valoresEstrucGeopLocal);
                            }
                        }
                        
                        if(valoresEstrucGeop.size()!= 0){
                            UtilidadesLog.debug("********* valoresEstrucGeop - size - distinto de cero - M00034");
                            // Error no critico        
                            this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00034",logString(dtoReg.dumpToString(),log));     
                            continue;                    
                        }

                        // Realiza el alta  
                        uniGeo.insertarUG(dtoReg.getDato1(),dtoReg.getDato4(),dtoReg.getDato5(),dtoReg.getDato7(),
                                      dtoReg.getDato3(),new Integer(dtoReg.getDato2()),dtoReg.getDato6(),oidPais,
                                      this.ipCliente, this.programa);

                    }
                    catch(MareException me) {
                        UtilidadesLog.debug("********* entro al catch MareException- M00015");
                        UtilidadesLog.debug(me);
                        // Error critico
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00015", logString(dtoReg.dumpToString(),log));                                
                        this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00015");                                    
                        // Deshace la transacción                                   
                        return false;//hace rollback
                    }
                    catch(Exception ex) {
                        UtilidadesLog.debug("********* entro al catch Exception- M00015");
                        UtilidadesLog.debug(ex);
                        // Error critico
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00015", logString(dtoReg.dumpToString(),log));                             
                        this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00015");                                    
                        // Deshace la transacción                                   
                        return false;//hace rollback
                    }
                                      
                } else if (dtoReg.getTipoOP().equals("B")) {
                    // Borrado 
                    try {
                        UtilidadesLog.debug("********* Llamando a obtenerUbigeo");
                        // Verifica si el registro existe no borrado
                        String[] ubigeoArray = obtenerUbigeo(dtoReg.getDato1());
                        
                        ValoresEstructuraGeopoliticaLocalHome localHomeVal = this.getValoresEstructuraGeopoliticaLocalHome();

                        UtilidadesLog.debug("********* Llamando a findByUbigeo");
                        Collection ubigeos1 = localHomeVal.findByUbigeo(ubigeoArray[0], ubigeoArray[1], ubigeoArray[2], ubigeoArray[3], 
                                                  ubigeoArray[4], ubigeoArray[5], ubigeoArray[6], ubigeoArray[7], 
                                                  ubigeoArray[8], oidPais);

                        // Busca los activos                                              
                        Iterator iteUbigeos = ubigeos1.iterator();  
                        ValoresEstructuraGeopoliticaLocal valoresEstrucGeopLocal = null;
                        Collection valoresEstrucGeop = new Vector();
                        
                        while(iteUbigeos.hasNext()){
                            valoresEstrucGeopLocal = (ValoresEstructuraGeopoliticaLocal)iteUbigeos.next();
                
                            if(valoresEstrucGeopLocal.getInd_borr().equals(new Long(0))){
                                System.out.println("********* valoresEstrucGeopLocal - getIndborr es cero");
                                valoresEstrucGeop.add(valoresEstrucGeopLocal);
                            }
                        }
                        
                        if(valoresEstrucGeop.size()== 0){
                            UtilidadesLog.debug("********* valoresEstrucGeop - size cero - M00045");
                            // Error no critico        
                            this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00045",logString(dtoReg.dumpToString(),log));     
                            continue;                    
                        }
                        
                        uniGeo.eliminarUG(oidPais, dtoReg.getDato1(),this.ipCliente, this.programa);
                    } catch(MareException me) {
                        UtilidadesLog.debug("********* entro al catch - M00016");
                        UtilidadesLog.debug(me);
                        // Error critico
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00016", logString(dtoReg.dumpToString(),log));                            
                        this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00016");
                        // Deshace la transacción                                               
                        return false;//hace rollback
                    } catch(Exception ex) {
                        UtilidadesLog.debug("********* entro al catch - M00016 - Exception");
                        UtilidadesLog.debug(ex);
                        // Error critico
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00016", logString(dtoReg.dumpToString(),log));                            
                        this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00016");
                        // Deshace la transacción                                               
                        return false;//hace rollback
                    }
                    
                } else if (dtoReg.getTipoOP().equals("M")) {
                    // Modificacion
                    try {
                        UtilidadesLog.debug("********* Llamando a obtenerUbigeo");
                        // Verifica si el registro existe no borrado
                        String[] ubigeoArray = obtenerUbigeo(dtoReg.getDato1());
                        
                        ValoresEstructuraGeopoliticaLocalHome localHomeVal = this.getValoresEstructuraGeopoliticaLocalHome();

                        UtilidadesLog.debug("********* Llamando a findByUbigeo");
                        Collection ubigeos1 = localHomeVal.findByUbigeo(ubigeoArray[0], ubigeoArray[1], ubigeoArray[2], ubigeoArray[3], 
                                                  ubigeoArray[4], ubigeoArray[5], ubigeoArray[6], ubigeoArray[7], 
                                                  ubigeoArray[8], oidPais);

                        // Busca los activos                                              
                        Iterator iteUbigeos = ubigeos1.iterator();  
                        ValoresEstructuraGeopoliticaLocal valoresEstrucGeopLocal = null;
                        Collection valoresEstrucGeop = new Vector();
                        
                        while(iteUbigeos.hasNext()){
                            valoresEstrucGeopLocal = (ValoresEstructuraGeopoliticaLocal)iteUbigeos.next();
                
                            if(valoresEstrucGeopLocal.getInd_borr().equals(new Long(0))){
                                System.out.println("********* valoresEstrucGeopLocal - getIndborr es cero");
                                valoresEstrucGeop.add(valoresEstrucGeopLocal);
                            }
                        }
                        
                        if(valoresEstrucGeop.size()== 0){
                            UtilidadesLog.debug("********* valoresEstrucGeop - size cero - M00045");
                            // Error no critico        
                            this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00045",logString(dtoReg.dumpToString(),log));     
                            continue;                    
                        }
                    
                        uniGeo.eliminarUG(oidPais, dtoReg.getDato1(),this.ipCliente, this.programa);
                        uniGeo.insertarUG(dtoReg.getDato1(),dtoReg.getDato4(),dtoReg.getDato5(),dtoReg.getDato7(),
                                          dtoReg.getDato3(),new Integer(dtoReg.getDato2()),dtoReg.getDato6(), oidPais,
                                          this.ipCliente, this.programa);
                    } catch(MareException me) {
                        UtilidadesLog.debug("********* Entro al catch - MareException - M00017");
                        UtilidadesLog.debug(me);
                        // Error critico
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00017", logString(dtoReg.dumpToString(),log));                                
                        this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00017");                                    
                        // Deshace la transacción                                   
                        return false;//hace rollback
                    } catch(Exception ex) {
                        UtilidadesLog.debug("********* Entro al catch - Exception - M00017");
                        UtilidadesLog.debug(ex);
                        // Error critico
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00017", logString(dtoReg.dumpToString(),log));                            
                        this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00017");
                        // Deshace la transacción                                               
                        return false;//hace rollback
                    }                              
                } else {
                    UtilidadesLog.debug("************** Operacion incorrecta");
                    UtilidadesLog.debug("************** operacion: " + dtoReg.getTipoOP());

                    UtilidadesLog.debug("********* Entro al catch - Exception - M00044");

                    // Error critico
                    this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00044", logString(dtoReg.dumpToString(),log));                            
                    this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00044");
                    // Deshace la transacción                                                   
                    return false;//hace rollback
                  }

            
            } catch(RemoteException re) {
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }            
        } //TERMINA EL CICLO WHILE

        // Logueo la finalizacion exitosa del proceso        
        if(terminoOK.equals("S")) {
            UtilidadesLog.debug("********* terminoOK es S");
            this.reportarResultado(log, idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_OK,"");
        }
            
        /*
        // Logueo la finalizacion exitosa del proceso        
        this.finalizacionProceso(log, idProc,this.TYPE_PROC_UG);
        */        
        
        // Cerrar el archivo
        fr.cerrarArchivo();        
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.procesarMantener(Long idProc, String filePath, String filename): Salida");
        return true;//no hace rollback
    }

    private String[] obtenerUbigeo(String ubigeo) {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.obtenerUbigeo(String ubigeo): Entrada");

        String[] ubigeoArray = new String[9];
        int resto = (ubigeo.length() % 6);

        if((ubigeo.length() >= 6) && (ubigeo.length() <= 54) && (resto == 0) && (ubigeo != null)) {
            int a = 0;

            for(int i = 0; i < ubigeo.length(); i++) {
                ubigeoArray[a] = ubigeo.substring(i, i + 6);
                i = i + 5;
                a = a + 1;
            }

            if(a < 9) {
                for(int i = a; i < 9; i++)
                    ubigeoArray[i] = null;
            }
        }
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.obtenerUbigeo(String ubigeo): Salida");
        return ubigeoArray;
    }
    

    public DTOManagerFileResult obtenerResultado(Long idProc) throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.obtenerResultado(Long idProc): Entrada");

        DTOManagerFileResult dto = new DTOManagerFileResult();
      
        MONZONLog log = getMONZONLog();

        try {
            dto = log.obtenerResultado(idProc,"");            
        } catch(RemoteException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 
        
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.obtenerResultado(Long idProc): Salida");
        return dto;
    }

    public DTOListaFicheroDisp ficherosDisponibles(String typeProc) throws MareException {
        return null;
    }

    public Integer estadoProc(Long idProc) throws MareException {
        return null;
    }

    /*
     * Autor: Cortaberria
     * Fecha: 27/06/2005
     * Mismo motivo que procesarMantener
    */
    public boolean procesarAsociarTerritorio(Long idProc, String filePath, String filename) throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.procesarAsociarTerritorio(Long idProc, String filePath, String filename): Entrada");
            
        DTOUnidadGeoCabecera dtoCab = new DTOUnidadGeoCabecera();
        DTOUnidadGeoRegistro dtoReg = new DTOUnidadGeoRegistro();
        Object reg;

        // Logueo el inicio del proceso        
        MONZONLog log;

        log = this.getMONZONLog();

        this.reportarResultado(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO,                                   
                                    IManagerFileInterface.EN_EJECUCION,"");
        

        // Abro el archivo
        UnidadGeoFileWrapper fr = new UnidadGeoFileWrapper(filePath, filename);

        // Lee la cabecera
        try {
            dtoCab = (DTOUnidadGeoCabecera)fr.leerCabecera();
        } catch(MareException me) {
            // Error critico            
            this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                                   "M00012","");
            this.reportarResultado(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO,                                   
                                    IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00012");
            return false;//se hace rollback
            
        }    

        UtilidadesLog.debug("dtoCab: " + dtoCab);

        Long oidPais;    

        // Convierte el codigo de pais a oid de pais
        try {
            oidPais = getMONMantenimientoSEG().obtenerOidPais(dtoCab.getPais());
        } catch(RemoteException re) {
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(MareException me) {
            throw new MareException(me,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CABECERA_FICHERO_NO_VALIDA));                    }    

        // Validación si tiene Estructura Geopolitica  
        MONEstructuraGeoPoliticaHome estGeoHome = getMONEstructuraGeoPoliticaHome();

        try {
            MONEstructuraGeoPolitica estGeo = estGeoHome.create();
            
            if(!estGeo.paisTieneEG(oidPais)) {
                // Error critico
                log.agregarDetalle(idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                                   "M00006", "");
                log.reportarResultado(idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO,                                   
                                    IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00006");
                return false;// se hace rollback
            }
            
        } catch(RemoteException re) {
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
     

        // Validación si tiene Unidades Geograficas
        MONUnidadesGeograficasHome uniGeoHome = getMONUnidadesGeograficasHome();
        MONUnidadesGeograficas uniGeo;
  
        try {
            uniGeo = uniGeoHome.create();

            if(!uniGeo.paisTieneUG(oidPais).booleanValue()) {
                // Error critico
                log.agregarDetalle(idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                    "M00007","");
                log.reportarResultado(idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO,                                   
                                    IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00007");
                return false;//se hace rollback
            }
            
        } catch(RemoteException re) {
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }


        // Proceso
        while((reg = this.leerRegistro(log, fr,idProc, this.TYPE_PROC_ASOCIAR_TERRITORIO))!=null) {
        
            if(reg instanceof String && ((String)reg).equals("Rollback")) {
                System.out.println("Error de linea no valida");
                return false;
            }
        
            dtoReg = (DTOUnidadGeoRegistro)reg;
            UtilidadesLog.debug("dtoReg: " + dtoReg);

            // Verifica si la operacion no es "A", "M", "B"
            // No se puede separar en metodos individuales por que no reconoce el continue 
            if(!dtoReg.getTipoOP().equals("A") && !dtoReg.getTipoOP().equals("M") && !dtoReg.getTipoOP().equals("B")) {
              UtilidadesLog.debug("************** Operacion incorrecta");
              UtilidadesLog.debug("************** operacion: " + dtoReg.getTipoOP());

              UtilidadesLog.debug("********* Entro al catch - Exception - M00044");

              // Error critico
              this.agregarDetalle(log, idProc,this.TYPE_PROC_UG, "M00044", logString(dtoReg.dumpToString(),log));                            
              this.reportarResultado(log,idProc,this.TYPE_PROC_UG, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00044");
                                    
              return false;//se hace rollback
            }

            // Valida que el territorio exista
            TerritorioLocalHome territorioLocalHome = getTerritorioLocalHome();
            DTOFicheroDisp fich= new DTOFicheroDisp();
            fich.setIpCliente(this.ipCliente);
            fich.setPrograma(this.programa.toString());
            UtilidadesLog.debug("DTO aud: " + fich);

            Collection territorio;
            TerritorioLocal territ;
            
            try {
               territorio = territorioLocalHome.findByCodigoPais(new Long(dtoReg.getDato1()), oidPais);

               if (territorio.size()== 0) {
                    // Error no critico
                    this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                         "M00008",logString(dtoReg.dumpToString(),log));                             
                    continue;   
               } 
            } catch(NoResultException fex) {                
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } 

            // Territorio
            Iterator itTerritorio = territorio.iterator();
            territ = (TerritorioLocal)itTerritorio.next();


            if(dtoReg.getTipoOP().equals("A") || dtoReg.getTipoOP().equals("M")){

                // Verifico la unidad geografica del territorio para la modificacion
                if(dtoReg.getTipoOP().equals("M") && territ.getOidValoresEstruGeo()== null){
                    // Error no critico        
                    UtilidadesLog.debug("Datos: "+ dtoReg.dumpToString());
                    this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                         "M00031",logString(dtoReg.dumpToString(),log));     
                    continue;                    
                }
                

                // Obtiene el Oid del Valor de la Estructura Geopolitica          
                DAOZON daozon = new DAOZON();
                Long oidValEstGeo;

                try {
                    oidValEstGeo = daozon.obtenerUniGeoPorUBIGEO(dtoReg.getDato2(), oidPais);
                } catch(MareException me) {
                    // Error critico
                    this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                                   "M00009", logString(dtoReg.dumpToString(),log));                                   
                                  
                    this.reportarResultado(log,idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO,                                   
                                    IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00009");
                    
                    // Deshace la transacción                                                   
                    return false;//se hace rollback
                }
            

                if (oidValEstGeo == null) {                
                    // Error no critico        
                    UtilidadesLog.debug("Datos: "+ dtoReg.dumpToString());
                    this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                         "M00009",logString(dtoReg.dumpToString(),log));     
                    continue;
                
                }

                // Verifico la unidad geografica del territorio para el alta
                if(dtoReg.getTipoOP().equals("A") && territ.getOidValoresEstruGeo()!= null) {

                    if(territ.getOidValoresEstruGeo().compareTo(oidValEstGeo)==0) {
                        // Error no critico 
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                             "M00010",logString(dtoReg.dumpToString(),log));                                        
                        continue;                                   
                    
                    } else {
                        // Error critico
                        this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                             "M00011",logString(dtoReg.dumpToString(),log));     
                                  
                        this.reportarResultado(log,idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO,                                   
                                        IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00011");
                        // Deshace la transacción                  
                        return false;//se hace rollback
                    }
                }
            
          
                // Actualiza el territorio
                try {
                    TerritorioLocal territorioLocal = territorioLocalHome.findByPrimaryKey(territ.getOid());

                    SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy hh:mm:ss");
                    Timestamp date = new Timestamp(System.currentTimeMillis());
                    
                    territorioLocal.setOidValoresEstruGeo(oidValEstGeo);
                    territorioLocal.setNse1(dtoReg.getDato4());
                    territorioLocal.setNse2(dtoReg.getDato5());
                    territorioLocal.setFechaRtz(date);
                    territorioLocalHome.merge(territorioLocal);
            
                } catch(NoResultException fe) {
                    throw new MareException(fe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));   
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

                } catch(Exception ex) {
                    // Error critico
                    this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                                   "M00029", logString(dtoReg.dumpToString(),log));                                   
                                  
                    this.reportarResultado(log,idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO,                                   
                                    IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00029");
                                    
                    return false;// Deshace la transacción      
                }
            } else {
                // Baja
                if(dtoReg.getTipoOP().equals("B") && territ.getOidValoresEstruGeo()== null){
                    // Error no critico        
                    UtilidadesLog.debug("Datos: "+ dtoReg.dumpToString());
                    this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                         "M00031",logString(dtoReg.dumpToString(),log));     
                    continue;                    
                }

                // Actualiza el territorio
                try {
                    TerritorioLocal territorioLocal = territorioLocalHome.findByPrimaryKey(territ.getOid());

                    territorioLocal.setOidValoresEstruGeo(null);                        
                    territorioLocalHome.merge(territorioLocal);
            
                } catch(NoResultException fe) {
                    throw new MareException(fe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));   
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                
                } catch(Exception ex) {
                    // Error critico
                    this.agregarDetalle(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO, 
                                   "M00029", logString(dtoReg.dumpToString(),log));                                   
                                  
                    this.reportarResultado(log,idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO,                                   
                                    IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00029");
                                    
                    return false;// Deshace la transacción      
                }
                
            }
            
        }

        // Logueo la finalizacion exitosa del proceso        
        if(terminoOK.equals("S")) {
            this.reportarResultado(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO,                                   
                                    IManagerFileInterface.PROCESAMIENTO_FINALIZADO_OK,"");
        }
        /*
        // Logueo la finalizacion exitosa del proceso   
        this.finalizacionProceso(log, idProc,this.TYPE_PROC_ASOCIAR_TERRITORIO);
         */
        
        // Cerrar el archivo
        fr.cerrarArchivo();
        
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.procesarAsociarTerritorio(Long idProc, String filePath, String filename): Salida");
        return true;
        
    }


    private Object leerRegistro(MONZONLog log , UnidadGeoFileWrapper fr, Long idProc, String typeProc) throws MareException {
    
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.leerRegistro(MONZONLog log , UnidadGeoFileWrapper fr, Long idProc, String typeProc): Entrada");
        Object registro;
    
        try {
            registro = fr.leerRegistro();
        }
        catch(MareException me) {
            UtilidadesLog.debug("*********** Entro al catch - M00013");
            // Error critico           
            this.agregarDetalle(log, idProc,typeProc, "M00013","");
            this.reportarResultado(log, idProc,typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,"M00013");
                            
            // No termino correctamente el proceso
            terminoOK = "N";                                           
            // Deshace la transacción
            UtilidadesLog.error(me);     
            UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.leerRegistro(MONZONLog log , UnidadGeoFileWrapper fr, Long idProc, String typeProc): Salida");
            
            return "Rollback";      
        }
        
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.leerRegistro(MONZONLog log , UnidadGeoFileWrapper fr, Long idProc, String typeProc): Salida");
        return registro;
    }

    private void reportarResultado(MONZONLog log, Long idProc, String valTipoProc, Long valEstado, String mensaje) throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.reportarResultado(MONZONLog log, Long idProc, String valTipoProc, Long valEstado, String mensaje): Entrada");
        try {            
            log.reportarResultado(idProc, valTipoProc, valEstado, mensaje);         
            UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.reportarResultado(MONZONLog log, Long idProc, String valTipoProc, Long valEstado, String mensaje): Salida");
        } catch(RemoteException re) {
            UtilidadesLog.debug(re);
        } 
    }


    private void agregarDetalle(MONZONLog log, Long idProc, String typeProc, String mensaje, Object datos) throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.agregarDetalle(MONZONLog log, Long idProc, String typeProc, String mensaje, Object datos): Entrada");
        try {
            log.agregarDetalle(idProc,typeProc, 
                               mensaje,datos);            
            UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.agregarDetalle(MONZONLog log, Long idProc, String typeProc, String mensaje, Object datos): Salida");
        } catch(RemoteException re) {
            UtilidadesLog.debug(re);
          } 
    }


    private void finalizacionProceso(MONZONLog log, Long idProc, String valTipoProc) throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.finalizacionProceso(MONZONLog log, Long idProc, String valTipoProc): Entrada");

        ZonLogLocalHome localHome = null;
        ZonLogLocal zonLocal      = null;        
        Long estatus = null;
            
        try{
            localHome = getZonLogLocalHome();            
            zonLocal = localHome.findByPrimaryKey(idProc);                
            estatus = zonLocal.getValEstado();
                    
        }catch(NoResultException fe){
            UtilidadesLog.error(fe);
            ctx.setRollbackOnly();
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if (!estatus.equals("-4")) {
            this.reportarResultado(log, idProc,valTipoProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_OK,"");
        }
        
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.finalizacionProceso(MONZONLog log, Long idProc, String valTipoProc): Salida");
    }


    private String logString(String dtos, MONZONLog log) {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.logString(String dtos, MONZONLog log): Entrada");

        int limSup = (dtos.length() < log.CANT_CARACTERES_MENSAJE_ERROR)?dtos.length():log.CANT_CARACTERES_MENSAJE_ERROR;
        
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.logString(String dtos, MONZONLog log): Salida");
        return dtos.substring(0,limSup);
        
    }
    

    private MONZONLogHome getMONZONLogHome() throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONZONLogHome(): Entrada");

        String codigoError;
        MONZONLogHome localHome = null;
        BelcorpService miBerlcorpService = null;

        try {
            miBerlcorpService = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MONZONLogHome)miBerlcorpService.ejbLocator.getHome("MONZONLog",
                    MONZONLogHome.class);
        } catch(MareServiceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONZONLogHome(): Salida");
        return localHome;
      
    }

    private MONZONLog getMONZONLog() throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONZONLog(): Entrada");
    
        MONZONLogHome logHome = getMONZONLogHome();
        MONZONLog log;
        try {
            log = logHome.create();
        } catch(RemoteException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            UtilidadesLog.error(ce);
            ctx.setRollbackOnly();
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONZONLog(): Salida");
        return log;
    }

    private MONEstructuraGeoPoliticaHome getMONEstructuraGeoPoliticaHome() throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONEstructuraGeoPoliticaHome(): Entrada");

        String codigoError;
        MONEstructuraGeoPoliticaHome localHome = null;
        BelcorpService miBerlcorpService = null;

        try {
            miBerlcorpService = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MONEstructuraGeoPoliticaHome)miBerlcorpService.ejbLocator.getHome("MONEstructuraGeoPolitica",
                    MONEstructuraGeoPoliticaHome.class);
        } catch(MareServiceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONEstructuraGeoPoliticaHome(): Salida");
        return localHome;
     
    }

    private MONUnidadesGeograficasHome getMONUnidadesGeograficasHome() throws MareException {
    
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONUnidadesGeograficasHome(): Entrada");

        String codigoError;
        MONUnidadesGeograficasHome localHome = null;
        BelcorpService miBerlcorpService = null;

        try {
            miBerlcorpService = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MONUnidadesGeograficasHome)miBerlcorpService.ejbLocator.getHome("MONUnidadesGeograficas",
                    MONUnidadesGeograficasHome.class);
        } catch(MareServiceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONUnidadesGeograficasHome(): Salida");
        return localHome;
      
    }


    private MONMantenimientoSEG getMONMantenimientoSEG() throws MareException {
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONMantenimientoSEG(): Entrada");
            
        MONMantenimientoSEGHome segHome = SEGEjbLocators.getMONMantenimientoSEGHome();
        MONMantenimientoSEG seg;
        
        try {
            seg = segHome.create();
            
        } catch(RemoteException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            UtilidadesLog.error(ce);
            ctx.setRollbackOnly();
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONUnidadGeoInterfaceGISBean.getMONMantenimientoSEG(): Salida");
        return seg;
    }

   private NivelSocioeconomicoBelcorpLocalHome getNivelSocioeconomicoBelcorpLocalHome() {
       return new NivelSocioeconomicoBelcorpLocalHome();
   }
   
   private TerritorioLocalHome getTerritorioLocalHome() {
       return new TerritorioLocalHome();
   }
   
   private ValoresEstructuraGeopoliticaLocalHome getValoresEstructuraGeopoliticaLocalHome() {
       return new ValoresEstructuraGeopoliticaLocalHome();
   }
   
    private ZonLogLocalHome getZonLogLocalHome() {
        return new ZonLogLocalHome();
    }
   

}