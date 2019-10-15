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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.barang_master;

/**
 *
 * @author Muhammad Ferly
 */
@WebServlet(name = "edit_Barang", urlPatterns = {"/edit_Barang"})
public class edit_Barang extends HttpServlet {

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
            out.println("<title>Servlet edit_Barang</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet edit_Barang at " + request.getContextPath() + "</h1>");
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
        String kode_barang = request.getParameter("kode_barang");
        barangDAO dao = new implBarang_master(koneksi.getConnection());
       if (act.equals("edit"));
       {
           barang_master person = dao.prepareEdit(kode_barang);
           request.setAttribute("a", person);
           
           RequestDispatcher rd = request.getRequestDispatcher("editBarang.jsp");
           rd.forward(request, response);
       }
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
        String act= request.getParameter("act");
        if(act.equals("edit"))
        {
        barangDAO dao = new implBarang_master(koneksi.getConnection());
        String kode_barang=request.getParameter("kode_barang");
        String nama_barang=request.getParameter("nama_barang");
        float harga_jual=Float.valueOf(request.getParameter("harga_jual"));
        float harga_beli=Float.valueOf(request.getParameter("harga_beli"));
        int satuan = Integer.parseInt(request.getParameter("satuan"));
        String kategori = request.getParameter("kategori");
        
        
        barang_master model= new barang_master();
        model.setKode_barang(kode_barang);
        model.setNama_barang(nama_barang);
        model.setHarga_beli(harga_beli);
        model.setHarga_jual(harga_jual);
        model.setSatuan(satuan);
        model.setKategori(kategori);
        
        dao.editBarang(model);
        response.sendRedirect("admin.jsp");
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
