public class KamarSingle extends KamarKost {
    public KamarSingle(String nomorKamar, String namaPenyewa, int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
    }

    public void tampilkanInfoSingle() {
        System.out.println("--------------------------------------------");
        super.tampilkanInfoDasar();
        System.out.println("Tipe Kamar    : Single (Kapasitas 1 Orang)");
    }
}