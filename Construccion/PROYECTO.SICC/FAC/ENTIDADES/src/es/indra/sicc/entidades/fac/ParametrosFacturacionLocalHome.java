package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.ParametrosFacturacionLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ParametrosFacturacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public ParametrosFacturacionLocal create(Long pais, Byte maxCampanyasPDR, Short maxPedidosProyeccion, Long esDocumentoMonopagina, Boolean chequeoClienteNuevo, Boolean indTipoProyeccionRegion, Boolean indPrecioContable, Boolean mostrarVctoCupon) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_PAFA_SEQ");
		ParametrosFacturacionLocal local = new ParametrosFacturacionLocal(oid,pais, maxCampanyasPDR, maxPedidosProyeccion, esDocumentoMonopagina, chequeoClienteNuevo, indTipoProyeccionRegion, indPrecioContable, mostrarVctoCupon);
		em.persist(local);
		et.commit();
		return local;
	}

        public ParametrosFacturacionLocal create(Long pais, Integer montoLimiteUIT, Byte maxCampanyasPDR, Short maxPedidosProyeccion, Long esDocumentoMonopagina, Boolean chequeoClienteNuevo, Boolean indTipoProyeccionRegion, Boolean indPrecioContable, Boolean mostrarVctoCupon) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_PAFA_SEQ");
                ParametrosFacturacionLocal local = new ParametrosFacturacionLocal(oid, pais, montoLimiteUIT, maxCampanyasPDR, maxPedidosProyeccion, esDocumentoMonopagina, chequeoClienteNuevo, indTipoProyeccionRegion, indPrecioContable, mostrarVctoCupon);
                em.persist(local);
                et.commit();
                return local;
        }
	
	public void remove(ParametrosFacturacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosFacturacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosFacturacionLocal findByPrimaryKey(Long  oid) {
		ParametrosFacturacionLocal local = (ParametrosFacturacionLocal)em.find(ParametrosFacturacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByPais(Long param1) {
		Query query=em.createNamedQuery("ParametrosFacturacionLocal.FindByPais");
		query.setParameter(1, param1);
		return (query.getResultList());
	}

}
