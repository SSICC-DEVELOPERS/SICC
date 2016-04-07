package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.CodigosAprobacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CodigosAprobacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public CodigosAprobacionLocal create(String cod_apro) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_COAP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CodigosAprobacionLocal local = new CodigosAprobacionLocal(oid, cod_apro);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CodigosAprobacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CodigosAprobacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CodigosAprobacionLocal findByPrimaryKey(Long  oid) {
		CodigosAprobacionLocal local = (CodigosAprobacionLocal)em.find(CodigosAprobacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("CodigosAprobacionLocal.FindAll");          
            return query.getResultList();
        }

	
}
