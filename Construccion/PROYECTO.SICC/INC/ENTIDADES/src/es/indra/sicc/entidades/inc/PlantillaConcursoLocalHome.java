package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PlantillaConcursoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PlantillaConcursoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PlantillaConcursoLocal create(Boolean valFaseCali, Long canaOidCana, Long dirigido) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PLC2_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PlantillaConcursoLocal local = new PlantillaConcursoLocal(oid, valFaseCali, canaOidCana, dirigido);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PlantillaConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PlantillaConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PlantillaConcursoLocal findByPrimaryKey(Long  oid) {
		PlantillaConcursoLocal local = (PlantillaConcursoLocal)em.find(PlantillaConcursoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                Query query = em.createNamedQuery("PlantillaConcursoLocal.FindAll");
                return query.getResultList();
        }

}
