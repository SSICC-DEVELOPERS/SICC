package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.*;
import es.indra.sicc.dtos.bel.DTOCaja;
import es.indra.sicc.dtos.bel.DTOMantenimientoCaja;

import java.text.SimpleDateFormat;

public class DAOCajas  {

  public DAOCajas() {  }

  /** 
   * Método para buscar Cajas
   * @param dto DTOOID con el subacceso por los que se filtrará la busqueda
   * @return DTOSalida el resultado de la busqueda
   * @exception MareException 
   */

   public DTOSalida abrirCajasConsulta (DTOOID dto) throws MareException {
     UtilidadesLog.info("DAOCajas().getLog():Entrada");
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
          bs = BelcorpService.getInstance();

          query.append(" SELECT OID_CAJA oid ,COD_CAJA, VAL_ESTA_CAJA ");
		      query.append(" FROM BEL_CAJA");
		      query.append(" WHERE SBAC_OID_SBAC  = " + dto.getOid());
          query.append(" AND PAIS_OID_PAIS = " + dto.getOidPais());
          query.append(" AND VAL_ESTA_CAJA = '" + ConstantesBEL.CAJA_CERRADA + "'");
          resultado = bs.dbService.executeStaticQuery(query.toString());    
     }
     catch(Exception e) {
          UtilidadesLog.debug(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     if (!resultado.esVacio()){
        dtoS.setResultado(resultado);
     }else{
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }        
     UtilidadesLog.info("DAOCajas().getLog():Salida");
     return dtoS;
   }


    /**
     * 23/11/2004
     * Obtiene oid de la caja principal
	 * 16/09/2005 - rgiorgi: se modifica la query por incidencia Peru (mdolce)
     * @param  Long Subacceso
     * @return Long 
     * @exception MareException 
     * @author mdolce
     */
   public Long obtenerCajaPrincipal(Long subacceso) throws MareException {
      UtilidadesLog.info("DAOCajas().obtenerCajaPrincipal(Long subacceso):Entrada");
      DTOSalida dtoSalida = new DTOSalida(); 
      String codigoError;
       Long resultado = null;

      StringBuffer query = new StringBuffer();
      RecordSet rs;
    
      query.append(" select a.OID_CAJA ");
      query.append(" from   bel_caja a, bel_tipo_caja b ");
      query.append(" where  a.TICJ_OID_TIPO_CAJA = b.OID_TIPO_CAJA" );
      query.append(" and    a.SBAC_OID_SBAC = " + subacceso);
      query.append(" and    b.COD_TIPO_CAJA =  '" + ConstantesBEL.TIPO_CAJA_PRINCIPAL + "'");

      UtilidadesLog.debug("********* query " + query);

      BelcorpService bs = UtilidadesEJB.getBelcorpService();

      try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }

       
        if (!rs.esVacio()) {
			     resultado = new Long(((BigDecimal)rs.getValueAt(0, 0)).longValue());
		    }
      UtilidadesLog.info("DAOCajas().obtenerCajaPrincipal(Long subacceso):Salida");
      return resultado;
   }


   /**
   * Autor: Cristian Valenzuela
   * Fecha: 09/11/2004
   * Descripcion: Obtiene los oids de la tabla BEL_CAJA filtrando por 
   * subacceso, pais y estado de la caja igual a C
   */
   public DTOSalida obtenerCajasCerradas (DTOOID dto) throws MareException {
      UtilidadesLog.info("DAOCajas().obtenerCajaPrincipal(Long subacceso):Entrada");
      DTOSalida dtoSalida = new DTOSalida(); 

      StringBuffer query = new StringBuffer();
      RecordSet rs;
    
      query.append(" SELECT OID_CAJA ");
      query.append(" FROM BEL_CAJA ");
      query.append(" WHERE SBAC_OID_SBAC = " + dto.getOid().toString());
      query.append(" AND PAIS_OID_PAIS = " + dto.getOidPais().toString());
      query.append(" AND VAL_ESTA_CAJA = '" + ConstantesBEL.CAJA_CERRADA + "'");

      UtilidadesLog.debug("********* query " + query);

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        UtilidadesLog.debug("************* Recordset "+ rs );
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      if (!rs.esVacio()){
        dtoSalida.setResultado(rs);
      }
      else{
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }        
      
      UtilidadesLog.info("DAOCajas().obtenerCajaPrincipal(Long subacceso):Salida");
      return dtoSalida;    
   } 


   /** 
   * Autor: Cristian Valenzuela
   * Fecha: 10/11/2004
   * Descripcion: Este metodo trae los oid de la cabecera de cierre de caja
   * filtrando por subacceso, pais, estado ('Descuadrada') y que la fecha de
   * cierre de caja sea igual a la fecha actual
   */
   public DTOSalida obtenerCierresDeCaja(DTOOID dto) throws MareException {
      UtilidadesLog.info("DAOCajas().obtenerCierresDeCaja(DTOOID dto):Entrada");
      DTOSalida dtoSalida = new DTOSalida(); 

      StringBuffer query = new StringBuffer();
      RecordSet rs;

      SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
      Date fecha = new Date();
      String sFecha = sdfFormato.format(fecha);

      UtilidadesLog.debug("********* sFecha " + sFecha);

      query.append(" SELECT a.OID_CABE ");
      query.append(" FROM BEL_CIERR_CAJA_CABEC a, BEL_MOVIM_CAJA_CABEC b, BEL_CAJA c ");
      query.append(" WHERE a.MCAC_OID_CABE = b.OID_CABE ");
      query.append(" AND b.CAJA_OID_CAJA = c.OID_CAJA ");
      query.append(" AND c.SBAC_OID_SBAC = " + dto.getOid().toString());
      query.append(" AND c.PAIS_OID_PAIS = " + dto.getOidPais().toString());
      query.append(" AND a.VAL_ESTA_CIER_CAJA = '" + ConstantesBEL.CAJA_DESCUADRADA + "'");
      query.append(" AND to_char(a.FEC_CIER_CAJA, 'dd/MM/yyyy') = '" + sFecha + "' ");

      UtilidadesLog.debug("********* query " + query);

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        UtilidadesLog.debug("************* Recordset "+ rs );
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      //if(!rs.esVacio()){
        dtoSalida.setResultado(rs);
      //}
      //else{
       // throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      //}        
      UtilidadesLog.info("DAOCajas().obtenerCierresDeCaja(DTOOID dto):Salida");
      return dtoSalida;    
   }


   /* 
   * Autor: Cristian Valenzuela
   * Fecha: 10/11/2004
   * Descripcion: Esta consulta se usa para llenar una de las listas
   * del caso de uso Cerrar Cajas Belcenter 
   */
   public DTOSalida obtenerCierresDeCajaDetalleDescuadrados(DTOOID dto) throws MareException {
      UtilidadesLog.info("DAOCajas().obtenerCierresDeCajaDetalleDescuadrados(DTOOID dto):Entrada");
      DTOSalida dtoSalida = new DTOSalida(); 

      StringBuffer query = new StringBuffer();
      RecordSet rs;

      SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
      Date fecha = new Date();
      String sFecha = sdfFormato.format(fecha);

      UtilidadesLog.debug("********* sFecha " + sFecha);

      query.append(" SELECT d.OID_CAJA, d.COD_CAJA, b.VAL_USUA, i1.VAL_I18N as MedioPago, i2.VAL_I18N as MonedaAlternativa, ");
      query.append(" (a.IMP_CIER - a.IMP_LOGI ) as Diferencia, (a.IMP_DIVI - a.IMP_LOGI_DIVI) as DiferenciaDivisa ");
      query.append(" FROM BEL_CIERR_CAJA_DETAL a, BEL_CIERR_CAJA_CABEC b, BEL_MOVIM_CAJA_CABEC c, BEL_CAJA d, ");
      query.append(" BEL_MEDIO_PAGO_BELCE e, BEL_MEDIO_PAGO f, SEG_MONED g, V_GEN_I18N_SICC i1, V_GEN_I18N_SICC i2 ");
      query.append(" WHERE a.CICC_OID_CABE = b.OID_CABE ");
      query.append(" AND b.MCAC_OID_CABE = c.OID_CABE ");
      query.append(" AND c.CAJA_OID_CAJA = d.OID_CAJA ");
      query.append(" AND a.MPBC_OID_MEDI_PAGO_BELC = e.OID_MEDI_PAGO_BELC ");
      query.append(" AND e.MPAB_OID_MEDI_PAGO = f.OID_MEDI_PAGO ");
      query.append(" AND a.MONE_OID_MONE = g.OID_MONE ");
      query.append(" AND d.SBAC_OID_SBAC = " + dto.getOid().toString());
      query.append(" AND d.PAIS_OID_PAIS = " + dto.getOidPais().toString());
      query.append(" AND b.VAL_ESTA_CIER_CAJA = '" + ConstantesBEL.CAJA_DESCUADRADA + "'");
      query.append(" AND to_char(b.FEC_CIER_CAJA, 'dd/MM/yyyy') = '" + sFecha + "'");
      query.append(" AND i1.ATTR_ENTI = 'BEL_MEDIO_PAGO' ");
      query.append(" AND i1.ATTR_NUM_ATRI = 1 ");
      query.append(" AND i1.IDIO_OID_IDIO = " + dto.getOidIdioma().toString());
      query.append(" AND f.OID_MEDI_PAGO = i1.VAL_OID");
      query.append(" AND i2.ATTR_ENTI = 'SEG_MONED' ");
      query.append(" AND i2.ATTR_NUM_ATRI = 1 ");
      query.append(" AND i2.IDIO_OID_IDIO = " + dto.getOidIdioma().toString());
      query.append(" AND g.OID_MONE = i2.VAL_OID ");
      query.append(" ORDER BY d.COD_CAJA, b.VAL_USUA ");

      UtilidadesLog.debug("********* query " + query);

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        UtilidadesLog.debug("************* Recordset "+ rs );
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      if(!rs.esVacio()){
        dtoSalida.setResultado(rs);
      }
      else{
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }        
      
      UtilidadesLog.info("DAOCajas().obtenerCierresDeCajaDetalleDescuadrados(DTOOID dto):Salida");
      return dtoSalida;    
   }


   /* 
   * Autor: Cristian Valenzuela
   * Fecha: 10/11/2004
   * Descripcion: Este consulta se usa para llenar una de las listas del
   * caso de uso Cerrar cajas Belcenter
   */
   public DTOSalida obtenerCierresDeCajaDetalleDescuadradosResumen(DTOOID dto) throws MareException {      
      UtilidadesLog.info("DAOCajas().obtenerCierresDeCajaDetalleDescuadradosResumen(DTOOID dto):Entrada");
      DTOSalida dtoSalida = new DTOSalida(); 

      StringBuffer query = new StringBuffer();
      RecordSet rs;

      SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
      Date fecha = new Date();
      String sFecha = sdfFormato.format(fecha);

      UtilidadesLog.debug("********* sFecha " + sFecha);

      query.append(" SELECT c.OID_CAJA, c.COD_CAJA as CodigoCaja, b.VAL_USUA as Usuario, i1.VAL_I18N as MedioPago, i2.VAL_I18N as MonedaAlternativa, ");
      query.append(" SUM(a.IMP_MOVI) as Importe, SUM(a.IMP_DIVI) as ImporteDivisa ");
      query.append(" FROM BEL_MOVIM_CAJA_DETAL a, BEL_MOVIM_CAJA_CABEC b, BEL_CAJA c, BEL_MEDIO_PAGO_BELCE d, BEL_MEDIO_PAGO e, ");
      query.append(" SEG_MONED f, BEL_CIERR_CAJA_CABEC g, BEL_CIERR_CAJA_DETAL h, V_GEN_I18N_SICC i1, V_GEN_I18N_SICC i2 ");
      query.append(" WHERE a.MCAC_OID_CABE = b.OID_CABE ");
      query.append(" AND b.CAJA_OID_CAJA = c.OID_CAJA ");
      query.append(" AND a.MPBC_OID_MEDI_PAGO_BELC = d.OID_MEDI_PAGO_BELC ");
      query.append(" AND d.MPAB_OID_MEDI_PAGO = e.OID_MEDI_PAGO ");
      query.append(" AND a.MONE_OID_MONE = f.OID_MONE ");
      query.append(" AND b.OID_CABE = g.MCAC_OID_CABE ");
      query.append(" AND c.SBAC_OID_SBAC = " + dto.getOid().toString());
      query.append(" AND c.PAIS_OID_PAIS = " + dto.getOidPais().toString());
      query.append(" AND g.VAL_ESTA_CIER_CAJA = '" + ConstantesBEL.CAJA_DESCUADRADA + "'");
      query.append(" AND to_char(b.FEC_MOVI, 'dd/MM/yyyy') = '" + sFecha + "'");
      //Pendiente incidencia 10243
      query.append(" AND ((h.IMP_CIER - h.IMP_LOGI) <> 0  OR (h.IMP_DIVI - h.IMP_LOGI_DIVI) <> 0) ");      
      query.append(" AND i1.ATTR_ENTI = 'BEL_MEDIO_PAGO' ");
      query.append(" AND i1.ATTR_NUM_ATRI = 1 ");
      query.append(" AND i1.IDIO_OID_IDIO = " + dto.getOidIdioma().toString());
      query.append(" AND e.OID_MEDI_PAGO = i1.VAL_OID ");
      query.append(" AND i2.ATTR_ENTI = 'SEG_MONED' ");
      query.append(" AND i2.ATTR_NUM_ATRI = 1 ");
      query.append(" AND i2.IDIO_OID_IDIO = " + dto.getOidIdioma().toString());
      query.append(" AND f.OID_MONE = i2.VAL_OID ");
      query.append(" GROUP BY c.OID_CAJA, c.COD_CAJA, b.VAL_USUA, i1.VAL_I18N, i2.VAL_I18N ");

      UtilidadesLog.debug("************* query " + query );

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        UtilidadesLog.debug("************* Recordset "+ rs );
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      if(!rs.esVacio()){
        dtoSalida.setResultado(rs);
      }
      else{
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }        
      UtilidadesLog.info("DAOCajas().obtenerCierresDeCajaDetalleDescuadradosResumen(DTOOID dto):Salida");
      return dtoSalida;    
   }


   /**
     * 22/11/2004
     * Obtiene el importe dle medio pago
     * @param Long medioPagoBelcenter, Long caja, Boolean divisa
     * @return BigDecimal
     * @exception MareException 
     * @author mdolcebel_caja a, bel_tipo_caja
     */
   public BigDecimal obtenerImporteLogicoMedioPago(Long medioPagoBelcenter, Long caja, Boolean divisa) throws MareException {

      UtilidadesLog.info("DAOCajas().obtenerImporteLogicoMedioPago(Long medioPagoBelcenter, Long caja, Boolean divisa):Entrada");

      StringBuffer query = new StringBuffer();
      RecordSet rs;
      String codigoError;

      SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
      Date fecha = new Date();
      String sFecha = sdfFormato.format(fecha);

      UtilidadesLog.debug("********* sFecha " + sFecha);

      if(divisa.booleanValue()){
         query.append(" select nvl(SUM(a.IMP_DIVI),0) as IMPORTEDIVISA ");   
      }else{
         query.append(" select nvl(SUM(a.IMP_MOVI),0)  as IMPORTEMOVIMIENTO "); 
      }
          
      query.append(" from   bel_movim_caja_detal a , bel_movim_caja_cabec b ");
      query.append(" where  a.MCAC_OID_CABE = b.OID_CABE ");
      query.append(" and    b.CAJA_OID_CAJA =  " + caja);
      query.append(" AND to_char(b.FEC_MOVI, 'dd/MM/yyyy') = '" + sFecha + "'"); 
      query.append(" and    a.MPBC_OID_MEDI_PAGO_BELC = " + medioPagoBelcenter);

      

      UtilidadesLog.debug("********* query " + query);

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }

     BigDecimal importeLogicoMedioPago;
     
     if(divisa.booleanValue()){
        UtilidadesLog.debug("entro por divisa");
        importeLogicoMedioPago = (BigDecimal)rs.getValueAt(0,"IMPORTEDIVISA");   
     }else{
        UtilidadesLog.debug("entro por movimiento");
        importeLogicoMedioPago = (BigDecimal)rs.getValueAt(0,"IMPORTEMOVIMIENTO"); 
        UtilidadesLog.debug("salio de movimiento");
     }
        
     UtilidadesLog.info("DAOCajas().obtenerImporteLogicoMedioPago(Long medioPagoBelcenter, Long caja, Boolean divisa):Salida");
     return importeLogicoMedioPago;    
   }


   /**
     * 22/11/2004
     * Obtiene el importe del vuelto
     * @param  Long caja
     * @return BigDecimal
     * @exception MareException 
     * @author mdolce
     */
   public BigDecimal obtenerSumaDevueltosMCC (Long caja) throws MareException {
      UtilidadesLog.info("DAOCajas().obtenerSumaDevueltosMCC (Long caja):Entrada");

      StringBuffer query = new StringBuffer();
      RecordSet rs;
      String codigoError;

      SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
      Date fecha = new Date();
      String sFecha = sdfFormato.format(fecha);

      UtilidadesLog.debug("********* sFecha " + sFecha);

      query.append(" select SUM (b.IMP_VUEL) AS importeVuelto "); 
      query.append(" from   bel_movim_caja_cabec b ");
      query.append(" where  b.CAJA_OID_CAJA = " + caja);
      query.append(" AND to_char(b.FEC_MOVI, 'dd/MM/yyyy') = '" + sFecha + "'"); 

      BelcorpService bs = UtilidadesEJB.getBelcorpService();

      try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        BigDecimal importeVuelto = (BigDecimal)rs.getValueAt(0,"IMPORTEVUELTO");   
        UtilidadesLog.info("DAOCajas().obtenerSumaDevueltosMCC (Long caja):Salida");
        return importeVuelto;
   }


   /**
     * 22/11/2004
     * Obtiene el oid del detalle de los movimientos de la caja
     * @param  Long caja
     * @return Recordset
     * @exception MareException 
     * @author mdolce
     */
   public RecordSet obtenerMovimientosDeCajaDetalle(Long caja) throws MareException {
      UtilidadesLog.info("DAOCajas().obtenerMovimientosDeCajaDetalle(Long caja):Entrada");

      StringBuffer query = new StringBuffer();
      RecordSet rs;
      String codigoError;

      SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
      Date fecha = new Date();
      String sFecha = sdfFormato.format(fecha);

      query.append(" select b.OID_DETA " );
      query.append(" from  bel_movim_caja_cabec a,bel_movim_caja_detal b ");  
      query.append(" where b.MCAC_OID_CABE = a.OID_CABE ");
      query.append(" and   a.CAJA_OID_CAJA = " + caja);
      query.append(" and   to_char(b.FEC_MOVI, 'dd/MM/yyyy') = '" + sFecha + "'"); 

      BelcorpService bs = UtilidadesEJB.getBelcorpService();

      try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCajas().obtenerMovimientosDeCajaDetalle(Long caja):Salida");
        return rs;
   }
   
     /** 
   * Método para llenar un combo de caja
   * @param dto DTOCaja con el pais y el subacceso
   * @return DTOSalida el resultado de la busqueda
   * @exception MareException
   * @author mdolce
   */
   
   public DTOSalida obtenerCajas(DTOCaja dtoin) throws MareException{
      UtilidadesLog.info("DAOCajas().obtenerCajas(DTOCaja dtoin):Entrada");
      DTOSalida dtoSalida = new DTOSalida(); 

      StringBuffer query = new StringBuffer();
      RecordSet rs;

      SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
      Date fecha = new Date();
      String sFecha = sdfFormato.format(fecha);

      UtilidadesLog.debug("********* sFecha " + sFecha);

      query.append(" SELECT c.SBAC_OID_SBAC, c.OID_CAJA, c.COD_CAJA ");
      query.append(" from  BEL_CAJA c ");
      query.append(" where c.PAIS_OID_PAIS = " + dtoin.getOidPais());
            
      UtilidadesLog.debug("************* query " + query );

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        UtilidadesLog.debug("************* Recordset "+ rs );
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      dtoSalida.setResultado(rs);
     
      UtilidadesLog.info("DAOCajas().obtenerCajas(DTOCaja dtoin):Salida");
      return dtoSalida;    
   }
   
   /**
   * Busca las cajas según los criterios que llegan en el DTO (DBLG500000884)
   * @author gPineda
   * @return DTOSalida con los datos que cumplen la condición.
   * @exception MareException 
   * @param dtoEntrada
   */
   public DTOSalida buscarCajas (DTOMantenimientoCaja dtoEntrada) throws MareException {
     UtilidadesLog.info("DAOCajas().buscarCajas(DTOMantenimientoCaja dtoEntrada):Entrada");
     UtilidadesLog.debug( dtoEntrada );
     
     StringBuffer query = new StringBuffer();
     DTOSalida dtoSalida = new DTOSalida();
     BelcorpService bs = UtilidadesEJB.getBelcorpService();
     RecordSet rs;
      query.append(" SELECT * FROM ( ");
      query.append(" SELECT ROWNUM AS OID, I18N_CAN.VAL_I18N CANAL, I18N_ACC.VAL_I18N ACCESO, ");
      query.append("        I18N_SBAC.VAL_I18N SUBACCESO, CAJ.COD_CAJA, ");
      query.append("        PRO1.STRINGVALUE || ' ' || PRO2.STRINGVALUE || ' ' || PRO3.STRINGVALUE || ' ' || PRO4.STRINGVALUE RESP_CAJA, ");
      query.append("        TCAJ.COD_TIPO_CAJA TIPO_CAJA, ");
      query.append("        CAN.OID_CANA, ACC.OID_ACCE, SUB.OID_SBAC, PRI.IDPRINCIPAL OID_RESP, TCAJ.OID_TIPO_CAJA OID_TIPO_CAJA, CAJ.PAIS_OID_PAIS OID_PAIS, ");
      query.append("        CAJ.OID_CAJA ");
      query.append("   FROM BEL_CAJA CAJ LEFT JOIN BEL_TIPO_CAJA TCAJ ON (CAJ.TICJ_OID_TIPO_CAJA = TCAJ.OID_TIPO_CAJA) ");
      query.append("                     JOIN SEG_SUBAC SUB ON (CAJ.SBAC_OID_SBAC = SUB.OID_SBAC) ");
      query.append("        				     JOIN SEG_ACCES ACC ON (SUB.ACCE_OID_ACCE = ACC.OID_ACCE) ");
      query.append("                     JOIN SEG_CANAL CAN ON (ACC.CANA_OID_CANA = CAN.OID_CANA) ");
      query.append(" 					           JOIN PRINCIPALS PRI ON (CAJ.USER_OID_USER = PRI.IDPRINCIPAL) ");
      query.append("        				     LEFT JOIN PROPERTYVALUES PRO1 ON (PRI.IDPRINCIPAL = PRO1.IDPRINCIPAL AND PRO1.IDPROPERTY = 2) "); // Primer Apellido
      query.append("        				     LEFT JOIN PROPERTYVALUES PRO2 ON (PRI.IDPRINCIPAL = PRO2.IDPRINCIPAL AND PRO2.IDPROPERTY = 3) "); // Segundo Apellido
      query.append("        				     LEFT JOIN PROPERTYVALUES PRO3 ON (PRI.IDPRINCIPAL = PRO3.IDPRINCIPAL AND PRO3.IDPROPERTY = 5) "); // Primer Nombre
      query.append("        				     LEFT JOIN PROPERTYVALUES PRO4 ON (PRI.IDPRINCIPAL = PRO4.IDPRINCIPAL AND PRO4.IDPROPERTY = 6) "); // Segundo Nombre
      query.append("        				     LEFT JOIN GEN_I18N_SICC_COMUN I18N_CAN ON (I18N_CAN.IDIO_OID_IDIO = 1 ");
      query.append(" 									                                    AND I18N_CAN.ATTR_ENTI = 'SEG_CANAL' ");
      query.append(" 													                            AND I18N_CAN.VAL_OID = CAN.OID_CANA ");
      query.append(" 													                            ) ");
      query.append("        				     LEFT JOIN GEN_I18N_SICC_COMUN I18N_ACC ON (I18N_ACC.IDIO_OID_IDIO = 1 ");
      query.append(" 													                            AND I18N_ACC.ATTR_ENTI = 'SEG_ACCES' ");
      query.append(" 													                            AND I18N_ACC.VAL_OID = ACC.OID_ACCE ");
      query.append(" 													                            ) ");
      query.append("        				     LEFT JOIN GEN_I18N_SICC_COMUN I18N_SBAC ON (I18N_SBAC.IDIO_OID_IDIO = 1 ");
      query.append(" 													                             AND I18N_SBAC.ATTR_ENTI = 'SEG_SUBAC' ");
      query.append(" 													                             AND I18N_SBAC.VAL_OID = SUB.OID_SBAC ");
      query.append(" 													                             ) ");
      query.append(" WHERE CAJ.PAIS_OID_PAIS = "+ dtoEntrada.getOidPais() +" ");
     
     if( dtoEntrada.getOidAcceso() != null ){
       query.append(" AND ACC.OID_ACCE = "+ dtoEntrada.getOidAcceso() +" " );  
     }
     if( dtoEntrada.getOidSubacceso() != null){
      query.append(" AND SUB.OID_SBAC = "+ dtoEntrada.getOidSubacceso() +" ");
     }
     if( dtoEntrada.getOidCanal() != null){
      query.append(" AND CAN.OID_CANA = "+ dtoEntrada.getOidCanal() +" ");
     }
     if( dtoEntrada.getOidCaja() != null){
      query.append(" AND CAJ.OID_CAJA = "+ dtoEntrada.getOidCaja() +" ");
     }
     if( dtoEntrada.getCodigoCaja() != null){
      query.append(" AND CAJ.COD_CAJA LIKE '"+ dtoEntrada.getCodigoCaja() +"' ");
     }
     if( dtoEntrada.getOidRespCierreCaja() != null){
      query.append(" AND CAJ.USER_OID_USER = "+ dtoEntrada.getOidRespCierreCaja() +" ");
     }
     if( dtoEntrada.getOidTipoCaja() != null){
      query.append(" AND CAJ.TICJ_OID_TIPO_CAJA = "+ dtoEntrada.getOidTipoCaja() +" ");
     }
     
     query.append(") WHERE ROWNUM <= "+ dtoEntrada.getTamanioPagina() +" AND OID > "+ dtoEntrada.getIndicadorSituacion() +" ");

     try{
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
     }catch(Exception e){
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
     if( rs.esVacio() ){
       throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );
     }
     
     dtoSalida.setResultado( rs );
     UtilidadesLog.info("DAOCajas().buscarCajas(DTOMantenimientoCaja dtoEntrada):Salida");
     return dtoSalida;
   }
   
   /**
   * Recupera los tipos de caja  (DBLG500000884)
   * @author gPineda
   * @return DTOSalida con los datos que cumplen la condición.
   * @exception MareException 
   * @param dtoEntrada
   */
   public DTOSalida obtenerTiposCajas () throws MareException {
     UtilidadesLog.info("DAOCajas().obtenerTiposCajas():Entrada");
     StringBuffer query = new StringBuffer();
     DTOSalida dtoSalida = new DTOSalida();
     BelcorpService bs = UtilidadesEJB.getBelcorpService();
     RecordSet rs;
     
     query.append(" SELECT CAJ.OID_TIPO_CAJA, CAJ.COD_TIPO_CAJA ");
     query.append(" FROM BEL_TIPO_CAJA CAJ ");

     try{
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
     }catch(Exception e){
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
     
     dtoSalida.setResultado( rs );
     UtilidadesLog.info("DAOCajas().obtenerTiposCajas():Salida");
     return dtoSalida;
   }
}