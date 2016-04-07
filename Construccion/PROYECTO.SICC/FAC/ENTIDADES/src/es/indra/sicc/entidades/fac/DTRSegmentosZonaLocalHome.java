package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.DTRSegmentosZonaLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class DTRSegmentosZonaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public DTRSegmentosZonaLocal create(Long zorgOidRegi, Long zzonOidZona, Long perdOidPeri, Long npedidos, Double venta, Double pmnp) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTR_SGZO_SEQ");
		DTRSegmentosZonaLocal local = new DTRSegmentosZonaLocal(oid, zorgOidRegi, zzonOidZona, perdOidPeri, npedidos, venta, pmnp);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public DTRSegmentosZonaLocal create(Long zorgOidRegi, Long zzonOidZona, Long perdOidPeri) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTR_SGZO_SEQ");
                DTRSegmentosZonaLocal local = new DTRSegmentosZonaLocal(oid, zorgOidRegi, zzonOidZona, perdOidPeri);
                em.persist(local);
                et.commit();
                return local;
        }
        
	public void remove(DTRSegmentosZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DTRSegmentosZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DTRSegmentosZonaLocal findByPrimaryKey(Long  oid) {
		DTRSegmentosZonaLocal local = (DTRSegmentosZonaLocal)em.find(DTRSegmentosZonaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
