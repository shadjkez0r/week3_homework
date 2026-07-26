# 🏛️ GoF Design Patterns Showcase (Java 17+)

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8%2B-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Patterns](https://img.shields.io/badge/GoF%20Patterns-6%20Implemented-4EAA25?style=for-the-badge)
![Theme](https://img.shields.io/badge/Theme-Pok%C3%A9mon%20%7C%20Witcher-purple?style=for-the-badge)

Учебный и архитектурный проект (Homework 3), представляющий собой практическую реализацию 6 классических паттернов проектирования Gang of Four (GoF) на языке Java. Все паттерны смоделированы на ярких нетривиальных предметных областях (экосистема Pokémon, диалоговая система The Witcher и интеграция Looney Tunes).

---

## 🏗️ Структура проекта и реализованные паттерны

Проект разделен на 6 независимых модулей, каждый из которых инкапсулирует решение конкретной архитектурной проблемы:

```text
src/main/java/evg/megatron/
├── adapter/                 # Паттерн Adapter (Интеграция JSON с легаси CSV-сервисом)
├── builder/                 # Паттерн Builder (Пошаговое конструирование сложных объектов)
├── chain_of_responsibility/ # Паттерн Chain of Responsibility (Конвейер проверок Покемонов)
├── decorator/               # Паттерн Decorator (Динамическое расширение диалогов Ведьмака)
├── proxy/                   # Паттерн Proxy (Кеширующий прокси для репозитория Покедекса)
└── strategy/                # Паттерн Strategy (Динамическая смена поведения в зависимости от локации)
```

---

## 🔍 Детальный разбор паттернов

### 🔌 1. Adapter (Адаптер)
**Пакет:** `evg.megatron.adapter`
- **Проблема:** Необходимость интеграции современных данных из формата JSON (`LooneyTunesCharacter`) со старой устаревшей системой, принимающей строго строковый CSV-формат (`LegacyCsvService`).
- **Решение:** Создание адаптера `JsonToCsvAdapter`, реализующего целевой интерфейс `Loadable`. Адаптер прозрачно для клиента преобразует объекты в формат "значение,значение" и передает их в легаси-сервис.

### 🏗️ 2. Builder (Строитель)
**Пакет:** `evg.megatron.builder`
- **Проблема:** Создание сложного доменного объекта `Pokemon` с множеством обязательных и опциональных характеристик (`PokemonType`, `PsychoType`, `Gender`, статистика), избегая "телескопных конструкторов" и неконсистентного состояния.
- **Решение:** Реализация статического вложенного билдера с текучим интерфейсом (Fluent API) и строгой инкапсуляцией полей.

### ⛓️ 3. Chain of Responsibility (Цепочка обязанностей)
**Пакет:** `evg.megatron.chain_of_responsibility`
- **Проблема:** Моделирование многоэтапной сертификации тренера в Лиге Покемонов (`PokemonExamineService`), где кандидат должен последовательно пройти проверку значков гима (`GymBadgeExamine`), региональной лиги (`RegionalLeagueExamine`), Элитной Четверки (`EliteFourExamine`) и битвы с Чемпионом (`ChampionBattleExamine`).
- **Решение:** Построение цепочки обработчиков `Examine`. Каждый этап принимает решение о прохождении проверки или досрочном прерывании конвейера, разгружая клиентский код от монолитных условий `if-else`.

### 🎭 4. Decorator (Декоратор)
**Пакет:** `evg.megatron.decorator`
- **Проблема:** Динамическое добавление новых философских смыслов и вариантов выбора в диалоговую систему Геральта из Ривии (`WitcherDialog`, `Dialog`) во время выполнения.
- **Решение:** Создание гибкой иерархии декораторов (`LessMoreMiddleDialogDecorator`, `NotHolyHermitDialogDecorator`, `PreferNotToChooseDialogDecorator`), оборачивающих базовый диалог и наслаивающих новые варианты ответов без изменения исходного класса.

### 🛡️ 5. Proxy (Заместитель)
**Пакет:** `evg.megatron.proxy`
- **Проблема:** Высокие накладные расходы при повторных обращениях к базе данных / внешнему сервису при запросе информации о Покемонах (`PokedexRepository`).
- **Решение:** Реализация паттерна Кеширующий Прокси (`CachedPokedexRepository`), реализующего общий интерфейс `Repository`. Прокси перехватывает запросы к `Pokedex`, проверяет локальный кэш и обращается к реальному репозиторию только при промахе кэша (Cache Miss).

### 🎯 6. Strategy (Стратегия)
**Пакет:** `evg.megatron.strategy`
- **Проблема:** Поведение игрока (`PokemonMaster`) при поиске и ловле покемонов должно кардинально меняться в зависимости от текущей игровой локации.
- **Решение:** Выделение алгоритмов поведения в интерфейс `Location` и реализация конкретных стратегий: лес (`ForestLocation`), поле (`FieldLocation`) и город (`CityLocation`). Смена стратегии происходит динамически в рантайме.

---

## 🛠️ Используемые принципы и технологии
- **Чистый ООП:** Инкапсуляция, наследование, полиморфизм.
- **SOLID:** Принцип единственной ответственности (SRP), Принцип открытости/закрытости (OCP), Принцип инверсии зависимостей (DIP).
- **GoF Design Patterns:** Creational (Builder), Structural (Adapter, Decorator, Proxy), Behavioral (Chain of Responsibility, Strategy).

---

## 🚀 Требования и инструкция по запуску

### 📋 Требования (Requirements)
- **Java Development Kit (JDK):** версия 17 или выше
- **Сборщик проектов:** Apache Maven 3.8+
- **Операционная система:** Windows / Linux / macOS

### 🛠️ Инструкция по сборке и тестированию (How to Run & Test)

1. **Клонирование репозитория:**
   ```bash
   git clone https://github.com/shadjkez0r/Homework3.git
   cd Homework3
   ```

2. **Сборка проекта через Maven:**
   ```bash
   mvn clean package
   ```

3. **Запуск автоматических тестов для всех 6 паттернов GoF:**
   В проекте реализовано полное тестовое покрытие для каждого паттерна (в папке `src/test/java`). Чтобы запустить проверку и демонстрацию работы всех 6 паттернов разом, выполните команду:
   ```bash
   mvn test
   ```
   *Вывод тестов покажет работу каждого паттерна: `JsonToCsvAdapterTest`, `PokemonTest` (Builder), `PokemonExamineServiceTest` (Chain of Responsibility), `WitcherDialogTest` (Decorator), `CachedPokedexRepositoryTest` (Proxy) и `PokemonMasterTest` (Strategy).*

4. **Запуск консольной демонстрации паттерна Strategy (Поиск покемонов):**
   Для паттерна Стратегия также предусмотрено интерактивное консольное приложение:
   ```bash
   java -cp target/Homework3-1.0-SNAPSHOT.jar evg.megatron.strategy.Main
   ```
