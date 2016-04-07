package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.AsignacionCobranzaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AsignacionCobranzaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public AsignacionCobranzaLocal create(Long pais, Long datosMovimientosCCC, Long sociedad, Long cartera) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_ASCO_SEQ");
		et.begin();
		AsignacionCobranzaLocal local = new AsignacionCobranzaLocal(oid, pais, datosMovimientosCCC, sociedad, cartera);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AsignacionCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AsignacionCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AsignacionCobranzaLocal findByPrimaryKey(Long  oid) {
		AsignacionCobranzaLocal local = (AsignacionCobranzaLocal)em.find(AsignacionCobranzaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("AsignacionCobranzaLocal.FindAll");          
            return query.getResultList();
        }

}
