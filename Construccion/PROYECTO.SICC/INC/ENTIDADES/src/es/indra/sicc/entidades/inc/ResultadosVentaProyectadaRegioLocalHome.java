package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ResultadosVentaProyectadaRegioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class ResultadosVentaProyectadaRegioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ResultadosVentaProyectadaRegioLocal create(Integer activasIniciales, Integer activasFinales,Integer ingresos, Integer reingresos, Integer egresos, Integer numeroOrdenes,  Integer numeroPedidos, Integer unidadesVendidas, Integer numeroClientes, BigDecimal ventaNetaEstadisticable, Long meta, Long periodoCalculado) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_RVPR_SEQ");  
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ResultadosVentaProyectadaRegioLocal local = new ResultadosVentaProyectadaRegioLocal(oid, activasIniciales, activasFinales,ingresos, reingresos, egresos, numeroOrdenes,  numeroPedidos, unidadesVendidas, numeroClientes, ventaNetaEstadisticable, meta, periodoCalculado);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ResultadosVentaProyectadaRegioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ResultadosVentaProyectadaRegioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ResultadosVentaProyectadaRegioLocal findByPrimaryKey(Long  oid) {
		ResultadosVentaProyectadaRegioLocal local = (ResultadosVentaProyectadaRegioLocal)em.find(ResultadosVentaProyectadaRegioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("ResultadosVentaProyectadaRegioLocal.FindAll");
                    return query.getResultList();
            }

}
