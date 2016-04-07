package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.AmbitoGeograficoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AmbitoGeograficoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public AmbitoGeograficoLocal create(Long zsgvOidSubgVent, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_TERC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AmbitoGeograficoLocal local = new AmbitoGeograficoLocal(oid, zsgvOidSubgVent, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AmbitoGeograficoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AmbitoGeograficoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AmbitoGeograficoLocal findByPrimaryKey(Long  oid) {
		AmbitoGeograficoLocal local = (AmbitoGeograficoLocal)em.find(AmbitoGeograficoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("AmbitoGeograficoLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("AmbitoGeograficoLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

                return query.getResultList();
	}

}
