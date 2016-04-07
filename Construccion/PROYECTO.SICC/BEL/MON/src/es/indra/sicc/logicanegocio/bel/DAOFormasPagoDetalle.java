/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.bel.DTOEBuscarFormasPagoDetalle;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.util.Vector;


public class DAOFormasPagoDetalle {

	private String usuario;
	
	public DAOFormasPagoDetalle(String usuario) {
		this.usuario = usuario;
	}

	/** 
     * Método para buscar detalles de formas de Pago
     * @param dto DTOEBuscarFormasPagoDetalle con los atributos por los que se filtrará la busqueda
     * @return DTOSalida el resultado de la busqueda
     * @exception MareException 
     */
	public DTOSalida buscarFormasPagoDetalle(DTOEBuscarFormasPagoDetalle dto) throws MareException {
    UtilidadesLog.info("DAOFormasPagoDetalle.buscarFormasPagoDetalle(DTOEBuscarFormasPagoDetalle dto):Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");		
		Vector parametros=new Vector();
		String sqlPaginada="";
		try{			
			//Añadido para obtener todos los de actividad nulos
			if (dto.getOidMarca() == null && dto.getOidCanal() == null) {
				
				consulta.append(" SELECT BF.OID_FORM_PAGO_DETA OID, "); //oid

				//Forma de pago.
				consulta.append(" CONCAT( CONCAT( BP.COD_FORM_PAGO,' '), ");			
				consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
				consulta.append(" IDIO.attr_enti = 'BEL_FORMA_PAGO' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
				parametros.add(dto.getOidIdioma());
				consulta.append(" AND IDIO.val_oid = BF.FOPA_OID_FORM_PAGO )) AS FORMA_PAGO, ");

				consulta.append(" BF.NUM_POSI_DETA, ");//posicion
				
				//Medio de pago.
				consulta.append(" CONCAT( CONCAT( MP.COD_MEDI_PAGO,' '), ");			
				consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
				consulta.append(" IDIO.attr_enti = 'BEL_MEDIO_PAGO' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
				parametros.add(dto.getOidIdioma());
				consulta.append(" AND IDIO.val_oid = BF.MPAB_OID_MEDI_PAGO )) AS MEDIO_PAGO, ");
			
				
				consulta.append(" BF.VAL_PORC_PAGO, ");//porcentaje pago.
				consulta.append(" BF.COD_INDI_DIAS, ");//indicador dias.
				consulta.append(" BF.NUM_DIAS, ");//numero de dias.

				//Actividad
				consulta.append(" NULL AS ACTIVIDAD ");

				consulta.append(" FROM BEL_FORMA_PAGO_DETAL BF, ");
				consulta.append(" BEL_FORMA_PAGO BP, ");
				consulta.append(" BEL_MEDIO_PAGO MP");

				consulta.append(" WHERE BF.FOPA_OID_FORM_PAGO = BP.OID_FORM_PAGO ");
				consulta.append(" AND BF.MPAB_OID_MEDI_PAGO = MP.OID_MEDI_PAGO ");
				consulta.append(" AND BF.CACT_OID_ACTI IS NULL ");
				if (dto.getOidFormaPagoCabecera() != null) {
					consulta.append(" AND BF.FOPA_OID_FORM_PAGO = ? ");
					parametros.add(dto.getOidFormaPagoCabecera());
				}
				if (dto.getIndicadorDeDias() != null) {
					consulta.append(" AND BF.COD_INDI_DIAS = ? ");
					parametros.add(dto.getIndicadorDeDias().toString()); //La clase Character da problemas
				}
				if (dto.getOidMedioPago() != null) {
					consulta.append(" AND BF.MPAB_OID_MEDI_PAGO = ? ");
					parametros.add(dto.getOidMedioPago());
				}
				consulta.append(" AND BP.PAIS_OID_PAIS = ? UNION ");
				parametros.add(dto.getOidPais());
			}
			
		    //Actividad no nulos
			consulta.append(" SELECT BF.OID_FORM_PAGO_DETA OID, "); //oid

			//Forma de pago.
			consulta.append(" CONCAT( CONCAT( BP.COD_FORM_PAGO,' '), ");			
			consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_FORMA_PAGO' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = BF.FOPA_OID_FORM_PAGO )) AS FORMA_PAGO, ");

			consulta.append(" BF.NUM_POSI_DETA, ");//posicion


			//Medio de pago.
			consulta.append(" CONCAT( CONCAT( MP.COD_MEDI_PAGO,' '), ");			
			consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_MEDIO_PAGO' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = BF.MPAB_OID_MEDI_PAGO )) AS MEDIO_PAGO, ");
			
			consulta.append(" BF.VAL_PORC_PAGO, ");//porcentaje pago.
			consulta.append(" BF.COD_INDI_DIAS, ");//indicador dias.
			consulta.append(" BF.NUM_DIAS, ");//numero de dias.

			//Actividad
			consulta.append(" DECODE(BF.CACT_OID_ACTI, NULL, NULL, CR.COD_ACTI||' '||");
			consulta.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'CRA_ACTIV' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = BF.CACT_OID_ACTI )) AS ACTIVIDAD ");

			/*
			consulta.append(" FROM ((BEL_FORMA_PAGO_DETAL BF LEFT JOIN CRA_ACTIV CR ON (BF.CACT_OID_ACTI = CR.OID_ACTI)) ");
			consulta.append(" INNER JOIN VCA_SEG_CANAL SC ON (CR.CANA_OID_CANA = SC.OID_CANA AND SC.COD_USUA = ?)) ");
			parametros.add(usuario);
			consulta.append(" INNER JOIN VCA_SEG_MARCA SM ON (CR.MARC_OID_MARC = SM.OID_MARC AND SM.COD_USUA = ?), ");
			parametros.add(usuario);
			*/
			// Actualizado
			consulta.append(" FROM BEL_FORMA_PAGO_DETAL BF INNER JOIN (CRA_ACTIV CR INNER JOIN VCA_SEG_CANAL SC ON ");
			consulta.append(" (CR.CANA_OID_CANA = SC.OID_CANA AND SC.COD_USUA = ?) ");
			parametros.add(usuario);
			consulta.append(" INNER JOIN VCA_SEG_MARCA SM ON (CR.MARC_OID_MARC = SM.OID_MARC AND SM.COD_USUA = ?)) ");
			parametros.add(usuario);
			consulta.append(" ON (BF.CACT_OID_ACTI = OID_ACTI), ");
			//	
			consulta.append(" BEL_FORMA_PAGO BP, ");
			consulta.append(" BEL_MEDIO_PAGO MP");	
			consulta.append(" WHERE BF.FOPA_OID_FORM_PAGO = BP.OID_FORM_PAGO ");
			consulta.append(" AND BF.MPAB_OID_MEDI_PAGO = MP.OID_MEDI_PAGO ");
			if (dto.getOidFormaPagoCabecera() != null) {
				consulta.append(" AND BF.FOPA_OID_FORM_PAGO = ? ");
				parametros.add(dto.getOidFormaPagoCabecera());
			}
			if (dto.getIndicadorDeDias() != null) {
				consulta.append(" AND BF.COD_INDI_DIAS = ? ");
				parametros.add(dto.getIndicadorDeDias().toString()); //La clase Character da problemas
			}
			if (dto.getOidMarca() != null) {
				consulta.append(" AND CR.MARC_OID_MARC = ? ");			
				parametros.add(dto.getOidMarca());
			}
			if (dto.getOidCanal() != null) {
				consulta.append(" AND CR.CANA_OID_CANA = ? ");
				parametros.add(dto.getOidCanal());
			}
			if (dto.getOidMedioPago() != null) {
				consulta.append(" AND BF.MPAB_OID_MEDI_PAGO = ? ");
				parametros.add(dto.getOidMedioPago());
			}
			consulta.append(" AND BP.PAIS_OID_PAIS = ? ");
			parametros.add(dto.getOidPais());
			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
			rs = (RecordSet) bs.dbService.executePreparedQuery(sqlPaginada,parametros);
		}catch (Exception e){
			UtilidadesLog.error("buscarFormasPagoDetalle: Exception",e);
			this.loguearSql("buscarFormasPagoDetalle",sqlPaginada,parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info("DAOFormasPagoDetalle.buscarFormasPagoDetalle(DTOEBuscarFormasPagoDetalle dto):Salida");
		return new DTOSalida(rs);					
	}

	/** 
     * Método para consultar los detalles de una forma de Pago
     * @param dto DTOOID con el oid de la forma de pago cuyos detalles queremos consultar
     * @return RecordSet el resultado de la consulta
     * @exception MareException 
     */	
		public RecordSet consultarDetalleFormaPago(DTOOID  dto) throws MareException{
		UtilidadesLog.info("DAOFormasPagoDetalle.consultarDetalleFormaPago(DTOOID dto):Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros=new Vector();		 
		try{			
			consulta.append(" SELECT BF.OID_FORM_PAGO_DETA OID, "); //oid

			//Forma de pago.
			consulta.append(" CONCAT( CONCAT( BP.COD_FORM_PAGO,' '), ");			
			consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_FORMA_PAGO' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = BF.FOPA_OID_FORM_PAGO )) AS FORMA_PAGO, ");

			consulta.append(" BF.NUM_POSI_DETA, ");//posicion
			consulta.append(" BF.VAL_PORC_PAGO, ");//porcentaje pago.

			//Medio de pago.
			consulta.append(" CONCAT( CONCAT( MP.COD_MEDI_PAGO,' '), ");			
			consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_MEDIO_PAGO' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = BF.MPAB_OID_MEDI_PAGO )) AS MEDIO_PAGO, ");
			
			consulta.append(" BF.COD_INDI_DIAS, ");//indicador dias.
			consulta.append(" BF.NUM_DIAS, ");//numero de dias.

			consulta.append(" (SELECT SM1.DES_MARC FROM SEG_MARCA SM1 WHERE CR.MARC_OID_MARC = SM1.OID_MARC) AS DESC_MARCA, ");

			consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE  ");
			consulta.append(" IDIO.attr_enti = 'SEG_CANAL' AND IDIO.idio_oid_idio = ? ");
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid =  CR.CANA_OID_CANA) AS DESC_CANAL, "); 

			//Actividad
			consulta.append(" DECODE(BF.CACT_OID_ACTI, NULL, NULL, CR.COD_ACTI||' '||");
			consulta.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'CRA_ACTIV' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = BF.CACT_OID_ACTI )) AS ACTIVIDAD, ");

			consulta.append(" BF.FOPA_OID_FORM_PAGO AS OIDFP, ");	
			consulta.append(" BF.MPAB_OID_MEDI_PAGO AS OIDMP, ");		 
			consulta.append(" CR.MARC_OID_MARC, ");
			consulta.append("  CR.CANA_OID_CANA, "); 
			consulta.append(" BF.CACT_OID_ACTI  ");

			consulta.append(" FROM BEL_FORMA_PAGO_DETAL BF LEFT JOIN CRA_ACTIV CR ON (BF.CACT_OID_ACTI = CR.OID_ACTI), ");
			consulta.append(" BEL_FORMA_PAGO BP, ");
			consulta.append(" BEL_MEDIO_PAGO MP ");		
			consulta.append(" WHERE BF.FOPA_OID_FORM_PAGO = BP.OID_FORM_PAGO ");
			consulta.append(" AND BF.MPAB_OID_MEDI_PAGO = MP.OID_MEDI_PAGO ");
			consulta.append(" AND BP.OID_FORM_PAGO = ? ");
			parametros.add(dto.getOid());
			consulta.append(" AND BP.PAIS_OID_PAIS = ? ");
			parametros.add(dto.getOidPais());
			consulta.append(" AND (CR.CANA_OID_CANA IS NULL OR ( ");
			consulta.append(" EXISTS (SELECT * FROM VCA_SEG_CANAL SC WHERE CR.CANA_OID_CANA = SC.OID_CANA AND SC.COD_USUA = ?)  ");
			parametros.add(this.usuario);
			consulta.append(" AND EXISTS (SELECT * FROM VCA_SEG_MARCA SM WHERE CR.MARC_OID_MARC = SM.OID_MARC AND SM.COD_USUA = ?)))");
			parametros.add(this.usuario);
			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error("consultarFormaPagoDetalle: Exception",e);
			this.loguearSql("consultarFormaPagoDetalle",consulta.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info("DAOFormasPagoDetalle.consultarDetalleFormaPago(DTOOID dto):Salida");
		return rs;					
	}
	
	/** 
     * Método para consultar un detalle de una forma de Pago
     * @param dto DTOOID con el oid del detalle a consultar
     * @return RecordSet el resultado de la consulta
     * @exception MareException 
     */	
	public RecordSet consultarFormaPagoDetalle(DTOOID dto) throws MareException {
		UtilidadesLog.info("DAOFormasPagoDetalle.consultarFormaPagoDetalle(DTOOID dto):Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros=new Vector();		
		try{			
			consulta.append(" SELECT BF.OID_FORM_PAGO_DETA OID, "); //oid forma pago detalle
			consulta.append(" BF.MPAB_OID_MEDI_PAGO, "); //oid Medio Pago
			
			//Descripcion Medio de pago.
			consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_MEDIO_PAGO' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = BF.MPAB_OID_MEDI_PAGO ) AS DESC_MEDIO_PAGO, ");

			consulta.append(" BF.VAL_PORC_PAGO, ");//porcentaje pago.
			consulta.append(" BF.COD_INDI_DIAS, ");//indicador dias.
			consulta.append(" BF.NUM_DIAS, ");//numero de dias.
			consulta.append(" CR.MARC_OID_MARC, "); //oid Marca

			//Descripcion Marca.	
			consulta.append(" (SELECT SM1.DES_MARC FROM SEG_MARCA SM1 WHERE CR.MARC_OID_MARC = SM1.OID_MARC) AS DESC_MARCA, ");

			consulta.append(" CR.CANA_OID_CANA, "); //oid Canal

			//Descripcion Canal.	
			consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'SEG_CANAL' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid =  CR.CANA_OID_CANA) AS DESC_CANAL, ");

			consulta.append(" BF.CACT_OID_ACTI, "); //oid Actividad
			
			//Descripcion Actividad
			consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'CRA_ACTIV' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = BF.CACT_OID_ACTI ) AS DESC_ACTIVIDAD, ");
			consulta.append(" BF.NUM_POSI_DETA ");

			consulta.append(" FROM BEL_FORMA_PAGO_DETAL BF LEFT JOIN CRA_ACTIV CR ON (BF.CACT_OID_ACTI = CR.OID_ACTI), ");
			consulta.append(" BEL_MEDIO_PAGO MP ");
			consulta.append(" WHERE BF.MPAB_OID_MEDI_PAGO = MP.OID_MEDI_PAGO ");
			consulta.append(" AND BF.OID_FORM_PAGO_DETA = ? ");
			parametros.add(dto.getOid());

			consulta.append(" AND (CR.CANA_OID_CANA IS NULL OR ( ");
			consulta.append(" EXISTS (SELECT * FROM VCA_SEG_CANAL SC WHERE CR.CANA_OID_CANA = SC.OID_CANA AND SC.COD_USUA = ?)  ");
			parametros.add(usuario);
			consulta.append(" AND EXISTS (SELECT * FROM VCA_SEG_MARCA SM WHERE CR.MARC_OID_MARC = SM.OID_MARC AND SM.COD_USUA = ?)))");
			parametros.add(usuario);


			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error("consultarDetalleFormaPago: Exception",e);
			this.loguearSql("consultarDetalleFormaPago",consulta.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info("DAOFormasPagoDetalle.consultarFormaPagoDetalle(DTOOID dto):Salida");
		return rs;						
	}
	public DTOSalida consultarFPagoDetalNumPosi(DTOOID dtoe) throws MareException{
		// metodo añadido por incidencia 8177, metodo necesario en el paquete N011B-FAC
		// La select de este método ha sido modificada por la incidencia 9232
		UtilidadesLog.info("DAOFormasPagoDetalle.consultarFPagoDetalNumPosi(DTOOID dtoe):Entrada");
		/*Concepto
		 * Recupera todos los campos del detalle de la forma de pago y ordenados por el numero de posición
		 * del detalle
	
		 * Parámetros e/s 
		 * Entrada: DTOOID (oidFormaPago)
		 * Salida: DTOSalida
		*/
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros=new Vector();		

		consulta.append(" SELECT D.* , cra.CANA_OID_CANA, cra.MARC_OID_MARC ");
		consulta.append(" FROM  BEL_FORMA_PAGO C, BEL_FORMA_PAGO_DETAL D, ");
		consulta.append(" CRA_ACTIV cra ");
		consulta.append(" WHERE ");
		
		//joins
		consulta.append(" C.OID_FORM_PAGO = D.FOPA_OID_FORM_PAGO AND ");
        //@ssaavedr 27/10/2005, se agrega el (+), para que igual traiga registros, sino no genera cuotas
		consulta.append(" D.CACT_OID_ACTI = cra.OID_ACTI(+) AND ");
		consulta.append(" C.OID_FORM_PAGO = ? ");
		parametros.add(dtoe.getOid()); 
		consulta.append(" ORDER BY NUM_POSI_DETA ");

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("consultarFPagoDetalNumPosi: Exception",e);
			this.loguearSql("consultarFPagoDetalNumPosi. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		DTOSalida dtoS =  new DTOSalida();
		dtoS.setResultado(rs);
		UtilidadesLog.info("DAOFormasPagoDetalle.consultarFPagoDetalNumPosi(DTOOID dtoe):Salida");
		return dtoS;
	}
	
		
	private void loguearSql(String metodo, String sql, Vector params){
    UtilidadesLog.info("DAOFormasPagoDetalle.loguearSql(String metodo, String sql, Vector params):Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0){
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
		UtilidadesLog.info("DAOFormasPagoDetalle.loguearSql(String metodo, String sql, Vector params):Salida");
	}	
	
}