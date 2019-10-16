package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.barang_master;

public final class details_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 barang_master model = (barang_master) request.getAttribute("a"); 
      out.write("\n");
      out.write("        <h1>Barang Details </h1>\n");
      out.write("        <form method=\"POST\" action=\"cartController\">\n");
      out.write("            \n");
      out.write("            kode Barang : ");
      out.print( model.getKode_barang());
      out.write("<input type=\"hidden\" name=\"kode_barang\" value=\"");
      out.print( model.getKode_barang());
      out.write("\"><br>\n");
      out.write("            nama Barang : ");
      out.print( model.getNama_barang());
      out.write("<input type=\"hidden\" name=\"nama_barang\" value=\"");
      out.print( model.getNama_barang());
      out.write("\"><br>\n");
      out.write("            satuan      : ");
      out.print( model.getSatuan() );
      out.write("<input type=\"hidden\" name=\"satuan\" value=\"");
      out.print( model.getSatuan());
      out.write("\"><br>\n");
      out.write("            kategori    : ");
      out.print( model.getKategori());
      out.write("<input type=\"hidden\" name=\"kategori\" value=\"");
      out.print( model.getKategori());
      out.write("\"><br>\n");
      out.write("            harga       : ");
      out.print( model.getHarga_jual());
      out.write("<input type=\"hidden\" name=\"harga_jual\" value=\"");
      out.print( model.getHarga_jual() );
      out.write("\"><br>\n");
      out.write("            \n");
      out.write("            Quantity :<input type=\"text\" name=\"qty\" value=\"1\"/><br><br>\n");
      out.write("            <input type=\"hidden\" name=\"act\" value=\"add\">\n");
      out.write("            <input type=\"submit\" name=\"addToCart\" value=\"tambah\"><br/>\n");
      out.write("        </form>\n");
      out.write("         \n");
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
