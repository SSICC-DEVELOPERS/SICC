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
 */
 
package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.batch.Proceso;
import es.indra.sicc.dtos.ped.DTOAlarmaPedidos;
import es.indra.sicc.dtos.ped.DTOAlarmas;
import es.indra.sicc.dtos.ped.DTOBuscarDatosMonitor;
import es.indra.sicc.dtos.ped.DTOEGrupoReversion;
import es.indra.sicc.dtos.ped.DTOInfoMonitor;
import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class DAOMonitor  {
  private static UtilidadesLog logAux = new UtilidadesLog();
  public DAOMonitor() {
  }


  /**
  //Este método carga la lista del monitor de procesos. 
  //Para ello en cada fila indica para cada tipo solicitud, region y zona, el número de solicitudes que están en cada uno de los GP. 
  //Si se ha especificado una plantilla, se intercala entre el número de solicitud de cada GP el número de secuencia. 
  //Además, por cada tipo de solicitud se hace un subtotal de número de solicitudes de cada proceso. 
  **/
  public RecordSet obtenerDatos(DTOBuscarDatosMonitor criterios) throws MareException {
        UtilidadesLog.info("DAOMonitor.obtenerDatos(DTOBuscarDatosMonitor criterios): Entrada ");
        String query;
        
        if (criterios.getFechaFin() == null) { 
            criterios.setFechaFin(new java.util.Date()); 
        } 

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dia = new java.sql.Date(criterios.getFechaInicio().getTime());
        String sDiaIni = sdf.format(dia);
        dia = new java.sql.Date(criterios.getFechaFin().getTime());
        String sDiaFin = sdf.format(dia);
        UtilidadesLog.debug("El dia actual a pasar es, Ini: " + sDiaIni + "   Fin: "+sDiaFin);

        /** VER Incidencia 7718 **/
        //Los numeros despues de los parentesis es para controlar apertura y cierre
        query = " SELECT ITipoSoli.val_i18n DESCRIPCION, --m.TSPA_OID_TIPO_SOLI_PAIS,(Descripcion) \n";
        query += " 	   r.COD_REGI, z.COD_ZONA, GP1, GP1SEC, GP2, GP2SEC, GP3, GP3SEC,  \n";
        query += " 	   GP4, GP4SEC, GP5, GP5SEC, m.TSPA_OID_TIPO_SOLI_PAIS, m.ZORG_OID_REGI, m.ZZON_OID_ZONA  \n";
        query += " FROM  \n";
        query += " ( --1  \n";
        query += " ( --2  \n";
        query += " --Esta consulta nos da la lista de por tipo de solicitud, region y zona con el sumatorio del número de solicitudes por GP  \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA,  \n";
        query += " SUM(GP1) GP1,SUM(GP2) GP2, SUM(GP3) GP3, SUM(GP4) GP4, SUM(GP5) GP5  \n";
        query += " FROM  \n";
        query += " ( --3  \n";
        query += " ( --4  \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, COUNT(OID_SOLI_CABE) GP1, 0 GP2, 0 GP3, 0 GP4, 0 GP5  \n";
        query += " FROM PED_SOLIC_CABEC, ZON_ZONA Z1  \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND  Z1.OID_ZONA = ZZON_OID_ZONA   \n";
        query += " AND PED_SOLIC_CABEC.PAIS_OID_PAIS = " + criterios.getOidPais();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = "+ConstantesPED.GP1 ;
        query += " ) --/4  \n";
        query += " UNION ( --5   \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, 0 GP1, COUNT(OID_SOLI_CABE) GP2, 0 GP3, 0 GP4, 0 GP5  \n";
        query += " FROM PED_SOLIC_CABEC, ZON_ZONA Z1 \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND  Z1.OID_ZONA = ZZON_OID_ZONA   \n";
        query += " AND PED_SOLIC_CABEC.PAIS_OID_PAIS = " + criterios.getOidPais().longValue();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = "+ConstantesPED.GP2 ;
        query += " ) --/5  \n";
        query += " UNION (  --6   \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, 0 GP1, 0 GP2, COUNT(OID_SOLI_CABE) GP3, 0 GP4, 0 GP5  \n";
        query += " FROM PED_SOLIC_CABEC, ZON_ZONA Z1 \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND  Z1.OID_ZONA = ZZON_OID_ZONA   \n";
        query += " AND PED_SOLIC_CABEC.PAIS_OID_PAIS = " + criterios.getOidPais().longValue();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = "+ConstantesPED.GP3 ;
        query += " ) --/6   \n";
        query += " UNION ( --7  \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, 0 GP1, 0 GP2, 0 GP3, COUNT(OID_SOLI_CABE) GP4, 0 GP5  \n";
        query += " FROM PED_SOLIC_CABEC, ZON_ZONA Z1 \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND  Z1.OID_ZONA = ZZON_OID_ZONA   \n";
        query += " AND PED_SOLIC_CABEC.PAIS_OID_PAIS = " + criterios.getOidPais().longValue();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = "+ConstantesPED.GP4 ;
        query += " ) --/7  \n";
        query += " UNION ( --8   \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, 0 GP1, 0 GP2, 0 GP3, 0 GP4, COUNT(OID_SOLI_CABE) GP5  \n";
        query += " FROM PED_SOLIC_CABEC, ZON_ZONA Z1 \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND  Z1.OID_ZONA = ZZON_OID_ZONA   \n";
        query += " AND PED_SOLIC_CABEC.PAIS_OID_PAIS = " + criterios.getOidPais().longValue();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = "+ConstantesPED.GP5 ;
        query += " ) --/8  \n";
        query += " ) --/3  \n";
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA  \n";
        query += " ) --/2    \n";
        query += " UNION  \n";
        query += " ( --12  (Inicio en 12 para comparar)  \n";
        query += " --Esta consulta nos da las líneas de subtotal por tipo de solicitud  \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA,  \n";
        query += " SUM(GP1) GP1,SUM(GP2) GP2, SUM(GP3) GP3, SUM(GP4) GP4, SUM(GP5) GP5  \n";
        query += " FROM  \n";
        query += " ( --13  \n";
        query += " ( --14  \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, 0 ZORG_OID_REGI, 0 ZZON_OID_ZONA, COUNT(OID_SOLI_CABE) GP1, 0 GP2, 0 GP3, 0 GP4, 0 GP5  \n";
        query += " FROM PED_SOLIC_CABEC  \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND PAIS_OID_PAIS = " + criterios.getOidPais().longValue();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = "+ ConstantesPED.GP1 ;
        query += " ) --/14  \n";
        query += " UNION ( --15  \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, 0 ZORG_OID_REGI, 0 ZZON_OID_ZONA, 0 GP1, COUNT(OID_SOLI_CABE) GP2, 0 GP3, 0 GP4, 0 GP5  \n";
        query += " FROM PED_SOLIC_CABEC  \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND PAIS_OID_PAIS = " + criterios.getOidPais().longValue();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = " + ConstantesPED.GP2 ;
        query += " ) --/15  \n";
        query += " UNION ( --16  \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, 0 ZORG_OID_REGI, 0 ZZON_OID_ZONA, 0 GP1, 0 GP2, COUNT(OID_SOLI_CABE) GP3, 0 GP4, 0 GP5  \n";
        query += " FROM PED_SOLIC_CABEC  \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND PAIS_OID_PAIS = " + criterios.getOidPais().longValue();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = " + ConstantesPED.GP3 ;
        query += " ) --/16  \n";
        query += " UNION ( --17  \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, 0 ZORG_OID_REGI, 0 ZZON_OID_ZONA, 0 GP1, 0 GP2, 0 GP3, COUNT(OID_SOLI_CABE) GP4, 0 GP5  \n";
        query += " FROM PED_SOLIC_CABEC  \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND PAIS_OID_PAIS = " + criterios.getOidPais().longValue();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = " + ConstantesPED.GP4 ;
        query += " ) --/17  \n";
        query += " UNION ( --18  \n";
        query += " SELECT TSPA_OID_TIPO_SOLI_PAIS, 0 ZORG_OID_REGI, 0 ZZON_OID_ZONA, 0 GP1, 0 GP2, 0 GP3, 0 GP4, COUNT(OID_SOLI_CABE) GP5  \n";
        query += " FROM PED_SOLIC_CABEC  \n";
        query += " WHERE FEC_PROG_FACT >= TO_DATE('" + sDiaIni +"','YYYY-MM-DD') AND FEC_PROG_FACT <= TO_DATE('" + sDiaFin +"','YYYY-MM-DD') \n";
        query += " AND PAIS_OID_PAIS = " + criterios.getOidPais().longValue();
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, GRPR_OID_GRUP_PROC  \n";
        query += " HAVING GRPR_OID_GRUP_PROC = " + ConstantesPED.GP5 ;
        query += " ) --/18  \n";
        query += " ) --/13  \n";
        query += " GROUP BY TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA  \n";
        query += " ) --/12  \n";
        query += " ) m  \n";
        query += " INNER JOIN PED_TIPO_SOLIC_PAIS pt \n";
        query += " ON pt.OID_TIPO_SOLI_PAIS = m.TSPA_OID_TIPO_SOLI_PAIS \n";
        query += " INNER JOIN v_gen_i18n_sicc ITipoSoli \n";
        query += " ON ITipoSoli.attr_enti = 'PED_TIPO_SOLIC' \n";
        query += " AND ITipoSoli.idio_oid_idio = " + criterios.getOidIdioma();
        query += " AND ITipoSoli.val_oid = pt.TSOL_OID_TIPO_SOLI \n";
        query += " AND ITipoSoli.attr_num_atri = 1 \n";
        query += " LEFT JOIN --/1  --Ahora lo juntamos con la configuracion de la plantilla, si existe \n";
        query += " ( --21  \n";
        //query += " ( --22  \n";
        query += subconsultaPlantilla(criterios.getPlantilla()) ;
        //query += " ) --/22  \n";
        query += " ) p ON (m.TSPA_OID_TIPO_SOLI_PAIS = p.TSPA_OID_TIPO_SOLI_PAIS AND --/21   \n";
        query += " m.ZORG_OID_REGI = p.ZORG_OID_REGI AND  \n";
        query += " m.ZZON_OID_ZONA = p.ZZON_OID_ZONA  \n";
        query += " ) LEFT JOIN ZON_ZONA z ON (m.ZZON_OID_ZONA = z.OID_ZONA) LEFT JOIN ZON_REGIO r ON (m.ZORG_OID_REGI = r.OID_REGI)  \n";
        query += " ORDER BY m.TSPA_OID_TIPO_SOLI_PAIS, m. ZORG_OID_REGI DESC, m.ZZON_OID_ZONA DESC ";


        Vector parametros = new Vector();
        if (criterios.getPlantilla() != null) { 
          for (int i=0; i<5; i++) { 
              //preparedStatement.setLong(numeroParemetro++, dto.plantilla); 
              parametros.add(criterios.getPlantilla());
          } 
        } 

        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
          rs = getBelcorpService().dbService.executePreparedQuery( query, parametros);
        } catch (MareException me) {
            throw me;
          } catch (Exception e) {
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
            }
        if (rs.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAOMonitor.obtenerDatos(DTOBuscarDatosMonitor criterios): Salida ");
        return rs;
  } 

  public String subconsultaPlantilla(Long plantilla) throws MareException {
      UtilidadesLog.info("DAOMonitor.subconsultaPlantilla(Long plantilla): Entrada ");
      StringBuffer query = new StringBuffer();
      /** VER Incidencias 7563 y 7718 **/
      if (plantilla == null) {
          query.append("SELECT 0 TSPA_OID_TIPO_SOLI_PAIS, 0 ZORG_OID_REGI, 0 ZZON_OID_ZONA, \n");
          query.append("             NULL GP1SEC, NULL GP2SEC, NULL GP3SEC, NULL GP4SEC, NULL GP5SEC \n");
          query.append(" FROM DUAL");
      } else { 
          query.append(" SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, MAX(GP1SEC) GP1SEC, \n");
          query.append(" MAX(GP2SEC) GP2SEC, MAX(GP3SEC) GP3SEC, MAX(GP4SEC) GP4SEC, MAX(GP5SEC) GP5SEC \n");
          query.append(" FROM ( \n");
          query.append("    SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, NUM_SECU GP1SEC, NULL GP2SEC,  \n");
          query.append("    NULL GP3SEC, NULL GP4SEC, NULL GP5SEC  \n");
          query.append("    FROM PED_PLANT_MONIT_DETAL  \n");
          query.append("    WHERE PLSM_OID_PLAN_MONI = ? AND GRPR_OID_GRUP_PROC = "+ ConstantesPED.GP1 + " \n");
          query.append("    UNION (  \n");
          query.append("    SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, NULL GP1SEC, NUM_SECU GP2SEC,  \n");
          query.append("    NULL GP3SEC, NULL GP4SEC, NULL GP5SEC  \n");
          query.append("    FROM PED_PLANT_MONIT_DETAL  \n");
          query.append("    WHERE PLSM_OID_PLAN_MONI = ? AND GRPR_OID_GRUP_PROC = "+ ConstantesPED.GP2 + " \n");
          query.append("    ) UNION (  \n");
          query.append("    SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, NULL GP1SEC, NULL GP2SEC,  \n");
          query.append("    NUM_SECU GP3SEC, NULL GP4SEC, NULL GP5SEC  \n");
          query.append("    FROM PED_PLANT_MONIT_DETAL  \n");
          query.append("    WHERE PLSM_OID_PLAN_MONI = ? AND GRPR_OID_GRUP_PROC = "+ ConstantesPED.GP3 + " \n");
          query.append("    ) UNION (  \n");
          query.append("    SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, NULL GP1SEC, NULL GP2SEC,  \n");
          query.append("    NULL GP3SEC, NUM_SECU GP4SEC, NULL GP5SEC  \n");
          query.append("    FROM PED_PLANT_MONIT_DETAL  \n");
          query.append("    WHERE PLSM_OID_PLAN_MONI = ? AND GRPR_OID_GRUP_PROC = "+ ConstantesPED.GP4 + " \n");
          query.append("    ) UNION (  \n");
          query.append("    SELECT TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA, NULL GP1SEC, NULL GP2SEC,  \n");
          query.append("    NULL GP3SEC, NULL GP4SEC, NUM_SECU GP5SEC  \n");
          query.append("    FROM PED_PLANT_MONIT_DETAL  \n");
          query.append("    WHERE PLSM_OID_PLAN_MONI = ? AND GRPR_OID_GRUP_PROC = "+ ConstantesPED.GP5 + " \n");
          query.append("    ) ");
          query.append(" ) \n ");
          query.append(" GROUP BY TSPA_OID_TIPO_SOLI_PAIS, ZORG_OID_REGI, ZZON_OID_ZONA \n ");

      }
      UtilidadesLog.info("DAOMonitor.subconsultaPlantilla(Long plantilla): Salida ");
      return query.toString();
  }


  /** Hacemos una consulta JDBC y obtenemos para todos los registros de la tabla 
   * "Plantilla Secuencia Monitor por Defecto Cabecera" cuyo pais coincida con el recibido por parametro. 
   * Para cada registro obtenemos oid y descripcion Devolvemos el resultado de la consulta.   **/
  public RecordSet obtenerPlantillas(Long pais) throws MareException {
        UtilidadesLog.info("DAOMonitor.obtenerPlantillas(Long pais): Entrada ");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT OID_PLAN_MONI as OID, ");
        query.append("               DES_PLAN_MONI as DESCRIPCION ");
        query.append(" FROM PED_PLANT_MONIT ");
        query.append(" WHERE PAIS_OID_PAIS = "+pais );
        
        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
          rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
          } catch (Exception e) {
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
            }
        UtilidadesLog.info("DAOMonitor.obtenerPlantillas(Long pais): Salida ");
        return rs;

  
  }

	public Integer validarGrupoReversion(DTOEGrupoReversion dtoin) throws MareException {
        UtilidadesLog.info("DAOMonitor.validarGrupoReversion(DTOEGrupoReversion dtoin): Entrada ");
  // Se verifique que todas las solicitudes en el grupo de reversión este en el mismo grupo de procesos.
       StringBuffer query = new StringBuffer();
       Integer resu;

       query.append(" SELECT PED_SOLIC_CABEC.GRPR_OID_GRUP_PROC");
       query.append(" FROM PED_SOLIC_CABEC");
       query.append(" WHERE PED_SOLIC_CABEC.VAL_GRUP_REVE = '" + dtoin.getGrupoReversion() + "'"); 
       query.append(" GROUP BY PED_SOLIC_CABEC.GRPR_OID_GRUP_PROC");

       //ejecución de la consulta
       RecordSet rs = new RecordSet();
       try {
         rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
       } catch (MareException me) {
           throw me;
       } catch (Exception e) {
           throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
       }

       if ((rs.getRowCount()==1) && (rs.getValueAt(0, "GRPR_OID_GRUP_PROC") != null)) {
         resu = new Integer(((BigDecimal) rs.getValueAt(0, "GRPR_OID_GRUP_PROC")).toString());
       } else {
         resu = new Integer(-1);        
       }
       UtilidadesLog.info("DAOMonitor.validarGrupoReversion(DTOEGrupoReversion dtoin): Salida ");
       return resu;
  
  }   

	private BelcorpService getBelcorpService() throws MareException{
        UtilidadesLog.info("DAOMonitor.getBelcorpService(): Entrada ");

        try {
            BelcorpService bs = BelcorpService.getInstance();
            UtilidadesLog.info("DAOMonitor.getBelcorpService(): Salida ");
			return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }		
		
	}
  /**
   * @Autor: Hugo A. Mansi
   * @Fecha: 09/09/2004
   * @Recibe: DTOAlarmaPedidos
   * @Devuelve: DTOAlarmas
   * @Descripción: Cuenta el número de pedidos sin facturar. 
   * @DMCO: SICC-DMCO-PED-201-354-N002b 
   */
   public DTOAlarmas cuentaAlarmas(DTOAlarmaPedidos dtoe) throws MareException {
        UtilidadesLog.info("DAOMonitor.cuentaAlarmas(DTOAlarmaPedidos dtoe): Entrada ");
        RecordSet rs;
        UtilidadesLog.debug("Contando alarmas...");
        BelcorpService bs = getBelcorpService();
        long hoy = System.currentTimeMillis();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");

        String fechaIni = simpledateformat.format(dtoe.getFechaIni());
		String fechaFin = simpledateformat.format(dtoe.getFechaFin());


        DTOAlarmas miDto = new DTOAlarmas();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT COUNT(*) as alarmas ");
        query.append(" FROM ped_solic_cabec, ped_estad_solic estado ");
        query.append(" WHERE ");
        query.append(" fec_prog_fact < sysdate AND ");
        query.append(" fec_prog_fact BETWEEN TO_Date( '" + fechaIni + "', 'DD-MM-YYYY') ");
        query.append(" AND  TO_Date( '" + fechaFin + "', 'DD-MM-YYYY') ");
		    query.append(" AND fec_fact IS NULL ");
        /* mdolce
         * 04/07/2006
         * Se debe exluir aquellas solicitudes bloquedas o rechazadas
         * */
        query.append(" and ESSO_OID_ESTA_SOLI = estado.OID_ESTA_SOLI ");
        query.append(" and estado.COD_ESTA_SOLI not in ('BL', 'RE') ");
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ", (MareException) e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
 
     miDto.setNumAlarmas(new Long (rs.getValueAt(0,0).toString()));
	 UtilidadesLog.debug("MI dto cuenta alarmas = " + miDto);
     UtilidadesLog.info("DAOMonitor.cuentaAlarmas(DTOAlarmaPedidos dtoe): Salida ");
     return miDto;         
   }//FIN cuentaAlarmas

/**
   * @Autor: Hugo A. Mansi
   * @Fecha: 09/09/2004
   * @Recibe: DTOAlarmaPedidos
   * @Devuelve: DTOSalida
   * @Descripción: Obtiene los pedidos sin facturar.
   * @DMCO: SICC-DMCO-PED-201-354-N002b 
   */
      public DTOSalida consultaAlarmaPedidos(DTOAlarmaPedidos dtoe) throws MareException {
        UtilidadesLog.info("DAOMonitor.consultaAlarmaPedidos(DTOAlarmaPedidos dtoe): Entrada ");


        UtilidadesLog.debug("Cosultando alarma pedidos...");
        RecordSet rs;
        BelcorpService bs = getBelcorpService();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaIni = simpledateformat.format(dtoe.getFechaIni());
    		String fechaFin = simpledateformat.format(dtoe.getFechaFin());
        DTOSalida miDto = new DTOSalida();
        StringBuffer query = new StringBuffer();
		query.append(" SELECT * from ( ");
		query.append(" SELECT a.oid_soli_cabe OID, in1.val_i18n canal, in2.val_i18n acceso, ");
		query.append(" in3.val_i18n subacceso, in4.val_i18n tiposolicitud, ");
		query.append(" a.val_nume_soli numsolicitud, a.fec_prog_fact fechafactura ");
		query.append(" FROM ped_solic_cabec a, ");
		query.append(" v_gen_i18n_sicc in1, ");
		query.append(" v_gen_i18n_sicc in2, ");
		query.append(" v_gen_i18n_sicc in3, ");
		query.append(" v_gen_i18n_sicc in4, ");
		query.append(" cra_perio b,	 ");
		query.append(" seg_subac c,	 ");
		query.append(" ped_tipo_solic_pais d,	 ");
    query.append(" ped_estad_solic estado ");
		query.append(" WHERE in1.attr_enti = 'SEG_CANAL' ");
		query.append(" AND in1.val_oid = b.CANA_OID_CANA ");
		query.append(" AND in1.attr_num_atri = 1 ");
		query.append(" AND in1.idio_oid_idio = "  + dtoe.getOidIdioma());
		query.append(" AND in2.attr_enti = 'SEG_ACCES' ");
		query.append(" AND in2.val_oid = c.ACCE_OID_ACCE ");
		query.append(" AND in2.attr_num_atri = 1 ");
		query.append(" AND in2.idio_oid_idio = " + dtoe.getOidIdioma());
		query.append(" AND in3.attr_enti = 'SEG_SUBAC' ");
		query.append(" AND in3.val_oid = a.SBAC_OID_SBAC ");
		query.append(" AND in3.attr_num_atri = 1 ");
		query.append(" AND in3.idio_oid_idio = " + dtoe.getOidIdioma());
		query.append(" AND in4.attr_enti = 'PED_TIPO_SOLIC' ");
		query.append(" AND in4.val_oid = d.TSOL_OID_TIPO_SOLI ");
		query.append(" AND in4.attr_num_atri = 1 ");
		query.append(" AND in4.idio_oid_idio = " + dtoe.getOidIdioma());
		query.append(" AND b.oid_peri = a.perd_oid_peri	 ");
		query.append(" AND c.oid_sbac = a.sbac_oid_sbac	 ");
		query.append(" AND d.oid_tipo_soli_pais = a.tspa_oid_tipo_soli_pais	 ");
		query.append(" AND a.oid_soli_cabe > " + dtoe.getIndicadorSituacion());
		query.append(" AND fec_prog_fact < sysdate ");
		query.append(" AND fec_prog_fact BETWEEN TO_Date( '" + fechaIni + "', 'DD-MM-YYYY') ");
		query.append(" AND  TO_Date( '" + fechaFin + "', 'DD-MM-YYYY') ");
		query.append(" AND fec_fact IS NULL ");
    /* mdolce 04/07/2006
     * Se deben exluir las solicitudes quen esten bloqueadas o rechazadas
     */
    query.append(" and a.ESSO_OID_ESTA_SOLI = estado.OID_ESTA_SOLI ");
		query.append(" and estado.COD_ESTA_SOLI not in ('BL', 'RE') ");
		query.append(" order by a.oid_soli_cabe ) ");
		query.append(" where ROWNUM <= " + dtoe.getTamanioPagina());
        try {
            
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",(MareException) e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
     
     miDto.setResultado(rs);
     UtilidadesLog.debug("DTO =   " + miDto);
     UtilidadesLog.info("DAOMonitor.consultaAlarmaPedidos(DTOAlarmaPedidos dtoe): Salida ");
     return miDto;         
   }//FIN cuentaAlarmas

/**
   * @Autor: SCSaavedra
   * @Fecha: 10/02/2005
   */

    public boolean verificarEjecucionActiva(ArrayList secuencia, Long gp) throws MareException {
        UtilidadesLog.info("DAOMonitor.verificarEjecucionActiva(ArrayList secuencia, Long gp): Entrada ");
        RecordSet rs;
        BelcorpService bs = getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled()){
            UtilidadesLog.debug("dentro de verificarEjecucionActiva.., recibo: " + secuencia + " grupo: " + gp);
        }
        
        if (secuencia.size() > 0) {
          Iterator it = null;
          it = secuencia.iterator();
          DTOSecuenciaSolicitudes elemento = null;
                    
          query.append("Select * from PED_MONIT_EJECU pme, ");
          query.append("GEN_PROCE_BATCH gpb");
          query.append(" where ");
          if(it.hasNext()){
              while(it.hasNext()) {
                elemento = (DTOSecuenciaSolicitudes)it.next();
                query.append("(pme.VAL_TIPO_SOLI_PAIS = " + elemento.getOidTipoSolicitud().longValue());
                query.append(" and pme.VAL_ZONA = " + elemento.getOidZona().longValue());
                query.append(" and pme.VAL_GRUP_PROC = " + gp.longValue());
                query.append(" and pme.COD_PROC = gpb.COD_PROC ");
                query.append(" and gpb.VAL_ESTA <> "+Proceso.PROCESO_ABORTADO);
                query.append(" and gpb.FEC_FIN is null) OR ");
              }
              query.delete(query.length()-3,query.length());
          }else{
              query.append(" 1!=1 ");
              query.append(" AND pme.cod_proc = gpb.cod_proc ");
          }
          
          //doliva -- cambio Optimizacion Logs -- 09/04/2010
          if(logAux.isDebugEnabled()){
            UtilidadesLog.debug("consulta: " + query.toString());
          }
          
          try {
              rs = bs.dbService.executeStaticQuery(query.toString());
              
              //doliva -- cambio Optimizacion Logs -- 09/04/2010
              if(logAux.isDebugEnabled()){
                UtilidadesLog.debug("luego query, obtengo: " + rs);
              }
          } catch (Exception e) {
              if (e instanceof MareException) {
                  UtilidadesLog.error("MareException: ",e);
                  throw (MareException) e;
              } else {
                  UtilidadesLog.error("Exception: ",e);
                  throw new MareException(e,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
          }
    
          if (rs.getRowCount() > 0 ) {
            UtilidadesLog.info("DAOMonitor.verificarEjecucionActiva(ArrayList secuencia, Long gp): Salida ");
            return false;
          } else{
            UtilidadesLog.info("DAOMonitor.verificarEjecucionActiva(ArrayList secuencia, Long gp): Salida ");
            return true;
          }
        } else {
          UtilidadesLog.info("DAOMonitor.verificarEjecucionActiva(ArrayList secuencia, Long gp): Salida ");
          return true;
        }
    }
    

  /**
   * CHANGELOG
   * ---------
   * dmorello, 14/01/2009 - Cambio RI 20090825
   *   - Se filtran resultados por los tipos de solicitud de la plantilla seleccionada
   *   - Se descartan los tipos de sol. que, para un GP que tiene num de secuencia asignado,
   *     la cantidad de solicitudes acumuladas es cero.
   */
  public RecordSet obtenerDatosNuevoEstadoBatch(DTOBuscarDatosMonitor criterios) throws MareException {
        UtilidadesLog.info("DAOMonitor.obtenerDatosNuevoEstadoBatch(DTOBuscarDatosMonitor criterios): Entrada ");
        StringBuffer query = new StringBuffer();
        
        if (criterios.getFechaFin() == null) { 
            criterios.setFechaFin(new java.util.Date()); 
        } 

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dia = new java.sql.Date(criterios.getFechaInicio().getTime());
        String sDiaIni = sdf.format(dia);
        dia = new java.sql.Date(criterios.getFechaFin().getTime());
        String sDiaFin = sdf.format(dia);
        UtilidadesLog.debug("El dia actual a pasar es, Ini: " + sDiaIni + "   Fin: "+sDiaFin);
        
        ArrayList array = new ArrayList();
        array.add(sDiaIni);       
        if (criterios.getFechaFin() == null) { 
            array.add("NULL");            
        } else {
            array.add(sDiaFin);            
        }        
        
        UtilidadesLog.debug("El periodo activo es :" + criterios.getOidPeriodo());
        // sapaza -- PER-SiCC-2011-0079 -- 14/02/2011
        if (criterios.getOidPeriodo() == null) 
            array.add("NULL");            
        else    
            array.add(criterios.getOidPeriodo().toString());

        // sapaza -- PER-SiCC-2011-0079 -- 25/02/2011
        if (criterios.getOidPeriodoSiguiente() == null) 
            array.add("NULL");            
        else    
            array.add(criterios.getOidPeriodoSiguiente().toString());
            
        RecordSet rs1;
        try {
          rs1 = getBelcorpService().dbService.executeProcedure("PQ_PLANI.PED_ACTUA_CABEC_ACUM",array); 
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
              UtilidadesLog.info("SCS Exception: " + e.getMessage());
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        Long oidPlantilla = criterios.getPlantilla();

        query.append(" SELECT   * ");
        //
        if (oidPlantilla != null) {
            query.append(" FROM (SELECT * ");
        }
        //
        //query.append(" FROM (SELECT   c.oid_acum, g1.val_i18n, re.cod_regi, zo.cod_zona, ");
        query.append(" FROM (SELECT   g1.val_i18n, re.cod_regi, zo.cod_zona, ");
        /*query.append(" c.val_acum_gp1, NULL b1, c.val_acum_gp2, NULL b2, ");
        query.append(" c.val_acum_gp3, NULL b3, c.val_acum_gp4, NULL b4, ");
        query.append(" c.val_acum_gp5, NULL b5, c.tspa_oid_tipo_soli_pais, zo.zorg_oid_regi, ");*/
        //<inicio>incidencia DBLG700000082, modificado por Sapaza    
        query.append(" sum(c.val_acum_gp1) AS gp1, " + obtenerOrdenEjecucionPlantilla(criterios.getPlantilla(),"1") +"b1, sum(c.val_acum_gp2) AS gp2, " + obtenerOrdenEjecucionPlantilla(criterios.getPlantilla(),"2") + "b2, ");
        query.append(" sum(c.val_acum_gp3) AS gp3, " + obtenerOrdenEjecucionPlantilla(criterios.getPlantilla(),"3") + "b3, sum(c.val_acum_gp4) AS gp4, " + obtenerOrdenEjecucionPlantilla(criterios.getPlantilla(),"4") + "b4, ");
        query.append(" sum(c.val_acum_gp5) AS gp5, " + obtenerOrdenEjecucionPlantilla(criterios.getPlantilla(),"5") + "b5, c.tspa_oid_tipo_soli_pais, zo.zorg_oid_regi, ");
        //<fin>incidencia DBLG700000082    
        query.append(" zo.oid_zona, ");
        //en ejecucion gp1
        query.append(" (SELECT COUNT(OID_MONI_EJEC) ");
            query.append(" FROM ped_monit_ejecu pme1, gen_proce_batch gpb  ");
            query.append(" WHERE pme1.val_tipo_soli_pais = c.tspa_oid_tipo_soli_pais ");
            query.append(" AND pme1.val_zona = zo.oid_zona ");
            query.append(" AND pme1.val_grup_proc = 1 ");
            query.append(" AND pme1.cod_proc = gpb.cod_proc ");
            query.append(" AND (gpb.val_esta = "+ Proceso.PROCESO_ENCOLADO + " OR gpb.val_esta = "+ Proceso.PROCESO_EJECUTANDO +" ) ");
            query.append(" AND gpb.fec_fin IS NULL ");
            if (sDiaIni!=null){
                query.append(" AND trunc(gpb.fec_inic) >= trunc(TO_DATE ('"+sDiaIni+"', 'dd/MM/yyyy')) ");
            }
            if (sDiaFin!=null){
                query.append(" AND trunc(gpb.fec_inic) <= trunc(TO_DATE ('"+sDiaFin+"', 'dd/MM/yyyy')) ) EJEC1, ");
            }
        //en ejecucion gp2
        query.append(" (SELECT COUNT(OID_MONI_EJEC) ");
            query.append(" FROM ped_monit_ejecu pme1, gen_proce_batch gpb  ");
            query.append(" WHERE pme1.val_tipo_soli_pais = c.tspa_oid_tipo_soli_pais ");
            query.append(" AND pme1.val_zona = zo.oid_zona ");
            query.append(" AND pme1.val_grup_proc = 2 ");
            query.append(" AND pme1.cod_proc = gpb.cod_proc ");
            query.append(" AND (gpb.val_esta = "+ Proceso.PROCESO_ENCOLADO + " OR gpb.val_esta = "+ Proceso.PROCESO_EJECUTANDO +" ) ");
            query.append(" AND gpb.fec_fin IS NULL ");
            if (sDiaIni!=null){
                query.append(" AND trunc(gpb.fec_inic) >= trunc(TO_DATE ('"+sDiaIni+"', 'dd/MM/yyyy')) ");
            }
            if (sDiaFin!=null){
                query.append(" AND trunc(gpb.fec_inic) <= trunc(TO_DATE ('"+sDiaFin+"', 'dd/MM/yyyy')) ) EJEC2, ");
            }
        //en ejecucion gp3
        query.append(" (SELECT COUNT(OID_MONI_EJEC) ");
            query.append(" FROM ped_monit_ejecu pme1, gen_proce_batch gpb  ");
            query.append(" WHERE pme1.val_tipo_soli_pais = c.tspa_oid_tipo_soli_pais ");
            query.append(" AND pme1.val_zona = zo.oid_zona ");
            query.append(" AND pme1.val_grup_proc = 3 ");
            query.append(" AND pme1.cod_proc = gpb.cod_proc ");
            query.append(" AND (gpb.val_esta = "+ Proceso.PROCESO_ENCOLADO + " OR gpb.val_esta = "+ Proceso.PROCESO_EJECUTANDO +" ) ");
            query.append(" AND gpb.fec_fin IS NULL ");
            if (sDiaIni!=null){
                query.append(" AND trunc(gpb.fec_inic) >= trunc(TO_DATE ('"+sDiaIni+"', 'dd/MM/yyyy')) ");
            }
            if (sDiaFin!=null){
                query.append(" AND trunc(gpb.fec_inic) <= trunc(TO_DATE ('"+sDiaFin+"', 'dd/MM/yyyy')) ) EJEC3, ");
            }
        //en ejecucion gp4
        query.append(" (SELECT COUNT(OID_MONI_EJEC) ");
            query.append(" FROM ped_monit_ejecu pme1, gen_proce_batch gpb  ");
            query.append(" WHERE pme1.val_tipo_soli_pais = c.tspa_oid_tipo_soli_pais ");
            query.append(" AND pme1.val_zona = zo.oid_zona ");
            query.append(" AND pme1.val_grup_proc = 4 ");
            query.append(" AND pme1.cod_proc = gpb.cod_proc ");
            query.append(" AND (gpb.val_esta = "+ Proceso.PROCESO_ENCOLADO + " OR gpb.val_esta = "+ Proceso.PROCESO_EJECUTANDO +" ) ");
            query.append(" AND gpb.fec_fin IS NULL ");
            if (sDiaIni!=null){
                query.append(" AND trunc(gpb.fec_inic) >= trunc(TO_DATE ('"+sDiaIni+"', 'dd/MM/yyyy') )");
            }
            if (sDiaFin!=null){
                query.append(" AND trunc(gpb.fec_inic) <= trunc(TO_DATE ('"+sDiaFin+"', 'dd/MM/yyyy')) ) EJEC4, ");
            }
        //en ejecucion gp5
        query.append(" (SELECT COUNT(OID_MONI_EJEC) ");
            query.append(" FROM ped_monit_ejecu pme1, gen_proce_batch gpb  ");
            query.append(" WHERE pme1.val_tipo_soli_pais = c.tspa_oid_tipo_soli_pais ");
            query.append(" AND pme1.val_zona = zo.oid_zona ");
            query.append(" AND pme1.val_grup_proc = 5 ");
            query.append(" AND pme1.cod_proc = gpb.cod_proc ");
            query.append(" AND (gpb.val_esta = "+ Proceso.PROCESO_ENCOLADO + " OR gpb.val_esta = "+ Proceso.PROCESO_EJECUTANDO +" ) ");
            query.append(" AND gpb.fec_fin IS NULL ");
            if (sDiaIni!=null){
                query.append(" AND trunc(gpb.fec_inic) >= trunc(TO_DATE ('"+sDiaIni+"', 'dd/MM/yyyy')) ");
            }
            if (sDiaFin!=null){
                query.append(" AND trunc(gpb.fec_inic) <=trunc( TO_DATE ('"+sDiaFin+"', 'dd/MM/yyyy') )) EJEC5 ");
            }
        query.append(" FROM ped_solic_cabec_acum c, ");
        query.append(" seg_subac s, ");
        query.append(" gen_i18n_sicc g1, ");
        query.append(" ped_tipo_solic_pais pt, ");
        query.append(" zon_zona zo, ");
        query.append(" zon_regio re ");
        query.append(" WHERE 1=1 ");
        if (sDiaIni!=null){
            query.append(" AND trunc(c.fec_proc) >= trunc(TO_DATE ('"+sDiaIni+"', 'dd/MM/yyyy')) ");
        }
        if (sDiaFin!=null){
        query.append(" AND trunc(c.fec_proc) <= trunc(TO_DATE ('"+sDiaFin+"', 'dd/MM/yyyy')) ");
        }
        if (criterios.getOidTipoSolicitudPais()!=null){
            if (oidPlantilla != null) {
                query.append(" AND (c.tspa_oid_tipo_soli_pais IN " + criterios.getOidTipoSolicitudPais().toString().replace('[','(').replace(']',')') );
                query.append("     OR c.tspa_oid_tipo_soli_pais IN ( ");
                query.append("        SELECT tspa_oid_tipo_soli_pais ");
                query.append("          FROM ped_plant_monit_detal ");
                query.append("         WHERE plsm_oid_plan_moni = ").append(oidPlantilla).append(')');
                query.append(" )");
            } else {
                query.append(" AND c.tspa_oid_tipo_soli_pais IN " + criterios.getOidTipoSolicitudPais().toString().replace('[','(').replace(']',')') );
            }
        } else {
            if (oidPlantilla != null) {
                query.append(" AND c.tspa_oid_tipo_soli_pais IN ( ");
                query.append("     SELECT tspa_oid_tipo_soli_pais ");
                query.append("       FROM ped_plant_monit_detal ");
                query.append("      WHERE plsm_oid_plan_moni = ").append(oidPlantilla);
                query.append(" )");
            }
        }

        //<inicio>filtramos por regiones y zonas seleccionadas, incidencia SiCC-20070172        
        if (criterios.getOidRegiones()!=null){
            query.append(" AND zo.zorg_oid_regi IN " + criterios.getOidRegiones().toString().replace('[','(').replace(']',')') );
        }
        if (criterios.getOidZonas()!=null){
            query.append(" AND zo.oid_zona IN " + criterios.getOidZonas().toString().replace('[','(').replace(']',')') );
        }
        //<fin>incidencia SiCC-20070172
        
        query.append(" AND c.sbac_oid_sbac = s.oid_sbac ");
        if (criterios.getOidAcceso()!=null){
            query.append(" AND s.acce_oid_acce = "+criterios.getOidAcceso());
        }
        query.append(" AND c.tspa_oid_tipo_soli_pais = pt.oid_tipo_soli_pais ");
        query.append(" AND g1.val_oid = pt.tsol_oid_tipo_soli ");
        query.append(" AND g1.attr_enti = 'PED_TIPO_SOLIC' ");
        query.append(" AND g1.attr_num_atri = 1 ");
        
        query.append(" AND g1.idio_oid_idio =  "+criterios.getOidIdioma());
        query.append(" AND zo.oid_zona = c.zzon_oid_zona ");
        query.append(" AND zo.zorg_oid_regi = re.oid_regi ");
        query.append(" group by g1.val_i18n, re.cod_regi, zo.cod_zona, zo.zorg_oid_regi, ");
        query.append(" zo.oid_zona, c.tspa_oid_tipo_soli_pais ");
        //
        if (oidPlantilla != null) {
            query.append(" ) ");
            query.append(" WHERE (b1 IS NULL OR gp1 > 0) ");
            query.append("   AND (b2 IS NULL OR gp2 > 0) ");
            query.append("   AND (b3 IS NULL OR gp3 > 0) ");
            query.append("   AND (b4 IS NULL OR gp4 > 0) ");
            query.append("   AND (b5 IS NULL OR gp5 > 0) ");
        }
        query.append(" ORDER BY val_i18n, cod_regi, cod_zona) ");

        RecordSet rs = null;
        try {
          rs = getBelcorpService().dbService.executeStaticQuery( query.toString());
        } catch (MareException me) {
            throw me;
          } catch (Exception e) {
              UtilidadesLog.info("SCS Exception: " + e.getMessage());
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
            }
        if (rs.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        StringBuffer paresTipoSolicZona = new StringBuffer();
        paresTipoSolicZona.append('(');
        int size = rs.getRowCount();
        for (int i = 0; i < size; i++) {
            String tipoSol = rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS").toString();
            String zona = rs.getValueAt(i, "OID_ZONA").toString();
            paresTipoSolicZona.append('(').append(tipoSol).append(',').append(zona).append(')');
            if (i < size-1) {
                paresTipoSolicZona.append(',');
            }
        }
        paresTipoSolicZona.append(')');
        
        // Se elimina la union de queries, se hara luego en el codigo Java
        //query.append(" UNION ");
        query = new StringBuffer();
        //
        query.append(" SELECT m.val_i18n, NULL COD_REGI , NULL COD_ZONA, gp1, b1, gp2, b2, gp3, b3, gp4, ");
        query.append(" b4, gp5, b5, m.tspa_oid_tipo_soli_pais, NULL ZORG_OID_REGI, NULL OID_ZONA ");
        query.append(" ,NULL EJEC1,NULL EJEC2,NULL EJEC3,NULL EJEC4,NULL EJEC5 ");
        query.append(" FROM (SELECT   g1.val_i18n, SUM (c.val_acum_gp1) gp1, NULL b1, ");
        query.append(" SUM (c.val_acum_gp2) gp2, NULL b2, ");
        query.append(" SUM (c.val_acum_gp3) gp3, NULL b3, ");
        query.append(" SUM (c.val_acum_gp4) gp4, NULL b4, ");
        query.append(" SUM (c.val_acum_gp5) gp5, NULL b5, ");
        query.append(" c.tspa_oid_tipo_soli_pais ");
        query.append(" FROM ped_solic_cabec_acum c, ");
        query.append(" seg_subac s, ");
        query.append(" gen_i18n_sicc g1, ");
        query.append(" ped_tipo_solic_pais pt, ");
        query.append(" zon_zona zo ");
        query.append(" WHERE 1=1 ");
        if (sDiaIni!=null){
            query.append(" AND trunc(c.fec_proc) >= trunc(TO_DATE ('"+sDiaIni+"', 'dd/MM/yyyy') )");
        }
        if (sDiaFin!=null){
            query.append(" AND trunc(c.fec_proc) <= trunc(TO_DATE ('"+sDiaFin+"', 'dd/MM/yyyy')) ");
        }
        query.append(" AND c.sbac_oid_sbac = s.oid_sbac ");
        /*if (criterios.getOidTipoSolicitudPais()!=null){
            query.append(" AND c.tspa_oid_tipo_soli_pais IN " + criterios.getOidTipoSolicitudPais().toString().replace('[','(').replace(']',')') );
        }
        if (criterios.getOidAcceso()!=null){
            query.append(" AND s.acce_oid_acce = "+criterios.getOidAcceso());
        }
        
        //<inicio>filtramos por regiones y zonas seleccionadas, incidencia SiCC-20070172
        if (criterios.getOidRegiones()!=null){
            query.append(" AND zo.zorg_oid_regi IN " + criterios.getOidRegiones().toString().replace('[','(').replace(']',')') );
        }
        if (criterios.getOidZonas()!=null){
            query.append(" AND zo.oid_zona IN " + criterios.getOidZonas().toString().replace('[','(').replace(']',')') );
        }*/
        //<fin>incidencia SiCC-20070172
        query.append(" AND (c.tspa_oid_tipo_soli_pais,zo.oid_zona) IN ").append(paresTipoSolicZona);
        
        query.append(" AND c.tspa_oid_tipo_soli_pais = pt.oid_tipo_soli_pais ");
        query.append(" AND g1.val_oid = pt.tsol_oid_tipo_soli ");
        query.append(" AND g1.attr_enti = 'PED_TIPO_SOLIC' ");
        query.append(" AND g1.attr_num_atri = 1 ");
        query.append(" AND g1.idio_oid_idio =  "+criterios.getOidIdioma());
        query.append(" AND zo.oid_zona = c.zzon_oid_zona ");
        query.append(" GROUP BY g1.val_i18n, c.tspa_oid_tipo_soli_pais ");
        query.append(" ORDER BY g1.val_i18n) m ");
        query.append(" ORDER BY val_i18n ASC, cod_regi asc , cod_zona asc");
        RecordSet rs2 = new RecordSet();
        try {
          rs2 = getBelcorpService().dbService.executeStaticQuery( query.toString());
        } catch (MareException me) {
            throw me;
          } catch (Exception e) {
              UtilidadesLog.info("SCS Exception: " + e.getMessage());
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
            }
        if (rs2.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        
        // Procedo a realizar la combinacion de recordsets
        int i1 = 0;
        int i2 = 0;
        int size1 = rs.getRowCount();
        Object oidTipoSolicitud = null;
        Object oidTipoSolicitudActual = null;
        
        RecordSet rsFinal = new RecordSet();
        for (int i = 0; i < rs.getColumnCount(); i++) {
            rsFinal.addColumn(rs.getColumnName(i));
        }
        UtilidadesLog.debug("nombres de las columnas: " + rsFinal.getColumnIdentifiers());
        
        while (i1 < size1) {
            Vector row = rs.getRow(i1);
            oidTipoSolicitud = rs.getValueAt(i1, "TSPA_OID_TIPO_SOLI_PAIS");
            if (oidTipoSolicitudActual != null) {
                if (! oidTipoSolicitud.equals(oidTipoSolicitudActual)) {
                    // Copio la fila del segundo recordset
                    Vector row2 = rs2.getRow(i2);
                    rsFinal.addRow(row2);
                    oidTipoSolicitudActual = oidTipoSolicitud;
                    i2++;
                }
            } else {
                oidTipoSolicitudActual = oidTipoSolicitud;
            }
            rsFinal.addRow(row);
            i1++;
        }
        
        // Copio la fila que quedo
        Vector row = rs2.getRow(i2);
        rsFinal.addRow(row);
        
        UtilidadesLog.debug("rsFinal: " + rsFinal);
        
        UtilidadesLog.info("DAOMonitor.obtenerDatosNuevoEstadoBatch(DTOBuscarDatosMonitor criterios): Salida ");
        return rsFinal;
  } 

  //agregado por Sapaza, por incidencia DBLG700000082    
  private String obtenerOrdenEjecucionPlantilla(Long oidPlantilla, String grupoProceso) {
    StringBuffer query = new StringBuffer();
    
    if(oidPlantilla != null) {
      query.append("(SELECT MIN(NUM_SECU) ");
      query.append("FROM PED_PLANT_MONIT_DETAL PPMD, PED_PLANT_MONIT PPM ");
      query.append("WHERE PPM.OID_PLAN_MONI = " + oidPlantilla.toString() + " ");
      query.append("AND PPMD.PLSM_OID_PLAN_MONI = PPM.OID_PLAN_MONI ");
      query.append("AND PPMD.GRPR_OID_GRUP_PROC = " + grupoProceso + " ");
      query.append("AND PPMD.TSPA_OID_TIPO_SOLI_PAIS = c.TSPA_OID_TIPO_SOLI_PAIS ");
      query.append("AND PPMD.ZZON_OID_ZONA = zo.oid_zona) ");
    }
    else {
      query.append("NULL ");
    }
    
    return query.toString();
  }

    // sapaza -- PER-SiCC-2011-0079 -- 14/02/2011  
    public RecordSet obtenerDatosCampañaActiva(Long pais) throws MareException {
        UtilidadesLog.info("DAOMonitor.obtenerDatosCampañaActiva(Long pais): Entrada ");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT CTRL.COD_PAIS, ");
        query.append("        CTRL.COD_PERI, ");
        query.append("        CTRL.FEC_PROC, ");
        query.append("        CRA.OID_PERI ");
        query.append("   FROM BAS_CTRL_FACT CTRL, ");
        query.append("        SEG_PERIO_CORPO COR, ");
        query.append("        CRA_PERIO CRA, ");
        query.append("        SEG_MARCA MAR, ");
        query.append("        SEG_CANAL CAN, ");
        query.append("        SEG_PAIS PAI ");
        query.append("  WHERE PAI.OID_PAIS = " + pais );
        query.append("    AND CTRL.COD_PAIS = PAI.COD_PAIS ");
        query.append("    AND CTRL.sta_camp = 0 ");
        query.append("    AND CTRL.ind_camp_act = 1 ");
        query.append("    AND COR.COD_PERI = CTRL.COD_PERI ");
        query.append("    AND CRA.PERI_OID_PERI = COR.OID_PERI ");
        query.append("    AND CRA.MARC_OID_MARC = MAR.OID_MARC ");
        query.append("    AND CRA.CANA_OID_CANA = CAN.OID_CANA ");
        query.append("    AND CRA.PAIS_OID_PAIS = PAI.OID_PAIS ");
        query.append("    AND MAR.COD_MARC = 'T' ");
        query.append("    AND CAN.COD_CANA = 'VD' ");
        query.append("  ORDER BY CTRL.COD_PERI ");
          
        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        UtilidadesLog.info("DAOMonitor.obtenerDatosCampañaActiva(Long pais): Salida ");
        return rs;
    }  
    
    // sapaza -- PER-SiCC-2011-0079 -- 24/02/2011  
    public RecordSet obtenerDatosCampañaSiguiente(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOMonitor.obtenerDatosCampañaSiguiente(Long oidPeriodo): Entrada ");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT OID_PERI, FEC_FINA ");
        query.append(" FROM ( ");
        query.append("       SELECT B.oid_peri, B.Fec_Fina ");
        query.append("         FROM cra_perio A, cra_perio B ");
        query.append("        WHERE A.oid_peri = " + oidPeriodo);
        query.append("          AND B.pais_oid_pais = A.pais_oid_pais ");
        query.append("          AND B.marc_oid_marc = A.marc_oid_marc ");
        query.append("          AND B.cana_oid_cana = A.cana_oid_cana ");
        query.append("          AND B.fec_inic > A.fec_inic ");
        query.append(" ORDER BY B.fec_inic) "); 
        query.append(" WHERE ROWNUM <= 1 "); 
        
        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        UtilidadesLog.info("DAOMonitor.obtenerDatosCampañaSiguiente(Long oidPeriodo): Salida ");
        return rs;
    }  
    
}    