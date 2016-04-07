package es.indra.sicc.cmn.negocio.print;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface SpoolManagerLocalHome extends EJBLocalHome 
{
    SpoolManagerLocal create() throws CreateException;
}