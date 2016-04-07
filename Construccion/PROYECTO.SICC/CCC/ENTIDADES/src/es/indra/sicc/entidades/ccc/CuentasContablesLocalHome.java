package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.CuentasContablesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CuentasContablesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

    
	public CuentasContablesLocal create(Long pais, String codigo, String codigoSAP)
            throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CUCO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CuentasContablesLocal local = new CuentasContablesLocal(oid, pais, codigo, codigoSAP);
		em.persist(local);
		et.commit();
		return local;
	}
	
        public CuentasContablesLocal create(Long pais, String codigo, String codigoSAP, String observaciones)
            throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CUCO_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                CuentasContablesLocal local = new CuentasContablesLocal(oid, pais, codigo, codigoSAP, observaciones);
                em.persist(local);
                et.commit();
                return local;
        }
    
	public void remove(CuentasContablesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CuentasContablesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CuentasContablesLocal findByPrimaryKey(Long  oid) {
		CuentasContablesLocal local = (CuentasContablesLocal)em.find(CuentasContablesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
