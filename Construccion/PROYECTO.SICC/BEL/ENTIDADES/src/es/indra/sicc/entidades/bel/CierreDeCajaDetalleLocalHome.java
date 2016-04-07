package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.CierreDeCajaDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class CierreDeCajaDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public CierreDeCajaDetalleLocal create(Long cierreCajaCabecera, Integer numeroLinea)throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_CICD_SEQ");
                CierreDeCajaDetalleLocal local = new CierreDeCajaDetalleLocal(oid, cierreCajaCabecera, numeroLinea);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public CierreDeCajaDetalleLocal create(Long cierreCajaCabecera, Integer numeroLinea, BigDecimal importe, BigDecimal importeDivisa, BigDecimal importeLogico, BigDecimal importeLogicoDivisa, Long medioDePago, Long monedaAlternativa)throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_CICD_SEQ");
                CierreDeCajaDetalleLocal local = new CierreDeCajaDetalleLocal(oid, cierreCajaCabecera, numeroLinea, importe, importeDivisa, importeLogico, importeLogicoDivisa, medioDePago, monedaAlternativa);
                em.persist(local);
                et.commit();
                return local;
        }        
        
	public void remove(CierreDeCajaDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CierreDeCajaDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CierreDeCajaDetalleLocal findByPrimaryKey(Long  oid) {
		CierreDeCajaDetalleLocal local = (CierreDeCajaDetalleLocal)em.find(CierreDeCajaDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
