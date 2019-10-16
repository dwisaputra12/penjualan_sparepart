<%-- 
    Document   : konfirmasi_pembayaran
    Created on : Oct 16, 2019, 4:46:43 PM
    Author     : rian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Penjualan Sparepart/konfirmasi</title>
    </head>
    <body>
        <h1>Konfirmasi Pembayaran</h1><br>
        <form name="item" method="POST" action="pembayaranController?act=bayar">
        <h2>Input Data Konsumen</h2>
        <hr>
        <input type="date" name="date" >
        <input type="text" name="no_faktur" placeholder="masukan no faktur">
        <input type="text" name="nama_konsumen" placeholder="masukan nama konsumen">
        
        
        <h2>Data Barang DiBeli</h2>
        <hr>
         <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
          <jsp:useBean id="cart" scope="session" class="keranjangbean.cartBean" />
            
          <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
               
              kode barang : <c:out value="${cartItem.kode_barang}"/><input type="hidden" name="kd_barang" value="<c:out value="${cartItem.kode_barang}"/>"><input type="hidden" name="kode_barang" value="<c:out value="${cartItem.kode_barang}"/>"><br>
              nama barang : <c:out value="${cartItem.nama_barang}"/><br> 
              Jumlah      : <c:out value="${cartItem.qty}"/>  <input type="hidden" name="qty" value="<c:out value="${cartItem.qty}"/>"><input type="hidden" name="pesanan" value="<c:out value="${cartItem.qty}"/>"><br>
              harga satuan: Rp.<c:out value="${cartItem.harga_jual}"/><br>
              total harga : Rp.<c:out value="${cartItem.totalHarga}"/><input type="hidden" name="totalHarga" value="<c:out value="${cartItem.harga_jual}"/>"><br>
              <input type="hidden" name="satuan" value="<c:out value="${cartItem.satuan}"/>"><br>
                
            </c:forEach>
            Subtotal: Rp. <c:out value="${cart.orderTotal}"/>
            <input type="hidden" name="orderTotal" value="<c:out value="${cart.orderTotal}"/>"><br>
            <input type="submit" value="oke">       
           </form>
        
    </body>
</html>
