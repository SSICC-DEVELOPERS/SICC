package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.FormaPagoDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FormaPagoDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public FormaPagoDetalleLocal create(Long formaPagoCabecera, Integer porcentaje, Character indicadorDeDias, Integer posicionDetalle, Long medioDePago) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_FPDE_SEQ");
                FormaPagoDetalleLocal local = new FormaPagoDetalleLocal(oid, formaPagoCabecera, porcentaje, indicadorDeDias, posicionDetalle, medioDePago);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public FormaPagoDetalleLocal create(Long formaPagoCabecera, Integer porcentaje, Character indicadorDeDias, Integer posicionDetalle, Long medioDePago, Long actividad,Integer numeroDeDias) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_FPDE_SEQ");
                FormaPagoDetalleLocal local = new FormaPagoDetalleLocal(oid, formaPagoCabecera, porcentaje, indicadorDeDias, posicionDetalle, medioDePago, actividad,numeroDeDias);
                em.persist(local);
                et.commit();
                return local;        
        
        }
	
	public void remove(FormaPagoDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FormaPagoDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FormaPagoDetalleLocal findByPrimaryKey(Long  oid) {
		FormaPagoDetalleLocal local = (FormaPagoDetalleLocal)em.find(FormaPagoDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByFormaPagoCabecera(Long param1) {
		Query query=em.createNamedQuery("FormaPagoDetalleLocal.FindByFormaPagoCabecera");
		query.setParameter(1, param1);
		return query.getResultList();
	}

}
