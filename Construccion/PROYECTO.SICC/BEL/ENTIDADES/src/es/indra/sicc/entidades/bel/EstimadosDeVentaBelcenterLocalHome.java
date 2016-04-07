package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.EstimadosDeVentaBelcenterLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class EstimadosDeVentaBelcenterLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public EstimadosDeVentaBelcenterLocal create(Long subacceso, Long producto, Long unidadesEstimadas, Integer paginaCatalogo, BigDecimal precioCatalogo, BigDecimal costeEstandar, Long tipoOferta, Long cicloVida, Long monedaTransaccion, Long condicionPromocion, Long catalogo, Long periodo, Long argumentoVenta, Long estrategia) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_EVBE_SEQ");
                EstimadosDeVentaBelcenterLocal local = new EstimadosDeVentaBelcenterLocal(oid, subacceso, producto, unidadesEstimadas, paginaCatalogo, precioCatalogo, costeEstandar, tipoOferta, cicloVida, monedaTransaccion, condicionPromocion, catalogo, periodo, argumentoVenta, estrategia);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public EstimadosDeVentaBelcenterLocal create(Long subacceso, Long producto, Long unidadesEstimadas, Integer paginaCatalogo, BigDecimal precioCatalogo, BigDecimal costeEstandar, Long tipoOferta, Long cicloVida, Long monedaTransaccion, Long condicionPromocion, Long catalogo, Long periodo, Long argumentoVenta, Long estrategia, Integer posicionPorPagina, BigDecimal valorVenta, BigDecimal precioPosicionamiento, String centro, Boolean indicadorOfertaGenerada, Long formaPagoCabecera) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_EVBE_SEQ");
                EstimadosDeVentaBelcenterLocal local = new EstimadosDeVentaBelcenterLocal(oid, subacceso, producto, unidadesEstimadas, paginaCatalogo, precioCatalogo, costeEstandar, tipoOferta, cicloVida, monedaTransaccion, condicionPromocion, catalogo, periodo, argumentoVenta, estrategia, posicionPorPagina, valorVenta, precioPosicionamiento, centro, indicadorOfertaGenerada, formaPagoCabecera);
                em.persist(local);
                et.commit();
                return local;        
        }
        
	
	public void remove(EstimadosDeVentaBelcenterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstimadosDeVentaBelcenterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstimadosDeVentaBelcenterLocal findByPrimaryKey(Long  oid) {
		EstimadosDeVentaBelcenterLocal local = (EstimadosDeVentaBelcenterLocal)em.find(EstimadosDeVentaBelcenterLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
