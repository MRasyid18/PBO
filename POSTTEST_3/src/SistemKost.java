import java.util.ArrayList;
import java.util.Scanner;

public class SistemKost {
    private static ArrayList<KamarKost> daftarKamar = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Data Dummy Awal
        daftarKamar.add(new KamarSingle("A01", "Budi", 800000, false));
        daftarKamar.add(new KamarDouble("B01", "Siti", "Rina", 1200000, false));
        daftarKamar.add(new KamarSuite("C01", "-", "AC, TV", 2500000, true)); // Kamar Kosong

        boolean jalan = true;
        while (jalan) {
            System.out.println("\n============================================");
            System.out.println("   SISTEM PENDATAAN KAMAR KOST - ASCII KOST");
            System.out.println("============================================");
            System.out.println(" 1. Tambah KamarBaru");
            System.out.println(" 2. Lihat Semua Kamar");
            System.out.println(" 3. Ubah Data Kamar");
            System.out.println(" 4. Hapus Kamar");
            System.out.println(" 5. Keluar Program");
            System.out.println("============================================");
            System.out.print("Pilih menu (1-5): ");
            String pilihan = input.nextLine();

            if (pilihan.equals("1")) {
                tambahKamar();
            } else if (pilihan.equals("2")) {
                lihatSemuaKamar();
            } else if (pilihan.equals("3")) {
                ubahKamar();
            } else if (pilihan.equals("4")) {
                hapusKamar();
            } else if (pilihan.equals("5")) {
                System.out.println("Terima kasih! Program dihentikan.");
                jalan = false;
            } else {
                System.out.println("[!] Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahKamar() {
        System.out.println("\n--- TAMBAH KAMAR BARU ---");
        System.out.print("Masukkan Nomor Kamar Baru: ");
        String nomor = input.nextLine();

        // Validasi jika nomor kamar sudah ada
        if (cariIndexKamar(nomor) != -1) {
            System.out.println("[!] Gagal: Nomor kamar " + nomor + " sudah terdaftar!");
            return;
        }

        System.out.print("Harga per Bulan (Rp): ");
        int harga = bacaAngka();
        if (harga == -1) return; 

        System.out.println("Pilih Tipe Kamar:");
        System.out.println("1. Single (1 Orang)");
        System.out.println("2. Double (2 Orang)");
        System.out.println("3. Suite (Premium)");
        System.out.print("Pilihan Tipe (1/2/3): ");
        String tipe = input.nextLine();

        System.out.print("Nama Penyewa (isi '-' jika kamar kosong): ");
        String penyewa = input.nextLine();
        boolean statusTersedia = penyewa.equals("-");

        if (tipe.equals("1")) {
            daftarKamar.add(new KamarSingle(nomor, penyewa, harga, statusTersedia));
            System.out.println("[+] Kamar Single berhasil ditambahkan!");
        } else if (tipe.equals("2")) {
            String penyewa2 = "-";
            if (!statusTersedia) {
                System.out.print("Nama Penyewa Ke-2 (isi '-' jika kosong): ");
                penyewa2 = input.nextLine();
            }
            daftarKamar.add(new KamarDouble(nomor, penyewa, penyewa2, harga, statusTersedia));
            System.out.println("[+] Kamar Double berhasil ditambahkan!");
        } else if (tipe.equals("3")) {
            System.out.print("Fasilitas Tambahan (contoh: AC, TV): ");
            String fasilitas = input.nextLine();
            daftarKamar.add(new KamarSuite(nomor, penyewa, fasilitas, harga, statusTersedia));
            System.out.println("[+] Kamar Suite berhasil ditambahkan!");
        } else {
            System.out.println("[!] Tipe kamar tidak dikenali. Batal menambahkan.");
        }
    }

    private static void lihatSemuaKamar() {
        System.out.println("\n--- DAFTAR SEMUA KAMAR ---");
        if (daftarKamar.isEmpty()) {
            System.out.println("[!] Belum ada data kamar terdaftar.");
            return;
        }

        for (KamarKost kamar : daftarKamar) {
            if (kamar instanceof KamarSingle) {
                ((KamarSingle) kamar).tampilkanInfoSingle();
            } else if (kamar instanceof KamarDouble) {
                ((KamarDouble) kamar).tampilkanInfoDouble();
            } else if (kamar instanceof KamarSuite) {
                ((KamarSuite) kamar).tampilkanInfoSuite();
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("Total kamar terdaftar: " + daftarKamar.size());
    }

    private static void ubahKamar() {
        System.out.println("\n--- UBAH DATA KAMAR ---");
        System.out.print("Masukkan Nomor Kamar yang ingin diubah: ");
        String nomor = input.nextLine();

        int index = cariIndexKamar(nomor);
        if (index == -1) {
            System.out.println("[!] Kamar dengan nomor " + nomor + " tidak ditemukan.");
            return;
        }

        KamarKost kamar = daftarKamar.get(index);

        System.out.print("Ubah Nomor Kamar (tekan Enter jika tidak ingin diubah) [" + kamar.getNomorKamar() + "]: ");
        String nomorBaru = input.nextLine();
        if (!nomorBaru.isEmpty()) kamar.setNomorKamar(nomorBaru);

        System.out.print("Ubah Harga/Bulan (ketik -1 jika tidak ingin diubah) [" + kamar.getHargaPerBulan() + "]: ");
        int hargaBaru = bacaAngka();
        if (hargaBaru != -1) kamar.setHargaPerBulan(hargaBaru);

        System.out.print("Ubah Nama Penyewa 1 (tekan Enter jika tidak ingin diubah) [" + kamar.getNamaPenyewa() + "]: ");
        String penyewaBaru = input.nextLine();
        if (!penyewaBaru.isEmpty()) {
            kamar.setNamaPenyewa(penyewaBaru);
            kamar.setTersedia(penyewaBaru.equals("-"));
        }

        // Mengecek instance untuk mengupdate properti milik Child Class
        if (kamar instanceof KamarDouble) {
            KamarDouble kDouble = (KamarDouble) kamar;
            System.out.print("Ubah Nama Penyewa 2 (tekan Enter jika tidak ingin diubah) [" + kDouble.getNamaPenyewa2() + "]: ");
            String penyewa2Baru = input.nextLine();
            if (!penyewa2Baru.isEmpty()) kDouble.setNamaPenyewa2(penyewa2Baru);
            
        } else if (kamar instanceof KamarSuite) {
            KamarSuite kSuite = (KamarSuite) kamar;
            System.out.print("Ubah Fasilitas (tekan Enter jika tidak ingin diubah) [" + kSuite.getFasilitasTambahan() + "]: ");
            String fasilitasBaru = input.nextLine();
            if (!fasilitasBaru.isEmpty()) kSuite.setFasilitasTambahan(fasilitasBaru);
        }

        System.out.println("[v] Data kamar berhasil diperbarui!");
    }

    private static void hapusKamar() {
        System.out.println("\n--- HAPUS KAMAR ---");
        System.out.print("Masukkan Nomor Kamar yang ingin dihapus: ");
        String nomor = input.nextLine();

        int index = cariIndexKamar(nomor);
        if (index == -1) {
            System.out.println("[!] Kamar dengan nomor " + nomor + " tidak ditemukan.");
        } else {
            daftarKamar.remove(index);
            System.out.println("[-] Kamar " + nomor + " berhasil dihapus secara permanen.");
        }
    }

    // Fungsi utilitas untuk mencari index array
    private static int cariIndexKamar(String nomor) {
        for (int i = 0; i < daftarKamar.size(); i++) {
            if (daftarKamar.get(i).getNomorKamar().equalsIgnoreCase(nomor)) {
                return i;
            }
        }
        return -1;
    }

    private static int bacaAngka() {
        try {
            String str = input.nextLine();
            if (str.isEmpty()) return -1;
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("[!] Input tidak valid, angka tidak diubah.");
            return -1;
        }
    }
}