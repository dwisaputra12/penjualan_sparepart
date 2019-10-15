/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class barang_master
{
    private String kode_barang;
    private String nama_barang;
    private float harga_jual;
    private float harga_beli;
    private int satuan;
    private String kategori;
    
    public String getKode_barang()
    {
        return kode_barang;
    }
    public void setKode_barang(String kode_barang)
    {
        this.kode_barang=kode_barang;
    }
    public String getNama_barang()
    {
        return nama_barang;
    }
    public void setNama_barang(String nama_barang)
    {
        this.nama_barang=nama_barang;
    }
    public float getHarga_jual()
    {
        return harga_jual;
    }
    public void setHarga_jual(float harga_jual)
    {
        this.harga_jual=harga_jual;
    }
    public float getHarga_beli()
    {
        return harga_beli;
    }
    public void setHarga_beli(float harga_beli)
    {
        this.harga_beli=harga_beli;
    }
    public int getSatuan()
    {
        return satuan;
    }
    public void setSatuan(int satuan)
    {
        this.satuan=satuan;
    }
    public String getKategori()
    {
        return kategori;
    }
    public void setKategori(String kategori)
    {
        this.kategori=kategori;
    }
}
