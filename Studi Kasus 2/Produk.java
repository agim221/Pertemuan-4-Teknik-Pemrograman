package Pertemuan4;

public class Produk {
	private String[] namaMakanan;
	private int[] hargaMakanan; 
	private int[] stok;
	private int id = -1;
	
	public Produk() {
		namaMakanan= new String[10];
		hargaMakanan = new int[10];
		stok = new int[10];
	}
	
	
	public void tampilkanMenuTersedia() {
		int i;
		for(i = 0;i <= id;i++) {
			System.out.printf("%d. %s      Rp. %d\n", i + 1, namaMakanan[i], hargaMakanan[i]);
		}
	}
	
	public int indexMakanan(String nama) {
		int index = 0;
		
		while(!(nama.equals(namaMakanan[index].toLowerCase()))) {
			index++;
		}
		
		return index;
	}
	
	
	public boolean isOutOfStock(int id) {
		if(stok[id] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void nextId() {
		id++;
	}


	public String[] getNamaMakanan() {
		return namaMakanan;
	}


	public void setNamaMakanan(String namaProduk) {
		this.namaMakanan[id] = namaProduk;
	}


	public int[] getHargaMakanan() {
		return hargaMakanan;
	}


	public void setHargaMakanan(int hargaProduk) {
		this.hargaMakanan[id] = hargaProduk;
	}


	public int[] getStok() {
		return stok;
	}


	public void setStok(int stok) {
		this.stok[id] = stok;
	}
	
	public void setStok(int stok, int index) {
		this.stok[index] = stok;
	}


	public int getId() {
		return id;
	}
	
}
