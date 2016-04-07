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
package es.indra.sicc.logicanegocio.seg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;
import es.indra.sicc.dtos.seg.DTOCAS;
import es.indra.sicc.dtos.seg.DTOCargaCAS;
import es.indra.sicc.dtos.seg.DTOEBuscarSubaccesos;
import es.indra.sicc.dtos.seg.DTOEBuscarVinculosJerarquia;
import es.indra.sicc.dtos.seg.DTOEVinculoJerarquia;
import es.indra.sicc.dtos.seg.DTOFiltroCAS;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.dtos.seg.DTOPMC;
import es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo;
import es.indra.sicc.dtos.seg.DTOSubacceso;
import es.indra.sicc.dtos.seg.DTOSubaccesosPorAccesoYCanal;
import es.indra.sicc.dtos.seg.DTOValidarUbigeo;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.entidades.seg.VinculoJerarquiaLocal;
import es.indra.sicc.entidades.seg.VinculoJerarquiaLocalHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficasHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import es.indra.sicc.logicanegocio.seg.DAOServicioSeg;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import java.util.Date;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * Sistema:           Belcorp - SICC
 * Modulo:            SEG - Seguridad
 * Componente:        MONMantenimientoSEG
 * Fecha:             03/11/2003
 * Documentacion:     
 * Observaciones:     
 *
 * @version           1.0
 * @author            Dario Hruszecki
 */ 
 
public class MONMantenimientoSEGBean implements SessionBean,IServicioSEG  {
    /*
     * ToDo : Ver si se sirve cargar dinamicamente en memoria
     * los atributos traducibles de la entidades de SEG
     */
    private Hashtable entidades = new Hashtable();
    private SessionContext ctx;
    
    public void ejbCreate() {
        // entidades
        entidades.put("Pais","SEG_PAIS");
        entidades.put("Departamentos","SEG_DEPTO_EMPRE");
        entidades.put("Marcas","SEG_MARCA");
        entidades.put("Canales","SEG_CANAL");
        entidades.put("Accesos","SEG_ACCES");
        entidades.put("Subaccesos","SEG_SUBAC");
        entidades.put("Periodo","SEG_PERIO_CORPO");
        entidades.put("Empresas","SEG_SOCIE");
        entidades.put("Idiomas","SEG_IDIOM");
        entidades.put("TiposPeriodo","SEG_TIPO_PERIO");
        entidades.put("TiposVia","SEG_TIPO_VIA");
        entidades.put("Modulos","SEG_MODUL");
        entidades.put("Nacionalidad","SEG_NACIO");
        
        entidades.put("Internacionalizacion","GEN_I18N_SICC");
    }

    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void ejbRemove() {}
    public void setSessionContext(SessionContext ctx) {this.ctx = ctx;}

    // implementacion de los metodos correspondientes la interface IServicioSEG

    /*
     * Documentation
     * Consulta por DBService sobre la entidad Pais, obtiene todos los países
     */
    public DTOSalida recuperarPaises(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPaises(DTOBelcorp):Entrada");
        String user = ctx.getCallerPrincipal().getName();
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" IPais.VAL_OID,  ");
        query.append(" IPais.VAL_I18N ");
        query.append(" FROM VCA_SEG_PAIS P, V_GEN_I18N_SICC IPais ");
        query.append(" WHERE IPais.ATTR_ENTI = 'SEG_PAIS' ");
        query.append(" AND IPais.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append(" AND IPais.VAL_OID = P.OID_PAIS  ");
        query.append(" AND IPais.ATTR_NUM_ATRI = 1 ");
        query.append(" AND P.COD_USUA = '"+user+"' ");
        query.append(" ORDER BY IPais.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPaises(DTOBelcorp):Salida");
        return dtos;
    }

	public DTOSalida recuperarPaises(DTOBelcorp dto, Boolean todos) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPaises(DTOBelcorp , Boolean):Entrada");
        String entidad = (String)entidades.get("Pais");
        //Hashtable atributos = cargarAtributosTraducibles(entidad);
        DTOSalida dtos =  new DTOSalida();

        String clausulaSinTodos = " and val_oid != 0 ";
        if (todos.booleanValue()) clausulaSinTodos = "";
        
        dtos.setResultado(getCodigoDescripcionTraducible(entidad,
                                              new Integer(1),//new Integer(((BigDecimal)atributos.get("Nombre")).intValue()),
                                              dto.getOidIdioma(),
                                              new String[]{clausulaSinTodos})); // Todo idioma		
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPaises(DTOBelcorp , Boolean):Salida");
        return dtos;
	}


    /**
     * Documentacion: Consulta por DBService sobre la vista VCA_SEG_PAIS, oid y descripción de todos los países,
     * recibe un dto de entrada "DTOBelcorp" que lleva el idioma para la recuperación de la descripción del país en el idioma introducido,
     * filtrando por el usuario, para que se recuperen los países para los que tiene permiso, y filtrará el metavalor "todos", 
     * que por defecto lleva oid = 0 en todas las entidades que aplican este valor. 
     * @author gdmarzi
     */
    public DTOSalida recuperarPaisesSinTodos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPaisesSinTodos(DTOBelcorp):Entrada");

        StringBuffer query = new StringBuffer();
        DTOSalida droSalida = new DTOSalida();
        RecordSet recordSet;
        String entidad = (String)entidades.get("Pais");
        Integer atributo = new Integer(1);
        Long idioma = dto.getOidIdioma();
        String usuario = ctx.getCallerPrincipal().getName();//"usuariopre";  //DESHARDCODEAR

        query.append(" SELECT DISTINCT i18n.val_oid, i18n.val_i18n ");
        query.append(" FROM VCA_SEG_PAIS pais, V_GEN_I18N_SICC i18n ");
        query.append(" WHERE pais.OID_PAIS = i18n.VAL_OID AND ");
        query.append(" i18n.ATTR_ENTI = ? AND ");
        query.append(" i18n.ATTR_NUM_ATRI = ? AND ");
        query.append(" i18n.IDIO_OID_IDIO = ? AND ");
        query.append(" pais.COD_USUA = ? AND ");
        query.append(" i18n.VAL_OID != 0 ");
        query.append(" ORDER BY val_i18n ");
        
        Vector parametros = new Vector();
        parametros.add(entidad);
        parametros.add(atributo);
        parametros.add(idioma);
        parametros.add(usuario);

        try {
            recordSet = getBelcorpService().dbService.executePreparedQuery(query.toString(),
                        parametros);

        } catch (MareException me) {
            UtilidadesLog.error("Error en recuperarPaisesSinTodos");
            throw me; 
        } catch (Exception e) {
            UtilidadesLog.error("Error en recuperarPaisesSinTodos");
            throw new MareException("Error al recuperarPaisesSinTodos",e);
        }

        droSalida.setResultado(recordSet);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPaisesSinTodos(DTOBelcorp):Salida");
        return droSalida;                                                        
    }

    
    /**
     * Modificacion según cambios en la version 3.19
     * Recibe como parámetro un objeto DTOBelcorp y un valor booleano que indica 
     * si se recupera el metavalor todos (true) o no (false). Se devuelve un 
     * DTOSalida que lleva un RecordSet con el el oid de Marca, el Código de 
     * Marca y la descripción en el idioma que venga indicado en el DTOBelcorp 
     * de entrada.
     */
    public DTOSalida recuperarMarcas(DTOBelcorp dto, Boolean todos) 
        throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarMarcas(DTOBelcorp , Boolean):Entrada");
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();
        
        query.append(" SELECT oid_marc as val_oid, des_marc as val_i18n, cod_marc ");
        query.append(" FROM vca_seg_marca ");
        query.append(" WHERE cod_usua = '"+user+"' ");

        if (!todos.booleanValue()) {			
          query.append(" AND oid_marc != 0 ");
        }
		
        query.append("ORDER BY des_marc ");

            try {
                rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            } catch (MareException me) {
                UtilidadesLog.error("Error en getCodigoDescripcionTraducible");
                throw me; 
            } catch (Exception e) {
                UtilidadesLog.error("Error en getCodigoDescripcionTraducible");
                throw new MareException("Error al obtener codigo Descripcion traducibles",e);
            }

            if (rs.esVacio()) {
                throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            UtilidadesLog.info("MONMantenimientoSEG.recuperarMarcas(DTOBelcorp , Boolean):Salida");
            return new DTOSalida(rs);
    }


    public DTOSalida recuperarMarcas(DTOBelcorp dto) throws MareException {
        return this.recuperarMarcas(dto, new Boolean("FALSE"));
    }


    public DTOSalida recuperarCanales(DTOBelcorp dto, Boolean todos) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarCanales(DTOBelcorp , Boolean):Entrada");
        String user = ctx.getCallerPrincipal().getName();
        DTOSalida dtos =  new DTOSalida();
        UtilidadesLog.debug("entro al metodo de recuperar canales");

        String clausulaSinTodos = " and val_oid != 0 ";
        if (todos.booleanValue()) clausulaSinTodos = "";

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" ICanal.VAL_OID,  ");
        query.append(" ICanal.VAL_I18N, ");
        query.append(" C.TIPE_OID_TIPO_PERI ");
        query.append(" FROM VCA_SEG_CANAL C, V_GEN_I18N_SICC ICanal ");
        query.append(" WHERE ICanal.ATTR_ENTI = 'SEG_CANAL' ");
        query.append(" AND ICanal.IDIO_OID_IDIO =  1");
        query.append(" AND ICanal.VAL_OID = C.OID_CANA  ");
        query.append(" AND ICanal.ATTR_NUM_ATRI = 1 ");
        query.append(" AND C.COD_USUA = '"+user+"' ");
        query.append(clausulaSinTodos);
        query.append(" ORDER BY ICanal.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarCanales(DTOBelcorp , Boolean):Salida");
        return dtos;
    }

    public DTOSalida recuperarCanales(DTOBelcorp dto) throws MareException {
        return this.recuperarCanales(dto, new Boolean("FALSE"));
    }
    
    public DTOSalida recuperarAccesos(DTOBelcorp dto, Boolean todos) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarAccesos(DTOBelcorp , Boolean):Entrada");
        String user = ctx.getCallerPrincipal().getName();
        DTOSalida dtos =  new DTOSalida();

        String clausulaSinTodos = " and val_oid != 0 ";
        if (todos.booleanValue()) clausulaSinTodos = "";
        
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" IAcce.VAL_OID,  ");
        query.append(" IAcce.VAL_I18N, ");
        query.append(" C.CANA_OID_CANA ");
        query.append(" FROM VCA_SEG_ACCES C, V_GEN_I18N_SICC IAcce ");
        query.append(" WHERE IAcce.ATTR_ENTI = 'SEG_ACCES' ");
        query.append(" AND IAcce.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append(" AND IAcce.VAL_OID = C.OID_ACCE  ");
        query.append(" AND IAcce.ATTR_NUM_ATRI = 1 ");
        query.append(" AND C.COD_USUA = '"+user+"' ");
        query.append(clausulaSinTodos);
        query.append(" ORDER BY IAcce.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarAccesos(DTOBelcorp , Boolean):Salida");
        return dtos;
    }

    public DTOSalida recuperarAccesos(DTOBelcorp dto) throws MareException {
        return this.recuperarAccesos(dto, new Boolean("FALSE"));
    }
    
    public DTOSalida recuperarDepartamentos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarDepartamentos(DTOBelcorp):Entrada");
        String entidad = (String)entidades.get("Departamentos");
        //Hashtable atributos = cargarAtributosTraducibles(entidad);
        DTOSalida dtos =  new DTOSalida();
        
        dtos.setResultado(getCodigoDescripcionTraducible(entidad,
                                              new Integer(1),//new Integer(((BigDecimal)atributos.get("Descripción larga")).intValue()),
                                              dto.getOidIdioma(),
                                              new String[]{})); // Todo idioma
        UtilidadesLog.info("MONMantenimientoSEG.recuperarDepartamentos(DTOBelcorp):Salida");
        return dtos;

    }

    public DTOSalida recuperarSubaccesos(DTOBelcorp dto, Boolean todos) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarSubaccesos(DTOBelcorp , Boolean):Entrada");
        String user = ctx.getCallerPrincipal().getName();
        DTOSalida dtos =  new DTOSalida();

        String clausulaSinTodos = " and val_oid != 0 ";
        if (todos.booleanValue()) clausulaSinTodos = "";
        
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" ISub.VAL_OID,  ");
        query.append(" ISub.VAL_I18N, ");
        query.append(" a.OID_ACCE, ");
        query.append(" a.CANA_OID_CANA ");
        query.append(" FROM VCA_SEG_SUBAC C, V_GEN_I18N_SICC ISub, seg_acces a ");
        query.append(" WHERE ISub.ATTR_ENTI = 'SEG_SUBAC' ");
        query.append(" AND ISub.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append(" AND ISub.VAL_OID = C.OID_SBAC  ");
        query.append(" AND ISub.ATTR_NUM_ATRI = 1 ");
        query.append(" AND C.COD_USUA = '"+user+"' ");
        query.append(" AND c.ACCE_OID_ACCE = a.OID_ACCE ");
        query.append(clausulaSinTodos);
        query.append(" ORDER BY ISub.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarSubaccesos(DTOBelcorp , Boolean):Salida");
        return dtos;
    }

    public DTOSalida recuperarSubaccesos(DTOBelcorp dto) throws MareException {
        return this.recuperarSubaccesos(dto, new Boolean("FALSE"));
    }
    
    public DTOSalida recuperarPeriodos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPeriodos(DTOBelcorp):Entrada");
        String entidad = (String)entidades.get("Periodo");
        //Hashtable atributos = cargarAtributosTraducibles(entidad);
        DTOSalida dtos =  new DTOSalida();
        
        dtos.setResultado(getCodigoDescripcionTraducible(entidad,
                                              new Integer(1),//new Integer(((BigDecimal)atributos.get("Descripción")).intValue()),
                                              dto.getOidIdioma(),
                                              new String[]{})); // Todo idioma
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPeriodos(DTOBelcorp):Salida");
        return dtos;
    }

    public DTOSalida recuperarIdiomas(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarIdiomas(DTOBelcorp):Entrada");

        RecordSet rs;
        StringBuffer query = new StringBuffer();
		query.append("SELECT   val_oid, val_i18n, COD_ISO_IDIO, COD_IDIO, IND_IDIO_TRAD ");
		query.append("    FROM V_gen_i18n_sicc i18n, seg_idiom  ");
		query.append("   WHERE UPPER (attr_enti) = UPPER ('SEG_IDIOM') ");
		query.append("   	 and val_oid = seg_idiom.oid_idio ");
		query.append("     AND attr_num_atri = 1  ");
		query.append("     AND i18n.idio_oid_idio = " + dto.getOidIdioma());
		query.append("ORDER BY val_i18n  ");

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("Error en getCodigoDescripcionTraducible");
            throw me; 
        } catch (Exception e) {
            UtilidadesLog.error("Error en getCodigoDescripcionTraducible");
            throw new MareException("Error al obtener codigo Descripcion traducibles",e);
        }


        if (rs.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoSEG.recuperarIdiomas(DTOBelcorp):Salida");
        return new DTOSalida(rs);
        
/*        dtos.setResultado(getCodigoDescripcionTraducible(entidad,
                                              new Integer(((BigDecimal)atributos.get("Descripción")).intValue()),
                                              dto.getOidIdioma(),
                                              new String[]{})); // Todo idioma
        return dtos;*/
    }

    public DTOSalida recuperarEmpresas(DTOBelcorp dto, Boolean todos) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarEmpresas(DTOBelcorp , Boolean):Entrada");
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();

        String clausulaSinTodos = " WHERE  s.OID_SOCI!= 0 ";
        if (todos.booleanValue()) clausulaSinTodos = "";

        query.append(" SELECT ");
        query.append(" s.OID_SOCI, ");
        query.append(" s.VAL_DENO, ");
        query.append(" s.PAIS_OID_PAIS ");
        query.append(" FROM VCA_SEG_SOCIE s ");      	
        query.append(clausulaSinTodos);
        query.append(" ORDER BY s.VAL_DENO ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarEmpresas(DTOBelcorp , Boolean):Salida");
        return dtos;
    }

    public DTOSalida recuperarTiposPeriodo(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarTiposPeriodo(DTOBelcorp):Entrada");
        String entidad = (String)entidades.get("TiposPeriodo");
        //Hashtable atributos = cargarAtributosTraducibles(entidad);
        DTOSalida dtos =  new DTOSalida();
        
        dtos.setResultado(getCodigoDescripcionTraducible(entidad,
                                              new Integer(1),//new Integer(((BigDecimal)atributos.get("Nombre")).intValue()),
                                              dto.getOidIdioma(),
                                              new String[]{})); // Todo idioma
        UtilidadesLog.info("MONMantenimientoSEG.recuperarTiposPeriodo(DTOBelcorp):Salida");
        return dtos;

    }
    
    public DTOSalida recuperarAccesosPorCanal(DTOAccesosPorCanal dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarAccesosPorCanal(DTOAccesosPorCanal):Entrada");
        String user = ctx.getCallerPrincipal().getName();
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" iAcce.val_oid,  ");
        query.append(" iAcce.val_i18n ");
        query.append(" FROM vca_seg_acces s, V_GEN_I18N_SICC iAcce ");
        query.append(" WHERE iAcce.ATTR_ENTI = 'SEG_ACCES' ");
        query.append(" AND iAcce.IDIO_OID_IDIO = " + dtoe.getOidIdioma() + " ");
        query.append(" AND iAcce.VAL_OID = s.oid_acce  ");
        query.append(" AND iAcce.ATTR_NUM_ATRI = 1 ");
        query.append(" AND s.COD_USUA = '"+user+"' ");
      	query.append(" AND s.cana_oid_cana = "+ dtoe.getOidCanal() + " ");
        query.append(" ORDER BY iAcce.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarAccesosPorCanal(DTOAccesosPorCanal):Salida");
        return dtos;
    }
/**
 * Autor: Hugo Mansi
 * Fecha: 19/08/2004
 * Recibe: DTOSubaccesosPorAccesoYCanal
 * Devuelve: DTOSalida
 * Descripción: Consulta por DBService sobre la vista VCA_SEG_SUBAC, 
 * filtrando por usuario del contexto, obtiene todos los subaccesos 
 * para un acceso y un canal, recibe un dto de entrada "DTOSubaccesosPorAccesoYCanal" 
 * que lleva el oid de acceso, de canal y el idioma para recuperar el atributo 
 * internacionalizable en el idioma del usuario activo.
**/


/* NOTA: TENER EN CUENTA QUE EL FILTRADO 
 *       POR CANAL NO SE ESTÁ REALIZANDO 
 *       YA QUE EN LA BD, CADA ACCESO TIENE 
 *       UN CANAL ASOCIADO. ESTE METODO SE
 *       REALIZO PARA CUMPLIR CON LA CONSTRUCCIÓN
 *       DEL PAQUETE 18 N002. POR CUALQUIER DUDA
 *       O CONSULTA, DIRIGIRSE A HUGO MANSI O A
 *       LUIS RAMOS GIACOSA.
 */

    public DTOSalida recuperarSubaccesosPorAccesoCanal(DTOSubaccesosPorAccesoYCanal dtoe) throws MareException {
      UtilidadesLog.info("MONMantenimientoSEG.recuperarSubaccesosPorAccesoCanal(DTOSubaccesosPorAccesoYCanal):Entrada");
      StringBuffer query = new StringBuffer();
      String user = ctx.getCallerPrincipal().getName();
      RecordSet rs;
      try {       
			query.append(" select ");
			query.append(" OID_SBAC,");
			query.append(" i18nSub.VAL_I18N ");
			query.append(" from ");
			query.append(" VCA_SEG_SUBAC sub, ");
			query.append(" GEN_I18N_SICC i18nSub ");
			query.append(" Where ");
			query.append(" i18nSub.ATTR_ENTI = 'SEG_SUBAC' ");
			query.append(" and i18nSub.VAL_OID = sub.OID_SBAC ");
			query.append(" and i18nSub.IDIO_OID_IDIO = '" + dtoe.getOidIdioma() + "' ");
			query.append(" and sub.ACCE_OID_ACCE = '" + dtoe.getOidAcceso() + "' ");
            //NO SE UTILIZA LIKE POR TRATARSE DE UN CODIGO DE USUARIO Y NO DE UNA DESCRIPCION
            query.append(" and sub.COD_USUA = '"+user+"' ");
			query.append(" ORDER BY i18nSub.VAL_I18N ");
             
        rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
    } catch (MareException me) {
        UtilidadesLog.error("Error en recuperarSubaccesosPorAccesoYCanal");
        throw me; 
    } catch (SQLException se) {
        UtilidadesLog.error("Error en recuperarSubaccesosPorAccesoYCanal");
        throw new MareException();
    } catch (Exception e) {
        UtilidadesLog.error("Error en recuperarSubaccesosPorAccesoYCanal");
        throw new MareException("Error al recuperarSubaccesosPorAccesoYCanal",e);
    }
    DTOSalida sal = new DTOSalida();
    sal.setResultado(rs);
    UtilidadesLog.info("MONMantenimientoSEG.recuperarSubaccesosPorAccesoCanal(DTOSubaccesosPorAccesoYCanal):Salida");
    return sal;
  }

		
    public DTOSalida recuperarEmpresasPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarEmpresasPorPais(DTOBelcorp):Entrada");
        String user = ctx.getCallerPrincipal().getName();
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" s.OID_SOCI, ");
        query.append(" s.VAL_DENO ");
        query.append(" FROM vca_seg_socie s ");        
        query.append(" WHERE s.COD_USUA = '"+user+"' ");
      	query.append(" AND s.pais_oid_pais = "+ dto.getOidPais() + " ");
        query.append(" ORDER BY s.VAL_DENO ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarEmpresasPorPais(DTOBelcorp):Salida");
        return dtos;
    }
    
    public DTOSalida recuperarPeriodosPorTipoPeriodo(DTOPeriodosPorTipoPeriodo dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPeriodosPorTipoPeriodo(DTOPeriodosPorTipoPeriodo):Entrada");
        String entidad = (String)entidades.get("Periodo");
        //Hashtable atributos = cargarAtributosTraducibles(entidad);
        DTOSalida dtos =  new DTOSalida();
        
        dtos.setResultado(getCodigoDescripcionTraducibleFiltrados(entidad,
                                              new Integer(1),//new Integer(((BigDecimal)atributos.get("Descripción")).intValue()),
                                              dtoe.getOidIdioma(),
                                              new String[] {"TIPE_OID_TIPO_PERI"},
                                              new Object[] {dtoe.getOidTipoPeriodo()},
                                              new boolean[] {false},
                                              new String[]{})); // Todo idioma
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPeriodosPorTipoPeriodo(DTOPeriodosPorTipoPeriodo):Salida");
        return dtos;
    }

    

    // utiles
    private BelcorpService getBelcorpService() {
       try  {
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe)  {
            throw new EJBException( "MareMiiServiceNotFoundException: "
                        + mmsnfe.getMessage(), mmsnfe);
        } 
    }

    private RecordSet getCodigoDescripcionTraducible(String entidad,
                                                    Integer atributo,
                                                    Long idioma,
                                                    String[] lineasDinamicas)
    throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.getCodigoDescripcionTraducible(String , Integer, Long, String[]):Entrada");
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        
        String entidadInter = (String)entidades.get("Internacionalizacion");
        
        query.append("SELECT val_oid ");
        query.append(",val_i18n ");
        query.append(agregarCampoFK(entidad));
        query.append("FROM "+entidadInter+" ");
        query.append(armarJoin(entidadInter,entidad));
        query.append(UtilidadesBD.armarSQLWhere(new String[] {"ATTR_ENTI","ATTR_NUM_ATRI"},
                                                new Object[] {entidad,atributo},
                                                new boolean[] {false,false,false}));
        query.append(UtilidadesBD.armarSQLWhereDinamico(lineasDinamicas, " "));                                                                                       
            
        
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(UtilidadesI18N.armarSQLPatronI18n(query,idioma,"ORDER BY val_i18n "));
        } catch (MareException me) {
            UtilidadesLog.error("Error en getCodigoDescripcionTraducible");
            throw me; 
        } catch (Exception e) {
            UtilidadesLog.error("Error en getCodigoDescripcionTraducible");
            throw new MareException("Error al obtener codigo Descripcion traducibles",e);
        }

        if (rs.esVacio()) {
//        if (rs.esVacio()) {		// Deberia ser asi		
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoSEG.getCodigoDescripcionTraducible(String , Integer, Long, String[]):Salida");
        return rs;
    }

    

    private RecordSet getCodigoDescripcionTraducibleFiltrados(String entidad,
                                                              Integer atributo,
                                                              Long idioma,
                                                              String[] camposFiltro,
                                                              Object[] valoresFiltro,
                                                              boolean[] operadores,
                                                              String[] lineasDinamicas)
    throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.getCodigoDescripcionTraducibleFiltrados(String , Integer, Long, String[], Object[], boolean[], String[]):Salida");
        RecordSet rs;
        String entidadInter = (String)entidades.get("Internacionalizacion");
        StringBuffer query = new StringBuffer();
        String[] camposWhere = new String[10]; 
        camposWhere[0] = "ATTR_ENTI";
        camposWhere[1] = "ATTR_NUM_ATRI";
        //camposWhere[2] = entidadInter+".IDIO_OID_IDIO";
        Object[] valoresWhere = new Object[10];
        valoresWhere[0] = entidad;
        valoresWhere[1] = atributo;
        //valoresWhere[2] = idioma;
        boolean[] operadoresWhere = new boolean[10];
        operadoresWhere[0] = false;
        operadoresWhere[1] = false;
        //operadoresWhere[2] = false;

        for (int i= 0; i < camposFiltro.length; i++) {
            camposWhere[i+2] = entidad+"."+camposFiltro[i];
            valoresWhere[i+2] = valoresFiltro[i];
            operadoresWhere[i+2] = operadores[i];
        }

        try {
        
            query.append("SELECT val_oid ");
            query.append(",val_i18n ");
            query.append(agregarCampoFK(entidad));
            query.append("FROM "+entidadInter);
            query.append(armarJoin(entidadInter,entidad));
            query.append(UtilidadesBD.armarSQLWhere(camposWhere,valoresWhere,operadoresWhere));
            query.append(UtilidadesBD.armarSQLWhereDinamico(lineasDinamicas," "));      
                                                
            rs = getBelcorpService().dbService.executeStaticQuery(UtilidadesI18N.armarSQLPatronI18n(query,idioma," ORDER BY val_i18n "));
        } catch (MareException me) {
            UtilidadesLog.error("Error en getCodigoDescripcionTraducibleFiltrados");
            throw me; 
        } catch (SQLException e) {
            UtilidadesLog.error("Error en getCodigoDescripcionTraducibleFiltrados");
            throw new MareException();
        } catch (Exception e) {
            UtilidadesLog.error("Error en getCodigoDescripcionTraducibleFiltrados");
            throw new MareException("Error al obtener codigo Descripcion traducibles",e);
        }

        if (rs.esVacio()) {
            UtilidadesLog.error("Error en getCodigoDescripcionTraducibleFiltrados");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoSEG.getCodigoDescripcionTraducibleFiltrados(String , Integer, Long, String[], Object[], boolean[], String[]):Salida");
        return rs;
    }


/*
    private String armarJoin(String tablaPadre, String tablaHijo) throws MareException  {
        StringBuffer join = new StringBuffer();
        try {
            Connection conn = getBelcorpService().dbService.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet columnasPKPadre=metaData.getImportedKeys(null,null,tablaPadre);

            UtilidadesLog.debug(columnasPKPadre);
            join.append("INNER JOIN "+tablaPadre+" ON ");
            int cant=0;
            while (columnasPKPadre.next()) {
                UtilidadesLog.debug("primer row");
                UtilidadesLog.debug("FKTABLE_NAME: "+columnasPKPadre.getString("FKTABLE_NAME"));
                UtilidadesLog.debug(columnasPKPadre.getString("PKCOLUMN_NAME"));
                UtilidadesLog.debug(columnasPKPadre.getString("FKCOLUMN_NAME"));
                if (columnasPKPadre.getString("FKTABLE_NAME").equals(tablaHijo)) {
                    if (cant>0) {
                        join.append(" AND ");
                    }
                    join.append(tablaPadre+"."+columnasPKPadre.getString("PKCOLUMN_NAME") + " = "+tablaHijo+"."+columnasPKPadre.getString("FKCOLUMN_NAME"));
                    cant++;
                }
            }
            conn.close();
        } catch(SQLException e) {
            throw new MareException();
        } catch(Exception e) {
            throw new MareException();
        }
        join.append(" ");
        return join.toString();  
    }
*/

    private String armarJoin(String entidadInter, String tabla2) throws MareException  {
        UtilidadesLog.info("MONMantenimientoSEG.armarJoin(String , String):Entrada");
        StringBuffer join = new StringBuffer();
        Connection conn = null;
        try {
            conn = getBelcorpService().dbService.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            /*
             * Todas estas tablas tienen como pl un solo campo, sino no pueden
             * ser internacionalizables
             */
            ResultSet columnasPKTabla2=metaData.getPrimaryKeys(null,null,tabla2.toUpperCase());

            columnasPKTabla2.next();
            
            join.append(" INNER JOIN "+tabla2+" ON ");
            join.append(" VAL_OID= "+tabla2+"."+columnasPKTabla2.getString("COLUMN_NAME"));

            conn.close();
        } catch(SQLException e) {
            try {
                conn.close();
            } catch (SQLException sqle) {
            }
            throw new MareException();
        } catch(Exception e) {
            try {
                conn.close();
            } catch (SQLException sqle) {
            }
            throw new MareException();
        }
        join.append(" ");
        UtilidadesLog.debug(join);
        UtilidadesLog.info("MONMantenimientoSEG.armarJoin(String , String):Salida");
        return join.toString();  
    }

    private String agregarCampoFK(String entidad) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.agregarCampoFK(String):Entrada");
        StringBuffer join = new StringBuffer();
        Connection conn = null;
        try {
            conn = getBelcorpService().dbService.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            /*
             * Todas estas tablas tienen como pl un solo campo, sino no pueden
             * ser internacionalizables
             */
            ResultSet columnasFK=metaData.getImportedKeys(null,null,entidad.toUpperCase());

            while (columnasFK.next()) {
                join.append(", "+entidad+"."+columnasFK.getString("FKCOLUMN_NAME")+" ");
            }
            conn.close();
        } catch(SQLException e) {
            try {
                conn.close();
            } catch (SQLException sqle) {
            }
            throw new MareException();
        } catch(Exception e) {
            try {
                conn.close();
            } catch (SQLException sqle) {
            }
            throw new MareException();
        }
        join.append(" ");
        UtilidadesLog.debug(join);
        UtilidadesLog.info("MONMantenimientoSEG.agregarCampoFK(String):Salida");
        return join.toString();       
    }

    private Hashtable cargarAtributosTraducibles(String entidad) 
    throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.cargarAtributosTraducibles(String):Entrada");
        StringBuffer query = new StringBuffer();
        Hashtable atributos = new Hashtable();
        RecordSet rs;
        
        query.append("SELECT des_atri, ");
        query.append("num_atri ");
        query.append("FROM gen_atrib_tradu ");
        query.append(UtilidadesBD.armarSQLWhere(new String[] {"NOM_ENTI"},
                                                new Object[] {entidad},
                                                new boolean[] {false}));
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());     
        } catch (MareException me) {
            throw me; 
        } catch (Exception e) {
            throw new MareException("Error al obtener atributos traducibles",e);
        }

        if (!rs.esVacio()) {
            for (int i=0;i<rs.getRowCount();i++) {
                atributos.put((String)rs.getValueAt(i,0),(BigDecimal)rs.getValueAt(i,1));
            }
        }
        UtilidadesLog.info("MONMantenimientoSEG.cargarAtributosTraducibles(String):Salida");
        return atributos;
    }

    private Object obtiene(Hashtable h,String key) {
        Object o=null;
        try {
            o = h.get(key);
        } catch (Exception e) {
            return null;
        }
        return o;
    }

    

    private RecordSet ejecutarConsulta(String[] camposSelect,
                                       String entidad,
                                       String join,
                                       String[] camposWhere,
                                       Object[] valoresWhere,
                                       boolean[] operadores,
                                       String[] camposOrden)throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.ejecutarConsulta:Entrada");
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT "+camposSelect[0]);

        for (int i = 1; i < camposSelect.length; i++) {
            query.append(" ,"+camposSelect[i]+" ");   
        }

        query.append(" FROM "+entidad+" ");

        query.append(" "+ join + " ");
        
        query.append(UtilidadesBD.armarSQLWhere(camposWhere,
                                                valoresWhere,
                                             operadores));

        
        if (camposOrden!=null) {
            query.append(" ORDER BY "+camposOrden[0]); 

            for (int j = 1; j < camposOrden.length; j++) {
                query.append(" ,"+camposOrden[j]+" ");   
            }
        }
                                               
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me; 
        } catch (Exception e) {
            throw new MareException("Error al ejecutar consulta",e);
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoSEG.ejecutarConsulta:Salida");
        return rs;                                      
    }

    public DTOSalida recuperarTamanoTipoPeriodoPorCanal(Long canal) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarTamanoTipoPeriodoPorCanal(Long):Entrada");
        String entidad = (String)entidades.get("TiposPeriodo");
        DTOSalida dtos =  new DTOSalida();
        dtos.setResultado(this.ejecutarConsulta(new String[] {"NUM_DIAS"},
                                                entidad,
                                                "INNER JOIN SEG_CANAL CAN ON TIPE_OID_TIPO_PERI = OID_TIPO_PERI",
                                                new String[] {"OID_CANA"},
                                                new Object[] {canal},
                                                new boolean[] {false},
                                                null));
        UtilidadesLog.info("MONMantenimientoSEG.recuperarTamanoTipoPeriodoPorCanal(Long):Salida");
        return dtos;
    }

	/*
	 * Agregado a pedido de CRA
	 * */
	public DTOPMC obtienePaisMarcaCanalTodos(DTOFiltroPMC dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtienePaisMarcaCanalTodos(DTOFiltroPMC):Entrada");
        DTOPMC dtos = new DTOPMC();
        DTOInternacional inter = new DTOInternacional();
        inter.setOidIdioma(dtoe.getOidIdioma());

        if (dtoe.getPaises().booleanValue()) {
            dtos.setPaises(recuperarPaises(inter,Boolean.TRUE).getResultado());
        }
        if (dtoe.getMarcas().booleanValue()) {
            dtos.setMarcas(recuperarMarcas(inter,Boolean.TRUE).getResultado());
        }
        if (dtoe.getCanales().booleanValue()) {
            dtos.setCanales(this.recuperarCanales(inter,Boolean.TRUE).getResultado());
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtienePaisMarcaCanalTodos(DTOFiltroPMC):Salida");
        return dtos;
	}

    public DTOPMC obtienePaisMarcaCanal (DTOFiltroPMC dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtienePaisMarcaCanal(DTOFiltroPMC):Entrada");
        DTOPMC dtos = new DTOPMC();
        DTOInternacional inter = new DTOInternacional();
        inter.setOidIdioma(dtoe.getOidIdioma());

        if (dtoe.getPaises().booleanValue()) {
            dtos.setPaises(recuperarPaises(inter).getResultado());
        }
        if (dtoe.getMarcas().booleanValue()) {
            dtos.setMarcas(recuperarMarcas(inter).getResultado());
        }
        if (dtoe.getCanales().booleanValue()) {
            dtos.setCanales(this.recuperarCanales(inter).getResultado());
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtienePaisMarcaCanal(DTOFiltroPMC):Salida");
        return dtos;
    }

    public DTOSalida recuperarTiposVia (DTOBelcorp dto) 
    throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarTiposVia(DTOBelcorp):Entrada");
        
		RecordSet rs = null;
        StringBuffer query = new StringBuffer();
		query.append(" SELECT tipovia.OID_TIPO_VIA, i18n.VAL_I18N ");
		query.append(" FROM SEG_TIPO_VIA tipovia,V_GEN_I18N_SICC i18n ");
		query.append(" WHERE i18n.IDIO_OID_IDIO = "+ dto.getOidIdioma());
		query.append(" AND tipovia.OID_TIPO_VIA = i18n.VAL_OID ");
		query.append(" AND i18n.ATTR_ENTI = 'SEG_TIPO_VIA' ");
		query.append(" ORDER BY i18n.VAL_I18N ");

		 try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
	
        } catch (MareException me) {
            throw me; 
        } catch (Exception e) {
            throw new MareException("Error al ejecutar consulta",e);
        }
		DTOSalida dtos =  new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarTiposVia(DTOBelcorp):Salida");
        return dtos;
    }
    public DTOSalida recuperarDepartamentosPorPais (DTOBelcorp dto) 
    throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarDepartamentosPorPais(DTOBelcorp):Entrada");
        String entidad = (String)entidades.get("Departamentos");
        //Hashtable atributos = cargarAtributosTraducibles(entidad);
        DTOSalida dtos =  new DTOSalida();
        
        dtos.setResultado(getCodigoDescripcionTraducibleFiltrados(entidad,
                                              new Integer(1),//new Integer(((BigDecimal)atributos.get("Descripción larga")).intValue()),
                                              dto.getOidIdioma(),
                                              new String[] {"PAIS_OID_PAIS"},
                                              new Object[] {dto.getOidPais()},
                                              new boolean[] {false},
                                              new String[]{})); // Todo idioma
        UtilidadesLog.info("MONMantenimientoSEG.recuperarDepartamentosPorPais(DTOBelcorp):Salida");
        return dtos;
    }

    public DTOSalida recuperarDescripcionPais(DTOInternacional internacional) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarDescripcionPais(DTOInternacional):Entrada");
        String entidad = (String)entidades.get("Pais");
        //Hashtable atributos = cargarAtributosTraducibles(entidad);
        DTOSalida dtos =  new DTOSalida();
        
        dtos.setResultado(getCodigoDescripcionTraducibleFiltrados(entidad,
                                              new Integer(1),//new Integer(((BigDecimal)atributos.get("Nombre")).intValue()),
                                              internacional.getOidIdioma(),
                                              new String[] {"OID_PAIS"},
                                              new Object[] {internacional.getOidPais()},
                                              new boolean[] {false},
                                              new String[]{})); // Todo idioma
        UtilidadesLog.info("MONMantenimientoSEG.recuperarDescripcionPais(DTOInternacional):Salida");
        return dtos;
    }

    /**
     * Este método genera una instancia del Entity Bean de Pais, obtiene el 
     * dato "longitudNumeroCliente" y lo devuelve.
     * 
     * A la espera de la inc. 380 para confirmar el uso de JDBC
     */
    public Integer obtenerLongitudNumeroCliente(Long oidPais) 
        throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerLongitudNumeroCliente(Long):Entrada");

        RecordSet rs;
        String entidadPais = (String)entidades.get("Pais");
        StringBuffer query = new StringBuffer();

        String[] camposWhere = new String[1];
        camposWhere[0] = "OID_PAIS";

        Object[] valoresWhere = new Object[1];
        valoresWhere[0] = oidPais;

        boolean[] operadoresWhere = new boolean[1];
        operadoresWhere[0] = false;

        try {
        
            query.append("SELECT NUM_POSI_NUME_CLIE ");
            query.append("FROM " + entidadPais);
            query.append(UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere, operadoresWhere));
                                                
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("Error en obtenerLongitudNumeroCliente");
            throw me; 
        } catch (SQLException e) {
            UtilidadesLog.error("Error en obtenerLongitudNumeroCliente");
            throw new MareException();
        } catch (Exception e) {
            UtilidadesLog.error("Error en obtenerLongitudNumeroCliente");
            throw new MareException("Error al obtener Longitud Numero Cliente",e);
        }

        if (rs.esVacio() || rs.getValueAt(0,0)==null) {
            UtilidadesLog.error("Error en obtenerLongitudNumeroCliente");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtenerLongitudNumeroCliente(Long):Salida");
        return new Integer(rs.getValueAt(0,0).toString());
    }

    /**
     * Recibe como parámetro la clave natural, el código de tipo String, 
     * que es único para cada Canal, y devuelve su oid.
     */
    public Long obtenerOidCanal(String codigo) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidCanal(String):Entrada");
        RecordSet rs;
        String entidadPais = (String)entidades.get("Canales");
        StringBuffer query = new StringBuffer();

        String[] camposWhere = new String[1];
        camposWhere[0] = "COD_CANA";

        Object[] valoresWhere = new Object[1];
        valoresWhere[0] = codigo;

        boolean[] operadoresWhere = new boolean[1];
        operadoresWhere[0] = false;

        try {
        
            query.append("SELECT OID_CANA ");
            query.append("FROM " + entidadPais);
            query.append(UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere, operadoresWhere));
                                                
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("Error en obtenerOidCanal");
            throw me; 
        } catch (SQLException e) {
            UtilidadesLog.error("Error en obtenerOidCanal");
            throw new MareException();
        } catch (Exception e) {
            UtilidadesLog.error("Error en obtenerOidCanal");
            throw new MareException("Error al obtener el oId de Canal",e);
        }

        if (rs.esVacio() || rs.getValueAt(0,0)==null) {
            UtilidadesLog.error("Error en obtenerOidCanal");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidCanal(String):Salida");
        return new Long(rs.getValueAt(0,0).toString());
    }

    public Long obtenerOidPais(String codigo) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidPais(String):Entrada");
        RecordSet rs;
        String entidadPais = (String)entidades.get("Pais");
        StringBuffer query = new StringBuffer();

        String[] camposWhere = new String[1];
        camposWhere[0] = "COD_PAIS";

        Object[] valoresWhere = new Object[1];
        valoresWhere[0] = codigo;

        boolean[] operadoresWhere = new boolean[1];
        operadoresWhere[0] = false;

        try {
        
            query.append("SELECT OID_PAIS ");
            query.append("FROM " + entidadPais);
            query.append(UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere, operadoresWhere));
                                                
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("Error en obtenerOidPais");
            throw me; 
        } catch (SQLException e) {
            UtilidadesLog.error("Error en obtenerOidPais");
            throw new MareException();
        } catch (Exception e) {
            UtilidadesLog.error("Error en obtenerOidPais");
            throw new MareException("Error al obtener el oId de Pais",e);
        }

        if (rs.esVacio() || rs.getValueAt(0,0)==null) {
            UtilidadesLog.error("Error en obtenerOidPais");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidPais(String):Salida");
        return new Long(rs.getValueAt(0,0).toString());
    }

    public Long obtenerOidMarca(String codigo) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidMarca(String):Entrada");
        RecordSet rs;
        String entidadPais = (String)entidades.get("Marcas");
        StringBuffer query = new StringBuffer();

        String[] camposWhere = new String[1];
        camposWhere[0] = "COD_MARC";

        Object[] valoresWhere = new Object[1];
        valoresWhere[0] = codigo;

        boolean[] operadoresWhere = new boolean[1];
        operadoresWhere[0] = false;

        try {
        
            query.append("SELECT OID_MARC ");
            query.append("FROM " + entidadPais);
            query.append(UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere, operadoresWhere));
                                                
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("Error en obtenerOidMarca");
            throw me; 
        } catch (SQLException e) {
            UtilidadesLog.error("Error en obtenerOidMarca");
            throw new MareException();
        } catch (Exception e) {
            UtilidadesLog.error("Error en obtenerOidMarca");
            throw new MareException("Error al obtener el oId de Marca",e);
        }

        if (rs.esVacio() || rs.getValueAt(0,0)==null) {
            UtilidadesLog.error("Error en obtenerOidPais");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidMarca(String):Salida");
        return new Long(rs.getValueAt(0,0).toString());
    }

    public DTOSalida recuperarModulos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarModulos(DTOBelcorp):Entrada");
        String entidad = (String)entidades.get("Modulos");
        //Hashtable atributos = cargarAtributosTraducibles(entidad);
        DTOSalida dtos =  new DTOSalida();
        
        dtos.setResultado(getCodigoDescripcionTraducible(entidad,
                                              new Integer(1),//new Integer(((BigDecimal)atributos.get("Descripción")).intValue()),
                                              dto.getOidIdioma(),
                                              new String[]{})); // Todo idioma
        UtilidadesLog.info("MONMantenimientoSEG.recuperarModulos(DTOBelcorp):Salida");
        return dtos;
    }

    public DTOSalida recuperarNacionalidades(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarNacionalidades(DTOBelcorp):Entrada");
        String entidad = (String)entidades.get("Nacionalidad");
        //Hashtable atributos = cargarAtributosTraducibles(entidad);
        DTOSalida dtos =  new DTOSalida();
        
        dtos.setResultado(getCodigoDescripcionTraducible(entidad,
                                              new Integer(1),//new Integer(((BigDecimal)atributos.get("Descripción")).intValue()),
                                              dto.getOidIdioma(),
                                              new String[]{})); // Todo idioma
        UtilidadesLog.info("MONMantenimientoSEG.recuperarNacionalidades(DTOBelcorp):Salida");
        return dtos;
    }
    //modificado por C Noziglia 09/09/2005
    public Long obtenerOidTipoVia(String codigo) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidTipoVia(String):Entrada");
        RecordSet rs;
        StringBuffer query = new StringBuffer();


        try {
        
            query.append("SELECT OID_TIPO_VIA ");
            query.append("FROM SEG_TIPO_VIA ");
            query.append("WHERE COD_TIPO_VIA ");
            if(codigo!=null){
                query.append("LIKE '"+codigo+"'");
            }else{
                query.append("IS NULL");    
            }
            
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            getBelcorpService().log.info("Error en obtenerOidTipoVia");
            throw me; 
        } catch (SQLException e) {
            UtilidadesLog.error(e);
            getBelcorpService().log.info("Error en obtenerOidTipoVia");
            throw new MareException();
        } catch (Exception e) {
            UtilidadesLog.error(e);
            UtilidadesLog.error("Error en obtenerOidTipoVia");
            throw new MareException("Error al obtener el Oid de Tipo de Via",e);
        }

        if (rs.esVacio() || rs.getValueAt(0,0)==null) {
            return null;
       //     getBelcorpService().log.info("Error en obtenerOidTipoVia");
        //    throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidTipoVia(String):Salida");
        return new Long(rs.getValueAt(0,0).toString());
    }

  public void insertarSubacceso(DTOSubacceso dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.insertarSubacceso(DTOSubacceso):Entrada");
      try{
          SubaccesoLocalHome saLH = getSubaccesosLocalHome();
          Entidadi18nLocalHome e18nLH = getEntidadi18nLocalHome();
          SubaccesoLocal saL = saLH.create(dto.getCodigoSubacceso(),dto.getOidAcceso());
          //esta era la linea anterior SubaccesoLocal saL = saLH.create(dto.getCodigoSubacceso(),dto.getOidAcceso(),dto.getDescripcionUbigeo());
          //e18nLH.create("SEG_SUBAC", new Long(1),dto.getOidIdioma(),dto.getDescripcionSubaccesoBusqueda(),saL.getOid());   
          //Para cuando ande multiiodoma
          for (int i=0;i<dto.getDescripcionesSubacceso().size();i++){
              DTOI18nSICC dtoTraduccion = (DTOI18nSICC)dto.getDescripcionesSubacceso().elementAt(i);//devuelve los datos de la traduccion
              Long oidIdioma = dtoTraduccion.getOidIdioma();
              String descripcion = dtoTraduccion.getValorI18n();
              e18nLH.create("SEG_SUBAC",new Long(1),oidIdioma,descripcion,saL.getOid());    
          }
      }catch(PersistenceException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.info("MONMantenimientoSEG.insertarSubacceso(DTOSubacceso):Salida");
  }

  public void modificarSubacceso(DTOSubacceso dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.modificarSubacceso(DTOSubacceso):Entrada");
      try{
          SubaccesoLocalHome saLH = getSubaccesosLocalHome();
          SubaccesoLocal saL = saLH.findByPrimaryKey(dto.getOidSubacceso());
          Entidadi18nLocalHome e18nLH = getEntidadi18nLocalHome();
          try{
              Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK( "SEG_SUBAC", new Long(1), dto.getOidIdioma(), saL.getOid());
              e18nL.setDetalle(dto.getDescripcionSubaccesoBusqueda());
              e18nLH.merge(e18nL);
          }catch(NoResultException e){
              UtilidadesLog.debug("No se encontro la descripcion para ese idioma, vamos a crearlo");
              try {
                e18nLH.create("SEG_SUBAC",new Long(1),dto.getOidIdioma(),dto.getDescripcionSubaccesoBusqueda(),saL.getOid());
              } catch (PersistenceException pe) {
                  ctx.setRollbackOnly();
                  String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                  throw new MareException(pe, UtilidadesError.armarCodigoError(error));
              }
          }catch(PersistenceException e){
              ctx.setRollbackOnly();
              String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              throw new MareException(e, UtilidadesError.armarCodigoError(error));
          }
          //Para multiidioma
          for (int i=0;i<dto.getDescripcionesSubacceso().size();i++){
              DTOI18nSICC dtoTraduccion = (DTOI18nSICC)dto.getDescripcionesSubacceso().elementAt(i);//devuelve los datos de la traduccion
              Long oidIdioma = dtoTraduccion.getOidIdioma();
              String descripcion = dtoTraduccion.getValorI18n();
              try{
                  Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK( "SEG_SUBAC", new Long(1), oidIdioma, saL.getOid());
                  e18nL.setDetalle(descripcion);
                  e18nLH.merge(e18nL);
              }catch(NoResultException e){
                  UtilidadesLog.debug("No se encontro la descripcion para ese idioma, vamos a crearlo");
                  try {
                    e18nLH.create("SEG_SUBAC",new Long(1),oidIdioma,descripcion,saL.getOid());
                  } catch (PersistenceException pe) {
                      ctx.setRollbackOnly();
                      String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                      throw new MareException(e, UtilidadesError.armarCodigoError(error));
                  }
              }catch(PersistenceException e){
                  ctx.setRollbackOnly();
                  String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                  throw new MareException(e, UtilidadesError.armarCodigoError(error));
              }
          }
          saL.setOidAcceso(dto.getOidAcceso());
          saL.setCodigo( dto.getCodigoSubacceso() );
          saLH.merge(saL);
      }catch(NoResultException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }catch(PersistenceException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      UtilidadesLog.info("MONMantenimientoSEG.modificarSubacceso(DTOSubacceso):Salida");
  }

  public void eliminarSubaccesos(DTOOIDs dtos) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.eliminarSubaccesos(DTOOIDs):Entrada");
      try{
          SubaccesoLocalHome saLH = getSubaccesosLocalHome();
          Entidadi18nLocalHome e18nLH = getEntidadi18nLocalHome();
          Long[] oids = dtos.getOids();          
          for (int i=0; i<oids.length;i++){
              Long oidActual = oids[i];
              SubaccesoLocal saL = saLH.findByPrimaryKey(oidActual);
              Collection col = e18nLH.findByEntAtrPK("SEG_SUBAC",new Long(1),saL.getOid());
              Iterator it = col.iterator();
              while (it.hasNext()){
                  Entidadi18nLocal e18nLocal= (Entidadi18nLocal)it.next();
                  try {
                    e18nLH.remove(e18nLocal);
                  } catch (PersistenceException pe) {
                      ctx.setRollbackOnly();
                      UtilidadesLog.error(CodigosError.ERROR_DE_BORRADO_DE_DATOS);
                      throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                  }
              }
              saLH.remove(saL);
          }
      }catch(NoResultException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }catch(PersistenceException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      UtilidadesLog.info("MONMantenimientoSEG.eliminarSubaccesos(DTOOIDs):Salida");
  }

  public DTOValidarUbigeo validarUbigeo(DTOSubacceso dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.validarUbigeo(DTOSubacceso):Entrada");
      try{
          MONUnidadesGeograficas mug = getMONUnidadesGeograficasHome().create();
          DTOValidarUbigeo dtos = new DTOValidarUbigeo();
          dtos.setUbigeoValido(mug.validarUBIGEO(dto.getOidPais(),dto.getDescripcionUbigeo()));
          UtilidadesLog.info("MONMantenimientoSEG.validarUbigeo(DTOSubacceso):Salida");
          return dtos;
      }catch(NamingException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }catch(RemoteException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }catch(CreateException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
  }

  private SubaccesoLocalHome getSubaccesosLocalHome() {
      return new SubaccesoLocalHome();
  }

  public DTOSalida buscarPorCriterioSubacceso(DTOSubacceso dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.buscarPorCriterioSubacceso(DTOSubacceso):Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs;
    try {       
        query.append(" select ")
             .append("   OID_SBAC,") 
             .append("   COD_SBAC, ")
             .append("   i18nSub.VAL_I18N as DES_SUBACC, ")
             .append("   i18nCanal.VAL_I18N as DES_CANAL, ")
             .append("   i18nAcc.VAL_I18N as DES_ACCESO, ")
             //.append("   geo.DES_GEOG ")
             //.append("   sub.VAL_UBIG")
             .append(" from ")
             .append("   SEG_SUBAC sub, ")
             .append("   GEN_I18N_SICC i18nSub, GEN_I18N_SICC i18nAcc, ")
             .append("   SEG_ACCES acc, GEN_I18N_SICC i18nCanal ")
             .append(" where ")
             //.append("   geo.OID_VALO_ESTR_GEOP = sub.VEPO_OID_VALO_ESTR_GEOP ")
             .append("   i18nAcc.ATTR_ENTI = 'SEG_ACCES' ")
             .append("   and i18nAcc.VAL_OID = sub.ACCE_OID_ACCE ")
             .append("   and i18nAcc.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "' ")
             .append("   and i18nSub.ATTR_ENTI = 'SEG_SUBAC' ")
             .append("   and i18nSub.VAL_OID = sub.OID_SBAC ")
             .append("   and i18nSub.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "' ")
             .append("   and acc.OID_ACCE = sub.ACCE_OID_ACCE ")
             .append("   and i18nCanal.ATTR_ENTI = 'SEG_CANAL' ")
             .append("   and i18nCanal.VAL_OID = acc.CANA_OID_CANA ")
             .append("   and i18nCanal.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "' ");
        // Filtros:
        
        if (( dto.getCodigoSubacceso() != null)  &&  (!dto.getCodigoSubacceso().trim().equals(""))){
            if (contieneComodin(dto.getCodigoSubacceso(),"%"))
               query.append("   and sub.COD_SBAC like '" + dto.getCodigoSubacceso() + "' ");
            else
               query.append("   and sub.COD_SBAC = '" + dto.getCodigoSubacceso() + "' ");
            }
        if (( dto.getDescripcionSubaccesoBusqueda() != null) && (!dto.getDescripcionSubaccesoBusqueda().trim().equals(""))) {
            if (contieneComodin(dto.getDescripcionSubaccesoBusqueda(),"%"))
               query.append("   and i18nSub.VAL_I18N like '" + dto.getDescripcionSubaccesoBusqueda() + "' ");
            else
               query.append("   and i18nSub.VAL_I18N = '" + dto.getDescripcionSubaccesoBusqueda() + "' ");
            }
              
        if ( dto.getOidCanal() != null)
          query.append("   and acc.CANA_OID_CANA = '" + dto.getOidCanal() + "' ");
        if ( dto.getOidAcceso() != null )
          query.append("   and sub.ACCE_OID_ACCE = '" + dto.getOidAcceso() + "' ");

/*        if (( dto.getDescripcionUbigeo() != null ) && (!dto.getDescripcionUbigeo().trim().equals(""))){
            if (contieneComodin(dto.getDescripcionUbigeo(),"%"))
               query.append("   and sub.VAL_UBIG like '" + dto.getDescripcionUbigeo() + "' ");
            else
               query.append("   and sub.VAL_UBIG = '" + dto.getDescripcionUbigeo() + "' ");
            }
*/        
        rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
    } catch (MareException me) {
        UtilidadesLog.error("Error en buscarPorCriterioSubacceso");
        throw me; 
    } catch (SQLException e) {
        UtilidadesLog.error("Error en buscarPorCriterioSubacceso");
        throw new MareException();
    } catch (Exception e) {
        UtilidadesLog.error("Error en buscarPorCriterioSubacceso");
        throw new MareException("Error al buscarPorCriterioSubacceso",e);
    }
    if (rs.esVacio()){
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    DTOSalida sal = new DTOSalida();
    sal.setResultado(rs);
    UtilidadesLog.info("MONMantenimientoSEG.buscarPorCriterioSubacceso(DTOSubacceso):Salida");
    return sal;
  }

    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
        return new Entidadi18nLocalHome();
    }
    
    private MONUnidadesGeograficasHome getMONUnidadesGeograficasHome() 
  throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONUnidadesGeograficasHome)PortableRemoteObject.narrow(
        context.lookup("java:comp/env/MONUnidadesGeograficas"), MONUnidadesGeograficasHome.class);
  }

  /*
   * Documentation
   * Este método recupera todos los atributos del pais correspondiente al oid del 
   * DTOOID de entrada. Si este atributo es igual a NULL, se realiza mediante JDBC 
   * con un join entre la tabla Paises de SEG, y la tabla CMN_PAIS_INSTANCIA 
   * (nombre lógico) para recuperar el pais de la instancia. Se tomará el oidIdioma 
   * del DTOOID, que hereda de DTOBelcorp, de entrada para recuperar la descripción 
   * del país traducida haciendo joing con la tabla GEN_I18N_SICC
   */
    public DTOSalida recuperarPais(DTOOID dtoOid) 
    throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPais(DTOOID):Entrada");
        String codigoError;
        DTOSalida dtos = new DTOSalida();
        RecordSet rs = new RecordSet();
        StringBuffer query  = new StringBuffer();
        query.append("   select OID_PAIS, ");
        query.append("   OID_PAIS, ");
        query.append("   COD_PAIS, ");
        query.append("   VAL_I18N, "); 
        query.append("   VAL_IDEN, "); 
        query.append("   VAL_PROG_EJEC, "); 
        query.append("   VAL_PORC_ALAR, "); 
        query.append("   VAL_TIEM_REZO, "); 
        query.append("   VAL_CONF_SECU_CCC, "); 
        query.append("   NUM_LIMI_DIFE_PAGO, "); //Por script 399
        query.append("   VAL_MAXI_DIFE_ANLS_COMB, "); 
       // query.append("   VAL_MOVI_RESE_CALL_CENT, "); 
        query.append("   NUM_DIAS_MORA, "); 
        query.append("   NUM_DIAS_FACT, "); 
        //query.append("   NUM_DIAS_CADU_RESE, "); 
        query.append("   NUM_POSI_NUME_CLIE, "); 
        query.append("   MONE_OID_MONE, "); 
        query.append("   MONE_OID_MONE_ALT, "); 
        query.append("   IND_SALD_UNIC, "); 
        query.append("   IND_INTE_GIS, "); 
        query.append("   IND_COMP_AUTO, "); 
        query.append("   IND_TRAT_ACUM_DESC, "); 
        query.append("   IND_EMIS_VENC, "); 
        query.append("   VAL_FORM_FECH, "); 
       // query.append("   NUM_DECI, "); 
        query.append("   VAL_SEPA_MILE, "); 
        query.append("   VAL_SEPA_DECI, "); 
        query.append("   NUM_PERI_EGRE, "); 
        query.append("   NUM_PERI_RETI, "); 
        query.append("   FOPA_OID_FORM_PAGO, ");
        query.append("   VAL_URL ");
        query.append("   from seg_pais a ");
        query.append("   inner join v_gen_i18n_sicc b on ");
        query.append("   ATTR_ENTI = 'SEG_PAIS' ");
        query.append("   and b.ATTR_NUM_ATRI = 1 "); 
        query.append("   and b.IDIO_OID_IDIO = "+dtoOid.getOidIdioma()+" "); 
        query.append("   and b.VAL_OID = a.OID_PAIS ");
        
		//11/10/2005 - rgiorgi: cambio por incidencia 21188
		if (dtoOid!=null && 
			dtoOid.getOid() != null && 
			dtoOid.getOid().longValue() != -1 ){

			if (dtoOid!=null && 
				dtoOid.getOid()!=null) {
				query.append(" and a.OID_PAIS = "+dtoOid.getOid()+" ");
			} else {
				query.append(" inner join GEN_PAIS_ACTIV c on a.OID_PAIS = c.PAIS_OID_PAIS ");
			}
		}
		
		//11/10/2005 - rgiorgi: cambio por incidencia 21188
		query.append(" order by VAL_I18N ");
		
        try {             
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        }  

        if ((rs==null) || (rs != null && rs.esVacio())) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(codigoError));
        } else {
            dtos.setResultado(rs);
        }
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPais(DTOOID):Salida");
        return dtos;
    }

	public Boolean usaGeoreferenciador(Long oidPais) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.usaGeoreferenciador(Long):Salida");
		RecordSet rs = new RecordSet();
		StringBuffer query = new StringBuffer();
        BelcorpService bs;

		query.append("SELECT ind_inte_gis ");
		query.append("  FROM seg_pais ");
		query.append(" WHERE oid_pais = " + oidPais);

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, 
				UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
		
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
		}catch(Exception ex) {
            throw new MareException(ex, 
				UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		
		String resultado = (String) rs.getValueAt(0,0);
		//Incidencia 5020, se cambia R por G.
		if ( (resultado != null) && !(resultado.equals("")) && resultado.equals("G")){
            UtilidadesLog.info("MONMantenimientoSEG.usaGeoreferenciador(Long):Salida");
			return Boolean.TRUE;
		} else {
            UtilidadesLog.info("MONMantenimientoSEG.usaGeoreferenciador(Long):Salida");
            return Boolean.FALSE;
            }
	}

     private boolean contieneComodin(String aString, String aChar){

        if (aString.indexOf(aChar) != -1) 
            return true;
        else
            return false;
     } 

  public DTOSalida obtenerSubaccesosPorAcceso(DTOOID dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.obtenerSubaccesosPorAcceso(DTOOID):Entrada");
    StringBuffer query = new StringBuffer();
    String user = ctx.getCallerPrincipal().getName();
    RecordSet rs;
    try {       
        query.append(" select ")
             .append("   OID_SBAC,") 
             .append("   i18nSub.VAL_I18N ")
             .append(" from ")
             .append("   VCA_SEG_SUBAC sub, ")
             .append("   GEN_I18N_SICC i18nSub ")
             .append(" where ")
             .append("   i18nSub.ATTR_ENTI = 'SEG_SUBAC' ")
             .append("   and i18nSub.VAL_OID = sub.OID_SBAC ")
             .append("   and i18nSub.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "' ")
             .append("   and sub.ACCE_OID_ACCE = '" + dto.getOid() + "' ")
             .append("   and sub.COD_USUA = '"+user+"' ")
             .append(" ORDER BY i18nSub.VAL_I18N ");
             
        rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
    } catch (MareException me) {
        UtilidadesLog.error("Error en buscarPorCriterioSubacceso");
        throw me; 
    } catch (SQLException e) {
        UtilidadesLog.error("Error en buscarPorCriterioSubacceso");
        throw new MareException();
    } catch (Exception e) {
        UtilidadesLog.error("Error en buscarPorCriterioSubacceso");
        throw new MareException("Error al buscarPorCriterioSubacceso",e);
    }
    DTOSalida sal = new DTOSalida();
    sal.setResultado(rs);
    UtilidadesLog.info("MONMantenimientoSEG.obtenerSubaccesosPorAcceso(DTOOID):Salida");
    return sal;
  }

  /* Busca en la entidad Vinculos de Jerarquia */
  public DTOSalida buscarVinculosJerarquia(DTOEBuscarVinculosJerarquia dto) throws MareException {

    UtilidadesLog.info("MONMantenimientoSEG.buscarVinculosJerarquia(DTOEBuscarVinculosJerarquia):Entrada");

    DTOSalida dtoSal = new DTOSalida();

    StringBuffer query = new StringBuffer();
    query.append(" SELECT ");
    query.append(" S.OID_VINC_JERA OID, ");
    query.append(" S.PAIS_OID_PAIS, ");
    query.append(" S.MARC_OID_MARC, ");
    query.append(" S.CANA_OID_CANA, ");
    query.append(" S.ACCE_OID_ACCE, ");
    query.append(" S.SBAC_OID_SBAC, ");
    query.append(" M.DES_MARC, ");
    //Internacionalizacion
    query.append(" ICanal.VAL_I18N DES_SEG_CANAL, ");
    query.append(" IAcceso.VAL_I18N DES_SEG_ACCES, ");
    query.append(" ISubAcc.VAL_I18N DES_SEG_SUBAC, ");
    query.append(" soci.VAL_DENO DES_SEG_SOCIE ");

    query.append(" FROM SEG_VINCU_JERAR S, SEG_MARCA M, SEG_SOCIE soci, ");
    //Internacionalizacion
    query.append(" V_GEN_I18N_SICC ICanal, V_GEN_I18N_SICC IAcceso, V_GEN_I18N_SICC ISubAcc ");

    query.append(UtilidadesBD.armarSQLWhere(
            new String[] {
                "S.PAIS_OID_PAIS", "S.MARC_OID_MARC", "S.CANA_OID_CANA", 
                "S.ACCE_OID_ACCE","S.SBAC_OID_SBAC","S.SOCI_OID_SOCI"
            },
            new Object[] {
                dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal(),
                dto.getOidAcceso(), dto.getOidSubacceso(), dto.getOidEmpresa()
            },
            new boolean[] {
                false, false, false, false, false, false
            }));

    query.append(" AND  M.OID_MARC(+) = S.MARC_OID_MARC ");
    query.append(" AND  soci.OID_SOCI(+) = S.SOCI_OID_SOCI ");
    //SEG_CANAL
    query.append(" AND ICanal.ATTR_ENTI(+) = 'SEG_CANAL'  ");
    query.append(" AND ICanal.IDIO_OID_IDIO(+) = " + dto.getOidIdioma() + " ");
    query.append(" AND ICanal.VAL_OID(+) = S.CANA_OID_CANA  ");
    query.append(" AND ICanal.ATTR_NUM_ATRI(+) = 1 ");
    //SEG_ACCES
    query.append(" AND IAcceso.ATTR_ENTI(+) = 'SEG_ACCES'  ");
    query.append(" AND IAcceso.IDIO_OID_IDIO(+) = " + dto.getOidIdioma() + " ");
    query.append(" AND IAcceso.VAL_OID(+) = S.ACCE_OID_ACCE  ");
    query.append(" AND IAcceso.ATTR_NUM_ATRI(+) = 1 ");
    //SEG_SUBAC
    query.append(" AND ISubAcc.ATTR_ENTI(+) = 'SEG_SUBAC'  ");
    query.append(" AND ISubAcc.IDIO_OID_IDIO(+) = " + dto.getOidIdioma() + " ");
    query.append(" AND ISubAcc.VAL_OID(+) = S.SBAC_OID_SBAC  ");
    query.append(" AND ISubAcc.ATTR_NUM_ATRI(+) = 1 ");

    query.append(" ORDER BY S.OID_VINC_JERA");

    String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);

    RecordSet rs;

    try {
        rs = getBelcorpService().dbService.executeStaticQuery(queryStr);
        UtilidadesLog.debug("resultado  " + rs.toString());
        dtoSal.setResultado(rs);
    } catch (MareException me) {
        throw me;
    } catch (Exception e) {
        throw new MareException(e, 
    				UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }

    if (rs==null || rs.esVacio()) {
        throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    
    }
    UtilidadesLog.info("MONMantenimientoSEG.buscarVinculosJerarquia(DTOEBuscarVinculosJerarquia):Salida");
    return dtoSal;
  }

  /* Elimina elementos de la entidad Vinculos de Jerarquia */
  public void eliminarVinculosJerarquia(DTOOIDs dto) throws MareException {
    try {
        UtilidadesLog.info("MONMantenimientoSEG.eliminarVinculosJerarquia(DTOOIDs):Entrada");

        VinculoJerarquiaLocalHome vHome = getVinculoJerarquiaLocalHome();

        for(int i = 0; i < dto.getOids().length; i++) {
          VinculoJerarquiaLocal vLocal = vHome.findByPrimaryKey(dto.getOids()[i]);
          UtilidadesLog.debug("A punto de eliminar VinculoJerarquia con OID = " + dto.getOids()[i]);
          vHome.remove(vLocal);
        }

    } catch(PersistenceException e) {
        ctx.setRollbackOnly();
        String error = (e instanceof NoResultException)?
            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE : CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    }
    UtilidadesLog.info("MONMantenimientoSEG.eliminarVinculosJerarquia(DTOOIDs):Salida");
  }

    private VinculoJerarquiaLocalHome getVinculoJerarquiaLocalHome() {
        return new VinculoJerarquiaLocalHome();
    }
    
    /* Guarda un Vinculos de Jerarquia */
  public void guardarVinculosJerarquia(DTOEVinculoJerarquia dto) throws MareException  {
    UtilidadesLog.info("MONMantenimientoSEG.guardarVinculosJerarquia(DTOEVinculoJerarquia):Entrada");
      try{
          VinculoJerarquiaLocalHome vHome = getVinculoJerarquiaLocalHome();
          vHome.create(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal(), dto.getOidAcceso(), 
                               dto.getOidSubacceso(), dto.getOidEmpresa());
      }catch(PersistenceException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
    UtilidadesLog.info("MONMantenimientoSEG.guardarVinculosJerarquia(DTOEVinculoJerarquia):Salida");
  }

  public DTOSalida recuperarSubaccesosCriterios(DTOEBuscarSubaccesos dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.recuperarSubaccesosCriterios(DTOEBuscarSubaccesos):Entrada");
       StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet recordSet;
        
        String codigo = dto.getCodigoSubacceso();
        String descripcion = dto.getDescripcionSubacceso();
        Long oidAcceso = dto.getOidAcceso();
        Long oidCanal = dto.getOidCanal();
        
        Integer atributo = new Integer(1);
        Long idioma = dto.getOidIdioma();
        String usuario = ctx.getCallerPrincipal().getName();

        query.append(" SELECT vsbac.OID_SBAC OID, vsbac.COD_SBAC, i18n.VAL_I18N DES_SUBACC, ");
        query.append(" i18n3.VAL_I18N DES_CANAL, i18n2.VAL_I18N DES_ACCESO ");
        query.append(" FROM VCA_SEG_SUBAC vsbac, V_GEN_I18N_SICC i18n, VCA_SEG_ACCES vacc, V_GEN_I18N_SICC i18n2, V_GEN_I18N_SICC i18n3 ");
        query.append(" WHERE vsbac.COD_USUA = '"+usuario+"' ");
        query.append(" AND i18n.ATTR_ENTI = 'SEG_SUBAC' ");
        query.append(" AND i18n.ATTR_NUM_ATRI = "+atributo+" ");
        query.append(" AND i18n.IDIO_OID_IDIO = "+idioma+" ");
        query.append(" AND i18n.VAL_OID = vsbac.OID_SBAC "); 
       // if (descripcion!=null) query.append(" AND i18n.VAL_I18N = '"+descripcion+"' "); 
        query.append(" AND vsbac.ACCE_OID_ACCE = vacc.OID_ACCE ");
        query.append(" AND vsbac.COD_USUA = vacc.COD_USUA ");
        query.append(" AND i18n2.ATTR_ENTI = 'SEG_ACCES' ");  
        query.append(" AND i18n2.ATTR_NUM_ATRI = "+atributo+" ");
        query.append(" AND i18n2.IDIO_OID_IDIO = "+idioma+" ");
        query.append(" AND i18n2.VAL_OID = vacc.OID_ACCE ");
        //query.append(" AND i18n2.VAL_I18N = 'Acceso 1' "); 
        query.append(" AND i18n3.ATTR_ENTI = 'SEG_CANAL' ");  
        query.append(" AND i18n3.ATTR_NUM_ATRI = "+atributo+" ");
        query.append(" AND i18n3.IDIO_OID_IDIO = "+idioma+" ");
        query.append(" AND i18n3.VAL_OID = vacc.CANA_OID_CANA ");
        //query.append(" AND i18n3.VAL_I18N = 'Venta Directa' ");        
        if (oidAcceso!=null) query.append(" AND vsbac.ACCE_OID_ACCE = "+oidAcceso+" ");
        if (oidCanal!=null) query.append(" AND vacc.CANA_OID_CANA = "+oidCanal+" ");

        if (( codigo != null)  &&  (!codigo.trim().equals(""))){
            if (contieneComodin(codigo,"%"))
               query.append("   AND vsbac.COD_SBAC LIKE '" + codigo.toUpperCase() + "' ");
            else
               query.append("   AND vsbac.COD_SBAC = '" + codigo.toUpperCase() + "' ");
            }
        if (( descripcion != null) && (!descripcion.trim().equals(""))) {
            if (contieneComodin(descripcion,"%"))
               query.append("   AND i18n.VAL_I18N LIKE '" + descripcion + "' ");
            else
               query.append("   AND i18n.VAL_I18N = '" + descripcion + "' ");
            }

/*        if (( ubigeo != null ) && (!ubigeo.trim().equals(""))){
            if (contieneComodin(ubigeo,"%"))
               query.append("   AND vsbac.VAL_UBIG LIKE '" + ubigeo + "' ");
            else
               query.append("   AND vsbac.VAL_UBIG = '" + ubigeo + "' ");
            }
*/
        
        String queryPag = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);

        try {
            recordSet = getBelcorpService().dbService.executeStaticQuery(queryPag);

            if (recordSet==null || recordSet.esVacio()) {
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    
            }

        } catch (MareException me) {
            UtilidadesLog.error("Error en recuperarSubaccesosCriterios");
            throw me; 
        } catch (Exception e) {
            UtilidadesLog.error("Error en recuperarSubaccesosCriterios");
            throw new MareException(e, 
    				UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(recordSet);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarSubaccesosCriterios(DTOEBuscarSubaccesos):Salida");
        return dtoSalida; 
  }

  public DTOSalida consultarSubacceso(DTOOID dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.consultarSubacceso(DTOOID):Entrada");
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet recordSet;
        Long oid = dto.getOid();
        Integer atributo = new Integer(1);
        Long idioma = dto.getOidIdioma();

        query.append(" SELECT sub.OID_SBAC, sub.COD_SBAC, i18n.VAL_I18N DES_SBAC, acc.CANA_OID_CANA, i18n1.VAL_I18N DES_CANA, "); 
        query.append(" sub.ACCE_OID_ACCE, i18n2.VAL_I18N DES_ACCE ");
        query.append(" FROM SEG_SUBAC sub, SEG_ACCES acc, SEG_CANAL can, GEN_I18N_SICC i18n, V_GEN_I18N_SICC i18n1, V_GEN_I18N_SICC i18n2 ");
        query.append(" WHERE sub.ACCE_OID_ACCE = acc.OID_ACCE ");
        query.append(" AND acc.CANA_OID_CANA = can.OID_CANA ");
        query.append(" AND sub.OID_SBAC = "+oid+" ");
        query.append(" AND i18n.ATTR_ENTI(+) = 'SEG_SUBAC' "); 
        query.append(" AND i18n.ATTR_NUM_ATRI(+) = "+atributo+" ");
        query.append(" AND i18n.IDIO_OID_IDIO(+) = "+idioma+" ");
        query.append(" AND i18n.VAL_OID(+) = sub.OID_SBAC ");
        query.append(" AND i18n1.ATTR_ENTI = 'SEG_CANAL' "); 
        query.append(" AND i18n1.ATTR_NUM_ATRI = "+atributo+" ");
        query.append(" AND i18n1.IDIO_OID_IDIO = "+idioma+" ");
        query.append(" AND i18n1.VAL_OID =acc.CANA_OID_CANA  ");
        query.append(" AND i18n2.ATTR_ENTI = 'SEG_ACCES' "); 
        query.append(" AND i18n2.ATTR_NUM_ATRI = "+atributo+" ");
        query.append(" AND i18n2.IDIO_OID_IDIO = "+idioma+" ");
        query.append(" AND i18n2.VAL_OID = sub.ACCE_OID_ACCE ");

        try {
            recordSet = getBelcorpService().dbService.executeStaticQuery(query.toString());

        } catch (MareException me) {
            UtilidadesLog.error("Error en consultarSubacceso");
            throw me; 
        } catch (Exception e) {
            UtilidadesLog.error("Error en consultarSubacceso");
            throw new MareException(e);
        }

        dtoSalida.setResultado(recordSet);
        UtilidadesLog.info("MONMantenimientoSEG.consultarSubacceso(DTOOID):Salida");
        return dtoSalida; 
  }

  public void guardarSubacceso(DTOSubacceso dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.guardarSubacceso(DTOSubacceso):Entrada");
      try {
          SubaccesoLocalHome sublh = this.getSubaccesosLocalHome();
          Entidadi18nLocalHome e18nLH = getEntidadi18nLocalHome();

          UtilidadesLog.debug("dto: " + dto);
          
          if (dto.getOidSubacceso()==null){        

             UtilidadesLog.debug("dto.getOidSubacceso() nulo");               
               
                try {
                  SubaccesoLocal subl = sublh.create(dto.getCodigoSubacceso().toUpperCase(),dto.getOidAcceso());
                  for (int i=0;i<dto.getDescripcionesSubacceso().size();i++){
                      DTOI18nSICC dtoTraduccion = (DTOI18nSICC)dto.getDescripcionesSubacceso().elementAt(i);//devuelve los datos de la traduccion
                      Long oidIdioma = dtoTraduccion.getOidIdioma();
                      String descripcion = dtoTraduccion.getValorI18n();
                      e18nLH.create("SEG_SUBAC",new Long(1),oidIdioma,descripcion,subl.getOid());    
                  }
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                }
          } else {

                UtilidadesLog.debug("dto.getOidSubacceso() NO nulo");
            
                SubaccesoLocal subl = sublh.findByPrimaryKey(dto.getOidSubacceso());            
                try{
                    Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK( "SEG_SUBAC", new Long(1), dto.getOidIdioma(), subl.getOid());
                    e18nL.setDetalle(dto.getDescripcionSubaccesoBusqueda());
                    e18nLH.merge(e18nL);
                }catch(NoResultException e){
                    UtilidadesLog.debug("No se encontro la descripcion para ese idioma, vamos a crearlo");
                    try {
                        e18nLH.create("SEG_SUBAC",new Long(1),dto.getOidIdioma(),dto.getDescripcionSubaccesoBusqueda(),subl.getOid());
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
                //Para multiidioma
                for (int i=0;i<dto.getDescripcionesSubacceso().size();i++){
                    DTOI18nSICC dtoTraduccion = (DTOI18nSICC)dto.getDescripcionesSubacceso().elementAt(i);//devuelve los datos de la traduccion
                    Long oidIdioma = dtoTraduccion.getOidIdioma();
                    String descripcion = dtoTraduccion.getValorI18n();
                    try{
                        Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK( "SEG_SUBAC", new Long(1), oidIdioma, subl.getOid());
                        e18nL.setDetalle(descripcion);
                        e18nLH.merge(e18nL);
                    }catch(NoResultException e){
                        UtilidadesLog.debug("No se encontro la descripcion para ese idioma, vamos a crearlo");
                        try {
                            e18nLH.create("SEG_SUBAC",new Long(1),oidIdioma,descripcion,subl.getOid());
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                        }
                    }
                }            
                subl.setOidAcceso(dto.getOidAcceso());
                subl.setCodigo( dto.getCodigoSubacceso().toUpperCase() );
                sublh.merge(subl);
            }
      }catch(NoResultException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }catch(PersistenceException e){
          ctx.setRollbackOnly();
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      UtilidadesLog.info("MONMantenimientoSEG.guardarSubacceso(DTOSubacceso):Salida");
  }

  public DTOSalida obtenerMarcasSinFiltro() throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.obtenerMarcasSinFiltro():Entrada");
        RecordSet rs;
        DTOSalida dtos = new DTOSalida();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT oid_marc, des_marc ");
        query.append(" FROM seg_marca ");
        query.append("ORDER BY des_marc ");

            try {
                rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            } catch (MareException me) {
                throw me; 
            } catch (Exception e) {
                throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        
        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.obtenerMarcasSinFiltro():Salida");
        return dtos;
  }

  public DTOSalida obtenerCanalesSinFiltro(DTOBelcorp dto) throws MareException  {
    UtilidadesLog.info("MONMantenimientoSEG.obtenerCanalesSinFiltro(DTOBelcorp):Entrada");
        DTOSalida dtos =  new DTOSalida();

        //String clausulaSinTodos = " and val_oid != 0 ";
        //if (todos.booleanValue()) clausulaSinTodos = "";

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" C.OID_CANA,  ");
        query.append(" ICanal.VAL_I18N ");
        query.append(" FROM SEG_CANAL C, V_GEN_I18N_SICC ICanal ");
        query.append(" WHERE ICanal.ATTR_ENTI = 'SEG_CANAL' ");
        query.append(" AND ICanal.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append(" AND ICanal.VAL_OID = C.OID_CANA  ");
        query.append(" AND ICanal.ATTR_NUM_ATRI = 1 ");
        //query.append(clausulaSinTodos);
        query.append(" ORDER BY ICanal.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.obtenerCanalesSinFiltro(DTOBelcorp):Salida");
        return dtos;
  }

  public DTOSalida obtenerAccesosSinFiltro(DTOOID dto) throws MareException{
        UtilidadesLog.info("MONMantenimientoSEG.obtenerAccesosSinFiltro(DTOOID):Entrada");
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" s.oid_acce,  ");
        query.append(" iAcce.val_i18n, s.CANA_OID_CANA ");
        query.append(" FROM seg_acces s, V_GEN_I18N_SICC iAcce ");
        query.append(" WHERE iAcce.ATTR_ENTI = 'SEG_ACCES' ");
        query.append(" AND iAcce.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append(" AND iAcce.VAL_OID = s.oid_acce  ");
        query.append(" AND iAcce.ATTR_NUM_ATRI = 1 ");
        if (dto.getOid() != null)
          	query.append(" AND s.cana_oid_cana = "+ dto.getOid() + " ");
        query.append(" ORDER BY iAcce.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.obtenerAccesosSinFiltro(DTOOID):Salida");
        return dtos;
  }

  public DTOSalida obtenerSubaccesosSinFiltro(DTOOID dto) throws MareException{
        UtilidadesLog.info("MONMantenimientoSEG.obtenerSubaccesosSinFiltro(DTOOID):Entrada");
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();
        query.append(" SELECT ");
        query.append(" sub.OID_SBAC, ");
        query.append(" iSubac.VAL_I18N, ");
        query.append(" sub.ACCE_OID_ACCE ");
        query.append(" FROM SEG_SUBAC sub, V_GEN_I18N_SICC iSubac ");
        query.append(" WHERE iSubac.ATTR_ENTI = 'SEG_SUBAC' ");
        query.append(" AND iSubac.VAL_OID = sub.OID_SBAC ");
        query.append(" AND iSubac.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "' ");
        query.append(" AND iSubac.ATTR_NUM_ATRI = 1 ");
        if (dto.getOid() != null)
            query.append(" AND sub.ACCE_OID_ACCE = " + dto.getOid() + " ");
        query.append(" ORDER BY iSubac.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.obtenerSubaccesosSinFiltro(DTOOID):Salida");
        return dtos;
  }

  public DTOSalida obtenerEmpresasSinFiltro(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerEmpresasSinFiltro(DTOOID):Entrada");
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" s.OID_SOCI,  ");
        query.append(" s.VAL_DENO, ");
        query.append(" s.PAIS_OID_PAIS ");
        query.append(" FROM SEG_SOCIE s ");
        if (dto.getOid() != null)
          query.append(" WHERE s.pais_oid_pais = "+ dto.getOid() + " ");
        query.append(" ORDER BY s.VAL_DENO ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.obtenerEmpresasSinFiltro(DTOOID):Salida");
        return dtos;
  }

  public DTOSalida buscarSubaccesos(DTOEBuscarSubaccesos dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.buscarSubaccesos(DTOEBuscarSubaccesos):Salida");
       StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet recordSet;
        
        String codigo = dtoe.getCodigoSubacceso();
        String descripcion = dtoe.getDescripcionSubacceso();
        Long oidAcceso = dtoe.getOidAcceso();
        Long oidCanal = dtoe.getOidCanal();
        
        Integer atributo = new Integer(1);
        Long idioma = dtoe.getOidIdioma();

        query.append(" SELECT vsbac.OID_SBAC OID, vsbac.COD_SBAC, i18n.VAL_I18N DES_SUBACC, ");
        query.append(" i18n3.VAL_I18N DES_CANAL, i18n2.VAL_I18N DES_ACCESO ");
        query.append(" FROM SEG_SUBAC vsbac, V_GEN_I18N_SICC i18n, SEG_ACCES vacc, V_GEN_I18N_SICC i18n2, "); 
        query.append(" V_GEN_I18N_SICC i18n3 ");
        query.append(" WHERE  i18n.ATTR_ENTI = 'SEG_SUBAC' ");
        query.append(" AND i18n.ATTR_NUM_ATRI = "+atributo+" ");  
        query.append(" AND i18n.IDIO_OID_IDIO = "+idioma+" ");  
        query.append(" AND i18n.VAL_OID = vsbac.OID_SBAC ");   
       
        query.append(" AND vsbac.ACCE_OID_ACCE = vacc.OID_ACCE ");  
        query.append(" AND i18n2.ATTR_ENTI = 'SEG_ACCES' ");
        query.append(" AND i18n2.ATTR_NUM_ATRI = "+atributo+" ");
        query.append(" AND i18n2.IDIO_OID_IDIO = "+idioma+" ");
        query.append(" AND i18n2.VAL_OID = vacc.OID_ACCE ");  
       
        query.append(" AND i18n3.ATTR_ENTI = 'SEG_CANAL' ");
        query.append(" AND i18n3.ATTR_NUM_ATRI = "+atributo+" ");
        query.append(" AND i18n3.IDIO_OID_IDIO = "+idioma+" ");
        query.append(" AND i18n3.VAL_OID = vacc.CANA_OID_CANA ");  
       
        if (oidAcceso!=null) query.append(" AND vsbac.ACCE_OID_ACCE = "+oidAcceso+" ");  
        if (oidCanal!=null) query.append(" AND vacc.CANA_OID_CANA = "+oidCanal+" "); 

        if (( codigo != null)  &&  (!codigo.trim().equals(""))){
            if (contieneComodin(codigo,"%"))
                query.append(" AND vsbac.COD_SBAC LIKE '" + codigo.toUpperCase() + "' ");
            else
                query.append(" AND vsbac.COD_SBAC = '" + codigo.toUpperCase() + "' ");
        }

        if (( descripcion != null) && (!descripcion.trim().equals(""))) {
            if (contieneComodin(descripcion,"%"))
                query.append(" AND i18n.VAL_I18N LIKE '" + descripcion + "' ");
            else
                query.append(" AND i18n.VAL_I18N = '" + descripcion + "' ");
        }

/*        if (( ubigeo != null ) && (!ubigeo.trim().equals(""))){
            if (contieneComodin(ubigeo,"%"))        
                query.append(" AND vsbac.VAL_UBIG LIKE  '" + ubigeo + "' ");
            else
                query.append(" AND vsbac.VAL_UBIG = '" + ubigeo + "' ");
            
        }
*/        
        String queryPag = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);

        try {
            recordSet = getBelcorpService().dbService.executeStaticQuery(queryPag);

            if (recordSet==null || recordSet.esVacio()) {
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    
            }

        } catch (MareException me) {
            UtilidadesLog.error("Error en recuperarSubaccesosCriterios");
            throw me; 
        } catch (Exception e) {
            UtilidadesLog.error("Error en recuperarSubaccesosCriterios");
            throw new MareException(e, 
    				UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(recordSet);
        UtilidadesLog.info("MONMantenimientoSEG.buscarSubaccesos(DTOEBuscarSubaccesos):Salida");
        return dtoSalida; 
  }

  public DTOCAS obtieneCanalAccesoSubacceso(DTOCargaCAS dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.obtieneCanalAccesoSubacceso(DTOCargaCAS):Salida");
    DTOFiltroCAS dtoCons = dto.getFiltro();
    DTOFiltroCAS dtoMeta = dto.getTodos();
    DTOCAS dtoRes = new DTOCAS();

    UtilidadesLog.debug("el dto es " + dto);
    UtilidadesLog.debug("el dto de filtro es " + dtoCons);
    if (dtoCons.getBcanales() != null && dtoCons.getBcanales().booleanValue()) {
        UtilidadesLog.debug("entro al if de canales");
        Boolean todos = dtoMeta.getBcanales();
        UtilidadesLog.debug("todos es " + todos);
        UtilidadesLog.debug("dto es " + dto);
        DTOSalida dtoSal = this.recuperarCanales(dto, todos);
        UtilidadesLog.debug("ya salio de recuperar");
        dtoRes.setCanales(dtoSal.getResultado());
    }
    if (dtoCons.getBaccesos() != null && dtoCons.getBaccesos().booleanValue()) {
        UtilidadesLog.debug("entro al if de accesos");
        Boolean todos = dtoMeta.getBaccesos();
        DTOSalida dtoSal = this.recuperarAccesos(dto, todos);
        dtoRes.setAccesos(dtoSal.getResultado());
    }
    if (dtoCons.getBsubaccesos() != null && dtoCons.getBsubaccesos().booleanValue()) {
        UtilidadesLog.debug("entro al if de subaccesos");
        Boolean todos = dtoMeta.getBsubaccesos();
        DTOSalida dtoSal = this.recuperarSubaccesos(dto, todos);
        dtoRes.setSubaccesos(dtoSal.getResultado());
    }
    UtilidadesLog.info("MONMantenimientoSEG.obtieneCanalAccesoSubacceso(DTOCargaCAS):Salida");
    return dtoRes;
  }

  public Long obtenerOidMoneda(String codigo) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidMoneda(String):Entrada");

        StringBuffer SQL = new StringBuffer();
        SQL.append(" SELECT OID_MONE ");
        SQL.append(" FROM SEG_MONED ");
        SQL.append(" WHERE COD_MONE = '"+codigo+"' ");

        RecordSet r;
        
        try {
            r = getBelcorpService().dbService.executeStaticQuery(SQL.toString());
        } catch(Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        Long oidMone = null;
        if (r.getRowCount() > 0) {
            oidMone = new Long(((BigDecimal) r.getValueAt(0,0)).toString());
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidMoneda(String):Salida");
        return oidMone;
      }

  public BigDecimal obtenerCambioMonedaAlternativa(Long oidPais) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.obtenerCambioMonedaAlternativa(Long):Entrada");

        StringBuffer SQL = new StringBuffer();
        SQL.append(" SELECT MONE_OID_MONE, MONE_OID_MONE_ALT  ");
        SQL.append(" FROM SEG_PAIS ");
        SQL.append(" WHERE OID_PAIS = "+oidPais+" ");

        RecordSet r;
        
        try {
            r = getBelcorpService().dbService.executeStaticQuery(SQL.toString());
        } catch(Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        BigDecimal mone = null;
        if (!r.esVacio()) {
            mone = obtenerTipoCambio(new Long(((BigDecimal) r.getValueAt(0,0)).toString()),
                                                     new Long(((BigDecimal) r.getValueAt(0,1)).toString()));
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtenerCambioMonedaAlternativa(Long):Salida");
        return mone;
  }

  public BigDecimal obtenerTipoCambio(Long moneda1, Long moneda2) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.obtenerTipoCambio(Long , Long):Entrada");
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");        
            
        StringBuffer SQL = new StringBuffer();
        SQL.append(" SELECT VAL_TIPO_CAMB ");
        SQL.append(" FROM SEG_TIPO_CAMBI ");
        SQL.append(" WHERE MONE_OID_MON1  = "+moneda1+" ");
        SQL.append(" AND MONE_OID_MON2  = "+moneda2+" ");
        SQL.append(" AND to_date('"+dt.format(new Date(System.currentTimeMillis()))+"','DD-MM-YYYY') BETWEEN FEC_DESD AND FEC_HAST ");

        RecordSet r;        
        try {
            r = getBelcorpService().dbService.executeStaticQuery(SQL.toString());
        } catch(Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        BigDecimal tipo = null;
        if (!r.esVacio()) {
            tipo = (BigDecimal) r.getValueAt(0,0);
        }
        UtilidadesLog.info("MONMantenimientoSEG.obtenerTipoCambio(Long , Long):Salida");
        return tipo;
  }

  public Long obtenerOidPeriodo(String codigo, Long canal) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.obtenerOidPeriodo(String codigo, Long):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" p.OID_PERI  ");
        query.append(" FROM SEG_PERIO_CORPO p, SEG_CANAL c ");
        query.append(" WHERE c.TIPE_OID_TIPO_PERI = p.TIPE_OID_TIPO_PERI ");
        query.append(" AND c.OID_CANA = " + canal + " ");
        query.append(" AND p.COD_PERI = '" + codigo + "' ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Long res = null;
        if (!rs.esVacio()) 
            res = new Long(((BigDecimal) rs.getValueAt(0,0)).toString());
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidPeriodo(String codigo, Long):Salida");
        return res;

  }

	public DTOSalida obtenerSubaccesosMultiAcceso( DTOOIDs dto ) throws  MareException {
     UtilidadesLog.info("MONMantenimientoSEG.obtenerSubaccesosMultiAcceso(DTOOIDs):Entrada");
	 RecordSet recordSet = new RecordSet();
     boolean primero = true;
	 RecordSet recordSetAux; 
	 //Para cada oid del dto de entrada hacer: 
     DTOOID dtoOid = new DTOOID();
	 Long oids [] =	dto.getOids();
    
     dtoOid.setOidIdioma(dto.getOidIdioma());
     
	 for (int i= 0; i< oids.length;i++) {
		//-> Llamar al método de esta clase "obtenerSubaccesosPorSubacceso" 
        dtoOid.setOid(oids[i]);        
        recordSetAux =	this.obtenerSubaccesosPorAcceso(dtoOid).getResultado();

        // Cabecera
        if (primero) {
            for (int j = 0; j < recordSetAux.getColumnCount(); j++) {
                recordSet.addColumn(recordSetAux.getColumnName(j));
            }
            primero = false;
        }
		//-> añadir las filas del RecordSet obtenido al RecorSet creado en la actividad anterior 
		for( int j = 0; j <recordSetAux.getRowCount();j++)
			recordSet.addRow(recordSetAux.getRow(j));
	 }
//-> Devolver RecordSet con todas las filas recuperadas en cada llamada dentro de un DTOSalida
	//return recordSet;	 
	DTOSalida dts = new DTOSalida();
	dts.setResultado(recordSet);
    UtilidadesLog.info("MONMantenimientoSEG.obtenerSubaccesosMultiAcceso(DTOOIDs):Salida");
	return dts;
	}

	public DTOSalida recuperarPaisesSinFiltro(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPaisesSinFiltro(DTOOID):Entrada");
        String codigoError;
        RecordSet rs = new RecordSet();
        StringBuffer query  = new StringBuffer();

        query.append("   SELECT oid_pais, b.VAL_I18N ");
        query.append("   from seg_pais a ");
        query.append("   inner join v_gen_i18n_sicc b on ");
        query.append("   ATTR_ENTI = 'SEG_PAIS' ");
        query.append("   and b.ATTR_NUM_ATRI = 1 "); 
        query.append("   and b.IDIO_OID_IDIO = '"+ dto.getOidIdioma()+ "' "); 
        query.append("   and b.VAL_OID = a.OID_PAIS ");

        try {             
            rs = UtilidadesEJB.getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        }  
        UtilidadesLog.info("MONMantenimientoSEG.recuperarPaisesSinFiltro(DTOOID):Salida");
        return new DTOSalida(rs);
	}

	public DTOSalida obtenerAccesosPorCanal(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerAccesosPorCanal(DTOOID):Entrada");
        String codigoError;
        RecordSet rs = new RecordSet();
        StringBuffer query  = new StringBuffer();

        query.append(" SELECT a.oid_acce OID, i.val_i18n ");
        query.append(" FROM seg_acces a, v_gen_i18n_sicc i ");
        query.append(" WHERE i.attr_enti = 'SEG_ACCES' ");
        query.append(" AND i.attr_num_atri = 1 ");
        query.append(" AND i.idio_oid_idio = " + dto.getOidIdioma() );
        query.append(" AND i.val_oid = a.oid_acce ");
        query.append(" AND a.cana_oid_cana = " + dto.getOid() );
        query.append(" ORDER BY val_i18n ");

        try {             
            rs = UtilidadesEJB.getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        }  
        UtilidadesLog.info("MONMantenimientoSEG.obtenerAccesosPorCanal(DTOOID):Salida");
        return new DTOSalida(rs);
	}

    public DTOSalida obtenerMonedasAlternativas(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerMonedasAlternativas(DTOBelcorp):SaEntradalida");
        String codigoError;
        RecordSet rs = new RecordSet();
        StringBuffer query  = new StringBuffer();

        query.append("   SELECT DISTINCT p.mone_oid_mone_alt, i.val_i18n ");
        query.append("     FROM v_gen_i18n_sicc i, seg_pais p ");
        query.append("    where p.mone_oid_mone = i.val_oid ");
        query.append("      AND i.attr_num_atri = 1 ");
        query.append("      and i.idio_oid_idio =  " + dtoe.getOidIdioma() );
        query.append("      and i.attr_enti='SEG_MONED' ");
        if (dtoe.getOidPais()!=null){
            query.append("      and p.oid_pais =  " + dtoe.getOidPais() );
        }
        query.append(" order by i.val_i18n");

        try {             
            rs = UtilidadesEJB.getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        }  
        UtilidadesLog.info("MONMantenimientoSEG.obtenerMonedasAlternativas(DTOBelcorp):Salida");
        return new DTOSalida(rs);
    }

      

	public DTOSalida recuperarMarcasProducto(DTOBelcorp dto) throws MareException {
    /*Incidencia 5701
     -> Hacer consulta JDBC sobre tabla SEG_MARCA_PRODU para obtener los campos OID_MARC_PROD y
    DES_MARC_PROD de todos los registros
    -> Devolver RecordSet obtenido en un objeto DTOSalida.*/

    /*
    Entrada: DTOBelcorp
    Proceso: 
    -> Hacer consulta JDBC sobre tabla SEG_MARCA_PRODU para obtener los campos
    OID_MARC_PROD y DES_MARC_PROD de todos los registros
    -> Devolver RecordSet obtenido en un objeto DTOSalida.

    No hay que filtrar por pais, pero ponemos como parámetro de entrada un DTOBelcorp para
    prevenir futuros cambios.

    Se construye la fachada MLNFRecuperarMarcasProducto cuya documentación es la siguiente:

    idBusiness = "SEGRecuperarMarcasProducto"
    MONMantenimientoSEG.recuperarMarcasProducto(dto : DTOBelcorp) : DTOSalida*/
    UtilidadesLog.info("MONMantenimientoSEG.recuperarMarcasProducto(DTOBelcorp):Entrada");
    String codigoError;
    RecordSet rs = new RecordSet();
    StringBuffer query  = new StringBuffer();

    query.append("SELECT OID_MARC_PROD, DES_MARC_PROD FROM SEG_MARCA_PRODU");
    query.append( " ORDER BY DES_MARC_PROD" );

    try {             
      rs = UtilidadesEJB.getBelcorpService().dbService.executeStaticQuery(query.toString());
    } catch (Exception e) {
      codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
      throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
    }
    UtilidadesLog.info("MONMantenimientoSEG.recuperarMarcasProducto(DTOBelcorp):Salida");
    return new DTOSalida(rs);	
	}


/**
Para solucionar este problema se debe modificar el metodo recuperarMarcasProductoMP del
MONMantenimientoSEG para que no agregue la condicion de filtro de marca corporativa si esta
llega en NULL.

El diseño del metodo que da de la siguiente forma:
Entrada: DTOOID (oid de marca)
Proceso:
-> Hacer consulta JDBC sobre la tabla SEG_MARCA_PRODU haciendo join con la tabla
SEG_MARCA_CORPO_MARCA_PRODU, filtrando por el campo PAIS_OID_PAIS = dto.pais y si
dto.oid es diferente de NULL filtrar por MARC_OID_MARC = dto.oid
-> Devolver RecordSet obtenido en un objeto DTOSalida

Se reenvia a construccion CDOS para que realice esta modificacion.
*/
  public DTOSalida recuperarMarcasProductoMP(DTOOID dto) throws  MareException {
    UtilidadesLog.info("MONMantenimientoSEG.recuperarMarcasProductoMP(DTOOID):Entrada");
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" MAPR_OID_MARC_PROD , DES_MARC_PROD  ");
        query.append(" FROM SEG_MARCA_PRODU marca, SEG_MARCA_CORPO_MARCA_PRODU produ ");
        query.append(" WHERE marca.OID_MARC_PROD = produ.MAPR_OID_MARC_PROD ");
        query.append(" AND produ.PAIS_OID_PAIS  = " + dto.getOidPais() + " ");
        if (dto.getOid() != null)  {
            query.append(" AND produ.MARC_OID_MARC =  " + dto.getOid());
        }
        query.append(" ORDER BY DES_MARC_PROD ");
        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.recuperarMarcasProductoMP(DTOOID):Salida");
        return dtos;
    }

    public Long obtenerOidModulo(String codigo) throws MareException {
       UtilidadesLog.info("MONMantenimientoSEG.obtenerOidModulo(String):Entrada");

       StringBuffer query = new StringBuffer();
       query.append(" SELECT oid_modu ");
       query.append(" FROM SEG_MODUL ");
       query.append(" WHERE cod_modu = '" + codigo + "'");     
       RecordSet rs = new RecordSet();

       try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
       }
       catch (MareException me) {
            throw me;
       }
       catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }   

      Long oid = null;

      if(rs.getRowCount()>0) {
        BigDecimal oidBig = (BigDecimal)rs.getValueAt(0,"oid_modu");
        UtilidadesLog.debug("********** oidBig: " + oidBig);
        oid = new Long(oidBig.longValue());     
      }      
      UtilidadesLog.info("MONMantenimientoSEG.obtenerOidModulo(String):Salida");
      return oid;
    }
	
	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       22/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Obtiene todas las monedas de la base
	 */
	public DTOSalida obtenerMonedas(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerMonedas(DTOBelcorp):Entrada");
		StringBuffer query = new StringBuffer();
		BelcorpService belcorpService = null;
		try{
			belcorpService = BelcorpService.getInstance();
			query.append("SELECT m.OID_MONE as oid, i18n.VAL_I18N as descripcion ");
			query.append("  FROM SEG_MONED m, v_gen_i18n_sicc i18n ");
			query.append(" WHERE i18n.attr_enti = 'SEG_MONED' ");
			query.append("   AND i18n.attr_num_atri = 1 ");
			query.append("   AND i18n.idio_oid_idio = " + dto.getOidIdioma() + " ");
			query.append("   AND i18n.val_oid = m.OID_MONE ");
			query.append("order by descripcion");

			RecordSet rs = belcorpService.dbService.executeStaticQuery(query.toString());

			DTOSalida dtoSalida = new DTOSalida();
			dtoSalida.setResultado(rs);
            UtilidadesLog.info("MONMantenimientoSEG.obtenerMonedas(DTOBelcorp):Salida");
			return dtoSalida;
		} catch (MareException me) {
	        throw me;
	    } catch (Exception e) {
		    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
	}

    /**
     * -> Hacer findByPrimaryKey sobre la entidad Pais, tomando el oid de pais del dto de entrada.
        -> Hacer get del atributo "indicadorFleteZonaUbigeo"
        -> Crear un objeto DTOBoolean
        Si indicadorFleteZonaUbigeo = 'Z' entonces
        ->asignar "true" al atributo DTOBoolean.resultado
        Si no Si indicador FleteZonaUbigeo = 'U' entonces
        -> asignar "false" al atributo DTOBoolean.resultado
        Fin Si
        -> Devolver DTOBoolean creado
     */
    public DTOBoolean obtenerIndicadorFleteZonaUbigeo(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerIndicadorFleteZonaUbigeo(DTOBelcorp):Entrada");
        DTOBoolean dtoS = new DTOBoolean();
               
        try {
     
            PaisLocalHome tPLH = new PaisLocalHome();
            PaisLocal pl = tPLH.findByPrimaryKey(dtoe.getOidPais());

            if (pl.getInd_flet_zona_ubig().toString().equals("Z")) {
              dtoS.setValor(true);
            } else if (pl.getInd_flet_zona_ubig().equals("U")) {
              dtoS.setValor(false);
            }
            UtilidadesLog.info("MONMantenimientoSEG.obtenerIndicadorFleteZonaUbigeo(DTOBelcorp):Salida");    
            return dtoS;
            
        }catch(PersistenceException ex){
          UtilidadesLog.error(ex);
          String error = (ex instanceof NoResultException)?
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE : CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(ex, UtilidadesError.armarCodigoError(error));
        }

     }

  public Long[] obtenerSubAccesosPorCodigoAcceso(String codAcceso) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.obtenerIndicadorFleteZonaUbigeo(DTOBelcorp):Entrada");    
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        
        query.append(" SELECT SU.OID_SBAC FROM SEG_SUBAC SU, SEG_ACCES A");
        query.append(" WHERE SU.ACCE_OID_ACCE = A.OID_ACCE");
        query.append(" AND trim(A.COD_ACCE) = " + codAcceso.toString());

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Long[] oidSbac = new Long[rs.getRowCount()];
        
        Vector row = null;
        for (int i=0; i < rs.getRowCount(); i++){
           row = rs.getRow(i);
           Long pos0 = ((row.get(0) == null) ? null : new Long(((BigDecimal) row.get(0)).toString()));
           oidSbac[i] = pos0; 
        }     
        UtilidadesLog.info("MONMantenimientoSEG.obtenerIndicadorFleteZonaUbigeo(DTOBelcorp):Salida");
        return oidSbac;
    
  }

    public BigDecimal obtenerUltimoTipoCambio(Long moneda1, Long moneda2) throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerUltimoTipoCambio(Long , Long):Entrada");
       	StringBuffer query = new StringBuffer();
		BelcorpService belcorpService = null;
		RecordSet rs = new RecordSet();
        SimpleDateFormat sDate = new SimpleDateFormat("dd/MM/yy");
        String fecha = sDate.format(new Date());
		try{
    		belcorpService = BelcorpService.getInstance();
			query.append(" SELECT s.VAL_TIPO_CAMB ");
			query.append(" FROM SEG_TIPO_CAMBI s ");
			query.append(" WHERE s.MONE_OID_MON1 = " + moneda1);
			query.append(" AND s.MONE_OID_MON2 = " + moneda2);
			query.append(" AND (SELECT max(s.FEC_DESD) ");
			query.append("      FROM SEG_TIPO_CAMBI s) <= to_date('" + fecha + "','dd/MM/yy') ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            BigDecimal resp = (BigDecimal) rs.getValueAt(0,0);
            UtilidadesLog.info("MONMantenimientoSEG.obtenerUltimoTipoCambio(Long , Long):Salida");
            return resp;
		} catch (MareException me) {
	        throw me;
	    } catch (Exception e) {
		    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
    }

	public DTOOID obtenerMonedaPais (DTOOID dto)throws MareException{
        UtilidadesLog.info("MONMantenimientoSEG.obtenerMonedaPais (DTOOID):Entrada");
		StringBuffer query = new StringBuffer();
		BelcorpService belcorpService = null;
		RecordSet rs = new RecordSet();
		DTOOID out = new DTOOID();
		try{
    		belcorpService = BelcorpService.getInstance();
			query.append(" SELECT MONE_OID_MONE  ");
			query.append(" FROM SEG_PAIS WHERE OID_PAIS = " + dto.getOid());
			rs = belcorpService.dbService.executeStaticQuery(query.toString());
            BigDecimal resp = (BigDecimal) rs.getValueAt(0,0);
			out.setOid(new Long(resp.toString()));
			} catch (Exception e) {
		    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
        UtilidadesLog.info("MONMantenimientoSEG.obtenerMonedaPais (DTOOID):Salida");
		return out;
	}

	public  DTOSalida obtenerTiposCambioMoneda (DTOOID dto)throws MareException{
        UtilidadesLog.info("MONMantenimientoSEG.obtenerTiposCambioMoneda (DTOOID):Entrada");
	    StringBuffer query = new StringBuffer();
		BelcorpService belcorpService = null;
		RecordSet rs = new RecordSet();
		DTOSalida out = new DTOSalida();
		SimpleDateFormat sDate = new SimpleDateFormat("dd/MM/yy");
        String fecha = sDate.format(new Date());
		try{
    		belcorpService = BelcorpService.getInstance();
			query.append(" SELECT A.OID_TIPO_CAMB, A.MONE_OID_MON1, A.MONE_OID_MON2, A.VAL_TIPO_CAMB, g1.val_i18n desc_mon1, g2.val_i18n desc_mon2  ");
			query.append("FROM SEG_TIPO_CAMBI A , v_gen_i18n_sicc g1, v_gen_i18n_sicc g2 ");
			query.append(" WHERE g1.attr_enti = 'SEG_MONED' ");
			query.append(" AND g1.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND g1.ATTR_NUM_ATRI = 1 ");
			query.append(" AND g1.val_oid = a.mone_oid_mon1 ");
            query.append(" AND g2.attr_enti = 'SEG_MONED' ");
			query.append(" AND g2.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND g2.ATTR_NUM_ATRI = 1 ");
			query.append(" AND g2.val_oid = a.mone_oid_mon2 ");            
            query.append(" AND A.MONE_OID_MON1 = " + dto.getOid());
			query.append(" AND A.FEC_DESD <=to_date('"+ fecha +"'" + "," + "'dd/MM/yy')");
			query.append(" AND A.FEC_HAST >= to_date('"+ fecha +"'" + "," + "'dd/MM/yy')");
			rs = belcorpService.dbService.executeStaticQuery(query.toString());
			
	    } catch (Exception e) {
		    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		out.setResultado(rs);
        UtilidadesLog.info("MONMantenimientoSEG.obtenerTiposCambioMoneda (DTOOID):Salida");
		return out;
		
	}


/** MONMantenimientoSEG.obtenerPeriodosPorCanal(dto : DTOOID) : DTOSalida  
Entrada: 
- dto : DTOOID (oid de canal) 
Proceso: 
-> Llamar al método "DAOServicioSEG.obtenerPeriodosPorCanal(dto : DTOOID) : DTOSalida" pasando el dto de entrada 
-> Devolver el objeto DTOSalida devuelto por la llamada anterior
*/

	public DTOSalida obtenerPeriodosPorCanal(DTOOID dtoin) throws  RemoteException, MareException {
		UtilidadesLog.info("MONMantenimientoSEG.obtenerPeriodosPorCanal(DTOOID):Entrada");
		DAOServicioSeg daoServicioSeg = new DAOServicioSeg();
		DTOSalida dtoSalida = daoServicioSeg.obtenerPeriodosPorCanal(dtoin);
        UtilidadesLog.info("MONMantenimientoSEG.obtenerPeriodosPorCanal(DTOOID):Salida");
		return dtoSalida;
	}

	public DTOOID obtenerOIDMonedaAltPais(Long oidPais, String codigoMonedaAlt) throws  RemoteException, MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOIDMonedaAltPais(Long , String):Entrada");
       DAOServicioSeg daoSeg = new DAOServicioSeg();
       DTOOID dtooid = daoSeg.obtenerOIDMonedaAltPais(oidPais,codigoMonedaAlt);
       UtilidadesLog.info("MONMantenimientoSEG.obtenerOIDMonedaAltPais(Long , String):Salida");
       return dtooid;
	}
  
    /**
      * // Obtiene el valor de tipo cambio para la fecha inmediatamente anterior a la fecha recibida 
      SELECT VAL_TIPO_CAMB 
      FROM SEG_TIPO_CAMBI 
      WHERE 
      MONE_OID_MON1 = oidMoneda1 AND 
      MONE_OID_MON2 = oidMoneda2 AND 
      FEC_DESD < fechaDesde       
      ORDER BY 
      FEC_DESD       
        Devuelve el primero de los valores recuperados
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param fechaDesde
     * @param oidMoneda2
     * @param oidMoneda1
     */
    public BigDecimal obtenerTipoCambioAnterior(Long oidMoneda1, Long oidMoneda2, Date fechaDesde) throws MareException{
        UtilidadesLog.info("MONMantenimientoSEG.obtenerTipoCambioAnterior(Long , Long, Date):Salida");
        StringBuffer query = new StringBuffer();
        BelcorpService belcorpService = null;
        RecordSet rs = new RecordSet();
        SimpleDateFormat sDate = new SimpleDateFormat("dd/MM/yyyy");
        try{
            belcorpService = BelcorpService.getInstance();
            query.append(" SELECT VAL_TIPO_CAMB   ");
            query.append("FROM SEG_TIPO_CAMBI  ");
            query.append(" WHERE  1=1 ");
            if (oidMoneda1!=null)
                query.append(" AND MONE_OID_MON1 = " + oidMoneda1);
            if (oidMoneda2!=null)
                query.append(" AND MONE_OID_MON2 = " + oidMoneda2);
            if (fechaDesde!=null){
                query.append(" AND FEC_DESD < to_date('"+sDate.format(fechaDesde)+"','DD/MM/YYYY')");
            }
            query.append(" ORDER BY FEC_DESD");
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if (rs.esVacio()){
            UtilidadesLog.info("MONMantenimientoSEG.obtenerTipoCambioAnterior(Long , Long, Date):Salida");
            return null;
            }
        UtilidadesLog.info("MONMantenimientoSEG.obtenerTipoCambioAnterior(Long , Long, Date):Salida");
        return (BigDecimal)rs.getValueAt(0,0);
    }


  /*autor Marta Aurora Montiel
   * fecha 29/03/05
   * Incidencia BELC300015496
   * */
  public DTOSalida obtenerMonedasPorPais(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoSEG.obtenerMonedasPorPais(DTOBelcorp):Entrada");
    DAOServicioSeg dao = new DAOServicioSeg();
    DTOSalida dts = new DTOSalida();
    dts = dao.obtenerMonedasPorPais(dto);    
    UtilidadesLog.info("MONMantenimientoSEG.obtenerMonedasPorPais(DTOBelcorp):Salida");
    return dts;   
  }

    /**
     * @author mmaidana
     * @date 21/09/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * Creado por incidencia 23152
     */
    public DTOSalida obtenerOidCanalAccesoSubAcceso() throws MareException {
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidCanalAccesoSubAcceso():Entrada");
        DAOServicioSeg dao = new DAOServicioSeg();
        UtilidadesLog.info("MONMantenimientoSEG.obtenerOidCanalAccesoSubAcceso():Salida");
        return dao.obtenerOidCanalAccesoSubAcceso();
    }

  public DTOSubacceso buscarValoresDefectoAccSubac(DTOBelcorp dto) throws MareException
  {
    UtilidadesLog.info("MONMantenimientoSEG.buscarValoresDefectoAccSubac():Entrada");
    StringBuffer query = new StringBuffer();
    query.append("select oid_cana, oid_acce, oid_sbac ");
    query.append(" from seg_canal c, seg_acces a , seg_subac s ");
    query.append(" where c.oid_cana = a.CANA_OID_CANA ");
    query.append(" and a.OID_ACCE = s.ACCE_OID_ACCE ");
    query.append(" and c.cod_cana = '" + ConstantesSEG.COD_CANAL_VD + "' ");
    query.append(" and a.cod_acce = '" + ConstantesSEG.ACCESO_GZ + "' ");
    query.append(" and s.COD_SBAC = '" + ConstantesSEG.SUBACCESO_000 + "' ");
    RecordSet rs = null; 
    try{
            BelcorpService belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
    } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    
    DTOSubacceso dtoSubacceso = new DTOSubacceso();
    if (!rs.esVacio()) {
       dtoSubacceso.setOidCanal(this.bigDecimalToLong(rs.getValueAt(0,0)));
       dtoSubacceso.setOidAcceso(this.bigDecimalToLong(rs.getValueAt(0,1)));
       dtoSubacceso.setOidSubacceso(this.bigDecimalToLong(rs.getValueAt(0,2)));
    }    

    UtilidadesLog.info("MONMantenimientoSEG.buscarValoresDefectoAccSubac():Salida");
    return dtoSubacceso;
  }
  
   private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
    
    
}  