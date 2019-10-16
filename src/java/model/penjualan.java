/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

public class penjualan
{
  private Date tgl_faktur;
  private String no_faktur;
  private String nama_konsumen;
  private String kode_barang;
  private int jumlah;
  private int harga_satuan;
  private double harga_total;
  
  public Date getTgl_faktur()
  {
      return tgl_faktur;
  }
  public void setTgl_faktur(Date tgl_faktur)
  {
      this.tgl_faktur=tgl_faktur;
  }
  public String getNo_faktur()
  {
      return no_faktur;
  }
  public void setNo_faktur(String no_faktur)
  {
      this.no_faktur=no_faktur;
  }
  public String getNama_konsumen()
  {
      return nama_konsumen;
  }
  public void setNama_konsumen(String nama_konsumen)
  {
      this.nama_konsumen=nama_konsumen;
  }
  public String getKode_barang()
  {
      return kode_barang;
  }
  public void setKode_barang(String kode_barang)
  {
      this.kode_barang=kode_barang;
  }
  public int getJumlah()
  {
      return jumlah;
  }
  public void setJumlah(int jumlah)
  {
      this.jumlah=jumlah;
  }
  public int getHarga_satuan()
  {
      return harga_satuan;
  }
  public void setHarga_satuan(int harga_satuan)
  {
      this.harga_satuan=harga_satuan;
  }
  public double getHarga_total()
  {
      return harga_total;
  }
  public void setHarga_total(double harga_total)
  {
      this.harga_total=harga_total;
  }
  
}
