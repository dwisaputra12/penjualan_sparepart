/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implDAO;
import DAO.barangDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.barang_master;
import java.sql.*;
import java.util.ArrayList;
import model.penjualan;

public class implBarang_master implements barangDAO
{
    private Connection connection;
    public implBarang_master(Connection connection)
    {
        this.connection=connection;
    }
    @Override
    public void insertBarang(barang_master model) {
       PreparedStatement ps = null;
        ResultSet rs = null;
        try 
        {
            String sql = "insert into master_barang (kode_barang,nama_barang,harga_jual,harga_beli,satuan,kategori) values(?,?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,model.getKode_barang());
            ps.setString(2,model.getNama_barang());
            ps.setInt(3,model.getHarga_jual());
            ps.setInt(4,model.getHarga_beli());
            ps.setInt(5,model.getSatuan());
            ps.setString(6,model.getKategori());
            
            
            ps.executeUpdate();
        }catch (SQLException ex)
        {
            Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
        }
        finally 
        {
            if (connection!=null) try
            {
               connection.close();
            }catch(SQLException ex)
            {
                Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
            }
            if (ps!=null) try
            {
                ps.close();
            }catch(SQLException ex)
            {
                Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }

    @Override
    public void deleteBarang(String kode_barang) {
        Statement stat = null;
      try {
          stat = connection.createStatement();
           stat.executeUpdate("delete from master_barang where kode_barang='"+kode_barang+"'");
           connection.commit();
       }catch(SQLException ex)
       {
           Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
       }
    }

    @Override
    public ArrayList<barang_master> listAll() {
        ArrayList<barang_master> result= new ArrayList<barang_master>(); 
       
       Statement stat = null;
       ResultSet rs = null;
       try 
       {
          stat = connection.createStatement();
          String sql = "select * from master_barang";
          rs = stat.executeQuery(sql);
          while(rs.next())
          {
              barang_master model = new barang_master();
              model.setKode_barang(rs.getString("kode_barang"));
              model.setNama_barang(rs.getString("nama_barang"));
              model.setHarga_jual(rs.getInt("harga_jual"));
              model.setHarga_beli(rs.getInt("harga_beli"));
              model.setSatuan(rs.getInt("satuan"));
              model.setKategori(rs.getString("kategori"));
              result.add(model);
          }
       }catch(SQLException ex)
       {
           Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
       }   
    return result;
    }

    @Override
    public void editBarang(barang_master barang) {
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
          ps = connection.prepareStatement("update master_barang set nama_barang=?,harga_jual=?,harga_beli=?,satuan=?,kategori=? where kode_barang=?");
           ps.setString(1,barang.getNama_barang()); 
           ps.setInt(2,barang.getHarga_beli());
           ps.setInt(3,barang.getHarga_jual());
           ps.setInt(4,barang.getSatuan());
           ps.setString(5,barang.getKategori());
           ps.setString(6,barang.getKode_barang());
           
            ps.executeUpdate();
            connection.commit();
        }catch(SQLException ex)
        {
               Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
        }
        finally
        {
            if (connection!=null) try
            {
                connection.close();
            }catch(SQLException ex)
            {
                Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
            }
            if(rs!=null) try
            {
                rs.close();
            }catch(SQLException ex)
            {
                Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
            }
            if(ps!=null) try 
            {
                ps.close();
            }catch(SQLException ex)
            {
                Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }

    @Override
    public barang_master findBarang(String kode_barang) {
        barang_master bm = new barang_master();
        Statement stat = null;
        PreparedStatement ps= null;
        ResultSet rs= null;
    try{
            stat= connection.createStatement();
            String sql= "select * from master_barang where kode_barang=?";
            ps= connection.prepareStatement(sql);
            ps.setString(1, kode_barang);
           rs = ps.executeQuery();
        if (rs.next())
        {
            bm.setKode_barang(kode_barang);
            bm.setNama_barang(rs.getString("nama_barang"));
            bm.setHarga_beli(rs.getInt("harga_beli"));
            bm.setHarga_jual(rs.getInt("harga_jual"));
            bm.setSatuan(rs.getInt("satuan"));
            bm.setKategori(rs.getString("kategori"));
        }
    }catch(SQLException ex)
    {
        
    }
    return bm;
    }

    @Override
    public barang_master prepareEdit(String kode_barang) {
        barang_master model = findBarang(kode_barang);
        return model;
    }

    @Override
    public barang_master prepareDetail(String kode_barang) {
        barang_master model = findBarang(kode_barang);
        return model;
    }

    @Override
    public void updatePembayaran(int satuan, int qty, String kode_barang) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        int x =0;
        int y =0;
        int z=x-y;
        try
        { 
           x = (satuan);
           y = (qty);
           z = x-y;

            barang_master model = new barang_master();
            String sql= "update master_barang set satuan=? where kode_barang='"+kode_barang+"'";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,z);
            ps.executeUpdate();
        }catch(SQLException ex)
        {
             Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
        }
        finally
        {
            if(ps!=null) try
            {
                ps.close();
            }catch(SQLException ex)
            {
                  Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
            }
            if(rs!=null) try
            {
                rs.close();
            }catch(SQLException ex)
            {
                  Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }

    @Override
    public void insertPenjualan(penjualan model) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try 
        {
           
            String sql = "insert into penjualan (tgl_faktur,no_faktur,nama_konsumen,kode_barang,jumlah,harga_satuan,harga_total) values(?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setDate(1,model.getTgl_faktur());
            ps.setString(2,model.getNo_faktur());
            ps.setString(3,model.getNama_konsumen());
            ps.setString(4,model.getKode_barang());
            ps.setInt(5,model.getJumlah());
            ps.setInt(6,model.getHarga_satuan());
            ps.setDouble(7,model.getHarga_total());
            
            
            ps.executeUpdate();
        }catch (SQLException ex)
        {
            Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
        }
        finally 
        {
            if (connection!=null) try
            {
               connection.close();
            }catch(SQLException ex)
            {
                Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
            }
            if (ps!=null) try
            {
                ps.close();
            }catch(SQLException ex)
            {
                Logger.getLogger(implBarang_master.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
    
}