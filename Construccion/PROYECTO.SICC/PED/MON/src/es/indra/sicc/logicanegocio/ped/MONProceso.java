package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedGrupoProceData;
import es.indra.belcorp.mso.PedProceData;
import es.indra.belcorp.mso.PedProceViewData;
import es.indra.belcorp.mso.PedProgrData;
import es.indra.belcorp.mso.PedSubtiPosicViewData;
import es.indra.belcorp.mso.PedTipoPosicData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONProceso extends EJBObject {
    Vector query(PedGrupoProceData pedGrupoProceFrom, 
                 PedGrupoProceData pedGrupoProceTo, HashMap userProperties) throws MareException, 
            RemoteException;

    Vector query(PedProgrData pedProgrFrom, PedProgrData pedProgrTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(PedTipoPosicData pedTipoPosicFrom, 
                 PedTipoPosicData pedTipoPosicTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(PedSubtiPosicViewData pedSubtiPosicViewFrom, 
                 PedSubtiPosicViewData pedSubtiPosicViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(PedProceViewData pedProceViewFrom, 
                 PedProceViewData pedProceViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarProceso(PedProceData pedProce, Vector localizationLabels, 
                             HashMap userProperties) throws MareException, 
                                                            RemoteException;

    Vector query(PedProceData pedProceFrom, PedProceData pedProceTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(PedProceData pedProce, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
