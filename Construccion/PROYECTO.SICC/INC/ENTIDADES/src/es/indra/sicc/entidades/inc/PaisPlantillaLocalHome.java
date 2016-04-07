package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PaisPlantillaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PaisPlantillaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PaisPlantillaLocal create(Long paisOidPais, Long plc2OidPlanConc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PAPL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PaisPlantillaLocal local = new PaisPlantillaLocal(oid, paisOidPais, plc2OidPlanConc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PaisPlantillaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PaisPlantillaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PaisPlantillaLocal findByPrimaryKey(Long  oid) {
		PaisPlantillaLocal local = (PaisPlantillaLocal)em.find(PaisPlantillaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("PaisPlantillaLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByPlantilla(Long plantilla) {
		Query query=em.createNamedQuery("PaisPlantillaLocal.FindByPlantilla");
		
		query.setParameter(1, plantilla);

                return query.getResultList();
	}

}
