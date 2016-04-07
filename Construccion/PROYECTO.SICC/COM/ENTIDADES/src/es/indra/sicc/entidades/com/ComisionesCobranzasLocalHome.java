package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.ComisionesCobranzasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesCobranzasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesCobranzasLocal create(Long comision, Long tipoParticipante) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_COCO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesCobranzasLocal local = new ComisionesCobranzasLocal(oid, comision, tipoParticipante);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesCobranzasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesCobranzasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesCobranzasLocal findByPrimaryKey(Long  oid) {
		ComisionesCobranzasLocal local = (ComisionesCobranzasLocal)em.find(ComisionesCobranzasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesCobranzasLocal.FindAll");          
                return query.getResultList();
        }

	public Collection findByComision(Long oidComision) {
		Query query=em.createNamedQuery("ComisionesCobranzasLocal.FindByComision");
		
		query.setParameter(1, oidComision);

                return query.getResultList();
	}

}
