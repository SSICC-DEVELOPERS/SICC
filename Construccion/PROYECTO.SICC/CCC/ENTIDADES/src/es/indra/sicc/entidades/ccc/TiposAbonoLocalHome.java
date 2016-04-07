package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.TiposAbonoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposAbonoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
            
	public TiposAbonoLocal create(Long pais, String codigo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_TCAB_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TiposAbonoLocal local = new TiposAbonoLocal(oid, pais, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public TiposAbonoLocal create(Long pais, String codigo, String observaciones)   
                                                                    throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_TCAB_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                TiposAbonoLocal local = new TiposAbonoLocal(oid, pais, codigo, observaciones);
                em.persist(local);
                et.commit();
                return local;
        }        
	
	public void remove(TiposAbonoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TiposAbonoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TiposAbonoLocal findByPrimaryKey(Long  oid) {
		TiposAbonoLocal local = (TiposAbonoLocal)em.find(TiposAbonoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
