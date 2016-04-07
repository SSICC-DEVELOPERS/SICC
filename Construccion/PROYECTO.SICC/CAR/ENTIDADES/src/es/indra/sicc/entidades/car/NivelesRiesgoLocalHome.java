package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.NivelesRiesgoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class NivelesRiesgoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public NivelesRiesgoLocal create(String cod_nive_ries) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_NIRE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		NivelesRiesgoLocal local = new NivelesRiesgoLocal(oid, cod_nive_ries);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(NivelesRiesgoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(NivelesRiesgoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public NivelesRiesgoLocal findByPrimaryKey(Long  oid) {
		NivelesRiesgoLocal local = (NivelesRiesgoLocal)em.find(NivelesRiesgoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("NivelesRiesgoLocal.FindAll");          
            return query.getResultList();
        }

	
}
