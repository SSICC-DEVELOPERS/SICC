package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.intsys.DTOCodProdOid;
import es.indra.mare.common.dto.MareDTO;

public interface ExtensionINT extends EJBObject 
{
     DTOCodProdOid validacionCodigoProducto(MareDTO datos) throws MareException, RemoteException;

}