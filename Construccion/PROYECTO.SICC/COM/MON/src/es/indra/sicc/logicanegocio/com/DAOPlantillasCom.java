/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DAOPlantillasCom
 * Fecha:             08/02/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-202-334
 * Descripcion:       DAOPlantillasCom
 * @version           1.0
 * @autor             Marta Aurora Montiel
 */

package es.indra.sicc.logicanegocio.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.dtos.com.DTOBusquedaAccesosPlantilla;
import es.indra.sicc.dtos.com.DTOPlantillaDetalle;
import es.indra.sicc.dtos.com.DTOBusquedaPlantillas;

import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.util.Vector;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import java.sql.Date;

public class DAOPlantillasCom 
{
  public DAOPlantillasCom()
  {  
  }
  
  /*
   *Autor: Marta Montiel
   * Fecha: 15/02/05
   */ 
   public RecordSet obtenerTipoComision( DTOBelcorp dto) throws MareException {
   /*
    * Acceder a la entidad COM:TipoPlantilla 
      Obtener: 
    - oid 
    - descripcion (internacionalizable)
    * */
      UtilidadesLog.info("DAOPlantillasCom.obtenerTipoComision(DTOBelcorp dto): Entrada");
      BelcorpService belcorpService = null;
      RecordSet rs = null;
      StringBuffer query = null;
       try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        /* INCIDENCIA 13326 CUANDO LA RESPONDAN CORREGIR EL COD_PLAN POR AL DECRIPCION
         * INTERNACIONALIZABLE*/
        try {
            query = new StringBuffer();
            query.append(" SELECT OID_TIPO_PLAN OID,  gen.VAL_I18N DESCRIPCION   ");
            query.append(" FROM COM_TIPO_PLANT a,V_GEN_I18N_SICC gen ");
            query.append(" WHERE gen.ATTR_ENTI = 'COM_TIPO_PLANT' ");
            query.append(" AND gen.ATTR_NUM_ATRI = 1 ");
            query.append(" AND gen.IDIO_OID_IDIO = 1 ");
            query.append(" AND gen.VAL_OID = a.OID_TIPO_PLAN ");            
            query.append(" ORDER BY DESCRIPCION ");

            UtilidadesLog.debug("query: " + query.toString());

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }      
        UtilidadesLog.info("DAOPlantillasCom.obtenerTipoComision(DTOBelcorp dto): Salida");
        return rs;
   }
   
   /*
    * autor Marta Aurora Montiel
    * fecha 14/02/05
    * */
   public RecordSet obtenerPlantillasCom( DTOSiccPaginacion dto) throws MareException {
   /*
    * //Se trata de obtener de la entidad PlantillasComisiones, aquellas plantillas con estado activo. 
      Acceder a la entidad PlantillasComisiones A y GEN_i18n_SICC B (haciendo join entre ellas) filtrando por: //No se debe filtrar por el pais, pues hay n plantillas para n paises. 
      B.IDIO_OID_IDIO=DTOE.idioma //idioma de la sesion 
      A.oidEstado=COMConstantes.ESTADO_ACTIVO 
      B.VAL_OID=A.oid (join) 
      y obtener: 
      A.oid 
      B.VAL_I18N (descripcion internacionalizable)
    * */
     UtilidadesLog.info("DAOPlantillasCom.obtenerPlantillasCom(DTOBelcorp dto): Entrada");
     StringBuffer query = new StringBuffer();
     RecordSet rs;
    
     BelcorpService bs = UtilidadesEJB.getBelcorpService();
     query.append(" select distinct OID_PLAN_COMI OID, i.VAL_I18N DESCRIPCION ");
     query.append(" from COM_PLANT_COMIS pc , V_GEN_I18N_SICC i ");
     query.append(" where CEST_OID_ESTA = " + ConstantesCOM.ESTADO_ACTIVO ); 
     query.append(" AND i.ATTR_NUM_ATRI = 1 ");
     query.append(" AND i.ATTR_ENTI = 'COM_PLANT_COMIS' ");
     query.append(" AND i.IDIO_OID_IDIO = " + dto.getOidIdioma() );
     query.append(" AND  i.VAL_OID = OID_PLAN_COMI ");
     String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);     

     UtilidadesLog.debug(query.toString());
     
     try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(sqlPaginada.toString());
        if(rs.esVacio()){
           throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
     }catch (Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }
     UtilidadesLog.debug("el resultado de obtenerPlantillasCom   es  "  + rs);
     UtilidadesLog.info("DAOPlantillasCom.obtenerPlantillasCom(DTOBelcorp dto): Salida");
     return rs;
   }
    /*
   *Autor: Marta Montiel
   * Fecha: 15/02/05
   */ 
   public DTOPlantillaDetalle obtenerDetallePlantilla( DTOOID dto) throws MareException {
   /*
    * Se accede a las entidades PlantillasComisiones A, PlantillasComisionesPais B, PlantillasComisionesAcceso C, PlantillasComisionesMarca D, haciendo un join entre ellas, 
      filtrando por: 
      - A.oid=DTOE.oid 
      - A.oidEstado= 'ESTADO_ACTIVO' 
      - y los de las join: PlantillasComisiones con PlantillasComisionesPais 
      PlantillasComisiones con PlantillasComisionesAcceso 
      PlantillasComisiones con PlantillasComisionesMarca 
      Obtener: 
      de PlantillasComisiones: - oidPlantilla 
      - codPlantilla 
      - descripcionPlantilla (internacionalizable) 
      - oidCanal 
      - descripcionCanal (internacionalizable) 
      - descripcionEstado (internacionalizable) 
      - fechaUltimoEstado 
      - oidPais 
      - oidAcceso 
      - oidMarca 
      - oidTipoPlantilla 
      - comparativo 
      - tratamientoDiferencial        
    * */
    UtilidadesLog.info("DAOPlantillasCom.obtenerDetallePlantilla(DTOOID dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs;
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    DTOPlantillaDetalle dtoe = new DTOPlantillaDetalle();
   
    query.append(" SELECT a.OID_PLAN_COMI OID, ");
 		query.append(" a.COD_PLAN_COMI CODIGOPLANTILLA,  "); 
		query.append(" a.CANA_OID_CANA OIDCANAL,  ");
    query.append(" gen.VAL_I18N DESCRIPCIONCANAL,  ");
		query.append(" gen1.VAL_I18N DESCRIPESTADO ,  ");
    query.append(" a.FEC_ULTI_ESTA FECHAULTACT, ");
		query.append(" a.TPLA_OID_TIPO_PLAN OIDTIPOPLAN,  ");
		query.append(" a.IND_COMP INDCOMPARATIVO,  ");
		query.append(" a.IND_TRAT_DIFE INDTRATAMIENTODIF, ");
    query.append(" genPlant.VAL_I18N DESC_PLANTILLA ");
    query.append(" FROM  V_GEN_I18N_SICC gen, V_GEN_I18N_SICC gen1,COM_PLANT_COMIS a  , V_GEN_I18N_SICC genPlant ");
    query.append(" WHERE gen.ATTR_ENTI = 'SEG_CANAL'  ");
    query.append(" AND gen.ATTR_NUM_ATRI = 1  ");
    query.append(" AND gen.IDIO_OID_IDIO =  " + dto.getOidIdioma()+" ");
    query.append(" AND gen.VAL_OID = a.CANA_OID_CANA  ");
    query.append(" AND gen1.ATTR_ENTI = 'COM_ESTAD'  ");
    query.append(" AND gen1.ATTR_NUM_ATRI = 1   ");
    query.append(" AND gen1.IDIO_OID_IDIO = " + dto.getOidIdioma()+" ");
    query.append(" AND gen1.VAL_OID = a.CEST_OID_ESTA  ");
    //query.append(" AND a.IND_COMP = 1  "); error incidencia 14009 de pruebas y no encontre en el dc el motivo
	  query.append(" AND a.OID_PLAN_COMI =  " + dto.getOid());
    query.append(" AND a.CEST_OID_ESTA =  " + ConstantesCOM.ESTADO_ACTIVO ); //incidencia BELC300016895
    query.append(" AND genPlant.ATTR_ENTI = 'COM_PLANT_COMIS' ");
    query.append(" AND genPlant.ATTR_NUM_ATRI = 1 ");
    query.append(" AND genPlant.IDIO_OID_IDIO = " + dto.getOidIdioma()+" ");
    query.append(" AND genPlant.VAL_OID = a.OID_PLAN_COMI ");
    
     
     UtilidadesLog.debug(query.toString());
   
     try {
         rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
         UtilidadesLog.debug(rs);
         /*if( rs.esVacio() ){
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }*/
      }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
     if( !rs.esVacio() ){
             
             /* 0- a.OID_PLAN_COMI OID,
               1- a.COD_PLAN_COMI CODIGOPLANTILLA,  
               2- a.CANA_OID_CANA OIDCANAL, 
               3-	gen.VAL_I18N DESCRIPCIONCANAL, 
               4- gen1.VAL_I18N DESCRIPESTADO , 
               5- a.FEC_ULTI_ESTA FECHAULTACT,
               6- a.TPLA_OID_TIPO_PLAN OIDTIPOPLAN, 
               7- a.IND_COMP INDCOMPARATIVO, 
              8- a.IND_TRAT_DIFE INDTRATAMIENTODIF
              9- genPlant.VAL_I18N DESC_PLANTILLA*/
          for( int i = 0; i< rs.getRowCount(); i++){    
                 BigDecimal bg = (BigDecimal)rs.getValueAt(i,0);
                 dtoe.setOidPlantilla(new Long(bg.longValue()));
                 bg = (BigDecimal)rs.getValueAt(i,1);
                 dtoe.setCodPlantilla(new Long(bg.longValue()));
                 bg = (BigDecimal)rs.getValueAt(i,2);
                 dtoe.setOidCanal(new Long(bg.longValue()));                  
                 dtoe.setCanal((String)rs.getValueAt(i,3));
                 dtoe.setDescripcion( (String)rs.getValueAt(i,9) );                 
                 dtoe.setEstado((String)rs.getValueAt(i,4));
                 dtoe.setFechaUltimoEstado((Date)rs.getValueAt(i,5));  //rs.getValueAt(i,5)
                 
                 bg = ( rs.getValueAt(i,6)!=null?(BigDecimal)rs.getValueAt(i,6):null );
                 dtoe.setOidTipoComision(bg==null?null:new Long(bg.longValue())); //
                 bg = ( rs.getValueAt(i,7)!=null?(BigDecimal)rs.getValueAt(i,7):null );
                 dtoe.setComparativo( bg==null?"":bg.toString() );    //rs.getValueAt(i,7)
                 bg = ( rs.getValueAt(i,8)!=null?(BigDecimal)rs.getValueAt(i,8):null );
                 dtoe.setTratamientoDiferencial(bg==null?"":bg.toString()); //rs.getValueAt(i,8)
             }    
                RecordSet rsPais = new RecordSet();
                RecordSet rsMarca = new RecordSet();
                RecordSet rsAcceso = new RecordSet();
                RecordSet rsDescri = new RecordSet();
                query = new StringBuffer();
                bs = UtilidadesEJB.getBelcorpService();
                
                
                /* Obtiene todos los paises para una plantillacomision activa */
                query.append(" SELECT DISTINCT PAIS_OID_PAIS ");
                query.append(" FROM COM_PLANT_COMIS a  ");
                query.append(" JOIN COM_PLANT_COMIS_PAIS d ON ( d.PLCO_OID_PLAN_COMI = a.OID_PLAN_COMI ) ");
                query.append(" WHERE a.OID_PLAN_COMI = " + dto.getOid());
                query.append(" AND a.CEST_OID_ESTA =  " + ConstantesCOM.ESTADO_ACTIVO); 
                UtilidadesLog.debug(query.toString());
   
                try {
                     rsPais = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
                     UtilidadesLog.debug(rs);
                }catch (Exception e) {
                     UtilidadesLog.error(e);
                     throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                
                /* Obtiene todas los accesos para una plantillacomision activa */
                query = new StringBuffer();
                query.append(" SELECT DISTINCT ACCE_OID_ACCE ");
                query.append(" FROM COM_PLANT_COMIS a ");
                query.append(" JOIN COM_PLANT_COMIS_ACCES b ON ( b.PLCO_OID_PLAN_COMI = a.OID_PLAN_COMI ) ");
                query.append(" WHERE a.OID_PLAN_COMI = " + dto.getOid());
                query.append(" AND a.CEST_OID_ESTA = " + ConstantesCOM.ESTADO_ACTIVO );
                UtilidadesLog.debug(query.toString());
   
                try {
                     rsAcceso = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
                     UtilidadesLog.debug(rs);
                }catch (Exception e) {
                     UtilidadesLog.error(e);
                     throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                
                
                /* Obtiene todas las marcas para una plantillacomision activa */
                query = new StringBuffer();
                query.append(" SELECT DISTINCT MARC_OID_MARC ");
                query.append(" FROM COM_PLANT_COMIS a ");
                query.append(" JOIN COM_PLANT_COMIS_MARCA c ON ( c.PLCO_OID_PLAN_COMI = a.OID_PLAN_COMI ) ");
                query.append(" WHERE a.OID_PLAN_COMI = " + dto.getOid());
                query.append(" AND a.CEST_OID_ESTA = " + ConstantesCOM.ESTADO_ACTIVO );
                UtilidadesLog.debug(query.toString());
   
                try {
                     rsMarca = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
                     UtilidadesLog.debug(rs);
                }catch (Exception e) {
                     UtilidadesLog.error(e);
                     throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                 
                 /* seteo en el dto los oids de pais */
                 Long[] oids = new Long[rsPais.getRowCount()]; 
                 for(int i=0; i<rsPais.getRowCount(); i++){
                    BigDecimal bgOid = (BigDecimal)rsPais.getValueAt(i,0);
                    oids[i]= new Long(bgOid.longValue());
                 }
                 dtoe.setArrayPais(oids);
                 
                 /* seteo en el dto los oids de marca */
                 oids = new Long[rsMarca.getRowCount()]; 
                 for(int i=0; i<rsMarca.getRowCount(); i++){
                    BigDecimal bgOid = (BigDecimal)rsMarca.getValueAt(i,0);
                    oids[i]= new Long(bgOid.longValue());
                 }
                 dtoe.setArrayMarca(oids);
                 
                 /* seteo en el dto los oids de accesos */
                 oids = new Long[rsAcceso.getRowCount()]; 
                 for(int i=0; i<rsAcceso.getRowCount(); i++){
                    BigDecimal bgOid = (BigDecimal)rsAcceso.getValueAt(i,0);
                    oids[i]= new Long(bgOid.longValue());
                 }
                 dtoe.setArrayAcceso(oids);
                 /*
                 Obtiene todas las descripciones intencacionalizables de la entidad Plantillas COmisiones
                query = new StringBuffer();
                query.append( " SELECT VAL_I18N DESCRIPCION " );
                query.append( " FROM V_GEN_I18N_SICC gen, COM_PLANT_COMIS a " );
                query.append( " WHERE gen.ATTR_ENTI = 'COM_PLANT_COMIS' " );
                query.append( " AND gen.ATTR_NUM_ATRI = 1 " );
                query.append( " AND gen.IDIO_OID_IDIO =  " + dto.getOidIdioma() );
                query.append( " AND gen.VAL_OID = " + dto.getOid() );
                query.append( " AND gen.VAL_OID = a.OID_PLAN_COMI " );
                query.append( " AND a.CEST_OID_ESTA =  " + ConstantesCOM.ESTADO_ACTIVO );
                UtilidadesLog.debug(query.toString());
   
                try {
                     rsDescri = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
                     UtilidadesLog.debug(rs);
                }catch (Exception e) {
                     throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                
                 seteo todas las descripciones 
                
                DTOI18nSICC[] dtoInt = new DTOI18nSICC[rsDescri.getRowCount()];
                DTOI18nSICC dtoeINT;
                for(int i =0; i<rsDescri.getRowCount(); i++){
                    dtoeINT = new DTOI18nSICC();
                    dtoeINT.setValorI18n(String.valueOf(rsDescri.getValueAt(i,0)));
                    dtoInt[i] = dtoeINT;
                }
                dtoe.setAttriTraducible(dtoInt);*/
     }
                 /*
                1- a.OID_PLAN_COMI OID
                2- a.COD_PLAN_COMI
                3- gen.VAL_I18N descriPlantilla
                4- a.CANA_OID_CANA
                5- gen2.VAL_I18N descriCanal
                6- gen3.VAL_I18N descriEstado
                7- b.OID_PLAN_COMI_ACCE
                8- c.MARC_OID_MARC
                9- a.TPLA_OID_TIPO_PLAN
                10- a.IND_COMP
                11- a.IND_TRAT_DIFE
                  * */
      UtilidadesLog.debug(dtoe);
      UtilidadesLog.info("DAOPlantillasCom.obtenerDetallePlantilla(DTOOID dto): Salida");
      return dtoe;
   } 
    
   /*
   *Autor: Marta Montiel
   * Fecha: 15/02/05
   */  
   public RecordSet obtenerEstadoPlantilla( DTOBelcorp dtoe) throws MareException {
         /*
          * Acceder a la entidad COM:Estado 
            Obtener: 
            - oid 
            - descripcion (internacionalizable)
          * */
           UtilidadesLog.info("DAOPlantillasCom.obtenerEstadoPlantilla(DTOBelcorp dtoe): Entrada");
           StringBuffer query = new StringBuffer();
           RecordSet rs;
           RecordSet rsalida = new RecordSet();
          
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
           query.append(" SELECT OID_ESTA OID, gen.VAL_I18N DESCRIPCION ");
           query.append(" FROM COM_ESTAD A, V_GEN_I18N_SICC gen ");
           query.append(" WHERE gen.ATTR_ENTI = 'COM_ESTAD' ");
           query.append(" AND gen.ATTR_NUM_ATRI = 1 ");
           query.append(" AND gen.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
           query.append(" AND gen.VAL_OID = a.OID_ESTA ");
           query.append(" ORDER BY DESCRIPCION ");
            
            //String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);
           UtilidadesLog.debug(query.toString());
         
           try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
            }catch (Exception e) {
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }           
            UtilidadesLog.info("DAOPlantillasCom.obtenerEstadoPlantilla(DTOBelcorp dtoe): Salida");
            return rs;
   }
   /*
   *Autor: Marta Montiel
   * Fecha: 14/02/05
   */ 
   public RecordSet buscarPlantillasComisiones( DTOBusquedaPlantillas dtoe) throws MareException {
   /*
    * Obtiene las plantillas que cumplen el criterio especificado por el usuario. 
      Búsqueda paginada. 
      Se accede a las entidades PlantillasComisiones A, PlantillasComisionesPais B (join con A), PlantillasComisionesAcceso C (join con A), PlantillasComisionesMarca D (join con A), , TipoPlantilla E (join con A), Estado F (join con A) 
      filtrando por: //aquellos que no sean nulos 
      - A.codigo=DTOE.codPlantilla 
      - E.descripcionPlantilla = DTOE.descripcion 
      - B.oidPais = DTOE.oidPais 
      - D.oidMarca = DTOE.oidMarca 
      - A.oidCanal = DTOE.oidCanal 
      - C. oidAcceso = DTOE.oidAcceso 
      - A.oidEstado =DTOE.oidEstado 
      - y los de las join 
       * */   
          UtilidadesLog.debug("DAOPlantillasCom.buscarPlantillasComisiones(DTOBusquedaPlantillas dtoe): Entrada");
          StringBuffer query = new StringBuffer();
          RecordSet rs;
          RecordSet rsalida = new RecordSet();
          
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          query.append("SELECT * FROM (");
          query.append(" SELECT distinct a.OID_PLAN_COMI OID, a.COD_PLAN_COMI CODIGOPLANTILLA, ");
          query.append(" 		   	 gen.VAL_I18N DESCRIPLANTILLA , '' DESCRIPAIS, '' DESCRIMARCA, ");
          query.append(" 			 gen2.VAL_I18N descriCanal, '' DESCRIACCESO , gen4.VAL_I18N DESCRITIPOPLANTILLA, ");
          query.append(" 			 a.IND_COMP, a.IND_TRAT_DIFE,  gen3.VAL_I18N DESCRIESTADO ");
          query.append(" FROM COM_PLANT_COMIS a LEFT OUTER JOIN COM_TIPO_PLANT e  ON (a.TPLA_OID_TIPO_PLAN  = e.OID_TIPO_PLAN  ");
          query.append("		   ) "); 
          query.append(" 	  LEFT OUTER JOIN V_GEN_I18N_SICC gen4  ON ( (a.TPLA_OID_TIPO_PLAN = gen4.VAL_OID )  "); 
          query.append(" 	  	   AND (gen4.ATTR_ENTI = 'COM_TIPO_PLANT' OR gen4.ATTR_ENTI IS NULL)  ");
          query.append(" 	  	   AND (gen4.ATTR_NUM_ATRI = 1 OR gen4.ATTR_NUM_ATRI IS NULL) ");
          query.append(" 	  	   AND (gen4.IDIO_OID_IDIO = 1 OR gen4.IDIO_OID_IDIO IS NULL) )");
          query.append(" 	  JOIN COM_ESTAD f ON ( f.OID_ESTA = a.CEST_OID_ESTA ) ");
          query.append(" 	  JOIN COM_PLANT_COMIS_ACCES b ON ( b.PLCO_OID_PLAN_COMI = a.OID_PLAN_COMI  ");
        
          query.append("		   ) "); 
          query.append(" 	  JOIN COM_PLANT_COMIS_MARCA c ON ( c.PLCO_OID_PLAN_COMI = a.OID_PLAN_COMI  ");
        
          query.append("		   ) "); 
          query.append(" 	  JOIN COM_PLANT_COMIS_PAIS d ON ( d.PLCO_OID_PLAN_COMI = a.OID_PLAN_COMI  ");
     
          query.append("		   ) "); 
          query.append("    JOIN V_GEN_I18N_SICC gen ON ( gen.ATTR_ENTI = 'COM_PLANT_COMIS' ");
          query.append(" 		   AND gen.ATTR_NUM_ATRI = 1  "); 
          query.append(" 		   AND gen.IDIO_OID_IDIO = " + dtoe.getOidIdioma() );
          query.append(" 		   AND gen.VAL_OID = a.OID_PLAN_COMI ");
     
          query.append("		   ) "); 
          query.append("	  JOIN V_GEN_I18N_SICC gen2 ON ( gen2.ATTR_ENTI = 'SEG_CANAL' ");
          query.append(" 		   AND gen2.ATTR_NUM_ATRI = 1 "); 
          query.append(" 		   AND gen2.IDIO_OID_IDIO = " + dtoe.getOidIdioma() );
          query.append(" 		   AND gen2.VAL_OID = a.CANA_OID_CANA ) ");
          query.append(" 	  JOIN V_GEN_I18N_SICC gen3 ON ( gen3.ATTR_ENTI = 'COM_ESTAD' ");
          query.append(" 		   AND gen3.ATTR_NUM_ATRI = 1   ");                  
          query.append(" 		   AND gen3.IDIO_OID_IDIO = " + dtoe.getOidIdioma() );
          query.append(" 		   AND gen3.VAL_OID = f.OID_ESTA )"); 
          query.append(" 	   ");
          query.append(" WHERE "); 
          query.append("          1=1");
          if(dtoe.getOidCanal()!=null){
              query.append(" 	   AND (a.CANA_OID_CANA = " + dtoe.getOidCanal() +") ");   
          }
          if(dtoe.getCodPlantilla()!=null){
              query.append(" 	   AND (a.COD_PLAN_COMI = " + dtoe.getCodPlantilla() +") ");    
          }          
          if(dtoe.getOidEstado()!=null){
              query.append(" 	   AND (a.CEST_OID_ESTA = " + dtoe.getOidEstado() +") ");    
          }   
            if(dtoe.getOidAcceso() != null){
              query.append(" 	   AND (b.ACCE_OID_ACCE = " + dtoe.getOidAcceso() + ") ");
          }
            if(dtoe.getOidMarca() != null){
              query.append(" 	   AND (c.MARC_OID_MARC = " + dtoe.getOidMarca() +") " );
          }
          if(dtoe.getOidPaisPlanti() != null){
             query.append(" 	   AND d.PAIS_OID_PAIS = " + dtoe.getOidPaisPlanti() );
          }
           if(dtoe.getDescripcion() != null && !dtoe.getDescripcion().equals("") ){
              query.append(" 	   AND gen.VAL_I18N LIKE '" + dtoe.getDescripcion() + "'" );
          }
          
          query.append(" ORDER BY OID  ");
          query.append(" ) WHERE ROWNUM <=  "+dtoe.getTamanioPagina()); 
          query.append(" AND OID >  " + dtoe.getIndicadorSituacion());                                     
          UtilidadesLog.debug(query.toString());
          
         // String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);
     
     try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        /*
        * se obtiene
        *  El DTOSalida por tanto contendra los siguientes campos:       
        OID, CODPLANTILLA, DESCRIPICION, PAIS, MARCA, CANAL, ACCESO, TIPOCOMISION
        COMPARTATIVO, TRATDIFERENCIAL, ESTADO*********
        0 a.OID_PLAN_COMI OID
        1 a.COD_PLAN_COMI CODPLANTILLA
        2 gen.VAL_I18N descriPlantilla
        3 gen2.VAL_I18N descriCanal 
        4 a.IND_COMP
        5 a.IND_TRAT_DIFE
        6 '' descriPais
        7 '' descriAcceso
        8 '' descriMarca
        9 gen3.VAL_I18N descriEstado
        10 gen4.VAL_I18N descriTipoPlantilla
        * */
        UtilidadesLog.debug("cuando entra al try tiene :" + query.length() + " registros");
        if(!rs.esVacio()){
        
                /* 0- OID
                1- CODPLANTILLA
                2- DESCRIPLANTILLA
                3- DESCRICANAL    pias
                4- IND_COMPARATIVO   marca
                5 -IND_TRAT_DIFE  canal
                6- DESCRIPAIS  acceso
                7- DESCRIACCESO   tipocomision
                8- DESCRIMARCA   comparativo
                9- DESCRIESTADO   tratadiferencialanti
                10- DESCRITIPOPLANTILLA  estado
                */
        
                rsalida.addColumn("OID");
                rsalida.addColumn("CODPLANTILLA");
                rsalida.addColumn("DESCRIPLANTILLA");
                rsalida.addColumn("DESCRIPAIS");
                rsalida.addColumn("DESCRIMARCA");
                rsalida.addColumn("DESCRICANAL");
                rsalida.addColumn("DESCRIACCESO");
                rsalida.addColumn("DESCRITIPOPLANTILLA");
                rsalida.addColumn("IND_COMPARATIVO");
                rsalida.addColumn("IND_TRAT_DIFE");
                rsalida.addColumn("DESCRIESTADO");
                
                for( int i = 0; i< rs.getRowCount(); i++){
                    Vector vc = rs.getRow(i);
                    BigDecimal bgPlanti = (BigDecimal)vc.get(0);
                    Long oidPlantilla = new Long(bgPlanti.longValue());
                    //Busco en la entidad Plantilla Comision Paises            
                    RecordSet rsPais;
                    RecordSet rsMarca;
                    RecordSet rsAcceso;
                    query = new StringBuffer();
                    bs = UtilidadesEJB.getBelcorpService();
                    query.append(" select  distinct gen.VAL_I18N ");
                    query.append(" from V_GEN_I18N_SICC gen ");
                    query.append(" where gen.VAL_OID in ( ");
                    query.append(" select distinct PAIS_OID_PAIS ");
                    query.append(" from COM_PLANT_COMIS_PAIS ");
                    query.append(" where PLCO_OID_PLAN_COMI =  " + oidPlantilla);
                    if(dtoe.getOidPaisPlanti()!=null){
                        query.append(" AND PAIS_OID_PAIS = " + dtoe.getOidPaisPlanti());    
                    }
                    query.append(" ) ");
                    query.append(" AND gen.ATTR_ENTI = 'SEG_PAIS' ");
                    query.append(" AND gen.ATTR_NUM_ATRI = 1 ");
                    query.append(" AND gen.IDIO_OID_IDIO = " + dtoe.getOidIdioma() );
                    query.append(" order by  gen.VAL_I18N ");
                
                    rsPais = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
                    String strPais="";
                    //cargo en un string todos los paises , para luego seterlo al recorset de salida
                   
                    for( int a=0; a<rsPais.getRowCount(); a++){
                          UtilidadesLog.debug(rsPais.getValueAt(a,0));
                          
                          if(a==0){
                              strPais = (String)rsPais.getValueAt(a,0);
                          }else{
                              strPais = strPais + (String)rsPais.getValueAt(a,0);
                          }                 
                    }
                    
                    
                    //Busco en la entidad Plantilla Comision Marca
                    query = new StringBuffer();
                    bs = UtilidadesEJB.getBelcorpService();
                    /*query.append(" select distinct gen.VAL_I18N ");
                    query.append(" from V_GEN_I18N_SICC gen ");
                    query.append(" where gen.VAL_OID in ( ");
                    query.append(" select distinct MARC_OID_MARC ");
                    query.append(" from COM_PLANT_COMIS_MARCA ");
                    query.append(" where PLCO_OID_PLAN_COMI = " + oidPlantilla);
                    if(dtoe.getOidMarca()!=null){
                        query.append(" AND MARC_OID_MARC = " + dtoe.getOidMarca());
                    }
                    query.append(" ) ");
                    query.append(" AND gen.ATTR_ENTI = 'SEG_MARCA' ");
                    query.append(" AND gen.ATTR_NUM_ATRI = 1 ");
                    query.append(" AND gen.IDIO_OID_IDIO = " + dtoe.getOidIdioma() );
                    query.append(" order by  gen.VAL_I18N ");
                     */
                    query.append(" select distinct DES_MARC ");       
                    query.append(" from COM_PLANT_COMIS_MARCA comarca, SEG_MARCA marca ");       
                    query.append(" where comarca.MARC_OID_MARC = marca.OID_MARC ");       
                    query.append(" AND  PLCO_OID_PLAN_COMI = " + oidPlantilla );       
                    if(dtoe.getOidMarca()!=null){
                        query.append(" AND comarca.MARC_OID_MARC = " + dtoe.getOidMarca());
                    }
                    query.append(" ORDER BY DES_MARC ");           
                    rsMarca = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
                    
                    String strMarca="";
                    //cargo en un string todas las marcas , para luego seterlo al recorset de salida
                    for( int a=0; a<rsMarca.getRowCount(); a++){
                          UtilidadesLog.debug(rsMarca.getValueAt(a,0));
                          if(a==0){
                              strMarca = (String)rsMarca.getValueAt(a,0);
                          }else{
                              strMarca = strMarca + (String)rsMarca.getValueAt(a,0);
                          }                 
                    }
                    
                    //Busco en la entidad Plantilla Comision Acceso
                    query = new StringBuffer();
                    bs = UtilidadesEJB.getBelcorpService();
                    query.append(" select distinct gen.VAL_I18N ");
                    query.append(" from V_GEN_I18N_SICC gen ");
                    query.append(" where gen.VAL_OID in ( ");
                    query.append(" select distinct ACCE_OID_ACCE ");
                    query.append(" from COM_PLANT_COMIS_ACCES ");
                    query.append(" where PLCO_OID_PLAN_COMI = " + oidPlantilla);
                    if(dtoe.getOidAcceso()!=null){
                        query.append(" AND ACCE_OID_ACCE = " + dtoe.getOidAcceso());
                    }                   
                    query.append(" ) ");
                    query.append(" AND gen.ATTR_ENTI = 'SEG_ACCES' ");
                    query.append(" AND gen.ATTR_NUM_ATRI = 1  ");
                    query.append(" AND gen.IDIO_OID_IDIO =  " + dtoe.getOidIdioma() );
                    query.append(" order by  gen.VAL_I18N ");
                
                    rsAcceso = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
                     
                    String strAcceso="";
                    //cargo en un string todas las marcas , para luego seterlo al recorset de salida
                    for( int a=0; a<rsAcceso.getRowCount(); a++){
                          UtilidadesLog.debug(rsAcceso.getValueAt(a,0));
                          if(a==0){
                              strAcceso = String.valueOf(rsAcceso.getValueAt(a,0));
                          }else{
                              strAcceso = strAcceso + String.valueOf(rsAcceso.getValueAt(a,0));
                          }                 
                    }
                   UtilidadesLog.debug("strMarca  " + strMarca ); 
                   UtilidadesLog.debug("strPais  " + strPais ); 
                   UtilidadesLog.debug("strAcceso  " + strAcceso ); 
                    
                    //ahora deberia ir seteando en mi recordset de salida con las nuevas descripcion de pais, marca y acceso
                    
                    
                    //COM_SI
                    String IND_COMP ="";
                    if(rs.getValueAt(i,8)!=null){
                        if(String.valueOf(rs.getValueAt(i,8)).equals("1")){
                            IND_COMP ="SI";
                        }else{
                            IND_COMP ="NO";
                        }
                    }
                    
                    //INDTRATDIF
                    String INDTRATDIF ="";
                    if(rs.getValueAt(i,9)!=null){
                        if(String.valueOf(rs.getValueAt(i,9)).equals("1")){
                            INDTRATDIF ="SI";
                            
                        }else{
                            INDTRATDIF ="NO";
                        }
                        UtilidadesLog.debug("*** Trat dif en base: "+rs.getValueAt(i,9));
                    }
                    UtilidadesLog.debug("*** INDTRATDIF: "+INDTRATDIF);
                    UtilidadesLog.debug("*** OID: "+rs.getValueAt(i,0));
                    UtilidadesLog.debug("*** CODIGO PLANTILLA: "+rs. getValueAt(i,1));
                    
                    rsalida.addRow(new Object []{ rs.getValueAt(i,0), 
                                                 rs. getValueAt(i,1),
                                                 rs.getValueAt(i,2),
                                                 strPais,
                                                 strMarca,
                                                 rs.getValueAt(i,5),
                                                 strAcceso,
                                                 rs.getValueAt(i,7),
                                                 IND_COMP,  
                                                 INDTRATDIF,
                                                 rs.getValueAt(i,10),                                                 
                                              });                                              
                                              
                }//fin for
        }//fin del es vacio        
     }catch(Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }
     if(rs.esVacio()){
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    UtilidadesLog.debug("DAOPlantillasCom.buscarPlantillasComisiones(DTOBusquedaPlantillas dtoe): Salida");
      UtilidadesLog.debug("Al salir rSalida tiene :" + rsalida.getRowCount() + " registros");
     return rsalida;
   }
  
  
  /*
   *Autor: Marta Montiel
   * Fecha: 15/02/05
   */ 
   public RecordSet obtenerComActivasPorPlantilla( Long oid) throws MareException {
         /*
          * Acceder a la entidad Comisiones, PlantillasComisionesPais, haciendo join entre ellas. 
          filtrando por: 
          - PlantillasComisionesPais.oidPlantilla=DTOE.oidPlantilla 
          - Comisiones.oidEstadoComision=COMConstantes.ESTADO_COMISION_ACTIVA 
          - Comisiones.oidPlantillaPais=PlantillasComisionesPais.oid 
          
          Obtener: Comisiones.oid
          * */
           UtilidadesLog.info("DAOPlantillasCom.obtenerComActivasPorPlantilla(Long oid): Entrada");
           StringBuffer query = new StringBuffer();
           RecordSet rs;
           RecordSet rsalida = new RecordSet();
          
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    
           /*
           * POR AHORA SIMULEMOS QUE EL OID QUE RECIBO ES EL OIDPAIS
           * HASTA QUE SE RESUELVA LA INCIDENCIA 13430
           *  y que el 1 del CEST_OID_ESTA es igual a activo
           * */  
           
           // inc 24432 
           /*query.append(" SELECT a.OID_PLAN_COMI ");
           query.append(" FROM COM_PLANT_COMIS a ");           
           query.append(" WHERE a.CEST_OID_ESTA =  " + ConstantesCOM.ESTADO_ACTIVO );
           query.append(" AND OID_PLAN_COMI = " + oid);         */ 
            
           query.append(" SELECT comis.OID_COMI");
           query.append(" FROM COM_COMIS comis");           
           query.append(" WHERE comis.CECO_OID_ESTA_COMI =  " + ConstantesCOM.ESTADO_COMISION_ACTIVA );
           query.append(" AND comis.PLCO_OID_PLAN_COMI = " + oid);    
            
            
           UtilidadesLog.debug(query.toString());
         
           try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
            }catch (Exception e) {
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }         
            UtilidadesLog.info("DAOPlantillasCom.obtenerComActivasPorPlantilla(Long oid): Salida");
            return rs;
   }
    
   /*
   *Autor: Marta Montiel
   * Fecha: 15/02/05
   */ 
   public RecordSet obtenerAccesosPlantilla( DTOBusquedaAccesosPlantilla dtoe) throws MareException {
   /*
    * Acceder a la entidad PlantillasComisionesAccesos, PlantillasComisiones, PlantillasComisionesPais Accesos (SEG) haciendo un join entre ellas 
    Filtrando por: //aquellos no nulos 
    - PlantillasComisiones.oidCanal=DTOBusquedaAccesosPlantilla.oidCanal 
    - PlantillasComisiones.codigo=DTOBusquedaAccesosPlantilla.codPlantilla 
    - PlantillasComisionesPais.oidPais=DTOBusquedaAccesosPlantilla.oidPais 
    - Los de la join: PlantillasComisiones con PlantillasComisionesAccesos. 
    PlantillasComisiones con PlantillasComisionesPais 
    PlantillasComisionesAccesos con Accesos 
    Obtener: PlantillasComisionesAccesos.oidAccesos 
    Accesos.descripcion (internacionalizable)
    * */
    UtilidadesLog.info("DAOPlantillasCom.obtenerAccesosPlantilla(DTOBusquedaAccesosPlantilla dtoe): Entrada");
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet();

    try {
             bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT distinct d.OID_ACCE oid, gen.VAL_I18N DESCRIPCION ");
            query.append(" FROM V_GEN_I18N_SICC gen, COM_PLANT_COMIS a ");
            query.append(" JOIN COM_PLANT_COMIS_ACCES b ON (b.PLCO_OID_PLAN_COMI = a.OID_PLAN_COMI) ");
            query.append(" JOIN COM_PLANT_COMIS_PAIS c ON (c.PLCO_OID_PLAN_COMI = a.OID_PLAN_COMI)	 ");
            query.append(" JOIN SEG_ACCES d ON ( d.OID_ACCE = b.ACCE_OID_ACCE) ");
            query.append(" WHERE  gen.ATTR_ENTI = 'SEG_ACCES'  ");
            query.append(" AND gen.ATTR_NUM_ATRI = 1 ");
            query.append(" AND gen.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
            query.append(" AND gen.VAL_OID = d.OID_ACCE ");
            if(dtoe.getOidPais()!=null){
                query.append(" AND PAIS_OID_PAIS =  " + dtoe.getOidPais());
            }            
            if(dtoe.getCodigo()!=null){
                query.append(" AND COD_PLAN_COMI =  " + dtoe.getCodigo());
            }
            if(dtoe.getOidCanal()!=null){
                query.append(" AND CANA_OID_CANA =  " + dtoe.getOidCanal());
            }
            query.append(" order by  DESCRIPCION ");
            
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }  
   UtilidadesLog.debug(rs);
   UtilidadesLog.info("DAOPlantillasCom.obtenerAccesosPlantilla(DTOBusquedaAccesosPlantilla dtoe): Salida");
    return rs;
   }
   
   
}