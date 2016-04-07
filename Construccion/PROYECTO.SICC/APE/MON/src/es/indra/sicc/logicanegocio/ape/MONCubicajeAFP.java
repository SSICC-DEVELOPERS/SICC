package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTODatosAgrupacion;
import es.indra.sicc.dtos.ape.DTODatosPallets;
import es.indra.sicc.dtos.ape.DTOImpresionFP;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONCubicajeAFP extends EJBObject  {
    DTOSalida buscarListaPicadoCubicaje(DTOImpresionFP dtoE) throws MareException, RemoteException;

    DTOSalida buscarListaDatosPallet(DTOOID dtoE) throws MareException, RemoteException;

    void guardarListaDatosPallets(DTODatosPallets dtoE) throws RemoteException, MareException;

    DTOSalida verDatosAgrupacion(DTODatosAgrupacion dtoE) throws MareException, RemoteException;


}