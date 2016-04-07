package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.OfertaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class OfertaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public OfertaLocal create(Long coes_oid_estr, Integer num_ofer, Long argv_oid_argu_vent, Long mfca_oid_cabe, Long oidCatalogo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_OFER_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		OfertaLocal local = new OfertaLocal(oid, coes_oid_estr, num_ofer, argv_oid_argu_vent, mfca_oid_cabe, oidCatalogo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(OfertaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(OfertaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public OfertaLocal findByPrimaryKey(Long  oid) {
		OfertaLocal local = (OfertaLocal)em.find(OfertaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidCabe(Long oidCabe) {
		Query query=em.createNamedQuery("OfertaLocal.FindByOidCabe");
		
		query.setParameter(1, oidCabe);

		return query.getResultList();
	}
        
        // vbongiov -- Cambio 20080746 -- 29/10/2008
        public Collection findByOidCabeOrde(Long oidCabe) {
                Query query=em.createNamedQuery("OfertaLocal.FindByOidCabeOrde");
                
                query.setParameter(1, oidCabe);
    
                return query.getResultList();
        }

	public Collection findByOidCabeOidEstr(Long oidCabe,Long oidEstr) {
		Query query=em.createNamedQuery("OfertaLocal.FindByOidCabeOidEstr");
		
		query.setParameter(1, oidCabe);

		query.setParameter(2, oidEstr);

		return query.getResultList();
	}

        public Collection findByMFGenerada(Long oidCabe,Long matrizFacturacionGenerada) {
                Query query=em.createNamedQuery("OfertaLocal.FindByMFGenerada");
                
                query.setParameter(1, oidCabe);
    
                query.setParameter(2, matrizFacturacionGenerada);
    
                return query.getResultList();
        }
        
}
