<%-- 
    Document   : admin
    Created on : Oct 15, 2019, 8:45:27 PM
    Author     : Muhammad Ferly
--%>

<%@page import="java.util.ArrayList"%>
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
        <title>Penjualan Sparepart</title>
    </head>
    <body>
        <form name="tambah" method="POST"   action ="homes?act=tambah">
                
                <br/>
                
                
                <br/>
                <input type="text" name="kode_barang" placeholder="masukan kode barang">
<!--                <span class="text-danger" id="eror_nama"></span>-->
                <br/><br/>
                
                <br/>
                <input type="text" name="nama_barang" placeholder="masukan nama barang">
<!--                <span class="text-danger" id="eror_alamat"></span>-->
                <br/><br/>
                
                <br/>
                <input type="text" name="harga_jual" placeholder="masukan harga jual" >
                <span class="text-danger" id="eror_email"></span>
                <br/><br/>
                No Telp 
                <br/>
                <input type ="text" name="harga_beli" placeholder="masukan harga beli" >
                <span class="text-danger" id="eror_phone"></span>
                <br/><br/>
               Password
               <br/>
               <input type="text" name="satuan" placeholder="masukan satuan">
               <span class="text-danger" id="eror_password"></span>
               <br/><br/>
               <input type="text" name="kategori" placeholder="masukan kategori">
<!--               <span class="text-danger" id="eror_password"></span>-->
               <br/><br/>
               
               <input type="submit" name="submit" value="Daftar">
                  
            </form>
        <hr>
        <% 
            barang_master bm = new barang_master();
            barangDAO dao = new implBarang_master(koneksi.getConnection()); 
            ArrayList<barang_master> arr = dao.listAll();
         %>
         
         <table >
            <tr>
            <th> <p>Kode Barang</p></th>
            <th><p>Nama Barang</p></th>
            <th><p>Harga Beli</p></th>
            <th><p>Harga Jual</p></th>
            <th><p>Satuan</p></th>
            <th><p>Kategori</p></th>
            </tr>
            <%
                for(int x=0; x<arr.size();x++)
            {%>
             <tr>
                 <td><%=arr.get(x).getKode_barang() %></td>
                 <td><%=arr.get(x).getNama_barang() %></td>
                 <td><%=arr.get(x).getHarga_beli() %></td>
                 <td><%=arr.get(x).getHarga_jual()%></td>
                 <td><%=arr.get(x).getSatuan()%></td>
                 <td><%=arr.get(x).getKategori()%></td>
                 <td>
                     
                     <a href ="edit_Barang?act=edit&kode_barang=<%=arr.get(x).getKode_barang() %>">EDIT</a>
                     <a href="deleteBarang?act=hapus&kode_barang=<%=arr.get(x).getKode_barang() %>">HAPUS</a>
                 </td>
             </tr>
             <%}%>
           </table>
    </body>
</html>
