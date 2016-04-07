package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoPeriodoCorporativoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public TipoPeriodoCorporativoLocal create(String codigoTipoPeriodo, Long duracion, Long numeroPeriodosAnio) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_TIPE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoPeriodoCorporativoLocal local = new TipoPeriodoCorporativoLocal(oid, codigoTipoPeriodo, duracion, numeroPeriodosAnio);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoPeriodoCorporativoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoPeriodoCorporativoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoPeriodoCorporativoLocal findByPrimaryKey(Long oid) {
		TipoPeriodoCorporativoLocal local = (TipoPeriodoCorporativoLocal)em.find(TipoPeriodoCorporativoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	public Collection findAll() {
		Query query=em.createNamedQuery("TipoPeriodoCorporativoLocal.FindAll");
		return query.getResultList();
	}

	public TipoPeriodoCorporativoLocal findByUk(String codigo) {
		Query query=em.createNamedQuery("TipoPeriodoCorporativoLocal.FindByUk");
		query.setParameter(1, codigo);
		return (TipoPeriodoCorporativoLocal)(query.getSingleResult());
	}

}
