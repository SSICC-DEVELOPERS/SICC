package es.indra.sicc.logicanegocio.bel;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOApplet;
import es.indra.sicc.util.DTOOID;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MONCobroDevolucion extends EJBObject 
{
    es.indra.sicc.dtos.bel.DTODatosCobroDevolucion cargaInicial(DTOApplet dtoa) throws MareException, RemoteException;
}