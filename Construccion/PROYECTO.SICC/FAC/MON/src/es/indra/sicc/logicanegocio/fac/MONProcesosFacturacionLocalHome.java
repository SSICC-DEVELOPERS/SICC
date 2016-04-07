package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONProcesosFacturacionLocalHome extends EJBLocalHome 
{
    MONProcesosFacturacionLocal create() throws CreateException;
}