package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.EstatusPedidoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstatusPedidoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public EstatusPedidoLocal create(String cod_esta) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_ESPE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstatusPedidoLocal local = new EstatusPedidoLocal(oid, cod_esta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstatusPedidoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstatusPedidoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstatusPedidoLocal findByPrimaryKey(Long  oid) {
		EstatusPedidoLocal local = (EstatusPedidoLocal)em.find(EstatusPedidoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("EstatusPedidoLocal.FindAll");          
            return query.getResultList();
        }

	
}
