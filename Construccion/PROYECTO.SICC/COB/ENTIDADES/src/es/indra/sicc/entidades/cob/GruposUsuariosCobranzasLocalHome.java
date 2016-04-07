package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.GruposUsuariosCobranzasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class GruposUsuariosCobranzasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public GruposUsuariosCobranzasLocal create(Long codigoGrupoUsuario, String descripcion, Long pais) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_GUCO_SEQ");
		et.begin();
		GruposUsuariosCobranzasLocal local = new GruposUsuariosCobranzasLocal(oid, codigoGrupoUsuario, descripcion, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(GruposUsuariosCobranzasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(GruposUsuariosCobranzasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public GruposUsuariosCobranzasLocal findByPrimaryKey(Long  oid) {
		GruposUsuariosCobranzasLocal local = (GruposUsuariosCobranzasLocal)em.find(GruposUsuariosCobranzasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("GruposUsuariosCobranzasLocal.FindAll");          
            return query.getResultList();
        }

}
