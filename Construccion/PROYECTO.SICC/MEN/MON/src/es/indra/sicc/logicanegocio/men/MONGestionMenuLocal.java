package es.indra.sicc.logicanegocio.men;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.dtos.men.DTOSFormato;
import es.indra.mare.common.exception.MareException;

public interface MONGestionMenuLocal extends EJBLocalObject 
{
    DTOSFormato cargaformatosSesion(DTOPais dtoe) throws MareException;
}