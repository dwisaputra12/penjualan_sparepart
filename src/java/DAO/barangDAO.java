/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.barang_master;

public interface barangDAO{
  public void insertBarang (barang_master model);
  public void deleteBarang(String kode_barang);
  public ArrayList<barang_master> listAll();  
  public void editBarang(barang_master barang);
  public barang_master findBarang(String kode_barang);
  public barang_master prepareEdit(String kode_barang);
  public barang_master prepareDetail(String kode_barang);

}