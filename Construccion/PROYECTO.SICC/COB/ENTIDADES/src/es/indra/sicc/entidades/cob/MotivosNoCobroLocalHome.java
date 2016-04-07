package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.MotivosNoCobroLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MotivosNoCobroLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public MotivosNoCobroLocal create(String codigoMotivoNoCobro, String descripcionMotivoNoCobro, Long pais) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_MONO_SEQ");
		et.begin();
		MotivosNoCobroLocal local = new MotivosNoCobroLocal(oid, codigoMotivoNoCobro, descripcionMotivoNoCobro, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MotivosNoCobroLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MotivosNoCobroLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MotivosNoCobroLocal findByPrimaryKey(Long  oid) {
		MotivosNoCobroLocal local = (MotivosNoCobroLocal)em.find(MotivosNoCobroLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("MotivosNoCobroLocal.FindAll");          
            return query.getResultList();
        }

}
