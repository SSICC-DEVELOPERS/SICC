package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreIndicCuadrData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONIndicadorCuadreBean implements SessionBean {
    private SessionContext _context;

    public void ejbCreate() {
    }

    public void setSessionContext(SessionContext context) throws EJBException {
        _context = context;
    }

    public void ejbRemove() throws EJBException {
    }

    public void ejbActivate() throws EJBException {
    }

    public void ejbPassivate() throws EJBException {
    }

    public Vector query(PreIndicCuadrData preIndicCuadrFrom, PreIndicCuadrData preIndicCuadrTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOIndicadorCuadre daoIndicadorCuadre = new DAOIndicadorCuadre();
        
        return daoIndicadorCuadre.query(preIndicCuadrFrom, preIndicCuadrTo, userProperties, pageCount, pageSize); 
    }

    public Vector query(PreIndicCuadrData preIndicCuadrFrom, PreIndicCuadrData preIndicCuadrTo, HashMap userProperties) throws MareException
    {
        DAOIndicadorCuadre daoIndicadorCuadre = new DAOIndicadorCuadre();
    
        return daoIndicadorCuadre.query(preIndicCuadrFrom, preIndicCuadrTo,  userProperties) ;
    }
}
