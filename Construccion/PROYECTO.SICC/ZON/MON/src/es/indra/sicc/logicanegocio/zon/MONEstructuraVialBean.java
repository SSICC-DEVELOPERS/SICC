package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.zon.DTOConsultaEstructuraVialPantalla;
import es.indra.sicc.dtos.zon.DTOELocalizacionDirecciones;
import es.indra.sicc.dtos.zon.DTOEstructuraVialCabecera;
import es.indra.sicc.dtos.zon.DTOEstructuraVialRegistro;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOListaFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.dtos.zon.DTOUBIGEOS;
import es.indra.sicc.dtos.zon.DTOUBIGEO;
import es.indra.sicc.dtos.zon.DTOUG;
import es.indra.sicc.dtos.zon.DTOEstructuraGeopoliticaPais;
import es.indra.sicc.entidades.seg.TipoViaLocal;
import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.ViaLocalHome;
import es.indra.sicc.entidades.zon.ViaLocal;
import es.indra.sicc.entidades.zon.ViaSegmentoLocalHome;
import es.indra.sicc.entidades.zon.ViaSegmentoLocal;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocal;
import es.indra.sicc.logicanegocio.zon.EstructuralVialFileWrapper;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.DTOSalida;
import org.apache.commons.logging.Log;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.entidades.seg.TipoViaLocalHome;

import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocalHome;

import java.util.Vector;
import java.util.Iterator;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import java.util.Collection;
import es.indra.sicc.util.DTOOID;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONEstructuraVialBean implements SessionBean, IServiceEstructuraVial {
    /*
     * Incidencias importantes 
     */
     // 557 : ViaSegmento no es auditable
     // 576 : Baja estrucuta vial, cambios en el registro y en la uk de ViaSegmento
     // 690 : atributo borrado de la entidad ViaSegmento no se utiliza

    private static String nombreMON = "MONEstructuraVial";
    private SessionContext ctx;
    private String ESTRUCTURAVIAL_CARGA = "ZONProcesarFicheroCargaEV";
    private String ESTRUCTURAVIAL_MODIFICAR = "ZONProcesarFicheroModificacionEV";
    private String ESTRUCTURAVIAL_BAJA = "ZONProcesarFicheroBajaEV";
    private String TIPO_OPERACION_ALTA = "A";
    private String TIPO_OPERACION_BAJA = "B";
    private EstructuralVialFileWrapper fileWrapper;
    
    private boolean ejecutarRollback = false;

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

    /*
     * Autor: Cortaberria
     * Fecha: 08/06/2005
     * Retorna false si debe hacer rollback
     */
    public void procesar(Long iDproc, String filePath, String typeProc, String filename) throws MareException {
        UtilidadesLog.info("MONEstructuraVialBean.procesar(Long iDproc, String filePath, String typeProc, String filename): Entrada");
        this.ejecutarRollback = false;
        if (typeProc.equals(ESTRUCTURAVIAL_CARGA)) {
            UtilidadesLog.debug("************ Llamando a procesarCarga");
            this.ejecutarRollback = !procesarCarga(iDproc, filePath, filename);
        }
        else if (typeProc.equals(ESTRUCTURAVIAL_MODIFICAR)) {
            UtilidadesLog.debug("************ Llamando a procesarModificacion");
            this.ejecutarRollback = !procesarModificacion(iDproc, filePath, filename);
        }
        else if (typeProc.equals(ESTRUCTURAVIAL_BAJA)) {
            UtilidadesLog.debug("************ Llamando a procesarBaja");
            this.ejecutarRollback = !procesarBaja(iDproc, filePath, filename);
        }
        UtilidadesLog.info("MONEstructuraVialBean.procesar(Long iDproc, String filePath, String typeProc, String filename)): Salida");        
    }


    public DTOListaFicheroDisp ficherosDisponibles(String typeProc)
        throws MareException {
        return null;
    }

    public Integer estadoProc(Long idProc) throws MareException {
        return null;
    }

    public DTOManagerFileResult obtenerResultado(Long iDproc)
        throws MareException {
        
        UtilidadesLog.info("MONEstructuraVialBean.obtenerResultado(Long iDproc): Entrada");
        
        String codigoError;
        try {
            return ZONEjbLocators.getMONZONLogHome().create().obtenerResultado(iDproc,"");
        } catch (CreateException ce) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ce,UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public DTOManagerFileResult procesarsinc(DTOFicheroDisp datos) throws MareException {
        UtilidadesLog.info("MONEstructuraVialBean.procesarsinc(DTOFicheroDisp datos): Entrada");
        
        Long idProceso;
        /*
         * Habro el archivo
         */
        fileWrapper = new EstructuralVialFileWrapper(datos.getPathFichero(), datos.getNombreFichero());

        /*
         * Valido la cabecera y si de ser correcta comienzo a procesar
         * caso contrario tiro la MareExeption
         */
        if (validarCabecera(datos.getTypeProc(), datos.getDatos()).booleanValue()) {
            /*
             * creo log del proceso
             */
             idProceso = crearLogProceso(datos.getTypeProc());

            /*
             * Llamo al procesar
             */
             procesar(idProceso, datos.getPathFichero(), datos.getTypeProc(), datos.getNombreFichero());
            /*
             * retorno los resultados
             */
            DTOManagerFileResult dtoResult =  this.obtenerResultado(idProceso);
            
            if (this.ejecutarRollback) {
                this.rollBackContexto();
            }
            UtilidadesLog.info("MONEstructuraVialBean.procesarsinc(DTOFicheroDisp datos): Salida");
            return dtoResult;
         }
         else {
            /*
             * Tiro Exception por error en cabecera
             */
            UtilidadesLog.debug("************ Entro al else - lanzando MareException - Error en el PAIS");
            UtilidadesLog.info("MONEstructuraVialBean.procesarsinc(DTOFicheroDisp datos): Salida");
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PAIS_DE_FICHERO_DIFERENTE_PAIS_ACTIVO));
         }
    }

    //-- metodos del MOM
    /*
     * Autor: Cortaberria
     * Fecha: 08/06/2005
     * Retorna false si debe hacer rollback
     */
    private boolean procesarCarga(Long IDproc, String FilePath, String FileName) throws MareException {
        UtilidadesLog.info("MONEstructuraVialBean.procesarCarga(Long IDproc, String FilePath, String FileName): Entrada");
        
        fileWrapper = new EstructuralVialFileWrapper(FilePath, FileName);

        DTOEstructuraVialCabecera cabecera = null;
        DTOEstructuraVialRegistro registro = null;

        /*
         * leo la cabecera
         */
        cabecera = obtenerCabecera();

        if (cabecera != null) {
            /*
             * Recorro los registro hasta que el me llegue un nulo (fin archivo)
             * y actualizo el estado en Ejecucion
             */
             reportarResultado(IDproc, ESTRUCTURAVIAL_CARGA, IManagerFileInterface.EN_EJECUCION,  "");

             try {
                
                while ((registro = obtenerRegistro()) != null) {
                    procesarOperacion(cabecera, registro);
                }

                /*
                 * Proceso finalizo ok, actualizo el estado
                 */
                reportarResultado(IDproc, ESTRUCTURAVIAL_CARGA, 
                                  IManagerFileInterface.PROCESAMIENTO_FINALIZADO_OK, 
                                  "");
                /*
                 * Cierro el archivo
                 */
                fileWrapper.cerrarArchivo();

            }
            catch(MareException me) {
                /*
                 * Cierro el archivo
                 */
                UtilidadesLog.error(me);
                fileWrapper.cerrarArchivo();
                
                /*
                 * catcheo de MareException y logeo de errores
                 */
             
             // Agregado por Inc. BELC300023002 alorenzo 19/04/2006   
                if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO)) {
                    // 23002 - dmorello, 15/06/2006: Se loguea en este caso el message de la excepción
                    // ya que el mismo ES EL REGISTRO ERRONEO
                    //registro = null;
                    parseErrores(me, IDproc, ESTRUCTURAVIAL_CARGA, me.getMessage());    
                } else {
                    // ELSE agregado por 23002 - dmorello - 15/06/2006
                    // En este caso SÍ se logueará el DTOEstructuraVialRegistro registro
                    parseErrores(me, IDproc, ESTRUCTURAVIAL_CARGA, registro);
                }
            // Fin Agregado por Inc. BELC300023002 alorenzo 19/04/2006                
                //parseErrores(me, IDproc, ESTRUCTURAVIAL_CARGA, registro);
                UtilidadesLog.info("MONEstructuraVialBean.procesarCarga(Long IDproc, String FilePath, String FileName): Salida");
                return false;
            }
        }
        UtilidadesLog.info("MONEstructuraVialBean.procesarCarga(Long IDproc, String FilePath, String FileName): Salida");
        return true;
    }

    /*
     * Autor: Cortaberria
     * Fecha: 08/06/2005
     * Retorna false si debe hacer rollback
     */
    private boolean procesarModificacion(Long IDproc, 
                                      String FilePath,
                                      String FileName) 
    throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.procesarModificacion(Long IDproc, String FilePath, String FileName) : Entrada");
    
        fileWrapper = new EstructuralVialFileWrapper(FilePath, FileName);
        
        DTOEstructuraVialCabecera cabecera = null;
        DTOEstructuraVialRegistro registro = null;

        /*
         * leo la cabecera
         */
        cabecera = obtenerCabecera();

        if (cabecera != null) {
            /*
             * Recorro los registro hasta que el me llegue un nulo (fin archivo)
             * y actualizo el estado en Ejecucion
             */
             reportarResultado(IDproc,
                               ESTRUCTURAVIAL_CARGA,
                               IManagerFileInterface.EN_EJECUCION,
                               "");
          try {
                while ((registro = obtenerRegistro()) != null) {
                    procesarOperacion(cabecera, registro);
                }

                /*
                 * Proceso finalizo ok, actualizo el estado
                 */
                reportarResultado(IDproc,
                                  ESTRUCTURAVIAL_CARGA,
                                  IManagerFileInterface.PROCESAMIENTO_FINALIZADO_OK,
                                  "");
           } catch(MareException me) {
                /*
                 * catcheo de MareException y logeo de errores
                 */
                parseErrores(me,IDproc,ESTRUCTURAVIAL_MODIFICAR,registro);
                UtilidadesLog.info("MONEstructuraVialBean.procesarModificacion(Long IDproc, String FilePath, String FileName): Salida");
                return false;
            }
        }
        UtilidadesLog.info("MONEstructuraVialBean.procesarModificacion(Long IDproc, String FilePath, String FileName): Salida");
        return true;
    }
    
     /*
     * Autor: Cortaberria
     * Fecha: 08/06/2005
     * Retorna false si debe hacer rollback
     */
    private boolean procesarBaja(Long IDproc,
                              String FilePath, 
                              String FileName)
    
    throws MareException {  
    
        UtilidadesLog.info("MONEstructuraVialBean.procesarBaja(Long IDproc, String FilePath, String FileName): Entrada");
        
        fileWrapper = new EstructuralVialFileWrapper(FilePath, FileName);
        Long oidPais;
        Long oidTerritorio;
        Long oidTipoVia;
        Long oidVia;
		Long oidViaSegmento;
        
        DTOEstructuraVialCabecera cabecera = null;
        DTOEstructuraVialRegistro registro = null;
        
        /*
         * leo la cabecera
         */
      cabecera = obtenerCabecera();
         UtilidadesLog.debug("**** la cabecera es: "+cabecera);   
         
        if (cabecera != null) {
            /*
             * Recorro los registro hasta que el me llegue un nulo (fin archivo)
             * y actualizo el estado en Ejecucion
             */
            UtilidadesLog.debug("**** la cabecera no es null");
             reportarResultado(IDproc,
                               ESTRUCTURAVIAL_CARGA,
                               IManagerFileInterface.EN_EJECUCION,
                               "");
          try {
                while ((registro = obtenerRegistro()) != null) {
                   UtilidadesLog.debug("**** el registro es: "+registro);
                    /*
                    * obtengo el pais
                    */
                    
                    
                    if(!(registro.getOperacion().equals(TIPO_OPERACION_BAJA)||
                        registro.getOperacion().equals(TIPO_OPERACION_ALTA))){
                        throw new MareException(null,null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON,
                                                                                "",
                                                                                ErroresDeNegocio.OPERACION_INCORRECTA));
                    }
                    
                    
                    oidPais = obtenerOidPais(cabecera.getPais());
                    UtilidadesLog.debug("**** obtiene oidpais: "+oidPais);

                    /*
                     * busco el tipo de via
                     */
//                    oidTipoVia = buscaTipoViaPorUK(registro.getTipoVia());

                    /*
                     * busco la via
                     */
                    UtilidadesLog.debug("**** codigo de via es: "+registro.getCodVia()); 
                    oidVia = buscaViaPorUK(oidPais, registro.getCodVia());
                    UtilidadesLog.debug("**** obtiene oidVia: "+oidVia);
					// MODIFICADO
					oidViaSegmento = findByViaSegmentoWrapper(oidVia, registro.getNumViaSegmento());
                    UtilidadesLog.debug("**** obtiene oidViaSEGMENTO: "+oidViaSegmento);                        

	                 /*
                     * Inactivar vias segmento para esa via y esos territorios
                     */
					 UtilidadesLog.debug("**** llama a inactivaViaSegmento");
                     inactivaViaSegmento(oidVia, registro);
                     
					try{
                        buscarViaSegmentoPorVia
                        (oidVia);	
                        
					}catch(MareException me){
						UtilidadesLog.debug(me);
                        if( me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO) ){
							UtilidadesLog.debug("**** TIRO: NO_EXISTE_VIA_SEGMEN ");
                            /*
		                     * inactivar Via
							 */
                            UtilidadesLog.debug("**** LLama a inactivarVia"); 
							inactivarVia(oidVia);		
						}
					}
                    
                }

                /*
                 * Proceso finalizo ok, actualizo el estado
                 */
                reportarResultado(IDproc,
                                  ESTRUCTURAVIAL_CARGA,
                                  IManagerFileInterface.
                                  PROCESAMIENTO_FINALIZADO_OK,
                                  "");
								  
           } catch(MareException me) {
                /*
                 * catcheo de MareException y logeo de errores
                 */
                parseErrores(me,IDproc,ESTRUCTURAVIAL_MODIFICAR,registro);
                UtilidadesLog.info("MONEstructuraVialBean.procesarBaja(Long IDproc, String FilePath, String FileName): Salida");
                return false;
            }
        }
        UtilidadesLog.info("MONEstructuraVialBean.procesarBaja(Long IDproc, String FilePath, String FileName): Salida");
        return true;
    }


	private Collection buscarViaSegmentoPorVia(Long oidVia) throws MareException{
            
            UtilidadesLog.info("MONEstructuraVialBean.buscarViaSegmentoPorVia(Long oidVia): Entrada");
            
            Collection viasSegmento = null;
            ViaSegmentoLocal viaSegmento = null;
            
            UtilidadesLog.debug("oidVia: " + oidVia);
            try{
                viasSegmento = this.getViaSegmentoLocalHome().findByVia(oidVia);
                UtilidadesLog.debug("los viasegmentos encontrados: "+viaSegmento);
                if( viasSegmento.size() >= 1 ){
                    Iterator it = viasSegmento.iterator();
                    UtilidadesLog.debug("recorro los viasegmentos buscado uno activo");
                    while(it.hasNext()){
                    viaSegmento = (ViaSegmentoLocal)it.next();
                    if( viaSegmento.getActivo().booleanValue() ){
                        UtilidadesLog.debug("encontro uno activo lo devuelvo");
                        UtilidadesLog.info("MONEstructuraVialBean.buscarViaSegmentoPorVia(Long oidVia): Salida");
                        return viasSegmento;	
                        }
                    }
                    
                    UtilidadesLog.info("MONEstructuraVialBean.buscarViaSegmentoPorVia(Long oidVia): Salida");
                    // Estan todos desactivados
                    throw new MareException(null, null, 
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
                }else{
                    UtilidadesLog.info("MONEstructuraVialBean.buscarViaSegmentoPorVia(Long oidVia): Salida");
                    throw new MareException(null, null, 
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
                }
                
            
            }catch(NoResultException fe){
            throw new MareException(null, null,
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
	}

	
	private Long findByViaSegmentoWrapper(Long oidVia, String numViaSegmento) throws MareException{
            UtilidadesLog.info("MONEstructuraVialBean.findByViaSegmentoWrapper(Long oidVia, String numViaSegmento): Entrada");
            
            Collection viasSegmento = null;
            ViaSegmentoLocal viaSegmento = null;
            try{
                Integer secuencia = new Integer(numViaSegmento);
                viasSegmento = this.getViaSegmentoLocalHome().findByViaSegmento(oidVia, secuencia);
                if( viasSegmento.size() >= 1 ){
                    viaSegmento = (ViaSegmentoLocal)viasSegmento.iterator().next();
                    UtilidadesLog.info("MONEstructuraVialBean.findByViaSegmentoWrapper(Long oidVia, String numViaSegmento): Salida");
                    return viaSegmento.getOid();
                }else{
                    UtilidadesLog.info("MONEstructuraVialBean.findByViaSegmentoWrapper(Long oidVia, String numViaSegmento): Salida");
                    throw new MareException(null, null,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
                }
            }catch(NoResultException fe){
                throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
	}
			
	

    private Boolean validarCabecera(String typeProc, Object datos) throws MareException {
        UtilidadesLog.info("MONEstructuraVialBean.validarCabecera(String typeProc, Object datos): Entrada");
        
        Long oidPais;
        
        /*
         * Leo la cabecera, si no existe o faltan lineas o no se puede 
         * convertir  algun campo tira MareException
         */
        DTOEstructuraVialCabecera cabecera = obtenerCabecera();

        /*
         * obtengo el pais
         */    
        oidPais = obtenerOidPais(cabecera.getPais());

        /*
         * Verifico que el pais de la cabecera sea idem al del usuario 
         * de session
         */         
        if (!((DTOBelcorp)datos).getOidPais().equals(oidPais)) {
            UtilidadesLog.debug("************ Entro al if, devuelve false");
            return Boolean.FALSE;
        }
        
        /*
         * Verifico que el tipo de fichero
         */
         if(!((cabecera.getTipoFichero().equalsIgnoreCase("CARGA VIAL") && typeProc.equals(ESTRUCTURAVIAL_CARGA)) || 
            (cabecera.getTipoFichero().equalsIgnoreCase("BAJA VIAL") && typeProc.equals(ESTRUCTURAVIAL_BAJA)) ||
            (cabecera.getTipoFichero().equalsIgnoreCase("MODIFICACION VIAL") && typeProc.equals(ESTRUCTURAVIAL_MODIFICAR)))) {

            UtilidadesLog.debug("************ Entro al if, lanza una MareException - CABECERA NO VALIDA");
            UtilidadesLog.info("MONEstructuraVialBean.validarCabecera(String typeProc, Object datos): Salida");
            throw new MareException(null, null,	UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CABECERA_FICHERO_NO_VALIDA));
          
         }

        UtilidadesLog.debug("************ Paso - devuelve TRUE");
        UtilidadesLog.info("MONEstructuraVialBean.validarCabecera(String typeProc, Object datos): Salida");
        return Boolean.TRUE;
    }

    private void ejecutarBaja(String codPais,
                              DTOEstructuraVialRegistro registro)
        throws MareException {
        
        UtilidadesLog.info("MONEstructuraVialBean.ejecutarBaja(String codPais, DTOEstructuraVialRegistro registro): Entrada");
        
        Long oidPais;
        Long oidTerritorio;
        Long oidTipoVia;
        Long oidVia;
		Long oidViaSegmento;

        /*
         * obtengo el pais
         */
        
        
        oidPais = obtenerOidPais(codPais.toString());
        UtilidadesLog.debug("**** obtiene el oidpais: "+oidPais);
        /*
         * busco Territorio por el codigo de pais
         */
        oidTerritorio = buscaTerritorioPorUK(registro.getCodTerritorio(),
                                             oidPais,
                                             null);
        UtilidadesLog.debug("**** obtiene el oidterritorio: "+oidTerritorio);
		// MODIFICACION
		oidVia = findByPaisSecuencialWrapper(oidPais, registro.getCodVia());
		UtilidadesLog.debug("**** obtiene el oidVia: "+oidVia);
        
        //

		// MODIFICACION incidencia 7717
		oidViaSegmento = findByTerritorioViaSegmentoWrapper(oidTerritorio, oidVia, registro.getNumViaSegmento());
		UtilidadesLog.debug("**** obtiene el oidviaSegmento: "+oidViaSegmento);
        /*
         * busco el tipo de via
         */
//        oidTipoVia = buscaTipoViaPorUK(registro.getTipoVia());

        /*
         * busco la via
         */
/*        oidVia = buscaViaPorUK(oidPais,
                               registro.getNomVia(),
                               oidTipoVia);

        /*
         * Inactivo la segmento via
         */
        inactivaViaSegmento (oidVia, registro);
        UtilidadesLog.info("MONEstructuraVialBean.ejecutarBaja(String codPais, DTOEstructuraVialRegistro registro): Salida");
    }


	private Long findByTerritorioViaSegmentoWrapper(Long oidTerritorio, Long oidVia, String numViaSegmento) throws MareException{
  
            UtilidadesLog.info("MONEstructuraVialBean.findByTerritorioViaSegmentoWrapper(Long oidTerritorio, Long oidVia, String numViaSegmento): Entrada");
            
            Collection viasSegmento = null;
            Integer secuencia = null;
            ViaSegmentoLocal viaSegmento = null;
            try{
                secuencia = new Integer(numViaSegmento);
                viasSegmento = this.getViaSegmentoLocalHome().findByTerritorioViaSegmento(oidTerritorio, oidVia, secuencia);
                if( viasSegmento.size() >= 1 ){
                    viaSegmento = (ViaSegmentoLocal)viasSegmento.iterator().next();
                    UtilidadesLog.info("MONEstructuraVialBean.findByTerritorioViaSegmentoWrapper(Long oidTerritorio, Long oidVia, String numViaSegmento): Salida");
                    return viaSegmento.getOid();
                }else{
                    UtilidadesLog.info("MONEstructuraVialBean.findByTerritorioViaSegmentoWrapper(Long oidTerritorio, Long oidVia, String numViaSegmento): Salida");
                    throw new MareException(null, null,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
                }
            }catch(NoResultException fe){
                throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
	}
	
	/**
	 * Sistema:     Belcorp
	 * Modulo:      ZON
	 * Fecha:       01/09/2004
	 * @version     3.2
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: 
	 */
	private Long findByPaisSecuencialWrapper(Long oidPais, String secuencial) throws MareException{
            UtilidadesLog.info("MONEstructuraVialBean.findByPaisSecuencialWrapper(Long oidPais, String secuencial): Entrada");
            
            ViaLocal via = null;
            Integer secuencia = null;
            try{
                secuencia = new Integer(secuencial);
                via = this.getViaLocalHome().findByPaisSecuencial(oidPais, secuencia);
                UtilidadesLog.debug("**** obtiene la via y devuelve el oid: "+via);
                UtilidadesLog.info("MONEstructuraVialBean.findByPaisSecuencialWrapper(Long oidPais, String secuencial): Salida");
                return via.getOid();
            } catch(NoResultException fe){
                UtilidadesLog.debug("**** tiro FinderException - mensaje: NO_EXISTE_VIA");
                UtilidadesLog.debug(fe);
                throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
				
	}


    private void ejecutaAlta(String codPais, DTOEstructuraVialRegistro registro) throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.ejecutaAlta(String codPais, DTOEstructuraVialRegistro registro): Entrada");
        
        Long oidPais;
        Long oidTerritorio;
        Long oidTipoVia;
        Long oidVia;

        /*
         * obtengo el pais
         */
        oidPais = obtenerOidPais(codPais.toString());

        /*
         * busco Territorio por el codigo de pais y verifico q no este Borrado
         */
        oidTerritorio = buscaTerritorioPorUK(registro.getCodTerritorio(), oidPais, Boolean.FALSE);

        // Modificación
        oidVia = findByPaisSecuencialWrapper(oidPais, registro.getCodVia());

		
        /*
         * busco el tipo de via
         */
        //oidTipoVia = buscaTipoViaPorUK(registro.getTipoVia());

        /*
         * busco la via
         */
        /* oidVia = buscaViaPorUK(oidPais, registro.getNomVia(), oidTipoVia);*/

        // Modificacion
        ValoresEstructuraGeopoliticaLocal valoresEstructura = findByUbigeoWrapper(oidPais, registro.getUBIGEO());


        /*
         * creo el segmento via
         */
        crearViaSegmento(oidTerritorio, oidVia, registro);
        
        UtilidadesLog.info("MONEstructuraVialBean.ejecutaAlta(String codPais, DTOEstructuraVialRegistro registro): Salida");
    }


	/**
	 * Sistema:     	Belcorp
	 * Modulo:      	ZON
	 * Fecha:       	01/09/2004
	 * @version     	3.2
	 * @autor       	grusso
	 * Modificado por	rgiorgi
	 */
	private ValoresEstructuraGeopoliticaLocal findByUbigeoWrapper(Long oidPais, String ubigeo) throws MareException {
  
    UtilidadesLog.info("MONEstructuraVialBean.findByUbigeoWrapper(Long oidPais, String ubigeo)): Entrada");
    
		Vector ordenes = new Vector();
		int poscInicial = 0;
		int poscFinal = 6;
        ubigeo = ubigeo.trim(); //Agregado CNoziglia si el fichero trae espacio vacios no identifica el Ubigeo
		if( ubigeo.length() < 6 || ubigeo.length() > 54 ){
      UtilidadesLog.debug("************ ubigeo menor a 6 o mayor a 54 - lanza una MareException - NO EXISTE UBIGEO");
			throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_UBIGEO));
		}

		int cant = ubigeo.length() / 6;
		int rest = ubigeo.length() % 6;

		if( rest != 0 ){
      UtilidadesLog.debug("************ rest es distinto de 0 - lanza una MareException - NO EXISTE UBIGEO");
			throw new MareException(null,
                                    null, 
                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON,
                                    "",
                                    ErroresDeNegocio.NO_EXISTE_UBIGEO));
		}
			
		String orden = null;
		for(int i = 0; i < cant; i++ ){
			orden = ubigeo.substring(poscInicial, poscFinal);
			ordenes.add(orden);
			poscInicial = poscFinal;
			poscFinal += 6;
		}
		
        try{
            String [] arrayOrdenes = new String[9]; // Por 9 ordenes
            Object [] auxOrdenes = null;
            auxOrdenes = ordenes.toArray();
            
            for(int i = 0; i < auxOrdenes.length; i++){
                arrayOrdenes[i] = (String)auxOrdenes[i];
            }

            //Para ver el array*******************************************************
            for(int i=0; i< arrayOrdenes.length; i++) {
                UtilidadesLog.debug("************** i " + i);
                UtilidadesLog.debug("************** arrayOrdenes " + arrayOrdenes[i]);
            }
            //***********************************************************************

            Collection estructuras = this.getValoresEstructuraGeopoliticaLocalHome().findByUbigeo(
                arrayOrdenes[0], arrayOrdenes[1], arrayOrdenes[2], arrayOrdenes[3], arrayOrdenes[4], arrayOrdenes[5],
                arrayOrdenes[6], arrayOrdenes[7], arrayOrdenes[8], oidPais);
            
            UtilidadesLog.debug("************** estructuras - size " + estructuras.size());
            
            if( estructuras.size() == 0 || estructuras.size() > 1 ){
                UtilidadesLog.debug("************ estructuras igual a 0 o mayor a 1 - se lanza MareException - NO EXISTE UBIGEO");
                throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_UBIGEO));
            }
            
            ValoresEstructuraGeopoliticaLocal valoresEstructura = (ValoresEstructuraGeopoliticaLocal)estructuras.iterator().next();
            
            UtilidadesLog.info("MONEstructuraVialBean.findByUbigeoWrapper(Long oidPais, String ubigeo): Salida");
            return valoresEstructura;
        } catch(NoResultException fe){
            UtilidadesLog.debug("************ !!entro al catch - finderException - NO EXISTE UBIGEO");
            throw new MareException(null, null,	UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_UBIGEO));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
     }
	

      public DTOConsultaEstructuraVialPantalla consultaDatosPantalla(DTOPais dtoPais) 
      throws  MareException{
      
        UtilidadesLog.info("MONEstructuraVialBean.consultaDatosPantalla(DTOPais dtoPais): Entrada");

        DTOConsultaEstructuraVialPantalla dtoCEVP = new DTOConsultaEstructuraVialPantalla();

        DTOUG dtoUG = new DTOUG();

        /*
         * se recuperar las de primer nivel
         */
        dtoUG.setOidUG( null );
        dtoUG.setOidPais(dtoPais.getPais());
        dtoUG.setFiltroActiva(Boolean.TRUE);

        //dtos que reciben datos a guardarse en DTOConsultaEstructuraVialPantalla para
        // ser devueltos por este metodo
        DTOSalida dtoTiposVia = null;
        DTOSalida dtoUnidadesGeograficas = null;
        DTOEstructuraGeopoliticaPais dtoEGP = null;

        dtoTiposVia = recuperarTiposVia( (DTOBelcorp)dtoPais );
        dtoUnidadesGeograficas = recuperarUnidadesGeograficas( dtoUG );
        dtoEGP = recuperarEstructuraGeoPolitica( dtoPais );

        dtoCEVP.setTiposVia( (dtoTiposVia == null) ? null : dtoTiposVia.getResultado() );
        dtoCEVP.setUnidadesGeo( (dtoUnidadesGeograficas == null) ? null : dtoUnidadesGeograficas.getResultado() );
        dtoCEVP.setNivelesGeopoliticos( dtoEGP );

        UtilidadesLog.info("MONEstructuraVialBean.consultaDatosPantalla(DTOPais dtoPais) : Salida");
        return dtoCEVP;
      }

      // ---------------------------------------------------------------------------
      // Se invocan metodos de los MON MONMantenimientoSEG, MONUnidadesGeograficas y 
      // MONEstructuraGeoPolitica.
      // ---------------------------------------------------------------------------
      private DTOSalida recuperarTiposVia( DTOBelcorp dto ) 
      throws MareException {
        
        UtilidadesLog.info("MONEstructuraVialBean.recuperarTiposVia( DTOBelcorp dto ): Entrada");
        
        DTOSalida dtoSalida = null;
        int errorCode;
        try {
          //Creamos una instancia e invocamos al metodo 
          return SEGEjbLocators.getMONMantenimientoSEGHome().create().recuperarTiposVia(dto);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            errorCode = UtilidadesError.armarCodigoError(
               CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE );
            throw new MareException(new Exception(), errorCode);
        } 
      }

      private DTOSalida recuperarUnidadesGeograficas( DTOUG dtoUG ) 
      throws MareException {
      
        UtilidadesLog.info("MONEstructuraVialBean.recuperarUnidadesGeograficas( DTOUG dtoUG ): Entrada");
        
        DTOSalida dtoSalida = null;
        int errorCode;
        try {
          //Creamos una instancia y llamamos al metodo
          return ZONEjbLocators.getMONUnidadesGeograficasHome().
                                   create().obtenerUnidadesGeograficas( dtoUG );
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            errorCode = UtilidadesError.armarCodigoError(
               CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE );
            throw new MareException(new Exception(), errorCode);
        } 
      }

      private DTOEstructuraGeopoliticaPais recuperarEstructuraGeoPolitica( DTOPais dtoPais ) 
      throws MareException {
        
        UtilidadesLog.info("MONEstructuraVialBean.recuperarEstructuraGeoPolitica( DTOPais dtoPais )): Entrada");
        
        int  errorCode;      
        try {
          //Creamos una instancia e inocamos al metodo
          return ZONEjbLocators.getMONEstructuraGeoPoliticaHome().create().
                            obtenerEstructuraGeoPolitica( dtoPais );
        } catch (Exception e) {
            errorCode = UtilidadesError.armarCodigoError(
               CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE );
            throw new MareException(new Exception(), errorCode);
        } 
      }


    private DTOEstructuraVialCabecera obtenerCabecera()
    throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.obtenerCabecera(): Entrada");

        Object dto = null;
        
        try {
            dto = fileWrapper.leerCabecera();
        } catch(MareException me) {
            UtilidadesLog.error(me);
            throw new MareException(me,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CABECERA_FICHERO_NO_VALIDA));            
        } catch (Exception e) {
            UtilidadesLog.error(e);
        }

        UtilidadesLog.info("MONEstructuraVialBean.obtenerCabecera(): Salida");
            return (DTOEstructuraVialCabecera) dto;
       
    }

    private DTOEstructuraVialRegistro obtenerRegistro()
        throws MareException {
        
        UtilidadesLog.info("MONEstructuraVialBean.obtenerRegistro(): Entrada");
        
        Object dto = fileWrapper.leerRegistro();
        
        if (dto != null) {
            UtilidadesLog.debug("**** sale de obtenerRegistro() con: "+dto);
            UtilidadesLog.info("MONEstructuraVialBean.obtenerRegistro(): Salida");
            return (DTOEstructuraVialRegistro) dto;
        }
        UtilidadesLog.debug("**** sale de obtenerRegistro() con null ");
        UtilidadesLog.info("MONEstructuraVialBean.obtenerRegistro(): Salida");
        return null;
    }

    private void procesarOperacion(DTOEstructuraVialCabecera cabecera, DTOEstructuraVialRegistro registro) throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.procesarOperacion(DTOEstructuraVialCabecera cabecera, DTOEstructuraVialRegistro registro): Entrada");

        if (registro.getOperacion().equals(TIPO_OPERACION_ALTA)) {
            UtilidadesLog.debug("************ Llamando a ejecutaAlta");
            ejecutaAlta(cabecera.getPais(),registro);
        }
        else if (registro.getOperacion().equals(TIPO_OPERACION_BAJA)) {
            UtilidadesLog.debug("************ Llamando a ejecutaBaja");
            ejecutarBaja(cabecera.getPais(),registro);
        }else{ //BELC300014795
            UtilidadesLog.info("MONEstructuraVialBean.procesarOperacion(DTOEstructuraVialCabecera cabecera, DTOEstructuraVialRegistro registro): Salida");
            throw new MareException(null,null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON,
                                                                                "",
                                                                                ErroresDeNegocio.OPERACION_INCORRECTA));
        }
        
        UtilidadesLog.info("MONEstructuraVialBean.procesarOperacion(DTOEstructuraVialCabecera cabecera, DTOEstructuraVialRegistro registro): Salida");
    }

    private Long crearLogProceso(String tipoProceso) throws MareException {
        UtilidadesLog.info("MONEstructuraVialBean.crearLogProceso(String tipoProceso): Entrada");
        
        String codigoError;
        try {
            return ZONEjbLocators.getMONZONLogHome().create().crearLogProceso(tipoProceso);
        } catch(CreateException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));
        } catch(RemoteException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private void agregarDetalleLog(Long idProc,
                                   String tipoProceso,
                                   String codMensaje,
                                   Object datos) throws MareException {
                                   
        UtilidadesLog.info("MONEstructuraVialBean.agregarDetalleLog(Long idProc,String tipoProceso, String codMensaje, Object datos) : Entrada");
        
        UtilidadesLog.debug("idProc: " + idProc);
        UtilidadesLog.debug("tipoProceso: " + tipoProceso);
        UtilidadesLog.debug("codMensaje: " + codMensaje);
        UtilidadesLog.debug("datos: " + datos);
        
        String codigoError;
        try {
            ZONEjbLocators.getMONZONLogHome().create().agregarDetalle(idProc,
                                                                      tipoProceso,
                                                                      codMensaje,
                                                                      datos);
                                                                      
            UtilidadesLog.info("MONEstructuraVialBean.agregarDetalleLog(Long idProc,String tipoProceso, String codMensaje, Object datos): Salida");                                                                      
        } catch(CreateException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));
        } catch(RemoteException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));
        }
    }

    
    private void reportarResultado(Long idProceso,
                                   String tipoProceso,
                                   Long valEstado,
                                   String mensaje) 
    throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.reportarResultado(Long idProceso, String tipoProceso, Long valEstado, String mensaje) : Entrada");
        
        String codigoError;
        try {
            ZONEjbLocators.getMONZONLogHome().create().reportarResultado(idProceso, 
                                                                         tipoProceso,
                                                                         valEstado,
                                                                         mensaje);
            UtilidadesLog.info("MONEstructuraVialBean.reportarResultado(Long idProceso, String tipoProceso, Long valEstado, String mensaje): Salida");                                                                         
        } catch(CreateException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));
        } catch(RemoteException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private Long obtenerOidPais(String codPais) throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.obtenerOidPais(String codPais): Entrada");
        
        String codigoError;
        try {	
			MONMantenimientoSEG mon = SEGEjbLocators.getMONMantenimientoSEGHome().create();
			return mon.obtenerOidPais(codPais);
        } catch(CreateException ce) {
           codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(ce,UtilidadesError.armarCodigoError(codigoError)); 
        } catch(RemoteException re) {
           codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(re,UtilidadesError.armarCodigoError(codigoError)); 
        } catch(MareException me) {
           return null;
        }     
        
    }

    private Long buscaTerritorioPorUK(String codigoTerritorio, Long oidPais, Boolean borrado)throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.buscaTerritorioPorUK(String codigoTerritorio, Long oidPais, Boolean borrado): Entrada");
        
        String codigoError;
        Collection territorios;
        TerritorioLocal territorio;
        Long borrar = null;
		
        if( borrado != null && borrado.booleanValue() ){
          UtilidadesLog.debug("************ borrar es 1");
          borrar = new Long(1);
        }
        else{
          UtilidadesLog.debug("************ borrar es 0");
          borrar = new Long(0);
        }

        try {
          UtilidadesLog.debug("************ Llamando a findByCodigoPaisBorrado");
          territorios = this.getTerritorioLocalHome().findByCodigoPaisBorrado(new Long(codigoTerritorio), oidPais);

            /*
             * verifico que los territorios retonados sean solo 1 (por la UK)
             * si trae size = 0, entonces no existe el territorio y retorno null
             * si trae size > 1 no se respecta la UK
             */
            if (territorios.size()==1) {
                UtilidadesLog.debug("************ territorios es 1");
                territorio = (TerritorioLocal)territorios.iterator().next();
                if ((borrado!=null && territorio.getBorrado().equals(borrar)) || (borrado==null)) {
                        UtilidadesLog.debug("************ devuelve territorio - getOid");
                        UtilidadesLog.info("MONEstructuraVialBean.buscaTerritorioPorUK(String codigoTerritorio, Long oidPais, Boolean borrado): Salida");                                                                         
                        return territorio.getOid();
                }
                else {
                  UtilidadesLog.debug("************ Lanza MareException - NO EXISTE TERRITORIO");
                  UtilidadesLog.info("MONEstructuraVialBean.buscaTerritorioPorUK(String codigoTerritorio, Long oidPais, Boolean borrado): Salida");                                                                         
                  throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_TERRITORIO));
                }
            }
            else if (territorios.size()==0) {
                UtilidadesLog.debug("************ territorios es 0 - lanza MareException - NO EXISTE TERRITORIO");            
                UtilidadesLog.info("MONEstructuraVialBean.buscaTerritorioPorUK(String codigoTerritorio, Long oidPais, Boolean borrado): Salida");                                                                         
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_TERRITORIO));
            }
            else {
                UtilidadesLog.debug("************ lanza MareException - EXISTE MAS DE UN TERRITORIO POR CODIGO PAIS");
                UtilidadesLog.info("MONEstructuraVialBean.buscaTerritorioPorUK(String codigoTerritorio, Long oidPais, Boolean borrado): Salida");                                                                         
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.EXISTE_MAS_DE_UN_TERRITORIO_POR_CODIGO_PAIS));
            }
            
        }
        catch(NoResultException fe) {
           codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(fe,UtilidadesError.armarCodigoError(codigoError));             
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    private Long buscaTipoViaPorUK(String codigoTipoVia)
    throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.buscaTipoViaPorUK(String codigoTipoVia): Entrada");
        
        String codigoError;
        Long oidTipoVia;
        try {
            oidTipoVia = SEGEjbLocators.getMONMantenimientoSEGHome().create().obtenerOidTipoVia(codigoTipoVia);
             /*
             * verifico que el tipo de via existe, en caso de no existir 
             * tiro una execpcion correspondiente
             */
            if (oidTipoVia!=null) {
                UtilidadesLog.info("MONEstructuraVialBean.buscaTipoViaPorUK(String codigoTipoVia): Salida");
                return oidTipoVia;
            } else {
        UtilidadesLog.info("MONEstructuraVialBean.buscaTipoViaPorUK(String codigoTipoVia): Salida");
				throw new MareException(null, null,
				  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_TIPOVIA));
            }
        } catch(CreateException ce) {
           codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(ce,UtilidadesError.armarCodigoError(codigoError));             
        } catch(RemoteException re) {
           codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));                         
        } catch(MareException me) {
           throw new MareException(me,
				  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_TIPOVIA));                         
        }
    }

    private Long buscaViaPorUK(Long oidPais, String codVia)  throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.buscaViaPorUK(Long oidPais, String codVia): Entrada");
        
        String codigoError;
        ViaLocal via;
        try {
            UtilidadesLog.debug("*****-* busca con oidpais: "+oidPais);
            UtilidadesLog.debug("*****-* y con codVia: "+codVia);
            
            Integer secuencia = new Integer(codVia);
            via = this.getViaLocalHome().findByPaisSecuencial(oidPais, secuencia );
            
            UtilidadesLog.debug("************ obtiene la via: "+via);
            UtilidadesLog.debug("************ obtiene el ind activo: "+ via.getActivo());
            
            /*
             * verifico que los territorios retonados sean solo 1 (por la UK)
             * si trae size = 0, entonces no existe el territorio y retorno null
             * si trae size > 1 no se respecta la UK
             */
/*
            if (vias.size()==1) {
                via = (ViaLocal)vias.iterator().next();
*/
                /*
                 * incidencia 459: verifico q este activa la via
                 */

                if (via.getActivo().booleanValue()) {
                    UtilidadesLog.debug("*********** la via esta activa devuelve el oid");
                    UtilidadesLog.info("MONEstructuraVialBean.buscaViaPorUK(Long oidPais, String codVia): Salida");
                    return via.getOid();    
                } else {
                UtilidadesLog.info("MONEstructuraVialBean.buscaViaPorUK(Long oidPais, String codVia): Salida");
					throw new MareException(null, null,
					  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.VIA_INACTIVA));
                }

        } catch(NoResultException fe) {
            UtilidadesLog.debug("************ La via no existe tiro Finder con NO_EXISTE_VIA");
            UtilidadesLog.debug(fe);
            throw new MareException(null, null,
					  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    private Long crearViaSegmento(Long oidTerritorio, Long oidVia, DTOEstructuraVialRegistro registro) throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.crearViaSegmento(Long oidTerritorio, Long oidVia, DTOEstructuraVialRegistro registro): Entrada");

        String strNum = registro.getNumViaSegmento();
        if(strNum.length()>3) {
          UtilidadesLog.debug("*********** num via Segmento mayor a 3");
          throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.ERROR_AL_CREAR_VIA_SEGMENTO));                    
        }
        else {
          UtilidadesLog.debug("*********** OK num via Segmento menor o igual a 3");
        }
        

        String codigoError;
        ViaSegmentoLocal viaSegmento;
        ViaSegmentoLocalHome viaSegmentoLH;
        
        viaSegmentoLH = this.getViaSegmentoLocalHome();
        try {
            viaSegmento = buscarViaSegmento(oidVia, registro);
            UtilidadesLog.info("MONEstructuraVialBean.crearViaSegmento(Long oidTerritorio, Long oidVia, DTOEstructuraVialRegistro registro): Salida");
        }
        catch (MareException e) {
          UtilidadesLog.debug("************ Entro al catch");
          if (e.getCode() == UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO)) {
                UtilidadesLog.debug("************ Entro al if");
                try {
                  Integer numViaSegmento = new Integer(registro.getNumViaSegmento());
                  Timestamp tiempoLocal = new Timestamp(System.currentTimeMillis());
                  UtilidadesLog.debug("************ Haciendo el create");
                  UtilidadesLog.debug("************ PARAMETROS DEL CREATE:");
                  UtilidadesLog.debug("************ oidTerritorio " + oidTerritorio);
                  UtilidadesLog.debug("************ oidVia " + oidVia);
                  UtilidadesLog.debug("************ numViaSegmento " + numViaSegmento);
                  
                  viaSegmento = viaSegmentoLH.create(oidTerritorio, oidVia, numViaSegmento, new Timestamp(System.currentTimeMillis()));

                    /*
                     * Seteo el resto de los atributos
                     */
                  UtilidadesLog.debug("************ Seteando el resto de los valores");

                  viaSegmento.setNumeroInicialSegmento(UtilidadesBelcorp.StringToInteger(registro.getNumInicio()));
                  viaSegmento.setNumeroFinalSegmento(UtilidadesBelcorp.StringToInteger(registro.getNumFin()));
                  viaSegmento.setSentido(UtilidadesBelcorp.StringToCharacter(registro.getSentido()));
                  viaSegmento.setLado(UtilidadesBelcorp.StringToCharacter(registro.getLado()));
                  viaSegmento.setActivo(new Boolean(true));
                
                  viaSegmentoLH.merge(viaSegmento);
                  

                    /*
                     * retorno el oid
                     */
                  UtilidadesLog.info("MONEstructuraVialBean.crearViaSegmento(Long oidTerritorio, Long oidVia, DTOEstructuraVialRegistro registro): Salida");   
                  return viaSegmento.getOid();
                }
                catch (PersistenceException ce) {
                  UtilidadesLog.debug("************ Entro al catch CreateException- ERROR AL CREAR VIA SEGMENTO");
                  UtilidadesLog.debug(ce);
                  throw new MareException(ce, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.ERROR_AL_CREAR_VIA_SEGMENTO));
                }
                catch (MareException me) {
                    if (me.getCode()==0) {
                      UtilidadesLog.debug("************ Entro al catch MareException- DATO DE REGISTRO ERRONEO");
                      throw new MareException(me, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO));
                    }
                    else {
                      throw me;
                    }
                }
            }
        }

        /*
         * Si no tiro exception, es por que encontre el registro, tiro exception
         * hago esto para evitar que me llegue la SQLException al cliente
         * utilizando la BussinesFacade
         */
        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.ERROR_AL_CREAR_VIA_SEGMENTO));
    }

    private Long inactivaViaSegmento(Long oidVia, DTOEstructuraVialRegistro registro) throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.inactivaViaSegmento(Long oidVia, DTOEstructuraVialRegistro registro): Entrada"); 
        
        String codigoError;
        ViaSegmentoLocal viaSegmento;
        Collection viasSegmento;
        ViaSegmentoLocalHome viaSegmentoLH;

        viaSegmento = buscarViaSegmento(oidVia, registro);

        if (viaSegmento != null) {
            /*
             * Inactivo la Via Segmento
             */
            viaSegmentoLH = this.getViaSegmentoLocalHome();
            viaSegmento.setActivo(Boolean.FALSE);
            
            viaSegmentoLH.merge(viaSegmento);
            
            UtilidadesLog.info("MONEstructuraVialBean.inactivaViaSegmento(Long oidVia, DTOEstructuraVialRegistro registro): Salida");
            return viaSegmento.getOid();
        } else {
			throw new MareException(null, null,
				  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
        }
        
    }

    /*
     * Autor Cortaberria
     * Fecha 08/07/2005
     * Se elimina el rollback ya que se debe ejecutar este al finalizar todo el proceso
     * Si no se hace de esta manera genera error no documentado.
     * 
     * Modificador por 23002 - dmorello - 15/06/2006:
     * El último parámetro sera un Object, ya que puede venir un DTOEstructuraVialRegistro
     * o bien un String
     */
    
    private void parseErrores(MareException me,
                              Long idProc,
                              String tipoProceso,
                              //DTOEstructuraVialRegistro registro) 
                              Object registro)
    throws MareException {
        UtilidadesLog.info("MONEstructuraVialBean.parseErrores(MareException me, Long idProc, String tipoProceso,DTOEstructuraVialRegistro registro) : Entrada");
        
        String codMensaje;

        /*
         * RollBack
         */
        
        if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.NO_EXISTE_TERRITORIO)) {
            codMensaje = "M00008";    
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.EXISTE_MAS_DE_UN_TERRITORIO_POR_CODIGO_PAIS)) {
            codMensaje = "M00021";
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.NO_EXISTE_TIPOVIA)) {
            codMensaje = "M00023";
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.EXISTE_MAS_DE_UN_TIPOVIA_POR_CODIGO)) {
            codMensaje = "M00022";        
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.NO_EXISTE_VIA)) {
            codMensaje = "M00025";
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.EXISTE_MAS_DE_UNA_VIA_POR_PAIS_NOMBRE_TIPO)) {
            codMensaje = "M00024";
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO)) {
            codMensaje = "M00027";
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.EXISTE_MAS_DE_UNA_VIA_SEGMENTO_POR_TERRITORIO_VIA)) {
            codMensaje = "M00028";
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO)) {
            codMensaje = "M00013";
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.ERROR_AL_CREAR_VIA_SEGMENTO)) {
            codMensaje = "M00026";
        } else if (me.getCode()== Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.NO_EXISTE_SEGMENTO_VIA)) {
            codMensaje = "M00032";
        } else if(me.getCode() == Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.NO_EXISTE_UBIGEO)){
			codMensaje = "M00043";
        } else if(me.getCode() == Integer.parseInt(ConstantesSEG.MODULO_ZON + ErroresDeNegocio.OPERACION_INCORRECTA)){
			codMensaje = "M00044";
   		} else{
            /*
             * Si no es ninguno de estos codigos lo tiro para arriba
             */
            throw me;
        }


        /*
         *  creamos el Log detalle
         */
        // 23002 - dmorello, 15/06/2006: Se creará el String a loguear en BD
        String reg;
        if (registro instanceof DTOEstructuraVialRegistro) {
            reg = ((DTOEstructuraVialRegistro)registro).dumpToString();
        } else {
            reg = (String)registro;
        }
        
        agregarDetalleLog(idProc,
                          tipoProceso,
                          codMensaje,
                          reg);

        /*
         * Cambio estado del proceso
         */
        reportarResultado(idProc,
                  ESTRUCTURAVIAL_CARGA,
                  IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR,
                  codMensaje);
                  
        UtilidadesLog.info("MONEstructuraVialBean.parseErrores(MareException me, Long idProc, String tipoProceso,DTOEstructuraVialRegistro registro): Salida");                  
    }


    public DTOUBIGEOS localizarDireccion(DTOELocalizacionDirecciones datosdir) throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.localizarDireccion(DTOELocalizacionDirecciones datosdir): Entrada");
    
        String codigoError;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        Log loggeo = bs.log;
        DTOUBIGEOS sal = new DTOUBIGEOS();
        DTOUBIGEO dto = new DTOUBIGEO();
        Vector ubigeos = new Vector();
        Long oidTerritorio;
        
        try {
        // Se obtiene la local del entity con nombre de via, 
        // tipo de via y pais coincidente. Se verifica que la VIA esté activa
        loggeo.info("MONEstructuraVial - localizarDireccion - INICIO");
        
        ViaLocalHome viaLocalHome = this.getViaLocalHome();
        /*Collection vias = viaLocalHome.findByPaisNombreTipoViaActivas(
            datosdir.getNombreVia(), 
            datosdir.getOidTipoVia(), 
            datosdir.getOidPais(), 
            Boolean.TRUE
        );*/
        /*
         * 
         * buscarVias (String nombre, Long oidPais, Long oidTipoVia), in Class DAOZON
            Realiza una consulta sobre la entidad ZON:VIA filtrando por oidPais, nombre (que puede usar un comodin) y oidTipo de Via. 
            Esta busqueda debe filtrar que la via este activa. 
            retorn un arreglo de Longs con los oid de las vias encontradas. 
           */
        DAOZON dao = new DAOZON();
        Long[] vias = dao.buscarVias(datosdir.getNombreVia(), datosdir.getOidPais(), datosdir.getOidTipoVia() );
        
       // Se verifica que existe una sola VIA recuperada
       UtilidadesLog.info("antes de vias --" + vias.length); 
        if( vias.length==0 ){
            throw new MareException(null, null, UtilidadesError.armarCodigoError(
                  ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA));
        }
        
       // ViaLocal via = (ViaLocal) vias.iterator().next();
      //  loggeo.info("Se ha encontrado una VIA. Nombre de la VIA: " + via.getNombre());

        // Se obtienen el oid de la VIA y el numero de portal para 
        // obtener los territorios asociados        
        //Long oidVia = via.getOid();
        String numeroPortal = (datosdir.getNumeroPortal()!=null? datosdir.getNumeroPortal(): "");
        UtilidadesLog.info("valor de numeroPortal --" + numeroPortal); 
        // Se obtienen los territorios asociados.
        UtilidadesLog.info("antes del recordset --"); 
        RecordSet rsTerritorios = getTerritoriosViaAsociada(vias, numeroPortal,datosdir.getOidUGnivel());
        UtilidadesLog.info("vvvvvvvvv --" + rsTerritorios.getRowCount());         
        if(rsTerritorios.getRowCount() == 0) {
          loggeo.info("No se ha obtenido ningun territorio.");
          throw new MareException(null, null, UtilidadesError.armarCodigoError(
                ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_NUMERO_INDICADO));
        }
        else{

            MONUnidadesGeograficas monUG = ZONEjbLocators.getMONUnidadesGeograficasHome().create();
            UtilidadesLog.info("antes del For" + rsTerritorios.getRowCount()); 
            for( int i=0; i<rsTerritorios.getRowCount(); i++ ){
                oidTerritorio = new Long(((BigDecimal) rsTerritorios.getValueAt(i, "OID_TERR")).intValue());    
                UtilidadesLog.info("valor oidTerritorio---" + oidTerritorio); 
                dto = monUG.obtenerUBIGEOdeTerritorio(oidTerritorio);
                UtilidadesLog.info("despues monUG.obtenerUBIGEOdeTerritorio(oidTerritorio)"); 
                dto.setNombreVia(  ( rsTerritorios.getValueAt(i, "NOM_VIA")==null?"":rsTerritorios.getValueAt(i, "NOM_VIA").toString()) );
                dto.setNumInicio((rsTerritorios.getValueAt(i, "NUM_INIC_SEGM")==null?null:new Integer(rsTerritorios.getValueAt(i, "NUM_INIC_SEGM").toString())));
                dto.setNumFin(( rsTerritorios.getValueAt(i, "NUM_FIN_SEGM")==null?null:new Integer(rsTerritorios.getValueAt(i, "NUM_FIN_SEGM").toString())));
                UtilidadesLog.info("valores dto.getOidTerritorio()" + dto.getOidTerritorio()); 
                UtilidadesLog.info("valores dto.getNombreVia()" + dto.getNombreVia());
                UtilidadesLog.info("valores dto.getUBIGEO()" + dto.getUBIGEO());                                
                ubigeos.add(dto);                
            }

        //sal.setDtoUbigeoVec(ubigeos);
        UtilidadesLog.info("antes de setDtoUbigeoVec(validaUbigeos(ubigeos,datosdir.getOidUGnivel()");      
        sal.setDtoUbigeoVec(validaUbigeos(ubigeos,datosdir.getOidUGnivel()));
        UtilidadesLog.info("despues de setDtoUbigeoVec(validaUbigeos(ubigeos,datosdir.getOidUGnivel()");      
        }
        } catch ( RemoteException e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch ( CreateException e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
        UtilidadesLog.info("MONEstructuraVialBean.localizarDireccion(DTOELocalizacionDirecciones datosdir): Salida");
        return sal;
    }


/* Se validan los UBIGEOS obtenidos de los territorios con el 
         * UBIGEO obtenido de la unidad geografica recibida como entrada */
    private Vector validaUbigeos(Vector ug, Long oidUG)throws MareException{
    
        UtilidadesLog.info("MONEstructuraVialBean.validaUbigeos(Vector ug, Long oidUG): Entrada");
        
        String codigoError;
        Vector ugSalida = new Vector();

        try{
            DTOUBIGEO dto = null;                
            String ubigeoTerri;
            String[] ubigeoArray = new String[9];
            String[] ubigeoArrayRef = new String[9];
            
            //cargo en un array el ubigeo obtenido en la ref al entity
            int a=0;
            //ahora comparo con lo obtenido luego de instancia a la entidad valoresestructurageopo
            ValoresEstructuraGeopoliticaLocal valEstrGeopo = this.getValoresEstructuraGeopoliticaLocalHome().findByPrimaryKey(oidUG);
            UtilidadesLog.info("MONEstructuraVialBean.findByPrimaryKey(oidUG)" + oidUG);    
            if(valEstrGeopo.getOrde_1()!=null){
                ubigeoArrayRef[a] = valEstrGeopo.getOrde_1(); 
                a++;
            }
            if(valEstrGeopo.getOrde_2()!=null){
                ubigeoArrayRef[a] = valEstrGeopo.getOrde_2(); 
                a++;
            }
            if(valEstrGeopo.getOrde_3()!=null){
                ubigeoArrayRef[a] = valEstrGeopo.getOrde_3(); 
                a++;
            }
            if(valEstrGeopo.getOrde_4()!=null){
                ubigeoArrayRef[a] = valEstrGeopo.getOrde_4(); 
                a++;
            }
            if(valEstrGeopo.getOrde_5()!=null){
                ubigeoArrayRef[a] = valEstrGeopo.getOrde_5(); 
                a++;
            }
            if(valEstrGeopo.getOrde_6()!=null){
                ubigeoArrayRef[a] = valEstrGeopo.getOrde_6(); 
                a++;
            }
            if(valEstrGeopo.getOrde_7()!=null){
                ubigeoArrayRef[a] = valEstrGeopo.getOrde_7(); 
                a++;
            }
            if(valEstrGeopo.getOrde_8()!=null){
                ubigeoArrayRef[a] = valEstrGeopo.getOrde_8(); 
                a++;
            }
            if(valEstrGeopo.getOrde_9()!=null){
                ubigeoArrayRef[a] = valEstrGeopo.getOrde_9(); 
                a++;
            }

            boolean agregar = true;
            UtilidadesLog.info("ug.size()" + ug.size());    
            for (int r = 0; r < ug.size(); r++){            
                     agregar = true;
                     
                     dto = (DTOUBIGEO)ug.elementAt(r);
                     UtilidadesLog.info("dentro del vector UBIGEO dto.getOidTerritorio()" + dto.getOidTerritorio());    
                     ubigeoTerri = dto.getUBIGEO();
                     int resto = (ubigeoTerri.length() % 6);
                     UtilidadesLog.info("dentro del vector UBIGEO ubigeoTerri.length()" + ubigeoTerri.length());    
                     UtilidadesLog.info("dentro del vector UBIGEO resto" + resto);    
                     //esto hago con el string ubigeo del dto sal
                     if ((ubigeoTerri.length() >= 6) && (ubigeoTerri.length() <= 54) &&
                            (resto == 0)) {
                            a = 0;
                            for (int i = 0; i < ubigeoTerri.length(); i++) {
                                UtilidadesLog.info("ubigeoTerri.substring(i, i + 6)" + ubigeoTerri.substring(i, i + 6));    
                                 ubigeoArray[a] = ubigeoTerri.substring(i, i + 6);
                                 i = i + 5;
                                 a = a + 1;
                            }     
                     }

                    
                    for(int i=0; i<ubigeoArray.length;i++){                    
                        if( (ubigeoArrayRef[i]!=null) && (ubigeoArrayRef[i].equals(ubigeoArray[i])) ){
                            // OK
                        }else{
                            if(ubigeoArrayRef[i]!=null){
                                agregar = false;                               
                            }
                        }
                    }

                    if(agregar) {
                        // El ubigeo se muestra        
                        ugSalida.addElement(ug.elementAt(r));
                    }
            }
            
        }catch(NoResultException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch ( MareException e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }  
        UtilidadesLog.info("MONEstructuraVialBean.validaUbigeos(Vector ug, Long oidUG): Salida");
        return ugSalida; 
    }//fin metodo validaubigeos();        
  
    /**   Metodo que valida el ubigeo, segun DMCO:
     *   Esta comparacion consiste en obtener de la instancia de la entidad obtenida 
     * en el paso anterior los codigos de orden_x que sean diferentes de NULL, y 
     * comparar esto con los obtenidos para cada territorio. 
     *   Esto quiere decir que si se reciben tres niveles de Unidades geograficas 
     * de entrada se debe validar que para el UBIGEO recibido en base al territorio, 
     * estos tres niveles deben coincidir, de igual forma si se reciben más de 
     * tres niveles. 
     * 
     *   Ej. La entidad tiene codigo para los niveles 1, 2 y 3. 
     *     orden_1=000001
     *     orden_2=000023
     *     orden_3=000021
     *   Y para el territorio 1 se teine el UBIGEO
     *     000001 000023 000021 000025 000065
     *     Por lo cual como coincide con los niveles no se descarta.
     *   Y para el territorio 2 se teine el UBIGEO
     *     000001 000024 000021 000025 000065
     *     Por lo cual el nivel 2 no coincide se descarta.
     *     
     *   Los que no coincidan deben descartarse.
     *   Este proceso elimina los territorios que no coinciden con los criterios 
     * recibidos como entrada en cuanto a los niveles de las unidades geográficas.
     *   Si al terminar el filtrado, no quedase ningún territorio que cumpliese 
     * con los criterios de entrada, se debe generar una MAREException con el
     * mensaje de error "No existe el UBIGEO" 
     */
    private boolean isUbigeoValido(String ubigeo, Long[] niveles) {
      UtilidadesLog.info("MONEstructuraVialBean.isUbigeoValido(String ubigeo, Long[] niveles): Entrada");
      
      UtilidadesLog.debug( " Validando ubigeo: " + ubigeo );
      Long nivel;      
      int iNivel = 1;
      while ( ubigeo.length() > 3 ) {       
        try {
          nivel = new Long(ubigeo.substring(0,6));
        } catch ( Exception e ) { return false; }
        UtilidadesLog.debug( "niveles[" + iNivel + "]: " + niveles[iNivel] + " subUbigeo: " + nivel );
        if ( ( niveles[iNivel] != null && !nivel.equals(niveles[iNivel]) ) ||
             ( niveles[iNivel] == null ) ) return false;
        ubigeo = ubigeo.substring(6);
        iNivel++;
      }
      
      UtilidadesLog.info("MONEstructuraVialBean.isUbigeoValido(String ubigeo, Long[] niveles): Salida");
      return true;
    }
    
    /**
     * Descripcion del metodo:
     * Utilizando el DBService se buscan todos los territorios asociados a la via. 
     * Para esto se hace una busqueda en la entidad ViaSegmento, 
     * utilizando para filtrar el oidVia obtenido en el paso anterior, 
     * y el número de vía si este es recibido
     */
    private RecordSet getTerritoriosViaAsociada(Long[] oidVia, String numeroPortal, Long oidUG) 
        throws MareException {
        UtilidadesLog.info("MONEstructuraVialBean.getTerritoriosViaAsociada(Long[] oidVia, String numeroPortal, Long oidUG) : Entrada");
        
        UtilidadesLog.debug( "oidVia: " + oidVia + ", " + numeroPortal + ")" );
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        String codigoError;

        try {
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            String viasStr = "";
            for( int i=0; i<oidVia.length; i++){
                if(viasStr.equals("")){
                    viasStr = oidVia[i].toString();
                }else{
                    viasStr = viasStr +", "+ oidVia[i]; 
                }
                UtilidadesLog.debug("viasStr  " + viasStr); 
            }
            query.append(" select zt.oid_terr, zv.nom_via, zvs.NUM_INIC_SEGM, zvs.NUM_FIN_SEGM ");
            query.append(" from zon_via zv, zon_via_segme zvs, zon_terri zt ");
            query.append(" where zv.oid_via = zvs.via_oid_via ");
            query.append("  and zt.oid_terr = zvs.TERR_OID_TERR ");
            query.append("  and zvs.IND_ACTI = 1 ");
            query.append("  and zv.oid_via in ( " + viasStr + ")  ");           
            query.append("  and  zt.VEPO_OID_VALO_ESTR_GEOP is not null ");
            /*
             * Si se recibe el número de via, este se debe usar como críterio, 
             * de forma que este comprendido entre el número de inicio y fin del segmento.
             */
            if(!numeroPortal.equals("")) {
                query.append(" and " + numeroPortal 
                             + " between zvs.NUM_INIC_SEGM and zvs.NUM_FIN_SEGM ");
            }

            query.append("   order by zv.nom_via, zvs.TERR_OID_TERR  ");
            
            
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info("MONEstructuraVialBean.getTerritoriosViaAsociada(Long[] oidVia, String numeroPortal, Long oidUG) : Salida");
            return rs;
            
        } catch(Exception e){
            UtilidadesLog.debug("Error en consulta Territorios asociados");
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private void rollBackContexto() {
        UtilidadesLog.info("MONEstructuraVialBean.getTerritoriosViaAsociada(Long[] oidVia, String numeroPortal, Long oidUG) : Entrada");
        ctx.setRollbackOnly();
        UtilidadesLog.info("MONEstructuraVialBean.getTerritoriosViaAsociada(Long[] oidVia, String numeroPortal, Long oidUG) : Salida");
    } 

    private ViaSegmentoLocal buscarViaSegmento(Long oidVia, DTOEstructuraVialRegistro registro) throws MareException {
        UtilidadesLog.info("MONEstructuraVialBean.buscarViaSegmento(Long oidVia, DTOEstructuraVialRegistro registro) : Entrada");
        
        String codigoError;
        Collection viasSegmento1;
        Collection viasSegmento = new Vector();
        ViaSegmentoLocalHome viaSegmentoLH;
        ViaSegmentoLocal   viaSegmentoLocal;
        
        viaSegmentoLH = this.getViaSegmentoLocalHome();

        try {
            Integer segmento = new Integer(registro.getNumViaSegmento());
            UtilidadesLog.debug("************ Llamando a findByViaSegmento");
            UtilidadesLog.debug("************ OidVia : " + oidVia.toString());
            UtilidadesLog.debug("************ segmento : " + segmento);
            viasSegmento1 = viaSegmentoLH.findByViaSegmento(oidVia, segmento); 
            // Busca los activos                                              
            Iterator iteViasSegmento1 = viasSegmento1.iterator();
            
            while(iteViasSegmento1.hasNext()){
                viaSegmentoLocal = (ViaSegmentoLocal)iteViasSegmento1.next();
                
                if(viaSegmentoLocal.getActivo().booleanValue()){
                    viasSegmento.add(viaSegmentoLocal);
                }
            }
            
            if (viasSegmento!= null && viasSegmento.size()==1) {
                UtilidadesLog.debug("************ Entro al if - igual a 1");
                UtilidadesLog.info("MONEstructuraVialBean.buscarViaSegmento(Long oidVia, DTOEstructuraVialRegistro registro): Salida");                                                                         
                return (ViaSegmentoLocal)viasSegmento.iterator().next();
            }
            else if (viasSegmento.size() > 1) {
                UtilidadesLog.debug("************ Lanza una MareException - MAS DE UNA VIA SEGMENTO POR TERRITORIO");
                UtilidadesLog.info("MONEstructuraVialBean.buscarViaSegmento(Long oidVia, DTOEstructuraVialRegistro registro): Salida");                                                                         
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.EXISTE_MAS_DE_UNA_VIA_SEGMENTO_POR_TERRITORIO_VIA));
            }
            else {
                UtilidadesLog.debug("************ Lanza una MareException - NO EXISTE VIA SEGMENTO");
                UtilidadesLog.info("MONEstructuraVialBean.buscarViaSegmento(Long oidVia, DTOEstructuraVialRegistro registro): Salida");                                                                         
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
            }
        }
        catch (NoResultException fe) {
            throw new MareException(fe,  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA_SEGMENTO));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 
    }

    private void inactivarViasSegmentoUG(Collection oidTerritorios,
                                         Long oidVia) 
    throws MareException {
        UtilidadesLog.info("MONEstructuraVialBean.inactivarViasSegmentoUG(Collection oidTerritorios, Long oidVia) : Entrada");
        
        String codigoError;
        /*
         * Voy buscando por cada tupla de territorio y via los segmentos y los
         * voy inactivando
         */
        if (oidTerritorios.size()!=0 && oidTerritorios!= null) {
            for (Iterator iteTerri = oidTerritorios.iterator();
                 iteTerri.hasNext();) {
                inactivarViasSegmento((Long)iteTerri.next(),oidVia);                
            }
            
            UtilidadesLog.info("MONEstructuraVialBean.inactivarViasSegmentoUG(Collection oidTerritorios, Long oidVia): Salida");
        } else{           
           UtilidadesLog.info("MONEstructuraVialBean.inactivarViasSegmentoUG(Collection oidTerritorios, Long oidVia): Salida");
           throw new MareException(null, null,
				  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_SEGMENTO_VIA));                         
       
        }
    }

    private void inactivarViasSegmento(Long oidTerritorio,
                                       Long oidVia) 
    throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.inactivarViasSegmento(Long oidTerritorio,Long oidVia) : Entrada");
        
        String codigoError;
        Collection viasSegmento;
        /*
         * busco las vias segmento por via y territorio y las inactivo
         */
        if (oidTerritorio!=null && oidVia!=null) {
            try {
                viasSegmento = this.getViaSegmentoLocalHome().findByTerritorioVia(oidTerritorio,oidVia);
                for (Iterator viasSegmentoIte = viasSegmento.iterator(); viasSegmentoIte.hasNext();) {
                    ViaSegmentoLocal viaAux = (ViaSegmentoLocal)viasSegmentoIte.next();
                    viaAux.setActivo(Boolean.FALSE);
                    this.getViaSegmentoLocalHome().merge(viaAux);
                    
                }
                
                UtilidadesLog.info("MONEstructuraVialBean.inactivarViasSegmento(Long oidTerritorio,Long oidVia): Salida");
            } catch (NoResultException fe) {
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(fe,UtilidadesError.armarCodigoError(codigoError));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
        }
    }

    private void inactivarVia(Long oidVia)
    throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.inactivarVia(Long oidVia): Entrada");
        
        String codigoError;
        Vector retorno = new Vector();
        RecordSet resultado = new RecordSet();
        String valorInactiva = "INACTIVA";
        String valorActiva = "ACTIVA";
        Collection viasSegmento1;
        Collection viasSegmento = new Vector();
        ViaSegmentoLocal     viaSegmentoLocal;
		ViaLocal viaLocal = null;

        try {
            viasSegmento1 = this.getViaSegmentoLocalHome().findByViaActivos(oidVia);

            // Busca los activos                                              
            Iterator iteViasSegmento1 = viasSegmento1.iterator();
            
            while(iteViasSegmento1.hasNext()){
                viaSegmentoLocal = (ViaSegmentoLocal)iteViasSegmento1.next();
                
                if(viaSegmentoLocal.getActivo().booleanValue()){
                    viasSegmento.add(viaSegmentoLocal);
                }
            }

            // Si no hay activos, desactiva la via
            if (viasSegmento.size()==0) {
                try {
                    viaLocal = this.getViaLocalHome().findByPrimaryKey(oidVia);
                    viaLocal.setActivo(Boolean.FALSE);
                    viaLocal.setFechaReestructuracion(new Timestamp(System.currentTimeMillis()));
                    this.getViaLocalHome().merge(viaLocal);
          
                    UtilidadesLog.info("MONEstructuraVialBean.inactivarVia(Long oidVia): Salida");
          
                } catch (NoResultException fe) {
					throw new MareException(fe,
						  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_VIA));
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }    
            }
        } catch (NoResultException fe) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(fe,UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

    }

    private Collection buscarTerritoriosUG(Long oidPais,
                                           String UBIGEO)
    throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.buscarTerritoriosUG(Long oidPais,  String UBIGEO): Entrada");
        
        String codigoError;
        Vector retorno = new Vector();
        RecordSet territorios = new RecordSet();
        Long oidUG;

        DAOZON daozon = new DAOZON();

        oidUG = daozon.obtenerUniGeoPorUBIGEO(UBIGEO, oidPais);
        
        String query = " select OID_TERR "+
                       " from ZON_TERRI "+
                       " where VEPO_OID_VALO_ESTR_GEOP = " + oidUG;
                       
        try {
            territorios = UtilidadesEJB.getBelcorpService().dbService.executeStaticQuery(query);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (territorios!=null && !territorios.esVacio()) {
            for (int i = 0; i < territorios.getRowCount() ; i ++) {
                retorno.add( new Long(((BigDecimal)territorios.getValueAt(i,0)).intValue()) );
            }
        } 
        
        UtilidadesLog.info("MONEstructuraVialBean.buscarTerritoriosUG(Long oidPais,  String UBIGEO): Salida");
        return retorno;
    }

    public DTOSalida obtenerViasPais(DTOOID dtooid) 
    throws MareException {
    
        UtilidadesLog.info("MONEstructuraVialBean.obtenerViasPais(DTOOID dtooid) : Entrada");
        
        String codigoError;
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        DTOSalida dtos = new DTOSalida();

        /*
         * Validadcion
         */
        if (dtooid==null ||
            dtooid.getOid()==null ||
            dtooid.getOidPais()==null) {
                codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
                throw new MareException(new Exception(),
                                        UtilidadesError.armarCodigoError(codigoError));  
        }
        
        try {
            query.append("select ");
            query.append("OID_VIA, ");
            query.append("NOM_VIA ");
            query.append("from ");
            query.append("ZON_VIA ");
            query.append("where ");
            query.append("IND_ACTI_VIA = 1 "); 
            query.append("and PAIS_OID_PAIS = "+dtooid.getOidPais());
            query.append("and TIVI_OID_TIPO_VIA = "+dtooid.getOid());
            query.append(" ORDER BY nom_via ASC ");

            rs = UtilidadesEJB.getBelcorpService().dbService.executeStaticQuery(query.toString());
            
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs==null) {
            UtilidadesLog.info("MONEstructuraVialBean.obtenerViasPais(DTOOID dtooid) : Salida");
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(codigoError));        
        } else if (rs.esVacio()) {
            UtilidadesLog.info("MONEstructuraVialBean.obtenerViasPais(DTOOID dtooid) : Salida");
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(codigoError));            
        } else {
            dtos.setResultado(rs);
        }
        
        UtilidadesLog.info("MONEstructuraVialBean.obtenerViasPais(DTOOID dtooid) : Salida");
        return dtos;
    }

    public DTOSalida consultaEstructuraVial(DTOELocalizacionDirecciones dtoLocalizaDire) throws  RemoteException, MareException {
    
       UtilidadesLog.info("MONEstructuraVialBean.consultaEstructuraVial(DTOELocalizacionDirecciones dtoLocalizaDire): Entrada");
       
       String codigoError;
       DTOSalida dtoSal = new DTOSalida();
       RecordSet rs = new RecordSet();
       DTOUBIGEO dtoUbigeo;
       String descripcion ="";
       String nombreVia ="";
       String inicioSeg ="";
       String finSeg = "";
       TipoViaLocal tipoViaH;
       DTOUBIGEOS dtoUbigeos = localizarDireccion(dtoLocalizaDire);
        
       if(dtoUbigeos==null){
            throw new MareException(null, null, UtilidadesError.armarCodigoError(
                      ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_SE_ENCONTRO_NINGUNA_VIA_PARA_LOS_CRITERIOS_DEFINIDOS));	
        }                
        rs.addColumn("oid");
        rs.addColumn("DescripcionUnidadGeo");
        rs.addColumn("TipoVia");
        rs.addColumn("NombreVia");
        rs.addColumn("IncioSeg");
        rs.addColumn("FinSEg");
        try{
            tipoViaH = this.getTipoViaLocalHome().findByPrimaryKey(dtoLocalizaDire.getOidTipoVia());
        }catch(NoResultException fe) {
           codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(fe,UtilidadesError.armarCodigoError(codigoError));             
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.debug("*******************antes de armar paginado manual*****************");
        for(int i= dtoLocalizaDire.getIndicadorSituacion().intValue(); i <dtoUbigeos.getDtoUbigeoVec().size(); i++){ 
           if(rs.getRowCount() < dtoLocalizaDire.getTamanioPagina().intValue()){ 			
                    //Añadimos una fila 
                    /*
                    Se utiliza el metodo findbyPrimaryKey de la entidad SEG:TiposVia para obtener la 
                    descripción del oidTipoVia recibido como entrada. 
                    */                            
                    dtoUbigeo = (DTOUBIGEO)(dtoUbigeos.getDtoUbigeoVec().elementAt(i)==null?"":dtoUbigeos.getDtoUbigeoVec().elementAt(i));
                    descripcion = dtoUbigeo.getDescCompleta();
                    nombreVia = dtoUbigeo.getNombreVia();                    
                    inicioSeg = dtoUbigeo.getNumInicio()==null?"":dtoUbigeo.getNumInicio().toString();
                    finSeg = dtoUbigeo.getNumFin()==null?"":dtoUbigeo.getNumFin().toString();
                    
                    rs.addRow(new Object []{ new Integer(i+1), descripcion,(tipoViaH.getDescAbreTipoVia()==null?"":tipoViaH.getDescAbreTipoVia()), 
                              nombreVia, inicioSeg, finSeg });
            }
        }

      if(rs.esVacio()){
            UtilidadesLog.info("MONEstructuraVialBean.consultaEstructuraVial(DTOELocalizacionDirecciones dtoLocalizaDire): Salida");
             codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
             throw new MareException(null,null,UtilidadesError.armarCodigoError(codigoError));
       }
      dtoSal.setResultado(rs);
      UtilidadesLog.info("MONEstructuraVialBean.consultaEstructuraVial(DTOELocalizacionDirecciones dtoLocalizaDire): Salida");
      return dtoSal;        
    }
    
    private TipoViaLocalHome getTipoViaLocalHome() {
        return new TipoViaLocalHome();
    }
    
    private ValoresEstructuraGeopoliticaLocalHome getValoresEstructuraGeopoliticaLocalHome() {
        return new ValoresEstructuraGeopoliticaLocalHome();
    }
    
    private ViaSegmentoLocalHome getViaSegmentoLocalHome() {
        return new ViaSegmentoLocalHome();
    }
    
    private ViaLocalHome getViaLocalHome() {
        return new ViaLocalHome();
    }
    
    private TerritorioLocalHome getTerritorioLocalHome() {
        return new TerritorioLocalHome();
    }    
    
        
    
        
    
}
