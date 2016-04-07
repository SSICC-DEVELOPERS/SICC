package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.TipoEstadoContactoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoEstadoContactoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public TipoEstadoContactoLocal create(String cod_esta) throws  MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_TECO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoEstadoContactoLocal local = new TipoEstadoContactoLocal(oid, cod_esta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoEstadoContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoEstadoContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoEstadoContactoLocal findByPrimaryKey(Long  oid) {
		TipoEstadoContactoLocal local = (TipoEstadoContactoLocal)em.find(TipoEstadoContactoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        public Collection findAll() {
                Query query=em.createNamedQuery("TipoEstadoContactoLocal.FindAll");
                return query.getResultList();
       }

	
}
