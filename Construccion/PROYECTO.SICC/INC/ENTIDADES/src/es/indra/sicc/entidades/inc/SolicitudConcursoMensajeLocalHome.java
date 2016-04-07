package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.SolicitudConcursoMensajeLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SolicitudConcursoMensajeLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public SolicitudConcursoMensajeLocal create(Long valBuzoMens, Long socaOidSoliCabe, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_SCMS_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SolicitudConcursoMensajeLocal local = new SolicitudConcursoMensajeLocal(oid, valBuzoMens, socaOidSoliCabe, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SolicitudConcursoMensajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SolicitudConcursoMensajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SolicitudConcursoMensajeLocal findByPrimaryKey(Long  oid) {
		SolicitudConcursoMensajeLocal local = (SolicitudConcursoMensajeLocal)em.find(SolicitudConcursoMensajeLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("SolicitudConcursoMensajeLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("SolicitudConcursoMensajeLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
