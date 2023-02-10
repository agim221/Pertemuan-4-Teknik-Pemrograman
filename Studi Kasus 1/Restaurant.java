package Pertemuan4;

public class Restaurant {
	private Menu[] menus;
	private static byte id = -1;
		
	public Restaurant() {
		menus = new Menu[10];
	}
	
	public void tambahMenuMakanan(String nama, double harga, int stok) {
		this.nextId();
		menus[id] = new Menu();
		menus[id].setNama_makanan(nama);
		menus[id].setHarga_makanan(harga);
		menus[id].setStok(stok);
	}
	
	public void tampilkanMenuMakanan() {
		for(int i = 0; i <= id; i++) {
			if(!isOutOfStock(i)) {
				System.out.println(menus[i].getNama_makanan() + "["+menus[i].getStok()+"]"+"\tRp. "+menus[i].getHarga_makanan());
			}
		}
	}
	
	public void pesanMakanan(String nama, int jumlah) {
		int index = indexMakanan(nama);
		if(!(isOutOfStock(index))) {
			if(jumlah <= menus[index].getStok()) {
				menus[index].setStok(menus[index].getStok() - jumlah);
				
			} else {
				System.out.println("Stok Tidak Cukup");
			}
		} else {
			System.out.println("Stok Kosong");
		};
	}
	
	public int indexMakanan(String nama) {
		int index = 0;
		
		while(!(nama.equals(menus[index].getNama_makanan()))) {
			index++;
		}
		
		return index;
	}
	
	public boolean isOutOfStock(int id) {
		if(menus[id].getStok() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public Menu[] getMenus() {
		return menus;
	}

	public void nextId() {
		id++;
	}	
}