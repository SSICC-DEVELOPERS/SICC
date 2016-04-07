package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class ParametrosBelcenterLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public ParametrosBelcenterLocal create(Long subacceso, String direccion, 
                    BigDecimal montoMaximoDiferencia, BigDecimal limiteEfectivoCaja, 
                    Integer numeroDeCajas, String nombreDeLocal, Integer tiempoDeReposicion, 
                    Float factorLocal, Integer numeroMaximoProductos, BigDecimal alertaStock, 
                    String usuario, Long cliente, Long empresa, Long tipoTransaccion, 
                    Long cuentaCorriente, Long tipoMovimientoCobrar, Long tipoMovimientoCierre, 
                    Long movimientoConfirmarStock, Long movimientoConfirmarStockEnTransito, 
                    Long movimientoStockEnTransito, Long movimientoStockDevolucion, 
                    Long movimientoRegularizacion, Long movimientoRegularizacionSAP, 
                    Long movimientoDevolverStockExistencias, Long movimientoPeticionExistencias, 
                    Long pais) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_PABE_SEQ");
		ParametrosBelcenterLocal local = new ParametrosBelcenterLocal(oid, subacceso, direccion, montoMaximoDiferencia, 
                            limiteEfectivoCaja, numeroDeCajas, nombreDeLocal, tiempoDeReposicion, factorLocal, numeroMaximoProductos, 
                            alertaStock, usuario, cliente, empresa, tipoTransaccion, cuentaCorriente, tipoMovimientoCobrar, 
                            tipoMovimientoCierre, movimientoConfirmarStock, movimientoConfirmarStockEnTransito, movimientoStockEnTransito, 
                            movimientoStockDevolucion, movimientoRegularizacion, movimientoRegularizacionSAP, 
                            movimientoDevolverStockExistencias, movimientoPeticionExistencias, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosBelcenterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosBelcenterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosBelcenterLocal findByPrimaryKey(Long  oid) {
		ParametrosBelcenterLocal local = (ParametrosBelcenterLocal)em.find(ParametrosBelcenterLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public ParametrosBelcenterLocal findByUK(Long param1,Long param2) {
		Query query=em.createNamedQuery("ParametrosBelcenterLocal.FindByUK");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		return (ParametrosBelcenterLocal)(query.getSingleResult());
	}

}
