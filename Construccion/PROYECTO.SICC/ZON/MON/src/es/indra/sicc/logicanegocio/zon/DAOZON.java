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

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.dtos.zon.DTOResponsable;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.dtos.zon.DTOBuscarUA;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.zon.DTOLISTUniNSE;
import es.indra.sicc.dtos.zon.DTOUniNSE;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.zon.ConstantesZON;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.ZONEjbLocators;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import es.indra.sicc.dtos.zon.DTOPedidosZona;
import es.indra.sicc.dtos.zon.DTOHistoricoZona;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOBelcorp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.ejb.FinderException;


public class DAOZON {
    private String codigoError = null;

    public DAOZON() {  }

    public DTOSalida obtenerTerritoriosUG(Long oidPais, Long oidUG) throws MareException {
      /*Obtiene los territorios asociados a una Unidad Geográfica
        para mostrarlos en un árbol de consulta de estado de Unidades Geográficas. 

        Proceso 
        ========= 
        Se ejecuta la query: 

        SELECT 
        -1 indTerritorio, 
        A.cod_terr codTerritorio, 
        A.cod_terr desTerritorio, 
        B.ind_acti indActivo, 
        A.cod_nse1 nse1, 
        A.cod_nse2 nse2, 
        A.cod_nse3 nse3, 
        NULL cp, 
        NULL ubigeo 

        FROM 
        zon_terri A, 
        zon_valor_estru_geopo B 

        WHERE 
        A.pais_oid_pais = oidPais AND 
        A.vepo_oid_valo_estr_geop = oidUG AND 
        A.ind_borr = 0 AND 
        B.oid_valo_estr_geop = A.vepo_oid_valo_estr_geop 

        Se devuelven las columnas: 
        indTerritorio (que servirá para identificar los nodos que son de territorios), 
        codTerritorio, 
        desTerritorio, 
        indActivo, 
        nse1, 
        nse2, 
        nse3, 
        cp, 
        ubigeo */
      UtilidadesLog.info("DAOZON.obtenerTerritoriosUG(Long oidPais, Long oidUG): Entrada");
      BelcorpService bs = null;

      StringBuffer query = new StringBuffer();
    
      query.append(" SELECT ");
      query.append(" -1 indTerritorio, ");
      query.append(" A.cod_terr codTerritorio, ");
      query.append(" A.cod_terr desTerritorio, ");
      query.append(" B.ind_acti indActivo, ");
      query.append(" A.cod_nse1 nse1, ");
      query.append(" A.cod_nse2 nse2, ");
      query.append(" A.cod_nse3 nse3, ");
      query.append(" NULL cp, ");
      query.append(" NULL ubigeo ");      
      query.append(" FROM zon_terri A, zon_valor_estru_geopo B ");
      query.append(" WHERE A.pais_oid_pais = " + oidPais.toString());
      query.append(" AND A.vepo_oid_valo_estr_geop = " + oidUG.toString());
      query.append(" AND A.ind_borr = 0 ");
      query.append(" AND B.oid_valo_estr_geop = A.vepo_oid_valo_estr_geop ");     
      query.append(" ORDER BY codTerritorio ");

      try {
        bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex) {
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      RecordSet rs = null;

      try {
        rs = bs.dbService.executeStaticQuery(query.toString());
      }
      catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      if(rs.esVacio()) {
        UtilidadesLog.info("DAOZON.obtenerTerritoriosUG(Long oidPais, Long oidUG): Salida");
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      else {
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOZON.obtenerTerritoriosUG(Long oidPais, Long oidUG): Salida");
        return dtoSalida;
      }  
    }

    public Long obtenerUltimoNivel (Long oidPais) throws MareException {
      /*Obtiene el oid de la Estructura Geopolítica de máximo orden. 

        Proceso 
        ========= 
        Se ejecuta la query: 

        SELECT oid_estr_geop oidMax
        FROM zon_estru_geopo 
        WHERE pais_oid_pais = oidPais AND 
        cod_orde = (SELECT MAX(cod_orde) 
        FROM zon_estru_geopo 
        WHERE pais_oid_pais = oidPais) 

        Se retorna oidMax.*/
      UtilidadesLog.info("DAOZON.obtenerUltimoNivel (Long oidPais): Entrada");

      BelcorpService bs = null;

      StringBuffer query = new StringBuffer();
    
      query.append(" SELECT oid_estr_geop oidMax ");
      query.append(" FROM zon_estru_geopo ");
      query.append(" WHERE pais_oid_pais = " + oidPais.toString());
      query.append(" AND cod_orde = ");    
      query.append(" (SELECT MAX(cod_orde) ");
      query.append(" FROM zon_estru_geopo ");
      query.append(" WHERE pais_oid_pais = " + oidPais.toString() + ") ");

      try {
        bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex) {
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      RecordSet rs = null;

      try {
        rs = bs.dbService.executeStaticQuery(query.toString());
      }
      catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      if(rs.esVacio()) {
        UtilidadesLog.info("DAOZON.obtenerUltimoNivel (Long oidPais): Salida");
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      else {
        BigDecimal valor = (BigDecimal)rs.getValueAt(0,"oidMax");
        Long lVal = new Long(valor.longValue());      
        UtilidadesLog.info("DAOZON.obtenerUltimoNivel (Long oidPais): Salida");
        return lVal;    
      }      
    }

    public DTOLISTUniNSE obtenerTerritoriosEnUG(Long codUG)
        throws MareException {
        // Dado el OID de una unidad geografica correspondiente al nivel más bajo, 
        // realiza un query en la entidad de territorios buscando todos aquello territorios 
        // que pertenezcan a esa Unidad Geografica. 
        // NOTA: Siempre recibe en codUG el código de una unidad geográfica de nivel mas bajo.
        // Utiliza la tabla ZON_TERRI.
        
        UtilidadesLog.info("DAOZON.obtenerTerritoriosEnUG(Long codUG): Entrada");

        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        StringBuffer SQL = new StringBuffer(
                "SELECT OID_TERR, COD_NSE1, COD_NSE2, ");
        SQL.append("COD_NSE3 FROM ZON_TERRI WHERE VEPO_OID_VALO_ESTR_GEOP=");
        SQL.append(codUG.toString());
        SQL.append(" AND IND_BORR=0");

        RecordSet r;

        try {
            // Ejecuta la consulta.
            r = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        DTOLISTUniNSE dtoNSEList = armaDTOLIST(r);
        UtilidadesLog.info("DAOZON.obtenerTerritoriosEnUG(Long codUG): Salida");
        return dtoNSEList;
    }

    private boolean checkStr(String s) {
        return ((s != null) && (s.length() > 0)) ? true : false;
    }

    public DTOLISTUniNSE obtenerUGinferioresaUG(Long oidUG)
        throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerUGinferioresaUG(Long oidUG): Entrada");
        
        String sNombreTabla = "ZON_VALOR_ESTRU_GEOPO";
        BelcorpService bs;
        DTOLISTUniNSE dtoNSEList = new DTOLISTUniNSE();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        StringBuffer SQL = new StringBuffer(
                "SELECT ORDE_1, ORDE_2, ORDE_3, ORDE_4, ORDE_5,");
        SQL.append(" ORDE_6, ORDE_7, ORDE_8, ORDE_9, PAIS_OID_PAIS FROM " +
            sNombreTabla.toString());
        SQL.append(" WHERE OID_VALO_ESTR_GEOP=" + oidUG.toString() + " AND");
        SQL.append(" IND_ACTI=1 AND IND_BORR=0");

        //SQL.append(" PAIS_OID_PAIS=" +  )
        RecordSet r = null;

        try {
            // Ejecuta la consulta.
            r = bs.dbService.executeStaticQuery(SQL.toString());
            UtilidadesLog.debug("Primer R: " + r.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //RecordSet
        int nNivelOrden = 0;

        if (r.getRowCount() != 0) // Encontró un registro.
         {
            // Encuentra en qué nivel de orden se encuentra esta UG
            // chequeando todos los parámetros de orden hasta que encuentre
            // uno NULL.
            // Por ejemplo, con i=4, se encuentra null, entonces el nivel de orden
            // sería 4 (ya que i=4 denota el 5to elemento o nivel de orden).
            int i = 0;
            boolean bFlagNull = false;
            BigDecimal nBigDecimal = (BigDecimal) r.getValueAt(0, 9);
            String sPaisFiltrado = nBigDecimal.toString();
            String sValorNivelOrden = null;

            SQL = new StringBuffer(
                    "SELECT OID_VALO_ESTR_GEOP, COD_NSE1, COD_NSE2, COD_NSE3");
            SQL.append(" FROM ZON_VALOR_ESTRU_GEOPO WHERE");
            SQL.append(" PAIS_OID_PAIS=" + sPaisFiltrado);

            while ((i < 9) && (bFlagNull == false)) {
                if (r.getValueAt(0, i) == null) {
                    nNivelOrden = i;

                    if (i <= 7) {
                        SQL.append(" AND ORDE_" +
                            new Integer(i + 2).toString() + " IS NULL");
                    }

                    bFlagNull = true;
                } else {
                    sValorNivelOrden = (String) r.getValueAt(0, i);
                    SQL.append(" AND ORDE_" + new Integer(i + 1).toString() +
                        "='" + sValorNivelOrden + "'");
                }

                i++;
            }

            SQL.append(" AND OID_VALO_ESTR_GEOP <> " + oidUG.toString());

            // Con el nivel de orden, se procede a buscar todos los registros 
            // que coincidan con el país obtenido, la descripción en el campo 
            // ORDEN_nNivelOrden, y que tengan null en el campo ORDEN_nNivel+2.
            // Por ejemplo, si se requiere los inferiores al nivel 1, entonces 
            // se filtra por país, valor campo de nivel de orden 1 y con valores
            // NULL en el nivel de orden 3.

            try {
                // Ejecuta la consulta.
                r = bs.dbService.executeStaticQuery(SQL.toString());
            } catch (Exception ex) {
                throw new MareException(ex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            UtilidadesLog.debug("Segundo RSet: " + r.toString());
            dtoNSEList = armaDTOLIST(r);
        }
        UtilidadesLog.info("DAOZON.obtenerUGinferioresaUG(Long oidUG): Salida");
        return dtoNSEList;
    }

    public DTOLISTUniNSE obtenerUAinferioresUA(Long oidUA, Integer nivelUA)
        throws MareException {
        // nivelUA: Especifica sobre que nivel se desea obtener todas las entidades
        // de nivel inmediatamente inferior.
        // 
        //  valores: 1 - SVG
        //           2 - Region
        //           3 - Zona
        //           4 - Seccion
        // 
        // oidUA: Especifica el código o id del elemento correspondiente a buscar
        // en la entidad inmediatemente inferio a nivelUA.
        // 
        // Para los primeros 3 niveles, se va a la entidad inmediatamente inferior
        // y se hace una búsqueda obteniendo el FK. Luego, se arma el DTOLIST. 
        // Para el nivel 4, se requiere hacer joinear dos tablas: ZON_TERR_ADMI
        // y ZON_TERR.
        
        UtilidadesLog.info("DAOZON.obtenerUAinferioresUA(Long oidUA, Integer nivelUA): Entrada");

        NivelUA nivel = new NivelUA();

        // Obtiene el nombre de la entidad 
        String sNombreTabla = nivel.obtenerEntidad(new Integer(nivelUA.intValue() +
                    1));
        UtilidadesLog.debug(sNombreTabla.toString());

        // Obtiene el nombre del campo de FK.
        String sFKName = nivel.obtenerNombreRelacion(new Integer(nivelUA.intValue() +
                    1));
        UtilidadesLog.debug(sFKName.toString());

        // Obtiene el nombre del campo de PK.
        String sPKName = nivel.obtenerNombreClave(new Integer(nivelUA.intValue() +
                    1));
        UtilidadesLog.debug(sPKName.toString());

        DTOLISTUniNSE dtoList = new DTOLISTUniNSE();

        StringBuffer SQL;
        BelcorpService bs;
        RecordSet r;

        if (nivelUA.intValue() < 4) {
            // Los tres primeros, 1, 2 y 3, no merecen tratamiento especial.
            SQL = new StringBuffer("SELECT " + sPKName.toString() + ",");
            SQL.append(" COD_NSE1, COD_NSE2, COD_NSE3 FROM " +
                sNombreTabla.toString());
            SQL.append(" WHERE " + sFKName.toString() + "=" + oidUA.toString());
            SQL.append(" AND IND_BORR=0 AND IND_ACTI=1");

            try {
                bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException ex) {
                throw new MareException(ex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            try {
                // Ejecuta la consulta.
                r = bs.dbService.executeStaticQuery(SQL.toString());
            } catch (Exception ex) {
                throw new MareException(ex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            UtilidadesLog.debug("Llamando a armaDTOLIST(r)");
            dtoList = armaDTOLIST(r);
        } else {
            // Para el nivel 4, hay que hacer un JOIN entre la tabla ZON_TERRI_ADMIN y ZON_TERRI
            // para obtener los NSE. 
            // Para esto, aparte de sNombreTabla, sPKName y sFKName hay que obtener dos datos
            // mas de la tabla ZON_TERRI: el nombre (sTablaNivel6) y su PK (sTablaNivel6PK).
            String sTablaNivel6 = nivel.obtenerEntidad(new Integer(6));
            String sTablaNivel6PK = nivel.obtenerNombreClave(new Integer(6));

            //SQL = new StringBuffer("SELECT " +  sPKName.toString() + "," );
            SQL = new StringBuffer("SELECT " + sTablaNivel6PK.toString() + ",");
            SQL.append(" COD_NSE1, COD_NSE2, COD_NSE2 FROM " +
                sNombreTabla.toString() + ", ");
            SQL.append(sTablaNivel6.toString());
            SQL.append(" WHERE " + sFKName.toString() + " = " +
                oidUA.toString());
            SQL.append(" AND " + sTablaNivel6PK.toString() + " = " +
                sPKName.toString());
            SQL.append(" AND " + sNombreTabla.toString() + ".IND_BORR=0 AND ");
            SQL.append(sTablaNivel6.toString() + ".IND_BORR=0");

            try {
                bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException ex) {
                throw new MareException(ex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            try {
                r = bs.dbService.executeStaticQuery(SQL.toString());
            } catch (Exception ex) {
                throw new MareException(ex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            dtoList = armaDTOLIST(r);
        }
        UtilidadesLog.info("DAOZON.obtenerUAinferioresUA(Long oidUA, Integer nivelUA): Salida");
        return dtoList;
    }

    public ArrayList obtenerSeccionesdeTerritorio(Long oidTerritorio)
        throws MareException {
        // Retorna una lista de oid correspondientes a las secciones a las que pertenece
        // el territorio.  
        
        UtilidadesLog.info("DAOZON.obtenerSeccionesdeTerritorio(Long oidTerritorio): Entrada");
        
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Genera la sentencia SQL.
        StringBuffer SQL = new StringBuffer(
                "SELECT TA.ZSCC_OID_SECC FROM ZON_TERRI_ADMIN TA, ZON_SECCI S WHERE ");
        SQL.append("TERR_OID_TERR=");
        SQL.append(oidTerritorio.toString());
        SQL.append(" AND TA.IND_BORR = 0 ");
        SQL.append(" AND S.IND_BORR = 0 ");
/* 
 * BELC300023160 - gPineda - 22/05/2006 
 *      SQL.append(" AND S.IND_ACTI = 1 ");
*/
        SQL.append(" AND TA.ZSCC_OID_SECC = S.OID_SECC ");

        RecordSet r;

        try {
            // Ejecuta la consulta.
            r = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        int nCantRegistros = r.getRowCount();
        ArrayList aList = new ArrayList(); // Se instancia como null por si la cant. de registros es vacío.
        BigDecimal d = null;

        if (nCantRegistros != 0) {
            // Guarda en aList los oid de las secciones que coinciden.
            for (int i = 0; i < nCantRegistros; i++) {
                d = (BigDecimal) r.getValueAt(i, 0);
                aList.add(new Long(d.longValue()));
            }
        }
        UtilidadesLog.info("DAOZON.obtenerSeccionesdeTerritorio(Long oidTerritorio): Salida");
        return aList;
    }

    public Long obtenerEstadoZonaCorrespondiente(Double MontoVenta,
        Integer NumPedidos, Integer NumConsultoras) throws Exception {
        
        UtilidadesLog.info("DAOZON.obtenerEstadoZonaCorrespondiente(Double MontoVenta, Integer NumPedidos, Integer NumConsultoras): Entrada");

        BelcorpService bs = BelcorpService.getInstance();

        StringBuffer SQL = new StringBuffer(
                "SELECT OID_ESTA_ZONA FROM ZON_ESTAD_ZONA WHERE");
        SQL.append(" IMPO_VENT_MINI<" + MontoVenta.toString());
        SQL.append(" AND NUM_PEDI_ZONA<" + NumPedidos.toString());
        SQL.append(" AND NUM_CONS_MIN<" + NumConsultoras.toString());

        //SQL.append(" AND IND_BORR=0 AND IND_ACTIVO=1;");
        RecordSet r = bs.dbService.executeStaticQuery(SQL.toString());
        
        UtilidadesLog.debug("r.toString(): " + r.toString());

        if (r != null) {
            if (r.getRowCount() > 0) {

                BigDecimal d = (BigDecimal) r.getValueAt(0, 0); // Solo se retorna el primero encontrado.
                UtilidadesLog.info("DAOZON.obtenerEstadoZonaCorrespondiente(Double MontoVenta,Integer NumPedidos, Integer NumConsultoras): Salida");
                return new Long(d.longValue());
            } else {
                UtilidadesLog.info("DAOZON.obtenerEstadoZonaCorrespondiente(Double MontoVenta,Integer NumPedidos, Integer NumConsultoras): Salida");
                return null;
            }
        } else {
            UtilidadesLog.debug("r es null");
            UtilidadesLog.info("DAOZON.obtenerEstadoZonaCorrespondiente(Double MontoVenta,Integer NumPedidos, Integer NumConsultoras): Salida");
        }
        
        return null;
    }

    public Long consultarNumUG(Long oidPais) throws MareException {
    
        UtilidadesLog.info("DAOZON.consultarNumUG(Long oidPais): Entrada");

        Long nReturnValue = null;
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        StringBuffer SQL = new StringBuffer(
                "SELECT COUNT(*) FROM ZON_VALOR_ESTRU_GEOPO");
        SQL.append(" WHERE PAIS_OID_PAIS=" + oidPais.toString());
        SQL.append(" AND IND_BORR=0 AND IND_ACTI=1");

        RecordSet r;

        try {
            // Ejecuta la consulta.
            r = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        BigDecimal d = (BigDecimal) r.getValueAt(0, 0);
        UtilidadesLog.debug("Valor de d: " + d.toString());
        nReturnValue = new Long(d.longValue());
        UtilidadesLog.debug("Return Value: " + nReturnValue.toString());
        UtilidadesLog.info("DAOZON.consultarNumUG(Long oidPais): Salida");
        return nReturnValue;
    }

    public void borradoLogicoEG(Long oidPais) throws MareException {
    
        UtilidadesLog.info("DAOZON.borradoLogicoEG(Long oidPais): Entrada");

        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        StringBuffer SQL = new StringBuffer(
                "UPDATE ZON_ESTRU_GEOPO SET IND_BORR=1 , FEC_ACTU = SYSDATE " );
        SQL.append(" WHERE PAIS_OID_PAIS=" + oidPais.toString());

        try {
            // Ejecuta la consulta.
            int updateValue = bs.dbService.executeUpdate(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOZON.borradoLogicoEG(Long oidPais): Salida");
        return;
    }

    public Long obtenerNivelesEstructuraGeoPolitica(Long oidPais)
        throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerNivelesEstructuraGeoPolitica(Long oidPais): Entrada");

        Long nReturnValue = null;
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        StringBuffer SQL = new StringBuffer(
                "SELECT COUNT(*) FROM ZON_ESTRU_GEOPO");
        SQL.append(" WHERE PAIS_OID_PAIS=" + oidPais.toString());
        SQL.append(" AND IND_BORR=0");

        RecordSet r;

        try {
            // Ejecuta la consulta.
            r = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            UtilidadesLog.debug(ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        BigDecimal d = (BigDecimal) r.getValueAt(0, 0);
        UtilidadesLog.debug("Valor de d: " + d.toString());
        nReturnValue = new Long(d.longValue());
        UtilidadesLog.debug("Return Value: " + nReturnValue.toString());
        UtilidadesLog.info("DAOZON.obtenerNivelesEstructuraGeoPolitica(Long oidPais): Salida");
        return nReturnValue;
    }

    /**
    * Este metodo realiza la consulta para determinar que exista
    * las entidades necesarias de la unidad administrativa.
    * Retorna el Oid, correspondiente a la entidad que se consulta.
    * Si el registro a buscar no se encuentra, entonces se retorna -1.
    * */
    public Long obtenerUAporcodigo(Long oidMarca, Long oidCanal, Long oidPais,
        String codsgv, String codRegion, String codZona, String codSeccion,
        String codTer) throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerUAporcodigo(Long oidMarca, Long oidCanal, Long oidPais, String codsgv, String codRegion, String codZona, String codSeccion, String codTer): Entrada");
        
        BigDecimal result;
        BelcorpService belcorpService;
        RecordSet respuestaRecordSet = null;
        Vector parametros = new Vector();

        StringBuffer stringBuffer = null;

        try {
            belcorpService = BelcorpService.getInstance();

            if (checkStr(codSeccion) && checkStr(codZona) &&
                    checkStr(codRegion) && checkStr(codsgv) &&
                    checkStr(codTer)) {
                //Chequeo sobre CodSGV,Region,Zona,Seccion. Para Territorio
                stringBuffer = new StringBuffer("SELECT T.OID_TERR as UA");
                stringBuffer.append(
                    " FROM ZON_SUB_GEREN_VENTA SGV, ZON_REGIO R, ZON_ZONA Z, ZON_SECCI S, ZON_TERRI T, ZON_TERRI_ADMIN TA ");
                stringBuffer.append(" WHERE ");
                stringBuffer.append(" SGV.CANA_OID_CANA = " +
                    oidCanal.toString());
                stringBuffer.append(" AND SGV.MARC_OID_MARC = " +
                    oidMarca.toString());
                stringBuffer.append(" AND SGV.PAIS_OID_PAIS = " +
                    oidPais.toString());
                stringBuffer.append(" AND SGV.COD_SUBG_VENT = '" + codsgv +
                    "' ");
                stringBuffer.append(" AND R.COD_REGI = '" + codRegion + "' ");
                stringBuffer.append(" AND Z.COD_ZONA = '" + codZona + "' ");
                stringBuffer.append(" AND S.COD_SECC = '" + codSeccion + "' ");
                stringBuffer.append(" AND T.COD_TERR = '" + codTer + "' ");
                stringBuffer.append(
                    " AND R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                stringBuffer.append(" AND Z.ZORG_OID_REGI = R.OID_REGI ");
                stringBuffer.append(" AND S.ZZON_OID_ZONA = Z.OID_ZONA ");
                stringBuffer.append(" AND TA.ZSCC_OID_SECC = S.OID_SECC ");
                stringBuffer.append(" AND TA.TERR_OID_TERR = T.OID_TERR ");                
                stringBuffer.append(" AND SGV.IND_BORR = 0 ");
                stringBuffer.append(" AND R.IND_BORR = 0 ");
                stringBuffer.append(" AND Z.IND_BORR = 0 ");
                stringBuffer.append(" AND S.IND_BORR = 0 ");
                stringBuffer.append(" AND T.IND_BORR = 0 ");
                stringBuffer.append(" AND TA.IND_BORR = 0 ");
                
                respuestaRecordSet = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
            } else if (checkStr(codSeccion) && checkStr(codZona) &&
                    checkStr(codRegion) && checkStr(codsgv)) {
                //Chequeo sobre CodSGV,Region,Zona,Seccion. Para Territorio
                stringBuffer = new StringBuffer("SELECT S.OID_SECC as UA");
                stringBuffer.append(
                    " FROM ZON_SUB_GEREN_VENTA SGV, ZON_REGIO R, ZON_ZONA Z, ZON_SECCI S");
                stringBuffer.append(" WHERE ");
                stringBuffer.append(" SGV.CANA_OID_CANA = " +
                    oidCanal.toString());
                stringBuffer.append(" AND SGV.MARC_OID_MARC = " +
                    oidMarca.toString());
                stringBuffer.append(" AND SGV.PAIS_OID_PAIS = " +
                    oidPais.toString());
                stringBuffer.append(" AND SGV.COD_SUBG_VENT = '" + codsgv +
                    "' ");
                stringBuffer.append(" AND R.COD_REGI = '" + codRegion + "' ");
                stringBuffer.append(" AND Z.COD_ZONA = '" + codZona + "' ");
                stringBuffer.append(" AND S.COD_SECC = '" + codSeccion + "' ");
                stringBuffer.append(
                    " AND R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                stringBuffer.append(" AND Z.ZORG_OID_REGI = R.OID_REGI ");
                stringBuffer.append(" AND S.ZZON_OID_ZONA = Z.OID_ZONA ");
                stringBuffer.append(" AND SGV.IND_BORR = 0 ");
                stringBuffer.append(" AND R.IND_BORR = 0 ");
                stringBuffer.append(" AND Z.IND_BORR = 0 ");
                stringBuffer.append(" AND S.IND_BORR = 0 ");
                
                respuestaRecordSet = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
            } else if (checkStr(codsgv) && checkStr(codRegion) &&
                    checkStr(codZona)) {
                //Chequeo sobre codSgv,Region,Zona. Para Seccion
                stringBuffer = new StringBuffer("SELECT Z.OID_ZONA as UA");
                stringBuffer.append(
                    " FROM ZON_SUB_GEREN_VENTA SGV, ZON_REGIO R, ZON_ZONA Z");
                stringBuffer.append(" WHERE ");
                stringBuffer.append(" SGV.CANA_OID_CANA = " +
                    oidCanal.toString());
                stringBuffer.append(" AND SGV.MARC_OID_MARC = " +
                    oidMarca.toString());
                stringBuffer.append(" AND SGV.PAIS_OID_PAIS = " +
                    oidPais.toString());
                stringBuffer.append(" AND SGV.COD_SUBG_VENT = '" + codsgv +
                    "' ");
                stringBuffer.append(" AND R.COD_REGI = '" + codRegion + "' ");
                stringBuffer.append(" AND Z.COD_ZONA = '" + codZona + "' ");
                stringBuffer.append(
                    " AND R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                stringBuffer.append(" AND Z.ZORG_OID_REGI = R.OID_REGI ");
                stringBuffer.append(" AND SGV.IND_BORR = 0 ");
                stringBuffer.append(" AND R.IND_BORR = 0 ");
                stringBuffer.append(" AND Z.IND_BORR = 0 ");
                
                respuestaRecordSet = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
            } else if (checkStr(codsgv) && checkStr(codRegion)) {
                //Chequeo sobre codSgv,Region. Para Zona.
                stringBuffer = new StringBuffer("SELECT R.OID_REGI as UA");
                stringBuffer.append(
                    " FROM ZON_SUB_GEREN_VENTA SGV, ZON_REGIO R");
                stringBuffer.append(" WHERE  ");
                stringBuffer.append(" SGV.CANA_OID_CANA = " +
                    oidCanal.toString());
                stringBuffer.append(" AND SGV.MARC_OID_MARC = " +
                    oidMarca.toString());
                stringBuffer.append(" AND SGV.PAIS_OID_PAIS = " +
                    oidPais.toString());
                stringBuffer.append(" AND SGV.COD_SUBG_VENT = '" + codsgv +
                    "' ");
                stringBuffer.append(" AND R.COD_REGI = '" + codRegion + "' ");
                stringBuffer.append(
                    " AND R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                stringBuffer.append(" AND SGV.IND_BORR = 0 ");
                stringBuffer.append(" AND R.IND_BORR = 0 ");
                
                respuestaRecordSet = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
            } else if (checkStr(codsgv)) {
                //Chequeo sobre codSgv. Para Region
                stringBuffer = new StringBuffer(
                        "SELECT SGV.OID_SUBG_VENT as UA");
                stringBuffer.append(" FROM ZON_SUB_GEREN_VENTA SGV");
                stringBuffer.append(" WHERE ");
                stringBuffer.append(" SGV.CANA_OID_CANA = " +
                    oidCanal.toString());
                stringBuffer.append(" AND SGV.MARC_OID_MARC = " +
                    oidMarca.toString());
                stringBuffer.append(" AND SGV.PAIS_OID_PAIS = " +
                    oidPais.toString());
                stringBuffer.append(" AND SGV.COD_SUBG_VENT = '" + codsgv + "' ");
                stringBuffer.append(" AND SGV.IND_BORR = 0 ");
                
                respuestaRecordSet = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
            }
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuestaRecordSet.esVacio()) {
            UtilidadesLog.info("DAOZON.obtenerUAporcodigo(Long oidMarca, Long oidCanal, Long oidPais, String codsgv, String codRegion, String codZona, String codSeccion, String codTer): Salida");
            return null;
        } else {
            result = (BigDecimal) respuestaRecordSet.getValueAt(0, "UA");
        }
        UtilidadesLog.info("DAOZON.obtenerUAporcodigo(Long oidMarca, Long oidCanal, Long oidPais, String codsgv, String codRegion, String codZona, String codSeccion, String codTer): Salida");
        return new Long(result.longValue());
    }

    private DTOLISTUniNSE armaDTOLIST(RecordSet r) {
        // Recibe un RecordSet de fomato (oid, NSE1, NSE2, NSE3). 
        // Si este RecordSet no posee registros, devuelve un DTOLISTUniNSE null. 
        // Si posee 1 o más tuplas, entonces forma por cada tupla un DTOUniNSE
        // y lo agrega a un Arralist que finalmente lo agrega a un
        // DTOLISTUniNSE.
        
        UtilidadesLog.info("DAOZON.armaDTOLIST(RecordSet r): Entrada");
        
        DTOUniNSE dtoNSE;
        DTOLISTUniNSE dtoNSEList = new DTOLISTUniNSE();
        ArrayList aList = null;
        BigDecimal bigD = null;
        String NSE = null;

        UtilidadesLog.debug("RecordSet de entrada: " + r.toString());

        int nCantRegistros = r.getRowCount();

        if (nCantRegistros != 0) {
            aList = new ArrayList(nCantRegistros);

            for (int i = 0; i < nCantRegistros; i++) {
                UtilidadesLog.debug("REGISTRO " + i);
                dtoNSE = new DTOUniNSE();

                bigD = (BigDecimal) r.getValueAt(i, 0);
                UtilidadesLog.debug("Valor oidUni: " + bigD.toString());
                dtoNSE.setOidUni(new Long(bigD.toString()));

                //bigD = (BigDecimal) r.getValueAt(i,1); 
                NSE = (String) r.getValueAt(i, 1);
                UtilidadesLog.debug("Valor NSE1: " + NSE);
                dtoNSE.setNSE1(NSE);

                NSE = (String) r.getValueAt(i, 2);
                UtilidadesLog.debug("Valor NSE2: " + NSE);
                dtoNSE.setNSE2(NSE);

                NSE = (String) r.getValueAt(i, 3);
                UtilidadesLog.debug("Valor NSE3: " + NSE);
                dtoNSE.setNSE3(NSE);

                // dtoNSE.setOidUni( (Long) r.getValueAt(i,0) ); // Tomaria el oidUni?
                // dtoNSE.setNSE1( (String) r.getValueAt(i,1) ); // Tomaría la NSE1?
                // dtoNSE.setNSE2( (String) r.getValueAt(i,2) ); // Tomaría la NSE2?
                // dtoNSE.setNSE3( (String) r.getValueAt(i,3) ); // Tomaría la NSE2?      
                aList.add(dtoNSE);
            }

            dtoNSEList.setArrayDTOUniNSE(aList);
        }
        UtilidadesLog.info("DAOZON.armaDTOLIST(RecordSet r): Salida");
        return dtoNSEList;
    }

    public DTOUnidadAdministrativa obtenerUnidadAdministrativa(Long marca,
        Long pais, Long canal, Long territorio, Long zona)
        throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerUnidadAdministrativa(Long marca, Long pais, Long canal, Long territorio, Long zona): Entrada");
        
        /*Si es un territorio entoces la unidad administrativa va desde SGV hasta territorio,
        si se recibe la zona entonces la unidad administrativa va desde SVG hasta ZONA*/
        String codigoError;
        RecordSet respuesta;
        BelcorpService bs;
        StringBuffer buf = new StringBuffer();
        DTOUnidadAdministrativa dtos = new DTOUnidadAdministrativa();
        Long sgv = null;
        Long region = null;
        Long seccion = null;
        Long territorioAdm = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            if (territorio != null) {
                buf.append("select SGV.OID_SUBG_VENT, R.OID_REGI, ");
                buf.append(" S.OID_SECC, TA.OID_TERR_ADMI, Z.OID_ZONA ");
                buf.append(
                    " from ZON_SUB_GEREN_VENTA SGV, ZON_REGIO R, ZON_ZONA Z, ");
                buf.append(" ZON_SECCI S, ZON_TERRI_ADMIN TA, ZON_TERRI T ");
                buf.append(" where ");
                buf.append(" SGV.OID_SUBG_VENT = R.ZSGV_OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and Z.OID_ZONA = S.ZZON_OID_ZONA ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and TA.TERR_OID_TERR = T.OID_TERR ");
                buf.append(" and T.OID_TERR = " + territorio);
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if (zona != null) {
                buf.append("select SGV.OID_SUBG_VENT, R.OID_REGI ");
                buf.append(
                    " from ZON_SUB_GEREN_VENTA SGV, ZON_REGIO R, ZON_ZONA Z ");
                buf.append(" where ");
                buf.append(" SGV.OID_SUBG_VENT = R.ZSGV_OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and Z.OID_ZONA = " + zona);
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_borr = 0 ");
            } else {
                codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
                throw new MareException(null, null,
                    UtilidadesError.armarCodigoError(codigoError));
            }

            if (pais != null) {
                buf.append(" and SGV.PAIS_OID_PAIS = " + pais);
            }

            if (marca != null) {
                buf.append(" and SGV.MARC_OID_MARC = " + marca);
            }

            if (canal != null) {
                buf.append(" and SGV.CANA_OID_CANA = " + canal);
            }

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.debug("respuesta: " + respuesta);

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOZON.obtenerUnidadAdministrativa(Long marca, Long pais, Long canal, Long territorio, Long zona): Salida");
            return null;
        }

        if (territorio != null) {
            sgv = new Long(((BigDecimal) respuesta.getValueAt(0, "OID_SUBG_VENT")).intValue());
            region = new Long(((BigDecimal) respuesta.getValueAt(0, "OID_REGI")).intValue());
            zona = new Long(((BigDecimal) respuesta.getValueAt(0, "OID_ZONA")).intValue());
            seccion = new Long(((BigDecimal) respuesta.getValueAt(0, "OID_SECC")).intValue());
            territorioAdm = new Long(((BigDecimal) respuesta.getValueAt(0,
                        "OID_TERR_ADMI")).intValue());
        } else {
            sgv = new Long(((BigDecimal) respuesta.getValueAt(0, "OID_SUBG_VENT")).intValue());
            region = new Long(((BigDecimal) respuesta.getValueAt(0, "OID_REGI")).intValue());
        }

        dtos.setOidPais(pais);
        dtos.setOidMarca(marca);
        dtos.setOidCanal(canal);
        dtos.setOidTerritorio(territorio);
        dtos.setOidZona(zona);
        dtos.setOidSGV(sgv);
        dtos.setOidRegion(region);
        dtos.setOidSeccion(seccion);
        dtos.setOidTerritorioAdministrativo(territorioAdm);
        
        UtilidadesLog.debug("dtos: " + dtos);
        
        UtilidadesLog.info("DAOZON.obtenerUnidadAdministrativa(Long marca, Long pais, Long canal, Long territorio, Long zona): Salida");
        return dtos;
    }

    //metodo que obtiene el oid de del UBIGEO recibido por parametro
    public Long obtenerUniGeoPorUBIGEO(String ubigeo, Long pais)
        throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerUniGeoPorUBIGEO(String ubigeo, Long pais): Entrada");
        
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        StringBuffer query = new StringBuffer();
        UtilidadesLog.debug("ubigeo " + ubigeo);

        try {
            bs = BelcorpService.getInstance();
        } catch (Exception re) {
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        query.append(" select OID_VALO_ESTR_GEOP ");
        query.append(" from ZON_VALOR_ESTRU_GEOPO a ");
        query.append(armarWhereStr(ubigeo));
        query.append(" and PAIS_OID_PAIS = " + pais);
        query.append(" and IND_BORR = 0 ");

        try {
            resultado = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado    " + resultado.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (resultado.esVacio()) {
            UtilidadesLog.info("DAOZON.obtenerUniGeoPorUBIGEO(String ubigeo, Long pais): Salida");
            return null;
        } else {
            Vector idResultado = resultado.getColumn(0);
            UtilidadesLog.info("DAOZON.obtenerUniGeoPorUBIGEO(String ubigeo, Long pais): Salida");
            return new Long(((BigDecimal) idResultado.elementAt(0)).longValue());
        }
    }

    //fin metodo
    //este metodo me devuelve where que pregunta por los parametros no nulos y los nulos!
    private String armarWhereStr(String ubigeo) {
    
        UtilidadesLog.info("DAOZON.armarWhereStr(String ubigeo): Entrada");
        
        String[] ubigeoArray = new String[9];
        int resto = (ubigeo.length() % 6);

        if ((ubigeo.length() >= 6) && (ubigeo.length() <= 54) && (resto == 0) &&
                (ubigeo != null)) {
            int a = 0;

            for (int i = 0; i < ubigeo.length(); i++) {
                ubigeoArray[a] = ubigeo.substring(i, i + 6);
                i = i + 5;
                a = a + 1;
            }

            if (a < 9) {
                for (int i = a; i < 9; i++)
                    ubigeoArray[i] = null;
            }

            StringBuffer query = new StringBuffer();
            String[] camposWhere = new String[] {
                    "orde_1", "orde_2", "orde_3", "orde_4", "orde_5", "orde_6",
                    "orde_7", "orde_8", "orde_9"
                };

            Object[] valoresWhere = new Object[] {
                    ubigeoArray[0], ubigeoArray[1], ubigeoArray[2],
                    ubigeoArray[3], ubigeoArray[4], ubigeoArray[5],
                    ubigeoArray[6], ubigeoArray[7], ubigeoArray[8]
                };
            boolean[] operadores = new boolean[] {
                    false, false, false, false, false, false, false, false,
                    false
                };

            if (ubigeo.length() > 0) {
                /*
                 * Armamos where de los campos not null
                 */
                query.append(UtilidadesBD.armarSQLWhere(camposWhere,
                        valoresWhere, operadores));

                /*
                 * buscamos el primer orden !=nulo
                 */
                for (int i = 0; i < valoresWhere.length; i++) {
                    if (valoresWhere[i] == null) {
                        query.append(" and " + camposWhere[i] + " is null ");
                        UtilidadesLog.debug("camposWhere[i]   " + i + "  " +
                            camposWhere[i] + " valoresWhere " +
                            valoresWhere.toString());
                    }
                }
            }
            UtilidadesLog.info("Salida : query.toString()" + query.toString());
            UtilidadesLog.info("DAOZON.armarWhereStr(String ubigeo): Salida");
            return query.toString();
        } //fin del if donde valida tamaño del ubigeo
        else {
            /*throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(ErroresDeNegocio.UBIGEO_NO_EXISTE_PARA_TERRITORIO));
            */
            UtilidadesLog.info("DAOZON.armarWhereStr(String ubigeo): Salida");
            return null;
        }
    }

    public Long obtenerUnidadGeoSuperior(Long oidUG) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerUnidadGeoSuperior(Long oidUG): Entrada");

        String ubigeoStr = new String();
        StringBuffer query = new StringBuffer("SELECT ");
        BelcorpService bs = null;
        int i = 1;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        for (i = 1; i < 10; i++) {
            query.append("ORDE_" + i);

            //           if (i != 9)
            query.append(", ");
        }

        query.append("PAIS_OID_PAIS ");
        query.append(" FROM ZON_VALOR_ESTRU_GEOPO WHERE OID_VALO_ESTR_GEOP = " +
            oidUG);
        UtilidadesLog.debug("Query: " + query.toString());

        RecordSet r = new RecordSet();

        try {
            // Obtiene la tupla (los 9 campos de orden) con clave primaria según oidUG.           
            r = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("Respuesta: " + r.toString());

        int nIndiceNivelPadre;

        if (r.getRowCount() > 0) // Se encontró un registro. 
         {
            // Se fija cuál es el último nivel de orden con valor no NULO
            // y obtiene el índice de ese nivel. 
            // NOTA: i queda apuntando a la columna con VALOR NULO.
            boolean bBreak = false;
            i = 0;

            while ((bBreak == false) && (i < 9)) // Se limita para evitar contar PAIS_OID_PAIS.
             {
                if (r.getValueAt(0, i) == null) {
                    bBreak = true;
                } else {
                    i++;
                }
            }

            UtilidadesLog.debug("Columna con valor nulo: " + i);

            BigDecimal bigValue = null;

            if (i <= 1) {
                // ORDE_2 es NULO, asi que el unico valor que existe está
                // en ORDE_1 <---- Es el PADRE, no hay superior, 
                // entonces devuelve NULL.
                // Chequea por si es menor que 1 en el caso de que en la base
                // haya datos "malos" y esten todos los orde_x en NULL
                // (no se deberia dar nunca, pero...)
                UtilidadesLog.debug("O bien es nivel mas alto de la jerarquia, ");
                UtilidadesLog.debug("o son todos nulos <-- No deberia pasar");
                UtilidadesLog.debug("Devuelve NULL");

                return null;
            } else {
                // El índice del nivel padre es i-2, ya que si por ej, el nulo
                // es orde_7, orde_6 contiene el valor de ultimo
                // nivel de jerarquía, y orde_5 seria el padre (i-2).
                nIndiceNivelPadre = i - 2;
                UtilidadesLog.debug("Indice de Nivel del Padre: " +
                    nIndiceNivelPadre);
            }

            // Arma la query para obtener el oid del padre inmediato.
            // Se necesita tan sólo dos cosas: el valor de campos anteriores
            // y poner a null el nivel de orden inmediatamente inferior 
            // al campo padre. 
            // Por ejemplo: 
            //  
            //  SELECT OID_VALO_ESTR_GEOP FROM ZON_VALOR_ESTRU_GEOPO WHERE
            // ORDE_1 = "AA" ANd ORDE_2 = "BB AND ORDE_3 = "CC"
            //  ORDE_4 = "1234" AND ORDE_5 IS NULL AND PAIS_OID_PAIS=1
            // 
            //  Traería el OID para el padre con valor "1234".
            //  (en este caso, la entrada del método fue un oid 
            //  de nivel ORDE_5 (por ejemplo, ORDE_5 = xxxx).
            UtilidadesLog.debug(
                "** Arma la query para obtener el oid del padre **");

            BigDecimal bigPais = (BigDecimal) r.getValueAt(0, 9);

            //int j = i+1;
            UtilidadesLog.debug("Pais a tener en cuenta: " + bigPais.toString());
            query = new StringBuffer("SELECT OID_VALO_ESTR_GEOP FROM ");
            query.append("ZON_VALOR_ESTRU_GEOPO WHERE ");

            int n = 0;

            for (int k = 0; k <= nIndiceNivelPadre; k++) {
                n = k + 1;

                String sValue = (String) r.getValueAt(0, k);
                query.append("ORDE_" + n);
                query.append("='" + sValue.toString() + "' AND ");
            }

            //query.append("ORDE_" + i + "='" + bigValue.toString() + "' AND ");
            n++;
            query.append("ORDE_" + n + " IS NULL AND PAIS_OID_PAIS=" +
                bigPais.toString());

            //query.append("ORDE_" + j +" IS NULL AND PAIS_OID_PAIS=" + bigPais.toString());
            try {
                // Obtiene el oid del padre (valor del padre).
                UtilidadesLog.debug(
                    "Obtiene el OID de la tupla con el padre absoluto");
                r = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            UtilidadesLog.debug("Valor de R de tupla de padre: " + r.toString());

            BigDecimal valorRetorno = (BigDecimal) r.getValueAt(0, 0);
            UtilidadesLog.info("DAOZON.obtenerUnidadGeoSuperior(Long oidUG): Salida");
            return new Long(valorRetorno.longValue());
        } else {
            // No hay tuplas con el OID pasado como parametro. 
            ; // Aca tira error, tira null o algo asi. 
        }
        UtilidadesLog.info("DAOZON.obtenerUnidadGeoSuperior(Long oidUG): Salida");
        return null;
    }

    //metodo que arma el where de los ubigeos recibidos
    private String armarWhere2(String[] ubigeoArray) {
    
        UtilidadesLog.info("DAOZON.armarWhere2(String[] ubigeoArray): Entrada");
        
        StringBuffer query = new StringBuffer();
        String[] camposWhere = new String[] {
                "orde_1", "orde_2", "orde_3", "orde_4", "orde_5", "orde_6",
                "orde_7", "orde_8", "orde_9"
            };
        Object[] valoresWhere = new Object[ubigeoArray.length];

        for (int i = 0; i < ubigeoArray.length; i++) {
            valoresWhere[i] = ubigeoArray[i];
        }

        boolean[] operadores = new boolean[] {
                false, false, false, false, false, false, false, false, false
            };

        /*
         * Armamos where de los campos not null
         */
        query.append(UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere,
                operadores));
                
        UtilidadesLog.info("DAOZON.armarWhere2(String[] ubigeoArray): Salida");
        return query.toString();
    }

    public Long[] buscarVias(String nombre, Long oidPais, Long oidTipoVia)
        throws MareException {
        
        UtilidadesLog.info("DAOZON.buscarVias(String nombre, Long oidPais, Long oidTipoVia): Entrada");
        
        /*
         * Realiza una consulta sobre la entidad ZON:VIA filtrando por oidPais, nombre
         * (que puede usar un comodin) y oidTipo de Via.
            Esta busqueda debe filtrar que la via este activa.
            retorn un arreglo de Longs con los oid de las vias encontradas.
         * */
        StringBuffer query = new StringBuffer();

        query.append(" select OID_VIA ");
        query.append("   from ZON_VIA");
        query.append("  where PAIS_OID_PAIS = " + oidPais.toString());
        query.append("    and IND_ACTI_VIA = 1 ");
        query.append("    and NOM_VIA like '" + nombre + "' ");
        query.append("    and TIVI_OID_TIPO_VIA = " + oidTipoVia);

        try {
            RecordSet r = new RecordSet();
            BelcorpService bs;
            bs = BelcorpService.getInstance();
            r = bs.dbService.executeStaticQuery(query.toString());
            int cantVias = r.getRowCount();
            Long[] via = new Long[cantVias];

            for (int i = 0; i < cantVias; i++) {
                //via[i] = new Long(((BigDecimal) r.getValueAt(0, i)).longValue());
                via[i] = new Long(((BigDecimal) r.getValueAt(i, 0)).longValue());  // DBLG700000169
            }
            UtilidadesLog.info("DAOZON.buscarVias(String nombre, Long oidPais, Long oidTipoVia): Salida");
            return via;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public Long obtenerTerritorioAdministrativo(Long oidMarca, Long oidCliente)
        throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerTerritorioAdministrativo(Long oidMarca, Long oidCliente): Entrada");

        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Genera la sentencia SQL.
        StringBuffer SQL = new StringBuffer();
        SQL.append(" SELECT zt.OID_TERR_ADMI ");
        SQL.append(
            " FROM mae_clien_unida_admin mc, zon_terri_admin zt, ZON_SECCI zc, ");
        SQL.append(
            "           ZON_ZONA zz, ZON_REGIO zr, ZON_SUB_GEREN_VENTA zsgv ");
        SQL.append(" WHERE mc.ZTAD_OID_TERR_ADMI = zt.OID_TERR_ADMI ");
        SQL.append(" AND zt.ZSCC_OID_SECC = zc.OID_SECC ");
        SQL.append(" AND zc.ZZON_OID_ZONA = zz.OID_ZONA ");
        SQL.append(" AND zz.ZORG_OID_REGI = zr.OID_REGI ");
        SQL.append(" AND zr.ZSGV_OID_SUBG_VENT = zsgv.OID_SUBG_VENT ");
        SQL.append(" AND mc.IND_ACTI = 1 ");
        SQL.append(" AND mc.clie_oid_clie = " + oidCliente);
        SQL.append(" AND zsgv.MARC_OID_MARC = " + oidMarca);

        RecordSet r;

        try {
            // Ejecuta la consulta.
            r = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        int nCantRegistros = r.getRowCount();
        Long oidTA;

        if (nCantRegistros == 0) {
            oidTA = null;
        } else if (nCantRegistros == 1) {
            oidTA = new Long(((BigDecimal) r.getValueAt(0, 0)).toString());
        } else {
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "",
                    ErroresDeNegocio.JERARQUIA_ADMINISTRATIVA_NO_UNICA));
        }
        UtilidadesLog.info("DAOZON.obtenerTerritorioAdministrativo(Long oidMarca, Long oidCliente): Salida");
        return oidTA;
    }

    public RecordSet obtenerSeccionesPorZona(Long marca, Long canal, Long pais)
        throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerSeccionesPorZona(Long marca, Long canal, Long pais): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("select distinct Z.OID_ZONA, S.OID_SECC, S.DES_SECCI ");

            buf.append(
                " from ZON_REGIO R, ZON_ZONA Z, ZON_SUB_GEREN_VENTA SGV, ZON_SECCI S ");

            String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {
                        "SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC",
                        "SGV.PAIS_OID_PAIS"
                    }, new Object[] { canal, marca, pais },
                    new boolean[] { false, false, false, false });

            if (sqlWhere == "") {
                buf.append(" WHERE ");
            } else {
                buf.append(sqlWhere);
                buf.append(" AND ");
            }

            buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
            buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
            buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
            buf.append(" and sgv.ind_acti = 1 ");
            buf.append(" and sgv.ind_borr = 0 ");
            buf.append(" and r.ind_acti = 1 ");
            buf.append(" and r.ind_borr = 0 ");
            buf.append(" and z.ind_acti = 1 ");
            buf.append(" and z.ind_borr = 0 ");
            buf.append(" and s.ind_acti = 1 ");
            buf.append(" and s.ind_borr = 0 ");

            buf.append(" ORDER BY S.DES_SECCI");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOZON.obtenerSeccionesPorZona(Long marca, Long canal, Long pais): Salida");
        return respuesta;
    }

    public RecordSet obtenerTerritoriosPorSeccion(Long marca, Long canal,
        Long pais) throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerTerritoriosPorSeccion(Long marca, Long canal,Long pais): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(
                "select distinct S.OID_SECC, TA.TERR_OID_TERR, T.COD_TERR ");

            buf.append(
                " from ZON_TERRI T, ZON_TERRI_ADMIN TA, ZON_REGIO R, ZON_ZONA Z, ZON_SUB_GEREN_VENTA SGV, ZON_SECCI S ");

            String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {
                        "SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC",
                        "SGV.PAIS_OID_PAIS"
                    }, new Object[] { canal, marca, pais },
                    new boolean[] { false, false, false, false });

            if (sqlWhere == "") {
                buf.append(" WHERE ");
            } else {
                buf.append(sqlWhere);
                buf.append(" AND ");
            }

            buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
            buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
            buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
            buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
            buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
            buf.append(" and sgv.ind_acti = 1 ");
            buf.append(" and sgv.ind_borr = 0 ");
            buf.append(" and r.ind_acti = 1 ");
            buf.append(" and r.ind_borr = 0 ");
            buf.append(" and z.ind_acti = 1 ");
            buf.append(" and z.ind_borr = 0 ");
            buf.append(" and s.ind_acti = 1 ");
            buf.append(" and s.ind_borr = 0 ");
            buf.append(" and t.ind_borr = 0 ");
            buf.append(" and ta.ind_borr = 0 ");

            buf.append(" ORDER BY T.COD_TERR ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOZON.obtenerTerritoriosPorSeccion(Long marca, Long canal, Long pais): Salida");
        return respuesta;
    }

    public RecordSet obtenerRegionesPorSGV(Long marca, Long canal, Long pais)
        throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerRegionesPorSGV(Long marca, Long canal, Long pais): Entrada");
        
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer query = new StringBuffer();
        RecordSet r = new RecordSet();

        //
        query.append(" SELECT z.zsgv_oid_subg_vent, z.oid_regi, z.des_regi, z.cod_regi "); 
        query.append(" FROM zon_regio z, zon_sub_geren_venta subgv ");
        query.append(" WHERE z.ind_acti = 1 AND z.ind_borr = 0 ");
        query.append(" AND subgv.ind_acti = 1 AND subgv.ind_borr = 0 ");
        query.append(" AND subgv.OID_SUBG_VENT = z.ZSGV_OID_SUBG_VENT ");

        // Alguno de los tres parametros de entrada debe ser SIEMPRE
        // distinto de NULL. 
        if (marca != null) {
            query.append(" AND subgv.MARC_OID_MARC = " + marca.toString());
        }

        if (canal != null) {
            query.append(" AND subgv.CANA_OID_CANA = " + canal.toString());
        }

        if (pais != null) {
            query.append(" AND subgv.PAIS_OID_PAIS = " + pais.toString());
        }
        
        //gacevedo, segun incidencia SiCC 20070095
        query.append(" ORDER BY des_regi");
        
        try {
            r = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOZON.obtenerRegionesPorSGV(Long marca, Long canal, Long pais): Salida");
        return r;
    }

    public RecordSet obtenerZonasPorRegiones(Long marca, Long canal, Long pais)
        throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerZonasPorRegiones(Long marca, Long canal, Long pais): Entrada");
        
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer query = new StringBuffer();
        RecordSet r = new RecordSet();

        query.append(" SELECT z.oid_zona, z.zorg_oid_regi, z.des_zona, ");
        query.append(" subgv.MARC_OID_MARC MARCA, subgv.CANA_OID_CANA CANAL, z.cod_zona ");
        query.append(" FROM zon_zona z, zon_regio r, zon_sub_geren_venta subgv ");
        query.append(" WHERE z.ind_acti = 1 AND z.ind_borr = 0 ");
        query.append(" AND r.IND_ACTI = 1 AND r.IND_BORR = 0 ");
        query.append(" AND subgv.IND_ACTI = 1 AND subgv.IND_BORR = 0 ");
        query.append(" AND r.oid_regi = z.zorg_oid_regi ");
        query.append(" AND r.zsgv_oid_subg_vent = subgv.oid_subg_vent ");

        // Alguno de los tres parametros de entrada debe ser SIEMPRE
        // distinto de NULL.       
        if (canal != null) {
            query.append(" AND subgv.cana_oid_cana = " + canal.toString());
        }

        if (pais != null) {
            query.append(" AND subgv.pais_oid_pais = " + pais.toString());
        }

        if (marca != null) {
            query.append(" AND subgv.marc_oid_marc = " + marca.toString());
        }
        query.append(" ORDER BY z.des_zona ");

        try {
            r = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOZON.obtenerZonasPorRegiones(Long marca, Long canal, Long pais): Salida");
        return r;
    }

    public Long obtenerGerente(DTOUnidadAdministrativa arg) throws MareException {
    
    UtilidadesLog.info("DAOZON.obtenerGerente(DTOUnidadAdministrativa arg): Entrada");
    
        String entidad = null;
		String campo = null;
		Long value = null;
		boolean cond = false;
		BelcorpService bs = BelcorpService.getInstance();
        StringBuffer query = new StringBuffer();
        RecordSet r = new RecordSet();

		//Controla que el DTO traiga al menos 1 valor
		 int x=-1;
		 for (int i = 0; i < 4; i++){
			 switch (i) {
			   case 0:
			     value = arg.getOidSGV();
				 if (value != null) {
				   x++;
				 }
			   case 1:
				value = arg.getOidRegion();
				  if (value != null) {
				   x++;
				 }
			   case 2:
				value = arg.getOidZona();
				  if (value != null) {
				   x++;
				 }
			   case 3:
				value = arg.getOidSeccion();
				  if (value != null) {
				   x++;
				 }
			   
			   
			 }
		 }

		 if(x==-1 || x!=0){
			 throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.ERROR_EN_PARAMETROS));
		 }

        for (int i = 0; i < 4; i++) {
		
            switch (i) {
			
            case 0:
				value = arg.getOidSGV();
                if (value != null) {
                    entidad = "ZON_SUB_GEREN_VENTA";
					campo = "OID_SUBG_VENT";
					cond = true;
					break;
                }
				break;

            case 1:
				value = arg.getOidRegion();
                if (value != null) {
                    entidad = "ZON_REGIO";
					campo = "OID_REGI";
					cond = true;
					break;
					
                }
				break;

            case 2:
				value = arg.getOidZona();
                if (value != null) {
                    entidad = "ZON_ZONA";
					campo = "OID_ZONA";
					cond = true;
					break;
				}
				 break;

            case 3:
				value = arg.getOidSeccion();
                if (value != null) {
                    entidad = "ZON_SECCI"; 
					campo = "OID_SECC";
					cond = true;
					break;
                }
				break;
            }
			if(cond){break;}
        }
		query.append(" SELECT CLIE_OID_CLIE FROM  "+ entidad);
		query.append(" WHERE " + campo + " = " + value);
		 try {
            r = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
		if(r.esVacio()){
      UtilidadesLog.info("DAOZON.obtenerGerente(DTOUnidadAdministrativa arg): Salida");
			throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_UNIDAD_ADMINISTRATIVA));
		}

		
		if(((BigDecimal)r.getValueAt(0,0))==null){
			value =null;
			
		}else{
			value =new Long(((BigDecimal)r.getValueAt(0,0)).toString());
			
		}
    UtilidadesLog.info("DAOZON.obtenerGerente(DTOUnidadAdministrativa arg): Salida");
		return value;
    }

    public Integer obtenerNroConsultorasZona (DTOPedidosZona DTOE) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerNroConsultorasZona (DTOPedidosZona DTOE): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT COUNT(DISTINCT(A.CLIE_OID_CLIE)) "); 
        consulta.append(" FROM  MAE_CLIEN_UNIDA_ADMIN A, "); 
        consulta.append(" ZON_TERRI_ADMIN B, "); 
        consulta.append(" ZON_SECCI C, "); 
        consulta.append(" CRA_PERIO D, "); 
        consulta.append(" CRA_PERIO E, "); 
        consulta.append(" CRA_PERIO F  ");
        consulta.append(" WHERE A.ZTAD_OID_TERR_ADMI = B.OID_TERR_ADMI  ");
        consulta.append(" AND A.IND_ACTI = ? "); 
        consulta.append(" AND B.ZSCC_OID_SECC = C.OID_SECC "); 
        consulta.append(" AND C.ZZON_OID_ZONA = ? "); 
        consulta.append(" AND D.OID_PERI = A.PERD_OID_PERI_INI "); 
        consulta.append(" AND E.OID_PERI (+) = A.PERD_OID_PERI_FIN "); 
        consulta.append(" AND F.OID_PERI = ? "); 
        consulta.append(" AND F.FEC_INIC >= D.FEC_INIC "); 
        consulta.append(" AND (E.FEC_FINA IS NULL OR F.FEC_FINA <= E.FEC_FINA) ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_ACTIVO);
        parametros.add(DTOE.getOidZona());
        parametros.add(DTOE.getOidPeriodo());

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.obtenerNroConsultorasZona (DTOPedidosZona DTOE): Salida");

        return new Integer(((BigDecimal) resultado.getValueAt(0, 0)).intValue());
    }   

    public void activarUnidadesAdministrativasCliente (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.activarUnidadesAdministrativasCliente (Long oidPeriodo): Entrada");
        //Se activan aquellas unidades administrativas cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();


        consulta.append(" UPDATE MAE_CLIEN_UNIDA_ADMIN "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append(" WHERE PERD_OID_PERI_INI = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_ACTIVO);
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.activarUnidadesAdministrativasCliente (Long oidPeriodo): Salida");
    }

    public void desactivarUnidadesAdministrativasCliente (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.desactivarUnidadesAdministrativasCliente (Long oidPeriodo): Entrada");
        //Se desactivan aquellas unidades administrativas cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();


        consulta.append(" UPDATE MAE_CLIEN_UNIDA_ADMIN "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append(" WHERE PERD_OID_PERI_FIN = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_INACTIVO);
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.desactivarUnidadesAdministrativasCliente (Long oidPeriodo): Salida");
    }

    public void activarSecciones (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.activarSecciones (Long oidPeriodo): Entrada");
        //Se activan aquellas secciones cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();


        consulta.append(" UPDATE ZON_SECCI  "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append("    ,IND_BORR = ? ");  //incidencia Sicc-20070276 (13-06-2007) Sapaza, se actualiza el campo IND_BORRADO               
        consulta.append(" WHERE PERD_OID_PERI_INIC = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_ACTIVO);
        parametros.add(ConstantesZON.IND_INACTIVO); //incidencia Sicc-20070276 (13-06-2007)
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.activarSecciones (Long oidPeriodo): Salida");
    }

    public void desactivarSecciones (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.desactivarSecciones (Long oidPeriodo): Entrada");
        //Se desactivan aquellas secciones cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        //incidencia Sicc-20070365 (03-08-2007) Sapaza, se da de baja a los gerentes de las secciones desactivadas
        dardebajaResponsables(oidPeriodo, 4);

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append(" UPDATE ZON_SECCI "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append("    ,IND_BORR = ? ");  //incidencia Sicc-20070276 (12-06-2007) Sapaza, se actualiza el campo IND_BORRADO       
        consulta.append("    ,CLIE_OID_CLIE = NULL "); //incidencia SiCC-20070365 (02-08-2007) Sapaza, se limpia el campo cliente                
        consulta.append(" WHERE PERD_OID_PERI_FINA = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_INACTIVO);
        parametros.add(ConstantesZON.IND_ACTIVO); //incidencia Sicc-20070276 (12-06-2007)
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.desactivarSecciones (Long oidPeriodo): Salida");
    }

    public void activarZonas  (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.activarZonas  (Long oidPeriodo): Entrada");
        //Se activan aquellas zonas cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();


        consulta.append(" UPDATE ZON_ZONA   "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append("    ,IND_BORR = ? ");  //incidencia Sicc-20070276 (13-06-2007) Sapaza, se actualiza el campo IND_BORRADO               
        consulta.append(" WHERE PERD_OID_PERI_INIC = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_ACTIVO);
        parametros.add(ConstantesZON.IND_INACTIVO); //incidencia Sicc-20070276 (13-06-2007)
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.activarZonas  (Long oidPeriodo): Salida");
    }

    public void desactivarZonas  (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.desactivarZonas  (Long oidPeriodo): Entrada");
        //Se desactivan aquellas zonas cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        //incidencia Sicc-20070365 (03-08-2007) Sapaza, se da de baja a los gerentes de las zonas desactivadas
        dardebajaResponsables(oidPeriodo, 3);

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" UPDATE ZON_ZONA  "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append("    ,IND_BORR = ? ");  //incidencia Sicc-20070276 (12-06-2007) Sapaza, se actualiza el campo IND_BORRADO       
        consulta.append("    ,CLIE_OID_CLIE = NULL "); //incidencia SiCC-20070365 (02-08-2007) Sapaza, se limpia el campo cliente        
        consulta.append(" WHERE PERD_OID_PERI_FINA = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_INACTIVO);
        parametros.add(ConstantesZON.IND_ACTIVO); //incidencia Sicc-20070276 (12-06-2007)
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.desactivarZonas  (Long oidPeriodo): Salida");
    }

    public void activarRegiones  (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.activarRegiones  (Long oidPeriodo): Entrada");
        //Se activan aquellas regiones cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();


        consulta.append(" UPDATE ZON_REGIO  "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append("    ,IND_BORR = ? ");  //incidencia Sicc-20070276 (13-06-2007) Sapaza, se actualiza el campo IND_BORRADO               
        consulta.append(" WHERE PERD_OID_PERI_INIC = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_ACTIVO);
        parametros.add(ConstantesZON.IND_INACTIVO); //incidencia Sicc-20070276 (13-06-2007)
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.activarRegiones  (Long oidPeriodo): Salida");
    }

    public void desactivarRegiones  (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.desactivarRegiones  (Long oidPeriodo): Entrada");
        //Se desactivan aquellas regiones cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        //incidencia Sicc-20070365 (03-08-2007) Sapaza, se da de baja a los gerentes de las regiones desactivadas
        dardebajaResponsables(oidPeriodo, 2);

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" UPDATE ZON_REGIO   "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append("    ,IND_BORR = ? ");  //incidencia Sicc-20070276 (13-06-2007) Sapaza, se actualiza el campo IND_BORRADO       
        consulta.append("    ,CLIE_OID_CLIE = NULL "); //incidencia SiCC-20070365 (02-08-2007) Sapaza, se limpia el campo cliente
        consulta.append(" WHERE PERD_OID_PERI_FINA = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_INACTIVO);
        parametros.add(ConstantesZON.IND_ACTIVO); //incidencia Sicc-20070276 (13-06-2007)
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.desactivarRegiones  (Long oidPeriodo): Salida");
    }

    public void activarSubgerenciasVenta (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.activarSubgerenciasVenta (Long oidPeriodo): Entrada");
        //Se activan aquellas subgerencias cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();


        consulta.append(" UPDATE ZON_SUB_GEREN_VENTA  "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append("    ,IND_BORR = ? ");  //incidencia Sicc-20070276 (13-06-2007) Sapaza, se actualiza el campo IND_BORRADO               
        consulta.append(" WHERE PERD_OID_PERI_INIC = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_ACTIVO);
        parametros.add(ConstantesZON.IND_INACTIVO); //incidencia Sicc-20070276 (13-06-2007)
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.activarSubgerenciasVenta (Long oidPeriodo): Salida");
    }

    public void desactivarSubgerenciasVenta  (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.desactivarSubgerenciasVenta  (Long oidPeriodo): Entrada");
        //Se desactivan aquellas subgerencias cuyo periodo inicio sea igual al periodo pasado como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 

        //incidencia Sicc-20070365 (03-08-2007) Sapaza, se da de baja a los gerentes de las SGV desactivadas
        dardebajaResponsables(oidPeriodo, 1);

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" UPDATE ZON_SUB_GEREN_VENTA   "); 
        consulta.append(" SET IND_ACTI = ? "); 
        consulta.append("    ,IND_BORR = ? ");  //incidencia Sicc-20070276 (13-06-2007) Sapaza, se actualiza el campo IND_BORRADO       
        consulta.append("    ,CLIE_OID_CLIE = NULL "); //incidencia SiCC-20070365 (02-08-2007) Sapaza, se limpia el campo cliente                
        consulta.append(" WHERE PERD_OID_PERI_FINA = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_INACTIVO);
        parametros.add(ConstantesZON.IND_ACTIVO); //incidencia Sicc-20070276 (13-06-2007)
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.desactivarSubgerenciasVenta  (Long oidPeriodo): Salida");
    }

    public void actualizarFechaActivacionHistoricoZonas (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.actualizarFechaActivacionHistoricoZonas (Long oidPeriodo): Entrada");
        //Se actualiza la fecha de activación del histórico para todos aquellos registros cuyo periodo de activación sea el recibido (que es el siguiente al recibido para la reestructuración de ua's) 

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" UPDATE ZON_HISTO_ZONAS   "); 
        consulta.append(" SET FEC_ACTI = sysdate "); 
        consulta.append(" WHERE PERD_OID_PERI_ACTI  = ? "); 

        // Parametros de la consulta
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.actualizarFechaActivacionHistoricoZonas (Long oidPeriodo): Salida");
    }

    public ArrayList obtenerZonasParticionadas (DTOPeriodo DTOE)
        throws MareException {

        // Este método hace un consulta a través del DBService para obtener las zonas que acaban de ser desactivadas, recuperando las zonas en las que se ha particionado la zona que ha sido desactivada 
        UtilidadesLog.info("DAOZON.obtenerZonasParticionadas (DTOPeriodo DTOE): Entrada");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        Vector parametros = new Vector();

        StringBuffer consulta = new StringBuffer("SELECT ");
        consulta.append(" C.OID_ZONA AS oidZonaPadre, C.ESZO_OID_ESTA_ZONA as oidEstadoPadre, ");
        consulta.append(" E.OID_ZONA AS oidZonaHija "); 
        consulta.append(" FROM  ");
        consulta.append(" ZON_SUB_GEREN_VENTA A, "); 
        consulta.append(" ZON_REGIO B, "); 
        consulta.append(" ZON_ZONA C,  ");
        consulta.append(" ZON_HISTO_ZONAS D, "); 
        consulta.append(" ZON_ZONA E "); 
        consulta.append(" WHERE A.OID_SUBG_VENT = B.ZSGV_OID_SUBG_VENT "); 
        consulta.append(" AND B.OID_REGI = C.ZORG_OID_REGI "); 
        consulta.append(" AND C.PERD_OID_PERI_FINA = ?  ");
        consulta.append(" AND D.VAL_UNID_ADM1 = A.COD_SUBG_VENT||B.COD_REGI||C.COD_ZONA ");  //incidencia
        consulta.append(" AND D.VAL_TIPO_MODI = ? "); 
        consulta.append(" AND E.COD_ZONA = SUBSTR(D.VAL_UNID_ADM2,5,4) "); 
        consulta.append(" AND E.PAIS_OID_PAIS = ? ");
        consulta.append(" AND E.MARC_OID_MARC = ? ");
        consulta.append(" AND E.CANA_OID_CANA = ? ");

        // Parametros de la consulta
        parametros.add(DTOE.getOid());
        parametros.add(ConstantesZON.TIPO_MODIFICACION_PARTICION);        
        parametros.add(DTOE.getOidPais());
        parametros.add(DTOE.getMarca());
        parametros.add(DTOE.getCanal());


        RecordSet rs;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        ArrayList aList = new ArrayList(); // Se instancia como null por si la cant. de registros es vacío.
        

        if (!rs.esVacio()) {
            UtilidadesLog.info("*** Método obtenerZonasParticionadas: hay datos ***");
           // Guarda en aList los oid de las secciones que coinciden.
            for (int i = 0; i < rs.getRowCount(); i++) {
                DTOHistoricoZona dtoHistoricoZona = new DTOHistoricoZona();
                dtoHistoricoZona.setOidPais(DTOE.getOidPais());
                dtoHistoricoZona.setOidIdioma(DTOE.getOidIdioma());
                dtoHistoricoZona.setOidZonaPadre(rs.getValueAt(i, "OIDZONAPADRE") != null?new Long(((BigDecimal)rs.getValueAt(i, "OIDZONAPADRE")).longValue()):null);
                dtoHistoricoZona.setOidEstadoPadre(rs.getValueAt(i, "OIDESTADOPADRE") != null?new Long(((BigDecimal)rs.getValueAt(i, "OIDESTADOPADRE")).longValue()):null);
                dtoHistoricoZona.setOidZonaHija(rs.getValueAt(i, "OIDZONAHIJA") != null?new Long(((BigDecimal)rs.getValueAt(i, "OIDZONAHIJA")).longValue()):null);
                aList.add(dtoHistoricoZona);
            }
        }

        UtilidadesLog.info("DAOZON.obtenerZonasParticionadas (DTOPeriodo DTOE): Salida");
        return aList;
    }


    public RecordSet obtenerZonasFusionadas (DTOPeriodo DTOE) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerZonasFusionadas (DTOPeriodo DTOE): Entrada");
        //Este método hace un consulta a través del DBService para obtener las zonas que acaban de ser desactivadas, recuperando las zonas en las que se ha particionado la zona que ha sido desactivada 

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer("SELECT ");

        consulta.append(" E.OID_ZONA "); 
        consulta.append(" FROM "); 
        consulta.append(" ZON_SUB_GEREN_VENTA A, "); 
        consulta.append(" ZON_REGIO B, "); 
        consulta.append(" ZON_ZONA C, "); 
        consulta.append(" ZON_HISTO_ZONAS D, "); 
        consulta.append(" ZON_ZONA E "); 
        consulta.append(" WHERE A.OID_SUBG_VENT = B.ZSGV_OID_SUBG_VENT "); 
        consulta.append(" AND B.OID_REGI = C.ZORG_OID_REGI "); 
        consulta.append(" AND C.PERD_OID_PERI_FINA = ? "); 
        consulta.append(" AND D.VAL_UNID_ADM1 = A.COD_SUBG_VENT||B.COD_REGI||C.COD_ZONA "); 
        consulta.append(" AND D.VAL_TIPO_MODI = ? "); 
        consulta.append(" AND E.COD_ZONA = SUBSTR(D.VAL_UNID_ADM3, 5, 4) "); 
        consulta.append(" AND E.PAIS_OID_PAIS = ? "); 
        consulta.append(" AND E.MARC_OID_MARC = ? "); 
        consulta.append(" AND E.CANA_OID_CANA = ? "); 

        // Parametros de la consulta
        parametros.add(DTOE.getOid());
        parametros.add(ConstantesZON.TIPO_MODIFICACION_FUSION);
        parametros.add(DTOE.getOidPais());
        parametros.add(DTOE.getMarca());
        parametros.add(DTOE.getCanal());

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.obtenerZonasFusionadas (DTOPeriodo DTOE): Salida");
        return resultado;
    }

    public RecordSet obtenerZonasActivas (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerZonasActivas (Long oidPeriodo): Entrada");
        //Se obtienen todas las zonas por subgerencia, zonas por región, zonas y zonas 
        //de las secciones, para aquellas subgerencias, regiones, zonas y secciones que 
        //se hayan activado respectivamente 

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer("SELECT ");

        consulta.append(" A.OID_ZONA "); 
        consulta.append(" FROM "); 
        consulta.append(" ZON_ZONA A, "); 
        consulta.append(" ZON_REGIO B, "); 
        consulta.append(" ZON_SUB_GEREN_VENTA C "); 
        consulta.append(" WHERE A.ZORG_OID_REGI = B.OID_REGI "); 
        consulta.append(" AND B.ZSGV_OID_SUBG_VENT = C.OID_SUBG_VENT "); 
        consulta.append(" AND C.PERD_OID_PERI_INIC = ? "); 

        consulta.append(" UNION "); 

        consulta.append(" SELECT "); 
        consulta.append(" A.OID_ZONA "); 
        consulta.append(" FROM "); 
        consulta.append(" ZON_ZONA A, "); 
        consulta.append(" ZON_REGIO B "); 
        consulta.append(" WHERE A.ZORG_OID_REGI = B.OID_REGI "); 
        consulta.append(" AND B.PERD_OID_PERI_INIC = ? "); 

        consulta.append(" UNION "); 

        consulta.append(" SELECT "); 
        consulta.append(" A.OID_ZONA "); 
        consulta.append(" FROM "); 
        consulta.append(" ZON_ZONA A "); 
        consulta.append(" WHERE A.PERD_OID_PERI_INIC = ? ");
        
        consulta.append(" UNION "); 

        consulta.append(" SELECT "); 
        consulta.append(" A.OID_ZONA "); 
        consulta.append(" FROM "); 
        consulta.append(" ZON_ZONA A, "); 
        consulta.append(" ZON_SECCI D "); 
        consulta.append(" WHERE A.OID_ZONA = D.ZZON_OID_ZONA "); 
        consulta.append(" AND D.PERD_OID_PERI_INIC = ? "); 

        // Parametros de la consulta
        parametros.add(oidPeriodo);
        parametros.add(oidPeriodo);
        parametros.add(oidPeriodo);
        parametros.add(oidPeriodo);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.obtenerZonasActivas (Long oidPeriodo): Salida");
        return resultado;
    }

    
  /**
   * @author: ssantana, 25/11/2005, SICC-GCC-ZON-003
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet 
   * @param DTOBuscarUA dtoe
   */
    public RecordSet buscarUnidadesAdministrativas (DTOBuscarUA dtoe) throws
                                                                   MareException {   
        UtilidadesLog.info("DAOZON.buscarUnidadesAdministrativas(DTOBuscarUA dtoe): Entrada");
        // Este método hace un consulta a través del DBService para obtener 
        // los códigos de las unidades administrativas que no tienen responsable,
        // dependiendo de la unidad administrativa seleccionada en la pantalla 
        // se traerán los datos de una tabla u otra 

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet rs = new RecordSet();
        
        if (dtoe.getIndUA() != null) {
        
            // Si el indicador es = 1, realizo la siguiente consulta
            if (dtoe.getIndUA().intValue() == 1) {
               // Modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003
               consulta.append(" SELECT zon_sub_geren_venta.oid_subg_vent OID, ");
               consulta.append(" zon_sub_geren_venta.cod_subg_vent, ");
               consulta.append(" mae_clien.cod_clie, ");
               consulta.append(" mae_clien.val_nom1 ");
               consulta.append(" || ' ' ");
               consulta.append(" || mae_clien.val_nom2 ");
               consulta.append(" || ' ' ");
               consulta.append(" || mae_clien.val_ape1 ");
               consulta.append(" || ' ' ");
               consulta.append(" || mae_clien.val_ape2, ");
               consulta.append(" 1 indua, mae_clien.oid_clie ");
               consulta.append(" FROM zon_sub_geren_venta, mae_clien ");
               consulta.append(" WHERE zon_sub_geren_venta.clie_oid_clie = ");
               consulta.append("                        mae_clien.oid_clie(+)");
               if ( dtoe.getOidPais() != null ) {                
                 consulta.append(" AND zon_sub_geren_venta.pais_oid_pais = ? ");
                 parametros.add(dtoe.getOidPais());                  
               }
               if ( dtoe.getOidMarca() != null ) {
                 consulta.append(" AND zon_sub_geren_venta.marc_oid_marc = ? ");
                 parametros.add(dtoe.getOidMarca());                
               }
               if ( dtoe.getOidCanal() != null ) {
                 consulta.append(" AND zon_sub_geren_venta.cana_oid_cana = ? ");
                 parametros.add(dtoe.getOidCanal());
               }
               //modificado por Sapaza, 03/08/2007, incidencia SiCC-20070365
               consulta.append(" AND NOT (zon_sub_geren_venta.ind_acti = 0 AND zon_sub_geren_venta.ind_borr = 1) ");
               
               consulta.append(" ORDER BY OID ");
               // Fin modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003
             } else {
                // Si el indicador es = 2, realizo la siguiente consulta
                if (dtoe.getIndUA().intValue() == 2){
                    // Modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003                    
                    consulta.append(" SELECT zon_regio.oid_regi OID, ");
                    consulta.append(" zon_sub_geren_venta.cod_subg_vent || ");
                    consulta.append("      zon_regio.cod_regi, ");
                    consulta.append(" mae_clien.COD_CLIE, ");
                    consulta.append(" mae_clien.val_nom1 ");
                    consulta.append(" || ' ' ");
                    consulta.append(" || mae_clien.val_nom2 ");
                    consulta.append(" || ' ' ");
                    consulta.append(" || mae_clien.val_ape1 ");
                    consulta.append(" || ' ' ");
                    consulta.append(" || mae_clien.val_ape2,  ");
                    consulta.append(" 2 indua, mae_clien.oid_clie ");
                    consulta.append(" FROM mae_clien, zon_sub_geren_venta, ");
                    consulta.append(" zon_regio ");
                    consulta.append(" WHERE mae_clien.oid_clie(+) = ");
                    consulta.append("         zon_regio.clie_oid_clie ");
                    consulta.append(" AND zon_regio.zsgv_oid_subg_vent = ");
                    consulta.append("      zon_sub_geren_venta.oid_subg_vent ");
                    if (dtoe.getOidPais() != null){                    
                      consulta.append(" AND zon_sub_geren_venta.pais_oid_pais ");
                      consulta.append(" = ? ");
                      parametros.add(dtoe.getOidPais());
                    }
                    
                    if (dtoe.getOidMarca() != null){
                      consulta.append(" AND zon_sub_geren_venta.marc_oid_marc ");
                      consulta.append(" = ? ");
                      parametros.add(dtoe.getOidMarca());
                    }
                    
                    if (dtoe.getOidCanal() != null) {
                      consulta.append(" AND zon_sub_geren_venta.cana_oid_cana ");
                      consulta.append(" = ? ");
                      parametros.add(dtoe.getOidCanal());
                    }
                    //modificado por Sapaza, 03/08/2007, incidencia SiCC-20070365
                    consulta.append(" AND NOT (zon_sub_geren_venta.ind_acti = 0 AND zon_sub_geren_venta.ind_borr = 1) ");
                    consulta.append(" AND NOT (zon_regio.ind_acti = 0 AND zon_regio.ind_borr = 1) ");
                    
                    consulta.append(" ORDER BY OID ");
                    // Fin modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003
                    
                } else {
                    // Si el indicador es = 3, realizo la siguiente consulta
                    if (dtoe.getIndUA().intValue() == 3){
                        // Modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003
                        consulta.append(" SELECT zon_zona.oid_zona OID, ");
                        consulta.append(" zon_sub_geren_venta.cod_subg_vent ");
                        consulta.append(" || zon_regio.cod_regi ");
                        consulta.append(" || zon_zona.cod_zona, ");
                        consulta.append(" mae_clien.cod_clie, ");
                        consulta.append(" mae_clien.val_nom1 ");
                        consulta.append(" || ' ' ");
                        consulta.append(" || mae_clien.val_nom2 ");
                        consulta.append(" || ' ' ");
                        consulta.append(" || mae_clien.val_ape1 ");
                        consulta.append(" || ' ' ");
                        consulta.append(" || mae_clien.val_ape2, ");
                        consulta.append(" 3 indua, mae_clien.oid_clie ");
                        consulta.append(" FROM zon_sub_geren_venta, zon_regio, ");
                        consulta.append(" zon_zona, mae_clien ");
                        consulta.append(" WHERE zon_zona.clie_oid_clie = ");
                        consulta.append(" mae_clien.oid_clie(+) ");
                        if ( dtoe.getOidPais() != null ) { 
                          consulta.append(" AND zon_sub_geren_venta.");
                          consulta.append(" pais_oid_pais = ? ");
                          parametros.add(dtoe.getOidPais());
                        }
                        
                        if (dtoe.getOidMarca() != null) {
                          consulta.append(" AND zon_sub_geren_venta.");
                          consulta.append(" marc_oid_marc = ? ");
                          parametros.add(dtoe.getOidMarca());
                        }
                        
                        if (dtoe.getOidCanal() != null) {
                          consulta.append(" AND zon_sub_geren_venta.");
                          consulta.append(" cana_oid_cana = ? ");
                          parametros.add(dtoe.getOidCanal());
                        }
                        consulta.append(" AND zon_regio.zsgv_oid_subg_vent = ");
                        consulta.append("  zon_sub_geren_venta.oid_subg_vent ");
                        consulta.append(" AND zon_zona.zorg_oid_regi = ");
                        consulta.append(" zon_regio.oid_regi  ");
                        
                        //splatas - DBLG400001087 - 27/04/2006
                        if( dtoe.getCodZona() != null  &&  dtoe.getCodZona() != ""){
                            consulta.append(" AND ZON_ZONA.COD_ZONA = ? ");
                            parametros.add(dtoe.getCodZona());
                        }
                        
                        //modificado por Sapaza, 03/08/2007, incidencia SiCC-20070365
                        consulta.append(" AND NOT (zon_sub_geren_venta.ind_acti = 0 AND zon_sub_geren_venta.ind_borr = 1) ");
                        consulta.append(" AND NOT (zon_regio.ind_acti = 0 AND zon_regio.ind_borr = 1) ");
                        consulta.append(" AND NOT (zon_zona.ind_acti = 0 AND zon_zona.ind_borr = 1) ");
                        
                        consulta.append(" ORDER BY OID ");                        
                        // Fin modificacion por ssantana, 25/11/2005, 
                        // SICC-GCC-ZON-003
                    
                    } else {
                        // Si el indicador es = 4, realizo la siguiente consulta
                        if (dtoe.getIndUA().intValue() == 4) {
                            // Modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003
                            consulta.append(" SELECT zon_secci.oid_secc OID, ");
                            consulta.append(" zon_sub_geren_venta.cod_subg_vent ");
                            consulta.append(" || zon_regio.cod_regi ");
                            consulta.append(" || zon_zona.cod_zona ");
                            consulta.append(" || zon_secci.cod_secc, ");
                            consulta.append(" mae_clien.cod_clie, ");
                            consulta.append(" mae_clien.val_nom1 ");
                            consulta.append(" || ' ' ");
                            consulta.append(" || mae_clien.val_nom2 ");
                            consulta.append(" || ' ' ");
                            consulta.append(" || mae_clien.val_ape1 ");
                            consulta.append(" || ' ' ");
                            consulta.append(" || mae_clien.val_ape2, ");
                            consulta.append(" 4 indua, mae_clien.oid_clie ");
                            
                            consulta.append(" FROM zon_sub_geren_venta, ");
                            consulta.append(" zon_regio, ");
                            consulta.append(" zon_zona, zon_secci, mae_clien ");
                            consulta.append(" WHERE zon_secci.clie_oid_clie = ");
                            consulta.append("           mae_clien.oid_clie(+) ");
                            if ( dtoe.getOidPais() != null ) { 
                              consulta.append(" AND zon_sub_geren_venta.");
                              consulta.append(" pais_oid_pais = ? ");
                              parametros.add(dtoe.getOidPais());
                            }
                            
                            if (dtoe.getOidMarca() != null) {
                              consulta.append(" AND zon_sub_geren_venta.");
                              consulta.append(" marc_oid_marc = ? ");
                              parametros.add(dtoe.getOidMarca());
                            }
                            
                            if (dtoe.getOidCanal() != null) {
                              consulta.append(" AND zon_sub_geren_venta.");
                              consulta.append(" cana_oid_cana = ? ");
                              parametros.add(dtoe.getOidCanal());
                            }
                            consulta.append(" AND zon_regio.");
                            consulta.append(" zsgv_oid_subg_vent = ");
                            consulta.append(" zon_sub_geren_venta.");
                            consulta.append(" oid_subg_vent ");
                            consulta.append(" AND zon_zona.zorg_oid_regi ");
                            consulta.append(" = zon_regio.oid_regi ");
                            consulta.append(" AND zon_secci.zzon_oid_zona = ");
                            consulta.append(" zon_zona.oid_zona ");  
                            
                            //splatas - DBLG400001087 - 27/04/2006
                            if( dtoe.getCodZona() != null  &&  dtoe.getCodZona() != ""){
                                consulta.append(" AND ZON_ZONA.COD_ZONA = ? ");
                                parametros.add(dtoe.getCodZona());
                            }

                            //modificado por Sapaza, 03/08/2007, incidencia SiCC-20070365
                            consulta.append(" AND NOT (zon_sub_geren_venta.ind_acti = 0 AND zon_sub_geren_venta.ind_borr = 1) ");
                            consulta.append(" AND NOT (zon_regio.ind_acti = 0 AND zon_regio.ind_borr = 1) ");
                            consulta.append(" AND NOT (zon_zona.ind_acti = 0 AND zon_zona.ind_borr = 1) ");
                            consulta.append(" AND NOT (zon_secci.ind_acti = 0 AND zon_secci.ind_borr = 1) ");
                            
                            consulta.append(" ORDER BY OID ");
                            // Fin modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003                            
                        }else{
                            UtilidadesLog.debug(" El valor del indicador es "+
                                                "distinto de 1-4 ");
                            return rs;
                        }
                    }
                }
            }
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            String sqlPaginada = 
                  UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), 
                                                            dtoe);
   
            try {
                // Rellenamos el RecordSet con los resultados de la Consulta
                rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
                UtilidadesLog.debug("rs: " + rs);
            } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, 
                                UtilidadesError.armarCodigoError(codigoError));
            }
            if (rs.esVacio()) {
                // GEN-0007 --> 0005                                                                                  
                UtilidadesLog.debug("****DAOZON.buscarUASinResponsable: No hay datos ");				
                String sCodigoError = 
                            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(), 
                                        UtilidadesError.armarCodigoError(sCodigoError));
            }
        } else {
            UtilidadesLog.debug(" El valor del indicador es NULO ");
            return rs;
        }
        
        UtilidadesLog.info("DAOZON.buscarUnidadesAdministrativas(DTOBuscarUA dtoe): Salida"); 
                           
        return rs;
    }

    public Long obtenerNuevoEstadoEvaluacion (DTOPedidosZona dtoe) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerNuevoEstadoEvaluacion (DTOPedidosZona dtoe): Entrada");
        /*Este método hace un consulta a través del DBService para obtener 
          el estado cuyo número de consultoras mínimo e importe venta mínimo 
          sea el máximo posible y menor que los actuales */
        
        // INC 22396 - dmorello, 25/01/06: Cambio preparedQuery por staticQuery
        //Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();

        consulta.append("SELECT OID_ESTA_ZONA, ");
        consulta.append("NUM_CONS_MIN, ");
        consulta.append("IMPO_VENT_MINI ");
        consulta.append("FROM ZON_ESTAD_ZONA ");
        consulta.append("WHERE NUM_CONS_MIN <= " + dtoe.getNumeroConsultoras()
            + ' ');
        //parametros.add(dtoe.getNumeroConsultoras());
        consulta.append("AND IMPO_VENT_MINI <= " + dtoe.getMontoTotal() + ' ');
        //parametros.add(dtoe.getMontoTotal());
        /*
         * DBLG500000150 - dmorello, 09/08/2006
         * Se filtran los estados de zona por país y marca
         */
        if (dtoe.getOidPais() != null) {
          consulta.append(" AND PAIS_OID_PAIS = " + dtoe.getOidPais());
        }
        if (dtoe.getOidMarca() != null) {
          consulta.append(" AND MARC_OID_MARC = " + dtoe.getOidMarca());
        }
        
        /*
         * Incidencia 22640 - dmorello, 21/02/2006
         * Se deja de ordenar por COD_ESTA_ZONA descendente.....
         */
        consulta.append("ORDER BY NUM_CONS_MIN DESC, IMPO_VENT_MINI DESC");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            // INC 22396 - dmorello, 25/1/06: cambio preparedQuery por static
            resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
                
        UtilidadesLog.info("DAOZON.obtenerNuevoEstadoEvaluacion (DTOPedidosZona dtoe): Salida");
        /*
         * Incidencia 22640 - dmorello, 21/02/2006
         * Si la query no levanta registros, se devuelve el OID del estado
         * "Otro estado". En otro caso, el OID del primer estado recuperado.
         */
        if (resultado.esVacio()) {
            /*  inicio pperez   02/11/2006  */
            consulta = new StringBuffer();
            consulta.append("  SELECT oid_esta_zona  OID_ESTA_ZONA  ");
            consulta.append("    FROM zon_estad_zona  ");
            consulta.append("   WHERE pais_oid_pais = " + dtoe.getOidPais());
            consulta.append("     AND marc_oid_marc = " + dtoe.getOidMarca());
            consulta.append("     AND cod_esta_zona =   " + ConstantesZON.CODIGO_OTRO_ESTADO);   

            try {
                // INC 22396 - dmorello, 25/1/06: cambio preparedQuery por static
                resultado = bs.dbService.executeStaticQuery(consulta.toString());
            } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
            /*  fin pperez   02/11/2006  */
        } 
        
        return new Long(((BigDecimal)resultado.getValueAt(0, 0)).longValue());
    }
	
	/*
	 * 29-06-2005 - rgiorgi: inc. 18991
	 * */
	public Long[] obtenerUGTerritorioporZona(Long oidZona) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerUGTerritorioporZona(Long oidZona): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT c.vepo_oid_valo_estr_geop valorug, c.oid_terr territorio ");
        consulta.append("  FROM zon_secci a, zon_terri_admin b, zon_terri c ");
        consulta.append(" WHERE a.zzon_oid_zona = " + oidZona);
        consulta.append("   AND a.ind_borr = " + ConstantesCMN.VAL_FALSE);
        consulta.append("   AND b.zscc_oid_secc = a.oid_secc ");
        consulta.append("   AND b.ind_borr = " + ConstantesCMN.VAL_FALSE);
        consulta.append("   AND c.oid_terr = b.terr_oid_terr ");
        consulta.append("   AND c.ind_borr = " + ConstantesCMN.VAL_FALSE);
        consulta.append("   AND c.vepo_oid_valo_estr_geop IS NOT NULL ");
        consulta.append(" ORDER BY c.vepo_oid_valo_estr_geop ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
               
		if (resultado.esVacio() == false){
			ArrayList oidTerritorios = new ArrayList();
			Long lValorUG = new Long(0);		
			for (int i=0; i<resultado.getRowCount() ;i++){
				Long valorUGActual = (((BigDecimal)resultado.getValueAt(i,0))!=null) ?
						new Long(((BigDecimal)resultado.getValueAt(i,0)).longValue()):null;
				if ( (valorUGActual != null && 
						valorUGActual.longValue() != lValorUG.longValue())){
					lValorUG = valorUGActual;
					oidTerritorios.add(
						new Long(((BigDecimal)resultado.getValueAt(i,1)).longValue()));
				}
			}
			UtilidadesLog.info("DAOZON.obtenerUGTerritorioporZona(Long oidZona): Salida");
			return (Long[]) oidTerritorios.toArray();
		} else {		
			UtilidadesLog.debug("DAOZON.obtenerUGTerritorioporZona: no se obtuvieron resultados");
      UtilidadesLog.info("DAOZON.obtenerUGTerritorioporZona(Long oidZona): Salida");
			return null;
		}
    }

	/*
	 * 29-06-2005 - rgiorgi: inc. 18991
	 * */
	public Long[] obtenerSeccionTerritorioporZona(Long oidZona) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerSeccionTerritorioporZona(Long oidZona): Entrada");
        
        StringBuffer consulta = new StringBuffer();

        consulta.append("  SELECT b.zscc_oid_secc seccion, b.terr_oid_terr territorio ");
        consulta.append("    FROM zon_secci a, zon_terri_admin b ");
        consulta.append("   WHERE a.zzon_oid_zona = " + oidZona);
        consulta.append("     AND a.ind_borr = " + ConstantesCMN.VAL_FALSE);
        consulta.append("     AND b.zscc_oid_secc = a.oid_secc ");
        consulta.append("     AND b.ind_borr = " + ConstantesCMN.VAL_FALSE);
        consulta.append("   ORDER BY b.zscc_oid_secc ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
               
		if (resultado.esVacio() == false){
			ArrayList oidTerritorios = new ArrayList();
			Long lSeccion = new Long(0);		
			for (int i=0; i<resultado.getRowCount() ;i++){
				Long valorSeccionActual = (((BigDecimal)resultado.getValueAt(i,0))!=null) ?
						new Long(((BigDecimal)resultado.getValueAt(i,0)).longValue()):null;
				if ( (valorSeccionActual != null && 
						valorSeccionActual.longValue() != lSeccion.longValue())){
					lSeccion = valorSeccionActual;
					oidTerritorios.add(
						new Long(((BigDecimal)resultado.getValueAt(i,1)).longValue()));
				}
			}
			UtilidadesLog.info("DAOZON.obtenerSeccionTerritorioporZona(Long oidZona): Salida");
			return (Long[]) oidTerritorios.toArray();
		} else {		
			UtilidadesLog.debug("DAOZON.obtenerSeccionTerritorioporZona: no se obtuvieron resultados");
      UtilidadesLog.info("DAOZON.obtenerSeccionTerritorioporZona(Long oidZona): Salida");
			return null;
		}
 }	


    /**
     * Obtiene los territorios activos con su zona asociada
     * @param DTOBelcorp, 
     * @return RecordSet con los datos de los territorios obtenidos
     * @exception MareException si no se pudo acceder a la base de datos
     */

  public RecordSet obtenerTerritoriosporZonas(DTOBelcorp dtoIn) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerTerritoriosporZonas(DTOBelcorp dtoIn): Entrada");

       
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT DISTINCT z.OID_ZONA, ta.terr_oid_terr, t.cod_terr ");
        consulta.append(" FROM zon_terri t, zon_terri_admin ta, zon_regio r, ");
        consulta.append(" zon_zona z, zon_sub_geren_venta sgv, zon_secci s ");
        consulta.append(" WHERE sgv.pais_oid_pais = " + dtoIn.getOidPais());
        consulta.append(" AND r.zsgv_oid_subg_vent = sgv.oid_subg_vent ");
        consulta.append(" AND r.oid_regi = z.zorg_oid_regi ");
        consulta.append(" AND s.zzon_oid_zona = z.oid_zona ");
        consulta.append(" AND s.oid_secc = ta.zscc_oid_secc ");
        consulta.append(" AND t.oid_terr = ta.terr_oid_terr ");
        consulta.append(" AND sgv.ind_acti = 1 ");
        consulta.append(" AND sgv.ind_borr = 0 ");
        consulta.append(" AND r.ind_acti = 1 ");
        consulta.append(" AND r.ind_borr = 0 ");
        consulta.append(" AND z.ind_acti = 1 ");
        consulta.append(" AND z.ind_borr = 0 ");
        consulta.append(" AND s.ind_acti = 1 ");
        consulta.append(" AND s.ind_borr = 0 ");
        consulta.append(" AND t.ind_borr = 0 ");
        consulta.append(" AND ta.ind_borr = 0 ");
        consulta.append(" ORDER BY t.cod_terr ");

        // Parametros de la consulta
       
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.obtenerTerritoriosporZonas(DTOBelcorp dtoIn): Salida");
        return resultado;
    }
    
    
  /**
   * @author: ssantana, 24/11/2005, cambio SICC-GCC-ZON-003
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet
   * @param Long oidCliente
   */
  public RecordSet obtenerDetalleResponsable(Long oidCliente, Long oidIdioma) 
                                                          throws MareException {
    UtilidadesLog.info("DAOZON.obtenerDetalleResponsable(Long oidCliente): " + 
                       "Entrada");
    RecordSet rRetorno = null;
    
    try { 
       BelcorpService bs = BelcorpService.getInstance();
       StringBuffer sqlQuery = new StringBuffer("");
        sqlQuery.append(" SELECT  ");
        sqlQuery.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE  ");
        sqlQuery.append(" IDIO.attr_enti = 'MAE_TIPO_CLIEN' AND IDIO.idio_oid_idio = " + oidIdioma);
        sqlQuery.append(" AND IDIO.val_oid = mae_clien_tipo_subti.ticl_oid_tipo_clie  ) AS tipoCliente, ");
        sqlQuery.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE  ");
        sqlQuery.append(" IDIO.attr_enti = 'MAE_SUBTI_CLIEN' AND IDIO.idio_oid_idio = " + oidIdioma);
        sqlQuery.append(" AND IDIO.val_oid = mae_clien_tipo_subti.sbti_oid_subt_clie  ) AS subTipoCliente,  ");
        sqlQuery.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE  ");
        sqlQuery.append(" IDIO.attr_enti = 'MAE_CLASI' AND IDIO.idio_oid_idio = " + oidIdioma);
        sqlQuery.append(" AND IDIO.val_oid = mae_clien_clasi.clas_oid_clas  ) AS clasificacion,  ");
        sqlQuery.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE  ");
        sqlQuery.append(" IDIO.attr_enti = 'MAE_TIPO_CLASI_CLIEN' AND IDIO.idio_oid_idio = " + oidIdioma);
        sqlQuery.append(" AND IDIO.val_oid = mae_clien_clasi.tccl_oid_tipo_clasi  ) AS tipoClasificacion ");
        sqlQuery.append(" FROM mae_clien, ");
        sqlQuery.append(" mae_clien_tipo_subti, ");
        sqlQuery.append(" mae_clien_clasi ");
        sqlQuery.append(" WHERE mae_clien.oid_clie = " + oidCliente);
        sqlQuery.append(" AND mae_clien_tipo_subti.clie_oid_clie = mae_clien.oid_clie ");
        sqlQuery.append(" AND mae_clien_clasi.ctsu_oid_clie_tipo_subt(+) = mae_clien_tipo_subti.oid_clie_tipo_subt ");
        sqlQuery.append(" AND mae_clien_tipo_subti.ind_ppal = 1 ");
        sqlQuery.append(" AND mae_clien_clasi.ind_ppal(+) = 1 ");

/*       sqlQuery.append(" SELECT vtipocliente.val_i18n, vsubtipocliente.val_i18n, ");
       sqlQuery.append(" vclasificacion.val_i18n, vtipoclasificacion.val_i18n ");
       sqlQuery.append(" FROM mae_clien, ");
       sqlQuery.append(" mae_clien_tipo_subti, ");
       sqlQuery.append(" mae_clien_clasi, ");
       sqlQuery.append(" v_gen_i18n_sicc vtipocliente, ");
       sqlQuery.append(" v_gen_i18n_sicc vsubtipocliente, ");
       sqlQuery.append(" v_gen_i18n_sicc vclasificacion, ");
       sqlQuery.append(" v_gen_i18n_sicc vtipoclasificacion ");
       sqlQuery.append(" WHERE mae_clien.oid_clie = " + oidCliente);
       sqlQuery.append(" AND mae_clien_tipo_subti.clie_oid_clie = ");
       sqlQuery.append("                                  mae_clien.oid_clie ");
       sqlQuery.append(" AND mae_clien_clasi.ctsu_oid_clie_tipo_subt = ");
       sqlQuery.append("              mae_clien_tipo_subti.oid_clie_tipo_subt ");
       sqlQuery.append(" AND mae_clien_tipo_subti.ticl_oid_tipo_clie = ");
       sqlQuery.append("                                 vtipocliente.val_oid ");
       sqlQuery.append(" AND vtipocliente.attr_enti = 'MAE_TIPO_CLIEN' ");
       sqlQuery.append(" AND vtipocliente.attr_num_atri = 1 ");
       sqlQuery.append(" AND vtipocliente.idio_oid_idio = " + oidIdioma);
       sqlQuery.append(" AND mae_clien_tipo_subti.sbti_oid_subt_clie = ");
       sqlQuery.append("                               vsubtipocliente.val_oid ");
       sqlQuery.append(" AND vsubtipocliente.attr_enti = 'MAE_SUBTI_CLIEN' ");
       sqlQuery.append(" AND vsubtipocliente.attr_num_atri = 1 ");
       sqlQuery.append(" AND vsubtipocliente.idio_oid_idio = " + oidIdioma);
       sqlQuery.append(" AND mae_clien_clasi.clas_oid_clas = vclasificacion.val_oid ");
       sqlQuery.append(" AND vclasificacion.attr_enti = 'MAE_CLASI' ");
       sqlQuery.append(" AND vclasificacion.attr_num_atri = 1 ");
       sqlQuery.append(" AND vclasificacion.idio_oid_idio = " + oidIdioma);
       sqlQuery.append(" AND mae_clien_clasi.tccl_oid_tipo_clasi = ");
       sqlQuery.append("                            vtipoclasificacion.val_oid ");
       sqlQuery.append(" AND vtipoclasificacion.attr_enti = 'MAE_TIPO_CLASI_CLIEN' ");
       sqlQuery.append(" AND vtipoclasificacion.attr_num_atri = 1 ");
       sqlQuery.append(" AND vtipoclasificacion.idio_oid_idio = " + oidIdioma);
       // Agregado por ssantana, 30/11/2005, inc. BELC300021896 
       sqlQuery.append(" AND mae_clien_tipo_subti.ind_ppal = 1 ");
       sqlQuery.append(" AND mae_clien_clasi.ind_ppal = 1 ");
       // Fin agregado por ssantana, 30/11/2005, inc. BELC300021896 
       */
       UtilidadesLog.debug(sqlQuery.toString());
       
       rRetorno = bs.dbService.executeStaticQuery(sqlQuery.toString());
       UtilidadesLog.debug("rRetorno: "+ rRetorno);
      
    } catch (Exception ex) {
       UtilidadesLog.debug(ex);
       String sCodigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
       throw new MareException(ex, 
                               UtilidadesError.armarCodigoError(sCodigoError));
    }
    return rRetorno;
    
  }
  
  
  /**
   * @author: ssantana, 24/11/2005, cambio SICC-GCC-ZON-003
   * @throws es.indra.mare.common.exception.MareException
   * @return boolean
   * @param Long oidCliente
   */
  public boolean validarClienteGerente(Long oidCliente) throws MareException {
    UtilidadesLog.info("DAZON.validarClienteGerente(Long oidCliente): Entrada");
    boolean esGerente = false;
    
    StringBuffer sqlQuery = new StringBuffer("");
    RecordSet r = null;
    BelcorpService bs = BelcorpService.getInstance();


     sqlQuery.append(" SELECT mae_clien_tipo_subti.ticl_oid_tipo_clie ");
    sqlQuery.append(" FROM mae_clien_tipo_subti ");
    sqlQuery.append(" WHERE mae_clien_tipo_subti.clie_oid_clie = " + oidCliente);
    /*mdolce 08/02/2007 POr incidencia  SiCC 20070010 no se debe filtrar por principal*/
  /*  sqlQuery.append(" AND mae_clien_tipo_subti.ind_ppal = 1 "); */
    
    try {
       UtilidadesLog.debug("sqlQuery: " + sqlQuery.toString());
       r =  bs.dbService.executeStaticQuery(sqlQuery.toString());
       UtilidadesLog.debug("r: " + r);
    } catch (Exception ex) {
       UtilidadesLog.debug(ex);
       String sCodigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
       throw new MareException(ex, 
                               UtilidadesError.armarCodigoError(sCodigoError));
    }
    
    // Ahora me fijo que el Oid de Tipo de Cliente matchee con 
    // ConstantesMAE.OID_TIPO_CLIENTE_GERENTE
    
     
     Long oidTipoCliente;
        /*mdolce 08/02/2007 POr incidencia  SiCC 20070010 no se debe filtrar por principal*/
     if ( !r.esVacio() ) {
        for (int i = 0; i < r.getRowCount(); i++) {
          oidTipoCliente = new Long( ((BigDecimal)r.getValueAt(i,0)).toString() );
          UtilidadesLog.debug("oidTipoCliente: " + oidTipoCliente);             
          if ( oidTipoCliente.equals(ConstantesMAE.OID_TIPO_CLIENTE_GERENTE) ) {
             UtilidadesLog.debug("Es Tipo Cliente Gerente");
             esGerente = true;
             break;
          }
        }
     } 
    
    UtilidadesLog.info("DAZON.validarClienteGerente(Long oidCliente): Salida");
    return esGerente;
  }
  
  
  /**
   * Método agregado por INC 21881
   * Modificado por INC 21881 - dmorello, 05/04/2006: pasa a devolver
   * el código de la gerente de zona en lugar del OID de la responsable de
   * sección.
   * 
   * @author dmorello
   * @date 02/01/2006
   * @return String
   * @param oidMarca
   * @param oidCanal
   * @param oidPeriodo
   * @param codTerritorio
   */
  public String obtenerResponsableTerritorio(Long oidMarca, Long oidCanal, Long oidPeriodo, String codTerritorio)
          throws MareException {
          
      UtilidadesLog.info("DAOZON.obtenerResponsableTerritorio(Long oidMarca, Long oidCanal, Long oidPeriodo, String codTerritorio): Entrada");
  
      RecordSet rs = null;
      StringBuffer query = new StringBuffer();
      BelcorpService bs = null;
      
      //query.append(" SELECT SE.CLIE_OID_CLIE ");
      //query.append(" SELECT CLI.COD_CLIE "); // 21881, dmorello 05/04/2006 <-- elimina 22937 26/04/2006
      
      //22937 26/04/2006
      query.append(" SELECT (cli.VAL_NOM1 ||' ' || cli.VAL_NOM2 ||' ' || cli.VAL_APE1 ||' ' || cli.VAL_APE2) AS nombreApellido ");   
      //ahora tiene que retornar el nombreApellido
      
      query.append(" FROM ZON_TERRI_ADMIN TAD, ");
      query.append("   ZON_SECCI SE,  ");
      query.append("   ZON_ZONA ZON, ");  // 21881, dmorello 05/04/2006
      query.append("   MAE_CLIEN CLI, "); // 21881, dmorello 05/04/2006
      query.append("   CRA_PERIO PERINI, ");
      query.append("   CRA_PERIO PERFIN, ");
      query.append("   CRA_PERIO PER, ");
      query.append("   ZON_TERRI TERRI ");
      query.append(" WHERE TAD.MARC_OID_MARC = " + oidMarca);
      query.append("   AND TAD.CANA_OID_CANA = " + oidCanal);
      query.append("   AND TERRI.COD_TERR = " +codTerritorio);
      query.append("   AND TAD.TERR_OID_TERR = TERRI.OID_TERR ");
      query.append("   AND TAD.PERD_OID_PERI_INIC = PERINI.OID_PERI ");
      // Agregado outer join - dmorello, 04/01/2006
      query.append("   AND TAD.PERD_OID_PERI_FINA = PERFIN.OID_PERI (+) ");
      query.append("   AND PER.OID_PERI = " + oidPeriodo);
      query.append("   AND PERINI.FEC_INIC <= PER.FEC_INIC ");
      // Se modifica el siguiente AND agregando en un OR tad.periodoFinal nulo
      query.append("   AND (TAD.PERD_OID_PERI_FINA IS NULL ");
      query.append("        OR PERFIN.FEC_FINA >= PER.FEC_FINA) ");
      query.append("   AND SE.OID_SECC = TAD.ZSCC_OID_SECC ");  
      // Agregados INC 21881 dmorello 05/04/2006
      query.append("   AND SE.ZZON_OID_ZONA = ZON.OID_ZONA ");
      query.append("   AND CLI.OID_CLIE = ZON.CLIE_OID_CLIE");
      // Fin agregados INC 21881
      
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE);
          throw new MareException(e,error);
      }
                
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
          throw new MareException(e,error);
      }
      
      UtilidadesLog.debug("resultado: " + rs);
      /*
      dmorello, 09/01/2006: Se asignará en el IF siguiente el valor
      String codCliente;
      dmorello, 11/01/2006: Se agrega la última condición por precaución.
      if (rs != null && !rs.esVacio() && rs.getRowCount() == 1) {
          Object o = rs.getValueAt(0,"COD_CLIE");
          codCliente = (o != null)? o.toString() : null;
      } else {
          codCliente = null;
      }*/
      
      // 27/04/2006 incidencia 22937
      String nombreResponsable = null;
      if (rs != null && !rs.esVacio() && rs.getRowCount() == 1) {
          Object obj = rs.getValueAt(0,"nombreApellido");
          nombreResponsable = obj.toString();
      } 
      
      UtilidadesLog.debug("responsable a retornar: " + nombreResponsable);
      UtilidadesLog.info("DAOZON.obtenerResponsableTerritorio(Long oidMarca, Long oidCanal, Long oidPeriodo, String codTerritorio): Salida");
      return nombreResponsable;
  }
   
   // 26/04/2006 incidencia 22937
   public String obtenerNombreSeccion(String periodo, String seccion, Long oidZona ) throws MareException {
      UtilidadesLog.info("DAOZON.obtenerNombreSeccion(String periodo, String seccion, Long oidZona ): Entrada");
      
      RecordSet rs = null;   
      StringBuffer query = new StringBuffer();
      BelcorpService bs = null;
           
      query.append(" SELECT SECCION.DES_SECCI nombreSeccion");
      query.append(" FROM ZON_SECCI SECCION ");
      query.append(" WHERE SECCION.IND_BORR = 0 ");
      query.append(" AND SECCION.IND_ACTI = 1 ");
      query.append(" AND SECCION.COD_SECC = " + "'"+ seccion +"'");
      query.append(" AND SECCION.PERD_OID_PERI_INIC = " + periodo);
      query.append(" AND SECCION.ZZON_OID_ZONA = "+ oidZona);
      
      try {
          bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex) {
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      try {
        rs = bs.dbService.executeStaticQuery(query.toString());
      }
      catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      String nombreSeccion = null;
      if (rs != null && !rs.esVacio() && rs.getRowCount() == 1) {
          Object obj = rs.getValueAt(0,"nombreSeccion");
          nombreSeccion = obj.toString();
      }       
      UtilidadesLog.debug("Seccion nombre a retornar: " + nombreSeccion);
      UtilidadesLog.info("DAOZON.obtenerNombreSeccion(String periodo, String seccion, Long oidZona ): Salida");
     
      return nombreSeccion;
   }
   
 /**
  * @autor Noziglia C.
  * @throws MareException
  * @param 
  * @return 
  * @documentation Descripción: Comprueba que un cliente dado sea Consultora.

        Implementación:
        
        Con el oidCliente recibido como parametro recuperar:
         - tc.COD_TIPO_CLIE
         De:
         - MAE_CLIEN_TIPO_SUBTI cts
         - MAE_TIPO_CLIEN tc
         Donde:
         - cts.CLIE_OID_CLIE = oidCliente
         - cts.IND_PPAL = 1
        
        Si (tc.COD_TIPO_CLIE == ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA)
        {
         Se retorna "true"
        }Sino
         {
          Se retorna "false"
         }
        }

  * 
  * @date
  */
    public boolean validarClienteConsultora(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAZON.validarClienteConsultora(Long oidCliente): Entrada");
        boolean esConsultora = false;
        
        StringBuffer sqlQuery = new StringBuffer("");
        RecordSet r = null;
        BelcorpService bs = BelcorpService.getInstance();
    
    
        sqlQuery.append(" SELECT mae_clien_tipo_subti.ticl_oid_tipo_clie ");
        sqlQuery.append(" FROM mae_clien_tipo_subti ");
        sqlQuery.append(" WHERE mae_clien_tipo_subti.clie_oid_clie = " + oidCliente);
        /*mdolce 08/02/2007 POr incidencia  SiCC 20070010 no se debe filtrar por principal*/
        /*sqlQuery.append(" AND mae_clien_tipo_subti.ind_ppal = 1 "); */
        
        try {
           UtilidadesLog.debug("sqlQuery: " + sqlQuery.toString());
           r =  bs.dbService.executeStaticQuery(sqlQuery.toString());
           UtilidadesLog.debug("r: " + r);
        } catch (Exception ex) {
           UtilidadesLog.debug(ex);
           String sCodigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           throw new MareException(ex, 
                                   UtilidadesError.armarCodigoError(sCodigoError));
            }
        
        // Ahora me fijo que el Oid de Tipo de Cliente matchee con 
        // ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA
        Long oidTipoCliente;
        /*mdolce 08/02/2007 POr incidencia  SiCC 20070010 no se debe filtrar por principal*/
        if ( !r.esVacio() ) {
           for (int i = 0; i < r.getRowCount(); i++) {
             oidTipoCliente = new Long( ((BigDecimal)r.getValueAt(i,0)).toString() );
             UtilidadesLog.debug("oidTipoCliente: " + oidTipoCliente);             
             if ( oidTipoCliente.equals(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA) ) {
                UtilidadesLog.debug("Es Tipo Cliente Consultora");
                esConsultora = true;
                break;
             }
           }
        } 
        UtilidadesLog.info("DAZON.validarClienteConsultora(Long oidCliente): Salida");
        return esConsultora;
    }
    
    
    // 26/04/2006 incidencia 22937
   public String obtenerNombreSeccion(DatoRegistro unRegistro, Long oidPais, Long oidMarca, Long oidCanal) throws MareException {
      UtilidadesLog.info("DAOZON.obtenerNombreSeccion(DatoRegistro unRegistro): Entrada");
      
      RecordSet rs = null;   
      StringBuffer query = new StringBuffer();
      BelcorpService bs = null;
           
      query.append(" SELECT sec.DES_SECCI nombreSeccion ");
      query.append("   FROM zon_sub_geren_venta sgv, ");
      query.append("        zon_regio reg, ");
      query.append("        zon_zona zon, ");
      query.append("        zon_secci sec ");
      query.append("  WHERE sgv.COD_SUBG_VENT = '" + unRegistro.getSubgerencia() + "' ");
      query.append("        AND sgv.PAIS_OID_PAIS = " + oidPais);
      query.append("        AND sgv.MARC_OID_MARC = " + oidMarca);
      query.append("        AND sgv.CANA_OID_CANA = " + oidCanal);
      query.append("        AND sgv.IND_BORR = 0 ");
	    query.append("        AND reg.COD_REGI = '" + unRegistro.getRegion() +"' ");
      query.append("        AND reg.ZSGV_OID_SUBG_VENT = sgv.OID_SUBG_VENT ");
      query.append("        AND zon.COD_ZONA = '" + unRegistro.getZona() + "' ");
      query.append("        AND zon.ZORG_OID_REGI = reg.OID_REGI ");
      query.append("        AND zon.IND_BORR = 0 ");
      query.append("        AND sec.COD_SECC = '" + unRegistro.getSeccion() + "' ");
      query.append("        AND sec.ZZON_OID_ZONA = zon.OID_ZONA ");
      query.append("        AND sec.IND_BORR = 0 ");
      
      try {
          bs = BelcorpService.getInstance();
      } catch(MareMiiServiceNotFoundException ex) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      try {
         rs = bs.dbService.executeStaticQuery(query.toString());
      } catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      String nombreSeccion = null;
      if (rs != null && !rs.esVacio() && rs.getRowCount() == 1) {
          Object obj = rs.getValueAt(0,"nombreSeccion");
          nombreSeccion = obj.toString();
          //debemos retornar codigoSeccion + nombreSeccion 12/06/2006
          nombreSeccion = (unRegistro.getSeccion() + nombreSeccion);
      }       
      UtilidadesLog.debug("*** Seccion, Nombre a retornar: " + nombreSeccion);
      UtilidadesLog.info("DAOZON.obtenerNombreSeccion(DatoRegistro unRegistro): Salida");
     
      return nombreSeccion;
   }

  /**
   * 12-04-2012   agregado por Sapaza, PER-SiCC-2011-0928, se elimina todo lo referente a Secciones
   *              
   * @author: sapaza, 02/05/2007, incidencia SiCC-20070239
   * @throws es.indra.mare.common.exception.MareException
   * @return boolean 
   * @param DTOResponsable dtoe
   */
    public String validarResponsableYaAsignado (DTOResponsable dtoe) throws  MareException {   
        UtilidadesLog.info("DAOZON.validarResponsableYaAsignado(DTOResponsable dtoe): Entrada");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet rs = new RecordSet();
        
        String asignado = null;
        String unidadAdministrativa = null;
        Long marca = null;
        Long canal = null;
        Long pais = null;

        //Recuperamos el pais, marca y canal de la Unidad Administrativa        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        /*if (dtoe.getIndUA().intValue() == 1) {   
            consulta.append(" SELECT pais_oid_pais PAIS, marc_oid_marc MARCA, cana_oid_cana canal ");
            consulta.append(" FROM zon_sub_geren_venta ");
            consulta.append(" WHERE oid_subg_vent = ? ");
            unidadAdministrativa = "Subgerencia";
        }*/
        if (dtoe.getIndUA().intValue() == 2){
            consulta.append(" SELECT pais_oid_pais PAIS, marc_oid_marc MARCA, cana_oid_cana canal ");
            consulta.append(" FROM zon_regio ");
            consulta.append(" WHERE oid_regi = ? ");
            unidadAdministrativa = "Region";
        }
        if (dtoe.getIndUA().intValue() == 3){
            consulta.append(" SELECT pais_oid_pais PAIS, marc_oid_marc MARCA, cana_oid_cana canal ");
            consulta.append(" FROM zon_zona ");
            consulta.append(" WHERE oid_zona = ? ");
            unidadAdministrativa = "Zona";
        }
        /*if (dtoe.getIndUA().intValue() == 4){
            consulta.append(" SELECT zon.pais_oid_pais PAIS, zon.marc_oid_marc MARCA, zon.cana_oid_cana canal ");
            consulta.append(" FROM zon_zona zon, zon_secci sec ");
            consulta.append(" WHERE sec.zzon_oid_zona = zon.oid_zona ");              
            consulta.append("   AND sec.oid_secc = ? ");
            unidadAdministrativa = "Seccion";            
        }*/
        parametros.add(dtoe.getOidUA());
        
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            UtilidadesLog.debug("rs: " + rs);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug("****DAOZON.validarResponsableYaAsignado: No existe Unidad Administrativa ");				
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(sCodigoError));
        } else {
            pais = new Long(((BigDecimal)rs.getValueAt(0,"PAIS")).longValue());
            marca = new Long(((BigDecimal)rs.getValueAt(0,"MARCA")).longValue());
            canal = new Long(((BigDecimal)rs.getValueAt(0,"CANAL")).longValue());
        }

        //Buscamos si el cliente es responsable en otra unidad administrativa
        //para el pais, marca y canal de la unidad administrativa a asignar
        parametros = new Vector();        
        consulta = new StringBuffer();
        /*consulta.append(" SELECT 'SubGerencia: ' || zon_sub_geren_venta.des_subg_vent DESCUNIDADADMIN ");
        consulta.append(" FROM zon_sub_geren_venta, mae_clien ");
        consulta.append(" WHERE mae_clien.oid_clie = zon_sub_geren_venta.clie_oid_clie ");        
        consulta.append(" AND mae_clien.oid_clie = ? ");
        parametros.add(dtoe.getOidResponsable());
        consulta.append(" AND zon_sub_geren_venta.pais_oid_pais = ? ");
        parametros.add(pais);
        consulta.append(" AND zon_sub_geren_venta.marc_oid_marc = ? ");
        parametros.add(marca);
        consulta.append(" AND zon_sub_geren_venta.cana_oid_cana = ? ");
        parametros.add(canal);
        consulta.append(" AND zon_sub_geren_venta.ind_borr = 0 ");

        consulta.append(" UNION ");*/
         
        consulta.append(" SELECT 'Region: ' || zon_regio.des_regi DESCUNIDADADMIN ");
        consulta.append(" FROM mae_clien, zon_sub_geren_venta, zon_regio ");
        consulta.append(" WHERE mae_clien.oid_clie = zon_regio.clie_oid_clie ");
        consulta.append(" AND mae_clien.oid_clie = ? ");
        parametros.add(dtoe.getOidResponsable());
        consulta.append(" AND zon_regio.zsgv_oid_subg_vent = zon_sub_geren_venta.oid_subg_vent ");
        consulta.append(" AND zon_sub_geren_venta.pais_oid_pais = ? ");
        parametros.add(pais);
        consulta.append(" AND zon_sub_geren_venta.marc_oid_marc = ? ");
        parametros.add(marca);
        consulta.append(" AND zon_sub_geren_venta.cana_oid_cana = ? ");
        parametros.add(canal);
        consulta.append(" AND zon_sub_geren_venta.ind_borr = 0 ");
        consulta.append(" AND zon_regio.ind_borr = 0 ");
              
        consulta.append(" UNION ");
         
        consulta.append(" SELECT 'Zona: ' || zon_zona.des_zona DESCUNIDADADMIN ");
        consulta.append(" FROM zon_sub_geren_venta, zon_regio, zon_zona, mae_clien ");
        consulta.append(" WHERE zon_zona.clie_oid_clie = mae_clien.oid_clie ");
        consulta.append(" AND mae_clien.oid_clie = ? ");
        parametros.add(dtoe.getOidResponsable());
        consulta.append(" AND zon_sub_geren_venta.pais_oid_pais = ? ");
        parametros.add(pais);
        consulta.append(" AND zon_sub_geren_venta.marc_oid_marc = ? ");
        parametros.add(marca);
        consulta.append(" AND zon_sub_geren_venta.cana_oid_cana = ? ");
        parametros.add(canal);
        consulta.append(" AND zon_regio.zsgv_oid_subg_vent = zon_sub_geren_venta.oid_subg_vent ");
        consulta.append(" AND zon_zona.zorg_oid_regi = zon_regio.oid_regi  ");
        consulta.append(" AND zon_zona.ind_borr = 0 ");
        consulta.append(" AND zon_sub_geren_venta.ind_borr = 0 ");
        consulta.append(" AND zon_regio.ind_borr = 0 ");
              
        /*consulta.append(" UNION ");
         
        consulta.append(" SELECT 'Seccion: ' || zon_secci.des_secci DESCUNIDADADMIN ");
        consulta.append(" FROM zon_sub_geren_venta, zon_regio, ");
        consulta.append(" zon_zona, zon_secci, mae_clien ");
        consulta.append(" WHERE zon_secci.clie_oid_clie = mae_clien.oid_clie ");
        consulta.append(" AND mae_clien.oid_clie = ? ");
        parametros.add(dtoe.getOidResponsable());
        consulta.append(" AND zon_sub_geren_venta.pais_oid_pais = ? ");
        parametros.add(pais);
        consulta.append(" AND zon_sub_geren_venta.marc_oid_marc = ? ");
        parametros.add(marca);
        consulta.append(" AND zon_sub_geren_venta.cana_oid_cana = ? ");
        parametros.add(canal);
        consulta.append(" AND zon_regio.zsgv_oid_subg_vent = zon_sub_geren_venta.oid_subg_vent ");
        consulta.append(" AND zon_zona.zorg_oid_regi = zon_regio.oid_regi ");
        consulta.append(" AND zon_secci.zzon_oid_zona = zon_zona.oid_zona ");  
        consulta.append(" AND zon_secci.ind_borr = 0 ");
        consulta.append(" AND zon_zona.ind_borr = 0 ");
        consulta.append(" AND zon_sub_geren_venta.ind_borr = 0 ");
        consulta.append(" AND zon_regio.ind_borr = 0 ");*/

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            UtilidadesLog.debug("rs: " + rs);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug("****DAOZON.validarResponsableYaAsignado: No hay datos ");				
        }
        else {
            UtilidadesLog.debug("****DAOZON.validarResponsableYaAsignado: se encontro al menos un cliente ");				
            asignado = rs.getValueAt(0,"DESCUNIDADADMIN").toString();
        }
        
        UtilidadesLog.info("DAOZON.validarResponsableYaAsignado(DTOResponsable dtoe): Salida"); 
                           
        return asignado;
    }

  /**
   * 11-06-2007   Creado por Sapaza, incidencia Sicc 20070276. Se obtiene toda la estructura de la
   *              unidad Administrativa a partir del Territorio Administrativo
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param oidTerrAdmin
   */
    public RecordSet obtenerTerritorioAdministrativo(Long oidTerrAdmin) throws MareException {
        
        UtilidadesLog.info("DAOZON.obtenerTerritorioAdministrativo(Long oidTerrAdmin): Entrada");

        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Genera la sentencia SQL.
        StringBuffer SQL = new StringBuffer();
        SQL.append(" SELECT zr.OID_REGI REGION, zz.OID_ZONA ZONA, zc.OID_SECC SECCION, zt.OID_TERR_ADMI TERR_ADM ");
        SQL.append(" FROM zon_terri_admin zt, ZON_SECCI zc, ");
        SQL.append(" ZON_ZONA zz, ZON_REGIO zr, ZON_SUB_GEREN_VENTA zsgv ");
        SQL.append(" WHERE zt.ZSCC_OID_SECC = zc.OID_SECC ");
        SQL.append(" AND zc.ZZON_OID_ZONA = zz.OID_ZONA ");
        SQL.append(" AND zz.ZORG_OID_REGI = zr.OID_REGI ");
        SQL.append(" AND zr.ZSGV_OID_SUBG_VENT = zsgv.OID_SUBG_VENT ");
        SQL.append(" AND zt.OID_TERR_ADMI = " + oidTerrAdmin);

        RecordSet rs;

        try {
            // Ejecuta la consulta.
            rs = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOZON.obtenerTerritorioAdministrativo(Long oidTerrAdmin): Salida");
        return rs;
    }

  /**
   * 13-06-2007   agregado por Sapaza, incidencia Sicc-20070276. Se activan aquellas 
   *              territorios administrativos cuyo periodo inicio sea igual al periodo pasado 
   *              como argumento (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 
   * @throws es.indra.mare.common.exception.MareException
   * @param oidPeriodo
   */
    public void activarTerritoriosAdministrativos (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.activarTerritoriosAdministrativos (Long oidPeriodo): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" UPDATE ZON_TERRI_ADMIN  "); 
        consulta.append(" SET IND_BORR = ? ");  
        consulta.append(" WHERE PERD_OID_PERI_INIC = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_INACTIVO);
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.activarTerritoriosAdministrativos (Long oidPeriodo): Salida");
    }

  /**
   * 13-06-2007   agregado por Sapaza, incidencia Sicc-20070276. Se desactivan aquellas 
   *              territorios administrativos cuyo periodo inicio sea igual al periodo pasado como argumento 
   *              (que es el periodo siguiente al periodo que se recibió como entrada para la reestructuración) 
   * @throws es.indra.mare.common.exception.MareException
   * @param oidPeriodo
   */
    public void desactivarTerritoriosAdministrativos (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.desactivarTerritoriosAdministrativos (Long oidPeriodo): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" UPDATE ZON_TERRI_ADMIN  "); 
        consulta.append(" SET IND_BORR = ? ");  
        consulta.append(" WHERE PERD_OID_PERI_FINA = ? ");

        // Parametros de la consulta
        parametros.add(ConstantesZON.IND_ACTIVO); 
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.desactivarTerritoriosAdministrativos (Long oidPeriodo): Salida");
    }

    /**
     * 03-08-2007       (Sapaza), agregado por incidencia Sicc-20070365. Se da de baja los responsables
     *                  para aquellas unidades administrativas desactivadas en el proceso
     *                  de Reestructuracion de Segunda Fase
     * @throws es.indra.mare.common.exception.MareException
     * @param indUA
     * @param oidPeriodo
     */
    private void dardebajaResponsables (Long oidPeriodo, int indUA) throws MareException {
        UtilidadesLog.info("DAOZON.dardebajaResponsables (Long oidPeriodo, int indUA): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        if(indUA == 1) { //para SGV
            consulta.append(" UPDATE ZON_HISTO_GEREN "); 
            consulta.append(" SET	 FEC_HAST = ? "); 
            consulta.append(" WHERE  OID_HIST_GERE IN "); 
            consulta.append(" 		(SELECT OID_HIST_GERE FROM ZON_HISTO_GEREN ");
            consulta.append(" 		WHERE (PAIS_OID_PAIS,MARC_OID_MARC, CANA_OID_CANA, UA) ");
            consulta.append(" 		IN (SELECT ZON_SUB_GEREN_VENTA.PAIS_OID_PAIS, ");
            consulta.append(" 			   	   ZON_SUB_GEREN_VENTA.MARC_OID_MARC, ");
            consulta.append(" 		       	   ZON_SUB_GEREN_VENTA.CANA_OID_CANA, ");            
            consulta.append(" 			       ZON_SUB_GEREN_VENTA.COD_SUBG_VENT ");
            consulta.append(" 			FROM   ZON_SUB_GEREN_VENTA, MAE_CLIEN ");
            consulta.append(" 			WHERE  ZON_SUB_GEREN_VENTA.PERD_OID_PERI_FINA = ?) ");
            consulta.append(" 		AND FEC_HAST IS NULL) ");
        } else if(indUA == 2) { //para Region
            consulta.append(" UPDATE ZON_HISTO_GEREN "); 
            consulta.append(" SET	 FEC_HAST = ? "); 
            consulta.append(" WHERE  OID_HIST_GERE IN "); 
            consulta.append(" 		(SELECT OID_HIST_GERE FROM ZON_HISTO_GEREN ");
            consulta.append(" 		WHERE (PAIS_OID_PAIS,MARC_OID_MARC, CANA_OID_CANA, UA) ");
            consulta.append(" 		IN (SELECT ZON_REGIO.PAIS_OID_PAIS, ");
            consulta.append(" 		       	   ZON_REGIO.MARC_OID_MARC, ");
            consulta.append(" 		       	   ZON_REGIO.CANA_OID_CANA, ");
            consulta.append(" 		       	   ZON_SUB_GEREN_VENTA.COD_SUBG_VENT || ZON_REGIO.COD_REGI  ");
            consulta.append(" 		    FROM ZON_SUB_GEREN_VENTA, ZON_REGIO ");
            consulta.append(" 	    	WHERE ZON_REGIO.ZSGV_OID_SUBG_VENT = ZON_SUB_GEREN_VENTA.OID_SUBG_VENT ");  
            consulta.append(" 	    	  AND ZON_REGIO.PERD_OID_PERI_FINA = ?) ");
            consulta.append(" 		AND FEC_HAST IS NULL) ");            
        } else if(indUA == 3) { //para Zona
            consulta.append(" UPDATE ZON_HISTO_GEREN "); 
            consulta.append(" SET	 FEC_HAST = ? "); 
            consulta.append(" WHERE  OID_HIST_GERE IN "); 
            consulta.append(" 		(SELECT OID_HIST_GERE FROM ZON_HISTO_GEREN ");
            consulta.append(" 		WHERE (PAIS_OID_PAIS,MARC_OID_MARC, CANA_OID_CANA, UA) ");
            consulta.append(" 		IN (SELECT   ZON_ZONA.PAIS_OID_PAIS, ");
            consulta.append(" 					 ZON_ZONA.MARC_OID_MARC, ");
            consulta.append(" 					 ZON_ZONA.CANA_OID_CANA, ");
            consulta.append(" 			         ZON_SUB_GEREN_VENTA.COD_SUBG_VENT ");
            consulta.append(" 			         || ZON_REGIO.COD_REGI ");
            consulta.append(" 			         || ZON_ZONA.COD_ZONA ");  
            consulta.append(" 			FROM  ZON_SUB_GEREN_VENTA, ZON_REGIO, ZON_ZONA ");
            consulta.append(" 			WHERE ZON_REGIO.ZSGV_OID_SUBG_VENT = ZON_SUB_GEREN_VENTA.OID_SUBG_VENT ");
            consulta.append(" 			  AND ZON_ZONA.ZORG_OID_REGI = ZON_REGIO.OID_REGI ");
            consulta.append(" 			  AND ZON_ZONA.PERD_OID_PERI_FINA = ?) ");            
            consulta.append(" 		AND FEC_HAST IS NULL) ");                        
        } else if(indUA == 4) { //para Seccion
            consulta.append(" UPDATE ZON_HISTO_GEREN "); 
            consulta.append(" SET	 FEC_HAST = ? "); 
            consulta.append(" WHERE  OID_HIST_GERE IN "); 
            consulta.append(" 		(SELECT OID_HIST_GERE FROM ZON_HISTO_GEREN ");
            consulta.append(" 		WHERE (PAIS_OID_PAIS,MARC_OID_MARC, CANA_OID_CANA, UA) ");
            consulta.append(" 		IN (SELECT   ZON_ZONA.PAIS_OID_PAIS, ");
            consulta.append(" 					 ZON_ZONA.MARC_OID_MARC, ");
            consulta.append(" 					 ZON_ZONA.CANA_OID_CANA, ");
            consulta.append(" 			         ZON_SUB_GEREN_VENTA.COD_SUBG_VENT ");
            consulta.append(" 			         || ZON_REGIO.COD_REGI ");
            consulta.append(" 			         || ZON_ZONA.COD_ZONA ");  
            consulta.append("                    || ZON_SECCI.COD_SECC ");
            consulta.append(" 			FROM  ZON_SUB_GEREN_VENTA, ZON_REGIO, ZON_ZONA, ZON_SECCI ");            
            consulta.append(" 			WHERE ZON_REGIO.ZSGV_OID_SUBG_VENT = ZON_SUB_GEREN_VENTA.OID_SUBG_VENT ");
            consulta.append(" 			  AND ZON_ZONA.ZORG_OID_REGI = ZON_REGIO.OID_REGI ");
            consulta.append("             AND ZON_SECCI.ZZON_OID_ZONA = ZON_ZONA.OID_ZONA ");            
            consulta.append(" 			  AND ZON_SECCI.PERD_OID_PERI_FINA = ?) ");            
            consulta.append(" 		AND FEC_HAST IS NULL) ");                        
        }

        // Parametros de la consulta
        parametros.add(new Timestamp(new Date(System.currentTimeMillis()).getTime())); 
        parametros.add(oidPeriodo);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOZON.dardebajaResponsables (Long oidPeriodo, int indUA): Salida");
    }
   
    public Long obtNumMinCamp(long oidPais, String cFiltro) throws MareException {
        UtilidadesLog.info("DAOZON.obtNumMinCamp(long oidPais, String CodUA): Entrada");
        Long resu = null;

        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Genera la sentencia SQL.
        StringBuffer SQL = new StringBuffer();
        SQL.append("SELECT prc.VAL_NUME_MINI_CAMP ");
        SQL.append("FROM ZON_PARAM_REING_CONSU prc ");
        SQL.append("WHERE prc.PAIS_OID_PAIS = " + oidPais);
        SQL.append(" AND upper(prc.TIPO_DE_UA) = '" + cFiltro + "'");

        RecordSet rs;

        try {
            // Ejecuta la consulta.
            rs = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if ((rs!=null) && (rs.getRowCount()>0)){
            BigDecimal d = (BigDecimal) rs.getValueAt(0, 0);
            resu = Long.valueOf(d.toString());
            UtilidadesLog.debug("numero min campañas: " + resu);
        }else{
            UtilidadesLog.debug("sin registros....");
        }
        UtilidadesLog.info("DAOZON.obtNumMinCamp(long oidPais, String CodUA): Salida");
        return resu;
    }
    
    public Date buscoDataHistoResp(long oidMarca, long oidCanal, String codResponsable) throws MareException {
        UtilidadesLog.info("DAOZON.buscoDataHistoResp(long oidMarca, long oidCanal, String CodUA): Entrada");
        Date resu = null;
        
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Genera la sentencia SQL.
        StringBuffer SQL = new StringBuffer();
        SQL.append("SELECT hg.FEC_HAST ");
        SQL.append("FROM ZON_HISTO_GEREN hg ");
        SQL.append("WHERE hg.MARC_OID_MARC = " + oidMarca);
        SQL.append(" AND hg.CANA_OID_CANA = " + oidCanal);
        
        //se cambia a pedido de BEL (01/07/2008) SQL.append(" AND hg.UA = '" + CodUA.trim() + "'");
        SQL.append(" AND hg.GERE = '" + codResponsable + "'");
        
        SQL.append(" ORDER BY hg.FEC_HAST DESC NULLS LAST");
        
        RecordSet rs;

        try {
            // Ejecuta la consulta.
            rs = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if ((rs!=null) && (rs.getRowCount()>0)){
            resu = ((Date)rs.getValueAt(0, 0));
            UtilidadesLog.debug("mayor fecha hasta: " + resu);
        }else{
            UtilidadesLog.debug("sin registros....");
        }
        UtilidadesLog.info("DAOZON.buscoDataHistoResp(long oidMarca, long oidCanal, String CodUA): Salida");
        return resu;
    }

    public Date obtenerFechaInicDelPeriodo(long oidPais, 
                                           long oidMarca, 
                                           long oidCanal,
                                           Date mayFechHasta) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerFechaInicDelPeriodo(long oidPais, long oidMarca, long oidCanal, Date mayFechHasta): Entrada");
        Date resu = null;
        
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Genera la sentencia SQL.
        StringBuffer SQL = new StringBuffer();
        SQL.append("SELECT cp.FEC_INIC ");
        SQL.append("FROM CRA_PERIO cp ");
        SQL.append("WHERE cp.PAIS_OID_PAIS = " + oidPais);
        SQL.append(" AND cp.MARC_OID_MARC = " + oidMarca);
        SQL.append(" AND cp.CANA_OID_CANA = " + oidCanal);
        SQL.append(" AND cp.FEC_INIC <= TO_DATE( '" + mayFechHasta + "', 'yyyy-MM-dd') ");
        SQL.append(" AND cp.FEC_FINA >= TO_DATE( '" + mayFechHasta + "', 'yyyy-MM-dd') ");
        SQL.append(" ORDER BY cp.FEC_INIC DESC NULLS LAST");

        RecordSet rs;

        try {
            // Ejecuta la consulta.
            rs = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if ((rs!=null) && (rs.getRowCount()>0)){
            resu = ((Date)rs.getValueAt(0, 0));
            UtilidadesLog.debug("mayor fecha inicio del periodo: " + resu);
        }else{
            UtilidadesLog.debug("sin registros....");
        }
        
        UtilidadesLog.info("DAOZON.obtenerFechaInicDelPeriodo(long oidPais, long oidMarca, long oidCanal, Date mayFechHasta): Salida");
        return resu;
    }
  
    public Date obtenerFechaInicioPeriodoAct(long oidPais, 
                                           long oidMarca, 
                                           long oidCanal) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerFechaInicioPeriodoAct(long oidPais, long oidMarca, long oidCanal): Entrada");
        Date resu = null;
        
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sFecha;
        java.sql.Date fecha = null;        
        fecha = new java.sql.Date(System.currentTimeMillis());
        sFecha = sdf.format(fecha);

        // Genera la sentencia SQL.
        StringBuffer SQL = new StringBuffer();
        SQL.append("SELECT cp.FEC_INIC ");
        SQL.append("FROM CRA_PERIO cp ");
        SQL.append("WHERE cp.PAIS_OID_PAIS = " + oidPais);
        SQL.append(" AND cp.MARC_OID_MARC = " + oidMarca);
        SQL.append(" AND cp.CANA_OID_CANA = " + oidCanal);
        SQL.append(" AND cp.FEC_INIC <= TO_DATE( '" + sFecha + "', 'YYYY-MM-DD HH24:MI:SS') ");
        SQL.append(" AND cp.FEC_FINA >= TO_DATE( '" + sFecha + "', 'YYYY-MM-DD HH24:MI:SS') ");
        SQL.append(" ORDER BY cp.FEC_INIC DESC NULLS LAST");

        RecordSet rs;
        try {
            // Ejecuta la consulta.
            rs = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if ((rs!=null) && (rs.getRowCount()>0)){
            resu = ((Date)rs.getValueAt(0, 0));
            UtilidadesLog.debug("mayor fecha inicio del periodo actual: " + resu);
        }else{
            UtilidadesLog.debug("sin registros....");
        }
        UtilidadesLog.info("DAOZON.obtenerFechaInicioPeriodoAct(long oidPais, long oidMarca, long oidCanal): Salida");
        return resu;
    }

    public long obtNumPerDif(long oidPais,
                             long oidMarca, 
                             long oidCanal,
                             Date fechaInicioUltimoPeriodo, 
                             Date fechaInicioPeriodoAct) throws MareException {
        UtilidadesLog.info("DAOZON.obtNumPerDif(Date fechaInicioUltimoPeriodo, Date fechaInicioPeriodoAct): Entrada");
        long resu = 0;
        
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        StringBuffer SQL = new StringBuffer();
        SQL.append("SELECT COUNT(*) AS numPeriDife ");
        SQL.append("FROM CRA_PERIO cp ");
        SQL.append("WHERE cp.PAIS_OID_PAIS = " + oidPais);
        SQL.append(" AND cp.MARC_OID_MARC = " + oidMarca);
        SQL.append(" AND cp.CANA_OID_CANA = " + oidCanal);
        //se cambia a pedido de BEL (01/07/2008) SQL.append(" AND hg.UA = '" + CodUA.trim() + "'");
        SQL.append(" AND cp.FEC_INIC >= TO_DATE( '" + fechaInicioUltimoPeriodo + "', 'yyyy-MM-dd') ");
        SQL.append(" AND cp.FEC_INIC < TO_DATE( '" + fechaInicioPeriodoAct + "', 'yyyy-MM-dd') ");

        RecordSet rs;
        try {
            // Ejecuta la consulta.
            rs = bs.dbService.executeStaticQuery(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if ((rs!=null) && (rs.getRowCount()>0)){
            resu = ((BigDecimal)rs.getValueAt(0,0)).longValue();
            UtilidadesLog.debug("num periodos dife: " + resu);
        }else{
            UtilidadesLog.debug("sin registros....");
        }
        UtilidadesLog.info("DAOZON.obtNumPerDif(Date fechaInicioUltimoPeriodo, Date fechaInicioPeriodoAct): Salida");
        return resu;
    }

    // sapaza -- PER-SiCC-2011-0928 -- 12/04/2012
    public RecordSet obtenerDatosCampañaAnterior(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOZON.obtenerDatosCampañaAnterior(Long oidPeriodo): Entrada ");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT OID_PERI, FEC_FINA ");
        query.append(" FROM ( ");
        query.append("       SELECT B.oid_peri, B.Fec_Fina ");
        query.append("         FROM cra_perio A, cra_perio B, seg_perio_corpo C, seg_perio_corpo D ");
        query.append("        WHERE A.oid_peri = " + oidPeriodo);
        query.append("          AND B.pais_oid_pais = A.pais_oid_pais ");
        query.append("          AND B.marc_oid_marc = A.marc_oid_marc ");
        query.append("          AND B.cana_oid_cana = A.cana_oid_cana ");
        query.append("          AND A.peri_oid_peri = C.oid_peri ");
        query.append("          AND B.peri_oid_peri = D.oid_peri ");
        query.append("          AND D.cod_peri < C.cod_peri ");
        query.append(" ORDER BY D.cod_peri DESC) "); 
        query.append(" WHERE ROWNUM <= 1 "); 
        
        //ejecución de la consulta
         BelcorpService bs;
         try {
           bs = BelcorpService.getInstance();
         }
         catch(MareMiiServiceNotFoundException ex) {
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }
         
        RecordSet rs = new RecordSet();
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        UtilidadesLog.info("DAOZON.obtenerDatosCampañaAnterior(Long oidPeriodo): Salida ");
        return rs;
    }  
    
}
