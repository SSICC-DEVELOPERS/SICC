/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DAOCalcularComisiones
 * Fecha:             07/04/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-202-334-N034
 * Descripcion:       DAOCalcular
 * @version           1.0
 * @autor             pcabrera
 */

package es.indra.sicc.logicanegocio.com;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

public class DAOCalcularVolumenFacturas {
  
  public DAOCalcularVolumenFacturas() { }  
  
  /**
   *@Author: Pcabrera, 06/04/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return DTOSalida
   *@param  oidComision
   *@param  
   *@param  oidPais
   */
  
   public DTOSalida tramosRecuperacion(Long oidComision, Long oidPais) 
    throws MareException { 
         /*
          * ->Crear un DTOSalida "dtoSalida" 
              ->Realizar una consulta JDBC en la entidad ComisionesCobranza, 
              ComisionesCobranzaTipoParticipante y TipoParticipante filtrado por
              pais, oidComision y version, en donde tipoParticipante.codigo = 'C', 
              recuperando: pais, oidPlantilla, oidComision, versionComision, 
              oidTipoParticipante, numeroDiasTrasFacturacion, nivelTramo, 
              porcRecuperacion, porcComision, numeroDiasParaComision 
              ->Encapsular el recordset en el dtoSalida 
              ->Retornar el dtoSalida        * 
          * 
          */
        UtilidadesLog.info("DAOCalcularVolumenFacturas.tramosRecuperacion(Long oidComision, Long oidPais): Entrada");
          
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        DTOSalida dtos = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();        
      
       query.append(" SELECT  cra.PAIS_OID_PAIS, ");
       query.append(" com.plco_oid_plan_comi, ");
       query.append(" com.oid_comi, ");
       query.append(" com.num_vers vers, ");
       query.append(" parti.OID_TIPO_PART, ");
       query.append(" cob.num_dias_tras_fact, ");
       query.append(" tipo.val_nive_tram, ");
       query.append(" tipo.val_porc_recu, ");
       query.append(" tipo.val_porc_comi, ");
       query.append(" tipo.num_dias_comi ");
       query.append(" FROM com_comis com, ");
       query.append(" com_comis_cobra cob, ");
       query.append(" com_comis_cobra_tipo_parti tipo, ");
       query.append(" cra_perio cra, ");
       query.append(" com_tipo_parti parti");
       query.append(" WHERE com.oid_comi = " + oidComision );    
       query.append(" AND cob.TPAR_OID_TIPO_PART = " + ConstantesCOM.TIPO_PARTICIPANTE_CAPITAL);
       query.append(" AND com.OID_COMI = cob.COMI_OID_COMI ");
       query.append(" AND cob.OID_COMI_COBR = tipo.COCO_OID_COMI_COBR ");
       query.append(" AND cob.TPAR_OID_TIPO_PART = parti.OID_TIPO_PART ");
       query.append(" AND com.PERD_OID_PERI = cra.OID_PERI ");      
        
        try {
           rs =  bs.dbService.executeStaticQuery(query.toString());
        }catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
                      
        dtos.setResultado(rs);   
        UtilidadesLog.info("DAOCalcularVolumenFacturas.tramosRecuperacion(Long oidComision, Long oidPais): Salida"); 
        return dtos;
    }  
}