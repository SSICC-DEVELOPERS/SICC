package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ParticipantesConcursoDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParticipantesConcursoDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ParticipantesConcursoDetalleLocal create(Long oidCabecera, Long tipoCliente) throws MareException {    
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PAC3_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParticipantesConcursoDetalleLocal local = new ParticipantesConcursoDetalleLocal(oid, oidCabecera, tipoCliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParticipantesConcursoDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParticipantesConcursoDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParticipantesConcursoDetalleLocal findByPrimaryKey(Long  oid) {
		ParticipantesConcursoDetalleLocal local = (ParticipantesConcursoDetalleLocal)em.find(ParticipantesConcursoDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("ParticipantesConcursoDetalleLocal.FindAll");
                    return query.getResultList();
            }

}
