package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.PrecioEnviaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PrecioEnviaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public PrecioEnviaLocal create(String codPrecioEnvia)throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_PENV_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                PrecioEnviaLocal local = new PrecioEnviaLocal(oid, codPrecioEnvia);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PrecioEnviaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PrecioEnviaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PrecioEnviaLocal findByPrimaryKey(Long  oid) {
		PrecioEnviaLocal local = (PrecioEnviaLocal)em.find(PrecioEnviaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("PrecioEnviaLocal.FindAll");
		
		return (query.getResultList());
	}

}
