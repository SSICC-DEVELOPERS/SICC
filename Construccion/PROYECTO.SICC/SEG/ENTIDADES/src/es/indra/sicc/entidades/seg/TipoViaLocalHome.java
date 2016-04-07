package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.TipoViaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoViaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public TipoViaLocal create(String codigoTipoVia, String descAbreTipoVia) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_TIVI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoViaLocal local = new TipoViaLocal(oid, codigoTipoVia, descAbreTipoVia);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoViaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoViaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoViaLocal findByPrimaryKey(Long  oid) {
		TipoViaLocal local = (TipoViaLocal)em.find(TipoViaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public TipoViaLocal findByUK(String codigo) {
		Query query=em.createNamedQuery("TipoViaLocal.FindByUK");
		query.setParameter(1, codigo);
		return (TipoViaLocal)(query.getSingleResult());
	}

	public Collection findAll() {
		Query query=em.createNamedQuery("TipoViaLocal.FindAll");
		return query.getResultList();
	}
}
