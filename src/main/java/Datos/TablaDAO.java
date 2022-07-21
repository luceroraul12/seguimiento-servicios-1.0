package Datos;

import domain.Servicio;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Datos.Conexion.close;
import static Datos.Conexion.getConnection;

public class TablaDAO {
    /**
     * Crea una tabla que contendra los meses cargados acompañados del id del servicio asociado.
     */
    public void crearTabla(){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `meses` (\n" +
                "  `id_servicios` int NOT NULL,\n" +
                "  `id_mes` mediumint NOT NULL AUTO_INCREMENT,\n" +
                "  `fecha_vencimiento` Date DEFAULT NULL,\n" +
                "  `fecha_pago` Date DEFAULT NULL,\n" +
                "  `costo_vencimiento` Double DEFAULT NULL,\n" +
                "  `costo_pago` Double DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id_servicios`,`id_mes`)\n" +
                ")  ENGINE=MyISAM;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_CREATE_TABLE);
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
    }
    /**
     * Muestra todos los meses cargados de un servicio en particular
     * @param servicio debe tener idServicio
     * @return devuelve un arreglo que contiene todos los elementos cargados al el momento
     */
    public List<Servicio> seleccionar(Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Servicio> servicios = new ArrayList<>();

        String SQL_SELECT = "SELECT * FROM meses WHERE id_servicios = ?";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, servicio.getIdServicio());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idServicio = rs.getInt("id_servicios");
                int idMensual = rs.getInt("id_mes");
                Date fechaVencimiento = rs.getDate("fecha_vencimiento");
                Date fechaPago = rs.getDate("fecha_pago");
                double costoVencimiento = rs.getDouble("costo_vencimiento");
                double costoPago = rs.getDouble("costo_pago");

                servicio = new Servicio(idServicio, idMensual, fechaVencimiento.toLocalDate(), fechaPago.toLocalDate(), costoVencimiento, costoPago);

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
     * Devuelve un dato en particular en función a la ubicacion dentro de la tabla
     * @param servicio debe contener el id_servicios e id_mensual
     * @return devuelve un elemento de tipo Servicio con la información extraida de la tabla
     */
    public Servicio seleccionarUno(Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio servicioFinal = null;
        String SQL_SELECT = "SELECT * FROM meses WHERE id_servicios = ? AND id_mes = ?";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            rs.next();
                int idServicio = rs.getInt("id_servicios");
                int idMensual = rs.getInt("id_mes");
                Date fechaVencimiento = rs.getDate("fecha_vencimiento");
                Date fechaPago = rs.getDate("fecha_pago");
                int costoVencimiento = rs.getInt("costo_vencimiento");
                int costoPago = rs.getInt("costo_pago");

                servicioFinal = new Servicio(idServicio, idMensual, fechaVencimiento.toLocalDate(), fechaPago.toLocalDate(), costoVencimiento, costoPago);

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
        return servicioFinal;
    }

    /**
     * Para ingresar un nuevo registro a la tabla
     * @param servicio Debe contener como minimo tiene que contener las fechas, los costos y el id_servicios
     * @return
     */
    public int insertar(Servicio servicio){
        String SQL_INSERT = "INSERT INTO meses(id_servicios,fecha_vencimiento, fecha_pago, costo_vencimiento, costo_pago) VALUES (?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, servicio.getIdServicio());
            stmt.setDate(2, Date.valueOf(servicio.getFechaVencimiento()));
            stmt.setDate(3, Date.valueOf(servicio.getFechaPago()));
            stmt.setDouble(4, servicio.getCostoVencimiento());
            stmt.setDouble(5, servicio.getCostoPago());

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
     * Modifica un elemento de la tabla
     * @param servicio Debe contener los elementos a modificar. idServicio, idMensual, fechas y costos
     * @return
     */
    public int actualizar(Servicio servicio){
        String SQL_UPDATE = "UPDATE meses SET fecha_vencimiento = ?, fecha_pago = ?, costo_vencimiento = ?, costo_pago = ? WHERE (id_servicios = ?) AND (id_mes = ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            Date.valueOf(servicio.getFechaVencimiento());
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setDate(1, Date.valueOf(servicio.getFechaVencimiento()));
            stmt.setDate(2, Date.valueOf(servicio.getFechaPago()));
            stmt.setDouble(3, servicio.getCostoVencimiento());
            stmt.setDouble(4, servicio.getCostoPago());
            stmt.setInt(5, servicio.getIdServicio());
            stmt.setInt(6, servicio.getIdMensual());
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
     * Elimina un registro dentro de una tabla
     * @param servicio Debe contener el id_servicios e id_Mensual para poder ubicarlo
     * @return
     */
    public int eliminar(Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        String SQL_DELETE = "DELETE FROM meses WHERE (id_servicios = ?) AND (id_mes = ?);";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, servicio.getIdServicio());
            stmt.setInt(2, servicio.getIdMensual());
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
     * Elimina un conjunto de meses en funcion del servicio deseado
     * @param servicio debe tener idServicio
     * @return
     */
    public int eliminarWhere(Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        String SQL_DELETE = "DELETE FROM meses WHERE id_servicios = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
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
