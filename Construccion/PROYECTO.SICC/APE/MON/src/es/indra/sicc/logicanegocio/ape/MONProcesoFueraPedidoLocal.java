package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBLocalObject;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;

public interface MONProcesoFueraPedidoLocal extends EJBLocalObject 
{
  ArrayList procesarFueraPedido(ArrayList lstProductos) throws MareException;

    void crearListasAFPDefinitivas(Long oidPais) throws MareException;
}