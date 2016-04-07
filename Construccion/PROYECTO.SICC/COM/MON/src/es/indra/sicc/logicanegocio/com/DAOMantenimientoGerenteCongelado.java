
/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DAOMantenimientoGerenteCongelado
 * Fecha:             28-12-2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes DMCO-SICC-COM-H34
 * Descripcion:       DAOMantenimiento
 * @version           1.0
 * @autor             lcordoba
 */
package es.indra.sicc.logicanegocio.com;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.com.DTODatosGerenteCongelacion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.util.Date;
import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;


public class DAOMantenimientoGerenteCongelado {
  public DAOMantenimientoGerenteCongelado(){
  }

    /**    
    *@Author: lcordoba
    *@Fecha: 29-12-2005
    *@throws: es.indra.mare.common.exception.MareException
    *@return: Boolean
    *@param: DTODatosGerenteCongelacion
    */ 
    public Boolean verificarCongelacion (DTODatosGerenteCongelacion dto)throws MareException { 
        UtilidadesLog.info("***DAOMantenimientoGerenteCongelado.verificarCongelacion - Entrada");
        /*
        * -> Boolean rta = false 
        -> Realizar una consulta JDBC en la entidad congelados (COM_CONGE) en donde: 
        oidCliente = dto.get(oidCliente) 
        AND 
        fechaDesde <= dto.get(fechaDesde) < fechaHasta 
        -> Si la consulta retornó datos 
        rta = true 
        fin si 
        -> retornar rta 
        **/
        
        
        Boolean rta= null;
        rta = Boolean.FALSE;
        StringBuffer consulta = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDesde= sdf.format(dto.getFechaDesde());        
        
        consulta.append(" SELECT oid_cong  ");
        consulta.append("   FROM com_conge  ");
        consulta.append("  WHERE clie_oid_clie = " + dto.getOidCliente());
        consulta.append("    AND fec_desd <= TO_DATE ('" + fechaDesde + "', 'dd/MM/yyyy')  ");
        consulta.append("    AND fec_hast > TO_DATE ('" + fechaDesde + "', 'dd/MM/yyyy')  ");
                
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;        
        try{
            rs =bs.dbService.executeStaticQuery(consulta.toString());
        }catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if (rs != null && !rs.esVacio()) {
            rta = Boolean.TRUE;
        }
        UtilidadesLog.info("***DAOMantenimientoGerenteCongelado.verificarCongelacion - Salida");
        return rta;
    }


public DTOSalida buscarGerentesCongelados (DTODatosGerenteCongelacion dto)throws MareException { 
    UtilidadesLog.info("***DAOMantenimientoGerenteCongelado.buscarGerentesCongelados - Entrada");
        /*
        * -> Crear DTOSalida rta 

        -> Realizar una consulta JDBC en la entidad congelados (COM_CONGE )cruzando con clienteDatosBasicos (MAE_CLIEN) recuperando: 
        oid (Oculto), 
        codigoCliente (clienteDatosBasicos) 
        fechaDesde 
        fechaHasta 
        importe 
        indDescongAutomatic 
        oidCliente (oculto) 
        filtrando por los campos que no son nulos en el dto recibido como parámetro 
        Si dto.get(vigente) == true 
        AND fecha del sistema between congelado.fechaDesde AND congelado.fechaHasta 
        fin si 

        -> asignar recordset rta 
        -> retornar rta 

        **/
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        long dia=System.currentTimeMillis();
        Date diaHoy= new Date(dia);
        String sDiaHoy = sdf.format(diaHoy);
        String fechaDesde="";
        String fechaHasta="";
        if(dto.getFechaDesde()!= null && !dto.getFechaDesde().equals("")){
          fechaDesde= sdf.format(dto.getFechaDesde());
        }
        if(dto.getFechaHasta()!= null && !dto.getFechaHasta().equals("")){
          fechaHasta= sdf.format(dto.getFechaHasta());
        }
        
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT c.OID_CONG AS OID, cl.COD_CLIE, c.FEC_DESD,c.FEC_HAST, c.IMP_CONG, c.IND_DESC_AUTO, c.CLIE_OID_CLIE");
        consulta.append("   FROM COM_CONGE c, MAE_CLIEN cl");
        consulta.append("  WHERE c.CLIE_OID_CLIE = cl.OID_CLIE");
        if(dto.getOidCliente()!=null) {
            consulta.append("    AND c.CLIE_OID_CLIE = " + dto.getOidCliente() );
        }
        if(dto.getCodigoCliente()!=null) {
            consulta.append("    AND cl.COD_CLIE = "+ dto.getCodigoCliente());
        }     
        if (dto.getVigente()!= null && dto.getVigente().booleanValue()){
            // eiraola - Inc. BELC300022723 - Se incluyen los extremos (igualdad)
            consulta.append("    AND c.FEC_DESD <= TO_DATE ('" + sDiaHoy + "', 'dd/MM/yyyy')  ");
            consulta.append("    AND c.FEC_HAST >=  TO_DATE ('" + sDiaHoy + "', 'dd/MM/yyyy')  ");
        }
        if(fechaDesde!= null && !fechaDesde.equals("")){
            consulta.append("    AND c.FEC_DESD >= TO_DATE ('" + fechaDesde + "', 'dd/MM/yyyy')  ");            
        }
        if(fechaHasta!= null && !fechaHasta.equals("")){
            consulta.append("    AND c.FEC_HAST <= TO_DATE ('" + fechaHasta + "', 'dd/MM/yyyy')  ");      
        }        
        if(dto.getImporte()!= null){
            consulta.append("    AND c.IMP_CONG = "+ dto.getImporte());
        }
        if(dto.getDescongelacion()!=null && dto.getDescongelacion().booleanValue())
        {
            consulta.append("    AND c.IND_DESC_AUTO = 1"); 
        }
          
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        DTOSalida dtos = new DTOSalida();
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);
        try{
            UtilidadesLog.info("***DAOMantenimientoGerenteCongelado.buscarGerentesCongelados - Antes execute Query");          
            rs =bs.dbService.executeStaticQuery(sqlPaginada);
            if(rs != null){
               dtos.setResultado(rs);
            }
        
        }catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        
        if(rs.esVacio())
          throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                
        
        
        UtilidadesLog.info("***DAOMantenimientoGerenteCongelado.buscarGerentesCongelados - Salida");
        return dtos;
    }

}