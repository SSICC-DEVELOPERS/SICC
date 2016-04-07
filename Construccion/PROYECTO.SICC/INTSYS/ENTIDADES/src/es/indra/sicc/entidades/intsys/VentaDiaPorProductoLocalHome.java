package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.VentaDiaPorProductoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class VentaDiaPorProductoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public VentaDiaPorProductoLocal create(Date fecha, Long subAcceso, Long periodo, Long almacen, Long tipoCliente, Long tipoSolicitud, Long sociedad, Long producto, Long cicloVida, Long tipoOferta, Long promocion, Long moneda) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_VDPP_SEQ");
		VentaDiaPorProductoLocal local = new VentaDiaPorProductoLocal(oid, fecha, subAcceso, periodo, almacen, tipoCliente, tipoSolicitud, sociedad, producto, cicloVida, tipoOferta, promocion, moneda);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VentaDiaPorProductoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VentaDiaPorProductoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VentaDiaPorProductoLocal findByPrimaryKey(Long  oid) {
		VentaDiaPorProductoLocal local = em.find(VentaDiaPorProductoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("VentaDiaPorProductoLocal.FindAll");
		return query.getResultList();
	}

}
