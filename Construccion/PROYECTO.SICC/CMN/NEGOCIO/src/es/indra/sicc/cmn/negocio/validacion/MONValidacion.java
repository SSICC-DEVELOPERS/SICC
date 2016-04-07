package es.indra.sicc.cmn.negocio.validacion;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;

public interface MONValidacion extends EJBObject 
{
  Boolean validarVinculos(Long Pais, Long Sociedad, Long Marca, Long Canal, Long Acceso, Long Subacceso) throws RemoteException, MareException;

  Boolean validarAccesos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio) throws RemoteException, MareException;

    Boolean validarAccesos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio, String user) throws MareException, RemoteException;
}