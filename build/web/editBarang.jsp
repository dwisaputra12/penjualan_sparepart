<%-- 
    Document   : editBarang
    Created on : Oct 15, 2019, 11:37:32 PM
    Author     : Muhammad Ferly
--%>

<%@page import="implDAO.implBarang_master"%>
<%@page import="connect.koneksi"%>
<%@page import="DAO.barangDAO"%>
<%@page import="DAO.barangDAO"%>
<%@page import="model.barang_master"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Penjualan Sparepart/edit</title>
    </head>
    <body>
         <%
            barang_master model = (barang_master) request.getAttribute("a");
            barangDAO dao = new implBarang_master(koneksi.getConnection());
 
        %>
        <form method="POST" action="edit_Barang?act=edit">
                <input type="text"  name="kode_barang"  value="<%=model.getKode_barang() %>" readonly="true"> 
                <input type="text" name="nama_barang" value="<%=model.getNama_barang() %>">
                <input type="text" name="harga_jual"  value="<%=model.getHarga_jual() %>">
                <input type="text" name="harga_beli"  value="<%=model.getHarga_beli() %>">
                <input type="text" name="satuan"  value="<%=model.getSatuan() %>">
                <input type="text" name="kategori"  value="<%=model.getKategori() %>">
                <input type="submit" value="submit">
            </form>
    </body>
</html>
