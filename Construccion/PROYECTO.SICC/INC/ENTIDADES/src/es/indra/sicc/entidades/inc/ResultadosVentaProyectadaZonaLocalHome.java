package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ResultadosVentaProyectadaZonaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class ResultadosVentaProyectadaZonaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ResultadosVentaProyectadaZonaLocal create(Integer activasIniciales, Integer activasFinales, Integer ingresos, Integer reingresos, Integer egresos, Integer numeroOrdenes, Integer numeroPedidos, Integer unidadesVendidas, Integer numeroClientes, BigDecimal ventaNetaEstadisticable, Long meta, Long periodoCalculado) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_RVPZ_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ResultadosVentaProyectadaZonaLocal local = new ResultadosVentaProyectadaZonaLocal(oid, activasIniciales, activasFinales, ingresos, reingresos, egresos, numeroOrdenes, numeroPedidos, unidadesVendidas, numeroClientes, ventaNetaEstadisticable, meta, periodoCalculado);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ResultadosVentaProyectadaZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ResultadosVentaProyectadaZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ResultadosVentaProyectadaZonaLocal findByPrimaryKey(Long  oidVPZona) {
		ResultadosVentaProyectadaZonaLocal local = (ResultadosVentaProyectadaZonaLocal)em.find(ResultadosVentaProyectadaZonaLocal.class, oidVPZona);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ResultadosVentaProyectadaZonaLocal.FindAll");
                    return query.getResultList();
            }
}
