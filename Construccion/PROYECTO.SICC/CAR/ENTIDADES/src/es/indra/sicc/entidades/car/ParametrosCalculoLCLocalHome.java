package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.ParametrosCalculoLCLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosCalculoLCLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public ParametrosCalculoLCLocal create(Long  oidParaCalcLc) throws MareException {
                oidParaCalcLc = SecuenciadorOID.obtenerSiguienteValor("CAR_PCLC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosCalculoLCLocal local = new ParametrosCalculoLCLocal(oidParaCalcLc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosCalculoLCLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosCalculoLCLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosCalculoLCLocal findByPrimaryKey(Long  oidParaCalcLc) {
		ParametrosCalculoLCLocal local = (ParametrosCalculoLCLocal)em.find(ParametrosCalculoLCLocal.class, oidParaCalcLc);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("ParametrosCalculoLCLocal.FindAll");          
            return query.getResultList();
        }

	public Collection findByNivelRiesgo(Long nivelRiesgo) {
		Query query=em.createNamedQuery("ParametrosCalculoLCLocal.FindByNivelRiesgo");
		
		query.setParameter(1, nivelRiesgo);

                return query.getResultList();
	}

}
