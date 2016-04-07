package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.SubtipoClienteDetalleMAVLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SubtipoClienteDetalleMAVLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public SubtipoClienteDetalleMAVLocal create(Long oidSubtipoCliente, Long oidDetalleMAV) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_SCDM_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SubtipoClienteDetalleMAVLocal local = new SubtipoClienteDetalleMAVLocal(oid, oidSubtipoCliente, oidDetalleMAV);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SubtipoClienteDetalleMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SubtipoClienteDetalleMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SubtipoClienteDetalleMAVLocal findByPrimaryKey(Long  oid) {
		SubtipoClienteDetalleMAVLocal local = (SubtipoClienteDetalleMAVLocal)em.find(SubtipoClienteDetalleMAVLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findByOidDetaMav(Long oidDetalleMAV) {
                Query query=em.createNamedQuery("SubtipoClienteDetalleMAVLocal.FindByOidDetaMav");
                
                query.setParameter(1, oidDetalleMAV);
    
                return query.getResultList();
        }        

	
}
