package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.PlantillasComisionesMarcaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PlantillasComisionesMarcaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public PlantillasComisionesMarcaLocal create(Long marcOidMarc, Long plcoOidPlanComi) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_PLCM_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PlantillasComisionesMarcaLocal local = new PlantillasComisionesMarcaLocal(oid, marcOidMarc, plcoOidPlanComi);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PlantillasComisionesMarcaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PlantillasComisionesMarcaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PlantillasComisionesMarcaLocal findByPrimaryKey(Long  oid) {
		PlantillasComisionesMarcaLocal local = (PlantillasComisionesMarcaLocal)em.find(PlantillasComisionesMarcaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
           Query query=em.createNamedQuery("PlantillasComisionesMarcaLocal.FindAll");          
           return query.getResultList();
       }

	public Collection findByPlantilla(Long oidPlantilla) {
		Query query=em.createNamedQuery("PlantillasComisionesMarcaLocal.FindByPlantilla");
		
		query.setParameter(1, oidPlantilla);

                return query.getResultList();
	}

	public PlantillasComisionesMarcaLocal findByUk(Long oidMarca, Long oidPlantillaComision) {
		Query query=em.createNamedQuery("PlantillasComisionesMarcaLocal.FindByUk");
		
		query.setParameter(1, oidMarca);

		query.setParameter(2, oidPlantillaComision);

		return (PlantillasComisionesMarcaLocal)(query.getSingleResult());
	}

}
