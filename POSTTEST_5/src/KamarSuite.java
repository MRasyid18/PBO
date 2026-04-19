public class KamarSuite extends KamarKost implements IBisaDiSewa {
    private String fasilitasTambahan;

    public KamarSuite(String nomorKamar, String namaPenyewa,
                        String fasilitasTambahan, int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
        setFasilitasTambahan(fasilitasTambahan);
    }

    public String getFasilitasTambahan() {
        return fasilitasTambahan;
    }

    public void setFasilitasTambahan(String fasilitasTambahan) {
        if (fasilitasTambahan == null || fasilitasTambahan.trim().isEmpty()) {
            this.fasilitasTambahan = "Tidak ada";
        } else {
            this.fasilitasTambahan = fasilitasTambahan.trim();
        }
    }

    @Override
    public String getTipeKamar() {
        return "Suite (Premium)";
    }

    @Override
    public int getKapasitasPenyewa() {
        return 1;
    }

    @Override
    public void tampilkanInfo() {
        tampilkanInfoDasar();
        System.out.println("Fasilitas Ekstra: " + getFasilitasTambahan());
    }

    @Override
    public boolean cekKetersediaan() {
        return isTersedia();
    }

    @Override
    public String getInfoHargaSewa() {
        return getTipeKamar() + " | Kapasitas: " + getKapasitasPenyewa()
        + " orang | Harga: " + formatHarga(getHargaPerBulan()) + "/bulan"
        + " | Fasilitas: " + getFasilitasTambahan();
    }
}