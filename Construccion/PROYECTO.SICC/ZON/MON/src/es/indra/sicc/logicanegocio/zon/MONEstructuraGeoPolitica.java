package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.zon.DTOEstructuraGeopoliticaPais;
import es.indra.sicc.dtos.zon.DTOEGPaises;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOPais;
import java.util.Vector;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.zon.DTOZONConsultarPaises;
import es.indra.sicc.dtos.zon.DTOUsuario;
import es.indra.sicc.dtos.zon.DTOSubEstructura;

public interface MONEstructuraGeoPolitica extends EJBObject 
{
  DTOEstructuraGeopoliticaPais obtenerEstructuraGeoPolitica(DTOPais pais) throws MareException, MareException, RemoteException;

  RecordSet cargaPaisesSinEG(String usuario) throws RemoteException, RemoteException, MareException;

  void definirEG(DTOEstructuraGeopoliticaPais eg) throws MareException, RemoteException;

  RecordSet cargaPaisesConEG(DTOUsuario usuario) throws RemoteException, MareException;

  DTOSalida consultaEGPaises(DTOZONConsultarPaises paises) throws RemoteException, RemoteException, MareException;

  DTOEstructuraGeopoliticaPais consultaEGMod(DTOZONConsultarPaises paises) throws MareException, RemoteException;

  void modificaEG(DTOEstructuraGeopoliticaPais eg) throws RemoteException, RemoteException, MareException;

  void eliminaEG(DTOPais pais) throws RemoteException, RemoteException, MareException;

  boolean paisTieneEG(Long pais) throws RemoteException, RemoteException, MareException;

  boolean paisTieneNivelDefinido(Integer oidPais, Integer nivel, String pais) throws RemoteException, RemoteException, MareException;

  RecordSet cargaDivisionesPoliticas(Long idioma) throws RemoteException, RemoteException, MareException;


  RecordSet consultaDefinirEG(DTOZONConsultarPaises dtoe) throws RemoteException, MareException;
}