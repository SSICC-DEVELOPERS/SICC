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

package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.cob.DTODatosClienteCOB;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarClientesCursos;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.dtos.mae.DTOClasificacionCliente;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTOClienteMarca;
import es.indra.sicc.dtos.mae.DTOClientesAsignarAptas;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.mae.DTOComunicacion;
import es.indra.sicc.dtos.mae.DTOConsultaCliente;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOIdentificacion;
import es.indra.sicc.dtos.mae.DTOObservacion;
import es.indra.sicc.dtos.mae.DTOPreferencia;
import es.indra.sicc.dtos.mae.DTOProblemaSolucion;
import es.indra.sicc.dtos.mae.DTOPsicografia;
import es.indra.sicc.dtos.mae.DTOTarjeta;
import es.indra.sicc.dtos.mae.DTOTipificacionCliente;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.mae.DTOVinculo;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.edu.MatrizCursosLocal;
import es.indra.sicc.logicanegocio.edu.ConstantesEDU;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.CreateException;
import es.indra.sicc.dtos.inc.DTOBusquedaZonaTerritorioUA;

import java.util.Vector;

/*
 * rgiorgi - 19/8/2005: se formatea la clase.
 * */
public class DAOMAEMaestroClientes {
    private final String usuario;

    public DAOMAEMaestroClientes(String usuario) {
        this.usuario = usuario;
    }

    public Long[] obtenerClientesTerritorio(Long territorio) throws MareException {
        /*Hacemos la siguiente consulta JDBC para obtener los clientes
         * asignados actualmente al territorio administrativo indicado:

        SELECT CLIE_OID_CLIE
        FROM MAE_CLIEN_UNIDA_ADMIN
        WHERE IND_ACTI = 1 AND
        ZTAD_OID_TERR_ADMI = territorio

        Devolvemos un array con los oids de cliente obtenidos de
        la consulta, o un array vacio si no obtenemos ninguno.*/
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerClientesTerritorio(territorio): Entrada");

        BelcorpService bs = null;

        StringBuffer query = new StringBuffer();

        query.append(" SELECT CLIE_OID_CLIE ");
        query.append(" FROM MAE_CLIEN_UNIDA_ADMIN ");
        query.append(" WHERE IND_ACTI = 1 ");
        query.append(" AND ZTAD_OID_TERR_ADMI = " + territorio.toString());
        query.append(" ORDER BY CLIE_OID_CLIE ");

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        RecordSet rs = null;

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        int cant = rs.getRowCount();

        if (cant > 0) {
            Long[] resultado = new Long[cant];

            for (int i = 0; i < rs.getRowCount(); i++) {
                BigDecimal valor = (BigDecimal) rs.getValueAt(i, "CLIE_OID_CLIE");
                Long lVal = new Long(valor.longValue());
                resultado[i] = lVal;
            }
            
            UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerClientesTerritorio(territorio): Salida");
            return resultado;
        } else {
            Long[] resultado = new Long[0];
            UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerClientesTerritorio(territorio): Salida");
            return resultado;
        }
    }

    public String calcularModaNSETerritorio(Long terrAdministrativo) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.calcularModaNSETerritorio(terrAdministrativo): Entrada");

        BelcorpService bs = null;

        /*StringBuffer sQuery = new StringBuffer("SELECT COUNT(VAL_NIVE_SOCI_ECO3) AS Moda, ");
        sQuery.append("VAL_NIVE_SOCI_ECO3 FROM MAE_CLIEN_DATOS_ADICI ");
        sQuery.append("GROUP BY clie_oid_clie, VAL_NIVE_SOCI_ECO3 ");
        sQuery.append("HAVING CLIE_OID_CLIE IN ");
        sQuery.append("(SELECT CLIE_OID_CLIE ");
        sQuery.append("FROM MAE_CLIEN_UNIDA_ADMIN ");
        sQuery.append("WHERE IND_ACTI = 1 AND ");
        sQuery.append("ZTAD_OID_TERR_ADMI = " + terrAdministrativo.toString() + ")");

        // Ordena por Moda en forma descendente, y dentro de modas iguales,
        // VAL_NIVE_SOCI_ECO3 en forma ascendente.
        sQuery.append(" ORDER BY Moda DESC, VAL_NIVE_SOCI_ECO3 ASC");*/

        StringBuffer sQuery = new StringBuffer();
        sQuery.append(" SELECT  ");
        sQuery.append(" COUNT(COD_NSEP) A, ");
        sQuery.append(" COD_NSEP B ");
        sQuery.append(" FROM  ");
        sQuery.append(" MAE_CLIEN_DATOS_ADICI , ");
        sQuery.append(" MAE_TIPO_NIVEL_SOCEC_PERSO ");
        sQuery.append(" WHERE  ");
        sQuery.append(" NSEP_OID_NSEP = OID_NSEP  AND ");
        sQuery.append(" CLIE_OID_CLIE IN (  ");
        sQuery.append(" SELECT CLIE_OID_CLIE    ");
        sQuery.append(" FROM MAE_CLIEN_UNIDA_ADMIN    ");
        sQuery.append(" WHERE IND_ACTI = 1 AND ");
        sQuery.append(" ZTAD_OID_TERR_ADMI = " + terrAdministrativo.toString() + ")");
        sQuery.append(" GROUP BY COD_NSEP ");
        sQuery.append(" ORDER BY 1 DESC ");

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        RecordSet r = null;

        try {
            r = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //Integer nValorDevuelto = null;

        // Si r no es null, obtiene el valor de NSE con moda mayor, al
        // tomar la segunda columna de la primer fila. Supuestamente ya está
        // ordenado por mayor moda, y dentro de está (si hay dos o más con 
        // la misma moda) por el menor valor de NSE.
        String sBuffer = "";
        if ((r != null) && (r.esVacio() == false)) {
            sBuffer = (String) r.getValueAt(0, 1);
            UtilidadesLog.debug("sBuffer (valor de NSE con moda mayor): " + sBuffer);

            /*if ((sBuffer != null) && !sBuffer.equals("")) { // Por si acaso es null o vacio por datos malos.
                nValorDevuelto = new Integer(sBuffer);
            }*/
        } else {
            UtilidadesLog.info(" DAOMAEMaestroClientes.calcularModaNSETerritorio(terrAdministrativo): EXCEPTION");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.UNID_ADM_SIN_CONSULTORAS));
        }

        UtilidadesLog.info(" DAOMAEMaestroClientes.calcularModaNSETerritorio(terrAdministrativo): Salida");

        return sBuffer;
        //return nValorDevuelto;
    }


    /*Devuelve los códigos de los clientes que hayan utilizado fichas de inscripción para el pais indicado*/
    public DTOSalida obtenerFichasInscripcionPorPais(DTOSiccPaginacion dto) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerFichasInscripcionPorPais(DTOSiccPaginacion): Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT OID_CLIE OID, COD_CLIE ");
            query.append(" FROM MAE_CLIEN ");
            query.append(" WHERE PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" AND IND_FICH_INSC = 1 ");
            query.append(" ORDER BY OID ");
            bs = BelcorpService.getInstance();

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto.getIndicadorSituacion().intValue(), dto.getTamanioPagina().intValue());
            resultado = bs.dbService.executeStaticQuery(queryStr);
            dtos.setResultado(resultado);
        } catch (MareException me) {
            UtilidadesLog.error("me.toString()" + me.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerFichasInscripcionPorPais(DTOSiccPaginacion): Salida");
        return dtos;
    }

    public Long[] obtenerConsultorasTerritorios(Long[] territorios) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerConsultorasTerritorios(territorios): Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT u.CLIE_OID_CLIE ");
            query.append(" FROM MAE_CLIEN_UNIDA_ADMIN u, MAE_CLIEN_TIPO_SUBTI c, MAE_TIPO_CLIEN t ");
            query.append(" WHERE u.CLIE_OID_CLIE = c.CLIE_OID_CLIE  ");
            query.append(" AND c.TICL_OID_TIPO_CLIE = t.OID_TIPO_CLIE ");
            query.append(" AND u.IND_ACTI = 1 ");

            //query.append(" AND t.COD_TIPO_CLIE = '01' "); //Solo los que tienen el tipo de cliente consultora 
            query.append(" AND t.COD_TIPO_CLIE = '" + ConstantesMAE.TIPO_CLIENTE_CONSULTORA + "' ");

            if ((territorios != null) && (territorios.length > 0)) {
                query.append(" and " + inClause("u.ZTAD_OID_TERR_ADMI", territorios));
            }

            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Long[] res = new Long[resultado.getRowCount()];

        for (int i = 0; i < resultado.getRowCount(); i++)
            res[i] = new Long(resultado.getValueAt(i, 0).toString());

        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerConsultorasTerritorios(territorios): Salida");
        return res;
    }

    private String inClause(String campo, Long[] codigos) {
        UtilidadesLog.info(" DAOMAEMaestroClientes.inClause(campo, codigos): Entrada");
        if ((codigos == null) || (codigos.length == 0)) {
            return "";
        }

        String result = "";
        result = campo + " in (";

        Long element;

        for (int i = 0; i < codigos.length; i++) {
            result += codigos[i];
            result += (((i + 1) < codigos.length) ? ", " : "");
        }

        result += ")";
        
        UtilidadesLog.info(" DAOMAEMaestroClientes.inClause(campo, codigos): Salida");
        return result;
    }

    /*
    * Devuelve el siguiente código de cliente generado automáticamente para el país indicado por parámetro.
    * El pais indicado debe tener codigos generados, de lo contrario se generará una excepcion
     */
    public Long obtenerSiguienteCodigoPais(Long pais_oid) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerSiguienteCodigoPais(pais_oid): Entrada");
        
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        Long res = new Long(-1); // valor por defecto de -1 L
        StringBuffer query = new StringBuffer();

        try {
            // Esta query obtiene el proximo codigo valido de cliente
            query.append(" SELECT nvl(MAX(TO_NUMBER(mae.COD_CLIE)),0)+1  ");
            query.append(" FROM MAE_CLIEN mae ");
            query.append(" WHERE mae.COD_CLIE NOT IN (  ");

            // Este subselect devbuelve una lista de los codigos que no son puramente numéricos
            query.append(" 								SELECT m.COD_CLIE ");
            query.append(" 								from MAE_CLIEN m   ");
            query.append(" 								where (length(translate(trim(COD_CLIE),' 0123456789',' '))) >0  ");
            query.append(" 							)");
            query.append(" GROUP BY PAIS_OID_PAIS ");
            query.append(" HAVING PAIS_OID_PAIS = " + pais_oid);

            bs = BelcorpService.getInstance();

            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        // si no tiene resultados, rowcount=0 o resultado == null devuelve 0
        res = ((resultado.getRowCount() == 0) || (resultado.getValueAt(0, 0) == null)) ? new Long(1) : new Long(((BigDecimal) resultado.getValueAt(0, 0)).longValue());
        
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerSiguienteCodigoPais(pais_oid): Salida");
        return res;
    }

    public Long[] obtenerClasificacionesCliente(Long cliente) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerClasificacionesCliente(cliente): Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();
        Long[] resu = null;

        try {
            query.append(" SELECT c.CLAS_OID_CLAS ");
            query.append(" FROM MAE_CLIEN_CLASI c, MAE_CLIEN_TIPO_SUBTI t ");
            query.append(" WHERE c.CTSU_OID_CLIE_TIPO_SUBT = t.OID_CLIE_TIPO_SUBT  ");
            query.append(" AND t.CLIE_OID_CLIE = " + cliente);
            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());
            resu = new Long[resultado.getRowCount()];

            for (int o = 0; o < resultado.getRowCount(); o++)
                resu[o] = new Long(((BigDecimal) resultado.getValueAt(o, 0)).longValue());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerClasificacionesCliente(cliente): Salida");

        return resu;
    }

    /**
     * 
     * Modificado: SICC-GCC-MAE-005 - SICC-DMCO-MAE-GCC-006 - Cleal
     */

    public DTOConsultaCliente consultarCliente(DTOOID oid) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.consultarCliente(DTOOID): Entrada");

        Boolean bUsaGEOREFERENCIADOR = Boolean.FALSE;
        MONMantenimientoSEG mms;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = new RecordSet();
        StringBuffer query = new StringBuffer();
        DTOConsultaCliente dtos = new DTOConsultaCliente();

        try {
            query.append(" select TICL_OID_TIPO_CLIE, SBTI_OID_SUBT_CLIE, I1.VAL_I18N DESC_TIPO_CLIENTE, ");
            query.append(" I2.VAL_I18N DESC_SUB_TIPO_CLIENTE");
            query.append(" from MAE_CLIEN_TIPO_SUBTI T, V_GEN_I18N_SICC I1, V_GEN_I18N_SICC I2  ");
            query.append(" where I1.ATTR_ENTI(+) = 'MAE_TIPO_CLIEN'  ");
            query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I1.VAL_OID(+) = TICL_OID_TIPO_CLIE  ");
            query.append(" and I2.ATTR_ENTI(+) = 'MAE_SUBTI_CLIEN'  ");
            query.append(" and I2.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I2.VAL_OID(+) = SBTI_OID_SUBT_CLIE ");
            query.append(" and T.CLIE_OID_CLIE = " + oid.getOid() + " ");
            query.append(" ORDER BY DESC_TIPO_CLIENTE ASC ");
            resultado = bs.dbService.executeStaticQuery(query.toString());
            dtos.setTiposSubtipos(resultado);

            query = new StringBuffer();
            resultado = new RecordSet();
            query.append(" select TDOC_OID_TIPO_DOCU, NUM_DOCU_IDEN, VAL_IDEN_DOCU_PRIN, VAL_IDEN_PERS_EMPR, ");
            query.append(" I1.VAL_I18N DESC_TIPO_DOCUM from MAE_CLIEN_IDENT I, V_GEN_I18N_SICC I1  ");
            query.append(" where I1.ATTR_ENTI(+) = 'MAE_TIPO_DOCUM'  ");
            query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I1.VAL_OID(+) = TDOC_OID_TIPO_DOCU ");
            query.append(" and I.CLIE_OID_CLIE = " + oid.getOid() + " ");
            resultado = bs.dbService.executeStaticQuery(query.toString());
            dtos.setIdentificaciones(resultado);

            query = new StringBuffer();
            resultado = new RecordSet();
            // Se agrega campo "cod_clie" a la query.
            query.append(" SELECT val_ape1, val_ape2, val_apel_casa, val_nom1, val_nom2, val_trat, ");
            query.append(" cod_sexo, fec_ingr, fopa_oid_form_pago, i1.val_i18n desc_forma_pago, ");
            query.append(" cod_clie ");
            query.append(" FROM mae_clien m, v_gen_i18n_sicc i1 ");
            query.append(" WHERE i1.val_oid(+) = fopa_oid_form_pago ");
            query.append(" AND i1.attr_enti(+) = 'BEL_FORMA_PAGO' ");
            query.append(" AND i1.idio_oid_idio(+) = " + oid.getOidIdioma());
            query.append(" AND m.oid_clie = " + oid.getOid()); 
            
            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (!resultado.esVacio()) {
                dtos.setApellido1((String) resultado.getValueAt(0, 0));
                dtos.setApellido2((String) resultado.getValueAt(0, 1));
                dtos.setApellidoCasada((String) resultado.getValueAt(0, 2));
                dtos.setNombre1((String) resultado.getValueAt(0, 3));
                dtos.setNombre2((String) resultado.getValueAt(0, 4));

                String tratamiento = (String) resultado.getValueAt(0, 5);

                if ((tratamiento != null) && !(tratamiento.equals(""))) {
                    dtos.setTratamiento(new Byte(tratamiento));
                }

                String sexo = (String) resultado.getValueAt(0, 6);

                if ((sexo != null) && !(sexo.equals(""))) {
                    dtos.setSexo(new Character(sexo.toCharArray()[0]));
                }

                dtos.setFechaIngreso((Date) resultado.getValueAt(0, 7));
                dtos.setFormaPago((String) resultado.getValueAt(0, 9));
                
                // Agregado by ssantana, inc. BELC300021214
                // Se agrega asignacion de parametro CodigoCliente
                dtos.setCodigoCliente((String) resultado.getValueAt(0, 10) );
            }

            query = new StringBuffer();
            resultado = new RecordSet();
            query.append(" SELECT FEC_NACI, COD_EMPL, SNON_OID_NACI, VAL_EDAD, ESCV_OID_ESTA_CIVI, VAL_OCUP,   ");
            query.append(" VAL_PROF, VAL_CENT_TRAB, VAL_CARG_DESE, VAL_CENT_ESTU, NUM_HIJO, NUM_PERS_DEPE,   ");
            query.append(" NSEP_OID_NSEP, TCLV_OID_CICL_VIDA, IND_CORR, IMP_INGR_FAMI, I1.VAL_I18N DESC_NACION, ");
            query.append(" I2.VAL_I18N DESC_EDO_CIVIL, I3.VAL_I18N DESC_NESP, I4.VAL_I18N DESC_CICLO_VIDA,  ");
            query.append(" NIED_OID_NIVE_ESTU, i5.VAL_I18N desc_nivel_estu, IND_ACTI ");
            query.append(" FROM MAE_CLIEN_DATOS_ADICI , V_GEN_I18N_SICC I1, V_GEN_I18N_SICC I2, V_GEN_I18N_SICC I3, V_GEN_I18N_SICC I4, v_gen_i18n_sicc i5 ");
            query.append(" where I1.ATTR_ENTI(+) = 'SEG_NACIO'  ");
            query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I1.VAL_OID(+) = SNON_OID_NACI  ");
            query.append(" and I2.ATTR_ENTI(+) = 'MAE_ESTAD_CIVIL'  ");
            query.append(" and I2.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I2.VAL_OID(+) = ESCV_OID_ESTA_CIVI   ");
            query.append(" and I3.ATTR_ENTI(+) = 'MAE_TIPO_NIVEL_SOCEC_PERSO'  ");
            query.append(" and I3.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I3.VAL_OID(+) = NSEP_OID_NSEP  ");
            query.append(" and I4.ATTR_ENTI(+) = 'MAE_CICLO_VIDA'  ");
            query.append(" and I4.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I4.VAL_OID(+) = TCLV_OID_CICL_VIDA  ");
            query.append(" and i5.ATTR_ENTI(+) = 'MAE_NIVEL_ESTUD' ");
            query.append(" AND i5.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" AND i5.VAL_OID(+) = NIED_OID_NIVE_ESTU ");
            query.append(" and CLIE_OID_CLIE = " + oid.getOid() + " ");
            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (!resultado.esVacio()) {
                UtilidadesLog.debug("resultado: " + resultado);

                dtos.setFechaNacimiento((Date) resultado.getValueAt(0, 0));
                dtos.setCodigoEmpleado((String) resultado.getValueAt(0, 1));
                /*cleal incidencia 21311 fecha 28/10/2005*/
                // Modificado por ssantana, 8/11/2005
                // dtos.setNacionalidad((resultado.getValueAt(0, 2))!=null ? new String(((BigDecimal) resultado.getValueAt(0, 2)).toString()) : "");
                dtos.setNacionalidad((resultado.getValueAt(0, 16)) != null ? (String) resultado.getValueAt(0, 16) : ""); 
                //(resultado.getValueAt(0, 10) != null) ? new String(((BigDecimal) resultado.getValueAt(0, 10)).toString()) : null

                // dtos.setEdad((String)resultado.getValueAt(0, 3));
                dtos.setEdad((resultado.getValueAt(0, 3) != null) ? new String(((BigDecimal) resultado.getValueAt(0, 3)).toString()) : "");
                dtos.setEstadoCivil((String) resultado.getValueAt(0, 17));
                dtos.setOcupacion((String) resultado.getValueAt(0, 5));
                dtos.setProfesion((String) resultado.getValueAt(0, 6));
                dtos.setCentroTrabajo((String) resultado.getValueAt(0, 7));
                dtos.setCargo((String) resultado.getValueAt(0, 8));
                dtos.setCentro((String) resultado.getValueAt(0, 9));

                //dtos.setNumeroHijos((BigDecimal)resultado.getValueAt(0, 10));
                /*                dtos.setNumeroHijos((resultado.getValueAt(0, 10) != null)
                                    ? new String(
                                        ((BigDecimal) resultado.getValueAt(0, 10)).toString())
                                    : "0");*/
                dtos.setNumeroHijos((resultado.getValueAt(0, 10) != null) ? new String(((BigDecimal) resultado.getValueAt(0, 10)).toString()) : null);

                //dtos.setPersonasDependientes((String)resultado.getValueAt(0, 11));
                /*                dtos.setPersonasDependientes((resultado.getValueAt(0, 11) != null)
                                    ? new String(
                                        ((BigDecimal) resultado.getValueAt(0, 11)).toString())
                                    : "0");*/
                dtos.setPersonasDependientes((resultado.getValueAt(0, 11) != null) ? new String(((BigDecimal) resultado.getValueAt(0, 11)).toString()) : null);

                dtos.setNSEP((String) resultado.getValueAt(0, 18));
                dtos.setCicloVidaFamiliar((String) resultado.getValueAt(0, 19));
                dtos.setNivelEstudios((String) resultado.getValueAt(0, 21));

                //String corres = (String)resultado.getValueAt(0, 14);
                String corres = (resultado.getValueAt(0, 14) != null) ? new String(((BigDecimal) resultado.getValueAt(0, 14)).toString()) : null;

                //String corres = ((BigDecimal) resultado.getValueAt(0,14)).toString();
                Boolean correspondencia = null;

                if ((corres != null) && !(corres.equals(""))) {
                    if (corres.equals("1")) {
                        correspondencia = Boolean.TRUE;
                    } else {
                        correspondencia = Boolean.FALSE;
                    }
                }

                dtos.setDeseaCorrespondencia(correspondencia);

                BigDecimal big = (BigDecimal) resultado.getValueAt(0, 15);

                if (big == null) {
                    dtos.setImporteIngreso("");
                } else {
                    dtos.setImporteIngreso(big.toString());
                }
                
                //SICC-DMCO-MAE-GCC-006 - Cleal
                Boolean indActi = null;
                if(((BigDecimal) resultado.getValueAt(0, 22))!=null){

                    if(((BigDecimal) resultado.getValueAt(0, 22)).longValue()==1){
                        indActi = new Boolean(true);
                    } else if(((BigDecimal) resultado.getValueAt(0, 22)).longValue()==0){
                        indActi = new Boolean(false);                
                    }
                }
                dtos.setIndicadorActivo(indActi);
            }

            query = new StringBuffer();
            resultado = new RecordSet();
            query.append(" SELECT I2.VAL_I18N, C.COD_CLIE, FEC_DESD, FEC_HAST, TIVC_OID_TIPO_VINC, IND_VINC_PPAL, I1.VAL_I18N DESC_TIPO_VINCU ");
            query.append(" FROM MAE_CLIEN_VINCU, V_GEN_I18N_SICC I1, mae_tipo_vincu tv, seg_pais p, v_gen_i18n_sicc i2, mae_clien c ");
            query.append(" where I1.ATTR_ENTI(+) = 'MAE_TIPO_VINCU'  ");
            query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I1.VAL_OID(+) = TIVC_OID_TIPO_VINC ");
            
            /* inicio deshace modif ciglesias incidencia 24377 17/11/2006
            // SPLATAS - 26/10/2006 - Error al obtener clientes vinculados 
            // query.append(" and CLIE_OID_CLIE_VNDO = " + oid.getOid() + " ");
            query.append(" and CLIE_OID_CLIE_VNTE = " + oid.getOid() + " ");
            */
            query.append(" and CLIE_OID_CLIE_VNDO = " + oid.getOid() + " ");
            /*fin deshace ciglesias 24377*/
            
            query.append(" AND mae_clien_vincu.TIVC_OID_TIPO_VINC = tv.OID_TIPO_VINC ");
            
            // SPLATAS - 26/10/2006 - Error al obtener clientes vinculados 
             query.append(" AND mae_clien_vincu.CLIE_OID_CLIE_VNTE = c.OID_CLIE "); //eiraola 30/11/2006 Incidencia DBLG7...165
            
            //query.append(" AND mae_clien_vincu.CLIE_OID_CLIE_VNDO = c.OID_CLIE ");
            
            query.append(" AND tv.PAIS_OID_PAIS = p.OID_PAIS ");
            query.append(" AND i2.VAL_OID = p.OID_PAIS ");
            query.append(" AND i2.ATTR_ENTI = 'SEG_PAIS' ");
            query.append(" AND i2.IDIO_OID_IDIO = " + oid.getOidIdioma());

            resultado = bs.dbService.executeStaticQuery(query.toString());

            //UtilidadesLog.info("resultado Vinculo: " + resultado.toString() );
            dtos.setVinculos(resultado);

            query = new StringBuffer();
            resultado = new RecordSet();

            /*query.append(" SELECT DES_CLIE_PREF, TIPF_OID_TIPO_PREF, DES_CLIE_PREF ");
            query.append(" FROM MAE_CLIEN_PREFE   ");
            query.append(" where CLIE_OID_CLIE = " + oid.getOid() + " ");*/
            query.append(" SELECT i1.VAL_I18N descripcionTipo , a.TIPF_OID_TIPO_PREF, a.DES_CLIE_PREF ");
            query.append(" FROM MAE_CLIEN_PREFE a , v_gen_i18n_sicc i1 ");
            query.append(" where a.CLIE_OID_CLIE = " + oid.getOid() + " ");
            query.append(" and i1.ATTR_ENTI = 'MAE_TIPO_PREFE' ");
            query.append(" and i1.VAL_OID = a.TIPF_OID_TIPO_PREF ");
            query.append(" and i1.IDIO_OID_IDIO = " + oid.getOidIdioma());
            query.append(" and i1.ATTR_NUM_ATRI = 1 ");
            resultado = bs.dbService.executeStaticQuery(query.toString());
            dtos.setPreferencias(resultado);

            query = new StringBuffer();
            resultado = new RecordSet();
            query.append(" SELECT MARC_OID_MARC, NUM_OBSE, VAL_TEXT, DES_MARC   ");
            query.append(" FROM MAE_CLIEN_OBSER M, SEG_MARCA S   ");
            query.append(" where CLIE_OID_CLIE = " + oid.getOid() + " ");
            query.append(" and M.MARC_OID_MARC = S.OID_MARC  ");
            resultado = bs.dbService.executeStaticQuery(query.toString());
            dtos.setObservaciones(resultado);

            query = new StringBuffer();
            resultado = new RecordSet();

            /*            query.append(" SELECT c.PAIS_OID_PAIS , c.COD_CLIE, t. TICL_OID_TIPO_CLIE, p.COD_TIPO_CONT, ");
                        query.append(" p.FEC_CONT, p.FEC_SIGU_CONT, I1.VAL_I18N DESC_PAIS, I2.VAL_I18N DESC_TIPO_CLIENTE   ");
                        query.append(" FROM MAE_CLIEN_PRIME_CONTA p, MAE_CLIEN c, MAE_CLIEN_TIPO_SUBTI t, V_GEN_I18N_SICC I1,     ");
                        query.append(" V_GEN_I18N_SICC I2     ");
                        query.append(" where I1.ATTR_ENTI(+) = 'SEG_PAIS'    ");
                        query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I1.VAL_OID(+) = c.PAIS_OID_PAIS    ");
                        query.append(" and I2.ATTR_ENTI(+) = 'MAE_TIPO_CLIEN'    ");
                        query.append(" and I2.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I2.VAL_OID(+) = TICL_OID_TIPO_CLIE   ");
                        query.append(" AND p.CTSU_CLIE_CONT = t.OID_CLIE_TIPO_SUBT    ");
                        query.append(" AND t.CLIE_OID_CLIE = c.OID_CLIE    ");
                        query.append(" and p.CLIE_OID_CLIE = " + oid.getOid() + " "); */
            query.append(" SELECT c.pais_oid_pais, c.cod_clie, t.ticl_oid_tipo_clie, p.cod_tipo_cont, ");
            query.append(" p.fec_cont, p.fec_sigu_cont, i1.val_i18n desc_pais, ");
            query.append(" i2.val_i18n desc_tipo_cliente, i3.val_i18n, perio.val_nomb_peri, marca.DES_MARC ");
            query.append(" FROM mae_clien_prime_conta p, ");
            query.append(" mae_clien c, ");
            query.append(" mae_clien_tipo_subti t, ");
            query.append(" seg_canal canal, ");
            query.append(" cra_perio perio, ");
            query.append(" seg_marca marca, ");
            query.append(" v_gen_i18n_sicc i1, ");
            query.append(" v_gen_i18n_sicc i2, ");
            query.append(" v_gen_i18n_sicc i3 ");
            query.append(" WHERE i1.attr_enti(+) = 'SEG_PAIS' ");
            query.append(" AND i1.idio_oid_idio(+) = " + oid.getOidIdioma().toString());
            query.append(" AND i1.val_oid(+) = c.pais_oid_pais ");
            query.append(" AND i2.attr_enti(+) = 'MAE_TIPO_CLIEN' ");
            query.append(" AND i2.idio_oid_idio(+) = " + oid.getOidIdioma().toString());
            query.append(" AND i2.val_oid(+) = ticl_oid_tipo_clie ");
            query.append(" AND p.ctsu_clie_cont = t.oid_clie_tipo_subt ");
            query.append(" AND t.clie_oid_clie = c.oid_clie ");
            query.append(" AND p.clie_oid_clie = " + oid.getOid().toString());
            query.append(" AND p.perd_oid_peri = perio.oid_peri(+) ");
            query.append(" AND p.cana_oid_cana = canal.oid_cana(+) ");
            query.append(" AND canal.oid_cana = i3.val_oid(+) ");
            query.append(" AND i3.attr_enti(+) = 'SEG_CANAL' ");
            query.append(" AND i3.attr_num_atri(+) = 1 ");
            query.append(" AND i3.idio_oid_idio(+) = " + oid.getOidIdioma().toString());
            query.append(" and p.MARC_OID_MARC = marca.OID_MARC(+) ");
            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (!resultado.esVacio()) {
                // by Ssantana, 29/7/04 - Se corren algunos indices en -1 al quitar
                // campo Primer Pedido Contacto. 
                // 5/8//2004 - Se agregan descripciones de Marca, Canal y Periodo
                dtos.setPaisContactado((String) resultado.getValueAt(0, 6));
                dtos.setCodigoClienteContactado((String) resultado.getValueAt(0, 1));
                dtos.setTipoClienteContactado((String) resultado.getValueAt(0, 7));
                dtos.setTipoContacto((String) resultado.getValueAt(0, 3));
                dtos.setFechaContacto((Date) resultado.getValueAt(0, 4));
                dtos.setFechaSiguienteContacto((Date) resultado.getValueAt(0, 5));
                dtos.setMarcaContactoDesc((String) resultado.getValueAt(0, 10));
                dtos.setCanalContactoDesc((String) resultado.getValueAt(0, 8));
                dtos.setPeriodoContactoDesc((String) resultado.getValueAt(0, 9));

                /*                dtos.setPaisContactado((String)resultado.getValueAt(0, 7));
                                dtos.setCodigoClienteContactado((String)resultado.getValueAt(0, 1));
                                dtos.setTipoClienteContactado((String)resultado.getValueAt(0, 8));
                                dtos.setTipoContacto((String)resultado.getValueAt(0, 3));
                                dtos.setFechaContacto((Date)resultado.getValueAt(0, 4));
                                //dtos.setFechaPrimerPedido((Date)resultado.getValueAt(0, 5));
                                dtos.setFechaSiguienteContacto((Date)resultado.getValueAt(0, 6));*/
            }
            //Cleal Mae-03
            MONMantenimientoSEGHome mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
            mms = mmsHome.create();
            bUsaGEOREFERENCIADOR = mms.usaGeoreferenciador(oid.getOidPais());
            
            resultado = new RecordSet();
            if(Boolean.FALSE.equals(bUsaGEOREFERENCIADOR)){
                UtilidadesLog.debug("*** No usa GEO");
                resultado = obtieneDireccionSinGEO(oid);
            } else{
                UtilidadesLog.debug("*** Usa GEO");
                resultado = obtieneDireccionConGEO(oid);
            }//
            
            //
            /*
            query = new StringBuffer();
            resultado = new RecordSet();
            query.append(" SELECT dir.TIDC_OID_TIPO_DIRE, dir.TIVI_OID_TIPO_VIA, ");
            //SICC-GCC-MAE-005 - Cleal
            query.append(" NVL(dir.VAL_NOMB_VIA,vi.NOM_VIA) AS VIA, ");
            
            query.append(" dir.NUM_PPAL, dir.VAL_COD_POST, ");
            query.append(" dir.VAL_OBSE, I1.VAL_I18N DESC_TIPO_DIREC, I2.VAL_I18N DESC_TIPO_VIA, ind_dire_ppal, VAL.DES_GEOG ");
            query.append(" FROM MAE_CLIEN_DIREC dir, ZON_VIA vi, ZON_VALOR_ESTRU_GEOPO val, ");
            //Cleal MAE-03
            if(bUsaGEOREFERENCIADOR.equals(Boolean.FALSE)){
                query.append(" ZON_TERRI terr, ");
            }
            //
            query.append(" V_GEN_I18N_SICC I1, V_GEN_I18N_SICC I2 ");
            query.append(" WHERE I1.ATTR_ENTI(+) = 'MAE_TIPO_DIREC'    ");
            query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I1.VAL_OID(+) = TIDC_OID_TIPO_DIRE    ");
            query.append(" and I2.ATTR_ENTI(+) = 'SEG_TIPO_VIA'    ");
            query.append(" and I2.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");

            //query.append(" and I2.VAL_OID(+) = vi.TIVI_OID_TIPO_VIA    ");
            query.append(" and I2.VAL_OID(+) = dir.tivi_oid_tipo_via ");
            query.append(" and dir.CLIE_OID_CLIE = " + oid.getOid() + " ");
            query.append(" AND dir.ZVIA_OID_VIA = vi.OID_VIA(+)  ");
            //Cleal MAE-03
            if(bUsaGEOREFERENCIADOR.equals(Boolean.FALSE)){
                query.append(" AND dir.TERR_OID_TERR = terr.OID_TERR ");
                query.append(" AND terr.VEPO_OID_VALO_ESTR_GEOP = val.OID_VALO_ESTR_GEOP ");
                //SICC-GCC-MAE-005 - Cleal
                query.append(" AND vi.PAIS_OID_PAIS = "+oid.getOidPais());
            } else{
                
                query.append(" ");
                
            }
            resultado = bs.dbService.executeStaticQuery(query.toString());
            */
            dtos.setDirecciones(resultado);

            query = new StringBuffer();
            resultado = new RecordSet();

            /*            query.append(" SELECT TICM_OID_TIPO_COMU, VAL_DIA_COMU, VAL_TEXT_COMU, FEC_HORA_DESD,   ");
                        query.append(" FEC_HORA_HAST, VAL_INTE_COMU, IND_COMU_PPAL, I1.VAL_I18N DESC_TIPO_COMUN ");
                        query.append(" FROM MAE_CLIEN_COMUN, V_GEN_I18N_SICC I1  ");
                        query.append(" where I1.ATTR_ENTI(+) = 'MAE_TIPO_COMUN'  ");
                        query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I1.VAL_OID(+) = TICM_OID_TIPO_COMU ");
                        query.append(" and CLIE_OID_CLIE = " + oid.getOid() + " ");*/
            query.append(" SELECT i1.val_i18n desc_tipo_comun, val_dia_comu, val_text_comu, ind_comu_ppal, ");

            /*            query.append(" DECODE(to_char(FEC_HORA_DESD, 'HH24:MI'), NULL, ' ', to_char(FEC_HORA_DESD, 'HH24:MI')), ");
                        query.append(" DECODE(to_char(FEC_HORA_HAST, 'HH24:MI'), NULL, ' ', to_char(FEC_HORA_HAST, 'HH24:MI')), ");*/
            query.append(" to_char(FEC_HORA_DESD, 'HH24:MI'), ");
            query.append(" to_char(FEC_HORA_HAST, 'HH24:MI'), ");
            query.append(" val_inte_comu ");
            query.append(" FROM mae_clien_comun, v_gen_i18n_sicc i1 ");
            query.append(" WHERE i1.attr_enti(+) = 'MAE_TIPO_COMUN' ");
            query.append(" AND i1.idio_oid_idio(+) = " + oid.getOidIdioma().toString());
            query.append(" AND i1.val_oid(+) = ticm_oid_tipo_comu ");
            query.append(" AND clie_oid_clie = " + oid.getOid().toString());

            /*            query.append(" SELECT TICM_OID_TIPO_COMU, VAL_DIA_COMU, VAL_TEXT_COMU, FEC_HORA_DESD,   ");
                        query.append(" FEC_HORA_HAST, VAL_INTE_COMU, IND_COMU_PPAL, I1.VAL_I18N DESC_TIPO_COMUN ");
                        query.append(" FROM MAE_CLIEN_COMUN, V_GEN_I18N_SICC I1  ");
                        query.append(" where I1.ATTR_ENTI(+) = 'MAE_TIPO_COMUN'  ");
                        query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I1.VAL_OID(+) = TICM_OID_TIPO_COMU ");
                        query.append(" and CLIE_OID_CLIE = " + oid.getOid() + " ");   */
            resultado = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("----- resultado Comunicaciones: " + resultado);
            dtos.setComunicaciones(resultado);

            query = new StringBuffer();
            resultado = new RecordSet();
            query.append(" SELECT MARC_OID_MARC, S.DES_MARC ");
            query.append(" FROM MAE_CLIEN_MARCA M, SEG_MARCA S ");
            query.append(" where CLIE_OID_CLIE = " + oid.getOid() + " ");
            query.append(" and M.MARC_OID_MARC = S.OID_MARC ");
            resultado = bs.dbService.executeStaticQuery(query.toString());

            String[] marcas = new String[resultado.getRowCount()];

            for (int i = 0; i < resultado.getRowCount(); i++)
                marcas[i] = (String) resultado.getValueAt(i, 1);

            dtos.setMarcas(marcas);

            query = new StringBuffer();
            resultado = new RecordSet();
            query.append(" SELECT TITR_OID_TIPO_TARJ, CLTA_OID_CLAS_TARJ, CBAN_OID_BANC, I1.VAL_I18N DESC_TIPO_TARJ, ");
            query.append(" DES_CLAS_TARJ, DES_BANC   ");
            query.append(" FROM MAE_CLIEN_TARJE, V_GEN_I18N_SICC I1, MAE_CLASE_TARJE, CCC_BANCO   ");
            query.append(" where I1.ATTR_ENTI(+) = 'MAE_TIPO_TARJE'  ");
            query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I1.VAL_OID(+) = TITR_OID_TIPO_TARJ ");
            query.append(" and CLTA_OID_CLAS_TARJ = OID_CLAS_TARJ ");
            query.append(" and CLIE_OID_CLIE = " + oid.getOid() + " ");
            query.append(" and CBAN_OID_BANC = OID_BANC ");
            resultado = bs.dbService.executeStaticQuery(query.toString());
            dtos.setTarjetas(resultado);

            query = new StringBuffer();
            resultado = new RecordSet();

            /*            query.append(" SELECT t.TICL_OID_TIPO_CLIE, t.SBTI_OID_SUBT_CLIE, c.CLAS_OID_CLAS, c.TCCL_OID_TIPO_CLASI,   ");
                        query.append(
                            " c.FEC_CLAS, PERD_OID_PERI, I1.VAL_I18N DESC_TIPO_CLIENTE, I2.VAL_I18N DESC_SUB_TIPO_CLIENTE, I3.VAL_I18N DESC_CLASI, I4.VAL_I18N DESC_TIPO_CLASI_CLIENTE, I5.VAL_I18N DESC_PERIODO, ");
                        query.append(" i6.VAL_I18N desc_canal, m.DES_MARC desc_marca ");
                        query.append(" FROM MAE_CLIEN_TIPO_SUBTI t, MAE_CLIEN_CLASI c, V_GEN_I18N_SICC I1, V_GEN_I18N_SICC I2,   ");
                        query.append(" V_GEN_I18N_SICC I3, V_GEN_I18N_SICC I4, V_GEN_I18N_SICC I5,  ");
                        query.append(" cra_perio p, seg_marca m, v_gen_i18n_sicc i6 ");
                        query.append(" WHERE I1.ATTR_ENTI(+) = 'MAE_TIPO_CLIEN'  ");
                        query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I1.VAL_OID(+) = t.TICL_OID_TIPO_CLIE  ");
                        query.append(" and I2.ATTR_ENTI(+) = 'MAE_SUBTI_CLIEN'  ");
                        query.append(" and I2.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I2.VAL_OID(+) = t.SBTI_OID_SUBT_CLIE  ");
                        query.append(" and I3.ATTR_ENTI(+) = 'MAE_CLASI'  ");
                        query.append(" and I3.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I3.VAL_OID(+) = c.CLAS_OID_CLAS  ");
                        query.append(" and I4.ATTR_ENTI(+) = 'MAE_TIPO_CLASI_CLIEN'  ");
                        query.append(" and I4.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I4.VAL_OID(+) = c.TCCL_OID_TIPO_CLASI  ");
                        query.append(" and I5.ATTR_ENTI(+) = 'CRA_PERIO'  ");
                        query.append(" and I5.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I5.VAL_OID(+) = PERD_OID_PERI ");
                        query.append(" and t.OID_CLIE_TIPO_SUBT = c.CTSU_OID_CLIE_TIPO_SUBT ");
                        query.append(" AND t.CLIE_OID_CLIE = " + oid.getOid() + " ");
                        query.append(" AND perd_oid_peri = p.OID_PERI ");
                        query.append(" AND i6.VAL_OID(+) = p.CANA_OID_CANA ");
                        query.append(" AND i6.ATTR_ENTI(+) = 'SEG_CANAL' ");
                        query.append(" AND i6.IDIO_OID_IDIO = " + oid.getOidIdioma() + " ");
                        query.append(" AND i6.ATTR_NUM_ATRI = 1 ");
                        query.append(" AND p.MARC_OID_MARC = m.OID_MARC ");        */
            query.append(" SELECT m.DES_MARC, v1.VAL_I18N, v2.VAL_I18N, ");
            query.append(" v3.VAL_I18N, v4.VAL_I18N, v5.VAL_I18N ");
            query.append(" FROM mae_clien_tipo_subti t, mae_clien_clasi c, cra_perio p, seg_marca m, v_gen_i18n_sicc v1, ");
            query.append(" v_gen_i18n_sicc v2, v_gen_i18n_sicc v3, v_gen_i18n_sicc v4, v_gen_i18n_sicc v5 ");
            query.append(" WHERE t.oid_clie_tipo_subt = c.ctsu_oid_clie_tipo_subt ");
            query.append(" AND c.perd_oid_peri = p.oid_peri ");
            query.append(" AND t.clie_oid_clie = " + oid.getOid().toString());
            query.append(" AND p.MARC_OID_MARC = m.OID_MARC "); // MARCA
            query.append(" AND p.CANA_OID_CANA = v1.VAL_OID "); // CANAL
            query.append(" AND v1.ATTR_NUM_ATRI = 1 ");
            query.append(" AND v1.ATTR_ENTI = 'SEG_CANAL' ");
            query.append(" AND v1.IDIO_OID_IDIO = " + oid.getOidIdioma());
            query.append(" AND t.TICL_OID_TIPO_CLIE = v2.VAL_OID "); // TIPO CLIENTE
            query.append(" AND v2.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
            query.append(" AND v2.ATTR_NUM_ATRI = 1 ");
            query.append(" AND v2.IDIO_OID_IDIO = " + oid.getOidIdioma());
            query.append(" AND t.SBTI_OID_SUBT_CLIE = v3.VAL_OID "); // SUBTIPO CLIENTE
            query.append(" AND v3.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
            query.append(" AND v3.ATTR_NUM_ATRI = 1 ");
            query.append(" AND v3.IDIO_OID_IDIO = " + oid.getOidIdioma());
            query.append(" AND c.TCCL_OID_TIPO_CLASI = v4.VAL_OID "); // TIPO CLASIFICACION
            query.append(" AND v4.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
            query.append(" AND v4.ATTR_NUM_ATRI = 1 ");
            query.append(" AND v4.IDIO_OID_IDIO = " + oid.getOidIdioma());
            query.append(" AND c.CLAS_OID_CLAS = v5.VAL_OID "); // CLASIFICACION
            query.append(" AND v5.ATTR_ENTI = 'MAE_CLASI' ");
            query.append(" AND v5.ATTR_NUM_ATRI = 1 ");
            query.append(" AND v5.IDIO_OID_IDIO = " + oid.getOidIdioma());

            resultado = bs.dbService.executeStaticQuery(query.toString());
            
            // BELC300023061 - 04/07/2006
            // Si no se obtuvo ninguna clasificacion para el cliente en la consulta anterior, 
            // insertar una fila en el atributo clasificaciones, con el indicador principal activo, 
            // sólo con la marca y el canal
            if (!resultado.esVacio()) {
                dtos.setClasificaciones(resultado);
            } else {
                query = new StringBuffer();
                resultado = new RecordSet();
                
                query.append(" SELECT mar.DES_MARC, ");
                query.append(" 		    iCa.VAL_I18N, null VAL_I18N, null VAL_I18N, null VAL_I18N, null VAL_I18N ");
                query.append("   FROM MAE_CLIEN_UNIDA_ADMIN uA, ");
                query.append("   	    CRA_PERIO per, ");
                query.append("   		  SEG_MARCA mar, ");
                query.append(" 	      V_GEN_I18N_SICC iCa ");
                query.append("  WHERE uA.CLIE_OID_CLIE = " + oid.getOid().toString());
                query.append("        AND uA.IND_ACTI = 1 ");
                query.append("   	    AND uA.PERD_OID_PERI_INI = per.OID_PERI ");
                query.append("     	  AND per.MARC_OID_MARC = mar.OID_MARC ");
                query.append("        AND per.CANA_OID_CANA = iCa.VAL_OID ");
                query.append("        AND iCa.ATTR_NUM_ATRI = 1  ");
                query.append("        AND iCa.ATTR_ENTI = 'SEG_CANAL'  ");
                query.append("        AND iCa.IDIO_OID_IDIO = " + oid.getOidIdioma());
                query.append("  ORDER BY uA.OID_CLIE_UNID_ADMI ASC ");
                
                resultado = bs.dbService.executeStaticQuery(query.toString());
                dtos.setClasificaciones(resultado);
            }

            query = new StringBuffer();
            resultado = new RecordSet();

            //el false se utiliza para indicar que estas filas son de problemas 
            //el true indica que estas filas son de soluciones 
            query.append(" SELECT i1.VAL_I18N, DES_PROB, decode(IND_SOLU,0,'false',1,'true') IND_SOLU, I2.VAL_I18N TSOC_OID_TIPO_SOLU, DES_SOLU, VAL_NEGO_PROD ");
            query.append("   FROM MAE_CLIEN_PROBL, V_GEN_I18N_SICC I1, V_GEN_I18N_SICC I2 ");
            query.append(" where I1.ATTR_ENTI(+) = 'MAE_TIPO_PROBL'  ");
            query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I1.VAL_OID(+) = TIPB_OID_TIPO_PROB ");
            query.append(" and I2.ATTR_ENTI(+) = 'MAE_TIPO_SOLUC'  ");
            query.append(" and I2.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
            query.append(" and I2.VAL_OID(+) = TSOC_OID_TIPO_SOLU ");
            query.append(" and CLIE_OID_CLIE = " + oid.getOid() + " ");

            resultado = bs.dbService.executeStaticQuery(query.toString());
            dtos.setProblemasSoluciones(resultado);

            query = new StringBuffer();
            resultado = new RecordSet();

            /*SELECT s.des_marc, i1.val_i18n desc_tipo_perfil_psico, cod_test, fec_psic
              FROM mae_psico, v_gen_i18n_sicc i1, seg_marca s
             WHERE i1.attr_enti(+) = 'MAE_TIPO_PERFI_PSICO'
               AND i1.idio_oid_idio(+) = 1
               AND i1.val_oid(+) = tpoid_tipo_perf_psic
               AND clie_oid_clie = 152
               AND marc_oid_marc = s.oid_marc           */
            query.append(" SELECT s.des_marc, i1.val_i18n desc_tipo_perfil_psico, cod_test, fec_psic ");
            query.append(" FROM mae_psico, v_gen_i18n_sicc i1, seg_marca s ");
            query.append(" WHERE i1.attr_enti(+) = 'MAE_TIPO_PERFI_PSICO' ");
            query.append(" AND i1.idio_oid_idio(+) = " + oid.getOidIdioma().toString());
            query.append(" AND i1.val_oid(+) = tpoid_tipo_perf_psic ");
            query.append(" AND clie_oid_clie = " + oid.getOid().toString());
            query.append(" AND marc_oid_marc = s.oid_marc ");

            /*            query.append(" SELECT MARC_OID_MARC, TPOID_TIPO_PERF_PSIC, COD_TEST, FEC_PSIC,  ");
                        query.append(" I1.VAL_I18N DESC_TIPO_PERFIL_PSICO, S.DES_MARC   ");
                        query.append(" FROM MAE_PSICO, V_GEN_I18N_SICC I1, SEG_MARCA S   ");
                        query.append(" where I1.ATTR_ENTI(+) = 'MAE_TIPO_PERFI_PSICO'   ");
                        query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                        query.append(" and I1.VAL_OID(+) = TPOID_TIPO_PERF_PSIC  ");
                        query.append(" and CLIE_OID_CLIE = " + oid.getOid() + " ");
                        query.append(" and MARC_OID_MARC = S.OID_MARC         ");*/
            resultado = bs.dbService.executeStaticQuery(query.toString());
            dtos.setPsicografias(resultado);
        } catch (CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("DTO a retornar: " + dtos.toString());
        UtilidadesLog.info(" DAOMAEMaestroClientes.consultarCliente(DTOOID): Salida");

        return dtos;
    }
    
    
    private RecordSet obtieneDireccionConGEO(DTOOID oid) throws MareException{
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtieneDireccionConGEO(DTOOID): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs; 
        BelcorpService bs;
        String codigoError;
        RecordSet resultado = new RecordSet();
        
        try {
            query.append(" SELECT DISTINCT M.COD_UNID_GEOG ");
            query.append(" FROM MAE_CLIEN_DIREC M ");
            query.append(" WHERE M.CLIE_OID_CLIE = "+ oid.getOid());
            query.append(" AND M.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
            
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: "+rs);
            
            if(!rs.esVacio()){
                
                for(int j=0;j<rs.getRowCount();j++){
                    RecordSet rs2 = new RecordSet();
                    String orden_1 = "";
                    String orden_2 = "";
                    String orden_3 = "";
                    String orden_4 = "";
                    String orden_5 = "";
                    String orden_6 = "";
                    String orden_7 = "";
                    String orden_8 = "";
                    String orden_9 = "";
                    String codUniGeo = rs.getValueAt(j,0)==null?"":(String) rs.getValueAt(j,0);
                    int sizeCod = codUniGeo.length();
                    int numOrdenesGeo = sizeCod/6;
                    
                    UtilidadesLog.debug("*** numOrdenesGeo: "+numOrdenesGeo);
                    switch(numOrdenesGeo){
                        case 1:
                                orden_1 = codUniGeo.substring(0);
                                break;
                        case 2: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                break;
                        case 3: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                break;
                        case 4: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                break;
                        case 5: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                break;
                        case 6: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                orden_6 = codUniGeo.substring(30, 36);
                                break;
                        case 7: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                orden_6 = codUniGeo.substring(30, 36);
                                orden_7 = codUniGeo.substring(36, 40);
                                break;
                        case 8: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                orden_6 = codUniGeo.substring(30, 36);
                                orden_7 = codUniGeo.substring(36, 40);
                                orden_8 = codUniGeo.substring(40, 46);
                                break;
                        case 9: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                orden_6 = codUniGeo.substring(30, 36);
                                orden_7 = codUniGeo.substring(36, 40);
                                orden_8 = codUniGeo.substring(40, 46);
                                orden_9 = codUniGeo.substring(46, 52);
                                break;
                    }
                    
                    StringBuffer query2 = new StringBuffer();
                    query2.append(" SELECT dir.TIDC_OID_TIPO_DIRE, dir.TIVI_OID_TIPO_VIA, ");
                    query2.append(" NVL(dir.VAL_NOMB_VIA,vi.NOM_VIA) AS VIA, ");
                    query2.append(" dir.NUM_PPAL, dir.VAL_COD_POST, ");
                    query2.append(" dir.VAL_OBSE, I1.VAL_I18N DESC_TIPO_DIREC, I2.VAL_I18N DESC_TIPO_VIA, ind_dire_ppal, VAL.DES_GEOG ");
                    query2.append(" FROM MAE_CLIEN_DIREC dir, ZON_VIA vi, ZON_VALOR_ESTRU_GEOPO val, ");
                    query2.append(" V_GEN_I18N_SICC I1, V_GEN_I18N_SICC I2 ");
                    query2.append(" WHERE I1.ATTR_ENTI(+) = 'MAE_TIPO_DIREC'    ");
                    query2.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                    query2.append(" and I1.VAL_OID(+) = TIDC_OID_TIPO_DIRE    ");
                    query2.append(" and I2.ATTR_ENTI(+) = 'SEG_TIPO_VIA'    ");
                    query2.append(" and I2.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
                    query2.append(" and I2.VAL_OID(+) = dir.tivi_oid_tipo_via ");
                    query2.append(" and dir.CLIE_OID_CLIE = " + oid.getOid() + " ");
                    query2.append(" AND dir.ZVIA_OID_VIA = vi.OID_VIA(+)  ");
                    query2.append(" AND dir.ind_elim = 0 "); //agregado por Sapaza, incidencia V_MAE_08
                    if(!"".equals(orden_1)){
                        query2.append(" AND VAL.ORDE_1 = '"+orden_1+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_1 IS NULL ");
                    }
                    if(!"".equals(orden_2)){
                        query2.append(" AND VAL.ORDE_2 = '"+orden_2+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_2 IS NULL ");
                    }
                    if(!"".equals(orden_3)){
                        query2.append(" AND VAL.ORDE_3 = '"+orden_3+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_3 IS NULL ");
                    }
                    if(!"".equals(orden_4)){
                        query2.append(" AND VAL.ORDE_4 = '"+orden_4+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_4 IS NULL ");
                    }
                    if(!"".equals(orden_5)){
                        query2.append(" AND VAL.ORDE_5 = '"+orden_5+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_5 IS NULL ");
                    }
                    if(!"".equals(orden_6)){
                        query2.append(" AND VAL.ORDE_6 = '"+orden_6+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_6 IS NULL ");
                    }
                    if(!"".equals(orden_7)){
                        query2.append(" AND VAL.ORDE_7 = '"+orden_7+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_7 IS NULL ");
                    }
                    if(!"".equals(orden_8)){
                        query2.append(" AND VAL.ORDE_8 = '"+orden_8+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_8 IS NULL ");
                    }
                    if(!"".equals(orden_9)){
                        query2.append(" AND VAL.ORDE_9 = '"+orden_9+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_9 IS NULL ");
                    }
                    query2.append(" AND VAL.pais_oid_pais = "+oid.getOidPais());
        
                    bs = BelcorpService.getInstance();
                    rs2 = bs.dbService.executeStaticQuery(query2.toString());
                    UtilidadesLog.debug("*** rs2: "+rs2);
                    
                    if(!rs2.esVacio()){
                        resultado.setColumnIdentifiers(rs2.getColumnIdentifiers());
                        for(int k=0;k<rs2.getRowCount();k++){
                            resultado.addRow(rs2.getRow(k));
                        }
                        
                        UtilidadesLog.info("*** resultado.getRowCount(): "+resultado.getRowCount());
                    }
                    
                    
                }
            }
            UtilidadesLog.info("*** resultado: "+resultado);
            return resultado;
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    
    }
    
    private RecordSet obtieneDireccionSinGEO(DTOOID oid) throws MareException{
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtieneDireccionSinGEO(DTOOID): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs; 
        BelcorpService bs;
        String codigoError;
        
        query.append(" SELECT dir.TIDC_OID_TIPO_DIRE, dir.TIVI_OID_TIPO_VIA, ");
        query.append(" NVL(dir.VAL_NOMB_VIA,vi.NOM_VIA) AS VIA, ");
        query.append(" dir.NUM_PPAL, dir.VAL_COD_POST, ");
        query.append(" dir.VAL_OBSE, I1.VAL_I18N DESC_TIPO_DIREC, I2.VAL_I18N DESC_TIPO_VIA, ind_dire_ppal, VAL.DES_GEOG ");
        query.append(" FROM MAE_CLIEN_DIREC dir, ZON_VIA vi, ZON_VALOR_ESTRU_GEOPO val, ");
        query.append(" V_GEN_I18N_SICC I1, V_GEN_I18N_SICC I2, ZON_TERRI terr ");
        query.append(" WHERE I1.ATTR_ENTI(+) = 'MAE_TIPO_DIREC'    ");
        query.append(" and I1.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
        query.append(" and I1.VAL_OID(+) = TIDC_OID_TIPO_DIRE    ");
        query.append(" and I2.ATTR_ENTI(+) = 'SEG_TIPO_VIA'    ");
        query.append(" and I2.IDIO_OID_IDIO(+) = " + oid.getOidIdioma() + " ");
        query.append(" and I2.VAL_OID(+) = dir.tivi_oid_tipo_via ");
        query.append(" and dir.CLIE_OID_CLIE = " + oid.getOid() + " ");
        query.append(" AND dir.ZVIA_OID_VIA = vi.OID_VIA(+)  ");
        query.append(" AND dir.TERR_OID_TERR = terr.OID_TERR ");
        query.append(" AND dir.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
        query.append(" AND terr.VEPO_OID_VALO_ESTR_GEOP = val.OID_VALO_ESTR_GEOP ");
        query.append(" AND vi.PAIS_OID_PAIS = "+oid.getOidPais());
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: "+rs);
            UtilidadesLog.info(" DAOMAEMaestroClientes.obtieneDireccionSinGEO(DTOOID): Salida");
            return rs;
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

     /**
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param oid
   * @author Gacevedo
   */
    public DTOCliente obtenerClienteBatch(DTOOID oid) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerClienteBatch(DTOOID): Entrada");
      
        Boolean bUsaGEOREFERENCIADOR = Boolean.FALSE;
        MONMantenimientoSEG mms;
        DTOCliente dtosalida = new DTOCliente();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = new RecordSet();
        StringBuffer query = new StringBuffer();
      
        try {
            DTOCrearClienteBasico dto = new DTOCrearClienteBasico();
            
            //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011 
            Vector params = new Vector();
            params.add(oid.getOid()); //oidCliente
            resultado = UtilidadesBD.executeProcedureCursor("FAC_PKG_PROCE.MAE_PR_OBTIE_DOCUM_CLIEN", params);
            
            /*query = new StringBuffer();
            query.append(" select OID_CLIE_IDEN, TDOC_OID_TIPO_DOCU, NUM_DOCU_IDEN, VAL_IDEN_PERS_EMPR, VAL_IDEN_DOCU_PRIN ");
            query.append(" from MAE_CLIEN_IDENT I  ");
            query.append(" where  I.CLIE_OID_CLIE = " + oid.getOid() + " ");
            //INC DBLG700000130 (Gacevedo)
            //Se devuelve el documento principal primero en el query
            //y se termina de corregir la incidencia en FAC.MonTratamientosContables
            query.append(" order by oid_clie_iden asc, tdoc_oid_tipo_docu asc, val_iden_docu_prin desc ");
            
            resultado = bs.dbService.executeStaticQuery(query.toString());*/

            DTOIdentificacion[] dtots1 = new DTOIdentificacion[resultado.getRowCount()];
            DTOIdentificacion dtos1;

            for (int i = 0; i < resultado.getRowCount(); i++) {
                dtos1 = new DTOIdentificacion();
                dtos1.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                dtos1.setTipoDocumento(new Long(((BigDecimal) resultado.getValueAt(i, 1)).longValue()));
                dtos1.setNumeroDocumento((String) resultado.getValueAt(i, 2));
                dtos1.setIndPersonaEmpresa((String) resultado.getValueAt(i, 3));
                dtos1.setEsPrincipal((((BigDecimal) resultado.getValueAt(i, 4)).toString()).equals("1") ? Boolean.TRUE : Boolean.FALSE);
                dtots1[i] = dtos1;
            }

            dto.setIdentificaciones(dtots1);

            query = new StringBuffer();
            query.append(" select COD_CLIE, COD_DIGI_CTRL, VAL_APE1, VAL_APE2, VAL_APEL_CASA, VAL_NOM1,  ");
            query.append(" VAL_NOM2, VAL_TRAT, COD_SEXO, FEC_INGR, FOPA_OID_FORM_PAGO  ");
            query.append(" from MAE_CLIEN    ");
            query.append(" where  OID_CLIE = " + oid.getOid() + " ");
            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (resultado.getRowCount() > 0) {
                dto.setCodigoCliente((String) resultado.getValueAt(0, 0));
                dto.setDigitoControl((String) resultado.getValueAt(0, 1));
                dto.setApellido1((String) resultado.getValueAt(0, 2));
                dto.setApellido2((String) resultado.getValueAt(0, 3));
                dto.setApellidoCasada((String) resultado.getValueAt(0, 4));
                dto.setNombre1((String) resultado.getValueAt(0, 5));
                dto.setNombre2((String) resultado.getValueAt(0, 6));
                dto.setTratamiento((String) resultado.getValueAt(0, 7));
                dto.setSexo((String) resultado.getValueAt(0, 8));
                dto.setFechaIngreso((Date) resultado.getValueAt(0, 9));

                BigDecimal formPago = (BigDecimal) resultado.getValueAt(0, 10);

                if (formPago != null) {
                    dto.setFormaPago(new Long(formPago.longValue()));
                }
            }
            MONMantenimientoSEGHome mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
            mms = mmsHome.create();
            bUsaGEOREFERENCIADOR = mms.usaGeoreferenciador(oid.getOidPais());
            dto.setUsaGeoreferenciador(bUsaGEOREFERENCIADOR);
    
            dtosalida.setCriterioBusqueda1(null);
            dtosalida.setCriterioBusqueda2(null);
            dtosalida.setOid(oid.getOid());

            resultado = new RecordSet();
            UtilidadesLog.debug(" Direcciones ");

            //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011 
            params = new Vector();
            params.add(oid.getOid()); //oidCliente
            resultado = UtilidadesBD.executeProcedureCursor("FAC_PKG_PROCE.MAE_PR_OBTIE_DIREC_CLIEN", params);
            
            /*query = new StringBuffer();
            query.append(" SELECT dir.OID_CLIE_DIRE, dir.TIDC_OID_TIPO_DIRE, dir.TIVI_OID_TIPO_VIA, ");
            query.append(" val.OID_VALO_ESTR_GEOP, dir.ZVIA_OID_VIA, dir.NUM_PPAL, dir.VAL_COD_POST, ");
            query.append(" dir.VAL_OBSE, dir.IND_DIRE_PPAL, dir.VAL_NOMB_VIA, val.DES_GEOG ");
            query.append(" FROM MAE_CLIEN_DIREC dir, ZON_VALOR_ESTRU_GEOPO val, ZON_TERRI terr ");
            query.append(" WHERE dir.CLIE_OID_CLIE = " + oid.getOid() + " AND ");
            query.append(" dir.TERR_OID_TERR = terr.OID_TERR AND ");
            query.append(" dir.IND_ELIM = 0 AND "); //agregado por Sapaza, incidencia V_MAE_08
            query.append(" terr.VEPO_OID_VALO_ESTR_GEOP = val.OID_VALO_ESTR_GEOP ");
            resultado = bs.dbService.executeStaticQuery(query.toString());*/
            
            UtilidadesLog.info("resulado Dir: " + resultado.toString());

            if (resultado.getRowCount() == 0) {
                dto.setDirecciones(null);
            } else {
                int cantFilas = resultado.getRowCount();
                DTODireccion[] arrayDirecciones = new DTODireccion[cantFilas];
                DTODireccion dir = null;

                for (int i = 0; i < cantFilas; i++) {
                    dir = new DTODireccion();

                    if (resultado.getValueAt(i, 0) == null) {
                        dir.setOid(null);
                    } else {
                        dir.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                    }

                    if (resultado.getValueAt(i, 1) == null) {
                        dir.setTipoDireccion(null);
                    } else {
                        dir.setTipoDireccion(new Long(((BigDecimal) resultado.getValueAt(i, 1)).longValue()));
                    }

                    if (resultado.getValueAt(i, 2) == null) {
                        dir.setTipoVia(null);
                    } else {
                        dir.setTipoVia(new Long(((BigDecimal) resultado.getValueAt(i, 2)).longValue()));
                    }

                    if (resultado.getValueAt(i, 3) == null) {
                        dir.setUnidadGeografica(null);
                    } else {
                        dir.setUnidadGeografica(new Long(((BigDecimal) resultado.getValueAt(i, 3)).longValue()));
                    }

                    if (resultado.getValueAt(i, 4) == null) {
                        dir.setVia(null);
                    } else {
                        dir.setVia(new Long(((BigDecimal) resultado.getValueAt(i, 4)).longValue()));
                    }

                    if (resultado.getValueAt(i, 5) == null) {
                        dir.setNumeroPrincipal(null);
                    } else {
                        /*
                         * V-PED001 - dmorello, 06/10/2006
                         * Cambio el tipo de numeroPrincipal de Integer a String
                         */
                        //dir.setNumeroPrincipal(new Integer(resultado.getValueAt(i, 5).toString()));
                        dir.setNumeroPrincipal(resultado.getValueAt(i, 5).toString());
                    }

                    if (resultado.getValueAt(i, 6) == null) {
                        dir.setCodigoPostal(null);
                    } else {
                        dir.setCodigoPostal(resultado.getValueAt(i, 6).toString());
                    }

                    if (resultado.getValueAt(i, 7) == null) {
                        dir.setObservaciones(null);
                    } else {
                        dir.setObservaciones(resultado.getValueAt(i, 7).toString());
                    }

                    if (resultado.getValueAt(i, 8) == null) {
                        dir.setEsDireccionPrincipal(null);
                    } else {
                        if (((BigDecimal) resultado.getValueAt(i, 8)).longValue() == 1) {
                            dir.setEsDireccionPrincipal(new Boolean(true));
                        } else {
                            dir.setEsDireccionPrincipal(new Boolean(false));
                        }
                    }

                    if (resultado.getValueAt(i, 9) == null) {
                        dir.setNombreVia(null);
                    } else {
                        dir.setNombreVia(resultado.getValueAt(i, 9).toString());
                    }

                    if (resultado.getValueAt(i, 10) == null) {
                        dir.setNombreUnidadGeografica(null);
                    } else {
                        dir.setNombreUnidadGeografica(resultado.getValueAt(i, 10).toString());
                    }

                    //UtilidadesLog.debug("bucle " + i + ": " + dir.toString());
                    arrayDirecciones[i] = dir;
                }

                dto.setDirecciones(arrayDirecciones);
            }
            //DTOCliente
            //base: metemos el DTOCrearClienteBasico creado anteriormente 
            dtosalida.setBase(dto);

            //DTOComunicacion[]			
            query = new StringBuffer();
            query.append(" SELECT OID_CLIE_COMU, TICM_OID_TIPO_COMU, VAL_DIA_COMU, VAL_TEXT_COMU,  ");
            query.append(" to_char(FEC_HORA_DESD, 'HH24:MI'), to_char(FEC_HORA_HAST, 'HH24:MI'), VAL_INTE_COMU, IND_COMU_PPAL  ");
            query.append(" FROM MAE_CLIEN_COMUN  ");
            query.append(" WHERE CLIE_OID_CLIE = " + oid.getOid() + " ");
            resultado = bs.dbService.executeStaticQuery(query.toString());

            DTOComunicacion[] dtots7 = new DTOComunicacion[resultado.getRowCount()];
            DTOComunicacion dtos7;
            if (resultado!=null && !resultado.esVacio()){
                for (int i = 0; i < resultado.getRowCount(); i++) {
                    dtos7 = new DTOComunicacion();
                    dtos7.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                    dtos7.setTipoComunicacion(new Long(((BigDecimal) resultado.getValueAt(i, 1)).longValue()));
    
                    String diaComu = (String) resultado.getValueAt(i, 2);
    
                    if ((diaComu != null) && !(diaComu.equals(""))) {
                        dtos7.setDiaComunicacion(new Character(diaComu.toCharArray()[0]));
                    }
    
                    dtos7.setTextoComunicacion((String) resultado.getValueAt(i, 3));
    
                    /*****************************************************************/
                    String sHoraDesde = (String) resultado.getValueAt(i, 4);
                    String sHoraHasta = (String) resultado.getValueAt(i, 5);
    
                    UtilidadesLog.debug("HoraDesde: " + sHoraDesde);
                    UtilidadesLog.debug("HoraHasta: " + sHoraHasta);
    
                    SimpleDateFormat simpleDateHora = new SimpleDateFormat("HH:mm");
    
                    if ((sHoraDesde != null) && !sHoraDesde.equals("")) {
                        java.util.Date dateHoraDesde = simpleDateHora.parse(sHoraDesde);
                        UtilidadesLog.debug("dateHoraDesde: " + dateHoraDesde.toString());
                        UtilidadesLog.debug("dateHoraDesde Long: " + dateHoraDesde.getTime());
    
                        Long longHoraDesde = new Long(dateHoraDesde.getTime());
                        dtos7.setHoraDesde(longHoraDesde);
                    }
    
                    if ((sHoraHasta != null) && !sHoraHasta.equals("")) {
                        java.util.Date dateHoraHasta = simpleDateHora.parse(sHoraHasta);
                        UtilidadesLog.debug("dateHoraHasta: " + dateHoraHasta.toString());
                        UtilidadesLog.debug("dateHoraHasta Long: " + dateHoraHasta.getTime());
    
                        Long longHoraHasta = new Long(dateHoraHasta.getTime());
                        dtos7.setHoraHasta(longHoraHasta);
                    }
    
                    /*                java.util.Date dateHoraDesde = simpleDate.parse(sHoraDesde);
                                    UtilidadesLog.info("dateHoraDesde: " + dateHoraDesde.toString() );
                                    UtilidadesLog.info("dateHoraDesde Long: " + dateHoraDesde.getTime() );*/
                    /*                dtos7.setHoraDesde(new Long(((java.sql.Date)resultado.getValueAt(i, 4)).getTime()));
                                    dtos7.setHoraDesde(new Long(((java.sql.Date)resultado.getValueAt(i, 5)).getTime()));*/
                    /*dtos7.setHoraHasta(new Long(((BigDecimal)resultado.getValueAt(i, 5)).longValue()));
                    dtos7.setHoraHasta(new Long(((BigDecimal)resultado.getValueAt(i, 5)).longValue()));*/
    
                    /*****************************************************************/
                    BigDecimal interva = (BigDecimal) resultado.getValueAt(i, 6);
                    Boolean intervaloComuni = null;
    
                    if (interva != null) {
                        if (interva.toString().equals("1")) {
                            intervaloComuni = Boolean.TRUE;
                        } else {
                            intervaloComuni = Boolean.FALSE;
                        }
                    }
    
                    dtos7.setIntervaloComunicacion(intervaloComuni);
    
                    BigDecimal pric = (BigDecimal) resultado.getValueAt(i, 7);
                    Boolean principal = null;
    
                    if (pric != null) {
                        if (pric.toString().equals("1")) {
                            principal = Boolean.TRUE;
                        } else {
                            principal = Boolean.FALSE;
                        }
                    }
    
                    dtos7.setPrincipal(principal);
                    dtots7[i] = dtos7;
                }
            }
            dtosalida.setComunicaciones(dtots7);
            
            //dtosalida.setBase(dto);
        } catch (CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("dtoSalida ObtenerCliente: " + dtosalida);
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerClienteBatch(DTOOID): Salida");

        return dtosalida;
      
    
    }
    
    /**
     * Modificado: SICC-GCC-MAE-005 - SICC-GCC-MAE-006 - Cleal
     */
    public DTOCliente obtenerCliente(DTOOID oid) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerCliente(DTOOID): Entrada");

        Boolean bUsaGEOREFERENCIADOR = Boolean.FALSE;
        MONMantenimientoSEG mms;
        DTOCliente dtosalida = new DTOCliente();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = new RecordSet();
        RecordSet rTipoSubtipo = null;
        RecordSet rIdentificacion = null;
        RecordSet rClienteMarca = null;
        RecordSet rClasificacion = null;
        RecordSet rVinculo = null;
        RecordSet rPreferencias = null;
        RecordSet rObservacion = null;
        RecordSet rComunicaciones = null;
        RecordSet rTarjetas = null;
        RecordSet rProblemaSolucion = null;
        RecordSet rPsicografia = null;
        StringBuffer query = new StringBuffer();
        

        try {

            DTOCrearClienteBasico dto = new DTOCrearClienteBasico();
            
            query.append(" SELECT   oid_clie_tipo_subt, vtipo.val_i18n, vsubtipo.val_i18n, ");
            query.append(" ticl_oid_tipo_clie, sbti_oid_subt_clie, ind_ppal ");
            query.append(" FROM mae_clien_tipo_subti t, ");
            query.append(" v_gen_i18n_sicc vtipo, ");
            query.append(" v_gen_i18n_sicc vsubtipo ");
            query.append(" WHERE t.clie_oid_clie = " + oid.getOid());
            query.append(" AND vtipo.attr_enti = 'MAE_TIPO_CLIEN' ");
            query.append(" AND vtipo.idio_oid_idio = " + oid.getOidIdioma());
            query.append(" AND vtipo.attr_num_atri = 1 ");
            query.append(" AND vtipo.val_oid = t.ticl_oid_tipo_clie ");
            query.append(" AND vsubtipo.attr_enti = 'MAE_SUBTI_CLIEN' ");
            query.append(" AND vsubtipo.idio_oid_idio = " + oid.getOidIdioma());
            query.append(" AND vsubtipo.attr_num_atri = 1 ");
            query.append(" AND vsubtipo.val_oid = t.sbti_oid_subt_clie ");
            query.append(" ORDER BY t.ind_ppal DESC ");
            rTipoSubtipo = bs.dbService.executeStaticQuery(query.toString());

            dto.setRTipoSubtipoCliente(rTipoSubtipo);

            //DTOIdentificacion[]
            query = new StringBuffer();

            query.append(" SELECT oid_clie_iden, tdoc_oid_tipo_docu, ");
            query.append(" num_docu_iden, num_docu_iden, ");
            query.append(" decode (val_iden_docu_prin, 1, 'S', 'N'), val_iden_pers_empr ");
            query.append(" FROM mae_clien_ident i ");
            query.append(" WHERE i.clie_oid_clie = " + oid.getOid());           

            rIdentificacion = bs.dbService.executeStaticQuery(query.toString());

            dto.setRIdentificacionCliente(rIdentificacion);

            query = new StringBuffer();
            query.append(" select COD_CLIE, COD_DIGI_CTRL, VAL_APE1, VAL_APE2, VAL_APEL_CASA, VAL_NOM1,  ");
            query.append(" VAL_NOM2, VAL_TRAT, COD_SEXO, FEC_INGR, FOPA_OID_FORM_PAGO  ");
            query.append(" from MAE_CLIEN    ");
            query.append(" where  OID_CLIE = " + oid.getOid() + " ");
            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (resultado.getRowCount() > 0) {
                dto.setCodigoCliente((String) resultado.getValueAt(0, 0));
                dto.setDigitoControl((String) resultado.getValueAt(0, 1));
                dto.setApellido1((String) resultado.getValueAt(0, 2));
                dto.setApellido2((String) resultado.getValueAt(0, 3));
                dto.setApellidoCasada((String) resultado.getValueAt(0, 4));
                dto.setNombre1((String) resultado.getValueAt(0, 5));
                dto.setNombre2((String) resultado.getValueAt(0, 6));
                dto.setTratamiento((String) resultado.getValueAt(0, 7));
                dto.setSexo((String) resultado.getValueAt(0, 8));
                dto.setFechaIngreso((Date) resultado.getValueAt(0, 9));

                BigDecimal formPago = (BigDecimal) resultado.getValueAt(0, 10);

                if (formPago != null) {
                    dto.setFormaPago(new Long(formPago.longValue()));
                }
            }

            //DTOClienteMarca[]
            query = new StringBuffer();
            query.append(" select OID_CLIE_MARC, MARC_OID_MARC, IND_PPAL ");
            query.append(" from MAE_CLIEN_MARCA    ");
            query.append(" where CLIE_OID_CLIE = " + oid.getOid() + " ");
            /* rClienteMarca = bs.dbService.executeStaticQuery(query.toString()); */
            resultado = bs.dbService.executeStaticQuery(query.toString()); 

            DTOClienteMarca[] dtots2 = new DTOClienteMarca[resultado.getRowCount()];
            DTOClienteMarca dtos2;

            for (int i = 0; i < resultado.getRowCount(); i++) {
                dtos2 = new DTOClienteMarca();
                dtos2.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                dtos2.setMarca(new Long(((BigDecimal) resultado.getValueAt(i, 1)).longValue()));
                dtos2.setPrincipal((((BigDecimal) resultado.getValueAt(i, 2)).toString()).equals("1") ? Boolean.TRUE : Boolean.FALSE);
                dtots2[i] = dtos2;
            }

            dto.setMarcas(dtots2);
            /* dto.setRClienteMarca(rClienteMarca); */
            

            //DTOClasificacionCliente[]
            query = new StringBuffer();

            query.append(" SELECT   c.oid_clie_clas, marca.des_marc, v3.val_i18n, v1.val_i18n, ");
            query.append(" v2.val_i18n, v4.val_i18n, v5.val_i18n, p.marc_oid_marc, ");
            query.append(" p.cana_oid_cana, ticl_oid_tipo_clie, t.sbti_oid_subt_clie, ");
            query.append(" c.tccl_oid_tipo_clasi, c.clas_oid_clas, c.ind_ppal ");
            query.append(" FROM mae_clien_clasi c, ");
            query.append(" cra_perio p, ");
            query.append(" mae_clien_tipo_subti t, ");
            query.append(" v_gen_i18n_sicc v1, ");
            query.append(" v_gen_i18n_sicc v2, ");
            query.append(" seg_marca marca, ");
            query.append(" v_gen_i18n_sicc v3, ");
            query.append(" v_gen_i18n_sicc v4, ");
            query.append(" v_gen_i18n_sicc v5 ");
            query.append(" WHERE c.perd_oid_peri = p.oid_peri ");
            query.append(" AND t.oid_clie_tipo_subt = c.ctsu_oid_clie_tipo_subt ");
            query.append(" AND t.clie_oid_clie = " + oid.getOid().toString());
            query.append(" AND t.ticl_oid_tipo_clie = v1.val_oid ");
            query.append(" AND p.marc_oid_marc = marca.oid_marc ");
            query.append(" AND p.cana_oid_cana = v3.val_oid ");
            query.append(" AND v3.attr_num_atri = 1 ");
            query.append(" AND v3.idio_oid_idio = " + oid.getOidIdioma().toString());
            query.append(" AND v3.attr_enti = 'SEG_CANAL' ");
            query.append(" AND t.ticl_oid_tipo_clie = v1.val_oid ");
            query.append(" AND v1.attr_num_atri = 1 ");
            query.append(" AND v1.idio_oid_idio = " + oid.getOidIdioma().toString());
            query.append(" AND v1.attr_enti = 'MAE_TIPO_CLIEN' ");
            query.append(" AND t.sbti_oid_subt_clie = v2.val_oid ");
            query.append(" AND v2.attr_num_atri = 1 ");
            query.append(" AND v2.idio_oid_idio = " + oid.getOidIdioma().toString());
            query.append(" AND v2.attr_enti = 'MAE_SUBTI_CLIEN' ");
            query.append(" AND c.tccl_oid_tipo_clasi = v4.val_oid ");
            query.append(" AND v4.attr_num_atri = 1 ");
            query.append(" AND v4.idio_oid_idio = " + oid.getOidIdioma().toString());
            query.append(" AND v4.attr_enti = 'MAE_TIPO_CLASI_CLIEN' ");
            query.append(" AND c.clas_oid_clas = v5.val_oid ");
            query.append(" AND v5.attr_num_atri = 1 ");
            query.append(" AND v5.idio_oid_idio = " + oid.getOidIdioma().toString());
            query.append(" AND v5.attr_enti = 'MAE_CLASI' ");
            query.append(" ORDER BY c.ind_ppal DESC ");

            /* rClasificacion = bs.dbService.executeStaticQuery(query.toString());*/
            resultado = bs.dbService.executeStaticQuery(query.toString());
            int cantClasi = resultado.getRowCount();
            UtilidadesLog.debug("cantidad de Clasificaciones_" + cantClasi);
            DTOClasificacionCliente[] dtots3 = new DTOClasificacionCliente[0];
            DTOClasificacionCliente dtos3;
            
            if (!resultado.esVacio()) {
              dtots3 = new DTOClasificacionCliente[cantClasi];
              for (int i = 0; i < cantClasi; i++) {
                dtos3 = new DTOClasificacionCliente();
                dtos3.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                dtos3.setMarcaDesc((String) resultado.getValueAt(i, 1));
                dtos3.setCanalDesc((String) resultado.getValueAt(i, 2));
                dtos3.setTipoDesc((String) resultado.getValueAt(i, 3));
                dtos3.setSubtipoDesc((String) resultado.getValueAt(i, 4));
                dtos3.setTipoClasificacionDesc((String) resultado.getValueAt(i, 5));
                dtos3.setClasificacionDesc((String) resultado.getValueAt(i, 6));

                dtos3.setMarca(new Long(((BigDecimal) resultado.getValueAt(i, 7)).longValue()));
                dtos3.setCanal(new Long(((BigDecimal) resultado.getValueAt(i, 8)).longValue()));
                dtos3.setTipo(new Long(((BigDecimal) resultado.getValueAt(i, 9)).longValue()));
                dtos3.setSubtipo(new Long(((BigDecimal) resultado.getValueAt(i, 10)).longValue()));
                dtos3.setTipoClasificacion(new Long(((BigDecimal) resultado.getValueAt(i, 11)).longValue()));
                dtos3.setClasificacion(new Long(((BigDecimal) resultado.getValueAt(i, 12)).longValue()));
                dtos3.setPrincipal((((BigDecimal) resultado.getValueAt(i, 13)).toString()).equals("1") ? Boolean.TRUE : Boolean.FALSE);
                dtots3[i] = dtos3;
              }
            } else {
                UtilidadesLog.debug("sin clasificaciones");
                // BELC300023061 - 04/07/2006
                // Si no se obtuvo ninguna clasificacion para el cliente en la consulta anterior, 
                // insertar una fila en el atributo clasificaciones, con el indicador principal activo, 
                // sólo con la marca y el canal
                query = new StringBuffer();
                
                query.append(" SELECT null OID_CLIE_CLAS, mar.DES_MARC, iCa.VAL_I18N, ");
                query.append("        null VAL_I18N, null VAL_I18N, null VAL_I18N, null VAL_I18N,	");
                query.append("        per.MARC_OID_MARC, per.CANA_OID_CANA, ");
                query.append("        null TICL_OID_TIPO_CLIE, null SBTI_OID_SUBT_CLIE, null TCCL_OID_TIPO_CLASI, null CLAS_OID_CLAS, null IND_PPAL ");
                query.append("   FROM MAE_CLIEN_UNIDA_ADMIN uA, ");
                query.append("        CRA_PERIO per, 	");
                query.append("        SEG_MARCA mar,  ");
                query.append("        V_GEN_I18N_SICC iCa  ");
                query.append("  WHERE uA.CLIE_OID_CLIE = " + oid.getOid().toString());
                query.append("        AND uA.IND_ACTI = 1 ");
                query.append("        AND uA.PERD_OID_PERI_INI = per.OID_PERI  ");
                query.append("        AND per.MARC_OID_MARC = mar.OID_MARC  ");
                query.append("        AND per.CANA_OID_CANA = iCa.VAL_OID  ");
                query.append("        AND iCa.ATTR_NUM_ATRI = 1 ");
                query.append("        AND iCa.ATTR_ENTI = 'SEG_CANAL'   ");
                query.append("        AND iCa.IDIO_OID_IDIO = " + oid.getOidIdioma().toString());
                query.append("  ORDER BY uA.OID_CLIE_UNID_ADMI ASC ");

                resultado = bs.dbService.executeStaticQuery(query.toString());
                
                if (!resultado.esVacio()) {
                  dtos3 = new DTOClasificacionCliente();
                  dtos3.setMarcaDesc((String) resultado.getValueAt(0, 1));
                  dtos3.setCanalDesc((String) resultado.getValueAt(0, 2));
                  dtos3.setMarca(new Long(((BigDecimal) resultado.getValueAt(0, 7)).longValue()));
                  dtos3.setCanal(new Long(((BigDecimal) resultado.getValueAt(0, 8)).longValue()));
                  dtos3.setPrincipal(Boolean.TRUE);
                  
                  dtots3 = new DTOClasificacionCliente[1];
                  dtots3[0] = dtos3; 
                }
            }
            
            dto.setClasificaciones(dtots3);
            
            /*dto.setRClasificacionCliente(rClasificacion);*/

            MONMantenimientoSEGHome mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
            mms = mmsHome.create();
            bUsaGEOREFERENCIADOR = mms.usaGeoreferenciador(oid.getOidPais());
            dto.setUsaGeoreferenciador(bUsaGEOREFERENCIADOR);

            dtosalida.setBase(dto);

            //criterioBusqueda 1 y 2 queda a null
            dtosalida.setCriterioBusqueda1(null);
            dtosalida.setCriterioBusqueda2(null);

            //oid: dto.oid 
            dtosalida.setOid(oid.getOid());

            //-fechaNacimiento, codigoEmpleado, nacionalidad, estadoCivil, 
            //ocupacion, profesion, centroTrabajo, cargo, nivelEstudios, centroEstudios, 
            //numeroHijos, personasDependientes, NSEP, cicloVida, deseaCorrespondencia, 
            //cicloVida, deseaCorrespondencia, importeIngresos 
            query = new StringBuffer();
            query.append(" select FEC_NACI, COD_EMPL, IND_ACTI,SNON_OID_NACI, ESCV_OID_ESTA_CIVI, VAL_OCUP, VAL_PROF,  ");
            query.append(" VAL_CENT_TRAB, VAL_CARG_DESE, NIED_OID_NIVE_ESTU, VAL_CENT_ESTU, ");
            query.append(" NUM_HIJO, NUM_PERS_DEPE, NSEP_OID_NSEP, TCLV_OID_CICL_VIDA, IND_CORR, IMP_INGR_FAMI ");
            query.append(" from MAE_CLIEN_DATOS_ADICI   ");
            query.append(" where  CLIE_OID_CLIE = " + oid.getOid() + " ");
            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (resultado.getRowCount() > 0) {
                dtosalida.setFechaNacimiento((Date) resultado.getValueAt(0, 0));
                dtosalida.setCodigoEmpleado((String) resultado.getValueAt(0, 1));
                //SICC-DMCO-MAE-GCC-006 - Cleal
                dtosalida.setIndicadorActivo((resultado.getValueAt(0, 2) != null) ? new Long(((BigDecimal) resultado.getValueAt(0, 2)).longValue()) : null);
                
                
                dtosalida.setNacionalidad((resultado.getValueAt(0, 3) != null) ? new Long(((BigDecimal) resultado.getValueAt(0, 3)).longValue()) : null);
                dtosalida.setEstadoCivil((resultado.getValueAt(0, 4) != null) ? new Long(((BigDecimal) resultado.getValueAt(0, 4)).longValue()) : null);
                
                dtosalida.setOcupacion((String) resultado.getValueAt(0, 5));

                dtosalida.setProfesion((String) resultado.getValueAt(0, 6));
                dtosalida.setCentroTrabajo((String) resultado.getValueAt(0, 7));
                dtosalida.setCargo((String) resultado.getValueAt(0, 8));
                dtosalida.setNivelEstudios((resultado.getValueAt(0, 9) != null) ? new Long(((BigDecimal) resultado.getValueAt(0, 9)).longValue()) : null);
                dtosalida.setCentroEstudios((String) resultado.getValueAt(0, 10));
                dtosalida.setNumeroHijos((resultado.getValueAt(0, 11) != null) ? new Byte(((BigDecimal) resultado.getValueAt(0, 11)).byteValue()) : null);
                dtosalida.setPersonasDependientes((resultado.getValueAt(0, 12) != null) ? new Byte(((BigDecimal) resultado.getValueAt(0, 12)).byteValue()) : null);
                dtosalida.setNSEP((resultado.getValueAt(0, 13) != null) ? new Long(((BigDecimal) resultado.getValueAt(0, 13)).longValue()) : null);
                dtosalida.setCicloVida((resultado.getValueAt(0, 14) != null) ? new Long(((BigDecimal) resultado.getValueAt(0, 14)).longValue()) : null);

                BigDecimal corres = (BigDecimal) resultado.getValueAt(0, 15);
                Boolean correspondencia = null;

                if (corres != null) {
                    if (corres.toString().equals("1")) {
                        correspondencia = Boolean.TRUE;
                    } else {
                        correspondencia = Boolean.FALSE;
                    }
                }

                dtosalida.setDeseaCorrespondencia(correspondencia);
                dtosalida.setImporteIngresos((resultado.getValueAt(0, 16) != null) ? new Double(((BigDecimal) resultado.getValueAt(0, 16)).doubleValue()) : null);
                
            }

            //DTOVinculo[]
            query = new StringBuffer();


            /* 
             * Cambios a restriccion por xxx_vnte y vndo hechas por ssantana, 
             * 07/04/2006, porque no tenian mucho sentido como estaban antes 
             */ 
            query.append(" SELECT   oid_clie_vinc, c.cod_clie,  ");
            query.append(" tivc_oid_tipo_vinc, fec_desd, fec_hast, ");
            query.append(" ind_vinc_ppal ");
            query.append(" FROM mae_clien_vincu, mae_tipo_vincu tv, seg_pais p, mae_clien c ");
        /*inicio modificado ciglesias 17/11/2006 incidencia 24377*/
            query.append(" WHERE clie_oid_clie_vndo = " + oid.getOid());
            query.append(" AND mae_clien_vincu.tivc_oid_tipo_vinc = tv.oid_tipo_vinc ");
            query.append(" AND mae_clien_vincu.clie_oid_clie_vnte = c.oid_clie ");
        /*fin modificado ciglesias 17/11/2006 incidencia 24377*/
            query.append(" AND tv.pais_oid_pais = p.oid_pais ");
            query.append(" ORDER BY ind_vinc_ppal DESC ");

            rVinculo = bs.dbService.executeStaticQuery(query.toString());


            
            dtosalida.setRVinculo(rVinculo);

            //DTOPreferencia[]			
            query = new StringBuffer();
            query.append(" select OID_CLIE_PREF, TIPF_OID_TIPO_PREF, DES_CLIE_PREF ");
            query.append(" from MAE_CLIEN_PREFE ");
            query.append(" where CLIE_OID_CLIE = " + oid.getOid() + " ");
            rPreferencias = bs.dbService.executeStaticQuery(query.toString());

            dtosalida.setRPreferencia(rPreferencias);

            //DTOObservacion[]			
            query = new StringBuffer();
            query.append(" select OID_OBSE, MARC_OID_MARC, NUM_OBSE, VAL_TEXT ");
            query.append(" from MAE_CLIEN_OBSER ");
            query.append(" where  CLIE_OID_CLIE = " + oid.getOid() + " ");
            rObservacion = bs.dbService.executeStaticQuery(query.toString());

            dtosalida.setRObservaciones(rObservacion);

            //paisContactado, clienteContactado, oidClienteContactado, tipoClienteContactado, 
            //tipoContacto, fechaPrimerContacto, fechaSiguienteContacto, fechaPrimerPedidoContacto
            query = new StringBuffer();

            // Nueva query by ssantana
            query.append(" SELECT c.pais_oid_pais, c.cod_clie, t.clie_oid_clie, t.ticl_oid_tipo_clie, ");
            query.append(" p.cod_tipo_cont, p.fec_cont, p.fec_sigu_cont, canal.oid_cana, ");
            query.append(" marca.oid_marc, perio.oid_peri ");
            query.append(" FROM mae_clien c, ");
            query.append(" mae_clien_tipo_subti t, ");
            query.append(" mae_clien_prime_conta p, ");
            query.append(" seg_canal canal, ");
            query.append(" seg_marca marca, ");
            query.append(" cra_perio perio ");
            query.append(" WHERE p.ctsu_clie_cont = t.oid_clie_tipo_subt ");
            query.append(" AND t.clie_oid_clie = c.oid_clie ");
            query.append(" AND p.clie_oid_clie = " + oid.getOid().toString());
            
            // modif. - splatas - 25/10/2006 - DBLG700000168
            // query.append(" AND t.ind_ppal = 1 ");
            
            query.append(" AND p.cana_oid_cana = canal.oid_cana(+) ");
            query.append(" AND p.marc_oid_marc = marca.oid_marc(+) ");
            query.append(" AND p.perd_oid_peri = perio.oid_peri(+) ");

            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (resultado.getRowCount() > 0) {
                BigDecimal buffer = null;
                dtosalida.setPaisContactado(new Long(((BigDecimal) resultado.getValueAt(0, 0)).longValue()));
                dtosalida.setClienteContactado((String) resultado.getValueAt(0, 1));
                dtosalida.setOidClienteContactado(new Long(((BigDecimal) resultado.getValueAt(0, 2)).longValue()));
                dtosalida.setTipoClienteContactado(new Long(((BigDecimal) resultado.getValueAt(0, 3)).longValue()));
                dtosalida.setTipoContacto((String) (resultado.getValueAt(0, 4)));
                dtosalida.setFechaPrimerContacto((Date) resultado.getValueAt(0, 5));
                dtosalida.setFechaSiguienteContacto((Date) resultado.getValueAt(0, 6));

                buffer = (BigDecimal) resultado.getValueAt(0, 7); // Canal Contacto

                if (buffer != null) {
                    dtosalida.setCanalContacto(Long.valueOf(buffer.toString()));
                } else {
                    dtosalida.setCanalContacto(null);
                }

                buffer = (BigDecimal) resultado.getValueAt(0, 8); // Marca Contacto

                if (buffer != null) {
                    dtosalida.setMarcaContacto(new Long(buffer.longValue()));
                } else {
                    dtosalida.setMarcaContacto(null);
                }

                buffer = (BigDecimal) resultado.getValueAt(0, 9); // Periodo Contacto

                if (buffer != null) {
                    dtosalida.setPeriodoContacto(new Long(buffer.longValue()));
                } else {
                    dtosalida.setPais(null);
                }
            }

            //tipoClienteContacto
            query = new StringBuffer();
            query.append(" SELECT TICL_OID_TIPO_CLIE  ");
            query.append(" FROM MAE_CLIEN_TIPO_SUBTI  ");
            query.append(" WHERE CLIE_OID_CLIE = " + oid.getOid() + " ");
            query.append(" AND IND_PPAL = 1  ");
            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (resultado.getRowCount() > 0) {
                dtosalida.setTipoClienteContacto(new Long(((BigDecimal) resultado.getValueAt(0, 0)).longValue()));
            }

            // DTODirecciones
            resultado = new RecordSet();
            UtilidadesLog.debug(" Direcciones ");
            /*
            query = new StringBuffer();
            query.append(" SELECT dir.OID_CLIE_DIRE, dir.TIDC_OID_TIPO_DIRE, dir.TIVI_OID_TIPO_VIA, ");
            query.append(" val.OID_VALO_ESTR_GEOP, dir.ZVIA_OID_VIA, dir.NUM_PPAL, dir.VAL_COD_POST, ");
            query.append(" dir.VAL_OBSE, dir.IND_DIRE_PPAL, dir.VAL_NOMB_VIA, val.DES_GEOG ");
            query.append(" FROM MAE_CLIEN_DIREC dir, ZON_VALOR_ESTRU_GEOPO val, ZON_TERRI terr ");
            query.append(" WHERE dir.CLIE_OID_CLIE = " + oid.getOid() + " AND ");
            query.append(" dir.TERR_OID_TERR = terr.OID_TERR AND ");
            query.append(" terr.VEPO_OID_VALO_ESTR_GEOP = val.OID_VALO_ESTR_GEOP ");
            resultado = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info("resulado Dir: " + resultado.toString());
            */
            if(Boolean.FALSE.equals(bUsaGEOREFERENCIADOR)){
                UtilidadesLog.debug("*** No usa GEO");
                resultado = obtieneDireccionSinGEOModificar(oid);
            } else{
                UtilidadesLog.debug("*** Usa GEO");
                resultado = obtieneDireccionConGEOModificar(oid);
            }
            if (resultado.getRowCount() == 0) {
                dto.setDirecciones(null);
            } else {
                int cantFilas = resultado.getRowCount();
                DTODireccion[] arrayDirecciones = new DTODireccion[cantFilas];
                DTODireccion dir = null;

                for (int i = 0; i < cantFilas; i++) {
                    dir = new DTODireccion();

                    if (resultado.getValueAt(i, 0) == null) {
                        dir.setOid(null);
                    } else {
                        dir.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                    }

                    if (resultado.getValueAt(i, 1) == null) {
                        dir.setTipoDireccion(null);
                    } else {
                        dir.setTipoDireccion(new Long(((BigDecimal) resultado.getValueAt(i, 1)).longValue()));
                    }

                    if (resultado.getValueAt(i, 2) == null) {
                        dir.setTipoVia(null);
                    } else {
                        dir.setTipoVia(new Long(((BigDecimal) resultado.getValueAt(i, 2)).longValue()));
                    }

                    if (resultado.getValueAt(i, 3) == null) {
                        dir.setUnidadGeografica(null);
                    } else {
                        dir.setUnidadGeografica(new Long(((BigDecimal) resultado.getValueAt(i, 3)).longValue()));
                    }

                    if (resultado.getValueAt(i, 4) == null) {
                        dir.setVia(null);
                    } else {
                        dir.setVia(new Long(((BigDecimal) resultado.getValueAt(i, 4)).longValue()));
                    }

                    if (resultado.getValueAt(i, 5) == null) {
                        dir.setNumeroPrincipal(null);
                    } else {
                        /*
                         * V-PED001 - dmorello, 06/10/2006
                         * Cambio el tipo de numeroPrincipal de Integer a String
                         */
                        //dir.setNumeroPrincipal(new Integer(resultado.getValueAt(i, 5).toString()));
                        dir.setNumeroPrincipal(resultado.getValueAt(i, 5).toString());
                    }

                    if (resultado.getValueAt(i, 6) == null) {
                        dir.setCodigoPostal(null);
                    } else {
                        dir.setCodigoPostal(resultado.getValueAt(i, 6).toString());
                    }

                    if (resultado.getValueAt(i, 7) == null) {
                        dir.setObservaciones(null);
                    } else {
                        dir.setObservaciones(resultado.getValueAt(i, 7).toString());
                    }

                    if (resultado.getValueAt(i, 8) == null) {
                        dir.setEsDireccionPrincipal(null);
                    } else {
                        if (((BigDecimal) resultado.getValueAt(i, 8)).longValue() == 1) {
                            dir.setEsDireccionPrincipal(new Boolean(true));
                        } else {
                            dir.setEsDireccionPrincipal(new Boolean(false));
                        }
                    }

                    if (resultado.getValueAt(i, 9) == null) {
                        dir.setNombreVia(null);
                    } else {
                        dir.setNombreVia(resultado.getValueAt(i, 9).toString());
                    }

                    if (resultado.getValueAt(i, 10) == null) {
                        dir.setNombreUnidadGeografica(null);
                    } else {
                        dir.setNombreUnidadGeografica(resultado.getValueAt(i, 10).toString());
                    }

                    //UtilidadesLog.debug("bucle " + i + ": " + dir.toString());
                    arrayDirecciones[i] = dir;
                }

                dto.setDirecciones(arrayDirecciones);
            }

            //DTOCliente
            //base: metemos el DTOCrearClienteBasico creado anteriormente 
            dtosalida.setBase(dto);

            //DTOComunicacion[]			
            query = new StringBuffer();
            /*query.append(" SELECT OID_CLIE_COMU, TICM_OID_TIPO_COMU, VAL_DIA_COMU, VAL_TEXT_COMU,  ");
            query.append(" to_char(FEC_HORA_DESD, 'HH24:MI'), to_char(FEC_HORA_HAST, 'HH24:MI'), VAL_INTE_COMU, IND_COMU_PPAL  ");
            query.append(" FROM MAE_CLIEN_COMUN  ");
            query.append(" WHERE CLIE_OID_CLIE = " + oid.getOid() + " ");*/
            
            query.append(" SELECT oid_clie_comu, ticm_oid_tipo_comu, val_dia_comu, val_text_comu, ");
            query.append(" ind_comu_ppal, TO_CHAR (fec_hora_desd, 'HH24:MI'), ");
            query.append(" TO_CHAR (fec_hora_hast, 'HH24:MI'), val_inte_comu ");
            query.append(" FROM mae_clien_comun ");
            query.append(" WHERE clie_oid_clie = " + oid.getOid());    
            query.append(" order by ind_comu_ppal desc ");
            rComunicaciones = bs.dbService.executeStaticQuery(query.toString());
            /*resultado = bs.dbService.executeStaticQuery(query.toString());

            DTOComunicacion[] dtots7 = new DTOComunicacion[resultado.getRowCount()];
            DTOComunicacion dtos7;

            for (int i = 0; i < resultado.getRowCount(); i++) {
                dtos7 = new DTOComunicacion();
                dtos7.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                dtos7.setTipoComunicacion(new Long(((BigDecimal) resultado.getValueAt(i, 1)).longValue()));

                String diaComu = (String) resultado.getValueAt(i, 2);

                if ((diaComu != null) && !(diaComu.equals(""))) {
                    dtos7.setDiaComunicacion(new Character(diaComu.toCharArray()[0]));
                }

                dtos7.setTextoComunicacion((String) resultado.getValueAt(i, 3));

                String sHoraDesde = (String) resultado.getValueAt(i, 4);
                String sHoraHasta = (String) resultado.getValueAt(i, 5);

                UtilidadesLog.debug("HoraDesde: " + sHoraDesde);
                UtilidadesLog.debug("HoraHasta: " + sHoraHasta);

                SimpleDateFormat simpleDateHora = new SimpleDateFormat("HH:mm");

                if ((sHoraDesde != null) && !sHoraDesde.equals("")) {
                    java.util.Date dateHoraDesde = simpleDateHora.parse(sHoraDesde);
                    UtilidadesLog.debug("dateHoraDesde: " + dateHoraDesde.toString());
                    UtilidadesLog.debug("dateHoraDesde Long: " + dateHoraDesde.getTime());

                    Long longHoraDesde = new Long(dateHoraDesde.getTime());
                    dtos7.setHoraDesde(longHoraDesde);
                }

                if ((sHoraHasta != null) && !sHoraHasta.equals("")) {
                    java.util.Date dateHoraHasta = simpleDateHora.parse(sHoraHasta);
                    UtilidadesLog.debug("dateHoraHasta: " + dateHoraHasta.toString());
                    UtilidadesLog.debug("dateHoraHasta Long: " + dateHoraHasta.getTime());

                    Long longHoraHasta = new Long(dateHoraHasta.getTime());
                    dtos7.setHoraHasta(longHoraHasta);
                }

                BigDecimal interva = (BigDecimal) resultado.getValueAt(i, 6);
                Boolean intervaloComuni = null;

                if (interva != null) {
                    if (interva.toString().equals("1")) {
                        intervaloComuni = Boolean.TRUE;
                    } else {
                        intervaloComuni = Boolean.FALSE;
                    }
                }

                dtos7.setIntervaloComunicacion(intervaloComuni);

                BigDecimal pric = (BigDecimal) resultado.getValueAt(i, 7);
                Boolean principal = null;

                if (pric != null) {
                    if (pric.toString().equals("1")) {
                        principal = Boolean.TRUE;
                    } else {
                        principal = Boolean.FALSE;
                    }
                }

                dtos7.setPrincipal(principal);
                dtots7[i] = dtos7;
            }
            
            dtosalida.setComunicaciones(dtots7); */
            dtosalida.setRComunicaciones(rComunicaciones);

            //DTOTarjeta[]			
            query = new StringBuffer();
            query.append(" SELECT OID_CLIE_TARJ, TITR_OID_TIPO_TARJ, CLTA_OID_CLAS_TARJ, CBAN_OID_BANC ");
            query.append(" FROM MAE_CLIEN_TARJE ");
            query.append(" WHERE CLIE_OID_CLIE = " + oid.getOid() + " ");
            /* rTarjetas = bs.dbService.executeStaticQuery(query.toString()); */

            resultado= bs.dbService.executeStaticQuery(query.toString());
            DTOTarjeta[] dtots8 = new DTOTarjeta[resultado.getRowCount()];
            DTOTarjeta dtos8;

            for (int i = 0; i < resultado.getRowCount(); i++) {
                dtos8 = new DTOTarjeta();
                dtos8.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                dtos8.setTipo(new Long(((BigDecimal) resultado.getValueAt(i, 1)).longValue()));
                dtos8.setClase((resultado.getValueAt(i, 2) != null) ? new Long(((BigDecimal) resultado.getValueAt(i, 2)).longValue()) : null);
                dtos8.setBanco((resultado.getValueAt(i, 3) != null) ? new Long(((BigDecimal) resultado.getValueAt(i, 3)).longValue()) : null);
                dtots8[i] = dtos8;
            }

            dtosalida.setTarjetas(dtots8);
            /*dtosalida.setRTarjeta(rTarjetas);*/

            //DTOProblemaSolucion
            query = new StringBuffer();
            query.append(" SELECT OID_CLIE_PROB, DES_PROB, IND_SOLU, ");
            query.append(" VAL_NEGO_PROD, TIPB_OID_TIPO_PROB, DES_SOLU, TSOC_OID_TIPO_SOLU  ");
            query.append(" FROM MAE_CLIEN_PROBL  ");
            query.append(" WHERE CLIE_OID_CLIE = " + oid.getOid() + " ");

            /* rProblemaSolucion = bs.dbService.executeStaticQuery(query.toString()); */
            resultado = bs.dbService.executeStaticQuery(query.toString());

            DTOProblemaSolucion[] dtots9 = new DTOProblemaSolucion[resultado.getRowCount()];
            DTOProblemaSolucion dtos9;

            for (int i = 0; i < resultado.getRowCount(); i++) {
                dtos9 = new DTOProblemaSolucion();
                dtos9.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                dtos9.setDescripcionProblema((String) resultado.getValueAt(i, 1));

                // dtos9.setSolucion(new Boolean((String) (resultado.getValueAt(i, 2))));
                if (resultado.getValueAt(i, 2) != null) {
                
                    Long ind = null;
                    ind = new Long(((BigDecimal) resultado.getValueAt(i, 2)).longValue());

                    if (ind.intValue() == 1) {
                        dtos9.setSolucion(new Boolean(true));
                    } else {
                        dtos9.setSolucion(new Boolean(false));
                    }

                    //Boolean valor = new Boolean( ((String)resultado.getValueAt(i, 2)).equals("1") );
                }

                
                dtos9.setNegocio((String) resultado.getValueAt(i, 3));
                dtos9.setTipoProblema((resultado.getValueAt(i, 4) != null) ? new Long(((BigDecimal) resultado.getValueAt(i, 4)).longValue()) : null);
                dtos9.setDescripcionSolucion((String) resultado.getValueAt(i, 5));
                dtos9.setTipoSolucion((resultado.getValueAt(i, 6) != null) ? new Long(((BigDecimal) resultado.getValueAt(i, 6)).longValue()) : null);

                dtots9[i] = dtos9;
            }

            dtosalida.setProblemasSoluciones(dtots9);
            /* dtosalida.setRProblemaSolucion(rProblemaSolucion);*/

            //DTOPsicografia
            query = new StringBuffer();
            query.append(" SELECT OID_PSIC, MARC_OID_MARC, TPOID_TIPO_PERF_PSIC, COD_TEST, FEC_PSIC ");
            query.append(" FROM MAE_PSICO  ");
            query.append(" WHERE CLIE_OID_CLIE = " + oid.getOid() + " ");
            /* rPsicografia = bs.dbService.executeStaticQuery(query.toString());*/
            
            resultado = bs.dbService.executeStaticQuery(query.toString());
            DTOPsicografia[] dtots10 = new DTOPsicografia[resultado.getRowCount()];
            DTOPsicografia dtos10;

            for (int i = 0; i < resultado.getRowCount(); i++) {
                dtos10 = new DTOPsicografia();
                dtos10.setOid(new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue()));
                dtos10.setMarca(new Long(((BigDecimal) resultado.getValueAt(i, 1)).longValue()));
                dtos10.setTipoPerfil(new Long(((BigDecimal) resultado.getValueAt(i, 2)).longValue()));
                dtos10.setCodigoTest((String) (resultado.getValueAt(i, 3)));
                dtos10.setFecha((Date) (resultado.getValueAt(i, 4)));
                dtots10[i] = dtos10;
            }

            dtosalida.setPsicografias(dtots10);
            /* dtosalida.setRPsicografia(rPsicografia);*/
        } catch (CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("dtoSalida ObtenerCliente: " + dtosalida);
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerCliente(DTOOID): Salida");

        return dtosalida;
    }
    
    private RecordSet obtieneDireccionSinGEOModificar(DTOOID oid)throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtieneDireccionSinGEOModificar(DTOOID): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs; 
        BelcorpService bs;
        String codigoError;
        
        query.append(" SELECT dir.OID_CLIE_DIRE, dir.TIDC_OID_TIPO_DIRE, dir.TIVI_OID_TIPO_VIA, ");
            query.append(" val.OID_VALO_ESTR_GEOP, dir.ZVIA_OID_VIA, dir.NUM_PPAL, dir.VAL_COD_POST, ");
            query.append(" dir.VAL_OBSE, dir.IND_DIRE_PPAL, dir.VAL_NOMB_VIA, val.DES_GEOG ");
            query.append(" FROM MAE_CLIEN_DIREC dir, ZON_VALOR_ESTRU_GEOPO val, ZON_TERRI terr ");
            query.append(" WHERE dir.CLIE_OID_CLIE = " + oid.getOid() + " AND ");
            query.append(" dir.TERR_OID_TERR = terr.OID_TERR AND ");
            query.append(" terr.VEPO_OID_VALO_ESTR_GEOP = val.OID_VALO_ESTR_GEOP ");
            query.append(" AND dir.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: "+rs);
            UtilidadesLog.info(" DAOMAEMaestroClientes.obtieneDireccionSinGEOModificar(DTOOID): Entrada");
            return rs;
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    
    }
    
    private RecordSet obtieneDireccionConGEOModificar(DTOOID oid)throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtieneDireccionConGEOModificar(DTOOID): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs; 
        BelcorpService bs;
        String codigoError;
        RecordSet resultado = new RecordSet();
        
        try {
            query.append(" SELECT DISTINCT M.COD_UNID_GEOG ");
            query.append(" FROM MAE_CLIEN_DIREC M ");
            query.append(" WHERE M.CLIE_OID_CLIE = "+ oid.getOid());
            query.append(" AND M.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08

            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: "+rs);
            
            if(!rs.esVacio()){
                
                for(int j=0;j<rs.getRowCount();j++){
                    RecordSet rs2 = new RecordSet();
                    String orden_1 = "";
                    String orden_2 = "";
                    String orden_3 = "";
                    String orden_4 = "";
                    String orden_5 = "";
                    String orden_6 = "";
                    String orden_7 = "";
                    String orden_8 = "";
                    String orden_9 = "";
                    String codUniGeo = rs.getValueAt(j,0)==null?"":(String) rs.getValueAt(j,0);
                    int sizeCod = codUniGeo.length();
                    int numOrdenesGeo = sizeCod/6;
                    
                    UtilidadesLog.debug("*** numOrdenesGeo: "+numOrdenesGeo);
                    switch(numOrdenesGeo){
                        case 1:
                                orden_1 = codUniGeo.substring(0);
                                break;
                        case 2: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                break;
                        case 3: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                break;
                        case 4: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                break;
                        case 5: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                break;
                        case 6: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                orden_6 = codUniGeo.substring(30, 36);
                                break;
                        case 7: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                orden_6 = codUniGeo.substring(30, 36);
                                orden_7 = codUniGeo.substring(36, 40);
                                break;
                        case 8: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                orden_6 = codUniGeo.substring(30, 36);
                                orden_7 = codUniGeo.substring(36, 40);
                                orden_8 = codUniGeo.substring(40, 46);
                                break;
                        case 9: 
                                orden_1 = codUniGeo.substring(0,6);
                                orden_2 = codUniGeo.substring(6, 12);
                                orden_3 = codUniGeo.substring(12, 18);
                                orden_4 = codUniGeo.substring(18, 24);
                                orden_5 = codUniGeo.substring(24, 30);
                                orden_6 = codUniGeo.substring(30, 36);
                                orden_7 = codUniGeo.substring(36, 40);
                                orden_8 = codUniGeo.substring(40, 46);
                                orden_9 = codUniGeo.substring(46, 52);
                                break;
                    }
                    
                    StringBuffer query2 = new StringBuffer();
                    query2.append(" SELECT dir.oid_clie_dire,  ");
                    query2.append(" dir.tidc_oid_tipo_dire,  ");
                    query2.append(" dir.tivi_oid_tipo_via, ");
                    query2.append(" val.oid_valo_estr_geop,  ");
                    query2.append(" dir.zvia_oid_via,  ");
                    query2.append(" dir.num_ppal, ");
                    query2.append(" dir.val_cod_post,  ");
                    query2.append(" dir.val_obse,  ");
                    query2.append(" dir.ind_dire_ppal,  ");
                    query2.append(" dir.val_nomb_via, ");
                    query2.append(" val.des_geog ");
                    query2.append(" FROM mae_clien_direc dir,  ");
                    query2.append(" zon_valor_estru_geopo val ");
                    query2.append(" WHERE dir.clie_oid_clie = " + oid.getOid());
                    query2.append(" AND dir.ind_elim = 0 "); //agregado por Sapaza, incidencia V_MAE_08

                    if(!"".equals(orden_1)){
                        query2.append(" AND VAL.ORDE_1 = '"+orden_1+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_1 IS NULL ");
                    }
                    if(!"".equals(orden_2)){
                        query2.append(" AND VAL.ORDE_2 = '"+orden_2+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_2 IS NULL ");
                    }
                    if(!"".equals(orden_3)){
                        query2.append(" AND VAL.ORDE_3 = '"+orden_3+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_3 IS NULL ");
                    }
                    if(!"".equals(orden_4)){
                        query2.append(" AND VAL.ORDE_4 = '"+orden_4+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_4 IS NULL ");
                    }
                    if(!"".equals(orden_5)){
                        query2.append(" AND VAL.ORDE_5 = '"+orden_5+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_5 IS NULL ");
                    }
                    if(!"".equals(orden_6)){
                        query2.append(" AND VAL.ORDE_6 = '"+orden_6+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_6 IS NULL ");
                    }
                    if(!"".equals(orden_7)){
                        query2.append(" AND VAL.ORDE_7 = '"+orden_7+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_7 IS NULL ");
                    }
                    if(!"".equals(orden_8)){
                        query2.append(" AND VAL.ORDE_8 = '"+orden_8+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_8 IS NULL ");
                    }
                    if(!"".equals(orden_9)){
                        query2.append(" AND VAL.ORDE_9 = '"+orden_9+"'");
                    } else{
                        query2.append(" AND VAL.ORDE_9 IS NULL ");
                    }
                    query2.append(" AND VAL.pais_oid_pais = "+oid.getOidPais());
        
                    bs = BelcorpService.getInstance();
                    rs2 = bs.dbService.executeStaticQuery(query2.toString());
                    UtilidadesLog.debug("*** rs2: "+rs2);
                    
                    if(!rs2.esVacio()){
                        resultado.setColumnIdentifiers(rs2.getColumnIdentifiers());
                        for(int k=0;k<rs2.getRowCount();k++){
                            resultado.addRow(rs2.getRow(k));
                        }
                        UtilidadesLog.info("*** resultado.getRowCount(): "+resultado.getRowCount());
                    }
                    
                    
                }
            }
            UtilidadesLog.info("*** resultado: "+resultado);
            UtilidadesLog.info(" DAOMAEMaestroClientes.obtieneDireccionConGEOModificar(DTOOID): Salida");
            return resultado;
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }
    
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * 29/06/06 - [1] pperanzola : se modifica para que sea performante
     */
    public DTOSalida buscarClientes(DTOCliente dto) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.buscarClientes(DTOCliente): Entrada");

        Boolean bUsaGEOREFERENCIADOR = Boolean.FALSE;
        MONMantenimientoSEG mms;
        RecordSet resultado = new RecordSet();

        try {
            if (!validarArraysDTOCliente(dto)) {
                //TODO error de negocio los arrays tienen mas de un elemento, excepto Problema/Solucion
                throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer selectFrom = new StringBuffer();
            StringBuffer where = new StringBuffer();
            StringBuffer aux = new StringBuffer();

            selectFrom.append(" SELECT OID_CLIE OID, COD_CLIE, DA.IND_ACTI, ");
            selectFrom.append(" Pq_Apl_Aux.Valor_Gen_I18n_Sicc(1, ticl_oid_tipo_clie, 'MAE_TIPO_CLIEN') DESC_TIPO_CLIENTE, ");// [1] I1.VAL_I18N DESC_TIPO_CLIENTE, I2.VAL_I18N DESC_SUB_TIPO_CLIENTE, ");
			selectFrom.append(" Pq_Apl_Aux.Valor_Gen_I18n_Sicc(1, sbti_oid_subt_clie, 'MAE_SUBTI_CLIEN') DESC_SUB_TIPO_CLIENTE, " );// [1] 
            selectFrom.append(" VAL_APE1, VAL_APE2, VAL_NOM1, VAL_NOM2 ");
            selectFrom.append("   FROM MAE_CLIEN C, ");
            selectFrom.append("        MAE_CLIEN_TIPO_SUBTI TS, ");
            //selectFrom.append(" 	   V_GEN_I18N_SICC I1, ");
            //selectFrom.append(" 	   V_GEN_I18N_SICC I2, ");
            selectFrom.append(" MAE_CLIEN_DATOS_ADICI DA");

            where.append(" WHERE  C.OID_CLIE = TS.CLIE_OID_CLIE (+)");
            where.append(" AND c.pais_oid_pais = " + dto.getOidPais().toString());
            //[1] where.append(" AND I1.ATTR_ENTI (+)= 'MAE_TIPO_CLIEN'   ");
            //[1] where.append(" AND I1.IDIO_OID_IDIO(+) = " + dto.getOidIdioma() + " ");
            //[1] where.append(" AND I1.VAL_OID(+) = TICL_OID_TIPO_CLIE   ");
            //[1] where.append(" AND I2.ATTR_ENTI(+) = 'MAE_SUBTI_CLIEN'  ");
            //[1] where.append(" AND I2.IDIO_OID_IDIO (+)= " + dto.getOidIdioma() + " ");
            //[1] where.append(" AND I2.VAL_OID (+)= SBTI_OID_SUBT_CLIE   ");
            
            /* BELC300024052 - gPineda 17/08/06 */
            //where.append(" AND C.OID_CLIE = DA.CLIE_OID_CLIE ");
            where.append(" AND C.OID_CLIE = DA.CLIE_OID_CLIE(+) ");
            
            // Se añade UPPER a ambos Criterios de Busqueda, por inc. 7167.
            // Cambio realizado por ssantana, 13/1/2005
            if ((dto.getCriterioBusqueda1() != null) && !(dto.getCriterioBusqueda1().equals(""))) {
                where.append(" AND UPPER(C.VAL_CRIT_BUS1) LIKE UPPER('" + dto.getCriterioBusqueda1() + "') ");
            }

            if ((dto.getCriterioBusqueda2() != null) && !(dto.getCriterioBusqueda2().equals(""))) {
                where.append(" AND UPPER(C.VAL_CRIT_BUS2) LIKE UPPER('" + dto.getCriterioBusqueda2() + "') ");
            }

            DTOCrearClienteBasico dcb = dto.getBase();
            boolean dcbJoin = false;

            if (dcb != null) {
                if ((dcb.getCodigoCliente() != null) && !(dcb.getCodigoCliente().equals(""))) {
                    where.append(" AND C.COD_CLIE LIKE '" + dcb.getCodigoCliente() + "' ");
                }

                if ((dcb.getApellido1() != null) && !(dcb.getApellido1().equals(""))) {
                    where.append(" AND UPPER(C.VAL_APE1) LIKE UPPER('" + dcb.getApellido1() + "') ");
                }

                if ((dcb.getApellido2() != null) && !(dcb.getApellido2().equals(""))) {
                    where.append(" AND UPPER(C.VAL_APE2) LIKE UPPER('" + dcb.getApellido2() + "') ");
                }

                if ((dcb.getApellidoCasada() != null) && !(dcb.getApellidoCasada().equals(""))) {
                    where.append(" AND UPPER(C.VAL_APEL_CASA) LIKE UPPER('" + dcb.getApellidoCasada() + "') ");
                }

                if ((dcb.getNombre1() != null) && !(dcb.getNombre1().equals(""))) {
                    where.append(" AND UPPER(C.VAL_NOM1) LIKE UPPER('" + dcb.getNombre1() + "') ");
                }

                if ((dcb.getNombre2() != null) && !(dcb.getNombre2().equals(""))) {
                    where.append(" AND UPPER(C.VAL_NOM2) LIKE UPPER('" + dcb.getNombre2() + "') ");
                }

                if ((dcb.getTratamiento() != null) && !(dcb.getTratamiento().equals(""))) {
                    where.append(" AND C.VAL_TRAT = '" + dcb.getTratamiento() + "' ");
                }

                if ((dcb.getSexo() != null) && !(dcb.getSexo().equals(""))) {
                    where.append(" AND C.COD_SEXO = '" + dcb.getSexo() + "' ");
                }

                if (dcb.getFechaIngreso() != null) {
                    where.append(" AND C.FEC_INGR = to_date('" + dcb.getFechaIngreso() + "', 'yyyy-mm-dd') ");
                }

                if (dcb.getFormaPago() != null) {
                    where.append(" AND C.FOPA_OID_FORM_PAGO = " + dcb.getFormaPago() + " ");
                }

                //Cambio segun dmco N013, se filtra por varios tipos subtipos
                DTOTipoSubtipoCliente[] dts1 = dcb.getTiposSubtipos();
                DTOTipoSubtipoCliente dts = dts1[0];
                UtilidadesLog.debug("antes del if");

                if (dts.getTipo() != null) {
                    UtilidadesLog.debug("entro al if");

                    where.append(" AND (  ");

                    for (int i = 0; i < dcb.getTiposSubtipos().length; i++) {
                        
                        if (dts1 != null) {
                            DTOTipoSubtipoCliente dtsc = dts1[i];

                            if (dtsc != null) {
                                if (dtsc.getTipo() != null) {
                                    where.append("  (TS.TICL_OID_TIPO_CLIE = " + dtsc.getTipo() + " ");
                                }

                                if (dtsc.getSubtipo() != null) {
                                    where.append(" AND TS.SBTI_OID_SUBT_CLIE = " + dtsc.getSubtipo() + " ) OR ");
                                    
                                } else {
                                    where.append(" ) OR ");
                                    
                                }
                            }
                        }
                    }

                    where.append(" 1!=1 ");
                    where.append(" ) ");
                }

                DTOIdentificacion[] dti1 = dcb.getIdentificaciones();

                if ((dti1 != null) && (dti1.length == 1)) {
                    DTOIdentificacion dti = dti1[0];
                    boolean dtiJoin = false;

                    if (dti != null) {
                        if (dti.getTipoDocumento() != null) {
                            where.append(" AND ID.TDOC_OID_TIPO_DOCU = " + dti.getTipoDocumento() + " ");
                            dtiJoin = true;
                        }

                        if (dti.getNumeroDocumento() != null) {
                            where.append(" AND ID.NUM_DOCU_IDEN LIKE '" + dti.getNumeroDocumento() + "' ");
                            dtiJoin = true;
                        }

                        if ((dti.getIndPersonaEmpresa() != null) && !(dti.getIndPersonaEmpresa().equals(""))) {
                            where.append(" AND ID.VAL_IDEN_PERS_EMPR = '" + dti.getIndPersonaEmpresa() + "' ");
                            dtiJoin = true;
                        }

                        if (dti.getEsPrincipal() != null) {
                            where.append(" AND ID.VAL_IDEN_DOCU_PRIN = " + booleanALong(dti.getEsPrincipal()) + " ");
                            dtiJoin = true;
                        }

                        if (dtiJoin) {
                            where.append(" AND C.OID_CLIE = ID.CLIE_OID_CLIE ");
                            selectFrom.append("       , MAE_CLIEN_IDENT ID	");
                        }
                    }
                }

                DTODireccion[] dtd1 = dcb.getDirecciones();

                if ((dtd1 != null) && (dtd1.length == 1)) {
                    DTODireccion dtd = dtd1[0];
                    boolean dtdJoin = false;

                    if (dtd != null) {
                        if (dtd.getTipoDireccion() != null) {
                            where.append(" AND DIR.TIDC_OID_TIPO_DIRE = " + dtd.getTipoDireccion() + " ");
                            dtdJoin = true;
                        }

                        if (dtd.getTipoVia() != null) {
                            where.append(" AND DIR.TIVI_OID_TIPO_VIA = " + dtd.getTipoVia() + " ");
                            dtdJoin = true;
                        }

                        if (dtd.getNumeroPrincipal() != null) {
                            where.append(" AND DIR.NUM_PPAL LIKE '" + dtd.getNumeroPrincipal() + "' ");
                            dtdJoin = true;
                        }

                        if ((dtd.getCodigoPostal() != null) && !(dtd.getCodigoPostal().equals(""))) {
                            where.append(" AND DIR.VAL_COD_POST LIKE '" + dtd.getCodigoPostal() + "' ");
                            dtdJoin = true;
                        }

                        if ((dtd.getObservaciones() != null) && !(dtd.getObservaciones().equals(""))) {
                            where.append(" AND DIR.VAL_OBSE LIKE '" + dtd.getObservaciones() + "' ");
                            dtdJoin = true;
                        }

                        if (dtd.getEsDireccionPrincipal() != null) {
                            where.append(" AND DIR.IND_DIRE_PPAL = " + booleanALong(dtd.getEsDireccionPrincipal()) + " ");
                            dtdJoin = true;
                        }

                        MONMantenimientoSEGHome mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
                        mms = mmsHome.create();
                        bUsaGEOREFERENCIADOR = mms.usaGeoreferenciador(dto.getOidPais());

                        if (bUsaGEOREFERENCIADOR.booleanValue()) {
                            if ((dtd.getNombreVia() != null) && !(dtd.getNombreVia().equals(""))) {
                                where.append(" AND DIR.VAL_NOMB_VIA LIKE '" + dtd.getNombreVia() + "' ");
                                dtdJoin = true;
                            }

                            if (dtdJoin) {
                                where.append(" AND C.OID_CLIE = DIR.CLIE_OID_CLIE ");
                                where.append(" AND DIR.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08                                
                                selectFrom.append("       , MAE_CLIEN_DIREC DIR ");
                            }
                        } else {
                            if ((dtd.getNombreVia() != null) && !(dtd.getNombreVia().equals(""))) {
                                where.append(" AND ZV.NOM_VIA = '" + dtd.getNombreVia() + "' ");
                                dtdJoin = true;
                            }

                            if (dtdJoin) {
                                where.append(" AND C.OID_CLIE = DIR.CLIE_OID_CLIE ");
                                where.append(" AND DIR.ZVIA_OID_VIA = ZV.OID_VIA(+) ");
                                where.append(" AND DIR.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08                                
                                selectFrom.append("       , MAE_CLIEN_DIREC DIR ");
                                selectFrom.append("       , ZON_VIA ZV ");
                            }
                        }
                    }
                }

                DTOClienteMarca[] dtm1 = dcb.getMarcas();

                if ((dtm1 != null) && (dtm1.length == 1)) {
                    DTOClienteMarca dtm = dtm1[0];

                    if (dtm != null) {
                        if (dtm.getMarca() != null) {
                            where.append(" AND C.OID_CLIE = MA.CLIE_OID_CLIE ");
                            where.append(" AND MA.MARC_OID_MARC = " + dtm.getMarca() + " ");
                            selectFrom.append("        , MAE_CLIEN_MARCA MA  ");
                        }
                    }
                }

                DTOClasificacionCliente[] dtc1 = dcb.getClasificaciones();

                if ((dtc1 != null) && (dtc1.length == 1)) {
                    DTOClasificacionCliente dtc = dtc1[0];
                    boolean dtcJoin = false;

                    if (dtc != null) {
                        if (dtc.getMarca() != null) {
                            where.append(" AND PERI.MARC_OID_MARC = " + dtc.getMarca() + " ");
                            dtcJoin = true;
                        }

                        if (dtc.getCanal() != null) {
                            where.append(" AND PERI.CANA_OID_CANA = " + dtc.getCanal() + " ");
                            dtcJoin = true;
                        }

                        if (dtc.getClasificacion() != null) {
                            where.append(" AND CL.CLAS_OID_CLAS = " + dtc.getClasificacion() + " ");
                            dtcJoin = true;
                        }

                        if (dtc.getTipoClasificacion() != null) {
                            where.append(" AND CL.TCCL_OID_TIPO_CLASI = " + dtc.getTipoClasificacion() + " ");
                            dtcJoin = true;
                        }

                        if (dtcJoin) {
                            where.append(" AND TS.OID_CLIE_TIPO_SUBT = CL.CTSU_OID_CLIE_TIPO_SUBT ");
                            where.append(" AND CL.PERD_OID_PERI = PERI.OID_PERI  ");
                            selectFrom.append("       , MAE_CLIEN_CLASI CL ");
                            selectFrom.append("	   , CRA_PERIO PERI ");
                        }
                    }
                }
            }

            //DTOCrearClienteBasico != null
            boolean dtdaJoin = false;

            if (dto.getFechaNacimiento() != null) {
                where.append(" AND DA.FEC_NACI = to_date('" + dto.getFechaNacimiento() + "', 'yyyy-mm-dd') ");
                dtdaJoin = true;
            }

            if (dto.getCodigoEmpleado() != null) {
                where.append(" AND DA.COD_EMPL LIKE '" + dto.getCodigoEmpleado() + "' ");
                dtdaJoin = true;
            }

            if (dto.getNacionalidad() != null) {
                where.append(" AND DA.SNON_OID_NACI = " + dto.getNacionalidad() + " ");
                dtdaJoin = true;
            }

            if (dto.getEstadoCivil() != null) {
                where.append(" AND DA.ESCV_OID_ESTA_CIVI = " + dto.getEstadoCivil() + " ");
                dtdaJoin = true;
            }

            if (dto.getOcupacion() != null) {
                where.append(" AND DA.VAL_OCUP LIKE '" + dto.getOcupacion() + "' ");
                dtdaJoin = true;
            }

            if (dto.getProfesion() != null) {
                where.append(" AND DA.VAL_PROF LIKE '" + dto.getProfesion() + "' ");
                dtdaJoin = true;
            }

            if (dto.getCentroTrabajo() != null) {
                where.append(" AND DA.VAL_CENT_TRAB LIKE '" + dto.getCentroTrabajo() + "' ");
                dtdaJoin = true;
            }

            if (dto.getCargo() != null) {
                where.append(" AND DA.VAL_CARG_DESE LIKE '" + dto.getCargo() + "' ");
                dtdaJoin = true;
            }

            if (dto.getNivelEstudios() != null) {
                where.append(" AND DA.NIED_OID_NIVE_ESTU = " + dto.getNivelEstudios() + " ");
                dtdaJoin = true;
            }

            if (dto.getCentroEstudios() != null) {
                where.append(" AND DA.VAL_CENT_ESTU LIKE '" + dto.getCentroEstudios() + "' ");
                dtdaJoin = true;
            }

            if (dto.getNumeroHijos() != null) {
                where.append(" AND DA.NUM_HIJO LIKE '" + dto.getNumeroHijos() + "' ");
                dtdaJoin = true;
            }

            if (dto.getPersonasDependientes() != null) {
                where.append(" AND DA.NUM_PERS_DEPE LIKE '" + dto.getPersonasDependientes() + "' ");
                dtdaJoin = true;
            }

            if (dto.getNSEP() != null) {
                where.append(" AND DA.NSEP_OID_NSEP = " + dto.getNSEP() + " ");
                dtdaJoin = true;
            }

            if (dto.getCicloVida() != null) {
                where.append(" AND DA.TCLV_OID_CICL_VIDA = " + dto.getCicloVida() + " ");
                dtdaJoin = true;
            }

            if (dto.getDeseaCorrespondencia() != null) {
                where.append(" AND DA.IND_CORR = " + booleanALong(dto.getDeseaCorrespondencia()) + " ");
                dtdaJoin = true;
            }

            if (dto.getImporteIngresos() != null) {
                String str2 = new String();
                str2 = dto.getImporteIngresos().toString();
                UtilidadesLog.debug("el string " + str2);

                if (str2.endsWith(".0")) {
                    UtilidadesLog.debug("***entro");

                    String str3 = new String();
                    str3 = str2.substring(0, str2.length() - 2);
                    str2 = str3;
                }

                where.append(" AND DA.IMP_INGR_FAMI LIKE '" + str2 + "' ");
                dtdaJoin = true;
            }
            
            //Modificado: SICC-DMCO-MAE-GCC-006 - Cleal  !!!!Si no selecciono nada en el combo debe ser null!!!
            if(dto.getIndicadorActivo()!=null){
                where.append(" AND DA.IND_ACTI = "+dto.getIndicadorActivo()+ " ");
                dtdaJoin = true;   
            }
            
            DTOVinculo[] dtv1 = dto.getVinculos();

            if ((dtv1 != null) && (dtv1.length == 1)) {
                DTOVinculo dtv = dtv1[0];
                boolean dtvJoin = false;

                if (dtv != null) {
                    if (dtv.getFechaDesde() != null) {
                        where.append(" AND V.FEC_DESD = to_date('" + dtv.getFechaDesde() + "', 'yyyy-mm-dd') ");
                        dtvJoin = true;
                    }

                    if (dtv.getFechaHasta() != null) {
                        where.append(" AND V.FEC_HAST = to_date('" + dtv.getFechaHasta() + "', 'yyyy-mm-dd') ");
                        dtvJoin = true;
                    }

                    if (dtv.getTipo() != null) {
                        where.append(" AND V.TIVC_OID_TIPO_VINC = " + dtv.getTipo() + " ");
                        dtvJoin = true;
                    }

                    if (dtv.getPrincipal() != null) {
                        where.append(" AND V.IND_VINC_PPAL = " + booleanALong(dtv.getPrincipal()) + " ");
                        dtvJoin = true;
                    }

                    if ((dtv.getPais() != null) || (dtv.getCodigoCliente() != null) || dtvJoin) {
                        /* inicio deshace modif ciglesias incidencia 24377 17/11/2006
                        //inicio Modificado incidencia DBLG700000127
                        where.append(" AND V.CLIE_OID_CLIE_VNTE IN (SELECT OID_CLIE  ");
                        //fin Modificado incidencia DBLG700000127
                        */
                        where.append(" AND V.CLIE_OID_CLIE_VNDO IN (SELECT OID_CLIE  ");
                        
                        /*fin deshace modif 24377*/
                        
                        
                        where.append(" 							FROM MAE_CLIEN C  ");
                        where.append(" 							WHERE 1=1  ");

                        if (dtv.getPais() != null) {
                            where.append(" 							AND C.PAIS_OID_PAIS = " + dtv.getPais() + " ");
                            dtvJoin = true;
                        }

                        if (dtv.getCodigoCliente() != null) {
                            where.append(" 							AND C.COD_CLIE LIKE '" + dtv.getCodigoCliente() + "' ");
                            dtvJoin = true;
                        }

                        where.append(" 							) ");
                    }

                    if (dtvJoin) {
                        /*inicio deshace modif ciglesias 17/11/2006 incidencia 24377
                        //inicio Modificado incidencia DBLG700000127
                        where.append("AND C.OID_CLIE = V.CLIE_OID_CLIE_VNDO ");
                        //fin Modificado incidencia DBLG700000127
                        */
                        where.append("AND C.OID_CLIE = V.CLIE_OID_CLIE_VNTE ");
                        /*fin deshace modif ciglesias 24337*/
                        selectFrom.append("       , MAE_CLIEN_VINCU V ");
                    }
                }
            }

            DTOPreferencia[] dtpr1 = dto.getPreferencias();

            if ((dtpr1 != null) && (dtpr1.length == 1)) {
                DTOPreferencia dtpr = dtpr1[0];
                boolean dtprJoin = false;

                if (dtpr != null) {
                    if (dtpr.getTipo() != null) {
                        where.append(" AND PR.TIPF_OID_TIPO_PREF = " + dtpr.getTipo() + " ");
                        dtprJoin = true;
                    }

                    if (dtpr.getTipo() != null) {
                        where.append(" AND PR.DES_CLIE_PREF LIKE '" + dtpr.getDescripcion() + "' ");
                        dtprJoin = true;
                    }

                    if (dtprJoin) {
                        where.append(" AND C.OID_CLIE = PR.CLIE_OID_CLIE ");
                        selectFrom.append("       , MAE_CLIEN_PREFE PR ");
                    }
                }
            }

            boolean dtpcJoin = false;

            if (dto.getFechaPrimerContacto() != null) {
                where.append(" AND PC.FEC_CONT = to_date('" + dto.getFechaPrimerContacto() + "', 'yyyy-mm-dd') ");
                dtpcJoin = true;
            }

            // by Ssantana
            if (dto.getMarcaContacto() != null) {
                where.append(" AND PC.MARC_OID_MARC = " + dto.getMarcaContacto().toString() + " ");
                dtpcJoin = true;
            }

            if (dto.getCanalContacto() != null) {
                where.append(" AND PC.CANA_OID_CANA = " + dto.getCanalContacto().toString() + " ");
                dtpcJoin = true;
            }

            if (dto.getPeriodoContacto() != null) {
                where.append(" AND PC.PERD_OID_PERI = " + dto.getPeriodoContacto().toString() + " ");
                dtpcJoin = true;
            }

            if (dto.getFechaSiguienteContacto() != null) {
                where.append(" AND PC.FEC_SIGU_CONT = to_date('" + dto.getFechaSiguienteContacto() + "', 'yyyy-mm-dd') ");
                dtpcJoin = true;
            }

            if (dto.getTipoContacto() != null) {
                where.append(" AND PC.COD_TIPO_CONT LIKE '" + dto.getTipoContacto() + "' ");
                dtpcJoin = true;
            }

            if ((dto.getTipoClienteContactado() != null) || (dto.getClienteContactado() != null) || (dto.getPaisContactado() != null) || dtpcJoin) {
                where.append(" AND PC.CTSU_CLIE_CONT IN (  ");
                where.append(" 						SELECT TS.OID_CLIE_TIPO_SUBT ");
                where.append(" 						FROM MAE_CLIEN_TIPO_SUBTI TS, MAE_CLIEN C ");
                where.append(" 						WHERE TS.CLIE_OID_CLIE = C.OID_CLIE ");

                if (dto.getTipoClienteContactado() != null) {
                    where.append(" 						AND TS.TICL_OID_TIPO_CLIE = " + dto.getTipoClienteContactado() + " ");
                    dtpcJoin = true;
                }

                if (dto.getClienteContactado() != null) {
                    where.append(" 						AND C.COD_CLIE LIKE '" + dto.getClienteContactado() + "' ");
                    dtpcJoin = true;
                }

                if (dto.getPaisContactado() != null) {
                    where.append(" 						AND C.PAIS_OID_PAIS = " + dto.getPaisContactado() + " ");
                    dtpcJoin = true;
                }

                where.append(" 						)  ");
            }

            if (dtpcJoin) {
                where.append(" AND C.OID_CLIE = PC.CLIE_OID_CLIE ");
                selectFrom.append("       , MAE_CLIEN_PRIME_CONTA PC ");
            }

            DTOComunicacion[] dtco1 = dto.getComunicaciones();

            if ((dtco1 != null) && (dtco1.length == 1)) {
                DTOComunicacion dtco = dtco1[0];
                boolean dtcoJoin = false;

                if (dtco != null) {
                    if (dtco.getTipoComunicacion() != null) {
                        where.append(" AND CO.TICM_OID_TIPO_COMU = " + dtco.getTipoComunicacion() + " ");
                        dtcoJoin = true;
                    }

                    if (dtco.getDiaComunicacion() != null) {
                        where.append("AND CO.VAL_DIA_COMU LIKE '" + dtco.getDiaComunicacion() + "' ");
                        dtcoJoin = true;
                    }

                    if (dtco.getTextoComunicacion() != null) {
                        where.append(" AND CO.VAL_TEXT_COMU LIKE '" + dtco.getTextoComunicacion() + "' ");
                        dtcoJoin = true;
                    }

                    if (dtco.getHoraDesde() != null) {
                        SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");

                        java.util.Date horaDesde = new java.util.Date(dtco.getHoraDesde().longValue());
                        String sHoraDesde = simpleDate.format(horaDesde);
                        
                        where.append(" AND to_char(CO.FEC_HORA_DESD, 'HH24:MI') = '" + sHoraDesde + "' ");

                        dtcoJoin = true;
                    }

                    if (dtco.getHoraHasta() != null) {
                        SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");

                        java.util.Date horaHasta = new java.util.Date(dtco.getHoraHasta().longValue());
                        String sHoraHasta = simpleDate.format(horaHasta);

                        where.append(" AND to_char(CO.FEC_HORA_HAST, 'HH24:MI') = '" + sHoraHasta + "' ");

                        dtcoJoin = true;
                    }

                    if (dtco.getIntervaloComunicacion() != null) {
                        where.append(" AND CO.VAL_INTE_COMU = " + booleanALong(dtco.getIntervaloComunicacion()) + " ");
                        dtcoJoin = true;
                    }

                    if (dtco.getPrincipal() != null) {
                        where.append(" AND CO.IND_COMU_PPAL = " + booleanALong(dtco.getPrincipal()) + " ");
                        dtcoJoin = true;
                    }

                    if (dtcoJoin) {
                        where.append("AND C.OID_CLIE = CO.CLIE_OID_CLIE ");
                        selectFrom.append("       , MAE_CLIEN_COMUN CO ");
                    }
                }
            }

            DTOTarjeta[] dttar1 = dto.getTarjetas();

            if ((dttar1 != null) && (dttar1.length == 1)) {
                DTOTarjeta dttar = dttar1[0];
                boolean dttarJoin = false;

                if (dttar != null) {
                    if (dttar.getTipo() != null) {
                        where.append(" AND TAR.TITR_OID_TIPO_TARJ = " + dttar.getTipo() + " ");
                        dttarJoin = true;
                    }

                    if (dttar.getClase() != null) {
                        where.append(" AND TAR.CLTA_OID_CLAS_TARJ = " + dttar.getClase() + " ");
                        dttarJoin = true;
                    }

                    if (dttar.getBanco() != null) {
                        where.append(" AND TAR.CBAN_OID_BANC = " + dttar.getBanco() + " ");
                        dttarJoin = true;
                    }

                    if (dttarJoin) {
                        where.append(" AND C.OID_CLIE = TAR.CLIE_OID_CLIE ");
                        selectFrom.append("       , MAE_CLIEN_TARJE TAR ");
                    }
                }
            }

            UtilidadesLog.debug(" ------- Problema Solucion --------");

            DTOProblemaSolucion[] problemas = dto.getProblemasSoluciones();
            
            DTOProblemaSolucion dtoProblemaSolucion = problemas[0];
            
            boolean agregarProblemaSolucion = false;

            if (dtoProblemaSolucion != null) {
            
                StringBuffer cadenaProblema = new StringBuffer();

                if (dtoProblemaSolucion.getTipoProblema() != null) {
                    agregarProblemaSolucion = true;
                    cadenaProblema.append(" AND PRO.TIPB_OID_TIPO_PROB = " + dtoProblemaSolucion.getTipoProblema() + " ");
                }

                if (dtoProblemaSolucion.getDescripcionProblema() != null) {
                    agregarProblemaSolucion = true;
                    cadenaProblema.append(" AND PRO.DES_PROB LIKE '" + dtoProblemaSolucion.getDescripcionProblema() + "' ");
                }

                if (dtoProblemaSolucion.getNegocio() != null) {
                    agregarProblemaSolucion = true;
                    cadenaProblema.append(" AND PRO.VAL_NEGO_PROD LIKE '" + dtoProblemaSolucion.getNegocio() + "' ");
                }

                if (dtoProblemaSolucion.getTipoSolucion() != null) {
                    agregarProblemaSolucion = true;
                    cadenaProblema.append(" AND PRO.TSOC_OID_TIPO_SOLU = " + dtoProblemaSolucion.getTipoSolucion() + " ");
                }

                if (dtoProblemaSolucion.getDescripcionSolucion() != null) {
                    agregarProblemaSolucion = true;
                    cadenaProblema.append(" AND PRO.DES_SOLU LIKE '" + dtoProblemaSolucion.getDescripcionSolucion() + "' ");
                }

                if (dtoProblemaSolucion.getSolucion() != null) {
                    agregarProblemaSolucion = true;
                    cadenaProblema.append(" AND PRO.IND_SOLU = " + (dtoProblemaSolucion.getSolucion().booleanValue() ? 1 : 0) + " ");
                }

                if (agregarProblemaSolucion) {
                    selectFrom.append("       , MAE_CLIEN_PROBL PRO ");
                    where.append(" AND C.OID_CLIE = PRO.CLIE_OID_CLIE ");
                    where.append(cadenaProblema.toString());
                }
            }

            /* Quitado por ssantana, 11/04/2006 */ 
            /* where.append(" ORDER BY 2 "); */

            selectFrom.append(where.toString());

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(selectFrom.toString(), dto);
            resultado = bs.dbService.executeStaticQuery(queryStr);
            UtilidadesLog.debug("resultado: " + resultado.toString());
        } catch (CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException me) {
            me.printStackTrace();
            throw me;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (resultado.esVacio()) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info(" DAOMAEMaestroClientes.buscarClientes(DTOCliente): Salida");

        return new DTOSalida(resultado);
    }

    private boolean validarArraysDTOCliente(DTOCliente dto) {
        UtilidadesLog.info(" DAOMAEMaestroClientes.validarArraysDTOCliente(DTOCliente): Entrada");
        boolean aux = true;

        DTOCrearClienteBasico dtoBase = dto.getBase();

        if (dtoBase != null) {
            aux = (((dtoBase.getIdentificaciones() == null) || (dtoBase.getIdentificaciones().length < 2)) && ((dtoBase.getDirecciones() == null) || (dtoBase.getDirecciones().length < 2)) && ((dtoBase.getMarcas() == null) || (dtoBase.getMarcas().length < 2)) && ((dtoBase.getClasificaciones() == null) || (dtoBase.getClasificaciones().length < 2)));
        }
        
        UtilidadesLog.info(" DAOMAEMaestroClientes.validarArraysDTOCliente(DTOCliente): Salida");
        return (aux && ((dto.getVinculos() == null) || (dto.getVinculos().length < 2)) && ((dto.getPreferencias() == null) || (dto.getPreferencias().length < 2)) && ((dto.getObservaciones() == null) || (dto.getObservaciones().length < 2)) && ((dto.getTarjetas() == null) || (dto.getTarjetas().length < 2)) && ((dto.getPsicografias() == null) || (dto.getPsicografias().length < 2)));
    }

    public Boolean tieneClienteTipo(Long cliente, Long tipo) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.tieneClienteTipo(cliente, tipo): Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT OID_CLIE_TIPO_SUBT  ");
            query.append(" FROM MAE_CLIEN_TIPO_SUBTI ");
            query.append(" WHERE TICL_OID_TIPO_CLIE = " + tipo.longValue() + " ");
            query.append(" AND CLIE_OID_CLIE = " + cliente.longValue() + " ");
            bs = BelcorpService.getInstance();

            resultado = bs.dbService.executeStaticQuery(query.toString());
            
            if (resultado.esVacio()) {
                UtilidadesLog.info(" DAOMAEMaestroClientes.tieneClienteTipo(cliente, tipo): Salida");
                return new Boolean(false);
            } else {
                UtilidadesLog.info(" DAOMAEMaestroClientes.tieneClienteTipo(cliente, tipo): Salida");
                return new Boolean(true);
            }
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida busquedaRapida(DTOBusquedaRapidaCliente dto) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.busquedaRapida(DTOBusquedaRapidaCliente): Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        DTOSalida sl = new DTOSalida();

        try {
            bs = UtilidadesEJB.getBelcorpService();

            StringBuffer query = new StringBuffer();
            String whereStr;

            //mamontie 10/06/05 distinct agregue por los duplicados
            query.append(" SELECT distinct c.OID_CLIE OID, c.COD_CLIE, c.VAL_NOM1, c.VAL_NOM2, c.VAL_APE1, c.VAL_APE2 ");
            query.append("   FROM MAE_CLIEN c, MAE_CLIEN_IDENT i ");
            query.append("  WHERE c.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append("    AND i.CLIE_OID_CLIE = c.OID_CLIE ");

            if (dto.getCodigoCliente() != null) {
                query.append("    AND c.COD_CLIE LIKE '" + dto.getCodigoCliente() + "' ");
            }

            if ((dto.getNombre1() != null) && (!dto.getNombre1().equals(""))) {
                //query.append(" and c.VAL_NOM1 LIKE '" + dto.getNombre1() + "' ");
                query.append(" AND UPPER(c.VAL_NOM1) LIKE UPPER('" + dto.getNombre1() + "') "); //inc. 14014                
            }

            if ((dto.getNombre2() != null) && (!dto.getNombre2().equals(""))) {
                //query.append(" and c.VAL_NOM2 LIKE '" + dto.getNombre2() + "' ");
                query.append(" AND UPPER(c.VAL_NOM2) LIKE UPPER('" + dto.getNombre2() + "') "); //inc. 14014               
            }

            if ((dto.getApellido1() != null) && (!dto.getApellido1().equals(""))) {
                //query.append(" and c.VAL_APE1 LIKE '" + dto.getApellido1() + "' ");
                query.append(" AND UPPER(c.VAL_APE1) LIKE UPPER('" + dto.getApellido1() + "') "); //inc. 14014                               
            }

            if ((dto.getApellido2() != null) && (!dto.getApellido2().equals(""))) {
                //query.append(" and c.VAL_APE2 LIKE '" + dto.getApellido2() + "' ");
                query.append(" AND UPPER(c.VAL_APE2) LIKE UPPER('" + dto.getApellido2() + "') "); //inc. 14014                                               
            }

            if (dto.getCriterioBusqueda1() != null) {
                query.append("    AND c.VAL_CRIT_BUS1 LIKE '" + dto.getCriterioBusqueda1() + "' ");
            }

            if (dto.getCriterioBusqueda2() != null) {
                query.append("    AND c.VAL_CRIT_BUS2 LIKE '" + dto.getCriterioBusqueda2() + "' ");
            }

            if (dto.getDocumentoIdentidad() != null) {
                //query.append("    AND i.NUM_DOCU_IDEN = " + dto.getDocumentoIdentidad() );
                query.append("    AND i.NUM_DOCU_IDEN LIKE '" + dto.getDocumentoIdentidad() + "' ");
            }
            

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);

            resultado = bs.dbService.executeStaticQuery(queryStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (resultado.esVacio()) {
            UtilidadesLog.debug("####### EL RESULTADO ES VACIO ######");
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        sl.setResultado(resultado);
        UtilidadesLog.info(" DAOMAEMaestroClientes.busquedaRapida(DTOBusquedaRapidaCliente): Salida");

        return sl;
    }

    public DTOSalida buscarClientesParaCurso(DTOBuscarClientesCursos dto) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.buscarClientesParaCurso(DTOBuscarClientesCursos): Entrada");

        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            /*mdolce 12/03/2007 Incidencia Produccion  SiCC 20070102*/
            query.append("SELECT distinct a.oid_clie OID, ");
            query.append("		 (select i.VAL_I18N ");
            query.append("          from V_GEN_I18N_SICC i ");
            query.append("		   where i.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
            query.append("		     and i.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append("			 and i.VAL_OID = c.TICL_OID_TIPO_CLIE) as tipocliente, ");
            query.append("  	 (select i.VAL_I18N ");
            query.append("		    from V_GEN_I18N_SICC i ");
            query.append("		   where i.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
            query.append("		     and i.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append("			 and i.VAL_OID = c.SBTI_OID_SUBT_CLIE) as subtipocliente, ");
            query.append("		 a.cod_clie AS codigo, ");
            query.append("		 a.val_ape1 AS apellido1, a.val_ape2 AS apellido2, ");
            query.append("		 a.val_apel_casa AS apellidocasada, a.val_nom1 AS nombre1, ");
            query.append("		 a.val_nom2 AS nombre2, a.val_trat AS trato, ");
            query.append("		 a.cod_sexo AS sexo, ");
            query.append("		 (select i.VAL_I18N ");
            query.append("		    from V_GEN_I18N_SICC i ");
            query.append("		   where i.ATTR_ENTI = 'SEG_NACIO' ");
            query.append("		     and i.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append("		     and i.VAL_OID = b.SNON_OID_NACI) as nacionalidad, ");
            query.append("		 b.val_edad AS edad, ");
            query.append("		 c.SBTI_OID_SUBT_CLIE AS oidSubtipoCliente ");
            query.append("	FROM mae_clien a, mae_clien_datos_adici b, ");
            query.append("		 mae_clien_tipo_subti c, mae_clien_unida_admin d, ");
            query.append("		 cra_perio e, zon_terri_admin f,");
            query.append("		 zon_terri k, zon_secci g, ");
            query.append("		 zon_zona h, zon_regio i, ");
            query.append("		 zon_sub_geren_venta j, "); /*vca_zon_terri l,*/
            query.append("		  vca_zon_zona n, ");/*vca_zon_secci m,*/
            query.append("		 vca_zon_regio o, vca_zon_sub_geren_venta p,");
            query.append("		 vca_seg_marca q, vca_seg_canal r ");
            query.append(" WHERE A.oid_clie > " + dto.getIndicadorSituacion());

            if ((dto.getCodigo() != null) && !(dto.getCodigo().equals(""))) {
                query.append("   AND a.COD_CLIE = '" + dto.getCodigo() + "' ");
            }

            query.append("   AND b.clie_oid_clie = a.oid_clie ");
            query.append("   AND c.clie_oid_clie = b.clie_oid_clie ");
            query.append("   AND d.clie_oid_clie = c.clie_oid_clie ");
            query.append("   AND d.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("   AND e.oid_peri = d.perd_oid_peri_ini ");
            query.append("   AND e.pais_oid_pais = " + dto.getOidPais());

            if (dto.getMarca() != null) {
                query.append("   AND e.marc_oid_marc  = " + dto.getMarca());
            }

            if (dto.getCanal() != null) {
                query.append("   AND e.cana_oid_cana = " + dto.getCanal());
            }

            query.append("   AND f.oid_terr_admi = d.ztad_oid_terr_admi ");

            if (dto.getTerritorio() != null) {
                query.append("   AND f.terr_oid_terr = " + dto.getTerritorio());
            }

            if (dto.getSeccion() != null) {
                query.append("   AND f.zscc_oid_secc = " + dto.getSeccion());
            }

            query.append("   AND f.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND k.oid_terr = f.terr_oid_terr ");
            query.append("   AND k.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND g.oid_secc = f.zscc_oid_secc ");

            if (dto.getZona() != null) {
                query.append("   AND g.zzon_oid_zona = " + dto.getZona());
            }

            query.append("   AND g.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND g.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("   AND h.oid_zona = g.zzon_oid_zona ");

            if (dto.getRegion() != null) {
                query.append("   AND h.zorg_oid_regi = " + dto.getRegion());
            }

            query.append("   AND h.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND h.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("   AND i.oid_regi = h.zorg_oid_regi ");

            if (dto.getSubgerencia() != null) {
                query.append("   AND i.zsgv_oid_subg_vent = " + dto.getSubgerencia());
            }

            query.append("   AND i.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND i.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("   AND j.oid_subg_vent = i.zsgv_oid_subg_vent ");
            query.append("   AND j.pais_oid_pais = e.pais_oid_pais ");
            query.append("   AND j.marc_oid_marc = e.marc_oid_marc ");
            query.append("   AND j.cana_oid_cana = e.cana_oid_cana ");
            query.append("   AND j.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND j.ind_acti = " + ConstantesCMN.VAL_TRUE);
         /*   query.append("   AND l.oid_terr = k.oid_terr ");
            query.append("   AND l.cod_usua = '" + this.usuario + "'");
            query.append("   AND m.oid_secc = g.oid_secc ");
            query.append("   AND m.cod_usua = '" + this.usuario + "'");*/
            query.append("   AND n.oid_zona = h.oid_zona ");
            query.append("   AND n.cod_usua = '" + this.usuario + "'");
            query.append("   AND o.oid_regi = i.oid_regi ");
            query.append("   AND o.cod_usua = '" + this.usuario + "'");
            query.append("   AND p.oid_subg_vent = j.oid_subg_vent ");
            query.append("   AND p.cod_usua = '" + this.usuario + "'");
            query.append("   AND q.oid_marc = e.marc_oid_marc ");
            query.append("   AND q.cod_usua = '" + this.usuario + "'");
            query.append("   AND r.oid_cana = e.cana_oid_cana ");
            query.append("   AND r.cod_usua = '" + this.usuario + "'");
            query.append("ORDER BY a.oid_clie ");

            bs = BelcorpService.getInstance();

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
            resultado = bs.dbService.executeStaticQuery(queryStr);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        
        if (!resultado.esVacio()) {
            dtos.setResultado(resultado);
        } else {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info(" DAOMAEMaestroClientes.buscarClientesParaCurso(DTOBuscarClientesCursos): Salida");

        return dtos;
    }

    /* que arma el where*/
    private String armarWhere(DTOBusquedaRapidaCliente dto) {
        UtilidadesLog.info(" DAOMAEMaestroClientes.armarWhere(DTOBusquedaRapidaCliente): Entrada");
        StringBuffer query = new StringBuffer();
        String[] camposWhere = new String[] {
            "c.PAIS_OID_PAIS", "c.COD_CLIE", "c.VAL_CRIT_BUS1",
            "c.VAL_CRIT_BUS2", "i.NUM_DOCU_IDEN"
        };

        Object[] valoresWhere = new Object[] {
            dto.getOidPais(), dto.getCodigoCliente(), dto.getCriterioBusqueda1(),
            dto.getCriterioBusqueda2(), dto.getDocumentoIdentidad()
        };

        boolean[] operadores = new boolean[] { false, false, false, false, false };
        UtilidadesLog.info(" DAOMAEMaestroClientes.armarWhere(DTOBusquedaRapidaCliente): Salida"); 
        return UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere, operadores);
    }

    private DTOCliente armaDTOCLiente() {
        UtilidadesLog.info(" DAOMAEMaestroClientes.armaDTOCLiente(): Entrada"); 
        DTOCliente dto = new DTOCliente();
        dto.setOidIdioma(new Long(1));
        dto.setCriterioBusqueda1("1");
        dto.setCriterioBusqueda2("1");
        dto.setFechaNacimiento(new java.sql.Date(1));
        dto.setCodigoEmpleado("1");
        dto.setNacionalidad(new Long(1));
        dto.setEstadoCivil(new Long(1));
        dto.setOcupacion("1");
        dto.setProfesion("1");
        dto.setCentroTrabajo("1");
        dto.setCargo("1");
        dto.setNivelEstudios(new Long(1));
        dto.setCentroEstudios("1");
        dto.setNumeroHijos(new Byte("1"));
        dto.setPersonasDependientes(new Byte("1"));
        dto.setNSEP(new Long(1));
        dto.setCicloVida(new Long(1));
        dto.setDeseaCorrespondencia(Boolean.TRUE);
        dto.setImporteIngresos(new Double(1));
        dto.setFechaPrimerContacto(new java.sql.Date(1));

        //dto.setFechaPrimerPedidoContactado(new java.sql.Date(1));
        dto.setFechaSiguienteContacto(new java.sql.Date(1));
        dto.setTipoContacto("1");
        dto.setTipoClienteContactado(new Long(1));
        dto.setClienteContactado("1");
        dto.setPaisContactado(new Long(1));

        DTOCrearClienteBasico dcb = new DTOCrearClienteBasico();
        dcb.setCodigoCliente("1");
        dcb.setApellido1("1");
        dcb.setApellido2("1");
        dcb.setApellidoCasada("1");
        dcb.setNombre1("1");
        dcb.setNombre2("1");
        dcb.setTratamiento("1");
        dcb.setSexo("1");
        dcb.setFechaIngreso(new java.sql.Date(1));
        dcb.setFormaPago(new Long(1));

        DTOTipoSubtipoCliente dts = new DTOTipoSubtipoCliente();
        dts.setTipo(new Long(1));
        dts.setSubtipo(new Long(1));

        DTOTipoSubtipoCliente[] dts1 = new DTOTipoSubtipoCliente[1];
        dts1[0] = dts;
        dcb.setTiposSubtipos(dts1);

        DTOIdentificacion dti = new DTOIdentificacion();
        dti.setTipoDocumento(new Long(1));
        dti.setNumeroDocumento("1");
        dti.setIndPersonaEmpresa("1");
        dti.setEsPrincipal(Boolean.TRUE);

        DTOIdentificacion[] dti1 = new DTOIdentificacion[1];
        dti1[0] = dti;
        dcb.setIdentificaciones(dti1);

        DTODireccion dtd = new DTODireccion();
        dtd.setTipoDireccion(new Long(1));
        dtd.setTipoVia(new Long(1));
        /*
         * V-PED001 - dmorello, 06/10/2006
         * Cambio el tipo de numeroPrincipal de Integer a String
         */
        //dtd.setNumeroPrincipal(new Integer(1));
        dtd.setNumeroPrincipal("");
        dtd.setCodigoPostal("1");
        /*dtd.setInterior(new Integer(1));
        dtd.setManzana(new Integer(1));
        dtd.setLote(new Integer(1));
        dtd.setKilometro(new Integer(1));*/
        dtd.setObservaciones("1");
        dtd.setEsDireccionPrincipal(Boolean.TRUE);
        dtd.setNombreVia("1");

        DTODireccion[] dtd1 = new DTODireccion[1];
        dtd1[0] = dtd;
        dcb.setDirecciones(dtd1);

        DTOClienteMarca dtm = new DTOClienteMarca();
        dtm.setMarca(new Long(1));

        DTOClienteMarca[] dtm1 = new DTOClienteMarca[1];
        dtm1[0] = dtm;
        dcb.setMarcas(dtm1);

        DTOClasificacionCliente dtc = new DTOClasificacionCliente();
        dtc.setMarca(new Long(1));
        dtc.setCanal(new Long(1));
        dtc.setClasificacion(new Long(1));
        dtc.setTipoClasificacion(new Long(1));

        DTOClasificacionCliente[] dtc1 = new DTOClasificacionCliente[1];
        dtc1[0] = dtc;
        dcb.setClasificaciones(dtc1);

        DTOVinculo dtv = new DTOVinculo();
        dtv.setFechaDesde(new java.sql.Date(1));
        dtv.setFechaHasta(new java.sql.Date(1));
        dtv.setTipo(new Long(1));
        dtv.setPrincipal(Boolean.TRUE);
        dtv.setPais(new Long(1));
        dtv.setCodigoCliente("1");

        DTOVinculo[] dtv1 = new DTOVinculo[1];
        dtv1[0] = dtv;
        dto.setVinculos(dtv1);

        DTOPreferencia dtpr = new DTOPreferencia();
        dtpr.setTipo(new Long(1));

        DTOPreferencia[] dtpr1 = new DTOPreferencia[1];
        dtpr1[0] = dtpr;
        dto.setPreferencias(dtpr1);

        DTOComunicacion dtco = new DTOComunicacion();
        dtco.setTipoComunicacion(new Long(1));
        dtco.setTextoComunicacion("1");
        dtco.setHoraDesde(new Long(1));
        dtco.setHoraHasta(new Long(1));
        dtco.setDiaComunicacion(new Character("a".charAt(0)));
        dtco.setIntervaloComunicacion(Boolean.TRUE);
        dtco.setPrincipal(Boolean.TRUE);

        DTOComunicacion[] dtco1 = new DTOComunicacion[1];
        dtco1[0] = dtco;
        dto.setComunicaciones(dtco1);

        DTOTarjeta dttar = new DTOTarjeta();
        dttar.setTipo(new Long(1));
        dttar.setClase(new Long(1));
        dttar.setBanco(new Long(1));

        DTOTarjeta[] dttar1 = new DTOTarjeta[1];
        dttar1[0] = dttar;
        dto.setTarjetas(dttar1);

        DTOProblemaSolucion dttps = new DTOProblemaSolucion();
        dttps.setSolucion(Boolean.TRUE);
        dttps.setTipoProblema(new Long(1));
        dttps.setNegocio("1");
        dttps.setDescripcionProblema("1");

        DTOProblemaSolucion[] dttps1 = new DTOProblemaSolucion[1];
        dttps1[0] = dttps;
        dto.setProblemasSoluciones(dttps1);

        dto.setBase(dcb);

        return dto;
    }

    private Long booleanALong(Boolean b) {
        if (b.booleanValue()) {
            return new Long(1);
        }

        return new Long(0);
    }

    /***************************MAIN************************/
    public static void main(String[] args) {
        UtilidadesLog.info("Main start");

        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes("usuario1");

        try {
            dao.obtenerUnidadAdministrativa(new Long(1), new Long(2));

            //      UtilidadesLog.info(dao.tieneClienteTipo(new Long(2456),new Long(1)));
            //      UtilidadesLog.info(dao.buscarClientes(new Long(2456),new Long(1)));
            DTOCrearClienteBasico a = new DTOCrearClienteBasico();
            DTOTipoSubtipoCliente[] e = new DTOTipoSubtipoCliente[1];
            a.setTiposSubtipos(e);

            DTOTarjeta[] m = new DTOTarjeta[1];
            DTOCliente mm = new DTOCliente();
            mm.setBase(a);
            mm.setTarjetas(m);
            mm.setOidIdioma(new Long(1));

            DTOOID d = new DTOOID();
            d.setOid(new Long(2330));

            DTOCliente dto = dao.obtenerCliente(d);
            DTOProblemaSolucion[] dd = dto.getProblemasSoluciones();
            DTOProblemaSolucion ff = dd[0];
            ff.setSolucion(null);
            ff.setNegocio(null);
            ff.setDescripcionProblema(null);
            ff.setTipoProblema(null);
            dd[0] = ff;
            dto.setProblemasSoluciones(dd);

            DTOSalida salida = dao.buscarClientes(dto);

            //            DTOSalida salida = dao.buscarClientes(dao.armaDTOCLiente());
        } catch (MareException mareException) {
            mareException.printStackTrace();
        }

        UtilidadesLog.info("Main end");
    }

    public static DTOSalida listaClientesPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.listaClientesPais(DTOBelcorp): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();

            query.append("SELECT a.oid_clie, a.val_nom1 || ' ' || a.val_ape1 || ' ' || a.val_ape2");
            query.append("  FROM mae_clien a,");
            query.append("       mae_clien_tipo_subti c,");
            query.append("       mae_tipo_clien t,");
            query.append("       mae_clien_datos_adici adic");
            query.append(" WHERE c.ticl_oid_tipo_clie = t.oid_tipo_clie");
            query.append("   AND a.oid_clie = c.clie_oid_clie ");
            query.append("	 AND a.oid_clie = adic.clie_oid_clie");
            query.append("   AND t.cod_tipo_clie = '" + ConstantesMAE.TIPO_CLIENTE_CONSULTORA + "'");
            query.append("   AND a.pais_oid_pais = " + dto.getOidPais());
            query.append("   AND adic.ind_acti = 1 ");
            query.append(" ORDER BY 1 ");

            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!resultado.esVacio()) {
            dtos.setResultado(resultado);
        } else {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info(" DAOMAEMaestroClientes.listaClientesPais(DTOBelcorp): Salida"); 
        return dtos;
    }

    public Long obtenerOidCliente(Long pais, String codCliente) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerOidCliente(pais, codCliente): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            query.append("  SELECT oid_clie  ");
            query.append("    FROM mae_clien  ");
            query.append("   WHERE cod_clie = '" + codCliente + "'");
            query.append("     AND pais_oid_pais = " + pais);

            bs = BelcorpService.getInstance();

            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (resultado.esVacio()) {
                UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerOidCliente(pais, codCliente): Salida"); 
                return null;
            } else {
                UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerOidCliente(pais, codCliente): Salida"); 
                return new Long(((BigDecimal) resultado.getValueAt(0, 0)).longValue());
            }
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public String obtenerDireccion(DTOOID oid) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerDireccion(DTOOID): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT v1.VAL_I18N, v2.VAL_I18N, val_nomb_via, num_ppal, ");
            query.append(" val_inte, val_manz, val_lote, val_km, val_cod_post ");
            query.append(" FROM mae_clien_direc, v_gen_i18n_sicc v1, v_gen_i18n_sicc v2 ");
            query.append(" WHERE oid_clie_dire = " + oid.getOid() + " ");
            query.append(" AND ind_elim = 0 "); //agregado por Sapaza, incidencia V_MAE_08
            query.append(" AND v1.ATTR_ENTI = 'MAE_TIPO_DIREC' ");
            query.append(" AND v1.ATTR_NUM_ATRI = 1 ");
            query.append(" AND v1.IDIO_OID_IDIO = " + oid.getOidIdioma() + " ");
            query.append(" AND v1.VAL_OID = mae_clien_direc.TIDC_OID_TIPO_DIRE ");
            query.append(" AND v2.ATTR_ENTI = 'SEG_TIPO_VIA' ");
            query.append(" AND v2.ATTR_NUM_ATRI = 1 ");
            query.append(" AND v2.IDIO_OID_IDIO =" + oid.getOidIdioma() + " ");
            query.append(" AND v2.VAL_OID = mae_clien_direc.TIVI_OID_TIPO_VIA ");

            bs = BelcorpService.getInstance();

            resultado = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerDireccion(DTOOID): Salida"); 

            return resultado.getValueAt(0, 0).toString() + " " + resultado.getValueAt(0, 1).toString() + " " + resultado.getValueAt(0, 2).toString() + " " + ((BigDecimal) resultado.getValueAt(0, 3)).intValue() + " " + ((BigDecimal) resultado.getValueAt(0, 4)).intValue() + " " + ((BigDecimal) resultado.getValueAt(0, 5)).intValue() + " " + ((BigDecimal) resultado.getValueAt(0, 6)).intValue() + " " + ((BigDecimal) resultado.getValueAt(0, 7)).intValue() + " " + resultado.getValueAt(0, 8).toString();
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida buscarClientesBloqueoFinanciero(DTOBuscarClienteBloqueo criterios) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.buscarClientesBloqueoFinanciero(DTOBuscarClienteBloqueo): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            // SPLATAS - DBLG700000226 - 16/11/2006
            query.append("SELECT DISTINCT(c.oid_clie), c.cod_clie, c.val_nom1, c.val_nom2, c.val_ape1, c.val_ape2, b.VAL_MOTI_BLOQ, b.OBS_BLOQ ");
            
            query.append("  FROM mae_clien c, ");
            query.append("       mae_clien_bloqu b, ");
            query.append("       mae_tipo_bloqu t, ");
            query.append("       mae_clien_ident i, ");
            query.append("       mae_clien_datos_adici adi ");
            query.append(" WHERE b.clie_oid_clie = c.oid_clie ");
            query.append("   AND t.oid_tipo_bloq = b.tibq_oid_tipo_bloq ");
            query.append("   AND t.cod_tipo_bloq = '" + ConstantesMAE.BLOQUEO_FINANCIERO + "'");
            query.append("   AND i.clie_oid_clie = c.oid_clie ");
            query.append("   AND c.pais_oid_pais = " + criterios.getOidPais());
            query.append("   AND adi.clie_oid_clie = c.oid_clie ");
            query.append("   AND adi.ind_acti = 1 ");

            if (criterios.getDocumentoIdentificacion() != null) {
                query.append("   AND i.num_docu_iden = '" + criterios.getDocumentoIdentificacion() + "'");
            }

            if (criterios.getCodigo() != null) {
                query.append("   AND c.cod_clie = '" + criterios.getCodigo() + "'");
            }

            if (criterios.getNombre1() != null) {
                query.append("   AND c.val_nom1 LIKE '" + criterios.getNombre1() + "'");
            }

            if (criterios.getNombre2() != null) {
                query.append("   AND c.val_nom2 LIKE '" + criterios.getNombre2() + "'");
            }

            if (criterios.getApellido1() != null) {
                query.append("   AND c.val_ape1 LIKE '" + criterios.getApellido1() + "'");
            }

            if (criterios.getApellido2() != null) {
                query.append("   AND c.val_ape2 LIKE '" + criterios.getApellido2() + "'");
            }

            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info(" DAOMAEMaestroClientes.buscarClientesBloqueoFinanciero(DTOBuscarClienteBloqueo): Salida"); 
        return new DTOSalida(resultado);
    }

    public RecordSet obtenerTiposDireccionCliente(DTOOID cliente) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerTiposDireccionCliente(DTOOID): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT DISTINCT d.oid_clie_dire, i.val_i18n ");  // Inc. BELC300023518
            //query.append(" SELECT DISTINCT d.tidc_oid_tipo_dire, i.val_i18n ");            
            query.append("           FROM mae_clien_direc d, v_gen_i18n_sicc i ");
            query.append("          WHERE d.clie_oid_clie = " + cliente.getOid());
            query.append("            AND d.ind_elim = 0 "); //agregado por Sapaza, incidencia V_MAE_08
            query.append("            AND d.tidc_oid_tipo_dire = i.val_oid ");
            query.append("            AND i.attr_enti = 'MAE_TIPO_DIREC' ");
            query.append("            AND i.attr_num_atri = 1 ");
            query.append("            AND i.idio_oid_idio = " + cliente.getOidIdioma());
            query.append("	ORDER BY 2 ");

            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerTiposDireccionCliente(DTOOID): Salida"); 

        return resultado;
    }

    public DTOUnidadAdministrativa obtenerUnidadAdministrativa(Long cliente, Long periodo) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerUnidadAdministrativa(cliente, periodo): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        DTOUnidadAdministrativa dtoS = new DTOUnidadAdministrativa();

        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT distinct sub.PAIS_OID_PAIS, sub.MARC_OID_MARC, sub.CANA_OID_CANA, OID_SUBG_VENT,   ");
            query.append(" OID_REGI, OID_ZONA, OID_SECC, TERR_OID_TERR, t.COD_NSE1, t.COD_NSE2, t.COD_NSE3,  ");
            query.append(" OID_TERR_ADMI,pi.FEC_INIC,unid.PERD_OID_PERI_INI,unid.PERD_OID_PERI_FIN  ");
            query.append(" FROM MAE_CLIEN_UNIDA_ADMIN unid,  ");
            query.append("   ZON_TERRI_ADMIN tadm,    ");
            query.append(" 	 ZON_TERRI t,   ");
            query.append(" 	 ZON_SECCI,   ");
            query.append(" 	 ZON_ZONA,    ");
            query.append(" 	 ZON_REGIO,  ");
            query.append(" 	 ZON_SUB_GEREN_VENTA sub,  ");
            query.append("   CRA_PERIO pi,   ");
            query.append(" 	 CRA_PERIO pi2  ");
            query.append(" WHERE  ");
            query.append(" unid.CLIE_OID_CLIE = " + cliente);
            query.append(" AND ZTAD_OID_TERR_ADMI = OID_TERR_ADMI  ");
            query.append(" AND TERR_OID_TERR = OID_TERR  ");
            query.append(" AND ZSCC_OID_SECC = OID_SECC  ");
            query.append(" AND ZZON_OID_ZONA= OID_ZONA  ");
            query.append(" AND ZORG_OID_REGI = OID_REGI  ");
            query.append(" AND ZSGV_OID_SUBG_VENT = OID_SUBG_VENT   ");
            query.append(" AND unid.PERD_OID_PERI_INI = pi.OID_PERI  ");
            query.append(" AND pi.FEC_INIC <= (SELECT FEC_INIC FROM CRA_PERIO WHERE OID_PERI = " + periodo + ")");
            query.append(" AND ((unid.PERD_OID_PERI_FIN = pi2.OID_PERI   ");
            query.append("     AND pi2.FEC_FINA >= (SELECT FEC_FINA FROM CRA_PERIO WHERE OID_PERI = " + periodo + "))");
            query.append(" OR unid.PERD_OID_PERI_FIN is NULL)  ");
            query.append(" order by pi.FEC_INIC desc  ");

            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (resultado.esVacio()) {
            UtilidadesLog.info("DAOMAEMaestroClientes.obtenerUnidadAdministrativa(cliente, periodo): Salida"); 
            return null;
        } else {
            dtoS.setNSE1(objToString(resultado.getValueAt(0, "COD_NSE1")));
            dtoS.setNSE2(objToString(resultado.getValueAt(0, "COD_NSE2")));
            dtoS.setNSE3(objToString(resultado.getValueAt(0, "COD_NSE3")));
            dtoS.setOidCanal(objToLong(resultado.getValueAt(0, "CANA_OID_CANA")));
            dtoS.setOidMarca(objToLong(resultado.getValueAt(0, "MARC_OID_MARC")));
            dtoS.setOidPais(objToLong(resultado.getValueAt(0, "PAIS_OID_PAIS")));
            dtoS.setOidRegion(objToLong(resultado.getValueAt(0, "OID_REGI")));
            dtoS.setOidSeccion(objToLong(resultado.getValueAt(0, "OID_SECC")));
            dtoS.setOidSGV(objToLong(resultado.getValueAt(0, "OID_SUBG_VENT")));
            dtoS.setOidTerritorio(objToLong(resultado.getValueAt(0, "TERR_OID_TERR")));
            dtoS.setOidTerritorioAdministrativo(objToLong(resultado.getValueAt(0, "OID_TERR_ADMI")));
            dtoS.setOidZona(objToLong(resultado.getValueAt(0, "OID_ZONA")));
            
            UtilidadesLog.info("DAOMAEMaestroClientes.obtenerUnidadAdministrativa(cliente, periodo): Salida"); 

            return dtoS;
        }
    }

    public boolean estaClienteBloqueado(Long cliente, String tipoBloqueo) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.estaClienteBloqueado(cliente, tipoBloqueo): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            UtilidadesLog.info("Este es el cliente: " + cliente);
            UtilidadesLog.info("Este es el Tbloqueo: " + tipoBloqueo);
            query.append(" SELECT OID_BLOQ ");
            query.append(" FROM MAE_CLIEN_BLOQU JOIN MAE_TIPO_BLOQU ON (TIBQ_OID_TIPO_BLOQ = OID_TIPO_BLOQ ) ");
            query.append(" WHERE CLIE_OID_CLIE = " + cliente);

            if ((tipoBloqueo != null) && (!tipoBloqueo.equals(""))) {
                query.append(" AND COD_TIPO_BLOQ = '" + tipoBloqueo + "' ");
            }

            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info("Este es el resultado: " + resultado);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!resultado.esVacio()) {
            UtilidadesLog.info("DAOMAEMaestroClientes.estaClienteBloqueado(cliente, tipoBloqueo): Salida"); 
            return true;
        } else {
            UtilidadesLog.info("DAOMAEMaestroClientes.estaClienteBloqueado(cliente, tipoBloqueo): Salida"); 
            return false;
        }
    }

    public DTOSalida obtieneClienteSubtiposAptas(Long oid) throws MareException {
        /*    Se ejecuta la query:

        SELECT sbti_oid_subt_clie oidSubtipoCliente

        FROM mae_clien_tipo_subti

        WHERE clie_oid_clie = oid (parámetro entrada)

        La query devuelve:
        oidSubtipoCliente  */
        UtilidadesLog.info("DAOMAEMaestroClientes.obtieneClienteSubtiposAptas(oid): Entrada"); 
        RecordSet resultado = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();

        try {
            query.append("   SELECT sbti_oid_subt_clie oidsubtipocliente   ");
            query.append("     FROM mae_clien_tipo_subti ");
            query.append("    WHERE clie_oid_clie = " + oid);

            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(resultado);
        UtilidadesLog.info("DAOMAEMaestroClientes.obtieneClienteSubtiposAptas(oid): Salida"); 

        return dtoSalida;
    }

    public DTOSalida obtieneClientesAsignarAptas(DTOClientesAsignarAptas dto) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtieneClientesAsignarAptas(DTOClientesAsignarAptas): Entrada"); 
        RecordSet resultado = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();

        try {
            query.append("  SELECT Distinct a.oid_clie oidcliente, a.fec_ingr fechaingreso,               ");
            query.append("         p.oid_peri periodoprimercontacto, e.terr_oid_terr territorio, ");
            query.append("         f.oid_secc seccion, g.oid_zona zona, h.oid_regi region,       ");
            query.append("         h.zsgv_oid_subg_vent subgerencia,  ");
            query.append("         i.tibq_oid_tipo_bloq bloqueofinanciero, j.esta_oid_esta_clie estatus,  ");
            query.append("         k.ticl_oid_tipo_clie tipocliente, k.sbti_oid_subt_clie subtipocliente, ");
            query.append("         l.clas_oid_clas clasificacion, l.tccl_oid_tipo_clasi tipoclasificacion ");
            query.append("    FROM mae_clien a,  ");
            query.append("         mae_clien_prime_conta b, ");
            query.append("         cra_perio p, ");
            query.append("         mae_clien_unida_admin c, ");
            query.append("         cra_perio d, ");
            query.append("         zon_terri_admin e, ");
            query.append("         zon_secci f,  ");
            query.append("         zon_zona g, ");
            query.append("         zon_regio h, ");
            query.append("         mae_clien_bloqu i, ");
            query.append("         mae_clien_datos_adici j, ");
            query.append("         mae_clien_tipo_subti k, ");
            query.append("         mae_clien_clasi l,  ");
            query.append("         vca_seg_pais m,  ");
            query.append("         vca_seg_marca n,  ");
            query.append("         vca_seg_canal o  ");
            query.append("   WHERE a.pais_oid_pais = " + dto.getOidPais());
            query.append("     AND b.clie_oid_clie (+) = a.oid_clie  ");
            query.append("     AND p.oid_peri(+) = b.perd_oid_peri  ");
            query.append("     AND p.pais_oid_pais(+) = " + dto.getOidPais());
            query.append("     AND p.marc_oid_marc(+) = " + dto.getMarca());
            query.append("     AND p.cana_oid_cana(+) = " + dto.getCanal());
            query.append("     AND c.clie_oid_clie = a.oid_clie ");
            query.append("   AND d.oid_peri = c.perd_oid_peri_ini ");
            query.append("   AND d.pais_oid_pais = " + dto.getOidPais());
            query.append("   AND d.marc_oid_marc = " + dto.getMarca());
            query.append("   AND d.cana_oid_cana = " + dto.getCanal());
            query.append("   AND e.oid_terr_admi = c.ztad_oid_terr_admi ");
            query.append("   AND e.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND f.oid_secc = e.zscc_oid_secc ");
            query.append("   AND f.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND f.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("   AND g.oid_zona = f.zzon_oid_zona ");
            query.append("   AND g.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND g.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("   AND c.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("   AND h.oid_regi = g.zorg_oid_regi ");
            query.append("   AND h.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("   AND h.ind_acti = " + ConstantesCMN.VAL_TRUE);

            //Inc. 17666 - rgiorgi - 4/5/2005
            query.append(" 	 AND i.clie_oid_clie(+) = a.oid_clie ");

            //query.append(" 	 AND i.tibq_oid_tipo_bloq(+) <> " + ConstantesMAE.OID_BLOQUEO_FINANCIERO + " ");
            query.append(" 	 AND a.oid_clie not in (select distinct clie_oid_clie from mae_clien_bloqu where tibq_oid_tipo_bloq = " + ConstantesMAE.OID_BLOQUEO_FINANCIERO + ")");

            //            query.append(" 	 AND ((i.clie_oid_clie = a.oid_clie AND i.tibq_oid_tipo_bloq <> " + ConstantesMAE.ESTATUS_EGRESADA +") OR (i.clie_oid_clie <> a.oid_clie)) ");
            query.append("   AND j.clie_oid_clie = a.oid_clie ");
            query.append("   AND j.ind_acti = " + ConstantesCMN.VAL_TRUE);

            //ESTO HAY QUE PREGUNTAR!!!!!!!!!!!!!  constantesmae.oid_estatus_egresada
            query.append("   AND j.esta_oid_esta_clie <>  " + ConstantesMAE.ESTATUS_EGRESADA);
            query.append("   AND k.clie_oid_clie = a.oid_clie ");
            
            // Comentado para que al momento de obtener los candidatos de aptos
            // a cursos, se consideren no solo los tipos y clasificaciones
            // principales
            // Rafael Romero (2007-01-13) V-EDU-03
            //query.append("   AND k.ind_ppal = 1 ");
            //query.append("   AND l.ind_ppal = 1 ");
            
            query.append("   AND l.ctsu_oid_clie_tipo_subt = k.oid_clie_tipo_subt ");
            query.append("   AND m.oid_pais =  " + dto.getOidPais());
            query.append("   AND m.cod_usua = '" + this.usuario + "' ");
            query.append("   AND n.oid_marc =  " + dto.getMarca());
            query.append("   AND n.cod_usua = '" + this.usuario + "' ");
            query.append("   AND o.oid_cana =  " + dto.getCanal());
            query.append("   AND o.cod_usua = '" + this.usuario + "' ");
            query.append("   AND c.IND_ACTI = 1 "); 

            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(resultado);
        UtilidadesLog.info("DAOMAEMaestroClientes.obtieneClientesAsignarAptas(DTOClientesAsignarAptas): Salida"); 

        return dtoSalida;
    }


    public int obtieneClientesAsignarAptas(MatrizCursosLocal obj, DTOClientesAsignarAptas dto, Long oidAsigna) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtieneClientesAsignarAptas(MatrizCursosLocal obj, DTOClientesAsignarAptas dto, Long oidAsigna): Entrada"); 
        int resultado = -1;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        SimpleDateFormat sdFecha = new SimpleDateFormat("yyyyMMdd");
        try {
            query.append("INSERT ALL ");
            query.append("      INTO edu_aptas_asign ");
            query.append("           (oid_apta_asig, num_conv, clie_oid_clie, asap_oid_asig, ");
            query.append("            sbti_oid_subt_clie, ind_apta, ind_data_mart, FEC_ULTI_ACTU ");
            query.append("           ) ");
            query.append("    VALUES (edu_apas_seq.NEXTVAL, num_conv, clie_oid_clie, asap_oid_asig, ");
            query.append("            sbti_oid_subt_clie, ind_apta, ind_data_mart, FEC_ULTI_ACTU ");
            query.append("           ) ");
            query.append("SELECT DISTINCT ");
            query.append("	   			1 NUM_CONV, ");
            query.append("	   			a.oid_clie CLIE_OID_CLIE, ");
            query.append("				"+oidAsigna+" ASAP_OID_ASIG, ");
            query.append("				k.sbti_oid_subt_clie SBTI_OID_SUBT_CLIE, ");
            query.append("				1 IND_APTA, ");
            query.append("				1 IND_DATA_MART, ");
            query.append("				SYSDATE FEC_ULTI_ACTU ");
            query.append("           FROM mae_clien a, ");
            query.append("                mae_clien_prime_conta b, ");
            query.append("                cra_perio p, ");
            query.append("                mae_clien_unida_admin c, ");
            query.append("                cra_perio d, ");
            query.append("                zon_terri_admin e, ");
            query.append("                zon_secci f, ");
            query.append("                zon_zona g, ");
            query.append("                zon_regio h, ");
            query.append("                mae_clien_bloqu i, ");
            query.append("                mae_clien_datos_adici j, ");
            query.append("                mae_clien_tipo_subti k, ");
            query.append("                mae_clien_clasi l ");
            query.append("          WHERE a.pais_oid_pais = " + dto.getOidPais());
            query.append("            AND b.clie_oid_clie (+) = a.oid_clie  ");
            query.append("            AND p.oid_peri(+) = b.perd_oid_peri  ");
            query.append("            AND p.pais_oid_pais(+) = " + dto.getOidPais());
            query.append("            AND p.marc_oid_marc(+) = " + dto.getMarca());
            query.append("            AND p.cana_oid_cana(+) = " + dto.getCanal());
            query.append("            AND c.clie_oid_clie = a.oid_clie ");
            query.append("            AND d.oid_peri = c.perd_oid_peri_ini ");
            query.append("            AND d.pais_oid_pais = " + dto.getOidPais());
            query.append("            AND d.marc_oid_marc = " + dto.getMarca());
            query.append("            AND d.cana_oid_cana = " + dto.getCanal());
            query.append("            AND e.oid_terr_admi = c.ztad_oid_terr_admi ");
            query.append("            AND e.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("            AND f.oid_secc = e.zscc_oid_secc ");
            query.append("            AND f.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("            AND f.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("            AND g.oid_zona = f.zzon_oid_zona ");
            query.append("            AND g.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("            AND g.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("            AND c.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("            AND h.oid_regi = g.zorg_oid_regi ");
            query.append("            AND h.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append("            AND h.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append("            AND i.clie_oid_clie(+) = a.oid_clie ");
            query.append("            AND NOT EXISTS (SELECT clie_bloq.clie_oid_clie ");
            query.append("							           FROM mae_clien_bloqu clie_bloq ");
            query.append("							          WHERE clie_bloq.clie_oid_clie = a.oid_clie ");
            query.append("							                AND tibq_oid_tipo_bloq = " + ConstantesMAE.OID_BLOQUEO_FINANCIERO + ") ");
            query.append("            AND j.clie_oid_clie = a.oid_clie ");
            query.append("            AND j.ind_acti = " + ConstantesCMN.VAL_TRUE + " ");
            query.append("            AND j.esta_oid_esta_clie <>  " + ConstantesMAE.ESTATUS_EGRESADA + " ");
            query.append("            AND k.clie_oid_clie = a.oid_clie ");
            query.append("            AND l.ctsu_oid_clie_tipo_subt = k.oid_clie_tipo_subt ");
            query.append("            AND c.ind_acti = 1 ");
			/*
			Control de morosidad:
			Si es distinto de nulo en la matriz del curso   
			Valores: 0(No hay control) / 1 (Hay control) 
			*/ 
            if(obj.isControlMorosidad()!=null){
                int controlMorosidad = 0;
                if(obj.isControlMorosidad().booleanValue()){
                    controlMorosidad = 1;
                }
                query.append("			AND NVL2(i.tibq_oid_tipo_bloq,"+controlMorosidad+",0)=0 ");
            }
			/*
			Validacion de estatus
			Si es distinto de nulo en la matriz del curso
			Se compara con el campo 
			*/
            if(obj.getStatusCliente()!=null){
                query.append("			AND j.esta_oid_esta_clie = "+obj.getStatusCliente()+" ");
            }
			/*
			Validacion de carrera
			Se valida por separado cada un do los 4 siguientes:
			Tipo 
			Subtipo 
			Clasificacion 
			TipoClasificacion
			 
			TIPO
			Si es distinto de nulo en la matriz del curso
			Se compara con el campo
			*/
            if(obj.getTipoCliente()!=null){
                query.append("			AND k.ticl_oid_tipo_clie = "+obj.getTipoCliente()+" ");
            }
			/*
			SUBTIPO 
			Si es distinto de nulo en la matriz del curso
			Se compara con el campo
			*/
            if(obj.getSubtipoCliente()!=null){
                query.append("			AND k.sbti_oid_subt_clie = "+obj.getSubtipoCliente()+" ");
            }
			/*
			CLASIFICACION 
			Si es distinto de nulo en la matriz del curso
			Se compara con el campo
			*/
            if(obj.getClasificacion()!=null){
                query.append("			AND l.clas_oid_clas = "+obj.getClasificacion()+" ");
            }
			/*
			TIPOCLASIFICACION 
			Si es distinto de nulo en la matriz del curso
			Se compara con el campo 
			*/
            if(obj.getTipoClasificacion()!=null){
                query.append("			AND l.tccl_oid_tipo_clasi = "+obj.getTipoClasificacion()+" ");
            }
			/*
			Validacion de Unidad Administrativa 
			Si el objeto Boolean alcance (isAlcance) no es nulo y es falso
			Se avalua uno a uno los siguientes:
			Territorio 
			Seccion 
			Zona 
			Region 
			Subgerencia 
			*/
            if((obj.isAlcance()!=null)&&!obj.isAlcance().booleanValue()){
                /*
                TERRITORIO 
                Si es distinto de nulo en la matriz del curso 
                Se compara con el campo 
                */
                if(obj.getTerritorio()!=null){
                    query.append("			AND e.terr_oid_terr = "+obj.getTerritorio()+" ");
                }
                /*
                SECCION 
                Si es distinto de nulo en la matriz del curso 
                Se compara con el campo 
                */
                if(obj.getSeccion()!=null){
                    query.append("			AND f.oid_secc = "+obj.getSeccion()+" ");
                }
                /*
                ZONA 
                Si es distinto de nulo en la matriz del curso 
                Se compara con el campo 
                */
                if(obj.getZona()!=null){
                    query.append("			AND g.oid_zona = "+obj.getZona()+" ");
                }
                /*
                REGION
                Si es distinto de nulo en la matriz del curso 
                Se compara con el campo 
                */
                if(obj.getRegion()!=null){
                    query.append("			AND h.oid_regi = "+obj.getRegion()+" ");
                }
                /*
                SUBGERENCIA 
                Si es distinto de nulo en la matriz del curso 
                Se compara con el campo 
                */
                if(obj.getSubgerencia()!=null){
                    query.append("			AND h.zsgv_oid_subg_vent = "+obj.getSubgerencia()+" ");
                }
            }
			/* 
			Cursos exigidos para el presente curso 
			No deben existir cursos exigidos que no existan en los llevados 
			*/
            query.append("  			AND NOT EXISTS ( ");
            query.append("			SELECT ticu_oid_tipo_curs ");
            query.append("			           FROM edu_matri_curso_exigi exig ");
            query.append("			          WHERE exig.mcur_oid_curs = "+obj.getOid()+" ");
            query.append("			            AND NOT EXISTS ( ");
            query.append("			                   SELECT matrizcursos.ticu_oid_tipo_curs ");
            query.append("			                     FROM edu_aptas_curso aptas, edu_matri_curso matrizcursos ");
            query.append("			                    WHERE aptas.clie_oid_clie = a.oid_clie ");
            query.append("			                      AND aptas.ind_asis <> "+ConstantesEDU.NO_ASIS+" ");
            query.append("			                      AND matrizcursos.ticu_oid_tipo_curs = exig.ticu_oid_tipo_curs) ");
            query.append("			            AND NOT EXISTS ( ");
            query.append("			                   SELECT matrizcursos.ticu_oid_tipo_curs ");
            query.append("			                     FROM edu_histo_curso historicocursos, ");
            query.append("			                          edu_matri_curso matrizcursos ");
            query.append("			                    WHERE historicocursos.clie_oid_clie = a.oid_clie ");
            query.append("			                      AND historicocursos.mcur_oid_curs = matrizcursos.oid_curs ");
            query.append("			                      AND matrizcursos.ticu_oid_tipo_curs = exig.ticu_oid_tipo_curs) ");
            query.append("			) ");
			/*
			Validacion de constancia 
			Si PeriodoIniConstancia y PeriodoFinConstancia son distintos de nulo en la matriz del curso 
			Tambien se verifica que Numero de ordenes no sea nulo en la matriz del curso
			
			Si el numero de pedidos totales comprendidos en los periodos incluidos los extremos no supera 
			el numero de ordenes indicadas en la matriz del curso 
			*/
            if((obj.getPeriodoIniConstancia()!=null) && (obj.getPeriodoFinConstancia()!=null) && (obj.getNumeroOrdenes()!=null)){
                query.append("			AND (SELECT COUNT(pedido.oid_soli_cabe) NUMERPED ");
                query.append("				  FROM ped_solic_cabec pedido ");
                query.append("				 WHERE clie_oid_clie = a.oid_clie ");
                query.append("				   AND perd_oid_peri IN ( ");
                query.append("				        SELECT peri.oid_peri OID_PERI ");
                query.append("				            FROM cra_perio peri, ");
                query.append("				                 (SELECT pais_oid_pais pais, marc_oid_marc marca, ");
                query.append("				                         cana_oid_cana canal ");
                query.append("				                    FROM cra_perio ");
                query.append("				                   WHERE oid_peri = "+obj.getPeriodoIniConstancia()+") x ");
                query.append("				           WHERE peri.fec_inic >= (SELECT fec_inic ");
                query.append("				                                     FROM cra_perio ");
                query.append("				                                    WHERE oid_peri = "+obj.getPeriodoIniConstancia()+") ");
                query.append("				             AND peri.fec_fina <= (SELECT fec_fina ");
                query.append("				                                     FROM cra_perio ");
                query.append("				                                    WHERE oid_peri = "+obj.getPeriodoFinConstancia()+") ");
                query.append("				             AND pais_oid_pais = x.pais ");
                query.append("				             AND marc_oid_marc = x.marca ");
                query.append("				             AND cana_oid_cana = x.canal) ");
                query.append("				   AND ind_oc = 1) >= "+obj.getNumeroOrdenes()+" ");
            }
			/*
			Validacion de ventas 
			Si PeriodoIniComparativo y PeriodoFinComparativo son distintos de nulo en la matriz del curso 
			Tambien se verifica que MontoVentas no sea nulo en la matriz del curso
			
			Si el numero de pedidos totales comprendidos en los periodos incluidos los extremos no supera 
			el numero de ordenes indicadas en la matriz del curso 
			*/
            if((obj.getPeriodoIniComparativo()!=null) && (obj.getPeriodoFinComparativo()!=null) && (obj.getMontoVentas()!=null)){
                query.append("			AND (SELECT SUM (NVL(val_tota_paga_loca,0) + NVL(val_impo_impu_tota_loca,0)) suma ");
                query.append("				  FROM ped_solic_cabec ");
                query.append("				 WHERE clie_oid_clie = a.oid_clie ");
                query.append("				   AND perd_oid_peri IN ( ");
                query.append("				          SELECT peri.oid_peri OID_PERI ");
                query.append("				            FROM cra_perio peri, ");
                query.append("				                 (SELECT pais_oid_pais pais, marc_oid_marc marca, ");
                query.append("				                         cana_oid_cana canal ");
                query.append("				                    FROM cra_perio ");
                query.append("				                   WHERE oid_peri = "+obj.getPeriodoIniComparativo()+") x ");
                query.append("				           WHERE peri.fec_inic >= (SELECT fec_inic ");
                query.append("				                                     FROM cra_perio ");
                query.append("				                                    WHERE oid_peri = "+obj.getPeriodoIniComparativo()+") ");
                query.append("				             AND peri.fec_fina <= (SELECT fec_fina ");
                query.append("				                                     FROM cra_perio ");
                query.append("				                                    WHERE oid_peri = "+obj.getPeriodoFinComparativo()+") ");
                query.append("				             AND pais_oid_pais = x.pais ");
                query.append("				             AND marc_oid_marc = x.marca ");
                query.append("				             AND cana_oid_cana = x.canal)) >= "+obj.getMontoVentas()+" ");
            }
			/*
			Validacion de Ingreso 
			
			Se hacen las validaciones siguientes
			Periodo 
			Fecha de ingreso 
			Numero de campañas
			Ultimo curso 
			*/
            /*
			PERIODO
			Si PeriodoIngreso no es nulo se verifica periodo 
			*/
            if(obj.getPeriodoIngreso()!=null){
                query.append("			AND NVL(p.oid_peri,-1) = "+obj.getPeriodoIngreso()+" ");
            }
			/*
			FECHA DE INGRESO 
			Si FechaIngreso no es nula en la matriz de curso se hace la comparacion con el campo
			Debe crearse el objeto fechaCurso de comparacion de acurdo al formato de fecha  ********
			*/
            if(obj.getFechaIngreso()!=null){
                query.append("			AND TRUNC(NVL(a.fec_ingr,SYSDATE)) = TRUNC(TO_DATE('"+sdFecha.format(new java.util.Date(obj.getFechaIngreso().getTime()))+"','YYYYMMDD')) ");
            }
			/*
			NUMERO DE CAMPAÑAS  
			Si NumeroCampanyas no es nulo en la matriz y el campo periodo no es nulo 
            
            Se consideran validos aquellos cuya cantidad de campañas es igual a la solicitada
			*/
            if(obj.getNumeroCampanyas()!=null){
                query.append("			AND p.oid_peri IS NOT NULL ");
                query.append("			AND ( ");
                query.append("				SELECT COUNT (peri.oid_peri) tot_campanias ");
                query.append("				  FROM cra_perio peri, cra_perio peri2 ");
                query.append("				 WHERE peri2.oid_peri = p.oid_peri ");
                query.append("				   AND peri.pais_oid_pais = peri2.pais_oid_pais ");
                query.append("				   AND peri.marc_oid_marc = peri2.marc_oid_marc ");
                query.append("				   AND peri.cana_oid_cana = peri2.cana_oid_cana ");
                query.append("				   AND peri.fec_inic >= peri2.fec_inic ");
                query.append("				   AND peri.fec_fina <= ");
                query.append("				          (SELECT MAX (pp.fec_fina) ");
                query.append("				             FROM cra_perio pp ");
                query.append("				            WHERE TRUNC (pp.fec_inic) <= TRUNC (SYSDATE) ");
                query.append("				              AND TRUNC (SYSDATE) <= TRUNC (pp.fec_fina) ");
                query.append("				              AND pp.pais_oid_pais = peri2.pais_oid_pais ");
                query.append("				              AND pp.marc_oid_marc = peri2.marc_oid_marc ");
                query.append("				              AND pp.cana_oid_cana = peri2.cana_oid_cana) ");
                query.append("			) = "+obj.getNumeroCampanyas()+" ");
            }
			/*
			ULTIMO CURSO 
			Se valida que la matriz especifique fecha de UltimoCurso
            */
            if(obj.getFechaUltimo()!=null){
                String fecha = sdFecha.format(new java.util.Date(obj.getFechaUltimo().getTime()));
                /*
                Los cursos llevados despues de la fecha de UltimoCurso de la Matriz de cursos deben ser CERO
                */
                query.append("			AND (SELECT COUNT (OID_APTA) ");
                query.append("				  FROM edu_aptas_curso ");
                query.append("				 WHERE clie_oid_clie = a.oid_clie ");
                query.append("				   AND ind_asis <> 0 ");
                query.append("				   AND TRUNC (fec_asis) > TRUNC (TO_DATE ('"+fecha+"', 'YYYYDDMM')))+ ");
                query.append("				(SELECT COUNT (OID_HIST) ");
                query.append("				  FROM edu_histo_curso ");
                query.append("				 WHERE clie_oid_clie = a.oid_clie ");
                query.append("				   AND TRUNC (fec_asis) > TRUNC (TO_DATE ('"+fecha+"', 'YYYYDDMM'))) ");
                query.append("			 = 0 ");
                /*
                Debe por lo menos haber llevado cursos 
                */
                query.append("			AND (SELECT COUNT (OID_APTA) ");
                query.append("				  FROM edu_aptas_curso ");
                query.append("				 WHERE clie_oid_clie = a.oid_clie ");
                query.append("				   AND ind_asis <> "+ConstantesEDU.NO_ASIS+")+ ");
                query.append("				(SELECT COUNT (OID_HIST) ");
                query.append("				  FROM edu_histo_curso ");
                query.append("				 WHERE clie_oid_clie = a.oid_clie) ");
                query.append("			> 0 ");
            }
			/*
			Validacion de No este en el curso
			
			Para llevar un curso no debe estar inscrito en el mismo 
			*/
            query.append("			AND NOT EXISTS ( ");
            query.append("				SELECT 1 ");
            query.append("				FROM EDU_APTAS_CURSO ");
            query.append("				WHERE MCUR_OID_CURS = "+obj.getOid()+" ");
            query.append("				AND CLIE_OID_CLIE = a.oid_clie ");
            query.append("				) ");


            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeUpdate(query.toString());
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMAEMaestroClientes.obtieneClientesAsignarAptas(MatrizCursosLocal obj, DTOClientesAsignarAptas dto, Long oidAsigna): Salida"); 

        return resultado;
    }




    /**
     * @Autor: Hugo Andrés Mansi
     * @Fecha : 04/10/2004
     * @Recibe: un DTOBuscarClienteBloqueo
     * @Retorna: un DTOSalida con el resultado de la consulta
     * @Descripción: Busca los clientes que no tengan BLOQUEO_FINANCIERO.Es decir,
     *               cuyo MAE_TIPO_BLOQU.COD_TIPO_BLOQU <> MAEConstantes.BLOQUEO_FINANCIERO (02)
     *               o bien que no haya ningún registro para el cliente en la tabla MAE_CLIEN_BLOQU.
     */
    public DTOSalida buscarClientesDesbloqueoFinanciero(DTOBuscarClienteBloqueo criterio) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.buscarClientesDesbloqueoFinanciero(DTOBuscarClienteBloqueo): Entrada"); 
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet resultado = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        UtilidadesLog.debug("DTO----<> " + criterio);
        StringBuffer query = new StringBuffer();

        /*    query.append(" SELECT temp.OID_CLIE OID, temp.COD_CLIE, temp.VAL_NOM1, ");
            query.append(" temp.VAL_NOM2, temp.VAL_APE1, temp.VAL_APE2 ");
            query.append(" FROM (SELECT c.OID_CLIE, c.COD_CLIE, c.VAL_NOM1, ");
            query.append(" c.VAL_NOM2, c.VAL_APE1, c.VAL_APE2 , adi.IND_ACTI, ");
            query.append(" i.NUM_DOCU_IDEN ");
            query.append(" FROM MAE_CLIEN c, MAE_CLIEN_BLOQU b,MAE_TIPO_BLOQU t,MAE_CLIEN_IDENT i, ");
            query.append(" MAE_CLIEN_DATOS_ADICI adi ");
            query.append(" WHERE c.PAIS_OID_PAIS =  " + criterio.getOidPais());
            query.append(" AND b.CLIE_OID_CLIE (+)= c.OID_CLIE ");
            query.append(" AND i.CLIE_OID_CLIE (+)= c.OID_CLIE ");
            query.append(" AND t.OID_TIPO_BLOQ = b.TIBQ_OID_TIPO_BLOQ ");
            query.append(" AND adi.CLIE_OID_CLIE (+)= c.OID_CLIE ");
            query.append(" AND t.COD_TIPO_BLOQ NOT LIKE '" + ConstantesMAE.BLOQUEO_FINANCIERO + "' ");
            query.append(" AND adi.IND_ACTI = 1 "); //Solo tenemos en cuenta clientes activos

            if (criterio.getDocumentoIdentificacion() != null) {
                query.append(" AND i.NUM_DOCU_IDEN LIKE '" + criterio.getDocumentoIdentificacion() + "' ");
            }

            if (criterio.getCodigo() != null) {
                query.append(" AND c.COD_CLIE LIKE '" + criterio.getCodigo() + "' ");
            }

            if (criterio.getNombre1() != null) {
                query.append(" AND c.VAL_NOM1 LIKE '" + criterio.getNombre1() + "' ");
            }

            if (criterio.getNombre2() != null) {
                query.append(" AND c.VAL_NOM2 LIKE '" + criterio.getNombre2() + "'");
            }

            if (criterio.getApellido1() != null) {
                query.append(" AND c.VAL_APE1 LIKE '" + criterio.getApellido1() + "' ");
            }

            if (criterio.getApellido2() != null) {
                query.append(" AND c.VAL_APE2 LIKE '" + criterio.getApellido2() + "' ");
            }

            query.append(" UNION SELECT c.OID_CLIE, c.COD_CLIE, c.VAL_NOM1, c.VAL_NOM2, ");
            query.append(" c.VAL_APE1, c.VAL_APE2, adi.IND_ACTI, i.NUM_DOCU_IDEN ");
            query.append(" FROM MAE_CLIEN c, MAE_CLIEN_BLOQU b ,MAE_CLIEN_IDENT i, MAE_CLIEN_DATOS_ADICI adi ");
            query.append(" WHERE c.OID_CLIE <> b.CLIE_OID_CLIE ");
            query.append(" AND c.PAIS_OID_PAIS = " + criterio.getOidPais());
            query.append(" AND i.CLIE_OID_CLIE (+)= c.OID_CLIE ");
            query.append(" AND adi.CLIE_OID_CLIE (+)= c.OID_CLIE ");
            query.append(" AND adi.IND_ACTI= 1 "); //Solo tenemos en cuenta clientes activos

            if (criterio.getDocumentoIdentificacion() != null) {
                query.append(" AND i.NUM_DOCU_IDEN LIKE '" + criterio.getDocumentoIdentificacion() + "' ");
            }

            if (criterio.getCodigo() != null) {
                query.append(" AND c.COD_CLIE LIKE '" + criterio.getCodigo() + "' ");
            }

            if (criterio.getNombre1() != null) {
                query.append(" AND c.VAL_NOM1 LIKE '" + criterio.getNombre1() + "' ");
            }

            if (criterio.getNombre2() != null) {
                query.append(" AND c.VAL_NOM2 LIKE '" + criterio.getNombre2() + "' ");
            }

            if (criterio.getApellido1() != null) {
                query.append(" AND c.VAL_APE1 LIKE '" + criterio.getApellido1() + "' ");
            }

            if (criterio.getApellido2() != null) {
                query.append(" AND c.VAL_APE2 LIKE '" + criterio.getApellido2() + "') temp");
            } else {
                query.append(" ) temp");
            }*/

        //        query.append(" SELECT * ");
        //        query.append(" FROM (SELECT   temp.oid_clie OID, temp.cod_clie, temp.val_nom1, ");
        
        // SPLATAS - DBLG700000226 - 16/11/2005
        query.append(" SELECT  DISTINCT(temp.oid_clie) OID, temp.cod_clie, temp.val_nom1, ");
        query.append(" temp.val_nom2, temp.val_ape1, temp.val_ape2, temp.VAL_MOTI_BLOQ, temp.OBS_BLOQ ");

        query.append(" FROM (SELECT c.oid_clie, c.cod_clie, c.val_nom1, c.val_nom2, ");
        query.append(" c.val_ape1, c.val_ape2, adi.ind_acti, ");
        
        // SPLATAS - DBLG700000226 - 16/11/2005
        query.append(" i.num_docu_iden, b.VAL_MOTI_BLOQ, b.OBS_BLOQ ");
        query.append(" FROM mae_clien c, ");
        query.append(" mae_clien_bloqu b, ");
        query.append(" mae_tipo_bloqu t, ");
        query.append(" mae_clien_ident i, ");
        query.append(" mae_clien_datos_adici adi ");
        query.append(" WHERE c.pais_oid_pais = " + criterio.getOidPais());
        query.append(" AND b.clie_oid_clie(+) = c.oid_clie ");
        query.append(" AND i.clie_oid_clie(+) = c.oid_clie ");
        query.append(" AND t.oid_tipo_bloq(+) = b.tibq_oid_tipo_bloq ");
        query.append(" AND adi.clie_oid_clie(+) = c.oid_clie ");
        query.append(" AND ( t.cod_tipo_bloq NOT LIKE '" + ConstantesMAE.BLOQUEO_FINANCIERO + "' OR t.cod_tipo_bloq IS NULL) ");
        query.append(" AND adi.ind_acti = 1 ");

        if (criterio.getDocumentoIdentificacion() != null) {
            query.append(" AND i.NUM_DOCU_IDEN = '" + criterio.getDocumentoIdentificacion() + "' ");
        }

        if (criterio.getCodigo() != null) {
            query.append(" AND c.COD_CLIE = '" + criterio.getCodigo() + "' ");
        }

        if (criterio.getNombre1() != null) {
            query.append(" AND c.VAL_NOM1 LIKE '" + criterio.getNombre1() + "' ");
        }

        if (criterio.getNombre2() != null) {
            query.append(" AND c.VAL_NOM2 LIKE '" + criterio.getNombre2() + "'");
        }

        if (criterio.getApellido1() != null) {
            query.append(" AND c.VAL_APE1 LIKE '" + criterio.getApellido1() + "' ");
        }

        if (criterio.getApellido2() != null) {
            query.append(" AND c.VAL_APE2 LIKE '" + criterio.getApellido2() + "') temp");
        } else {
            query.append(" ) temp");
        }

        query.append(" ORDER BY OID ");

        //        query.append(" WHERE ROWNUM <= 10 AND OID > 0 ");
        try {
            bs = BelcorpService.getInstance();

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), criterio.getIndicadorSituacion().intValue(), criterio.getTamanioPagina().intValue());
            resultado = bs.dbService.executeStaticQuery(queryStr);

            dtoSalida.setResultado(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMAEMaestroClientes.buscarClientesDesbloqueoFinanciero(DTOBuscarClienteBloqueo): Salida"); 

        return dtoSalida;
    }

    private String objToString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }

    private Long objToLong(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return new Long(obj.toString());
        }
    }

    /**
    * @author mbobadill
    * @date 11/01/05
    * Obtiene los distintos canales asociados a un cliente por las unidades administrativas.
    * @param dto
    * @return
    * @throws es.indra.mare.common.exception.MareException
    */
    public DTOSalida obtenerCanalesClienteUnidadAdministrativa(DTOCodigoCliente dto) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerCanalesClienteUnidadAdministrativa(DTOCodigoCliente): Entrada"); 
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet resultado = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT DISTINCT  ");
        query.append(" C.cana_oid_cana as oid, D.VAL_I18N AS Descripcion  ");
        query.append(" from mae_clien A,  mae_clien_unida_admin B, cra_perio C,V_GEN_I18N_SICC D ");
        query.append(" where ");
        query.append(" A.cod_clie = '" + dto.getCodigoCliente() + "'" + "AND ");
        query.append(" B.clie_oid_clie = A.oid_clie  ");
        query.append(" and B.ind_acti = " + ConstantesCMN.VAL_TRUE + " AND ");
        query.append(" C.oid_peri = B.perd_oid_peri_ini ");
        query.append(" and D.ATTR_ENTI ='SEG_CANAL' ");
        query.append(" AND D.IDIO_OID_IDIO = 1 ");
        query.append(" AND  D.val_oid = C.cana_oid_cana ");

        try {
            bs = BelcorpService.getInstance();

            resultado = bs.dbService.executeStaticQuery(query.toString());

            dtoSalida.setResultado(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerCanalesClienteUnidadAdministrativa(DTOCodigoCliente): Salida"); 
        return dtoSalida;
    }

    /**
    * @author mbobadill
    * @date 11/05/01
    * Obtiene las distintas marcas asociadas a un cliente por las unidades administrativas
    * @param dto
    * @return
    * @throws es.indra.mare.common.exception.MareException
    */
    public DTOSalida obtenerMarcasClienteUnidadAdministrativa(DTOCodigoCliente dto) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerMarcasClienteUnidadAdministrativa(DTOCodigoCliente): Entrada"); 
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet resultado = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();
        query.append(" SELECT DISTINCT  ");
        query.append(" C.marc_oid_marc as oid,D.des_marc as descripcion  ");
        query.append(" from mae_clien A,  mae_clien_unida_admin B, cra_perio C,seg_marca D ");
        query.append(" where ");
        query.append(" A.cod_clie = '" + dto.getCodigoCliente() + "'" + "AND ");
        query.append(" B.clie_oid_clie = A.oid_clie  ");
        query.append(" and B.ind_acti = " + ConstantesCMN.VAL_TRUE + " AND ");
        query.append(" C.oid_peri = B.perd_oid_peri_ini ");
        query.append(" and D.oid_marc =C.marc_oid_marc ");

        try {
            bs = BelcorpService.getInstance();

            resultado = bs.dbService.executeStaticQuery(query.toString());

            dtoSalida.setResultado(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerMarcasClienteUnidadAdministrativa(DTOCodigoCliente): Salida"); 

        return dtoSalida;
    }

    public DTOSalida consultarGerenteZona(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.consultarGerenteZona(DTOOID): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;

        query.append(" SELECT B.cod_clie as codCliente, ");
        query.append(" B.val_nom1 as nombre1, ");
        query.append(" B.val_nom2 as nombre2, ");
        query.append(" B.val_ape1 as apellido1, ");
        query.append(" B.val_ape2 as apellido2 ");

        query.append(" FROM zon_zona A, ");
        query.append(" mae_clien B ");

        query.append(" WHERE A.oid_zona = " + dto.getOid() + " AND ");
        query.append(" B.oid_clie (+) = A.clie_oid_clie ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMAEMaestroClientes.consultarGerenteZona(DTOOID): Salida"); 

        return dtoSalida;
    }

    public DTOSalida obtenerZonaMarcaCanal(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerZonaMarcaCanal(DTOOID): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;

        query.append(" SELECT B.marc_oid_marc as oidMarca, ");
        query.append(" B.cana_oid_cana as oidCanal, ");
        query.append(" C.zzon_oid_zona as oidZona ");

        query.append(" FROM mae_clien_unida_admin A, ");
        query.append(" zon_terri_admin B, ");
        query.append(" zon_secci C ");

        query.append(" WHERE A.clie_oid_clie = " + dto.getOid() + " AND ");
        query.append(" A.ind_acti = " + ConstantesCMN.VAL_TRUE + " AND ");
        query.append(" B.oid_terr_admi = A.ztad_oid_terr_admi AND ");
        query.append(" C.oid_secc = B.zscc_oid_secc ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug("DAOMAEMaestroClientes.obtenerZonaMarcaCanal(DTOOID) : rs.esVacio = true ");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerZonaMarcaCanal(DTOOID): Salida"); 

        return dtoSalida;
    }

    /**
     * @author pperanzola
     * @date 21/02/05
     * Obtiene País,Código Cliente,Apellido 1,Apellido 2,Apellido de casada,Nombre 1,Nombre 2,Tratamiento,Fecha nacimiento,Tipo de vía
     * Nombre de la vía,Número principal,Puerta,Estatus,Indicador Activo de un cliente
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dto
     */
    public DTODatosClienteCOB consultarDatosClienteCOB(DTOString dto) throws MareException {
       UtilidadesLog.info("DAOMAEMaestroClientes.consultarDatosClienteCOB(DTOString): Entrada"); 
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        DTODatosClienteCOB dtoDatosClie = new DTODatosClienteCOB();

        query.append(" SELECT");
        query.append(" CLIENTE.COD_CLIE, CLIENTE.VAL_APE1, CLIENTE.VAL_APE2,");
        query.append(" CLIENTE.VAL_APEL_CASA, CLIENTE.VAL_NOM1, CLIENTE.VAL_NOM2,");
        query.append(" CLIENTE.VAL_TRAT, DATOS_ADICIONALES.FEC_NACI, TIPO_VIA.COD_TIPO_VIA,");
        query.append(" DIRECCION.VAL_NOMB_VIA, DIRECCION.NUM_PPAL, DIRECCION.VAL_MANZ,");
        query.append(" ESTATUS.COD_ESTA_CLIE, DATOS_ADICIONALES.IND_ACTI  ");
        query.append(" FROM");
        query.append(" MAE_CLIEN CLIENTE, ");
        query.append(" MAE_CLIEN_DIREC DIRECCION, ");
        query.append(" MAE_CLIEN_DATOS_ADICI DATOS_ADICIONALES,");
        query.append(" SEG_TIPO_VIA TIPO_VIA, ");
        query.append(" MAE_ESTAT_CLIEN ESTATUS");
        query.append(" WHERE ");
        query.append(" CLIENTE.OID_CLIE = DATOS_ADICIONALES.CLIE_OID_CLIE ");
        query.append(" AND DIRECCION.TIVI_OID_TIPO_VIA = TIPO_VIA.OID_TIPO_VIA");
        query.append(" AND DATOS_ADICIONALES.CLIE_OID_CLIE = CLIENTE.OID_CLIE");
        query.append(" AND DATOS_ADICIONALES.ESTA_OID_ESTA_CLIE = ESTATUS.OID_ESTA_CLIE");
        query.append(" AND CLIENTE.COD_CLIE = '" + dto.getCadena() + "'");
        query.append(" AND CLIENTE.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND DIRECCION.IND_DIRE_PPAL = 1");
        query.append(" AND DIRECCION.CLIE_OID_CLIE= CLIENTE.OID_CLIE");
        query.append(" AND DIRECCION.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoDatosClie.setCodigoCliente((String) rs.getValueAt(0, 0));
        dtoDatosClie.setApellido1((String) rs.getValueAt(0, 1));
        dtoDatosClie.setApellido2((String) rs.getValueAt(0, 2));
        dtoDatosClie.setApellidoCasada((String) rs.getValueAt(0, 3));
        dtoDatosClie.setNombre1((String) rs.getValueAt(0, 4));
        dtoDatosClie.setNombre2((String) rs.getValueAt(0, 5));
        dtoDatosClie.setTratamiento((String) rs.getValueAt(0, 6));
        dtoDatosClie.setFechaNacimiento((Date) rs.getValueAt(0, 7));
        dtoDatosClie.setTipoVia((String) rs.getValueAt(0, 8));
        dtoDatosClie.setNombreVia((String) rs.getValueAt(0, 9));
        
        /* V-PED001 - dmorello, 09/10/2006 - Cambia el tipo de Integer a String*/
        //dtoDatosClie.setNumeroPrincipal((rs.getValueAt(0, 10) != null) ? new Integer(rs.getValueAt(0, 10).toString()) : null);
        dtoDatosClie.setNumeroPrincipal((rs.getValueAt(0, 10) != null) ? rs.getValueAt(0, 10).toString() : null);
        
        dtoDatosClie.setPuerta((rs.getValueAt(0, 11) != null) ? ((BigDecimal) rs.getValueAt(0, 11)).toString() : null);
        dtoDatosClie.setEstatus((rs.getValueAt(0, 12) != null) ? (String) rs.getValueAt(0, 12) : null);
        dtoDatosClie.setIndicadorActivo(((rs.getValueAt(0, 13)).toString()).equals("1") ? Boolean.TRUE : Boolean.FALSE);
        UtilidadesLog.info("DAOMAEMaestroClientes.consultarDatosClienteCOB(DTOString): Salida"); 

        return dtoDatosClie;
    }

    public DTOSalida obtieneSolicitudMasAntiguaNoCancelada(DTOCodigoCliente dto) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtieneSolicitudMasAntiguaNoCancelada(DTOCodigoCliente): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;

        query.append(" SELECT   soci.cod_soci COD_SOCI, soci.val_deno SOCIEDAD, M.NUM_IDEN_CUOT , M.FEC_DOCU, M.FEC_VENC,fpago.cod_form_pago FORMA_PAGO, ");
        query.append(" M.IMP_MOVI AS MONTO, (M.IMP_MOVI - M.IMP_PAGA) AS MONTO_SALDO, tsolic.cod_tipo_soli TIPO_SOLI");
        query.append(" FROM ccc_movim_cuent_corri m, ");
        query.append(" ccc_subpr s, ");
        query.append(" ccc_proce p, ");
        query.append(" seg_socie soci, ");
        query.append(" bel_forma_pago fpago, ");
        query.append(" ped_tipo_solic_pais tsolic_pa, ");
        query.append(" ped_tipo_solic tsolic, ");
        query.append(" ped_solic_cabec solic_cab, ");
        query.append(" mae_clien cl ");
        query.append(" WHERE m.subp_oid_subp_crea = s.oid_subp ");
        query.append(" AND s.ccpr_oid_proc = p.oid_proc ");
        query.append(" AND m.subp_oid_subp_crea = 1    ");
        query.append(" AND p.cod_proc = 'CCC001' ");
        query.append(" AND m.tspa_oid_tipo_soli_pais(+) = tsolic_pa.oid_tipo_soli_pais ");
        query.append(" AND m.soci_oid_soci = soci.oid_soci(+) ");
        query.append(" AND solic_cab.tspa_oid_tipo_soli_pais = tsolic_pa.oid_tipo_soli_pais ");
        query.append(" AND solic_cab.fopa_oid_form_pago = fpago.oid_form_pago(+) ");
        query.append(" AND tsolic_pa.tsol_oid_tipo_soli = tsolic.oid_tipo_soli(+) ");
        query.append(" AND tsolic_pa.pais_oid_pais = fpago.pais_oid_pais ");
        query.append(" AND tsolic_pa.pais_oid_pais = " + dto.getOidPais() + "  ");
        query.append(" AND m.clie_oid_clie = cl.oid_clie ");
        query.append(" AND cl.cod_clie = '" + dto.getCodigoCliente() + "'  ");
        query.append(" AND (NVL (m.imp_movi, 0) - NVL (m.imp_paga, 0)) <> 0 ");
        query.append(" ORDER BY m.fec_docu DESC ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMAEMaestroClientes.obtieneSolicitudMasAntiguaNoCancelada(DTOCodigoCliente): Salida"); 

        return dtoSalida;
    }

    public Boolean obtenerDeudaCobranza(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerDeudaCobranza(oidCliente): Entrada"); 

        Boolean resultado = new Boolean(false);
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;

        query.append(" SELECT NVL(SUM(ASIGN.IMP_DEUD_ASIG) - SUM(ASIGN.IMP_DEUD_CANC),0) DEUDA ");
        query.append("  FROM COB_ASIGN_COBRA ASIGN, ccc_movim_cuent_corri movi ");
        query.append("  WHERE asign.MVCC_OID_MOVI_CC = movi.OID_MOVI_CC ");
        query.append(" AND movi.clie_oid_clie = " + oidCliente + " ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());

            if ((rs != null) && (!rs.esVacio()) && (rs.getValueAt(0, 0) != null)) {
                if (((BigDecimal) rs.getValueAt(0, 0)).compareTo(new BigDecimal(0)) > 0) {
                    resultado = new Boolean(true);
                }
            }
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerDeudaCobranza(oidCliente): Salida"); 

        return resultado;
    }

    public DTOSalida obtenerVecesEtapa(Long oidCliente, Long pais) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerVecesEtapa(oidCliente, pais): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;
        
        query.append(" SELECT DISTINCT etapa.oid_etap_deud, etapa.cod_etap_deud, ");
                        query.append(" COUNT (etapa.oid_etap_deud) ");
                   query.append(" FROM cob_asign_cobra asign, ");
                        query.append(" ccc_movim_cuent_corri movi, ");
                        query.append(" cob_crono_cobra crono_cobra, ");
                        query.append(" cob_etapa_deuda etapa, ");
			                  query.append(" mae_clien mclie ");
                  query.append(" WHERE asign.crco_oid_cron_cobr = crono_cobra.oid_cron_cobr ");
                    query.append(" AND asign.MVCC_OID_MOVI_CC = movi.OID_MOVI_CC ");
                    query.append(" AND crono_cobra.etde_oid_etap_deud = etapa.oid_etap_deud ");
		            query.append(" AND mclie.pais_oid_pais = " + pais + " ");
		            query.append(" AND mclie.OID_CLIE = " + oidCliente + " ");
               query.append(" GROUP BY etapa.cod_etap_deud, etapa.oid_etap_deud ");      

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerVecesEtapa(oidCliente, pais): Salida"); 

        return dtoSalida;
    }

    public String obtenerNombreUsuarioLargo(Long codUsuario) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerNombreUsuarioLargo(codUsuario): Entrada"); 

        String salida = new String("");
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;

        query.append(" SELECT USU.VAL_APEL_PATE || ' ' || USU.VAL_APE_MATE || ' ' || USU.VAL_NOM1 || ' ' || USU.VAL_NOM2 NOMBRE ");
        query.append(" FROM V_REP_USUAR_LARGO USU ");
        query.append(" WHERE USU.COD_USUA = " + codUsuario + " ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());

            if ((!rs.esVacio()) && (rs.getValueAt(0, 0) != null)) {
                salida = (String) rs.getValueAt(0, "NOMBRE");
            }
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerNombreUsuarioLargo(codUsuario): Salida"); 

        return salida;
    }

    public DTOSalida obtenerSolicitudesBloqueadasUltimos6Meses(Long oidCliente, Long oidIdioma) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerSolicitudesBloqueadasUltimos6Meses(oidCliente, oidIdioma): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;

        query.append(" SELECT CLIEN.OID_CLIE, ");
        query.append(" T_SOLIC.COD_TIPO_SOLI, ");
        query.append(" SOL_CAB.VAL_NUME_SOLI, ");
        query.append(" PERI.VAL_NOMB_PERI, ");
        query.append(" SOL_ENTR.FEC_DOCU, ");
        query.append(" SOL_ENTR.VAL_MONT_ORDE, ");
        query.append(" SOL_ENTR.VAL_MONT_DEUD_VENC, ");
        query.append(" DECODE(SOL_ENTR.IND_VALI_1,1,'B1 ',' ') AS VAL_1, ");
        query.append(" DECODE(SOL_ENTR.IND_VALI_2,1,'B2 ',' ') AS VAL_2, ");
        query.append(" DECODE(SOL_ENTR.IND_VALI_3,1,'B3 ',' ') AS VAL_3, ");
        query.append(" DECODE(SOL_ENTR.IND_VALI_4,1,'B4 ',' ') AS VAL_4, ");
        query.append(" USUARIO_LIBERACION.VAL_NOMB_USUA AS USUARIO, ");
        query.append(" SOL_ENTR.FEC_HORA_LIBE, ");
        query.append(" GEN_ESTADO_EVAL_AUTO.ESTADO_EVAL_AUTO, ");
        query.append(" DECODE(SOL_ENTR.IND_NOTI,1,'SI','NO') AS NOTIFICADO, ");
        query.append(" RIESGO.COD_NIVE_RIES ");
        query.append(" FROM ");
        query.append(" CAR_SOLI_ENTR_BLOQ SOL_ENTR, ");
        query.append(" PED_TIPO_SOLIC T_SOLIC, ");
        query.append(" CAR_NIVEL_RIESG RIESGO, ");
        query.append(" CRA_PERIO PERI, ");
        query.append(" MAE_CLIEN CLIEN, ");
        query.append(" MAE_CLIEN_DATOS_ADICI CLIEN_ADICI, ");
        query.append(" CAR_EJECU_CUENT EJECTA_LIBERACION, ");
        query.append(" V_REP_USUAR_LARGO USUARIO_LIBERACION, ");
        query.append(" PED_SOLIC_CABEC SOL_CAB, ");
        query.append(" CAR_CODIG_APROB COD,  ");
        query.append(" PED_ESTAD_SOLIC SOL_ESTADO, ");
        query.append(" ( ");
        query.append(" SELECT GEN.VAL_OID, GEN.VAL_I18N AS ESTADO_EVAL_AUTO ");
        query.append(" FROM V_GEN_I18N_SICC GEN ");
        query.append(" WHERE GEN.ATTR_ENTI = 'CAR_ESTAT_PEDID'  ");
        query.append(" AND GEN.IDIO_OID_IDIO = " + oidIdioma + " ");
        query.append(" ) GEN_ESTADO_EVAL_AUTO ");
        query.append(" WHERE ");
        query.append(" SOL_ENTR.PERD_OID_PERI = PERI.OID_PERI ");
        query.append(" AND SOL_ENTR.TSOL_OID_TIPO_SOLI = T_SOLIC.OID_TIPO_SOLI ");
        query.append(" AND SOL_ENTR.NIRI_OID_NIVE_RIES = RIESGO.OID_NIVE_RIES ");
        query.append(" AND SOL_ENTR.CLIE_OID_CLIE = CLIEN.OID_CLIE ");
        query.append(" AND SOL_ENTR.CLIE_OID_CLIE = CLIEN_ADICI.CLIE_OID_CLIE(+) ");
        query.append(" AND SOL_ENTR.SOCA_OID_SOLI_CABE = SOL_CAB.OID_SOLI_CABE ");
        query.append(" AND SOL_ENTR.COAP_OID_CODI_APRO = COD.OID_CODI_APRO(+) ");
        query.append(" AND SOL_CAB.ESSO_OID_ESTA_SOLI = SOL_ESTADO.OID_ESTA_SOLI ");
        query.append(" AND SOL_ENTR.ESPE_OID_ESTA_PEDI= GEN_ESTADO_EVAL_AUTO.VAL_OID(+) ");
        query.append(" AND SOL_ENTR.EJCU_OID_USUA_LIBE= EJECTA_LIBERACION.OID_EJEC_CUEN ");
        query.append(" AND EJECTA_LIBERACION.USER_EJEC_CUEN  = USUARIO_LIBERACION.COD_USUA(+) ");
        query.append(" AND PERI.FEC_INIC >= ADD_MONTHS(SYSDATE,-6) ");
        query.append(" AND PERI.FEC_FINA <= SYSDATE ");
        query.append(" AND SOL_ENTR.CLIE_OID_CLIE = " + oidCliente + " ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerSolicitudesBloqueadasUltimos6Meses(oidCliente, oidIdioma): Salida"); 

        return dtoSalida;
    }

    public DTOSalida obtenerUsuarioResponsable(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerUsuarioResponsable(DTOBelcorp): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;

        query.append(" SELECT responsable.oid_clie, ");
        query.append(" responsable.val_ape1 ");
        query.append(" || ' ' ");
        query.append(" || responsable.val_ape2 ");
        query.append(" || ' ' ");
        query.append(" || responsable.val_nom1 ");
        query.append(" || ' ' ");
        query.append(" || responsable.val_nom2 ");
        query.append(" FROM mae_clien responsable ");
        query.append(" where responsable.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" order by 2 ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerUsuarioResponsable(DTOBelcorp): Salida"); 

        return dtoSalida;
    }
    
    public DTOPeriodo obtienePrimerPeriodoCliente(java.lang.Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtienePrimerPeriodoCliente(java.lang.Long): Entrada"); 

        DTOPeriodo dtoPeriodo = new DTOPeriodo();
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;

        

        query.append(" SELECT * ");
        query.append(" FROM ");
        query.append(" ( ");
        query.append(" SELECT PERIO.OID_PERI, PERIO.PAIS_OID_PAIS, PERIO.MARC_OID_MARC, PERIO.CANA_OID_CANA, PERIO.VAL_NOMB_PERI ");
        query.append(" FROM CRA_PERIO PERIO, ");
        query.append(" MAE_CLIEN_UNIDA_ADMIN CLI_UA, ");
        query.append(" MAE_CLIEN CL ");
        query.append(" WHERE  ");
        query.append(" PERIO.FEC_INIC <= CL.FEC_INGR  ");
        query.append(" AND CL.FEC_INGR <= PERIO.FEC_FINA ");
        query.append(" AND PERIO.VAL_ESTA = 1 ");
        query.append(" AND CL.oid_clie= "+oidCliente+" ");
        query.append(" AND CLI_UA.CLIE_OID_CLIE = CL.OID_CLIE ");
        query.append(" AND PERIO.OID_PERI = CLI_UA.PERD_OID_PERI_INI ");
        query.append(" ORDER BY PERIO.FEC_INIC  ");
        query.append(" ) PERI_ACTUAL ");
        query.append(" WHERE ROWNUM = 1 ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (rs!=null && rs.getValueAt(0,0)!=null){
            dtoPeriodo.setOid(BigToLong(rs.getValueAt(0,"OID_PERI")));
            dtoPeriodo.setOidPais(BigToLong(rs.getValueAt(0,"PAIS_OID_PAIS")));
            dtoPeriodo.setMarca(BigToLong(rs.getValueAt(0,"MARC_OID_MARC")));
            dtoPeriodo.setCanal(BigToLong(rs.getValueAt(0,"CANA_OID_CANA")));
            dtoPeriodo.setNombre((String)rs.getValueAt(0,"VAL_NOMB_PERI"));
        }

        UtilidadesLog.info("DAOMAEMaestroClientes.obtienePrimerPeriodoCliente(java.lang.Long): Salida"); 

        return dtoPeriodo;
    }    
    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un Object
     * @Retorna: un Integer
     * @Descripción: transforma un objeto a Integer.
     *
     */
    private Integer BigToInteger(Object num) {
        if (num != null) {
            return (new Integer(((BigDecimal) num).intValue()));
        } else {
            return null;
        }
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un Object
     * @Retorna: un Long
     * @Descripción: transforma un objeto a long.
     *
     */
    private Long BigToLong(Object num) {
        if (num != null) {
            return (new Long(((BigDecimal) num).longValue()));
        } else {
            return null;
        }
    }    
    
    /**
     * @Autor: Pablo Perez
     * @Fecha : 28/10/2005
     * @Recibe: un Object
     * @Retorna: un Boolean
     * @Descripción: transforma un objeto a Boolean.
     */
     
    private Boolean bigToBoolean(Object num) {
        if (num != null) {
            if (((BigDecimal) num).longValue() == 1)  {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } else {
            return null;
        }
    }    
    

    /**    
     *@Author: Pablo Perez
     *@Fecha: 28/10/2005
     *@throws: MareException
     *@return: DTODireccion[]
     *@param: Long oidCliente, Long oidTipoDireccion
     *@Observaciones: Metodo creado a raiz de incidencia bloqueante de Perú. Ref: 21299
    */ 
    
    public DTODireccion[] obtenerDireccionesPorTipo(Long oidCliente, Long oidTipoDireccion, Long idioma) throws MareException{
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerDireccionesPorTipo(Long oidCliente, Long oidTipoDireccion): Entrada ");
        /*Descripción: obtiene todas las direcciones del cliente y tipo de direccion recibidos por parametro. Si el tipo es nulo retorna todas 
        las direcciones del cliente.
        
            Implementación: 
            1.- Efectuar una consulta con las siguientes caracteristicas:
            1.1.- Recuperar los datos de la entidad MAE:ClienteDireccion.(cliDire)
            1.2.- Efectuar un join con la entidad MAE:TipoDireccion(tipoDir) por: cliDire.tipoDireccion = tipoDir.oid
            1.3.- Filtrar por: cliDire.oidCliente = oidCliente
            1.4.- Si el parametro oidTipoTipoDireccion != null entonces
            Filtrar por: cliDire.tipoDireccion = oidTipoDireccion
            FSi
            1.5.- Ordenar la consulta por tipoDir.codigoTipoDireccion.
            2.- Con cada registro recuperado crear un objeto de la clase DTODireccion y agregarlo a un array de objetos de la misma clase.
            3.- Retonar el array creado en el punto anterior.
        */
        
        DTODireccion[] dtoDireccion = null;
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;
        /* Cleal - Inc. BELC300021989
        query.append("  SELECT   mdire.oid_clie_dire OID, mdire.tidc_oid_tipo_dire TIPO_DIRECCION,  ");
        query.append("           mdire.val_cod_post CODIGO_POSTAL, mdire.ind_dire_ppal DIRE_PRINCIPAL,  ");
        query.append("           mdire.val_inte INTERIOR, mdire.val_km KM, mdire.val_lote LOTE,  ");
        query.append("           mdire.val_manz MANZANA, mdire.val_nomb_via NOMBRE_VIA, mdire.num_ppal NUM_PRINCIPAL,   ");
        query.append("           mdire.val_obse OBSERVACIONES, mdire.tivi_oid_tipo_via TIPO_VIA,  ");
        query.append("           mdire.zvia_oid_via VIA, mdire.TERR_OID_TERR TERRITORIO  ");
        query.append("      FROM mae_clien_direc mdire, mae_tipo_direc mtdire  ");
        query.append("     WHERE mdire.tidc_oid_tipo_dire = mtdire.oid_tipo_dire  ");
        query.append("       AND mdire.clie_oid_clie =  " + oidCliente);
        
        */
        
       query.append("  SELECT ");
       query.append("  v.val_i18n TIPO_DIREC, ");
       query.append("  v2.val_i18n TIPO_VIA,");
	   query.append("  mdire.val_cod_post CODIGO_POSTAL,");
       query.append("  mdire.ind_dire_ppal dire_principal, ");
       query.append("  mdire.val_nomb_via NOMBRE_VIA, ");
	   query.append("  mdire.num_ppal NUM_PRINCIPAL,");
       query.append("  mdire.val_obse OBSERVACIONES, ");
       query.append("  mdire.cod_unid_geog UNID_GEO");
      query.append("  FROM mae_clien_direc mdire, v_gen_i18n_sicc v, v_gen_i18n_sicc v2");
     query.append("  WHERE 1 = 1");
       query.append("  AND mdire.clie_oid_clie = "+ oidCliente);
       query.append("  AND v.attr_enti = 'MAE_TIPO_DIREC'");
       query.append("  AND v.idio_oid_idio = "+idioma);
       query.append("  AND v.val_oid = mdire.tidc_oid_tipo_dire");
       query.append("  AND v.attr_num_atri = 1");
       query.append("  AND v2.attr_enti = 'SEG_TIPO_VIA'");
       query.append("  AND v2.idio_oid_idio = "+idioma);
       query.append("  AND v2.val_oid = mdire.tivi_oid_tipo_via");
       query.append("  AND v2.attr_num_atri = 1 ");

        if (oidTipoDireccion != null)  {
            query.append("       AND mdire.tidc_oid_tipo_dire =  " + oidTipoDireccion);
        }else{
            query.append("       AND mdire.IND_DIRE_PPAL = 1");
        }
        query.append("  AND mdire.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08        
        query.append("  ORDER BY mdire.tidc_oid_tipo_dire ASC  ");
        
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        int cantRegis = rs.getRowCount();
        dtoDireccion = new DTODireccion[cantRegis];
        
        if (rs.esVacio() && oidTipoDireccion != null) {
            //Si tengo oidTipoDireecion y no lo encuentro, lo busco sin tipo de direccion.
            UtilidadesLog.debug("obtenerDireccionesPorTipo busco nuevamente ");
            return this.obtenerDireccionesPorTipo(oidCliente, null, idioma);
        }
        
        for (int i=0;  i < cantRegis; i++)  {
            dtoDireccion[i] = new DTODireccion();
            /*mdolce - Por favor, validar campos que pueden ser nulos!!!!!!!!*/
            String codPost = (String) rs.getValueAt(i,"CODIGO_POSTAL");
            if(codPost != null){
               dtoDireccion[i].setCodigoPostal(codPost);
            }
            //dtoDireccion[i].setCodigoPostal((String) rs.getValueAt(i,"CODIGO_POSTAL"));
            //dtoDireccion[i].setEsDireccionPrincipal(bigToBoolean(rs.getValueAt(i,"DIRE_PRINCIPAL")));
            //dtoDireccion[i].setInterior(BigToInteger(rs.getValueAt(i,"INTERIOR")));
            //dtoDireccion[i].setKilometro(BigToInteger(rs.getValueAt(i,"KM")));
            //dtoDireccion[i].setLote(BigToInteger(rs.getValueAt(i,"LOTE")));
            //dtoDireccion[i].setManzana(BigToInteger(rs.getValueAt(i,"MANZANA")));
            String nombreVia = (String) rs.getValueAt(i,"NOMBRE_VIA");
            if(nombreVia != null){
               dtoDireccion[i].setNombreVia(nombreVia);
            }            
            String numPrinc = (String)rs.getValueAt(i,"NUM_PRINCIPAL");
            if (numPrinc != null) {
                /*
                 * V-PED001 - dmorello, 06/10/2006
                 * Cambio el tipo de numeroPrincipal de Integer a String
                 */
                //dtoDireccion[i].setNumeroPrincipal(new Integer(numPrinc));
                dtoDireccion[i].setNumeroPrincipal(numPrinc);
            }
            String Obs = (String) rs.getValueAt(i,"OBSERVACIONES");
            if(Obs!=null){
                dtoDireccion[i].setObservaciones(Obs);
            }
            //dtoDireccion[i].setOid(BigToLong(rs.getValueAt(i,"OID")));
            dtoDireccion[i].setTipoDireccionDescripcion((String)rs.getValueAt(i,"TIPO_DIREC"));
            dtoDireccion[i].setTipoViaDescripcion((String) rs.getValueAt(i,"TIPO_VIA"));
            dtoDireccion[i].setNombreUnidadGeografica((String)rs.getValueAt(i,"UNID_GEO"));
            UtilidadesLog.info("i: "+i+" *** dtoDireccion[i]: "+dtoDireccion[i]);
            //dtoDireccion[i].setVia(BigToLong(rs.getValueAt(i,"Tipo_Via")));
        }

        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerDireccionesPorTipo(Long oidCliente, Long oidTipoDireccion): Salida ");
        return dtoDireccion;
    }
    
    public DTOSalida recuperarDocumentos(Long oidPais, DTOColeccion dto) throws MareException{

     UtilidadesLog.info("DAOMAEMaestroClientes.recuperarDocumentos(Long oidPais):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs; 
        BelcorpService bs;
        String codigoError;
        DTOSalida dtoSal = new DTOSalida();
        ArrayList arrL = dto.getLista();
        int size = (dto.getLista()!=null)?dto.getLista().size():0;
        //Modificada por incidencia 22948
        /*query.append(" SELECT i.tdoc_oid_tipo_docu || i.num_docu_iden num, i.NUM_DOCU_IDEN numeroDocumento, c.OID_CLIE oid");
        query.append(" FROM mae_clien_ident i, mae_clien c");
        query.append(" WHERE c.oid_clie = i.CLIE_OID_CLIE");
        query.append(" AND c.pais_oid_pais = "+oidPais);*/
        
        
       query.append(" SELECT i.CLIE_OID_CLIE, clie.COD_CLIE ");
       query.append(" FROM mae_clien_ident i, mae_tipo_docum td, MAE_CLIEN clie ");
       query.append(" WHERE 1=1 ");
       query.append(" and td.OID_TIPO_DOCU = i.TDOC_OID_TIPO_DOCU and td.PAIS_OID_PAIS = " +oidPais);
       query.append(" and i.CLIE_OID_CLIE = clie.OID_CLIE");
       
       if (size>0){
            DTOIdentificacion dtoDL = (DTOIdentificacion) arrL.get(0);
            query.append(" AND ( ");
            query.append(" ("+dtoDL.getTipoDocumento()+" = i.tdoc_oid_tipo_docu and '"+dtoDL.getNumeroDocumento()+"' = i.num_docu_iden)");
       }
       for(int i=1;i<size;i++){
            DTOIdentificacion dtoDL = (DTOIdentificacion) arrL.get(i);
            query.append(" OR ");
            query.append(" ("+dtoDL.getTipoDocumento()+" = i.tdoc_oid_tipo_docu and '"+dtoDL.getNumeroDocumento()+"' = i.num_docu_iden)");
      
        }

       if (size>0){
            query.append(" )");
       } 
        
       try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        dtoSal.setResultado(rs);
        UtilidadesLog.info("DAOMAEMaestroClientes.recuperarDocumentos(Long oidPais):S");
        return dtoSal;
    }
    
   /**
    * Recupera la Unidad Administrativa activa de un cliente para el periodo que
    * se indica por parametro. Si no se encuentra una devuelve null. Se espera
    * (por lo que indica el diseno) que como maximo haya una sola unidad 
    * administrativa activa.
    * @author: Emilio Iraola
    * @date: 27/06/2006
    * @return: DTOUnidadAdministrativa
    * @param: Long oidCliente, Long oidPeriodo
    * @obs: Metodo creado a raiz de incidencia DBLG400001109
    */
    public DTOUnidadAdministrativa obtenerUAActiva(Long oidCliente, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerUAActiva(Long oidCliente, Long oidPeriodo): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        DTOUnidadAdministrativa dtoS = new DTOUnidadAdministrativa();

        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT distinct sub.PAIS_OID_PAIS, sub.MARC_OID_MARC, sub.CANA_OID_CANA, OID_SUBG_VENT, ");
            query.append("        OID_REGI, OID_ZONA, OID_SECC, TERR_OID_TERR, t.COD_NSE1, t.COD_NSE2, t.COD_NSE3, ");
            query.append("        OID_TERR_ADMI, pi.FEC_INIC, unid.PERD_OID_PERI_INI, unid.PERD_OID_PERI_FIN ");
            query.append("   FROM MAE_CLIEN_UNIDA_ADMIN unid, ");
            query.append("        ZON_TERRI_ADMIN tadm, ");
            query.append(" 	      ZON_TERRI t, ");
            query.append(" 	      ZON_SECCI, ");
            query.append(" 	      ZON_ZONA, ");
            query.append(" 	      ZON_REGIO, ");
            query.append(" 	      ZON_SUB_GEREN_VENTA sub, ");
            query.append("        CRA_PERIO pi, ");
            query.append(" 	      CRA_PERIO pi2 ");
            query.append("  WHERE unid.CLIE_OID_CLIE = " + oidCliente);
            query.append("        AND unid.IND_ACTI = 1 ");  // Unidad Administrativa "Activa" 
            query.append("        AND unid.PERD_OID_PERI_INI = pi.OID_PERI ");
            query.append("        AND pi.FEC_INIC <= (SELECT FEC_INIC FROM CRA_PERIO WHERE OID_PERI = " + oidPeriodo + ")");
            query.append("        AND ((unid.PERD_OID_PERI_FIN = pi2.OID_PERI ");
            query.append("              AND pi2.FEC_FINA >= (SELECT FEC_FINA FROM CRA_PERIO WHERE OID_PERI = " + oidPeriodo + ") )");
            query.append("              OR unid.PERD_OID_PERI_FIN is NULL) ");
            query.append("        AND ZTAD_OID_TERR_ADMI = OID_TERR_ADMI  ");
            query.append("        AND TERR_OID_TERR = OID_TERR  ");
            query.append("        AND ZSCC_OID_SECC = OID_SECC  ");
            query.append("        AND ZZON_OID_ZONA = OID_ZONA  ");
            query.append("        AND ZORG_OID_REGI = OID_REGI  ");
            query.append("        AND ZSGV_OID_SUBG_VENT = OID_SUBG_VENT   "); 
            query.append(" order by pi.FEC_INIC desc  ");

            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (resultado.esVacio()) {
            UtilidadesLog.debug("...no hay registros de obtenerUAActiva");
            UtilidadesLog.info("DAOMAEMaestroClientes.obtenerUAActiva(Long oidCliente, Long oidPeriodo): Salida"); 
            return null;
        } else {
            UtilidadesLog.debug("...resultado de obtenerUAActiva es: " + resultado);
            dtoS.setNSE1(objToString(resultado.getValueAt(0, "COD_NSE1")));
            dtoS.setNSE2(objToString(resultado.getValueAt(0, "COD_NSE2")));
            dtoS.setNSE3(objToString(resultado.getValueAt(0, "COD_NSE3")));
            dtoS.setOidCanal(objToLong(resultado.getValueAt(0, "CANA_OID_CANA")));
            dtoS.setOidMarca(objToLong(resultado.getValueAt(0, "MARC_OID_MARC")));
            dtoS.setOidPais(objToLong(resultado.getValueAt(0, "PAIS_OID_PAIS")));
            dtoS.setOidRegion(objToLong(resultado.getValueAt(0, "OID_REGI")));
            dtoS.setOidSeccion(objToLong(resultado.getValueAt(0, "OID_SECC")));
            dtoS.setOidSGV(objToLong(resultado.getValueAt(0, "OID_SUBG_VENT")));
            dtoS.setOidTerritorio(objToLong(resultado.getValueAt(0, "TERR_OID_TERR")));
            dtoS.setOidTerritorioAdministrativo(objToLong(resultado.getValueAt(0, "OID_TERR_ADMI")));
            dtoS.setOidZona(objToLong(resultado.getValueAt(0, "OID_ZONA")));
            
            dtoS.setOidCliente(oidCliente);
            UtilidadesLog.info("DAOMAEMaestroClientes.obtenerUAActiva(Long oidCliente, Long oidPeriodo): Salida"); 
            return dtoS;
        }
    }

  /**
   * Sistema: Belcorp
   * Módulo:  INC
   * Fecha:   26/07/2006
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Inc DBLG500000906
   */
  public RecordSet obtenerZonaTerritorioUA(DTOBusquedaZonaTerritorioUA dto) throws MareException {
  
    UtilidadesLog.info("DAOMAEMaestroClientes.obtenerZonaTerritorioUA(DTOBusquedaZonaTerritorioUA dto): Entrada"); 
    
    RecordSet rs;
    StringBuffer query = new StringBuffer();
    
    try {
        BelcorpService bs = BelcorpService.getInstance();
    
        query.append(" SELECT ZON.COD_ZONA, TERR.COD_TERR ");
        query.append(" FROM MAE_CLIEN_UNIDA_ADMIN UNA,  ZON_TERRI_ADMIN TERRA,  ZON_SECCI SEC, ");
        query.append(" ZON_ZONA ZON, ZON_TERRI TERR ");
        query.append(" WHERE UNA.ZTAD_OID_TERR_ADMI = TERRA.OID_TERR_ADMI ");
        query.append(" AND TERRA.TERR_OID_TERR = TERR.OID_TERR ");
        query.append(" AND TERRA.ZSCC_OID_SECC = SEC.OID_SECC ");
        query.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA ");
        query.append(" AND UNA.IND_ACTI = 1 ");
        query.append(" AND UNA.CLIE_OID_CLIE = " + dto.getOidCliente());
        query.append(" AND TERRA.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND TERRA.MARC_OID_MARC = " + dto.getOidMarca());
        query.append(" AND TERRA.CANA_OID_CANA = " + dto.getOidCanal());

        rs = bs.dbService.executeStaticQuery(query.toString());
        UtilidadesLog.debug("rs: " + rs);
        
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerZonaTerritorioUA(DTOBusquedaZonaTerritorioUA dto): Salida");       
        return rs;
        
    } catch (MareMiiServiceNotFoundException e) {
        UtilidadesLog.error(e);
        throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    } catch (Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
  }
  
  public ArrayList obtenerTipificacionesCliente(Long oidCliente) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerTipificacionesCliente(cliente): Entrada");
        ArrayList tipificaciones = new ArrayList();
        RecordSet resultado = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            query.append("SELECT mae.OID_CLIE, ");
            query.append("       tst.TICL_OID_TIPO_CLIE, tst.SBTI_OID_SUBT_CLIE,");
            query.append("       cla.TCCL_OID_TIPO_CLASI, cla.CLAS_OID_CLAS");
            query.append("  FROM MAE_CLIEN mae,");
            query.append("       MAE_CLIEN_TIPO_SUBTI tst,");
            query.append("       MAE_CLIEN_CLASI cla");
            query.append(" WHERE mae.OID_CLIE = " + oidCliente);
            query.append("   AND mae.OID_CLIE = tst.CLIE_OID_CLIE");
            query.append("   AND tst.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT (+)");
            
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        DTOTipificacionCliente dtoTipificacion;
        
        Long oidClien;
        Long oidTipo;
        Long oidSubtipo;
        Long oidTipoClasi;
        Long oidClasi;
        
        int cantTipificaciones = resultado.getRowCount();
        UtilidadesLog.debug(" Se recuperaron " + cantTipificaciones + " Tipificaciones para el cliente.");
        
        for (int i = 0; i < cantTipificaciones; i++) {
            dtoTipificacion = new DTOTipificacionCliente();
            
            oidClien = new Long(((BigDecimal) resultado.getValueAt(i, 0)).longValue());
            oidTipo = new Long(((BigDecimal) resultado.getValueAt(i, 1)).longValue());
            oidSubtipo = new Long(((BigDecimal) resultado.getValueAt(i, 2)).longValue());
            
            oidTipoClasi = (resultado.getValueAt(i, 3) != null)
                                 ? new Long(((BigDecimal) resultado.getValueAt(i, 3)).longValue())
                                 : null;
            oidClasi = (resultado.getValueAt(i, 4) != null)
                                 ? new Long(((BigDecimal) resultado.getValueAt(i, 4)).longValue())
                                 : null;
            dtoTipificacion.setOidCliente(oidClien);
            dtoTipificacion.setOidTipoCliente(oidTipo);
            dtoTipificacion.setOidSubtipoCliente(oidSubtipo);
            dtoTipificacion.setOidTipoClasificacionCliente(oidTipoClasi);
            dtoTipificacion.setOidClasificacionCliente(oidClasi);
            
            UtilidadesLog.debug(" Tipificacion dto: " + dtoTipificacion);
            tipificaciones.add(dtoTipificacion);
        }
        
        UtilidadesLog.info(" DAOMAEMaestroClientes.obtenerTipificacionesCliente(cliente): Salida");
        return tipificaciones;
    }

  /**
   * Sistema: Belcorp
   * Módulo:  MAE
   * Fecha:   15/02/2007
   * @version 1.00
   * @autor   Sergio Apaza
   * Inc V_MAE_08
   */
		public void eliminarDireccionCliente (Long oidClieDire) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.eliminarDireccionCliente: Entrada"); 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();

				query.append("UPDATE MAE_CLIEN_DIREC SET IND_ELIM=1 WHERE OID_CLIE_DIRE = " + oidClieDire );
		    
		    try {
		         
            bs = BelcorpService.getInstance();
            bs.dbService.executeUpdate(query.toString());
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMAEMaestroClientes.eliminarDireccionCliente: Salida"); 
    }
 
    public DTOSalida busquedaRapidaNombreCompleto(DTOBusquedaRapidaCliente dto) throws MareException {
        UtilidadesLog.info(" DAOMAEMaestroClientes.busquedaRapidaNombreCompleto(DTOBusquedaRapidaCliente): Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        DTOSalida sl = new DTOSalida();

        try {
            bs = UtilidadesEJB.getBelcorpService();

            StringBuffer query = new StringBuffer();
            String whereStr;

            query.append(" SELECT c.OID_CLIE OID, nvl(c.VAL_NOM1,'')  || ' ' || nvl(c.VAL_NOM2,'') ");
            query.append("        || ' ' || nvl(c.VAL_APE1,'') || ' ' ||nvl(c.VAL_APE2,'') NOMBRECOMPLETO ");            
            query.append("   FROM MAE_CLIEN c, MAE_CLIEN_IDENT i ");
            query.append("  WHERE c.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append("    AND i.CLIE_OID_CLIE = c.OID_CLIE ");

            if (dto.getCodigoCliente() != null) {
                query.append("    AND c.COD_CLIE = '" + dto.getCodigoCliente() + "' ");
            }

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);

            resultado = bs.dbService.executeStaticQuery(queryStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        /*if (resultado.esVacio()) {
            UtilidadesLog.debug("####### EL RESULTADO ES VACIO ######");
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }*/

        sl.setResultado(resultado);
        UtilidadesLog.info("DAOMAEMaestroClientes.busquedaRapidaNombreCompleto(DTOBusquedaRapidaCliente): Salida");

        return sl;
    }
    
    /**
     * Creado por cambio 20090923
     * Obtiene los datos de la direccion cuyo OID se recibe por parametro.
     * @author dmorello
     * @since 08-Jul-2009
     */
    public DTODireccion obtenerDireccionPorOID(Long oidDireccion) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerDireccionPorOID(Long oidDireccion): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT dir.tidc_oid_tipo_dire, dir.tivi_oid_tipo_via, val.oid_valo_estr_geop ");
        query.append("      , dir.zvia_oid_via, dir.num_ppal, dir.val_cod_post, dir.val_obse ");
        query.append("      , dir.ind_dire_ppal, dir.val_nomb_via, val.des_geog ");
        query.append("   FROM mae_clien_direc dir");
        query.append("      , zon_valor_estru_geopo val");
        query.append("      , zon_terri terr ");
        query.append("  WHERE DIR.OID_CLIE_DIRE = ").append(oidDireccion);
        query.append("    AND dir.terr_oid_terr = terr.oid_terr");
        query.append("    AND terr.vepo_oid_valo_estr_geop = val.oid_valo_estr_geop ");
        
        RecordSet resultado = null;
        try {
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        DTODireccion dir = null;
        if (resultado != null && !resultado.esVacio()) {
        
            dir = new DTODireccion();
            
            dir.setOid(oidDireccion);
            dir.setTipoDireccion(UtilidadesBD.convertirALong(resultado.getValueAt(0, "TIDC_OID_TIPO_DIRE")));
            dir.setTipoVia(UtilidadesBD.convertirALong(resultado.getValueAt(0, "TIVI_OID_TIPO_VIA")));
            dir.setUnidadGeografica(UtilidadesBD.convertirALong(resultado.getValueAt(0, "OID_VALO_ESTR_GEOP")));
            dir.setVia(UtilidadesBD.convertirALong(resultado.getValueAt(0, "ZVIA_OID_VIA")));
            dir.setNumeroPrincipal((String)resultado.getValueAt(0, "NUM_PPAL"));
            dir.setCodigoPostal((String)resultado.getValueAt(0, "VAL_COD_POST"));
            dir.setObservaciones((String)resultado.getValueAt(0, "VAL_OBSE"));
            dir.setEsDireccionPrincipal(UtilidadesBD.convertirABoolean(resultado.getValueAt(0, "IND_DIRE_PPAL")));
            dir.setNombreVia((String)resultado.getValueAt(0, "VAL_NOMB_VIA"));
            dir.setNombreUnidadGeografica((String)resultado.getValueAt(0, "DES_GEOG"));
            
        }
        
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerDireccionPorOID(Long oidDireccion): Salida");
        return dir;
    }
 
    // sapaza -- PER-SiCC-2013-1083 -- 04/10/2013
    public String obtenerValorModuloCliente(Long oidPais, String codigoParametro) throws MareException {
        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerValorModuloCliente(Long oidPais, String codigoParametro): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT mcm.MOD_VALI ");
        consulta.append("   FROM MAE_CLIEN_MODUL mcm, SEG_PAIS pai  ");
        consulta.append("  WHERE mcm.COD_PAIS = pai.COD_PAIS  ");
        consulta.append("    AND pai.OID_PAIS =  " + oidPais.toString());
        consulta.append("    AND mcm.TIP_VALI = '" + codigoParametro + "'");
        consulta.append("    AND mcm.IND_ACTI = '1' ");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerValorModuloCliente: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null) {                 
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOMAEMaestroClientes.obtenerValorModuloCliente(Long oidPais, String codigoParametro): Salida");

        return null;
    }
    
}