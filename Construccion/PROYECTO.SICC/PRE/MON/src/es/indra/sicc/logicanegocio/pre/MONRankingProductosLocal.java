package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.pre.DTORankingCuadre;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.mare.common.exception.MareException;

public interface MONRankingProductosLocal extends EJBLocalObject 
{
    DTOCabeceraSolicitud agregarProductosGrupo(DTORankingCuadre DTOE) throws MareException;

    DTOCabeceraSolicitud eliminarProductosGrupo(DTORankingCuadre DTOE) throws MareException;
}