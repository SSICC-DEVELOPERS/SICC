package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.SolicitudConcursoRecomendadasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SolicitudConcursoRecomendadasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public SolicitudConcursoRecomendadasLocal create(Long copaOidParaGral, Long socaOidSoliCabe, Long clieOidClie, Long perdOidPeri, Long gerente) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_SOCR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SolicitudConcursoRecomendadasLocal local = new SolicitudConcursoRecomendadasLocal(oid, copaOidParaGral, socaOidSoliCabe, clieOidClie, perdOidPeri, gerente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SolicitudConcursoRecomendadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SolicitudConcursoRecomendadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SolicitudConcursoRecomendadasLocal findByPrimaryKey(Long  oid) {
		SolicitudConcursoRecomendadasLocal local = (SolicitudConcursoRecomendadasLocal)em.find(SolicitudConcursoRecomendadasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("SolicitudConcursoRecomendadasLocal.FindAll");
                    return query.getResultList();
            }

	public SolicitudConcursoRecomendadasLocal findByUKConGerente(Long concurso, Long solicitud, Long gerente) {
		Query query=em.createNamedQuery("SolicitudConcursoRecomendadasLocal.FindByUKConGerente");
		
		query.setParameter(1, concurso);

		query.setParameter(2, solicitud);

		query.setParameter(3, gerente);

		return (SolicitudConcursoRecomendadasLocal)(query.getSingleResult());
	}

	public SolicitudConcursoRecomendadasLocal findByUKSinGerente(Long concurso, Long solicitud) {
		Query query=em.createNamedQuery("SolicitudConcursoRecomendadasLocal.FindByUKSinGerente");
		
		query.setParameter(1, concurso);

		query.setParameter(2, solicitud);

		return (SolicitudConcursoRecomendadasLocal)(query.getSingleResult());
	}

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("SolicitudConcursoRecomendadasLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
