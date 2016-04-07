package es.indra.sicc.cmn.negocio.auditoria;

import java.util.NoSuchElementException;

import javax.ejb.EJBLocalObject;


public interface EJBLocalObjectSICCAuditable extends EJBLocalObject {
    //public void auditar (String ipCliente, String programa);
    Object getObject(String atributo);

    void setObject(String atributo, Object valor);
}
