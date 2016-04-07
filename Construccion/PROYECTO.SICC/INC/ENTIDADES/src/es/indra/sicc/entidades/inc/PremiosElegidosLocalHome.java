package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.sql.Date;

import es.indra.sicc.entidades.inc.PremiosElegidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PremiosElegidosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PremiosElegidosLocal create(Integer numPrem, Long clieOidClie, Long copaOidParaGral, Long panpOidParaNivePrem, Date fechaSistema) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PREL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PremiosElegidosLocal local = new PremiosElegidosLocal(oid, numPrem, clieOidClie, copaOidParaGral, panpOidParaNivePrem, fechaSistema);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PremiosElegidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PremiosElegidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PremiosElegidosLocal findByPrimaryKey(Long  oid) {
		PremiosElegidosLocal local = (PremiosElegidosLocal)em.find(PremiosElegidosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("PremiosElegidosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("PremiosElegidosLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
