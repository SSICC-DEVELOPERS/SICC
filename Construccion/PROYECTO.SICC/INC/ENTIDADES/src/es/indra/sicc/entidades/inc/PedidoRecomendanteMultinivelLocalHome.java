package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PedidoRecomendanteMultinivelLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PedidoRecomendanteMultinivelLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PedidoRecomendanteMultinivelLocal create(Long periodo, Long recomendante) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PER2_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PedidoRecomendanteMultinivelLocal local = new PedidoRecomendanteMultinivelLocal(oid, periodo, recomendante);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PedidoRecomendanteMultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PedidoRecomendanteMultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PedidoRecomendanteMultinivelLocal findByPrimaryKey(Long  oid) {
		PedidoRecomendanteMultinivelLocal local = (PedidoRecomendanteMultinivelLocal)em.find(PedidoRecomendanteMultinivelLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("PedidoRecomendanteMultinivelLocal.FindAll");
                    return query.getResultList();
            }

}
