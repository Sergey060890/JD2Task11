# JD2Task11

Создать проект. 
В нем два maven подмодуля, 
один -repository, 
второй - service. 
Подключить checkstyle, jacoco.

В maven подмодуле repository реализовать маппинг 
на JPA entityTest(Hibernate), создать DAO, используя 
параметризацию класса через Generic. 
Базу создавать через liquibase. 
Покрыть тестами используя H2(базу накатывать через Hibernate).

В maven подмодуле service реализовать подключение 
maven подмодуля repository. Реализовать класс содержащий main. 
В main методе наполнить базу тестовыми данными через DAO.

Существует перечень Курсов, за каждым из 
которых закреплен Преподаватель. 
Студент записывается на один или несколько Курсов, 
выполняет задания. Преподаватель выставляет оценки 
за задания Студенту и добавляет отзыв. 
Администратор управляет Курсами и Преподавателями. 
(Поля у сущностей добавляйте по необходимости на свой выбор).
