## Тестовое задание от Bell Integrator

#### Для всех заданий:
* Необходимо параметризовать и вынести часто используемые/дублируемые инструкции в отдельные функции.
* Предусмотреть использование recovery-действий, в случае неожиданного результата.
* В каждом действии по переходу должны быть встроены логические проверки-ожидания открытия страницы.
* Каркас - фреймворк unit-тестирования J-Unit.
* Результатом выполнения должен быть Allure отчет.
* Проект должен быть оформлен как артефакт Maven.
* Исходный код проекта должен быть выложен на github или bitbucket.

#### Задание 1
1.	Перейти на https://www.google.com/
2.	Осуществить поиск по слову открытие. Убедиться что в выборке есть "Банк «Открытие» — вклады, кредитные 
и дебетовые ...".
3.	Перейти по ссылке, найденной в предыдущем шаге.
4.	На открывшейся странице найти таблицу с курсом обмена. Убедиться что курс покупки доллара меньше курса продажи 
доллара.
5.	Требования:
6.	Использовать Java, Cucumber, Junit, Allure, PageObgect или PageFactory, Selenium или Selenide.
7.	Тест должен работать даже если структура таблицы измениться (столбцы/строки поменяются местами/появятся новые)

#### Задание 2
1.  Для запроса LIST USERS ресурса https://reqres.in/ убедиться что имена файлов аватаров пользователей одинаковые.