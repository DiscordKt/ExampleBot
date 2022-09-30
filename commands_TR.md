# Komutlar

## Key
| Symbol      | Meaning                 |
|-------------|-------------------------|
| [Argument]  | Argüman opsiyonel.      |
| /Category   | Bu bir alt komut grubu. |

## /Math
| Komutlar | Argümanlar      | Açıklama                 |
|----------|-----------------|--------------------------|
| Add      | Birinci, İkinci | İki sayıyı toplar        |
| Mult     | Birinci, İkinci | İki sayıyı çarpar        |
| Sub      | Birinci, İkinci | İki sayının farkını alır |

## /Prompt
| Komutlar | Argümanlar | Açıklama |
|----------|------------|----------|
| Modal    |            |          |

## Argümanlar
| Komutlar | Argümanlar                                               | Açıklama                  |
|----------|----------------------------------------------------------|---------------------------|
| Choice   | İsimler                                                  | Bir seçim ekranı sunar    |
| Echo     | Yazı                                                     | Yazıyı yazar              |
| Junk     | Tam sayı, Rastgele tür, Kullanıcı, Kanal, Ondalıklı Sayı | Birçok argüman kabul eder |
| Plus     | Birinci, İkinci                                          | Basit bir toplama komudu  |

## Basics
| Komutlar | Argümanlar | Açıklama                         |
|----------|------------|----------------------------------|
| Embed    |            | Embed içeren bir mesaj oluşturur |
| Hello    |            | 'Hello World' komudu             |

## Context
| Komutlar | Argümanlar | Açıklama                                 |
|----------|------------|------------------------------------------|
| Info     | Kullanıcı  | Hedeflenen kullanıcının bilgilerini alır |
| Link     | Mesaj      | Mesajın linkini yollar                   |

## Conversation
| Komutlar | Argümanlar | Açıklama                                      |
|----------|------------|-----------------------------------------------|
| Private  |            | Özel kanalda bir konuşma başlatır             |
| Public   |            | Halka açık kanalda bir konuşma başlatır       |
| Slash    |            | Slash komuduu kullanarak bir konuşma başlatır |

## Data
| Komutlar | Argümanlar | Açıklama                                     |
|----------|------------|----------------------------------------------|
| Data     |            | Konfigürasyon dosyasından verileri gösterir  |
| SetData  | Integer    | Konfigürasyon dosyasındaki verileri düzenler |

## Math
| Komutlar | Argümanlar      | Açıklama                 |
|----------|-----------------|--------------------------|
| Add      | Birinci, İkinci | İki sayıyı toplar        |
| Mult     | Birinci, İkinci | İki sayıyı çarpar        |
| Sub      | Birinci, İkinci | İki sayının farkını alır |

## Optional
| Komutlar    | Argümanlar        | Açıklama                                                                        |
|-------------|-------------------|---------------------------------------------------------------------------------|
| Number      | [Tam Sayı]        | Sayının bir fazlasını söyler                                                    |
| OptionalAdd | Birinci, [İkinci] | İki sayıyı toplar, ikinci sayı yoksa birinciyi yazar                            |
| User        | [Kullanıcı]       | Eğer kullanıcı girildiyse kullanıcının girilmediyse komudu girenin tagını yazar |

## Overload
| Komutlar | Argümanlar | Açıklama                                   |
|----------|------------|--------------------------------------------|
| Overload |            | Bu komudun birden fazla kullanım şekli var |
|          | Rastgele   |                                            |
|          | Tam Sayı   |                                            |

## Permissions
| Komutlar   | Argümanlar | Açıklama                               |
|------------|------------|----------------------------------------|
| GuildOwner |            | GUILD_OWNER yetkisini gerektiren komut |
| Staff      |            | STAFF yetkisini gerektiren komut       |

## Preconditions
| Komutlar     | Argümanlar | Açıklama                                 |
|--------------|------------|------------------------------------------|
| Precondition |            | Bir ön koşulu başaramayan komut gösterir |

## Text
| Komutlar | Argümanlar | Açıklama                                                  |
|----------|------------|-----------------------------------------------------------|
| Dm       |            | Bu komut sadece özel mesajlarda kullanılabilir            |
| Global   |            | Bu komut sunucularda ya da özel mesajlarda kullanılabilir |
| Guild    |            | Bu komut sadece sunucularda kullanılabilir                |
| Menu     |            | Bir menü mesajı oluşturur                                 |

## Utility
| Komutlar | Argümanlar | Açıklama                                                 |
|----------|------------|----------------------------------------------------------|
| Help     | [Komut]    | Komut varsa komudun yoksa genel yardım menüsünü gösterir |
| info     |            | ExampleBot'un bilgilerini gösterir                       |

