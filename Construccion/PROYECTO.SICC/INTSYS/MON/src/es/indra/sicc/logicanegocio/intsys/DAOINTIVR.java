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

package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.intsys.DTODatosBasesIncumplidas;
import es.indra.sicc.dtos.intsys.DTODatosCartera;
import es.indra.sicc.dtos.intsys.DTODatosConcursos;
import es.indra.sicc.dtos.intsys.DTODatosConsultoras;
import es.indra.sicc.dtos.intsys.DTODatosCronograma;
import es.indra.sicc.dtos.intsys.DTODatosGerentes;
import es.indra.sicc.dtos.intsys.DTODatosLineaCredito;
import es.indra.sicc.dtos.intsys.DTODatosMotivosAtencion;
import es.indra.sicc.dtos.intsys.DTODatosNiveles;
import es.indra.sicc.dtos.intsys.DTODatosPremios;
import es.indra.sicc.dtos.intsys.DTODatosProductos;
import es.indra.sicc.dtos.intsys.DTODatosRegiones;
import es.indra.sicc.dtos.intsys.DTODatosServiciosPostVenta;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;


//import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
//import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
public class DAOINTIVR {
    public DAOINTIVR() {
    }

    public ArrayList obtenerRegiones(Long pais, Long oidMarca, Long oidCanal) throws MareException {
        //Traza de entrada
        UtilidadesLog.info("DAOINTIVR.obtenerRegiones(Long pais, Long oidMarca, Long oidCanal): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        // Consulta SQL
        consulta.append(" SELECT COD_REGI CODIGOREGION,DES_REGI DESCRIPCIONREGION ");
        consulta.append(" FROM ZON_REGIO ");
        consulta.append(" WHERE IND_ACTI = 1 ");

        if (pais != null) {
            consulta.append(" AND PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (oidMarca != null) {
            consulta.append(" AND MARC_OID_MARC = ? ");
            parametros.add(oidMarca);
        }

        if (oidCanal != null) {
            consulta.append(" AND CANA_OID_CANA = ? ");
            parametros.add(oidCanal);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerRegiones: Exception", e);
            this.logSql(" obtenerRegiones. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();

        // Rellenamos el ArrayList con objetos 'DTODatosRegiones'
        if (rs != null) {
            int x = rs.getRowCount();

            for (int i = 0; i < x; i++) {
                DTODatosRegiones dto = new DTODatosRegiones();

                if (rs.getValueAt(i, 0) != null) {
                    dto.setCodigoRegion(rs.getValueAt(i, "CODIGOREGION").toString());
                }

                if (rs.getValueAt(i, 1) != null) {
                    dto.setDescripcionRegion(rs.getValueAt(i, "DESCRIPCIONREGION").toString());
                }

                lista.add(dto);
            }
        }

        // Traza de salida
        UtilidadesLog.info("DAOINTIVR.obtenerRegiones(Long pais, Long oidMarca, Long oidCanal): Salida");

        return lista;
    }

    public ArrayList obtenerMotivosAtencion(Long pais, Long idioma) throws MareException {
        //Traza de entrada
        UtilidadesLog.info("DAOINTIVR.obtenerMotivosAtencion(Long pais, Long idioma): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        // Consulta SQL
        consulta.append(" SELECT COD_RECH_DESB CODIGO,(SELECT idio.VAL_I18N ");
        consulta.append("                              FROM V_GEN_I18N_SICC idio ");
        consulta.append("                              WHERE idio.ATTR_ENTI = 'REC_MOTIV_RECHA_DESBL' ");

        if (idioma != null) {
            consulta.append("                          AND idio.IDIO_OID_IDIO = ? ");
            parametros.add(idioma);
        }

        consulta.append("                              AND idio.VAL_OID = OID_MOTI_RECH_DESB) As DESCRIPCION ");
        consulta.append(" FROM REC_MOTIV_RECHA_DESBL ");

        if (pais != null) {
            consulta.append(" WHERE PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerMotivosAtencion: Exception", e);
            this.logSql(" obtenerMotivosAtencion. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();

        // Rellenamos el ArrayList con objetos 'DTODatosRegiones'
        if (rs != null) {
            int x = rs.getRowCount();

            for (int i = 0; i < x; i++) {
                DTODatosMotivosAtencion dto = new DTODatosMotivosAtencion();

                if (rs.getValueAt(i, 0) != null) {
                    dto.setMotivoAtencion(rs.getValueAt(i, "CODIGO").toString());
                }

                if (rs.getValueAt(i, 1) != null) {
                    dto.setDescripcionMotivo(rs.getValueAt(i, "DESCRIPCION").toString());
                }

                lista.add(dto);
            }
        }

        // Traza de salida
        UtilidadesLog.info("DAOINTIVR.obtenerMotivosAtencion(Long pais, Long idioma): Salida");

        return lista;
    }

    public ArrayList obtenerCronogramaOperaciones(Long pais, Long oidMarca, Long oidCanal, Long oidPeriodo, Long oidAcceso) throws MareException {
        //Traza de entrada
        UtilidadesLog.info("DAOINTIVR.obtenerCronogramaOperaciones(Long pais, Long oidMarca, Long oidCanal, Long oidPeriodo, Long oidAcceso): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        // Consulta SQL
        consulta.append(" SELECT ZON_ZONA.COD_ZONA,CRA_ACTIV.COD_ACTI,CRA_CLASE_ACTIV.COD_CLAS_ACTI,CRA_CRONO.FEC_FINA, CRA_CRONO.FEC_INIC ");
        consulta.append(" FROM CRA_CRONO,CRA_ACTIV,CRA_PERIO,CRA_CLASE_ACTIV,ZON_ZONA ");
        consulta.append(" WHERE CRA_CRONO.PERD_OID_PERI = CRA_PERIO.OID_PERI AND CRA_CRONO.CACT_OID_ACTI = CRA_ACTIV.OID_ACTI ");
        consulta.append("       AND CRA_ACTIV.CLAC_OID_CLAS_ACTI = CRA_CLASE_ACTIV.OID_CLAS_ACTI AND CRA_CRONO.ZZON_OID_ZONA = ZON_ZONA.OID_ZONA ");

        if (oidPeriodo != null) {
            consulta.append(" AND CRA_CRONO.PERD_OID_PERI = ? ");
            parametros.add(oidPeriodo);
        }

        if (pais != null) {
            consulta.append(" AND CRA_PERIO.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (oidMarca != null) {
            consulta.append(" AND CRA_PERIO.MARC_OID_MARC = ? ");
            parametros.add(oidMarca);
        }

        if (oidCanal != null) {
            consulta.append(" AND CRA_PERIO.CANA_OID_CANA = ? ");
            parametros.add(oidCanal);
        }

        if (oidAcceso != null) {
            consulta.append(" AND CRA_PERIO.ACCE_OID_ACCE = ? ");
            parametros.add(oidAcceso);
        }

        // BELC300017732
        consulta.append(" AND ( CRA_CLASE_ACTIV.COD_CLAS_ACTI = ? ");
        parametros.add(ConstantesCRA.COD_CLASE_ACTIVIDAD_FACTURACION);
        consulta.append(" OR CRA_CLASE_ACTIV.COD_CLAS_ACTI = ? ");
        parametros.add(ConstantesCRA.COD_CLASE_ACTIVIDAD_CURSO);
        consulta.append(" OR CRA_CLASE_ACTIV.COD_CLAS_ACTI = ? ) ");
        parametros.add(ConstantesCRA.COD_CLASE_ACTIVIDAD_RECLAMOS);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerCronogramaOperaciones: Exception", e);
            this.logSql(" obtenerCronogramaOperaciones. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();

        // Rellenamos el ArrayList con objetos 'DTODatosRegiones'
        if (rs != null) {
            int x = rs.getRowCount();

            for (int i = 0; i < x; i++) {
                DTODatosCronograma dto = new DTODatosCronograma();

                if (rs.getValueAt(i, 0) != null) {
                    dto.setCodZona(rs.getValueAt(i, "COD_ZONA").toString());
                }

                if (rs.getValueAt(i, 1) != null) {
                    dto.setCodActividad(rs.getValueAt(i, "COD_ACTI").toString());
                }

                // No estoy seguro del campo
                if (rs.getValueAt(i, 2) != null) {
                    dto.setClaseActividad(rs.getValueAt(i, "COD_CLAS_ACTI").toString());
                }

                if (rs.getValueAt(i, 3) != null) {
                    dto.setFechaFin(new java.util.Date(((java.sql.Date) rs.getValueAt(i, "FEC_INIC")).getTime()));
                }
                
                lista.add(dto);
            }
        }

        // Traza de salida
        UtilidadesLog.info("DAOINTIVR.obtenerCronogramaOperaciones(Long pais, Long oidMarca, Long oidCanal, Long oidPeriodo, Long oidAcceso): Salida");

        return lista;
    }

    public ArrayList obtenerGerentes(Long pais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimoProceso) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerGerentes(Long pais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimoProceso): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //sql MODIFICADA SEGUN BELC300018099 y BELC300018253
        consulta.append(" select CLI.COD_CLIE CODIGOCLIENTE, ");
        consulta.append("       CLI.VAL_NOM1 NOMBRE1, ");
        consulta.append("       CLI.VAL_NOM2 NOMBRE2, ");
        consulta.append("       CLI.VAL_APE1 APE1, ");
        consulta.append("       CLI.VAL_APE2 APE2, ");
        consulta.append("       BUZONA.COD_ACCE_BUZO_IVRZ CODBUZONZONA, ");
        consulta.append("       null as CODBUZONREGION, ");
        consulta.append("       CLIDA.FEC_NACI FECHANAC, ");
        consulta.append("       TICLI.COD_TIPO_CLIE CODTIPOCLIENTE, ");
        consulta.append("       CLTISUBTI.SBTI_OID_SUBT_CLIE OIDCLIENTETIPOSUBTIPO ");
        consulta.append(" from MAE_CLIEN CLI, ");
        consulta.append("     MAE_CLIEN_TIPO_SUBTI CLTISUBTI, ");
        consulta.append("     ZON_ZONA ZONA, ");
        consulta.append("     INT_ACCES_BUZON_IVRZN BUZONA, ");
        consulta.append("     MAE_CLIEN_DATOS_ADICI CLIDA, ");
        consulta.append("     MAE_TIPO_CLIEN TICLI ");
        consulta.append(" where CLI.OID_CLIE = CLTISUBTI.CLIE_OID_CLIE ");
        consulta.append("      and CLIDA.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append("      and CLTISUBTI.TICL_OID_TIPO_CLIE = TICLI.OID_TIPO_CLIE ");
        consulta.append("      and CLTISUBTI.SBTI_OID_SUBT_CLIE = ? ");

        //4 --ConstantesMAE.OID_SUBTIPO_GERENTE_ZONA
        parametros.add(ConstantesMAE.OID_SUBTIPO_GERENTE_ZONA);
        consulta.append("      and CLI.OID_CLIE = ZONA.CLIE_OID_CLIE ");
        consulta.append("      and BUZONA.ZZON_OID_ZONA = ZONA.OID_ZONA ");

        if (pais != null) {
            consulta.append(" AND ZONA.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (oidMarca != null) {
            consulta.append(" AND ZONA.MARC_OID_MARC = ? ");
            parametros.add(oidMarca);
        }

        if (oidCanal != null) {
            consulta.append(" AND ZONA.CANA_OID_CANA = ? ");
            parametros.add(oidCanal);
        }

        // 22394 - dmorello, 15/05/2006: Filtro por zona activa y no borrada
        consulta.append("      and ZONA.IND_ACTI = 1 ");
        consulta.append("      and ZONA.IND_BORR = 0 ");

        if (fechaUltimoProceso != null) {
            //la fecha del DTO siempre sera java.util.Date
            java.sql.Date fechaDesde = new java.sql.Date(fechaUltimoProceso.getTime());

            String sFechaDesde = sdf.format(fechaDesde);
            consulta.append(" AND ((CLI.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sFechaDesde);

            /*consulta.append(" AND (ClienteDatosAdicionales.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sFechaDesde);*/
            consulta.append(" OR (CLTISUBTI.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) )");
            parametros.add(sFechaDesde);
        }

        consulta.append(" union ");
        consulta.append(" select CLI.COD_CLIE CODIGOCLIENTE, ");
        consulta.append("      CLI.VAL_NOM1 NOMBRE1, ");
        consulta.append("      CLI.VAL_NOM2 NOMBRE2, ");
        consulta.append("      CLI.VAL_APE1 APE1, ");
        consulta.append("      CLI.VAL_APE2 APE2, ");
        consulta.append("      null as CODBUZONZONA, ");
        consulta.append("      BUREGI.COD_ACCE_BUZO_IVRR CODBUZONREGION, ");
        consulta.append("      CLIDA.FEC_NACI FECHANAC, ");
        consulta.append("      TICLI.COD_TIPO_CLIE CODTIPOCLIENTE, ");
        consulta.append("      CLTISUBTI.SBTI_OID_SUBT_CLIE OIDCLIENTETIPOSUBTIPO ");
        consulta.append(" from MAE_CLIEN CLI, ");
        consulta.append("     MAE_CLIEN_TIPO_SUBTI CLTISUBTI, ");
        consulta.append("     ZON_REGIO REGI, ");
        consulta.append("     INT_ACCES_BUZON_IVRRG BUREGI, ");
        consulta.append("     MAE_CLIEN_DATOS_ADICI CLIDA, ");
        consulta.append("     MAE_TIPO_CLIEN TICLI ");
        consulta.append(" where CLI.OID_CLIE = CLTISUBTI.CLIE_OID_CLIE ");
        consulta.append("      and CLTISUBTI.SBTI_OID_SUBT_CLIE = ? ");

        //3 --ConstantesMAE.OID_SUBTIPO_GERENTE_REGION
        parametros.add(ConstantesMAE.OID_SUBTIPO_GERENTE_REGION);
        consulta.append("      and CLI.OID_CLIE = REGI.CLIE_OID_CLIE ");
        consulta.append("      and BUREGI.ZORG_OID_REGI = REGI.OID_REGI ");
        consulta.append("      and CLIDA.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append("      and CLTISUBTI.TICL_OID_TIPO_CLIE = TICLI.OID_TIPO_CLIE ");

        if (pais != null) {
            consulta.append(" AND REGI.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (oidMarca != null) {
            consulta.append(" AND REGI.MARC_OID_MARC = ? ");
            parametros.add(oidMarca);
        }

        if (oidCanal != null) {
            consulta.append(" AND REGI.CANA_OID_CANA = ? ");
            parametros.add(oidCanal);
        }

        // 22394 - dmorello, 15/05/2006: Filtro por región activa y no borrada
        consulta.append("      and REGI.IND_ACTI = 1 ");
        consulta.append("      and REGI.IND_BORR = 0 ");

        if (fechaUltimoProceso != null) {
            //la fecha del DTO siempre sera java.util.Date
            java.sql.Date fechaDesde = new java.sql.Date(fechaUltimoProceso.getTime());

            String sFechaDesde = sdf.format(fechaDesde);
            consulta.append(" AND ((CLI.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sFechaDesde);

            /*consulta.append(" AND (ClienteDatosAdicionales.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sFechaDesde);*/
            consulta.append(" OR (CLTISUBTI.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) )");
            parametros.add(sFechaDesde);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerGerentes: Exception", e);
            this.logSql(" obtenerGerentes. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList listaRetorno = new ArrayList();

        if (rs != null) {
            int tamano = rs.getRowCount();

            for (int i = 0; i < tamano; i++) {
                DTODatosGerentes dtoDatosGerentes = new DTODatosGerentes();

                if (rs.getValueAt(i, "APE1") != null) {
                    dtoDatosGerentes.setApellido1(rs.getValueAt(i, "APE1").toString());
                }

                if (rs.getValueAt(i, "APE2") != null) {
                    dtoDatosGerentes.setApellido2(rs.getValueAt(i, "APE2").toString());
                }

                if (rs.getValueAt(i, "CODIGOCLIENTE") != null) {
                    dtoDatosGerentes.setCodCliente(rs.getValueAt(i, "CODIGOCLIENTE").toString());
                }

                if (rs.getValueAt(i, "CODTIPOCLIENTE") != null) {
                    dtoDatosGerentes.setCodTipoCliente(rs.getValueAt(i, "CODTIPOCLIENTE").toString());
                }

                if (rs.getValueAt(i, "FECHANAC") != null) {
                    dtoDatosGerentes.setFechaNacimiento(new java.util.Date(((java.sql.Date) rs.getValueAt(i, "FECHANAC")).getTime()));
                }

                if (rs.getValueAt(i, "NOMBRE1") != null) {
                    dtoDatosGerentes.setNombre1(rs.getValueAt(i, "NOMBRE1").toString());
                }

                if (rs.getValueAt(i, "NOMBRE2") != null) {
                    dtoDatosGerentes.setNombre2(rs.getValueAt(i, "NOMBRE2").toString());
                }

                if (rs.getValueAt(i, "OIDCLIENTETIPOSUBTIPO") != null) {
                    dtoDatosGerentes.setOidSubTipoCliente(new Long(((BigDecimal) rs.getValueAt(i, "OIDCLIENTETIPOSUBTIPO")).longValue()));
                }

                if (rs.getValueAt(i, "CODBUZONREGION") != null) {
                    dtoDatosGerentes.setCodBuzonRegion(rs.getValueAt(i, "CODBUZONREGION").toString());
                }

                if (rs.getValueAt(i, "CODBUZONZONA") != null) {
                    dtoDatosGerentes.setCodBuzonZona(rs.getValueAt(i, "CODBUZONZONA").toString());
                }

                listaRetorno.add(dtoDatosGerentes);
            }
        }

        UtilidadesLog.info("DAOINTIVR.obtenerGerentes(Long pais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimoProceso): Salida");

        return listaRetorno;
    }

    public DTOSalida obtenerInterfacesIVR(DTOString dto) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerInterfacesIVR(DTOString dto): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT IDI.OID_DEFI_INTE OIDINTER, ");
        consulta.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO ");
        consulta.append(" WHERE IDIO.ATTR_ENTI = 'INT_DEFIN_INTER' AND IDIO.IDIO_OID_IDIO = ? AND IDIO.VAL_OID = IDI.OID_DEFI_INTE ) DESCINTER ");

        if ((dto != null) && (dto.getOidIdioma() != null)) {
            parametros.add(dto.getOidIdioma());
        } else {
            parametros.add(new Long(1));
        }

        consulta.append(" FROM INT_DEFIN_INTER IDI ");
        consulta.append(" WHERE IDI.VAL_SIST = 'IVR' AND IDI.VAL_TIPO_INTE = '1' AND (");

        if ((dto != null) && (dto.getCadena() != null)) {
            String cadena = dto.getCadena();
            consulta.append(" IDI.VAL_MODO_ENVI = ? OR ");
            parametros.add(cadena);
        }

        consulta.append(" IDI.VAL_MODO_ENVI = '3') ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerInterfacesIVR: Exception", e);
            this.logSql(" obtenerInterfacesIVR. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        DTOSalida dTOSalida = new DTOSalida();

        if (rs != null) {
            dTOSalida.setResultado(rs);
        }

        UtilidadesLog.info("DAOINTIVR.obtenerInterfacesIVR(DTOString dto): Salida");

        return dTOSalida;
    }

    public ArrayList obtenerCarteras(Long pais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimoProceso) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerCarteras(Long pais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimoProceso): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT MIN ( CED.VAL_EDAD_INIC ) MINEDADINICIAL ");
        consulta.append(" FROM COB_ETAPA_DEUDA CED ");

        if (pais != null) {
            consulta.append(" WHERE CED.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerCarteras: Exception", e);
            this.logSql(" obtenerCarteras. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        BigDecimal minEdadInicial = null;

        if (rs != null) {
            minEdadInicial = (BigDecimal) rs.getValueAt(0, 0);
        }

        consulta.delete(0, consulta.length());
        parametros.clear();

        //sql MODIFICADA SEGUN BELC300018729
        consulta.append(" SELECT CLI.COD_CLIE CLIENTE, SPC.COD_PERI PERIODO, ");
        consulta.append("        MCC.NUM_IDEN_CUOT DOCUMENTO, MCC.IMP_PEND IMPORTE ");
        consulta.append(" FROM   MAE_CLIEN CLI, MAE_CLIEN_BLOQU CLB, MAE_TIPO_BLOQU TBL, ");
        consulta.append("        MAE_CLIEN_TIPO_SUBTI TST, CCC_MARCA_TIPO_ABONO MTA, ");
        consulta.append("        CCC_TIPO_ABONO_SUBPR TSP, CCC_SUBPR SPR, ");
        consulta.append("        CCC_PROCE PRO, CRA_PERIO PER,  ");
        consulta.append("        CCC_MARCA_SITUA MST1, CCC_MARCA_SITUA MST2, ");
        consulta.append("        CCC_MOVIM_CUENT_CORRI MCC ,SEG_PERIO_CORPO SPC ");
        consulta.append(" WHERE  CLI.OID_CLIE = MCC.CLIE_OID_CLIE ");
        consulta.append("        AND PER.PERI_OID_PERI = SPC.OID_PERI");
        consulta.append("        AND CLI.OID_CLIE = CLB.CLIE_OID_CLIE (+) ");
        consulta.append("        AND CLB.TIBQ_OID_TIPO_BLOQ = TBL.OID_TIPO_BLOQ ");
        consulta.append("        AND CLI.OID_CLIE = TST.CLIE_OID_CLIE ");
        consulta.append("        AND MCC.PERD_OID_PERI = PER.OID_PERI ");
        consulta.append("        AND MCC.MASI_OID_MARC_SITU = MST1.OID_MARC_SITU ");
        consulta.append("        AND MTA.MASI_OID_MARC_SALI = MST2.OID_MARC_SITU ");
        consulta.append("        AND MST1.OID_MARC_SITU = MST2.OID_MARC_SITU ");
        consulta.append("        AND MTA.TASP_OID_TIPO_ABON_SUBP = TSP.OID_TIPO_ABON_SUBP ");
        consulta.append("        AND TSP.SUBP_OID_SUBP = SPR.OID_SUBP ");
        consulta.append("        AND SPR.CCPR_OID_PROC = PRO.OID_PROC ");
        consulta.append("        AND TST.TICL_OID_TIPO_CLIE = 2 "); //--viene en el DECU pero no en el diseño
        consulta.append("        AND MCC.IMP_PEND <> 0  ");
        consulta.append("        AND SPR.COD_SUBP = 1 ");

        if (pais != null) {
            consulta.append("    AND CLI.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (oidMarca != null) {
            consulta.append("    AND MCC.MARC_OID_MARC = ? ");
            parametros.add(oidMarca);
        }

        if (oidCanal != null) {
            consulta.append("    AND PER.CANA_OID_CANA = ? ");
            parametros.add(oidCanal);
        }

        consulta.append("        AND PRO.COD_PROC = ? ");
        parametros.add(ConstantesBEL.COD_CON001);
        consulta.append("        AND TBL.COD_TIPO_BLOQ NOT IN ( ? , ? ) ");
        parametros.add(ConstantesMAE.BLOQUEO_ADMINISTRATIVO); //'01'
        parametros.add(ConstantesMAE.BLOQUEO_FINANCIERO); //'02'

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sFecha;
        java.sql.Date fecha = null;

        if (minEdadInicial != null) {
            fecha = new java.sql.Date(System.currentTimeMillis());
            sFecha = sdf.format(fecha);

            consulta.append("    AND MCC.FEC_DOCU + ? < TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");
            parametros.add(minEdadInicial);
            parametros.add(sFecha);
        }

        if (fechaUltimoProceso != null) {
            fecha = new java.sql.Date(fechaUltimoProceso.getTime());
            sFecha = sdf.format(fecha);

            consulta.append("    AND ((TST.FEC_ULTI_ACTU > TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFecha);
            consulta.append("    OR (MCC.FEC_ULTI_ACTU > TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ) )");
            parametros.add(sFecha);
        }

        consulta.append(" UNION   ");
        consulta.append(" SELECT CLI.COD_CLIE CLIENTE, SPC.COD_PERI PERIODO, ");
        consulta.append("        MCC.NUM_IDEN_CUOT DOCUMENTO, MCC.IMP_PEND IMPORTE ");
        consulta.append(" FROM   MAE_CLIEN CLI, MAE_CLIEN_BLOQU CLB, MAE_CLIEN_TIPO_SUBTI TST, ");
        consulta.append("        CCC_MARCA_TIPO_ABONO MTA, CCC_TIPO_ABONO_SUBPR TSP, ");
        consulta.append("        CCC_SUBPR SPR, CCC_PROCE PRO, CRA_PERIO PER, ");
        consulta.append("        CCC_MARCA_SITUA MST1, CCC_MARCA_SITUA MST2, ");
        consulta.append("        CCC_MOVIM_CUENT_CORRI MCC ,SEG_PERIO_CORPO SPC ");
        consulta.append(" WHERE  CLI.OID_CLIE = MCC.CLIE_OID_CLIE ");
        consulta.append("        AND PER.PERI_OID_PERI = SPC.OID_PERI");
        consulta.append("        AND CLI.OID_CLIE = CLB.CLIE_OID_CLIE (+) ");
        consulta.append("        AND CLB.TIBQ_OID_TIPO_BLOQ is null ");
        consulta.append("        AND CLI.OID_CLIE = TST.CLIE_OID_CLIE ");
        consulta.append("        AND MCC.PERD_OID_PERI = PER.OID_PERI ");
        consulta.append("        AND MCC.MASI_OID_MARC_SITU = MST1.OID_MARC_SITU ");
        consulta.append("        AND MTA.MASI_OID_MARC_SALI = MST2.OID_MARC_SITU ");
        consulta.append("        AND MST1.OID_MARC_SITU = MST2.OID_MARC_SITU ");
        consulta.append("        AND MTA.TASP_OID_TIPO_ABON_SUBP = TSP.OID_TIPO_ABON_SUBP ");
        consulta.append("        AND TSP.SUBP_OID_SUBP = SPR.OID_SUBP ");
        consulta.append("        AND SPR.CCPR_OID_PROC = PRO.OID_PROC ");
        consulta.append("        AND TST.TICL_OID_TIPO_CLIE = 2 "); //--viene en el DECU pero no en el diseño
        consulta.append("        AND MCC.IMP_PEND <> 0 ");
        consulta.append("        AND SPR.COD_SUBP = 1 ");

        if (pais != null) {
            consulta.append("    AND CLI.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (oidMarca != null) {
            consulta.append("    AND MCC.MARC_OID_MARC = ? ");
            parametros.add(oidMarca);
        }

        if (oidCanal != null) {
            consulta.append("    AND PER.CANA_OID_CANA = ? ");
            parametros.add(oidCanal);
        }

        consulta.append("        AND PRO.COD_PROC = ? ");
        parametros.add(ConstantesBEL.COD_CON001);

        if (minEdadInicial != null) {
            fecha = new java.sql.Date(System.currentTimeMillis());
            sFecha = sdf.format(fecha);

            consulta.append("    AND MCC.FEC_DOCU + ? < TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");
            parametros.add(minEdadInicial);
            parametros.add(sFecha);
        }

        if (fechaUltimoProceso != null) {
            fecha = new java.sql.Date(fechaUltimoProceso.getTime());
            sFecha = sdf.format(fecha);


            consulta.append("    AND ((TST.FEC_ULTI_ACTU > TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFecha);
            consulta.append("    OR (MCC.FEC_ULTI_ACTU > TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ) )");
            parametros.add(sFecha);
        }

        /*consulta.append(" SELECT CLI.COD_CLIE CLIENTE,PER.OID_PERI PERIODO,MCC.NUM_IDEN_CUOT DOCUMENTO,MCC.IMP_PEND IMPORTE ");
        consulta.append(" FROM   CCC_MOVIM_CUENT_CORRI MCC,MAE_CLIEN CLI,MAE_CLIEN_BLOQU CLB,MAE_TIPO_BLOQU TBL, ");
        consulta.append("        MAE_CLIEN_TIPO_SUBTI TST,CCC_MARCA_TIPO_ABONO MTA,CCC_TIPO_ABONO_SUBPR TSP,  ");
        consulta.append("        CCC_SUBPR SPR,CCC_PROCE PRO,CRA_PERIO PER, CCC_MARCA_SITUA MST ");
        consulta.append(" WHERE  CLI.OID_CLIE = CLB.CLIE_OID_CLIE AND CLB.TIBQ_OID_TIPO_BLOQ = TBL.OID_TIPO_BLOQ ");
        consulta.append("        AND CLI.OID_CLIE = TST.CLIE_OID_CLIE AND CLI.OID_CLIE = MCC.CLIE_OID_CLIE ");
        consulta.append("        AND MCC.PERD_OID_PERI = PER.OID_PERI  AND MCC.MASI_OID_MARC_SITU = MST.OID_MARC_SITU ");
        consulta.append("        AND MTA.MASI_OID_MARC_SALI = MST.OID_MARC_SITU AND MTA.TASP_OID_TIPO_ABON_SUBP = TSP.OID_TIPO_ABON_SUBP ");
        consulta.append("        AND TSP.SUBP_OID_SUBP = SPR.OID_SUBP AND SPR.CCPR_OID_PROC = PRO.OID_PROC ");

        consulta.append("        AND MCC.IMP_PEND <> 0 AND SPR.COD_SUBP = 1 ");

        if(pais != null){
        consulta.append("    AND CLI.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        }

        if(oidMarca != null){
        consulta.append("    AND MCC.MARC_OID_MARC = ? ");
        parametros.add(oidMarca);
        }

        if(oidCanal != null){
        consulta.append("    AND PER.CANA_OID_CANA = ? ");
        parametros.add(oidCanal);
        }

        consulta.append("        AND PRO.COD_PROC = ? ");
        parametros.add(ConstantesBEL.COD_CON001);

        consulta.append("        AND TBL.COD_TIPO_BLOQ NOT IN ( ? , ? ) ");
        parametros.add(ConstantesMAE.BLOQUEO_ADMINISTRATIVO);
        parametros.add(ConstantesMAE.BLOQUEO_FINANCIERO);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sFecha;
        java.sql.Date fecha = null;
        if(minEdadInicial != null){
        fecha = new java.sql.Date(System.currentTimeMillis());
        sFecha = sdf.format(fecha);

        consulta.append("    AND MCC.FEC_DOCU + ? < TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");
        parametros.add(minEdadInicial);
        parametros.add(sFecha);
        }

        if(fechaUltimoProceso != null){
        fecha = new java.sql.Date(fechaUltimoProceso.getTime());
        sFecha = sdf.format(fecha);

        consulta.append("    AND TST.FEC_ULTI_ACTU > TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");
        parametros.add(sFecha);
        consulta.append("    AND MCC.FEC_ULTI_ACTU > TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");
        parametros.add(sFecha);
        }*/
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerCarteras: Exception", e);
            this.logSql("  obtenerCarteras. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTODatosCartera cartera = null;

        if ((rs != null) && !rs.esVacio()) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                cartera = new DTODatosCartera();

                if (rs.getValueAt(i, "CLIENTE") != null) {
                    cartera.setCodCliente((String) rs.getValueAt(i, "CLIENTE"));
                }

                if (rs.getValueAt(i, "PERIODO") != null) {
                    cartera.setCodPeriodo((String) rs.getValueAt(i, "PERIODO") + "");
                }

                if (rs.getValueAt(i, "DOCUMENTO") != null) {
                    cartera.setNumeroDocumento(new Long(((BigDecimal) rs.getValueAt(i, "DOCUMENTO")).longValue()));
                }

                if (rs.getValueAt(i, "IMPORTE") != null) {
                    cartera.setImportePendiente((BigDecimal) rs.getValueAt(i, "IMPORTE"));
                }

                lista.add(cartera);
            }
        }

        UtilidadesLog.info("DAOINTIVR.obtenerCarteras(Long pais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimoProceso): Salida");

        return lista;
    }

    /**
         * Datos utlizados para poder realizar las pruebas del metodo obtenerConsultoras
         * pais = 1
         * oidMarca = 1
         * oidCanal =  1
         * fechaUltimoProceso = 2000-01-01
         * Para poder obtener resultados al probar el método he modificado un registro de la tabla MAE_CLIEN_TIPO_SUBTI
         * He modificado los campos siguientes
         * OID_CLIE_TIPO_SUBT, CLIE_OID_CLIE, TICL_OID_TIPO_CLIE
         *
         * Valores antiguos
         * OID_CLIE_TIPO_SUBT = 2
         * CLIE_OID_CLIE = 2
         * TICL_OID_TIPO_CLIE = 2
         *
         * Valores nuevos
         * OID_CLIE_TIPO_SUBT = 2
         * CLIE_OID_CLIE = 1
         * TICL_OID_TIPO_CLIE = 1
         *
         *
         * He añadido tambíen un registro a la tabla INT_ACCES_BUZON_IVRZN
         *
         * Valores nuevos
         * OID_ACCE_BUZO_IVRZ = 1
         * COD_ACCE_BUZO_IVRZ = 1
         * ZZON_OID_ZONA = 6
         *
         *
         * Se han producido cambios debido a las siguientes incidencias
         * BELC300016184 se debe realizar a través de la tabla MarcasSituacion de CCC
         * BELC300016187 el filtro debe aplicarse sobre las dos tablas MovimientosCuentaCorriente
         *
         */
    public ArrayList obtenerConsultoras(Long pais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimoProceso) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerConsultoras(Long pais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimoProceso): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        /*
        consulta.append(" SELECT DISTINCT ");
        consulta.append(" cl.OID_CLIE OID_CLIE, ");
        consulta.append(" cl.COD_CLIE CODIGO, ");
        consulta.append(" cl.VAL_NOM1 NOMBRE1, ");
        consulta.append(" cl.VAL_NOM2 NOMBRE2, ");
        consulta.append(" cl.VAL_APE1 APELLIDO1, ");
        consulta.append(" cl.VAL_APE2 APELLIDO2, ");
        consulta.append(" ab.COD_ACCE_BUZO_IVRZ CODIGO_BUZON, ");
        consulta.append(" se.COD_SECC CODIGO_SECC, ");
        consulta.append(" te.COD_TERR CODIGO_TERR, ");
        consulta.append(" mc1.OID_MOVI_CC OID_MOV_CC, ");

        //consulta.append(" MIN (mc2.FEC_DOCU) FECHA_DOCUMENTO ");
        consulta.append(" mc2.FEC_DOCU FECHA_DOCUMENTO ");

        consulta.append(" FROM ");
        consulta.append(" MAE_CLIEN cl, ");
        consulta.append(" MAE_CLIEN_TIPO_SUBTI ct, ");
        consulta.append(" MAE_CLIEN_UNIDA_ADMIN cu, ");
        consulta.append(" ZON_TERRI_ADMIN zta, ");
        consulta.append(" ZON_ZONA zo, ");
        consulta.append(" ZON_SECCI se, ");
        consulta.append(" ZON_TERRI te, ");
        consulta.append(" INT_ACCES_BUZON_IVRZN ab, ");
        consulta.append(" CCC_MARCA_TIPO_ABONO mt1, ");
        consulta.append(" CCC_MARCA_TIPO_ABONO mt2, ");
        consulta.append(" CCC_MARCA_SITUA ms1, ");
        consulta.append(" CCC_MARCA_SITUA ms2, ");
        consulta.append(" CCC_MOVIM_CUENT_CORRI mc1, ");
        consulta.append(" CCC_MOVIM_CUENT_CORRI mc2, ");
        consulta.append(" CCC_TIPO_ABONO_SUBPR ta1, ");
        consulta.append(" CCC_TIPO_ABONO_SUBPR ta2, ");
        consulta.append(" CCC_SUBPR sp1, ");
        consulta.append(" CCC_SUBPR sp2, ");
        consulta.append(" CCC_PROCE pr1, ");
        consulta.append(" CCC_PROCE pr2, ");
        consulta.append(" CRA_PERIO pe ");

        consulta.append(" WHERE ");
        consulta.append(" cl.OID_CLIE = ct.CLIE_OID_CLIE ");
        consulta.append(" AND cl.OID_CLIE = cu.CLIE_OID_CLIE ");
        consulta.append(" AND cu.ZTAD_OID_TERR_ADMI = zta.OID_TERR_ADMI ");
        consulta.append(" AND zta.TERR_OID_TERR = te.OID_TERR ");
        consulta.append(" AND zta.ZSCC_OID_SECC  = se.OID_SECC ");
        consulta.append(" AND se.ZZON_OID_ZONA  = zo.OID_ZONA ");
        consulta.append(" AND zo.OID_ZONA = ab.ZZON_OID_ZONA ");
        consulta.append(" AND cl.OID_CLIE = mc1.CLIE_OID_CLIE ");
        consulta.append(" AND mt1.MASI_OID_MARC_SALI = ms1.OID_MARC_SITU ");
        consulta.append(" AND ms1.OID_MARC_SITU  = mc1.MASI_OID_MARC_SITU ");
        consulta.append(" AND mt1.TASP_OID_TIPO_ABON_SUBP  = ta1.OID_TIPO_ABON_SUBP  ");
        consulta.append(" AND ta1.SUBP_OID_SUBP  = sp1.OID_SUBP  ");
        consulta.append(" AND sp1.CCPR_OID_PROC  = pr1.OID_PROC ");
        consulta.append(" AND cl.OID_CLIE = mc2.CLIE_OID_CLIE ");
        consulta.append(" AND mt2.MASI_OID_MARC_SALI = ms2.OID_MARC_SITU ");
        consulta.append(" AND ms2.OID_MARC_SITU  = mc2.MASI_OID_MARC_SITU ");
        consulta.append(" AND mc2.PERD_OID_PERI  = pe.OID_PERI ");
        consulta.append(" AND mt2.TASP_OID_TIPO_ABON_SUBP  = ta2.OID_TIPO_ABON_SUBP  ");
        consulta.append(" AND ta2.SUBP_OID_SUBP  = sp2.OID_SUBP ");
        consulta.append(" AND sp2.CCPR_OID_PROC  = pr2.OID_PROC ");
        consulta.append(" AND cl.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append(" AND ct.TICL_OID_TIPO_CLIE = ? ");
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
        consulta.append(" AND cu.IND_ACTI = 1 ");
        consulta.append(" AND sp1.COD_SUBP = 1 ");
        consulta.append(" AND pr1.COD_PROC = ? ");
        parametros.add(ConstantesBEL.COD_CON002);
        consulta.append(" AND sp2.COD_SUBP =1 ");
        consulta.append(" AND pr2.COD_PROC = ? ");
        parametros.add(ConstantesBEL.COD_CON001);

        if (oidMarca != null) {
            consulta.append(" AND mc2.MARC_OID_MARC = ? ");
            parametros.add(oidMarca);
        }

        if (oidCanal != null) {
            consulta.append(" AND pe.CANA_OID_CANA = ? ");
            parametros.add(oidCanal);
        }

        consulta.append(" AND mc2.IMP_PEND != 0 ");
        consulta.append(" and mc2.oid_movi_cc = ( select min(mov.oid_movi_cc)  ");
        consulta.append("            from CCC_MOVIM_CUENT_CORRI mov ");
        consulta.append("            where mov.clie_oid_clie = cl.oid_clie ");
        consulta.append("            and mov.fec_docu = (select min (b.fec_docu) ");
        consulta.append("                          from CCC_movim_CUENT_CORRI b ");
        consulta.append("                          where b.clie_oid_clie = cl.oid_clie) ");
        consulta.append("             ) ");

        consulta.append(" and mc1.oid_movi_cc = ( select min(mov.oid_movi_cc) ");
        consulta.append("             from CCC_MOVIM_CUENT_CORRI mov ");
        consulta.append("             where  mov.clie_oid_clie = cl.oid_clie ");
        consulta.append("             and mov.fec_docu = (select min (b.fec_docu) ");
        consulta.append("                          from CCC_movim_CUENT_CORRI b ");
        consulta.append("                          where b.clie_oid_clie = cl.oid_clie) ");
        consulta.append("             ) ");

        if (fechaUltimoProceso != null) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fechaDesde1 = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde1 = sdf1.format(fechaDesde1);
            consulta.append(" AND ((TO_DATE(TO_CHAR(cl.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFechaDesde1);

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fechaDesde2 = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde2 = sdf2.format(fechaDesde2);
            consulta.append(" OR (TO_DATE(TO_CHAR(ct.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFechaDesde2);

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fechaDesde3 = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde3 = sdf3.format(fechaDesde3);
            consulta.append(" OR (TO_DATE(TO_CHAR(cu.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFechaDesde3);

            SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fechaDesde4 = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde4 = sdf4.format(fechaDesde4);
            consulta.append(" OR (TO_DATE(TO_CHAR(mc1.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFechaDesde4);

            SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fechaDesde5 = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde5 = sdf5.format(fechaDesde5);
            consulta.append(" OR (TO_DATE(TO_CHAR(mc2.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS'))) ");
            parametros.add(sFechaDesde5);
        }

        //Añadido por incidencia BELC300018301
        consulta.append(" UNION  ");
        consulta.append(" SELECT DISTINCT  cl.OID_CLIE OID_CLIE, ");
        consulta.append("      cl.COD_CLIE CODIGO, ");
        consulta.append("      cl.VAL_NOM1 NOMBRE1, ");
        consulta.append("      cl.VAL_NOM2 NOMBRE2, ");
        consulta.append("      cl.VAL_APE1 APELLIDO1, ");
        consulta.append("      cl.VAL_APE2 APELLIDO2, ");
        consulta.append("      ab.COD_ACCE_BUZO_IVRZ CODIGO_BUZON, ");
        consulta.append("      se.COD_SECC CODIGO_SECC, ");
        consulta.append("      te.COD_TERR CODIGO_TERR, ");
        consulta.append("      null as OID_MOV_CC, ");
        consulta.append("      null as FECHA_DOCUMENTO ");
        consulta.append(" FROM  MAE_CLIEN cl, ");
        consulta.append("       MAE_CLIEN_TIPO_SUBTI ct, ");
        consulta.append("       MAE_CLIEN_UNIDA_ADMIN cu, ");
        consulta.append("       ZON_TERRI_ADMIN zta, ");
        consulta.append("       ZON_ZONA zo, ");
        consulta.append("       ZON_SECCI se, ");
        consulta.append("       ZON_TERRI te, ");
        consulta.append("       INT_ACCES_BUZON_IVRZN ab ");
        consulta.append(" WHERE  cl.OID_CLIE = ct.CLIE_OID_CLIE  AND ");
        consulta.append("        cl.OID_CLIE = cu.CLIE_OID_CLIE  AND ");
        consulta.append("        cl.oid_clie not in (select clie_oid_clie from CCC_MOVIM_CUENT_CORRI) and ");
        consulta.append("        cu.ZTAD_OID_TERR_ADMI = zta.OID_TERR_ADMI  AND ");
        consulta.append("        zta.TERR_OID_TERR = te.OID_TERR  AND ");
        consulta.append("        zta.ZSCC_OID_SECC  = se.OID_SECC  AND ");
        consulta.append("        se.ZZON_OID_ZONA  = zo.OID_ZONA  AND ");
        consulta.append("        zo.OID_ZONA = ab.ZZON_OID_ZONA  AND ");
        consulta.append("        cu.IND_ACTI = 1  AND ");
        consulta.append("        cl.PAIS_OID_PAIS = ?  AND "); //--05/05/11 09:46:39 parámetro 0: 1 
        parametros.add(pais);
        consulta.append("        ct.TICL_OID_TIPO_CLIE = ?  AND "); //--05/05/11 09:46:39 parámetro 1: 2
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);

        if (oidMarca != null) {
            consulta.append("        zta.MARC_OID_MARC = ? AND ");
            parametros.add(oidMarca);
        }

        if (oidCanal != null) {
            consulta.append("        zta.CANA_OID_CANA = ? ");
            parametros.add(oidCanal);
        }*/
        
        
        //MODIFICADO POR INCIDENCIA DE VALIDACION Y PERFORMANCE CZdasiuk y CNoziglia
        /**
         * se elimino lo anterio por inconsistencia con el decu ya modificado esto se hizo performance del mismo
         * 
         */
        
        
        consulta.append("         SELECT cl.oid_clie oid_clie, cl.cod_clie codigo, cl.val_nom1 nombre1, ");
        consulta.append("        cl.val_nom2 nombre2, cl.val_ape1 apellido1, cl.val_ape2 apellido2, ");
        consulta.append("        ab.cod_acce_buzo_ivrz codigo_buzon, se.cod_secc codigo_secc, ");
        consulta.append("        te.cod_terr codigo_terr, ");
        consulta.append("        pq_apl_rep.fn_cu_calc_saldo_cta_cte (cl.oid_clie, NULL, NULL,NULL ) IMPPEND, ");
        consulta.append("        fn_cu_calc_ind_incobrable (cl.pais_oid_pais, ? , ? , ");
        parametros.add(oidMarca);
        parametros.add(oidCanal);
        consulta.append("                                            cl.oid_clie ) ind_inco, ");
        consulta.append("        fn_fecha_documento (cl.pais_oid_pais, ? , ? , ");
        parametros.add(oidMarca);
        parametros.add(oidCanal);
        consulta.append("                                     cl.oid_clie  ) FECHA_DOCUMENTO ");
        consulta.append("   FROM mae_clien cl, ");
        consulta.append("        mae_clien_tipo_subti ct, ");
        consulta.append("        mae_clien_unida_admin cu, ");
        consulta.append("        zon_terri_admin zta, ");
        consulta.append("        zon_zona zo, ");
        consulta.append("        zon_secci se, ");
        consulta.append("        zon_terri te, ");
        consulta.append("        int_acces_buzon_ivrzn ab ");
        consulta.append("  WHERE cl.oid_clie = ct.clie_oid_clie ");
        consulta.append("    AND cl.oid_clie = cu.clie_oid_clie ");
        consulta.append("    AND cu.ztad_oid_terr_admi = zta.oid_terr_admi ");
        consulta.append("    AND zta.zscc_oid_secc = se.oid_secc ");
        consulta.append("    AND se.zzon_oid_zona = zo.oid_zona ");
        consulta.append("    AND ab.zzon_oid_zona(+) = zo.oid_zona  ");         //   -- acceso buzon IVR zonas
        consulta.append("    AND te.oid_terr = zta.terr_oid_terr ");
        consulta.append("    AND cl.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append("    AND ct.ticl_oid_tipo_clie = ? ");                  // 2-- tipo cliente consultora
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
        
        if (fechaUltimoProceso != null) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fechaDesde1 = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde1 = sdf1.format(fechaDesde1);
            consulta.append(" AND ((TO_DATE(TO_CHAR(cl.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFechaDesde1);

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fechaDesde2 = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde2 = sdf2.format(fechaDesde2);
            consulta.append(" OR (TO_DATE(TO_CHAR(ct.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFechaDesde2);

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fechaDesde3 = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde3 = sdf3.format(fechaDesde3);
            consulta.append(" OR (TO_DATE(TO_CHAR(cu.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS'))) ");
            parametros.add(sFechaDesde3);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerConsultoras: Exception", e);
            this.logSql(" obtenerConsultoras. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList resultado = new ArrayList();

        if (rs != null) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                DTODatosConsultoras dto = new DTODatosConsultoras();

                if (rs.getValueAt(i, "OID_CLIE") != null) {
                    dto.setOidCliente(new Long(((BigDecimal) rs.getValueAt(i, "OID_CLIE")).longValue()));
                }

                if (rs.getValueAt(i, "CODIGO") != null) {
                    dto.setCodCliente((String) rs.getValueAt(i, "CODIGO"));
                }

                if (rs.getValueAt(i, "NOMBRE1") != null) {
                    dto.setNombre1((String) rs.getValueAt(i, "NOMBRE1"));
                }

                if (rs.getValueAt(i, "NOMBRE2") != null) {
                    dto.setNombre2((String) rs.getValueAt(i, "NOMBRE2"));
                }

                if (rs.getValueAt(i, "APELLIDO1") != null) {
                    dto.setApellido1((String) rs.getValueAt(i, "APELLIDO1"));
                }

                if (rs.getValueAt(i, "APELLIDO2") != null) {
                    dto.setApellido2((String) rs.getValueAt(i, "APELLIDO2"));
                }

                if (rs.getValueAt(i, "CODIGO_SECC") != null) {
                    dto.setCodSeccion((String) rs.getValueAt(i, "CODIGO_SECC"));
                }

                if (rs.getValueAt(i, "CODIGO_BUZON") != null) {
                    dto.setCodBuzon((String) rs.getValueAt(i, "CODIGO_BUZON"));
                }

                if (rs.getValueAt(i, "CODIGO_TERR") != null) {
                    dto.setCodTerritorio((new Long(((BigDecimal) rs.getValueAt(i, "CODIGO_TERR")).longValue())).toString());
                }

                if (rs.getValueAt(i, "IND_INCO") != null) {
                    dto.setIndIncobrable(rs.getValueAt(i, "IND_INCO").toString());
                }

                if (rs.getValueAt(i, "FECHA_DOCUMENTO") != null) {
                    dto.setFechaDocumento(new java.util.Date(((java.sql.Date) rs.getValueAt(i, "FECHA_DOCUMENTO")).getTime()));
                }
                
                if (rs.getValueAt(i, "IMPPEND") != null) {
                    dto.setSaldo(((BigDecimal) rs.getValueAt(i, "IMPPEND")));
                }

                resultado.add(dto);
            }
        }

        UtilidadesLog.info("DAOINTIVR.obtenerConsultoras(Long pais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimoProceso): Salida");

        return resultado;
    }

    public ArrayList obtenerServiciosPostVenta(Long pais, Long oidMarca, Long oidCanal, Long oidPeriodoActual, Long oidPeriodoAnterior, Date fechaUltimoProceso) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerServiciosPostVenta(Long pais, Long oidMarca, Long oidCanal, Long oidPeriodoActual, Long oidPeriodoAnterior, Date fechaUltimoProceso): Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList lista = new ArrayList();
        RecordSet rs = new RecordSet();

        // INC 22105 - dmorello, 16/12/2005
        // Se modifica la siguiente query para poder recuperar el codigo de periodo
        // agregando al FROM la tabla SEG_PERIO_CORPO y al WHERE los joins necesarios
        sql.append(" SELECT cl.COD_CLIE CODIGOCLIENTE, ");
        sql.append(" op.COD_OPER CODIGOOPERACION, ");
        sql.append(" mp.COD_SAP CODIGOSAP, ");
        sql.append(" lo.IND_ATEN INDATENDIDO, ");
        sql.append(" ro.ESOP_OID_ESTA_OPER OIDESTADO, ");
        sql.append(" lo.IMP_ABON IMPORTEABONO, ");
        sql.append(" lo.IMP_CARG IMPORTECARGO, ");
        // INC 22105: Se cambia la siguiente línea por la que sigue a continuación de la misma:
        // sql.append(" pe2.VAL_NOMB_PERI CODIGOPERIODO, "); // Periodo B.codigo ??
        sql.append (" pc.COD_PERI CODIGOPERIODO, ");
        sql.append(" mr.COD_RECH_DESB CODIGORECHAZO, ");
        sql.append(" opi.COD_OPER_POST_VENT_IVR CODIGOPOSTVENTA, ");
        sql.append(" mp.DES_CORT DESCRIPCIONPRODUCTO, ");
        sql.append(" cr.NUM_RECL NUMERORECLAMO");

        sql.append(" FROM REC_LINEA_OPERA_RECLA lo, ");
        sql.append(" REC_OPERA_RECLA ro, ");
        sql.append(" REC_CABEC_RECLA cr, ");
        sql.append(" REC_TIPOS_OPERA rto, ");
        sql.append(" REC_OPERA op, ");
        sql.append(" CRA_PERIO pe1, ");
        sql.append(" MAE_CLIEN cl, ");
        sql.append(" MAE_CLIEN_TIPO_SUBTI ts, ");
        sql.append(" MAE_PRODU mp, ");
        sql.append(" CRA_PERIO pe2, ");
        sql.append(" REC_MOTIV_RECHA_DESBL mr, ");
        sql.append(" INT_RELAC_OPERA_RECLA ror, ");
        sql.append(" SEG_PERIO_CORPO pc, "); // INC 22105
        sql.append(" INT_OPERA_POSTV_IVR opi ");

        sql.append(" WHERE lo.OPRE_OID_OPER_RECL = ro.OID_OPER_RECL ");
        sql.append(" AND ro.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
        sql.append(" AND ro.TIOP_OID_TIPO_OPER = rto.OID_TIPO_OPER ");
        sql.append(" AND rto.ROPE_OID_OPER = op.OID_OPER ");
        sql.append(" AND cr.PERD_OID_PERI_RECL = pe1.OID_PERI ");
        sql.append(" AND ts.CLIE_OID_CLIE = cl.OID_CLIE ");
        sql.append(" AND cr.CLIE_OID_CLIE = cl.OID_CLIE ");
        sql.append(" AND lo.PROD_OID_PROD = mp.OID_PROD ");
        sql.append(" AND ro.PERD_OID_PERI_RECL = pe2.OID_PERI ");
        sql.append(" AND ro.MRDB_OID_MOTI_RECH_DESB = mr.OID_MOTI_RECH_DESB (+) ");
        sql.append(" AND ror.ROPE_OID_OPER = op.OID_OPER ");
        sql.append(" AND ror.OIVR_OID_OPER_POST_VENT_IVR = opi.OID_OPER_POST_VENT_IVR ");
        // INC 22105: join con período corporativo
        sql.append(" AND pe2.PERI_OID_PERI = pc.OID_PERI ");

        sql.append(" AND ts.TICL_OID_TIPO_CLIE = ? ");
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
        sql.append(" AND (lo.IND_ATEN IS NULL OR lo.IND_ATEN = 0 OR ");
        sql.append(" (lo.IND_ATEN = 1 AND (pe1.OID_PERI = ? OR pe1.OID_PERI = ?))) ");
        parametros.add(oidPeriodoActual);
        parametros.add(oidPeriodoAnterior);
        sql.append(" AND cr.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        sql.append(" AND pe1.MARC_OID_MARC = ? ");
        parametros.add(oidMarca);
        sql.append(" AND pe1.CANA_OID_CANA = ? ");
        parametros.add(oidCanal);
        sql.append(" AND opi.COD_OPER_POST_VENT_IVR IS NOT NULL ");

        if (fechaUltimoProceso != null) {
            String fecha = convierteFecha(fechaUltimoProceso);
            sql.append(" AND ((TO_DATE(TO_CHAR(ts.FEC_ULTI_ACTU,'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS')  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(fecha);
            sql.append(" OR (TO_DATE(TO_CHAR(cr.FEC_ULTI_ACTU,'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(fecha);
            sql.append(" OR (TO_DATE(TO_CHAR(ro.FEC_ULTI_ACTU,'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS'))) ");
            parametros.add(fecha);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerConsultoras: Exception", e);
            this.logSql(" obtenerConsultoras. SQL: ", sql.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && !rs.esVacio()) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                DTODatosServiciosPostVenta dto = new DTODatosServiciosPostVenta();

                if (rs.getValueAt(i, "CODIGOCLIENTE") != null) {
                    dto.setCodCliente(rs.getValueAt(i, "CODIGOCLIENTE").toString());
                }

                if (rs.getValueAt(i, "CODIGOOPERACION") != null) {
                    dto.setCodOperacion(rs.getValueAt(i, "CODIGOOPERACION").toString());
                }

                if (rs.getValueAt(i, "CODIGOSAP") != null) {
                    dto.setCodProducto(rs.getValueAt(i, "CODIGOSAP").toString());
                }

                if (rs.getValueAt(i, "INDATENDIDO") != null) {
                    dto.setIndAtendido(new Long(rs.getValueAt(i, "INDATENDIDO").toString()));
                }

                if (rs.getValueAt(i, "OIDESTADO") != null) {
                    dto.setEstadoOperacion(new Long(rs.getValueAt(i, "OIDESTADO").toString()));
                }

                if (rs.getValueAt(i, "IMPORTEABONO") != null) {
                    dto.setImporteAbono((BigDecimal) rs.getValueAt(i, "IMPORTEABONO"));
                }

                if (rs.getValueAt(i, "IMPORTECARGO") != null) {
                    dto.setImporteCargo((BigDecimal) rs.getValueAt(i, "IMPORTECARGO"));
                }

                if (rs.getValueAt(i, "CODIGOPERIODO") != null) {
                    dto.setCodPeriodo(rs.getValueAt(i, "CODIGOPERIODO").toString());
                }

                if (rs.getValueAt(i, "CODIGOPOSTVENTA") != null) {
                    dto.setCodIVR(rs.getValueAt(i, "CODIGOPOSTVENTA").toString());
                }

                if (rs.getValueAt(i, "CODIGORECHAZO") != null) {
                    dto.setCodMotivoRechazo(rs.getValueAt(i, "CODIGORECHAZO").toString());
                }

                if (rs.getValueAt(i, "DESCRIPCIONPRODUCTO") != null) {
                    dto.setDescripcionProducto(rs.getValueAt(i, "DESCRIPCIONPRODUCTO").toString());
                }

                if (rs.getValueAt(i, "NUMERORECLAMO") != null) {
                    dto.setNumeroReclamo(new Long(rs.getValueAt(i, "NUMERORECLAMO").toString()));
                }

                lista.add(dto);
            }
        }

        UtilidadesLog.info("DAOINTIVR.obtenerServiciosPostVenta(Long pais, Long oidMarca, Long oidCanal, Long oidPeriodoActual, Long oidPeriodoAnterior, Date fechaUltimoProceso): Salida");

        return lista;
    }

    private String convierteFecha(Date fecha) {
        UtilidadesLog.info("DAOINTIVR.convierteFecha(Date fecha): Entrada");
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
        UtilidadesLog.info("DAOINTIVR.convierteFecha(Date fecha): Salida");
        return sdf5.format(fechasql);
    }

    public ArrayList obtenerProductos(Long pais, Date fechaUltimoProceso) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerProductos(Long pais, Date fechaUltimoProceso): Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList lista = new ArrayList();

        sql.append(" SELECT COD_SAP CODIGOPRODUCTO, ");
        sql.append(" DES_CORT DESCRIPCIONPRODUCTO ");
        sql.append(" FROM MAE_PRODU ");
        sql.append(" WHERE PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        sql.append(" AND COD_IND_SITU = ? ");
        parametros.add(ConstantesMAE.PRODUCTO_ACTIVO);

        if (fechaUltimoProceso != null) {
            sql.append(" AND TO_DATE(TO_CHAR(FEC_ULTI_ACTU,'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ");
            parametros.add(convierteFecha(fechaUltimoProceso));
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        RecordSet rs = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerProductos: Exception", e);
            this.logSql(" obtenerProductos. SQL: ", sql.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && !rs.esVacio()) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                DTODatosProductos dto = new DTODatosProductos();

                if (rs.getValueAt(i, "CODIGOPRODUCTO") != null) {
                    dto.setCodigoProducto(rs.getValueAt(i, "CODIGOPRODUCTO").toString());
                }

                if (rs.getValueAt(i, "DESCRIPCIONPRODUCTO") != null) {
                    dto.setDescripcionProducto(rs.getValueAt(i, "DESCRIPCIONPRODUCTO").toString());
                }

                lista.add(dto);
            }
        }

        UtilidadesLog.info("DAOINTIVR.obtenerProductos(Long pais, Date fechaUltimoProceso): Salida");

        return lista;
    }

    //Pruebas Con Datos : pais = 1, fechaUltimoProceso = 01/01/2005
    public ArrayList obtenerConsultorasCuentaCastigada(Long pais, Date fechaUltimoProceso) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerConsultorasCuentaCastigada(Long pais, Date fechaUltimoProceso): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT DISTINCT CID.NUM_DOCU_IDEN NUMERODOCUMENTO,MST.IND_CUEN_CAST IDENTIFICADOR ");
        consulta.append(" FROM   MAE_CLIEN_TIPO_SUBTI CTS, CCC_MOVIM_CUENT_CORRI MCC,  ");
        consulta.append("        CCC_MARCA_SITUA MST, MAE_CLIEN CLI, MAE_CLIEN_IDENT CID  ");
        consulta.append(" WHERE  CLI.OID_CLIE = CTS.CLIE_OID_CLIE AND MST.OID_MARC_SITU = MCC.MASI_OID_MARC_SITU ");
        consulta.append("        AND CLI.OID_CLIE = MCC.CLIE_OID_CLIE AND CLI.OID_CLIE = CID.CLIE_OID_CLIE AND MST.IND_CUEN_CAST = 1 ");

        consulta.append("       AND CTS.TICL_OID_TIPO_CLIE = ? ");
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);

        if (pais != null) {
            consulta.append("   AND MST.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (fechaUltimoProceso != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fecha = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFecha = sdf.format(fecha);

            consulta.append("   AND ((CTS.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFecha);
            consulta.append("   OR (MCC.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')))  ");
            parametros.add(sFecha);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerConsultorasCuentaCastigada: Exception", e);
            this.logSql(" obtenerConsultorasCuentaCastigada. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTOString dto = null;

        if (rs != null) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                dto = new DTOString();

                if (rs.getValueAt(i, "NUMERODOCUMENTO") != null) {
                    dto.setCadena((String) rs.getValueAt(i, "NUMERODOCUMENTO"));
                }

                lista.add(dto);
            }
        }

        // Traza de salida
        UtilidadesLog.info("DAOINTIVR.obtenerConsultorasCuentaCastigada(Long pais, Date fechaUltimoProceso): Salida");

        return lista;
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) + ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
    }

    //Atenfdida incidencia BELC300016504
    public ArrayList obtenerClientesLineaCredito(Long pais, java.util.Date fechaUltimoProceso) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerClientesLineaCredito(Long pais, java.util.Date fechaUltimoProceso): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        //Añadido DISTINCT segun BELC300016504
        consulta.append(" select distinct "); //
        consulta.append(" MC.OID_CLIE OIDCLIENTE, "); //-- Cliente.oid
        consulta.append(" MC.COD_CLIE CODCLIENTE, "); //-- Cliente.codigo 
        consulta.append(" CNR.COD_NIVE_RIES NIVELRIESGO, "); //-- NivelRiesgo.COD_NIVE_RIES 
        consulta.append(" MCDA.IMP_MONT_LINE_CRED LINEACREDITO "); //-- ClienteDatosAdicionales.IMP_MONT_LINE_CRED 
        consulta.append(" from MAE_CLIEN MC, "); //--Cliente (MAE)
        consulta.append(" MAE_CLIEN_DATOS_ADICI MCDA, "); //");//--ClientesDatosAdicionales (MAE)
        consulta.append(" CCC_MOVIM_CUENT_CORRI CMCC, "); //--MovimientosCuentaCorriente (CCC)
        consulta.append(" CAR_NIVEL_RIESG CNR "); //--NivelRiesgo (CAR)
        consulta.append(" where "); //--JOINS
        consulta.append(" MC.OID_CLIE = MCDA.CLIE_OID_CLIE "); //-- Cliente con ClienteDatosAdicionales 
        consulta.append(" and MC.OID_CLIE = CMCC.CLIE_OID_CLIE "); //-- Cliente con MovimientosCuentaCorriente 
        consulta.append(" and MCDA.NIRI_OID_NIVE_RIES = CNR.OID_NIVE_RIES "); //-- ClienteDatosAdicionales con NivelRiesgo 

        if (pais != null) { //--FILTROS
            consulta.append(" and MC.PAIS_OID_PAIS = ? "); //1 -- Cliente.pais = pais RECIBIDO
            parametros.add(pais);
        }

        if (fechaUltimoProceso != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date sqlFechaUltimoProceso = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaUltimoProceso = sdf.format(sqlFechaUltimoProceso);
            consulta.append(" and ((MCDA.FEC_ULTI_ACTU > TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS')) "); //-- ( ClienteDatosAdicionales.fechaUltimaActualizacion > fechaUltimoProceso ) OR 
            parametros.add(sFechaUltimoProceso);
            consulta.append(" or (MC.FEC_ULTI_ACTU > TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'))) "); //--  ( MovimientosCuentaCorriente.fechaUltimaActualizacion > fechaUltimoProceso )
            parametros.add(sFechaUltimoProceso);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" nombreDAOnombreDelMetodo: Exception", e);
            this.logSql(" nombreDAOnombreDelMetodo. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList clientesLineaCredito = new ArrayList();

        if (rs != null /*&& !rs.esVacio()*/) {
            int numResultados = rs.getRowCount();

            for (int i = 0; i < numResultados; i++) {
                DTODatosLineaCredito dTODatosLineaCredito = new DTODatosLineaCredito();

                if (rs.getValueAt(i, "OIDCLIENTE") != null) {
                    dTODatosLineaCredito.setOidCliente(new Long(((BigDecimal) rs.getValueAt(i, "OIDCLIENTE")).longValue()));
                }

                if (rs.getValueAt(i, "CODCLIENTE") != null) {
                    dTODatosLineaCredito.setCodCliente((String) rs.getValueAt(i, "CODCLIENTE"));
                }

                if (rs.getValueAt(i, "NIVELRIESGO") != null) {
                    dTODatosLineaCredito.setNivelRiesgo((String) rs.getValueAt(i, "NIVELRIESGO"));
                }

                if (rs.getValueAt(i, "LINEACREDITO") != null) {
                    dTODatosLineaCredito.setLineaCredito((BigDecimal) rs.getValueAt(i, "LINEACREDITO"));
                }

                clientesLineaCredito.add(dTODatosLineaCredito);
            } //for
        } //if(rs!=null)

        UtilidadesLog.info("DAOINTIVR.obtenerClientesLineaCredito(Long pais, java.util.Date fechaUltimoProceso): Salida");

        return clientesLineaCredito;
    } //obtenerClientesLineaCredito

	/*
	 * rgiorgi - 27/8/2005: error en join
	 * */
    public ArrayList obtenerBasesIncumplidas(Long pais, Long oidPeriodoActual, Date fechaUltimoProceso) throws MareException {
        //Traza de entrada
        UtilidadesLog.info("DAOINTIVR.obtenerBasesIncumplidas(Long pais, Long oidPeriodoActual, Date fechaUltimoProceso): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        // Consulta SQL
        consulta.append(" SELECT distinct CLI.OID_CLIE OIDCLIENTE,CLI.COD_CLIE CODIGOCLIENTE, ");
        consulta.append("        CPG.NUM_CONC NUMEROCONCURSO, DES.CADE_OID_CAUS_DESC OIDCAUSADESCALIFICACION, ");
        consulta.append("        DES.PERD_OID_PERI OIDPERIODO");

        consulta.append(" FROM INC_CONCU_PARAM_GENER CPG, INC_CANDI_GANAD CGA, ");
        consulta.append("      INC_CUENT_CORRI_PUNTO CCP, INC_DESCA DES, ");
        consulta.append("      MAE_CLIEN CLI, CRA_PERIO PERA,CRA_PERIO PERB ");

        consulta.append(" WHERE CPG.OID_PARA_GRAL = CGA.COPA_OID_PARA_GRAL ");
        consulta.append("       AND CPG.OID_PARA_GRAL = CCP.COPA_OID_PARA_GRAL ");
        consulta.append("       AND DES.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        consulta.append("       AND DES.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append("       AND CPG.PERD_OID_PERI_HAST = PERB.OID_PERI ");
        consulta.append("       AND CPG.PERD_OID_PERI_DESD = PERA.OID_PERI ");

        if (pais != null) {
            consulta.append("   AND CPG.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (fechaUltimoProceso != null) {
            java.sql.Date fechaDesde = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde = sdf.format(fechaDesde);
            consulta.append("      AND (CGA.FEC_ULTI_ACTU > TO_DATE ( ? , 'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sFechaDesde);
        }

        consulta.append("       AND CPG.DIRI_OID_DIRI = ? ");
        parametros.add(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS);
        consulta.append("       AND CPG.COIV_OID_CONC_IVR IS NOT NULL ");
        consulta.append("       AND ((CGA.IND_META_SUPE = 0 ) OR ( CGA.VAL_REQU_PREM_SUPE = 0 )) ");

        if (oidPeriodoActual != null) {
            consulta.append("   AND PERB.OID_PERI = ? ");
            parametros.add(oidPeriodoActual);
        }

        consulta.append("       AND PERA.FEC_FINA <= PERB.FEC_INIC ");
        consulta.append("       AND ( SELECT COUNT(E.OID_PERI) ");
        consulta.append("             FROM CRA_PERIO C, ");
        consulta.append("                  CRA_PERIO D, ");
        consulta.append("                  CRA_PERIO E ");
        consulta.append("             WHERE C.OID_PERI = CPG.PERD_OID_PERI_HAST ");

        if (oidPeriodoActual != null) {
            consulta.append("               AND D.OID_PERI = ? ");
            parametros.add(oidPeriodoActual);
        }

        consulta.append("                   AND E.FEC_INIC >= C.FEC_INIC ");
        consulta.append("                   AND E.FEC_FINA >= C.FEC_INIC ");
        consulta.append("                   AND E.FEC_INIC <= D.FEC_INIC ");
        consulta.append("                   AND E.FEC_FINA <= D.FEC_INIC ");
        consulta.append("                   AND C.PAIS_OID_PAIS = D.PAIS_OID_PAIS ");
        consulta.append("                   AND D.PAIS_OID_PAIS = E.PAIS_OID_PAIS ");
        consulta.append("                   AND C.MARC_OID_MARC = D.MARC_OID_MARC ");
        consulta.append("                   AND D.MARC_OID_MARC = E.MARC_OID_MARC ");
        consulta.append("                   AND C.CANA_OID_CANA = D.CANA_OID_CANA ");
        consulta.append("                   AND D.CANA_OID_CANA = E.CANA_OID_CANA )<=5 ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            this.logSql(" obtenerBasesIncumplidas. SQL---: ", consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerBasesIncumplidas: Exception", e);
            this.logSql(" obtenerBasesIncumplidas. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();

        // Rellenamos el ArrayList con objetos 'DTODatosBasesIncumplidas'
        if (rs != null) {
            int x = rs.getRowCount();

            for (int i = 0; i < x; i++) {
                DTODatosBasesIncumplidas dto = new DTODatosBasesIncumplidas();

                if (rs.getValueAt(i, "OIDCLIENTE") != null) {
                    dto.setOidCliente(new Long(((BigDecimal) rs.getValueAt(i, "OIDCLIENTE")).longValue()));
                }

                if (rs.getValueAt(i, "CODIGOCLIENTE") != null) {
                    dto.setCodCliente(rs.getValueAt(i, "CODIGOCLIENTE").toString());
                }

                if (rs.getValueAt(i, "NUMEROCONCURSO") != null) {
                    dto.setNumConcurso(rs.getValueAt(i, "NUMEROCONCURSO").toString());
                }

                if (rs.getValueAt(i, "OIDCAUSADESCALIFICACION") != null) {
                    dto.setBaseIncumplida(new Long(((BigDecimal) rs.getValueAt(i, "OIDCAUSADESCALIFICACION")).longValue()));
                }

                if (rs.getValueAt(i, "OIDPERIODO") != null) {
                    dto.setOidPeriodo(new Long(((BigDecimal) rs.getValueAt(i, "OIDPERIODO")).longValue()));
                }

                lista.add(dto);
            }
        }

        // Traza de salida
        UtilidadesLog.info("DAOINTIVR.obtenerBasesIncumplidas(Long pais, Long oidPeriodoActual, Date fechaUltimoProceso): Salida");

        return lista;
    }

    public ArrayList obtenerPremios(Long pais, Long oidPeriodoActual) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerPremios(Long pais, Long oidPeriodoActual): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList lista = new ArrayList();

        //Inicio Consulta
        consulta.append(" SELECT ");
        consulta.append(" INC_CONCU_PARAM_GENER.NUM_CONC, ");
        consulta.append(" INC_PARAM_NIVEL_PREMI.NUM_NIVE, ");
        consulta.append(" MAE_PRODU.COD_SAP, ");
        consulta.append(" INC_ARTIC_LOTE.NUM_UNID  ");

        consulta.append(" FROM ");
        consulta.append(" INC_CONCU_PARAM_GENER, ");
        consulta.append(" INC_PARAM_GENER_PREMI, ");
        consulta.append(" INC_PARAM_NIVEL_PREMI, ");
        consulta.append(" INC_PREMI_ARTIC, ");
        consulta.append(" INC_CANDI_GANAD, ");
        consulta.append(" CRA_PERIO A, ");
        consulta.append(" CRA_PERIO B, ");
        consulta.append(" CRA_PERIO C, ");
        consulta.append(" INC_ARTIC_LOTE, ");
        consulta.append(" INC_LOTE_PREMI_ARTIC, ");
        consulta.append(" MAE_PRODU ");

        consulta.append(" WHERE ");

        consulta.append(" INC_CONCU_PARAM_GENER.COIV_OID_CONC_IVR is not null  ");

        if (pais != null) {
            consulta.append(" AND INC_CONCU_PARAM_GENER.PAIS_OID_PAIS = ?  ");
            parametros.add(pais);
        }

        consulta.append(" AND ( (INC_CANDI_GANAD.IND_META_SUPE= 0 ) OR ( INC_CANDI_GANAD.VAL_REQU_PREM_SUPE = 0 ) ) ");

        if (oidPeriodoActual != null) {
            consulta.append(" AND B.OID_PERI = ? ");
            parametros.add(oidPeriodoActual);
        }

        consulta.append(" AND C.FEC_FINA <= B.FEC_INIC  ");
        consulta.append(" AND A.FEC_FINA <= B.FEC_INIC  ");

        consulta.append(" AND ( SELECT COUNT(E.OID_PERI)  ");
        consulta.append(" FROM ");
        consulta.append(" CRA_PERIO PDESDE, ");
        consulta.append(" CRA_PERIO PHASTA, ");
        consulta.append(" CRA_PERIO E  ");
        consulta.append(" WHERE  ");
        consulta.append(" C.OID_PERI = INC_CONCU_PARAM_GENER.PERD_OID_PERI_HAST ");

        if (oidPeriodoActual != null) {
            consulta.append(" AND PHASTA.OID_PERI = ? "); //oidPeriodoActual                                          
            parametros.add(oidPeriodoActual);
        }

        consulta.append(" AND E.FEC_INIC >= PDESDE.FEC_INIC  ");
        consulta.append(" AND E.FEC_FINA >= PDESDE.FEC_INIC  ");
        consulta.append(" AND E.FEC_INIC <= PHASTA.FEC_INIC  ");
        consulta.append(" AND E.FEC_FINA <= PHASTA.FEC_INIC  ");
        consulta.append(" AND PDESDE.PAIS_OID_PAIS = PHASTA.PAIS_OID_PAIS  ");
        consulta.append(" AND PHASTA.PAIS_OID_PAIS = E.PAIS_OID_PAIS  ");
        consulta.append(" AND PDESDE.MARC_OID_MARC = PHASTA.MARC_OID_MARC  ");
        consulta.append(" AND PHASTA.MARC_OID_MARC = E.MARC_OID_MARC  ");
        consulta.append(" AND PDESDE.CANA_OID_CANA = PHASTA.CANA_OID_CANA  ");
        consulta.append(" AND PHASTA.CANA_OID_CANA = E.CANA_OID_CANA  ");
        consulta.append(" )<=5 ");

        consulta.append(" AND INC_CONCU_PARAM_GENER.OID_PARA_GRAL = INC_PARAM_GENER_PREMI.COPA_OID_PARA_GRAL ");
        consulta.append(" AND INC_CONCU_PARAM_GENER.PERD_OID_PERI_HAST=A.OID_PERI ");
        consulta.append(" AND INC_PARAM_GENER_PREMI.PERD_OID_PERI =C.OID_PERI ");
        consulta.append(" AND INC_PARAM_GENER_PREMI.OID_PARA_GENE_PREM= INC_PARAM_NIVEL_PREMI.PAGP_OID_PARA_GENE_PREM ");
        consulta.append(" AND INC_PARAM_NIVEL_PREMI.OID_PARA_NIVE_PREM = INC_PREMI_ARTIC.PANP_OID_PARA_NIVE_PREM ");
        consulta.append(" AND INC_PREMI_ARTIC.OID_PREM_ARTI = INC_LOTE_PREMI_ARTIC.PRAR_OID_PREM_ARTI ");
        consulta.append(" AND INC_LOTE_PREMI_ARTIC.OID_LOTE_PREM_ARTI=INC_ARTIC_LOTE.LOPA_OID_LOTE_PREM_ARTI  ");
        consulta.append(" AND INC_ARTIC_LOTE.PROD_OID_PROD =  MAE_PRODU.OID_PROD ");

        //Fin Consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        RecordSet rs = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString().toUpperCase(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerPremios: Exception", e);
            this.logSql(" obtenerPremios. SQL: ", consulta.toString().toUpperCase(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && !rs.esVacio()) {
            int numResultados = rs.getRowCount();

            for (int i = 0; i < numResultados; i++) {
                DTODatosPremios dto = new DTODatosPremios();

                if (rs.getValueAt(i, "NUM_CONC") != null) {
                    dto.setNumeroConcurso(rs.getValueAt(i, "NUM_CONC").toString());
                }

                if (rs.getValueAt(i, "NUM_NIVE") != null) {
                    dto.setNumeroNivel(new Long(((BigDecimal) rs.getValueAt(i, "NUM_NIVE")).longValue()));
                }

                if (rs.getValueAt(i, "COD_SAP") != null) {
                    dto.setCodProducto((String) rs.getValueAt(i, "COD_SAP"));
                }

                if (rs.getValueAt(i, "NUM_UNID") != null) {
                    dto.setNumUnidades(new Long(((BigDecimal) rs.getValueAt(i, "NUM_UNID")).longValue()));
                }

                lista.add(dto);
            }
        }

        UtilidadesLog.info("DAOINTIVR.obtenerPremios(Long pais, Long oidPeriodoActual): Salida");

        return lista;
    }


	/*
	 * rgiorgi - 27/8/2005: se corrige la query por falta de joins. 
	 * 						se modifica el campo codigo concurso por desc.
	 * */
    public ArrayList obtenerConcursos(Long pais, Long oidPeriodoActual, Date fechaUltimoProceso) throws MareException {
        //Traza de entrada
        UtilidadesLog.info("DAOINTIVR.obtenerConcursos(Long pais, Long oidPeriodoActual, Date fechaUltimoProceso): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT ");
        consulta.append("     CLI.COD_CLIE CODIGOCLIENTE, ");
        consulta.append("     CPG.PERD_OID_PERI_HAST OIDPERIODOHASTA, ");
        consulta.append("     CPG.NUM_CONC NUMEROCONCURSO, ");
        consulta.append("     (SELECT val_i18n FROM gen_i18n_sicc ");
        consulta.append("     WHERE val_oid = ci.OID_CONC_IVR ");
        consulta.append("     AND attr_enti = 'INC_CONCU_IVR' ");
        consulta.append("     AND ATTR_NUM_ATRI = 1 ) TIPOCONCURSO, ");
        consulta.append("     SUM ( CCP.NUM_PUNT ) PUNTUAJEACUMULADO, ");
        consulta.append("     PGP.NUM_PERI NUMEROPERIODOS, ");
        consulta.append("     PGP.PERD_OID_PERI OIDPERIODODESPACHO");
        consulta.append(" FROM ");
        consulta.append("      INC_CONCU_PARAM_GENER CPG, ");
        consulta.append("      INC_CANDI_GANAD CG, ");
        consulta.append("      INC_CUENT_CORRI_PUNTO CCP, ");
        consulta.append("      MAE_CLIEN CLI, ");
        consulta.append("      INC_PARAM_GENER_PREMI PGP, ");
        consulta.append("      CRA_PERIO  A, ");
        consulta.append("      CRA_PERIO  B, ");
        consulta.append("      INC_CONCU_IVR CI ");
        consulta.append(" WHERE ");
        consulta.append("      CPG.OID_PARA_GRAL = CG.COPA_OID_PARA_GRAL AND ");
        consulta.append("      CPG.OID_PARA_GRAL = CCP.COPA_OID_PARA_GRAL AND ");
        consulta.append("      CCP.CLIE_OID_CLIE = CLI.OID_CLIE AND ");
        consulta.append("      CPG.OID_PARA_GRAL = PGP.COPA_OID_PARA_GRAL AND ");
        consulta.append("      CPG.PERD_OID_PERI_HAST = B.OID_PERI AND ");
		consulta.append("      CPG.PERD_OID_PERI_DESD = A.OID_PERI AND ");
        consulta.append("      CPG.COIV_OID_CONC_IVR = CI.OID_CONC_IVR ");

        if (pais != null) {
            consulta.append("      AND CPG.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (fechaUltimoProceso != null) {
            java.sql.Date fechaDesde = new java.sql.Date(fechaUltimoProceso.getTime());
            String sFechaDesde = sdf.format(fechaDesde);
            consulta.append("      AND ((CG.FEC_ULTI_ACTU > TO_DATE ( ? , 'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sFechaDesde);
            consulta.append("      OR (CCP.FEC_ULTI_ACTU > TO_DATE ( ? , 'YYYY-MM-DD HH24:MI:SS') )) ");
            parametros.add(sFechaDesde);
        }

        consulta.append("      AND CPG.DIRI_OID_DIRI = ? ");
        parametros.add(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS);
        consulta.append("      AND CPG.COIV_OID_CONC_IVR IS NOT NULL ");
        consulta.append("      AND (( CG.IND_META_SUPE= 0 ) OR ( CG.VAL_REQU_PREM_SUPE = 0 )) ");

        if (oidPeriodoActual != null) {
            consulta.append("      AND B.OID_PERI = ? ");
            parametros.add(oidPeriodoActual);
        }

        consulta.append("      AND A.FEC_FINA <= B.FEC_INIC ");
        consulta.append("      AND ( SELECT COUNT(E.OID_PERI) ");
        consulta.append("        FROM ");
        consulta.append("             CRA_PERIO C, ");
        consulta.append("             CRA_PERIO D, ");
        consulta.append("             CRA_PERIO E ");
        consulta.append("             WHERE ");
        consulta.append("                   C.OID_PERI = CPG.PERD_OID_PERI_HAST ");

        if (oidPeriodoActual != null) {
            consulta.append("                   AND D.OID_PERI = ? ");
            parametros.add(oidPeriodoActual);
        }

        consulta.append("                   AND E.FEC_INIC >= C.FEC_INIC ");
        consulta.append("                   AND E.FEC_FINA >= C.FEC_INIC ");
        consulta.append("                   AND E.FEC_INIC <= D.FEC_INIC ");
        consulta.append("                   AND E.FEC_FINA <= D.FEC_INIC ");
        consulta.append("                   AND C.PAIS_OID_PAIS = D.PAIS_OID_PAIS ");
        consulta.append("                   AND D.PAIS_OID_PAIS = E.PAIS_OID_PAIS ");
        consulta.append("                   AND C.MARC_OID_MARC = D.MARC_OID_MARC ");
        consulta.append("                   AND D.MARC_OID_MARC = E.MARC_OID_MARC ");
        consulta.append("                   AND C.CANA_OID_CANA = D.CANA_OID_CANA ");
        consulta.append("                   AND D.CANA_OID_CANA = E.CANA_OID_CANA ");
        consulta.append("                   )<=5 ");
        consulta.append(" GROUP BY ");
        consulta.append("       CLI.COD_CLIE, ");
        consulta.append("       CPG.PERD_OID_PERI_HAST, ");
        consulta.append("       CPG.NUM_CONC, ");
        consulta.append("       CI.OID_CONC_IVR, ");
        consulta.append("       PGP.NUM_PERI, ");
        consulta.append("       PGP.PERD_OID_PERI ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerConcursos: Exception", e);
            this.logSql(" obtenerConcursos. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();

        // Rellenamos el ArrayList con objetos 'DTODatosConcursos'
        if (rs != null) {
            int x = rs.getRowCount();

            for (int i = 0; i < x; i++) {
                DTODatosConcursos dto = new DTODatosConcursos();

                if (rs.getValueAt(i, "CODIGOCLIENTE") != null) {
                    dto.setCodCliente(rs.getValueAt(i, "CODIGOCLIENTE").toString());
                }

                if (rs.getValueAt(i, "NUMEROCONCURSO") != null) {
                    dto.setNumeroConcurso(rs.getValueAt(i, "NUMEROCONCURSO").toString());
                }

                if (rs.getValueAt(i, "NUMEROPERIODOS") != null) {
                    dto.setNumPeriodos(new Integer(((BigDecimal) rs.getValueAt(i, "NUMEROPERIODOS")).intValue()));
                }

                if (rs.getValueAt(i, "OIDPERIODODESPACHO") != null) {
                    dto.setOidPeriodoDespacho(new Long(((BigDecimal) rs.getValueAt(i, "OIDPERIODODESPACHO")).longValue()));
                }

                if (rs.getValueAt(i, "OIDPERIODOHASTA") != null) {
                    dto.setOidPeriodoHasta(new Long(((BigDecimal) rs.getValueAt(i, "OIDPERIODOHASTA")).longValue()));
                }

                if (rs.getValueAt(i, "PUNTUAJEACUMULADO") != null) {
                    dto.setPuntajeAcumulado(new Long(((BigDecimal) rs.getValueAt(i, "PUNTUAJEACUMULADO")).longValue()));
                }

                if (rs.getValueAt(i, "TIPOCONCURSO") != null) {
                    dto.setTipoConcurso(rs.getValueAt(i, "TIPOCONCURSO").toString());
                }

                lista.add(dto);
            }
        }

        // Traza de salida
        UtilidadesLog.info("DAOINTIVR.obtenerConcursos(Long pais, Long oidPeriodoActual, Date fechaUltimoProceso): Salida");

        return lista;
    }

    /**
         * Datos utlizados para poder realizar las pruebas del metodo obtenerNiveles
         * pais = 1
         * Con oidPeriodoActual con valor 57 y 58 y con fechaUltimoProceso = 01/05/2005
         * se obtienen resultados.
         *
         *
         * Se han producido cambios debido a las siguientes incidencias
         * Incidencia BELC300017290
         * Incidencia BELC300017297
         *
         *
         */
    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param fechaUltimoProceso
    * @param oidPeriodoActual
    * @param pais
    */
    public ArrayList obtenerNiveles(Long pais, Long oidPeriodoActual, Date fechaUltimoProceso) throws MareException {
        UtilidadesLog.info("DAOINTIVR.obtenerNiveles(Long pais, Long oidPeriodoActual, Date fechaUltimoProceso): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        // Modificado por incidencia BELC300017290
        consulta.append(" SELECT ");
        consulta.append(" 	cpg.PERD_OID_PERI_HAST OID_PERIODO_HASTA, ");
        consulta.append(" 	cpg.NUM_CONC NUMERO_CONCURSO, ");
        consulta.append(" 	pnp.NUM_NIVE NUMERO_NIVEL, ");
        consulta.append(" 	pnp.NUM_CANT_INIC_PUNT CANTIDAD_INICIAL_PUNTOS, ");
        consulta.append(" 	pnp.NUM_CANT_FIJA_PUNT CANTIDAD_FIJA_PUNTOS, ");
        consulta.append(" 	pgp.NUM_PERI NUM_PERI, ");
        consulta.append(" 	pgp.PERD_OID_PERI  OID_PERIODO ");
        consulta.append(" FROM ");
        consulta.append(" 	INC_CONCU_PARAM_GENER cpg, ");
        consulta.append(" 	INC_PARAM_NIVEL_PREMI pnp, ");
        consulta.append(" 	INC_PARAM_GENER_PREMI  pgp, ");
        consulta.append(" 	CRA_PERIO pe1, ");
        consulta.append(" 	CRA_PERIO pe2 ");
        consulta.append(" WHERE ");
        consulta.append(" 	cpg.OID_PARA_GRAL  = pgp.COPA_OID_PARA_GRAL AND ");
        consulta.append(" 	pgp.OID_PARA_GENE_PREM  = pnp.PAGP_OID_PARA_GENE_PREM AND ");
        consulta.append(" 	cpg.PERD_OID_PERI_HAST = pe1.OID_PERI AND ");
        consulta.append(" 	cpg.PAIS_OID_PAIS  = ? AND ");
        parametros.add(pais);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.sql.Date fechaDesde = null;
        String sFechaDesde = null;

        if (fechaUltimoProceso != null) {
            fechaDesde = new java.sql.Date(fechaUltimoProceso.getTime());
            sFechaDesde = sdf.format(fechaDesde);
            consulta.append(" ((TO_DATE(TO_CHAR(pgp.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS')) OR ");
            parametros.add(sFechaDesde);

            consulta.append(" (TO_DATE(TO_CHAR(pnp.FEC_ULTI_ACTU, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS'))) AND ");
            parametros.add(sFechaDesde);
        }

        consulta.append(" 	cpg.COIV_OID_CONC_IVR IS NOT NULL AND ");

        if (oidPeriodoActual != null) {
            consulta.append(" 	pe2.OID_PERI = ? AND ");
            parametros.add(oidPeriodoActual);
        }

        consulta.append(" 	pe1.FEC_FINA  <= pe2.FEC_INIC AND ");
        consulta.append(" 	(SELECT ");
        consulta.append(" 		COUNT(e.OID_PERI) ");
        consulta.append(" 	FROM ");
        consulta.append(" 		CRA_PERIO c, ");
        consulta.append(" 		CRA_PERIO d, ");
        consulta.append(" 		CRA_PERIO e, ");
        consulta.append(" 		INC_CONCU_PARAM_GENER cpg ");
        consulta.append(" 	WHERE ");
        consulta.append(" 		c.OID_PERI = cpg.PERD_OID_PERI_HAST AND ");

        if (oidPeriodoActual != null) {
            consulta.append(" 		d.OID_PERI = ? AND ");
            parametros.add(oidPeriodoActual);
        }

        consulta.append(" 		e.FEC_INIC >= c.FEC_INIC AND ");
        consulta.append(" 		e.FEC_FINA >= c.FEC_INIC AND ");
        consulta.append(" 		e.FEC_INIC <= d.FEC_INIC AND ");
        consulta.append(" 		e.FEC_FINA <= d.FEC_INIC AND ");
        consulta.append(" 		c.PAIS_OID_PAIS = d.PAIS_OID_PAIS AND ");
        consulta.append(" 		d.PAIS_OID_PAIS = e.PAIS_OID_PAIS AND ");
        consulta.append(" 		c.MARC_OID_MARC = d.MARC_OID_MARC AND ");
        consulta.append(" 		d.MARC_OID_MARC = e.MARC_OID_MARC AND ");
        consulta.append(" 		c.CANA_OID_CANA = d.CANA_OID_CANA AND ");
        consulta.append(" 		d.CANA_OID_CANA = e.CANA_OID_CANA ");
        consulta.append(" 	)<=5 ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerNiveles: Exception", e);
            this.logSql(" obtenerNiveles. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList resultado = new ArrayList();

        if (rs != null) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                DTODatosNiveles dto = new DTODatosNiveles();

                if (rs.getValueAt(i, "OID_PERIODO_HASTA") != null) {
                    dto.setOidPeriodoHasta(new Long(((BigDecimal) rs.getValueAt(i, "OID_PERIODO_HASTA")).longValue()));
                }

                if (rs.getValueAt(i, "NUMERO_CONCURSO") != null) {
                    dto.setNumeroConcurso((String) rs.getValueAt(i, "NUMERO_CONCURSO"));
                }

                if (rs.getValueAt(i, "NUMERO_NIVEL") != null) {
                    dto.setNumeroNivel(new Long(((BigDecimal) rs.getValueAt(i, "NUMERO_NIVEL")).longValue()));
                }

                if (rs.getValueAt(i, "CANTIDAD_INICIAL_PUNTOS") != null) {
                    dto.setCantidadInicialPuntos(new Long(((BigDecimal) rs.getValueAt(i, "CANTIDAD_INICIAL_PUNTOS")).longValue()));
                }

                if (rs.getValueAt(i, "CANTIDAD_FIJA_PUNTOS") != null) {
                    dto.setCantidadFijaPuntos(new Long(((BigDecimal) rs.getValueAt(i, "CANTIDAD_FIJA_PUNTOS")).longValue()));
                }

                if (rs.getValueAt(i, "NUM_PERI") != null) {
                    dto.setNumPeriodos(new Integer(((BigDecimal) rs.getValueAt(i, "NUM_PERI")).intValue()));
                }

                if (rs.getValueAt(i, "OID_PERIODO") != null) {
                    dto.setOidPeriodoDespacho(new Long(((BigDecimal) rs.getValueAt(i, "OID_PERIODO")).longValue()));
                }

                resultado.add(dto);
            }
        }

        UtilidadesLog.info("DAOINTIVR.obtenerNiveles(Long pais, Long oidPeriodoActual, Date fechaUltimoProceso): Salida");

        return resultado;
    }
}
