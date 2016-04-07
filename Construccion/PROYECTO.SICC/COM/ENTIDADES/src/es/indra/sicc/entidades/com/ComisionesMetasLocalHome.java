package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.ComisionesMetasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesMetasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesMetasLocal create(Long perdOidPeri, Long comiOidComi, Long ctsuOidClieTipoSubt, Double impCalc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_COME_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesMetasLocal local = new ComisionesMetasLocal(oid, perdOidPeri, comiOidComi, ctsuOidClieTipoSubt, impCalc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesMetasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesMetasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesMetasLocal findByPrimaryKey(Long  oid) {
		ComisionesMetasLocal local = (ComisionesMetasLocal)em.find(ComisionesMetasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesMetasLocal.FindAll");          
                return query.getResultList();
        }

	public ComisionesMetasLocal findByUk(Long oidComision, Long oidPeriodo, Long oidTipoSubtipo) {
		Query query=em.createNamedQuery("ComisionesMetasLocal.FindByUk");
		
		query.setParameter(1, oidComision);

		query.setParameter(2, oidPeriodo);

		query.setParameter(3, oidTipoSubtipo);

		return (ComisionesMetasLocal)(query.getSingleResult());
	}

}
