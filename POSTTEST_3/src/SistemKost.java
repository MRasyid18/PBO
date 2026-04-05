import java.util.ArrayList;
import java.util.Scanner;

public class SistemKost {
    private static ArrayList<KamarKost> daftarKamar = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        daftarKamar.add(new KamarSingle("A01", "Budi", 800000, false));
        daftarKamar.add(new KamarSingle("A02", "-", 800000, true));
        daftarKamar.add(new KamarDouble("B01", "Siti", "Rina", 1200000, false));
        daftarKamar.add(new KamarSuite("C01", "Andi", "AC, TV, WiFi", 2500000, false));

        boolean jalan = true;

        while (jalan) {
            tampilkanMenu();
            int pilihan = bacaAngka();

            switch (pilihan) {
                case 1:
                    tambahKamar();
                    break;
                case 2:
                    lihatSemuaKamar();
                    break;
                case 3:
                    ubahKamar();
                    break;
                case 4:
                    hapusKamar();
                    break;
                case 5:
                    System.out.println("\nTerima kasih! Program selesai.");
                    jalan = false;
                    break;
                default:
                    System.out.println("\n[!] Menu tidak valid. Coba lagi.");
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("\n============================================");
        System.out.println("   SISTEM PENDATAAN KAMAR KOST - ASCII KOST");
        System.out.println("============================================");
        System.out.println(" 1. Tambah Kamar Baru");
        System.out.println(" 2. Lihat Semua Kamar");
        System.out.println(" 3. Ubah Data Kamar");
        System.out.println(" 4. Hapus Kamar");
        System.out.println(" 5. Keluar Program");
        System.out.println("============================================");
        System.out.print("Pilih menu: ");
    }

    private static void tampilkanSatuKamar(KamarKost kamar) {
        kamar.tampilkanInfo();
        if (kamar instanceof KamarSingle) {
            ((KamarSingle) kamar).tampilkanTipeKamar();
        } else if (kamar instanceof KamarDouble) {
            ((KamarDouble) kamar).tampilkanTipeKamar();
        } else if (kamar instanceof KamarSuite) {
            ((KamarSuite) kamar).tampilkanTipeKamar();
        }
    }

    private static void tambahKamar() {
        System.out.println("\n--- TAMBAH KAMAR BARU ---");

        System.out.print("Nomor Kamar   : ");
        String nomor = input.nextLine();

        System.out.print("Tipe Kamar (Single/Double/Suite): ");
        String tipe = input.nextLine().trim();

        System.out.print("Harga per Bulan (Rp): ");
        int harga = bacaAngka();

        System.out.print("Nama Penyewa (isi '-' jika kosong): ");
        String penyewa = input.nextLine();

        boolean statusTersedia = penyewa.equals("-");

        KamarKost kamarBaru;

        if (tipe.equalsIgnoreCase("Single")) {
            kamarBaru = new KamarSingle(nomor, penyewa, harga, statusTersedia);

        } else if (tipe.equalsIgnoreCase("Double")) {
            System.out.print("Nama Penyewa 2 (isi '-' jika kosong): ");
            String penyewa2 = input.nextLine();
            kamarBaru = new KamarDouble(nomor, penyewa, penyewa2, harga, statusTersedia);

        } else if (tipe.equalsIgnoreCase("Suite")) {
            System.out.print("Fasilitas Tambahan (contoh: AC, TV, WiFi): ");
            String fasilitas = input.nextLine();
            kamarBaru = new KamarSuite(nomor, penyewa, fasilitas, harga, statusTersedia);

        } else {
            System.out.println("[!] Tipe kamar tidak dikenali. Kamar tidak ditambahkan.");
            return;
        }

        daftarKamar.add(kamarBaru);
        System.out.println("[+] Kamar " + nomor + " (" + tipe + ") berhasil ditambahkan!");
    }

    private static void lihatSemuaKamar() {
        System.out.println("\n--- DAFTAR SEMUA KAMAR ---");

        if (daftarKamar.isEmpty()) {
            System.out.println("[!] Belum ada data kamar.");
        } else {
            for (KamarKost kamar : daftarKamar) {
                tampilkanSatuKamar(kamar);
            }
            System.out.println("--------------------------------------------");
            System.out.println("Total kamar terdaftar: " + daftarKamar.size());
        }
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

        System.out.println("\nData kamar saat ini:");
        tampilkanSatuKamar(kamar);

        System.out.print("Nama Penyewa baru (isi '-' jika kosong): ");
        String penyewaBaru = input.nextLine();

        kamar.setNamaPenyewa(penyewaBaru);
        kamar.setTersedia(penyewaBaru.equals("-"));

        // Jika kamar Double, tawarkan update penyewa 2
        if (kamar instanceof KamarDouble) {
            System.out.print("Nama Penyewa 2 baru (isi '-' jika kosong): ");
            String penyewa2Baru = input.nextLine();
            ((KamarDouble) kamar).setNamaPenyewa2(penyewa2Baru);
        }

        // Jika kamar Suite, tawarkan update fasilitas
        if (kamar instanceof KamarSuite) {
            System.out.print("Fasilitas Tambahan baru: ");
            String fasilitasBaru = input.nextLine();
            ((KamarSuite) kamar).setFasilitasTambahan(fasilitasBaru);
        }

        System.out.println("[v] Data kamar " + nomor + " berhasil diperbarui!");
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
            System.out.println("[-] Kamar " + nomor + " berhasil dihapus.");
        }
    }

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
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("[!] Input harus berupa angka.");
            return -1;
        }
    }
}