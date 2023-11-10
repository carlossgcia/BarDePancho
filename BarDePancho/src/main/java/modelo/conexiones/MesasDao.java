
package modelo.conexiones;

import modelo.entidades.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesasDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    public boolean registrarMesa(Mesa mesa){
        String sql = "INSERT INTO mesas(id, ocupada) VALUES (?,?)";
        try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, mesa.getId());
           ps.setInt(2, mesa.isOcupada());
           ps.execute();
           return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public ArrayList getListaMesas(){
        ArrayList<Mesa> Lista = new ArrayList();
        String sql = "SELECT * FROM mesas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Mesa sl = new Mesa();
                sl.setId(rs.getInt("id"));
                sl.setOcupada(rs.getInt("ocupada"));
                Lista.add(sl);
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Lista;
    }
    
    public boolean Eliminar(int id){
        String sql = "DELETE FROM mesas WHERE id = ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean Modificar(Mesa sl){
        String sql = "UPDATE mesa SET id=?, ocupada=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
          //  ps.setString(1, sl.getNombre());
            ps.setInt(2, sl.isOcupada());
            ps.setInt(3, sl.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
