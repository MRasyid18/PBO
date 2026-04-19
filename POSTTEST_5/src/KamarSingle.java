public class KamarSingle extends KamarKost implements IBisaDiSewa {

    public KamarSingle(String nomorKamar, String namaPenyewa,
                        int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
    }
    @Override
    public String getTipeKamar() {
        return "Single";
    }

    @Override
    public int getKapasitasPenyewa() {
        return 1;
    }

    @Override
    public void tampilkanInfo() {
        tampilkanInfoDasar();
    }

    @Override
    public boolean cekKetersediaan() {
        return isTersedia();
    }

    @Override
    public String getInfoHargaSewa() {
        return getTipeKamar() + " | Kapasitas: " + getKapasitasPenyewa()
        + " orang | Harga: " + formatHarga(getHargaPerBulan()) + "/bulan";
    }
}
