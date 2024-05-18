# Web Automation Testing

Project automation testing untuk menguji fitur Login dan Logout pada aplikasi web [Swag Labs](https://www.saucedemo.com/). Project ini dikembangkan dengan bahasa Java untuk kode program dan pembuatan script test dan Maven sebagai build tools.

## Build With
Automation Testing pada project ini menggunakan dua buah library.
 <ul>
    <li>JUnit</li>
    <li>Cucumber</li>
    <li>Selenium</li>
    <li>WebDriverManager</li>
 </ul>
 
# Getting Started
## Pre-requisites
Sebelum menjalankan project ini, perlu disiapkan environment yang sesuai.
<ul>
  <li>Java 17+</li>
  <li>Apache Maven 3.8.0+</li>
  <li>Web Browser</li>
</ul>

## Struture Project Test
Berikut ini merupakan struktur kode beserta penjelasannya
```
{nama_proyek}
```

## Run Automation Test
1. Clone repository dengan git
   ```
   git clone https://github.com/salsabilamp3/web-automation-testing.git
   ```
2. Jalankan perintah berikut untuk menginstall artifak yang didefinisikan
   ```
   mvn clean install
   ```
3. Jalankan perintah berikut pada terminal untuk menjalankan semua test
   ```
   mvn test
   ```

## Test Cases
Pembuatan test case meliputi test positif dan negatif untuk fitur Login dan Logout.

#### Login
```
1. Pemeriksaan login berhasil dengan menggunakan kredensial yang valid.
2. Pemeriksaan login gagal dengan menggunakan username yang benar dan password yang salah.
3. Pemeriksaan login gagal dengan menggunakan username yang tidak terdaftar di database.
4. Pemeriksaan login gagal dengan tidak mengisikan username.
5. Pemeriksaan login gagal dengan tidak mengisikan password.
6. Pemeriksaan login gagal dengan tidak mengisikan username dan passwrod.
```

#### Logout
```
1. Pemeriksaan logout berhasil dengan menekan tombol logout.
```

## Author
[Amelia Dewi Agustiani](https://github.com/ameliadewi19) (211524002)

[Salsabila Maharani Putri](https://github.com/salsabilamp3) (211524026)

[Raka Mahardika Maulana](https://github.com/rakamhrdka10) (211524056)

_Mahasiswa D4 Teknik Informatika Politeknik Negeri Bandung_
