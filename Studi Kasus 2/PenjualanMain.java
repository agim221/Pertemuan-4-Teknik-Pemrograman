package Pertemuan4;

import java.util.Scanner;

public class PenjualanMain {

	public static void main(String[] args) {
		Penjualan resto = new Penjualan();
		Scanner in = new Scanner(System.in);
		String pesanan = "";
		String lagi;
		int jumlah;
		int pilih;
		int uang;
		
		resto.tambahMenuMakanan("Siomay", 17000, 20);
		resto.tambahMenuMakanan("Mie", 12000, 34);
		resto.tambahMenuMakanan("Batagor", 15000, 0);
		resto.tambahMenuMakanan("Gehu", 10000, 7);
		resto.tambahMenuMakanan("Ayam", 25000, 15);
		resto.tambahMenuMakanan("Cappucino", 15000, 21);
		resto.tambahMenuMakanan("Matcha", 18000, 13);
		resto.tambahMenuMakanan("ThaiTea", 17000, 22);
		resto.tambahMenuMakanan("Chocolatte", 20000, 3);
		resto.tambahMenuMakanan("MilkTea", 19000, 10);
		
		do {
			
			do {
				resto.tampilkanMenuTersedia();
				System.out.println("Ingin Memesan Apa ?");
				pilih = in.nextInt();
				switch(pilih) {
				case 1: pesanan = new String("Siomay");break;
				case 2: pesanan = new String("Mie");break;
				case 3: pesanan = new String("Batagor");break;
				case 4: pesanan = new String("Gehu");break;
				case 5: pesanan = new String("Ayam");break;
				case 6: pesanan = new String("Cappucino");break;
				case 7: pesanan = new String("Matcha");break;
				case 8: pesanan = new String("ThaiTea");break;
				case 9: pesanan = new String("Chocolatte");break;
				case 10: pesanan = new String("MilkTea");break;
				}
				System.out.println("Ingin Memesan Berapa ?");
				jumlah = in.nextInt();
				resto.tambahkanPesanan(pesanan, jumlah);
				System.out.printf("Apakah Ingin Memesan Makanan Lagi ? (Y/N)" );
				lagi = in.next();
			} while(lagi.toUpperCase().equals("Y"));

			resto.tampilkanMenuYangDiPesan();
			System.out.println("Apakah Ingin Menghapus Pesanan ? (Y/N)");
			lagi = in.next();
			while(lagi.toUpperCase().equals("Y")) {
				System.out.println("Ingin Menghapus Pesanan Apa ? Ketikan Nama Pesanan!");
				pesanan = in.next();
				System.out.println("Ingin Menhapus Berapa ?");
				jumlah = in.nextInt();
				resto.hapusPesanan(pesanan, jumlah);
				resto.tampilkanMenuYangDiPesan();
				System.out.println("Apakah Ingin Menghapus Pesanan Lagi ? (Y/N)");
				lagi = in.next();
			}
			for(;;) {
				resto.tampilkanMenuYangDiPesan();
				System.out.println("Masukan Uang Anda...");
				uang = in.nextInt();
				if(uang >= resto.hitungTotalHarga()) {
					System.out.println("Pembayaran Sukses!!!");
					break;
				}
			System.out.println("Pembayaran Gagal, Uang Kurang!!!");
			}
			System.out.println("Apakah Ingin Memesan Pesanan Lagi ? (Y/N)");
			lagi = in.next();
			if(lagi.toUpperCase().equals("Y")) resto.kosongkanPesanan();
		} while(lagi.toUpperCase().equals("Y"));
	}

}
