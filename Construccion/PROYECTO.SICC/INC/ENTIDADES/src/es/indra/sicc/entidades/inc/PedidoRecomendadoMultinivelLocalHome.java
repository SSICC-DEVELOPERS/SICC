package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PedidoRecomendadoMultinivelLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PedidoRecomendadoMultinivelLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PedidoRecomendadoMultinivelLocal create(Long periodo, Long clierecomendado)  throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PERM_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PedidoRecomendadoMultinivelLocal local = new PedidoRecomendadoMultinivelLocal(oid, periodo, clierecomendado);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PedidoRecomendadoMultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PedidoRecomendadoMultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PedidoRecomendadoMultinivelLocal findByPrimaryKey(Long  oid) {
		PedidoRecomendadoMultinivelLocal local = (PedidoRecomendadoMultinivelLocal)em.find(PedidoRecomendadoMultinivelLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("PedidoRecomendadoMultinivelLocal.FindAll");
                    return query.getResultList();
            }

}
