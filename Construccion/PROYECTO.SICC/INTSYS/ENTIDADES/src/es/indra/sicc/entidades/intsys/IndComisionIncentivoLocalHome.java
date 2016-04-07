package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.IndComisionIncentivoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class IndComisionIncentivoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public IndComisionIncentivoLocal create(String codigo) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_DCOI_SEQ");
		IndComisionIncentivoLocal local = new IndComisionIncentivoLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(IndComisionIncentivoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(IndComisionIncentivoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public IndComisionIncentivoLocal findByPrimaryKey(Long  oid) {
		IndComisionIncentivoLocal local = em.find(IndComisionIncentivoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("IndComisionIncentivoLocal.FindAll");
		return query.getResultList();
	}

}
