package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import java.sql.Date;

public interface MONReestructuracion extends EJBObject 
{
  void PruebaDAOZONA() throws MareException, RemoteException;

  void asignarNSE(Long codPais, Long codMarca, Long codCanal, Long codTerritorio, Long codUA, Integer nivelUA) throws RemoteException, MareException;

  void realizarDivisionTerritorios(Long oidTerrOrigen, String codTerrDestino, Long oidCliente, Long oidPais, Date fechaInicioPeriodo) throws MareException, RemoteException;

  void actualizarMaestroCliente(Long oidClienteAfectado, Long oidTerrEliminado, Long oidTerrNuevo) throws MareException, RemoteException;

  void insertarHistoricoGerenteLideres(Long oidcliente, Long oidTerrOrigen, Long oidTerrDestino) throws MareException, RemoteException;

  void actualizarMaestroClientesFusion(Long oidTerrEliminado, Long oidTerrNuevo) throws MareException, RemoteException;

  void insertaHistoricoReterritorializacion(Long oidTerritorio1, Long oidTerritorio2, Long oidTerritorio3, String tipoOP, Date fechaInicioPerido) throws MareException, RemoteException;

  void realizarFusionTerritorios(Long oidTerrOrigen01, Long oidTerrOrigen02, String codTerrDestion, Long oidPais, Date fechaInicioPeriodo) throws MareException, RemoteException;



  //DTOPeriodosReestructuracion obtenerPeriodosReestructuracion(ListConsultorasReestructuracion ListClientes) throws MareException, RemoteException;

  //void crearNuevasUnidadesAdministrativas(ListConsultorasReestructuracion arg) throws MareException, RemoteException;








}