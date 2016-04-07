package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.PlantillasComisionesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PlantillasComisionesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public PlantillasComisionesLocal create(Long codPlanComi, Long oidCanal) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_PLCO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PlantillasComisionesLocal local = new PlantillasComisionesLocal(oid, codPlanComi, oidCanal);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PlantillasComisionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PlantillasComisionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PlantillasComisionesLocal findByPrimaryKey(Long  oid) {
		PlantillasComisionesLocal local = (PlantillasComisionesLocal)em.find(PlantillasComisionesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

        
        public Collection findAll() {
           Query query=em.createNamedQuery("PlantillasComisionesLocal.FindAll");          
           return query.getResultList();
       }

}
