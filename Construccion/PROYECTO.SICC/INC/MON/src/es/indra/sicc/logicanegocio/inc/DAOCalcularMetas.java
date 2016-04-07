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
 *
 * Autor : Sergio C. Saavedra
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado;
import es.indra.sicc.dtos.inc.DTOCalificacionParticipante;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOIncAmbitoGeografico;
import es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada;
import es.indra.sicc.dtos.inc.DTOMetasVentaProyectada;
import es.indra.sicc.dtos.inc.DTOPeriodoDesdeHasta;
import es.indra.sicc.dtos.inc.DTOUACliente;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;
import es.indra.sicc.dtos.inc.DTODatosGenMsgMetasVenta;
import es.indra.sicc.dtos.inc.DTOMsgMetasYClientes;
import java.util.Vector;

public class DAOCalcularMetas {
    public DAOCalcularMetas() {
    }

    public DTOListaMetasVentaProyectada obtenerMetasParaVentasProyectada(DTOConcurso DTOE, Long oidPrimerPeriodo)
            throws MareException {
        UtilidadesLog.info("DAOCalcularMetas.obtenerMetasParaVentasProyectada(DTOConcurso DTOE):Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        boolean lPrimerRegistro = true;

        StringBuffer query = new StringBuffer();
        UtilidadesLog.debug("dentro de DAOCalcularMetas==>>obtenerMetasParaVentasProyectada, recibo : " + DTOE);

        query.append("SELECT a.PERD_OID_PERI ");

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA)) {
            query.append(", D.OID_SUBG_VENT, D.CLIE_OID_CLIE, ");
        }

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_REGION)) {
            query.append(",A.ZORG_OID_REGI, B.CLIE_OID_CLIE, ");
        }

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_ZONA)) {
            query.append(",A.ZZON_OID_ZONA, E.CLIE_OID_CLIE, ");
        }

        query.append("SUM(A.NUM_ACTI_INIC) as NUM_ACTI_INIC, ");
        query.append("SUM(A.NUM_ACTI_FINA) as SUM_NUM_ACTI_FINA, ");
        query.append("SUM(A.NUM_INGR) as SUM_NUM_INGR, ");
        query.append("SUM(A.NUM_REIN) as SUM_NUM_REIN, ");
        query.append("SUM(A.NUM_EGRE) as SUM_NUM_EGRE, ");
        query.append("SUM(A.NUM_ORDE) as SUM_NUM_ORDE, ");
        query.append("SUM(A.NUM_PEDI) as SUM_NUM_PEDI, ");
        query.append("SUM(A.NUM_UNID_VEND) as SUM_NUM_UNID_VEND, ");
        query.append("SUM(A.NUM_CLIE) as SUM_NUM_CLIE, ");
        query.append("SUM(A.VAL_VENT_NETA_ESTA) as SUM_VAL_VENT_NETA_ESTA, ");
        query.append("SUM(A.NUM_REZO_RECI) as SUM_NUM_REZO_RECI, ");
        query.append("SUM(A.NUM_REZO_ENTR)  as SUM_NUM_REZO_ENTR, ");
        // vbongiov -- 14/09/2006 -- DBLG500000222
        query.append("MAX(DECODE(PRI_PER.OID_PRI, NULL, 'N', 'S')) DENTRO_RANGO, ");
        query.append("MAX(DECODE(C.OID_PERI,  " + oidPrimerPeriodo + ",'S','N')) PRIMER_PERIODO ");
        query.append("FROM INT_FUENT_VENTA_PREVI_SAP A, CRA_PERIO C, ");
        query.append("CRA_PERIO F, "); //Para el periodo desde
        query.append("CRA_PERIO G "); //Para el periodo hasta

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA)) {
            query.append(", ZON_REGIO B, ZON_SUB_GEREN_VENTA D ");
        }

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_REGION)) {
            query.append(", ZON_REGIO B ");
        }

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_ZONA)) {
            query.append(", ZON_ZONA E ");
        }
        
        // vbongiov -- 14/09/2006 -- DBLG500000222
        query.append(",( SELECT PERP.OID_PERI OID_PRI, PERD.OID_PERI OID_DES, PERH.OID_PERI OID_HAS ");
        query.append("FROM CRA_PERIO PERP, CRA_PERIO PERD, CRA_PERIO PERH  ");
        query.append("WHERE PERP.FEC_INIC >= PERD.FEC_INIC ");
        query.append("AND PERP.FEC_FINA <= PERH.FEC_FINA) PRI_PER ");   

        query.append("WHERE A.PERD_OID_PERI = C.OID_PERI ");

        //segun charla con maria..
        query.append("AND F.OID_PERI = " + DTOE.getParamCalificacion().getOidPeriodoDesde());
        query.append(" AND G.OID_PERI = " + DTOE.getParamCalificacion().getOidPeriodoHasta());
        
        // vbongiov -- 14/09/2006 -- DBLG500000222
        query.append(" AND ( ( C.FEC_INIC >= F.FEC_INIC ");
        query.append(" AND C.FEC_FINA <= G.FEC_FINA )  ");
        query.append(" OR C.OID_PERI = "  + oidPrimerPeriodo + ") ");
        query.append(" AND PRI_PER.OID_PRI(+) = C.OID_PERI  ");
        query.append(" AND PRI_PER.OID_DES(+) = " + DTOE.getParamCalificacion().getOidPeriodoDesde());
        query.append(" AND PRI_PER.OID_HAS(+) = " + DTOE.getParamCalificacion().getOidPeriodoHasta());
        
        query.append(" AND F.PAIS_OID_PAIS = C.PAIS_OID_PAIS ");
        query.append(" AND F.MARC_OID_MARC = C.MARC_OID_MARC ");
        query.append(" AND F.CANA_OID_CANA = C.CANA_OID_CANA ");
        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA)) {
            query.append("AND A.ZORG_OID_REGI = B.OID_REGI ");
            query.append("AND D.OID_SUBG_VENT = B.ZSGV_OID_SUBG_VENT ");
        }

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_REGION)) {
            query.append("AND A.ZORG_OID_REGI = B.OID_REGI ");
        }

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_ZONA)) {
            query.append("AND E.OID_ZONA = A.ZZON_OID_ZONA ");
        }

        /////////////////////////////////////////////////////////////////////////
        if ((!DTOE.getPlantilla().getIndAmbitoGeografico().booleanValue()) && (DTOE.getListaAmbitosGeograficos().getAmbitoGeografico() != null) &&
                (DTOE.getListaAmbitosGeograficos().getAmbitoGeografico().size() > 0)) {
            query.append("AND (");

            DTOIncAmbitoGeografico elemListaMetas = new DTOIncAmbitoGeografico();

            for (int j = 0; j < DTOE.getListaAmbitosGeograficos().getAmbitoGeografico().size(); j++) {
                elemListaMetas = (DTOIncAmbitoGeografico) DTOE.getListaAmbitosGeograficos().getAmbitoGeografico().get(j);

                if ((elemListaMetas.getOidSubgerencia() != null) && (elemListaMetas.getOidRegion() != null) && (elemListaMetas.getOidZona() != null)) {
                    //jrivas 26/7/2005
                    //Eliminado... inc 19704

                    /*&& (elemListaMetas.getOidSeccion()==null) &&
                    (elemListaMetas.getOidTerritorio()==null) ){*/
                    if (lPrimerRegistro) {
                        query.append(" A.ZZON_OID_ZONA = " + elemListaMetas.getOidZona());
                        lPrimerRegistro = false;
                    } else {
                        query.append(" OR A.ZZON_OID_ZONA = " + elemListaMetas.getOidZona());
                    }
                }

                if ((elemListaMetas.getOidSubgerencia() != null) && (elemListaMetas.getOidRegion() != null) && (elemListaMetas.getOidZona() == null)) {
                    //jrivas 26/7/2005
                    //Eliminado... inc 19704              

                    /*&& (elemListaMetas.getOidSeccion()==null) &&
                    (elemListaMetas.getOidTerritorio()==null) ){*/
                    if (lPrimerRegistro) {
                        query.append(" A.ZORG_OID_REGI = " + elemListaMetas.getOidRegion());
                        lPrimerRegistro = false;
                    } else {
                        query.append(" OR A.ZORG_OID_REGI = " + elemListaMetas.getOidRegion());
                    }
                }

                if ((elemListaMetas.getOidSubgerencia() != null) && (elemListaMetas.getOidRegion() == null) && (elemListaMetas.getOidZona() == null)) {
                    //jrivas 26/7/2005
                    //Eliminado... inc 19704    

                    /*&& (elemListaMetas.getOidSeccion()==null) &&
                    (elemListaMetas.getOidTerritorio()==null) ){*/
                    if (lPrimerRegistro) {
                        query.append(" B.ZSGV_OID_SUBG_VENT = " + elemListaMetas.getOidSubgerencia());
                        lPrimerRegistro = false;
                    } else {
                        query.append(" OR B.ZSGV_OID_SUBG_VENT = " + elemListaMetas.getOidSubgerencia());
                    }
                }
            } //for

            query.append(") ");
        }

        /////////////////////////////////////////////////////////////////////////
        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA)) {
            query.append("GROUP BY A.PERD_OID_PERI, D.OID_SUBG_VENT, D.CLIE_OID_CLIE");
        }

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_REGION)) {
            query.append("GROUP BY A.PERD_OID_PERI, A.ZORG_OID_REGI, B.CLIE_OID_CLIE");
        }

        if (DTOE.getParamCalificacion().getOidAgrupacion().equals(ConstantesINC.OID_AGRUPACION_ZONA)) {
            query.append("GROUP BY A.PERD_OID_PERI, A.ZZON_OID_ZONA, E.CLIE_OID_CLIE");
        }

        UtilidadesLog.info("la consulta resultante, es: " + query.toString());

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error(e); //ver si colocarlo 
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && (!rs.esVacio())) {
            DTOListaMetasVentaProyectada dtoResu = new DTOListaMetasVentaProyectada();
            ArrayList lista = new ArrayList();

            for (int row = 0; row < rs.getRowCount(); row++) {
                DTOMetasVentaProyectada dtoMVP = new DTOMetasVentaProyectada();

                //dtoMVP.setActividad();
                //dtoMVP.setCapitalizacion();
                //dtoMVP.setCodigoCliente();
                //dtoMVP.setImpCapitalizacion();
                dtoMVP.setImpEgresos((rs.getValueAt(row, "SUM_NUM_EGRE") == null) ? new BigDecimal(0) : (BigDecimal) rs.getValueAt(row, "SUM_NUM_EGRE"));
                dtoMVP.setImpIngreso((rs.getValueAt(row, "SUM_NUM_INGR") == null) ? new BigDecimal(0) : (BigDecimal) rs.getValueAt(row, "SUM_NUM_INGR"));
                dtoMVP.setImpReingreso((rs.getValueAt(row, "SUM_NUM_REIN") == null) ? new BigDecimal(0)
                                                                                    : (BigDecimal) rs.getValueAt(row, "SUM_NUM_REIN"));

                //dtoMVP.setImpRetencion();
                dtoMVP.setImpVentaEstadisticable((rs.getValueAt(row, "SUM_VAL_VENT_NETA_ESTA") == null) ? new BigDecimal(0)
                                                                                                        : (BigDecimal) rs.getValueAt(row,
                                                                                                                                     "SUM_VAL_VENT_NETA_ESTA"));

                //dtoMVP.setNombrePeriodo();
                dtoMVP.setNumActivasFinales((rs.getValueAt(row, "SUM_NUM_ACTI_FINA") == null) ? new Long(0)
                                                                                              : new Long(((BigDecimal) rs.getValueAt(row,
                                                                                                                                     "SUM_NUM_ACTI_FINA")).toString()));
                dtoMVP.setNumActivasIniciales((rs.getValueAt(row, "NUM_ACTI_INIC") == null) ? new Long(0)
                                                                                            : new Long(((BigDecimal) rs.getValueAt(row,
                                                                                                                                   "NUM_ACTI_INIC")).toString()));
                dtoMVP.setNumClientes((rs.getValueAt(row, "SUM_NUM_CLIE") == null) ? new Long(0)
                                                                                   : new Long(((BigDecimal) rs.getValueAt(row, "SUM_NUM_CLIE")).toString()));
                dtoMVP.setNumEntregadas((rs.getValueAt(row, "SUM_NUM_REZO_ENTR") == null) ? new Long(0)
                                                                                          : new Long(((BigDecimal) rs.getValueAt(row,
                                                                                                                                 "SUM_NUM_REZO_ENTR")).toString()));
                dtoMVP.setNumOrdenes((rs.getValueAt(row, "SUM_NUM_ORDE") == null) ? new Long(0)
                                                                                  : new Long(((BigDecimal) rs.getValueAt(row, "SUM_NUM_ORDE")).toString()));
                dtoMVP.setNumPedidos((rs.getValueAt(row, "SUM_NUM_PEDI") == null) ? new Long(0)
                                                                                  : new Long(((BigDecimal) rs.getValueAt(row, "SUM_NUM_PEDI")).toString()));
                dtoMVP.setNumRecibidas((rs.getValueAt(row, "SUM_NUM_REZO_RECI") == null) ? new Long(0)
                                                                                         : new Long(((BigDecimal) rs.getValueAt(row,
                                                                                                                                "SUM_NUM_REZO_RECI")).toString()));
                dtoMVP.setNumUnidadesVendidas((rs.getValueAt(row, "SUM_NUM_UNID_VEND") == null) ? new Long(0)
                                                                                                : new Long(((BigDecimal) rs.getValueAt(row,
                                                                                                                                       "SUM_NUM_UNID_VEND")).toString()));

                //dtoMVP.setOid();
                ;

                if ((ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.equals(DTOE.getParamCalificacion().getOidAgrupacion())) ||
                        (ConstantesINC.OID_AGRUPACION_REGION.equals(DTOE.getParamCalificacion().getOidAgrupacion())) ||
                        (ConstantesINC.OID_AGRUPACION_ZONA.equals(DTOE.getParamCalificacion().getOidAgrupacion()))) {
                    dtoMVP.setOidCliente((rs.getValueAt(row, "CLIE_OID_CLIE") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "CLIE_OID_CLIE")).toString()));
                }

                dtoMVP.setOidPeriodo((rs.getValueAt(row, "PERD_OID_PERI") == null) ? null
                                                                                   : new Long(((BigDecimal) rs.getValueAt(row, "PERD_OID_PERI")).toString()));

                if (ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.equals(DTOE.getParamCalificacion().getOidAgrupacion())) {
                    dtoMVP.setOidUA((rs.getValueAt(row, "OID_SUBG_VENT") == null) ? null
                                                                                  : new Long(((BigDecimal) rs.getValueAt(row, "OID_SUBG_VENT")).toString()));
                }

                if (ConstantesINC.OID_AGRUPACION_REGION.equals(DTOE.getParamCalificacion().getOidAgrupacion())) {
                    dtoMVP.setOidUA((rs.getValueAt(row, "ZORG_OID_REGI") == null) ? null
                                                                                  : new Long(((BigDecimal) rs.getValueAt(row, "ZORG_OID_REGI")).toString()));
                }

                if (ConstantesINC.OID_AGRUPACION_ZONA.equals(DTOE.getParamCalificacion().getOidAgrupacion())) {
                    dtoMVP.setOidUA((rs.getValueAt(row, "ZZON_OID_ZONA") == null) ? null
                                                                                  : new Long(((BigDecimal) rs.getValueAt(row, "ZZON_OID_ZONA")).toString()));
                }
                
                // vbongiov -- 14/09/2006 -- DBLG500000222
                if (((String)rs.getValueAt(row, "DENTRO_RANGO")).equals("S")) {
                    dtoMVP.setDentroRangoEvaluacion(Boolean.TRUE);
                } else {
                    dtoMVP.setDentroRangoEvaluacion(Boolean.FALSE);
                }
                
                if (((String)rs.getValueAt(row, "PRIMER_PERIODO")).equals("S")) {
                    dtoMVP.setPrimerPeriodo(Boolean.TRUE);
                } else {
                    dtoMVP.setPrimerPeriodo(Boolean.FALSE);
                }
                

                //dtoMVP.setPrecioPromedioUnitario();
                //dtoMVP.setPromedioOrdenesPedido();
                //dtoMVP.setPromedioUnidadesPedido();
                //dtoMVP.setPromedioVentaPedido();
                //dtoMVP.setRetencion();
                lista.add(dtoMVP);
            }

            dtoResu.setListaMetas(lista);
            UtilidadesLog.info("DAOBaseCalculo.obtenerMetasParaVentasProyectada(DTOConcurso DTOE):Salida");
            return dtoResu;
        } else {
            UtilidadesLog.info("DAOBaseCalculo.obtenerMetasParaVentasProyectada(DTOConcurso DTOE):Salida");
            return new DTOListaMetasVentaProyectada();
        }
    }

    public RecordSet obtenerTipificacionCliente(Long oidCliente)
            throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.obtenerTipificacionCliente(Long oidCliente):Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        boolean lPrimerRegistro = true;

        StringBuffer query = new StringBuffer();
        UtilidadesLog.debug("dentro de DAOCalcularMetas==>>obtenerTipificacionCliente, recibo Clte.: " + oidCliente);

        //segun inc.: 19000
        //la idea es retorna solo un registro!
        query.append("Select s.CLIE_OID_CLIE OID_CLIE, s.TICL_OID_TIPO_CLIE OID_TIPO, ");
        query.append("s.SBTI_OID_SUBT_CLIE OID_SUBTIPO, cla.TCCL_OID_TIPO_CLASI OID_TIPO_CLASI, ");
        query.append("cla.CLAS_OID_CLAS OID_CLASI ");
        query.append("FROM MAE_CLIEN_TIPO_SUBTI s, MAE_CLIEN_CLASI cla ");
        query.append("WHERE s.CLIE_OID_CLIE = " + oidCliente);
        query.append(" AND cla.CTSU_OID_CLIE_TIPO_SUBT(+) = s.OID_CLIE_TIPO_SUBT ");
        // vbongiov -- 3/07/06 -- DBLG500000768
        //query.append("AND s.IND_PPAL = 1");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOBaseCalculo.obtenerTipificacionCliente(Long oidCliente):Salida");
        return rs;
    }

    public ArrayList obtenerPeriodosCalificacion(DTOPeriodoDesdeHasta DTOE)
            throws MareException {
         UtilidadesLog.info("DAOBaseCalculo.obtenerPeriodosCalificacion(DTOPeriodoDesdeHasta DTOE):Entrada");
        //Este método obtiene los periodos comprendidos entre el periodo desde y hasta de calificacion del concurso 
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        ArrayList resu = new ArrayList();

        StringBuffer query = new StringBuffer();
        UtilidadesLog.info("dentro de DAOCalcularMetas==>>obtenerPeriodosCalificacion, recibo DTOPeriodoDesdeHasta.: " + DTOE);

        query.append("SELECT cp3.oid_peri, cp3.fec_inic, cp3.fec_fina, spc.cod_peri, cp3.pais_oid_pais, ");
        query.append("cp3.marc_oid_marc, cp3.cana_oid_cana ");
        query.append("FROM cra_perio cp1, cra_perio cp2, cra_perio cp3, seg_perio_corpo spc ");
        query.append("WHERE cp1.oid_peri = " + DTOE.getOidPeriodoDesde());
        query.append("AND cp2.oid_peri = " + DTOE.getOidPeriodoHasta());
        query.append("AND cp1.FEC_INIC <= cp3.FEC_INIC ");
        query.append("AND cp2.FEC_FINA >= cp3.FEC_FINA ");
        query.append("AND cp3.peri_oid_peri = spc.oid_peri ");

        //jrivas 26/10/2005 Agregado filtro pais, marca, canal.        
        query.append(" AND cp1.CANA_OID_CANA = cp3.CANA_OID_CANA ");
        query.append(" AND cp1.MARC_OID_MARC = cp3.MARC_OID_MARC ");
        query.append(" AND cp1.PAIS_OID_PAIS = cp3.PAIS_OID_PAIS ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());

            if ((rs != null) && (rs.getRowCount() > 0)) {
                for (int row = 0; row < rs.getRowCount(); row++) {
                    Periodo registro = new Periodo();

                    registro.setCodperiodo((rs.getValueAt(row, "COD_PERI") == null) ? null : (String) rs.getValueAt(row, "COD_PERI"));
                    registro.setFechaDesde((rs.getValueAt(row, "FEC_INIC") == null) ? null : (java.sql.Date) rs.getValueAt(row, "FEC_INIC"));
                    registro.setFechaHasta((rs.getValueAt(row, "FEC_FINA") == null) ? null : (java.sql.Date) rs.getValueAt(row, "FEC_FINA"));
                    registro.setOidCanal((rs.getValueAt(row, "CANA_OID_CANA") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "CANA_OID_CANA")).toString()));
                    registro.setOidMarca((rs.getValueAt(row, "MARC_OID_MARC") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "MARC_OID_MARC")).toString()));
                    registro.setOidPais((rs.getValueAt(row, "PAIS_OID_PAIS") == null) ? null
                                                                                      : new Long(((BigDecimal) rs.getValueAt(row, "PAIS_OID_PAIS")).toString()));
                    registro.setOidPeriodo((rs.getValueAt(row, "OID_PERI") == null) ? null
                                                                                    : new Long(((BigDecimal) rs.getValueAt(row, "OID_PERI")).toString()));

                    resu.add(registro);
                }
            }
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOBaseCalculo.obtenerPeriodosCalificacion(DTOPeriodoDesdeHasta DTOE):Salida");
        return resu;
    }


    public DTOUACliente[] obtenerGerentesConUA(DTOBusquedaClienteCalificado DTOE)
            throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.obtenerGerentesConUA(DTOBusquedaClienteCalificado DTOE):Entrada");
        //Se obtiene los gerentes y sus unidades administrativas que gerencian, siempre y 
        //cuando estén incluidas dichas unidades administrativas en el ámbito geográfico del 
        //concurso 
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
        UtilidadesLog.debug("dentro de DAOCalcularMetas==>>obtenerGerentesConUA, recibo DTOE.: " + DTOE);

        DTOIncAmbitoGeografico elemListaMetas = new DTOIncAmbitoGeografico();

        // vbongiov -- 6/04/2006 - inc 22569
        query.append(" SELECT SUB.OID_SUBG_VENT, NULL OID_REGI, NULL OID_ZONA, ");
        query.append(" NULL OID_SECC,NULL OID_TERR_ADMI, SUB.CLIE_OID_CLIE ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB ");
        query.append(" WHERE SUB.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, NULL OID_ZONA, ");
        query.append(" NULL OID_SECC, NULL OID_TERR_ADMI, REG.CLIE_OID_CLIE ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, ZON.OID_ZONA, ");
        query.append(" NULL OID_SECC, NULL OID_TERR_ADMI, ZON.CLIE_OID_CLIE ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG, ZON_ZONA ZON ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
        query.append(" AND ZON.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, ZON.OID_ZONA,  ");
        query.append(" SEC.OID_SECC, NULL OID_TERR_ADMI, SEC.CLIE_OID_CLIE  ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG, ZON_ZONA ZON, ZON_SECCI SEC ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
        query.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA ");
        query.append(" AND SEC.CLIE_OID_CLIE IS NOT NULL ");
        
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());

            ArrayList temp = new ArrayList();
            DTOUACliente[] resu = null;
            int cant = 0;
            DTOUACliente dtoUA = null;
            Gerente gerente = new Gerente();
            Concurso concurso= new Concurso();
            AmbitoGeografico[] ambitoGeoArray = null;
            AmbitoGeografico ambitoGeo = null;
            DTOIncAmbitoGeografico dtoIncAmbitoGeografico= null;
            Long geren = null;

            if ((rs != null) || (rs.getRowCount() > 0)) {
            
                // Paso la lista de ambitos geograficos de ArrayList a array[]
                if(!DTOE.getIndAmbitoGeograficoCompleto().booleanValue()) {
                
                    int cantAmb = DTOE.getListaAmbitosGeograficos().size();
                    
                    ambitoGeoArray = new AmbitoGeografico[cantAmb];

                    for (int k = 0; k < cantAmb; k++) {
                        dtoIncAmbitoGeografico = (DTOIncAmbitoGeografico) DTOE.getListaAmbitosGeograficos().get(k);
                        
                        ambitoGeo = new AmbitoGeografico();
                        
                        ambitoGeo.setOidSubgerencia(dtoIncAmbitoGeografico.getOidSubgerencia());
                        ambitoGeo.setOidRegion(dtoIncAmbitoGeografico.getOidRegion());
                        ambitoGeo.setOidZona(dtoIncAmbitoGeografico.getOidZona());
                        ambitoGeo.setOidSeccion(dtoIncAmbitoGeografico.getOidSeccion());
                        ambitoGeo.setOidTerritorio(dtoIncAmbitoGeografico.getOidTerritorio());
                        
                        ambitoGeoArray[k] = ambitoGeo;
                    }
                }            
            
                // Valida el ambito geografico
                cant = rs.getRowCount();
                
                for(int i=0; i < cant; i++) {
                
                    dtoUA = new DTOUACliente();
                    
                    dtoUA.setOidSubgerencia(rs.getValueAt(i, "OID_SUBG_VENT")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_SUBG_VENT")).longValue()));
                    dtoUA.setOidRegion(rs.getValueAt(i, "OID_REGI")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_REGI")).longValue()));
                    dtoUA.setOidZona(rs.getValueAt(i, "OID_ZONA")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_ZONA")).longValue()));
                    dtoUA.setOidSeccion(rs.getValueAt(i, "OID_SECC")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_SECC")).longValue()));
                    dtoUA.setOidTerritorio(rs.getValueAt(i, "OID_TERR_ADMI")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_TERR_ADMI")).longValue()));
                    
                    geren = new Long(((BigDecimal) rs.getValueAt(i, "CLIE_OID_CLIE")).longValue());
                    UtilidadesLog.debug("Gerente: " + geren);
                    
                    dtoUA.setOidCliente(geren);
                    
                    UtilidadesLog.debug("DTOUACliente: " + dtoUA);
                    
                    gerente.setOidCliente(geren);
                    
                    if(!DTOE.getIndAmbitoGeograficoCompleto().booleanValue()) {
                        UtilidadesLog.debug("IndAmbitoGeograficoCompleto false");
                    
                        AmbitoGeografico ambGeo = new AmbitoGeografico();
                        ambGeo.setOidSubgerencia(rs.getValueAt(i, "OID_SUBG_VENT")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_SUBG_VENT")).longValue()));
                        ambGeo.setOidRegion(rs.getValueAt(i, "OID_REGI")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_REGI")).longValue()));
                        ambGeo.setOidZona(rs.getValueAt(i, "OID_ZONA")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_ZONA")).longValue()));
                        ambGeo.setOidSeccion(rs.getValueAt(i, "OID_SECC")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_SECC")).longValue()));
                        ambGeo.setOidTerritorio(rs.getValueAt(i, "OID_TERR_ADMI")==null?null:new Long(((BigDecimal) rs.getValueAt(i, "OID_TERR_ADMI")).longValue()));
                        
                        if(ambGeo.getOidSeccion()!=null) {
                            ambGeo.setLider(gerente);                          
                        } else if(ambGeo.getOidZona()!=null) {
                            ambGeo.setGerenteZona(gerente);                          
                        } else if(ambGeo.getOidRegion()!=null) {
                            ambGeo.setGerenteRegion(gerente);                          
                        } else if(ambGeo.getOidSubgerencia()!=null) {
                            ambGeo.setSubgerente(gerente);                          
                        }
                        
                        UtilidadesLog.debug("AmbitoGeografico: " + ambGeo);
                        
                        concurso.setAmbitosGeograficos(ambitoGeoArray);
                        
                        if(concurso.cumpleAmbitoGeograficoGerentes(ambGeo, geren)) {
                             UtilidadesLog.debug("Cumple AmbitoGeografico"); 
                             temp.add(dtoUA);
                        }                    
                      
                    } else {
                        UtilidadesLog.debug("IndAmbitoGeograficoCompleto true");
                        temp.add(dtoUA);
                    }
                  
                }
                
                UtilidadesLog.debug("DTOUACliente[]: " + temp);
            
                DTOUACliente[] resu1 = new DTOUACliente[temp.size()];

                for (int z = 0; z < temp.size(); z++) {
                    resu1[z] = (DTOUACliente) temp.get(z);
                }
                
                UtilidadesLog.debug("salgo de DAOCalcularMetas==>>obtenerGerentesConUA con datos: " + resu1);

                return resu1;
                
            } else {
                UtilidadesLog.debug("salgo de DAOCalcularMetas==>>obtenerGerentesConUA sin datos.");

                return resu;
            }

        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }
    public DTOUACliente[] obtenerGerentesCalificados(DTOBusquedaClienteCalificado DTOE)
            throws MareException {
            UtilidadesLog.info("DAOBaseCalculo.obtenerGerentesCalificados(DTOBusquedaClienteCalificado DTOE:Entrada");
        // Se obtienen aquellos gerentes de zona, región o subgerencia cuya unidad administrativa 
        //que gerencian pertenece a alguno de los ámbitos geográficos definidos para el concurso 
        DTOUACliente[] dtoFinal = null;

        DTOUACliente[] dtoUAC = this.obtenerGerentesConUA(DTOE);
        DTOOIDs dtoClientes = this.obtenerGerentesParticipantes(DTOE);
        int nCuantos = 0;
        int actual = 0;

        if ((dtoUAC != null) && (dtoUAC.length > 0)) {
            int count = 0;

            while ((count < dtoUAC.length)) {
                DTOUACliente regActual = dtoUAC[count];

                if (this.contenidoEnOIDS(regActual.getOidCliente(), dtoClientes)) {
                    nCuantos++;
                }

                count++;
            }

            if (nCuantos > 0) {
                DTOUACliente[] dtoFinal1 = new DTOUACliente[nCuantos];
                count = 0;
                actual = 0;

                while ((count < dtoUAC.length)) {
                    DTOUACliente regActual = dtoUAC[count];

                    if (this.contenidoEnOIDS(regActual.getOidCliente(), dtoClientes)) {
                        dtoFinal1[actual] = regActual;
                        actual++;
                    }

                    count++;
                }
                
                UtilidadesLog.debug("dtoFinal1 :" + dtoFinal1);
                UtilidadesLog.info("DAOBaseCalculo.obtenerGerentesCalificados(DTOBusquedaClienteCalificado DTOE:Salida");
                return dtoFinal1;
            } else {
                UtilidadesLog.debug("dtoFinal :" + dtoFinal);
                UtilidadesLog.info("DAOBaseCalculo.obtenerGerentesCalificados(DTOBusquedaClienteCalificado DTOE:Salida");
                return dtoFinal;
            }
        } else {
            UtilidadesLog.debug("dtoFinal :" + dtoFinal);
            UtilidadesLog.info("DAOBaseCalculo.obtenerGerentesCalificados(DTOBusquedaClienteCalificado DTOE:Salida");
            return dtoFinal;
        }
    }

    public DTOOIDs obtenerClientesCalificados(DTOBusquedaClienteCalificado DTOE)
            throws MareException {
        //Recupera los clientes para el Pais, Marca y canal del concurso. 
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        DTOOIDs resu = new DTOOIDs();
        boolean primerRegistro = true;

        StringBuffer query = new StringBuffer();
        UtilidadesLog.info("dentro de DAOCalcularMetas==>>obtenerClientesCalificados, recibo DTOE.: " + DTOE);

        query.append("SELECT DISTINCT A.CLIE_OID_CLIE ");
        query.append("FROM MAE_CLIEN_UNIDA_ADMIN A, ");
        query.append("ZON_TERRI_ADMIN B, ");
        query.append("MAE_CLIEN_TIPO_SUBTI C, ");
        query.append("ZON_SECCI E, ");
        query.append("ZON_ZONA F, ");
        query.append("ZON_SUB_GEREN_VENTA H, ");
        query.append("INC_PARTI_CONCU_CABEC J, ");
        query.append("INC_PARTI_CONCU_DETAL K, ");
        query.append("V_MAE_TIPIF_CLIEN L, ");
        
        query.append("ZON_REGIO G ");
        
        //jrivas 21/1/2007  V-INC-17 Filtro de Consultoras Activas
        query.append(", MAE_CLIEN_DATOS_ADICI CDA ");

        query.append("WHERE A.ZTAD_OID_TERR_ADMI = B.OID_TERR_ADMI ");
        
        //jrivas 21/1/2007  V-INC-17 Filtro de Consultoras Activas
        query.append(" AND CDA.CLIE_OID_CLIE = A.CLIE_OID_CLIE ");
        query.append(" AND CDA.IND_ACTI = " + ConstantesINC.IND_ACTIVO);
        
        query.append("AND B.CANA_OID_CANA = " + DTOE.getOidCanal());
        query.append("AND B.MARC_OID_MARC = " + DTOE.getOidMarca());
        query.append("AND B.PAIS_OID_PAIS = " + DTOE.getOidPais());
        query.append("AND C.CLIE_OID_CLIE = A.CLIE_OID_CLIE ");
        query.append("AND E.OID_SECC = B.ZSCC_OID_SECC ");
        query.append("AND F.OID_ZONA = E.ZZON_OID_ZONA ");
        query.append("AND G.OID_REGI = F.ZORG_OID_REGI ");
        query.append("AND H.OID_SUBG_VENT = G.ZSGV_OID_SUBG_VENT ");
        query.append("AND L.CLIE_OID_CLIE = A.CLIE_OID_CLIE ");
        query.append("AND K.TICL_OID_TIPO_CLIE = L.TICL_OID_TIPO_CLIE ");
        query.append(" AND NVL(k.sbti_oid_subt_clie, -1) = DECODE(k.sbti_oid_subt_clie, NULL, -1, l.sbti_oid_subt_clie) ");
        query.append(" AND NVL(k.tccl_oid_tipo_clas, -1) = DECODE(k.tccl_oid_tipo_clas, NULL, -1, l.tccl_oid_tipo_clasi) ");
        query.append(" AND NVL(k.clas_oid_clas, -1) = DECODE(k.clas_oid_clas, NULL, -1, l.clas_oid_clas) ");
        query.append("AND J.OID_PART_CONC_CABE = K.PACI_OID_PART_CONC_CABE ");
        
        if ((DTOE.getListaParticipantesCalificacion() != null) &&
                (DTOE.getListaParticipantesCalificacion().size() > 0)) {
            query.append("AND (");

            DTOCalificacionParticipante registro = new DTOCalificacionParticipante();

            for (int j = 0; j < DTOE.getListaParticipantesCalificacion().size(); j++) {
                registro = (DTOCalificacionParticipante) DTOE.getListaParticipantesCalificacion().get(j);

                if (j < (DTOE.getListaParticipantesCalificacion().size() - 1)) {
                    query.append("J.OID_PART_CONC_CABE = " + registro.getOidParticipante().longValue() + " or ");
                } else {
                    query.append("J.OID_PART_CONC_CABE = " + registro.getOidParticipante().longValue());
                }
            }

            query.append(") ");            
        }

        if (!DTOE.getIndAmbitoGeograficoCompleto().booleanValue()) {
            //añadir a la select las condiciones necesarias para traer aquellos clientes que 
            //pertenezcan al ámbito geográfico del concurso   
            if ((DTOE.getListaAmbitosGeograficos() != null) && (DTOE.getListaAmbitosGeograficos().size() > 0)) {
                query.append("AND (");

                DTOIncAmbitoGeografico elemListaMetas = new DTOIncAmbitoGeografico();

                for (int j = 0; j < DTOE.getListaAmbitosGeograficos().size(); j++) {
                    elemListaMetas = (DTOIncAmbitoGeografico) DTOE.getListaAmbitosGeograficos().get(j);
                    UtilidadesLog.info("elemListaMetas " + elemListaMetas);

                    //jrivas 26/7/2005
                    //agregado... inc 19704
                    // INICIO ------ 19704 --------
                    if ((elemListaMetas.getOidSubgerencia() != null) && (elemListaMetas.getOidRegion() != null) &&
                            (elemListaMetas.getOidZona() != null) && (elemListaMetas.getOidSeccion() != null) &&
                            (elemListaMetas.getOidTerritorio() != null)) {
                        if (primerRegistro) {
                            query.append("B.TERR_OID_TERR = " + elemListaMetas.getOidTerritorio());
                            primerRegistro = false;
                        } else {
                            query.append("OR B.TERR_OID_TERR = " + elemListaMetas.getOidTerritorio());
                        }
                    }

                    if ((elemListaMetas.getOidSubgerencia() != null) && (elemListaMetas.getOidRegion() != null) &&
                            (elemListaMetas.getOidZona() != null) && (elemListaMetas.getOidSeccion() != null) &&
                            (elemListaMetas.getOidTerritorio() == null)) {
                        if (primerRegistro) {
                            query.append("E.OID_SECC = " + elemListaMetas.getOidSeccion());
                            primerRegistro = false;
                        } else {
                            query.append("OR E.OID_SECC = " + elemListaMetas.getOidSeccion());
                        }
                    }

                    // FIN ------ 19704 --------
                    if ((elemListaMetas.getOidSubgerencia() != null) && (elemListaMetas.getOidRegion() != null) &&
                            (elemListaMetas.getOidZona() != null) && (elemListaMetas.getOidSeccion() == null) &&
                            (elemListaMetas.getOidTerritorio() == null)) {
                        if (primerRegistro) {
                            query.append("F.OID_ZONA = " + elemListaMetas.getOidZona());
                            primerRegistro = false;
                        } else {
                            query.append("OR F.OID_ZONA = " + elemListaMetas.getOidZona());
                        }
                    }

                    if ((elemListaMetas.getOidSubgerencia() != null) && (elemListaMetas.getOidRegion() != null) &&
                            (elemListaMetas.getOidZona() == null) && (elemListaMetas.getOidSeccion() == null) &&
                            (elemListaMetas.getOidTerritorio() == null)) {
                        if (primerRegistro) {
                            query.append("G.OID_REGI = " + elemListaMetas.getOidRegion());
                            primerRegistro = false;
                        } else {
                            query.append("OR G.OID_REGI = " + elemListaMetas.getOidRegion());
                        }
                    }

                    if ((elemListaMetas.getOidSubgerencia() != null) && (elemListaMetas.getOidRegion() == null) &&
                            (elemListaMetas.getOidZona() == null) && (elemListaMetas.getOidSeccion() == null) &&
                            (elemListaMetas.getOidTerritorio() == null)) {
                        if (primerRegistro) {
                            query.append("H.OID_SUBG_VENT = " + elemListaMetas.getOidSubgerencia());
                            primerRegistro = false;
                        } else {
                            query.append("OR H.OID_SUBG_VENT = " + elemListaMetas.getOidSubgerencia());
                        }
                    }
                }

                query.append(") ");
            }

        }
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());

            if ((rs != null) || (rs.getRowCount() > 0)) {
                Long oid = null;
                Long[] colleccion = new Long[rs.getRowCount()];

                for (int row = 0; row < rs.getRowCount(); row++) {
                    if (rs.getValueAt(row, "CLIE_OID_CLIE") != null) {
                        oid = new Long(((BigDecimal) rs.getValueAt(row, "CLIE_OID_CLIE")).toString());
                    }

                    colleccion[row] = oid;
                }

                resu.setOids(colleccion);
            }
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
        UtilidadesLog.info("DAOCalcularMetas.obtenerGerentesConUA(DTOBusquedaClienteCalificado DTOE:Salida");
        return resu;
    }

    public DTOSolicitudValidacion[] obtenerSolicitudes(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion,
                                                       Boolean indDevolucion)
            throws MareException {
        UtilidadesLog.info("DAOCalcularMetas.obtenerSolicitudes(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion Boolean indDevolucion):Entrada");
        //Se obtienen las solicitudes consolidadas para un cliente, que sean orden de compra, 
        //que sean o no anulaciones o devoluciones dependiendo de los indicadores de anulación 
        //y devolución de los parámetros de calificación del concurso         
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        boolean primerRegistro = true;
        DTOSolicitudValidacion[] resu = new DTOSolicitudValidacion[0];

        StringBuffer query = new StringBuffer();
        UtilidadesLog.info("dentro de DAOCalcularMetas==>>obtenerSolicitudes, ");

        //jrivas 13/7/2005
        //19754
        //query.append("SELECT A.OID_SOLI_CABE, A.CLIE_OID_CLIE ");
        query.append(" SELECT A.OID_SOLI_CABE, A.CLIE_OID_CLIE, A.ZZON_OID_ZONA, A.PERD_OID_PERI, ");
        query.append(" A.PAIS_OID_PAIS, B.MARC_OID_MARC,B.CANA_OID_CANA ");
        query.append("FROM PED_SOLIC_CABEC A, CRA_PERIO INICIO, CRA_PERIO FIN, ");

        query.append("CRA_PERIO B ");

        if (indAnulacion == null) {
            indAnulacion = Boolean.FALSE;
        }

        if (indDevolucion == null) {
            indDevolucion = Boolean.FALSE;
        }

        if (!indAnulacion.booleanValue() || !indDevolucion.booleanValue()) {
            query.append(" , PED_TIPO_SOLIC_PAIS C ");
            query.append(" , PED_TIPO_SOLIC D ");
        }

        query.append(" WHERE A.CLIE_OID_CLIE = " + oidCliente);
        query.append(" AND A.PERD_OID_PERI = B.OID_PERI ");
        query.append(" AND FIN.OID_PERI = " + oidPeriodoFin);
        query.append(" AND INICIO.OID_PERI = " + oidPeriodoIni);
        query.append(" AND B.FEC_INIC >= INICIO.FEC_INIC ");
        query.append(" AND B.FEC_FINA <= FIN.FEC_FINA ");
        query.append(" AND A.IND_OC = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND A.IND_TS_NO_CONSO = " + ConstantesINC.IND_ACTIVO);

        if ((!indAnulacion.booleanValue()) || (!indDevolucion.booleanValue())) {
            query.append(" AND C.OID_TIPO_SOLI_PAIS = A.TSPA_OID_TIPO_SOLI_PAIS ");
        }

        if ((!indAnulacion.booleanValue()) || (!indDevolucion.booleanValue())) {
            query.append(" AND D.OID_TIPO_SOLI = C.TSOL_OID_TIPO_SOLI ");
        }

        if (!indAnulacion.booleanValue()) {
            query.append(" AND D.IND_ANUL = " + ConstantesINC.IND_INACTIVO);
        }

        if (!indDevolucion.booleanValue()) {
            query.append(" AND D.IND_DEVO = " + ConstantesINC.IND_INACTIVO);
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs.getRowCount() > 0) {
            DTOSolicitudValidacion[] resu1 = new DTOSolicitudValidacion[rs.getRowCount()];

            for (int row = 0; row < rs.getRowCount(); row++) {
                DTOSolicitudValidacion registro = new DTOSolicitudValidacion();
                registro.setOidCliente((rs.getValueAt(row, "CLIE_OID_CLIE") == null) ? null
                                                                                     : new Long(((BigDecimal) rs.getValueAt(row, "CLIE_OID_CLIE")).toString()));
                registro.setOidSolicitud((rs.getValueAt(row, "OID_SOLI_CABE") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "OID_SOLI_CABE")).toString()));
                registro.setZona((rs.getValueAt(row, "ZZON_OID_ZONA") == null) ? null
                                                                               : new Long(((BigDecimal) rs.getValueAt(row, "ZZON_OID_ZONA")).toString()));
                registro.setOidPeriodo((rs.getValueAt(row, "PERD_OID_PERI") == null) ? null
                                                                                     : new Long(((BigDecimal) rs.getValueAt(row, "PERD_OID_PERI")).toString()));
                registro.setOidPais((rs.getValueAt(row, "PAIS_OID_PAIS") == null) ? null
                                                                                  : new Long(((BigDecimal) rs.getValueAt(row, "PAIS_OID_PAIS")).toString()));
                registro.setOidMarca((rs.getValueAt(row, "MARC_OID_MARC") == null) ? null
                                                                                   : new Long(((BigDecimal) rs.getValueAt(row, "MARC_OID_MARC")).toString()));
                registro.setOidCanal((rs.getValueAt(row, "CANA_OID_CANA") == null) ? null
                                                                                   : new Long(((BigDecimal) rs.getValueAt(row, "CANA_OID_CANA")).toString()));

                resu1[row] = registro;
            }
            UtilidadesLog.info("DAOCalcularMetas.obtenerSolicitudes(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion Boolean indDevolucion):Salida");
            return resu1;
        } else {
            UtilidadesLog.info("DAOCalcularMetas.obtenerSolicitudes(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion Boolean indDevolucion):Salida");
            return resu;
        }
    }


   //jrivas 05/01/2007 V-INC-17 Cambio Calculo Metas Performance
   public ArrayList obtenerSolicitudesMetas(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion,
                                                       Boolean indDevolucion, Cliente cliente) throws MareException {
      UtilidadesLog.info("DAOCalcularMetas.obtenerSolicitudesCompleto(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion Boolean indDevolucion): Entrada");      
      //Este metodo se agrega por requerimiento de la incidencia tecnica V-INC-17
      //Devuelve un arraylist con todas las solicitudes de un determinado cliente.
      
      StringBuffer buff = new StringBuffer();
      Vector parametros = new Vector();
      ArrayList salida = new ArrayList();

      if (indAnulacion == null) { indAnulacion = Boolean.FALSE; }
      if (indDevolucion == null) {indDevolucion = Boolean.FALSE; }

      // JVM, sicc 20070445, se agrega las entidades ped_solic_cabec refe, cra_perio c y seg_perio_corpo pcr,
      //                     se agrega case para diferenciar por periodo
      buff.append(" SELECT ");
      buff.append(" a.oid_soli_cabe, a.clie_oid_clie, a.zzon_oid_zona, ");
      buff.append(" case ");
      buff.append(" 	when refe.perd_oid_peri is null then a.perd_oid_peri ");
      buff.append(" 	else refe.perd_oid_peri ");
      buff.append(" end perd_oid_peri, ");
      buff.append(" case ");
      buff.append(" 	when refe.perd_oid_peri is null then a.pais_oid_pais ");
      buff.append(" 	else refe.pais_oid_pais ");
      buff.append(" end pais_oid_pais, ");
      buff.append(" case ");
      buff.append(" 	when refe.perd_oid_peri is null then b.marc_oid_marc ");
      buff.append(" 	else c.marc_oid_marc ");
      buff.append(" end marc_oid_marc, ");
      buff.append(" case ");
      buff.append(" 	when refe.perd_oid_peri is null then b.cana_oid_cana ");
      buff.append(" 	else c.cana_oid_cana ");
      buff.append(" end cana_oid_cana, ");
      buff.append(" pts.ind_anul, ");
      buff.append(" pts.ind_devo,  ");
      buff.append(" case ");
      buff.append(" 	when refe.perd_oid_peri is null then a.fec_cron ");
      buff.append(" 	else refe.fec_cron ");
      buff.append(" end feccronanul, ");
      buff.append(" case ");
      buff.append(" 	when refe.perd_oid_peri is null then a.fec_fact ");
      buff.append(" 	else refe.fec_fact ");
      buff.append(" end fecfactanul, ");
      buff.append(" case ");
      buff.append(" 	when refe.perd_oid_peri is null then cp.fec_inic ");
      buff.append(" 	else c.fec_inic ");
      buff.append(" end fec_inic, ");
      buff.append(" case ");
      buff.append(" 	when refe.perd_oid_peri is null then cp.fec_fina ");
      buff.append(" 	else c.fec_fina ");
      buff.append(" end fec_fina, ");
      buff.append(" case ");
      buff.append(" 	when refe.perd_oid_peri is null then spc.cod_peri ");
      buff.append(" 	else pcr.cod_peri ");
      buff.append(" end cod_peri,  ");
      buff.append(" datoscliente.val_nom1,datoscliente.val_ape1, datoscliente.cod_clie, datoscliente.cod_zona,datoscliente.cod_terr ");      
      buff.append(" FROM ped_solic_cabec a, ped_solic_cabec refe, cra_perio inicio, ");
      buff.append(" cra_perio fin, cra_perio b, cra_perio c, cra_perio cp, seg_perio_corpo spc, seg_perio_corpo pcr, ");
      // ----------------------------------------------------------------------
      
      buff.append(" ped_tipo_solic_pais ptsp, ped_tipo_solic pts, ");
	    
      //jrivas SICC20070287 06/06/2007
      buff.append(" (SELECT cliente.val_nom1, cliente.val_ape1, cliente.cod_clie, ");
      buff.append("        zona.cod_zona, terri.cod_terr ");
      buff.append("   FROM mae_clien cliente, ");
      buff.append("        mae_clien_unida_admin uniadm, ");
      buff.append("        zon_terri_admin terriadm, ");
      buff.append("        zon_terri terri, ");
      buff.append("        zon_secci secci, ");
      buff.append("        zon_zona zona ");
      buff.append("  WHERE cliente.oid_clie = ? ");
      parametros.add(oidCliente);
      buff.append("    AND uniadm.clie_oid_clie = cliente.oid_clie ");
      buff.append("    AND uniadm.ind_acti = ? ");
      parametros.add(ConstantesINC.IND_ACTIVO);
      buff.append("    AND terriadm.oid_terr_admi = uniadm.ztad_oid_terr_admi ");
      buff.append("    AND terri.oid_terr = terriadm.terr_oid_terr ");
      buff.append("    AND secci.oid_secc = terriadm.zscc_oid_secc ");
      buff.append("    AND secci.zzon_oid_zona = zona.oid_zona) datoscliente ");
      //FIN SICC20070287
           
      buff.append(" WHERE a.clie_oid_clie = ? ");
      parametros.add(oidCliente);
      buff.append(" AND a.perd_oid_peri = b.oid_peri ");
      
      // JVM 20070445, se agrega condiciones
      buff.append(" AND a.SOCA_OID_DOCU_REFE = refe.oid_soli_cabe(+) ");
      buff.append(" AND refe.perd_oid_peri = c.oid_peri(+) ");
      buff.append(" AND nvl(c.fec_inic,sysdate) >= decode(nvl(c.fec_inic,sysdate),sysdate,sysdate,inicio.fec_inic) ");
      buff.append(" AND nvl(c.fec_fina,sysdate) <= decode(nvl(c.fec_fina,sysdate),sysdate,sysdate,fin.fec_fina) ");
      buff.append(" AND c.peri_oid_peri = pcr.oid_peri(+) ");
      // ----------------------------------------------------------------------

      buff.append(" AND fin.oid_peri = ? ");
      parametros.add(oidPeriodoFin);
      buff.append(" AND inicio.oid_peri = ? ");
      parametros.add(oidPeriodoIni);
      buff.append(" AND b.fec_inic >= inicio.fec_inic ");
      buff.append(" AND b.fec_fina <= fin.fec_fina ");
      buff.append(" AND a.ind_oc = ? ");
      parametros.add(ConstantesINC.IND_ACTIVO);
      buff.append(" AND a.ind_ts_no_conso = ? ");
      parametros.add(ConstantesINC.IND_ACTIVO);
      buff.append(" AND a.tspa_oid_tipo_soli_pais = ptsp.oid_tipo_soli_pais ");
      buff.append(" AND ptsp.tsol_oid_tipo_soli = pts.oid_tipo_soli ");
      buff.append(" AND cp.oid_peri = a.PERD_OID_PERI ");
      buff.append(" AND cp.peri_oid_peri = spc.oid_peri ");
      
      
      if (!indAnulacion.booleanValue()) {
         buff.append(" AND pts.IND_ANUL = ? ");
         parametros.add(ConstantesINC.IND_INACTIVO);
      }
      
      if (!indDevolucion.booleanValue()) {
         buff.append(" AND pts.IND_DEVO = ? ");
         parametros.add(ConstantesINC.IND_INACTIVO);
      }
      
      RecordSet rs = null;
      String codigoError = null;
      try {
         BelcorpService bs = BelcorpService.getInstance();
         rs = bs.dbService.executePreparedQuery(buff.toString(), parametros);
      } catch (MareMiiServiceNotFoundException e) {
         codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
         UtilidadesLog.error("ERROR ", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } catch (Exception e) {
         UtilidadesLog.error("ERROR ", e);
         codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      if(!rs.esVacio()){
         int largo = rs.getRowCount();
         Solicitud solicitud = null;
         
         //jrivas SICC20070287 06/06/2007
         DatosPersonales datosPersonales = null;
         datosPersonales = new DatosPersonales();
         datosPersonales.setNombre1(rs.getValueAt(0, "VAL_NOM1").toString());
         // Agregado validacion por HRCS - Fecha 04/07/2007
         if (rs.getValueAt(0, "VAL_APE1")!=null)
            datosPersonales.setApellido1(rs.getValueAt(0, "VAL_APE1").toString());
         else
            datosPersonales.setApellido1("");
         datosPersonales.setCodCliente(rs.getValueAt(0, "COD_CLIE").toString());            
         datosPersonales.setCodZona(rs.getValueAt(0, "COD_ZONA").toString());            
         datosPersonales.setCodTerritorio(rs.getValueAt(0, "COD_TERR").toString());                        
         cliente.setDatosPersonales(datosPersonales);

         Periodo periodo = null;
         for(int i=0; i<largo;i++){
            solicitud = new Solicitud();
            solicitud.setOidSolicitud(new Long(rs.getValueAt(i, "OID_SOLI_CABE").toString()));
            solicitud.setOidZona(new Long(rs.getValueAt(i, "ZZON_OID_ZONA").toString()));
            solicitud.setOidMarca(new Long(rs.getValueAt(i, "MARC_OID_MARC").toString()));
            solicitud.setOidCanal(new Long(rs.getValueAt(i, "CANA_OID_CANA").toString()));;
            solicitud.setOidPais(new Long(rs.getValueAt(i, "PAIS_OID_PAIS").toString()));
            solicitud.setOrdenDeCompra(true);
            if (((BigDecimal) rs.getValueAt(i, "IND_ANUL")).intValue() == 1) {
                solicitud.setIndAnulacion(true);
            } else {
                solicitud.setIndAnulacion(false);
            }

            if (((BigDecimal) rs.getValueAt(i, "IND_DEVO")).intValue() == 1) {
                solicitud.setIndDevolucion(true);
            } else {
                solicitud.setIndDevolucion(false);
            }
            solicitud.setFechaDocumento((java.sql.Date)rs.getValueAt(i, "FECCRONANUL"));
            solicitud.setFechaFacturacion((java.sql.Date)rs.getValueAt(i, "FECFACTANUL"));
            
            periodo = new Periodo();
            periodo.setOidPeriodo(new Long(rs.getValueAt(i, "OID_PERI").toString()));
            periodo.setFechaDesde((java.sql.Date) rs.getValueAt(i, "FEC_INIC"));
            periodo.setFechaHasta((java.sql.Date) rs.getValueAt(i, "FEC_FINA"));
            periodo.setCodperiodo(rs.getValueAt(i, "COD_PERI").toString());
            periodo.setOidPais(new Long(rs.getValueAt(i, "PAIS_OID_PAIS").toString()));
            periodo.setOidMarca(new Long(rs.getValueAt(i, "MARC_OID_MARC").toString()));
            periodo.setOidCanal(new Long(rs.getValueAt(i, "CANA_OID_CANA").toString()));
            solicitud.setPeriodo(periodo);
            
            /*periodoCalc = new Periodo();
            periodoCalc.setOidPeriodo(new Long(rs.getValueAt(i, "OID_PERI_CALC").toString()));
            periodoCalc.setFechaDesde((java.sql.Date) rs.getValueAt(i, "FEC_INIC_CALC"));
            periodoCalc.setFechaHasta((java.sql.Date) rs.getValueAt(i, "FEC_FINA_CALC"));
            periodoCalc.setCodperiodo(rs.getValueAt(i, "COD_PERI_CALC").toString());
            periodoCalc.setOidPais(new Long(rs.getValueAt(i, "PAIS_OID_PAIS").toString()));
            periodoCalc.setOidMarca(new Long(rs.getValueAt(i, "MARC_OID_MARC").toString()));
            periodoCalc.setOidCanal(new Long(rs.getValueAt(i, "CANA_OID_CANA").toString()));
            
            solicitud.setPeriodoCalculo(periodoCalc);*/
            
            DAOSolicitudes daoS  = new DAOSolicitudes();
            daoS.obtenerPosicionesSolicitud(solicitud);

            solicitud.setCliente(cliente);
          
            salida.add(solicitud);            
         }
      }
      
      UtilidadesLog.info("DAOCalcularMetas.obtenerSolicitudesCompleto(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion Boolean indDevolucion): Salida");      
      return salida;
   }

    public DTOSolicitudValidacion[] obtenerSolicitudes(DTOUACliente dtoUA, Long oidPeriodoInicio, Long oidPeriodoFin, Boolean indAnulacion,
                                                       Boolean indDevolucion)
            throws MareException {
        UtilidadesLog.info("DAOCalcularMetas.obtenerSolicitudes(DTOUACliente dtoUA):Entrada");
        //Se obtienen las solicitudes consolidadas para la unidad administrativa de un gerente,
        //que sean orden de compra, que sean o no anulaciones o devoluciones dependiendo de 
        //los indicadores de anulación y devolución de los parámetros de calificación del 
        //concurso       
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        boolean primerRegistro = true;
        DTOSolicitudValidacion[] resu = null;
        
        if (indAnulacion == null) {
            indAnulacion = Boolean.FALSE;
        }
        
        if (indDevolucion == null) {
            indDevolucion = Boolean.FALSE;
        }
        
        StringBuffer query = new StringBuffer();
        UtilidadesLog.info("dentro de DAOCalcularMetas==>>obtenerSolicitudes, recibo DTOUACliente.: " + dtoUA);

        query.append(" SELECT A.OID_SOLI_CABE, A.CLIE_OID_CLIE, A.ZZON_OID_ZONA, A.PERD_OID_PERI, ");
        query.append(" A.PAIS_OID_PAIS, B.MARC_OID_MARC,B.CANA_OID_CANA ");
        query.append(" FROM PED_SOLIC_CABEC A, ");
        query.append(" CRA_PERIO B ");
        query.append(" ,ZON_ZONA E ");
        query.append(" ,ZON_REGIO F  ");
        query.append(" ,ZON_SECCI S  ");
        query.append(" ,ZON_TERRI_ADMIN tadm ");
        query.append(" ,ZON_SUB_GEREN_VENTA G, CRA_PERIO INICIO, CRA_PERIO FIN ");

        if ((!indAnulacion.booleanValue()) || (!indDevolucion.booleanValue())) {
            query.append(" , PED_TIPO_SOLIC_PAIS C ");
            query.append(" , PED_TIPO_SOLIC D ");
        }

        query.append("WHERE A.PERD_OID_PERI = B.OID_PERI ");
        query.append(" AND FIN.OID_PERI = " + oidPeriodoFin);
        query.append(" AND INICIO.OID_PERI = " + oidPeriodoInicio);
        query.append(" AND B.FEC_INIC >= INICIO.FEC_INIC ");
        query.append(" AND B.FEC_FINA <= FIN.FEC_FINA ");
        query.append(" AND A.IND_OC = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND A.IND_TS_NO_CONSO = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND tadm.TERR_OID_TERR = A.TERR_OID_TERR ");
        query.append(" AND tadm.ZSCC_OID_SECC = S.OID_SECC ");
        query.append(" AND S.ZZON_OID_ZONA = E.OID_ZONA  ");
        query.append(" AND E.OID_ZONA = A.ZZON_OID_ZONA ");
        query.append(" AND F.OID_REGI = E.ZORG_OID_REGI ");
        query.append(" AND G.OID_SUBG_VENT = F.ZSGV_OID_SUBG_VENT ");

        if (dtoUA.getOidSeccion() != null) {
            query.append(" AND S.OID_SECC = " + dtoUA.getOidSeccion());
        }
        
        if (dtoUA.getOidSeccion() == null && dtoUA.getOidZona() != null) {
            query.append(" AND E.OID_ZONA = " + dtoUA.getOidZona());
        }

        if ((dtoUA.getOidZona() == null) && (dtoUA.getOidRegion() != null)) {
            query.append(" AND F.OID_REGI = " + dtoUA.getOidRegion());
        }

        if ((dtoUA.getOidZona() == null) && (dtoUA.getOidRegion() == null) && (dtoUA.getOidSubgerencia() != null)) {
            query.append(" AND G.OID_SUBG_VENT = " + dtoUA.getOidSubgerencia());
        }

        if ((!indAnulacion.booleanValue()) || (!indDevolucion.booleanValue())) {
            query.append(" AND C.OID_TIPO_SOLI_PAIS = A.TSPA_OID_TIPO_SOLI_PAIS ");
            query.append(" AND D.OID_TIPO_SOLI = C.TSOL_OID_TIPO_SOLI ");
        }

        if (!indAnulacion.booleanValue()) {
            query.append(" AND D.IND_ANUL = " + ConstantesINC.IND_INACTIVO);
        }

        if (!indDevolucion.booleanValue()) {
            query.append(" AND D.IND_DEVO = " + ConstantesINC.IND_INACTIVO);
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs.getRowCount() > 0) {
            DTOSolicitudValidacion[] resu1 = new DTOSolicitudValidacion[rs.getRowCount()];

            for (int row = 0; row < rs.getRowCount(); row++) {
                DTOSolicitudValidacion registro = new DTOSolicitudValidacion();
                registro.setOidCliente((rs.getValueAt(row, "CLIE_OID_CLIE") == null) ? null
                                                                                     : new Long(((BigDecimal) rs.getValueAt(row, "CLIE_OID_CLIE")).toString()));
                registro.setOidSolicitud((rs.getValueAt(row, "OID_SOLI_CABE") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "OID_SOLI_CABE")).toString()));
                registro.setZona((rs.getValueAt(row, "ZZON_OID_ZONA") == null) ? null
                                                                               : new Long(((BigDecimal) rs.getValueAt(row, "ZZON_OID_ZONA")).toString()));
                registro.setOidPeriodo((rs.getValueAt(row, "PERD_OID_PERI") == null) ? null
                                                                                     : new Long(((BigDecimal) rs.getValueAt(row, "PERD_OID_PERI")).toString()));
                registro.setOidPais((rs.getValueAt(row, "PAIS_OID_PAIS") == null) ? null
                                                                                  : new Long(((BigDecimal) rs.getValueAt(row, "PAIS_OID_PAIS")).toString()));
                registro.setOidMarca((rs.getValueAt(row, "MARC_OID_MARC") == null) ? null
                                                                                   : new Long(((BigDecimal) rs.getValueAt(row, "MARC_OID_MARC")).toString()));
                registro.setOidCanal((rs.getValueAt(row, "CANA_OID_CANA") == null) ? null
                                                                                   : new Long(((BigDecimal) rs.getValueAt(row, "CANA_OID_CANA")).toString()));

                resu1[row] = registro;
            }
            UtilidadesLog.info("DAOCalcularMetas.obtenerSolicitudes(DTOUACliente dtoUA):Salida " + resu1.length);
            return resu1;
        } else {
            UtilidadesLog.info("DAOCalcularMetas.obtenerSolicitudes(DTOUACliente dtoUA:Salida NULL");
            return resu;
        }
    }

    public DTOOIDs obtenerGerentesParticipantes(DTOBusquedaClienteCalificado DTOE)
            throws MareException {
        UtilidadesLog.info("DAOCalcularMetas.obtenerGerentesParticipantes(DTOBusquedaClienteCalificado DTOE):Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        DTOOIDs resu = new DTOOIDs();
        boolean primerRegistro = true;

        StringBuffer query = new StringBuffer();
        UtilidadesLog.info("dentro de DAOCalcularMetas==>>obtenerGerentesParticipantes, recibo DTOE.: " + DTOE);

        query.append(" SELECT distinct A.CLIE_OID_CLIE ");
        query.append(" FROM V_MAE_TIPIF_CLIEN A, ");
        query.append(" INC_PARTI_CONCU_DETAL B, ");
        query.append(" INC_PARTI_CONCU_CABEC C ");
        query.append(" WHERE A.TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente());
        query.append(" AND A.TICL_OID_TIPO_CLIE = B.TICL_OID_TIPO_CLIE ");
        query.append(" AND A.SBTI_OID_SUBT_CLIE = B.SBTI_OID_SUBT_CLIE ");
        query.append(" AND A.CLAS_OID_CLAS = B.CLAS_OID_CLAS ");
        query.append(" AND A.TCCL_OID_TIPO_CLASI = B.TCCL_OID_TIPO_CLAS ");
        query.append(" AND B.PACI_OID_PART_CONC_CABE = C.OID_PART_CONC_CABE ");

        //jrivas 1028 18-7-2006
        //if ((!DTOE.getIndParticipantesCompleto().booleanValue()) && (DTOE.getListaParticipantesCalificacion().size() > 0)) {
        if ((DTOE.getListaParticipantesCalificacion() != null) && (DTOE.getListaParticipantesCalificacion().size() > 0)) {
            query.append("AND( ");

            boolean primeraVez = true;
            DTOCalificacionParticipante registro = new DTOCalificacionParticipante();

            for (int j = 0; j < DTOE.getListaParticipantesCalificacion().size(); j++) {
                registro = (DTOCalificacionParticipante) DTOE.getListaParticipantesCalificacion().get(j);

                if (primeraVez) {
                    primeraVez = false;
                    query.append("C.OID_PART_CONC_CABE = " + registro.getOidParticipante() + " ");
                } else {
                    query.append("OR C.OID_PART_CONC_CABE = " + registro.getOidParticipante() + " ");
                }
            }

            query.append(" )");
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());

            if ((rs != null) || (rs.getRowCount() > 0)) {
                Long oid = null;
                Long[] colleccion = new Long[rs.getRowCount()];

                for (int row = 0; row < rs.getRowCount(); row++) {
                    if (rs.getValueAt(row, "CLIE_OID_CLIE") != null) {
                        oid = new Long(((BigDecimal) rs.getValueAt(row, "CLIE_OID_CLIE")).toString());
                    }

                    colleccion[row] = oid;
                }

                resu.setOids(colleccion);
            }
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCalcularMetas.obtenerGerentesParticipantes(DTOBusquedaClienteCalificado DTOE):Salida");
        return resu;
    }

    private boolean contenidoEnOIDS(Long oidClie, DTOOIDs oids)
            throws MareException {
        UtilidadesLog.info("DAOCalcularMetas.contenidoEnOIDS(Long oidClie, DTOOIDs oids):Entrada");
        boolean resu = false;
        int len = oids.getOids().length;

        for (int i = 0; i < len; i++) {
            if (oids.getOids()[i] != null) {
                Long oid;
                oid = oids.getOids()[i];

                if (oid.equals(oidClie)) {
                    resu = true;

                    break;
                }
            }
        }
        UtilidadesLog.info("DAOCalcularMetas.contenidoEnOIDS(Long oidClie, DTOOIDs oids):Salida");
        return resu;
    }

    public RecordSet obtenerTipificacionesParticipantes(ArrayList listaClasifParti)
            throws MareException {
        UtilidadesLog.info("DAOCalcularMetas.obtenerTipificacionesParticipantes(ArrayList listaClasifParti):Entrada");
        // listaClasifParti contiene objetos del tipo DTOClasificacion
        //inc. 19000
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        String filtroIN = new String();

        if ((listaClasifParti != null) && (listaClasifParti.size() > 0)) {
            // vbongiov -- 18/09/2006 -- inc DBLG500000304
            DTOCalificacionParticipante elemlistaClasifParti = new DTOCalificacionParticipante();

            boolean primeraVez = true;
            for (int j = 0; j < listaClasifParti.size(); j++) {
                elemlistaClasifParti = (DTOCalificacionParticipante) listaClasifParti.get(j);

                if (primeraVez) {
                    primeraVez = false;
                    filtroIN = filtroIN.concat(elemlistaClasifParti.getOidParticipante().toString());
                } else {
                    filtroIN = filtroIN.concat(" , ");
                    filtroIN = filtroIN.concat(elemlistaClasifParti.getOidParticipante().toString());
                }
            }
        }

        StringBuffer query = new StringBuffer();
        UtilidadesLog.info("dentro de DAOCalcularMetas==>>obtenerTipificacionesParticipantes, recibo : " + listaClasifParti);

        query.append("SELECT PAD.TICL_OID_TIPO_CLIE tipoCli, PAD.SBTI_OID_SUBT_CLIE subtipoCli, ");
        query.append("PAD.TCCL_OID_TIPO_CLAS tipoClas, PAD.CLAS_OID_CLAS clas ");
        query.append("FROM INC_PARTI_CONCU_DETAL PAD ");
        query.append("WHERE  PAD.PACI_OID_PART_CONC_CABE  IN ( ");
        query.append(filtroIN);
        query.append(" )");

        UtilidadesLog.debug("la consulta resultante, es: " + query.toString());

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCalcularMetas.obtenerTipificacionesParticipantes(ArrayList listaClasifParti):Salida");
        return rs;
    }
    
     /**
       * Sistema:     Belcorp
       * Modulo:      INC
       * Fecha:       13/07/2006
       * @version     1.00
       * @autor       Cristian Valenzuela
       */
    
    public DTODatosGenMsgMetasVenta buscarDatosGenMsgMetasVenta(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("DAOCalcularMetas.buscarDatosGenMsgMetasVenta(Long oidConcurso):Entrada");
        DTODatosGenMsgMetasVenta dto = null;
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;  

        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT CONCURSO.NUM_CONC, ");
        query.append(" MENSAJE.COD_MENS, ");
        query.append(" PERDESDECONC.VAL_NOMB_PERI AS PERDESDECONC, ");
        query.append(" PERHASTACONC.VAL_NOMB_PERI AS PERHASTACONC, ");
        query.append(" PERDESDECALI.VAL_NOMB_PERI AS PERDESDECALI, ");
        query.append(" PERHASTACALI.VAL_NOMB_PERI AS PERHASTACALI, ");
        query.append(" OBTPUNTO.VAL_FACT_CONV, ");
        query.append(" OBTPUNTO.NUM_PUNT_ASIG ");
        query.append(" FROM INC_CONCU_PARAM_GENER CONCURSO, ");
        query.append(" INC_PARAM_CALIF CALI, ");
        query.append(" INC_OBTEN_PUNTO OBTPUNTO, ");
        query.append(" MSG_MENSA MENSAJE, ");
        query.append(" CRA_PERIO PERDESDECONC, ");
        query.append(" CRA_PERIO PERHASTACONC, ");
        query.append(" CRA_PERIO PERDESDECALI, ");
        query.append(" CRA_PERIO PERHASTACALI ");
        query.append(" WHERE CONCURSO.OID_PARA_GRAL = " + oidConcurso);
        query.append(" AND CONCURSO.OID_PARA_GRAL = CALI.COPA_OID_PARA_GRAL  ");
        query.append(" AND CONCURSO.OID_PARA_GRAL = OBTPUNTO.COPA_OID_PARA_GRAL  ");
        query.append(" AND CALI.MENS_OID_MENS = MENSAJE.OID_MENS  ");
        query.append(" AND PERDESDECONC.OID_PERI = CONCURSO.PERD_OID_PERI_DESD ");
        query.append(" AND PERHASTACONC.OID_PERI = CONCURSO.PERD_OID_PERI_HAST ");
        query.append(" AND PERDESDECALI.OID_PERI = CALI.PERD_OID_PERI_DESD ");
        query.append(" AND PERHASTACALI.OID_PERI = CALI.PERD_OID_PERI_HAST ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }        
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
        
        if(!rs.esVacio()) {
            dto = new DTODatosGenMsgMetasVenta();            
            
            dto.setNumeroConcurso(rs.getValueAt(0, "NUM_CONC")==null?null:
            ((String)rs.getValueAt(0, "NUM_CONC")));
            
            dto.setMensaje(rs.getValueAt(0, "COD_MENS")==null?null:
            ((String)rs.getValueAt(0, "COD_MENS")));
            
            dto.setPeriodoDesdeConc(rs.getValueAt(0, "PERDESDECONC")==null?null:
            ((String)rs.getValueAt(0, "PERDESDECONC")));
            
            dto.setPeriodoHastaConc(rs.getValueAt(0, "PERHASTACONC")==null?null:
            ((String)rs.getValueAt(0, "PERHASTACONC")));
            
            dto.setPeriodoDesdeCali(rs.getValueAt(0, "PERDESDECALI")==null?null:
            ((String)rs.getValueAt(0, "PERDESDECALI")));
            
            dto.setPeriodoHastaCali(rs.getValueAt(0, "PERHASTACALI")==null?null:
            ((String)rs.getValueAt(0, "PERHASTACALI")));
            
            dto.setFactorConversion(rs.getValueAt(0, "VAL_FACT_CONV")==null?null:
            ((BigDecimal)rs.getValueAt(0, "VAL_FACT_CONV")));
            
            dto.setNumeroPuntos(rs.getValueAt(0, "NUM_PUNT_ASIG")==null?null:
            new Integer(((BigDecimal)rs.getValueAt(0, "NUM_PUNT_ASIG")).intValue()));       
        }       
        
        UtilidadesLog.info("DAOCalcularMetas.buscarDatosGenMsgMetasVenta(Long oidConcurso):Salida");        
        return dto;
    }
    
    /**
       * Sistema:     Belcorp
       * Modulo:      INC
       * Fecha:       13/07/2006
       * @version     1.00
       * @autor       Cristian Valenzuela
       */
       
    public ArrayList buscarMetasYClientesPorConcurso(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("DAOCalcularMetas.buscarMetasYClientesPorConcurso(Long oidConcurso):Entrada");        
        ArrayList resultado = null;
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;  

        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT META.VAL_META, ");
        query.append(" META.VAL_INCR, ");
        query.append(" META.CLIE_OID_CLIE, ");
        query.append(" CLIENTE.VAL_NOM1, ");
        query.append(" CLIENTE.VAL_APE1, ");
        query.append(" CLIENTE.COD_CLIE, ");
        query.append(" ZONA.COD_ZONA, ");
        query.append(" TERRI.COD_TERR ");
        query.append(" FROM INC_CONCU_PARAM_GENER CONCURSO, ");
        query.append(" INC_METAS_TIPO_VENTA META, ");
        query.append(" MAE_CLIEN CLIENTE, ");
        query.append(" MAE_CLIEN_UNIDA_ADMIN UNIADM, ");
        query.append(" ZON_TERRI_ADMIN TERRIADM, ");
        query.append(" ZON_TERRI TERRI, ");
        query.append(" ZON_SECCI SECCI, ");
        query.append(" ZON_ZONA ZONA ");
        query.append(" WHERE CONCURSO.OID_PARA_GRAL = " + oidConcurso);
        query.append(" AND META.COPA_OID_PARA_GRAL = CONCURSO.OID_PARA_GRAL ");
        query.append(" AND META.CLIE_OID_CLIE = CLIENTE.OID_CLIE ");
        query.append(" AND UNIADM.CLIE_OID_CLIE = CLIENTE.OID_CLIE ");
        query.append(" AND UNIADM.IND_ACTI = 1 ");
        query.append(" AND TERRIADM.OID_TERR_ADMI = UNIADM.ZTAD_OID_TERR_ADMI ");
        query.append(" AND TERRIADM.PAIS_OID_PAIS = CONCURSO.PAIS_OID_PAIS ");
        query.append(" AND TERRIADM.MARC_OID_MARC = CONCURSO.MARC_OID_MARC ");
        query.append(" AND TERRIADM.CANA_OID_CANA = CONCURSO.CANA_OID_CANA ");
        query.append(" AND TERRI.OID_TERR = TERRIADM.TERR_OID_TERR ");
        query.append(" AND SECCI.OID_SECC = TERRIADM.ZSCC_OID_SECC ");
        query.append(" AND SECCI.ZZON_OID_ZONA = ZONA.OID_ZONA ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }        
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
        
        UtilidadesLog.debug("********* RecordSet:" + rs);
        
        if(!rs.esVacio()) {
            resultado  = new ArrayList();
            int cant = rs.getRowCount();
            for(int i=0; i<cant; i++) {
                DTOMsgMetasYClientes dto = new DTOMsgMetasYClientes();                           
                
                dto.setMeta(rs.getValueAt(i, "VAL_META")==null?null:
                ((BigDecimal)rs.getValueAt(i, "VAL_META")));              
                    
                dto.setIncremento(rs.getValueAt(i, "VAL_INCR")==null?null:                
                ((BigDecimal)rs.getValueAt(i, "VAL_INCR")));                                
                
                dto.setCliente(rs.getValueAt(i, "CLIE_OID_CLIE")==null?null:
                new Long(((BigDecimal)rs.getValueAt(i, "CLIE_OID_CLIE")).longValue()));
                
                dto.setNombre1(rs.getValueAt(i, "VAL_NOM1")==null?null:
                ((String)rs.getValueAt(i, "VAL_NOM1")));
                
                dto.setApellido1(rs.getValueAt(i, "VAL_APE1")==null?null:
                ((String)rs.getValueAt(i, "VAL_APE1")));
                
                dto.setCodCliente(rs.getValueAt(i, "COD_CLIE")==null?null:
                ((String)rs.getValueAt(i, "COD_CLIE")));
                
                dto.setCodZona(rs.getValueAt(i, "COD_ZONA")==null?null:
                ((String)rs.getValueAt(i, "COD_ZONA")));
                
                dto.setCodTerritorio(rs.getValueAt(i, "COD_TERR")==null?null:
                new Long(((BigDecimal)rs.getValueAt(i, "COD_TERR")).longValue()));        
                
                UtilidadesLog.debug("********* DTOMsgMetasYClientes:" + dto);
                resultado.add(dto);                
            }           
        }
        
        UtilidadesLog.info("DAOCalcularMetas.buscarMetasYClientesPorConcurso(Long oidConcurso):Salida");        
        return resultado;
    }
}
