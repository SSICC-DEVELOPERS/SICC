package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.CalculoProductosExigidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class CalculoProductosExigidosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public CalculoProductosExigidosLocal create(Long perdOidPeri, Long pre2OidProdExig, Long clieOidClie, BigDecimal montoPedido, Integer unidadesPedido, Integer puntosPedido) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CPRE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CalculoProductosExigidosLocal local = new CalculoProductosExigidosLocal(oid, perdOidPeri, pre2OidProdExig, clieOidClie, montoPedido, unidadesPedido,  puntosPedido);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CalculoProductosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CalculoProductosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CalculoProductosExigidosLocal findByPrimaryKey(Long  oid) {
		CalculoProductosExigidosLocal local = (CalculoProductosExigidosLocal)em.find(CalculoProductosExigidosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("CalculoProductosExigidosLocal.FindAll");
                    return query.getResultList();
            }

	public CalculoProductosExigidosLocal findByUK(Long periodo, Long productoExigido, Long consultora) {
		Query query=em.createNamedQuery("CalculoProductosExigidosLocal.FindByUK");
		
		query.setParameter(1, periodo);

		query.setParameter(2, productoExigido);

		query.setParameter(3, consultora);

		return (CalculoProductosExigidosLocal)(query.getSingleResult());
	}

}
