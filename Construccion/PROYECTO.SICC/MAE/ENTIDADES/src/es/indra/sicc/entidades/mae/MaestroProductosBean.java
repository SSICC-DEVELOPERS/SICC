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

package es.indra.sicc.entidades.mae;

import es.indra.mare.common.exception.MareException;

/**
 * Sistema:         Belcorp
 * Modulo:           MAE
 * Submódulo:     Mantenimiento de Materiales
 * Componente:   DAO's
 * Fecha:             02/12/2003
 * Observaciones:
 *
 * @version          1.0
 * @autor             Luis Ramos
 */
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.auditoria.EntidadSICCAuditableBean;
import es.indra.sicc.cmn.negocio.i18n.MONI18nHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;

import es.indra.sicc.util.UtilidadesLog;
import java.lang.StringBuffer;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;


/*
 * rgiorgi - 19/8/2005: se formatea la clase
 * pperanzola - 12/09/2005: se agrega el campo COD_UNIC_VENT
 * pperanzola - 20/10/2005 - [1] se modifica segun SICC-DMCO-PRE_MAE_INT-GCC-001 
 * */
public class MaestroProductosBean extends EntidadSICCAuditableBean {
    public String codigoUnicoVenta;
    private EntityContext context;
    private Long oid;
    private String codigoSAP;
    private Long pais;
    private String codigoAntiguo;
    private String descripcionCorta;
    private Boolean esLote;
    private Boolean indProductoServicio;
    private String jerarquia1;
    private String jerarquia2;
    private String jerarquia3;
    private String atributo1;
    private String atributo2;
    private String atributo3;
    private BigDecimal alto;
    private BigDecimal largo;
    private BigDecimal ancho;
    private BigDecimal volumen;
    private BigDecimal peso;
    private Integer unidadesDentroPedido;
    private Integer unidadesCaja;
    private BigDecimal costeEstandard;
    private BigDecimal precioPosicionamiento;
    private String situacion;
    private String indCajaBolsa;
    private Long formaPago;
    private String codigoImpuesto;
    private BigDecimal precioCatalogo;
    private BigDecimal precioContable;
    private Boolean esKit;
    private Integer porcentajeUnidades;
    private Long generico;
    private Long supergenerico;
    private Long status;
    private Long unidadMedidaDimensiones;
    private Long lineaDeProducto;
    private Long negocio;
    private Long periodoInicio;
    private Long periodoFin;
    private Long unidadMedidaPeso;
    private Long unidadMedidaVolumen;
    private Long marcaProducto;
    private Long unidadNegocio;
    private String grupoArticulos;
    public Long programaFidelizacion; //[1]

    public void ejbPostCreate() {
    }

    public MaestroProductosPK ejbCreate(Long paramOid, String paramCodSAP, Long paramPais, Long marcaProducto) throws CreateException {
        try {
            Vector val = new Vector();

            return ejbCreate(paramCodSAP, paramPais, val, marcaProducto);
        } catch (MareException me) {
            throw new CreateException("MaestroProductos. No se pudo crear el Entity Bean: " + me.getCause().toString());
        }
    }

    public void ejbPostCreate(Long paramOid, String paramCodSAP, Long paramPais, Long marcaProducto) {
    }

    public MaestroProductosPK ejbCreate(String paramCodSAP, Long paramPais, Vector valores, Long marcaProducto) throws MareException {
        Long paramOid = SecuenciadorOID.obtenerSiguienteValor("MAE_PROD_SEQ");
        codigoSAP = paramCodSAP;
        pais = paramPais;

        String codigoError;

        if (valores == null) {
            valores = new Vector();
        }

        try {
            BelcorpService rs = BelcorpService.getInstance();
            nombreTabla = "MAE_PRODU";

            StringBuffer sql = new StringBuffer();
            StringBuffer parametros = new StringBuffer();
            Vector v = new Vector();

            this.setOid(paramOid);

            sql.append(" INSERT INTO MAE_PRODU ( ");
            parametros.append(" VALUES ( ");

            if (paramCodSAP != null) {
                sql.append(" COD_SAP,");
                parametros.append(" ? , ");
                v.add(paramCodSAP);
            }

            if (paramPais != null) {
                sql.append(" PAIS_OID_PAIS,");
                parametros.append(" ? , ");
                v.add(paramPais);
            }

            if (marcaProducto != null) {
                sql.append(" MAPR_OID_MARC_PROD,");
                parametros.append(" ? , ");
                v.add(marcaProducto);
            }

            if (paramOid != null) {
                sql.append(" OID_PROD) ");
                parametros.append(" ? )");
                v.add(paramOid);
            }

            sql.append(parametros.toString());

            rs.dbService.executePreparedUpdate(sql.toString(), v);

            // inserto los valores de i18n
            setTraducciones(valores);

            //super.ejbCreate();

            return new MaestroProductosPK(paramOid);
        } catch (Exception ex) {
            codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public void ejbPostCreate(String paramCodSAP, Long paramPais, Vector valores, Long marcaProducto) throws MareException {
    }

    public MaestroProductosPK ejbFindByPrimaryKey(MaestroProductosPK primaryKey) throws FinderException {
        try {
            BelcorpService rs = BelcorpService.getInstance();
            String query = " SELECT * FROM MAE_PRODU WHERE 1=1  AND OID_PROD = ? ";
            Vector v = new Vector();
            v.add(primaryKey.oid);

            RecordSet r = rs.dbService.executePreparedQuery(query, v);

            if (r.getRowCount() != 1) {
                throw new FinderException("Entidad no existente");
            }

            return primaryKey;
        } catch (Exception ex) {
            throw new FinderException("MaestroProductos." + ex.getMessage());
        }
    }

    public void ejbActivate() {
    }

    public void ejbLoad() {
        MaestroProductosPK primaryKey = (MaestroProductosPK) context.getPrimaryKey();
        oid = primaryKey.oid;

        try {
            BelcorpService bs = BelcorpService.getInstance();
            String query = " SELECT * FROM MAE_PRODU WHERE 1=1  AND OID_PROD = ? ";
            Vector v = new Vector();
            v.add(primaryKey.oid);

            RecordSet rs = bs.dbService.executePreparedQuery(query, v);
            codigoAntiguo = (String) rs.getValueAt(0, "CODI_ANTI");
            codigoSAP = (String) rs.getValueAt(0, "COD_SAP");
            descripcionCorta = (String) rs.getValueAt(0, "DES_CORT");

            if (rs.getValueAt(0, "IND_LOTE") == null) {
                esLote = null;
            } else {
                esLote = (((BigDecimal) rs.getValueAt(0, "IND_LOTE")).intValue() == 1) ? new Boolean(true) : new Boolean(false);
            }

            if (rs.getValueAt(0, "IND_PROD_SERV") == null) {
                indProductoServicio = null;
            } else {
                indProductoServicio = (((BigDecimal) rs.getValueAt(0, "IND_PROD_SERV")).intValue() == 1) ? new Boolean(true) : new Boolean(false);
            }

            jerarquia1 = (String) rs.getValueAt(0, "VAL_JERA_1");
            jerarquia2 = (String) rs.getValueAt(0, "VAL_JERA_2");
            jerarquia3 = (String) rs.getValueAt(0, "VAL_JERA_3");
            atributo1 = (String) rs.getValueAt(0, "VAL_ATRI_1");
            atributo2 = (String) rs.getValueAt(0, "VAL_ATRI_2");
            atributo3 = (String) rs.getValueAt(0, "VAL_ATRI_3");
            alto = (BigDecimal) rs.getValueAt(0, "VAL_DIME_ALTO");
            largo = (BigDecimal) rs.getValueAt(0, "VAL_DIME_LARG");
            ancho = (BigDecimal) rs.getValueAt(0, "VAL_DIME_ANCH");
            volumen = (BigDecimal) rs.getValueAt(0, "VAL_VOLU");
            peso = (BigDecimal) rs.getValueAt(0, "VAL_PESO");
            unidadesDentroPedido = (rs.getValueAt(0, "NUM_UNID_DENT_PEDI") == null) ? null : new Integer(((BigDecimal) rs.getValueAt(0, "NUM_UNID_DENT_PEDI")).toString());
            unidadesCaja = (rs.getValueAt(0, "NUM_UNID_CAJA") == null) ? null : new Integer(((BigDecimal) rs.getValueAt(0, "NUM_UNID_CAJA")).toString());
            costeEstandard = (BigDecimal) rs.getValueAt(0, "VAL_COST_ESTD");
            precioPosicionamiento = (BigDecimal) rs.getValueAt(0, "VAL_PREC_POSI");

            /***  COMENTADO HASTA TANTO SE CORRA EL script BELCORP_03_057  ***/
            situacion = (String) rs.getValueAt(0, "COD_IND_SITU");
            indCajaBolsa = (String) rs.getValueAt(0, "COD_IND_DENT_CAJA");
            formaPago = (rs.getValueAt(0, "FOPA_OID_FORM_PAGO") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "FOPA_OID_FORM_PAGO")).toString());
            codigoImpuesto = (String) rs.getValueAt(0, "COD_IMPU");
            precioCatalogo = (BigDecimal) rs.getValueAt(0, "VAL_PREC_CATA");
            precioContable = (BigDecimal) rs.getValueAt(0, "VAL_PREC_CONT");

            if (rs.getValueAt(0, "IND_KIT") == null) {
                esKit = null;
            } else {
                esKit = (((BigDecimal) rs.getValueAt(0, "IND_KIT")).intValue() == 1) ? new Boolean(true) : new Boolean(false);
            }

            porcentajeUnidades = (rs.getValueAt(0, "PCT_UNID") == null) ? null : new Integer(((BigDecimal) rs.getValueAt(0, "PCT_UNID")).toString());
            generico = (rs.getValueAt(0, "GENE_OID_GENE") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "GENE_OID_GENE")).toString());
            supergenerico = (rs.getValueAt(0, "SGEN_OID_SUPE_GENE") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "SGEN_OID_SUPE_GENE")).toString());
            status = (rs.getValueAt(0, "MEUD_OID_ESTA_PROD") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "MEUD_OID_ESTA_PROD")).toString());
            unidadMedidaDimensiones = (rs.getValueAt(0, "UNMD_OID_UNID_MEDI_DIME") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "UNMD_OID_UNID_MEDI_DIME")).toString());
            lineaDeProducto = (rs.getValueAt(0, "LIPR_OID_LINE_PROD") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "LIPR_OID_LINE_PROD")).toString());
            negocio = (rs.getValueAt(0, "NEGO_OID_NEGO") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "NEGO_OID_NEGO")).toString());
            periodoInicio = (rs.getValueAt(0, "PERD_OID_PERI_INIC") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "PERD_OID_PERI_INIC")).toString());
            periodoFin = (rs.getValueAt(0, "PERD_OID_PERI_FIN") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "PERD_OID_PERI_FIN")).toString());
            unidadMedidaPeso = (rs.getValueAt(0, "UNMD_OID_UNID_MEDI_PESO") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "UNMD_OID_UNID_MEDI_PESO")).toString());
            unidadMedidaVolumen = (rs.getValueAt(0, "UNMD_OID_UNID_MEDI") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "UNMD_OID_UNID_MEDI")).toString());
            marcaProducto = (rs.getValueAt(0, "MAPR_OID_MARC_PROD") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "MAPR_OID_MARC_PROD")).toString());
            unidadNegocio = (rs.getValueAt(0, "UNEG_OID_UNID_NEGO") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "UNEG_OID_UNID_NEGO")).toString());

            grupoArticulos = (String) rs.getValueAt(0, "VAL_GRUP_ARTI");
            
            codigoUnicoVenta =(String)rs.getValueAt(0, "COD_UNIC_VENT");
            
            programaFidelizacion = (rs.getValueAt(0, "PRFI_OID_PROG_FIDE") == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, "PRFI_OID_PROG_FIDE")).toString()); //[1]
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new EJBException("MaestroProductos. " + primaryKey + " no se pudo cargar." + ex.getMessage());
        }
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
        MaestroProductosPK primaryKey = (MaestroProductosPK) context.getPrimaryKey();

        try {
            BelcorpService bs = BelcorpService.getInstance();
            String query = " DELETE FROM MAE_PRODU WHERE 1=1 AND OID_PROD = ? ";
            Vector v = new Vector();
            v.add(primaryKey.oid);

            if (bs.dbService.executePreparedUpdate(query, v) != 1) {
                throw new RemoveException(primaryKey + " no se pudo eliminar");
            }

            //super.ejbRemove();
        } catch (Exception ex) {
            //throw new RemoveException("MaestroProductos. " + ex.getMessage());
        }
    }

    public void ejbStore() {
        try {
            BelcorpService rs = BelcorpService.getInstance();
            StringBuffer statement = new StringBuffer();
            String values = new String();
            statement.append("UPDATE MAE_PRODU SET ");

            Vector v = new Vector();

            if (this.codigoSAP != null) {
                statement.append("COD_SAP = ?,");
                v.add(this.codigoSAP);
            }

            if (this.pais != null) {
                statement.append("PAIS_OID_PAIS = ?,");
                v.add(this.pais);
            }

            if (this.codigoAntiguo != null) {
                statement.append("CODI_ANTI = ?,");
                v.add(this.codigoAntiguo);
            } else {
                statement.append("CODI_ANTI = NULL,");
            }

            if (this.descripcionCorta != null) {
                statement.append("DES_CORT = ?,");
                v.add(this.descripcionCorta);
            } else {
                statement.append("DES_CORT = NULL,");
            }

            if (this.esLote != null) {
                statement.append("IND_LOTE = ?,");

                if (this.esLote.booleanValue()) {
                    v.add(new Integer(1));
                } else {
                    v.add(new Integer(0));
                }
            } else {
                statement.append("IND_LOTE = NULL,");
            }

            if (this.indProductoServicio != null) {
                statement.append("IND_PROD_SERV = ?,");

                if (this.indProductoServicio.booleanValue()) {
                    v.add(new Integer(1));
                } else {
                    v.add(new Integer(0));
                }
            } else {
                statement.append("IND_PROD_SERV = NULL,");
            }

            if (this.jerarquia1 != null) {
                statement.append("VAL_JERA_1 = ?,");
                v.add(this.jerarquia1);
            } else {
                statement.append("VAL_JERA_1 = NULL,");
            }

            if (this.jerarquia2 != null) {
                statement.append("VAL_JERA_2 = ?,");
                v.add(this.jerarquia2);
            } else {
                statement.append("VAL_JERA_2 = NULL,");
            }

            if (this.jerarquia3 != null) {
                statement.append("VAL_JERA_3 = ?,");
                v.add(this.jerarquia3);
            } else {
                statement.append("VAL_JERA_3 = NULL,");
            }

            if (this.atributo1 != null) {
                statement.append("VAL_ATRI_1 = ?,");
                v.add(this.atributo1);
            } else {
                statement.append("VAL_ATRI_1 = NULL,");
            }

            if (this.atributo2 != null) {
                statement.append("VAL_ATRI_2 = ?,");
                v.add(this.atributo2);
            } else {
                statement.append("VAL_ATRI_2 = NULL,");
            }

            if (this.atributo3 != null) {
                statement.append("VAL_ATRI_3 = ?,");
                v.add(this.atributo3);
            } else {
                statement.append("VAL_ATRI_3 = NULL,");
            }

            if (this.alto != null) {
                statement.append("VAL_DIME_ALTO = ?,");
                v.add(this.alto);
            } else {
                statement.append("VAL_DIME_ALTO = NULL,");
            }

            if (this.largo != null) {
                statement.append("VAL_DIME_LARG = ?,");
                v.add(this.largo);
            } else {
                statement.append("VAL_DIME_LARG = NULL,");
            }

            if (this.ancho != null) {
                statement.append("VAL_DIME_ANCH = ?,");
                v.add(this.ancho);
            } else {
                statement.append("VAL_DIME_ANCH = NULL,");
            }

            if (this.volumen != null) {
                statement.append("VAL_VOLU = ?,");
                v.add(this.volumen);
            } else {
                statement.append("VAL_VOLU = NULL,");
            }

            if (this.peso != null) {
                statement.append("VAL_PESO = ?,");
                v.add(this.peso);
            } else {
                statement.append("VAL_PESO = NULL,");
            }

            if (this.unidadesDentroPedido != null) {
                statement.append("NUM_UNID_DENT_PEDI = ?,");
                v.add(this.unidadesDentroPedido);
            } else {
                statement.append("NUM_UNID_DENT_PEDI = NULL,");
            }

            if (this.unidadesCaja != null) {
                statement.append("NUM_UNID_CAJA = ?,");
                v.add(this.unidadesCaja);
            } else {
                statement.append("NUM_UNID_CAJA = NULL,");
            }

            if (this.costeEstandard != null) {
                statement.append("VAL_COST_ESTD = ?,");
                v.add(this.costeEstandard);
            } else {
                statement.append("VAL_COST_ESTD = NULL,");
            }

            if (this.precioPosicionamiento != null) {
                statement.append("VAL_PREC_POSI = ?,");
                v.add(this.precioPosicionamiento);
            } else {
                statement.append("VAL_PREC_POSI = NULL,");
            }

            if (this.situacion != null) {
                statement.append("COD_IND_SITU = ?,");
                v.add(this.situacion);
            } else {
                statement.append("COD_IND_SITU = NULL,");
            }

            if (this.indCajaBolsa != null) {
                statement.append("COD_IND_DENT_CAJA = ?,");
                v.add(this.indCajaBolsa);
            } else {
                statement.append("COD_IND_DENT_CAJA = NULL,");
            }

            if (this.formaPago != null) {
                statement.append("FOPA_OID_FORM_PAGO = ?,");
                v.add(this.formaPago);
            } else {
                statement.append("FOPA_OID_FORM_PAGO = NULL,");
            }

            if (this.codigoImpuesto != null) {
                statement.append("COD_IMPU = ?,");
                v.add(this.codigoImpuesto);
            } else {
                statement.append("COD_IMPU = NULL,");
            }

            if (this.precioCatalogo != null) {
                statement.append("VAL_PREC_CATA = ?,");
                v.add(this.precioCatalogo);
            } else {
                statement.append("VAL_PREC_CATA = NULL,");
            }

            if (this.precioContable != null) {
                statement.append("VAL_PREC_CONT = ?,");
                v.add(this.precioContable);
            } else {
                statement.append("VAL_PREC_CONT = NULL,");
            }

            if (this.esKit != null) {
                statement.append("IND_KIT = ?,");

                if (this.esKit.booleanValue()) {
                    v.add(new Integer(1));
                } else {
                    v.add(new Integer(0));
                }
            } else {
                statement.append("IND_KIT = NULL,");
            }

            if (this.porcentajeUnidades != null) {
                statement.append("PCT_UNID = ?,");
                v.add(this.porcentajeUnidades);
            } else {
                statement.append("PCT_UNID = NULL,");
            }

            if (this.generico != null) {
                statement.append("GENE_OID_GENE = ?,");
                v.add(this.generico);
            } else {
                statement.append("GENE_OID_GENE = NULL,");
            }

            if (this.supergenerico != null) {
                statement.append("SGEN_OID_SUPE_GENE = ?,");
                v.add(this.supergenerico);
            } else {
                statement.append("SGEN_OID_SUPE_GENE = NULL,");
            }

            if (this.status != null) {
                statement.append("MEUD_OID_ESTA_PROD = ?,");
                v.add(this.status);
            } else {
                statement.append("MEUD_OID_ESTA_PROD = NULL,");
            }

            if (this.unidadMedidaDimensiones != null) {
                statement.append("UNMD_OID_UNID_MEDI_DIME = ?,");
                v.add(this.unidadMedidaDimensiones);
            } else {
                statement.append("UNMD_OID_UNID_MEDI_DIME = NULL,");
            }

            if (this.lineaDeProducto != null) {
                statement.append("LIPR_OID_LINE_PROD = ?,");
                v.add(this.lineaDeProducto);
            } else {
                statement.append("LIPR_OID_LINE_PROD = NULL,");
            }

            if (this.negocio != null) {
                statement.append("NEGO_OID_NEGO = ?,");
                v.add(this.negocio);
            } else {
                statement.append("NEGO_OID_NEGO = NULL,");
            }

            if (this.periodoInicio != null) {
                statement.append("PERD_OID_PERI_INIC = ?,");
                v.add(this.periodoInicio);
            } else {
                statement.append("PERD_OID_PERI_INIC = NULL,");
            }

            if (this.periodoFin != null) {
                statement.append("PERD_OID_PERI_FIN = ?,");
                v.add(this.periodoFin);
            } else {
                statement.append("PERD_OID_PERI_FIN = NULL,");
            }

            if (this.unidadMedidaPeso != null) {
                statement.append("UNMD_OID_UNID_MEDI_PESO = ?,");
                v.add(this.unidadMedidaPeso);
            } else {
                statement.append("UNMD_OID_UNID_MEDI_PESO = NULL,");
            }

            if (this.unidadMedidaVolumen != null) {
                statement.append("UNMD_OID_UNID_MEDI = ?,");
                v.add(this.unidadMedidaVolumen);
            } else {
                statement.append("UNMD_OID_UNID_MEDI = NULL,");
            }

            if (this.marcaProducto != null) {
                statement.append("MAPR_OID_MARC_PROD = ?,");
                v.add(this.marcaProducto);
            } else {
                statement.append("MAPR_OID_MARC_PROD = NULL,");
            }

            if (this.unidadNegocio != null) {
                statement.append("UNEG_OID_UNID_NEGO = ?,");
                v.add(this.unidadNegocio);
            } else {
                statement.append("UNEG_OID_UNID_NEGO = NULL,");
            }

            if (this.grupoArticulos != null) {
                statement.append("VAL_GRUP_ARTI = ?,");
                v.add(this.grupoArticulos);
            } else {
                statement.append("VAL_GRUP_ARTI = NULL,");
            }
            
            if (this.codigoUnicoVenta != null) {
                statement.append("COD_UNIC_VENT = ?,");
                v.add(this.codigoUnicoVenta);
            } else {
                statement.append("COD_UNIC_VENT = NULL,");
            }
            
            // /*[1]
            if(this.getProgramaFidelizacion()!=null){
                statement.append("PRFI_OID_PROG_FIDE = ?,");
                v.add(this.programaFidelizacion);
            } else {
                statement.append("PRFI_OID_PROG_FIDE = NULL,");
            }
            // */[1]

            statement.deleteCharAt(statement.length() - 1);
            statement.append(" WHERE 1=1 AND OID_PROD = ?  ");
            v.add(this.oid);

            if (rs.dbService.executePreparedUpdate(statement.toString(), v) == 0) {
                throw new Exception("Error en el EJBStore");
            }

            //super.ejbStore();
        } catch (Exception ex) {
            throw new EJBException("MaestroProductos. " + ex.getMessage());
        }
    }

    public Collection ejbFindAll() throws FinderException {
        try {
            BelcorpService rs = BelcorpService.getInstance();
            String query = "  SELECT * FROM MAE_PRODU WHERE 1=1  ";
            Vector v = new Vector();
            RecordSet r = rs.dbService.executePreparedQuery(query, v);
            ArrayList res = new ArrayList();

            for (int i = 0; i < r.getRowCount(); i++) {
                MaestroProductosPK pkey = new MaestroProductosPK();
                pkey.oid = new Long(((BigDecimal) r.getValueAt(i, "OID_PROD")).toString());
                res.add(pkey);
            }

            //super.ejbStore();

            return res;
        } catch (Exception ex) {
            throw new FinderException("MaestroProducto." + ex.getMessage());
        }
    }

    public void setEntityContext(EntityContext ctx) {
        this.context = ctx;
    }

    public void unsetEntityContext() {
        this.context = null;
    }

    /** ********************************************************************************************************** */
    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public String getCodigoSAP() {
        return codigoSAP;
    }

    public void setCodigoSAP(String newCodigoSAP) {
        codigoSAP = newCodigoSAP;
    }

    public String getCodigoAntiguo() {
        return codigoAntiguo;
    }

    public void setCodigoAntiguo(String newCodAntiguo) {
        codigoAntiguo = newCodAntiguo;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String newDescripcionCorta) {
        descripcionCorta = newDescripcionCorta;
    }

    public Boolean getEsLote() {
        return esLote;
    }

    public void setEsLote(Boolean newIndLote) {
        esLote = newIndLote;
    }

    public Boolean getIndProductoServicio() {
        return indProductoServicio;
    }

    public void setIndProductoServicio(Boolean newProductoServicio) {
        indProductoServicio = newProductoServicio;
    }

    public String getJerarquia1() {
        return jerarquia1;
    }

    public void setJerarquia1(String newJerarquia1) {
        jerarquia1 = newJerarquia1;
    }

    public String getJerarquia2() {
        return jerarquia2;
    }

    public void setJerarquia2(String newJerarquia2) {
        jerarquia2 = newJerarquia2;
    }

    public String getJerarquia3() {
        return jerarquia3;
    }

    public void setJerarquia3(String newJerarquia3) {
        jerarquia3 = newJerarquia3;
    }

    public String getAtributo1() {
        return atributo1;
    }

    public void setAtributo1(String newAtributo1) {
        atributo1 = newAtributo1;
    }

    public String getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(String newAtributo2) {
        atributo2 = newAtributo2;
    }

    public String getAtributo3() {
        return atributo3;
    }

    public void setAtributo3(String newAtributo3) {
        atributo3 = newAtributo3;
    }

    public BigDecimal getAlto() {
        return alto;
    }

    public void setAlto(BigDecimal newAlto) {
        alto = newAlto;
    }

    public BigDecimal getLargo() {
        return largo;
    }

    public void setLargo(BigDecimal newLargo) {
        largo = newLargo;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal newAncho) {
        ancho = newAncho;
    }

    public BigDecimal getVolumen() {
        return volumen;
    }

    public void setVolumen(BigDecimal newVolumen) {
        volumen = newVolumen;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal newPeso) {
        peso = newPeso;
    }

    public Integer getUnidadesDentroPedido() {
        return unidadesDentroPedido;
    }

    public void setUnidadesDentroPedido(Integer newUnidDentroPedido) {
        unidadesDentroPedido = newUnidDentroPedido;
    }

    public Integer getUnidadesCaja() {
        return unidadesCaja;
    }

    public void setUnidadesCaja(Integer newUnidCaja) {
        unidadesCaja = newUnidCaja;
    }

    public BigDecimal getCosteEstandard() {
        return costeEstandard;
    }

    public void setCosteEstandard(BigDecimal newCosteEstandard) {
        costeEstandard = newCosteEstandard;
    }

    public BigDecimal getPrecioPosicionamiento() {
        return precioPosicionamiento;
    }

    public void setPrecioPosicionamiento(BigDecimal newPrecioPosicionamiento) {
        precioPosicionamiento = newPrecioPosicionamiento;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String newSituacion) {
        situacion = newSituacion;
    }

    public String getIndCajaBolsa() {
        return indCajaBolsa;
    }

    public void setIndCajaBolsa(String newIndCajaBolsa) {
        indCajaBolsa = newIndCajaBolsa;
    }

    public Long getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Long newFormaPago) {
        formaPago = newFormaPago;
    }

    public String getCodigoImpuesto() {
        return codigoImpuesto;
    }

    public void setCodigoImpuesto(String newCodImpuesto) {
        codigoImpuesto = newCodImpuesto;
    }

    public BigDecimal getPrecioCatalogo() {
        return precioCatalogo;
    }

    public void setPrecioCatalogo(BigDecimal newPrecioCatalogo) {
        precioCatalogo = newPrecioCatalogo;
    }

    public BigDecimal getPrecioContable() {
        return precioContable;
    }

    public void setPrecioContable(BigDecimal newPrecioContable) {
        precioContable = newPrecioContable;
    }

    public Boolean getEsKit() {
        return esKit;
    }

    public void setEsKit(Boolean newEsKit) {
        esKit = newEsKit;
    }

    public Integer getPorcentajeUnidades() {
        return porcentajeUnidades;
    }

    public void setPorcentajeUnidades(Integer newPorcentajeUnidades) {
        porcentajeUnidades = newPorcentajeUnidades;
    }

    public Long getGenerico() {
        return generico;
    }

    public void setGenerico(Long newGenerico) {
        generico = newGenerico;
    }

    public Long getSuperGenerico() {
        return supergenerico;
    }

    public void setSuperGenerico(Long newSupergenerico) {
        supergenerico = newSupergenerico;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long newStatus) {
        status = newStatus;
    }

    public Long getUnidadMedidaDimensiones() {
        return unidadMedidaDimensiones;
    }

    public void setUnidadMedidaDimensiones(Long newUnidMedidaDimensiones) {
        unidadMedidaDimensiones = newUnidMedidaDimensiones;
    }

    public Long getLineaDeProducto() {
        return lineaDeProducto;
    }

    public void setLineaDeProducto(Long newLineaProducto) {
        lineaDeProducto = newLineaProducto;
    }

    public Long getNegocio() {
        return negocio;
    }

    public void setNegocio(Long newNegocio) {
        negocio = newNegocio;
    }

    public Long getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(Long newPeriodoInicio) {
        periodoInicio = newPeriodoInicio;
    }

    public Long getPeriodoFin() {
        return periodoFin;
    }

    public void setPeriodoFin(Long newPeriodoFin) {
        periodoFin = newPeriodoFin;
    }

    public Long getUnidadMedidaPeso() {
        return unidadMedidaPeso;
    }

    public void setUnidadMedidaPeso(Long newUnidMedidaPeso) {
        unidadMedidaPeso = newUnidMedidaPeso;
    }

    public Long getUnidadMedidaVolumen() {
        return unidadMedidaVolumen;
    }

    public void setUnidadMedidaVolumen(Long newUnidMedidaVolumen) {
        unidadMedidaVolumen = newUnidMedidaVolumen;
    }

    public Long getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(Long newMarcaProducto) {
        marcaProducto = newMarcaProducto;
    }

    public Long getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(Long newUnidadNegocio) {
        unidadNegocio = newUnidadNegocio;
    }

    public String getGrupoArticulos() {
        return grupoArticulos;
    }

    public void setGrupoArticulos(String newGrupoArticulos) {
        grupoArticulos = newGrupoArticulos;
    }

    public void setTraducciones(Vector valores) throws MareException {
        /*
         * indico el nombre de la tabla para que se eliminen las traducciones en}
         * GEN_I18N.SICC cuando se elimine un elemento de Menu.
         */
        nombreTabla = "MAE_PRODU";

        /*
         * inserto/modifico los valores de i18n
         */
        UtilidadesLog.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        UtilidadesLog.debug("Internacionalizacion:");
        UtilidadesLog.debug("nombreTabla: " + nombreTabla);
        UtilidadesLog.debug("getOid(): " + getOid());
        UtilidadesLog.debug("valores: " + valores);
        UtilidadesLog.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        insertarTraducciones(nombreTabla, getOid(), valores);
    }

    private void insertarTraducciones(String entidad, Long oid, Vector valores) throws MareException {
        String codigoError;

        try {
            CMNEjbLocators.getMONI18nHome().create().actualizaTraducciones(entidad, oid, valores);
        } catch (CreateException ce) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public MaestroProductosPK ejbFindByUK(Long pais, String codigoSAP) throws FinderException {
        MaestroProductosPK pk = new MaestroProductosPK();

        try {
            BelcorpService bs = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();
            query.append(" SELECT * FROM MAE_PRODU WHERE 1=1  ");
            query.append("    AND PAIS_OID_PAIS = " + pais);
            query.append("    AND COD_SAP = '" + codigoSAP + "'");

            RecordSet rs = bs.dbService.executeStaticQuery(query.toString());

            //UtilidadesLog.info("rs: " + rs!=null?rs.toString():"vacio");
            if (rs.getRowCount() != 1) {
                throw new FinderException("Entidad no existente");
            }

            //UtilidadesLog.info("obj: " + rs.getValueAt(0,0) + " - tipo: " + rs.getValueAt(0,0).getClass().getName() );
            Long oid = new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
            pk.oid = oid;

            //UtilidadesLog.info("pk: " + pk);
            return pk;
        } catch (Exception ex) {
            //UtilidadesLog.info("ayayaya 2: " + ex);
            //ex.printStackTrace();
            throw new FinderException("MaestroProductos." + ex.getMessage());
        }
    }

    public String getCodigoUnicoVenta(){
        return codigoUnicoVenta;
    }

    public void setCodigoUnicoVenta(String codigoUnicoVenta) {
        this.codigoUnicoVenta = codigoUnicoVenta;
    }
    // /*[1]
     public Long getProgramaFidelizacion(){
        return programaFidelizacion;
    }

    public void setProgramaFidelizacion(Long programaFidelizacion)  {
        this.programaFidelizacion = programaFidelizacion;
    }
    // */[1]
}
