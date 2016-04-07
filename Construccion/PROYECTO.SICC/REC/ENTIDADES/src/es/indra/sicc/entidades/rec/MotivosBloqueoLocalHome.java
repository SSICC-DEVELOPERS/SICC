package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.MotivosBloqueoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MotivosBloqueoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public MotivosBloqueoLocal create(String motivoBloqueo, Long pais) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_MOBL_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                MotivosBloqueoLocal local = new MotivosBloqueoLocal(oid, motivoBloqueo, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MotivosBloqueoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MotivosBloqueoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MotivosBloqueoLocal findByPrimaryKey(Long  oid) {
		MotivosBloqueoLocal local = (MotivosBloqueoLocal)em.find(MotivosBloqueoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MotivosBloqueoLocal.FindAll");
		
		return (query.getResultList());
	}

}
