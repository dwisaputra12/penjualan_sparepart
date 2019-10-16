/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keranjangbean;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class cartBean{
    private ArrayList alCartItems = new ArrayList();
    private int allorderTotal;
    public int getLineItemCount()
    {
        return alCartItems.size();
    }
    public void deleteCartItem(String strItemIndex) {
            int iItemIndex = 0;
            try {
             iItemIndex = Integer.parseInt(strItemIndex);
             alCartItems.remove(iItemIndex - 1);
             calculateOrderTotal();
            } catch(NumberFormatException nfe) {
             System.out.println("Error while deleting cart item: "+nfe.getMessage());
             nfe.printStackTrace();
            }
        }
        public void updateCartItem(String strItemIndex, String strSatuan) {
      int dblTotalHarga = 0;
      int dblHarga = 0;
      int iQty = 0;
      int iItemIndex = 0;
      cartItemBean cartItem = null;
      try {
       iItemIndex = Integer.parseInt(strItemIndex);
       iQty = Integer.parseInt(strSatuan);
       if(iQty>0) {
        cartItem = (cartItemBean)alCartItems.get(iItemIndex-1);
        dblHarga = (int) cartItem.getHarga_jual();
        dblTotalHarga= dblHarga*iQty;
        cartItem.setQuantity(iQty);
        cartItem.setTotalHarga(dblTotalHarga);
        calculateOrderTotal();
       }
      } catch (NumberFormatException nfe) {
       System.out.println("Error while updating cart: "+nfe.getMessage());
       nfe.printStackTrace();
      }
   
    }
        public void addCartItem(String kode_barang, String nama_barang,int satuan,
        String strHarga, String strSatuan) {
          int dblTotalHarga = 0;
          int dblHarga = 0;
          int iQty = 0;
          cartItemBean cartItem = new cartItemBean();
          try {
           dblHarga = Integer.parseInt(strHarga);
           iQty = Integer.parseInt(strSatuan);
           if(iQty>0) {
            dblTotalHarga = dblHarga*iQty;
            cartItem.setKode_barang(kode_barang);
            cartItem.setNama_barang(nama_barang);
            cartItem.setHarga_jual(dblHarga);
            cartItem.setQuantity(iQty);
            cartItem.setSatuan(satuan);
            cartItem.setTotalHarga(dblTotalHarga);
            alCartItems.add(cartItem);
            calculateOrderTotal();
           }

          } catch (NumberFormatException nfe) {
           System.out.println("Error while parsing from String to primitive types: "+nfe.getMessage());
           nfe.printStackTrace();
          }
        }
         public void addCartItem(cartItemBean cartItem) {
            alCartItems.add(cartItem);
        }
         public cartItemBean getCartItem(int iItemIndex) {
            cartItemBean cartItem = null;
            if(alCartItems.size()>iItemIndex) {
             cartItem = (cartItemBean) alCartItems.get(iItemIndex);
            }
            return cartItem;
         }
          public ArrayList getCartItems() {
            return alCartItems;
           }
          public void setCartItems(ArrayList alCartItems) {
            this.alCartItems = alCartItems;
           }
           public double getOrderTotal() {
            return allorderTotal;
           }
          public void setOrderTotal(int dblOrderTotal) {
              this.allorderTotal = dblOrderTotal;
                   }
                  protected void calculateOrderTotal() {
          int dblTotal = 0;
          for(int counter=0;counter<alCartItems.size();counter++) {
           cartItemBean cartItem = (cartItemBean) alCartItems.get(counter);
           dblTotal+=cartItem.getTotalHarga();

          }
          setOrderTotal(dblTotal);
         }
}
