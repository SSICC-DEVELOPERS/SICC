/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DAOGestionComisiones
 * Fecha:             07/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033
 * Descripcion:       DAOGestionComisiones
 * @version           obtenerPeriodosMayores1.0
 * @autor             idedough
 */

package es.indra.sicc.logicanegocio.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.com.DTOEstado;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.com.DTOEstados;
import es.indra.sicc.dtos.com.DTOBuscarInsertarComisiones;
import es.indra.sicc.dtos.com.DTOEstadoComision;
import es.indra.sicc.dtos.com.DTOCodigoComision;
import es.indra.sicc.dtos.com.DTOBuscarMarcarModificar;
import es.indra.sicc.dtos.com.DTOBuscarModificar;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.util.ArrayList;
import java.util.Vector;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;

import java.math.BigDecimal;

public class DAOGestionComisiones 
{
    
    
    public DAOGestionComisiones()
    {
    }
    
    /*
    * Autor: idedough
    * Fecha: 07/03/05
    */ 
    public DTOSalida obtenerAccesosPlantilla(DTOOID dto) throws MareException
    {      
           UtilidadesLog.info("DAOGestionComisiones.obtenerAccesosPlantilla(DTOOID dto): Entrada"); 
           StringBuffer query = new StringBuffer();
           RecordSet rs = new RecordSet(); 
           DTOSalida dtos = new DTOSalida();
           BelcorpService bs = UtilidadesEJB.getBelcorpService();      
           query.append(" SELECT DISTINCT A.ACCE_OID_ACCE OID, B.VAL_I18N DESCRIPCION ");
           query.append(" FROM COM_PLANT_COMIS_ACCES A, V_GEN_I18N_SICC B, COM_PLANT_COMIS C ");                  
           query.append(" WHERE ");
           if(dto.getOid() != null) {
               query.append(" A.PLCO_OID_PLAN_COMI = " + dto.getOid() + " AND ");
           }
           query.append(" A.PLCO_OID_PLAN_COMI = C.OID_PLAN_COMI AND ");           
           query.append(" C.CEST_OID_ESTA = " + ConstantesCOM.ESTADO_ACTIVO + " AND  ");           
           
           query.append(" B.ATTR_ENTI = 'SEG_ACCES'  AND "); 
           query.append(" B.ATTR_NUM_ATRI = 1 AND ");
           query.append(" B.IDIO_OID_IDIO = " + dto.getOidIdioma() + " AND ");
           query.append(" B.VAL_OID = A.ACCE_OID_ACCE ");
           query.append(" ORDER BY DESCRIPCION ");            
           UtilidadesLog.debug(query.toString());         
           try {
               rs =  bs.dbService.executeStaticQuery(query.toString());
               if(rs != null)
                  dtos.setResultado(rs);
           }catch (Exception e) {
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }           
           UtilidadesLog.info("DAOGestionComisiones.obtenerAccesosPlantilla(DTOOID dto): Salida"); 
           return dtos;
    }
    
    /*
    * Autor: idedough
    * Fecha: 07/03/05
    */
    public DTOSalida obtenerDescripcionesPlantillas(DTOBelcorp dto) throws MareException
    {   
        UtilidadesLog.info("DAOGestionComisiones.obtenerDescripcionesPlantillas(DTOBelcorp dto): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        DTOSalida dtos = new DTOSalida();
                
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        UtilidadesLog.debug("UtilidadesEJB.getBelcorpService()  .... [OK]");
        query.append(" SELECT A.OID_PLAN_COMI OID, B.VAL_I18N DESCRIPCION ");
        query.append(" FROM COM_PLANT_COMIS A, V_GEN_I18N_SICC B ");          
        query.append(" WHERE ");
        //query.append(" A.ESTA_OID_ESTA = " + ConstantesCOM.ESTADO_ACTIVO + " AND ");
        query.append(" A.CEST_OID_ESTA = " + ConstantesCOM.ESTADO_ACTIVO + " AND ");
        query.append(" B.ATTR_ENTI = 'COM_PLANT_COMIS'  AND ");           
        query.append(" B.ATTR_NUM_ATRI = 1  AND ");        
        query.append(" B.IDIO_OID_IDIO = " + dto.getOidIdioma() + " AND ");
        query.append(" B.VAL_OID = A.OID_PLAN_COMI ");
        query.append(" ORDER BY DESCRIPCION ");            
        UtilidadesLog.debug(query.toString());         
        try {
            rs =  bs.dbService.executeStaticQuery(query.toString());
            if(rs != null)
               dtos.setResultado(rs);
        }catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        UtilidadesLog.info("DAOGestionComisiones.obtenerDescripcionesPlantillas(DTOBelcorp dto): Salida");
        return dtos;            
    }
    
    /*
    * Autor: idedough
    * Fecha: 07/03/05
    */
    public DTOSalida obtenerCanalesPlantillas(DTOBelcorp dto) throws MareException
    {   
        UtilidadesLog.info("DAOGestionComisiones.obtenerCanalesPlantillas(DTOBelcorp dto): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();               
        query.append(" SELECT DISTINCT A.CANA_OID_CANA OID, B.VAL_I18N DESCRIPCION ");
        query.append(" FROM COM_PLANT_COMIS A, V_GEN_I18N_SICC B ");          
        query.append(" WHERE ");
        query.append(" A.CEST_OID_ESTA = " + ConstantesCOM.ESTADO_ACTIVO + " AND  ");                   
        query.append(" B.ATTR_ENTI = 'SEG_CANAL'  AND ");           
        query.append(" B.ATTR_NUM_ATRI = 1  AND ");        
        query.append(" B.IDIO_OID_IDIO = " + dto.getOidIdioma() + " AND ");
        query.append(" B.VAL_OID = A.CANA_OID_CANA ");
        query.append(" ORDER BY DESCRIPCION "); 
        UtilidadesLog.debug(query.toString());         
        try {
            rs =  bs.dbService.executeStaticQuery(query.toString());
            if(rs != null)
               dtos.setResultado(rs);
        }catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        UtilidadesLog.info("DAOGestionComisiones.obtenerCanalesPlantillas(DTOBelcorp dto): Salida");
        return dtos;
    }
    
    /*
    * Autor: idedough
    * Fecha: 07/03/05
    */
    public DTOSalida obtenerMarcasPlantilla(DTOOID dto) throws MareException  {   
      UtilidadesLog.info("DAOGestionComisiones.obtenerMarcasPlantilla(DTOOID dto): Entrada");
      StringBuffer query = new StringBuffer();             
      query.append(" SELECT DISTINCT A.MARC_OID_MARC OID, B.DES_MARC DESCRIPCION ");
      query.append(" FROM COM_PLANT_COMIS_MARCA A, SEG_MARCA B, COM_PLANT_COMIS C ");                            
      query.append(" WHERE ");      
      if(dto.getOid() != null){
        query.append(" A.PLCO_OID_PLAN_COMI = " + dto.getOid() + " AND ");
      }
      query.append(" A.PLCO_OID_PLAN_COMI = C.OID_PLAN_COMI AND ");           
      query.append(" C.CEST_OID_ESTA = " + ConstantesCOM.ESTADO_ACTIVO + " AND  ");                   
      query.append(" B.OID_MARC = A.MARC_OID_MARC ");        
      query.append(" ORDER BY DESCRIPCION ");       
      
      UtilidadesLog.info("DAOGestionComisiones.obtenerMarcasPlantilla(DTOOID dto): Salida");
      return getDTOSalida(query.toString());
    }
    
    public DTOSalida buscarInsertarComisiones(DTOBuscarInsertarComisiones dto) throws MareException  {
        UtilidadesLog.info("DAOGestionComisiones.buscarInsertarComisiones(DTOBuscarInsertarComisiones dto): Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 

        query.append(" SELECT  distinct a.oid_plan_comi OID, a.cod_plan_comi codigo, c.val_i18n descripcion, ");
        
        //query.append(" '' marca, d.val_i18n canal, '' acceso, i.val_i18n tipoplantilla, ");        
        query.append(" '' marca, d.val_i18n canal, '' acceso, ");        
        query.append(" (SELECT VAL_I18N ");
        query.append(" FROM V_GEN_I18N_SICC i ");
  		  query.append(" WHERE i.VAL_OID = a.tpla_oid_tipo_plan ");
  		  query.append(" AND i.ATTR_ENTI = 'COM_TIPO_PLANT' ");
  		  query.append(" AND i.IDIO_OID_IDIO = " + dto.getOidIdioma());
  		  query.append(" AND i.ATTR_NUM_ATRI = 1 ");
  		  query.append(" ) AS TIPOPLANTILLA, ");      
        
        query.append(" a.ind_comp comparativo, a.ind_trat_dife tratamientodiferencial, ");
        query.append(" a.CEST_OID_ESTA estado, a.cana_oid_cana oidcanal, a.TPLA_OID_TIPO_PLAN ");
        query.append(" FROM com_plant_comis a, ");
        query.append(" com_plant_comis_pais b, "); 
        /* 23474 - dmorello, 20/06/2006: Se quita esta vista ya que no se filtrará por descripción */
        query.append(" v_gen_i18n_sicc c, ");
        query.append(" v_gen_i18n_sicc d, ");
        // dmorello, 20/06/2006: Esta vista ya se usa en la subquery que obtiene el tipo de plantilla
        // Si se repite acá se genera un prod cartesiano, por lo tanto se quita
        //query.append(" v_gen_i18n_sicc i, ");
        query.append(" COM_PLANT_COMIS_ACCES E, ");
        query.append(" COM_PLANT_COMIS_MARCA G ");
        query.append(" WHERE a.cest_oid_esta = " + ConstantesCOM.ESTADO_ACTIVO);
        query.append(" AND b.plco_oid_plan_comi = a.oid_plan_comi ");
        query.append(" AND b.pais_oid_pais = " + dto.getOidPais() );
        query.append(" AND c.attr_enti = 'COM_PLANT_COMIS' ");
        query.append(" AND c.attr_num_atri = 1 ");
        query.append(" AND c.idio_oid_idio = " + dto.getOidIdioma() );
        query.append(" AND c.val_oid = a.oid_plan_comi ");
        query.append(" AND d.attr_enti = 'SEG_CANAL' ");
        query.append(" AND d.attr_num_atri = 1 ");
        query.append(" AND d.idio_oid_idio = " + dto.getOidIdioma() );
        query.append(" AND d.val_oid = a.cana_oid_cana ");
    	  query.append(" and a.OID_PLAN_COMI = e.PLCO_OID_PLAN_COMI ");
        query.append(" and a.OID_PLAN_COMI = g.PLCO_OID_PLAN_COMI ");
        
        // 23474 - dmorello, 20/06/2006: Se filtrará por OID de plantilla
        // y ya no por la descripción
        //if ( dto.getDescripcion() != null )
        //   query.append(" AND c.val_i18n = '" + dto.getDescripcion() + "' ");
        if (dto.getOidPlantilla() != null) {
            query.append(" AND a.OID_PLAN_COMI = " + dto.getOidPlantilla());
        }
            
        if ( dto.getOidCanal() != null )
           query.append(" AND A.CANA_OID_CANA  = " + dto.getOidCanal()); 
           
        if ( dto.getOidAcceso() != null)
           query.append(" and e.ACCE_OID_ACCE =  " + dto.getOidAcceso() );
            
        if ( dto.getOidMarca() != null)
           query.append(" and g.MARC_OID_MARC = " + dto.getOidMarca() ); 
          
        query.append(" ORDER BY a.oid_plan_comi ");
         
         try {
            String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
            rs = bs.dbService.executeStaticQuery( queryPaginada );
         } catch (Exception ex)
         { 
           UtilidadesLog.error(ex);
           String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
         }
         
         UtilidadesLog.debug("Rs preliminar: " + rs);
         
         // Verifica que el Rs no sea vacio.
         if (rs.esVacio())
         {
           // Tira la exception de "no se encontraron registros bla bla bla"
           String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
           throw new MareException("No hay registros", UtilidadesError.armarCodigoError(sCodigoError));
         }
         
         Long[] arrayOids = this.obtieneOids(rs, new Long(0));
         Long acceso = null;
         Long marca = null;
         Long idioma = dto.getOidIdioma();
         if (dto.getOidAcceso() != null)
            acceso = dto.getOidAcceso();
            
         if (dto.getOidMarca() != null)
            marca = dto.getOidMarca();
         
         RecordSet rAccesos = this.obtieneDescAccesosPorOid(arrayOids, acceso, idioma);
         RecordSet rMarcas = this.obtieneDescMarcasPorOid(arrayOids, marca);
         
         rs = this.armaRSetFinalInsertarComisiones(rs, rAccesos, rMarcas);
         dtoSalida.setResultado(rs);
         
         UtilidadesLog.debug("*** DTOSalida a retornar: " + dtoSalida);         

         UtilidadesLog.info("DAOGestionComisiones.buscarInsertarComisiones(DTOBuscarInsertarComisiones dto): Salida");
         return dtoSalida;    
    }
    
  /**
   * @Author: ssantana, 16/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet
   * @param  oids, Long[] marcas
   */
    private RecordSet obtieneDescMarcasPorOid(Long[] oids, Long marca) throws MareException
    {
       UtilidadesLog.info("DAOGestionComisiones.obtieneDescMarcasPorOid(Long[] oids, Long marca): Entrada");
       RecordSet r = null;
       BelcorpService bs = BelcorpService.getInstance();
       StringBuffer sqlQuery = new StringBuffer(""); 
       
       String oidsComisiones = this.generaINClause(oids);
       //String oidsMarca = this.generaINClause(marcas);
       
      sqlQuery.append(" SELECT com_plant_comis.oid_plan_comi, seg_marca.des_marc "); 
      sqlQuery.append(" FROM com_plant_comis, com_plant_comis_marca, seg_marca ");
      sqlQuery.append(" WHERE com_plant_comis.oid_plan_comi " + oidsComisiones);  // IN (1,2,3,4,5)
      sqlQuery.append(" AND com_plant_comis_marca.plco_oid_plan_comi = com_plant_comis.oid_plan_comi ");
      sqlQuery.append(" AND com_plant_comis_marca.marc_oid_marc = seg_marca.oid_marc ");
      if (marca != null)
        sqlQuery.append(" AND com_plant_comis_marca.marc_oid_marc = " + marca);
      sqlQuery.append(" order by 1 ");
        
      try 
      {
        r = bs.dbService.executeStaticQuery( sqlQuery.toString() );
      } catch (Exception ex)
      {
        UtilidadesLog.error(ex);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      
      // Nota: Esta query se supone que es una extension de la query Principal en
      // obtenerTiposInsercionProducto(),
      // por lo que si no trae datos, entonces es lo mismo que la Principal no lo hiciera
      // y DEBE tirar EXCEPTION.
      if (r.esVacio())
      {
        String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
        throw new MareException("No hay datos", UtilidadesError.armarCodigoError(sCodigoError));
      }      
      
      UtilidadesLog.debug("RecordSet marcas: " + r);
      r = this.concatenaCampos(r);
      UtilidadesLog.info("DAOGestionComisiones.obtieneDescMarcasPorOid(Long[] oids, Long marca): Salida");
      return r;
    }


  /**
   * @Author: ssantana, 16/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param oidIdioma
   * @param acceso
   * @param oids
   */
    private RecordSet obtieneDescAccesosPorOid(Long[] oids, Long acceso, Long oidIdioma) throws MareException
    {
       UtilidadesLog.info("DAOGestionComisiones.obtieneDescAccesosPorOid(Long[] oids, Long acceso, Long oidIdioma): Entrada");
       RecordSet r = null;
       BelcorpService bs = BelcorpService.getInstance();
       StringBuffer sqlQuery = new StringBuffer(""); 
       
       String oidsComisiones = this.generaINClause(oids);

       sqlQuery.append(" SELECT   com_plant_comis.oid_plan_comi, v_gen_i18n_sicc.val_i18n ");
       sqlQuery.append(" FROM com_plant_comis, com_plant_comis_acces, v_gen_i18n_sicc ");
       sqlQuery.append(" WHERE com_plant_comis.oid_plan_comi = com_plant_comis_acces.plco_oid_plan_comi(+) ");
       sqlQuery.append(" AND com_plant_comis_acces.acce_oid_acce = v_gen_i18n_sicc.val_oid ");
       sqlQuery.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + oidIdioma);
       sqlQuery.append(" AND v_gen_i18n_sicc.attr_enti = 'SEG_ACCES' ");
       sqlQuery.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
       sqlQuery.append(" AND com_plant_comis.oid_plan_comi " + oidsComisiones);
       if ( acceso != null)
          sqlQuery.append(" AND com_plant_comis_acces.acce_oid_acce = " + acceso);
       sqlQuery.append(" ORDER BY com_plant_comis.oid_plan_comi ");
       
      try 
      {
        r = bs.dbService.executeStaticQuery( sqlQuery.toString() );
      } catch (Exception ex)
      {
        UtilidadesLog.error(ex);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      
      // Nota: Esta query se supone que es una extension de la query Principal en
      // obtenerTiposInsercionProducto(),
      // por lo que si no trae datos, entonces es lo mismo que la Principal no lo hiciera
      // y DEBE tirar EXCEPTION.
      if (r.esVacio())
      {
        String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
        throw new MareException("No hay datos", UtilidadesError.armarCodigoError(sCodigoError));
      }
      
      UtilidadesLog.debug("RecordSet marcas: " + r);
      r = this.concatenaCampos(r);
      UtilidadesLog.info("DAOGestionComisiones.obtieneDescAccesosPorOid(Long[] oids, Long acceso, Long oidIdioma): Salida");
      return r;
       
    }
    
  /**
   * @Author: ssantana, 16/3/2005
   * @throws java.lang.Exception
   * @return String
   * @param  oids
   */
  private String generaINClause(Long[] oids) throws MareException { 
     UtilidadesLog.debug("DAOGestionComisiones.generaINClause(Long[] oids): Entrada");     
     StringBuffer sClausula = new StringBuffer("");     
     try 
     {
       sClausula.append(" IN ( ");
       for (int i = 0; i < oids.length; i++)
       {
          //BigDecimal bigZona = (BigDecimal) zonas.getValueAt(i,0);
          Long oid = oids[i];
          if (i != 0)
            sClausula.append(", ");
            
          sClausula.append(""+ oid);
       }
       sClausula.append(")");
     
     } catch (Exception ex)
     {
       UtilidadesLog.error(ex);
       String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
     }
     UtilidadesLog.debug("DAOGestionComisiones.generaINClause(Long[] oids): Salida");     
     return sClausula.toString();     
  }    
  
  /**
   * @Author: ssantana, 16/3/2005
   * @return RecordSet
   * @param  r
   */
  private RecordSet concatenaCampos(RecordSet r) {
    // Recordset de Entrada tiene el sig. formato: [oid, desc],
    // ordenado por oid en forma ascendente. 
    // Concatena en una sola tupla aquellas descripciones que posean el mismo oid.
    
    UtilidadesLog.info("DAOGestionComisiones.concatenaCampos(RecordSet r): Entrada");
    UtilidadesLog.debug(" - Recordset entrada: " + r);
    RecordSet rToReturn = new RecordSet(); 
    Vector vCols = new Vector();
    vCols.add("Oid");
    vCols.add("Desc");    
    rToReturn.setColumnIdentifiers(vCols);
    
    int cantFilasOriginal = r.getRowCount();
    
    if (r.getRowCount() > 0)
    {
        // Obtengo el primero elemento fuera del bucle.
        BigDecimal bigBuffer = (BigDecimal) r.getValueAt(0,0);
        String descBuffer = (String) r.getValueAt(0,1);
        if (descBuffer == null) { descBuffer = "";} 
        
        long oidAnterior = bigBuffer.longValue();
        StringBuffer sCadena = new StringBuffer( descBuffer );

        // Corte de control. 
        for (int i = 1; i < cantFilasOriginal; i++)
        {
            UtilidadesLog.debug("Bucle: " + i);
            // Obtenemos el oid. 
            BigDecimal bigOid = (BigDecimal) r.getValueAt(i,0);
            String sDesc = (String) r.getValueAt(i,1);
            if (sDesc == null) { sDesc = "";}             
            
            if ( (oidAnterior == bigOid.longValue()) && (i != cantFilasOriginal))
            {
              // Si el oid del registro anterior es el mismo que el actual.            
              // continua concatenando descripcion.
               UtilidadesLog.debug("Match! - oid: " + oidAnterior);
                // Concatena la desc. a sCadena. 
                if ( !sCadena.equals("") )
                  sCadena.append(", ");
                 
                sCadena.append(sDesc);
                UtilidadesLog.debug("sCadena actual: " + sCadena.toString());
            } else
            {
                // Graba el oid y la cadena en el Recordset a retornar
                Vector vFila = new Vector();
                vFila.add( new Long(oidAnterior) );
                vFila.add(sCadena.toString());
                rToReturn.addRow(vFila);
                UtilidadesLog.debug("Agrega vfila: " + vFila);                
                
                // Setea "oidAnterior" con el oid actual y limpia sCadena.
                String sDescNueva = (String) r.getValueAt(i,1);
                if ( sDescNueva == null) { sDescNueva = ""; }
                sCadena = new StringBuffer( sDescNueva );
            }
            oidAnterior = bigOid.longValue();
            
        }

        Vector vFila = new Vector();
        vFila.add( new Long(oidAnterior) );
        vFila.add(sCadena.toString());
        rToReturn.addRow(vFila);
        UtilidadesLog.debug("Agrega ultima vfila: " + vFila);                
    
    }
    UtilidadesLog.debug("RecordSet Salida: " + rToReturn);
    UtilidadesLog.info("DAOGestionComisiones.concatenaCampos(RecordSet r): Salida");
    return rToReturn;    
  }
  
  /**
   * @Author: ssantana, 16/3/2005
   * @return Long[]
   * @param  indexCol
   * @param  r
   */
  private Long[] obtieneOids(RecordSet r, Long indexCol) {
    // Recorre el RecordSet y devuelve un array de Longs con los elementos de 
    // la columna "indexCol".
    UtilidadesLog.info("DAOGestionComisiones.obtieneOids(RecordSet r, Long indexCol): Entrada");
    Vector v = new Vector(); 

    for (int i = 0; i < r.getRowCount(); i++)
    {
      BigDecimal b = (BigDecimal)  r.getValueAt(i,indexCol.intValue());
      Long oid = new Long( b.longValue() );
      v.add(oid);
    }

    Long[] array = (Long[])v.toArray(new Long[v.size()]);
    UtilidadesLog.info("DAOGestionComisiones.obtieneOids(RecordSet r, Long indexCol): Salida");
    return array;
  }
  
  private Long[] obtieneOids(ArrayList aList)
  {
    UtilidadesLog.info("DAOGestionComisiones.obtieneOids(ArrayList aList): Entrada");
    // Recorre el RecordSet y devuelve un array de Longs con los elementos de la primer
    // columna (los oids)
    UtilidadesLog.debug("obtieneOids");    
    Vector v = new Vector(); 
    

    for (int i = 0; i < aList.size(); i++)
    {
      Long oid = (Long)  aList.get(i);
      v.add(oid);
    }

    Long[] array = (Long[])v.toArray(new Long[v.size()]);
    UtilidadesLog.info("DAOGestionComisiones.obtieneOids(ArrayList aList): Salida");
    return array;
  }  
  
  /**
   * @Author: ssantana, 15/3/2005
   * @return Recordset
   * @param RecordSet r
   */
  private RecordSet armaRSetFinalInsertarComisiones(RecordSet r, RecordSet rAccesos, RecordSet rMarcas)
  {
    // Arma el RecordSet final añadiendo los valores de Desc en rAcceso y rMarcas al RecordSet
    // r. 
    // Finalmente, retorna r.
    // Nota: Hay igual cant. de registros en rAccesos y rMarcas como en r. Los oids. 
    // de cada fila de cada RecordSet coinciden con los oids de los otros dos RecordSets.
    UtilidadesLog.info("DAOGestionComisiones.armaRSetFinalInsertarComisiones(RecordSet r, RecordSet rAccesos, RecordSet rMarcas): Entrada");
    UtilidadesLog.debug("****** RS CASI FINAL: " + r);
    UtilidadesLog.debug("****** rAccesos: " + rAccesos);
    UtilidadesLog.debug("****** rMarcas: " + rMarcas);    
    
    for (int i = 0; i < r.getRowCount(); i++)
    {
       String descAcceso = (String)rAccesos.getValueAt(i,1);
       String descMarca = (String)rMarcas.getValueAt(i,1);
       
       r.setValueAt(descMarca, i, 3);
       r.setValueAt(descAcceso, i, 5);       
    }
    
    UtilidadesLog.debug("RecordSet FINAL: " + r);    
    UtilidadesLog.info("DAOGestionComisiones.armaRSetFinalInsertarComisiones(RecordSet r, RecordSet rAccesos, RecordSet rMarcas): Salida");
    return r;
  }
  
    
    

    
    /*
    * Autor: idedough
    * Fecha: 07/03/05
    */
    private static DTOSalida getDTOSalida(String query) throws MareException {   
        UtilidadesLog.info("DAOGestionComisiones.getDTOSalida(String query): Entrada");
        RecordSet rs = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        UtilidadesLog.debug(query);         
        try {
            rs =  bs.dbService.executeStaticQuery(query);
            if(rs != null)
               dtos.setResultado(rs);
        }catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        UtilidadesLog.info("DAOGestionComisiones.getDTOSalida(String query): Salida");
        return dtos;        
    } 
    
    public static void main(String[] args) throws MareException
    {
        DTOSalida dtos = new DTOSalida();
        DTOBuscarInsertarComisiones dto = new DTOBuscarInsertarComisiones();
        //dtos = buscarInsertarComisiones(dto);
       
        UtilidadesLog.debug("dtoSalida " + dtos);
    }
    

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return DTOSalida
    * @documentation
        Obtiene los estados de comisiones (todos). 
    
        Proceso 
        ======== 
        Se ejecuta la query: 
        
        SELECT 
        A.oid_esta as oid, 
        B.val_i18n as descripcion 
        
        FROM 
        com_estad_comis A, 
        v_gen_i18n_sicc B 
        
        WHERE 
        Si dto.estados tiene elementos 
        A.oid_esta IN dto.estados 
        Fin del Si 
        B.attr_enti = 'COM_ESTAD_COMIS' AND 
        B.attr_num_atri = 1 AND 
        B.idio_oid_idio = dto.idioma AND 
        B.val_oid = A.oid_esta
    */
    public DTOSalida obtenerEstadosComisiones(DTOEstados dtoE) throws MareException {
        UtilidadesLog.info("DAOGestionComisiones.obtenerEstadosComisiones(DTOEstados dtoE): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        ArrayList al=null;

        query.append(" SELECT ");
        query.append(" A.oid_esta_comi as oid, ");
        query.append(" B.val_i18n as descripcion ");
        query.append(" FROM ");
        query.append(" com_estad_comis A, ");
        query.append(" v_gen_i18n_sicc B ");
        query.append(" WHERE ");
        
        al=dtoE.getEstados();
        int cnt = 0;
        if(al!=null && al.size()!=0) {
          query.append(" A.oid_esta_comi IN (");
          for(int i=0; i<al.size();i++) {
            UtilidadesLog.debug("Elemento nro. :"+i + "OBjeto"+al.get(i));
            if(al.get(i)!=null) {                            
              if(cnt != 0) {
                query.append(",");
              }
              
              query.append(((DTOEstado)al.get(i)).getOidEstadoComision());              
              cnt++;
              //if(i<=al.size()-1) query.append(",");//i!=0 && i!=al.size()-1
            }
          }
          query.append(") AND ");
        }
        
        query.append(" B.attr_enti = 'COM_ESTAD_COMIS' AND ");
        query.append(" B.attr_num_atri = 1 AND ");
        query.append(" B.idio_oid_idio = " + dtoE.getOidIdioma() + " AND ");
        query.append(" B.val_oid = A.oid_esta_comi ");
        query.append(" ORDER BY descripcion ");
       
        try {
            rs =  bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if(rs.esVacio())  {   
          throw new MareException(null, null,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
            
        dtoSalida.setResultado(rs);  
        UtilidadesLog.debug("dtoSalida: ***"+dtoSalida);
        UtilidadesLog.info("DAOGestionComisiones.obtenerEstadosComisiones(DTOEstados dtoE): Salida");
        return dtoSalida;    
    }
    
    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return DTOSalida
    * @documentation
          Obtiene las comisiones que cumplen el criterio especificado por el usuario. 
          Búsqueda paginada. 
          
          Proceso 
          ========= 
          Se ejecuta la query: 
          
          SELECT * FROM 
          ( 
          SELECT 
          ROWNUM as linea, 
          oid, 
          codigo, 
          version, 
          descripcion, 
          marca, 
          canal, 
          oidAcceso, 
          acceso, 
          tipoComision, 
          concepto, 
          oidEstadoComision, 
          fecIniVigor 
          
          FROM 
          ( 
          SELECT 
          A.oid_comi as oid, 
          A.cod_comi as codigo, 
          A.nume_vers as version, 
          B.val_i18n as descripcion, 
          D.desc_marc as marca, 
          G.val_i18n as canal, 
          I.acce_oid_acce as oidAcceso, 
          J.val_i18n as acceso, 
          K.val_i18n as tipoComision, 
          A.val_conc as concepto, 
          A.esco_oid_esta as oidEstadoComision, 
          L.fec_inic as fecIniVigor 
          
          FROM 
          com_comis A, 
          v_gen_i18n_sicc B, 
          com_plant_comis_marca C, 
          seg_marca D, 
          v_gen_i18n_sicc G, 
          com_comis_acces H, 
          com_plant_comis_acces I, 
          v_gen_i18n_sicc J, 
          v_gen_i18n_sicc K, 
          cra_perio L 
          
          WHERE 
          Si dto.oidEstadoComision <> null 
          A.esco_oid_esta = dto.oidEstadoComision AND 
          Si no 
          A.esco_oid_esta IN (ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO, ConstantesCOM.ESTADO_COMISION_CONFIRMACION_CAMBIOS) AND 
          Fin del Si 
          B.attr_enti (+) = 'COM_COMIS' AND 
          B.attr_num_atri (+) = 1 AND 
          B.idio_oid_idio (+) = dto.idioma AND 
          B.val_oid (+) = A.oid_comi AND 
          C.oid_plan_comi_marc = A.pcma_oid_plan_comi_marc AND 
          D.oid_marc = C.marc_oid_marc AND 
          G.attr_enti = 'SEG_CANAL' AND 
          G.attr_num_atri = 1 AND 
          G.idio_oid_idio = dto.idioma AND 
          G.val_oid = A.cana_oid_cana AND 
          H.comi_oid_comi = A.oid_comi AND 
          I.oid_plan_comi_acce = H.pcac_oid_plan_comi_acce AND 
          J.attr_enti = 'SEG_ACCES' AND 
          J.attr_num_atri = 1 AND 
          J.idio_oid_idio = dto.idioma AND 
          J.val_oid = I.acce_oid_acce AND 
          K.attr_enti = 'COM_TIPO_PLANT' AND 
          K.attr_num_atri = 1 AND 
          K.idio_oid_idio = dto.idioma AND 
          K.val_oid = A.tipl_oid_tipo_plan AND 
          L.oid_peri (+) = A.perd_oid_peri_vigo 
          
          ORDER BY A.fec_ulti_esta DESC, A.oid_comi, I.acce_oid_acce 
          ) 
          ) 
          WHERE 
          linea > dto.indicadorSituacion 
          
          Dado que una comisión puede estar asociada a más de un acceso, un mismo oid de comisión aparecerá hasta "n" veces con distintos accesos. Por tanto se trata el RecordSet (resultado) obtenido para devolver un sólo registro por comisión (con los accesos concatenados): 
          
          Se crean las variables Long oidComision y oidAcceso que se inicializan a cero. 
          
          Se crea la variable String sAcceso que se inicializa a "". 
          
          Se crea la variable Integer iFila que se inicializa a cero. 
          
          Se crea la variable RecordSet rComisiones que inicialmente estará vacío. 
          
          Se crea la variable Boolean bSalir que se inicializa a False. 
          
          Por cada registro en resultado 
          Si oidComision <> resultado(i).oid 
          Si oidComision <> 0 
          Se añade el elemento iFila a rComisiones y se carga como sigue: 
          rComisiones(iFila).linea = resultado(i - 1).linea 
          rComisiones(iFila).oid = oidComision 
          rComisiones(iFila).codigo = resultado(i - 1).codigo 
          rComisiones(iFila).version = resultado(i - 1).version 
          rComisiones(iFila).descripcion = resultado(i - 1).descripcion 
          rComisiones(iFila).marca = resultado(i - 1).marca 
          rComisiones(iFila).canal = resultado(i - 1).canal 
          rComisiones(iFila).acceso = sAcceso 
          rComisiones(iFila).tipoComision = resultado(i - 1).tipoComision 
          rComisiones(iFila).concepto = resultado(i - 1).concepto 
          rComisiones(iFila).oidEstadoComision = resultado(i - 1).oidEstadoComision 
          rComisiones(iFila).fecIniVigor = resultado(i - 1).fecIniVigor 
          
          iFila += 1 
          Si iFila == dto.tamañoPagina (la paginación la tenemos que hacer a mano) 
          bSalir = True 
          Se sale del bucle 
          Fin del Si 
          Fin del Si 
          
          oidComision = resultado(i).oid 
          oidAcceso = resultado(i).oidAcceso 
          sAcceso = resultado(i).acceso 
          Fin del Si 
          
          Si oidAcceso <> resultado(i).oidAcceso 
          sAcceso += ", " + resultado(i).acceso 
          oidAcceso = resultado(i).oidAcceso 
          Fin del Si 
          Fin del Bucle 
          
          Si bSalir == False y resultado tiene registros (no se ha salido del bucle por el paginado) 
          Se añade el elemento iFila a rComisiones y se carga como sigue: 
          rComisiones(iFila).linea = resultado(último elemento).linea 
          rComisiones(iFila).oid = oidComision 
          rComisiones(iFila).codigo = resultado(último elemento).codigo 
          rComisiones(iFila).version = resultado(último elemento).version 
          rComisiones(iFila).descripcion = resultado(último elemento).descripcion 
          rComisiones(iFila).marca = resultado(último elemento).marca 
          rComisiones(iFila).canal = resultado(último elemento).canal 
          rComisiones(iFila).acceso = sAcceso 
          rComisiones(iFila).tipoComision = resultado(último elemento).tipoComision 
          rComisiones(iFila).concepto = resultado(último elemento).concepto 
          rComisiones(iFila).oidEstadoComision = resultado(último elemento).oidEstadoComision 
          rComisiones(iFila).fecIniVigor = resultado(último elemento).fecIniVigor 
          Fin del Si 
          
          Se carga un DTOSalida con el RecordSet rComisiones que tiene las columnas: 
          linea, 
          oid, 
          codigo, 
          version, 
          descripcion, 
          marca, 
          canal, 
          acceso, 
          tipoComision, 
          concepto, 
          oidEstadoComision, 
          fecIniVigor   
    */
    public DTOSalida buscarAceptarModificacion(DTOEstadoComision dtoE) throws MareException {
        UtilidadesLog.info("DAOGestionComisiones.buscarAceptarModificacion(DTOEstadoComision dtoE): Entrada");
        StringBuffer query = new StringBuffer("");
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet r = null;
        DTOSalida dtoSalida = new DTOSalida();
        
        /*query.append(" SELECT ROWNUM AS OID, OIDComision, codigo, VERSION, descripcion, ");
        query.append(" marca, canal, ");
        query.append(" acceso, tipocomision, concepto, oidestadocomision, fecinivigor ");
        query.append(" FROM (SELECT  DISTINCT a.oid_comi AS OIDComision, a.cod_comi AS codigo, ");
        query.append(" a.num_vers AS VERSION, b.val_i18n AS descripcion, ");
        query.append(" d.des_marc AS marca, g.val_i18n AS canal, '' AS acceso, ");
        query.append(" k.val_i18n AS tipocomision, a.val_conc AS concepto, ");
        query.append(" a.ceco_oid_esta_comi AS oidestadocomision, ");
        query.append(" l.fec_inic AS fecinivigor ");
        query.append(" FROM com_comis a, "); 
        query.append(" v_gen_i18n_sicc b, ");
        query.append(" com_plant_comis_marca c, ");
        query.append(" seg_marca d, ");
        query.append(" v_gen_i18n_sicc g, ");
        query.append(" com_comis_acces h, ");
        query.append(" com_plant_comis_acces i, ");
        query.append(" v_gen_i18n_sicc k, ");
        query.append(" cra_perio l, ");
        query.append(" cra_perio m ");
        
        if (dtoE.getOidEstadoComision() != null)
         query.append(" WHERE a.ceco_oid_esta_comi = " + dtoE.getOidEstadoComision());
        else
        {
         query.append(" WHERE a.ceco_oid_esta_comi IN (" + ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO + ", ");
         query.append(ConstantesCOM.ESTADO_COMISION_CONFIRMACION_CAMBIOS + ") ");
        }
        
        query.append(" AND b.attr_enti(+) = 'COM_COMIS' ");
        query.append(" AND b.attr_num_atri(+) = 1 ");
        query.append(" AND b.idio_oid_idio(+) = " + dtoE.getOidIdioma() );
        query.append(" AND b.val_oid(+) = a.oid_comi ");
        query.append(" AND c.oid_plan_comi_marc = a.plcm_oid_plan_comi_marc ");
        query.append(" AND d.oid_marc = c.marc_oid_marc ");
        query.append(" AND g.attr_enti = 'SEG_CANAL' ");
        query.append(" AND g.attr_num_atri = 1 ");
        query.append(" AND g.idio_oid_idio = " + dtoE.getOidIdioma() );
        query.append(" AND g.val_oid = m.cana_oid_cana ");
        query.append(" AND a.perd_oid_peri = m.oid_peri ");
        query.append(" AND h.comi_oid_comi = a.oid_comi ");
        query.append(" AND i.oid_plan_comi_acce = h.plca_oid_plan_comi_acce ");
        query.append(" AND k.attr_enti = 'COM_TIPO_PLANT' ");
        query.append(" AND k.attr_num_atri = 1 ");
        query.append(" AND k.idio_oid_idio = " + dtoE.getOidIdioma() );
        query.append(" AND k.val_oid = a.tpla_oid_tipo_plan ");
        query.append(" AND l.oid_peri(+) = a.perd_oid_peri_vigo_modi ");
        query.append(" ORDER BY a.oid_comi)");*/
        query.append(" select * from ( ");
        query.append(" SELECT ROWNUM AS linea, z.oidcomision, z.codigo, z.VERSION, z.descripcion, ");
        query.append(" z.marca, z.canal, z.acceso, z.tipocomision, z.concepto, ");
        query.append(" z.oidestadocomision, z.fecinivigor ");
        query.append(" FROM (SELECT   x.oidcomision, x.codigo, x.VERSION, x.descripcion, x.marca, ");
        query.append(" x.canal, x.acceso, x.tipocomision, x.concepto, ");
        query.append(" x.oidestadocomision, x.fecinivigor ");
        query.append(" FROM (SELECT DISTINCT a.oid_comi AS oidcomision, ");
        query.append(" a.cod_comi AS codigo, a.num_vers AS VERSION, ");
        query.append(" b.val_i18n AS descripcion, ");
        query.append(" d.des_marc AS marca, g.val_i18n AS canal, ");
        query.append(" '' AS acceso, k.val_i18n AS tipocomision, ");
        query.append(" a.val_conc AS concepto, ");
        query.append(" a.ceco_oid_esta_comi AS oidestadocomision, ");
        query.append(" l.fec_inic AS fecinivigor ");
        query.append(" FROM com_comis a, ");
        query.append(" v_gen_i18n_sicc b, ");
        query.append(" com_plant_comis_marca c, ");
        query.append(" seg_marca d, ");
        query.append(" v_gen_i18n_sicc g, ");
        query.append(" com_comis_acces h, ");
        query.append(" com_plant_comis_acces i, ");
        query.append(" v_gen_i18n_sicc k, ");
        query.append(" cra_perio l, ");
        query.append(" cra_perio m ");
        //query.append(" WHERE a.ceco_oid_esta_comi = 1
        if (dtoE.getOidEstadoComision() != null)
           query.append(" WHERE a.ceco_oid_esta_comi = " + dtoE.getOidEstadoComision());
        else
        {
           query.append(" WHERE a.ceco_oid_esta_comi IN (" + ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO + ", ");
           query.append(ConstantesCOM.ESTADO_COMISION_CONFIRMACION_CAMBIOS + ") ");
        }                            
        query.append(" AND b.attr_enti(+) = 'COM_COMIS' ");
        query.append(" AND b.attr_num_atri(+) = 1 ");
        query.append(" AND b.idio_oid_idio(+) = " + dtoE.getOidIdioma());
        query.append(" AND b.val_oid(+) = a.oid_comi ");
        query.append(" AND c.oid_plan_comi_marc = a.plcm_oid_plan_comi_marc ");
        query.append(" AND d.oid_marc = c.marc_oid_marc ");
        query.append(" AND g.attr_enti = 'SEG_CANAL' ");
        query.append(" AND g.attr_num_atri = 1 ");
        query.append(" AND g.idio_oid_idio = " + dtoE.getOidIdioma() );
        query.append(" AND g.val_oid = m.cana_oid_cana ");
        query.append(" AND a.perd_oid_peri = m.oid_peri ");
        query.append(" AND h.comi_oid_comi = a.oid_comi ");
        query.append(" AND i.oid_plan_comi_acce = h.plca_oid_plan_comi_acce ");
        query.append(" AND k.attr_enti = 'COM_TIPO_PLANT' ");
        query.append(" AND k.attr_num_atri = 1 ");
        query.append(" AND k.idio_oid_idio = " + dtoE.getOidIdioma() );
        query.append(" AND k.val_oid = a.tpla_oid_tipo_plan ");
        query.append(" AND l.oid_peri(+) = a.perd_oid_peri_vigo_modi ");
        query.append(" ORDER BY a.oid_comi) x, ");
        query.append(" com_comis y ");
        query.append(" WHERE y.oid_comi = x.oidcomision ");
        query.append(" ORDER BY y.fec_ulti_esta DESC, x.oidcomision) z ");
        query.append(" ) where ROWNUM <= " + dtoE.getTamanioPagina() );
        query.append(" and linea > " + dtoE.getIndicadorSituacion() );
        try {
          //String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion( query.toString(), dtoE);
          r = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex)
        {
          UtilidadesLog.error(ex);
          String sError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(ex, UtilidadesError.armarCodigoError(sError));
        }
        
        if ( r.esVacio() )
        {
          String sError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
          throw new MareException("No hay datos", UtilidadesError.armarCodigoError(sError));
        }
        Long[] oidsComisiones = this.obtieneOids(r, new Long(1));
        RecordSet rAccesos = this.obtieneDescAccesoPorOidAceptarModificar(oidsComisiones, dtoE.getOidIdioma(), 
                                                                           dtoE.getOidEstadoComision() );
        r = this.armaRSetFinalAceptarModificar(r, rAccesos);
        
        dtoSalida.setResultado(r);
        UtilidadesLog.info("DAOGestionComisiones.buscarAceptarModificacion(DTOEstadoComision dtoE): Salida");
        return dtoSalida;
    }
    
    private RecordSet armaRSetFinalMarcarModificar(RecordSet r, RecordSet rAccesos) {
       // R y rAccesos tienen el mismo numero de campos a esta altura y los mismos
       // oid (ordenados de la misma manera).
       UtilidadesLog.info("DAOGestionComisiones.armaRSetFinalMarcarModificar(RecordSet r, RecordSet rAccesos): Entrada");
       UtilidadesLog.debug("***** RecordSet entrada: " + r);
       UtilidadesLog.debug("***** RecordSet entrada Accesos: " + rAccesos);  
       
       //String sAccesos = null;       
       for ( int i = 0; i < r.getRowCount(); i++)
       {  /*sAccesos = "";
          for(int z = 0;z<rAccesos.getRowCount();z++)
          {
            if(rAccesos.getValueAt(z,0).equals(r.getValueAt(i,1)))
               sAccesos += ((!"".equals(sAccesos))?" - ":"").concat((String)rAccesos.getValueAt(z,1));                                          
          }*/
          String sAccesos = (String) rAccesos.getValueAt(i,1);                  
          r.setValueAt(sAccesos,i,6);
       }
       UtilidadesLog.debug(" Record Final: " + r);
       UtilidadesLog.info("DAOGestionComisiones.armaRSetFinalMarcarModificar(RecordSet r, RecordSet rAccesos): Salida");       
      return r;
    }
    
    private RecordSet armaRSetFinalAceptarModificar(RecordSet r, RecordSet rAccesos)
    {
       // R y rAccesos tienen el mismo numero de campos a esta altura y los mismos
       // oid.
       
       UtilidadesLog.info("DAOGestionComisiones.armaRSetFinalAceptarModificar(RecordSet r, RecordSet rAccesos): Entrada");

       UtilidadesLog.debug("***** RecordSet entrada: " + r);
       UtilidadesLog.debug("***** RecordSet entrada: " + rAccesos);       
       
       for (int i = 0; i < r.getRowCount(); i++)
       {
          String descAcceso = (String) rAccesos.getValueAt(i,1);
          //Long oidAcceso = new Long( bigOidAcceso.longValue() );
          r.setValueAt(descAcceso, i,7);
       }
       
       UtilidadesLog.debug("***** RecordSet modificado: " + r);
       UtilidadesLog.info("DAOGestionComisiones.armaRSetFinalAceptarModificar(RecordSet r, RecordSet rAccesos): Salida");
       return r;      
    }
    
    private RecordSet obtieneDescAccesoPorOidAceptarModificar(Long[] oidComisiones, Long oidIdioma, Long oidEstadoComision) throws MareException
    {
      UtilidadesLog.info("DAOGestionComisiones.obtieneDescAccesoPorOidAceptarModificar(Long[] oidComisiones, Long oidIdioma, Long oidEstadoComision): Entrada");
      StringBuffer sqlQuery = new StringBuffer("");
      RecordSet r = null;
      BelcorpService bs = BelcorpService.getInstance();
      
      sqlQuery.append(" SELECT a.oid_comi, v.val_i18n, i.acce_oid_acce ");
      sqlQuery.append(" FROM com_comis a, ");
      sqlQuery.append(" com_plant_comis_marca c, ");
      sqlQuery.append(" com_comis_acces h, ");
      sqlQuery.append(" com_plant_comis_acces i, ");
      sqlQuery.append(" seg_marca d, ");
      sqlQuery.append(" cra_perio l, ");
      sqlQuery.append(" cra_perio m, ");
      sqlQuery.append(" v_gen_i18n_sicc v "); 
      if (oidEstadoComision != null)
        sqlQuery.append(" WHERE a.ceco_oid_esta_comi = " + oidEstadoComision);
      else
      {
        sqlQuery.append(" WHERE a.ceco_oid_esta_comi IN (" + ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO + ", ");
        sqlQuery.append(ConstantesCOM.ESTADO_COMISION_CONFIRMACION_CAMBIOS + ") ");
      }
      
      //sqlQuery.append(" WHERE a.ceco_oid_esta_comi = " + oidEstadoComision);
      sqlQuery.append(" AND a.oid_comi " + this.generaINClause(oidComisiones) );
      sqlQuery.append(" AND c.oid_plan_comi_marc = a.plcm_oid_plan_comi_marc ");
      sqlQuery.append(" AND d.oid_marc = c.marc_oid_marc "); 
      sqlQuery.append(" AND a.perd_oid_peri = m.oid_peri ");
      sqlQuery.append(" AND h.comi_oid_comi = a.oid_comi ");
      sqlQuery.append(" AND i.oid_plan_comi_acce = h.plca_oid_plan_comi_acce ");
      sqlQuery.append(" AND l.oid_peri(+) = a.perd_oid_peri_vigo_modi ");
      sqlQuery.append(" AND i.acce_oid_acce = v.val_oid ");
      sqlQuery.append(" AND v.attr_enti = 'SEG_ACCES' ");
      sqlQuery.append(" AND v.attr_num_atri = 1 ");
      sqlQuery.append(" AND v.idio_oid_idio = " + oidIdioma );
      sqlQuery.append(" ORDER BY 1, 2 ");
      try {
        r = bs.dbService.executeStaticQuery( sqlQuery.toString() );
      } catch (Exception ex)
      {
        UtilidadesLog.error(ex);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      
      r = this.concatenaCampos(r);
      UtilidadesLog.info("DAOGestionComisiones.obtieneDescAccesoPorOidAceptarModificar(Long[] oidComisiones, Long oidIdioma, Long oidEstadoComision): Salida");
      return r;      
    }
    

    
    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return DTOSalida
    * @documentation
        Obtiene la versión vigente de una dada (la inmediatamente anterior con estado activo). 
        
        Proceso 
        ======== 
        Se ejecuta la query (la última columna de esta query se retorna siempre vacía para facilitar el rellenado de la misma desde el método desde el que es invocado): 
        
        SELECT 
        A.oid_comi as oid, 
        A.cod_comi as codigo, 
        A.nume_vers as version, 
        B.val_i18n as descripcion, 
        D.desc_marc as marca, 
        G.val_i18n as canal, 
        I.acce_oid_acce as oidAcceso, 
        J.val_i18n as acceso, 
        K.val_i18n as tipoComision, 
        A.val_conc as concepto, 
        C.marc_oid_marc as oidMarca, 
        A.cana_oid_cana as oidCanal, 
        E.pais_oid_pais as oidPais, 
        '' as fecIniPeriodoActual 
        
        FROM 
        com_comis A, 
        v_gen_i18n_sicc B, 
        com_plant_comis_marca C, 
        seg_marca D, 
        com_plant_comis_pais E, 
        v_gen_i18n_sicc G, 
        com_comis_acces H, 
        com_plant_comis_acces I, 
        v_gen_i18n_sicc J, 
        v_gen_i18n_sicc K 
        
        WHERE 
        A.cod_comi = (SELECT cod_comi 
        FROM com_comis 
        WHERE oid_comi = dto.oid) AND 
        A.nume_vers < (SELECT nume_vers 
        FROM com_comis 
        WHERE oid_comi = dto.oid) AND 
        A.esco_oid_esta = ConstantesCOM.ESTADO_COMISION_ACTIVA AND 
        B.attr_enti (+) = 'COM_COMIS' AND 
        B.attr_num_atri (+) = 1 AND 
        B.idio_oid_idio (+) = dto.idioma AND 
        B.val_oid (+) = A.oid_comi AND 
        C.oid_plan_comi_marc = A.pcma_oid_plan_comi_marc AND 
        D.oid_marc = C.marc_oid_marc AND 
        E.oid_plan_comi_pais = A.pcpa_oid_plan_comi_pais AND 
        G.attr_enti = 'SEG_CANAL' AND 
        G.attr_num_atri = 1 AND 
        G.idio_oid_idio = dto.idioma AND 
        G.val_oid = A.cana_oid_cana AND 
        H.comi_oid_comi = A.oid_comi AND 
        I.oid_plan_comi_acce = H.pcac_oid_plan_comi_acce AND 
        J.attr_enti = 'SEG_ACCES' AND 
        J.attr_num_atri = 1 AND 
        J.idio_oid_idio = dto.idioma AND 
        J.val_oid = I.acce_oid_acce AND 
        K.attr_enti = 'COM_TIPO_PLANT' AND 
        K.attr_num_atri = 1 AND 
        K.idio_oid_idio = dto.idioma AND 
        K.val_oid = A.tipl_oid_tipo_plan 

        ORDER BY A.nume_vers DESC, I.acce_oid_acce 
        
        Dado que una comisión puede estar asociada a más de un acceso, la query retorna para cada comisión tantos registros como accesos a los que esté asociado. Se trata el RecordSet (resultado) obtenido para devolver un sólo registro por comisión. Además, sólo se va a retornan la primera comisión que se obtenga ya que tenemos que proporcionar la versión anterior y más próxima a la versión de la comisión de entrada. 
        
        Se crean las variables Long oidComision y oidAcceso que se inicializan a cero. 
        Se crea la variable String sAcceso que se inicializa a "". 
        Se crea la variable RecordSet rVersionVigente que incialmente estará vacía. 
        Se crea la variable Boolean bTerminado que se inicializa a False. 
        
        Por cada registro en resultado
          Si oidComision <> resultado(i).oid
            Si oidComision <> 0
              Se añade un elemento a rVersionVigente y se carga como sigue: 
              rVersionVigente(0).oid = oidComision 
              rVersionVigente(0).codigo = resultado(i - 1).codigo 
              rVersionVigente(0).version = resultado(i - 1).version 
              rVersionVigente(0).descripcion = resultado(i - 1).descripcion 
              rVersionVigente(0).marca = resultado(i - 1).marca 
              rVersionVigente(0).canal = resultado(i - 1).canal 
              rVersionVigente(0).acceso = sAcceso 
              rVersionVigente(0).tipoComision = resultado(i - 1).tipoComision 
              rVersionVigente(0).concepto = resultado(i - 1).concepto 
              rVersionVigente(0).oidMarca = resultado(i - 1).oidMarca 
              rVersionVigente(0).oidCanal = resultado(i - 1).oidCanal 
              rVersionVigente(0).oidPais = resultado(i - 1).oidPais 
              rVersionVigente(0).fecIniPeriodoActual = resultado(i - 1).fecIniPeriodoActual 
              
              bTerminado = True 
              Se sale del bucle 
            Fin del Si
            
            oidComision = resultado(i).oid 
            oidAcceso = resultado(i).oidAcceso 
            sAcceso = resultado(i).acceso 
          Fin del Si 
            
          Si oidAcceso <> resultado(i).oidAcceso 
            sAcceso += ", " + resultado(i).acceso 
            oidAcceso = resultado(i).oidAcceso 
          Fin del Si 
        Fin del Bucle 
        
        Si bTerminado == False y resultado tiene registros (sólo se ha obtenido una versión en la query) 
          Se añade un elemento a rVersionVigente y se carga como sigue: 
          rVersionVigente(0).oid = oidComision 
          rVersionVigente(0).codigo = resultado(último elemento).codigo 
          rVersionVigente(0).version = resultado(último elemento).version 
          rVersionVigente(0).descripcion = resultado(último elemento).descripcion 
          rVersionVigente(0).marca = resultado(último elemento).marca 
          rVersionVigente(0).canal = resultado(último elemento).canal 
          rVersionVigente(0).acceso = sAcceso 
          rVersionVigente(0).tipoComision = resultado(último elemento).tipoComision 
          rVersionVigente(0).concepto = resultado(último elemento).concepto 
          rVersionVigente(0).oidMarca = resultado(último elemento).oidMarca 
          rVersionVigente(0).oidCanal = resultado(último elemento).oidCanal 
          rVersionVigente(0).oidPais = resultado(último elemento).oidPais 
          rVersionVigente(0).fecIniPeriodoActual = resultado(último elemento).fecIniPeriodoActual 
        Fin del Si 
        
        Se carga un DTOSalida con el RecordSet rVersionVigente que tiene las columnas: 
        oid, 
        codigo, 
        version, 
        descripcion, 
        marca, 
        canal, 
        acceso, 
        tipoComision, 
        concepto, 
        oidMarca, 
        oidCanal, 
        oidPais, 
        fecIniPeriodoActual    
    */
    public DTOSalida cargaConfirmarModificar(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("DAOGestionComisiones.cargaConfirmarModificar(DTOOID dtoE): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet resultado = new RecordSet();
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 

        query.append(" SELECT ");
        query.append(" A.oid_comi as oid, ");
        query.append(" A.cod_comi as codigo, ");
        query.append(" A.num_vers as version, ");
        query.append(" B.val_i18n as descripcion, ");
        query.append(" D.des_marc as marca, ");
        query.append(" G.val_i18n as canal, ");
        query.append(" I.acce_oid_acce as oidAcceso, ");
        query.append(" J.val_i18n as acceso, ");
        query.append(" K.val_i18n as tipoComision, ");
        query.append(" A.val_conc as concepto, ");
        query.append(" C.marc_oid_marc as oidMarca, ");
        query.append(" L.cana_oid_cana as oidCanal, ");
        query.append(" E.pais_oid_pais as oidPais, ");
        query.append(" '' as fecIniPeriodoActual ");
        
        query.append(" FROM ");
        query.append(" com_comis A, ");
        query.append(" v_gen_i18n_sicc B, ");
        query.append(" com_plant_comis_marca C, ");
        query.append(" seg_marca D, ");
        query.append(" com_plant_comis_pais E, ");
        query.append(" v_gen_i18n_sicc G, ");
        query.append(" com_comis_acces H, ");
        query.append(" com_plant_comis_acces I, ");
        query.append(" v_gen_i18n_sicc J, ");
        query.append(" v_gen_i18n_sicc K, ");
        query.append(" cra_perio L ");
        
        query.append(" WHERE ");
        query.append(" A.PERD_OID_PERI=L.OID_PERI AND "); //jquiroga Inc 15061
        query.append(" A.cod_comi = (SELECT cod_comi FROM com_comis WHERE oid_comi = "+dtoE.getOid()+") AND "); 
        query.append(" A.num_vers < (SELECT num_vers FROM com_comis WHERE oid_comi = "+dtoE.getOid()+") AND ");
        query.append(" A.CECO_OID_ESTA_COMI = "+ConstantesCOM.ESTADO_COMISION_ACTIVA +" AND ");
        query.append(" B.attr_enti (+) = 'COM_COMIS' AND ");
        query.append(" B.attr_num_atri (+) = 1 AND ");
        query.append(" B.idio_oid_idio (+) = "+dtoE.getOidIdioma()+" AND  ");
        query.append(" B.val_oid (+) = A.oid_comi AND  ");
        query.append(" C.oid_plan_comi_marc = A.plcm_oid_plan_comi_marc AND  ");
        query.append(" D.oid_marc = C.marc_oid_marc AND  ");
        query.append(" E.oid_plan_comi_pais = A.plcp_oid_plan_comi_pais AND  ");
        query.append(" G.attr_enti = 'SEG_CANAL' AND  ");
        query.append(" G.attr_num_atri = 1 AND  ");
        query.append(" G.idio_oid_idio = "+dtoE.getOidIdioma()+" AND ");
        query.append(" G.val_oid = L.cana_oid_cana AND  ");
        query.append(" H.comi_oid_comi = A.oid_comi AND  ");
        query.append(" I.oid_plan_comi_acce = H.plca_oid_plan_comi_acce AND  ");
        query.append(" J.attr_enti = 'SEG_ACCES' AND  ");
        query.append(" J.attr_num_atri = 1 AND  ");
        query.append(" J.idio_oid_idio = "+dtoE.getOidIdioma()+" AND  ");
        query.append(" J.val_oid = I.acce_oid_acce AND  ");
        query.append(" K.attr_enti = 'COM_TIPO_PLANT' AND  ");
        query.append(" K.attr_num_atri = 1 AND  ");
        query.append(" K.idio_oid_idio = "+dtoE.getOidIdioma()+" AND  ");
        query.append(" K.val_oid = A.tpla_oid_tipo_plan ");
        
        query.append(" ORDER BY A.num_vers DESC, I.acce_oid_acce ");

        /*
        Dado que una comisión puede estar asociada a más de un acceso, 
        la query retorna para cada comisión tantos registros como accesos a los que esté 
        asociado. Se trata el RecordSet (resultado) obtenido para devolver un sólo registro 
        por comisión. Además, sólo se va a retornan la primera comisión que se obtenga ya que 
        tenemos que proporcionar la versión anterior y más próxima a la versión de la 
        comisión de entrada.
        */        
        try {
            resultado =  bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("Resultado: "+resultado);
        }
        catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        if(resultado.esVacio())  {   
          throw new MareException(null, null,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        Long oidComision=new Long(0);
        Long oidAcceso=new Long(0);
        String sAcceso=new String("");
        RecordSet rVersionVigente=new RecordSet();        
        Boolean bTerminado=Boolean.FALSE;
        Vector valores = null;
        Long tmpLng=null;
        
        rVersionVigente.addColumn("oid");
        rVersionVigente.addColumn("codigo");
        rVersionVigente.addColumn("version");
        rVersionVigente.addColumn("descripcion");
        rVersionVigente.addColumn("marca");
        rVersionVigente.addColumn("canal");
        rVersionVigente.addColumn("acceso");
        rVersionVigente.addColumn("tipoComision");
        rVersionVigente.addColumn("concepto");
        rVersionVigente.addColumn("oidMarca");
        rVersionVigente.addColumn("oidCanal");
        rVersionVigente.addColumn("oidPais");
        rVersionVigente.addColumn("fecIniPeriodoActual");
        
        for (int i = 0; i < resultado.getRowCount(); i++) {
          if(oidComision != objectToLong(resultado.getValueAt(i, "OID"))) {
            if(oidComision.intValue() != 0) {
              //Se añade un elemento a rVersionVigente y se carga como sigue:
              UtilidadesLog.debug("1.-");
              valores = new Vector();              
                valores.add(oidComision);
                UtilidadesLog.debug("oidComision: "+oidComision);
                valores.add(resultado.getValueAt(i-1, "CODIGO"));
                UtilidadesLog.debug("codigo: "+resultado.getValueAt(i-1, "CODIGO"));
                valores.add(resultado.getValueAt(i-1, "VERSION"));
                UtilidadesLog.debug("version: "+resultado.getValueAt(i-1, "VERSION"));

                valores.add(resultado.getValueAt(i-1, "DESCRIPCION"));
                UtilidadesLog.debug("descripcion: "+resultado.getValueAt(i-1, "DESCRIPCION"));

                valores.add(resultado.getValueAt(i-1, "MARCA"));
                UtilidadesLog.debug("marca: "+resultado.getValueAt(i-1, "MARCA"));

                valores.add(resultado.getValueAt(i-1, "CANAL"));
                UtilidadesLog.debug("canal: "+resultado.getValueAt(i-1, "CANAL"));

                valores.add(sAcceso);
                UtilidadesLog.debug("sAcceso: "+sAcceso);

                valores.add(resultado.getValueAt(i-1, "TIPOCOMISION"));
                UtilidadesLog.debug("tipoComision: "+resultado.getValueAt(i-1, "TIPOCOMISION"));

                valores.add(resultado.getValueAt(i-1, "CONCEPTO"));
                UtilidadesLog.debug("concepto: "+resultado.getValueAt(i-1, "CONCEPTO"));

                valores.add(resultado.getValueAt(i-1, "OIDMARCA"));
                UtilidadesLog.debug("oidMarca: "+resultado.getValueAt(i-1, "OIDMARCA"));

                valores.add(resultado.getValueAt(i-1, "OIDCANAL"));     
                UtilidadesLog.debug("oidCanal: "+resultado.getValueAt(i-1, "OIDCANAL"));

                valores.add(resultado.getValueAt(i-1, "OIDPAIS"));
                UtilidadesLog.debug("oidPais: "+resultado.getValueAt(i-1, "OIDPAIS"));

                valores.add(resultado.getValueAt(i-1, "FECINIPERIODOACTUAL"));
                UtilidadesLog.debug("fecIniPeriodoActual: "+resultado.getValueAt(i-1, "FECINIPERIODOACTUAL"));

              
              rVersionVigente.insertRow(0,valores);              
              bTerminado = Boolean.TRUE;
              break;
            }            
            oidComision = objectToLong(resultado.getValueAt(i, "OID"));  
            UtilidadesLog.debug("oid: "+oidComision);
            oidAcceso = objectToLong(resultado.getValueAt(i, "OIDACCESO")); 
            UtilidadesLog.debug("oidAcceso: "+oidAcceso);
            UtilidadesLog.debug("acceso: "+resultado.getValueAt(i, "ACCESO"));
            
            UtilidadesLog.debug("descripcion: "+resultado.getValueAt(i, "DESCRIPCION"));
            sAcceso = (String)resultado.getValueAt(i, "ACCESO");
            UtilidadesLog.debug("sAcceso: "+sAcceso);
          }
          
          tmpLng=objectToLong(resultado.getValueAt(i, "OIDACCESO"));
          if(tmpLng!=null && oidAcceso.longValue() != tmpLng.longValue()) { 
            sAcceso += ", " + (String)resultado.getValueAt(i, "ACCESO");
            oidAcceso = tmpLng;
          }
        } 
        
        if(bTerminado == Boolean.FALSE && resultado.getRowCount()!=0) {  //(sólo se ha obtenido una versión en la query)
          //Se añade un elemento a rVersionVigente y se carga como sigue:
          int tmpUltEle=resultado.getRowCount()-1;
          valores = new Vector();
            valores.add(oidComision);
            valores.add(resultado.getValueAt(tmpUltEle, "CODIGO"));
            UtilidadesLog.debug("codigo: "+resultado.getValueAt(tmpUltEle, "CODIGO"));
            
            valores.add(resultado.getValueAt(tmpUltEle, "VERSION"));
            UtilidadesLog.debug("version: "+resultado.getValueAt(tmpUltEle, "VERSION"));
            
            valores.add(resultado.getValueAt(tmpUltEle, "DESCRIPCION"));
            UtilidadesLog.debug("descripcion: "+resultado.getValueAt(tmpUltEle, "DESCRIPCION"));
            
            valores.add(resultado.getValueAt(tmpUltEle, "MARCA"));
            UtilidadesLog.debug("marca: "+resultado.getValueAt(tmpUltEle, "MARCA"));
            
            valores.add(resultado.getValueAt(tmpUltEle, "CANAL"));
            UtilidadesLog.debug("canal: "+resultado.getValueAt(tmpUltEle, "CANAL"));
            
            valores.add(sAcceso);
            UtilidadesLog.debug("sAcceso: "+sAcceso);
            
            valores.add(resultado.getValueAt(tmpUltEle, "TIPOCOMISION"));
            UtilidadesLog.debug("tipoComision: "+resultado.getValueAt(tmpUltEle, "TIPOCOMISION"));
            
            valores.add(resultado.getValueAt(tmpUltEle, "CONCEPTO"));
            UtilidadesLog.debug("CONCEPTO: "+resultado.getValueAt(tmpUltEle, "CONCEPTO"));
            
            valores.add(resultado.getValueAt(tmpUltEle, "OIDMARCA"));
            UtilidadesLog.debug("OIDMARCA: "+resultado.getValueAt(tmpUltEle, "OIDMARCA"));
            
            valores.add(resultado.getValueAt(tmpUltEle, "OIDCANAL"));  
            UtilidadesLog.debug("oidCanal: "+resultado.getValueAt(tmpUltEle, "OIDCANAL"));
            
            valores.add(resultado.getValueAt(tmpUltEle, "OIDPAIS"));
            UtilidadesLog.debug("oidPais: "+resultado.getValueAt(tmpUltEle, "OIDPAIS"));
            
            valores.add(resultado.getValueAt(tmpUltEle, "FECINIPERIODOACTUAL"));    
            UtilidadesLog.debug("fecIniPeriodoActual: "+resultado.getValueAt(tmpUltEle, "FECINIPERIODOACTUAL"));
            
          
          rVersionVigente.insertRow(0,valores); 
        }      

        //Se carga un DTOSalida con el RecordSet rVersionVigente que tiene las columnas
        dtoSalida.setResultado(rVersionVigente);
        UtilidadesLog.debug("DTOSALIDA: " + dtoSalida);
        UtilidadesLog.info("DAOGestionComisiones.cargaConfirmarModificar(DTOOID dtoE): Salida");
        return dtoSalida;
    }
    
  /**
   * @Author: ssantana, 15/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param 
   */
    public DTOSalida obtenerTiposInsercionProducto(DTOBelcorp dto) throws MareException
    {
       UtilidadesLog.info("DAOGestionComisiones.obtenerTiposInsercionProducto(DTOBelcorp dto): Entrada");
       DTOSalida dtoSalida = new DTOSalida();
       BelcorpService bs = BelcorpService.getInstance();
       RecordSet resultado = null;
       
       StringBuffer sql = new StringBuffer("");
      
       sql.append(" SELECT com_tipo_inser_produ.oid_tipo_inse_prod AS OID, ");
       sql.append(" v_gen_i18n_sicc.val_i18n AS descripcion ");
       sql.append(" FROM com_tipo_inser_produ, v_gen_i18n_sicc ");
       sql.append(" WHERE v_gen_i18n_sicc.attr_enti = 'COM_TIPO_INSER_PRODU' ");
       sql.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
       sql.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + dto.getOidIdioma());
       sql.append(" AND v_gen_i18n_sicc.val_oid = com_tipo_inser_produ.oid_tipo_inse_prod ");
       
       try 
       {
         resultado = bs.dbService.executeStaticQuery(sql.toString());
         UtilidadesLog.debug("resultado: " + resultado);
       } catch (Exception ex)
       {
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
       }
       
       dtoSalida.setResultado(resultado);
       UtilidadesLog.info("DAOGestionComisiones.obtenerTiposInsercionProducto(DTOBelcorp dto): Salida");
       return dtoSalida;      
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return DTOSalida
    * @documentation
        Obtiene los distintos códigos de las comisiones dadas de alta en el sistema. 
        
        Proceso 
        ======== 
        Se ejecuta la query (se retorna dos veces la misma columna porque se va a cargar 
        una combo con los distintos códigos de comisión, si se pusiera como primera columna 
        el oid el resultado no sería el que se desea ya que los oids son todos distintos y se 
        podría recuperar un mismo código varias veces): 
        
        SELECT
        
        DISTINCT 
        cod_comi as oid, 
        cod_comi as codigo 
        
        FROM com_comis
    */
    public DTOSalida obtenerCodigosComisiones(DTOBelcorp dtoE) throws MareException {
       UtilidadesLog.info("DAOGestionComisiones.obtenerCodigosComisiones(DTOBelcorp dtoE): Entrada");
       DTOSalida dtoSalida = new DTOSalida();
       BelcorpService bs = BelcorpService.getInstance();
       RecordSet resultado = null;
       
       StringBuffer sql = new StringBuffer("");      
       sql.append(" SELECT DISTINCT oid_comi as oid, cod_comi as codigo FROM com_comis ");
       // dmorello, 18/05/2006: Ordeno ascendentemente los códigos para que asi se vean en pantalla
       sql.append(" ORDER BY cod_comi ASC ");
      
       try {
         resultado = bs.dbService.executeStaticQuery(sql.toString());
       } 
       catch (Exception ex) {
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
       }
       
       dtoSalida.setResultado(resultado);
       UtilidadesLog.info("DAOGestionComisiones.obtenerCodigosComisiones(DTOBelcorp dtoE): Salida");
       return dtoSalida;
    }
    
    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return DTOSalida
    * @documentation
        Obtiene las distintas marcas de las comisiones dadas de alta en el sistema. 
        
        Proceso 
        ======== 
        Se ejecuta la query: 
        
        SELECT 
        DISTINCT B.marc_oid_marc as oid, 
        C.desc_marc as descripcion 
        
        FROM 
        com_comis A, 
        com_plant_comis_marca B, 
        seg_marca C 
        
        WHERE 
        B.oid_plan_comi_marc = A.pcma_oid_plan_comi_marc AND 
        C.oid_marc = B.marc_oid_marc
    */
    public DTOSalida obtenerMarcasComisiones(DTOBelcorp dtoE) throws MareException {
       UtilidadesLog.info("DAOGestionComisiones.obtenerMarcasComisiones(DTOBelcorp dtoE): Entrada");
       DTOSalida dtoSalida = new DTOSalida();
       BelcorpService bs = BelcorpService.getInstance();
       RecordSet resultado = null;
       
       StringBuffer sql = new StringBuffer("");      
       sql.append(" SELECT ");
       sql.append(" DISTINCT B.marc_oid_marc as oid, ");
       sql.append(" C.des_marc as descripcion ");
       
       sql.append(" FROM ");
       sql.append(" com_comis A, ");
       sql.append(" com_plant_comis_marca B, ");
       sql.append(" seg_marca C ");
       
       sql.append(" WHERE ");
       sql.append(" B.oid_plan_comi_marc = A.plcm_oid_plan_comi_marc AND ");
       sql.append(" C.oid_marc = B.marc_oid_marc ");
      
       try {
         resultado = bs.dbService.executeStaticQuery(sql.toString());
       } 
       catch (Exception ex) {
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
       }
       
       dtoSalida.setResultado(resultado);
       UtilidadesLog.debug("DTOSALIDA: *** "+dtoSalida);
       UtilidadesLog.info("DAOGestionComisiones.obtenerMarcasComisiones(DTOBelcorp dtoE): Salida");
       return dtoSalida;
    }
    
    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return DTOSalida
    * @documentation
        Obtiene los distintos canales de las comisiones dadas de alta en el sistema.
        
        Proceso 
        ======== 
        Se ejecuta la query: 
        
        SELECT 
        DISTINCT A.cana_oid_cana as oid, 
        B.val_i18n as descripcion 
        
        FROM 
        com_comis A, 
        v_gen_i18n_sicc B 
        
        WHERE 
        B.attr_enti = 'SEG_CANAL' AND 
        B.attr_num_atri = 1 AND 
        B.idio_oid_idio = dto.idioma AND 
        B.val_oid = A.cana_oid_cana    
    */
    public DTOSalida obtenerCanalesComisiones(DTOBelcorp dtoE) throws MareException {
       UtilidadesLog.info("DAOGestionComisiones.obtenerCanalesComisiones(DTOBelcorp dtoE): Entrada");
       DTOSalida dtoSalida = new DTOSalida();
       BelcorpService bs = BelcorpService.getInstance();
       RecordSet resultado = null;
       
       StringBuffer sql = new StringBuffer("");      
       sql.append(" SELECT ");
       sql.append(" DISTINCT L.cana_oid_cana as oid, ");
       sql.append(" B.val_i18n as descripcion ");
      
       sql.append(" FROM ");
       sql.append(" com_comis A, ");
       sql.append(" v_gen_i18n_sicc B, ");
       sql.append(" CRA_PERIO L ");
       
       sql.append(" WHERE ");
       sql.append(" B.attr_enti = 'SEG_CANAL' AND ");
       sql.append(" B.attr_num_atri = 1 AND ");
       sql.append(" B.idio_oid_idio = " + dtoE.getOidIdioma() + " AND ");
       sql.append(" B.val_oid = L.cana_oid_cana AND ");
       sql.append(" A.PERD_OID_PERI=L.OID_PERI ");
      
       try {
         resultado = bs.dbService.executeStaticQuery(sql.toString());
       } 
       catch (Exception ex) {
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
       }
       
       dtoSalida.setResultado(resultado);
       UtilidadesLog.info("DAOGestionComisiones.obtenerCanalesComisiones(DTOBelcorp dtoE): Salida");
       return dtoSalida;
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return DTOSalida
    * @documentation
        Obtiene los distintos accesos de las comisiones dadas de alta en el sistema. 

        Proceso 
        ======== 
        Se ejecuta la query: 
        
        SELECT 
        DISTINCT B.acce_oid_acce as oid, 
        C.val_i18n as descripcion 
        
        FROM 
        com_comis_acces A, 
        com_plant_comis_acces B, 
        v_gen_i18n_sicc C 
        
        WHERE 
        B.oid_plan_comi_acce = A.pcac_oid_plan_comi_acce AND 
        C.attr_enti = 'SEG_ACCES' AND 
        C.attr_num_atri = 1 AND 
        C.idio_oid_idio = dto.idioma AND 
        C.val_oid = B.acce_oid_acce    
    */    
    public DTOSalida obtenerAccesosComisiones(DTOBelcorp dtoE) throws MareException {
       UtilidadesLog.info("DAOGestionComisiones.obtenerAccesosComisiones(DTOBelcorp dtoE): Entrada");
       DTOSalida dtoSalida = new DTOSalida();
       BelcorpService bs = BelcorpService.getInstance();
       RecordSet resultado = null;
       
       StringBuffer sql = new StringBuffer("");
       sql.append("SELECT ");
       sql.append(" DISTINCT B.acce_oid_acce as oid,  ");
       sql.append(" C.val_i18n as descripcion  ");
       
       sql.append(" FROM  ");
       sql.append(" com_comis_acces A,  ");
       sql.append(" com_plant_comis_acces B,  ");
       sql.append(" v_gen_i18n_sicc C  ");
       
       sql.append(" WHERE  ");
       sql.append(" B.oid_plan_comi_acce = A.plca_oid_plan_comi_acce AND  ");
       sql.append(" C.attr_enti = 'SEG_ACCES' AND  ");
       sql.append(" C.attr_num_atri = 1 AND  ");
       sql.append(" C.idio_oid_idio = " + dtoE.getOidIdioma() + " AND  ");
       sql.append(" C.val_oid = B.acce_oid_acce  ");
       
       try {
         resultado = bs.dbService.executeStaticQuery(sql.toString());
       } 
       catch (Exception ex) {
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
       }
       
       dtoSalida.setResultado(resultado);
       UtilidadesLog.info("DAOGestionComisiones.obtenerAccesosComisiones(DTOBelcorp dtoE): Salida");
       return dtoSalida;
    }
    
    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return DTOSalida
    * @documentation
        Obtiene las versiones de una comisión. 
        
        Proceso 
        ======== 
        Se ejecuta la query (se retorna dos veces la misma columna porque se va a cargar una combo con las distintas versiones de un código de comisión, si se pusiera como primera columna el oid el resultado no sería el que se desea ya que los oids son todos distintos y se podría recuperar una misma versión varias veces): 
        
        SELECT 
        DISTINCT nume_vers as oid, 
        nume_vers as version 
        
        FROM 
        com_comis 
        
        WHERE 
        cod_comi = dto.codComision    
    */    
    public DTOSalida obtenerVersionesComision(DTOCodigoComision dtoE) throws MareException {
       UtilidadesLog.info("DAOGestionComisiones.obtenerVersionesComision(DTOCodigoComision dtoE): Entrada");
       DTOSalida dtoSalida = new DTOSalida();
       BelcorpService bs = BelcorpService.getInstance();
       RecordSet resultado = null;
       
       StringBuffer sql = new StringBuffer("");
       sql.append("SELECT ");
       sql.append(" DISTINCT num_vers as oid,  ");
       sql.append(" num_vers as version  ");
       sql.append(" FROM  ");
       sql.append(" com_comis  ");
       sql.append(" WHERE  ");
       sql.append(" cod_comi = '" + dtoE.getCodComision() + "'");
       // dmorello, 18/05/2006: Ordeno ascendentemente los números de versión para que asi se vean en pantalla
       sql.append(" ORDER BY num_vers ASC ");

       
       try {
         resultado = bs.dbService.executeStaticQuery(sql.toString());
       } 
       catch (Exception ex) {
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
       }
       
       dtoSalida.setResultado(resultado);
       UtilidadesLog.info("DAOGestionComisiones.obtenerVersionesComision(DTOCodigoComision dtoE): Salida");
       return dtoSalida;
    }
   
    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return DTOSalida
    * @documentation
        Obtiene las comisiones que cumplen el criterio especificado por el usuario. 
        Búsqueda paginada. 
        
        Proceso 
        ========= 
        Se ejecuta la query: 
        
        SELECT * FROM 
        ( 
        SELECT 
        ROWNUM as linea, 
        oid, 
        codigo, 
        descripcion, 
        marca, 
        canal, 
        oidAcceso, 
        acceso, 
        tipoComision, 
        concepto, 
        version 
        
        FROM 
        ( 
        SELECT 
        A.oid_comi as oid, 
        A.cod_comi as codigo, 
        B.val_i18n as descripcion, 
        D.desc_marc as marca, 
        G.val_i18n as canal, 
        I.acce_oid_acce as oidAcceso, 
        J.val_i18n as acceso, 
        K.val_i18n as tipoComision, 
        A.val_conc as concepto, 
        A.nume_vers as version 
        
        FROM 
        com_comis A, 
        v_gen_i18n_sicc B, 
        com_plant_comis_marca C, 
        seg_marca D, 
        v_gen_i18n_sicc G, 
        com_comis_acces H, 
        com_plant_comis_acces I, 
        v_gen_i18n_sicc J, 
        v_gen_i18n_sicc K 
        
        WHERE 
        A.esco_oid_esta = ConstantesCOM.ESTADO_COMISION_ACTIVA AND 
        B.attr_enti (+) = 'COM_COMIS' AND 
        B.attr_num_atri (+) = 1 AND 
        B.idio_oid_idio (+) = dto.idioma AND 
        B.val_oid (+) = A.oid_comi AND 
        C.oid_plan_comi_marc = A.pcma_oid_plan_comi_marc AND 
        D.oid_marc = C.marc_oid_marc AND 
        G.attr_enti = 'SEG_CANAL' AND 
        G.attr_num_atri = 1 AND 
        G.idio_oid_idio = dto.idioma AND 
        G.val_oid = A.cana_oid_cana AND 
        H.comi_oid_comi = A.oid_comi AND 
        I.oid_plan_comi_acce = H.pcac_oid_plan_comi_acce AND 
        J.attr_enti = 'SEG_ACCES' AND 
        J.attr_num_atri = 1 AND 
        J.idio_oid_idio = dto.idioma AND 
        J.val_oid = I.acce_oid_acce AND 
        K.attr_enti = 'COM_TIPO_PLANT' AND 
        K.attr_num_atri = 1 AND 
        K.idio_oid_idio = dto.idioma AND 
        K.val_oid = A.tipl_oid_tipo_plan 
        
        AND A.cod_comi = dto.codigo 
        AND A.nume_vers = dto.version 
        AND A.cana_oid_cana = dto.oidCanal 
        AND A.tipl_oid_tipo_plan = dto.oidTipoComision 
        AND B.val_i18n LIKE dto.descripcion 
        AND C.marc_oid_marc = dto.oidMarca 
        AND I.acce_oid_acce = dto.oidAcceso 
        
        ORDER BY A.fec_ulti_esta DESC, A.oid_comi, I.acce_oid_acce 
        ) 
        ) 
        WHERE 
        linea > dto.indicadorSituacion 
        
        Hay que tener en cuenta que los atributos 
        dto.descripcion 
        dto.oidCanal 
        dto.oidAcceso 
        dto.oidMarca 
        dto.codigo 
        dto.version 
        dto.oidTipoComision 
        pueden ser nulos, en cuyo caso no se utilizan en la clausula WHERE de la query. 
        
        Dado que una comisión puede estar asociada a más de un acceso, un mismo oid de comisión aparecerá hasta "n" veces con distintos accesos. Por tanto se trata el RecordSet (resultado) obtenido para devolver un sólo registro por comisión (con los accesos concatenados): 
        
        Se crean las variables Long oidComision y oidAcceso que se inicializan a cero. 
        
        Se crea la variable String sAcceso que se inicializa a "". 
        
        Se crea la variable Integer iFila que se inicializa a cero. 
        
        Se crea la variable RecordSet rComisiones que inicialmente estará vacío. 
        
        Se crea la variable Boolean bSalir que se inicializa a False. 
        
        Por cada registro en resultado 
        Si oidComision <> resultado(i).oid 
        Si oidComision <> 0 
        Se añade el elemento iFila a rComisiones y se carga como sigue: 
        rComisiones(iFila).linea = resultado(i - 1).linea 
        rComisiones(iFila).oid = oidComision 
        rComisiones(iFila).codigo = resultado(i - 1).codigo 
        rComisiones(iFila).descripcion = resultado(i - 1).descripcion 
        rComisiones(iFila).marca = resultado(i - 1).marca 
        rComisiones(iFila).canal = resultado(i - 1).canal 
        rComisiones(iFila).acceso = sAcceso 
        rComisiones(iFila).tipoComision = resultado(i - 1).tipoComision 
        rComisiones(iFila).concepto = resultado(i - 1).concepto 
        rComisiones(iFila).version = resultado(i - 1).version 
        
        iFila += 1 
        Si iFila == dto.tamañoPagina (la paginación la tenemos que hacer a mano) 
        bSalir = True 
        Se sale del bucle 
        Fin del Si 
        Fin del Si 
        
        oidComision = resultado(i).oid 
        oidAcceso = resultado(i).oidAcceso 
        sAcceso = resultado(i).acceso 
        Fin del Si 
        
        Si oidAcceso <> resultado(i).oidAcceso 
        sAcceso += ", " + resultado(i).acceso 
        oidAcceso = resultado(i).oidAcceso 
        Fin del Si 
        Fin del Bucle 
        
        Si bSalir == False y resultado tiene registros (no se ha salido del bucle por el paginado) 
        Se añade el elemento iFila a rComisiones y se carga como sigue: 
        rComisiones(iFila).linea = resultado(último elemento).linea 
        rComisiones(iFila).oid = oidComision 
        rComisiones(iFila).codigo = resultado(último elemento).codigo 
        rComisiones(iFila).descripcion = resultado(último elemento).descripcion 
        rComisiones(iFila).marca = resultado(último elemento).marca 
        rComisiones(iFila).canal = resultado(último elemento).canal 
        rComisiones(iFila).acceso = sAcceso 
        rComisiones(iFila).tipoComision = resultado(último elemento).tipoComision 
        rComisiones(iFila).concepto = resultado(último elemento).concepto 
        rComisiones(iFila).version = resultado(último elemento).version 
        Fin del Si 
        
        Se carga un DTOSalida con el RecordSet rComisiones que tiene las columnas: 
        linea, 
        oid, 
        codigo, 
        descripcion, 
        marca, 
        canal, 
        acceso, 
        tipoComision, 
        concepto, 
        version    */
       
    public DTOSalida buscarMarcarModificar(DTOBuscarMarcarModificar dtoE) throws MareException {
        UtilidadesLog.info("DAOGestionComisiones.buscarMarcarModificar(DTOBuscarMarcarModificar dtoE): Entrada");
        RecordSet r = null;
        RecordSet rAccesos = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        StringBuffer sqlQuery = new StringBuffer("");
        
        sqlQuery.append(" SELECT * ");
        //sqlQuery.append(" FROM (SELECT ROWNUM AS OID, oidcomision, codigo, descripcion, marca, canal, ");
        sqlQuery.append(" FROM (SELECT ROWNUM as linea, oidcomision as OID, codigo, descripcion, marca, canal, ");
        sqlQuery.append(" acceso, tipocomision, concepto, VERSION, oidcanal ");
        sqlQuery.append(" FROM (SELECT   oidcomision, codigo, descripcion, marca, canal, ");
        sqlQuery.append(" acceso, tipocomision, concepto, VERSION, oidcanal ");
        sqlQuery.append(" FROM (SELECT DISTINCT a.oid_comi AS oidcomision, ");
        sqlQuery.append(" a.cod_comi AS codigo, ");
        sqlQuery.append(" b.val_i18n AS descripcion, ");
        sqlQuery.append(" d.des_marc AS marca, ");
        sqlQuery.append(" g.val_i18n AS canal, '' AS acceso, ");
        sqlQuery.append(" k.val_i18n AS tipocomision, ");
        sqlQuery.append(" a.val_conc AS concepto, ");
        sqlQuery.append(" a.num_vers AS VERSION, ");
        sqlQuery.append(" i.cana_oid_cana as oidcanal ");
        sqlQuery.append(" FROM com_comis a, ");
        sqlQuery.append(" v_gen_i18n_sicc b, ");
        sqlQuery.append(" com_plant_comis_marca c, ");
        sqlQuery.append(" seg_marca d, ");
        sqlQuery.append(" v_gen_i18n_sicc g, ");
        sqlQuery.append(" com_comis_acces h, ");
        sqlQuery.append(" com_plant_comis_acces i, ");
        sqlQuery.append(" v_gen_i18n_sicc k, ");
        sqlQuery.append(" cra_perio p ");
        
        // Usar para testear en Construccion. 
        //sqlQuery.append(" WHERE a.ceco_oid_esta_comi = 1");
        
        sqlQuery.append(" WHERE a.ceco_oid_esta_comi = " + ConstantesCOM.ESTADO_COMISION_ACTIVA );
        sqlQuery.append(" AND b.attr_enti(+) = 'COM_COMIS' ");
        sqlQuery.append(" AND b.attr_num_atri(+) = 1 ");
        sqlQuery.append(" AND b.idio_oid_idio(+) = " + dtoE.getOidIdioma() );
        sqlQuery.append(" AND b.val_oid(+) = a.oid_comi ");
        sqlQuery.append(" AND c.oid_plan_comi_marc = a.plcm_oid_plan_comi_marc ");
        sqlQuery.append(" AND d.oid_marc = c.marc_oid_marc ");
        sqlQuery.append(" AND a.perd_oid_peri = p.oid_peri ");
        sqlQuery.append(" AND g.attr_enti = 'SEG_CANAL' ");
        sqlQuery.append(" AND g.attr_num_atri = 1 ");
        sqlQuery.append(" AND g.idio_oid_idio = " + dtoE.getOidIdioma() );
        sqlQuery.append(" AND g.val_oid = p.cana_oid_cana ");
        sqlQuery.append(" AND h.comi_oid_comi = a.oid_comi ");
        sqlQuery.append(" AND i.oid_plan_comi_acce = h.plca_oid_plan_comi_acce ");
        sqlQuery.append(" AND k.attr_enti = 'COM_TIPO_PLANT' ");
        sqlQuery.append(" AND k.attr_num_atri = 1 ");
        sqlQuery.append(" AND k.idio_oid_idio = " + dtoE.getOidIdioma() );
        sqlQuery.append(" AND k.val_oid = a.tpla_oid_tipo_plan ");
        if (dtoE.getCodigo() != null)
            sqlQuery.append(" AND A.cod_comi = '" + dtoE.getCodigo() + "' ");
        
        if ( dtoE.getVersion() != null)
            sqlQuery.append(" AND a.num_vers = "+  dtoE.getVersion());
        
        if (dtoE.getOidCanal() != null)
            sqlQuery.append(" AND p.cana_oid_cana = " + dtoE.getOidCanal() );
        
        if (dtoE.getOidTipoComision() != null)
            sqlQuery.append(" AND A.TPLA_OID_TIPO_PLAN = " + dtoE.getOidTipoComision() );
        
        if (dtoE.getDescripcion() != null)
          sqlQuery.append(" AND B.val_i18n LIKE '" + dtoE.getDescripcion() + "' ");
        
        if (dtoE.getOidMarca() != null)
          sqlQuery.append(" AND C.marc_oid_marc = " + dtoE.getOidMarca() );
        
        if (dtoE.getOidAcceso() != null)
          sqlQuery.append(" AND I.acce_oid_acce = " + dtoE.getOidAcceso() );
        
        
        //sqlQuery.append(" AND a.tpla_oid_tipo_plan = 
        sqlQuery.append(" ORDER BY a.oid_comi) w, ");
        sqlQuery.append(" com_comis x ");
        sqlQuery.append(" WHERE w.oidcomision = x.oid_comi ");
        
        sqlQuery.append(" ORDER BY x.fec_ulti_esta DESC, oidcomision)) ");
        //sqlQuery.append(" WHERE ROWNUM <= " + dtoE.getTamanioPagina() );
        //sqlQuery.append(" AND OID > " + dtoE.getIndicadorSituacion() );
 
        
/*        sqlQuery.append(" SELECT OID, OIDComis, codigo, descripcion, marca, canal, acceso, tipocomision, ");
        sqlQuery.append(" concepto, VERSION ");
        
SELECT   oidcomision, codigo, descripcion, marca, canal,
                         acceso, tipocomision, concepto, VERSION
                    FROM        
        sqlQuery.append(" FROM (SELECT ROWNUM AS OID, OIDComis, codigo, descripcion, marca, canal, acceso, tipocomision, ");
        sqlQuery.append(" concepto, VERSION ");
        sqlQuery.append(" FROM (SELECT DISTINCT a.oid_comi AS OIDComis, a.cod_comi AS codigo, ");
        sqlQuery.append(" b.val_i18n AS descripcion, ");
        sqlQuery.append(" d.des_marc AS marca, g.val_i18n AS canal, ");
        sqlQuery.append(" '' AS acceso, k.val_i18n AS tipocomision, ");
        sqlQuery.append(" a.val_conc AS concepto, ");
        sqlQuery.append(" a.num_vers AS VERSION ");
        sqlQuery.append(" FROM com_comis a, ");
        sqlQuery.append(" v_gen_i18n_sicc b, ");
        sqlQuery.append(" com_plant_comis_marca c, ");
        sqlQuery.append(" seg_marca d, ");
        sqlQuery.append(" v_gen_i18n_sicc g, ");
        sqlQuery.append(" com_comis_acces h, ");
        sqlQuery.append(" com_plant_comis_acces i, ");
        sqlQuery.append(" v_gen_i18n_sicc k, ");
        sqlQuery.append(" cra_perio p ");
        //sqlQuery.append(" WHERE a.ceco_oid_esta_comi = " + ConstantesCOM.ESTADO_COMISION_ACTIVA );
        sqlQuery.append(" WHERE a.ceco_oid_esta_comi = 1 ");        
        sqlQuery.append(" AND b.attr_enti(+) = 'COM_COMIS' ");
        sqlQuery.append(" AND b.attr_num_atri(+) = 1 ");
        sqlQuery.append(" AND b.idio_oid_idio(+) = " + dtoE.getOidIdioma() );
        sqlQuery.append(" AND b.val_oid(+) = a.oid_comi ");
        sqlQuery.append(" AND c.oid_plan_comi_marc = a.plcm_oid_plan_comi_marc ");
        sqlQuery.append(" AND d.oid_marc = c.marc_oid_marc ");
        sqlQuery.append(" AND a.perd_oid_peri = p.oid_peri ");
        sqlQuery.append(" AND g.attr_enti = 'SEG_CANAL' ");
        sqlQuery.append(" AND g.attr_num_atri = 1 ");
        sqlQuery.append(" AND g.idio_oid_idio = " + dtoE.getOidIdioma() );
        sqlQuery.append(" AND g.val_oid = p.cana_oid_cana ");
        sqlQuery.append(" AND h.comi_oid_comi = a.oid_comi ");
        sqlQuery.append(" AND i.oid_plan_comi_acce = h.plca_oid_plan_comi_acce ");
        sqlQuery.append(" AND k.attr_enti = 'COM_TIPO_PLANT' ");
        sqlQuery.append(" AND k.attr_num_atri = 1 "); 
        sqlQuery.append(" AND k.idio_oid_idio = " + dtoE.getOidIdioma() );
        sqlQuery.append(" AND k.val_oid = a.tpla_oid_tipo_plan ");

        if (dtoE.getCodigo() != null)
          sqlQuery.append(" AND A.cod_comi = '" + dtoE.getCodigo() + "' ");
          
        if ( dtoE.getVersion() != null)
          sqlQuery.append(" a.num_vers = "+  dtoE.getVersion());
          
        if (dtoE.getOidCanal() != null)
          sqlQuery.append(" AND p.cana_oid_cana = " + dtoE.getOidCanal() );
          
        if (dtoE.getOidTipoComision() != null)
          sqlQuery.append(" AND A.TPLA_OID_TIPO_PLAN = " + dtoE.getOidTipoComision() );
          
        if (dtoE.getDescripcion() != null)
          sqlQuery.append(" AND B.val_i18n LIKE '" + dtoE.getDescripcion() + "' ");
          
        if (dtoE.getOidMarca() != null)
          sqlQuery.append(" AND C.marc_oid_marc = " + dtoE.getOidMarca() );
    
        if (dtoE.getOidAcceso() != null)
          sqlQuery.append(" AND I.acce_oid_acce = " + dtoE.getOidAcceso() );
          
        sqlQuery.append(" ORDER BY a.oid_comi ) w, ");
        sqlQuery.append(" com_comis x ");
        sqlQuery.append(" WHERE w.OIDComis = x.oid_comi ");
          
        sqlQuery.append(" ORDER BY x.fec_ulti_esta DESC, OIDComis) ");
        */
        try 
        {
          String queryPaginada = this.armarQueryPaginandoNoPorOid(sqlQuery.toString(), dtoE);
          r = bs.dbService.executeStaticQuery(queryPaginada);
        } catch (Exception ex)
        {  
           UtilidadesLog.error(ex);
           String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }
        
        UtilidadesLog.debug("Recordset Preliminar: " + r);
        
        // Verifica que el Rs no sea vacio.
        if (r.esVacio())
        {
           // Tira la exception de "no se encontraron registros bla bla bla"
           String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
           throw new MareException("No hay registros", UtilidadesError.armarCodigoError(sCodigoError));
        }
        
        // Quito la primer Columna del RecordSet, es la del ROWNUM
        // r.removeColumn(0);
        //RecordSet rBuffer = r;
        //rBuffer.removeColumn(0);
        
        Long[] oids = this.obtieneOids(r, new Long(1));
        
        //rBuffer = null;
        /* private RecordSet obtieneDescAccesoPorOidMarcarModificar(Long[] oid, 
                                                             Long oidIdioma,
                                                             String codigo,
                                                             Integer version,
                                                             Long canal,
                                                             Long tipoComision,
                                                             String descripcion,
                                                             Long oidMarca,
                                                             Long oidAcceso)*/
        rAccesos = this.obtieneDescAccesoPorOidMarcarModificar( oids,
                                                                dtoE.getOidIdioma(),
                                                                dtoE.getCodigo(),
                                                                dtoE.getVersion(),
                                                                dtoE.getOidCanal(),
                                                                dtoE.getOidTipoComision(), 
                                                                dtoE.getDescripcion(),
                                                                dtoE.getOidMarca(),
                                                                dtoE.getOidAcceso()
                                                              );
                                                              
        
        r = this.armaRSetFinalMarcarModificar(r, rAccesos);
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(r);
        UtilidadesLog.info("DAOGestionComisiones.buscarMarcarModificar(DTOBuscarMarcarModificar dtoE): Salida");
        return dtoSalida;
    }  
    
  /**
   * @Author: ssantana, 1/4/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet
   * @param  oidAcceso
   * @param  oidMarca
   * @param  descripcion
   * @param  tipoComision
   * @param  canal
   * @param  version
   * @param  codigo
   * @param  oidIdioma
   * @param  oid
   */
    private RecordSet obtieneDescAccesoPorOidMarcarModificar(Long[] oid, 
                                                             Long oidIdioma,
                                                             String codigo,
                                                             Integer version,
                                                             Long canal,
                                                             Long tipoComision,
                                                             String descripcion,
                                                             Long oidMarca,
                                                             Long oidAcceso) throws MareException
    {
       BelcorpService bs = BelcorpService.getInstance();
       RecordSet r = null;
       UtilidadesLog.info("DAOGestionComisiones.obtieneDescAccesoPorOidMarcarModificar(Long[] oid, Long oidIdioma, String codigo, Integer version, Long canal, Long tipoComision, String descripcion, Long oidMarca, Long oidAcceso): Entrada");
       
       StringBuffer query = new StringBuffer("");
       query.append(" SELECT   a.oid_comi, j.val_i18n ");
       query.append(" FROM com_comis a, ");
       query.append(" v_gen_i18n_sicc b, ");
       query.append(" com_comis_acces h, ");
       query.append(" com_plant_comis_acces i, ");
       query.append(" com_plant_comis_marca c, ");
       query.append(" cra_perio p, ");
       query.append(" v_gen_i18n_sicc j ");
       query.append(" WHERE a.ceco_oid_esta_comi = " + ConstantesCOM.ESTADO_COMISION_ACTIVA );
       //query.append(" WHERE a.ceco_oid_esta_comi = 1" );       
       query.append(" AND a.oid_comi " + this.generaINClause(oid) );
       query.append(" AND a.perd_oid_peri = p.oid_peri ");
       query.append(" AND a.plcm_oid_plan_comi_marc = c.oid_plan_comi_marc "); 
       query.append(" AND a.oid_comi = h.comi_oid_comi ");
       query.append(" AND h.plca_oid_plan_comi_acce = i.oid_plan_comi_acce ");
       query.append(" AND i.acce_oid_acce = j.val_oid ");
       query.append(" AND j.attr_enti = 'SEG_ACCES' ");
       query.append(" AND j.attr_num_atri = 1 ");
       query.append(" AND j.idio_oid_idio = " + oidIdioma);
       query.append(" AND b.attr_enti(+) = 'COM_COMIS' ");
       query.append(" AND b.attr_num_atri(+) = 1 ");
       query.append(" AND b.idio_oid_idio(+) = " + oidIdioma);
       query.append(" AND b.val_oid(+) = a.oid_comi ");
       
       if (codigo != null)
         query.append(" AND A.cod_comi = '" + codigo + "' ");
          
       if ( version != null)
         query.append(" AND a.num_vers = " +  version);
          
       if (canal != null)
         query.append(" AND p.cana_oid_cana = " + canal );
          
       if (tipoComision != null)
         query.append(" AND A.TPLA_OID_TIPO_PLAN = " + tipoComision );
          
       if (descripcion != null)
         query.append(" AND B.val_i18n LIKE '" + descripcion + "' ");
          
       if (oidMarca != null)
         query.append(" AND C.marc_oid_marc = " + oidMarca );
    
       if (oidAcceso != null)
         query.append(" AND I.acce_oid_acce = " + oidAcceso );
       
       query.append(" ORDER BY a.fec_ulti_esta DESC, 2 ");
       
       try 
       {
           r = bs.dbService.executeStaticQuery( query.toString() );
       } catch (Exception ex)
       {  
           UtilidadesLog.error(ex);
           String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
       }
       
        // Verifica que el Rs no sea vacio.
        if (r.esVacio())
        {
           // Tira la exception de "no se encontraron registros bla bla bla"
           String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
           throw new MareException("No hay registros", UtilidadesError.armarCodigoError(sCodigoError));
        }
    
        UtilidadesLog.debug("R Antes de concatenar: " + r.toString());
        r = this.concatenaCampos(r);
        UtilidadesLog.debug("R Despues de concatenar: " + r.toString());
        UtilidadesLog.info("DAOGestionComisiones.obtieneDescAccesoPorOidMarcarModificar(Long[] oid, Long oidIdioma, String codigo, Integer version, Long canal, Long tipoComision, String descripcion, Long oidMarca, Long oidAcceso): Salida");
        return r;
    }
    
    
  /**
   * @Author: ssantana, 23/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param  dto
   */
    public DTOSalida buscarModificar(DTOBuscarModificar dto) throws MareException {        
        UtilidadesLog.info("DAOGestionComisiones.buscarModificar(DTOBuscarModificar dto): Entrada");
        BelcorpService bs = BelcorpService.getInstance();
        DTOSalida dtoSalida = null;
        RecordSet r = null;
       
        StringBuffer sqlQuery = new StringBuffer("");
        
       /* sqlQuery.append(" SELECT OID, codigo, descripcion, marca, canal, ");
        sqlQuery.append(" acceso, tipocomision, concepto, VERSION, oidestado ");
        sqlQuery.append(" FROM ( ");
       
        sqlQuery.append(" SELECT   distinct a.oid_comi AS OID, a.cod_comi AS codigo, b.val_i18n AS descripcion, ");
        sqlQuery.append(" d.des_marc AS marca, g.val_i18n AS canal, ");
        sqlQuery.append(" '' AS acceso, ");
        sqlQuery.append(" k.val_i18n AS tipocomision, a.val_conc AS concepto, ");
        sqlQuery.append(" a.num_vers AS VERSION, a.ceco_oid_esta_comi AS oidestado ");
        sqlQuery.append(" FROM com_comis a, ");
        sqlQuery.append(" v_gen_i18n_sicc b, ");
        sqlQuery.append(" com_plant_comis_marca c, ");
        sqlQuery.append(" seg_marca d, ");
        sqlQuery.append(" v_gen_i18n_sicc g, ");
        sqlQuery.append(" com_comis_acces h, ");
        sqlQuery.append(" com_plant_comis_acces i, ");
        sqlQuery.append(" v_gen_i18n_sicc j, ");
        sqlQuery.append(" v_gen_i18n_sicc k, ");
        sqlQuery.append(" cra_perio m ");
        sqlQuery.append(" WHERE b.attr_enti(+) = 'COM_COMIS' ");
        sqlQuery.append(" AND b.attr_num_atri(+) = 1 ");
        sqlQuery.append(" AND b.idio_oid_idio(+) = " + dto.getOidIdioma() );
        sqlQuery.append(" AND b.val_oid(+) = a.oid_comi ");
        sqlQuery.append(" AND c.oid_plan_comi_marc = a.plcm_oid_plan_comi_marc ");
        sqlQuery.append(" AND d.oid_marc = c.marc_oid_marc ");
        sqlQuery.append(" AND g.attr_enti = 'SEG_CANAL' ");
        sqlQuery.append(" AND g.attr_num_atri = 1 ");
        sqlQuery.append(" AND g.idio_oid_idio = " + dto.getOidIdioma() );
        sqlQuery.append(" AND a.perd_oid_peri = m.oid_peri ");
        sqlQuery.append(" AND m.cana_oid_cana = g.val_oid ");
        sqlQuery.append(" AND h.comi_oid_comi = a.oid_comi ");
        sqlQuery.append(" AND i.oid_plan_comi_acce = h.plca_oid_plan_comi_acce ");
        sqlQuery.append(" AND j.attr_enti = 'SEG_ACCES' ");
        sqlQuery.append(" AND j.attr_num_atri = 1 ");
        sqlQuery.append(" AND j.idio_oid_idio = " + dto.getOidIdioma() );
        sqlQuery.append(" AND j.val_oid = i.acce_oid_acce ");
        sqlQuery.append(" AND k.attr_enti = 'COM_TIPO_PLANT' ");
        sqlQuery.append(" AND k.attr_num_atri = 1 ");
        sqlQuery.append(" AND k.idio_oid_idio = " + dto.getOidIdioma() );
        sqlQuery.append(" AND k.val_oid = a.tpla_oid_tipo_plan ");
     
        if ( dto.getCodigo() != null )
           sqlQuery.append(" AND A.cod_comi = '" + dto.getCodigo() + "' ");
         
        if (dto.getVersion() != null)
           sqlQuery.append(" AND A.num_vers = " + dto.getVersion() );
        
        if (dto.getOidCanal() != null)
           sqlQuery.append(" AND m.cana_oid_cana = " + dto.getOidCanal() );
        
        if (dto.getOidTipoComision() != null)
           sqlQuery.append(" AND A.TPLA_OID_TIPO_PLAN = " + dto.getOidTipoComision() );
        
        if (dto.getEstados() != null && dto.getEstados().size() == 0)
        {
           Long[] oids = this.obtieneOids(dto.getEstados());
           String sClausula = this.generaINClause(oids);
           sqlQuery.append(" AND A.CECO_OID_ESTA_COMI " + sClausula );
        }
     
        if ( dto.getDescripcion() != null )
          sqlQuery.append(" AND B.val_i18n LIKE '" + dto.getDescripcion() + "' ");
          
        if (dto.getOidMarca() != null)
          sqlQuery.append(" AND C.marc_oid_marc = " + dto.getOidMarca() );
      
        if (dto.getOidAcceso() != null)
          sqlQuery.append(" AND I.acce_oid_acce = " + dto.getOidAcceso() );
        
        sqlQuery.append(" ORDER BY a.oid_comi )");*/
        
        sqlQuery.append(" SELECT * ");
        sqlQuery.append(" FROM (SELECT ROWNUM AS linea, z.OID, z.codigo, z.descripcion, z.marca, ");
        sqlQuery.append(" z.canal, z.acceso, z.tipocomision, z.concepto, z.VERSION, ");
        sqlQuery.append(" z.oidestado, z.oidcanal ");
        sqlQuery.append(" FROM (SELECT   x.OID, x.codigo, x.descripcion, x.marca, x.canal, ");
        sqlQuery.append(" x.acceso, x.tipocomision, x.concepto, x.VERSION, ");
        sqlQuery.append(" x.oidestado, x.oidcanal ");
        sqlQuery.append(" FROM (SELECT DISTINCT a.oid_comi AS OID, ");
        sqlQuery.append(" a.cod_comi AS codigo, ");
        sqlQuery.append(" b.val_i18n AS descripcion, ");
        sqlQuery.append(" d.des_marc AS marca, ");
        sqlQuery.append(" g.val_i18n AS canal, '' AS acceso, ");
        sqlQuery.append(" k.val_i18n AS tipocomision, ");
        sqlQuery.append(" a.val_conc AS concepto, ");
        sqlQuery.append(" a.num_vers AS VERSION, ");
        sqlQuery.append(" a.ceco_oid_esta_comi AS oidestado, ");
        sqlQuery.append(" i.cana_oid_cana as oidcanal ");        
        sqlQuery.append(" FROM com_comis a, ");
        sqlQuery.append(" v_gen_i18n_sicc b, ");
        sqlQuery.append(" com_plant_comis_marca c, ");
        sqlQuery.append(" seg_marca d, ");
        sqlQuery.append(" v_gen_i18n_sicc g, ");
        sqlQuery.append(" com_comis_acces h, ");
        sqlQuery.append(" com_plant_comis_acces i, ");
        sqlQuery.append(" v_gen_i18n_sicc j, ");
        sqlQuery.append(" v_gen_i18n_sicc k, ");
        sqlQuery.append(" cra_perio m ");
        sqlQuery.append(" WHERE b.attr_enti(+) = 'COM_COMIS' ");
        sqlQuery.append(" AND b.attr_num_atri(+) = 1 ");
        sqlQuery.append(" AND b.idio_oid_idio(+) = " + dto.getOidIdioma() );
        sqlQuery.append(" AND b.val_oid(+) = a.oid_comi ");
        sqlQuery.append(" AND c.oid_plan_comi_marc = a.plcm_oid_plan_comi_marc ");
        sqlQuery.append(" AND d.oid_marc = c.marc_oid_marc ");
        sqlQuery.append(" AND g.attr_enti = 'SEG_CANAL' ");
        sqlQuery.append(" AND g.attr_num_atri = 1 ");
        sqlQuery.append(" AND g.idio_oid_idio = " + dto.getOidIdioma() );
        sqlQuery.append(" AND a.perd_oid_peri = m.oid_peri ");
        sqlQuery.append(" AND m.cana_oid_cana = g.val_oid ");
        sqlQuery.append(" AND h.comi_oid_comi = a.oid_comi ");
        sqlQuery.append(" AND i.oid_plan_comi_acce = h.plca_oid_plan_comi_acce ");
        sqlQuery.append(" AND j.attr_enti = 'SEG_ACCES' ");
        sqlQuery.append(" AND j.attr_num_atri = 1 ");
        sqlQuery.append(" AND j.idio_oid_idio = " + dto.getOidIdioma() );
        sqlQuery.append(" AND j.val_oid = i.acce_oid_acce ");
        sqlQuery.append(" AND k.attr_enti = 'COM_TIPO_PLANT' ");
        sqlQuery.append(" AND k.attr_num_atri = 1 "); 
        sqlQuery.append(" AND k.idio_oid_idio = " + dto.getOidIdioma() );
        sqlQuery.append(" AND k.val_oid = a.tpla_oid_tipo_plan ");
        if ( dto.getCodigo() != null )
            sqlQuery.append(" AND A.cod_comi = '" + dto.getCodigo() + "' ");
        
        if (dto.getVersion() != null)
            sqlQuery.append(" AND A.num_vers = " + dto.getVersion() );
        
        if (dto.getOidCanal() != null)
            sqlQuery.append(" AND m.cana_oid_cana = " + dto.getOidCanal() );
        
        if (dto.getOidTipoComision() != null)
            sqlQuery.append(" AND A.TPLA_OID_TIPO_PLAN = " + dto.getOidTipoComision() );
        
        if (dto.getEstados() != null && !dto.getEstados().equals(""))
        {
            //Long[] oids = this.obtieneOids(dto.getEstados());            
            //String sClausula = this.generaINClause(oids);
            //sqlQuery.append(" AND A.CECO_OID_ESTA_COMI " + sClausula );
            sqlQuery.append(" AND A.CECO_OID_ESTA_COMI IN (" + dto.getEstados() + ") ");
            //sqlQuery.append(" AND A.CECO_OID_ESTA_COMI = " + dto.getEstado());
        }
        
        if ( dto.getDescripcion() != null )
            sqlQuery.append(" AND B.val_i18n LIKE '" + dto.getDescripcion() + "' ");
        
        if (dto.getOidMarca() != null)
            sqlQuery.append(" AND C.marc_oid_marc = " + dto.getOidMarca() );
        
        if (dto.getOidAcceso() != null)
            sqlQuery.append(" AND I.acce_oid_acce = " + dto.getOidAcceso() );
        
        sqlQuery.append(" ) x, ");
        sqlQuery.append(" com_comis y ");
        sqlQuery.append(" WHERE x.OID = y.oid_comi ");
        sqlQuery.append(" ORDER BY y.fec_ulti_esta DESC, x.OID) z) ");
        //sqlQuery.append(" WHERE ROWNUM <= " + dto.getTamanioPagina() );       // Error al intentar paginar 2 veces
        //sqlQuery.append(" AND linea > " + dto.getIndicadorSituacion() );
        
        try 
        {
           String queryPaginada = this.armarQueryPaginandoNoPorOid(sqlQuery.toString(), dto);
           r = bs.dbService.executeStaticQuery(queryPaginada.toString());
        } catch (Exception ex)
        {  
           UtilidadesLog.error(ex);
           String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }
        
        UtilidadesLog.debug("Rs preliminar: " + r);
        
        // Verifica que el Rs no sea vacio.
        if (r.esVacio())
        {
           // Tira la exception de "no se encontraron registros bla bla bla"
           String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
           throw new MareException("No hay registros", UtilidadesError.armarCodigoError(sCodigoError));
        }
    
       /*private RecordSet obtieneDescAccesoPorOidBuscarModificar(Long[] oidComisiones,
                                                             Long oidIdioma, 
                                                             String descripcion,
                                                             Long oidCanal,
                                                             Long oidAcceso,
                                                             Long oidMarca,
                                                             String codigo,
                                                             Integer version,
                                                             Long oidTipoComision,
                                                             ArrayList estados )        */
        RecordSet rNuevo = this.obtieneDescAccesoPorOidBuscarModificar(this.obtieneOids(r, new Long(1)),
                                                    dto.getOidIdioma(),
                                                    dto.getDescripcion(),
                                                    dto.getOidCanal(),
                                                    dto.getOidAcceso(),
                                                    dto.getOidMarca(),
                                                    dto.getCodigo(),
                                                    dto.getVersion(),
                                                    dto.getOidTipoComision(),
                                                    dto.getEstados());
    
        r = this.armaRSetFinalBuscarModificar(r, rNuevo);
        
        dtoSalida = new DTOSalida();
        dtoSalida.setResultado(r);
        UtilidadesLog.info("DAOGestionComisiones.buscarModificar(DTOBuscarModificar dto): Salida");
        return dtoSalida; 
    }
    
    
  /**
   * @Author: ssantana, 23/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet r
   * @param 
   */
    private RecordSet armaRSetFinalBuscarModificar(RecordSet r, RecordSet rNuevo) throws MareException
    {
       
       UtilidadesLog.info("DAOGestionComisiones.armaRSetFinalAceptarModificar(RecordSet r, RecordSet rNuevo): Entrada");

       UtilidadesLog.debug("***** RecordSet entrada: " + r);
       UtilidadesLog.debug("***** RecordSet entrada: " + rNuevo);       
       
       for (int i = 0; i < r.getRowCount(); i++)
       {
          String descAcceso = (String) rNuevo.getValueAt(i,1);
          //Long oidAcceso = new Long( bigOidAcceso.longValue() );
          r.setValueAt(descAcceso, i,6);
       }
       
       UtilidadesLog.debug("***** RecordSet modificado: " + r);
       UtilidadesLog.info("DAOGestionComisiones.armaRSetFinalAceptarModificar(RecordSet r, RecordSet rNuevo): Salida");
       return r;
    }
    
  /**
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet
   * @param estados
   * @param oidTipoComision
   * @param  version
   * @param  codigo
   * @param  oidMarca
   * @param  oidAcceso
   * @param  oidCanal
   * @param  descripcion
   * @param  oidIdioma
   * @param  oidComisiones
   */
    private RecordSet obtieneDescAccesoPorOidBuscarModificar(Long[] oidComisiones,
                                                             Long oidIdioma, 
                                                             String descripcion,
                                                             Long oidCanal,
                                                             Long oidAcceso,
                                                             Long oidMarca,
                                                             String codigo,
                                                             Integer version,
                                                             Long oidTipoComision,
                                                             String estados ) throws MareException    
    {
    
      UtilidadesLog.info("DAOGestionComisiones.obtieneDescAccesoPorOidBuscarModificar(Long[] oidComisiones, Long oidIdioma, String descripcion, Long oidCanal, Long oidAcceso, Long oidMarca, String codigo, Integer version, Long oidTipoComision, String estados ): Entrada");
      BelcorpService bs = BelcorpService.getInstance();
      StringBuffer query = new StringBuffer("");
      RecordSet r = null;
      
      query.append(" SELECT   a.oid_comi, v.VAL_I18N ");
      query.append(" FROM com_comis a, ");
      query.append(" v_gen_i18n_sicc b, ");
      query.append(" com_plant_comis_marca c, ");
      query.append(" seg_marca d, ");
      query.append(" com_comis_acces h, ");
      query.append(" com_plant_comis_acces i, ");
      query.append(" cra_perio m, "); 
      query.append(" v_gen_i18n_sicc v ");
      query.append(" WHERE ");
      query.append(" b.attr_enti(+) = 'COM_COMIS' ");
      query.append(" AND b.attr_num_atri(+) = 1 ");
      query.append(" AND b.idio_oid_idio(+) = " + oidIdioma);
      query.append(" AND b.val_oid(+) = a.oid_comi ");
      query.append(" and c.oid_plan_comi_marc = a.plcm_oid_plan_comi_marc ");
      query.append(" AND d.oid_marc = c.marc_oid_marc ");
      query.append(" AND a.oid_comi " + this.generaINClause(oidComisiones) );
      query.append(" AND h.comi_oid_comi = a.oid_comi ");
      query.append(" AND i.oid_plan_comi_acce = h.plca_oid_plan_comi_acce ");
      query.append(" AND a.perd_oid_peri = m.oid_peri ");
      
      query.append(" and i.ACCE_OID_ACCE = v.VAL_OID ");
      query.append(" and v.ATTR_ENTI = 'SEG_ACCES' ");
      query.append(" and v.IDIO_OID_IDIO = " + oidIdioma);
      query.append(" and v.ATTR_NUM_ATRI = 1 ");
      
      if ( codigo != null && !codigo.equals("") )
        query.append(" AND A.cod_comi = '" + codigo + "' ");
        
      if ( version != null )
        query.append(" AND A.num_vers = " + version );
        
      if ( oidCanal != null )
        query.append(" AND m.cana_oid_cana = " + oidCanal);    
        
      if (oidTipoComision != null)
        query.append(" AND A.TPLA_OID_TIPO_PLAN = " + oidTipoComision );
        
      if ( estados != null && !estados.equals("") )
      {
        //Long[] oids = this.obtieneOids(estados);
        //String sClausula = this.generaINClause(oids);        
        //query.append(" AND A.CECO_OID_ESTA_COMI " + sClausula );
        //query.append(" AND A.CECO_OID_ESTA_COMI = " + estados );
        query.append(" AND A.CECO_OID_ESTA_COMI IN (" + estados + ")");
      }
     
      if ( descripcion != null )
        query.append(" AND B.val_i18n LIKE '" + descripcion + "' ");
          
      if (oidMarca != null)
        query.append(" AND C.marc_oid_marc = " + oidMarca );
      
      if (oidAcceso != null)
        query.append(" AND I.acce_oid_acce = " + oidAcceso );        
        
      query.append(" ORDER BY 1, 2  ");
      
      
      try
      {
        r = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex)
      {
        UtilidadesLog.error(ex);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      
      // Nota: Esta query se supone que es una extension de la query Principal en
      // obtenerTiposInsercionProducto(),
      // por lo que si no trae datos, entonces es lo mismo que la Principal no lo hiciera
      // y DEBE tirar EXCEPTION.
      if (r.esVacio())
      {
        String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
        throw new MareException("No hay datos", UtilidadesError.armarCodigoError(sCodigoError));
      }
      
      UtilidadesLog.debug("RecordSet accesos: " + r);
      r = this.concatenaCampos(r);
      UtilidadesLog.info("DAOGestionComisiones.obtieneDescAccesoPorOidBuscarModificar(Long[] oidComisiones, Long oidIdioma, String descripcion, Long oidCanal, Long oidAcceso, Long oidMarca, String codigo, Integer version, Long oidTipoComision, String estados ): Salida");
      return r;       
    }

    
    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return Integer
    * @documentation
        Obtiene la máxima versión de una comisión (bloqueando). 
        
        Proceso 
        ======== 
        Se ejecuta la query: 
        
        SELECT 
        nume_vers as version 
        FROM 
        com_comis 
        WHERE 
        oid_comi = (SELECT oid FROM 
        (SELECT oid_comi as oid 
        FROM com_comis 
        WHERE 
        cod_comi = (SELECT cod_comi 
        FROM com_comis 
        WHERE oid_comi = oidComision) 
        ORDER BY nume_vers DESC) 
        WHERE ROWNUM <= 1) 
        FOR UPDATE 
        
        Se retorna el valor obtenido.    
    */
    public Integer obtenerVersionMaxima(Long oidComision) throws MareException {
       UtilidadesLog.info("DAOGestionComisiones.obtenerVersionMaxima(Long oidComision): Entrada");
       Integer lngSalida=null;
       BelcorpService bs = BelcorpService.getInstance();
       RecordSet rs = null;
       
       StringBuffer sql = new StringBuffer("");
       sql.append(" SELECT ");
       sql.append(" num_vers as version ");
       
       sql.append(" FROM  ");
       sql.append(" com_comis  ");
       
       sql.append(" WHERE  ");
       sql.append(" oid_comi = (SELECT oid FROM ");
       sql.append(" (SELECT oid_comi as oid  ");
       sql.append(" FROM com_comis ");       
       sql.append(" WHERE ");
       sql.append(" cod_comi = (SELECT cod_comi ");
       sql.append(" FROM com_comis  ");
       sql.append(" WHERE oid_comi = " + oidComision + ") ");
       sql.append(" ORDER BY num_vers DESC) ");
       sql.append(" WHERE ROWNUM <= 1) ");
       sql.append(" FOR UPDATE ");
       
       UtilidadesLog.debug("1");
       try {
         UtilidadesLog.debug("2");       
         rs = bs.dbService.executeStaticQuery(sql.toString());
         UtilidadesLog.debug("2.5");
       } 
       catch (Exception ex) {
          UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
       }       
       UtilidadesLog.debug("RecordSet: " + rs);            
       if (!rs.esVacio()) {
			     lngSalida = new Integer(((BigDecimal)rs.getValueAt(0, 0)).intValue());
		   }

       UtilidadesLog.debug("*** lngSalida: " + lngSalida);       
       UtilidadesLog.debug("*** lngSalida: " + lngSalida);
       UtilidadesLog.info("DAOGestionComisiones.obtenerVersionMaxima(Long oidComision): Salida");
       return lngSalida;      
    }
    
    // ________________________________________________________________________________
    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param 
    * @return Long
    * @documentation
        Dado un Object, obtiene el String y genera un Long si no es null.
    */
    private Long objectToLong(Object obj) {
      UtilidadesLog.info("DAOGestionComisiones.objectToLong(Object obj): Entrada");      
      if(obj==null) {
        UtilidadesLog.info("DAOGestionComisiones.objectToLong(Object obj): Salida");          
        return null;  
      }     
      UtilidadesLog.info("DAOGestionComisiones.objectToLong(Object obj): Salida");          
      return new Long(obj.toString());
    }
    
    
  /**
   * @author: ssantana, 3/4/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet 
   * @param  oidComision
   */
    public RecordSet obtieneDatosPlantillaValidaCopiaComision(Long oidComision) throws MareException
    {
      UtilidadesLog.info("DAOGestionComisiones.obtieneDatosPlantillaValidaCopiaComision(Long oidComision): Entrada");
      RecordSet r = null;
      BelcorpService bs = BelcorpService.getInstance();

      
      StringBuffer sqlQuery = new StringBuffer("");
      
      sqlQuery.append(" SELECT c.cest_oid_esta AS oidestado, c.cana_oid_cana AS oidcanal, ");
      sqlQuery.append(" c.tpla_oid_tipo_plan AS oidtipocomision ");
      sqlQuery.append(" FROM com_comis a, com_plant_comis_pais b, com_plant_comis c ");
      sqlQuery.append(" WHERE a.oid_comi = " + oidComision);
      sqlQuery.append(" AND b.oid_plan_comi_pais = a.plcp_oid_plan_comi_pais ");
      sqlQuery.append(" AND c.oid_plan_comi = b.plco_oid_plan_comi ");
      
      
      try
      {
        r = bs.dbService.executeStaticQuery(sqlQuery.toString());
      } catch (Exception ex)
      {
        UtilidadesLog.error(ex);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      
      UtilidadesLog.debug("r: " + r);
      UtilidadesLog.info("DAOGestionComisiones.obtieneDatosPlantillaValidaCopiaComision(Long oidComision): Salida");
      return r;
      
    }
    
    
    public RecordSet obtieneDatosComisionValidaCopiaComision(Long oidComision) throws MareException
    {
      UtilidadesLog.info("DAOGestionComisiones.obtieneDatosComisionValidaCopiaComision(Long oidComision): Entrada");
      RecordSet r = null;
      BelcorpService bs = BelcorpService.getInstance();
      StringBuffer sqlQuery = new StringBuffer("");
      
      sqlQuery.append(" SELECT b.marc_oid_marc AS oidmarca, b.esta_oid_esta AS oidestadomarca, ");
      sqlQuery.append(" d.acces_oid_acce AS oidacceso, d.esta_oid_esta AS oidestadoacceso ");
      sqlQuery.append(" FROM com_comis a, ");
      sqlQuery.append(" com_plant_comis_marca b, ");
      sqlQuery.append(" com_comis_acces c, ");
      sqlQuery.append(" com_plant_comis_acces d ");
      sqlQuery.append(" WHERE a.oid_comi = " + oidComision );
      sqlQuery.append(" AND b.oid_plan_comi_marc = a.PLCM_OID_PLAN_COMI_MARC ");
      sqlQuery.append(" AND c.comi_oid_comi = a.oid_comi ");
      sqlQuery.append(" AND d.oid_plan_comi_acce = c.PLCA_OID_PLAN_COMI_ACCE ");
      
      try 
      {
        r = bs.dbService.executeStaticQuery(sqlQuery.toString());
      } catch (Exception ex)
      {
        UtilidadesLog.error(ex);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      
      UtilidadesLog.debug("r: " + r);
      UtilidadesLog.info("DAOGestionComisiones.obtieneDatosComisionValidaCopiaComision(Long oidComision): Salida");
      return r;
      
    }
    
    /**
     * @author Gustavo Viñales
     * @param codigo El año requerido
     * @return el máximo código de una comisión para un año determinado
     *
     * Obtiene el máximo código de una comisión para un año determinado (bloqueando).
     * El parámetro de entrada "codigo" tiene el formato 'AA/' donde AA es el año del sistema.
     * Se retorna el valor obtenido. Si la query no obtiene ningún registro se retorna null.
     */
    public String obtenerCodigoMaximo(String codigo) throws MareException {
        UtilidadesLog.info("DAOGestionComisiones.obtenerCodigoMaximo(String codigo): Entrada");
        BelcorpService bs     = BelcorpService.getInstance();
        RecordSet      rs     = null;
        String         maxCod = null;
        StringBuffer   query  = new StringBuffer("");

        query.append("SELECT ");
        query.append("cod_comi as codComision ");
        query.append("FROM ");
        query.append("com_comis ");
        query.append("WHERE ");
        query.append("oid_comi = (SELECT oid FROM ");
        query.append("(SELECT oid_comi as oid ");
        query.append("FROM com_comis ");
        query.append("WHERE ");
        query.append("cod_comi LIKE '" + codigo + "%' ");
        query.append("ORDER BY cod_comi DESC, num_vers) ");
        query.append("WHERE ROWNUM <= 1) ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            String sCodigoError =
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(
                e, UtilidadesError.armarCodigoError(sCodigoError));
        }
        if(!rs.esVacio()) {
            maxCod = (String) rs.getValueAt(0,0);
        }
        UtilidadesLog.info("DAOGestionComisiones.obtenerCodigoMaximo(String codigo): Salida");
        return maxCod;
    }
    
    public DTOSalida obtenerTiposPlantilla() throws MareException {
      UtilidadesLog.info("DAOGestionComisiones.obtenerTiposPlantilla(): Entrada");
    
      //-> Hacer consulta JDBC sobre la tabla COM_TIPO_PLANT
      //-> Obtener los campos OID_TIPO_PLAN y la descripción internacionalizada
      //-> Devolver RecordSet obtenido encapsulado en un DTOSalida
      
      BelcorpService bs     = BelcorpService.getInstance();
      RecordSet      rs     = null;
      StringBuffer query = new StringBuffer();
      
      query.append("SELECT COM.OID_TIPO_PLAN, GEN.VAL_I18N ");
      query.append("FROM COM_TIPO_PLANT COM, GEN_I18N_SICC_COMUN GEN ");
      query.append("WHERE GEN.ATTR_ENTI = 'COM_TIPO_PLANT' AND ");
      query.append("COM.OID_TIPO_PLAN = GEN.VAL_OID");
      
      try {
        rs = bs.dbService.executeStaticQuery(query.toString());
      } catch(Exception e) {
        UtilidadesLog.error(e);
        String sCodigoError =
          CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(
          e, UtilidadesError.armarCodigoError(sCodigoError));
      }

       if (rs.esVacio()){
         // Tira la exception de "no se encontraron registros bla bla bla"
         String sCodigoError = 
          CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException("No hay registros", 
          UtilidadesError.armarCodigoError(sCodigoError));
       }

        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("DAOGestionComisiones.obtenerTiposPlantilla(): Salida");
        return dtos;
    }
    
    public DTOSalida obtenerPeriodosMayores(DTOPeriodo dto) throws MareException {
      UtilidadesLog.info("DAOGestionComisiones.obtenerPeriodosMayores(DTOPeriodo dto): Entrada");
      BelcorpService bs = BelcorpService.getInstance();
      RecordSet rs = null;
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT periodo.oid_peri, periodo.val_nomb_peri ");
      query.append(" FROM cra_perio periodo, cra_perio dtoperi ");
      query.append(" WHERE periodo.pais_oid_pais = " + dto.getOidPais());
      query.append(" AND periodo.cana_oid_cana = " + dto.getCanal());
      query.append(" AND periodo.marc_oid_marc = " + dto.getMarca());
      query.append(" AND dtoperi.pais_oid_pais = " + dto.getOidPais());
      query.append(" AND dtoperi.cana_oid_cana = " + dto.getCanal());
      query.append(" AND dtoperi.marc_oid_marc = " + dto.getMarca());
      query.append(" AND dtoperi.oid_peri = " + dto.getOid());
      //query.append(" AND to_date(periodo.fec_inic, 'dd/MM/yyyy') >= to_date(dtoperi.fec_inic, 'dd/MM/yyyy') ");
      query.append(" AND periodo.fec_inic >= dtoperi.fec_inic ");
      query.append(" order by periodo.fec_inic ");
      
      try {
        rs = bs.dbService.executeStaticQuery(query.toString());
      }
      catch(Exception e) {
        UtilidadesLog.error(e);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(sCodigoError));
      }

      UtilidadesLog.debug("************ rs " + rs);
      DTOSalida dtos = new DTOSalida();
      dtos.setResultado(rs);
      UtilidadesLog.info("DAOGestionComisiones.obtenerPeriodosMayores(DTOPeriodo dto): Salida");
      return dtos;              
    }    
    
    /**
     * Arma la query paginada en base a una consulta que viene ordenada por un
     * criterio distinto al OID, por ejemplo una fecha. La consulta que recibe
     * este metodo posee como primera columna el ROWNUM original cuyo alias es
     * 'linea' y a los efectos del paginado actuara como si fuese el OID.
     */
    private String armarQueryPaginandoNoPorOid(String consultaOri, DTOSiccPaginacion dto) {
        Long ultLineaPresentada = dto.getIndicadorSituacion();
        Integer cantidadLineas = dto.getTamanioPagina();
        
        if ((ultLineaPresentada == null) || (cantidadLineas == null)) {
            return consultaOri;
        } else {            
            StringBuffer salida = new StringBuffer();
            
            salida.append("SELECT auxi2.* FROM ( SELECT auxi.*, ");
            salida.append("CASE WHEN (("+ cantidadLineas + " - COUNT(*) OVER (PARTITION BY 1)) < 0) THEN 0 ELSE 1 END SICC_ES_ULTIMA_PAGINA ");
            salida.append("FROM (" + consultaOri + ") auxi WHERE ROWNUM <= " +(cantidadLineas.intValue()+1)+ " AND linea > " +ultLineaPresentada+ ") auxi2 ");
            salida.append(" WHERE ROWNUM <= " + cantidadLineas);
            salida.append(" and linea > " + ultLineaPresentada);

            return salida.toString();
        }
    }
}