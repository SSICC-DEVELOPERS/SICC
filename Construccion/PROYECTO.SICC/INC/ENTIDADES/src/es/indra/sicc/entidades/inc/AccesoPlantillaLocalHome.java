package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.AccesoPlantillaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AccesoPlantillaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public AccesoPlantillaLocal create(Long plc2OidPlanConc, Long acceOidAcce) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_ACPL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AccesoPlantillaLocal local = new AccesoPlantillaLocal(oid, plc2OidPlanConc, acceOidAcce);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AccesoPlantillaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AccesoPlantillaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AccesoPlantillaLocal findByPrimaryKey(Long  oid) {
		AccesoPlantillaLocal local = (AccesoPlantillaLocal)em.find(AccesoPlantillaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query = em.createNamedQuery("AccesoPlantillaLocal.FindAll");
                return query.getResultList();
        }


	public Collection findByPlantilla(Long plantilla) {
		Query query=em.createNamedQuery("AccesoPlantillaLocal.FindByPlantilla");
		
		query.setParameter(1, plantilla);

                return query.getResultList();
	}

}
