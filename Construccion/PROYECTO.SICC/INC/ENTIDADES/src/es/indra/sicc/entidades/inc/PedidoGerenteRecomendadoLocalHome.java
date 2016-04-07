package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PedidoGerenteRecomendadoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PedidoGerenteRecomendadoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PedidoGerenteRecomendadoLocal create(Long clgeOidClieGere, Long clgrOidClieGereReco, Long perdOidPeri, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PEGR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PedidoGerenteRecomendadoLocal local = new PedidoGerenteRecomendadoLocal(oid, clgeOidClieGere, clgrOidClieGereReco, perdOidPeri, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PedidoGerenteRecomendadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PedidoGerenteRecomendadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PedidoGerenteRecomendadoLocal findByPrimaryKey(Long  oid) {
		PedidoGerenteRecomendadoLocal local = (PedidoGerenteRecomendadoLocal)em.find(PedidoGerenteRecomendadoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("PedidoGerenteRecomendadoLocal.FindAll");
                    return query.getResultList();
            }


	public PedidoGerenteRecomendadoLocal findByGerenteRecom(Long gerente, Long cliente, Long concurso, Long periodo) {
		Query query=em.createNamedQuery("PedidoGerenteRecomendadoLocal.FindByGerenteRecom");
		
		query.setParameter(1, gerente);

		query.setParameter(2, cliente);

		query.setParameter(3, concurso);

		query.setParameter(4, periodo);

		return (PedidoGerenteRecomendadoLocal)(query.getSingleResult());
	}

}
