package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.SegPaisData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.MSGEjbLocators;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;

import java.util.Date;

public class UtilidadesMMGCCC  {
	public UtilidadesMMGCCC() {}

	public boolean enviaMensaje (SegPaisData pais, String descripcionBanco) 
											throws MareException{
		DTOSalida resultado = new DTOSalida();

		try{
		
			MONClientes monMAE = MAEEjbLocators.getMONClientesHome().create();
			DTOBelcorp dtoe = new DTOBelcorp();
			dtoe.setOidPais( new Long( pais.getId().intValue() ) );
			resultado = monMAE.listaClientesPais( dtoe );
			
        } catch (Exception e) {
			return false;
        }

		RecordSet rs = resultado.getResultado();
		if (rs != null && !rs.esVacio()){
			DTOBuzonMensajes buzon;
			for (int i=0; i<rs.getRowCount(); i++){
				try{
					buzon = new DTOBuzonMensajes();
					buzon.setOidPais( new Long( pais.getId().intValue()) );
					buzon.setCodigoMensaje( "CCC01" );
					//buzon.setModuloOrigen( new Long( CodigosModulos.CCC ) ); //TODO: verificar
					buzon.setModuloOrigen( new Long( ConstantesSEG.MODULO_CCC ) ); //TODO: verificar          
					//buzon.setCodigoCliente( ((BigDecimal) rs.getValueAt(i,0 )).toString() );
					buzon.setListaConsultoras("N");
					buzon.setDatoVariable1( (String) rs.getValueAt(i,1 ) );

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaActual = new Date( System.currentTimeMillis());
					buzon.setDatoVariable2( sdf.format(fechaActual) ); //TODO: que formato?

					buzon.setDatoVariable3(descripcionBanco); 
					MONGestionMensajes monMSG = MSGEjbLocators.getMONGestionMensajesHome().create();
					monMSG.insertaDatosMensaje( buzon );
				} catch (Exception e) {
					//no pasa nada, sigo con la proxima consultora.
					UtilidadesLog.error( "Error al llamar insertaDatosMensaje()." );
				}
			}
		}
		
		return true;											
	}
}