3. Interface — IBisaDiSewa
Berisi 2 method:

cekKetersediaan() — mengecek apakah kamar bisa disewa

getInfoHargaSewa() — menampilkan ringkasan info sewa


Diimplementasikan oleh ketiga child class dengan implements IBisaDiSewa.
Logika cekKetersediaan() di KamarDouble berbeda — kamar dianggap tersedia hanya jika kedua slot penyewa kosong.