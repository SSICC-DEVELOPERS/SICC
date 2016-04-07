package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.CajaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class CajaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public CajaLocal create(Long pais, Long subAcceso, String codigoCaja, Character estadoCaja, Timestamp fechaCierre, Long usuario) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_CAJA_SEQ");
                CajaLocal local = new CajaLocal(oid, pais, subAcceso, codigoCaja, estadoCaja, fechaCierre, usuario);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public CajaLocal create(Long pais, Long subAcceso, String codigoCaja, Character estadoCaja, Timestamp fechaCierre, Long oidTipoCaja, Long usuario) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_CAJA_SEQ");
                CajaLocal local = new CajaLocal(oid, pais, subAcceso, codigoCaja, estadoCaja, fechaCierre, oidTipoCaja, usuario);
                em.persist(local);
                et.commit();
                return local;
        }        
	
	public void remove(CajaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CajaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CajaLocal findByPrimaryKey(Long  oid) {
		CajaLocal local = (CajaLocal)em.find(CajaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
