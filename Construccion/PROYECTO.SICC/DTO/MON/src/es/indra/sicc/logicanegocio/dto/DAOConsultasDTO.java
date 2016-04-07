package es.indra.sicc.logicanegocio.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import javax.ejb.CreateException;


public class DAOConsultasDTO  {

	public static DTOSalida obtenerSubtiposClienteMultiTipocliente(DTOOIDs dto) throws MareException{
        UtilidadesLog.info("DAOConsultasDTO.obtenerSubtiposClienteMultiTipocliente(): Entrada");
		RecordSet rs = null;
		for (int i = 0; i < dto.getOids().length; i++){
			MONConfiguracionClientes cc = null;
			DTOSalida dtosal = null;
			try{
				cc = MAEEjbLocators.getMONConfiguracionClientesHome().create();
			
				DTOOID oid = new DTOOID();
				oid.setOid(dto.getOids()[i]);
				dtosal = cc.obtenerSubtipos(oid);
			}catch(RemoteException e){
				throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}catch(CreateException ee){
				throw new MareException(ee,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));	
			}
			RecordSet rstemp = dtosal.getResultado();
			for(int ii = 0; ii < rstemp.getRowCount(); ii++){
				rs.insertRow(ii,rstemp.getRow(ii));
			}
		
		}
		DTOSalida dtos = new DTOSalida();
		dtos.setResultado(rs);
        UtilidadesLog.info("DAOConsultasDTO.obtenerSubtiposClienteMultiTipocliente(): Salida");
		return dtos;
	}

	public static DTOSalida obtenerTiposClasificacionMultiSubtipoCliente (DTOOIDs dto)throws MareException{
        UtilidadesLog.info("DAOConsultasDTO.obtenerTiposClasificacionMultiSubtipoCliente(): Entrada");
		RecordSet rs = null;
		for (int i = 0; i < dto.getOids().length; i++){
			MONConfiguracionClientes cc = null;
			DTOSalida dtosal = null;
			try{
				cc = MAEEjbLocators.getMONConfiguracionClientesHome().create();
			
				DTOOID oid = new DTOOID();
				oid.setOid(dto.getOids()[i]);
                oid.setOidIdioma(dto.getOidIdioma());
                UtilidadesLog.debug(oid);
				dtosal = cc.obtenerTipoClasificacion(oid);
			}catch(RemoteException e){
				throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}catch(CreateException ee){
				throw new MareException(ee,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));	
			}
			RecordSet rstemp = dtosal.getResultado();
			for(int ii = 0; ii < rstemp.getRowCount(); ii++){
				rs.insertRow(ii,rstemp.getRow(ii));
			}
		
		}
		DTOSalida dtos = new DTOSalida();
		dtos.setResultado(rs);
        UtilidadesLog.info("DAOConsultasDTO.obtenerTiposClasificacionMultiSubtipoCliente(): Salida");
		return dtos;
	}
	
	public static DTOSalida obtenerClasificacionesMultiTipoClasificacion (DTOOIDs dto)throws MareException{
        UtilidadesLog.info("DAOConsultasDTO.obtenerClasificacionesMultiTipoClasificacion(): Entrada");
		RecordSet rs = new RecordSet();
		for (int i = 0; i < dto.getOids().length; i++){
			MONConfiguracionClientes cc = null;
			DTOSalida dtosal = null;
			try{
				cc = MAEEjbLocators.getMONConfiguracionClientesHome().create();
				DTOOID oid = new DTOOID();
				oid.setOid(dto.getOids()[i]);
                oid.setOidIdioma(dto.getOidIdioma());
                oid.setOidPais(dto.getOidPais());
				dtosal = cc.obtenerClasificacionesPorTipo(oid);
			}catch(RemoteException e){
				throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}catch(CreateException ee){
				throw new MareException(ee,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));	
			}
			RecordSet rstemp = dtosal.getResultado();
			for(int ii = 0; ii < rstemp.getRowCount(); ii++){
                UtilidadesLog.debug("rstemp.getRow(ii) : " + rstemp.getRow(ii));

                rs.setColumnIdentifiers(rstemp.getColumnIdentifiers());
                
				rs.insertRow(ii,rstemp.getRow(ii));
                UtilidadesLog.debug("rs : " + rs);
			}

		}
		DTOSalida dtos = new DTOSalida();
		dtos.setResultado(rs);
        UtilidadesLog.info("DAOConsultasDTO.obtenerClasificacionesMultiTipoClasificacion(): Salida");
		return dtos;
	}

	
}