package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.CicloVidaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CicloVidaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
    
	public CicloVidaLocal create(String cod_cicl_vida) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_CIVI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CicloVidaLocal local = new CicloVidaLocal(oid, cod_cicl_vida);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CicloVidaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CicloVidaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CicloVidaLocal findByPrimaryKey(Long  oid) {
		CicloVidaLocal local = (CicloVidaLocal)em.find(CicloVidaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public CicloVidaLocal findByUK(String codigoCicloVida) {
		Query query=em.createNamedQuery("CicloVidaLocal.FindByUK");
		
		query.setParameter(1, codigoCicloVida);

		return (CicloVidaLocal)(query.getSingleResult());
	}

}
