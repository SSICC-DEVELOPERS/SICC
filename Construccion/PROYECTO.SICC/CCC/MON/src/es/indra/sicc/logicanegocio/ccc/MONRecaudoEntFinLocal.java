package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;

public interface MONRecaudoEntFinLocal extends EJBLocalObject  {
   void BloquearLote(Long numeroLote) throws MareException;
}