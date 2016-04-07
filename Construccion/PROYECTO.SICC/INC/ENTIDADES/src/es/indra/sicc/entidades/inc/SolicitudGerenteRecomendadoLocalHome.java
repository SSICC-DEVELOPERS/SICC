package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.SolicitudGerenteRecomendadoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SolicitudGerenteRecomendadoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public SolicitudGerenteRecomendadoLocal create(Long clieOidClie, Long clieOidClieGere, Long socaOidSoliCabe, Long copaOidParaGral, Long perdOidPeri) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_SOGR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SolicitudGerenteRecomendadoLocal local = new SolicitudGerenteRecomendadoLocal(oid, clieOidClie, clieOidClieGere, socaOidSoliCabe, copaOidParaGral, perdOidPeri);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SolicitudGerenteRecomendadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SolicitudGerenteRecomendadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SolicitudGerenteRecomendadoLocal findByPrimaryKey(Long  oid) {
		SolicitudGerenteRecomendadoLocal local = (SolicitudGerenteRecomendadoLocal)em.find(SolicitudGerenteRecomendadoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("SolicitudGerenteRecomendadoLocal.FindAll");
                    return query.getResultList();
            }


	public SolicitudGerenteRecomendadoLocal findByClienteGerente(Long gerente, Long cliente, Long concurso, Long solicitud) {
		Query query=em.createNamedQuery("SolicitudGerenteRecomendadoLocal.FindByClienteGerente");
		
		query.setParameter(1, gerente);

		query.setParameter(2, cliente);

		query.setParameter(3, concurso);

		query.setParameter(4, solicitud);

		return (SolicitudGerenteRecomendadoLocal)(query.getSingleResult());
	}

}
