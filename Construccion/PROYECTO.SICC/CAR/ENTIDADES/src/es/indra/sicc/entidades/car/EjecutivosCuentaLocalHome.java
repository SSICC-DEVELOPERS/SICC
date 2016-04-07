package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.EjecutivosCuentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EjecutivosCuentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public EjecutivosCuentaLocal create(Long pais_oid_pais, Long cod_ejec_cuen) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_EJCU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EjecutivosCuentaLocal local = new EjecutivosCuentaLocal(oid, pais_oid_pais, cod_ejec_cuen);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EjecutivosCuentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EjecutivosCuentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EjecutivosCuentaLocal findByPrimaryKey(Long  oid) {
		EjecutivosCuentaLocal local = (EjecutivosCuentaLocal)em.find(EjecutivosCuentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("EjecutivosCuentaLocal.FindAll");          
            return query.getResultList();
        }

	
}
