package es.indra.sicc.logicanegocio.intsys;

import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;

public interface MONECMLocal extends EJBLocalObject  {

    DTOSalidaBatch tratarRegistroClientes(IRegistroSicc registro, InterfazInfo info) throws MareException;
}