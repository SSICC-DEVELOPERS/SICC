package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.MarcaDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Collection;

import javax.persistence.Query;

public class MarcaDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public MarcaDetalleLocal create(Long mtab_oid_marc_tipo_abon, Long masi_oid_marc_situ) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_DEME_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MarcaDetalleLocal local = new MarcaDetalleLocal(oid, mtab_oid_marc_tipo_abon, masi_oid_marc_situ);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MarcaDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MarcaDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MarcaDetalleLocal findByPrimaryKey(Long  oid) {
		MarcaDetalleLocal local = (MarcaDetalleLocal)em.find(MarcaDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findByMarcaTipoAbonoSubproceso(Long marcaTipoAbono) {
                Query query=em.createNamedQuery("MarcaDetalleLocal.FindByMarcaTipoAbonoSubproceso");
                
                query.setParameter(1, marcaTipoAbono);
    
                return query.getResultList();
        }
	
}
