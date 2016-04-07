package es.indra.sicc.logicanegocio.men;


import javax.ejb.EJBLocalObject;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.men.DTOElementoMenu;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.men.DTOEntradaFuncionSeleccionada;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.men.DTOFuncionMenu;
import es.indra.sicc.dtos.men.DTOEntradaInsertarElementodeMenu;
import es.indra.sicc.dtos.men.DTOModificarElementoMenu;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.dtos.men.DTOEntradaObtieneFuncion;
import es.indra.sicc.dtos.men.DTOEntradaPresentarMenu;
import es.indra.sicc.dtos.men.DTOString;

import es.indra.sicc.dtos.men.DTOOIDs;

public interface MONFuncionesMenuLocal extends EJBLocalObject 
{
    DTOElementoMenu construirArbolMenu(boolean hojas, RecordSet elementos) throws MareException;

    DTOSalida consulta(DTOEntradaFuncionSeleccionada dtoe) throws MareException;

    DTOFuncionMenu consulta(DTOOID dto) throws MareException;

    void elimina(DTOEntradaFuncionSeleccionada dtoe) throws MareException;

    void elimina(DTOOIDs dto) throws MareException;

    void guarda(DTOFuncionMenu dto) throws MareException;

    void insertar(DTOEntradaInsertarElementodeMenu dtoe) throws MareException;

    void modifica(DTOModificarElementoMenu dtoe) throws MareException;

    DTOElementoMenu obtenerMenuCompleto(DTOBelcorp dto) throws MareException;

    DTOElementoMenu obtenerMenuUsuario(DTOBoolean dto) throws MareException;

    DTOSalida obtieneFuncion(DTOEntradaObtieneFuncion dtoe) throws MareException;

    DTOSalida obtieneFunciones(DTOEntradaPresentarMenu dTOEntradaPresentarMenu) throws MareException;

    DTOSalida obtieneFuncionesUsuario(DTOString usuario) throws MareException;

    RecordSet obtieneFuncionesConfigurarAyuda(String usuario, Long idIdioma) throws MareException;

    DTOSalida obtieneMenu(DTOEntradaObtieneFuncion dtoe) throws MareException;
}
