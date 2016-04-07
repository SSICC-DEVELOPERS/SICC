package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.ImpresoraVirtualLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ImpresoraVirtualLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public ImpresoraVirtualLocal create(Long pais, String codigoImpresora, String descripcion, Long tipo, Long statusActivo) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_IMVI_SEQ");
		ImpresoraVirtualLocal local = new ImpresoraVirtualLocal(oid, pais, codigoImpresora, descripcion, tipo, statusActivo);
		em.persist(local);
		et.commit();
		return local;
	}
	
        public ImpresoraVirtualLocal create(Long pais, String codigoImpresora, String descripcion, Long tipo, Long statusActivo, String atributo_1) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_IMVI_SEQ");
                ImpresoraVirtualLocal local = new ImpresoraVirtualLocal(oid, pais, codigoImpresora, descripcion, tipo, statusActivo, atributo_1);
                em.persist(local);
                et.commit();
                return local;
        }

	public void remove(ImpresoraVirtualLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ImpresoraVirtualLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ImpresoraVirtualLocal findByPrimaryKey(Long  oid) {
		ImpresoraVirtualLocal local = (ImpresoraVirtualLocal)em.find(ImpresoraVirtualLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
