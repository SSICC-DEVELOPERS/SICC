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

import es.indra.sicc.entidades.inc.DescalificacionesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class DescalificacionesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public DescalificacionesLocal create(Date fecDesc, Long clieOidClie, Long copaOidParaGral, Long perdOidPeri, Long cadeOidCausDesc) throws MareException {
	    Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CESC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DescalificacionesLocal local = new DescalificacionesLocal(oid, fecDesc, clieOidClie, copaOidParaGral, perdOidPeri, cadeOidCausDesc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DescalificacionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DescalificacionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DescalificacionesLocal findByPrimaryKey(Long  oid) {
		DescalificacionesLocal local = (DescalificacionesLocal)em.find(DescalificacionesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("DescalificacionesLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("DescalificacionesLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
