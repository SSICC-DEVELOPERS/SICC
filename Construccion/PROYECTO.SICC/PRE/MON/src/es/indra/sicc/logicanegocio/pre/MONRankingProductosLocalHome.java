package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONRankingProductosLocalHome extends EJBLocalHome 
{
    MONRankingProductosLocal create() throws CreateException;
}