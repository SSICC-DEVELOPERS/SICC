package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.SeguimientoPedidosINTLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class SeguimientoPedidosINTLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public SeguimientoPedidosINTLocal create(String numeroDespacho, String chip, String docuIdenRepartidor, Date fechaInicioLineaSacado, String horaInicioLineaSacado, Date fechaFinLineaSacado, String horaFinLineaSacado, Integer cantidadBultos, Date fechaDespacho, String horaDespacho, Long pais, Long tipoSolicitud, Long sociedad, Long clienteRepartidor, Long cliente, Long numeroSolicitud, String CodRepartidorLarissa) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_ISPI_SEQ");
		SeguimientoPedidosINTLocal local = new SeguimientoPedidosINTLocal(oid, numeroDespacho, chip, docuIdenRepartidor, fechaInicioLineaSacado, horaInicioLineaSacado, fechaFinLineaSacado, horaFinLineaSacado, cantidadBultos, fechaDespacho, horaDespacho, pais, tipoSolicitud, sociedad, clienteRepartidor, cliente, numeroSolicitud, CodRepartidorLarissa);
                em.persist(local);
                et.commit();
		return local;
	}
	
	public void remove(SeguimientoPedidosINTLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SeguimientoPedidosINTLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SeguimientoPedidosINTLocal findByPrimaryKey(Long  oid) {
		SeguimientoPedidosINTLocal local = em.find(SeguimientoPedidosINTLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("SeguimientoPedidosINTLocal.FindAll");
		return query.getResultList();
	}

}
