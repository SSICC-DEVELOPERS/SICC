package es.indra.sicc.entidades.mae;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import es.indra.sicc.cmn.negocio.auditoria.EJBLocalHomeSICCAuditable;
import es.indra.mare.common.exception.MareException;
import java.util.Vector;
import java.util.Collection;

public interface MaestroProductosLocalHome extends EJBLocalHomeSICCAuditable {
	MaestroProductosLocal create(Long paramOid, String paramCodSAP, Long paramPais, Long marcaProducto) throws CreateException;

	MaestroProductosLocal create(String paramCodSAP, Long paramPais, Vector valores, Long marcaProducto) throws MareException, CreateException;

	MaestroProductosLocal findByPrimaryKey(MaestroProductosPK primaryKey) throws FinderException;

	MaestroProductosLocal findByUK(Long pais, String codigoSAP) throws FinderException;
}