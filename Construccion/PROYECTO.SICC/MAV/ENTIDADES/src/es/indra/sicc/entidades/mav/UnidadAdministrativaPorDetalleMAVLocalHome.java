package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.UnidadAdministrativaPorDetalleMAVLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class UnidadAdministrativaPorDetalleMAVLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public UnidadAdministrativaPorDetalleMAVLocal create(Long oidDetalleMAV, Long oidZona, Long oidTerritorio, Long oidRegion, Long oidSubgerencia) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_DMUA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		UnidadAdministrativaPorDetalleMAVLocal local = new UnidadAdministrativaPorDetalleMAVLocal(oid, oidDetalleMAV, oidZona, oidTerritorio, oidRegion, oidSubgerencia);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(UnidadAdministrativaPorDetalleMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(UnidadAdministrativaPorDetalleMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public UnidadAdministrativaPorDetalleMAVLocal findByPrimaryKey(Long  oid) {
		UnidadAdministrativaPorDetalleMAVLocal local = (UnidadAdministrativaPorDetalleMAVLocal)em.find(UnidadAdministrativaPorDetalleMAVLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findByOidDetaMav(Long oidDetalleMAV) {
                Query query=em.createNamedQuery("UnidadAdministrativaPorDetalleMAVLocal.FindByOidDetaMav");
                
                query.setParameter(1, oidDetalleMAV);
        
                return query.getResultList();
        }           

	
}
