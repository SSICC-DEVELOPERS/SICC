package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PedidosConcursoRecomendadaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PedidosConcursoRecomendadaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PedidosConcursoRecomendadaLocal create(Long perdOidPeri, Long copaOidParaGral, Long clr3OidClieRete, Long clreOidClieRedo, Long clieOidClie) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PECR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PedidosConcursoRecomendadaLocal local = new PedidosConcursoRecomendadaLocal(oid, perdOidPeri, copaOidParaGral, clr3OidClieRete, clreOidClieRedo, clieOidClie);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PedidosConcursoRecomendadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PedidosConcursoRecomendadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PedidosConcursoRecomendadaLocal findByPrimaryKey(Long  oid) {
		PedidosConcursoRecomendadaLocal local = (PedidosConcursoRecomendadaLocal)em.find(PedidosConcursoRecomendadaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("AccesoLocal.FindAll");
                    return query.getResultList();
            }

	public PedidosConcursoRecomendadaLocal findByUKGerente(Long recomendante, Long concurso, Long recomendado, Long cliente, Long periodo) {
		Query query=em.createNamedQuery("PedidosConcursoRecomendadaLocal.FindByUKGerente");
		
		query.setParameter(1, recomendante);

		query.setParameter(2, concurso);

		query.setParameter(3, recomendado);

		query.setParameter(4, cliente);

		query.setParameter(5, periodo);

		return (PedidosConcursoRecomendadaLocal)(query.getSingleResult());
	}

	public PedidosConcursoRecomendadaLocal findRecomendante(Long recomendante, Long concurso, Long periodo) {
		Query query=em.createNamedQuery("PedidosConcursoRecomendadaLocal.FindRecomendante");
		
		query.setParameter(1, recomendante);

		query.setParameter(2, concurso);

		query.setParameter(3, periodo);

		return (PedidosConcursoRecomendadaLocal)(query.getSingleResult());
	}

	public PedidosConcursoRecomendadaLocal findByUKConsultora(Long recomendante, Long concurso, Long recomendado, Long periodo) {
		Query query=em.createNamedQuery("PedidosConcursoRecomendadaLocal.FindByUKConsultora");
		
		query.setParameter(1, recomendante);

		query.setParameter(2, concurso);

		query.setParameter(3, recomendado);

		query.setParameter(4, periodo);

		return (PedidosConcursoRecomendadaLocal)(query.getSingleResult());
	}

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("PedidosConcursoRecomendadaLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
