package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.ValoresArgumentosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ValoresArgumentosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public ValoresArgumentosLocal create(String valorArgumento, String descripcionValorArgumento, Long codigoArgumento) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_VAAR_SEQ");
		et.begin();
		ValoresArgumentosLocal local = new ValoresArgumentosLocal(oid, valorArgumento, descripcionValorArgumento, codigoArgumento);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ValoresArgumentosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ValoresArgumentosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ValoresArgumentosLocal findByPrimaryKey(Long  oid) {
		ValoresArgumentosLocal local = (ValoresArgumentosLocal)em.find(ValoresArgumentosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("ValoresArgumentosLocal.FindAll");          
            return query.getResultList();
        }

}
