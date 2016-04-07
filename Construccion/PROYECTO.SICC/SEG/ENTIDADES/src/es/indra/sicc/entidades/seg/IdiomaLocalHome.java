package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.IdiomaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class IdiomaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public IdiomaLocal create(String codIdio, Boolean indIdioTrad, String codIsoIdio) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_IDIO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		IdiomaLocal local = new IdiomaLocal(oid, codIdio, indIdioTrad, codIsoIdio);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(IdiomaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(IdiomaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public IdiomaLocal findByPrimaryKey(Long  oid) {
		IdiomaLocal local = em.find(IdiomaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("IdiomaLocal.FindAll");
		return query.getResultList();
	}

	public IdiomaLocal findByCodigo(String codigo) {
		Query query=em.createNamedQuery("IdiomaLocal.FindByCodigo");
		query.setParameter(1, codigo);
		return (IdiomaLocal)(query.getSingleResult());
	}

}
