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
