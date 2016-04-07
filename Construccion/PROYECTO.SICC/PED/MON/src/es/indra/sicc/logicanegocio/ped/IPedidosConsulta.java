package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;

public interface IPedidosConsulta  {
	DTOSalida obtieneTiposSolicitudPais(DTOBelcorp dto);

	DTOSalida obtieneTiposPosicion(DTOBelcorp dto);
}