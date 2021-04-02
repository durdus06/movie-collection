# Movie Collection
Movie Collection responsive mobil uyumlu bir projedir. Kullanıcılar email adresleriyle kayıt olabilir. Film ekleme ve düzenleme  işlemlerini gerçekleştirebilir. Admin kullanıcıların gerçekleştirmiş olduğu işlemlerin yanı sıra film silme işlemini de gerçekleştirebilmektedir. Projenin geliştirilmesinde Spring Boot, Thymeleaf, Spring Security, JPA, Hibernate, Bootstrap kullanılmıştır.

## Proje Kurulum Adımları
1. https://github.com/durdus06/movie-collection adresine gidiniz. 
2. Sayfada bulunan Code butonuna tıklayınız orada bulunan linki kopyalayıp kullandığınız IDE üzerinden projeyi import edebilirsiniz veya burada bulunan Download ZIP bölümünden projeyi indirerek kullanmış olduğunuz IDE'de siz de açabilirsiniz.
3. Projeyi kullanmış olduğunuz IDE'de açtıktan sonra src/main/resources/application.properties'i açınız. Burada MySQL veritabanı için gerekli olan  kullanıcı adı ve şifrenizi giriniz. 
4. Proje içerisinde bulunan MySQL-DatabaseQueries.sql' deki sorguları MySQL'de çalıştırınız.
5. User olarak giriş yapabilmek için kullanıcı adı olarak sn.durdu@gmail.com şifre olarak user giriniz. Dilerseniz kendinize ait bir kullanıcıyı Sign in bölümünden siz de oluşturabilirsiniz.
6. Admin olarak giriş yapabilmek için kullanıcı adı olarak durdu.s06@gmail.com şifre olarak da admin giriniz.

## Projede ek olarak kullanılan teknolojiler ve araçlar
### DataTables
DataTables, aşağıda belirtilen tüm bu gelişmiş özellikleri herhangi bir HTML tablosuna ekleyebilen jQuery kütüphanesi için bir eklentidir.
- Sayfalama
- Anlık aramalar
- Çoklu sütun sıralaması
- Çoğu data kaynağını kullanabiliyor olması
- Kolayca tema uygulanabilmesi
- Mobil uyumlu olması

### Bootstrap
Hızlı tasarım ve ihtiyacınıza göre düzenleyebileceğiniz responsive mobil cihazlarla uyumlu siteler geliştirilmesine olanak tanıyan dünyanın en popüler front-end aracıdır. Bu sayede hazırlamış olduğum proje responsive bir tasarıma sahiptir.

### Bootbox.js
Gerekli DOM elemanları veya JavaScript event handlers oluşturma, yönetme veya kaldırma konusunda düşünmemize gerek kalmadan Bootstrap modals kullanarak programlanabilir dialog box oluşturmayı sağlayan küçük bir JavaScript kütüphanesidir. 


### Thymeleaf Layout Dialect
Kodun yeniden kullanımını iyileştirmek için  layout ve yeniden kullanılabilir template oluşturmamıza imkan tanıyan Thymeleaf için bir diyalekttir.

### jQuery Validation Plugin
Bu jQuery eklentisi, çok sayıda özelleştirme seçeneği sunarken, clientside form validation işlemini kolaylaştırır. Tüm methodlarda varsayılan olarak İngilizce hata mesajları bulunmaktadır ve bu mesajlar 37 diğer dile çevrilmiştir.

### Spring-boot-devtools
Spring-boot-devtools modülü, geliştirme sürecini hızlandırmak ve bu süreçte ek özellikler sağlamaktadır.

