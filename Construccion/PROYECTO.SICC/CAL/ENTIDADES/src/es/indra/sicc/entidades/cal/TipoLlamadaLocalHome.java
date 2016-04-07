package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.TipoLlamadaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoLlamadaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public TipoLlamadaLocal create() throws MareException {
	    Long oid=SecuenciadorOID.obtenerSiguienteValor("CAL_TILL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoLlamadaLocal local = new TipoLlamadaLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoLlamadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoLlamadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoLlamadaLocal findByPrimaryKey(Long  oid) {
		TipoLlamadaLocal local = (TipoLlamadaLocal)em.find(TipoLlamadaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        public Collection findAll() {
                Query query=em.createNamedQuery("TipoLlamadaLocal.FindAll");
                return query.getResultList();
        }

	
}
