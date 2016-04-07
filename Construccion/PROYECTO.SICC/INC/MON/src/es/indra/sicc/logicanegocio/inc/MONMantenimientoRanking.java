package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.inc.DTOAmbitRC;
import es.indra.sicc.dtos.inc.DTOAsignarPremios;
import es.indra.sicc.dtos.inc.DTOComunicarParticipantes;
import es.indra.sicc.dtos.inc.DTOEntregaPremios;
import es.indra.sicc.dtos.inc.DTONivelesRanking;
import es.indra.sicc.dtos.inc.DTORanking;
import es.indra.sicc.dtos.inc.DTORankingNivelesPremios;
import es.indra.sicc.dtos.inc.DTOVentaRankingGerentes;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.lang.Long;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONMantenimientoRanking
        extends EJBObject {
    DTOSalida obtenerNroConcursosVersionesRankingActivos(DTOBelcorp dtoIn)
            throws RemoteException, MareException;

    DTOSalida obtieneVersiones(DTOOID dtoIn) throws MareException, RemoteException;

    DTOSalida buscarConcursosRanking(DTORanking dtoIn)
            throws MareException, RemoteException;

    DTOSalida recuperarNivelesPremios(DTOOIDPaginado dtoIn)
            throws MareException, RemoteException;

    DTOSalida obtenerSGVConcursoAmbito(DTOAmbitRC dtoIn)
            throws RemoteException, MareException;

    DTOSalida obtenerRegionesConcursoAmbito(DTOAmbitRC dtoIn)
            throws RemoteException, MareException;

    DTOSalida obtenerZonasConcursoAmbito(DTOAmbitRC dtoIn)
            throws RemoteException, MareException;

    DTOSalida obtenerSeccionesConcursoAmbito(DTOAmbitRC dtoIn)
            throws RemoteException, MareException;

    DTOSalida obtenerTerritoriosConcursoAmbito(DTOAmbitRC dtoIn)
            throws RemoteException, MareException;

    DTOSalida recuperarVentaRankingGerentes(DTOVentaRankingGerentes dtoIn)
            throws MareException, RemoteException;

    Boolean validarFaseEvaluacion(Long oidConcurso) throws MareException, RemoteException;

    DTOSalida recuperarPremiosNiveles(DTORankingNivelesPremios dtoIn)
            throws MareException, RemoteException;

    DTOSalida calcularRanking(DTOVentaRankingGerentes dtoIn)
            throws MareException, RemoteException;

    void comunicarAParticipantes(DTOComunicarParticipantes dtoIn)
            throws MareException, RemoteException;

    DTOSalida recuperarGanadorasAspirantesNivel(DTONivelesRanking dtoIn)
            throws MareException, RemoteException;

    void entregaDePremios(DTOEntregaPremios dtoIn) throws MareException, RemoteException;

    void actualizarGanadoras(ClientePremiacion clientePremiacion)
            throws MareException, RemoteException;

    void asignarPremiosRanking(DTOAsignarPremios dto) throws MareException, RemoteException;

  void generarEvaluacionRanking(DTOVentaRankingGerentes dto) throws RemoteException, MareException;

  void calificar(DTOComunicarParticipantes dtoIn) throws RemoteException, MareException;

  void comunicarAParticipantesEvolutivo(DTOComunicarParticipantes dto) throws RemoteException, MareException;

  void entregaDePremiosEvolutivo(DTOEntregaPremios dto) throws RemoteException, MareException;

  void preProcesoSolicitudesVariableVentaRanking(Long oidConcurso) throws RemoteException, MareException;
}
