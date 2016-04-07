package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.AccesosSubaccesosPorDetalleMAVLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AccesosSubaccesosPorDetalleMAVLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public AccesosSubaccesosPorDetalleMAVLocal create(Long oidDetalleMAV, Long oidSubacceso) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_DMAS_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AccesosSubaccesosPorDetalleMAVLocal local = new AccesosSubaccesosPorDetalleMAVLocal(oid, oidDetalleMAV, oidSubacceso);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AccesosSubaccesosPorDetalleMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AccesosSubaccesosPorDetalleMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AccesosSubaccesosPorDetalleMAVLocal findByPrimaryKey(Long  oid) {
		AccesosSubaccesosPorDetalleMAVLocal local = (AccesosSubaccesosPorDetalleMAVLocal)em.find(AccesosSubaccesosPorDetalleMAVLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
            
        public Collection findByOidDetaMav(Long oidDetaMav) {
                Query query=em.createNamedQuery("AccesosSubaccesosPorDetalleMAVLocal.FindByOidDetaMav");
                
                query.setParameter(1, oidDetaMav);
    
                return query.getResultList();
        }
	
}
