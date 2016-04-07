package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PuntajeProductosExigidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PuntajeProductosExigidosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PuntajeProductosExigidosLocal create(Double impMont, Long numUnid, Long numPunt, Long copaOidParaGral, Long pre2OidProdExig, Long socaOidSoliCabe) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PPEX_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PuntajeProductosExigidosLocal local = new PuntajeProductosExigidosLocal(oid, impMont, numUnid, numPunt, copaOidParaGral, pre2OidProdExig, socaOidSoliCabe);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PuntajeProductosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PuntajeProductosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PuntajeProductosExigidosLocal findByPrimaryKey(Long  oid) {
		PuntajeProductosExigidosLocal local = (PuntajeProductosExigidosLocal)em.find(PuntajeProductosExigidosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("PuntajeProductosExigidosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("PuntajeProductosExigidosLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
