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

package es.indra.sicc.logicanegocio.edu;


import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.cal.DTOBuscarCursosReuniones;
import es.indra.sicc.dtos.edu.DTOBusquedaFichaTecnica;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.dtos.edu.DTOCurso;
import es.indra.sicc.dtos.edu.DTODependientesCarga;
import es.indra.sicc.dtos.edu.DTODruidaBusqueda;
import es.indra.sicc.dtos.edu.DTORelacionesCurso;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.entidades.edu.AptasACursosLocal;
import es.indra.sicc.entidades.edu.AptasACursosLocalHome;
import es.indra.sicc.entidades.edu.MatrizCursosLocal;
import es.indra.sicc.entidades.edu.MatrizCursosLocalHome;

import es.indra.sicc.entidades.edu.MatrizCursosExigidosLocal;
import es.indra.sicc.entidades.edu.MatrizCursosExigidosLocalHome;

import es.indra.sicc.logicanegocio.edu.MONPlantillaCurso;
import es.indra.sicc.logicanegocio.edu.MONPlantillaCursoHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.SQLException;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCursosBean implements SessionBean , IEDU {

    private final static String MON_VALIDACION = "MONValidacion";
    private SessionContext ctx;
    private BelcorpService belcorpService = null;
    // Nombres de las tablas y vistas de la BD
    private final static String EDU_MATRI_CURSO = "EDU_MATRI_CURSO";
    private final static String SEG_CANAL = "SEG_CANAL";
    private final static String SEG_MARCA = "SEG_MARCA";
    private final static String EDU_TIPO_CURSO = "EDU_TIPO_CURSO";
    private final static String VCA_SEG_PAIS =  "VCA_SEG_PAIS";
    private final static String VCA_SEG_MARCA = "VCA_SEG_MARCA";
    private final static String VCA_SEG_CANAL = "VCA_SEG_CANAL";	
    private final static String OPE_EDU_CODCURSO="EDUCOD"; //añadido por incidencia 19756

	private final static int ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE = 5;

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

    private Boolean validaAccesoVinculos(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio, boolean vinculos) throws RemoteException, MareException {
		UtilidadesLog.info("  MONcursos.validaAccesoVinculos(pais, marca, canal, acceso, subgerencia, region, zona, seccion, territorio): Entrada");
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);

        //Valida que el usuario tenga acceso al Pais, Marca y Canal que se pasan
        //como parametro.		
		UtilidadesLog.debug("****Llamada a validaAcceso(pais= "+ pais+", marca="+marca+", canal= "+canal+", acceso="+acceso+", subgerencia="+subgerencia+", region="+region+", zona="+zona+", seccion="+seccion+", territorio="+territorio);
		b = monValidacion.validarAccesos( pais, null, marca, canal, acceso, null, subgerencia, region, zona, seccion, territorio);
		UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());
		if (!b.booleanValue()){				
			ctx.setRollbackOnly();
			UtilidadesLog.error("**** validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
		}

		if(b.booleanValue() && vinculos){
			UtilidadesLog.debug("**** Llamada a validaVinculos(pais= "+ pais + ", marca= "+marca + ", canal= " + canal + ", acceso= "+ acceso+ ")");
			b = monValidacion.validarVinculos( pais, null, marca, canal, acceso, null);
			UtilidadesLog.debug("**** Retorno validaAccesoVinculos:  " + b.toString());
			if (!b.booleanValue()){				
				ctx.setRollbackOnly();			
				UtilidadesLog.error("**** validaAccesoVinculos: validarVinculos : ERROR_VINCULOS_INVALIDOS");
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULOS_INVALIDOS) );
			} 
			
		}
		UtilidadesLog.info("  MONcursos.validaAccesoVinculos(pais, marca, canal, acceso, subgerencia, region, zona, seccion, territorio): Salida");
		return b;

   }


    private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("  MONCursos.getMONValidacion(): Entrada");				
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            MON_VALIDACION, MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONValidacion",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("  MONCursos.getMONValidacion(): Salida");				
        return ejb;
	}



    /** 
     * Método para obtener los registros de la tabla EDU_MATRI_CURSO que cumplen 
     * los criterios de busqueda determinados en el parámetro de entrada
     * @param dto DTOConsultaCurso con los criterios de busqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneCursos(DTOConsultaCurso dto) throws MareException {
        
		    UtilidadesLog.info("  MONCursos.obtieneCursos(DTOConsultaCUrsos): Entrada");				
        belcorpService = UtilidadesEJB.getBelcorpService();
        // Se obtienen los parámetros del DTO
        Integer codigoCurso = dto.getCodigo();
        String nombreCurso = dto.getNombre();
        Long canal = dto.getCanal();
        Long marca = dto.getMarca();
        Long tipoCurso = dto.getTipoCurso();
        Long idioma = dto.getOidIdioma();
        // Parametros de la consulta
        Vector parametros = new Vector();        
        // Se indica la consulta SQL. 
        StringBuffer consulta = new StringBuffer();

        consulta.append("SELECT MC.OID_CURS OID, TC.COD_TIPO_CURS,");
		// Subselect para obtener la descripcion del tipo de curso
        consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        consulta.append(" IDIO.attr_enti = '"+EDU_TIPO_CURSO+"' AND IDIO.idio_oid_idio = ? AND ");
        consulta.append(" IDIO.val_oid = MC.TICU_OID_TIPO_CURS ) AS DES_TIPO_CURS, ");
        parametros.add(idioma);

		consulta.append(" MC.CPLC_OID_CABE_PLAN_CURS, MC.COD_CURS, ");

		// Subselect para obtener el nombre del curso
        consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        consulta.append(" IDIO.attr_enti = '"+EDU_MATRI_CURSO+"' AND IDIO.idio_oid_idio = ? AND ");
        consulta.append(" IDIO.val_oid = MC.OID_CURS ) AS NOMBRE_CURSO, ");
        parametros.add(idioma);

        // Subselect para obtener la descripcion de la marca
        consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = '"+SEG_MARCA+"' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = MC.MARC_OID_MARC ) AS DES_MARC, ");
        parametros.add(idioma);

        // Subselect para obtener la descripcion del canal
        consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = '"+SEG_CANAL+"' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = MC.CANA_OID_CANA ) AS DES_CANAL ");
        parametros.add(idioma);
        consulta.append(" FROM EDU_MATRI_CURSO MC LEFT JOIN EDU_TIPO_CURSO TC ON(MC.TICU_OID_TIPO_CURS = TC.OID_TIPO_CURS),"+VCA_SEG_CANAL+" VCA_CANAL,"+VCA_SEG_PAIS+" VCA_PAIS ,"+VCA_SEG_MARCA+" VCA_MARCA WHERE ");
		consulta.append(" MC.CANA_OID_CANA=VCA_CANAL.OID_CANA ");
		consulta.append(" AND MC.MARC_OID_MARC=VCA_MARCA.OID_MARC");
		consulta.append(" AND MC.PAIS_OID_PAIS=VCA_PAIS.OID_PAIS");
		consulta.append(" AND VCA_PAIS.COD_USUA=VCA_CANAL.COD_USUA ");
		consulta.append(" AND VCA_CANAL.COD_USUA=VCA_MARCA.COD_USUA ");
		consulta.append(" AND VCA_MARCA.COD_USUA= ?");
		parametros.add(getUsuario());
	
        if (codigoCurso != null) {
            consulta.append(" AND MC.COD_CURS = ? ");
            parametros.add(codigoCurso);
        }
		
        if (nombreCurso != null) {
            consulta.append(" AND EXISTS (SELECT VAL_I18N FROM GEN_I18N_SICC WHERE VAL_OID = MC.OID_CURS ");
            consulta.append(" AND ATTR_ENTI = '"+EDU_MATRI_CURSO+"' ");
            consulta.append(" AND IDIO_OID_IDIO = ? ");
            consulta.append(" AND VAL_I18N LIKE ? )");
            parametros.add(idioma);
            parametros.add(nombreCurso);
        }
		
        if (canal != null) {
            consulta.append(" AND MC.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }
		
        if (marca != null) {
            consulta.append(" AND MC.MARC_OID_MARC = ? ");
            parametros.add(marca);
        }
		
        if (tipoCurso != null) {
            consulta.append(" AND MC.TICU_OID_TIPO_CURS = ? ");
            parametros.add(tipoCurso);
        }
		        
    	String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
                
        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        String codigoError = null;
        try {
            resultadoQuery = belcorpService.dbService.executePreparedQuery(sql,
                                                                           parametros);
        } catch (Exception e) {
            //GEN-0002		
			UtilidadesLog.error("obtieneCursos: Exception",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        // Si la consulta no devuelve ningun dato
        if (resultadoQuery.esVacio()) {
            //GEN-0007 --> 005
			      UtilidadesLog.debug("****obtieneCursos: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        // Se devuelve un DTOSalida que contiene el resultado de la consulta
        DTOSalida dtoSalida = new DTOSalida(resultadoQuery);

		UtilidadesLog.info("  MONCursos.obtieneCursos(DTOConsultaCUrsos): Salida");				
        return dtoSalida;
    }
    
    /** 
     * Método que obtiene la información para cargar los campos de búsqueda de curso 
     * @param dto DTOBelcorp con los criterios para obtener la informacion
     * @return DTOCargaCursos con la informacion encontrada.
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontro informacion
     */
    public DTOCargaCursos cargaDatosConsulta(DTOBelcorp dto) throws MareException {
      UtilidadesLog.info("  MONCursos.cargaDatosConsulta(DTOBelcorp): Entrada");				

        DTODruidaBusqueda dtoB = new DTODruidaBusqueda();
        dtoB.setOidPais(dto.getOidPais());
        dtoB.setOidIdioma(dto.getOidIdioma());
        
        // Se obtiene el EJB MonUtilidadesBD
        MONUtilidadesBD monUtilidadesBD = this.getMONUtilidadesBD();        
        DTOCargaCursos dtoS = new DTOCargaCursos();
        try {
            dtoS.setMarcas(monUtilidadesBD.obtieneMarcas(dtoB).getResultado());
            dtoS.setCanales(monUtilidadesBD.obtieneCanales(dtoB).getResultado());
        } catch (RemoteException re) {
			UtilidadesLog.error("cargaDatosConsulta: RemoteException",re);
            throw new MareException(re);
        }
		UtilidadesLog.info("  MONCursos.cargaDatosConsulta(DTOBelcorp): Salida");				
        
        return dtoS;
    }
    
    /** 
     * Método que obtiene la información de un curso 
     * @param dto DTOOID con el oid del curso
     * @return DTOCargaCursos con la informacion encontrada.
     * @exception MareException si no se pudo acceder a la base de datos o no 
     * existe el curso
     * 
     * @ssaavedr Se modifica segun modelo: SICC-DMCO-EDU-GCC-008 - 29/11/2005
     * 
     * @CHANGELOG 
     * 2005.11.17 GMIOTTI DT Se reemplaza la Entidad MatrizCursosRecibidos por la Entidadad 
     * MatrizCursosTiposExigidos
     * 
     */
    public DTOCargaCursos obtieneDetallesCurso(DTOOID dto) throws MareException {
        UtilidadesLog.info("  MONCursos.obtieneDetallesCurso(DTOOID): Entrada");				
        MatrizCursosLocalHome localHome = this.getMatrizCursosLocalHome();
        MatrizCursosLocal local = null;
        String codigoError = null;
        belcorpService = UtilidadesEJB.getBelcorpService();
        try {
            local = localHome.findByPrimaryKey(dto.getOid());
        } catch (FinderException fe) {
            //GEN-0007 no existe -->		
            UtilidadesLog.error("obtieneDetallesCurso: FinderException",fe);
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }
        
        // Se rellenan los campos del DTO con la información obtenida de la 
        // entidad
        UtilidadesLog.debug(
        "<<<<<< Se rellenan los campos del DTO con la información obtenida de la entidad ");
        DTOCurso dtoCurso = new DTOCurso();
        UtilidadesLog.debug("local.getOid() = " + local.getOid());
        dtoCurso.setOid(local.getOid());
        dtoCurso.setCodigo(local.getCodigo());
        dtoCurso.setAccesoDataMart(local.isAccesoDataMart());
        dtoCurso.setObjetivo(local.getObjetivo());
        dtoCurso.setContenido(local.getContenido());
        dtoCurso.setFechaDisponible(local.getFechaDisponible());
        dtoCurso.setFechaLanzamiento(local.getFechaLanzamiento());
        dtoCurso.setFechaFin(local.getFechaFin());
        dtoCurso.setAlcance(local.isAlcance());
        dtoCurso.setNumeroParticipantes(local.getNumeroParticipantes());
        dtoCurso.setBloqueoExtemporaneas(local.isBloqueoExtemporaneas());
        dtoCurso.setRelacionMaterial(local.getRelacionMaterial());
        dtoCurso.setNumeroOrdenes(local.getNumeroOrdenes());
        dtoCurso.setMontoVentas(local.getMontoVentas());
        dtoCurso.setNumeroCampanyas(local.getNumeroCampanyas());
        dtoCurso.setFechaUltimo(local.getFechaUltimo());
        dtoCurso.setFechaConcreta(local.getFechaConcreta());
        dtoCurso.setNumeroUnidades(local.getNumeroUnidades());
        dtoCurso.setCondicionPedido(local.isCondicionPedido());
        dtoCurso.setControlMorosidad(local.isControlMorosidad());
        dtoCurso.setFechaIngreso(local.getFechaIngreso());
        dtoCurso.setDescripcion(local.getDescripcion());
        
        // Se rellenan las relaciones del curso
        DTORelacionesCurso dtoRelaciones = new DTORelacionesCurso();
        UtilidadesLog.debug("local.getTipo()=" + local.getTipo());
        dtoRelaciones.setOidTipoCurso(local.getTipo());
        dtoRelaciones.setOidMarca(local.getMarca());
        dtoRelaciones.setOidCanal(local.getCanal());
        dtoRelaciones.setOidAcceso(local.getAcceso());
        dtoRelaciones.setOidClasificacion(local.getClasificacion());
        dtoRelaciones.setOidTipoClasificacion(local.getTipoClasificacion());
        dtoRelaciones.setOidTipoCliente(local.getTipoCliente());
        dtoRelaciones.setOidSubtipoCliente(local.getSubtipoCliente());
        dtoRelaciones.setOidCapacitador(local.getCapacitador());
        dtoRelaciones.setOidClienteCapacitador(local.getClienteCapacitador());                       // + MAE-015
        dtoRelaciones.setOidFrecuencia(local.getFrecuencia());
        dtoRelaciones.setOidPais(local.getPais());
        dtoRelaciones.setOidPeriodoFinComparativo(local.getPeriodoFinComparativo());
        dtoRelaciones.setOidPeriodoIniComparativo(local.getPeriodoIniComparativo());
        dtoRelaciones.setOidPeriodoIngreso(local.getPeriodoIngreso());
        dtoRelaciones.setOidPeriodoIniConstancia(local.getPeriodoIniConstancia());
        dtoRelaciones.setOidPeriodoFinConstancia(local.getPeriodoFinConstancia());
        dtoRelaciones.setOidPlantilla(local.getPlantilla());
        dtoRelaciones.setOidRegalo(local.getRegalo());
        dtoRelaciones.setOidSubgerencia(local.getSubgerencia());
        dtoRelaciones.setOidRegion(local.getRegion());
        dtoRelaciones.setOidZona(local.getZona());
        dtoRelaciones.setOidTerritorio(local.getTerritorio());
        dtoRelaciones.setOidSeccion(local.getSeccion());
        dtoRelaciones.setOidStatusCliente(local.getStatusCliente());
        dtoRelaciones.setOidMomentoEntrega(local.getMomentoEntrega());
        dtoRelaciones.setOidSubtipoClienteCapacitador(local.getSubtipoClienteCapacitador());        // + MAE-015
        dtoRelaciones.setOidTipoClasificacionCapacitador(local.getTipoClasificacionCapacitador());  // + MAE-015
        
        /* Agrega MAE-015 ver con DT la posibilidad de reubicar esto mediante DAO */
        /* Para el oidClienteCapacitador se obtiene su código y se lo inserta en codClienteCapacitador, 
         * con el oidSubtipoClienteCapacitador se obtiene su descripción internacionalizable y se la 
         * asigna a descSubtipoClienteCapacitador */
        if (local.getClienteCapacitador() != null && local.getSubtipoClienteCapacitador() != null) {
            UtilidadesLog.debug("... buscando datos del capacitador");
            RecordSet datosCapacitador = null;
            StringBuffer query = new StringBuffer();
            try {
                query.append(" SELECT COD_CLIE, ");
                query.append("        DESC_SUBTIPO  ");
                query.append("   FROM ( SELECT mae.COD_CLIE ");
                query.append("            FROM MAE_CLIEN mae ");
                query.append("           WHERE mae.OID_CLIE = " + local.getClienteCapacitador() + " ),  ");
                query.append("        ( SELECT i1.VAL_I18N DESC_SUBTIPO ");
                query.append("            FROM MAE_SUBTI_CLIEN sbt, ");
                query.append("                 GEN_I18N_SICC_COMUN i1 ");
                query.append("           WHERE sbt.OID_SUBT_CLIE = " + local.getSubtipoClienteCapacitador());
                query.append("             AND i1.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
                query.append("             AND i1.ATTR_NUM_ATRI = 1 ");
                query.append("             AND i1.IDIO_OID_IDIO = " + dto.getOidIdioma());
                query.append("             AND i1.VAL_OID = sbt.OID_SUBT_CLIE ) ");
                        
                datosCapacitador = belcorpService.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("RecorsSet datosCapacitador_" + datosCapacitador);
            } catch (Exception e) {
			          UtilidadesLog.error("Exception al buscar datos del capacitador",e);
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        
            // Si la consulta devuelve algun dato
            if (!datosCapacitador.esVacio()) {
                UtilidadesLog.debug("... se encontraron datos del capacitador");
                dtoRelaciones.setCodClienteCapacitador((String)datosCapacitador.getValueAt(0, 0));
                dtoRelaciones.setDescSubtipoClienteCapacitador((String)datosCapacitador.getValueAt(0, 1));
            }
        }
        /* Fin Agrega MAE-015 */
        
        
        dtoCurso.setRelacion(dtoRelaciones);
        
        // Se obtienen los OIDs de los cursos requeridos, mediante una consulta por 
        // DBService, y se asignan al DTO
        dtoCurso.setCursosExigidos(this.obtieneTiposCursosRequeridos(dto));
        
        DTODruidaBusqueda dtoB = new DTODruidaBusqueda();
        dtoB.setOidPais(dto.getOidPais());
        dtoB.setOidIdioma(dto.getOidIdioma());
        
        // Se obtiene el EJB MonUtilidadesBD
        MONUtilidadesBD monUtilidadesBD = this.getMONUtilidadesBD();

		    //Se instancia un objeto DTOOID y se encapsula el valor 
		    //dtoCurso.relacion.oidPlantilla en él
		    DTOOID dtoOid = new DTOOID();
		    dtoOid.setOidPais(dto.getOidPais());
		    dtoOid.setOidIdioma(dto.getOidIdioma());
		    dtoOid.setOid(dtoCurso.getRelacion().getOidPlantilla());
			
		    //Se llama a MONPlantillaCurso.obtieneDetallesPlantilla con ese DTOOID
        UtilidadesLog.debug("<<<<<< Se llama a MONPlantillaCurso.obtieneDetallesPlantilla con ese DTOOID ");
		    MONPlantillaCurso monPlantillaCurso = this.getMONPlantillaCurso();
		
		    DTOCargaCursos dtoS = null;
		    try {
			      dtoS = monPlantillaCurso.obtieneDetallesPlantilla(dtoOid);	
		    } catch (Exception e) {
			      UtilidadesLog.error("obtieneDetallesCurso: Exception al obtener Detalles de Plantilla",e);
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        try {
        try {
            dtoS.setCursos(monUtilidadesBD.obtieneCursos(dtoB).getResultado());
        } catch (MareException me) {		
            if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // GEN-0007 no hay datos
                UtilidadesLog.error("obtieneDetallesCurso: MareException",me);
                throw me;
				    } else {
                UtilidadesLog.debug("**** obtieneDetallesCurso: no hay Cursos ");				
            }
        }
        dtoS.setMarcas(monUtilidadesBD.obtieneMarcas(dtoB).getResultado());
        dtoS.setCanales(monUtilidadesBD.obtieneCanales(dtoB).getResultado());
        try {
            dtoS.setRegalos(monUtilidadesBD.obtieneRegalos(dtoB).getResultado());
        } catch (MareException me) {								
            if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // GEN-0007 no hay datos
                UtilidadesLog.error("obtieneDetallesCurso: MareException",me);
                throw me;
            } else {
                UtilidadesLog.debug("**** obtieneDetallesCurso: no hay Regalos");
            }
        }
        try {
            dtoS.setTiposCliente(monUtilidadesBD.obtieneTiposCliente(dtoB).getResultado());
        } catch (MareException me) {
            if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // GEN-0007 no hay datos
                UtilidadesLog.error("obtieneDetallesCurso: MareException",me);
                throw me;
            } else {
                UtilidadesLog.debug("**** obtieneDetallesCurso: no hay Clientes ");				
            }
        }
			  try {
            dtoS.setFrecuenciasCursos(
            monUtilidadesBD.obtieneFrecuenciasCurso(dtoB).getResultado());
        } catch (MareException me) {
            if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // GEN-0007 no hay datos
                UtilidadesLog.error("**** obtieneDetallesCurso: MareException",me);
                throw me;
            } else {
                UtilidadesLog.debug("**** obtieneDetallesCurso: no hay Frecuencias");				
            }
        }
        try {
            dtoS.setParametros(monUtilidadesBD.obtieneParametros(dtoB).getResultado());
        } catch (MareException me) {
            if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // GEN-0007 no hay datos
                UtilidadesLog.error("obtieneDetallesCurso: MareException",me);
                throw me;
            } else {
                UtilidadesLog.debug("**** obtieneDetallesCurso: no hay Parametros");				
            }
        }
        try {
            dtoS.setStatusClientes(monUtilidadesBD.obtieneStatusClientes(dtoB).getResultado());
        } catch (MareException me) {
            if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // GEN-0007 no hay datos
                UtilidadesLog.error("obtieneDetallesCurso: MareException",me);
                throw me;
            } else {
                UtilidadesLog.debug("**** obtieneDetallesCurso: No hay Estatus de Cliente");				
            }
        }
        try {
            dtoS.setMomentoEntrega(monUtilidadesBD.obtieneMomentoEntrega(dtoB).getResultado());
        } catch (MareException me) {
            if (me.getCode() != ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE){ // GEN-0007 no hay datos
                UtilidadesLog.error("obtieneDetallesCurso: MareException",me);
                throw me;
            } else {
                UtilidadesLog.debug("**** obtieneDetallesCurso: No hay Momentos de Entrega");				
            }
        }
        } catch (RemoteException re) {	
            UtilidadesLog.error("obtieneDetallesCurso: RemoteException",re);
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        
        //nombre attritraducible
        RecordSet respuesta = null;
        try {
            Vector parametros = new Vector();
            StringBuffer consulta = new StringBuffer();
            // Subselect para obtener el nombre del curso
            consulta.append(" SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
            consulta.append(" IDIO.attr_enti = '"+EDU_MATRI_CURSO+"' AND IDIO.idio_oid_idio = ? AND ");
            consulta.append(" IDIO.val_oid = ? ");
            parametros.add(dto.getOidIdioma());
            parametros.add(dtoCurso.getOid());
            respuesta = belcorpService.dbService.executePreparedQuery(consulta.toString(),
                                                                           parametros);
        } catch (Exception e) {
            // Gen-002			
            UtilidadesLog.error("obtieneDetallesCurso: Exception al obtener Nombre i18n del curso",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        // Si la consulta devuelve algun dato
        if (!respuesta.esVacio()) {
            dtoCurso.setNombre((String)respuesta.getValueAt(0, 0));
        }
        
        dtoS.setCurso(dtoCurso);
        dtoS.setOidPais(dto.getOidPais());
        dtoS.setOidIdioma(dto.getOidIdioma());
        
        //obtiene dependientes
        DTODependientesCarga dependientes;
        try {
            dependientes = monUtilidadesBD.obtieneDependientes(dtoS);
            UtilidadesLog.debug(" setDependientes(dependientes) ");
            dtoS.setDependientes(dependientes);
        } catch (RemoteException e) {
            UtilidadesLog.error("obtieneDetallesCurso: Remote al obtieneDependientes",e);
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        /* Agrega MAE-015 Guardo el oid a seleccionar del combo cbCapacitador que
           corresponde al curso */
        //  Los datos del capacitador guardados en EDU_MATRI_CURSO son:
        Long oidClienteCapacitador = local.getClienteCapacitador();
        Long oidSubtipoClienteCapacitador = local.getSubtipoClienteCapacitador();
        Long oidTipoClasificacionCapacitador = local.getTipoClasificacionCapacitador();
        UtilidadesLog.debug("Datos del curso: oidClienteCapacitador_"           + oidClienteCapacitador);
        UtilidadesLog.debug("                 oidSubtipoClienteCapacitador_"    + oidSubtipoClienteCapacitador);
        UtilidadesLog.debug("                 oidTipoClasificacionCapacitador_" + oidTipoClasificacionCapacitador);
        
        Long oidCbCapacitador = null;  // Este es el oid que lleva el combo de capacitador (es la clasificacion)
        
        if (oidClienteCapacitador != null && oidSubtipoClienteCapacitador != null 
                && oidTipoClasificacionCapacitador != null ) {
            //  Los datos de las opciones del combo Capacitador obtenidos son:
            RecordSet capacitadores = dependientes.getCapacitadores();
            UtilidadesLog.debug("------- dependientes.capacitadores_" + capacitadores);
            int cantCapacitadores = 0;
            Vector fila;
            
            if (capacitadores != null) {
                cantCapacitadores = capacitadores.getRowCount();
            }
            
            Long oidFilaCombo;
            Long oidClienteFilaCombo;
            Long oidSubtipoFilaCombo;
            Long oidTipoClasiFilaCombo;
            
            for (int i = 0; i < cantCapacitadores; i++) {
                fila = capacitadores.getRow(i);
                oidFilaCombo          = (Long)fila.elementAt(0);
                oidClienteFilaCombo   = (Long)fila.elementAt(2);
                oidSubtipoFilaCombo   = (Long)fila.elementAt(3);
                oidTipoClasiFilaCombo = (Long)fila.elementAt(4);
                
                UtilidadesLog.debug("--- Fila " + i + " tiene oidClasificacion: " + oidFilaCombo);
                
                // Si coinciden los datos del capacitador del curso con una de las opciones 
                if ( oidClienteCapacitador.equals(oidClienteFilaCombo)
                        && oidSubtipoClienteCapacitador.equals(oidSubtipoFilaCombo)
                        && oidTipoClasificacionCapacitador.equals(oidTipoClasiFilaCombo) ) {
                    // He encontrado la opcion que debe pre-seleccionarse del combo
                    UtilidadesLog.debug("... el oid que debe seleccionarse de cbCapacitador es_" + oidFilaCombo);
                    oidCbCapacitador = oidFilaCombo;   // Guardo el oid de la fila que debera seleccionarse
                    break;
                }
            }
        }
        dtoCurso.getRelacion().setOidCapacitador(oidCbCapacitador);
        dtoS.setCurso(dtoCurso);
        /* Fin Agrega MAE-015 Guardo el oid a seleccionar del combo cbCapacitador */
        
        UtilidadesLog.info("  MONCursos.obtieneDetallesCurso(DTOOID): Salida");				
        return dtoS;
    }
    
    private MONUtilidadesBD getMONUtilidadesBD() throws MareException {
	    UtilidadesLog.info("  MONCursos.getMONUtilidadesBD(): Entrada");				
        // Se obtiene el interfaz home
        MONUtilidadesBDHome home = (MONUtilidadesBDHome)UtilidadesEJB.getHome(
            "MONUtilidadesBD", MONUtilidadesBDHome.class);

        // Se obtiene el interfaz remoto
        MONUtilidadesBD ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {		
			UtilidadesLog.error("getMONUtilidadesBD: Exception",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        // Se devuelve el interfaz remoto
		    UtilidadesLog.info("  MONCursos.getMONUtilidadesBD(): Salida");				
        return ejb;
    }

	private MONPlantillaCurso getMONPlantillaCurso() throws MareException {
	    UtilidadesLog.info("  MONCursos.getMONPlantillaCurso(): Entrada");				
        // Se obtiene el interfaz home
        MONPlantillaCursoHome home = (MONPlantillaCursoHome)UtilidadesEJB.getHome(
            "MONPlantillaCurso", MONPlantillaCursoHome.class);

        // Se obtiene el interfaz remoto
        MONPlantillaCurso ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {			
			UtilidadesLog.error("getMONPlantillaCurso: Exception",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("  MONCursos.getMONPlantillaCurso(): Salida");				
        // Se devuelve el interfaz remoto
        return ejb;
    }
    
    /*
     * @CHANGELOG 
       2005.11.17 GMIOTTI DT Se reemplaza la Entidad MatrizCursosRecibidos por la Entidadad 
       MatrizCursosTiposExigidos
     */
    private Long[] obtieneTiposCursosRequeridos(DTOOID dto) throws MareException {

		    UtilidadesLog.info("  MONCursos.obtieneTiposCursosRequeridos(DTOOID): Entrada");				
        belcorpService = UtilidadesEJB.getBelcorpService();        
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT TICU_OID_TIPO_CURS FROM EDU_MATRI_CURSO_EXIGI ");
        consulta.append("WHERE MCUR_OID_CURS = ? ");       
        Vector parametros = new Vector();
        parametros.add(dto.getOid());
		consulta.append(" ORDER BY TICU_OID_TIPO_CURS");
		
        // Se ejecuta la consulta
        RecordSet recordset = null;
        try {
            recordset = belcorpService.dbService.executePreparedQuery(consulta.toString(),
                                                                           parametros);
        } catch (Exception e) {
            //GEN-0002			
			UtilidadesLog.error("obtieneTiposCursosRequeridos: Exception",e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        // Se almacenan los oids obtenidos en un array
        Long resultado[] = null;
        if (!recordset.esVacio()) {
             Vector      valores    = recordset.getColumn(recordset.getColumnPosition("TICU_OID_TIPO_CURS"));
            
            //int numFilas = recordset.getRowCount();
            resultado = new Long[valores.size()];
            
            for (int i=0; i < valores.size(); i++) {
                resultado[i] = new Long(((BigDecimal)valores.get(i)).longValue());
            }   
        } 
		    UtilidadesLog.info("  MONCursos.obtieneTiposCursosRequeridos(DTOOID): Salida");				
        return resultado;
    }


    /** 
     * Método para insertar un registro en la tabla EDU_MATRI_CURSO y sus registros relacionados
     * @param dto DTOCurso con los datos necesarios para la inserción
     * @exception MareException si no se pudo acceder a la base de datos, si PK repetida o
	 * si hay error de integridad 
     * 
     * @ssaavedr Se modifica segun modelo: SICC-DMCO-EDU-GCC-008 - 30/11/2005
     * 
     * @CHANGELOG 
     * 
     * 2005.11.17 GMIOTTI DT Se reemplaza la Entidad MatrizCursosRecibidos por la Entidadad 
     * MatrizCursosTiposExigidos
     */
    public void insertaCurso(DTOCurso dto) throws MareException {
	
		UtilidadesLog.info("  MONCursos.insertaCurso(DTOCurso): Entrada");				
		String codigoError = null;
		try {
			DTORelacionesCurso dtoRelaciones=dto.getRelacion();
			//validar acceso
	        if( this.validaAccesoVinculos(dtoRelaciones.getOidPais(), 
                dtoRelaciones.getOidMarca(), dtoRelaciones.getOidCanal(), 
                dtoRelaciones.getOidAcceso(), dtoRelaciones.getOidSubgerencia(), 
                dtoRelaciones.getOidRegion(), dtoRelaciones.getOidZona(), 
                dtoRelaciones.getOidSeccion(), dtoRelaciones.getOidTerritorio(), 
                true).booleanValue() ){
				UtilidadesLog.debug("**** insertarCurso: Acceso concedido");
			}

            /*
             * a.- EJB MatrizCursos: se crea un registro con la información del dto. Salvo el oid que es autonumérico y el código que también lo es. Para las relaciones (oidMarca, oidCanal, ...) la información se encuentra en dto.relacion. 
            */
            
            //añadido por incidencia 19756
            DTONumeroSolicitud dtoSoli = new DTONumeroSolicitud();
            dtoSoli.setOidPais(dto.getOidPais()); 
            dtoSoli.setOperacion(OPE_EDU_CODCURSO); 
            MONProcesosPED monProcesosPED = this.getMONProcesosPED();
            String codigoCurso=null;
            codigoCurso = monProcesosPED.generaSecuenciaDocumento(dtoSoli); 
            //comprobamos que no se supera el limite del curso
            if (new Integer(codigoCurso).intValue() > 999)
            {
                UtilidadesLog.debug ("Se ha superado el tamaño máximo del codigo del curso");
                throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                ConstantesSEG.MODULO_EDU,ErroresNegocio.EDU_1003));
            }

        
            MatrizCursosLocalHome mcLH = this.getMatrizCursosLocalHome();
            MatrizCursosLocal  mcL = null;

            //mcL =  mcLH.create(dtoRelaciones.getOidPais(), dtoRelaciones.getOidPlantilla(), dto.getCodigo(), dtoRelaciones.getOidCanal(), dtoRelaciones.getOidMarca(), dtoRelaciones.getOidAcceso());
			//mcL.setContenido("Contenido curso 8");
            mcL =  mcLH.create(dtoRelaciones.getOidPais(), dtoRelaciones.getOidPlantilla(), 
                dtoRelaciones.getOidCanal(), dtoRelaciones.getOidMarca(), 
                dtoRelaciones.getOidAcceso(),
				      dtoRelaciones.getOidTerritorio(),
	            dtoRelaciones.getOidClasificacion(),
	            dtoRelaciones.getOidFrecuencia(),
	            dtoRelaciones.getOidRegalo(),
	            dtoRelaciones.getOidSubgerencia(),
	            dtoRelaciones.getOidRegion(),
	            dtoRelaciones.getOidZona(),
	            dtoRelaciones.getOidSeccion(),
	            dtoRelaciones.getOidPeriodoIniComparativo(),
	            dtoRelaciones.getOidPeriodoFinComparativo(),
	            dtoRelaciones.getOidPeriodoIniConstancia(),
	            dtoRelaciones.getOidPeriodoFinConstancia(),
	            dtoRelaciones.getOidPeriodoIngreso(),
	            dtoRelaciones.getOidTipoCurso(),
	            dto.getObjetivo(),
	            dto.getContenido(),
	            dto.getRelacionMaterial(),
	            dto.getMontoVentas(),
	            dto.getFechaDisponible(),
	            dto.getFechaLanzamiento(),
	            dto.getFechaFin(),
	            dto.getFechaUltimo(),
	            dto.getFechaConcreta(),
	            dto.getFechaIngreso(),
	            dto.getNumeroParticipantes(),
	            dto.getNumeroOrdenes(),
	            dto.getNumeroCampanyas(),
	            dto.getNumeroUnidades(),
	            dto.getDescripcion(),
	            dto.getAccesoDataMart(),
	            dto.getAlcance(),
	            dto.getBloqueoExtemporaneas(),
	            dtoRelaciones.getOidMomentoEntrega(),
	            dto.getCondicionPedido(),
	            dto.getControlMorosidad(),
	            dtoRelaciones.getOidClienteCapacitador(),    // Antes de MAE-015: dtoRelaciones.getOidCapacitador(),
	            dtoRelaciones.getOidSubtipoCliente(),
	            dtoRelaciones.getOidTipoClasificacion(),
	            dtoRelaciones.getOidStatusCliente(),
	            dtoRelaciones.getOidTipoCliente(),
 	            Boolean.valueOf(false), 
              new Integer(codigoCurso),
              dtoRelaciones.getOidSubtipoClienteCapacitador(),
              dtoRelaciones.getOidTipoClasificacionCapacitador());
              
              UtilidadesLog.debug("Se inserto en MatrizCurso BMP con los siguientes datos del capacitador:"); 
              UtilidadesLog.debug("oidCliente_" + dtoRelaciones.getOidClienteCapacitador() + " / SubtipoClien_"
                                    + dtoRelaciones.getOidSubtipoClienteCapacitador() + " / TipoClasificacion_"
                                    + dtoRelaciones.getOidTipoClasificacionCapacitador() );
            /*
             * b.- EJB MatrizCursosRecibidos: se crea un registro por cada elemento incluído en la lista dto.cursosRecibidos con la siguiente información: 
             * oid autogenerado 
             *- curso = dto.oid 
             *- cursoRequerido = dto.cursosRecibidos[i]
             */
            if(dto.getCursosExigidos() != null && dto.getCursosExigidos().length>0) {

                //@ssaavedr Se reemplaza la Entidad MatrizCursosRecibidos por la Entidadad MatrizCursosTiposExigidos            
                //MatrizCursosRecibidosLocalHome mcrLH = this.getMatrizCursosRecibidosLocalHome();
                //MatrizCursosRecibidosLocal  mcrL = null;            
                
                UtilidadesLog.info("  SCS voy a: this.getMatrizCursosExigidosLocalHome()");
                
                MatrizCursosExigidosLocalHome mceLH = null;
                    mceLH = new MatrizCursosExigidosLocalHome();               
                    
                MatrizCursosExigidosLocal mceL = null;
                
                for (int i = 0; i < dto.getCursosExigidos().length; i++){
                    UtilidadesLog.info("  SCS creando entrada en: MatrizCursosExigidos, con: " + 
                    mcL.getOid() + " - " + dto.getCursosExigidos()[i]);
                    mceL =  mceLH.create(mcL.getOid(), dto.getCursosExigidos()[i]);
                 }
            }

            
            //c.- Para cada DTO del vector dto.attriTraducible se debe hacer una llamada al método "create" del Entity Bean: "Entidadi18n". El oid es del registro de MatrizCursos afectado (paso a).
            Entidadi18nLocalHome eiLH = new Entidadi18nLocalHome();
            Entidadi18nLocal  eiL = null;
            DTOI18nSICC dtoTrad[]=dto.getAttriTraducible();
            for (int i = 0; i <dtoTrad.length ; i++){
                eiL =  eiLH.create(EDU_MATRI_CURSO, dtoTrad[i].getOidAtriuto(), 
                dtoTrad[i].getOidIdioma(), dtoTrad[i].getValorI18n(), mcL.getOid());
            }

      } catch (EntityExistsException de) {
		//clave duplicada GEN-0001
		UtilidadesLog.error("insertarCurso: DuplicateKeyException" ,de);
        ctx.setRollbackOnly();
        codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
        throw new MareException(de, UtilidadesError.armarCodigoError(codigoError));
      } catch (CreateException ce) {
		UtilidadesLog.error("insertarCurso: CreateException" ,ce);
        //integridad  GEN-0003
        ctx.setRollbackOnly();
        codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
      } catch (PersistenceException ce) {
		UtilidadesLog.error("insertarCurso: CreateException" ,ce);
        //integridad  GEN-0003
        ctx.setRollbackOnly();
        codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
      }catch (RemoteException re) {  
		UtilidadesLog.error("insertarCurso: RemoteException",re);
        //integridad  GEN-0003
        ctx.setRollbackOnly();
        codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
      } catch (EJBException e) {	  	  
		UtilidadesLog.error("insertarCurso: EJBException" ,e);
        //acceso a base de datos GEN-0002
        ctx.setRollbackOnly();
		throw new MareException(e,UtilidadesError.armarCodigoError(this.obtenerErrorSql(e,
        "insertar")));

      }
		  UtilidadesLog.info("  MONCursos.insertaCurso(DTOCurso): Salida");				
    }

    /** 
     * Método para modificar un registro en la tabla EDU_MATRI_CURSO y sus registros relacionados
     * @param dto DTOCurso con los nuevos datos del registro
     * @exception MareException si no se pudo acceder a la base de datos, si PK repetida o
	 * si hay error de integridad 
     * 
     * @ssaavedr Se modifica segun modelo: SICC-DMCO-EDU-GCC-008 - 30/11/2005
     * 
     * @CHANGELOG 
     * 
     * 2005.11.17 GMIOTTI DT Se reemplaza la Entidad MatrizCursosRecibidos por la Entidadad 
     * MatrizCursosTiposExigidos
     * 
     */
    public void modificaCurso(DTOCurso dto) throws MareException {
    
		UtilidadesLog.info("  MONCursos.modificaCurso(DTOCurso): Entrada");				
		String codigoError = null;

		try {
			DTORelacionesCurso dtoRelaciones=dto.getRelacion();
			//validar acceso
	        if(this.validaAccesoVinculos(dtoRelaciones.getOidPais(), 
                dtoRelaciones.getOidMarca(), dtoRelaciones.getOidCanal(), 
                dtoRelaciones.getOidAcceso(), dtoRelaciones.getOidSubgerencia(), 
                dtoRelaciones.getOidRegion(), dtoRelaciones.getOidZona(), 
                dtoRelaciones.getOidSeccion(), dtoRelaciones.getOidTerritorio(), 
                true).booleanValue() ){
				UtilidadesLog.debug("**** modificaCurso: Acceso concedido");
			}
            /*
             * a.- EJB MatrizCursos: EJB MatrizCursos: se modifica el registro indicado por dto.oid con la información del dto, salvo el codigo y el oid. Para las relaciones (oidMarca, oidCanal, ...) la información se encuentra en dto.relacion
            */
            MatrizCursosLocalHome mcLH = this.getMatrizCursosLocalHome();
            MatrizCursosLocal  mcL = null;
            mcL =  mcLH.findByPrimaryKey(dto.getOid());
            //Asignar campos nullable
            mcL.setAcceso(dtoRelaciones.getOidAcceso());
            mcL.setAccesoDataMart(dto.getAccesoDataMart());
            mcL.setAlcance(dto.getAlcance());
            mcL.setBloqueoExtemporaneas(dto.getBloqueoExtemporaneas());
            mcL.setCanal(dtoRelaciones.getOidCanal());
            mcL.setCapacitador(dtoRelaciones.getOidCapacitador());
            mcL.setClienteCapacitador(dtoRelaciones.getOidClienteCapacitador());                     // + MAE-015
            mcL.setSubtipoClienteCapacitador(dtoRelaciones.getOidSubtipoClienteCapacitador());       // + MAE-015
            mcL.setTipoClasificacionCapacitador(dtoRelaciones.getOidTipoClasificacionCapacitador()); // + MAE-015
            mcL.setClasificacion(dtoRelaciones.getOidClasificacion());
            mcL.setCondicionPedido(dto.getCondicionPedido());
            mcL.setContenido(dto.getContenido());
            mcL.setControlMorosidad(dto.getControlMorosidad());
            mcL.setDescripcion(dto.getDescripcion());
            mcL.setFechaConcreta(dto.getFechaConcreta());
            mcL.setFechaDisponible(dto.getFechaDisponible());
            mcL.setFechaFin(dto.getFechaFin());
            mcL.setFechaIngreso(dto.getFechaIngreso());
            mcL.setFechaLanzamiento(dto.getFechaLanzamiento());
            mcL.setFechaUltimo(dto.getFechaUltimo());
            mcL.setFrecuencia(dtoRelaciones.getOidFrecuencia());
            mcL.setMarca(dtoRelaciones.getOidMarca());
            mcL.setMomentoEntrega(dtoRelaciones.getOidMomentoEntrega());
            mcL.setMontoVentas(dto.getMontoVentas());
            mcL.setNumeroCampanyas(dto.getNumeroCampanyas());
            mcL.setNumeroOrdenes(dto.getNumeroOrdenes());
            mcL.setNumeroParticipantes(dto.getNumeroParticipantes());
            mcL.setNumeroUnidades(dto.getNumeroUnidades());
            mcL.setObjetivo(dto.getObjetivo());
            mcL.setPais(dtoRelaciones.getOidPais());
            mcL.setPeriodoFinComparativo(dtoRelaciones.getOidPeriodoFinComparativo());
            mcL.setPeriodoFinConstancia(dtoRelaciones.getOidPeriodoFinConstancia());
            mcL.setPeriodoIngreso(dtoRelaciones.getOidPeriodoIngreso());
            mcL.setPeriodoIniComparativo(dtoRelaciones.getOidPeriodoIniComparativo());
            mcL.setPeriodoIniConstancia(dtoRelaciones.getOidPeriodoIniConstancia());
            mcL.setPlantilla(dtoRelaciones.getOidPlantilla()); //ojo
            mcL.setRegalo(dtoRelaciones.getOidRegalo());
            mcL.setRegion(dtoRelaciones.getOidRegion());
            mcL.setRelacionMaterial(dto.getRelacionMaterial());
            mcL.setSeccion(dtoRelaciones.getOidSeccion());
            mcL.setStatusCliente(dtoRelaciones.getOidStatusCliente());
            mcL.setSubgerencia(dtoRelaciones.getOidSubgerencia());
            mcL.setSubtipoCliente(dtoRelaciones.getOidSubtipoCliente());
            mcL.setTerritorio(dtoRelaciones.getOidTerritorio());
            mcL.setTipo(dtoRelaciones.getOidTipoCurso());
            mcL.setTipoClasificacion(dtoRelaciones.getOidTipoClasificacion());
            mcL.setTipoCliente(dtoRelaciones.getOidTipoCliente());
            mcL.setZona(dtoRelaciones.getOidZona());
			try {
				mcL.modifica();
			} catch (DuplicateKeyException dke) {	
				UtilidadesLog.error("modificarCurso: DuplicateKeyException",dke);
				//clave duplicada GEN-0001
				ctx.setRollbackOnly();
				codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
				throw new MareException(dke, UtilidadesError.armarCodigoError(codigoError));
			} catch (CreateException ce) { 		
				UtilidadesLog.error("modificarCurso: CreateException" ,ce);
	            //integridad gen-005
	            ctx.setRollbackOnly();
	            codigoError = CodigosError.ERROR_INTEGRIDAD_ACTUALIZAR;
	            throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
			} catch (EJBException ejbe) {
				UtilidadesLog.error("modificarCurso: EJBException",ejbe);
	            //acceso gen-002
				codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
				UtilidadesLog.info("****Error: Ni  ORA-00001 ni ORA-02291");
				UtilidadesLog.error("**** modificarCurso: EJBException",ejbe);	  										
           		ctx.setRollbackOnly();
	            throw new MareException(new Exception(), 
                UtilidadesError.armarCodigoError(codigoError));
			}
            /*
             * 2.- MatrizCursosRecibidos: 

             * 2.1.- Se eliminan a través de DBService TODOS los registros de MatrizCursosRecibidos cuyo campo curso sea igual a dto.oid. 
             * 2.2.- Se crea a través del EJB entity MatrizCursosRecibidos un registro por cada elemento incluído en la lista dto.cursosRecibidos con la siguiente información: 
             * - oid autogenerado 
             * - curso = dto.oid 
             * - cursoRequerido = dto.cursosRecibidos[i] 
             */
             
            //@ssaavedr Se reemplaza la Entidad MatrizCursosRecibidos por la Entidadad MatrizCursosTiposExigidos            
			//MatrizCursosRecibidosLocalHome mcrLH = this.getMatrizCursosRecibidosLocalHome();
			//MatrizCursosRecibidosLocal  mcrL = null;
            
            MatrizCursosExigidosLocalHome mceLH = null;
                mceLH = new MatrizCursosExigidosLocalHome();
                
            MatrizCursosExigidosLocal mceL = null;
            
            Collection myColeccionCursosRecibidos=null;
            
            try  {
                    myColeccionCursosRecibidos=mceLH.findByCurso(dto.getOid());	
            } catch (NoResultException finder)  {
                    UtilidadesLog.debug("**** modificaCurso: No tiene cursos Recibidos");					
            } 
            if(myColeccionCursosRecibidos!=null){
                    Iterator myIteratorCursosRecibidos=myColeccionCursosRecibidos.iterator();
                    while(myIteratorCursosRecibidos.hasNext()){
                            mceL=(MatrizCursosExigidosLocal)myIteratorCursosRecibidos.next();					
                            mceLH.remove(mceL);
                    }
            }													
           // Borrar todos los registros encontrads
            if(dto.getCursosExigidos() != null && dto.getCursosExigidos().length>0) {
                mceLH = new MatrizCursosExigidosLocalHome();
                
                mceL = null;            
                for (int i = 0; i < dto.getCursosExigidos().length; i++){
                    mceL =  mceLH.create(mcL.getOid(), dto.getCursosExigidos()[i]);
               }
            }

            /* 
             * 3.- Para cada DTO del vector dto.attriTraducible se debe hacer una llamada a los métodos "find..." y "set..."del Entity Bean: "Entidadi18n".
             * El oid es del registro de MatrizCursos afectado (paso 1).
             */
			 // Modificado por fmunoz - Se eliminan todas las traducciones y se insertan de nuevo
			
			 this.eliminaTraducciones(mcL.getOid());
			 Entidadi18nLocalHome eiLH = new Entidadi18nLocalHome();
             Entidadi18nLocal  eiL = null;
             DTOI18nSICC dtoTrad[]=dto.getAttriTraducible();
             for (int i = 0; i <dtoTrad.length ; i++){
                eiL =  eiLH.create(EDU_MATRI_CURSO, dtoTrad[i].getOidAtriuto(), 
                                   dtoTrad[i].getOidIdioma(), dtoTrad[i].getValorI18n(), 
                                   mcL.getOid());
             }	
			 
        } catch (EntityExistsException dke) {	
			UtilidadesLog.error("modificarCurso: DuplicateKeyException",dke);
            //clave duplicada GEN-0001
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
            throw new MareException(dke, UtilidadesError.armarCodigoError(codigoError));
         } catch (NoResultException fe) {	 
			UtilidadesLog.error("modificarCurso: FinderException",fe);
            //no se encontro gen-007? -->005
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        } catch (FinderException fe) {        
                           UtilidadesLog.error("modificarCurso: FinderException",fe);
               //no se encontro gen-007? -->005
               ctx.setRollbackOnly();
               codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException ce) { 		
			UtilidadesLog.error("modificarCurso: CreateException" ,ce);
            //integridad gen-005
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
        }/* catch (CreateException ce) {             
                UtilidadesLog.error("modificarCurso: CreateException" ,ce);
                //integridad gen-005
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));

        }*/ catch (RemoteException re) {
			UtilidadesLog.error("modificarCurso: RemoteException" ,re);
	        ctx.setRollbackOnly();
	        codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
	        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
      } catch (EJBException ejbe) {
			UtilidadesLog.error("modificarCurso: EJBException",ejbe);
            //acceso gen-002
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			UtilidadesLog.info("**** falloSQL: " + falloSQL);
			if (falloSQL.indexOf("ORA-00001") != -1) {
				UtilidadesLog.info("****Error: ORA-00001");
				UtilidadesLog.error("modificarCurso: EJBException",ejbe);	  			
				codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
           		ctx.setRollbackOnly();

				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
			} else if (falloSQL.indexOf("ORA-02291") != -1) {
				UtilidadesLog.info("****Error: ORA-02291");
				UtilidadesLog.error("modificarCurso: EJBException",ejbe);	  						
				codigoError = CodigosError.ERROR_INTEGRIDAD_ACTUALIZAR;
           		ctx.setRollbackOnly();
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
			} else {
				codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
				UtilidadesLog.info("****Error: Ni  ORA-00001 ni ORA-02291");
				UtilidadesLog.error("**** modificarCurso: EJBException",ejbe);	  										
           		ctx.setRollbackOnly();
	            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
			}
      }

		UtilidadesLog.info("  MONCursos.modificaCurso(DTOCurso): Salida");				
    }

    /** 
     * Método para eliminar cursos de la tabla EDU_MATRI_CURSO
     * @param dto DTOOIDs con los oids de los registros a eliminar
     * @exception MareException si no se pudo acceder a la base de datos,
	 * si hay error de integridad o si no se encontró ningún elemento a eliminar 
     */
    public void eliminaCurso(DTOOIDs dto) throws MareException {
    
		UtilidadesLog.info("  MONCursos.eliminaCurso(DTOOIDs): Entrada");				
        Long oids[] = dto.getOids();
        //Vector vOids = new Vector();
        String codigoError = null;

        // Haciendo uso del DBService se eliminan todos los registros de MatrizCursos identificados por cada uno de los oids de la lista dto.oids        
        if(oids !=null && oids.length>0) {
            try {
                MatrizCursosLocalHome mcLH = this.getMatrizCursosLocalHome();
                MatrizCursosLocal  mcL = null;
               // Eliminar Cursos
                for (int i = 0; i <oids.length; i++) {
                    mcL=mcLH.findByPrimaryKey(oids[i]);
					//validar acceso: Si hay uno que no tiene acceso, hace rollback y lanza una 
					//MareException, por lo que no se borra ninguno
					if(this.validaAccesoVinculos( mcL.getPais(), mcL.getMarca(), mcL.getCanal(), mcL.getAcceso(), mcL.getSubgerencia(), mcL.getRegion(), mcL.getZona(), mcL.getSeccion(), mcL.getTerritorio(), false).booleanValue() ){
						UtilidadesLog.debug("**** eliminaCurso: Acceso concedido");					
					}
					//mcL.remove();
					mcL.elimina();
					this.eliminaTraducciones(oids[i]);					
                }//FOR DE ELIMINAR CURSOS

            } catch (FinderException fe) {		
				UtilidadesLog.error("eliminarCurso: FinderException", fe);
                //no se encontro gen-006
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_ELIMINAR_NO_EXISTE;
				throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            } catch (RemoveException re) {
				UtilidadesLog.error("eliminarCurso: RemoveException" ,re);
                //integridad gen-004
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
           } catch (RemoteException re) {
				UtilidadesLog.error("eliminarCurso: RemoteException" ,re);
				//integridad  GEN-0003
				ctx.setRollbackOnly();
				codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
				throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
			} catch (EJBException ejbe) {
                //acceso gen-002			
                ctx.setRollbackOnly();
				codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
				UtilidadesLog.error("eliminarCurso: EJBException",ejbe);	  										
				throw new MareException(ejbe, UtilidadesError.armarCodigoError(codigoError));
            }
        }
		UtilidadesLog.info("  MONCursos.eliminaCurso(DTOOIDs): Salida");				
    }


    /** 
     * Método para copiar  un curso de la tabla EDU_MATRI_CURSO
     * @param dto DTOOIDs con los oids de los registros a copiar
     * @return DTOOID con el oid del nuevo registro
     * @exception MareException si no se pudo acceder a la base de datos, si PK repetida,
	 * si hay error de integridad o si no se encontró ningún resultado al consultar 
     */
    public DTOOID copiaCurso(DTOOIDs dto) throws MareException {
		//Se mantiene un array de oids por el diseño original, pero tras una incidencia
		//se acordó que sólo sería un oid, por lo que llegará un array de longitud 1
		UtilidadesLog.info("  MONCursos.copiaCurso(DTOOIDs): Entrada");				
        Long oids[] = dto.getOids();
        //Vector vOids = new Vector();
        String codigoError = null;
		DTOOID resultado = new DTOOID();
        /*
         * Cada oid de la lista incluída en dto.oids identifica a un curso (un registro de MatrizCursos) de este modo lo que se hace es copiar toda la información relacionada con ese registro. El proceso es el siguiente para cada oid: 
         * 1.- El oid identifica un registro de la MatrizCursos que se desea copiar, lo llamaremos mcCursoOrigen. 
         * 2.- Se inserta un nuevo registro en MatrizCursos con el oid generado automáticamente y ese oid lo llamamos mcCursoCopia. 
         * 3.- En la tabla de internacionalización GEN_I18N_SICC se inserta una copia de los registros que apuntaban a MatrizCursos con el oid mcCursoOrigen para un oid mcCursoCopia. 
         * 4.- Se copian exactamente todos los registros de MatrizCursosRecibidos que apuntaban a mcCursoOrigen (es decir cuyo valor del campo curso es igual a mcCursoOrigen) y ahora los nuevos registros insertados apuntan a mcCursoCopia (es decir se insertan n nuevos registros con valor mcCursoCopia para el campo curso). 

         * Todo el proceso se realiza a través de DBService. 
        */
        if(oids !=null && oids.length>0) {
            try {
				MatrizCursosLocalHome mcLH = this.getMatrizCursosLocalHome();
                MatrizCursosLocal  mcCursoOrigen = null;
               // Curso Origen
                for (int i = 0; i <oids.length ; i++) {
                    Long cursoOrigen =oids[i];
                    mcCursoOrigen=mcLH.findByPrimaryKey(cursoOrigen);
					//validar acceso
					if(!(this.validaAccesoVinculos( mcCursoOrigen.getPais(), 
                         mcCursoOrigen.getMarca(), mcCursoOrigen.getCanal(), 
                         mcCursoOrigen.getAcceso(), mcCursoOrigen.getSubgerencia(), 
                         mcCursoOrigen.getRegion(), mcCursoOrigen.getZona(), 
                         mcCursoOrigen.getSeccion(), mcCursoOrigen.getTerritorio(), 
                         true)).booleanValue() ){
						 UtilidadesLog.debug("**** copiaCurso: Acceso denegado");
						 continue;
					}
                    //nuevo registro
                    //añadido por incidencia 19756
                    DTONumeroSolicitud dtoSoli = new DTONumeroSolicitud();
                    dtoSoli.setOidPais(dto.getOidPais()); 
                    dtoSoli.setOperacion(OPE_EDU_CODCURSO); 
                    MONProcesosPED monProcesosPED = this.getMONProcesosPED();
                    String codigoCurso=null;
                    codigoCurso = monProcesosPED.generaSecuenciaDocumento(dtoSoli);
                    //comprobamos que no se supera el limite del curso
                    if (new Integer(codigoCurso).intValue() > 999)
                    {
                        UtilidadesLog.debug (
                        "Se ha superado el tamaño máximo del codigo del curso");
                        throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_EDU,
                        ErroresNegocio.EDU_1003));
                    }
                    
                    MatrizCursosLocal  mcCursoCopia = null;
                    mcCursoCopia=mcLH.create(mcCursoOrigen.getPais(), 
                    mcCursoOrigen.getPlantilla(), mcCursoOrigen.getCanal(), 
                    mcCursoOrigen.getMarca(), mcCursoOrigen.getAcceso(),
                    mcCursoOrigen.getTerritorio(),
                    mcCursoOrigen.getClasificacion(),
                    mcCursoOrigen.getFrecuencia(),
                    mcCursoOrigen.getRegalo(),
                    mcCursoOrigen.getSubgerencia(),
                    mcCursoOrigen.getRegion(),
                    mcCursoOrigen.getZona(),
                    mcCursoOrigen.getSeccion(),
                    mcCursoOrigen.getPeriodoIniComparativo(),
                    mcCursoOrigen.getPeriodoFinComparativo(),
                    mcCursoOrigen.getPeriodoIniConstancia(),
                    mcCursoOrigen.getPeriodoFinConstancia(),
                    mcCursoOrigen.getPeriodoIngreso(),
                    mcCursoOrigen.getTipo(),
                    mcCursoOrigen.getObjetivo(),
                    mcCursoOrigen.getContenido(),
                    mcCursoOrigen.getRelacionMaterial(),
                    mcCursoOrigen.getMontoVentas(),
                    mcCursoOrigen.getFechaDisponible(),
                    mcCursoOrigen.getFechaLanzamiento(),
                    mcCursoOrigen.getFechaFin(),
                    mcCursoOrigen.getFechaUltimo(),
                    mcCursoOrigen.getFechaConcreta(),
                    mcCursoOrigen.getFechaIngreso(),
                    mcCursoOrigen.getNumeroParticipantes(),
                    mcCursoOrigen.getNumeroOrdenes(),
                    mcCursoOrigen.getNumeroCampanyas(),
                    mcCursoOrigen.getNumeroUnidades(),
                    mcCursoOrigen.getDescripcion(),
                    mcCursoOrigen.isAccesoDataMart(),
                    mcCursoOrigen.isAlcance(),
                    mcCursoOrigen.isBloqueoExtemporaneas(),
                    mcCursoOrigen.getMomentoEntrega(),
                    mcCursoOrigen.isCondicionPedido(),
                    mcCursoOrigen.isControlMorosidad(),
                    //mcCursoOrigen.getCapacitador(),
                    mcCursoOrigen.getClienteCapacitador(),
                    mcCursoOrigen.getSubtipoCliente(),
                    mcCursoOrigen.getTipoClasificacion(),
                    mcCursoOrigen.getStatusCliente(),
                    mcCursoOrigen.getTipoCliente(), mcCursoOrigen.isControlFuncion(), 
                    new Integer(codigoCurso),
                    mcCursoOrigen.getSubtipoClienteCapacitador(),
                    mcCursoOrigen.getTipoClasificacionCapacitador());
                    
                    resultado.setOid(mcCursoCopia.getOid());
			
                    RecordSet respuesta;
                    belcorpService = UtilidadesEJB.getBelcorpService();

                    try {
                        // Buscar Cursos Requeridos asociados al curso origen
                        String query =  " SELECT OID_MATR_CURS_RECI FROM EDU_MATRI_CURSO_EXIGI WHERE"+
                        " MCUR_OID_CURS = " + cursoOrigen;
                        respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
                    } catch (Exception e) {
						UtilidadesLog.error("copiarCurso: Exception" ,e);
						ctx.setRollbackOnly();
                        codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                    }

                    if (!respuesta.esVacio()) {
                        //@ssaavedr Se reemplaza la Entidad MatrizCursosRecibidos por la Entidadad MatrizCursosTiposExigidos            
                        
                        //MatrizCursosRecibidosLocalHome mcrLH = this.getMatrizCursosRecibidosLocalHome();
                        //MatrizCursosRecibidosLocal  mcrOrigen = null;
                        
                        MatrizCursosExigidosLocal  mceOrigen = null;
                        
                        MatrizCursosExigidosLocalHome mceLH = null;
                            mceLH = new MatrizCursosExigidosLocalHome();
                        
                        //MatrizCursosExigidosLocal mceL = null;
                    
                       // Añadir los registros para el nuevo curso
                        Vector vector = respuesta.getColumn(respuesta.getColumnPosition("OID_MATR_CURS_RECI"));
                        Enumeration oidsMatrizCursosRecibidos = vector.elements();
                        MatrizCursosExigidosLocal  mceNuevo = null;

                        while (oidsMatrizCursosRecibidos.hasMoreElements()) {
                            mceOrigen = mceLH.findByPrimaryKey(new Long(((BigDecimal) oidsMatrizCursosRecibidos.nextElement()).longValue()));
                            mceNuevo = mceLH.create(mcCursoCopia.getOid(), mceOrigen.getOidCursRequ());
                        }
                    }
            
                    try {
                        //Buscar la internacionalizacion del curso origen
                        String query =  " SELECT OID_I18N FROM GEN_I18N_SICC WHERE ATTR_ENTI = '"+EDU_MATRI_CURSO+"'"+
                        "  AND VAL_OID = " + cursoOrigen;
						
                        respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
                    } catch (Exception e) {				
						UtilidadesLog.error("copiarCurso: Exception" ,e);
						ctx.setRollbackOnly();
                        //acceso gen-002
                        codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                    }

                    if (!respuesta.esVacio()) {
                        Entidadi18nLocalHome eiLH = new Entidadi18nLocalHome();
                        Entidadi18nLocal  eiOrigen = null;
                        // Añadir los registros para el nuevo curso
                        Vector vector = respuesta.getColumn(respuesta.getColumnPosition("OID_I18N"));
                        Enumeration oidsEntidadi18n = vector.elements();

                        Entidadi18nLocal  eiNuevo = null;

                        while (oidsEntidadi18n.hasMoreElements()) {
                            eiOrigen = eiLH.findByPrimaryKey(new Long(((BigDecimal) 
                            oidsEntidadi18n.nextElement()).longValue()));
                            eiNuevo = eiLH.create(EDU_MATRI_CURSO, eiOrigen.getAtributo(), 
                            eiOrigen.getIdioma(), eiOrigen.getDetalle(), mcCursoCopia.getOid());
                        }
                    }
                }
            } catch (DuplicateKeyException de) {
				UtilidadesLog.error("copiarCurso: DuplicateKeyException" ,de);
                //duplicada gen-001
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
                throw new MareException(de, UtilidadesError.armarCodigoError(codigoError));
            } catch (FinderException fe) {
                UtilidadesLog.error("copiarCurso: FinderException" ,fe);
                //no se encontro gen-007 --> 005
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            } catch (NoResultException fe) {
                    UtilidadesLog.error("copiarCurso: FinderException" ,fe);
                    //no se encontro gen-007 --> 005
                    ctx.setRollbackOnly();
                    codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            } catch (CreateException ce) {
				UtilidadesLog.error("copiarCurso: CreateException" ,ce);
                //integridad gen-003
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
            } catch (PersistenceException ce) {
                    UtilidadesLog.error("copiarCurso: CreateException" ,ce);
                    //integridad gen-003
                    ctx.setRollbackOnly();
                    codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
            } catch (RemoteException re) {
				UtilidadesLog.error("copiarCurso: RemoteException" ,re);
				//integridad  GEN-0003
				ctx.setRollbackOnly();
				codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
				throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
			} catch (EJBException ejbe) {		
                //acceso gen-002
                ctx.setRollbackOnly();
				String falloSQL = (ejbe.getCausedByException()).getMessage();
				if (falloSQL.indexOf("ORA-02292") != -1) {
					UtilidadesLog.error("copiarCurso: EJBException",ejbe);	  						
					codigoError = CodigosError.ERROR_INTEGRIDAD_INSERCION;
					throw new MareException(ejbe, UtilidadesError.armarCodigoError(codigoError));
				} else {
					codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
					UtilidadesLog.error("copiarCurso: EJBException",ejbe);	  										
					throw new MareException(ejbe, UtilidadesError.armarCodigoError(codigoError));
				}				
            }
        }
		UtilidadesLog.info("  MONCursos.copiaCurso(DTOOIDs): Salida");				
		return resultado;
    }

    /** para obtener la LocalHome del Entity MatrizCursos */
    private MatrizCursosLocalHome getMatrizCursosLocalHome()
        throws MareException {
		UtilidadesLog.info("  MONCursos.getMatrizCursosLocalHome(): Entrada");				
        MatrizCursosLocalHome matrizCursosLocalHome = (MatrizCursosLocalHome) UtilidadesEJB.getLocalHome(
                    "java:comp/env/ejb/MatrizCursosLocal");
		UtilidadesLog.info("  MONCursos.getMatrizCursosLocalHome(): Salida");				
        return matrizCursosLocalHome;
    }


    private void eliminaTraducciones (Long oid) throws MareException {
		UtilidadesLog.info("  MONCursos.eliminaTraducciones(): Entrada");				
		try {
				Collection myCollectionI18n=null;
				//Eliminamos el registro con el oid 	
				//Obtenemos la interfaz local home de los entity que utilizamos
				Entidadi18nLocalHome  entidadi18nLocalHome = new Entidadi18nLocalHome();
				Entidadi18nLocal entidadi18nLocal = null;
				//Buscamos el seleccionado			
				myCollectionI18n = entidadi18nLocalHome.findByEntPK(EDU_MATRI_CURSO,oid);				
				Iterator myIteratorE18=myCollectionI18n.iterator();
				while(myIteratorE18.hasNext()){
					entidadi18nLocal=(Entidadi18nLocal)myIteratorE18.next();					
					entidadi18nLocalHome.remove(entidadi18nLocal);								
				}                  
		} catch (NoResultException fe) {
				UtilidadesLog.error("eliminaTraducciones: FinderException",fe);			
                //no se encontro gen-006
                ctx.setRollbackOnly();
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));		
		} 
		catch (PersistenceException exception){
            ctx.setRollbackOnly();
			UtilidadesLog.error("eliminaTraducciones: RemoveException",exception);	
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
		catch (Exception exception){
            ctx.setRollbackOnly();
			UtilidadesLog.error("eliminaTraducciones: Exception",exception);	
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		UtilidadesLog.info("  MONCursos.eliminaTraducciones(): Salida");				
    }

	private String getUsuario(){
		UtilidadesLog.info("Método MONCursos.getUsuario(): Entrada"); 
		return ctx.getCallerPrincipal().getName();
	}	
	
	private String obtenerErrorSql(Exception exception,String accion){
			UtilidadesLog.info("Método MONCursos.obtenerErrorSql(): Entrada"); 
			String codigoDevolver=CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.debug("**** obtenerErrorSql, Accion : "+accion);
			SQLException mySqlException=null;
			if(exception instanceof EJBException){
				EJBException ejbException=(EJBException)exception;
				mySqlException=(SQLException)ejbException.getCausedByException();
			}else if(exception instanceof SQLException){
				mySqlException=(SQLException)exception;	
			}
						
			if (mySqlException!=null){
				
				int codigoMensaje=mySqlException.getErrorCode();
				UtilidadesLog.debug("**** obtenerErrorSql, Codigo SQL de la excepcion: "+codigoMensaje);
				if(codigoMensaje==2291){	
					if(accion.equals("insertar")){
						codigoDevolver=CodigosError.ERROR_INTEGRIDAD_INSERCION;
					}else{
						codigoDevolver=CodigosError.ERROR_INTEGRIDAD_ACTUALIZAR;
					}
				}else if(codigoMensaje==2292){ //registro hijo encontrado al borrar
					if(accion.equals("insertar")){
						codigoDevolver=CodigosError.ERROR_INTEGRIDAD_INSERCION;
					}else if(accion.equals("eliminar")){
						codigoDevolver=CodigosError.ERROR_DE_BORRADO_DE_DATOS;
					}else{
						codigoDevolver=CodigosError.ERROR_INTEGRIDAD_ACTUALIZAR;
					}
				}
					
			}
			UtilidadesLog.debug("**** obtenerErrorSql, Codigo Mare Devuelto: "+codigoDevolver);
			UtilidadesLog.info("Método MONCursos.obtenerErrorSql(): Salida"); 
			return codigoDevolver;
	}

	public void aceptaMatriz(DTOOID dtoe) throws MareException {
		/* Aceptación de la matriz de cursos. */
		UtilidadesLog.info("Método MONCursos.aceptaMatriz(DTOOID): Entrada"); 
		this.validaAcceso(dtoe.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		
		AptasACursosLocalHome aptasHome = null;
		AptasACursosLocal aptasLocal = null;
		Collection collection = null;	

		aptasHome = new AptasACursosLocalHome(); 
		Long oid = dtoe.getOid();
		try{
			collection = aptasHome.findByCursoPruebas(oid);
		}catch (NoResultException fe) {
           	UtilidadesLog.error("aceptaMatriz: FinderException",fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
		try{
			if(collection != null){
				Iterator iteratorCursos = collection.iterator();
				while(iteratorCursos.hasNext()){
					aptasLocal = (AptasACursosLocal)iteratorCursos.next();					
					aptasHome.remove(aptasLocal);
				}
			}
		}catch (PersistenceException re){
                    UtilidadesLog.error("aceptaMatriz: RemoveException",re);	
                    throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
		MatrizCursosLocalHome matrizCursosHome = null;
		MatrizCursosLocal matrizCursosLocal = null;

		matrizCursosHome = this.getMatrizCursosLocalHome();
		try{
			matrizCursosLocal = matrizCursosHome.findByPrimaryKey(oid);
			matrizCursosLocal.setControlFuncion(obtieneBoolean(ConstantesCMN.VAL_TRUE)); 
			matrizCursosLocal.modifica();
		}catch (FinderException fe) {
           	UtilidadesLog.error("aceptaMatriz: FinderException",fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
		catch (DuplicateKeyException fe) {
           	UtilidadesLog.error("aceptaMatriz: DuplicateKeyException",fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError( CodigosError.ERROR_INTEGRIDAD_ACTUALIZAR));
        }
		catch (CreateException fe) {
           	UtilidadesLog.error("aceptaMatriz: CreateException",fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError( CodigosError.ERROR_INTEGRIDAD_INSERCION));
        }
		UtilidadesLog.info("Método MONCursos.aceptaMatriz(DTOOID): Salida"); 
	}
	
	private Boolean obtieneBoolean(Integer constantes){

		if(constantes.equals(new Integer("0"))){
			return Boolean.FALSE;
		}else{
			if(constantes.equals(new Integer("1"))){
				return Boolean.TRUE;
			}
		}//si no es cero que devuelva true
		return Boolean.TRUE;
		
	}//

	private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, 
        Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)
        throws MareException {
        UtilidadesLog.info("Método MONCursos.validaAcceso(pais, sociedad, marca, canal, acceso, subacceso, subgerenciua, region, zona, seccion, territorio): Entrada"); 

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);

        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais + ",sociedad = " + sociedad +
            ", marca=" + marca + ", canal= " + canal + ", acceso=" + acceso + ",subacceso = "
	        + subacceso +  ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal, acceso,
                    subacceso, subgerencia, region, zona, seccion, territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "**** validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "**** validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("Método MONCursos.validaAcceso(pais, sociedad, marca, canal, acceso, subacceso, subgerenciua, region, zona, seccion, territorio): Salida"); 
    }


    public DTOSalida consultarCursosReuniones(DTOBuscarCursosReuniones dto) throws MareException {
    ////incidencia 12320, incidencia 12556
    //Consulta los cursos que se encuentran en histórico para un cliente determinado.
    UtilidadesLog.info("Método MONCursos.consultarCursosReuniones(DTOBuscarCursosReuniones): Entrada"); 
    DAOCursos dao = new DAOCursos();
    DTOSalida dtoSalida = dao.consultarCursosReuniones(dto);
    UtilidadesLog.info("Método MONCursos.consultarCursosReuniones(DTOBuscarCursosReuniones): Salida"); 
    return dtoSalida;
  }

  public DTOSalida obtenerCursos(DTORelacionesCurso dto) throws MareException{
    UtilidadesLog.info("Método MONCursos.obtenerCursos(DTORelacionesCurso): Entrada"); 
    DAOCursos dao = new DAOCursos();
    UtilidadesLog.info("Método MONCursos.obtenerCursos(DTORelacionesCurso): Salida"); 
    return dao.obtenerCursos(dto);
    
  }

  public DTOSalida obtenerTipoCurso(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("Método MONCursos.obtenerTipoCurso(DTOBelcorp): Entrada"); 
    DAOCursos dao = new DAOCursos();
    UtilidadesLog.info("Método MONCursos.obtenerTipoCurso(DTOBelcorp): Salida"); 
    return dao.obtenerTipoCurso(dto);
    
    
  }

  public DTOSalida obtenerOidPlantilla(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("Método MONCursos.obtenerOidPlantilla(DTOBelcorp): Entrada"); 
    DAOCursos dao = new DAOCursos();
    UtilidadesLog.info("Método MONCursos.obtenerOidPlantilla(DTOBelcorp): Salida"); 
    return dao.obtenerOidPlantilla(dto);
  }

  public DTOSalida buscarFichaTecnica(DTOBusquedaFichaTecnica dto) throws MareException{
    UtilidadesLog.info("Método MONCursos.buscarFichaTecnica(DTOBusquedaFichaTecnica): Entrada"); 
    DAOCursos dao = new DAOCursos();
    UtilidadesLog.info("Método MONCursos.buscarFichaTecnica(DTOBusquedaFichaTecnica): Salida"); 
    return dao.buscarFichaTecnica(dto);
  
  }
  
  private MONProcesosPED getMONProcesosPED() throws MareException {
	    UtilidadesLog.info("Método MONCursos.getMONProcesosPED(): Entrada"); 
        // Se obtiene el interfaz home
        MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome(
            "MONProcesosPED", MONProcesosPEDHome.class);

        // Se obtiene el interfaz remoto
        MONProcesosPED ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {			
			UtilidadesLog.error("getMONProcesosPED: Exception",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("Método MONCursos.getMONProcesosPED(): Salida"); 
        // Se devuelve el interfaz remoto
        return ejb;
    }


}
