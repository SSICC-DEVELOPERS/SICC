package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.TipoGestionDelClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoGestionDelClienteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public TipoGestionDelClienteLocal create(String cod_gest, String val_desc) throws MareException {
	    Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_TGCL_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoGestionDelClienteLocal local = new TipoGestionDelClienteLocal(oid, cod_gest, val_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoGestionDelClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoGestionDelClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoGestionDelClienteLocal findByPrimaryKey(Long  oid) {
		TipoGestionDelClienteLocal local = (TipoGestionDelClienteLocal)em.find(TipoGestionDelClienteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

        public Collection findAll() {
                Query query=em.createNamedQuery("TipoGestionDelClienteLocal.FindAll");
                return query.getResultList();
        }
}
