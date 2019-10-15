<%-- 
    Document   : penjualan
    Created on : Oct 16, 2019, 12:22:21 AM
    Author     : Muhammad Ferly
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="implDAO.implBarang_master"%>
<%@page import="connect.koneksi"%>
<%@page import="DAO.barangDAO"%>
<%@page import="model.barang_master"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <% 
            barang_master bm = new barang_master();
            barangDAO dao = new implBarang_master(koneksi.getConnection()); 
            ArrayList<barang_master> barang = dao.listAll();
         %>
         <h1>Daftar Harga</h1>
        <% for (int x=0 ;x< barang.size();x++)
                { 
         %>
            
         <%}%>
    </body>
</html>
