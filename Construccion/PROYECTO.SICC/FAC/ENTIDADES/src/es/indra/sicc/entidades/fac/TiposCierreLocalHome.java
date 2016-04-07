package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.TiposCierreLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class TiposCierreLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public TiposCierreLocal create(String codigo) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_TCIE_SEQ");
		TiposCierreLocal local = new TiposCierreLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TiposCierreLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TiposCierreLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TiposCierreLocal findByPrimaryKey(Long  oid) {
		TiposCierreLocal local = (TiposCierreLocal)em.find(TiposCierreLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
                Query query=em.createNamedQuery("TiposCierreLocal.FindAll");
                return (query.getResultList());
        }


	
}
