package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;

public interface MONRevertirDescuentosLocal extends EJBLocalObject 
{
    void revertirDescuentos(DTOOID dto) throws MareException;
}