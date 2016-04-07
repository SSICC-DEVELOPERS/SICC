package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.SolicitudConcursoPuntajeLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SolicitudConcursoPuntajeLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public SolicitudConcursoPuntajeLocal create(Long copaOidParaGral, Long socaOidSoliCabe, Long perdOidPeri, Long clieOidClie, Long gerente) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_SOCP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SolicitudConcursoPuntajeLocal local = new SolicitudConcursoPuntajeLocal(oid, copaOidParaGral, socaOidSoliCabe, perdOidPeri, clieOidClie, gerente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SolicitudConcursoPuntajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SolicitudConcursoPuntajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SolicitudConcursoPuntajeLocal findByPrimaryKey(Long  oid) {
		SolicitudConcursoPuntajeLocal local = (SolicitudConcursoPuntajeLocal)em.find(SolicitudConcursoPuntajeLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("SolicitudConcursoPuntajeLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByUK(Long oidConcurso, Long oidPeriodo, Long oidSolicitud, Long oidCliente) {
		Query query=em.createNamedQuery("SolicitudConcursoPuntajeLocal.FindByUK");
		
		query.setParameter(1, oidConcurso);

		query.setParameter(2, oidPeriodo);

		query.setParameter(3, oidSolicitud);

		query.setParameter(4, oidCliente);

                return query.getResultList();
	}

	public Collection findByUKGerente(Long oidConcurso, Long oidPeriodo, Long oidSolicitud, Long oidCliente, Long oidGerente) {
		Query query=em.createNamedQuery("SolicitudConcursoPuntajeLocal.FindByUKGerente");
		
		query.setParameter(1, oidConcurso);

		query.setParameter(2, oidPeriodo);

		query.setParameter(3, oidSolicitud);

		query.setParameter(4, oidCliente);

		query.setParameter(5, oidGerente);

                return query.getResultList();
	}

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("SolicitudConcursoPuntajeLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
