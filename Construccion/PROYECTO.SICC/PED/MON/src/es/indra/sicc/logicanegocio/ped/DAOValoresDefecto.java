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

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.ped.*;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.util.Arrays;

public class DAOValoresDefecto  {
	public DAOValoresDefecto() {
	}

	private BelcorpService getBelcorpService() throws MareException{

        try {
            BelcorpService bs = BelcorpService.getInstance();
			return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }		
		
	}
	
	public DTOValoresDefecto obtenerValorDefecto(DTOValoresDefecto DTOE, int ind)
		throws MareException{
        
        UtilidadesLog.info("DAOValoresDefecto.obtenerValorDefecto(DTOValoresDefecto DTOE, int ind): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append("	SELECT vdts.val_valo_defe, vdts.ind_obli, vdts.ind_modi ");
			query.append("	  FROM ped_valor_defec_tipo_solic vdts, ped_atrib_espec ae ");
			query.append("	 WHERE vdts.tspa_oid_tipo_soli_pais = " + DTOE.getTipoSolicitud());
			query.append("	   AND ae.oid_atri_espe = vdts.atre_oid_atri_espe ");
			query.append("	   AND ae.modu_oid_modu = " + DTOE.getModulo());
			query.append("	   AND ae.val_form = '" + DTOE.getFormulario() + "' ");
			query.append("	   AND ae.cod_atri = '" + DTOE.getCampo()[ind] + "'" );
			query.append("	order by 1 ");

			respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

		String[] valores = new String[ind+1];
		for (int i=0;i < ind; i++) {
			if(DTOE.getValor()[i] != null) {
        valores[i] = DTOE.getValor()[i];
      } else {
        valores[i] = null;
      }
    }

		Boolean[] obligatorios = new Boolean[ind+1];
		for (int i=0;i < ind; i++) {
      if(DTOE.getValor()[i] != null) {
        obligatorios[i] = DTOE.getObligatorio()[i];
      } else {
        obligatorios[i] = null;
      }
    }

		Boolean[] editables = new Boolean[ind+1];
		for (int i=0;i < ind; i++) {
      if(DTOE.getValor()[i] != null) {
      	editables[i] = DTOE.getEditable()[i];
      } else {
        editables[i] = null;
      }
    }
    

		if(!respuesta.esVacio()) {

			valores[ind] = (String)respuesta.getValueAt(0, 0);

			
			obligatorios[ind] = ((BigDecimal)respuesta.getValueAt(0, 1)).intValue()==1? Boolean.TRUE:Boolean.FALSE;
					
			editables[ind] = ((BigDecimal)respuesta.getValueAt(0, 2)).intValue()==1? Boolean.TRUE:Boolean.FALSE;
		}

		DTOE.setValor(valores);
		DTOE.setObligatorio(obligatorios);
		DTOE.setEditable(editables);			
        UtilidadesLog.info("DAOValoresDefecto.obtenerValorDefecto(DTOValoresDefecto DTOE, int ind): Salida ");
		return DTOE;
	}
}