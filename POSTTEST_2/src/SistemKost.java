import java.util.ArrayList;
import java.util.Scanner;

public class SistemKost {
    private static ArrayList<KamarKost> daftarKamar = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        daftarKamar.add(new KamarKost("A01", "Budi",   "Single", 800000,  false));
        daftarKamar.add(new KamarKost("A02", "-",      "Single", 800000,  true));
        daftarKamar.add(new KamarKost("B01", "Siti",   "Double", 1200000, false));

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

    private static void tambahKamar() {
        System.out.println("\n--- TAMBAH KAMAR BARU ---");

        System.out.print("Nomor Kamar   : ");
        String nomor = input.nextLine();

        System.out.print("Tipe Kamar (Single/Double/Suite): ");
        String tipe = input.nextLine();

        System.out.print("Harga per Bulan (Rp): ");
        int harga = bacaAngka();

        System.out.print("Nama Penyewa (isi '-' jika kosong): ");
        String penyewa = input.nextLine();

        boolean statusTersedia = penyewa.equals("-");

        KamarKost kamarBaru = new KamarKost(nomor, penyewa, tipe, harga, statusTersedia);
        daftarKamar.add(kamarBaru);
        System.out.println("[+] Kamar " + nomor + " berhasil ditambahkan!");
    }
    private static void lihatSemuaKamar() {
        System.out.println("\n--- DAFTAR SEMUA KAMAR ---");

        if (daftarKamar.isEmpty()) {
            System.out.println("[!] Belum ada data kamar.");
        } else {
            System.out.println("--------------------------------------------");
            for (KamarKost kamar : daftarKamar) {
                kamar.tampilkanInfo();
            }
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
        kamar.tampilkanInfo();

        System.out.print("Nama Penyewa baru (isi '-' jika kosong): ");
        String penyewaBaru = input.nextLine();

        kamar.setNamaPenyewa(penyewaBaru);
        kamar.setTersedia(penyewaBaru.equals("-"));

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
            if (daftarKamar.get(i).getNomorKamar().equals(nomor)) {
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
