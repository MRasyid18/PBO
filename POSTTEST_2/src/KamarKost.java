public class KamarKost {
    private String  nomorKamar;
    private String  namaPenyewa;
    private String  tipeKamar;
    private int     hargaPerBulan;
    private boolean tersedia;

    public KamarKost() {
        this.nomorKamar    = "-";
        this.namaPenyewa   = "-";
        this.tipeKamar     = "Single";
        this.hargaPerBulan = 0;
        this.tersedia      = true;
    }

    public KamarKost(String nomorKamar, String namaPenyewa,
                    String tipeKamar, int hargaPerBulan, boolean tersedia) {
        setNomorKamar(nomorKamar);
        setNamaPenyewa(namaPenyewa);
        setTipeKamar(tipeKamar);
        setHargaPerBulan(hargaPerBulan);
        setTersedia(tersedia);
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public int getHargaPerBulan() {
        return hargaPerBulan;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setNomorKamar(String nomorKamar) {
        if (nomorKamar == null || nomorKamar.trim().isEmpty()) {
            System.out.println("[!] Nomor kamar tidak boleh kosong. Diset ke '-'.");
            this.nomorKamar = "-";
        } else {
            this.nomorKamar = nomorKamar.trim().toUpperCase();
        }
    }

    public void setNamaPenyewa(String namaPenyewa) {
        if (namaPenyewa == null || namaPenyewa.trim().isEmpty()) {
            this.namaPenyewa = "-";
        } else {
            this.namaPenyewa = namaPenyewa.trim();
        }
    }

    public void setTipeKamar(String tipeKamar) {
        if (tipeKamar == null || tipeKamar.trim().isEmpty()) {
            System.out.println("[!] Tipe kamar tidak boleh kosong. Diset ke 'Single'.");
            this.tipeKamar = "Single";
        } else {
            this.tipeKamar = tipeKamar.trim();
        }
    }

    public void setHargaPerBulan(int hargaPerBulan) {
        if (hargaPerBulan < 0) {
            System.out.println("[!] Harga tidak boleh negatif. Diset ke 0.");
            this.hargaPerBulan = 0;
        } else {
            this.hargaPerBulan = hargaPerBulan;
        }
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
        if (tersedia) {
            this.namaPenyewa = "-";
        }
    }

    private String formatHarga(int harga) {
        String hargaStr = String.valueOf(harga);
        StringBuilder hasil = new StringBuilder();
        int counter = 0;
        for (int i = hargaStr.length() - 1; i >= 0; i--) {
            if (counter > 0 && counter % 3 == 0) {
                hasil.insert(0, ".");
            }
            hasil.insert(0, hargaStr.charAt(i));
            counter++;
        }
        return "Rp " + hasil.toString();
    }

    protected void tampilkanInfo() {
        String statusKamar = this.tersedia ? "Tersedia (Kosong)" : "Disewa";
        System.out.println("--------------------------------------------");
        System.out.println("Nomor Kamar   : " + getNomorKamar());
        System.out.println("Tipe Kamar    : " + getTipeKamar());
        System.out.println("Nama Penyewa  : " + getNamaPenyewa());
        System.out.println("Harga/Bulan   : " + formatHarga(getHargaPerBulan()));
        System.out.println("Status        : " + statusKamar);
    }
}