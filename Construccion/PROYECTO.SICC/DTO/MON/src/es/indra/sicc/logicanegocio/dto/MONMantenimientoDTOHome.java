package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.dto.*;
import es.indra.sicc.util.*;

public interface MONMantenimientoDTOHome extends EJBHome  {
	MONMantenimientoDTO create() throws RemoteException, CreateException;
}  