
Bu çalışmada tipik bir mikro servis ekosisteminde yer alan bileşenler incelenmektedir.
Gerçek hayat senaryolarında bu bileşenlerden ApiGateway, Discovery Server ve Config Server'ı genelde kendimiz oluşturmaz ve hazır servisler olarak kullanırız.

Çalışmadaki bileşenler SpringBoot ile gerçeklenmiştir.

***Bileşenler***
1. ***Discovery Server:*** Yazılan tüm mikro servislerin ve önlerinde duran API Gateway bileşeninin kendilerini kaydettirdikleri ve IP adresleri yerine birbirlerinin isimlerini kullanarak haberleşmelerini sağlayan bileşendir. Web sitelerine IP adresi yazmak yerine domain isimlerini yazarak erişmemizi sağlayan DNS sunuculara benzetebiliriz. </br>
2. ***Config Server:*** Yazdığımız her servisin kendisine ait konfigurasyon dosyası mevcuttur. Ancak onlarca belki yüzlerce mikro servisin bulunduğu gerçek hayat senaryolarında bu dosyalarda yer alan değerleri değiştirmek çok pratik değildir. Bu yüzden genellikle konfigurasyon değerleri merkezi bir yapıdan alınır. Config Server bileşeni konfigurasyon değerlerini okumak için gerekli olan bilgilere sahiptir. Okunacak değerler dosya sistemindeki basit bir dosyada da olabilir, bir versiyon kontrol sisteminde yer alan dosyalar da olabilir. Genellikle Git repo'larında yer alan bir ya da bir kaç dosya ile gerçeklenir.
3. ***API Gateway:*** API Gateway 

![plot](./resources/ecosystem.jpg)

***Yararlanılan Kaynaklar*** </br>
https://github.com/osmanyaycioglu </br>
https://www.javainuse.com/spring/springcloud
