[![Build status](https://ci.appveyor.com/api/projects/status/df31uj7cvd1g2m6u?svg=true)](https://ci.appveyor.com/project/Evgenia-Vl/bdd)

Домашнее задание к занятию «2.4. BDD»
В качестве результата пришлите ссылки на ваши GitHub-проекты в личном кабинете студента на сайте netology.ru.

Все задачи этого занятия нужно делать в разных репозиториях.

Важно: если у вас что-то не получилось, то оформляйте issue по установленным правилам.

Важно: не делайте ДЗ всех занятий в одном репозитории. Иначе вам потом придётся достаточно сложно подключать системы Continuous integration.

Как сдавать задачи
Инициализируйте на своём компьютере пустой Git-репозиторий.
Добавьте в него готовый файл .gitignore.
Добавьте в этот же каталог код ваших автотестов.
Сделайте необходимые коммиты.
Добавьте в каталог artifacts целевой сервис (app-ibank-build-for-testers.jar).
Создайте публичный репозиторий на GitHub и свяжите свой локальный репозиторий с удалённым.
Сделайте пуш — удостоверьтесь, что ваш код появился на GitHub.
Удостоверьтесь, что в AppVeyor сборка выполняется: запускается тестируемый сервис и тесты. При отсутствии багов в сервисе сборка должна быть зелёной.
Поставьте бейджик сборки вашего проекта в файл README.md.
Ссылку на ваш проект отправьте в личном кабинете на сайте netology.ru.
Задачи, отмеченные как необязательные, можно не сдавать, это не повлияет на получение зачёта.
Если вы обнаружили подозрительное поведение SUT, похожее на баг, создайте описание в issue на GitHub. Придерживайтесь схемы при описании.
Если в проекте реализован тест или тесты, направленные на поиск описанных в issues багов тестируемого сервиса, то такие тесты будут падать до исправления багов сервиса, сборка в AppVeyor будет красной.
Настройка CI
Настройка CI осуществляется аналогично предыдущему заданию. Поскольку у вас и так специальная тестовая сборка, то ничего в самом сервисе делать не нужно.

Задача №1: Page Object's
Вам необходимо добить тестирование функции перевода с карты на карту. Разработчики пока реализовали возможность перевода только между своими картами, но уже хотят, чтобы вы всё протестировали.

Для этого они не поленились и захардкодили вам целого одного пользователя:

* login: 'vasya'
* password: 'qwerty123'
* verification code (hardcoded): '12345'
* cards:
    * first:
        * number: '5559 0000 0000 0001'
        * balance: 10 000 RUB
    * second:
        * number: '5559 0000 0000 0002'
        * balance: 10 000 RUB
          После логина, который уже мы сделали на лекции, вы получите список карт:



Нажав на кнопку «Пополнить», вы перейдёте на страницу перевода средств:



При успешном переводе вы вернётесь назад на страницу со списком карт.

Это ключевой кейс, который нужно протестировать.

Нужно, чтобы вы через Page Object's добавили доменные методы:

перевода с определённой карты на другую карту энной суммы,
проверки баланса по карте со страницы списка карт.
Вы можете познакомиться с некоторыми подсказками по реализации этой задачи.

P.S. Чтобы вам было не скучно, мы добавили порядком багов, поэтому как минимум один issue в GitHub у вас должен быть 😈

Подсказка
Задача №2: BDD (необязательная)
Используя Page Object's из предыдущей задачи, на базе шаблона Cucumber с лекции реализуйте кастомные steps:

когда пользователь переводит 5 000 рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы,
тогда баланс его 1 карты из списка на главной странице должен стать 15 000 рублей.
Тогда вместе с логином, который мы сделали на лекции, всё должно выглядеть вот так:

пусть пользователь залогинен с именем «vasya» и паролем «qwerty123»,
когда пользователь переводит 5 000 рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы,
тогда баланс его 1 карты из списка на главной странице должен стать 15 000 рублей.
