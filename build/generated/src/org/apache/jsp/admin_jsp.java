package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import implDAO.implBarang_master;
import connect.koneksi;
import DAO.barangDAO;
import DAO.barangDAO;
import model.barang_master;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Penjualan Sparepart</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"tambah\" method=\"POST\"   action =\"homes?act=tambah\">\n");
      out.write("                \n");
      out.write("                <br/>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <br/>\n");
      out.write("                <input type=\"text\" name=\"kode_barang\" placeholder=\"masukan kode barang\">\n");
      out.write("<!--                <span class=\"text-danger\" id=\"eror_nama\"></span>-->\n");
      out.write("                <br/><br/>\n");
      out.write("                \n");
      out.write("                <br/>\n");
      out.write("                <input type=\"text\" name=\"nama_barang\" placeholder=\"masukan nama barang\">\n");
      out.write("<!--                <span class=\"text-danger\" id=\"eror_alamat\"></span>-->\n");
      out.write("                <br/><br/>\n");
      out.write("                \n");
      out.write("                <br/>\n");
      out.write("                <input type=\"text\" name=\"harga_jual\" placeholder=\"masukan harga jual\" >\n");
      out.write("                <span class=\"text-danger\" id=\"eror_email\"></span>\n");
      out.write("                <br/><br/>\n");
      out.write("                No Telp \n");
      out.write("                <br/>\n");
      out.write("                <input type =\"text\" name=\"harga_beli\" placeholder=\"masukan harga beli\" >\n");
      out.write("                <span class=\"text-danger\" id=\"eror_phone\"></span>\n");
      out.write("                <br/><br/>\n");
      out.write("               Password\n");
      out.write("               <br/>\n");
      out.write("               <input type=\"text\" name=\"satuan\" placeholder=\"masukan satuan\">\n");
      out.write("               <span class=\"text-danger\" id=\"eror_password\"></span>\n");
      out.write("               <br/><br/>\n");
      out.write("               <input type=\"text\" name=\"kategori\" placeholder=\"masukan kategori\">\n");
      out.write("<!--               <span class=\"text-danger\" id=\"eror_password\"></span>-->\n");
      out.write("               <br/><br/>\n");
      out.write("               \n");
      out.write("               <input type=\"submit\" name=\"submit\" value=\"Daftar\">\n");
      out.write("                  \n");
      out.write("            </form>\n");
      out.write("        <hr>\n");
      out.write("        ");
 
            barang_master bm = new barang_master();
            barangDAO dao = new implBarang_master(koneksi.getConnection()); 
            ArrayList<barang_master> arr = dao.listAll();
         
      out.write("\n");
      out.write("         \n");
      out.write("         <table >\n");
      out.write("            <tr>\n");
      out.write("            <th> <p>Kode Barang</p></th>\n");
      out.write("            <th><p>Nama Barang</p></th>\n");
      out.write("            <th><p>Harga Beli</p></th>\n");
      out.write("            <th><p>Harga Jual</p></th>\n");
      out.write("            <th><p>Satuan</p></th>\n");
      out.write("            <th><p>Kategori</p></th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                for(int x=0; x<arr.size();x++)
            {
      out.write("\n");
      out.write("             <tr>\n");
      out.write("                 <td>");
      out.print(arr.get(x).getKode_barang() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(arr.get(x).getNama_barang() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(arr.get(x).getHarga_beli() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(arr.get(x).getHarga_jual());
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(arr.get(x).getSatuan());
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(arr.get(x).getKategori());
      out.write("</td>\n");
      out.write("                 <td>\n");
      out.write("                     <a href=\"Detail_Komoditas?act=Detail&kode=");
      out.print(arr.get(x).getKode_barang() );
      out.write("\">Detail</a>\n");
      out.write("                     <a href =\"edit_Barang?act=edit&kode_barang=");
      out.print(arr.get(x).getKode_barang() );
      out.write("\">EDIT</a>\n");
      out.write("                     <a href=\"deleteBarang?act=hapus&kode_barang=");
      out.print(arr.get(x).getKode_barang() );
      out.write("\">HAPUS</a>\n");
      out.write("                 </td>\n");
      out.write("             </tr>\n");
      out.write("             ");
}
      out.write("\n");
      out.write("           </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
