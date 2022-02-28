# Docker
データベースはpostgreです。  
タスクのdockerからcomposeUpを実行するとコンテナが起動して  
setupフォルダに配置したddlとdmlが流れます

参考  
https://volkruss.com/?p=1274

# データアクセス

依存の追加

```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa' //build時にもデータベースに接続できるようにしておく
}
```

データーベースにはアクセスできるように設定しておきます  
アドレスが各自の環境に合わせます。

``` :application.yaml
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://192.168.11.13:5432/misaka
    username: misaka
    password: mikoto
```

## Doma2

参考  
https://volkruss.com/?p=1254
https://volkruss.com/?p=1263


# Security

依存の追加

```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-security'
}
```

何も設定しなければ全てのページにログインが必須になる。
  
参考
https://volkruss.com/?p=1350

# ログの設定

参考  
https://volkruss.com/?p=1325


# ソースコードジェネレータ

参考  
https://volkruss.com/?p=1294

# バリデーション

参考  
https://volkruss.com/?p=1267