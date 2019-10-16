/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.barangDAO;
import connect.koneksi;
import implDAO.implBarang_master;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.penjualan;

/**
 *
 * @author rian
 */
@WebServlet(name = "pembayaranController", urlPatterns = {"/pembayaranController"})
public class pembayaranController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pembayaranController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pembayaranController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String act = request.getParameter("act");
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String act = request.getParameter("act");
        Date date = Date.valueOf(request.getParameter("date"));
        String no_faktur = request.getParameter("no_faktur");
        String nama_konsumen = request.getParameter("nama_konsumen");
        String kd_barang = request.getParameter("kd_barang");
        int jumlah = Integer.parseInt(request.getParameter("qty"));
        int harga_satuan = Integer.parseInt(request.getParameter("totalHarga"));
        double harga_total = Double.valueOf(request.getParameter("orderTotal"));
        int satuan = Integer.parseInt(request.getParameter("satuan"));
        int qty = Integer.parseInt(request.getParameter("pesanan"));
        String kode_barang = request.getParameter("kode_barang");
        if (act.equals("bayar"))
        {
            barangDAO dao = new implBarang_master(koneksi.getConnection());
            barangDAO update = new implBarang_master(koneksi.getConnection());
            penjualan model = new penjualan();
            model.setTgl_faktur(date);
            model.setNo_faktur(no_faktur);
            model.setNama_konsumen(nama_konsumen);
            model.setKode_barang(kd_barang);
            model.setJumlah(jumlah);
            model.setHarga_satuan(harga_satuan);
            model.setHarga_total(harga_total);
            
            dao.insertPenjualan(model);
            update.updatePembayaran(satuan, qty, kode_barang);
             
            RequestDispatcher rd = request.getRequestDispatcher("Sukses.jsp");
           rd.forward(request, response);
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
