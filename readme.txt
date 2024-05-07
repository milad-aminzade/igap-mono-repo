اپلیکیشن شامل مایکرو سرویس ها و کتابخانه :
Igap-API-Gateway: گیت وی وروردی نرم افزار که وظیفه روتینگ درخواست ها و همینطور اعمال سکوریتی را به عهده دارد
Igap-Service-Discovery: وظیفه رجیستر مایکرو سرویس ها و روتینگ در خواست ها از طریق نام سوریس به جای یو ار ال که امکان اسکیل نرم افزار و لود بالانسیگ را فارغ از یو ار ال فیزیکال به عهده دارد و پس از دیپلوی هر اینستنس از اپلیکیشن به آن اجتماع می توان از طریق نامش دسترسی پیدا کرد.
Igap-User-Profile: وظیفه مدیریت پرسن- پروفایل - و کلا هسته بیزنسی اپ را به عهده دارد
Igap-Common: کتابخانه مشترک بین مایکروسرویس ها می باشدکه برخی از کلاس های مشترک و همینطور کتابخانه های مشترک بین مایکرو سرویس ها را سرو می کند

وظیفه احراز هویت (authentication-authorization) از طریق key-cloak تامین می شود که جهت بهره برداری می بایست آنرا نصب و یا از طریق داکر انرا برروی سرور اجرا کرد:
برای استقرار نرم افزار مراحل زیر را انجام دهید:
1- اجرای keycloak با docker از طریق کامند زیر:
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:24.0.3 start-dev
2- ایجاد realm در کنسول keycloak
3- ایجاد client
4- ایجاد user
5- کانفیگ keycloak در Api-Gateway
app:
  config:
    keycloak:
      url: ${KEYCLOAK_URL:http://127.0.0.1:8089}
      realm: ${KEYCLOAK_REALM:Igam-Realm}
      user-name-attribute: ${KEYCLOAK_USERNAME_ATTR:preferred_username}
      client-id: ${KEYCLOAK_CLIENT_ID:igap-client}
      client-secret: ${KEYCLOAK_CLIENT_SECRET:9MFpcqB8XBCRARO3NBK6FbJfMRbBgSiN}
      grant-type: password
6- نصب mysql و کانفیگ برروی 
  datasource:
    url: jdbc:mysql://localhost:3306/${DATABASE_DB:user_profile}?useSSL=false&allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true
    username: ${DATABASE_USERNAME:root}
    password: ${DATABASE_PASSWORD:password}
7- پس از اجرای service-discovery کتابخانه common را clean-install کرده و پس از آن Api-gateway و نهایتا user-profile را اجرا می کنیم که متعاقب آن فایل liquebase اجرا شده و تمام کوری های مورد نیاز از قبیل ساخت جداول اجرا می شود.
8- پس از مراحل بالا می توان api های user-profile را از طریق swagger مشاهده کرد آدرس: http://{USER-PROFILE-SERVER-IP}:{USER-PROFILE-APP-PORT}/swagger-ui/index.html 
9- البته دسترسی به این API ها می باید از طریق Gateway انجام پذیرد که سکوریتی و سرویس روتینگ را ارائه می دهد. که لازم است برای دسترسی به سرویس ها از طریق زیر انجام پذیرد:
http://{API-GATEWAY-SERVER-IP}:{API-GATEWAY-APP-PORT}/profile/{USER-PROFILE-SERVICE-ROUTE}
که در Authorization Header می باید access-token جای بگیرد.
10- توکن Aceess-token از طریق سرویس سرویس login دریافت می شود:
http://{API-GATEWAY-SERVER-IP}:{API-GATEWAY-APP-PORT}/profile/api/v1/auth/login






