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

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.rmi.RemoteException;
import java.util.Vector;
import java.math.BigDecimal;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.dtos.edu.DTODruidaBusqueda;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.dtos.edu.DTODependientesCarga;
import es.indra.sicc.dtos.edu.DTODetallePlantillaCurso;
import es.indra.sicc.dtos.edu.DTORelacionesCurso;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOClasificaciones;

import es.indra.sicc.logicanegocio.mae.ConstantesMAE;

import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;

import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.dtos.cra.DTOPeriodo;

import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativasHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.mae.MONEstatusCliente;
import es.indra.sicc.logicanegocio.mae.MONEstatusClienteHome;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class MONUtilidadesBDBean implements SessionBean {

    private SessionContext ctx = null;
    private BelcorpService belcorpService = null;
    
    // Nombres de las tablas y vistas de la BD
    private final static String V_GEN_I18N_SICC = "V_GEN_I18N_SICC";
    private final static String EDU_FRECU_CURSO = "EDU_FRECU_CURSO";
    private final static String EDU_PARAM = "EDU_PARAM";
    private final static String EDU_TIPO_CURSO = "EDU_TIPO_CURSO";
    private final static String EDU_REGAL = "EDU_REGAL";
    private final static String EDU_MATRI_CURSO = "EDU_MATRI_CURSO";
    private final static String SEG_PAIS = "SEG_PAIS";
    private final static String SEG_MARCA = "SEG_MARCA";
    private final static String SEG_CANAL = "SEG_CANAL";

    private final static String VCA_SEG_PAIS =  "VCA_SEG_PAIS";
    private final static String VCA_SEG_MARCA = "VCA_SEG_MARCA";
    private final static String VCA_SEG_CANAL = "VCA_SEG_CANAL";	
    
    // Nombres de los MONs
    private final static String MON_MANTENIMIENTO_SEG = "MONMantenimientoSEG";
    private final static String MON_UNIDADES_ADMINISTRATIVAS = "MONUnidadesAdministrativas";
    private final static String MON_CONFIGURACION_CLIENTES = "MONConfiguracionClientes";
    private final static String MON_PERIODOS = "MONPeriodos";
    private final static String MON_STATUS_CLIENTES = "MONEstatusCliente";
    
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
    
    /** 
     * Método para obtener todas las frecuencias de cursos
     * @param dto DTODruidaBusqueda con el criterio de idioma
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos
     */
    public DTOSalida obtieneFrecuenciasCurso(DTODruidaBusqueda dto) throws MareException {
		     UtilidadesLog.info(" MONUtilidadesBD.obtieneFrecuenciasCurso(DTODruidaBusqueda): Entrada");
        
        // Se indica la consulta SQL
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT OID_FREC, (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = '"+EDU_FRECU_CURSO+"' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = OID_FREC) AS DES_FREC FROM " + EDU_FRECU_CURSO);
        consulta.append(" ORDER BY DES_FREC");

        Vector parametros = new Vector();
		Long oidIdioma = dto.getOidIdioma();
        parametros.add(oidIdioma);
				
        // Se ejecuta la consulta
        belcorpService = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        try {
            resultado = belcorpService.dbService.executePreparedQuery(consulta.toString(),
                parametros);
        } catch (Exception e) {
			UtilidadesLog.error("obtieneFrecuenciasCurso: Exception",e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /* incidencia BELC300004056
        if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneFrecuenciasCurso(DTODruidaBusqueda): Salida");
        return new DTOSalida(resultado);
    }
    
    /** 
     * Método para obtener todos los parámetros de cursos
     * @param dto DTODruidaBusqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos
     */
    public DTOSalida obtieneParametros(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneParametros(DTODruidaBusqueda): Entrada");

        // Se indica la consulta SQL
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT * FROM " + EDU_PARAM + " ORDER BY 1");

		
        
        // Se ejecuta la consulta
        belcorpService = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        try {
            resultado = belcorpService.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
			UtilidadesLog.error("obtieneParametros: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneParametros(DTODruidaBusqueda): Salida");
        return new DTOSalida(resultado);
    }
    
    /** 
     * Método para obtener todas los tipos de cursos relacionados con una marca determinada 
     * @param dto DTODruidaBusqueda con el criterio de marca e idioma
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneTiposCurso(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneTiposCurso(DTODruidaBusqueda): Entrada");
        
        // Se indica la consulta SQL
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT OID_TIPO_CURS, (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = '"+EDU_TIPO_CURSO+"' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = OID_TIPO_CURS) AS DES_TIPO_CURS "); 
        consulta.append("FROM " + EDU_TIPO_CURSO + ", " + VCA_SEG_MARCA);
        consulta.append(" WHERE ");
        consulta.append("MARC_OID_MARC = OID_MARC ");
        consulta.append(" AND OID_MARC = ? ");
		consulta.append(" AND COD_USUA = ? ");
		consulta.append(" ORDER BY DES_TIPO_CURS");
        
        Vector parametros = new Vector();
		Long oidIdioma = dto.getOidIdioma();
        Long oidMarca = dto.getOidMarca();
        parametros.add(oidIdioma);
        parametros.add(oidMarca);
        parametros.add(getUsuario());
		

        // Se ejecuta la consulta
        belcorpService = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        try {
            resultado = belcorpService.dbService.executePreparedQuery(consulta.toString(),
                parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
			UtilidadesLog.error("obtieneTiposCurso: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        /* incidencia BELC300004056
        if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneTiposCurso(DTODruidaBusqueda): Salida");
        return new DTOSalida(resultado);
    }
    
    /** 
     * Método para obtener todas los regalos de cursos 
     * @param dto DTODruidaBusqueda con el criterio de idioma
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos
     */
    public DTOSalida obtieneRegalos(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneRegalos(DTODruidaBusqueda): Entrada");
          
        // Se indica la consulta SQL
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT OID_REGA, (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = '"+EDU_REGAL+"' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = OID_REGA) AS DES_REGA "); 
        consulta.append("FROM " + EDU_REGAL);
        consulta.append(" ORDER BY DES_REGA");

        Vector parametros = new Vector();
		Long oidIdioma = dto.getOidIdioma();
        parametros.add(oidIdioma);


        // Se ejecuta la consulta
        belcorpService = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        try {
            resultado = belcorpService.dbService.executePreparedQuery(consulta.toString(),
                parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
			UtilidadesLog.error("obtieneRegalos: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        /* incidencia BELC300004056
        if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneRegalos(DTODruidaBusqueda): Salida");
        return new DTOSalida(resultado);
    }
    
    /** 
     * Método para obtener todas los cursos relacionados con un pais,
	 * y opcionalmente con una marca y/o un canal determinados 
     * @param dto DTODruidaBusqueda con el criterio de pais, marca, canal e idioma
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneCursos(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneCursos(DTODruidaBusqueda): Entrada");

        //jrivas 9/3/2006 EDO-08 se cambio toda la query.
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT   OID_TIPO_CURS, ");
        consulta.append("          (SELECT idio.val_i18n ");
        consulta.append("             FROM v_gen_i18n_sicc idio ");
        consulta.append("            WHERE idio.attr_enti = 'EDU_TIPO_CURSO' ");
        consulta.append("              AND idio.idio_oid_idio = " + dto.getOidIdioma());
        consulta.append("              AND idio.val_oid = OID_TIPO_CURS) AS des_curs ");
        consulta.append("     FROM edu_tipo_curso  ");
        consulta.append(" ORDER BY des_curs ");
        
        // Se indica la consulta SQL
        /*StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT OID_CURS, (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = '"+EDU_MATRI_CURSO+"' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = OID_CURS) AS DES_CURS "); 
        consulta.append("FROM " + EDU_MATRI_CURSO + ", " + VCA_SEG_PAIS);

		if (oidMarca != null) {
			consulta.append(", " + VCA_SEG_MARCA);
		}

		if (oidCanal != null) {
			consulta.append(", " + VCA_SEG_CANAL);
		}

        consulta.append(" WHERE ");
        consulta.append("PAIS_OID_PAIS = OID_PAIS ");
        consulta.append(" AND OID_PAIS =  ? ");
		consulta.append(" AND "+ VCA_SEG_PAIS+ ".COD_USUA =  ? ");
		
        Vector parametros = new Vector();
        parametros.add(oidIdioma);
        parametros.add(oidPais);
		parametros.add(getUsuario());
        
        if (oidMarca != null) {
            consulta.append("AND MARC_OID_MARC = OID_MARC ");
            consulta.append("AND OID_MARC = ? ");
			consulta.append(" AND "+ VCA_SEG_MARCA+ ".COD_USUA =  ? ");			
            parametros.add(oidMarca);
			parametros.add(getUsuario());
        }
        
        if (oidCanal != null) {
            consulta.append(" AND CANA_OID_CANA = OID_CANA ");
            consulta.append(" AND OID_CANA = ? ");
			consulta.append(" AND "+ VCA_SEG_CANAL+ ".COD_USUA =  ? ");
            parametros.add(oidCanal);
			parametros.add(getUsuario());
        }
		consulta.append(" ORDER BY DES_CURS");*/


        // Se ejecuta la consulta
        belcorpService = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        try {
            resultado = belcorpService.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
			UtilidadesLog.error("obtieneCursos: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        /* Incidencia 4056
		if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneCursos(DTODruidaBusqueda): Salida");
        return new DTOSalida(resultado);
	}
    
    /** 
     * Método para obtener las marcas
     * @param dto DTODruidaBusqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos
     */
    public DTOSalida obtieneMarcas(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneMarcas(DTODruidaBusqueda): Entrada");

        // Se llama al método recuperarMarcas de SEG
        MONMantenimientoSEG seg = this.getISEG();
		DTOBelcorp dtoB = new DTOBelcorp();
		dtoB.setOidIdioma(dto.getOidIdioma());
		dtoB.setOidPais(dto.getOidPais());

		DTOSalida dtoSalida = null;
        try {
            dtoSalida = seg.recuperarMarcas(dtoB);	
        } catch (MareException e) {
			UtilidadesLog.error("obtieneMarcas: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneMarcas: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        } 
        
        /* incidencia BELC300004056
        if (dtoSalida == null || dtoSalida.getResultado().esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneMarcas(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener los canales
     * @param dto DTODruidaBusqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos
     */
    public DTOSalida obtieneCanales(DTODruidaBusqueda dto) throws MareException {
      UtilidadesLog.info(" MONUtilidadesBD.obtieneCanales(DTODruidaBusqueda): Entrada");

        // Se llama al método recuperarCanales de SEG
        MONMantenimientoSEG seg = this.getISEG();
		DTOBelcorp dtoB = new DTOBelcorp();
		dtoB.setOidIdioma(dto.getOidIdioma());
		dtoB.setOidPais(dto.getOidPais());

		DTOSalida dtoSalida = null;
        try {
            dtoSalida = seg.recuperarCanales(dtoB);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneCanales: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		}  catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneCanales: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }

        /* incidencia BELC300004056
        if (dtoSalida == null || dtoSalida.getResultado().esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneCanales(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener los accesos relacionados con un canal
     * @param dto DTODruidaBusqueda con el criterio de canal e idioma
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneAccesos(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneAccesos(DTODruidaBusqueda): Entrada");

        DTOAccesosPorCanal dtoAccesos = new DTOAccesosPorCanal();
        dtoAccesos.setOidCanal(dto.getOidCanal());
        dtoAccesos.setOidIdioma(dto.getOidIdioma());

        // Se llama al método recuperarAccesosPorCanal de SEG
        MONMantenimientoSEG seg = this.getISEG();
        DTOSalida dtoSalida = null;
        try {
            dtoSalida = seg.recuperarAccesosPorCanal(dtoAccesos);	
        } catch (MareException e) {
			UtilidadesLog.error("obtieneAccesos: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		}  catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneAccesos: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        /* incidencia BELC300004056
        if (dtoSalida == null || dtoSalida.getResultado().esVacio()) {
            throw new MareException("",UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneAccesos(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener los periodos relacionados con un canal y una marca
     * @param dto DTODruidaBusqueda con el criterio de canal y marca
     * @return dto DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtienePeriodos(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtienePeriodos(DTODruidaBusqueda): Entrada");

        DTOPeriodo dtoPeriodo = new DTOPeriodo();
		dtoPeriodo.setPais(dto.getOidPais());
        dtoPeriodo.setCanal(dto.getOidCanal());
        dtoPeriodo.setMarca(dto.getOidMarca());
        
        // Se llama al método obtienePeriodo de CRA
        DAOCRA cra = new DAOCRA();
        DTOSalida dtoSalida = null;
        try {
            dtoSalida = cra.obtienePeriodo(dtoPeriodo);
        } catch (MareException e) {
			UtilidadesLog.error("obtienePeriodos: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} 
        
        /* incidencia BELC300004056
        if (dtoSalida.getResultado().esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtienePeriodos(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener los tipos de clientes
     * @param dto DTODruidaBusqueda
     * @return dto DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos
     */
    public DTOSalida obtieneTiposCliente(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneTiposCliente(DTODruidaBusqueda): Entrada");

        // Se llama al método obtieneTipoSubtipo de MAE
        MONConfiguracionClientes mae = this.getIMAEConfiguracion();
		DTOBelcorp dtoB = new DTOBelcorp();
		dtoB.setOidIdioma(dto.getOidIdioma());
		dtoB.setOidPais(dto.getOidPais());

		DTOTipoSubtipo dtoTipoSubtipo = null;
        try {
            dtoTipoSubtipo = mae.obtenerTipoSubtipo(dtoB);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneTiposCliente: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneTiposCliente: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        RecordSet tipos = new RecordSet();
		if (dtoTipoSubtipo != null) {
			tipos = dtoTipoSubtipo.getTipos();
		}
        /* incidencia BELC300004056
        if (tipos.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneTiposCliente(DTODruidaBusqueda): Salida");
		if (tipos == null) {
			tipos = new RecordSet();
		}
        return new DTOSalida(tipos);
    }
    
    /** 
     * Método para obtener los subtipos de clientes relacionados con un tipo de cliente
     * @param dto DTODruidaBusqueda con el criterio de tipo de cliente
     * @return dto DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneSubtiposCliente(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneSubtiposCliente(DTODruidaBusqueda): Entrada");
		/*
		 * Ver incidencia 4581
		 * 1.- Construye un DTOOID con la siguiente información:
		 * dtoOid.idioma = dto.idioma
		 * dtoOid.pais = dto.pais
		 * dtoOid.oid = dto.oidTipoCliente
		 * 2.- Llama aI IConfiguracionClientes.obtenerSubTipos(dtoOid) y devuelve el DTOSalida obtenido.
		 */
        // Se llama al método obtieneTipoSubtipo de MAE
        MONConfiguracionClientes mae = this.getIMAEConfiguracion();
        /* 
		DTOTipoSubtipo dtoTipoSubtipo = null;
		DTOBelcorp dtoB = new DTOBelcorp();
		dtoB.setOidIdioma(dto.getOidIdioma());
		dtoB.setOidPais(dto.getOidPais());
        try {
            //dtoTipoSubtipo = mae.obtenerTipoSubtipo((DTOBelcorp)dto);
            dtoTipoSubtipo = mae.obtenerTipoSubtipo(dtoB);
        } catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneSubtiposCliente: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }

        RecordSet subTiposOrigen = dtoTipoSubtipo.getSubtipos();
        RecordSet subTiposFinal = new RecordSet();
        Long oidTipoCliente = dto.getOidTipoCliente();
        if (!subTiposOrigen.esVacio()) {
            for (int i=0; i < subTiposOrigen.getColumnCount(); i++) {
                subTiposFinal.addColumn(subTiposOrigen.getColumnName(i));    
            }
            
            for (int i=0; i < subTiposOrigen.getRowCount(); i++) {
                Vector fila = subTiposOrigen.getRow(i);
                Long oid = new Long(((BigDecimal)fila.elementAt(0)).longValue());
                
                if (oid.longValue() == oidTipoCliente.longValue()) {
                    subTiposFinal.addRow(fila);    
                }
            }   
        } */
        
        /* incidencia BELC300004056
        if (subTiposFinal.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        DTOOID dtoOID = new DTOOID();
		dtoOID.setOidIdioma(dto.getOidIdioma());
        dtoOID.setOidPais(dto.getOidPais());
		dtoOID.setOid(dto.getOidTipoCliente());

		DTOSalida dtoSalida = null;
		try {
            dtoSalida = mae.obtenerSubtipos(dtoOID);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneSubtiposCliente: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneSubtiposCliente: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneSubtiposCliente(DTODruidaBusqueda): Salida");
        if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
		return dtoSalida;
    }
    
    /** 
     * Método para obtener las clasificaciones relacionados con un subtipo de cliente y un tipo de clasificación
     * @param dto DTODruidaBusqueda con el criterio de subtipo de cliente y tipo de clasificación
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneClasificaciones(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneClasificaciones(DTODruidaBusqueda): Entrada");

        DTOOID dtoOID = new DTOOID();
        dtoOID.setOidIdioma(dto.getOidIdioma());
        dtoOID.setOidPais(dto.getOidPais());
        dtoOID.setOid(dto.getOidSubtipoCliente());
        
        // Se llama al método obtenerClasificaciones de MAE
        MONConfiguracionClientes mae = this.getIMAEConfiguracion();
        DTOClasificaciones dtoClasificaciones = null;
        try {
            dtoClasificaciones = mae.obtenerClasificacionesSubtipo(dtoOID);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneClasificaciones: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneClasificaciones: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }

		RecordSet recordsetOrigen = new RecordSet();
        if (dtoClasificaciones != null) {
			recordsetOrigen = dtoClasificaciones.getClasificacion();
		}
        RecordSet recordsetDestino = new RecordSet();
        
        // Se obtienen las filas del recordset cuyo oid es igual al oid de 
        // tipo de clasificacion pasado como parametro en el DTO
        Long oidTipoClasificacion = dto.getOidTipoClasificacion();
        if (recordsetOrigen != null && !recordsetOrigen.esVacio()) {
            for (int i=0; i < recordsetOrigen.getColumnCount(); i++) {
                recordsetDestino.addColumn(recordsetOrigen.getColumnName(i));    
            }
            
            for (int i=0; i < recordsetOrigen.getRowCount(); i++) {
                Vector fila = recordsetOrigen.getRow(i);
                Long oid = new Long(((BigDecimal)fila.elementAt(2)).longValue());
                
                if (oid.longValue() == oidTipoClasificacion.longValue()) {
                    recordsetDestino.addRow(fila);    
                }
            }   
        } 
        
        /* incidencia BELC300004056
        if (recordsetDestino.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneClasificaciones(DTODruidaBusqueda): Salida  ");
        return new DTOSalida(recordsetDestino);
    }
    
    /** 
     * Método para obtener los tipos de clasificaciones relacionados con un subtipo de cliente
     * @param dto DTODruidaBusqueda con el criterio de subtipo de cliente
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneTiposClasificaciones(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneTiposClasificaciones(DTODruidaBusqueda): Entrada");

        DTOOID dtoOID = new DTOOID();
        dtoOID.setOidIdioma(dto.getOidIdioma());
        dtoOID.setOidPais(dto.getOidPais());
        dtoOID.setOid(dto.getOidSubtipoCliente());
        
        // Se llama al método obtenerClasificaciones de MAE
        MONConfiguracionClientes mae = this.getIMAEConfiguracion();
        DTOClasificaciones dtoClasificaciones = null;
        try {
            dtoClasificaciones = mae.obtenerClasificacionesSubtipo(dtoOID);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneTiposClasificaciones: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneTiposClasificaciones: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        RecordSet clasificaciones = new RecordSet();
		if (dtoClasificaciones != null) {
			clasificaciones = dtoClasificaciones.getTipoClasificacion();
		}
		
        /* incidencia BELC300004056
        if (clasificaciones == null || clasificaciones.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneTiposClasificaciones(DTODruidaBusqueda): Salida");
		if (clasificaciones == null) {
			clasificaciones = new RecordSet();
		}
        return new DTOSalida(clasificaciones);
    }
    
    /** 
     * Método para obtener los status de cliente
     * @param dto DTODruidaBusqueda
     * @return dto DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos
     */
    public DTOSalida obtieneStatusClientes(DTODruidaBusqueda dto) throws MareException {
      UtilidadesLog.info(" MONUtilidadesBD.obtieneStatusClientes(DTODruidaBusqueda): Entrada");

        DTOSalida dtoSalida = null;
		DTOBelcorp dtoB = new DTOBelcorp();
		dtoB.setOidIdioma(dto.getOidIdioma());
		dtoB.setOidPais(dto.getOidPais());
        
        // Se llama al método obtenerSubgerenciaVentas de ZON
        MONEstatusCliente mae = this.getIMAEStatus();
        try {
            dtoSalida = mae.obtenerPosiblesEstatusCliente(dtoB);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneStatusClientes: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneStatusClientes: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
		
        /* incidencia BELC300004056
        if (dtoSalida.getResultado().esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneStatusClientes(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener las subgerencias relacionadas con un pais, marca y canal determinados
     * @param dto DTODruidaBusqueda con el criterio de pais, marca y canal
     * @return dto DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneSubgerenciasVentas(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneSubgerenciasVentas(DTODruidaBusqueda): Entrada");

        DTOUnidadAdministrativa dtoUnidad = new DTOUnidadAdministrativa();
        dtoUnidad.setOidPais(dto.getOidPais());
        dtoUnidad.setOidCanal(dto.getOidCanal());
        dtoUnidad.setOidMarca(dto.getOidMarca());
                
        // Se llama al método recargaSubgerenciaVentas de ZON
		// Ver incidencia 4579
        MONUnidadesAdministrativas zon = this.getIZON();
        DTOSalida dtoSalida = null;
        try {
			dtoSalida = zon.recargaSubgerenciaVentas(dtoUnidad);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneSubgerenciasVentas: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneSubgerenciasVentas: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        /* incidencia BELC300004056
        if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneSubgerenciasVentas(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener las regiones relacionadas con una subgerencia
     * @param dto DTODruidaBusqueda con el criterio de subgerencia
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneRegiones(DTODruidaBusqueda dto) throws MareException {
      UtilidadesLog.info(" MONUtilidadesBD.obtieneRegiones(DTODruidaBusqueda): Entrada");

        DTOUnidadAdministrativa dtoUnidad = new DTOUnidadAdministrativa();
        dtoUnidad.setOidSGV(dto.getOidSubgerencia());
                
        // Se llama al método recargaRegiones de ZON
		// Ver incidencia 5172
        MONUnidadesAdministrativas zon = this.getIZON();
        DTOSalida dtoSalida = null;
        try {
            dtoSalida = zon.recargaRegiones(dtoUnidad);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneRegiones: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneRegiones: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        /* incidencia BELC300004056
        if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneRegiones(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener las zonas relacionadas con una region
     * @param dto DTODruidaBusqueda con el criterio de region
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneZonas(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneZonas(DTODruidaBusqueda): Entrada");

        DTOUnidadAdministrativa dtoUnidad = new DTOUnidadAdministrativa();
        dtoUnidad.setOidRegion(dto.getOidRegion());
        
        // Se llama al método recargaZonas de ZON
		// Ver incidencia 5177
        MONUnidadesAdministrativas zon = this.getIZON();
        DTOSalida dtoSalida = null;
        try {
            dtoSalida = zon.recargaZonas(dtoUnidad);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneZonas: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneZonas: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        /* incidencia BELC300004056
        if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneZonas(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener las secciones relacionados con una zona
     * @param dto DTODruidaBusqueda con el criterio de zona
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneSecciones(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneSecciones(DTODruidaBusqueda): Entrada");

        DTOUnidadAdministrativa dtoUnidad = new DTOUnidadAdministrativa();
        dtoUnidad.setOidZona(dto.getOidZona());
        
        // Se llama al método recargaSecciones de ZON
		// Ver incidencia 5179
        MONUnidadesAdministrativas zon = this.getIZON();
        DTOSalida dtoSalida = null;
        try {
            dtoSalida = zon.recargaSecciones(dtoUnidad);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneSecciones: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneSecciones: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        /* incidencia BELC300004056
        if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneSecciones(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener los territorios relacionados con una seccion
     * @param dto DTODruidaBusqueda con el criterio de seccion
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneTerritorios(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneTerritorios(DTODruidaBusqueda): Entrada");

        DTOUnidadAdministrativa dtoUnidad = new DTOUnidadAdministrativa();
        dtoUnidad.setOidSeccion(dto.getOidSeccion());
        
        // Se llama al método obtenerTerritorios de ZON
        MONUnidadesAdministrativas zon = this.getIZON();
        DTOSalida dtoSalida = null;
        try {
            dtoSalida = zon.recargaTerritorios(dtoUnidad);
        } catch (MareException e) {
			UtilidadesLog.error("obtieneTerritorios: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneTerritorios: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        /* incidencia BELC300004056
        if (resultado.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
        
		UtilidadesLog.info(" MONUtilidadesBD.obtieneTerritorios(DTODruidaBusqueda): Salida");
		if (dtoSalida == null) {
			dtoSalida = new DTOSalida(new RecordSet());
		}
        return dtoSalida;
    }
    
    /** 
     * Método para obtener los capacitadores relacionados con un tipo de curso
     * @param dto DTODruidaBusqueda con la descripcion del tipo de curso
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneCapacitadores(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneCapacitadores(DTODruidaBusqueda): Entrada");
		/*
		 * Del dto necesitan: 
		 * - los atributos heredados de DTOBelcorp 
		 * - descripcionTipoCurso 

		 * 1. Llama aI IConfiguracionClientes.obtieneClasificacionesCliente(dto.descripcionesTipoCurso, ConstantesMAE.TIPO_CLIENTE_INSTRUCTOR, dto.idioma) 
		 * y devuelve un RecordSet con n registros con las siguientes columnas: 
		 * - oid clasificacion cliente (campo 1)
     * - descripcion clasificacion cliente (campo 2)
     * - descripción subtipo cliente (campo 3) 
     * - codigo del cliente capacitador (campo 4)
		 * - oidCliente (campo 5)                                                   // Agregado  MAE-015
     * - oidSubtipoCliente (campo 6)                                            // Agregado  MAE-015
     * - oidTipoClasificacion (campo 7)                                         // Agregado  MAE-015
		 * 2. Se construye un nuevo RecordSet:
     * - oid clasificacion cliente
     * - descripcion concatenada del capacitador: (campo3 "subtipo")<ESPACIO>(campo 4 "cod cliente")
		 * - oidCliente
     * - oidSubtipoCliente
     * - oidTipoClasificacion
		 * 3. Se encapsula en un DTOSalida.resultado 
		 * 4. Se devuelve el DTOSalida. 
		 */
		
		MONConfiguracionClientes mae = this.getIMAEConfiguracion();
        RecordSet recordsetOrigen = null;
        try {			
            recordsetOrigen = mae.obtenerClasificacionesCliente(dto.getOidTipoCurso(), ConstantesMAE.TIPO_CLIENTE_INSTRUCTOR, dto.getOidIdioma());
        } catch (MareException e) {
			UtilidadesLog.error("obtieneCapacitadores: MareException",e);
			int codigo = e.getCode();
			int codigoNoDatos = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if (codigo != codigoNoDatos) {
				throw e;
			}
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("obtieneCapacitadores: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        RecordSet recordsetDestino = new RecordSet();
        if (recordsetOrigen != null && !recordsetOrigen.esVacio()) {
            recordsetDestino.addColumn("OID_CAPAC");
            recordsetDestino.addColumn("DES_CAPAC");
            recordsetDestino.addColumn("OID_CLIE");                             // Agrega MAE-015
            recordsetDestino.addColumn("OID_SUBT_CLIE");                        // Agrega MAE-015
            recordsetDestino.addColumn("OID_TIPO_CLASI");                       // Agrega MAE-015
            int cantClasificaciones = recordsetOrigen.getRowCount();
            
            Vector filaOrigen;
            Vector filaDestino;
            Long oid;
            String descClasificacion;
            String descSubtipoCliente;
            String codCliente;
            Long oidCliente;
            Long oidSubtipoCliente;
            Long oidTipoClasificacion;
            String concat;
            
            for (int i=0; i < cantClasificaciones; i++) {
                filaOrigen = recordsetOrigen.getRow(i);
                UtilidadesLog.debug(" ...filaOrigen_" + filaOrigen);
                // Se obtienen los tres elementos de cada fila y se concatenan
                // Ver incidencia 5104
                oid = new Long(((BigDecimal)filaOrigen.elementAt(0)).longValue());      // oidClasificacionCliente
                descClasificacion = (String)filaOrigen.elementAt(1);
                descSubtipoCliente = (String)filaOrigen.elementAt(2);
                codCliente = (String)filaOrigen.elementAt(3);
                
                /************* AGREGA MAE-015 INC.24082   *************/
                oidCliente = new Long(((BigDecimal)filaOrigen.elementAt(4)).longValue());
                oidSubtipoCliente = new Long(((BigDecimal)filaOrigen.elementAt(5)).longValue());
                oidTipoClasificacion = new Long(((BigDecimal)filaOrigen.elementAt(6)).longValue());
                /********** FIN AGREGA MAE-015 INC.24082   ************/

                //String concat = descSubtipoCliente + " " + descClasificacion + " " + codCliente;    // Elimina MAE-015
                concat = descSubtipoCliente + " " + codCliente;                                       // Agrega  MAE-015
                
                // Se añade una fila al recordset
                filaDestino = new Vector();
                filaDestino.add(oid);
                filaDestino.add(concat);
                filaDestino.add(oidCliente);                                    // Agrega MAE-015
                filaDestino.add(oidSubtipoCliente);                             // Agrega MAE-015
                filaDestino.add(oidTipoClasificacion);                          // Agrega MAE-015
                UtilidadesLog.debug(" ...filaDestino_" + filaDestino);
                recordsetDestino.addRow(filaDestino);
            }   
        } /* incidencia BELC300004056 else {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        }*/
		
		UtilidadesLog.info(" MONUtilidadesBD.obtieneCapacitadores(DTODruidaBusqueda): Salida");
        return new DTOSalida(recordsetDestino);
    }

	
	/**
	 *  para cargar los registros de los combos dependientes
	 * @param DTOCargaCursos
	 * @return void
	 * @exception MareException
	 * pperanzola - 26/09/2005 - Se corrige porque no cargaba los combos de capacitadores BELC300014072
	 * eiraola    - 25/09/2006 - Cambios MAE-015 sobre el combo capacitador BELC300024082
	 */
	public DTODependientesCarga obtieneDependientes(DTOCargaCursos dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneDependientes(DTODruidaBusqueda): Entrada");

		DTODependientesCarga dtoS = new DTODependientesCarga();
		DTOSalida dtoSalida = null;
		
		if (dto.getCurso() == null){
			UtilidadesLog.debug(" >>>>>>>> dto.getCurso() == null ");
			DTODetallePlantillaCurso detalle = null;
			DTODruidaBusqueda dtoe = new DTODruidaBusqueda();
			 
      UtilidadesLog.debug(" El idioma es : " + dto.getOidIdioma());
      dtoe.setOidIdioma(dto.getOidIdioma());
      UtilidadesLog.debug(" El pais es : " + dto.getOidPais());
			dtoe.setOidPais(dto.getOidPais());
			
      UtilidadesLog.debug(" antes del for dto.getPlantilla.getDetalle: ");
			int cantElemPlantilla = dto.getPlantilla().getDetalles().size();
      
      for (int i = 0; i < cantElemPlantilla; i++){
				 UtilidadesLog.debug("--- entra al for ");
        detalle = (DTODetallePlantillaCurso)dto.getPlantilla().getDetalles().get(i);
        UtilidadesLog.debug(" Dto Detallle de plantilla para i =: " +  i  + " :" + detalle.toString());
				Long oidParam = detalle.getParametro().getOid();
        UtilidadesLog.debug(" El oidParam es  " + oidParam.toString());
				if (oidParam.longValue() == ConstantesEDU.PARAM_MARCA.longValue() && detalle.getValor() != null){
					UtilidadesLog.debug(" El oidParam es similar a cte edu marca: " + detalle.getValor());
          dtoe.setOidMarca(new Long(detalle.getValor()));
          UtilidadesLog.debug(" la marca es " + dtoe.getOidMarca() );
				} else if (oidParam.longValue() == ConstantesEDU.PARAM_CANAL.longValue()  && detalle.getValor() != null){
					UtilidadesLog.debug(" El oidParam es similar a cte edu canal: " + detalle.getValor());
          dtoe.setOidCanal(new Long(detalle.getValor()));
          UtilidadesLog.debug(" El cana es: " + dtoe.getOidCanal());
				} else if (oidParam.longValue() == ConstantesEDU.PARAM_TIPO_CLIENTE.longValue()  && detalle.getValor() != null){
					UtilidadesLog.debug(" El oidParam es similar a cte tipo cliente: " + detalle.getValor());
          dtoe.setOidTipoCliente(new Long(detalle.getValor()));
          UtilidadesLog.debug(" El oidTipoCliente es: " +  dtoe.getOidTipoCliente());
				} else if (oidParam.longValue() == ConstantesEDU.PARAM_SUBTIPO_CLIENTE.longValue()  && detalle.getValor() != null){
					UtilidadesLog.debug(" El oidParam es similar a cte subtipotipo cliente: " + detalle.getValor());
          dtoe.setOidSubtipoCliente(new Long(detalle.getValor()));
          UtilidadesLog.debug(" El oidSubtipoCLiente es: " +  dtoe.getOidSubtipoCliente());
				} else if (oidParam.longValue() == ConstantesEDU.PARAM_TIPO_CLASIFICACION.longValue()  && detalle.getValor() != null){
					UtilidadesLog.debug(" El oidParam es similar a cte tipo clasificacion: " + detalle.getValor());
          dtoe.setOidTipoClasificacion(new Long(detalle.getValor()));
          UtilidadesLog.debug("asigna tipo clasificacion " );
				} else if (oidParam.longValue() == ConstantesEDU.PARAM_SUBGERENCIA.longValue()  && detalle.getValor() != null) {
					UtilidadesLog.debug(" El oidParam es similar a cte odSubgerencia: " + detalle.getValor());
          dtoe.setOidSubgerencia(new Long(detalle.getValor()));
          UtilidadesLog.debug(" asigna  oidSubgerencia  ");
				} else if (oidParam.longValue() == ConstantesEDU.PARAM_REGION.longValue()  && detalle.getValor() != null){
					UtilidadesLog.debug(" El oidParam es similar a cte region: " + detalle.getValor());
          dtoe.setOidRegion(new Long(detalle.getValor()));
          UtilidadesLog.debug(" asigna region " );
				} else if (oidParam.longValue() == ConstantesEDU.PARAM_ZONA.longValue()  && detalle.getValor() != null) {
					UtilidadesLog.debug(" El oidParam es similar a cte zona: " + detalle.getValor());
          dtoe.setOidZona(new Long(detalle.getValor()));
          UtilidadesLog.debug(" asigna zona " );
				} else if (oidParam.longValue() == ConstantesEDU.PARAM_SECCION.longValue()  && detalle.getValor() != null) {
					UtilidadesLog.debug(" El oidParam es similar a cte seccion: " + detalle.getValor());
          dtoe.setOidSeccion(new Long(detalle.getValor()));
          UtilidadesLog.debug(" asigna seccion " );
				} else if (oidParam.longValue() == ConstantesEDU.PARAM_TIPO_CURSO.longValue()  && detalle.getValor() != null) {
					UtilidadesLog.debug(" El oidParam es similar a cte tipoCurso: " + detalle.getValor());
          dtoe.setOidTipoCurso(new Long(detalle.getValor()));
          UtilidadesLog.debug(" asigna curso: ");
				}
			}

			if (dtoe.getOidMarca() != null){
        UtilidadesLog.debug("dtoe.getoidMarca !=null" );
				dtoSalida = this.obtieneTiposCurso(dtoe);
        UtilidadesLog.debug(" El dto salida en marca : " + dtoSalida.toString());
				dtoS.setTiposCurso(dtoSalida.getResultado());
        UtilidadesLog.debug(" El dtos en marca : " + dtoS.toString());
			}

			if (dtoe.getOidCanal() != null){
				UtilidadesLog.debug("dtoe.getoidCanal !=null" );
				dtoSalida = this.obtieneAccesos(dtoe);
        UtilidadesLog.debug(" El dto salida en canal : " + dtoSalida.toString());
				dtoS.setAccesos(dtoSalida.getResultado());
				UtilidadesLog.debug(" El dtos en canal : " + dtoS.toString());		
			}

			if (dtoe.getOidMarca() != null && dtoe.getOidCanal() != null){

				dtoSalida = this.obtienePeriodos(dtoe);
        UtilidadesLog.debug(" El dto salida en marca y canal : " + dtoSalida.toString());
				dtoS.setPeriodos(dtoSalida.getResultado());
				
				dtoSalida = this.obtieneSubgerenciasVentas(dtoe);
				dtoS.setSubgerencias(dtoSalida.getResultado());
        UtilidadesLog.debug(" El dtos en marca y canal : " + dtoS.toString());		
						
			}


			if (dtoe.getOidTipoCliente() != null){
        UtilidadesLog.debug("dtoe.getoidTipoCliente !=null" );
				dtoSalida = this.obtieneSubtiposCliente(dtoe);
				dtoS.setSubtiposCliente(dtoSalida.getResultado());	
        UtilidadesLog.debug(" El dtos en getOidTipoCliente : " + dtoS.toString());		
			}
				 
			if (dtoe.getOidSubtipoCliente() != null){
        UtilidadesLog.debug("dtoe.getoidSubtipoCliente !=null" );
				dtoSalida = this.obtieneTiposClasificaciones(dtoe);
				dtoS.setTiposClasificacion(dtoSalida.getResultado());
        UtilidadesLog.debug(" El dtos en oidSubtipoCliente : " + dtoS.toString());		
			}
				
			if (dtoe.getOidTipoClasificacion() != null  &&  dtoe.getOidSubtipoCliente() != null){
        UtilidadesLog.debug("dtoe.getOidTipoClasificacion !=null" );
				dtoSalida = this.obtieneClasificaciones(dtoe);
				dtoS.setClasificaciones(dtoSalida.getResultado());
        UtilidadesLog.debug(" El dtos en clasificaciones : " + dtoS.toString());		
			}
				
			if (dtoe.getOidSubgerencia() != null){
        UtilidadesLog.debug("dtoe.getOidSubgerencia !=null" );
				dtoSalida = this.obtieneRegiones(dtoe);
				dtoS.setRegiones(dtoSalida.getResultado());
        UtilidadesLog.debug("dtos en regiones" + dtoS.toString() );
			}
				
			if (dtoe.getOidRegion() != null){
       UtilidadesLog.debug("dtoe.getOidRegion !=null" );
				dtoSalida = this.obtieneZonas(dtoe);
				dtoS.setZonas(dtoSalida.getResultado());
        UtilidadesLog.debug("dtos en zonas" + dtoS.toString() );
			}

			if (dtoe.getOidZona() != null){
        UtilidadesLog.debug("dtoe.getOidZona !=null" );
				dtoSalida = this.obtieneSecciones(dtoe);
				dtoS.setSecciones(dtoSalida.getResultado());
        UtilidadesLog.debug("dtoe.getSecciones ="  + dtoS);
			}
				
			if (dtoe.getOidSeccion() != null){
        UtilidadesLog.debug("dtoe.getSecciones != null"  );
				dtoSalida = this.obtieneTerritorios(dtoe);
				dtoS.setTerritorios(dtoSalida.getResultado());
        UtilidadesLog.debug("dtoe.getTerritorios ="  + dtoS);
			}
				
			if (dtoe.getOidTipoCurso() != null){
        UtilidadesLog.debug("dtoe.getTipoCurso != null"  );
				dtoSalida = this.obtieneCapacitadores(dtoe);
				dtoS.setCapacitadores(dtoSalida.getResultado());
        UtilidadesLog.debug("dtoS.getCapacitadores= " + dtoS );
			}
				
		} else { //Incidencia BELC300006784
			UtilidadesLog.debug(" >>>>>>>> dto.getCurso()!= null");
			DTODruidaBusqueda dtoe = new DTODruidaBusqueda();
			DTORelacionesCurso dtoRelacion = dto.getCurso().getRelacion();
			dtoe.setOidIdioma(dto.getOidIdioma());
			dtoe.setOidPais(dto.getOidPais());
			dtoe.setOidMarca(dtoRelacion.getOidMarca());
			dtoe.setOidCanal(dtoRelacion.getOidCanal());

			if (dtoRelacion.getOidMarca() != null){
				dtoSalida = this.obtieneTiposCurso(dtoe);
				dtoS.setTiposCurso(dtoSalida.getResultado());				
			}

			dtoSalida = this.obtienePeriodos(dtoe);
			dtoS.setPeriodos(dtoSalida.getResultado());

			if (dtoRelacion.getOidCanal() != null){
				dtoSalida = this.obtieneAccesos(dtoe);
				dtoS.setAccesos(dtoSalida.getResultado());				
			}

			if (dtoRelacion.getOidCanal() != null && dtoRelacion.getOidMarca() != null){
				dtoSalida = this.obtieneSubgerenciasVentas(dtoe);
				dtoS.setSubgerencias(dtoSalida.getResultado());	
			}
			

			if (dtoRelacion.getOidTipoCliente() != null) {
				dtoe.setOidTipoCliente(dtoRelacion.getOidTipoCliente());
				dtoSalida = this.obtieneSubtiposCliente(dtoe);
				dtoS.setSubtiposCliente(dtoSalida.getResultado());				
			}

			if (dtoRelacion.getOidSubtipoCliente() != null){
				dtoe.setOidSubtipoCliente(dtoRelacion.getOidSubtipoCliente());
				dtoSalida = this.obtieneTiposClasificaciones(dtoe);
				dtoS.setTiposClasificacion(dtoSalida.getResultado());				
			}

			if (dtoRelacion.getOidTipoClasificacion() != null){
				dtoe.setOidTipoClasificacion(dtoRelacion.getOidTipoClasificacion());
				dtoSalida = this.obtieneClasificaciones(dtoe);
				dtoS.setClasificaciones(dtoSalida.getResultado());				
			}

			if (dtoRelacion.getOidSubgerencia() != null){
				dtoSalida = this.obtieneRegiones(dtoe);
				dtoS.setRegiones(dtoSalida.getResultado());
			}
			
			if (dtoRelacion.getOidRegion() != null){
				dtoe.setOidRegion(dtoRelacion.getOidRegion());
				dtoSalida = this.obtieneZonas(dtoe);
				dtoS.setZonas(dtoSalida.getResultado());
			}

			if (dtoRelacion.getOidZona() != null){
				dtoe.setOidZona(dtoRelacion.getOidZona());
				dtoSalida = this.obtieneSecciones(dtoe);
				dtoS.setSecciones(dtoSalida.getResultado());
			}

			if (dtoRelacion.getOidSeccion() != null){
				dtoe.setOidSeccion(dtoRelacion.getOidSeccion());
				dtoSalida = this.obtieneTerritorios(dtoe);
				dtoS.setTerritorios(dtoSalida.getResultado());				
			}

			UtilidadesLog.debug("dtoRelacion.getOidTipoCurso() =  " + dtoRelacion.getOidTipoCurso());
			if (dtoRelacion.getOidTipoCurso() != null) {
			    dtoe.setOidTipoCurso(dtoRelacion.getOidTipoCurso());
			    dtoSalida = this.obtieneCapacitadores(dtoe);
			    dtoS.setCapacitadores(dtoSalida.getResultado());
          
          /* Agrega MAE-015*/
          Long oidClienteCapacitador           = dtoRelacion.getOidClienteCapacitador();
          Long oidSubtipoClienteCapacitador    = dtoRelacion.getOidSubtipoClienteCapacitador();
          Long oidTipoClasificacionCapacitador = dtoRelacion.getOidTipoClasificacionCapacitador();
          String codClienteCapacitador         = dtoRelacion.getCodClienteCapacitador();
          String descSubtipoClienteCapacitador = dtoRelacion.getDescSubtipoClienteCapacitador();
          UtilidadesLog.debug("Capacitador anterior");
          UtilidadesLog.debug("                    # oidCliente_"         + oidClienteCapacitador );
          UtilidadesLog.debug("                      codigoCliente_"      + codClienteCapacitador );
          UtilidadesLog.debug("                      descSubtipoCliente_" + descSubtipoClienteCapacitador );
          UtilidadesLog.debug("                    # oidSubtipo_"         + oidSubtipoClienteCapacitador );
          UtilidadesLog.debug("                    # oidTipoClasi_"       + oidTipoClasificacionCapacitador );
          
          if (oidClienteCapacitador != null && oidSubtipoClienteCapacitador != null
                  && oidTipoClasificacionCapacitador != null ) {
              
              RecordSet capacitadores = dtoSalida.getResultado();
              int cantCapacitadores = 0;
              Vector fila = null;
              boolean coincide = false;
              
              if (capacitadores != null) {
                  cantCapacitadores = capacitadores.getRowCount();
              }
              
              Long oidClienteFilaCombo;
              Long oidSubtipoFilaCombo;
              Long oidTipoClasiFilaCombo;
              
              // Recorrer dtoS.capacitadores
              for (int i = 0; i < cantCapacitadores; i++) {
                  UtilidadesLog.debug(".... recorriendo fila_" + i);
                  fila = capacitadores.getRow(i);
                  oidClienteFilaCombo   = (Long)fila.elementAt(2);
                  oidSubtipoFilaCombo   = (Long)fila.elementAt(3);
                  oidTipoClasiFilaCombo = (Long)fila.elementAt(4);
                  
                  // Si coinciden los datos del capacitador del curso con una de las opciones                  
                  if ( oidClienteCapacitador.equals(oidClienteFilaCombo)
                          && oidSubtipoClienteCapacitador.equals(oidSubtipoFilaCombo)
                          && oidTipoClasificacionCapacitador.equals(oidTipoClasiFilaCombo) ) {
                      // No es necesario agregar la opcion con el capacitador al recordset
                      coincide = true;
                      break;
                  }
              }
              
              /* Si ninguno coincide
                   Asignar -99 a dto.curso.oidCapacitador y armar un registro 2 columnas, 
                   la primera con -99 y la segunda con descCapacitador y asignarlo a dtoS.capacitadores
                   Se le asigna a este registro como campos ocultos los campos dto.curso.oidCliente, 
                   dto.curso.oidSubtipoCliente, dto.curso.oidTipoClasificacion */
              if (!coincide) {
                  UtilidadesLog.debug(".... ninguna fila de capacitadores coincide con el guardado para el curso -> genero fila ficticia -99");
                  // Se anyade una fila al recordset
                  Vector filaNueva = new Vector();
                  
                  filaNueva.add(new Long(-99)); // Oid de clasificacion ficticio para poder seleccionarlo del combo en pantalla
                  filaNueva.add(descSubtipoClienteCapacitador + " " + codClienteCapacitador);
                  filaNueva.add(dtoRelacion.getOidClienteCapacitador());
                  filaNueva.add(dtoRelacion.getOidSubtipoClienteCapacitador());
                  filaNueva.add(dtoRelacion.getOidTipoClasificacionCapacitador());
                  
                  UtilidadesLog.debug(".... filaNueva_" + filaNueva);
                  capacitadores.addRow(filaNueva);
                  
                  dtoS.setCapacitadores(capacitadores);  // Actualizo con el recordset que tiene la fila adicional
              }
              
          }
          /* Fin Agrega MAE-015*/
			}
			
		}
		UtilidadesLog.info(" MONUtilidadesBD.obtieneDependientes(DTODruidaBusqueda): Salida");
		return dtoS;
	}

	/**
	 *  para obtener todos los registros de la entidad MomentoEntrega 
	 * teniendo en cuenta que la descripcion es internacionalizable 
	 * @param DTODruidaBusqueda
	 * @return DTOSalida
	 * @exception MareException
	 */
	public DTOSalida obtieneMomentoEntrega(DTODruidaBusqueda dto) throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.obtieneMomentoEntrega(DTODruidaBusqueda): Entrada");
		
		Vector parametros=new Vector();
		StringBuffer query = new StringBuffer("");		 

		query.append(" SELECT m.OID_MOME_ENTR,");
		query.append(" (SELECT i.val_i18n FROM V_GEN_I18N_SICC i WHERE ");
		query.append(" i.attr_enti = 'EDU_MOMEN_ENTRE' AND i.attr_num_atri = 1");
        query.append(" AND i.idio_oid_idio = ? AND i.val_oid = m.OID_MOME_ENTR ) AS DESC_MOME_ENTR");
		//FROM
		query.append(" FROM EDU_MOMEN_ENTRE m");
		parametros.add(dto.getOidIdioma());

		RecordSet rs;
		BelcorpService bs = UtilidadesEJB.getBelcorpService();

		try{
			rs = bs.dbService.executePreparedQuery(query.toString(),parametros);
		} catch (Exception e){
		
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(rs);
		UtilidadesLog.info(" MONUtilidadesBD.obtieneMomentoEntrega(DTODruidaBusqueda): Salida");
		return dtoSalida;
	}
    
    private MONMantenimientoSEG getISEG() throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.getISEG(): Entrada");

        // Se obtiene el interfaz home
        MONMantenimientoSEGHome home = (MONMantenimientoSEGHome)UtilidadesEJB.getHome(
            MON_MANTENIMIENTO_SEG, MONMantenimientoSEGHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoSEG ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("getISEG: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

       UtilidadesLog.info(" MONUtilidadesBD.getISEG(): Salida");
        return ejb;
    }
    
    private MONUnidadesAdministrativas getIZON() throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.getIZON(): Entrada");

        // Se obtiene el interfaz home
        MONUnidadesAdministrativasHome home = (MONUnidadesAdministrativasHome)UtilidadesEJB.getHome(
            MON_UNIDADES_ADMINISTRATIVAS, MONUnidadesAdministrativasHome.class);
            
        // Se obtiene el interfaz remoto
        MONUnidadesAdministrativas ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("getIZON: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

        UtilidadesLog.info(" MONUtilidadesBD.getIZON(): Salida");
        return ejb;
    }
    
    private MONConfiguracionClientes getIMAEConfiguracion() throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.getIMAEConfiguracion(): Entrada");

        // Se obtiene el interfaz home
        MONConfiguracionClientesHome home = (MONConfiguracionClientesHome)UtilidadesEJB.getHome(
            MON_CONFIGURACION_CLIENTES, MONConfiguracionClientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONConfiguracionClientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("getIMAEConfiguracion: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

        UtilidadesLog.info(" MONUtilidadesBD.getIMAEConfiguracion(): Salida");
        return ejb;
    }

    
    private MONEstatusCliente getIMAEStatus() throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.getIMAEStatus(): Entrada");

        // Se obtiene el interfaz home
        MONEstatusClienteHome home = (MONEstatusClienteHome)UtilidadesEJB.getHome(
            MON_STATUS_CLIENTES, MONEstatusClienteHome.class);
            
        // Se obtiene el interfaz remoto
        MONEstatusCliente ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("getIMAEStatus: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

        UtilidadesLog.info(" MONUtilidadesBD.getIMAEStatus(): Salida");
        return ejb;
    }
    
    private MONPeriodos getICRA() throws MareException {
		UtilidadesLog.info(" MONUtilidadesBD.getICRA(): Entrada");

        // Se obtiene el interfaz home
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome(
            MON_PERIODOS, MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.error("getICRA: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

        UtilidadesLog.info(" MONUtilidadesBD.getICRA(): Salida");
        return ejb;
    }


	


	
	private String getUsuario(){
		UtilidadesLog.info("*** Método getUsuario: " + ctx.getCallerPrincipal().getName()); 
		return ctx.getCallerPrincipal().getName();
	}	

}