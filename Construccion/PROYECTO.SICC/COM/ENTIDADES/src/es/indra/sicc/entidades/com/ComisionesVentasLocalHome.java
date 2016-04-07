package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.ComisionesVentasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesVentasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesVentasLocal create(Long comision, Long formula) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_COVE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesVentasLocal local = new ComisionesVentasLocal(oid, comision, formula);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesVentasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesVentasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesVentasLocal findByPrimaryKey(Long  oid) {
		ComisionesVentasLocal local = (ComisionesVentasLocal)em.find(ComisionesVentasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesVentasLocal.FindAll");          
                return query.getResultList();
        }

	public ComisionesVentasLocal findByUK(Long oidComision) {
		Query query=em.createNamedQuery("ComisionesVentasLocal.FindByUK");
		
		query.setParameter(1, oidComision);

		return (ComisionesVentasLocal)(query.getSingleResult());
	}

}
