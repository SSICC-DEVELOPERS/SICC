package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.PlantillasComisionesAccesoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PlantillasComisionesAccesoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public PlantillasComisionesAccesoLocal create(Long plcoOidPlanComi, Long acceOidAcce, Long oidCanal) throws MareException  {  
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_PLCA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PlantillasComisionesAccesoLocal local = new PlantillasComisionesAccesoLocal(oid, plcoOidPlanComi, acceOidAcce, oidCanal);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PlantillasComisionesAccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PlantillasComisionesAccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PlantillasComisionesAccesoLocal findByPrimaryKey(Long  oid) {
		PlantillasComisionesAccesoLocal local = (PlantillasComisionesAccesoLocal)em.find(PlantillasComisionesAccesoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
           Query query=em.createNamedQuery("PlantillasComisionesAccesoLocal.FindAll");          
           return query.getResultList();
       }
       
	public Collection findByPlantilla(Long oidPlantilla) {
		Query query=em.createNamedQuery("PlantillasComisionesAccesoLocal.FindByPlantilla");
		
		query.setParameter(1, oidPlantilla);

                return query.getResultList();
	}

	public PlantillasComisionesAccesoLocal findByUK(Long oidAcceso, Long oidPlanComision, Long oidCanal) {
		Query query=em.createNamedQuery("PlantillasComisionesAccesoLocal.FindByUK");
		
		query.setParameter(1, oidAcceso);

		query.setParameter(2, oidPlanComision);

		query.setParameter(3, oidCanal);

		return (PlantillasComisionesAccesoLocal)(query.getSingleResult());
	}

}
