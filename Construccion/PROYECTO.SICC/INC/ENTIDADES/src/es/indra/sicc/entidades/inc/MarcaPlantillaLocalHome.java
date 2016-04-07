package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.MarcaPlantillaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MarcaPlantillaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public MarcaPlantillaLocal create(Long marcOidMarc, Long plc2OidPlanConc) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_MAPL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MarcaPlantillaLocal local = new MarcaPlantillaLocal(oid, marcOidMarc, plc2OidPlanConc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MarcaPlantillaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MarcaPlantillaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MarcaPlantillaLocal findByPrimaryKey(Long  oid) {
		MarcaPlantillaLocal local = (MarcaPlantillaLocal)em.find(MarcaPlantillaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("MarcaPlantillaLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByPlantilla(Long plantilla) {
		Query query=em.createNamedQuery("MarcaPlantillaLocal.FindByPlantilla");
		
		query.setParameter(1, plantilla);

	    return query.getResultList();
	}

}
