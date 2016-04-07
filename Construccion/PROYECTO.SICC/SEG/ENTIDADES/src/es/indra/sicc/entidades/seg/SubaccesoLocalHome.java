package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SubaccesoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public SubaccesoLocal create(String codigo, Long oidAcceso) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_SBAC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SubaccesoLocal local = new SubaccesoLocal(oid, codigo, oidAcceso);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SubaccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SubaccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SubaccesoLocal findByPrimaryKey(Long  oid) {
		SubaccesoLocal local = em.find(SubaccesoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public SubaccesoLocal findByUK(String codigo,Long oidAcceso) {
		Query query=em.createNamedQuery("SubaccesoLocal.FindByUK");
		query.setParameter(1, codigo);
		query.setParameter(2, oidAcceso);
		return (SubaccesoLocal)(query.getSingleResult());
	}
	
	public Collection findAll() {
		Query query=em.createNamedQuery("SubaccesoLocal.FindAll");
		return query.getResultList();
	}

}
