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
import es.indra.sicc.dtos.mae.DTOBusquedaConfiguracionCampo;
import es.indra.sicc.dtos.mae.DTOCampo;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposCliente;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposProducto;
import es.indra.sicc.dtos.mae.DTOConsultaConfiguracionCampos;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.Hashtable;

import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.EJBException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase
 * */
public class DAOMAEConfiguracionClientes {
    private final String usuario;

    public DAOMAEConfiguracionClientes(String user) {
        this.usuario = user;
    }

    /**
     * Obtiene para el pais especificados en el dto, la configuración que tienen  los campos
     * indicados en el dto. Para el módulo MAE y especificando como  formulario "PRODUCTOS"
     *
     * @param DTOConfiguracionCamposProducto
     *
     * @return DTOConfiguracionCamposProducto
     *
     * @throws MareException
     */
    public DTOConfiguracionCamposProducto obtenerConfiguracionCamposProductos(DTOConfiguracionCamposProducto dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerConfiguracionCamposProductos(DTOConfiguracionCamposProducto): Entrada");

        Hashtable datosCampos = obtenerDatosCamposProducto(dto);

        for (int i = 0; i < dto.getCampos().size(); i++) {
            DTOCampo dtoC = (DTOCampo) dto.getCampos().get(i);
            DTOCampo dtoDB = (DTOCampo) datosCampos.get(dtoC.getCodigoCampo());

            if (dtoDB != null) {
                dtoC.setValorDefecto(dtoDB.getValorDefecto());
                dtoC.setObligatorio(dtoDB.getObligatorio());
                dtoC.setModificable(dtoDB.getModificable());
            } else {
                dtoC.setValorDefecto("");
                dtoC.setObligatorio(new Boolean(false));
                dtoC.setModificable(new Boolean(true));
            }
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerConfiguracionCamposProductos(DTOConfiguracionCamposProducto): Salida");
        return dto;
    }

    /**
     * DOCUMENT ME!
     *
     * @param dto - DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws MareException - DOCUMENT ME!
     */
    public DTOConfiguracionCamposCliente obtenerConfiguracionCamposClientes(DTOConfiguracionCamposCliente dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerConfiguracionCamposClientes(DTOConfiguracionCamposCliente): Entrada");

        Hashtable datosCampos = obtenerDatosCamposClientes(dto);

        UtilidadesLog.debug("datosCampos " + datosCampos);

        for (int i = 0; i < dto.getCampos().size(); i++) {
            DTOCampo dtoC = (DTOCampo) dto.getCampos().get(i);
            DTOCampo dtoDB = (DTOCampo) datosCampos.get(dtoC.getCodigoCampo());

            if (dtoDB != null) {
                dtoC.setValorDefecto(dtoDB.getValorDefecto());
                dtoC.setObligatorio(dtoDB.getObligatorio());
                dtoC.setModificable(dtoDB.getModificable());
            } else {
                dtoC.setValorDefecto("");
                dtoC.setObligatorio(new Boolean(false));
                dtoC.setModificable(new Boolean(true));
            }
        }
       UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerConfiguracionCamposClientes(DTOConfiguracionCamposCliente): Salida");

        return dto;
    }

    /**
     * DOCUMENT ME!
     *
     * @param dto - DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws MareException - DOCUMENT ME!
     */
    public DTOTipoSubtipo obtenerTipoSubtipo(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipoSubtipo(DTOBelcorp): Entrada");

        DTOTipoSubtipo dtor = new DTOTipoSubtipo();

        dtor.setTipos(obtenerTiposClie(dto.getOidIdioma()));
        dtor.setSubtipos(obtenerSubTiposClie(dto.getOidIdioma()));
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipoSubtipo(DTOBelcorp): Salida"); 
        return dtor;
    }

    /**
     * Realiza el acceso a la tabla de tipos de clientes para obtener todos los tipos de cliente
     *
     * @param Long idioma
     *
     * @return RecordSet
     *
     * @throws MareException
     */
    private RecordSet obtenerTiposClie(Long idioma) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposClie(idioma): Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT T.OID_TIPO_CLIE, D.VAL_I18N ");
        query.append(" FROM MAE_TIPO_CLIEN T, v_gen_i18n_sicc D ");
        query.append(" where T.OID_TIPO_CLIE = D.VAL_OID ");
        query.append(" and D.IDIO_OID_IDIO = " + idioma);
        query.append(" and D.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
        query.append(" order by D.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener tipos de clientes", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposClie(idioma): Salida");
        return rs;
    }

    public RecordSet obtenerTipos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipos(idioma): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT tipo.OID_TIPO_CLIE, i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_CLIEN tipo,V_GEN_I18N_SICC i18n ");
        query.append(" WHERE tipo.OID_TIPO_CLIE = i18n.VAL_OID");
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener tipos", e);
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipos(idioma): Salida");

        return rs;
    }

    /**
     * Realiza el acceso a la tabla de tipos de clientes para obtener todos los tipos de cliente
     *
     * @param Long idioma
     *
     * @return RecordSet
     *
     * @throws MareException
     */
    private RecordSet obtenerSubTiposClie(Long idioma) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerSubTiposClie(idioma): Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT S.OID_SUBT_CLIE, S.TICL_OID_TIPO_CLIE, ");
        query.append(" D.VAL_I18N ");
        query.append(" FROM MAE_SUBTI_CLIEN S, v_gen_i18n_sicc D ");
        query.append(" where S.OID_SUBT_CLIE = D.VAL_OID ");
        query.append(" and D.IDIO_OID_IDIO = " + idioma);
        query.append(" and D.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
        query.append(" order by D.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener subtipos de clientes", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerSubTiposClie(idioma): Salida");

        return rs;
    }

    /**
     * DOCUMENT ME!
     *
     * @param oid - DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws MareException - DOCUMENT ME!
     */
    public DTOConsultaConfiguracionCampos consultarConfiguracionCampos(DTOOID oid) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.consultarConfiguracionCampos(DTOOID): Entrada");

        DTOConsultaConfiguracionCampos dto = new DTOConsultaConfiguracionCampos();
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        RecordSet rsCli;

        //Hacemos una consulta 
        query.append("SELECT ");
        query.append("a.DES_ATRI, ");
        query.append("c.IND_OBLI, ");
        query.append("c.IND_MODI, ");
        query.append("c.VAL_DEFE, ");

        //Campos a mostrar descripcion
        query.append("c.SBTI_OID_SUBT_CLIE ");

        //query.append(", s.TICL_OID_TIPO_CLIE ");
        query.append("FROM MAE_CONFI_CAMPO c, PED_ATRIB_ESPEC a "); //, MAE_SUBTI_CLIEN s ");

        //Primero ponemos los join
        query.append(" WHERE c.OID_CONF_CAMP = " + oid.getOid() + " ");
        query.append(" AND c.ATRE_OID_ATRI_ESPE = a.OID_ATRI_ESPE ");

        //query.append(" AND c.SBTI_OID_SUBT_CLIE = s.OID_SUBT_CLIE ");
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error en consultarConfiguracionCampos", e);
        }

        UtilidadesLog.info(rs);

        dto.setCampo((String) rs.getValueAt(0, "DES_ATRI"));

        if ((((BigDecimal) rs.getValueAt(0, "IND_OBLI")).intValue()) == 1) {
            dto.setObligatorio(new Boolean(true));
        } else {
            dto.setObligatorio(new Boolean(false));
        }

        if ((((BigDecimal) rs.getValueAt(0, "IND_MODI")).intValue()) == 1) {
            dto.setModificable(new Boolean(true));
        } else {
            dto.setModificable(new Boolean(false));
        }

        dto.setValorDefecto((String) (rs.getValueAt(0, "VAL_DEFE")));

        if (rs.getValueAt(0, "SBTI_OID_SUBT_CLIE") == null) {
            dto.setIndClienteProducto(new Boolean(false));
        } else {
            dto.setIndClienteProducto(new Boolean(true));

            //Hacemos la consulta por Cliente
            StringBuffer query2 = new StringBuffer();
            query2.append("SELECT ");
            query2.append("OID_SUBT_CLIE, ");
            query2.append("TICL_OID_TIPO_CLIE ");
            query2.append("FROM MAE_SUBTI_CLIEN ");
            query2.append(" WHERE OID_SUBT_CLIE = " + rs.getValueAt(0, "SBTI_OID_SUBT_CLIE") + " ");

            try {
                rsCli = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query2.toString());
            } catch (MareException me) {
                throw me;
            } catch (Exception e) {
                throw new MareException("Error en consultarConfiguracionCampos", e);
            }

            UtilidadesLog.info(rsCli);

            RecordSet rsInter = UtilidadesI18N.traeDescI18N(rsCli, new int[] {
                    0, 1
                }, new String[] { "MAE_SUBTI_CLIEN", "MAE_TIPO_CLIEN" }, oid.getOidIdioma());
            UtilidadesLog.info(rsInter);

            dto.setSubtipoCliente((String) rsInter.getValueAt(0, 2));
            dto.setTipoCliente((String) rsInter.getValueAt(0, 3));
        }

        UtilidadesLog.info(" DAOMAEConfiguracionClientes.consultarConfiguracionCampos(DTOOID): Salida");

        return dto;
    }

    /**
     * DOCUMENT ME!
     *
     * @param dto - DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws MareException - DOCUMENT ME!
     */
    public RecordSet obtenerTiposDocumentoPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposDocumentoPorPais(DTOBelcorp): Entrada");

        StringBuffer query = new StringBuffer();
        query.append(" SELECT ");
        query.append(" doc.OID_TIPO_DOCU oid, ");
        query.append(" i18n.VAL_I18N descripcion ");
        query.append(" FROM  MAE_TIPO_DOCUM doc , ");
        query.append(" V_GEN_I18N_SICC i18n ");
        query.append(" WHERE doc.PAIS_OID_PAIS =" + dto.getOidPais() + " ");
        query.append(" AND i18n.VAL_OID = doc.OID_TIPO_DOCU ");
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_DOCUM' ");
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append(" ORDER BY 2 ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener tipos de clientes", e);
        }

        //RecordSet rsInter = UtilidadesI18N.traeDescI18N(rs, new int[] { 0 }, new String[] { "MAE_TIPO_DOCUM" }, dto.getOidIdioma());
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposDocumentoPorPais(DTOBelcorp): Salida");
        return rs;
    }

    /**
     * Esta consulta es paginada y por tanto se debe tener en cuenta el patron  de paginacion
     * (debemos indicar en el DTOSalida si es la ultima página y  debemos devolver como máximo
     * tantos registros como el tamaño de página que indica el dto, y a partir del oid que nos
     * indica el dto. Para poder filtrar por oid los resultados deben estar ordenados por oid).
     *
     * @param dto - DTOConfiguracionCampo
     *
     * @return DTOSalida
     *
     * @throws MareException
     */
    public DTOSalida buscarConfiguracionCamposPorCriterios(DTOBusquedaConfiguracionCampo dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.buscarConfiguracionCamposPorCriterios(DTOBusquedaConfiguracionCampo): Entrada");

        RecordSet rsInter = null;
        StringBuffer query = new StringBuffer();

        //Hacemos una consulta diferente dependiendo de si es para un cliente o un producto 
        if ((dto != null) && (dto.getIndClienteProducto() != null) && dto.getIndClienteProducto().booleanValue()) {
            //Consulta para Cliente
            UtilidadesLog.debug("Consulta de Cliente");

            query.append("SELECT ");
            query.append("c.OID_CONF_CAMP OID, ");
            query.append("g1.VAL_I18N DES1, ");
            query.append("g2.VAL_I18N DES2, ");
            query.append("a.DES_ATRI, ");
            query.append("c.IND_OBLI, ");
            query.append("c.IND_MODI, ");
            query.append("c.VAL_DEFE ");

            //Campos a mostrar descripcion
            //query.append("s.OID_SUBT_CLIE, ");
            //query.append("s.TICL_OID_TIPO_CLIE ");
            query.append("FROM MAE_CONFI_CAMPO c, PED_ATRIB_ESPEC a, MAE_SUBTI_CLIEN s, V_GEN_I18N_SICC g1, V_GEN_I18N_SICC g2 ");

            //Para cada atributo que no sea null añadimos la restriccion correspondiente: 
            /*
            String quer = UtilidadesBD.armarSQLWhere(
              new String[] {
                "c.VAL_DEFE", "c.IND_OBLI", "c.IND_MODI", "c.ATRE_OID_ATRI_ESPE",
                "s.OID_SUBT_CLIE", "s.TICL_OID_TIPO_CLIE"},
              new Object[] {
                dto.getValorDefecto(), dto.getObligatorio(), dto.getModificable(),
                dto.getCampo(), dto.getSubtipoCliente(), dto.getTipoCliente()},
              new boolean[] { true, false, false, false, false, false });
            */
            //----------------------------
            query.append("WHERE 1 = 1");

            if (dto.getValorDefecto() != null) {
                query.append(" AND c.VAL_DEFE LIKE '" + dto.getValorDefecto() + "'");
            }

            if (dto.getObligatorio() != null) {
                query.append(" AND c.IND_OBLI = " + convertirBooleanANumber(dto.getObligatorio()));
            }

            if (dto.getModificable() != null) {
                query.append(" AND c.IND_MODI = " + convertirBooleanANumber(dto.getModificable()));
            }

            if (dto.getCampo() != null) {
                query.append(" AND c.ATRE_OID_ATRI_ESPE = " + dto.getCampo().toString());
            }

            if (dto.getSubtipoCliente() != null) {
                query.append(" AND s.OID_SUBT_CLIE = " + dto.getSubtipoCliente());
            }

            if (dto.getTipoCliente() != null) {
                query.append(" AND s.TICL_OID_TIPO_CLIE = " + dto.getTipoCliente().toString());
            }

            //----------------------------

            /*
            if (quer.length() == 0 ) {
              query.append(" WHERE " );
            } else {
              query.append(quer + " and " );
            }
            */
            if (dto.getOidPais() != null) {
                query.append(" AND c.PAIS_OID_PAIS = " + dto.getOidPais().toString());
            }

            query.append(" AND c.ATRE_OID_ATRI_ESPE = a.OID_ATRI_ESPE");
            query.append(" AND c.SBTI_OID_SUBT_CLIE = s.OID_SUBT_CLIE");

            if (dto.getTipoCliente() != null) {
                query.append(" AND g1.ATTR_ENTI = 'MAE_TIPO_CLIEN'");
                query.append(" AND g1.VAL_OID = '" + dto.getTipoCliente() + "'");
                query.append(" AND g1.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "'");
            } else {
                query.append(" AND g1.ATTR_ENTI = 'MAE_TIPO_CLIEN'");
                query.append(" AND g1.VAL_OID = s.TICL_OID_TIPO_CLIE");
                query.append(" AND g1.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "'");
            }

            if (dto.getSubtipoCliente() != null) {
                query.append(" AND g2.VAL_OID = '" + dto.getSubtipoCliente() + "'");
                query.append(" AND g2.ATTR_ENTI = 'MAE_SUBTI_CLIEN'");
                query.append(" AND g2.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "'");
            } else {
                query.append(" AND g2.VAL_OID = c.SBTI_OID_SUBT_CLIE");
                query.append(" AND g2.ATTR_ENTI = 'MAE_SUBTI_CLIEN'");
                query.append(" AND g2.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "'");
            }

            query.append(" AND c.SBTI_OID_SUBT_CLIE = s.OID_SUBT_CLIE");
            query.append(" AND a.VAL_FORM = 'CLIENTES'");

            try {
                rsInter = (RecordSet) getBelcorpService().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
                UtilidadesLog.debug("*********la salida es " + rsInter);
            } catch (MareException me) {
                throw me;
            } catch (Exception e) {
                throw new MareException("Error al obtener clientes por criterios", e);
            }
        } else if ((dto != null) && (dto.getIndClienteProducto() != null) && !dto.getIndClienteProducto().booleanValue()) {
            //Consulta para Producto
            UtilidadesLog.debug("Consulta de Producto");

            query.append(" SELECT c.OID_CONF_CAMP OID, c.PAIS_OID_PAIS DES1 , c.SBTI_OID_SUBT_CLIE DES2, "); //los ultimos dos no se usan
            query.append("a.DES_ATRI, c.IND_OBLI, c.IND_MODI, c.VAL_DEFE ");
            query.append("FROM MAE_CONFI_CAMPO c, PED_ATRIB_ESPEC a ");

            //Primero ponemos los join
            query.append("WHERE 1 = 1");

            if (dto.getOidPais() != null) {
                query.append(" AND c.PAIS_OID_PAIS = " + dto.getOidPais().toString());
            }

            query.append(" AND c.ATRE_OID_ATRI_ESPE = a.OID_ATRI_ESPE");
            query.append(" AND a.VAL_FORM = 'PRODUCTOS'");

            //Para cada atributo que no sea null añadimos la restriccion correspondiente: 
            //ESTO SE COMENTA DEBIDO A QUE NO PUEDE VENIR VALOR POR DEFECTO CUANDO ES
            //TIPO 'PRODUCTO' PORQUE EN ESE CASO NO FIGURA DICHO CAMPO EN PANTALLA
            //if (dto.getValorDefecto() != null) {
            //  query.append(" AND c.VAL_DEFE LIKE '" + dto.getValorDefecto() + "'");
            //}
            if (dto.getObligatorio() != null) {
                query.append(" AND c.IND_OBLI = " + convertirBooleanANumber(dto.getObligatorio()));
            }

            if (dto.getModificable() != null) {
                query.append(" AND c.IND_MODI = " + convertirBooleanANumber(dto.getModificable()));
            }

            if (dto.getCampo() != null) {
                query.append(" AND c.ATRE_OID_ATRI_ESPE = " + dto.getCampo());
            }

            try {
                rsInter = (RecordSet) getBelcorpService().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
            } catch (MareException me) {
                throw me;
            } catch (Exception e) {
                e.printStackTrace();
                throw new MareException("Error al obtener productos por criterios", e);
            }

            UtilidadesLog.debug("**************Datos de la query " + rsInter);
        } else {
            //Se selecciono Tipo Campo == vacio
            UtilidadesLog.debug("Consulta de VACIO");

            query.append("SELECT	C.OID_CONF_CAMP OID, G1.VAL_I18N DES1, G2.VAL_I18N DES2,");
            query.append(" A.DES_ATRI, C.IND_OBLI, C.IND_MODI, C.VAL_DEFE");
            query.append(" FROM MAE_CONFI_CAMPO C, PED_ATRIB_ESPEC A, MAE_SUBTI_CLIEN S,");
            query.append(" V_GEN_I18N_SICC G1, V_GEN_I18N_SICC G2");
            query.append(" WHERE 1 = 1");

            //PREGUNTAR POR ESTOS DOS
            if (dto.getObligatorio() != null) {
                query.append(" AND C.IND_OBLI = " + this.convertirBooleanANumber(dto.getObligatorio()));
            }

            if (dto.getModificable() != null) {
                query.append(" AND C.IND_MODI = " + this.convertirBooleanANumber(dto.getModificable()));
            }

            if (dto.getOidPais() != null) {
                query.append(" AND C.PAIS_OID_PAIS = " + dto.getOidPais().toString());
            }

            if (dto.getOidIdioma() != null) {
                query.append(" AND G2.IDIO_OID_IDIO(+) = " + dto.getOidIdioma().toString());
            }

            if (dto.getOidIdioma() != null) {
                query.append(" AND G1.IDIO_OID_IDIO (+)= " + dto.getOidIdioma().toString());
            }

            query.append(" AND C.ATRE_OID_ATRI_ESPE = A.OID_ATRI_ESPE");
            query.append(" AND A.VAL_FORM IN ( 'CLIENTES', 'PRODUCTOS')");
            query.append(" AND C.SBTI_OID_SUBT_CLIE = S.OID_SUBT_CLIE(+)");
            query.append(" AND G2.ATTR_ENTI(+) = 'MAE_SUBTI_CLIEN'");
            query.append(" AND C.SBTI_OID_SUBT_CLIE = G2.VAL_OID(+)");
            query.append(" AND S.TICL_OID_TIPO_CLIE = G1.VAL_OID(+)");
            query.append(" AND G1.ATTR_ENTI(+) = 'MAE_TIPO_CLIEN'");

            try {
                rsInter = (RecordSet) getBelcorpService().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
            } catch (MareException me) {
                throw me;
            } catch (Exception e) {
                e.printStackTrace();
                throw new MareException("Error al obtener productos por criterios", e);
            }

            UtilidadesLog.debug("Datos de la query " + rsInter);
        }

        UtilidadesLog.debug("antes del if de rs Inter valor del mismo " + rsInter);

        if (rsInter.esVacio()) {
            UtilidadesLog.debug("entro al if valor " + rsInter);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.buscarConfiguracionCamposPorCriterios(DTOBusquedaConfiguracionCampo): Salida");

        return new DTOSalida(rsInter);
    }

    /**
     * Devuelve un recordset con todos los tipos de direccion que tiene el
     * sistema, para cada uno se devuelve el oid y la descipción en el idioma
     * indicado por el dto de entradaPara ello realiza una consulta JDBC
     * sobre la tabla MAE_TIPO_DIREC y obtenemos el OID_TIPO_DIRE y la
     * descripcion (de la tabla internacionalizable) para todos los registros.
     * Devolvemos el recordset con el resultado de la consulta
     *
     * @param dto - DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws MareException - DOCUMENT ME!
     */
    public RecordSet obtenerTiposDireccion(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposDireccion(DTOBelcorp): Entrada");

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" m.OID_TIPO_DIRE , g.val_i18n");
        query.append(" FROM MAE_TIPO_DIREC m, gen_i18n_sicc g ");
        query.append(" WHERE M.OID_TIPO_DIRE = G.VAL_OID AND G.ATTR_ENTI='MAE_TIPO_DIREC' AND G.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" ORDER BY G.VAL_I18N");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener tipos de direccion", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposDireccion(DTOBelcorp): Salida");

        return rs;
    }

    /**
     * Métodos privados
     */
    private Hashtable obtenerDatosCamposProducto(DTOConfiguracionCamposProducto dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerDatosCamposProducto(DTOConfiguracionCamposProducto): Entrada");
        StringBuffer query = new StringBuffer();
        StringBuffer campos = new StringBuffer();
        Hashtable atributos = new Hashtable();
        RecordSet rs;

        for (int i = 0; i < dto.getCampos().size(); i++) {
            DTOCampo dtoC = (DTOCampo) dto.getCampos().get(i);
            campos.append("'" + dtoC.getCodigoCampo() + "'");

            if (i < (dto.getCampos().size() - 1)) {
                campos.append(",");
            }
        }

        query.append(" SELECT a.COD_ATRI, c.VAL_DEFE, c.IND_OBLI, c.IND_MODI ");
        query.append(" FROM MAE_CONFI_CAMPO c, PED_ATRIB_ESPEC a, SEG_MODUL m ");

        //Primero ponemos los join
        query.append(" WHERE c.ATRE_OID_ATRI_ESPE = a.OID_ATRI_ESPE ");
        query.append(" AND a.MODU_OID_MODU = m.OID_MODU ");

        //Ahora ponemos las resctricciones 
        query.append(" AND c.SBTI_OID_SUBT_CLIE IS NULL "); //Para los productos este campo no tiene sentido 
        query.append(" AND c.PAIS_OID_PAIS = " + dto.getOidPais() + " ");
        query.append(" AND m.COD_MODU = '" + ConstantesSEG.MODULO_MAE + "'");
        query.append(" AND a.VAL_FORM = '" + ConstantesMAE.CAMPO_PRODUCTO + "'");
        query.append(" AND a.COD_ATRI IN (" + campos.toString() + ")");

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException("Error al obtener valores por defecto", e);
        }

        if (!(rs == null)) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                DTOCampo dtoC = new DTOCampo();
                dtoC.setCodigoCampo((String) rs.getValueAt(i, "COD_ATRI"));
                dtoC.setValorDefecto((String) rs.getValueAt(i, "VAL_DEFE"));

                BigDecimal indicador = (BigDecimal) rs.getValueAt(i, "IND_OBLI");

                if ((indicador == null) || (indicador.intValue() == 0)) {
                    dtoC.setObligatorio(new Boolean(false));
                } else {
                    dtoC.setObligatorio(new Boolean(true));
                }

                indicador = (BigDecimal) rs.getValueAt(i, "IND_MODI");

                if ((indicador == null) || (indicador.intValue() == 0)) {
                    dtoC.setModificable(new Boolean(false));
                } else {
                    dtoC.setModificable(new Boolean(true));
                }

                atributos.put((String) rs.getValueAt(i, 0), dtoC);
            }
        }

        UtilidadesLog.debug("atributos-------> " + atributos.toString());
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerDatosCamposProducto(DTOConfiguracionCamposProducto): Salida");
        return atributos;
    }

    /**
     * DOCUMENT ME!
     *
     * @param dto - DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws MareException - DOCUMENT ME!
     */
    private Hashtable obtenerDatosCamposClientes(DTOConfiguracionCamposCliente dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerDatosCamposClientes(DTOConfiguracionCamposCliente): Entrada");
        StringBuffer query = new StringBuffer();
        StringBuffer campos = new StringBuffer();
        Hashtable atributos = new Hashtable();
        RecordSet rs;

        for (int i = 0; i < dto.getCampos().size(); i++) {
            DTOCampo dtoC = (DTOCampo) dto.getCampos().get(i);
            campos.append("'" + dtoC.getCodigoCampo() + "'");

            if (i < (dto.getCampos().size() - 1)) {
                campos.append(",");
            }
        }

        query.append(" SELECT a.COD_ATRI, c.VAL_DEFE, c.IND_OBLI, c.IND_MODI ");
        query.append(" FROM MAE_CONFI_CAMPO c, MAE_TIPO_CLIEN t, PED_ATRIB_ESPEC a, MAE_SUBTI_CLIEN s, SEG_MODUL m ");

        //Primero hacemos los join entre las 5 tablas 
        query.append(" WHERE ( c.SBTI_OID_SUBT_CLIE = s.OID_SUBT_CLIE OR c.SBTI_OID_SUBT_CLIE is NULL ) ");
        query.append(" AND s.TICL_OID_TIPO_CLIE = t.OID_TIPO_CLIE ");
        query.append(" AND c.ATRE_OID_ATRI_ESPE = a.OID_ATRI_ESPE  ");
        query.append(" AND a.MODU_OID_MODU = m.OID_MODU ");

        //Ahora ponemos las resctricciones 
        query.append(" AND c.PAIS_OID_PAIS = " + dto.getOidPais() + " ");
        query.append(" AND s.OID_SUBT_CLIE = " + dto.getSubtipo() + " ");
        query.append(" AND t.OID_TIPO_CLIE = " + dto.getTipo() + " ");
        query.append(" AND m.COD_MODU = '" + ConstantesSEG.MODULO_MAE + "' "); //El modulo MAE
        query.append(" AND a.VAL_FORM = '" + ConstantesMAE.CAMPO_CLIENTE + "' "); //inc 4151
        query.append(" AND a.COD_ATRI IN (" + campos.toString() + ")");

        /**
         * c.PAIS_OID_PAIS = dto.pais AND  s.OID_SUBT_CLIE = dto.subtipo AND  t.OID_TIPO_CLIE =
         * dto.tipo
         */
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException("Error al obtener valores por defecto", e);
        }

        if (!(rs == null)) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                DTOCampo dtoC = new DTOCampo();
                dtoC.setCodigoCampo((String) rs.getValueAt(i, "COD_ATRI"));
                dtoC.setValorDefecto((String) rs.getValueAt(i, "VAL_DEFE"));

                BigDecimal indicador = (BigDecimal) rs.getValueAt(i, "IND_OBLI");

                if ((indicador == null) || (indicador.intValue() == 0)) {
                    dtoC.setObligatorio(new Boolean(false));
                } else {
                    dtoC.setObligatorio(new Boolean(true));
                }

                indicador = (BigDecimal) rs.getValueAt(i, "IND_MODI");

                if ((indicador == null) || (indicador.intValue() == 0)) {
                    dtoC.setModificable(new Boolean(false));
                } else {
                    dtoC.setModificable(new Boolean(true));
                }

                atributos.put((String) rs.getValueAt(i, 0), dtoC);
            }
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerDatosCamposClientes(DTOConfiguracionCamposCliente): Salida");

        return atributos;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    private BelcorpService getBelcorpService() {
        try {
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
    }

    public DTOClasificaciones obtenerClasificaciones(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificaciones(DTOBelcorp): Entrada");
        DTOClasificaciones dtoR = new DTOClasificaciones();
        StringBuffer query = new StringBuffer();

        //query.append(" SELECT ");
        // query.append(" OID_TIPO_CLAS, ");
        //  query.append(" SBTI_OID_SUBT_CLIE ");
        //  query.append(" FROM MAE_TIPO_CLASI_CLIEN ");
        query.append(" SELECT m.OID_TIPO_CLAS, m.SBTI_OID_SUBT_CLIE, v.VAL_I18N ");
        query.append(" FROM   MAE_TIPO_CLASI_CLIEN m, v_gen_i18n_sicc v ");
        query.append(" where  m.OID_TIPO_CLAS = v.VAL_OID ");
        query.append(" and    v.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
        query.append(" and    v.ATTR_NUM_ATRI = 1 ");
        query.append(" and    v.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" order by 3 ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener subtipos de clientes", e);
        }

        /* RecordSet rsInter = UtilidadesI18N.traeDescI18N(rs, new int[] { 0 },
                 new String[] { "MAE_TIPO_CLASI_CLIEN" }, dto.getOidIdioma());*/
        dtoR.setTipoClasificacion(rs);

        query = new StringBuffer();

        /*query.append(" SELECT ");
        query.append(" OID_CLAS, ");
        query.append(" TCCL_OID_TIPO_CLAS ");
        query.append(" FROM MAE_CLASI ");*/
        query.append(" SELECT m.OID_CLAS, m.TCCL_OID_TIPO_CLAS, v.VAL_I18N ");
        query.append(" FROM MAE_CLASI m, v_gen_i18n_sicc v ");
        query.append(" where  m.OID_CLAS = v.VAL_OID ");
        query.append(" and    v.ATTR_ENTI = 'MAE_CLASI' ");
        query.append(" and    v.ATTR_NUM_ATRI = 1 ");
        query.append(" and    v.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" order by 3  ");

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener subtipos de clientes", e);
        }

        /* rsInter = UtilidadesI18N.traeDescI18N(rs, new int[] { 0 },
                 new String[] { "MAE_CLASI" }, dto.getOidIdioma());*/
        dtoR.setClasificacion(rs);
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificaciones(DTOBelcorp): Salida"); 
        return dtoR;
    }

    /**
    * @param  DTOOID
    *
    * @return DTOClasificaciones
    */
    public DTOClasificaciones obtenerClasificacionesSubtipo(DTOOID dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificacionesSubtipo(DTOOID): Entrada");
        DTOClasificaciones dtoR = new DTOClasificaciones();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT OID_TIPO_CLAS,  SBTI_OID_SUBT_CLIE, v.VAL_I18N ");
        query.append(" FROM   MAE_TIPO_CLASI_CLIEN m, v_gen_i18n_sicc v ");
        query.append(" WHERE  m.SBTI_OID_SUBT_CLIE = " + dto.getOid());
        query.append(" and  m.OID_TIPO_CLAS = v.VAL_OID ");
        query.append(" and    v.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
        query.append(" and    v.ATTR_NUM_ATRI = 1 ");
        query.append(" and    v.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" order by 3 ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener subtipos de clientes para el SBTI_OID_SUBT_CLIE:" + dto.getOid(), e);
        }

        dtoR.setTipoClasificacion(rs);

        query = new StringBuffer();
        query.append(" SELECT m.OID_CLAS, m.TCCL_OID_TIPO_CLAS, v.VAL_I18N ");
        query.append(" FROM MAE_CLASI m, MAE_TIPO_CLASI_CLIEN mc, v_gen_i18n_sicc v ");
        query.append(" WHERE m.TCCL_OID_TIPO_CLAS = mc.OID_TIPO_CLAS ");
        query.append(" AND   mc.SBTI_OID_SUBT_CLIE = " + dto.getOid());
        query.append(" and  m.OID_CLAS = v.VAL_OID ");
        query.append(" and    v.ATTR_ENTI = 'MAE_CLASI' ");
        query.append(" and    v.ATTR_NUM_ATRI = 1 ");
        query.append(" and    v.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" order by 3  ");

        /*  query.append(" SELECT  OID_CLAS,  TCCL_OID_TIPO_CLAS ");
          query.append(" FROM MAE_CLASI m, MAE_TIPO_CLASI_CLIEN mc");
          query.append(" WHERE TCCL_OID_TIPO_CLAS = MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS ");
          query.append(" AND MAE_TIPO_CLASI_CLIEN.SBTI_OID_SUBT_CLIE = " + dto.getOid());*/
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener subtipos de clientes para el SBTI_OID_SUBT_CLIE:" + dto.getOid(), e);
        }

        dtoR.setClasificacion(rs);
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificacionesSubtipo(DTOOID): Salida");

        return dtoR;
    }

    private static int convertirBooleanANumber(Boolean aBoolean) {
        if (aBoolean.booleanValue()) {
            return 1;
        }

        return 0;
    }

    public RecordSet obtenerTiposVinculosPais(DTOBelcorp dto) throws MareException {
        // Hacemos una consulta JDBC sobre la tabla MAE_TIPO_VINCU y obtenemos el OID_TIPO_VINC y la descripcion (
        // en el idioma indicado por el dto) para los registros cuyo PAIS_OID_PAIS coincida con el pais del dto de entrada.
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposVinculosPais(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT  vincu.OID_TIPO_VINC, i18n.VAL_I18N  ");
        query.append(" FROM MAE_TIPO_VINCU vincu, V_GEN_I18N_SICC i18n ");
        query.append(" WHERE vincu.OID_TIPO_VINC = i18n.VAL_OID ");
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_VINCU' ");
        query.append(" AND vincu.PAIS_OID_PAIS = " + dto.getOidPais());
        //  Agregado por HRCS - Fecha 08/05/2007 - Incidencia Sicc20070250
        if (dto instanceof DTOCodigoCliente)    {
            //  Agregado por HRCS - Fecha 03/04/2007 - Incidencia Sicc20070184
            Long oidTipoCliente = ((DTOCodigoCliente)dto).getOidTipoCliente();
            Long oidSubtipoCliente = ((DTOCodigoCliente)dto).getOidSubTipoCliente();
            if (oidTipoCliente!=null && oidSubtipoCliente!=null && 
                oidTipoCliente.longValue()==getOidTipoCliente(ConstantesMAE.COD_TIPO_CLIEN_HIJADUPLA).longValue() &&
                oidSubtipoCliente.longValue()==getOidSubtipoCliente(ConstantesMAE.COD_TIPO_CLIEN_HIJADUPLA,ConstantesMAE.COD_SUBTIPO_CLIEN_HIJADUPLA).longValue())   {
                query.append(" AND vincu.cod_tipo_vinc = '"+ ConstantesMAE.COD_TIPO_VINCULO_DUPLACYZONE +"'");
            }
            else    {
                query.append(" AND vincu.cod_tipo_vinc <> '"+ ConstantesMAE.COD_TIPO_VINCULO_DUPLACYZONE +"'");
            }
        }
        query.append(" ORDER BY i18n.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener vinculo por pais", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposVinculosPais(DTOBelcorp): Salida");

        return rs;
    }

    public RecordSet obtenerTiposPreferenciasPorPais(DTOBelcorp dto) throws MareException {
        // Se hace una consulta JDBC en la tabla MAE_TIPO_PREFE y obtenemos todos los registros cuyo PAIS_OID_PAIS 
        // coincida con el pais del dto. 
        // Para cada registro obtenemos el campo OID_TIPO_PREF y la descripcion de la tabla internacionalizable 
        // para el pais indicado por el dto de entrada. 
        // Devolvemos un recordset con los oid y descripcion de los registros obtenidos para el pais
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposPreferenciasPorPais(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT prefe.OID_TIPO_PREF, i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_PREFE prefe, V_GEN_I18N_SICC i18n  ");
        query.append(" WHERE prefe.OID_TIPO_PREF = i18n.VAL_OID ");
        query.append(" AND prefe.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_PREFE' ");
        query.append(" ORDER BY 2");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener preferencias por pais", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposPreferenciasPorPais(DTOBelcorp): Salida");

        return rs;
    }

    public RecordSet obtenerEstadosCiviles(DTOBelcorp dto) throws MareException {
        // Se hace una consulta MAE_ESTAD_CIVIL y se obtienen de todos los registros el 
        // OID_ESTA_CIVI y la descripcion de la tabla de idiomas, para el idioma que 
        // indica el dto. 
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerEstadosCiviles(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT civil.OID_ESTA_CIVI, i18n.VAL_I18N ");
        query.append(" FROM MAE_ESTAD_CIVIL civil, V_GEN_I18N_SICC i18n  ");
        query.append(" WHERE civil.OID_ESTA_CIVI = i18n.VAL_OID ");
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_ESTAD_CIVIL' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener Estados civiles por pais", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerEstadosCiviles(DTOBelcorp): Salida");

        return rs;
    }

    public RecordSet obtenerNivelesEstudiosPorPais(DTOBelcorp dto) throws MareException {
        // Hacemos una consulta JDBC MAE_NIVEL_ESTUD y obtenemos todos los registros cuyo campo PAIS_OID_PAIS coincida 
        // con el pais del dto. 
        // Para cada registro obtenemos el OID_NIVE_ESTU y la descripcion cruzando con la tabla i18n para el idioma
        // indicado por el dto.
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerNivelesEstudiosPorPais(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT estudio.OID_NIVE_ESTU, i18n.VAL_I18N ");
        query.append(" FROM MAE_NIVEL_ESTUD  estudio, V_GEN_I18N_SICC i18n ");
        query.append(" WHERE estudio.OID_NIVE_ESTU = i18n.VAL_OID ");
        query.append(" AND estudio.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_NIVEL_ESTUD' ");
        query.append(" ORDER BY i18n.VAL_I18N");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener nivel de estudios por pais", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerNivelesEstudiosPorPais(DTOBelcorp): Salida");
        return rs;
    }

    public RecordSet buscarTipoNSEPPorPais(DTOBelcorp dto) throws MareException {
        // Realizamos la siguiente consulta JDBC y devolvemos el resultado en un recordset: 
        // Obtenemos los campos OID_NSEP y descripcion (de la tabla i18n) de la tabla MAE_TIPO_NIVEL_SOCEC_PERSO
        // para aquellos registros que cumplan PAIS_OID_PAIS = dto.pais
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.buscarTipoNSEPPorPais(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT nse.OID_NSEP, i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_NIVEL_SOCEC_PERSO nse, V_GEN_I18N_SICC i18n ");
        query.append(" WHERE  nse.OID_NSEP = i18n.VAL_OID ");
        query.append(" AND nse.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_NIVEL_SOCEC_PERSO' ");
        query.append(" ORDER BY i18n.VAL_I18N");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener NSE por pais", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.buscarTipoNSEPPorPais(DTOBelcorp): Salida");
        return rs;
    }

    public RecordSet obtenerTiposComunicacionPorPais(DTOBelcorp dto) throws MareException {
        // ESTO decia el Decu, aunque hable de documento se implantto con comunicacion
        // Hacemos una consulta JDBC sobre la tabla MAE_TIPO_DOCUM y obtenemos los registros cuyo PAIS_OID_PAIS coincide con 
        //el pais del dto. 
        // Para cada registro obtenemos el OID_TIPO_DOCU y la descripcion de la tabla i18n para el idioma indicado por el dto.
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposComunicacionPorPais(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT com.OID_TIPO_COMU, i18n.VAL_I18N  ");
        query.append(" FROM MAE_TIPO_COMUN COM, V_GEN_I18N_SICC i18n  ");
        query.append(" WHERE  com.OID_TIPO_COMU= i18n.VAL_OID ");
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_COMUN' ");
        query.append(" ORDER BY i18n.val_i18n ASC ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener NSE por pais", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposComunicacionPorPais(DTOBelcorp): Salida");
        return rs;
    }

    public RecordSet obtenerTiposTarjeta(DTOBelcorp dto) throws MareException {
        // Hacemos una consulta JDBC sobre la tabla MAE_TIPO_TARJE y obtenemos para todos los registros el OID_TIPO_TARJ 
        // y la descripción el el idioma que indica el dto (cruzando con la tabla de i18n).
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposTarjeta(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT tarj.OID_TIPO_TARJ, i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_TARJE tarj, V_GEN_I18N_SICC i18n ");
        query.append(" WHERE tarj.OID_TIPO_TARJ = i18n.VAL_OID ");
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_TARJE' ");
        query.append(" ORDER BY i18n.val_i18n ASC ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener Tipos Tarjeta", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposTarjeta(DTOBelcorp): Salida");

        return rs;
    }

    public RecordSet obtenerClasesTarjeta(DTOBelcorp dto) throws MareException {
        // Hacemos una consulta JDBC sobre la tabla MAE_CLASE_TARJE y para todos los registros obtenemos los campos: 
        // OID_CLAS_TARJ y DES_CLAS_TARJ
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasesTarjeta(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append("  SELECT tarj.oid_clas_tarj, tarj.des_clas_tarj ");
        query.append("    FROM mae_clase_tarje tarj ");
        query.append("   ORDER BY 2 ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener Classes Tarjeta", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasesTarjeta(DTOBelcorp): Salida");

        return rs;
    }

    public RecordSet obtenerTiposProblemaPais(DTOBelcorp dto) throws MareException {
        // Se hace una consulta JDBC MAE_TIPO_PROBL y obtenemos los registros cuyo PAIS_OID_PAIS coincide con el pais del dto. 
        // Para cada registro obtenemos el campo OID_TIPO_PROB y la descripcion en el idioma indicado por el dto (cruzando con 
        // la tabla i18n).
        // Hacemos una consulta JDBC sobre la tabla MAE_CLASE_TARJE y para todos los registros obtenemos los campos: 
        // OID_CLAS_TARJ y DES_CLAS_TARJ
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposProblemaPais(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT problema.OID_TIPO_PROB, i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_PROBL problema, V_GEN_I18N_SICC i18n ");
        query.append(" WHERE problema.OID_TIPO_PROB = i18n.VAL_OID ");
        query.append(" AND problema.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_PROBL' ");
        query.append(" ORDER BY i18n.val_i18n ASC ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener Tipos Problema por pais", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposProblemaPais(DTOBelcorp): Salida");

        return rs;
    }

    public RecordSet obtenerTiposSolucionPais(DTOBelcorp dto) throws MareException {
        // Se hace una consulta JDBC MAE_TIPO_SOLUC y obtenemos los registros cuyo PAIS_OID_PAIS coincide con el pais del dto
        // de entrada. 
        // Para cada registro obtenemos los campos OID_TIPO_SOLU y descripcion en el idioma indicado por el dto (de la tabla i18n).
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposProblemaPais(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT solucion.OID_TIPO_SOLU, i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_SOLUC solucion, V_GEN_I18N_SICC i18n ");
        query.append(" WHERE solucion.OID_TIPO_SOLU = i18n.VAL_OID ");
        query.append(" AND solucion.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_SOLUC' ");
        query.append(" ORDER BY i18n.val_i18n ASC ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener Tipo Solucion  por pais", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposProblemaPais(DTOBelcorp): Salida");

        return rs;
    }

    public RecordSet obtenerPerfilesPsicograficosPais(DTOBelcorp dto) throws MareException {
        // Realizamos un consulta JDBC sobre la tabla MAE_TIPO_PERFI_PSICO y obtenemos el OID_TIPO_PERF_PSIC y la descripción 
        // (de la tabla internacional para el idioma indicado por el dto) para aquellos registro cuyo campo PAIS_OID_PAIS coincida
        // con el pais de entrada.
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerPerfilesPsicograficosPais(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT perfil.OID_TIPO_PERF_PSIC, i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_PERFI_PSICO perfil, V_GEN_I18N_SICC i18n ");
        query.append(" WHERE perfil.OID_TIPO_PERF_PSIC = i18n.VAL_OID ");

        /* Incidencia BELC300015706, se ha eliminado el campo de la tabla */

        // query.append(" AND perfil.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_PERFI_PSICO' ");
        query.append(" AND i18n.ATTR_NUM_ATRI = 1 ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener Perfiles Psicograficos por pais", e);
        }
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerPerfilesPsicograficosPais(DTOBelcorp): Salida");

        return rs;
    }

    public DTOClasificaciones obtenerClasificacionesSubtipo(DTOOIDs dto) throws MareException {
        // Construyo un string con los oids pasados como parametro separados por coma, para usar en las consultas select
        // Ej, si me pasaron los oids 130,131 y 132, la cadena oidsList va a contener "130,131,132".
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificacionesSubtipo(DTOOIDs): Entrada");
        Long[] oids = dto.getOids();
        StringBuffer oidsList = new StringBuffer();

        for (int y = 0; y < oids.length; y++) {
            if (y != 0) {
                oidsList.append(",");
            }

            oidsList.append(oids[y]);
        }

        DTOClasificaciones dtoOut = new DTOClasificaciones();

        // Obtiene los tipos de clasificacion y clasificaciones para el subtipo indicado. 
        // Para ello realiza las siguientes consultas JDBC para rellenar los dos recordsets del DTOClasificaciones 
        // que vamos a devolver. 
        StringBuffer query = new StringBuffer();
        query.append(" SELECT clasi.OID_TIPO_CLAS, i18n.VAL_I18N ,clasi.SBTI_OID_SUBT_CLIE ");
        query.append(" FROM MAE_TIPO_CLASI_CLIEN  clasi, V_GEN_I18N_SICC i18n ");
        query.append(" WHERE clasi.OID_TIPO_CLAS = i18n.VAL_OID ");
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND i18n.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
        query.append("  AND clasi.SBTI_OID_SUBT_CLIE  IN ( " + oidsList.toString() + " ) order by 2");

        RecordSet rs = null;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener tiposClasificacion", e);
        }

        dtoOut.setTipoClasificacion(rs);

        // tiposClasificacion: obtenemos de la tabla MAE_TIPO_CLASI_CLIEN los campos OID_TIPO_CLAS y descripcion (de la tabla 
        // i18n en el idioma que indica el dto) de los registros que tengan el campo SBTI_OID_SUBT_CLIE igual que el oid 
        // contenido en el dto de entrada. 
        StringBuffer query2 = new StringBuffer();
        query2.append(" SELECT clasi.OID_CLAS,  i18n.VAL_I18N ,clasi.TCCL_OID_TIPO_CLAS ");
        query2.append(" FROM MAE_CLASI clasi, V_GEN_I18N_SICC i18n ,MAE_TIPO_CLASI_CLIEN  tipoclasi ");
        query2.append(" WHERE clasi.OID_CLAS = i18n.VAL_OID ");
        query2.append(" AND clasi.TCCL_OID_TIPO_CLAS = tipoclasi.OID_TIPO_CLAS ");
        query2.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query2.append("  AND i18n.ATTR_ENTI = 'MAE_CLASI' ");
        query2.append("  AND tipoclasi.SBTI_OID_SUBT_CLIE IN (" + oidsList.toString() + " ) order by 2 ");

        RecordSet rs2 = null;

        try {
            rs2 = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query2.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener Clasificacion", e);
        }

        dtoOut.setClasificacion(rs2);
        
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificacionesSubtipo(DTOOIDs): Salida");
        return dtoOut;
    }

    /*************************************  TEST MAIN *************************/
    public static void main(String[] args) {
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes("usuario1");

        DTOBelcorp dtoIn = new DTOBelcorp();
        dtoIn.setOidIdioma(new Long(1));
        dtoIn.setOidPais(new Long(1));

        try {
            UtilidadesLog.info(dao.obtenerTipos(dtoIn));
        } catch (MareException mareException) {
            mareException.printStackTrace();
        }
    }

    public DTOSalida obtenerSubtipos(DTOOID dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerSubtipos(DTOOID): Entrada");
        DTOSalida dtos = new DTOSalida();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT S.OID_SUBT_CLIE, ");
        query.append(" D.VAL_I18N ");
        query.append(" FROM MAE_SUBTI_CLIEN S, v_gen_i18n_sicc D ");
        query.append(" where S.OID_SUBT_CLIE = D.VAL_OID ");
        query.append(" and D.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" and D.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
        query.append(" and S.TICL_OID_TIPO_CLIE = " + dto.getOid());
        query.append(" order by D.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener subtipos", e);
        }

        dtos.setResultado(rs);
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerSubtipos(DTOOID): Salida");

        return dtos;
    }

    public DTOSalida obtenerTipoClasificacion(DTOOID dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipoClasificacion(DTOOID): Entrada");
        DTOSalida dtos = new DTOSalida();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT S.OID_TIPO_CLAS, ");
        query.append(" D.VAL_I18N ");
        query.append(" FROM MAE_TIPO_CLASI_CLIEN S, v_gen_i18n_sicc D ");
        query.append(" where S.OID_TIPO_CLAS = D.VAL_OID ");
        query.append(" and D.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" and D.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
        query.append(" and S.SBTI_OID_SUBT_CLIE = " + dto.getOid());
        query.append(" order by D.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener tipos clasificaciones", e);
        }

        dtos.setResultado(rs);
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipoClasificacion(DTOOID): Salida");

        return dtos;
    }

    public DTOSalida obtenerClasificacionesPorTipo(DTOOID dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificacionesPorTipo(DTOOID): Entrada");
        DTOSalida dtos = new DTOSalida();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT S.OID_CLAS, ");
        query.append(" D.VAL_I18N ");
        query.append(" FROM MAE_CLASI S, v_gen_i18n_sicc D ");
        query.append(" where S.OID_CLAS = D.VAL_OID ");
        query.append(" and D.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" and D.ATTR_ENTI = 'MAE_CLASI' ");
        query.append(" and S.TCCL_OID_TIPO_CLAS = " + dto.getOid());
        query.append(" order by D.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener clasificaciones", e);
        }

        dtos.setResultado(rs);
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificacionesPorTipo(DTOOID): Salida");

        return dtos;
    }

    public static RecordSet obtenerClasificacionesCliente(Long tipoClasificacion, String tipoCliente, Long idioma) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificacionesCliente(tipoClasificacion, tipoCliente, idioma): Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();

        /*DTOSalida dtos = new DTOSalida();*/
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();

            //SELECT
            query.append("SELECT cla.OID_CLIE_CLAS, ");

            //Descripcion de clasificación
            query.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
            query.append(" WHERE v.VAL_OID= clas.OID_CLAS ");
            query.append(" AND v.IDIO_OID_IDIO = " + idioma);
            query.append(" AND v.ATTR_NUM_ATRI = 1 ");
            query.append(" AND v.ATTR_ENTI = 'MAE_CLASI') as clasificacion , ");

            //Descripcion subtipo
            query.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
            query.append(" WHERE v.VAL_OID= sub.OID_SUBT_CLIE ");
            query.append(" AND v.IDIO_OID_IDIO = " + idioma);
            query.append(" AND v.ATTR_NUM_ATRI = 1 ");
            query.append(" AND v.ATTR_ENTI = 'MAE_SUBTI_CLIEN') as tiposubtipo , ");
            query.append(" cli.COD_CLIE ");
            
            /************* AGREGA MAE-015 INC.24082   *************/
            query.append(" , ");
            query.append(" cli.OID_CLIE, ");
            query.append(" sub.OID_SUBT_CLIE, ");
            query.append(" cla.TCCL_OID_TIPO_CLASI ");
            /********** FIN AGREGA MAE-015 INC.24082   ************/

            //FROM
            query.append("FROM MAE_CLIEN_CLASI cla, MAE_CLIEN_TIPO_SUBTI ts, ");
            query.append(" MAE_CLIEN cli, MAE_CLASI clas, MAE_SUBTI_CLIEN sub, ");
            query.append(" MAE_TIPO_CLIEN tip, MAE_TIPO_CLASI_CLIEN tc, ");
            query.append(" EDU_TIPO_CURSO cur, ");
            query.append(" (select trim(to_char(cod_tipo_curs,'00')) codigo_tipo_curso from EDU_TIPO_CURSO) tc2 ");

            //WHERE
            query.append(" WHERE cla.CTSU_OID_CLIE_TIPO_SUBT = ts.OID_CLIE_TIPO_SUBT AND");
            query.append(" ts.CLIE_OID_CLIE = cli.OID_CLIE AND ");
            query.append(" cla.CLAS_OID_CLAS = clas.OID_CLAS AND ");
            query.append(" ts.SBTI_OID_SUBT_CLIE = sub.OID_SUBT_CLIE AND ");
            query.append(" sub.TICL_OID_TIPO_CLIE = tip.OID_TIPO_CLIE AND ");
            query.append(" clas.TCCL_OID_TIPO_CLAS = tc.OID_TIPO_CLAS ");
            query.append(" AND to_char(tc.cod_tipo_clas) = to_char(cur.cod_tipo_curs) ");
            query.append(" AND tc2.codigo_tipo_curso = tc.COD_TIPO_CLAS ");

            if (tipoClasificacion != null) {
                //rgiorgi, 9/12/2004 - inc. 9623,10786
                query.append(" AND cur.oid_tipo_curs = " + tipoClasificacion.longValue());
            }

            if (tipoCliente != null) {
                query.append(" AND tip.COD_TIPO_CLIE = '" + tipoCliente + "'");
            }

            query.append("  ORDER BY 2,3");
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (resultado.esVacio()) {
            return new RecordSet();

            //throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerClasificacionesCliente(tipoClasificacion, tipoCliente, idioma): Salida");

        return resultado;
    }

    public DTOTipoSubtipoCliente obtenerTipoSubtipoCliente(Long cliente) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipoSubtipoCliente(Long cliente): Entrada");
        DTOTipoSubtipoCliente salida = new DTOTipoSubtipoCliente();
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ticl_oid_tipo_clie, sbti_oid_subt_clie, ind_ppal, oid_clie_tipo_subt ");
        query.append(" FROM mae_clien_tipo_subti WHERE clie_oid_clie = "+cliente.toString());
        query.append(" ORDER BY ind_ppal desc, oid_clie_tipo_subt asc ");

        RecordSet rs;
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error en obtenerTipoSubtipoCliente ", e);
        }

        if (rs.esVacio()) {
            LogAPP.error("El cliente: " + cliente + " no tiene tipo/subtipo de cliente.");
            throw new MareException("Error en obtenerTipoSubtipoCliente, no hay tipo/subtipo cliente");
        } else {
            salida.setOid((rs.getValueAt(0, 3) != null) ? new Long(((BigDecimal) rs.getValueAt(0, 3)).longValue()) : null);
            salida.setPrincipal((rs.getValueAt(0, 2) != null) ? ((((BigDecimal) rs.getValueAt(0, 2)).intValue() == 1) ? Boolean.TRUE : Boolean.FALSE) : null);
            salida.setSubtipo((rs.getValueAt(0, 1) != null) ? new Long(((BigDecimal) rs.getValueAt(0, 1)).longValue()) : null);
            salida.setTipo((rs.getValueAt(0, 0) != null) ? new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue()) : null);
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipoSubtipoCliente(Long cliente): Salida");

        return salida;
    }


    public DTOTipoSubtipoCliente obtenerTipoPrincipalCliente(Long cliente) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipoPrincipalCliente(cliente): Entrada");
        DTOTipoSubtipoCliente salida = new DTOTipoSubtipoCliente();
        StringBuffer query = new StringBuffer();

        query.append("SELECT ticl_oid_tipo_clie, sbti_oid_subt_clie, ind_ppal, oid_clie_tipo_subt ");
        query.append("  FROM mae_clien_tipo_subti ");
        query.append(" WHERE ind_ppal = 1 ");
        query.append("   AND clie_oid_clie = " + cliente);
        query.append(" ORDER BY oid_clie_tipo_subt ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error en obtenerTipoPrincipalCliente ", e);
        }

        if (rs.esVacio()) {
            salida.setPrincipal(Boolean.TRUE);
        } else {
            if (rs.getRowCount() > 1) {
                LogAPP.error("El cliente: " + cliente + " tiene más de un tipo de cliente marcado como principal, el sistema está inconsistente.");
            }

            salida.setOid((rs.getValueAt(0, 3) != null) ? new Long(((BigDecimal) rs.getValueAt(0, 3)).longValue()) : null);

            salida.setPrincipal((rs.getValueAt(0, 2) != null) ? ((((BigDecimal) rs.getValueAt(0, 2)).intValue() == 1) ? Boolean.TRUE : Boolean.FALSE) : null);

            salida.setSubtipo((rs.getValueAt(0, 1) != null) ? new Long(((BigDecimal) rs.getValueAt(0, 1)).longValue()) : null);
            salida.setTipo((rs.getValueAt(0, 0) != null) ? new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue()) : null);
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTipoPrincipalCliente(cliente): Salida");

        return salida;
    }

    /**
     * Obtiene el primer registro de tipo de cliente que no sea principal (ind_ppal != 1)
     * fecha de Creacion: 30/01/2007
     * Autor: HRCS
     * Motivo: Incidencia reportada en Preproductivo, los tipos de cliente tienen ind_ppal=0 y puede haber mas de un registro.
     */
    public DTOTipoSubtipoCliente obtenerPrimerTipoClienteNoPrincipal(Long cliente) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerPrimerTipoClienteNoPrincipal(cliente): Entrada");
        DTOTipoSubtipoCliente salida = new DTOTipoSubtipoCliente();
        StringBuffer query = new StringBuffer();

        query.append("SELECT ticl_oid_tipo_clie, sbti_oid_subt_clie, ind_ppal, oid_clie_tipo_subt ");
        query.append("  FROM mae_clien_tipo_subti ");
        query.append(" WHERE ind_ppal = 0 ");
        query.append("   AND clie_oid_clie = " + cliente);
        query.append("   AND rownum = 1 ");

        RecordSet rs;
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error en obtenerPrimerTipoClienteNoPrincipal ", e);
        }

        if (!rs.esVacio()) {
        
            salida.setOid((rs.getValueAt(0, 3) != null) ? new Long(((BigDecimal) rs.getValueAt(0, 3)).longValue()) : null);
            salida.setPrincipal((rs.getValueAt(0, 2) != null) ? ((((BigDecimal) rs.getValueAt(0, 2)).intValue() == 1) ? Boolean.TRUE : Boolean.FALSE) : null);
            salida.setSubtipo((rs.getValueAt(0, 1) != null) ? new Long(((BigDecimal) rs.getValueAt(0, 1)).longValue()) : null);
            salida.setTipo((rs.getValueAt(0, 0) != null) ? new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue()) : null);
        }
        else {
            LogAPP.error("El cliente: " + cliente + " no tiene registro de tipo de cliente, ni tampoco marcado como principal.");
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerPrimerTipoClienteNoPrincipal(cliente): Salida");

        return salida;
    }

    public RecordSet obtenerCiclosVida(DTOBelcorp dto) throws MareException {
        // Se hace una consulta MAE_CICLO_VIDA y se obtienen de todos los registros el 
        // OID_CICL_VIDA y la descripcion de la tabla de idiomas, para el idioma que 
        // indica el dto. 
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerCiclosVida(DTOBelcorp): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT m.OID_CICL_VIDA, i18n.val_i18n");
        query.append("   FROM mae_ciclo_vida m, v_gen_i18n_sicc i18n");
        query.append("  WHERE m.OID_CICL_VIDA = i18n.val_oid");
        query.append("   and m.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append("  AND i18n.idio_oid_idio = " + dto.getOidIdioma());
        query.append(" AND i18n.attr_enti = 'MAE_CICLO_VIDA'");
        query.append(" order by 2 ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener ciclos de vida por pais", e);
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerCiclosVida(DTOBelcorp): Salida");

        return rs;
    }

    public RecordSet obtenerTiposDocumentoCliente(DTOOID cliente) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposDocumentoCliente(DTOOID): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT TDOC_OID_TIPO_DOCU, i.VAL_I18N ");
        query.append(" FROM MAE_CLIEN_IDENT, v_gen_i18n_sicc i  ");
        query.append(" WHERE CLIE_OID_CLIE = " + cliente.getOid());
        query.append(" and i.ATTR_ENTI = 'MAE_TIPO_DOCUM' ");
        query.append(" and i.VAL_OID = TDOC_OID_TIPO_DOCU ");
        query.append(" and i.ATTR_NUM_ATRI = 1 ");
        query.append(" and i.IDIO_OID_IDIO = " + cliente.getOidIdioma());
        query.append(" ORDER BY VAL_IDEN_DOCU_PRIN DESC ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener ciclos de vida por pais", e);
        }

        if (rs.esVacio()) {
            return new RecordSet();
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposDocumentoCliente(DTOOID): Salida");

        return rs;
    }
    
     /**
      * CHANGELOG
      * ---------
      * Error MAE-002 - dmorello, 17/10/2008 - El primer campo devuelto se llamara OID
      */
     public DTOSalida obtenerValoresDefectoClientes(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerValoresDefectoClientes(DTOBelcorp dtoe) : Entrada");
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet rs;

        query.append("  SELECT doc.oid_tipo_docu AS oid, 'MAE_TIPO_DOCUM' AS codigo ");
        query.append("    FROM mae_tipo_docum doc ");
        query.append("   WHERE doc.cod_tipo_docu = '01' AND doc.pais_oid_pais = ? ");
        parametros.add( dtoe.getOidPais() );
        query.append("  UNION ");
        query.append("  SELECT marc.oid_marc, 'SEG_MARCA' AS codigo ");
        query.append("    FROM seg_marca marc ");
        query.append("   WHERE marc.cod_marc = 'T' ");
        query.append("  UNION ");
        query.append("  SELECT can.oid_cana, 'SEG_CANAL' AS codigo ");
        query.append("    FROM seg_canal can ");
        query.append("   WHERE can.cod_cana = 'VD' ");
        query.append("  UNION ");
        query.append("  SELECT tip.oid_tipo_dire, 'MAE_TIPO_DIREC' AS codigo ");
        query.append("    FROM mae_tipo_direc tip ");
        query.append("   WHERE tip.cod_tipo_dire = '01' ");
        query.append("  UNION ");
        query.append("  SELECT tip.oid_tipo_clie AS OID, 'MAE_TIPO_CLIEN' AS codigo ");
        query.append("    FROM mae_tipo_clien tip ");
        query.append("   WHERE tip.cod_tipo_clie = '02' ");
        query.append("  UNION ");
        query.append("  SELECT OID, codigo ");
        query.append("    FROM (SELECT oid_peri AS OID, codigo, ROWNUM AS r ");
        query.append("            FROM (SELECT   p.oid_peri, 'CRA_PERIO' AS codigo ");
        query.append("                      FROM cra_perio p, seg_marca marc, seg_canal can ");
        query.append("                     WHERE fec_inic <= SYSDATE ");
        query.append("                       AND SYSDATE <= fec_fina ");
        query.append("                       AND pais_oid_pais = ? ");
        parametros.add( dtoe.getOidPais() );
        query.append("                       AND marc.cod_marc = 'T' ");
        query.append("                       AND can.cod_cana = 'VD' ");
        query.append("                       AND p.cana_oid_cana = can.oid_cana ");
        query.append("                       AND marc.oid_marc = p.marc_oid_marc ");
        query.append("                  ORDER BY fec_inic ASC)) ");
        query.append("   WHERE r < 2 ");

        
        try {
            rs = (RecordSet) getBelcorpService().dbService.executePreparedQuery(query.toString(), parametros);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener valores por defecto", e);
        }

        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerValoresDefectoClientes(DTOBelcorp dtoe) : Salida");
        return new DTOSalida(rs);
     }
    
    /**
     * Nuevo metodo que verifica si la recomendante es valida para DuplaCyzone:
     *  - No debe tener un tipo de vinculo "DuplaCyzone" y
     *  - No puede tener el tipo de cliente "Hija Dupla"
     * @throws es.indra.mare.common.exception.MareException
     * @return Boolean
     * @param dto DTOCodigoCliente
     */
    public DTOBoolean validarRecomendanteEnHijaDupla(DTOCodigoCliente dto) throws MareException {

        UtilidadesLog.info(" DAOMAEConfiguracionClientes.validarRecomendanteEnHijaDupla(): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" select c.oid_clie, c.cod_clie, cts.ticl_oid_tipo_clie, cts.sbti_oid_subt_clie, cv.* ");
        query.append(" from mae_clien c, mae_clien_vincu cv, mae_clien_tipo_subti cts ");
        query.append(" where c.cod_clie = '"+ dto.getCodigoCliente() +"' ");
        query.append(" AND c.oid_clie = cv.clie_oid_clie_vnte(+) ");
        query.append(" AND c.oid_clie = cts.clie_oid_clie(+) ");
        query.append(" AND ");
        query.append(" ( cv.tivc_oid_tipo_vinc=(select oid_tipo_vinc from mae_tipo_vincu where cod_tipo_vinc='"+ConstantesMAE.COD_TIPO_VINCULO_DUPLACYZONE+"')");
	    query.append("   OR ");
	    query.append("   cts.ticl_oid_tipo_clie=(select oid_tipo_clie from mae_tipo_clien where cod_tipo_clie='"+ ConstantesMAE.COD_TIPO_CLIEN_HIJADUPLA + "') )");
        RecordSet rs;
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al validar recomendante cuando es HijaDupla", e);
        }
        //  Creamos el DTOBoolean de retorno
        DTOBoolean dtoB = new DTOBoolean();
        if (rs.esVacio())  {
            dtoB.setValor( true );
        }
        else    {
            dtoB.setValor( false );
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.validarRecomendanteEnHijaDupla(): Salida");
        return dtoB;
    }
    
    /**
     * Nuevo metodo que valida la edad de la Hija Dupla
     * @throws es.indra.mare.common.exception.MareException
     * @return Boolean
     * @param dto DTOCodigoCliente
     */
    public DTOBoolean validarEdadHijaDupla(DTOCodigoCliente dto) throws MareException {

        UtilidadesLog.info(" DAOMAEConfiguracionClientes.validarEdadHijaDupla(): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT ce.val_edad_mini, ce.val_edad_maxi ");
        query.append(" FROM mae_clien_edad ce ");
        query.append(" WHERE ce.pais_oid_pais="+ dto.getOidPais() );
        //query.append(" AND ce.ticl_oid_tipo_clie=(select oid_tipo_clie from mae_tipo_clien where cod_tipo_clie='"+ ConstantesMAE.COD_TIPO_CLIEN_HIJADUPLA +"')");
        //query.append(" AND ce.sbti_oid_subt_clie=(select oid_subt_clie from mae_subti_clien where cod_subt_clie='"+ ConstantesMAE.COD_SUBTIPO_CLIEN_HIJADUPLA +"' and ticl_oid_tipo_clie=ce.ticl_oid_tipo_clie)" );
        query.append(" AND ce.sbti_oid_subt_clie=(SELECT sc.oid_subt_clie ");
		query.append(" FROM mae_subti_clien sc, mae_tipo_clien tc ");
		query.append(" WHERE sc.ticl_oid_tipo_clie = tc.oid_tipo_clie "); 
        query.append(" AND sc.cod_subt_clie = '"+ ConstantesMAE.COD_SUBTIPO_CLIEN_HIJADUPLA +"' ");
		query.append(" AND tc.cod_tipo_clie = '"+ ConstantesMAE.COD_TIPO_CLIEN_HIJADUPLA +"') ");
        RecordSet rs;
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al recuperar datos para validar edad cuando es HijaDupla.", e);
        }
        //  Creamos el DTOBoolean de retorno
        DTOBoolean dtoB = new DTOBoolean();
        if (rs.esVacio())  {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("No se encontraron datos para validar edad cuando es HijaDupla.", 
            UtilidadesError.armarCodigoError(error));
        }
        else    {
            if (dto.getEdad()!=null)  {
                int edad = dto.getEdad().intValue();
                if (edad >= 0) {
                    dtoB.setValor( true );
                    if (rs.getValueAt(0,0)!=null)   {
                        int edadMinima = ((BigDecimal)rs.getValueAt(0,0)).intValue();
                        if (edad < edadMinima) {
                            dtoB.setValor( false );
                        }
                    }
                    if (rs.getValueAt(0,1)!=null)   {
                        int edadMaxima = ((BigDecimal)rs.getValueAt(0,1)).intValue();
                        if (edad > edadMaxima)   {
                            dtoB.setValor( false );
                        }                        
                    }
                }
                else    {
                    throw new MareException("Debe ingresar la Fecha de Nacimiento del cliente.");
                }
            }
            else    {
                throw new MareException("Debe ingresar la Fecha de Nacimiento del cliente.");
            }
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.validarEdadHijaDupla(): Salida");
        return dtoB;
    }
    
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @param dto DTOCodigoCliente
     */
    public DTOSalida recuperarTipoSubtipoCliente(DTOCodigoCliente dto) throws MareException {

        UtilidadesLog.info(" DAOMAEConfiguracionClientes.recuperarTipoSubtipoCliente(): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT c.oid_clie, c.cod_clie, cts.ticl_oid_tipo_clie, cts.sbti_oid_subt_clie ");
        query.append(" ,(select oid_tipo_clie from mae_tipo_clien where cod_tipo_clie='"+ConstantesMAE.COD_TIPO_CLIEN_HIJADUPLA+"') as CONST_HIJADUPLA ");
        query.append(" ,(select oid_tipo_clie from mae_tipo_clien where cod_tipo_clie='"+ConstantesMAE.TIPO_CLIENTE_CONSULTORA+"') as CONST_CONSULTORA ");
        query.append(" FROM mae_clien c, mae_clien_tipo_subti cts ");
        query.append(" WHERE c.cod_clie = '"+ dto.getCodigoCliente() +"' ");
        query.append(" AND c.oid_clie = cts.clie_oid_clie(+) ");
        RecordSet rs;
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al recuperar tipo y subtipo del cliente", e);
        }
        //  Creamos el DTOBoolean de retorno
        DTOSalida salida = new DTOSalida();
        if (!rs.esVacio())  {
            salida.setResultado(rs);
        }
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.recuperarTipoSubtipoCliente(): Salida");
        return salida;
    }
    
    private static Hashtable htTiposVinculos;
    
    /**
     * Metodo que arma un Hashtable en memoria para tener los vinculos asociados a un pais
     */
    public Long getOidTipoVinculo(Long pais, String codigoTipoVinculo) throws MareException {
        
        if (htTiposVinculos==null)  {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT pais_oid_pais, oid_tipo_vinc, cod_tipo_vinc FROM mae_tipo_vincu ");
            RecordSet rs;
            try {
                rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
            } catch (MareException me) {
                throw me;
            } catch (Exception e) {
                throw new MareException("Error al recuperar los tipos de vinculos", e);
            }
            if (!rs.esVacio())  {
                htTiposVinculos = new Hashtable();
                for(int i=0;i<rs.getRowCount();i++)   {
                    Long oidPais = new Long( ((BigDecimal)rs.getValueAt(i,0)).longValue() );
                    Long oidTipoVinc = new Long( ((BigDecimal)rs.getValueAt(i,1)).longValue() );
                    String codTipoVinc = (String)rs.getValueAt(i,2);
                    htTiposVinculos.put( oidPais.toString()+"-"+codTipoVinc, oidTipoVinc);
                }
            }
            UtilidadesLog.debug("Hashtable TiposVinculos: " + htTiposVinculos );
        }
        if (htTiposVinculos.containsKey(pais.toString()+"-"+codigoTipoVinculo))   {
            return (Long)htTiposVinculos.get(pais.toString()+"-"+codigoTipoVinculo);
        }
        else return null;
    }
    
    private static Hashtable htTiposCliente;

    /**
     * Metodo que arma un hashtable en memoria con los tipos de clientes
     */
    public Long getOidTipoCliente(String codigoTipoCliente) throws MareException {
        
        if (htTiposCliente==null)  {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT tc.oid_tipo_clie, tc.cod_tipo_clie FROM mae_tipo_clien tc ");
            RecordSet rs;
            try {
                rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
            } catch (MareException me) {
                throw me;
            } catch (Exception e) {
                throw new MareException("Error al recuperar los tipos de cliente", e);
            }
            if (!rs.esVacio())  {
                htTiposCliente = new Hashtable();
                for(int i=0;i<rs.getRowCount();i++)   {

                    Long oidTipoClie = new Long(((BigDecimal)rs.getValueAt(i,0)).longValue());
                    String codTipoClie = (String)rs.getValueAt(i,1);
                    htTiposCliente.put( codTipoClie, oidTipoClie );
                }
            }
            UtilidadesLog.debug("Hashtable TiposClientes: " + htTiposCliente );
        }
        if (htTiposCliente.containsKey(codigoTipoCliente))   {
            return (Long)htTiposCliente.get(codigoTipoCliente);
        }
        else return null;
    }
    
    private static Hashtable htSubtipoCliente;
    
    /**
     * Metodo que arma en memoria un hashtable con los subtipos de cliente
     */
    public Long getOidSubtipoCliente(String codigoTipoCliente, String codigoSubTipoCliente) throws MareException {
        
        if (htSubtipoCliente==null)  {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT tc.cod_tipo_clie, sc.oid_subt_clie, sc.cod_subt_clie ");
            query.append(" FROM mae_tipo_clien tc, mae_subti_clien sc ");
            query.append(" WHERE tc.oid_tipo_clie = sc.ticl_oid_tipo_clie ");
            query.append(" ORDER BY tc.oid_tipo_clie, sc.oid_subt_clie ");
            RecordSet rs;
            try {
                rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
            } catch (MareException me) {
                throw me;
            } catch (Exception e) {
                throw new MareException("Error al recuperar los tipos de cliente", e);
            }
            if (!rs.esVacio())  {
                htSubtipoCliente = new Hashtable();
                for(int i=0;i<rs.getRowCount();i++)   {

                    String codTipoClie = (String)rs.getValueAt(i,0);
                    Long oidSubtClie = new Long(((BigDecimal)rs.getValueAt(i,1)).longValue());
                    String codSubtClie = (String)rs.getValueAt(i,2);

                    htSubtipoCliente.put( codTipoClie + "-"+ codSubtClie, oidSubtClie );
                }
            }
            UtilidadesLog.debug("Hashtable SubTiposClientes: " + htSubtipoCliente );
        }
        if (htSubtipoCliente.containsKey(codigoTipoCliente+"-"+codigoSubTipoCliente))   {
            return (Long)htSubtipoCliente.get(codigoTipoCliente+"-"+codigoSubTipoCliente);
        }
        else return null;
    }

}
