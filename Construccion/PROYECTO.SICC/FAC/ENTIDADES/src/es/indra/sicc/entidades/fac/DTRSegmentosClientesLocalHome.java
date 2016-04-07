package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.DTRSegmentosClientesLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class DTRSegmentosClientesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public DTRSegmentosClientesLocal create(Long clieOidClie, Long zorgOidRegi, Long zzonOidZona, Long perdOidPeri, Long nvsgOidNiveSegm, Long npedidos, Double venta, Double pmnp, Double impDes1, Double impDes3) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTR_SGZL_SEQ");
		DTRSegmentosClientesLocal local = new DTRSegmentosClientesLocal(oid, clieOidClie, zorgOidRegi, zzonOidZona, perdOidPeri, nvsgOidNiveSegm, npedidos, venta, pmnp, impDes1, impDes3);
		em.persist(local);
		et.commit();
		return local;
	}


    public DTRSegmentosClientesLocal create(Long clieOidClie, Long zorgOidRegi, Long zzonOidZona, Long perdOidPeri) throws MareException {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            Long oid = SecuenciadorOID.obtenerSiguienteValor("DTR_SGZL_SEQ");
            DTRSegmentosClientesLocal local = new DTRSegmentosClientesLocal(oid, clieOidClie, zorgOidRegi, zzonOidZona, perdOidPeri);
            em.persist(local);
            et.commit();
            return local;
    }
        
	public void remove(DTRSegmentosClientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DTRSegmentosClientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DTRSegmentosClientesLocal findByPrimaryKey(Long  oid) {
		DTRSegmentosClientesLocal local = (DTRSegmentosClientesLocal)em.find(DTRSegmentosClientesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
