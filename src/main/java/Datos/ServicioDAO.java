package Datos;

import domain.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Datos.Conexion.close;
import static Datos.Conexion.getConnection;

/**
 * CREA, MODIFICA ELIMINA ELEMENTOS DE LA TABLA DE SERVICIOS Y A SU VEZ CREA, MODIFICA Y ELIMINA TABLA DEL SERVICIO ASOCIADO
 */
public class ServicioDAO {
    private static final String SQL_SELECT = "SELECT * FROM servicios";
    private static final String SQL_INSERT_SERVICIO = "INSERT INTO servicios(servicio) VALUES (?)";
    private static final String SQL_UPDATE = "UPDATE servicios SET servicio = ? WHERE id_servicios = ?";
    private static final String SQL_DELETE_SERVICIO = "DELETE FROM servicios WHERE id_servicios = ?";
    /**
     * Para obtener un arreglo que contiene los servicios registrados
     * @return Arreglo de servicio existentes
     */
    public List<Servicio> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio servicio = null;
        List<Servicio> servicios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idServicio = rs.getInt("id_servicios");
                String nombreServicio = rs.getString("servicio");

                servicio = new Servicio(idServicio, nombreServicio);
                servicios.add(servicio);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return servicios;
    }

    /**
     * Para ingresar un nuevo servicio
     * @param servicio Debe contener el nombre del nuevo servicio
     * @return
     */
    public int insertar(Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_SERVICIO);
            stmt.setString(1, servicio.getNombreServicio());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

    /**
     *Para Actualizar el nombre de un servicio
     * @param servicio Debe contener el id_servicio, nombreServicioModificado
     * @return
     */
    public int actualizar(Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, servicio.getNombreServicio());
            stmt.setInt(2, servicio.getIdServicio());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

    /**
     * Para eliminar un servicio
     * @param servicio Debe tener el id_servicio
     * @return
     */
    public int eliminar(Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_SERVICIO);
            stmt.setInt(1, servicio.getIdServicio());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

}
