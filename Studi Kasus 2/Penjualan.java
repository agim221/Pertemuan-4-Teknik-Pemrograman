package Pertemuan4;

public class Penjualan extends Produk {
	private int[] totalPerMakanan;
	private int[] jumlahPerMakanan;
	
	public Penjualan() {
		super();
		totalPerMakanan = new int[10];
		jumlahPerMakanan = new int[10];
	}
	
	public void tambahMenuMakanan(String nama, int harga, int stok) {
		nextId();;
		super.setNamaMakanan(nama);
		super.setHargaMakanan(harga);
		super.setStok(stok);
	}
	
	public void hapusPesanan(String nama, int jumlah) {
		int index = super.indexMakanan(nama.toLowerCase());
		if(jumlahPerMakanan[index] != 0) {
			if(jumlah <= super.getStok()[index]) {
				super.setStok(super.getStok()[index] - jumlah, index);
				jumlahPerMakanan[index] -= jumlah;
				totalPerMakanan[index] -= (super.getHargaMakanan()[index] * jumlah);
				System.out.println("Menghapus Pesanan Berhasil");
			} else {
				System.out.println("Gagal Menhapus Pesan");
			}
		} else {
			System.out.println("Pesanan Tidak Ada");
		}
	}
	
	public void tambahkanPesanan(String nama, int jumlah) {
		int index = super.indexMakanan(nama.toLowerCase());
		if(!(super.isOutOfStock(index))) {
			if(jumlah <= super.getStok()[index]) {
				super.setStok(super.getStok()[index] - jumlah, index);
				jumlahPerMakanan[index] += jumlah;
				totalPerMakanan[index] += (super.getHargaMakanan()[index] * jumlah);
				System.out.println("Menambah Pesanan Berhasil");
			} else {
				System.out.println("Stok Tidak Cukup");
			}
		} else {
			System.out.println("Stok Kosong");
		}
	}
	
	public void tampilkanMenuTersedia() {
		int i;
		for(i = 0;i <= super.getId();i++) {
			System.out.printf("%-2d. %-15s      Rp. %d\n", i + 1, super.getNamaMakanan()[i], super.getHargaMakanan()[i]);
		}
	}
	
	public void tampilkanMenuYangDiPesan() {
		int i;
		int angka = 0;
		System.out.println("No |      Nama Produk    |   Jumlah   |    Harga    |");
		for(i = 0;i < 10;i++) {
//			-15s%03d%n
			if(totalPerMakanan[i] != 0) System.out.printf("%-3d|%-20s | %-11d| Rp. %-5d   |\n",++angka, super.getNamaMakanan()[i], jumlahPerMakanan[i], totalPerMakanan[i]);
		}
		System.out.printf("Total Harga                           |   %d     |\n",hitungTotalHarga());
	}
	
	public void kosongkanPesanan() {
		for(int i = 0; i < 10;i++) {
			totalPerMakanan[i] = 0;
			jumlahPerMakanan[i] = 0;
		}
	}
	
	public int hitungTotalHarga() {
		int total = 0;
		for(int i = 0; i < 10;i++) {
			if(totalPerMakanan[i] != 0) total += totalPerMakanan[i];
		}
		
		return total;
	}
 
}