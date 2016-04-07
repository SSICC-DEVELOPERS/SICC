package es.indra.sicc.entidades.ccc;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import java.util.Collection;

public interface CuponesTramiteDepuracionLocalHome extends EJBLocalHome  {
	CuponesTramiteDepuracionLocal create() throws CreateException;

	CuponesTramiteDepuracionLocal findByPrimaryKey(Long primaryKey) throws FinderException;

	Collection findAll() throws FinderException;
}