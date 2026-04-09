package itson.daos;


import itson.matchu_dominio.models.Estudiante;
import itson.matchu_utilerias.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ricardo
 */
public class EstudianteDAO {
    
    public Estudiante guardar(Estudiante estudiante) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
            return estudiante;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException("Error al guardar estudiante: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    public Optional<Estudiante> buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return Optional.ofNullable(em.find(Estudiante.class, id));
        } finally {
            em.close();
        }
    }

    public Optional<Estudiante> buscarPorCorreo(String correo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.correo = :correo AND e.activo = true",
                Estudiante.class
            );
            q.setParameter("correo", correo);
            return Optional.of(q.getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }

    public List<Estudiante> listarTodosExcepto(Long idExcluido) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT e FROM Estudiante e " +
                "WHERE e.idEstudiante <> :id AND e.activo = true ORDER BY e.nombre",
                Estudiante.class
            ).setParameter("id", idExcluido).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Estudiante> listarPendientesDeEvaluar(Long idEmisor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT e FROM Estudiante e " +
                "WHERE e.idEstudiante <> :idEmisor AND e.activo = true " +
                "  AND e.idEstudiante NOT IN (" +
                "      SELECT i.receptor.idEstudiante FROM Interaccion i " +
                "      WHERE i.emisor.idEstudiante = :idEmisor) " +
                "ORDER BY e.nombre",
                Estudiante.class
            ).setParameter("idEmisor", idEmisor).getResultList();
        } finally {
            em.close();
        }
    }

    public boolean existeCorreo(String correo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Long count = em.createQuery(
                "SELECT COUNT(e) FROM Estudiante e WHERE e.correo = :correo", Long.class
            ).setParameter("correo", correo).getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }

    public Estudiante actualizar(Estudiante estudiante) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Estudiante managed = em.merge(estudiante);
            em.getTransaction().commit();
            return managed;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException("Error al actualizar estudiante: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Estudiante e = em.find(Estudiante.class, id);
            if (e != null) { e.setActivo(false); em.merge(e); }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException("Error al eliminar estudiante: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
