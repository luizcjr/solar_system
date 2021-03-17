package com.example.solarsystemclean.domain

import com.example.solarsystemclean.domain.model.Features
import com.example.solarsystemclean.domain.model.Planets
import com.example.solarsystemclean.domain.model.Satellites

object PlanetsFactory {
    val searchTags = listOf("planeta", "terra")
    val satellites = Satellites(
        number = 1,
        names = listOf(
            "Lua"
        )
    )
    val feature = Features(
        orbitalPeriod = listOf("365, 26 dias", "1 ano"),
        orbitalSpeed = "29,78 km/s",
        rotationDuration = "23h56min",
        radius = "6.371 km",
        diameter = "12.742 km",
        sunDistance = "149.600.000 km",
        temperature = "15ºC",
        satellites = satellites,
    )

    val planets = listOf(
        Planets(
            id = 1,
            name = "Terra",
            resume = "O planeta Terra é o planeta habitado por nós, seres vivos. Conhecido também como planeta água, é o maior dentre os quatro planetas rochosos que fazem parte do Sistema Solar. O Planeta Terra é um dos planetas que fazem parte do Sistema Solar e é o terceiro planeta mais próximo do Sol. A sua formação ocorreu há bilhões de anos, assim como a existência de vida aqui . Algumas teorias explicam sua origem, como a teoria da nebulosa solar",
            introduction = "",
            image = "https://i.ibb.co/VjXymhb/earth.png",
            searchTags = searchTags,
            features = feature,
            geography = "",
            favorite = false
        ),
        Planets(
            id = 2,
            name = "Sol",
            resume = "O Sol é a estrela do sistema solar. Todos os corpos celestes desse sistema, inclusive a Terra, giram em torno dele. O diâmetro do Sol é de 1,392 milhão de quilômetros. Ele é composto principalmente por hidrogênio e hélio, além de ferro, níquel, oxigênio, silício, carbono, nitrogênio, enxofre, etc. Sua temperatura varia, podendo atingir até 5.505 graus Celsius na superfície e 16 milhões de graus Celsius no núcleo",
            introduction = "",
            image = "https://i.ibb.co/D714Rsd/sun.png",
            searchTags = searchTags,
            features = feature,
            geography = "",
            favorite = false
        ),
        Planets(
            id = 3,
            name = "Mercúrio",
            resume = "Mercúrio é um planeta que não possui uma inclinação semelhante à da Terra. Sem essa inclinação e com uma translação curta, não há existência de estações do ano. Essa baixa inclinação explica também o gelo encontrado nas crateras desse planeta. O nome do planeta está relacionado às culturas mitológicas grega e romana. Segundo esses dois povos, Hermes (para os gregos) e Mercúrio (para os romanos) são considerados os deuses dos mensageiros, atuando de forma rápida na comunicação entre os povos",
            introduction = "",
            image = "https://i.ibb.co/t3qYgWk/mercury.png",
            searchTags = searchTags,
            features = feature,
            geography = "",
            favorite = false
        ),
        Planets(
            id = 4,
            name = "Vênus",
            resume = "Vênus é o segundo planeta do sistema Solar mais próximo do Sol. Tem cerca de 800 milhões de anos e além do Sol e da Lua é o corpo celeste mais brilhante no céu, motivo pelo qual é conhecido desde a antiguidade. Também chamado de Estrela Dalva, estrela da manhã, estrela da tarde e joia do céu, é considerado um planeta irmão da Terra. Isso decorre em virtude das similaridades de massa, densidade e volume entre ambos",
            introduction = "",
            image = "https://i.ibb.co/ccVq5Vs/venus.png",
            searchTags = searchTags,
            features = feature,
            geography = "",
            favorite = false
        )
    )
}