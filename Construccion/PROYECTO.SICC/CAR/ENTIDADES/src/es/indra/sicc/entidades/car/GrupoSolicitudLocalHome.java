package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.GrupoSolicitudLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class GrupoSolicitudLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public GrupoSolicitudLocal create(Long  oid) throws MareException {
	        oid = SecuenciadorOID.obtenerSiguienteValor("CAR_GRSO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		GrupoSolicitudLocal local = new GrupoSolicitudLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(GrupoSolicitudLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(GrupoSolicitudLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public GrupoSolicitudLocal findByPrimaryKey(Long  oid) {
		GrupoSolicitudLocal local = (GrupoSolicitudLocal)em.find(GrupoSolicitudLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("GrupoSolicitudLocal.FindAll");          
            return query.getResultList();
        }

	
}
