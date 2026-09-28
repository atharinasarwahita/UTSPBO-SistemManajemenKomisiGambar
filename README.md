# Sistem Manajemen Komisi Gambar (Art Commission Management System)

*Tugas Ujian Tengah Semester - Pemrograman Berbasis Objek (PBO)*

## 1. Deskripsi Proyek

**Sistem Manajemen Komisi Gambar** adalah aplikasi berbasis Pemrograman Berbasis Objek (PBO) yang dirancang untuk mempermudah seniman (*artist*) dan klien dalam mengelola alur kerja komisi seni digital secara terstruktur.

### 2. Fitur Utama

* **Manajemen Pesanan:** Memproses pendaftaran komisi baru dari klien.
* **Perhitungan Komisi & Biaya:** Menghitung total harga secara otomatis berdasarkan kompleksitas, jenis lisensi (komersial/personal), dan tingkat kerumitan gambar.
* **Pelacakan Status Progres:** Memantau tahapan pengerjaan (misal: *Pending*, *Sketching*, *Inking*, *Coloring*, *Completed*).
* **Penerapan Konsep PBO:** Mengimplementasikan prinsip-prinsip *Encapsulation*, *Inheritance*, *Polymorphism*, dan *Abstraction*.

---

## 3. Alur Sistem Program

Alur sistem ini dirancang untuk mensimulasikan proses bisnis manajemen komisi gambar secara menyeluruh, mulai dari penerimaan pesanan hingga tahap penyelesaian.

```
+---------------------------+
|  1. Penerimaan Pesanan    |
|     (Input Data Klien)    |
+-------------+-------------+
              |
              v
+---------------------------+
|  2. Kalkulasi Biaya       |
|     (Lisensi & Detail)    |
+-------------+-------------+
              |
              v
+---------------------------+
|  3. Registrasi & Status   |
|     (Inisialisasi Antrean)|
+-------------+-------------+
              |
              v
+---------------------------+
|  5. Rekap                 |
|     (Laporan & Selesai)   |
+---------------------------+
```

### Tahapan Alur Kerja Sistem Secara Rinci

#### 1. Tahap Penerimaan & Pendataan Pesanan (*Order Entry*)
* **Input Data Klien:** Sistem meminta informasi identitas dasar seperti nama klien dan rincian kontak.
* **Spesifikasi Karya:** Klien/seniman memasukkan spesifikasi gambar yang dipesan, meliputi:
  * Jenis karya (misal: *Headshot*, *Half Body*, *Full Body*, atau *Illustration Background*).
  * Tingkat kerumitan (*Level of Detail*).
  * Hak Penggunaan / Lisensi (*Personal Use* atau *Commercial Use*).

#### 2. Tahap Logika Kalkulasi & Penentuan Harga (*Pricing Calculation*)
* **Penetapan Tarif Dasar:** Sistem mengambil nilai *base price* berdasarkan jenis karya yang dipilih.
* **Multiplikator Lisensi:** Jika lisensi bernilai *Commercial Use*, sistem secara otomatis menerapkan pengganda harga (misal: $2 \times$ atau tarif tambahan khusus).
* **Penyesuaian Kompleksitas:** Tambahan biaya kalkulasi diterapkan secara dinamis jika terdapat permintaan khusus (seperti kerumitan latar belakang atau jumlah karakter tambahan).
* **Output Harga:** Sistem menghasilkan rincian (*breakdown*) total biaya transparan yang harus dibayar oleh klien.

#### 3. Tahap Pencatatan & Inisialisasi Antrean (*Queue & Initialization*)
* Pesanan yang telah dikonfirmasi akan dicatat oleh sistem dengan nomor identitas unik (*Order ID*).
* Sistem menginisialisasi slot yang tersedia, jika slot sudah habis maka pesanan akan ditolak.

#### 5. Tahap Finalisasi & Pelaporan (*Completion & Summary*)
* **Rekapitulasi Sistem:** Sistem menyajikan laporan komprehensif berisi daftar seluruh transaksi, rincian pesanan, total biaya yang diperoleh, serta ringkasan status pengerjaan untuk keperluan pencatatan keuangan dan manajemen seniman.

---

## 4. Penjelasan Gambar & Dokumentasi

Section ini berisi diagram arsitektur kelas (*Class Diagram*) serta tangkapan layar (*screenshot*) hasil uji coba sistem.

### 1. Class Diagram (Diagram Kelas)

Diagram ini menggambarkan struktur Pemrograman Berbasis Objek (PBO) yang diterapkan dalam aplikasi.

> ⚠️ **[CATATAN LOKASI GAMBAR]**: Letakkan file gambar diagram kelas pada direktori `docs/class-diagram.png`.

* **Penjelasan Class Diagram:**
  * `Komisi` (*Abstract Class/Superclass*): Menyimpan atribut dasar seperti ID Pesanan, Nama Klien, dan Harga Dasar.
  * `KomisiPersonal` / `KomisiKomersial` (*Subclass*): Turunan dari kelas `Komisi` yang memiliki perhitungan tarif spesifik berdasarkan lisensi.
  * `StatusEnum`: Mengelola konstanta status progres pengerjaan komisi (*Pending*, *Sketching*, *Coloring*, *Completed*).

---

### 2. Tangkapan Layar Output Program (Screenshots)

> ⚠️ **[CATATAN LOKASI GAMBAR]**: Letakkan tangkapan layar output sistem pada folder `docs/`.

#### A. Menu Utama & Input Data Pesanan
* *Filename:* `docs/screenshot-menu.png`
* *Deskripsi Gambar:* Menampilkan antarmuka navigasi utama serta proses pengisian data komisi dan spesifikasi gambar dari klien.

#### B. Pelacakan Status & Rekap Biaya
* *Filename:* `docs/screenshot-output.png`
* *Deskripsi Gambar:* Menampilkan tabel/daftar seluruh komisi yang terdaftar, hasil kalkulasi biaya otomatis, dan status progres pengerjaan terkini.

---

## 🛠️ Teknologi yang Digunakan

* **Bahasa Pemrograman:** Java
* **Konsep:** Object-Oriented Programming (OOP)
* **IDE:** VS Code / NetBeans / IntelliJ IDEA

*Dibuat untuk memenuhi Tugas UTS Pemrograman Berbasis Objek.*
