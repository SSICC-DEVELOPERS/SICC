package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.fac.DTOFACCabeceraDocContable;
import es.indra.sicc.dtos.fac.DTOFACConsultaFacturas;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import java.sql.Date;
import es.indra.sicc.dtos.fac.DTOFACReasignarNumeroDocContable;

public interface MONReversionFACLocal extends EJBLocalObject 
{
    void revertirFacturacion(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion, String user) throws MareException;

    void reasignarNumeroDocumentoContable(DTOOIDs cabecerasDC) throws MareException;

    void eliminarMensajeProductoFueraDocumentoLegal(DTOFACCabeceraDocContable dtoDocContable) throws MareException;

    void desasignarNumeroDocumentoContable(DTOOIDs cabecerasDC) throws MareException;

    DTOSalida consultarFacturas(DTOFACConsultaFacturas dtoE) throws MareException;

    void revertirFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud) throws MareException;

  void revertirFacturacionOffLine(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion, String user) throws MareException;

    void actualizoAcumulado(Long subAcceso, Long tipoSoliPais, Date fecProg, Long oidZona) throws MareException;

  DTOFACReasignarNumeroDocContable reasignarNumeroDocumentoContableAsignar(DTOFACReasignarNumeroDocContable dtoFacReasignar) throws MareException;

  void reasignarNumeroDocumentoContableConfirmar(DTOFACReasignarNumeroDocContable dtoFacReasignar) throws  Exception, MareException;


}