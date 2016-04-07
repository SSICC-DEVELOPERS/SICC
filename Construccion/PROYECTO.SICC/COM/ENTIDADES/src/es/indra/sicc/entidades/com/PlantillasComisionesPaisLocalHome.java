package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.PlantillasComisionesPaisLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PlantillasComisionesPaisLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public PlantillasComisionesPaisLocal create(Long paisOidPais, Long plcoOidPlanComi) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_PLCP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PlantillasComisionesPaisLocal local = new PlantillasComisionesPaisLocal(oid, paisOidPais, plcoOidPlanComi);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PlantillasComisionesPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PlantillasComisionesPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PlantillasComisionesPaisLocal findByPrimaryKey(Long  oid) {
		PlantillasComisionesPaisLocal local = (PlantillasComisionesPaisLocal)em.find(PlantillasComisionesPaisLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("PlantillasComisionesPaisLocal.FindAll");          
                return query.getResultList();
        }

	public Collection findByPlantilla(Long oid) {
		Query query=em.createNamedQuery("PlantillasComisionesPaisLocal.FindByPlantilla");
		
		query.setParameter(1, oid);

                return query.getResultList();
	}

	public PlantillasComisionesPaisLocal findByUK(Long oidPlantillaComision, Long oidPais) {
		Query query=em.createNamedQuery("PlantillasComisionesPaisLocal.FindByUK");
		
		query.setParameter(1, oidPlantillaComision);

		query.setParameter(2, oidPais);

		return (PlantillasComisionesPaisLocal)(query.getSingleResult());
	}

}
