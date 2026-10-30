package com.obpiub.vkeducationpractice.data

import com.obpiub.vkeducationpractice.domain.App
import com.obpiub.vkeducationpractice.domain.AppsRepository
import com.obpiub.vkeducationpractice.domain.Category
import kotlin.String

class AppsRepositoryImpl(
    private val mapper: AppMapper
):  AppsRepository{
    private val appDto = listOf(
        // https://www.rustore.ru/catalog/app/ru.yandex.yandexmaps
        AppDto(
            id = "ru.yandex.yandexmaps",
            name = "Яндекс Карты и Навигатор",
            developer = "ООО \"ЯНДЕКС\"",
            category = Category.APP,
            ageRating = 0,
            size = 342.1f,
            iconUrl = "https://static.rustore.ru/apk/586431/content/ICON/a5f2fe7d-cd63-4f3f-a2f8-40d997c1d6f4.png",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/2026/10/1/6e/apk/586431/content/SCREENSHOT/72c31baa-226b-422e-867e-79399c69066d.png",
                "https://static.rustore.ru/2026/10/1/0a/apk/586431/content/SCREENSHOT/a22680e7-bbea-459e-bf1e-55bbecd69828.jpg",
                "https://static.rustore.ru/2026/7/20/b4/apk/586431/content/SCREENSHOT/236fb404-4f3c-491e-9880-549f393e755e.jpg",
            ),
            description = "Карты городов, поиск организаций и маршруты для поездок и прогулок. Навигатор помогает ориентироваться на дороге и учитывать пробки.",
        ),
        // https://www.rustore.ru/catalog/app/ru.yandex.metro
        AppDto(
            id = "ru.yandex.metro",
            name = "Яндекс Метро",
            developer = "ООО \"ЯНДЕКС\"",
            category = Category.APP,
            ageRating = 0,
            size = 101.2f,
            iconUrl = "https://static.rustore.ru/77271b9a-880a-470f-bc3d-20bf33f7a101",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/3f26615e-4a98-4908-9304-e68b4f1c3b41",
                "https://static.rustore.ru/d5f95196-9649-4802-afd0-176317c07b2c",
                "https://static.rustore.ru/a5063189-1707-4d55-92f4-9c0fcb0b5893",
            ),
            description = "Планируйте поездки на метро: выбирайте станции и сравнивайте маршруты с пересадками. Схемы помогают разобраться в линиях и оценить время в пути.",
        ),
        // https://www.rustore.ru/catalog/app/com.yandex.browser
        AppDto(
            id = "com.yandex.browser",
            name = "Яндекс Браузер с Алисой AI",
            developer = "ООО \"ЯНДЕКС\"",
            category = Category.APP,
            ageRating = 0,
            size = 144.5f,
            iconUrl = "https://static.rustore.ru/2026/9/10/57/apk/579007/content/ICON/79aab4d5-9db3-4644-8291-febef32cf437.png",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/2026/9/10/0e/apk/579007/content/SCREENSHOT/0eee8e45-b30c-474f-bd8c-aabbcb938bcd.jpg",
                "https://static.rustore.ru/2026/9/10/b1/apk/579007/content/SCREENSHOT/7f30d93d-702e-4f24-9aaa-be24d2fc0364.jpg",
                "https://static.rustore.ru/2026/9/10/55/apk/579007/content/SCREENSHOT/ce38fff6-4fe9-4a85-94c2-dca9070b3f6f.jpg",
            ),
            description = "Браузер для поиска информации и просмотра сайтов со встроенной Алисой AI. Помогает работать с текстами и находить ответы на повседневные вопросы.",
        ),
        // https://www.rustore.ru/catalog/app/ru.ozon.app.android
        AppDto(
            id = "ru.ozon.app.android",
            name = "OZON: товары, одежда, билеты",
            developer = "ООО \"Интернет Решения\"",
            category = Category.APP,
            ageRating = 0,
            size = 110.3f,
            iconUrl = "https://static.rustore.ru/2026/6/30/b6/apk/514239/content/ICON/8a44b15d-a16e-41a4-b926-9088693015ca.png",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/2026/9/2/c9/apk/514239/content/SCREENSHOT/4874316f-ffb7-4803-99bb-5cfaac48631e.jpg",
                "https://static.rustore.ru/2026/9/2/3c/apk/514239/content/SCREENSHOT/81f2cc3b-4654-4239-8222-aac10398ed1b.jpg",
                "https://static.rustore.ru/2026/9/2/3c/apk/514239/content/SCREENSHOT/268f91e9-67ae-42b1-9151-d2bd087457aa.jpg",
            ),
            description = "Выбирайте товары для дома, электронику, одежду и подарки. В приложении можно сравнивать предложения, оформлять покупки и следить за заказами.",
        ),
        // https://www.rustore.ru/catalog/app/ru.dublgis.dgismobile
        AppDto(
            id = "ru.dublgis.dgismobile",
            name = "2ГИС: навигатор, транспорт, друзья на карте",
            developer = "ООО \"ДубльГИС\"",
            category = Category.APP,
            ageRating = 0,
            size = 281.2f,
            iconUrl = "https://static.rustore.ru/2026/2/2/1e/apk/260799/content/ICON/8e439c58-11cf-4e0a-a3dc-9596eda08cfd.png",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/2026/10/22/8d/apk/260799/content/SCREENSHOT/4de54e00-e09f-425c-a02e-11252d7a2816.jpg",
                "https://static.rustore.ru/2026/10/22/4c/apk/260799/content/SCREENSHOT/4e373490-37ee-4a7b-8f94-1d4979778aed.jpg",
                "https://static.rustore.ru/2026/10/22/ba/apk/260799/content/SCREENSHOT/1bdf791d-7312-4072-ad27-6f6a53d3216f.jpg",
            ),
            description = "Городской справочник с картой, навигацией и информацией об организациях. Стройте маршруты пешком, на автомобиле или общественном транспорте.",
        ),
        // https://www.rustore.ru/catalog/app/com.vkontakte.android
        AppDto(
            id = "com.vkontakte.android",
            name = "ВКонтакте: чаты, видео, музыка",
            developer = "VK",
            category = Category.APP,
            ageRating = 12,
            size = 131.3f,
            iconUrl = "https://static.rustore.ru/3f3d7180-6eb9-45ad-8706-f467c6dcf82a",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/2026/5/6/d3/apk/317631/content/SCREENSHOT/3e54a2d0-13a1-4508-a8dd-b93a05ea2a63.jpg",
                "https://static.rustore.ru/2026/5/6/26/apk/317631/content/SCREENSHOT/e7535e33-6e0e-4cc2-bd2e-08d5499948f5.jpg",
                "https://static.rustore.ru/2026/5/6/2f/apk/317631/content/SCREENSHOT/43bb1c06-5d7c-4035-940e-4160714bc9f4.jpg",
            ),
            description = "Общайтесь с друзьями, звоните и следите за новостями сообществ. Слушайте музыку, смотрите видео и делитесь своими публикациями.",
        ),
        // https://www.rustore.ru/catalog/app/com.avito.android
        AppDto(
            id = "com.avito.android",
            name = "Авито – путешествия, работа, услуги, авто",
            developer = "ООО \"КЕХ еКоммерц\"",
            category = Category.APP,
            ageRating = 0,
            size = 236.1f,
            iconUrl = "https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/2026/4/20/38/apk/2688703/content/SCREENSHOT/9e50e796-9c0a-4a40-927f-a3bd5c4bf047.jpg",
                "https://static.rustore.ru/2026/10/23/2b/apk/2688703/content/SCREENSHOT/1904b927-7919-4702-a711-9b0ac2947576.jpg",
                "https://static.rustore.ru/2026/10/23/6d/apk/2688703/content/SCREENSHOT/680e4a53-3d56-4bf2-9f43-0b436c014779.jpg",
            ),
            description = "Сервис объявлений для покупки и продажи вещей, поиска работы, жилья и услуг. Сравнивайте предложения и связывайтесь с авторами объявлений.",
        ),
        // https://www.rustore.ru/catalog/app/ru.mail.mailapp
        AppDto(
            id = "ru.mail.mailapp",
            name = "Mail: Почта, Облако, Календарь",
            developer = "VK",
            category = Category.APP,
            ageRating = 0,
            size = 128.3f,
            iconUrl = "https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/2026/8/20/63/apk/332223/content/SCREENSHOT/84f9a723-5d05-46b3-983c-81fe37f97825.png",
                "https://static.rustore.ru/2026/8/20/73/apk/332223/content/SCREENSHOT/c91dc8bb-513e-40bb-afd2-eaec17ec4c19.png",
                "https://static.rustore.ru/2026/8/20/00/apk/332223/content/SCREENSHOT/34e673f1-40a1-492e-981a-f2eebbd97283.png",
            ),
            description = "Работайте с письмами из нескольких почтовых ящиков в одном приложении. Сохраняйте файлы в облаке и планируйте дела с помощью календаря.",
        ),
        // https://www.rustore.ru/catalog/app/com.vk.vkvideo
        AppDto(
            id = "com.vk.vkvideo",
            name = "VK Видео: кино, сериалы, ТВ, мультфильмы и клипы",
            developer = "VK",
            category = Category.APP,
            ageRating = 12,
            size = 99.0f,
            iconUrl = "https://static.rustore.ru/apk/2027823295/content/ICON/97486018-5785-424d-9cab-4fe496d27c76.png",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/2026/4/15/39/apk/2027823295/content/SCREENSHOT/0cff6242-3ca9-4591-b6e7-42fbd31b4b2c.jpg",
                "https://static.rustore.ru/2026/4/15/5e/apk/2027823295/content/SCREENSHOT/508b971e-1220-4592-ae1f-a3f31f03dfd7.png",
                "https://static.rustore.ru/2026/7/2/f1/apk/2027823295/content/SCREENSHOT/8398b9a4-872c-4880-9b3d-fb885c31551f.png",
            ),
            description = "Смотрите фильмы, сериалы, шоу и ролики авторов. Находите видео по интересам и сохраняйте доступные записи для просмотра без интернета.",
        ),
    )
    override fun getApps(): List<App> {
        return appDto.map { dto ->
            mapper.toDomain(dto)
        }
    }
}