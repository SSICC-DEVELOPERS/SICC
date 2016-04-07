package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.CierreDeCajaCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class CierreDeCajaCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public CierreDeCajaCabeceraLocal create(Long movimientoCajaCabecera, Long numeroMovimiento, Character estadoCierreCaja, Timestamp fechaCierreCaja, String usuario)throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_CICC_SEQ");
                CierreDeCajaCabeceraLocal local = new CierreDeCajaCabeceraLocal(oid, movimientoCajaCabecera, numeroMovimiento, estadoCierreCaja, fechaCierreCaja, usuario);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CierreDeCajaCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CierreDeCajaCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CierreDeCajaCabeceraLocal findByPrimaryKey(Long  oid) {
		CierreDeCajaCabeceraLocal local = (CierreDeCajaCabeceraLocal)em.find(CierreDeCajaCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
