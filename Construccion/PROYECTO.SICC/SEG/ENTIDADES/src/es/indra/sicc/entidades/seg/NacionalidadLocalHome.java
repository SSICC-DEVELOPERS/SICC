package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.NacionalidadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class NacionalidadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public NacionalidadLocal create(String codNaci) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_SNON_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		NacionalidadLocal local = new NacionalidadLocal(oid, codNaci);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(NacionalidadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(NacionalidadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public NacionalidadLocal findByPrimaryKey(Long  oid) {
		NacionalidadLocal local = (NacionalidadLocal)em.find(NacionalidadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("NacionalidadLocal.FindAll");
		return query.getResultList();
	}

	public NacionalidadLocal findByUk(String codNacio) {
		Query query=em.createNamedQuery("NacionalidadLocal.FindByUk");
		query.setParameter(1, codNacio);
		return (NacionalidadLocal)(query.getSingleResult());
	}

}
