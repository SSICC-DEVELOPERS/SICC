package es.indra.sicc.logicanegocio.zon;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.zon.DTOUBIGEOS;
import es.indra.sicc.dtos.zon.DTOUG;
import es.indra.sicc.dtos.zon.DTOUBIGEO;
import es.indra.sicc.dtos.zon.DTOSubEstructura;

public interface MONUnidadesGeograficas extends EJBObject  {
    DTOSalida obtenerUnidadesGeograficas(DTOUG dtoUG) throws RemoteException, MareException;
    DTOUBIGEO obtenerUBIGEOdeTerritorio(Long codTerritorio) throws RemoteException, MareException;
    Boolean validarUBIGEO(Long oidPais, String ubigeo) throws RemoteException, MareException;
    void desasignarUnidadesGeograficas(DTOPais pais) throws RemoteException, MareException;
    Boolean paisTieneUG(Long pais) throws RemoteException, MareException;
  //DTOConsultaPantallaUG consultaDatosPantalla() throws  RemoteException, MareException, RemoteException;
    DTOSalida obtenerTerritoriosdeUBIGEO(Long pais, String ubigeo) throws RemoteException, MareException;
    void actualizarEstadoUG(DTOUBIGEOS ug) throws RemoteException, MareException;
    void insertarUG(String ubigeo, String nse1, String nse2, String desc, String subestructura, Integer nivel, String cp, Long oidPais, String ip, String oidPrograma) throws RemoteException, MareException;
    void eliminarUG(Long oidPais, String ubigeo, String ip, String oidPrograma) throws RemoteException, MareException;
    void calcularNSE(Long codPais, Long codTerritorio) throws  RemoteException, MareException;
    Boolean validarNivelUBIGEO(Integer nivel, String UBIGEO) throws RemoteException, MareException;
    String obtenerDescripcionUBIGEO(Long valEstructuraGeopolitica) throws RemoteException, MareException;
    DTOSubEstructura obtenerSubestructuraUG(Long oidPais, Long oidTerritorio, Long idIdioma) throws RemoteException, MareException;
    Long obtenerOidUBIGEO(Long oidPais, String ubigeo) throws MareException, RemoteException;
    DTOSalida obtenerUGTerritorios(DTOUG dto) throws  MareException, RemoteException;
    DTOSalida modificaEstadoUniGeo(DTOUG dto) throws  MareException, RemoteException;
}