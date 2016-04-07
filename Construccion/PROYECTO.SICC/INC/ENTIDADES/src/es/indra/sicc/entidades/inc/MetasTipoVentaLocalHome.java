package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.MetasTipoVentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class MetasTipoVentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public MetasTipoVentaLocal create(BigDecimal montoVenta, Integer unidadesVendidas, BigDecimal incremento, BigDecimal meta, Long cliente, Long concurso) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_METV_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MetasTipoVentaLocal local = new MetasTipoVentaLocal(oid, montoVenta, unidadesVendidas, incremento, meta, cliente, concurso);
		em.persist(local);
		et.commit();
		return local;
	}
        
    public MetasTipoVentaLocal create(BigDecimal valMeta, Long clieOidClie, Long copaOidParaGral) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_METV_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            MetasTipoVentaLocal local = new MetasTipoVentaLocal(oid, valMeta, clieOidClie, copaOidParaGral);
            em.persist(local);
            et.commit();
            return local;
    }
	
	public void remove(MetasTipoVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MetasTipoVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MetasTipoVentaLocal findByPrimaryKey(Long  oid) {
		MetasTipoVentaLocal local = (MetasTipoVentaLocal)em.find(MetasTipoVentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("AccesoLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("MetasTipoVentaLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

	public MetasTipoVentaLocal findByConcursoCliente(Long oidConcurso, Long oidCliente) {
		Query query=em.createNamedQuery("MetasTipoVentaLocal.FindByConcursoCliente");
		
		query.setParameter(1, oidConcurso);

		query.setParameter(2, oidCliente);

		return (MetasTipoVentaLocal)(query.getSingleResult());
	}

}
