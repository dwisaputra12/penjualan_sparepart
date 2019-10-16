/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import keranjangbean.cartBean;

/**
 *
 * @author rian
 */
@WebServlet(name = "cartController", urlPatterns = {"/cartController"})
public class cartController extends HttpServlet {

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
            out.println("<title>Servlet cartController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cartController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
     
           if (act.equals("add"))
           {
               addToCart(request);
           }else if(act.equals("update"))
           {
               updateCart(request);
           }else if(act.equals("delete"))
           {
               deleteCart(request);
           }
           response.sendRedirect("keranjang.jsp");
       
       
    }
      protected void deleteCart(HttpServletRequest request) {
            HttpSession session = request.getSession();
          String strItemIndex = request.getParameter("itemIndex");
          cartBean cartBean = null;
          Object objCartBean = session.getAttribute("cart");
          if(objCartBean!=null) {
          cartBean = (cartBean) objCartBean ;
          } else {
          cartBean = new cartBean();
         }
         cartBean.deleteCartItem(strItemIndex);
      }
       protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strSatuan = request.getParameter("satuan");
        String strItemIndex = request.getParameter("itemIndex");

          cartBean CartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if(objCartBean!=null) {
         CartBean = (cartBean) objCartBean ;
        } else {
         CartBean = new cartBean();
        }
        CartBean.updateCartItem(strItemIndex, strSatuan);
       }
        protected void addToCart(HttpServletRequest request) {
            HttpSession session = request.getSession();
            String kode_barang = request.getParameter("kode_barang");
            String nama_barang = request.getParameter("nama_barang");
            int satuan = Integer.parseInt(request.getParameter("satuan"));
            String strHarga = request.getParameter("harga_jual");
            String strSatuan = request.getParameter("qty");
           

            cartBean CartBean = null;

            Object objCartBean = session.getAttribute("cart");

            if(objCartBean!=null) {
             CartBean = (cartBean) objCartBean ;
            } else {
             CartBean = new cartBean();
             session.setAttribute("cart", CartBean);
            }

            CartBean.addCartItem(kode_barang, nama_barang, satuan, strHarga, strSatuan);
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
