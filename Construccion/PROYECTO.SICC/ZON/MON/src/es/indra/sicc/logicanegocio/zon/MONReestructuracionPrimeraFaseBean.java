/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.dtos.zon.DTORezonificacionCabecera;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
import es.indra.sicc.entidades.fac.TiposCierreLocal;
import es.indra.sicc.entidades.fac.TiposCierreLocalHome;
import es.indra.sicc.entidades.zon.HistoricoZonasLocalHome;

import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.fac.DAOFACCierreFacturacion;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroDisp;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroResultado;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Iterator;

import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.dtos.zon.DTOFicheroRezonificacion;
import es.indra.sicc.dtos.zon.DTOPeriodosRezonificacion;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;


import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocal;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocalHome;
import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.HistoricoZonasLocal;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.entidades.zon.SeccionLocal;
import es.indra.sicc.entidades.zon.SeccionLocalHome;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocal;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocalHome;


import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocal;
import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;

//import es.indra.sicc.entidades.zon.SeccionLocal;
//import es.indra.sicc.entidades.zon.SeccionLocalHome;

import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.util.CodigosError;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.FinderException;
import javax.ejb.CreateException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

/*
 * 15-06-2005 - rgiorgi: inc. 18887
 * */
public class MONReestructuracionPrimeraFaseBean implements SessionBean  {

    private int DIM_UA = 15;
    private int DIM_SUBGERENCIA = 2;
    private int DIM_REGION = 2;
    private int DIM_ZONA = 4;
    private int DIM_SECCION = 1;
    private int DIM_TERRITORIO = 6;
    private int DIM_UA_REGION = DIM_SUBGERENCIA + DIM_REGION;
    private int DIM_UA_ZONA = DIM_UA_REGION + DIM_ZONA; 
    private int DIM_UA_SECCION = DIM_UA_ZONA + DIM_SECCION; 
    private int SUBGERENCIA = 1;
    private int REGION = 2;
    private int ZONA = 3;
    private int SECCION = 4;
    private int TERRITORIO = 5;
    private Long pais;   
    private Long marca;   
    private Long canal;  
    private Long periodo;
    //Definidas en ConstantesZON incidencia

   // private String TIPO_OPERACION_PARTICION = "P"; 
   // private String TIPO_OPERACION_FUSION = "F";
   // private String TIPO_OPERACION_TRASVASE = "T"; 
    private ArrayList unidadesParticion;   
    private HashMap UnidadesCreadas;   
    private Long periodoRezonificacion;   
    private Long periodoFin;  
    //private Date fechaFin;
    private RezonificacionFileWrapper fileWrapper;  
    
    //Incidencia 21808
    private ArrayList lineasConError = new ArrayList();

    //(13/06/2007)agregado por incidencia Sicc-20070276 (Sapaza)
    private Long indActivoTrasvaseNueva;
    private Long indBorradoTrasvaseNueva;
    private Long indActivoTrasvaseAnt;
    private Long indBorradoTrasvaseAnt;
    private Long region;    
    private Long regionOrigen;
    private Long regionDestino;
    
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

    public DTOFicheroResultado obtenerPeriodoRezonificacion(DTOFicheroDisp dto) throws MareException {
        //Lee el fichero recibido y obtiene los periodos de rezonificación posibles para dicho fichero
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoRezonificacion(DTOFicheroDisp dto): Entrada");

        try {
            DTOFicheroRezonificacion dtoFicheroRezonificacion = this.leerFichero(dto);
            // Comprueba los datos de la cabecera 
            this.obtenerDatosCabecera(dtoFicheroRezonificacion.getCabecera());
            
            DTOPeriodosRezonificacion dtoPeriodosRezonificacion = this.obtenerPeriodosParaRezonificacion(dtoFicheroRezonificacion.getCabecera(), dtoFicheroRezonificacion.getRegistros());
    
            //Crea un DTOFicheroResultado con:  - Datos = DTOPeriodosRezonificacion
            DTOFicheroResultado dtoFicheroResultado = new DTOFicheroResultado();
            dtoFicheroResultado.setOidPais(dto.getOidPais());
            dtoFicheroResultado.setDatos(dtoPeriodosRezonificacion);
    
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoRezonificacion(DTOFicheroDisp dto): Salida");
    
            return dtoFicheroResultado;
        
        } catch (Exception ex) {
            ex.printStackTrace(); 
            throw new MareException(ex);
        }   
    }

    private DTOPeriodosRezonificacion obtenerPeriodosParaRezonificacion(DTORezonificacionCabecera cabecera, ArrayList registros) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodosParaRezonificacion(DTORezonificacionCabecera cabecera, ArrayList registros): Entrada");
        // Obtiene los periodos para los que se puede realizar la rezonificación 
        DTOPeriodosRezonificacion dtoPeriodosRezonificacion = new DTOPeriodosRezonificacion();
        dtoPeriodosRezonificacion.setOidPais(cabecera.getOidPais());

        // Obtiene el último periodo en el que se generó una solicitud para todas las U.A del fichero 
        Long oidUltimoPeriodo = this.obtenerUltimoPeriodo(registros);

        // Se obtiene el periodo propuesto 
        DTOPeriodo periodoPropuesto = this.obtenerPeriodoPropuesto(oidUltimoPeriodo); 
        if (periodoPropuesto != null && periodoPropuesto.getOid() != null)
            UtilidadesLog.debug("*** Periodo Propuesto ***: " + periodoPropuesto.toString());
        dtoPeriodosRezonificacion.setPeriodoPropuesto(periodoPropuesto);
        
        // Se obtiene el periodo sin solapar. (Siguiente periodo sin solapar al periodo propuesto) 
        DTOPeriodo periodoSinSolapar = this.obtenerPeriodoSinSolapar(periodoPropuesto); 
        if (periodoSinSolapar != null && periodoSinSolapar.getOid() != null) {
             UtilidadesLog.debug("*** Periodo Sin Solapar ***: " + periodoSinSolapar.toString());
        }
        periodoSinSolapar.setPais(periodoSinSolapar.getOidPais());
        dtoPeriodosRezonificacion.setPeriodoSinSolapar(periodoSinSolapar);

        // Se obtiene la lista de periodos posteriores al periodo sin solapar 
        dtoPeriodosRezonificacion.setListaPosteriores(this.obtenerPeriodosPosteriores(periodoSinSolapar));

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodosParaRezonificacion(DTORezonificacionCabecera cabecera, ArrayList registros): Salida");
        return dtoPeriodosRezonificacion;
    }

    private Long obtenerUltimoPeriodo(ArrayList registros) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUltimoPeriodo(ArrayList registros): Entrada");

        Long oidUltimoPeriodo = null;

        // Procesa todos los registros recibidos 
        if (registros != null) {
            String unidadActual = "";
            Date fechaUltimoPeriodo = null;
            for (int i = 0; i < registros.size(); i++) {
                DTORezonificacionRegistro registro = (DTORezonificacionRegistro)registros.get(i); 

                // Valida si la información de la U.A que varía no es a nivel de territorio 
                boolean correcto = validarRTZ(registro);
                if (!correcto) {
                    // Aborta el proceso. Se debe tratar el fichero con el CU Procesar fichero RTZ
                    //La operación a realizar es Reterritorialización. Debe ejecutar Procesar fichero RTZ. (código de error: 280290001)
                    this.fileWrapper.cerrarArchivo(); 
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.FICHERO_NO_DE_REZONIFICACION));
                } 

                // Obtiene el último periodo en el que se generó una solicitud para la U.A tratada 
                if (!unidadActual.equals(registro.getDatoOrigen1())) { 
                    unidadActual = registro.getDatoOrigen1(); 
                    DTOPeriodo dtoPeriodo = this.obtenerUltimoPeriodoUA(registro);
                    if (dtoPeriodo != null && (fechaUltimoPeriodo == null || (dtoPeriodo.getFechaFin() != null && dtoPeriodo.getFechaFin().after(fechaUltimoPeriodo)))) {
                        oidUltimoPeriodo = dtoPeriodo.getOid(); //incidencia 18453
                        fechaUltimoPeriodo = dtoPeriodo.getFechaFin();
                    }
                }
            }
        }

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUltimoPeriodo(ArrayList registros): Salida");
        return oidUltimoPeriodo;
    }


    private DTOPeriodo obtenerUltimoPeriodoUA (DTORezonificacionRegistro registro) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUltimoPeriodoUA (DTORezonificacionRegistro registro): Entrada");
        DTOPeriodo ultimoPeriodo = null;
        // Obtiene el último periodo en el que se generó una solicitud para la U.A tratada
        DatoRegistro UA1 = new DatoRegistro(registro.getDatoOrigen1(), registro.getNse1(), registro.getNse2());

        DTOPeriodo dtoPeriodo = (new DAOReestructuracion()).obtenerUltimoPeriodoUA(this.pais, this.marca, this.canal, UA1.getSubgerencia(), UA1.getRegion(), UA1.getZona(), UA1.getSeccion(), UA1.getTerritorio()); //incidencia BELC300018450

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUltimoPeriodoUA (DTORezonificacionRegistro registro): Salida");
        return dtoPeriodo;
    }

    private boolean validarRTZ (DTORezonificacionRegistro registro) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.validarRTZ (DTORezonificacionRegistro registro: Entrada");
        // Valida si la información que varía de la U.A recibida es a nivel de territorio
        DatoRegistro datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1());
        DatoRegistro datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2());
        
         /* INC BELC300024021 gPineda 06/06/2006
          * Para tomar solamente el codigo de la UA hasta la ultima UA que varia
          */
        if ( ! registro.getTipoOp().equalsIgnoreCase(ConstantesZON.TIPO_OPERACION_TRASVASE) ) {
            /*  if ( this.actualizarCodigosUAModificados( registro ) == false) {
             return false;
            } */ // - EIRAOLA
            this.actualizarCodigosUAModificados( registro ); // + EIRAOLA
        }
        
        if (datoRegistro1.esTerritorio() && datoRegistro2.esTerritorio()) { 
            // INC 21497 - dmorello, 02/01/2006
            // A la presente validación de RTZ se le agrega la verificación
            // de que haya variación de territorio entre datoRegistro1 y datoRegistro2.
            // Sólo en caso de que varíe, se tratará de RTZ.
            boolean terrNoVaria = datoRegistro1.getTerritorio().equals(datoRegistro2.getTerritorio());
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.validarRTZ (DTORezonificacionRegistro registro: Salida");
            return terrNoVaria;
            // Fin modificaciones INC 21497
        } 

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.validarRTZ (DTORezonificacionRegistro registro: Salida");
        return true;
    }


    private DTOPeriodo obtenerSiguientePeriodo(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerSiguientePeriodo(Long oidPeriodo): Entrada");

        // Se obtiene el siguiente periodo al recibido 
        DTOPeriodo periodoSiguiente = new DTOPeriodo();
        Long oidSiguientePeriodo = (new DAOCRA()).obtienePeriodoSiguiente(oidPeriodo);
        PeriodoLocal periodo = null;
        if (oidSiguientePeriodo != null)
            try {
                periodo = this.getPeriodoLocalHome().findByPrimaryKey(oidSiguientePeriodo);
                periodoSiguiente.setOid(periodo.getOid());
                periodoSiguiente.setOidPais(periodo.getOidPais());
                periodoSiguiente.setFechaInicio(periodo.getFechainicio());
                periodoSiguiente.setFechaFin(periodo.getFechaFin());
                periodoSiguiente.setPeriodoCruce(periodo.getPeriodoCruce());
                periodoSiguiente.setMarca(periodo.getOidMarca());
                periodoSiguiente.setCanal(periodo.getOidCanal());
                try {
                    PeriodoCorporativoLocal periodoCorpLocal = (this.getPeriodoCorporativoLocalHome()).findByPrimaryKey(periodo.getOidPeriodoCorporativo());
                    periodoSiguiente.setCodigoPeriodo(periodoCorpLocal.getCodigoPeriodo());
                } catch (NoResultException e) {
                    UtilidadesLog.debug("*** No se encontró el período siguiente ***");
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            } catch (NoResultException e) {
                UtilidadesLog.debug("*** No se encontró el período siguiente ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

        UtilidadesLog.debug("*** Método obtenerSiguientePeriodo: Salida ***: " + periodoSiguiente.toString());
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerSiguientePeriodo(Long oidPeriodo): Salida");
        return periodoSiguiente;
    }

    private DTOPeriodo obtenerPeriodoSinSolapar(DTOPeriodo periodo) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoSinSolapar(DTOPeriodo periodo): Entrada");
        // Mientras el periodo propuesto esté solapado, se obtiene el siguiente 
        while (periodo != null && periodo.getPeriodoCruce() != null && periodo.getPeriodoCruce().booleanValue())
            periodo = this.obtenerSiguientePeriodo(periodo.getOid());

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoSinSolapar(DTOPeriodo periodo): Salida");
        return periodo;
    }

    private Collection obtenerPeriodosPosteriores(DTOPeriodo periodo) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodosPosteriores(DTOPeriodo periodo): Entrada");
        // Obtiene los periodos posteriores al periodo recibido
        Collection periodosPosteriores = null;
        try {
            periodosPosteriores = this.getMONPeriodos().obtienePeriodosPosteriores(periodo);   //incidencia BELC300018454
        } catch (RemoteException e)  {
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		} 

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodosPosteriores(DTOPeriodo periodo): Salida");
        return periodosPosteriores;
    }

    private DTOPeriodo obtenerPeriodoPropuesto(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoPropuesto(Long oidPeriodo): Entrada");
        
        // Se obtiene el siguiente periodo al recibido y se compara con el periodo de la cabecera
        DTOPeriodo ultimoPeriodo = null;
        if (oidPeriodo != null)
            ultimoPeriodo = this.obtenerSiguientePeriodo(oidPeriodo);

        if (ultimoPeriodo != null)
            UtilidadesLog.debug("*** periodoSiguiente: ***: " + ultimoPeriodo.toString());
        // Se comparan ambos periodos   //incidencia BELC300018452
        // Se obtiene el siguiente periodo al recibido y se compara con el periodo de la cabecera

        //08-06-2007, modificado por Sapaza, incidencia Sicc-20070276, no se compara con periodo del Fichero
        // Se obtiene el periodo de cabecera
        /*DTOPeriodo periodoCabecera = this.obtenerPeriodoCabecera();

        if (ultimoPeriodo == null)
            ultimoPeriodo = periodoCabecera;  
        else if (periodoCabecera != null && ultimoPeriodo.getFechaFin() != null && periodoCabecera.getFechaFin() != null && periodoCabecera.getFechaFin().after(ultimoPeriodo.getFechaFin())) 
            ultimoPeriodo = periodoCabecera;  */

        UtilidadesLog.debug("*** Método obtenerPeriodoPropuesto: Salida ultimoperiodo***: " + ultimoPeriodo.toString());
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoPropuesto(Long oidPeriodo): Salida");
        return ultimoPeriodo;
    }

    //incidencia BELC300018452
    private DTOPeriodo obtenerPeriodoCabecera() throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoCabecera(): Entrada");

        DTOPeriodo periodoCabecera = new DTOPeriodo();
        PeriodoLocal periodoLocal = null;
        PeriodoCorporativoLocal periodoCorpLocal = null;
        try {
            periodoLocal = (this.getPeriodoLocalHome()).findByPrimaryKey(this.periodo);
        } catch (NoResultException e) {
            UtilidadesLog.debug("*** Método obtenerPeriodoCabecera: No hay periodo ***");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        try {
            periodoCorpLocal = (this.getPeriodoCorporativoLocalHome()).findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());
        } catch (NoResultException e) {
            UtilidadesLog.debug("*** Método obtenerPeriodoCabecera: No hay periodo corporativo***");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        periodoCabecera.setOid(periodoLocal.getOid());
        periodoCabecera.setOidPais(periodoLocal.getOidPais());
        periodoCabecera.setFechaInicio(periodoLocal.getFechainicio());
        periodoCabecera.setFechaFin(periodoLocal.getFechaFin());
        periodoCabecera.setCodigoPeriodo(periodoCorpLocal.getCodigoPeriodo());
        periodoCabecera.setPeriodoCruce(periodoLocal.getPeriodoCruce());
        periodoCabecera.setCanal(periodoLocal.getOidCanal());
        periodoCabecera.setMarca(periodoLocal.getOidMarca());
        
        UtilidadesLog.debug("*** Método obtenerPeriodoCabecera: Salida ***: " + periodoCabecera.toString());
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoCabecera(): Salida");
        return periodoCabecera;
    }


    private void obtenerPeriodoFin () throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoFin (): Entrada");
        // Obtiene el periodo anterior al periodo de rezonificación 

        this.periodoFin = (new DAOCRA()).obtienePeriodoAnterior(this.periodoRezonificacion); 
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerPeriodoFin (): Salida");
    }

    private UnidadAdministrativa obtenerUnidadAdministrativa (DatoRegistro datoRegistro) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUnidadAdministrativa (DatoRegistro datoRegistro): Entrada");
        
        Long oidSGV;
        Long oidRegion;
        Long oidZona;
        Long oidSeccion;
        Long oidTerritorio;
        
        
        // INC BELC300021497 - inicio
        if (datoRegistro.esTerritorio()) {
            UtilidadesLog.debug("***** esTerritorio = true");
            try {
                SubGerenciaVentaLocal subGerenciaVentaLocal = obtenerSubgerencia(datoRegistro.getSubgerencia());
                oidSGV = subGerenciaVentaLocal.getOidSubgVenta();
                
                RegionLocal regionLocal = obtenerRegion(datoRegistro.getRegion(), oidSGV);
                oidRegion = regionLocal.getOid();
                this.region = oidRegion; //07-06-2007 modificado por incidencia Sicc-20070276 (Sapaza)
                
                ZonaLocal zonaLocal = obtenerZona(datoRegistro.getZona(), oidRegion);
                oidZona = zonaLocal.getOid();
                
                SeccionLocal seccionLocal = obtenerSeccion(datoRegistro.getSeccion(), oidZona);
                
                TerritorioLocal territorioLocal = obtenerTerritorio(datoRegistro.getTerritorio());
                                
                Collection colecTerrAdm = this.getTerritorioAdministrativoLocalHome().findBySeccionTerritorio( seccionLocal.getOid(), territorioLocal.getOid() );
                UtilidadesLog.info(" getTerritorioAdministrativoLocalHome()).findByCodigo Registros: "+colecTerrAdm.size()+" [" + colecTerrAdm + " ]");
                TerritorioAdministrativoLocal territorioAdm = null;
                if (!colecTerrAdm.isEmpty() && colecTerrAdm.size() == 1) {
                    Iterator iterator = colecTerrAdm.iterator();
                    territorioAdm = (TerritorioAdministrativoLocal) iterator.next();
                } else {  
                    UtilidadesLog.debug("*** No se encontró el Territorio Administrativo***");
                    throw new MareException("No se encontró el Territorio Administrativo", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
                UnidadAdministrativa territorio = this.crearTerritorio( territorioAdm.getOid(), territorioAdm.getOidTerritorio(), datoRegistro.obtenerCodigoUnidad(), datoRegistro.obtenerCodigoUAPadre() );
                territorio.setOidPadre( territorioAdm.getOid() );
                UtilidadesLog.debug("*** Método obtenerUnidadAdministrativa: Salida esTerritorio***");
                UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUnidadAdministrativa (DatoRegistro datoRegistro): Salida");              
                return territorio;
                
            } catch (NoResultException e) {
                UtilidadesLog.debug("*** No se encontró el territorio ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } 
        // INC BELC300021497 - fin
        
        if (datoRegistro.esSeccion()) {
            UtilidadesLog.debug("***** esSeccion = true");
            
            SubGerenciaVentaLocal subGerenciaVentaLocal = obtenerSubgerencia(datoRegistro.getSubgerencia());
            oidSGV = subGerenciaVentaLocal.getOidSubgVenta();
            
            RegionLocal regionLocal = obtenerRegion(datoRegistro.getRegion(), oidSGV);
            oidRegion = regionLocal.getOid();
            this.region = oidRegion; //07-06-2007 modificado por incidencia Sicc-20070276 (Sapaza)
                
            ZonaLocal zonaLocal = obtenerZona(datoRegistro.getZona(), oidRegion);
            oidZona = zonaLocal.getOid();
            
            SeccionLocal seccionLocal = obtenerSeccion(datoRegistro.getSeccion(), oidZona);
                
                
            UnidadAdministrativa seccion = this.crearSeccion(seccionLocal.getOid(), datoRegistro.obtenerCodigoUnidad(), datoRegistro.obtenerCodigoUAPadre(),"");
            seccion.setOidPadre( seccionLocal.getOidZona());
            // 21886 - dmorello, 05/04/2006: Se setea la descripción de la sección
            seccion.setDescripcion(seccionLocal.getDesripcion());
            UtilidadesLog.debug("*** Método obtenerUnidadAdministrativa: Salida esSeccion***");
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUnidadAdministrativa (DatoRegistro datoRegistro): Salida");
            return seccion; 
        }

        if (datoRegistro.esZona()) {
            UtilidadesLog.debug("***** esZona = true");
            SubGerenciaVentaLocal subGerenciaVentaLocal = obtenerSubgerencia(datoRegistro.getSubgerencia());
            oidSGV = subGerenciaVentaLocal.getOidSubgVenta();
            
            RegionLocal regionLocal = obtenerRegion(datoRegistro.getRegion(), oidSGV);
            oidRegion = regionLocal.getOid();
            this.region = oidRegion; //07-06-2007 modificado por incidencia Sicc-20070276 (Sapaza)            
            
            ZonaLocal zonaLocal = obtenerZona(datoRegistro.getZona(), oidRegion);
            
            UnidadAdministrativa zona = this.crearZona(zonaLocal.getOid(), datoRegistro.obtenerCodigoUnidad(), datoRegistro.obtenerCodigoUAPadre(), "");
            zona.setOidPadre( zonaLocal.getOidRegion());  
            // 21886 - dmorello, 05/04/2006: Se setea la descripción de la zona.
            zona.setDescripcion(zonaLocal.getDescripcion());
            UtilidadesLog.debug("*** Método obtenerUnidadAdministrativa: Salida esZona***");
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUnidadAdministrativa (DatoRegistro datoRegistro): Salida");
            return zona; 
        } 

        if (datoRegistro.esRegion()) {
            UtilidadesLog.debug("***** esRegion = true");
            SubGerenciaVentaLocal subGerenciaVentaLocal = obtenerSubgerencia(datoRegistro.getSubgerencia());
            oidSGV = subGerenciaVentaLocal.getOidSubgVenta();
            
            RegionLocal regionLocal = obtenerRegion(datoRegistro.getRegion(), oidSGV);
                
            UnidadAdministrativa region = this.crearRegion(regionLocal.getOid(), datoRegistro.obtenerCodigoUnidad(), datoRegistro.obtenerCodigoUAPadre(), "");
            region.setOidPadre( regionLocal.getSgvOidSubgVenta()); 
            // 21886 - dmorello, 05/04/2006: Se setea la descripción de la región
            region.setDescripcion(regionLocal.getDescripcionRegion());
            UtilidadesLog.debug("*** Método obtenerUnidadAdministrativa: Salida esRegion***");
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUnidadAdministrativa (DatoRegistro datoRegistro): Salida");
            return region;
        }

        if (datoRegistro.esSubgerencia()) {
            UtilidadesLog.debug("***** esSubgerencia = true");
            SubGerenciaVentaLocal subGerenciaVentaLocal = obtenerSubgerencia(datoRegistro.getSubgerencia());
            
            UnidadAdministrativa subgerencia = this.crearSubgerencia(subGerenciaVentaLocal.getOidSubgVenta(), datoRegistro.obtenerCodigoUnidad());
            // 21886 - dmorello, 05/04/2006: Se setea la descripción de la SGV.
            subgerencia.setDescripcion(subGerenciaVentaLocal.getDescripcionSubgVenta());
            UtilidadesLog.debug("*** Método obtenerUnidadAdministrativa: Salida esSubgerencia***");
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerUnidadAdministrativa (DatoRegistro datoRegistro): Salida");
            return subgerencia; 
        }
        return null;
    }

    private void guardarUnidadAdministrativa (UnidadAdministrativa uniAdm) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarUnidadAdministrativa (UnidadAdministrativa uniAdm): Entrada");
        UtilidadesLog.debug("uniAdm recibida por parametro: " + uniAdm);
        
        // Guarda en BD la unidad administrativa recibida 

        // Comprobar si la unidad no tiene padre y no siendo subgerencia 
        if (uniAdm != null && uniAdm.getOidPadre() == null && uniAdm.getTipo() != uniAdm.SUBGERENCIA ) 
            UtilidadesLog.error("Se encontro un nodo principal que no posee el oid de su padre" );

        //Verificar que la unidad no haya sido creada previamente 
        //Para esto busco en el hashMap "UnidadesCreadas" si hay un elemento con key=uniAdm.obtenerCodigoCompleto(). 
        //Si lo obtiene recupero el oid que se guardo (uniAdm.oid = oid recuperado) 
        if (this.UnidadesCreadas == null) this.UnidadesCreadas = new HashMap();

        if (this.UnidadesCreadas.get(uniAdm.obtenerCodigoCompleto()) == null) { 
            if (uniAdm.getTipo() == uniAdm.SUBGERENCIA) 
                uniAdm.setOid( this.guardarSubgerencia(uniAdm)); 
            else if (uniAdm.getTipo() == uniAdm.REGION) 
                uniAdm.setOid( this.guardarRegion(uniAdm) );
            else if (uniAdm.getTipo() == uniAdm.ZONA) 
                uniAdm.setOid( this.guardarZona(uniAdm) );
            else if (uniAdm.getTipo() == uniAdm.SECCION) 
                uniAdm.setOid( this.guardarSeccion(uniAdm) );
            else if (uniAdm.getTipo() == uniAdm.TERRITORIO) 
                uniAdm.setOid( this.guardarTerritorio(uniAdm) );
            this.UnidadesCreadas.put(uniAdm.obtenerCodigoCompleto(), uniAdm.getOid());
        } else
            uniAdm.setOid((Long)this.UnidadesCreadas.get( uniAdm.obtenerCodigoCompleto()));

        if (uniAdm.getUnidades() != null) {
            for (int i = 0; i < uniAdm.getUnidades().size(); i++) { 
                UnidadAdministrativa unidad = (UnidadAdministrativa)uniAdm.getUnidades().get(i);
                unidad.setOidPadre(uniAdm.getOid()); 
                this.guardarUnidadAdministrativa(unidad); 
            }
        }

        //19286
        if (uniAdm.getTipo() == uniAdm.TERRITORIO) 
            if (uniAdm.getClientes() != null)
                for (int i = 0; i < uniAdm.getClientes().size(); i++)
                    this.guardarCliente(uniAdm.getOid(), (Long)uniAdm.getClientes().get(i));

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarUnidadAdministrativa (UnidadAdministrativa uniAdm): Salida");
    }

    private Long guardarSubgerencia (UnidadAdministrativa unidad) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarSubgerencia (UnidadAdministrativa unidad): Entrada");
        UtilidadesLog.debug("unidad recibida por parametro: " + unidad);
        
        try {
            SubGerenciaVentaLocal subgerencia = 
              (this.getSubGerenciaVentaLocalHome()).create(unidad.obtenerCodigoUnidad(), 
              this.canal, this.marca, this.pais, this.periodoRezonificacion);
            subgerencia.setCodNse1(unidad.getNse1());            
            subgerencia.setCodNse2(unidad.getNse2());            
            /* INC BELC300024021 gPineda 06/06/2006
             * Se cambia el ind_acti. Se debe crear con ind_acti = 0;
            * */
            //subgerencia.setActivo(new Long(1));            
            subgerencia.setActivo(new Long(0));            
            subgerencia.setBorrado(new Long(0));        
            // INC 21886 - dmorello, 16/12/2005
            // Se asigna a la subgerencia la descripción que viene en el parámetro de entrada
            subgerencia.setDescripcionSubgVenta(unidad.getDescripcion());
            
            this.getSubGerenciaVentaLocalHome().merge(subgerencia);
            
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarSubgerencia (UnidadAdministrativa unidad): Salida");
            return subgerencia.getOidSubgVenta();
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
        }
    }

    /*
     * 14-06-2005 - rgiorgi: inc. 19143: cambia el create de la region.
     * */
    private Long guardarRegion (UnidadAdministrativa unidad) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarRegion (UnidadAdministrativa unidad): Entrada");
        UtilidadesLog.debug("unidad recibida por parametro: " + unidad);


        try {
            //Incidencia Peru mamontie 07/05/05
            Timestamp fecUltAct = new Timestamp((new Date()).getTime());
            /* INC BELC300024021 gPineda 06/06/2006
             * Se cambia el ind_acti. Se debe crear con ind_acti = 0;
            * */
            RegionLocal region = (this.getRegionLocalHome()).create(unidad.obtenerCodigoUnidad(), this.pais, this.marca, this.canal, unidad.getOidPadre(), this.periodoRezonificacion ,new Long(0),new Long(0) );
            region.setCodNse1(unidad.getNse1());            
            region.setCodNse2(unidad.getNse2());   
            // INC 21886 - dmorello, 16/12/2005
            // Se agrega a la región la descripción que viene en el parámetro de entrada
            region.setDescripcionRegion(unidad.getDescripcion());
            this.getRegionLocalHome().merge(region);
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarRegion (UnidadAdministrativa unidad): Salida");
            return region.getOid();
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
        }
    }

    private Long guardarZona (UnidadAdministrativa unidad) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarZona (UnidadAdministrativa unidad): Entrada");
        UtilidadesLog.debug("unidad recibida por parametro: " + unidad);

        try {
            ZonaLocal zona = (this.getZonaLocalHome()).create(unidad.obtenerCodigoUnidad(), this.pais, this.marca, this.canal, unidad.getOidPadre(), new Timestamp((new Date()).getTime()), this.periodoRezonificacion);
            zona.setNse1(unidad.getNse1());            
            zona.setNse2(unidad.getNse2());            
            /* INC BELC300024021 gPineda 06/06/2006
             * Se cambia el ind_acti. Se debe crear con ind_acti = 0;
            * */
            //zona.setActiva(new Long(1));            
            zona.setActiva(new Long(0));            
            zona.setBorrado(new Long(0));   
            // INC 21886 - dmorello, 16/12/2005
            // Se asigna a la zona la descripción que viene en el parámetro de entrada
            zona.setDescripcion(unidad.getDescripcion());
            
            this.getZonaLocalHome().merge(zona);
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarZona (UnidadAdministrativa unidad): Salida");
            return zona.getOid();
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
        }
    }

    private Long guardarSeccion (UnidadAdministrativa unidad) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarSeccion (UnidadAdministrativa unidad): Entrada");
        UtilidadesLog.debug("unidad recibida por parametro: " + unidad);

        try {
            SeccionLocal seccion = (this.getSeccionLocalHome()).create(unidad.obtenerCodigoUnidad(), /*this.pais, this.marca, this.canal,*/ unidad.getOidPadre(), this.periodoRezonificacion);
            seccion.setCodNse1(unidad.getNse1());            
            seccion.setCodNse2(unidad.getNse2());            
            /* INC BELC300024021 gPineda 06/06/2006
             * Se cambia el ind_acti. Se debe crear con ind_acti = 0;
            * */
            //seccion.setActivo(new Long(1));            
            seccion.setActivo(new Long(0));            
            seccion.setBorrado(new Long(0));
            // INC 21886 - dmorello, 16/12/2005
            // Se asigna a la sección la descripción que viene en el parámetro de entrada
            seccion.setDesripcion(unidad.getDescripcion());
            this.getSeccionLocalHome().merge(seccion);
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarSeccion (UnidadAdministrativa unidad): Salida");
            return seccion.getOid();
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
        }
    }
    
    private Long guardarTerritorio (UnidadAdministrativa unidad) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarTerritorio (UnidadAdministrativa unidad): Entrada");
        UtilidadesLog.debug("unidad recibida por parametro: " + unidad);

        try {
            // dmorello, 16/05/2006: Se setea el período de inicio al hacer el create.
            TerritorioAdministrativoLocal territorio = (this.getTerritorioAdministrativoLocalHome()).create(this.pais, this.marca, this.canal, unidad.getOidPadre(), unidad.getOidTerritorio(), this.periodoRezonificacion, new Timestamp((new Date()).getTime()));
            //INCIDENCIA incidencia 18478 - FALTA PROPIEDAD PeriodoFin EN LA ENTIDAD - CORREGIDO
            //territorio.setPeriodoIni(this.periodoRezonificacion);   
            territorio.setBorrado(new Long(0));   
            
            this.getTerritorioAdministrativoLocalHome().merge(territorio);
            
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarTerritorio (UnidadAdministrativa unidad): Salida");
            return territorio.getOid();
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
        }
    }
    

   /**
   *              Procesa los registro recibidos y realiza el proceso de rezonificación 
   *              correspondiente para cada uno. Obtiene el fichero del dtoBatch de entrada.
   * 07-07-2006   Modificado por Sapaza, incidencia Sicc-20070276, se modifico para que manejara
   *              transacciones independientes por linea de detalle     
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dtoBatch
   */
    public DTOSalidaBatch rezonificar(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.rezonificar(DTOBatch dtoBatch): Entrada");
        
        DTOFicheroRezonificacion fichero = null;
        try{
            fichero = (DTOFicheroRezonificacion)dtoBatch.getDTOOnline();                       
            UtilidadesLog.debug(" RECIBIDO DTOFicheroRezonificacion  "+fichero);        
        }catch(ClassCastException cce){
            UtilidadesLog.debug("**** ClassCastException  en  MONReestructuracionPrimeraFase.rezonificar, salimos del metodo : ");
            throw new MareException(" ClassCastException  en  MONReestructuracionPrimeraFase.rezonificar  ", cce);
        }
        
        //Obtiene los datos de cabecera
        this.obtenerDatosCabecera(fichero.getCabecera());

        this.periodoRezonificacion = fichero.getOidPeriodoRezonificacion();       //18821 

        //Obtiene el periodo anterior al periodo de rezonificación
        this.obtenerPeriodoFin();
        
        ArrayList regs = fichero.getRegistros();
        int cantRegs = regs.size();

        DTORezonificacionRegistro registro = null;
        UtilidadesLog.debug("Cantidad de registros a procesar: " + cantRegs);
        this.lineasConError = new ArrayList();  // Inicializo array para errores
        
        
        try {
            String codOperacion;
            String strDatoOrigen1;
            String strDatoOrigen2;
            String strDatoNuevo;
            String strClien;
            
            DatoRegistro datoRegistro1;
            DatoRegistro datoRegistro2;
            
            for (int posicion=0; posicion < cantRegs; posicion++) {
                UtilidadesLog.debug("--------- Operacion: " + (posicion + 1));
                registro = (DTORezonificacionRegistro)fichero.getRegistros().get(posicion);
                
                codOperacion = registro.getTipoOp();
                strDatoOrigen1 = registro.getDatoOrigen1();
                strDatoOrigen2 = registro.getDatoOrigen2();
                strDatoNuevo = registro.getDatoNuevo();
                strClien =  registro.getCodCliente();
                
                if ( codOperacion.equalsIgnoreCase(ConstantesZON.TIPO_OPERACION_FUSION) ||
                     codOperacion.equalsIgnoreCase(ConstantesZON.TIPO_OPERACION_PARTICION) ||
                     codOperacion.equalsIgnoreCase(ConstantesZON.TIPO_OPERACION_TRASVASE) ) {
                } else {
                    this.lineasConError.add(new ErrorLineaFichero(posicion + 1, "Codigo de " + FileInterfaceMensajes.M00044)); // Codigo de operacion incorrecto
                    continue;
                }
                
                            
                
                // Validamos dato1 y dato2 pues son obligatorios en las 3 operaciones.
                if (strDatoOrigen1 == null || strDatoOrigen1.trim().length() == 0) {
                    UtilidadesLog.debug("Falta el dato1 y es obligatorio");
                    this.lineasConError.add(new ErrorLineaFichero(posicion + 1, FileInterfaceMensajes.M00048 + "1")); // Falta dato1
                    continue;
                }
                if (strDatoOrigen2 == null || strDatoOrigen2.trim().length() == 0) {
                    UtilidadesLog.debug("Falta el dato2 y es obligatorio");
                    this.lineasConError.add(new ErrorLineaFichero(posicion + 1, FileInterfaceMensajes.M00048 + "2")); // Falta dato2
                    continue;
                }
                // Validamos dato3 solo para Fusion.
                if ( codOperacion.equalsIgnoreCase(ConstantesZON.TIPO_OPERACION_FUSION)
                     && (strDatoNuevo == null || strDatoNuevo.trim().length() == 0) ) {
                    UtilidadesLog.debug("Falta el dato3 y es obligatorio");
                    this.lineasConError.add(new ErrorLineaFichero(posicion + 1, FileInterfaceMensajes.M00048 + "3")); // Falta dato3
                    continue;
                }
                
                
                /* AGREGA 19/04/2006 BELC300021813 */ 
                datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1(), registro.getNse1(), registro.getNse2());
                datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2(), registro.getNse1(), registro.getNse2());
                
                            
                /* INC BELC300024021 gPineda 06/06/2006
                 * Para tomar solamente el codigo de la UA hasta la ultima UA que varia
                 */
                if ( ! registro.getTipoOp().equalsIgnoreCase(ConstantesZON.TIPO_OPERACION_TRASVASE) ) {
                    if ( this.actualizarCodigosUAModificados( registro ) == false) {
                        UtilidadesLog.debug("No es T. Faltan datos para realizar la operacion.");
                        this.lineasConError.add(new ErrorLineaFichero(posicion + 1, FileInterfaceMensajes.M00051)); // Faltan datos para realizar la operacion
                        continue;
                    }
                }
                
                /* INC BELC300024021 gPineda 06/06/2006
                 * Solo NO se procesa por RZ cuando son territorios y éstos difieren.
                 * ( En este caso, se procesan por RTZ )
                 */
                if (datoRegistro1.esTerritorio() && datoRegistro2.esTerritorio()) {
                    UtilidadesLog.debug("*** Los dos campos del archivo SON de Territorio");
                    
                    if(! datoRegistro1.getTerritorio().equals(datoRegistro2.getTerritorio())) {
                        // Este fichero se debe procesar por RTZ
                        UtilidadesLog.debug("*** Los dos Territorios SON distintos, entonces RTZ");
                        this.lineasConError.add(new ErrorLineaFichero(posicion + 1, "Operacion que debe realizarse por Reterritorializacion"));
                        break;
                    }
                }
                              
                try {
                    realizarOperacionTransaccion(registro); //incidencia Sicc-20070276
                } catch(Exception m){
                    UtilidadesLog.error(" ...error al realizar operacion de linea Nro:" + (posicion + 1));
                    UtilidadesLog.error(m);
                    this.lineasConError.add(new ErrorLineaFichero(posicion + 1, m.getMessage()));
                }
            }
        } catch (Exception m) {
            UtilidadesLog.error(m);
            ctx.setRollbackOnly();
            if (m instanceof MareException)
                throw (MareException)m;
        } finally {
            // Incidencia 21808
            UtilidadesLog.debug(" ...grabando el LOG del proceso");
            this.grabarLogErroresReestructuracion(fichero);
        }
        
        String estadoFinProceso = "Rezonificación primera fase realizada";
        if(lineasConError.size() > 0) {
            estadoFinProceso = "Rezonificación primera fase realizada, pero con errores";
        }

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.rezonificar(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, estadoFinProceso );
    }  
    
    private void guardarCliente(Long territorio, Long cliente) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarCliente(Long territorio, Long cliente): Entrada");
        try {
            /* INC BELC300024021 gPineda 06/06/2006
             * Se cambia el ind_acti. Se debe crear con ind_acti = 0;
            * */
            ClienteUnidadAdministrativaLocal clienteLocal = (this.getClienteUnidadAdministrativaLocalHome()).create(cliente, this.periodoRezonificacion, null, territorio, new Long(0));
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarCliente(Long territorio, Long cliente): Salida");
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
        }
    }

    private void actualizarCliente(Long oidCliente, Long oidTerritorioAdm) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarCliente(Long oidCliente, Long oidTerritorioAdm): Entrada");
        // Actualiza el periodo fin del cliente asociado al territorio recibido 

        // Obtiene la relación entre el cliente y el territorio recibido 
        // Se pueden obtener varios ya que un cliente puede estar asignado a la unidad administrativa en varios periodos 
        Collection clientesUA = null;
        try {
            clientesUA = (this.getClienteUnidadAdministrativaLocalHome()).findUAActiva(oidCliente, oidTerritorioAdm);
        } catch (NoResultException e)  {
            UtilidadesLog.debug("*** Método actualizarCliente: No hay clientes ***");
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        ClienteUnidadAdministrativaLocal clienteLocal = null;
        if (!clientesUA.isEmpty()) { 
            Object [] clientesUAArray = clientesUA.toArray();
            for (int i = 0; i < clientesUAArray.length; i++) {
                clienteLocal = (ClienteUnidadAdministrativaLocal) clientesUAArray[i];
                clienteLocal.setPerd_oid_peri_fin(this.periodoFin);
                this.getClienteUnidadAdministrativaLocalHome().merge(clienteLocal);
                /* INC BELC300024021 gPineda 06/06/2006
                 * */
                //clienteLocal.setInd_acti(new Long(0));
            }
        }

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarCliente(Long oidCliente, Long oidTerritorioAdm): Salida");
    }

   //modificado 18429
    public DTOFicheroRezonificacion rezonificarPrimeraFase(DTOFicheroDisp infoFichero) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.rezonificarPrimeraFase(DTOFicheroDisp infoFichero): Entrada");
        // Lee el fichero recibido y realiza el proceso de rezonificación
        DTOFicheroRezonificacion fichero = leerFichero(infoFichero);
        
        // Comprueba los datos de la cabecera
        obtenerDatosCabecera((DTORezonificacionCabecera)fichero.getCabecera());
        fichero.setOidPeriodoRezonificacion((Long)infoFichero.getDatos()); //18821
        
        // Llama al proceso de rezonificación en modo Batch
        DTOBatch dtoBatch = new DTOBatch( "rezonificarPrimeraFase", new MareBusinessID("ZONRezonificarPrimeraFase"),fichero );
        try {
            BatchUtil.executeMLN( dtoBatch, "ZONRezonificacion");
            //BatchUtil.executeMLN( dtoBatch, "FACProcesosGP5");
             
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en rezonificarPrimeraFase",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }        
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.rezonificarPrimeraFase(DTOFicheroDisp infoFichero): Salida");
        return fichero;
    }

    private DTOFicheroRezonificacion leerFichero(DTOFicheroDisp infoFichero) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.leerFichero(DTOFicheroDisp infoFichero): Entrada");

        // Lee el fichero indicado en la entrada  
        this.fileWrapper = new RezonificacionFileWrapper(infoFichero.getPathFichero(), infoFichero.getNombreFichero());
        
        
        // Lee la cabecera del fichero 
        DTOFicheroRezonificacion dtoFicheroRezonificacion = new DTOFicheroRezonificacion();
        dtoFicheroRezonificacion.setCabecera((DTORezonificacionCabecera)fileWrapper.leerCabecera());
        //this.obtenerDatosCabecera(dtoFicheroRezonificacion.getCabecera());    //BELC300018451

        // Lee los registros del fichero 
        DTORezonificacionRegistro dtoRezonificacionRegistro = (DTORezonificacionRegistro)fileWrapper.leerRegistro();
        dtoFicheroRezonificacion.setRegistros(new ArrayList());
        while (dtoRezonificacionRegistro != null) {
            dtoFicheroRezonificacion.getRegistros().add(dtoRezonificacionRegistro);
            dtoRezonificacionRegistro = (DTORezonificacionRegistro)fileWrapper.leerRegistro();
        }
        
        dtoFicheroRezonificacion.setNombreFichero(infoFichero.getNombreFichero());
        
        // Cierra el archivo 
        fileWrapper.cerrarArchivo(); 

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.leerFichero(DTOFicheroDisp infoFichero): Salida");
        return dtoFicheroRezonificacion;
    }

    private void obtenerDatosCabecera (DTORezonificacionCabecera cabecera) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerDatosCabecera (DTORezonificacionCabecera cabecera): Entrada");

        // BELC300018983
        PaisLocal paisLocal = null;
        try {
            paisLocal = this.getPaisLocalHome().findByUk(cabecera.getCodPais());
        } catch (NoResultException e) {
            // Si se captura una Excepción, generar una MareException con error: 280320001 - "El país no existe"
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PAIS_NO_EXISTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        MarcaLocal marcaLocal = null;
        try {
            marcaLocal = this.getMarcaLocalHome().findByUK(cabecera.getCodMarca());
        } catch (NoResultException e) {
            // Si se captura una Excepción, generar una MareException con error: 280330001 - "La marca no existe"
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.MARCA_NO_EXISTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        CanalLocal canalLocal = null;
        try {
            canalLocal = this.getCanalLocalHome().findByUK(cabecera.getCodCanal());
        } catch (NoResultException e) {
            // Si se captura una Excepción, generar una MareException con error: 280340001 - "El canal no existe"
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CANAL_NO_EXISTE));
        }

        TipoPeriodoCorporativoLocal tipoPeriodoCorporativoLocal = null;
        try {
            //inc 18983
            tipoPeriodoCorporativoLocal = this.getTipoPeriodoCorporativoLocalHome().findByUk(cabecera.getTipoPeriodo());
        } catch (NoResultException e) {
            // Si se captura una Excepción, generar una MareException con error: 280350001 - "El tipo periodo no existe"
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.TIPO_PERIODO_NO_EXISTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        PeriodoCorporativoLocal periodoCorporativoLocal = null;
        try {
            periodoCorporativoLocal = this.getPeriodoCorporativoLocalHome().findByUK(cabecera.getPeriodoInicio());
        } catch (NoResultException e) {
            // Si se captura una Excepción, generar una MareException con error: 280360001 - "El periodo no existe"
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PERIODO_NO_EXISTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        PeriodoLocal periodoLocal = null;
        try {
            periodoLocal = this.getPeriodoLocalHome().findByUk(periodoCorporativoLocal.getOid(), marcaLocal.getOid(), paisLocal.getOid(), canalLocal.getOid());
        } catch (NoResultException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PERIODO_NO_EXISTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        this.pais = paisLocal.getOid(); 
        this.marca = marcaLocal.getOid();
        this.canal = canalLocal.getOid(); 
        this.periodo = periodoLocal.getOid();

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerDatosCabecera (DTORezonificacionCabecera cabecera): Salida");
    }
    
    private UnidadAdministrativa crearTerritorio(Long oidTerritorioAdm, 
            Long oidTerritorio, String codUnidad, String codUAPadre) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearTerritorio(Long oidTerritorioAdm, Long oidTerritorio, String codUnidad, String codUAPadre): Entrada");
        // Crea un territorioy obtiene todos los clientes pertenecientes al mismo
        UnidadAdministrativa uaTerritorio = new UnidadAdministrativa(this.TERRITORIO,oidTerritorioAdm, codUnidad, codUAPadre,"");
        uaTerritorio.setOidTerritorio(oidTerritorio);
        
        //clientes = DAOReestructuracion.obtenerClientesPorTerritorio(oidTerritorioAdm) 
        DAOReestructuracion daoReestruccturacion = new DAOReestructuracion();
        RecordSet clientes = daoReestruccturacion.obtenerClientesPorTerritorio(oidTerritorioAdm);
        if (clientes!=null && clientes.esVacio()){
            //SI NO HAY RESULTADOS QUE SE HACE
            UtilidadesLog.debug("No hay resultados para clientes");
        }
        int n=clientes.getRowCount();
        Long oidCliente =null;
        ArrayList arrayClientes = new ArrayList();
        for(int i=0;i<n;i++){
            oidCliente = new Long(((BigDecimal)clientes.getValueAt(i,"OID_CLIENTE")).longValue());
            arrayClientes.add(oidCliente);
        }
        uaTerritorio.setClientes(arrayClientes);
        UtilidadesLog.debug("Territorio creado: " + uaTerritorio);
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearTerritorio(Long oidTerritorioAdm, Long oidTerritorio, String codUnidad, String codUAPadre): Salida");
        return uaTerritorio;
    }

    /**
     * Incidencia 21886 - dmorello, 06/04/2006
     * Se modifica la firma del método para agregar el parámetro "descripcion"
     */
    private UnidadAdministrativa crearSeccion(Long oidSeccion, String codUnidad, String codUAPadre, String descripcion) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearSeccion(Long oidSeccion, String codUnidad, String codUAPadre): Entrada");
        // Crea una seccion y obtiene todas los territorios pertenecientes a la misma 
        UnidadAdministrativa uaSeccion = new UnidadAdministrativa(this.SECCION,oidSeccion, codUnidad, codUAPadre, descripcion);
        
        // territorios = DAOReestructuracion.obtenerTerritoriosPorSeccion(oidSeccion) 
        DAOReestructuracion daoReestruccturacion = new DAOReestructuracion();
        RecordSet territorios = daoReestruccturacion.obtenerTerritoriosPorSeccion(oidSeccion);
        if (territorios != null && territorios.esVacio()){
            //SI NO HAY RESULTADOS QUE SE HACE
            UtilidadesLog.debug("No hay resultados para territorios");
        }        
        Long oidTerritorioAdm =null;
        Long oidTerritorio =null;
        String codTerritorio =null;
        UnidadAdministrativa uaTerritorio = null;
        ArrayList arraySeccion = new ArrayList();
        int n=territorios.getRowCount();
        for(int i=0;i<n;i++){
            oidTerritorioAdm = new Long(((BigDecimal)territorios.getValueAt(i,"OID_TERRITORIO_ADM")).longValue());
            oidTerritorio = new Long(((BigDecimal)territorios.getValueAt(i,"OID_TERRITORIO")).longValue());
            codTerritorio = (BigDecimal)territorios.getValueAt(i,"CODIGO_TERRITORIO") + "";
            uaTerritorio = this.crearTerritorio(oidTerritorioAdm,oidTerritorio,codTerritorio,uaSeccion.obtenerCodigoCompleto());
            //generamos un arraylist de UnidadesAdministrativas de tipo Territorio
            arraySeccion.add(uaTerritorio);
        }
        uaSeccion.setUnidades(arraySeccion);
        UtilidadesLog.debug("Seccion creada: " + uaSeccion);
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearSeccion(Long oidSeccion, String codUnidad, String codUAPadre): Salida");
        return uaSeccion;
    }

    /**
     * Incidencia 21886 - dmorello, 06/04/2006
     * Se modifica la firma del método agregando el parámetro "descripcion"
     */
    private UnidadAdministrativa crearZona(Long oidZona, String codUnidad, String codUAPadre, String descripcion) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearZona(Long oidZona, String codUnidad, String codUAPadre): Entrada");
        // Crea una zona y obtiene todas las secciones pertenecientes a la misma 
        UnidadAdministrativa uaZona = new UnidadAdministrativa(this.ZONA,oidZona, codUnidad, codUAPadre, descripcion);
        
        // secciones = DAOReestructuracion.obtenerSeccionesPorZona(oidZona) 
        DAOReestructuracion daoReestruccturacion = new DAOReestructuracion();
        RecordSet secciones = daoReestruccturacion.obtenerSeccionesPorZona(oidZona);
        if (secciones != null && secciones.esVacio()){
            //SI NO HAY RESULTADOS QUE SE HACE
            UtilidadesLog.debug("No hay resultados para secciones");
        }
        Long oidSeccion = null;
        String codSeccion = null;
        UnidadAdministrativa uaSeccion=null;
        ArrayList arraySeccion = new ArrayList();
        int n=secciones.getRowCount();
        for(int i=0;i<n;i++){
            oidSeccion = new Long(((BigDecimal)secciones.getValueAt(i,"OID_SECCION")).longValue());
            codSeccion = (String)secciones.getValueAt(i,"CODIGO_SECCION");
            // 21886 - dmorello, 06/04/2006: Se setea la descripción de sección
            descripcion = (String)secciones.getValueAt(i,"DESCRIPCION");
            uaSeccion = this.crearSeccion(oidSeccion,codSeccion,uaZona.obtenerCodigoCompleto(),descripcion);
            //generamos un arraylist de UnidadesAdministrativas de tipo Seccion
            arraySeccion.add(uaSeccion);
        }
        // Añade las secciones a la zona 
        uaZona.setUnidades(arraySeccion);
        UtilidadesLog.debug("Zona creada: " + uaZona);
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearZona(Long oidZona, String codUnidad, String codUAPadre): Salida");
        return uaZona;
    }

    /**
     * Incidencia 21886 - dmorello, 06/04/2006
     * Se modifica la firma del método agregando el parámetro "descripcion"
     */
    private UnidadAdministrativa crearRegion(Long oidRegion, String codUnidad, String codUAPadre, String descripcion) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearRegion(Long oidRegion, String codUnidad, String codUAPadre): Entrada");
        // Crea una region y obtiene todas las zonas pertenecientes a la misma 
        UnidadAdministrativa uaRegion = new UnidadAdministrativa(this.REGION,oidRegion, codUnidad, codUAPadre, descripcion);
        
        // zonas = DAOReestructuracion.obtenerZonasPorRegion(oidRegion)
        DAOReestructuracion daoReestruccturacion = new DAOReestructuracion();
        RecordSet zonas = daoReestruccturacion.obtenerZonasPorRegion(oidRegion);
        if (zonas != null && zonas.esVacio()){
            //SI NO HAY RESULTADOS QUE SE HACE
            UtilidadesLog.debug("No hay resultados para zonas");
        }
        Long oidZona = null;
        String codZona = null;
        UnidadAdministrativa uaZona=null;
        ArrayList arrayZona = new ArrayList();
        int n=zonas.getRowCount();
        for(int i=0;i<n;i++){
            oidZona = new Long(((BigDecimal)zonas.getValueAt(i,"OID_ZONA")).longValue());
            codZona = (String)zonas.getValueAt(i,"CODIGO_ZONA");
            // 21886 - dmorello, 06/04/2006: Se setea la descripción de zona
            descripcion = (String)zonas.getValueAt(i,"DESCRIPCION");
            uaZona = this.crearZona(oidZona,codZona,uaRegion.obtenerCodigoCompleto(),descripcion);
            //generamos un arraylist de UnidadesAdministrativas de tipo Zonas
            arrayZona.add(uaZona);
        }
        // Añade las secciones a la zona 
        uaRegion.setUnidades(arrayZona); 
        UtilidadesLog.debug("Region creada:" + uaRegion);
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearRegion(Long oidRegion, String codUnidad, String codUAPadre): Salida");
        return uaRegion;
    }
    
    private UnidadAdministrativa crearSubgerencia (Long oidSubgerencia, String codUnidad) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearSubgerencia (Long oidSubgerencia, String codUnidad): Entrada");
        // Crea una subgerencia y obtiene todas las regiones pertenecientes a la misma 
        UnidadAdministrativa uaSubgerencia = new UnidadAdministrativa(this.SUBGERENCIA,oidSubgerencia, codUnidad, "");
        
        //regiones = DAORezonificacion.obtenerRegionesPorSubgerencia(oidSubgerencia)
        DAOReestructuracion daoReestruccturacion = new DAOReestructuracion();
        RecordSet regiones = daoReestruccturacion.obtenerRegionesPorSubgerencia(oidSubgerencia);
        if (regiones != null && regiones.esVacio()){
            //SI NO HAY RESULTADOS QUE SE HACE
            UtilidadesLog.debug("No hay resultados para zonas");
        }
        Long oidRegion = null;
        String codRegion = null;
        String descripcion = null; // 21886
        UnidadAdministrativa uaRegion = null;
        ArrayList arrayRegion = new ArrayList();
        int n=regiones.getRowCount();
        for(int i=0;i<n;i++){
            oidRegion = new Long(((BigDecimal)regiones.getValueAt(i,"OID_REGION")).longValue());
            codRegion = (String)regiones.getValueAt(i,"CODIGO_REGION");
            // 21886 - dmorello, 06/04/2006: Se setea la descripción de región
            descripcion = (String)regiones.getValueAt(i,"DESCRIPCION");
            uaRegion = this.crearRegion(oidRegion,codRegion,uaSubgerencia.obtenerCodigoCompleto(),descripcion);
            //generamos un arraylist de UnidadesAdministrativas de tipo Region
            arrayRegion.add(uaRegion);
        }
        // Añade las secciones a la zona 
        uaSubgerencia.setUnidades(arrayRegion);
        UtilidadesLog.debug("Subgerencia creada: " + uaSubgerencia);
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.crearSubgerencia (Long oidSubgerencia, String codUnidad): Salida");
        return uaSubgerencia;
    }
    
    private void actualizarSubgerencia (UnidadAdministrativa unidad) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarSubgerencia (UnidadAdministrativa unidad): Entrada");
        // Actualiza la subgerencia recibida 
        //subgerencia = SubgerenciaVentas.findByPrimaryKey(unidad.oid); 
        SubGerenciaVentaLocal subGerenciaVentalocal = null;
        try {
            subGerenciaVentalocal = this.getSubGerenciaVentaLocalHome().findByPrimaryKey(unidad.getOid());
        }catch (NoResultException e) { 
         UtilidadesLog.error(e);
         ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         UtilidadesLog.error("actualizarSubgerencia: FinderException", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
        // Incidencia 18478
        subGerenciaVentalocal.setPeriodoFin(this.periodoFin);
        
        this.getSubGerenciaVentaLocalHome().merge(subGerenciaVentalocal);
        /* INC BELC300024021 gPineda 06/06/2006
        * */
        //subGerenciaVentalocal.setActivo(new Long(0));
        
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarSubgerencia (UnidadAdministrativa unidad): Salida");
    }
    
    private void actualizarRegion (UnidadAdministrativa unidad) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarRegion (UnidadAdministrativa unidad): Entrada");
        // Actualiza la region recibida 
        // region = Region.findByPrimaryKey(unidad.oid) 
        RegionLocal regionLocal = null;
        try {
            regionLocal = this.getRegionLocalHome().findByPrimaryKey(unidad.getOid());
        } catch (NoResultException e) { 
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.error("actualizarRegion: FinderException", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        // Incidencia 18478
        regionLocal.setPeriodoFin(this.periodoFin);
        this.getRegionLocalHome().merge(regionLocal);
        /* INC BELC300024021 gPineda 06/06/2006
        * */
        //regionLocal.setActivo(new Long(0));
        
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarRegion (UnidadAdministrativa unidad): Salida");
    }
    
    private void actualizarZona (UnidadAdministrativa unidad) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarZona (UnidadAdministrativa unidad): Entrada");
        // Actualiza la zona recibida 
        //zona = Zona.findByPrimaryKey(unidad.oid)  
        ZonaLocal zonaLocal = null;
        try {
            zonaLocal = this.getZonaLocalHome().findByPrimaryKey(unidad.getOid());
        } catch (NoResultException e) {
            UtilidadesLog.debug("Zona no existe: "+unidad.getOid());
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //zona.periodoFin = this.periodoFin 
        //zona.indRezonificacion = True

        // Incidencia 18478
        zonaLocal.setPeriodoFin(this.periodoFin);
        zonaLocal.setRezonificacion(new Long(1));
        
        this.getZonaLocalHome().merge(zonaLocal);
        /* INC BELC300024021 gPineda 06/06/2006
        * */
        //zonaLocal.setActiva(new Long(0));
        
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarZona (UnidadAdministrativa unidad): Salida");
    }
    
    private void actualizarSeccion (UnidadAdministrativa unidad) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarSeccion (UnidadAdministrativa unidad): Entrada");
        // Actualiza la seccion recibida 
        //seccion = Seccion.findByPrimaryKey(unidad.oid)  
        SeccionLocal seccionLocal = null;
        try {
            seccionLocal = this.getSeccionLocalHome().findByPrimaryKey(unidad.getOid());
        } catch (NoResultException e) { 
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.error("actualizarSeccion: FinderException", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //seccion.periodoFin = this.periodoFin 

        // Incidencia 18478
        seccionLocal.setPeriodoFin(this.periodoFin);
        /* INC BELC300024021 gPineda 06/06/2006
        * */
        //seccionLocal.setActivo(new Long(0));
        
         this.getSeccionLocalHome().merge(seccionLocal);
        
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarSeccion (UnidadAdministrativa unidad): Salida");
    }
    
    private void actualizarTerritorio (UnidadAdministrativa unidad) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTerritorio (UnidadAdministrativa unidad): Entrada");
        UtilidadesLog.debug("unidad recibida por parametro: " + unidad);
        // Actualiza el territorio administrativo recibido
        //territorio = TerritorioAdministrativo.findByPrimaryKey(unidad.oid)  
        TerritorioAdministrativoLocal territorioAdministrativoLocal = null;
        try {
            territorioAdministrativoLocal = this.getTerritorioAdministrativoLocalHome().findByPrimaryKey(unidad.getOid());
        } catch (NoResultException e) { 
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.error("actualizarTerritorio: FinderException", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //territorio.periodoFin = this.periodoFin
        //INCIDENCIA 18478 - FALTA LA PROPIEDAD PeriodoFin EN LA ENTIDAD - CORREGIDA
        territorioAdministrativoLocal.setPeriodoFin(this.periodoFin);
        
        this.getTerritorioAdministrativoLocalHome().merge(territorioAdministrativoLocal);
        
        // Actualiza los clientes asignados al territorio 
        ArrayList clientes = unidad.getClientes();
        int n = clientes.size();
        Long oidCliente = null;
        for (int i = 0; i < n; i++) {
            oidCliente = (Long)clientes.get(i);
            this.actualizarCliente(oidCliente, territorioAdministrativoLocal.getOid());
        }
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTerritorio (UnidadAdministrativa unidad): Salida");
    }

  /**
   * 07/06/2007   Modificado por Sapaza, incidencia Sicc-20070276, se modifica para que lance
   *              una transaccion por cada detalle del fichero
   * @throws es.indra.mare.common.exception.MareException
   * @param mapValores
   * @param registro
   */
    public void realizarOperacion(DTORezonificacionRegistro registro, HashMap mapValores) throws MareException {
      UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.realizarOperacion (DTORezonificacionRegistro registro, HashMap mapValores): Entrada");
      // Realiza la operación indicada entre las dos unidades administrativas recibidas

      //recupera Valores de Cabecera del Fichero, incidencia 20070276
      ponerValoresFichero(mapValores);
      
      if (registro.getTipoOp().equals(ConstantesZON.TIPO_OPERACION_PARTICION)){
          particion(registro); 
      }
      if (registro.getTipoOp().equals(ConstantesZON.TIPO_OPERACION_FUSION)){
          fusion(registro); 
      }
      if (registro.getTipoOp().equals(ConstantesZON.TIPO_OPERACION_TRASVASE)){
          trasvase(registro); 
      }
      
      // Genera el histórico de la operación
      this.generarHistorico(registro);
      UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.realizarOperacion (DTORezonificacionRegistro registro, HashMap mapValores): Salida");
    }
    
    private void particion(DTORezonificacionRegistro registro) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.particion(DTORezonificacionRegistro registro): Entrada");
        // Realiza la partición de una UA en otra
        // Obtiene la UA correspondiente al dato origen 1 del registro
        ClienteDatosBasicosLocal clienteDatosBasicosLocal =null;
        String codigoCliente = registro.getCodCliente();
        if (codigoCliente.trim().length() == 0) {
            throw new MareException(FileInterfaceMensajes.M00052);  // M00052 "Falta el codigo de cliente"
        }
        
        try {
            clienteDatosBasicosLocal = this.getClienteDatosBasicosLocalHome().findByCodigoYPais(this.pais,registro.getCodCliente());
        } catch (NoResultException e) {
            UtilidadesLog.error("No existe el codigo de cliente: "+ codigoCliente);
            throw new MareException(FileInterfaceMensajes.M00053);  // M00053 "No existe el codigo de cliente"
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        DatoRegistro datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1(),registro.getNse1(),registro.getNse2());
        UnidadAdministrativa unidadAdministrativa1;
        
        // La UA del dato1 debe existir
        try {
            unidadAdministrativa1 = obtenerUnidadAdministrativa(datoRegistro1);
        } catch(MareException me) {
            UtilidadesLog.error(me);
            // M000049 "No existe la UA del Dato1"
            throw new MareException(FileInterfaceMensajes.M00049 + "1: " + me.getMessage());
        }
        // Obtiene al dato origen 2 del registro
        DatoRegistro datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2(),registro.getNse1(),registro.getNse2());

        /* DBLG500000110 - BELC300021497 : gPineda cdos 10/07/2006
         * Se verifica que no exista la unidad a crear con la partición. */
        boolean existe = false;
        UnidadAdministrativa unidadAdministrativaReg2 = null;
        
        try {
          unidadAdministrativaReg2 = obtenerUnidadAdministrativa(datoRegistro2);
          existe = true;
        }catch(MareException e){
          UtilidadesLog.debug("La UA a crear no existe, es correcto");
          existe = false;
        }
        
        // vbongiov -- 5/12/2007
        if( existe && (this.UnidadesCreadas.get(unidadAdministrativaReg2.obtenerCodigoCompleto()) == null)) {
            // M00050 "La UA del Dato2 ya existe"
            throw new MareException(FileInterfaceMensajes.M00050 + "2");
        }

        //Particiona la unidad 1 generando una nueva unidad con código 2
        UnidadAdministrativa nuevaUnidad = unidadAdministrativa1.particion(clienteDatosBasicosLocal.getOid(),datoRegistro2.obtenerCodigoUnidad());

        if (nuevaUnidad != null) {       
            nuevaUnidad.setOidPadre(unidadAdministrativa1.getOidPadre());
            nuevaUnidad.setNse1(datoRegistro1.obtenerNSE1());
            nuevaUnidad.setNse2(datoRegistro1.obtenerNSE2());
            
            // INC 21886 - dmorello, 16/12/2005
            // Asigna la descripcion a la nueva unidad
            nuevaUnidad.setDescripcion(registro.getDesc());
        
            //Guarda la nueva unidad fruto de la fusión
            this.guardarUnidadAdministrativa(nuevaUnidad);
        }
        
        //Actualiza la unidad original
        this.actualizarUnidadAdministrativa(unidadAdministrativa1);
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.particion(DTORezonificacionRegistro registro): Salida");
    }

    private void fusion(DTORezonificacionRegistro registro) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.fusion(DTORezonificacionRegistro registro): Entrada");
        // Realiza la fusión de las 2 UA contenidas en el registro 

        // Obtiene la UA correspondiente al dato origen 1 del registro 
        DatoRegistro datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1(), registro.getNse1(), registro.getNse2());
        UnidadAdministrativa unidadAdministrativa1;
        
        try {
            unidadAdministrativa1 = this.obtenerUnidadAdministrativa(datoRegistro1);
        } catch(MareException me) {
            UtilidadesLog.error(me);
            // M00049 "No existe la UA del Dato1"
            throw new MareException(FileInterfaceMensajes.M00049 + "1: " + me.getMessage());
        }

        // Obtiene la UA correspondiente al dato origen 2 del registro 
        DatoRegistro datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2(), registro.getNse1(), registro.getNse2());
        UnidadAdministrativa unidadAdministrativa2;
        
        try {
            unidadAdministrativa2 = this.obtenerUnidadAdministrativa(datoRegistro2);
        } catch(MareException me) {
            UtilidadesLog.error(me);
            // M00049 "No existe la UA del Dato2"
            throw new MareException(FileInterfaceMensajes.M00049 + "2: " + me.getMessage());
        }

        // Obtiene la UA correspondiente al dato destino del registro 
        DatoRegistro datoDestino = new DatoRegistro(registro.getDatoNuevo(), registro.getNse1(), registro.getNse2()); 
        
        /* DBLG500000110 - BELC300021497 : gPineda cdos 10/07/2006
         * Se verifica que no exista la unidad a crear con la fusion. */
        boolean existe = false;
        UnidadAdministrativa unidadAdministrativaDest = null;
        try {          
          unidadAdministrativaDest = obtenerUnidadAdministrativa(datoDestino);
          existe = true;
        } catch(MareException e) {
          UtilidadesLog.debug("La UA a crear no existe, esto es correcto");
          existe = false;
        }
        
        // vbongiov -- 5/12/2007
        if ( existe && (this.UnidadesCreadas.get(unidadAdministrativaDest.obtenerCodigoCompleto()) == null)) {
            // M00050 "La UA del Dato3 ya existe"
            throw new MareException(FileInterfaceMensajes.M00050 + "3");
        }

        // Fusiona ambas unidades y asigna código al resultado 
        UnidadAdministrativa nuevaUnidad = unidadAdministrativa1.fusion(unidadAdministrativa2, datoDestino.obtenerCodigoUnidad()); 

        nuevaUnidad.setNse1(datoDestino.obtenerNSE1()); 
        nuevaUnidad.setNse2(datoDestino.obtenerNSE2()); 
        // INC 21886 - dmorello, 16/12/2005
        // Se asigna la descripción a la nueva unidad
        UtilidadesLog.debug("Descripción recuperada del DTORezonificacionRegistro: " + registro.getDesc());
        nuevaUnidad.setDescripcion(registro.getDesc());

        // Guarda la nueva unidad fruto de la fusión 
        this.guardarUnidadAdministrativa(nuevaUnidad); 

        // Actualiza las unidades originales 
        this.actualizarUnidadAdministrativa(unidadAdministrativa1); 
        this.actualizarUnidadAdministrativa(unidadAdministrativa2);

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.fusion(DTORezonificacionRegistro registro): Salida");
    }

  /**
   * 13-06-2007   modificado por Sapaza, incidencia Sicc-20070276. Se crea un nuevo registro 
   *              para la unidad administrativa y se da de baja el registro actual
   * @throws es.indra.mare.common.exception.MareException
   * @param registro
   */
    private void trasvase(DTORezonificacionRegistro registro) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.trasvase(DTORezonificacionRegistro registro): Entrada");
        // Realiza el trasvase de una unidad a otra 
        try{

        // Obtiene la UA correspondiente al dato origen 1 del registro 
        DatoRegistro datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1(), registro.getNse1(), registro.getNse2());
        UnidadAdministrativa unidadAdministrativa1;
        try {
            unidadAdministrativa1 = this.obtenerUnidadAdministrativa(datoRegistro1);
            //recupera la region Origen, incidencia-20070276
            this.regionOrigen = this.region;
        } catch(MareException me) {
            UtilidadesLog.error(me);
            // M00049 "No existe la UA del Dato1"
            throw new MareException(FileInterfaceMensajes.M00049 + "1: " + me.getMessage());
        }

        // Obtiene la UA correspondiente al dato origen 2 del registro 
        DatoRegistro datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2(), registro.getNse1(), registro.getNse2());
        
        
        // BELC300024016 - 10/08/2006
        // Se verifica que no exista la unidad destino del trasvase.
        boolean existe = false;
        UnidadAdministrativa unidadAdministrativaReg2 = null;
        
        try {
            unidadAdministrativaReg2 = obtenerUnidadAdministrativa(datoRegistro2);
            existe = true;
        } catch (MareException me) {
            UtilidadesLog.error("La UA destino del trasvase no existe. Esto es correcto... continuamos el proceso.");
            existe = false;
        }
        
        if(existe) {
            // M00050 "La UA del Dato2 ya existe"
            throw new MareException(FileInterfaceMensajes.M00050 + "2");
        }
        
        DatoRegistro datoRegistro3 = new DatoRegistro(datoRegistro2.obtenerCodigoUAPadre(), registro.getNse1(), registro.getNse2());
        UnidadAdministrativa unidadAdministrativa2;
        // Obtenemos la UA Padre del Dato2
        try {
            unidadAdministrativa2 = this.obtenerUnidadAdministrativa(datoRegistro3);

            //recupera la region Destino, incidencia-20070276
            this.regionDestino = this.region;
            
        } catch (MareException me) {
            UtilidadesLog.error(me);
            // M00049 "No existe la UA del Dato2"
            throw new MareException(FileInterfaceMensajes.M00049 + "2: " + me.getMessage());
        }
        
        // Realiza el trasvase de la unidad 1 a la unidad 2        
        /*AGREGA 19/04/2006 BELC300021813*/
        unidadAdministrativa2.trasvase(unidadAdministrativa1);

        unidadAdministrativa1.setNse1(datoRegistro1.obtenerNSE1()) ;
        unidadAdministrativa1.setNse2(datoRegistro1.obtenerNSE2());
        unidadAdministrativa1.setOidPadre( unidadAdministrativa2.getOid());

        try {
            //verificamos si el periodoFin esta cerrado, de acuerdo a ello actualizaremos
            //los indicadores Activo y Borrado de las unidades administrativas afectadas
            validarCierrePeriodoFin();

            // Actualiza la unidad Trasvasada
            actualizarTrasvaseUA(unidadAdministrativa1);         
        } catch (MareException me) {
            ctx.setRollbackOnly();  
            throw me;
        }
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e);
        }
        
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.trasvase(DTORezonificacionRegistro registro): Salida");
    }



    private void generarHistorico (DTORezonificacionRegistro registro) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.generarHistorico (DTORezonificacionRegistro registro): Entrada");
        
        // Genera el histórico de la operación recibida en el registro
        // 18810
        try{
            HistoricoZonasLocal historicoZonasLocal = this.getHistoricoZonasLocalHome().create(registro.getTipoOp(), registro.getDatoOrigen1(), registro.getDatoOrigen2(),new Timestamp((new Date()).getTime()), this.periodoRezonificacion);
            if (registro.getTipoOp().equals(ConstantesZON.TIPO_OPERACION_FUSION)){
                historicoZonasLocal.setUa3(registro.getDatoNuevo());
                this.getHistoricoZonasLocalHome().merge(historicoZonasLocal);
            }
        }catch(PersistenceException e){
            UtilidadesLog.error(e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));            
        }        

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.generarHistorico (DTORezonificacionRegistro registro): Salida");
    }

    private void actualizarUnidadAdministrativa(UnidadAdministrativa unidad) throws MareException{
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarUnidadAdministrativa(UnidadAdministrativa unidad): Entrada");
        if (unidad.getTipo() == this.SUBGERENCIA) 
            this.actualizarSubgerencia(unidad); 
        else if (unidad.getTipo() == this.REGION) 
            this.actualizarRegion(unidad); 
        else if (unidad.getTipo() == this.ZONA) 
            this.actualizarZona(unidad); 
        else if (unidad.getTipo() == this.SECCION) 
            this.actualizarSeccion(unidad); 
        else if (unidad.getTipo() == this.TERRITORIO) 
            this.actualizarTerritorio(unidad);

        if (unidad.getUnidades() != null)
            for (int i = 0; i < unidad.getUnidades().size(); i++) 
                this.actualizarUnidadAdministrativa((UnidadAdministrativa)unidad.getUnidades().get(i));

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarUnidadAdministrativa(UnidadAdministrativa unidad): Salida");
    }
    
    private MONGestorInterfacesHome getMONGestorInterfacesHome() throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.getMONGestorInterfacesHome(): Entrada");
        try {
            final InitialContext context = new InitialContext();
            MONGestorInterfacesHome mgiH = null;
            mgiH = (MONGestorInterfacesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestorInterfaces"), MONGestorInterfacesHome.class);
            UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.getMONGestorInterfacesHome(): Salida");
            return mgiH;
        } catch (NamingException ne) {
            throw new MareException(ne, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
    }
  

    private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.getMONPeriodos(): Entrada");
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome("MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.getMONPeriodos(): Salida");
        return ejb;
	}

  // AGREGA 20/04/2006 incidencia 21813
  /**
   * 13-07-2006   Modificado por Sapaza, incidencia Sicc-20070276. Se crea un nuevo registro para 
   *              la region/zona/seccion/territorioadministrativo y se da de baja el actual,
   *              ademas se actualiza las unidades administrativas de los clientes afectados
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param unidad
   */
  private void actualizarTrasvaseUA(UnidadAdministrativa unidad) throws MareException {
    // Actualiza el estado de la unidad trasvasada
    UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseUA(UnidadAdministrativa unidad): Entrada");
    Long oidTerritorioAnt = null;
  
    if(unidad.getTipo() == this.REGION)
    {
       unidad.setOid(actualizarTrasvaseRegion(unidad));
       this.regionDestino = unidad.getOid(); //si se trasvasa region, se recupera la nueva oid region
    }
    if(unidad.getTipo() == this.ZONA)
    {
       unidad.setOid(actualizarTrasvaseZona(unidad));
    }
    if(unidad.getTipo() == this.SECCION)
    {
       unidad.setOid(actualizarTrasvaseSeccion(unidad)); 
    }
    if(unidad.getTipo() == this.TERRITORIO)
    {
       oidTerritorioAnt = unidad.getOid();  //recuperamos el oid Territorio Administrativo Anterior
       unidad.setOid(actualizarTrasvaseTerritorio(unidad));
    }

    //(07-06-2007) Se actualiza el oid padre, incidencia Sicc20070276 (Sapaza)    
    if (unidad.getUnidades() != null) {
        for (int i = 0; i < unidad.getUnidades().size(); i++) { 
            UnidadAdministrativa unidadHija = (UnidadAdministrativa)unidad.getUnidades().get(i);
            unidadHija.setOidPadre(unidad.getOid()); 
            this.actualizarTrasvaseUA(unidadHija); 
        }
    }

    //(07-06-2007) En caso de TerritorioAdministrativo, actualizamos las unidades administrativas 
    //y estatus del cliente, incidencia Sicc20070276 (Sapaza)
    if (unidad.getTipo() == unidad.TERRITORIO) 
        if(unidad.getClientes() != null && (unidad.getClientes().size() > 0))
            this.guardarClienteTrasvase(unidad.getClientes(), oidTerritorioAnt, unidad.getOid());
    
    UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseUA(UnidadAdministrativa unidad): Salida");
  }
  // FIN AGREGA 20/04/2006 incidencia 21813
  
  // AGREGA 20/04/2006 incidencia 21813
  /**
   * 13-07-2006   Modificado por Sapaza, incidencia Sicc-20070276. Se crea un nuevo registro para 
   *              la region y se da de baja el actual
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param unidad
   */
  private Long actualizarTrasvaseRegion(UnidadAdministrativa unidad) throws MareException {
    UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseRegion(UnidadAdministrativa unidad): Entrada");
    UtilidadesLog.debug("unidad recibida por parametro: " + unidad);
    Long responsable = null;
    /*Hacer un findByPk en el entity Region con unidad.oid y actualizar los siguientes datos:
      - nse1 = unidad.obtenerNSE1()
      - nse2 = unidad.obtenerNSE2()
      - sgv = unidad.oidPadre
      - descripcion = unidad.descripcion
    
     */  
   
    if (unidad.getOid()!= null){
        try {                
            RegionLocal region = null;
            region = this.getRegionLocalHome().findByPrimaryKey(unidad.getOid());
            //region.setCodNse1(unidad.getNse1());
            //region.setCodNse2(unidad.getNse2());
            responsable = region.getOidCliente();
            region.setPeriodoFin(this.periodoFin);
            region.setActivo(this.indActivoTrasvaseAnt);
            region.setBorrado(this.indBorradoTrasvaseAnt);
            this.getRegionLocalHome().merge(region);
        } catch (NoResultException e) {
            UtilidadesLog.debug("*** No se encontró la Region ***");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }   

    try {
    
          UtilidadesLog.debug("unidad.obtenerCodigoUnidad(): " + unidad.obtenerCodigoUnidad());
          UtilidadesLog.debug("this.pais: " + this.pais);
          UtilidadesLog.debug("this.marca: " + this.marca);
          UtilidadesLog.debug("this.canal: " + this.canal);
          UtilidadesLog.debug("unidad.getOidPadre(): " + unidad.getOidPadre());
          UtilidadesLog.debug("this.periodoRezonificacion: " + this.periodoRezonificacion);
    
    
        Timestamp fecUltAct = new Timestamp((new Date()).getTime());
        RegionLocal region = (this.getRegionLocalHome()).create(unidad.obtenerCodigoUnidad(), this.pais, this.marca, this.canal, 
                              unidad.getOidPadre(), this.periodoRezonificacion ,this.indActivoTrasvaseNueva, this.indBorradoTrasvaseNueva);
        region.setCodNse1(unidad.getNse1());            
        region.setCodNse2(unidad.getNse2());   

        region.setSgvOidSubgVenta(unidad.getOidPadre());
        region.setDescripcionRegion(unidad.getDescripcion());
        region.setOidCliente(responsable);
        this.getRegionLocalHome().merge(region);
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseRegion (UnidadAdministrativa unidad): Salida");
        return region.getOid();
    } catch (PersistenceException e) {
        UtilidadesLog.error(e);
        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
    }   

  }
  // FIN AGREGA 20/04/2006 incidencia 21813
  
  // AGREGA 20/04/2006 incidencia 21813
  /**
   * 13-07-2006   Modificado por Sapaza, incidencia Sicc-20070276. Se crea un nuevo registro para 
   *              la zona y se da de baja el actual
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param unidad
   */
  private Long actualizarTrasvaseZona(UnidadAdministrativa unidad) throws MareException {
    UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseZona(UnidadAdministrativa unidad): Entrada");
    UtilidadesLog.debug("unidad recibida por parametro: " + unidad);
    Long responsable = null;
    /*
    Hacer un findByPk en el entity Zona con unidad.oid y actualizar los siguientes datos:
    - nse1 = unidad.obtenerNSE1()
    - nse2 = unidad.obtenerNSE2()
    - region = unidad.oidPadre
    - descripcion = unidad.descripcion
     */
   
      if (unidad.getOid()!= null){
        try {                
            ZonaLocal zona = null;
            zona = this.getZonaLocalHome().findByPrimaryKey(unidad.getOid());
            
            UtilidadesLog.debug("zona.getCodZona(): " + zona.getCodZona());
            UtilidadesLog.debug("zona.getPeriodoInic(): " + zona.getPeriodoInic());            
            
            //zona.setNse1(unidad.getNse1());
            //zona.setNse2(unidad.getNse2());
            responsable = zona.getCliente();
            zona.setPeriodoFin(this.periodoFin);
            zona.setActiva(this.indActivoTrasvaseAnt);
            zona.setBorrado(this.indBorradoTrasvaseAnt);
            this.getZonaLocalHome().merge(zona);
                        
        } catch (NoResultException e) {
            UtilidadesLog.debug("*** No se encontró la Zona ***");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
      } 

      try {
      
          UtilidadesLog.debug("unidad.obtenerCodigoUnidad(): " + unidad.obtenerCodigoUnidad());
          UtilidadesLog.debug("this.pais: " + this.pais);
          UtilidadesLog.debug("this.marca: " + this.marca);
          UtilidadesLog.debug("this.canal: " + this.canal);
          UtilidadesLog.debug("unidad.getOidPadre(): " + unidad.getOidPadre());
          UtilidadesLog.debug("this.periodoRezonificacion: " + this.periodoRezonificacion);
      
      
          ZonaLocal zona = (this.getZonaLocalHome()).create(unidad.obtenerCodigoUnidad(), this.pais, this.marca, this.canal, unidad.getOidPadre(), new Timestamp((new Date()).getTime()), this.periodoRezonificacion);
          zona.setNse1(unidad.getNse1());            
          zona.setNse2(unidad.getNse2());            
          zona.setActiva(this.indActivoTrasvaseNueva);            
          zona.setBorrado(this.indBorradoTrasvaseNueva);   
          zona.setDescripcion(unidad.getDescripcion());
          zona.setCliente(responsable);
          this.getZonaLocalHome().merge(zona);
          UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseZona(UnidadAdministrativa unidad): Salida");
          
          return zona.getOid();
      } catch (PersistenceException e) {
          UtilidadesLog.error(e);
          String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
      }
      
  }
  // FIN AGREGA 20/04/2006 incidencia 21813
  
  // AGREGA 20/04/2006 incidencia 21813
  /**
   * 13-07-2006   Modificado por Sapaza, incidencia Sicc-20070276. Se crea un nuevo registro para 
   *              la seccion y se da de baja el actual
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param unidad
   */
  private Long actualizarTrasvaseSeccion(UnidadAdministrativa unidad) throws MareException {
    UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseSeccion(UnidadAdministrativa unidad): Entrada");
    UtilidadesLog.debug("unidad recibida por parametro: " + unidad);  
    Long responsable = null;
    /*
     Hacer un findByPk en el entity Seccion con unidad.oid y actualizar los siguientes datos:
   - nse1 = unidad.obtenerNSE1()
   - nse2 = unidad.obtenerNSE2()
   - zona = unidad.oidPadre
   - descripcion = unidad.descripcion
     */
   
    if (unidad.getOid()!= null){
      try {                
          SeccionLocal seccion = null;
          seccion = this.getSeccionLocalHome().findByPrimaryKey(unidad.getOid());
          //seccion.setCodNse1(unidad.getNse1());
          //seccion.setCodNse2(unidad.getNse2());
          //seccion.setOidZona(unidad.getOidPadre());
          //seccion.setDesripcion(unidad.getDescripcion());
           responsable = seccion.getClienteOid();
           seccion.setPeriodoFin(this.periodoFin);
           seccion.setActivo(this.indActivoTrasvaseAnt);
           seccion.setBorrado(this.indBorradoTrasvaseAnt);
          this.getSeccionLocalHome().merge(seccion);
                      
      } catch (NoResultException e) {
          UtilidadesLog.debug("*** No se encontró la Seccion ***");
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
    }  

    try {
        SeccionLocal seccion = (this.getSeccionLocalHome()).create(unidad.obtenerCodigoUnidad(), unidad.getOidPadre(), this.periodoRezonificacion);
        seccion.setCodNse1(unidad.getNse1());            
        seccion.setCodNse2(unidad.getNse2());            
        seccion.setActivo(this.indActivoTrasvaseNueva);
        seccion.setBorrado(this.indBorradoTrasvaseNueva);
        seccion.setDesripcion(unidad.getDescripcion());
        seccion.setClienteOid(responsable);
        this.getSeccionLocalHome().merge(seccion);
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseSeccion(UnidadAdministrativa unidad): Salida");
        
        return seccion.getOid();
    } catch (PersistenceException e) {
        UtilidadesLog.error(e);
        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
    }
   
  }
// FIN AGREGA 20/04/2006 incidencia 21813

//  AGREGA 20/04/2006 incidencia 21813
  /**
   * 13-07-2006   Modificado por Sapaza, incidencia Sicc-20070276. Se crea un nuevo registro para 
   *              el territorio administrativo y se da de baja el actual
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param unidad
   */
  private Long actualizarTrasvaseTerritorio(UnidadAdministrativa unidad) throws MareException {
  UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseTerritorio(UnidadAdministrativa unidad): Entrada");
  /*
   Hacer un findByPk en el entity TerritorioAdministrativo con unidad.oid y actualizar los siguientes datos:
   - seccion = unidad.oidPadre

    Hacer un findByPk en el entity Territorio con unidad.oidTerritorio y actualizar los siguientes datos:
   - nse1 = unidad.obtenerNSE1()
  - nse2 = unidad.obtenerNSE2()
  */
  
    if (unidad.getOid()!= null){
        try {              
            TerritorioAdministrativoLocal territorioAdm = null;
            territorioAdm = this.getTerritorioAdministrativoLocalHome().findByPrimaryKey(unidad.getOid());
            territorioAdm.setPeriodoFin(this.periodoFin);
            territorioAdm.setBorrado(this.indBorradoTrasvaseAnt);
            
            try{                  
                TerritorioLocal territorio = null; 
                territorio = this.getTerritorioLocalHome().findByPrimaryKey(unidad.getOidTerritorio());
                territorio.setNse1(unidad.getNse1());
                territorio.setNse2(unidad.getNse2());
                this.getTerritorioLocalHome().merge(territorio);
            
            }catch (NoResultException e){
                UtilidadesLog.debug("*** No se encontró el Territorio ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
        } catch (NoResultException e) {
            UtilidadesLog.debug("*** No se encontró la Territorio Administrativo ***");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    } 
    
      try {
          TerritorioAdministrativoLocal territorio = (this.getTerritorioAdministrativoLocalHome()).create(this.pais, this.marca, this.canal, unidad.getOidPadre(), unidad.getOidTerritorio(), this.periodoRezonificacion, new Timestamp((new Date()).getTime()));
          territorio.setBorrado(this.indBorradoTrasvaseNueva);
          this.getTerritorioAdministrativoLocalHome().merge(territorio);
  
          UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.actualizarTrasvaseTerritorio(UnidadAdministrativa unidad): Salida");
          return territorio.getOid();
      } catch (PersistenceException e) {
          UtilidadesLog.error(e);
          String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
      }
   
  }
// FIN AGREGA 20/04/2006 incidencia 21813

   /**
    * Genera un archivo de log con los errores producidos durante el proceso de 
    * restructuracion. Se utiliza el gestor de Interfaces.
    * @author Emilio Iraola
    * @since 15/05/2006
    */
    private void grabarLogErroresReestructuracion(DTOFicheroRezonificacion fichero) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.grabarLogErroresReestructuracion(): Entrada");
        
        MONGestorInterfaces gestor = null;
        MONGestorInterfacesHome monGestorInterfacesHome = null;
        InterfazInfo info = null;
        InterfazInfo interfaz = null;
        RegistroSicc registro = new RegistroSicc();
        
        int cantErrores = this.lineasConError.size();
        UtilidadesLog.debug("...hubo errores " + cantErrores);
        
        DTORezonificacionCabecera cabeceraArchivo = fichero.getCabecera();
        UtilidadesLog.debug("...cabecera de archivo: " + cabeceraArchivo);
        
        try {
            /* Archivo "ZON_<numeroLote>.TXT"
             * Contiene
             *  - Cabecera
             *    nombreFicheroOriginal
             *    fechayHoraProceso
             *    copia de la cabecera original
             *  - Detalle
             *    NroLineaDelError + "Faltan datos...."
             * rezonificacion procesado y la cantidad de errores ocurridos.
             */
            
            /* Fecha y hora del proceso */
            Timestamp ahora = new Timestamp(System.currentTimeMillis()); 
                        
            /* Caracter para separar lineas de la cabecera - seria el 'Enter' */
            String bajaLinea = System.getProperty( "line.separator" );
                                    
            /* String vacio para los casos en que los campos van vacios */
            String vacio = new String();
            
            /* Variables para la cabecera del Log */
            String nombreFichero = fichero.getNombreFichero() + bajaLinea;
            String fechaProceso = ahora.toString() + bajaLinea;
            String pais = cabeceraArchivo.getCodPais() + bajaLinea;
            String marca = cabeceraArchivo.getCodMarca() + bajaLinea;
            String canal = cabeceraArchivo.getCodCanal() + bajaLinea;
            String tipoPeriodo = cabeceraArchivo.getTipoPeriodo() + bajaLinea;
            String periodoInicio = cabeceraArchivo.getPeriodoInicio() + bajaLinea;
            String fechaActualizacion = cabeceraArchivo.getFechaActualizacion().toString() + bajaLinea;
                        
            // vbongiov -- 9/11/2007
            String fechaCreacionGis = null;
            if(cabeceraArchivo.getFechaCreacionGIS()!=null){
                fechaCreacionGis = cabeceraArchivo.getFechaCreacionGIS().toString() + bajaLinea;
            } else {
                fechaCreacionGis = " " + bajaLinea;
            }
                        
            monGestorInterfacesHome = getMONGestorInterfacesHome();
            gestor = monGestorInterfacesHome.create();
            info = gestor.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_ZON1, this.pais);
            interfaz = gestor.crearInterfaz(info);
                        
            
            /** Cabecera del LOG */
            registro.vaciar();
            registro.anyadirCampo(IRegistroSicc.ZON_NOMBRE_FICHERO, nombreFichero);
            registro.anyadirCampo(IRegistroSicc.ZON_FECHA_PROCESO, fechaProceso);
            
            registro.anyadirCampo(IRegistroSicc.ZON_PAIS, pais);
            registro.anyadirCampo(IRegistroSicc.ZON_MARCA, marca);
            registro.anyadirCampo(IRegistroSicc.ZON_CANAL, canal);
            registro.anyadirCampo(IRegistroSicc.ZON_TIPO_PERIODO, tipoPeriodo);
            registro.anyadirCampo(IRegistroSicc.ZON_PERIODO_INICIO, periodoInicio);
            registro.anyadirCampo(IRegistroSicc.ZON_FECHA_ACTUALIZACION, fechaActualizacion);
            registro.anyadirCampo(IRegistroSicc.ZON_CREACION_GIS, fechaCreacionGis);
            if (cantErrores > 0) { // El encabezado del detalle
                registro.anyadirCampo(IRegistroSicc.ZON_DETALLE, "        Linea" + "\t" + "Error");
            } else {
                registro.anyadirCampo(IRegistroSicc.ZON_DETALLE, vacio);
            }
            
            gestor.anyadirRegistro(interfaz, registro);
            UtilidadesLog.debug("... la cabecera se grabo correctamente en el archivo Log de ZON");
            
            ErrorLineaFichero errorLinea;
            String descripcionError;
            
            if (cantErrores > 0) {
                for (int i = 0; i < cantErrores; i++) {
                    errorLinea = (ErrorLineaFichero) this.lineasConError.get(i);
                    descripcionError = errorLinea.getNroLinea() + "\t" + errorLinea.getDescError();
                    
                    /** Detalle del LOG - con errores */
                    registro.vaciar();
                    // Van los datos de cabecera vacios para evitar error en cantidad de campos
                    registro.anyadirCampo(IRegistroSicc.ZON_NOMBRE_FICHERO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_FECHA_PROCESO, vacio); 
                    registro.anyadirCampo(IRegistroSicc.ZON_PAIS, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_MARCA, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_CANAL, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_TIPO_PERIODO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_PERIODO_INICIO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_FECHA_ACTUALIZACION, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_CREACION_GIS, vacio);
                    
                    registro.anyadirCampo(IRegistroSicc.ZON_DETALLE, descripcionError);
                    gestor.anyadirRegistro(interfaz, registro);
                }
            } else {
                    /** Detalle del LOG - cuando no hay errores */
                    String resultadoProceso = "El proceso finalizó sin errores en las lineas de operacion.";
                    registro.vaciar();
                    // Van los datos de cabecera vacios para evitar error en cantidad de campos
                    registro.anyadirCampo(IRegistroSicc.ZON_NOMBRE_FICHERO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_FECHA_PROCESO, vacio); 
                    registro.anyadirCampo(IRegistroSicc.ZON_PAIS, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_MARCA, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_CANAL, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_TIPO_PERIODO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_PERIODO_INICIO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_FECHA_ACTUALIZACION, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_CREACION_GIS, vacio);
                    
                    registro.anyadirCampo(IRegistroSicc.ZON_DETALLE, resultadoProceso);
                    gestor.anyadirRegistro(interfaz, registro);
            }
            UtilidadesLog.debug("... el detalle se grabo correctamente en el archivo Log de ZON");
            gestor.enviarInterfaz(interfaz);
            
        } catch (InterfacesException iex) {
            UtilidadesLog.error(iex);
            throw new MareException(iex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException rex) {
            UtilidadesLog.error(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cex) {
            UtilidadesLog.error(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.grabarLogErroresReestructuracion(): Salida");
    }
    
    private SubGerenciaVentaLocal obtenerSubgerencia(String codSubgerencia) throws MareException {
        try {
                Collection colecSgv = (this.getSubGerenciaVentaLocalHome()).findByCodigo(this.marca, this.pais, this.canal, codSubgerencia); 
                SubGerenciaVentaLocal subgerenciaVentaLocal = null;
                int cantSgv = colecSgv.size();
                if (cantSgv == 1) {
                    Iterator iterator = colecSgv.iterator();
                    subgerenciaVentaLocal = (SubGerenciaVentaLocal) iterator.next();
                    Long oidSGV = subgerenciaVentaLocal.getOidSubgVenta();
                    UtilidadesLog.debug("*** SGV - El oidSGV es_" + oidSGV);
                    return subgerenciaVentaLocal;
                } else {
                    UtilidadesLog.debug("*** SGV - Se encontraron_" + cantSgv + " Subgerencias con el codigo ingresado.");
                    throw new MareException("No se encontró la Subgerencia", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error("*** SGV - Error en el findByCodigo al buscar la subgerencia ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    }
    
    private RegionLocal obtenerRegion(String codRegion, Long oidSubgerencia) throws MareException {
        try {
                Collection colecReg = (this.getRegionLocalHome()).findByCodigo(oidSubgerencia, codRegion);
                RegionLocal regionLocal = null;
                int cantReg = colecReg.size();
                if (cantReg == 1) {
                    Iterator iterator = colecReg.iterator();
                    regionLocal = (RegionLocal) iterator.next();
                    Long oidRegion = regionLocal.getOid();
                    UtilidadesLog.debug("*** REGION - El oidRegion es_" + oidRegion);
                    return regionLocal;
                } else {
                    UtilidadesLog.debug("*** REGION - Se encontraron_" + cantReg + " Regiones con el codigo ingresado.");
                    throw new MareException("No se encontró la Region", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error("*** REGION - Error en el findByCodigo al buscar la region ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    }
    
    private ZonaLocal obtenerZona(String codZona, Long oidRegion) throws MareException {
        try {
            Collection colecZon = (this.getZonaLocalHome()).findByCodigo(oidRegion, codZona);
            ZonaLocal zonaLocal = null;
            int cantZon = colecZon.size();
            if (cantZon == 1) {
                Iterator iterator = colecZon.iterator();
                zonaLocal = (ZonaLocal) iterator.next();
                Long oidZona = zonaLocal.getOid();
                UtilidadesLog.debug("*** ZONA - El oidZona es_" + oidZona);
                return zonaLocal;
            } else { 
                UtilidadesLog.debug("*** ZONA - Se encontraron_" + cantZon + " Zonas con el codigo ingresado.");
                    throw new MareException("No se encontró la Zona", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        } catch (NoResultException e) {
            UtilidadesLog.error("*** ZONA - Error en el findByCodigo al buscar la zona ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private SeccionLocal obtenerSeccion(String codSeccion, Long oidZona) throws MareException {
        try {
                Collection colecSecc = (this.getSeccionLocalHome()).findByCodigo(this.pais, this.marca, this.canal, oidZona, codSeccion);
                SeccionLocal seccionLocal = null;
                int cantSecc = colecSecc.size();
                if (cantSecc == 1) {
                    Iterator iterator = colecSecc.iterator();
                    seccionLocal = (SeccionLocal) iterator.next();
                    Long oidSeccion = seccionLocal.getOid();
                    UtilidadesLog.debug("*** SECCION - El oidSeccion es_" + oidSeccion);
                    return seccionLocal;
                } else { 
                    UtilidadesLog.debug("*** SECCION - Se encontraron_" + cantSecc + " Secciones con el codigo ingresado.");
                    throw new MareException("No se encontró la Seccion", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error("*** SECCION - Error en el findByCodigo al buscar la seccion ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    }
    
    private TerritorioLocal obtenerTerritorio(String codTerritorio) throws MareException {
        try {
                UtilidadesLog.debug("Buscando Territorio con codTerritorio_"+ codTerritorio +"_ y oidPais_"+ this.pais + "_");
                Collection colecTerr = (this.getTerritorioLocalHome()).findByCodigoPais(new Long(codTerritorio), this.pais);
                TerritorioLocal territorioLocal = null;
                int cantTerr = colecTerr.size();
                if (cantTerr == 1) { 
                    Iterator iterator = colecTerr.iterator();
                    territorioLocal = (TerritorioLocal) iterator.next();
                    Long oidTerritorio = territorioLocal.getOid();
                    UtilidadesLog.debug("*** TERRITORIO - El oidTerritorio es_" + oidTerritorio);
                    return territorioLocal;
                } else { 
                    UtilidadesLog.debug("*** TERRITORIO - Se encontraron_" + cantTerr + " Territorios con el codigo ingresado.");
                    throw new MareException("No se encontró el Territorio", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error("*** TERRITORIO - Error en el findByCodigo al buscar el territorio ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    }
    /* INC BELC300024021 gPineda 06/06/2006
     * 
     * */
    private boolean actualizarCodigosUAModificados ( DTORezonificacionRegistro registro )
    {
      UtilidadesLog.info("actualizarCodigosUAModificados ( DTORezonificacionRegistro registro ) : Entrada");
      String codigoTruncado1 = null;
      String codigoTruncado2 = null;
      String codigoTruncadoNuevo = null;
    
      DatoRegistro datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1(), registro.getNse1(), registro.getNse2());
      DatoRegistro datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2(), registro.getNse1(), registro.getNse2());
      
      codigoTruncado1 = datoRegistro1.obtenerCodigoHastaVariacion( datoRegistro2 );
      codigoTruncado2 = datoRegistro2.obtenerCodigoHastaVariacion( datoRegistro1 );
      if( codigoTruncado1 == null || codigoTruncado2 == null) 
      {
        UtilidadesLog.error("actualizarCodigosUAModificados ( DTORezonificacionRegistro registro ) : Salida (false)");
        return false;
      }
      
      registro.setDatoOrigen1( codigoTruncado1 );
      registro.setDatoOrigen2( codigoTruncado2 );
      
      if( registro.getTipoOp().equalsIgnoreCase(ConstantesZON.TIPO_OPERACION_FUSION) ) {
          DatoRegistro datoNuevo = new DatoRegistro(registro.getDatoNuevo(), registro.getNse1(), registro.getNse2());
          codigoTruncadoNuevo = datoNuevo.obtenerCodigoHastaVariacion( datoRegistro1 );
          if( codigoTruncadoNuevo == null ) 
          {
            UtilidadesLog.error("actualizarCodigosUAModificados ( DTORezonificacionRegistro registro ) : Salida (false)");
            return false;
          }
          
          registro.setDatoNuevo( codigoTruncadoNuevo );
      }
      
      UtilidadesLog.info("actualizarCodigosUAModificados ( DTORezonificacionRegistro registro ) : Salida (true)");
      return true;
    }

    private HashMap obtenerValoresFichero() {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerValoresFichero(): Entrada");
        
        HashMap mapValores = new HashMap();
        
        mapValores.put("pais", this.pais); 
        mapValores.put("marca", this.marca);
        mapValores.put("canal", this.canal); 
        mapValores.put("periodo", this.periodo); 
        mapValores.put("periodoFin", this.periodoFin); 
        mapValores.put("periodoRezonificacion", this.periodoRezonificacion); 
        
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerValoresFichero(): Salida");
        
        return mapValores;
    }

    private void ponerValoresFichero(HashMap mapValores) {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.ponerValoresFichero(HashMap mapValores): Entrada");
        
        this.pais = (Long)mapValores.get("pais");
        this.marca = (Long)mapValores.get("marca"); 
        this.canal = (Long)mapValores.get("canal"); 
        this.periodo = (Long)mapValores.get("periodo"); 
        this.periodoFin = (Long)mapValores.get("periodoFin"); 
        this.periodoRezonificacion = (Long)mapValores.get("periodoRezonificacion"); 
       
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.ponerValoresFichero(HashMap mapValores): Entrada");
    }

    private MONReterritorializacionLocalHome getReterritorializacionLocalHome() throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.getReterritorializacionLocalHome(): Entrada");
        MONReterritorializacionLocalHome reterritorioLocalHome = (MONReterritorializacionLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MONReterritorializacion");
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.getReterritorializacionLocalHome(): Salida");
        return reterritorioLocalHome;
    }
 
    private void guardarClienteTrasvase(ArrayList clientes, Long oidTerritorioAnt, Long oidTerritorioNuevo) throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarClienteTrasvase(ArrayList clientes, Long regionOrigen, Long regionDestino, Long oidTerritorioAnt, Long oidTerritorioNuevo): Entrada");    
        MONReterritorializacionLocal reterritorioLocal = null;

        try {
            reterritorioLocal = this.getReterritorializacionLocalHome().create();
        } catch (CreateException cex) {
            UtilidadesLog.error(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("clientes :" + clientes);
        UtilidadesLog.info("oidTerritorioAnt :" + oidTerritorioAnt);
        UtilidadesLog.info("oidTerritorioNuevo :" + oidTerritorioNuevo);
        UtilidadesLog.info("this.regionOrigen :" + this.regionOrigen);
        UtilidadesLog.info("this.regionDestino :" + this.regionDestino);
        UtilidadesLog.info("this.periodoRezonificacion :" + this.periodoRezonificacion);
        UtilidadesLog.info("this.periodoFin :" + this.periodoFin);

        //llamamos para que actualicen las unidades administrativas y el estatus del cliente
        reterritorioLocal.actualizarClientesUnidadesAdminyStatus(clientes, this.pais, this.marca, this.canal, this.periodoRezonificacion, 
                          this.periodoFin, this.regionOrigen, this.regionDestino, oidTerritorioAnt, oidTerritorioNuevo);        
                          
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.guardarClienteTrasvase(ArrayList clientes, Long regionOrigen, Long regionDestino, Long oidTerritorioAnt, Long oidTerritorioNuevo): Entrada");        
    }
 
    private MONReestructuracionPrimeraFaseLocalHome getReestructuracionPrimeraFaseLocalHome() throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.getReestructuracionPrimeraFaseLocalHome(): Entrada");
        MONReestructuracionPrimeraFaseLocalHome reestructuracionLocalHome = (MONReestructuracionPrimeraFaseLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MONReestructuracionPrimeraFase");
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.getReestructuracionPrimeraFaseLocalHome(): Salida");
        return reestructuracionLocalHome;
    }
 
    private void realizarOperacionTransaccion(DTORezonificacionRegistro registro) throws MareException {
        MONReestructuracionPrimeraFaseLocal reestructuracionLocal = null;

        try {
            reestructuracionLocal = this.getReestructuracionPrimeraFaseLocalHome().create();
        } catch (CreateException cex) {
            UtilidadesLog.error(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        reestructuracionLocal.realizarOperacion(registro, obtenerValoresFichero());        
    }

    private Long obtenerTipoCierrePeriodo() throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.obtenerTipoCierrePeriodo(): Entrada");

        TiposCierreLocalHome tiposCierreLH = this.getTiposCierreLocalHome();
        TiposCierreLocal tiposCierreL = null;
        Collection colTiposCierre = null;
        
        try {
            colTiposCierre = tiposCierreLH.findAll();
        } catch(NoResultException fe) {
            throw new MareException(fe, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        Iterator iterator = colTiposCierre.iterator();
        
        while (iterator.hasNext()) {
            tiposCierreL = (TiposCierreLocal)iterator.next();
            
            if (tiposCierreL.getCodigo().equals(ConstantesFAC.TIPO_CIERRE_PERIODO)) {
                break;
            }
        }

        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.cargarTiposCierreFacturacion(): Salida");                            
        return tiposCierreL.getOid();        
    }
    
    private void validarCierrePeriodoFin() throws MareException {
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.validarCierrePeriodo(): Entrada");    
        DAOFACCierreFacturacion daoFACCierre = new DAOFACCierreFacturacion();
        
        DTOFACCierreFacturacion dtoe = new DTOFACCierreFacturacion();
        dtoe.setOidPais(this.pais);
        dtoe.setCanal(this.canal);
        dtoe.setMarca(this.marca);
        dtoe.setCodigoTipoCierre(ConstantesFAC.TIPO_CIERRE_PERIODO);
        dtoe.setTipoCierre(this.obtenerTipoCierrePeriodo());            
        dtoe.setPeriodo(this.periodoFin);
        
        Integer cierreProcesos = daoFACCierre.obtenerNumeroControlCierres(dtoe);
        if(cierreProcesos.intValue()>0) {  //si periodoFin ha cerrado
            this.indActivoTrasvaseAnt = new Long(0);
            this.indBorradoTrasvaseAnt = new Long(1);
            this.indActivoTrasvaseNueva = new Long(1);
            this.indBorradoTrasvaseNueva = new Long(0);
        } else {
            this.indActivoTrasvaseAnt = new Long(1);
            this.indBorradoTrasvaseAnt = new Long(0);
            this.indActivoTrasvaseNueva = new Long(0);
            this.indBorradoTrasvaseNueva = new Long(1);
        }
        
        UtilidadesLog.debug("this.indActivoTrasvaseAnt: " + this.indActivoTrasvaseAnt);
        UtilidadesLog.debug("this.indBorradoTrasvaseAnt: " + this.indBorradoTrasvaseAnt);
        UtilidadesLog.debug("this.indActivoTrasvaseNueva: " + this.indActivoTrasvaseNueva);
        UtilidadesLog.debug("this.indBorradoTrasvaseNueva: " + this.indBorradoTrasvaseNueva);
                
        UtilidadesLog.info("MONReestructuracionPrimeraFaseBean.validarCierrePeriodo(): Salida");
    }
    
    private MarcaLocalHome getMarcaLocalHome() {
        return new MarcaLocalHome();
    }           
    
    private CanalLocalHome getCanalLocalHome() {
        return new CanalLocalHome();
    }   
    
    private PaisLocalHome getPaisLocalHome() {
        return new PaisLocalHome();
    }

    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
        return new PeriodoCorporativoLocalHome();
    }    
    
    private PeriodoLocalHome getPeriodoLocalHome() {
        return new PeriodoLocalHome();
    }

    private SubGerenciaVentaLocalHome getSubGerenciaVentaLocalHome() {
        return new SubGerenciaVentaLocalHome();
    }

    private ClienteUnidadAdministrativaLocalHome getClienteUnidadAdministrativaLocalHome() {
        return new ClienteUnidadAdministrativaLocalHome();
    }

    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }
    
    private HistoricoZonasLocalHome getHistoricoZonasLocalHome() {
        return new HistoricoZonasLocalHome();
    } 
    




    private TerritorioAdministrativoLocalHome getTerritorioAdministrativoLocalHome() {
        return new TerritorioAdministrativoLocalHome();
    } 

    private RegionLocalHome getRegionLocalHome() {
        return new RegionLocalHome();
    } 

    private ZonaLocalHome getZonaLocalHome() {
        return new ZonaLocalHome();
    } 

    private SeccionLocalHome getSeccionLocalHome() {
        return new SeccionLocalHome();
    }

    private TerritorioLocalHome getTerritorioLocalHome() {
       return new TerritorioLocalHome();
    }
    
    private TipoPeriodoCorporativoLocalHome getTipoPeriodoCorporativoLocalHome() {
       return new TipoPeriodoCorporativoLocalHome();
    }

    private TiposCierreLocalHome getTiposCierreLocalHome() {
       return new TiposCierreLocalHome();
    }

       
       
}