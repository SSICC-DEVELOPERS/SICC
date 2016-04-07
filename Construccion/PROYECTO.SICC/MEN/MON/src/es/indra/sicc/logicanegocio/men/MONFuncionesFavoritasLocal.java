package es.indra.sicc.logicanegocio.men;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.men.DTOEntradaObtieneFuncion;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.men.DTOCargaFavoritos;
import es.indra.sicc.dtos.men.DTOEntradaSeleccionarFuncionesFavoritas;
import es.indra.sicc.dtos.men.DTOFavoritos;
import es.indra.sicc.dtos.men.DTOString;

public interface MONFuncionesFavoritasLocal extends EJBLocalObject 
{
    DTOSalida consultaFavorito(DTOEntradaObtieneFuncion dtoEOF) throws MareException;

    DTOCargaFavoritos consultaFavoritos(DTOBelcorp dto) throws MareException;

    void insertaFavorito(DTOEntradaSeleccionarFuncionesFavoritas dtoESFF) throws MareException;

    DTOString insertaFavoritos(DTOFavoritos dto) throws MareException;

    DTOSalida obtieneFavoritosUsuario(DTOEntradaObtieneFuncion dtoe) throws MareException;
}