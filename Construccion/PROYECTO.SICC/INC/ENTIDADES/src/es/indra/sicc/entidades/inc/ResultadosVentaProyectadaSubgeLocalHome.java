package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ResultadosVentaProyectadaSubgeLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class ResultadosVentaProyectadaSubgeLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ResultadosVentaProyectadaSubgeLocal create(Integer activasIniciales, Integer activasFinales, Integer ingresos, Integer reingresos, Integer egresos, Integer numeroOrdenes, Integer numeroPedidos, BigDecimal ventaNetaEstadisticable, Long meta, Long periodoCalculado) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_RVPS_SEQ");  
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ResultadosVentaProyectadaSubgeLocal local = new ResultadosVentaProyectadaSubgeLocal(oid, activasIniciales, activasFinales, ingresos, reingresos, egresos, numeroOrdenes, numeroPedidos, ventaNetaEstadisticable, meta, periodoCalculado);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ResultadosVentaProyectadaSubgeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ResultadosVentaProyectadaSubgeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ResultadosVentaProyectadaSubgeLocal findByPrimaryKey(Long  oid) {
		ResultadosVentaProyectadaSubgeLocal local = (ResultadosVentaProyectadaSubgeLocal)em.find(ResultadosVentaProyectadaSubgeLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("ResultadosVentaProyectadaSubgeLocal.FindAll");
                    return query.getResultList();
            }

}
