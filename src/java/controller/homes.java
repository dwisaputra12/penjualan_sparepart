/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import connect.koneksi;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.barangDAO;
import java.sql.*;

import implDAO.implBarang_master;

import model.barang_master;

/**
 *
 * @author Muhammad Ferly
 */
@WebServlet(name = "homes", urlPatterns = {"/homes"})
public class homes extends HttpServlet {

    @Override
      protected void doPost(HttpServletRequest request , HttpServletResponse response)
      throws ServletException ,IOException
      {
          String act = request.getParameter("act");
          barangDAO barang = new implBarang_master(koneksi.getConnection());
          PrintWriter out = response.getWriter();
          
          if (act.equals("tambah")) 
                  { 
                   String kode_barang = request.getParameter("kode_barang");
                   String nama_barang = request.getParameter("nama_barang");
                   float harga_jual   = Float.valueOf(request.getParameter("harga_jual"));
                   float harga_beli   = Float.valueOf(request.getParameter("harga_beli"));
                   int satuan         = Integer.parseInt(request.getParameter("satuan"));
                   String kategori    = request.getParameter("kategori");
          
                    barang_master model = new barang_master();
                    model.setKode_barang(kode_barang);
                    model.setNama_barang(nama_barang);
                    model.setHarga_jual(harga_jual);
                    model.setHarga_beli(harga_beli);
                    model.setSatuan(satuan);
                    model.setKategori(kategori);
                    barang.insertBarang(model);
                    
                        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
           rd.include(request, response);
           
                     }
                  }
          
          
          
          
      }

   
