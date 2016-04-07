package es.indra.sicc.logicanegocio.men;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;

public interface IUsuarios  {
		public DTOSalida obtenerUsuarios(DTOBelcorp dtoin) throws MareException;	
		public DTOSalida obtenerCodUsuarios(DTOBelcorp dto) throws MareException;
	
}