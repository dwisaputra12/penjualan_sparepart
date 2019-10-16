/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keranjangbean;

public class cartItemBean {
     private String kode_barang;
    private String nama_barang;
    private int harga_jual;
    private int harga_beli;
    private int satuan;
    private String kategori;
    private int iQty;
    private int dblTotalHarga;
     
    public String getKode_barang() {
        return kode_barang;
    }
    public void setKode_barang(String kode_barang) {
        this.kode_barang=kode_barang;
    }
    public String getNama_barang() {
        return nama_barang;
    }
    public void setNama_barang(String nama_barang) {
        this.nama_barang=nama_barang;
    }
    public int getHarga_jual() {
        return harga_jual;
    }
    public void setHarga_jual(int harga_jual) {
        this.harga_jual= harga_jual;
    }
    public int getQty() {
        return iQty;
    }
    public void setQuantity(int satuan) {
        iQty = satuan;
    }
    public double getTotalHarga() {
        return dblTotalHarga;
    }
    public void setTotalHarga(int dblTotalHarga) {
        this.dblTotalHarga =  dblTotalHarga;
    }
}
