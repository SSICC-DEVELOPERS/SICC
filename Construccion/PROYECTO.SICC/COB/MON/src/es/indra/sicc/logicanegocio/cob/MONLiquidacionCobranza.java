package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cob.DTOConsultarLiquidacionComisionesCobranza;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;

public interface MONLiquidacionCobranza extends EJBObject 
{
  DTOSalida listarLiquidaciones(DTOConsultarLiquidacionComisionesCobranza dtoEntrada) throws RemoteException, MareException;
}