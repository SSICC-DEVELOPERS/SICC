package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.ComisionesAccesoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesAccesoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesAccesoLocal create(Long acceso, Long comision, Long canal) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_COAC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesAccesoLocal local = new ComisionesAccesoLocal(oid, acceso, comision, canal);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesAccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesAccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesAccesoLocal findByPrimaryKey(Long  oid) {
		ComisionesAccesoLocal local = (ComisionesAccesoLocal)em.find(ComisionesAccesoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesAccesoLocal.FindAll");          
                return query.getResultList();
        }

	public Collection findbyComision(Long oidComision) {
		Query query=em.createNamedQuery("ComisionesAccesoLocal.FindbyComision");
		
		query.setParameter(1, oidComision);

                return query.getResultList();
	}

}
