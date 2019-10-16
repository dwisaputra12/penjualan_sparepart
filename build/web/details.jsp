<%-- 
    Document   : details
    Created on : Oct 16, 2019, 11:35:10 AM
    Author     : rian
--%>

<%@page import="model.barang_master"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% barang_master model = (barang_master) request.getAttribute("a"); %>
        <h1>Barang Details </h1>
        <form method="POST" action="cartController">
            
            kode Barang : <%= model.getKode_barang()%><input type="hidden" name="kode_barang" value="<%= model.getKode_barang()%>"><br>
            nama Barang : <%= model.getNama_barang()%><input type="hidden" name="nama_barang" value="<%= model.getNama_barang()%>"><br>
            satuan      : <%= model.getSatuan() %><input type="hidden" name="satuan" value="<%= model.getSatuan()%>"><br>
            kategori    : <%= model.getKategori()%><input type="hidden" name="kategori" value="<%= model.getKategori()%>"><br>
            harga       : <%= model.getHarga_jual()%><input type="hidden" name="harga_jual" value="<%= model.getHarga_jual() %>"><br>
            
            Quantity :<input type="text" name="satuan" value="1"/><br><br>
            <input type="hidden" name="act" value="add">
            <input type="submit" name="addToCart" value="tambah"><br/>
        </form>
         
    </body>
</html>
