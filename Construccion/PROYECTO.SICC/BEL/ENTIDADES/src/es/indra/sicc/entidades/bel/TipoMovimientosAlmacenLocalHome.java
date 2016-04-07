package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.TipoMovimientosAlmacenLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoMovimientosAlmacenLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public TipoMovimientosAlmacenLocal create(Long pais, String codigoMovimiento, String codigoMovimientoSAP, Boolean movimientoEntreAlmacenes, Boolean mantieneMovimientos, Boolean indicadorSAP) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_TMAL_SEQ");
                TipoMovimientosAlmacenLocal local = new TipoMovimientosAlmacenLocal(oid, pais, codigoMovimiento, codigoMovimientoSAP, movimientoEntreAlmacenes, mantieneMovimientos, indicadorSAP);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public TipoMovimientosAlmacenLocal create(Long pais, String codigoMovimiento, String codigoMovimientoSAP, Boolean movimientoEntreAlmacenes, Boolean mantieneMovimientos, Boolean indicadorSAP, Long estadoMercancia1, Long estadoMercancia2, Character operacion1, Character operacion2) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_TMAL_SEQ");
                TipoMovimientosAlmacenLocal local = new TipoMovimientosAlmacenLocal(oid, pais, codigoMovimiento, codigoMovimientoSAP, movimientoEntreAlmacenes, mantieneMovimientos, indicadorSAP, estadoMercancia1, estadoMercancia2, operacion1, operacion2);
                em.persist(local);
                et.commit();
                return local;
        }        
	
	public void remove(TipoMovimientosAlmacenLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoMovimientosAlmacenLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoMovimientosAlmacenLocal findByPrimaryKey(Long  oid) {
		TipoMovimientosAlmacenLocal local = em.find(TipoMovimientosAlmacenLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
