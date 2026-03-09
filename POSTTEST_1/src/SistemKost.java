import java.util.ArrayList;
import java.util.Scanner;

class KamarKost {
    String nomorKamar;
    String namaPenyewa;
    String tipeKamar;
    int hargaPerBulan;
    boolean tersedia;

    KamarKost() {
        this.nomorKamar   = "-";
        this.namaPenyewa  = "-";
        this.tipeKamar    = "-";
        this.hargaPerBulan = 0;
        this.tersedia      = true;
    }

    KamarKost(String nomorKamar, String namaPenyewa, String tipeKamar, int hargaPerBulan, boolean tersedia) {
        this.nomorKamar    = nomorKamar;
        this.namaPenyewa   = namaPenyewa;
        this.tipeKamar     = tipeKamar;
        this.hargaPerBulan = hargaPerBulan;
        this.tersedia      = tersedia;
    }

    void tampilkanInfo() {
        String statusKamar = this.tersedia ? "Tersedia" : "Disewa";
        System.out.println("Nomor Kamar   : " + this.nomorKamar);
        System.out.println("Tipe Kamar    : " + this.tipeKamar);
        System.out.println("Nama Penyewa  : " + this.namaPenyewa);
        System.out.println("Harga/Bulan   : Rp " + this.hargaPerBulan);
        System.out.println("Status        : " + statusKamar);
        System.out.println("--------------------------------------------");
    }

    void ubahStatus(boolean statusTersedia) {
        this.tersedia = statusTersedia;
    }
}

public class SistemKost {
    static ArrayList<KamarKost> daftarKamar = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        daftarKamar.add(new KamarKost("A01", "Budi",   "Single", 800000,  false));
        daftarKamar.add(new KamarKost("A02", "-",      "Single", 800000,  true));
        daftarKamar.add(new KamarKost("B01", "Siti",   "Double", 1200000, false));
        boolean jalan = true;

        while (jalan) {
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
            int pilihan = Integer.parseInt(input.nextLine());

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

    static void tambahKamar() {
        System.out.println("\n--- TAMBAH KAMAR BARU ---");
        System.out.print("Nomor Kamar   : ");
        String nomor = input.nextLine();

        System.out.print("Tipe Kamar (Single/Double/Suite): ");
        String tipe = input.nextLine();

        System.out.print("Harga per Bulan (Rp): ");
        int harga = Integer.parseInt(input.nextLine());

        System.out.print("Nama Penyewa (isi '-' jika kosong): ");
        String penyewa = input.nextLine();

        boolean statusTersedia;
        if (penyewa.equals("-")) {
            statusTersedia = true;
        } else {
            statusTersedia = false;
        }

        KamarKost kamarBaru = new KamarKost(nomor, penyewa, tipe, harga, statusTersedia);
        daftarKamar.add(kamarBaru);
        System.out.println("[+] Kamar " + nomor + " berhasil ditambahkan!");
    }

    static void lihatSemuaKamar() {
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

    static void ubahKamar() {
        System.out.println("\n--- UBAH DATA KAMAR ---");
        System.out.print("Masukkan Nomor Kamar yang ingin diubah: ");
        String nomor = input.nextLine();

        boolean ketemu = false;

        for (int i = 0; i < daftarKamar.size(); i++) {
            if (daftarKamar.get(i).nomorKamar.equals(nomor)) {
                ketemu = true;
                KamarKost kamar = daftarKamar.get(i);
                
                System.out.println("\nData kamar saat ini:");
                kamar.tampilkanInfo();

                System.out.print("Masukkan Nama Penyewa baru (isi '-' jika kosong): ");
                kamar.namaPenyewa = input.nextLine();
                
                if (kamar.namaPenyewa.equals("-")) {
                    kamar.ubahStatus(true);
                } else {
                    kamar.ubahStatus(false);
                }

                daftarKamar.set(i, kamar);
                System.out.println("[v] Data kamar " + nomor + " berhasil diperbarui!");
                break;
            }
        }

        if (!ketemu) {
            System.out.println("[!] Kamar dengan nomor " + nomor + " tidak ditemukan.");
        }
    }

    static void hapusKamar() {
        System.out.println("\n--- HAPUS KAMAR ---");
        System.out.print("Masukkan Nomor Kamar yang ingin dihapus: ");
        String nomor = input.nextLine();

        boolean ketemu = false;

        for (int i = 0; i < daftarKamar.size(); i++) {
            if (daftarKamar.get(i).nomorKamar.equals(nomor)) {
                ketemu = true;
                daftarKamar.remove(i);
                System.out.println("[-] Kamar " + nomor + " berhasil dihapus.");
                break;
            }
        }

        if (!ketemu) {
            System.out.println("[!] Kamar dengan nomor " + nomor + " tidak ditemukan.");
        }
    }
}