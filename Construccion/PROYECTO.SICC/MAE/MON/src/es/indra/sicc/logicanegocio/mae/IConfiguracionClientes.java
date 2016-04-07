package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public interface IConfiguracionClientes  {
	//DTOTipoSubtipo obtenerTipoSubtipo (DTOBelcorp dto);
		public DTOSalida obtenerTipos(DTOBelcorp dto)throws MareException;
		public DTOSalida obtenerTiposClasificacion (DTOOID subtipo)throws MareException;
		public DTOTipoSubtipoCliente obtenerTipoPrincipalCliente (Long cliente) throws MareException;
		public DTOSalida obtenerTiposDocumentoCliente(DTOOID cliente) throws MareException;
		public RecordSet obtenerTipoDocumentoLegal(DTOOID dto) throws MareException;
		public RecordSet obtenerClasificacionesCliente(Long tipoClasificacion, String tipoCliente, Long idioma) throws MareException;
        public DTOSalida obtenerTiposTarjeta(DTOBelcorp dto) throws MareException;
       
}