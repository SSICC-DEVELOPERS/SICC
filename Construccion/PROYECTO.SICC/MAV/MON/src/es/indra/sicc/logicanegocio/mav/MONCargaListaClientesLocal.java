package es.indra.sicc.logicanegocio.mav;

import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.util.DTOString;

import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;

public interface MONCargaListaClientesLocal extends EJBLocalObject 
{
    DTOManagerFileResult procesar(DTOFicheroDisp dto) throws MareException;

    DTOSalida busquedaListaClientes(DTOBusquedaRapidaCliente dto) throws MareException;

    DTOString procesarLista(DTOString dto) throws MareException;
}
