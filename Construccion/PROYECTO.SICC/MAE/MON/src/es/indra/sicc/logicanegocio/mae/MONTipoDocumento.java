package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoDocumData;
import javax.ejb.EJBObject;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONTipoDocumento extends EJBObject 
{

public Hashtable insertar(MaeTipoDocumData maeTipoDocumData, Vector vector , HashMap userProperties) throws MareException, RemoteException;

public Vector query(MaeTipoDocumData maeTipoDocumFrom, MaeTipoDocumData maeTipoDocumTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;

public void remove(Vector MaeTipoDocumData ) throws MareException, RemoteException;

public void update(MaeTipoDocumData MaeTipoDocumData, Vector localizationLabels) throws MareException, RemoteException;

   //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010                
  DTOSalida obtenerTiposDocumentoPorSigla(DTOBelcorp DTOE) throws MareException, RemoteException;
    
}