# MisYemek
Kullanıcıların yemek siparişi verdiği, firma sahiplerinin siparişleri yönettiği ve kuryelerin teslimatı üstlendiği uçtan uca bir yemek sipariş ve takip uygulaması.
## Özellikler

### Kullanıcı
- Kayıt olma ve giriş yapma (JWT tabanlı kimlik doğrulama)
- Adrese ve yakınlığa (mahalle / ilçe / şehir) göre firma listeleme
- Ürün ve kategoriye göre filtreleme, restoran arama
- Firmaları en yüksek puana (yıldıza) göre sıralama
- Sepete ürün ekleme ve sipariş verme
- Verilen siparişleri anlık olarak takip etme
- Firmalara puan verme (değerlendirme)
- Şifre değiştirme ve profil bilgilerini görüntüleme

### Firma Sahibi (Admin)
- Gelen siparişleri görüntüleme ve durumunu güncelleme
- Sipariş takibi yapma
- Aylık kazanç bilgisini görüntüleme
- Teslim edilen ve iptal edilen sipariş sayılarını takip etme
- Firma bilgilerini ve ürünlerini yönetme

### Kurye
- Kendisine atanan teslimatları görüntüleme
- Teslimatları tamamlama ve durum güncelleme
- Kurye ayarlarını düzenleme

### Genel
- Anlık bildirim sistemi
- Rol bazlı yetkilendirme (Kullanıcı / Firma Sahibi / Kurye)

### Kullanılan Teknolojiler

**Backend**
-Java (V.21)
-Spring Boot
-Spring Security(JWT Tabanlı)
-Spring Data JPA / Hibernate
-MySQL

**Frontend**
-Angular(V.17)
-PrimeNG / PrimeFlex

## Kurulum

### Gereksinimler
- Java 17+
- Node.js ve npm
- MySQL

### Veritabanı
1. MySQL üzerinde bir veritabanı oluşturun.
2. `src/main/resources/application.properties` dosyasındaki bağlantı bilgilerini kendi ayarlarınıza göre güncelleyin:
​```properties
spring.datasource.url=jdbc:mysql://localhost:3306/misyemek
spring.datasource.username=KULLANICI_ADI
spring.datasource.password=SIFRE
​```

### Backend'i Çalıştırma
​```bash
mvn spring-boot:run
​```
Uygulama varsayılan olarak `http://localhost:8080` üzerinde çalışır.

### Frontend'i Çalıştırma
​```bash
cd frontend
npm install
npm start
​```
Arayüz `http://localhost:4200` üzerinde açılır.


## Ekran Görüntüleri

### Giriş Ekranı 
![](docs/login.png)

### Kayıt OL
![](docs/Kayit_Ol.png)

### Ana Ekran
![](docs/Ana_Ekran.png)

### Hesap Sayfası
![](docs/Kullanici_Hesap.png)

### Sepet Ekranı
![](docs/sepet.png)

### Kullanıcı Sipariş Takip ve Yıldız Sistemi
![](docs/Siparişler.png)

### Firma Ayarları
![](docs/Firma_Yönetim_Ekran.png)

### Firma Ürün Düzenleme Ekranı 
![](docs/Firma_Urun.png)

### Firma Sipariş Onaylama ve Reddetme Ekranı
![](docs/Firma_Siparis_Onayla.png)

### Firma Sipariş Takip Ekranı
![](docs/Firma_Siparis_Takip.png)

### Kurye Teslimat Ekranı
![](docs/Kurye_Teslimat_Ekrani.png)