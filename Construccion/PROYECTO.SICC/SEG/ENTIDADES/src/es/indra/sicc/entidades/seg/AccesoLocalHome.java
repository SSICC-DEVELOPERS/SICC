package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AccesoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public AccesoLocal create(String codigo, Long oidCanal, String indicador) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_ACCE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AccesoLocal local = new AccesoLocal(oid, codigo, oidCanal, indicador);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AccesoLocal findByPrimaryKey(Long  oid) {
		AccesoLocal local = em.find(AccesoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
	
	public Collection findAll() {
		Query query = em.createNamedQuery("AccesoLocal.FindAll");
		return query.getResultList();
	}

	
	public AccesoLocal findByClaveUnica(String codigo,Long oidCanal) {
		Query query=em.createNamedQuery("AccesoLocal.FindByClaveUnica");
		query.setParameter(1, codigo);
		query.setParameter(2, oidCanal);
		return (AccesoLocal)(query.getSingleResult());
	}

}
