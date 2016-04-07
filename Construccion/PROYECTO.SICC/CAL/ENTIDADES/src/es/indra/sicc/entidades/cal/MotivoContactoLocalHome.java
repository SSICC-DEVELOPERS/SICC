package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.MotivoContactoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MotivoContactoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public MotivoContactoLocal create(String cod_moti) throws  MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_MOCO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MotivoContactoLocal local = new MotivoContactoLocal(oid, cod_moti);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MotivoContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MotivoContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MotivoContactoLocal findByPrimaryKey(Long  oid) {
		MotivoContactoLocal local = (MotivoContactoLocal)em.find(MotivoContactoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
         public Collection findAll() {
                Query query=em.createNamedQuery("MotivoContactoLocal.FindAll");
                return query.getResultList();
        }    

	
}
