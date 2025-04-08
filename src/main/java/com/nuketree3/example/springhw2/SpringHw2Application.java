package com.nuketree3.example.springhw2;

import com.nuketree3.example.springhw2.domain.Book;
import com.nuketree3.example.springhw2.domain.Reader;
import com.nuketree3.example.springhw2.repositories.BookRepository;
import com.nuketree3.example.springhw2.repositories.ReaderRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * 1. Доделать сервис управления книгами:
 * 1.1 Реализовать контроллер по управлению книгами с ручками: GET /book/{id} - получить описание книги, DELETE /book/{id} - удалит книгу, POST /book - создать книгу
 * 1.2 Реализовать контроллер по управлению читателями (аналогично пункту 1.1)
 * 1.3 В контроллере IssueController добавить ресурс GET /issue/{id} - получить описание факта выдачи
 *
 * 2.1 В сервисе IssueService добавить проверку, что у пользователя на руках нет книг. Если есть - не выдавать книгу (статус 409 - Conflict)
 * 2.2 В сервисе читателей добавить ручку GET /reader/{id}/issue - вернуть список всех выдачей для данного читателя
 *
 * 3.1* В Issue поле timestamp разбить на 2: issued_at и returned_at - дата выдачи и дата возврата
 * 3.2* К ресурсу POST /issue добавить запрос PUT /issue/{issueID}, который закрывает факт выдачи. (т.е. проставляет returned_at в Issue).
 * Замечание: возвращенные книги не нужно учитывать при 2.1
 * 3.3** Пункт 2.1 расширить параметром, сколько книг может быть на руках у одного пользователя.
 * Должно задаваться в конфигурации (параметр application.issue.max-allowed-books). Если параметр не задан, то использовать значение равное 1
 */

@SpringBootApplication
public class SpringHw2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringHw2Application.class, args);
        context.getBean(BookRepository.class).getBooks().addAll(List.of(
                new Book(1L, "Война и мир"),
                new Book(2L, "Герой нашего времени"),
                new Book(3L, "Капитал"),
                new Book(4L, "Энциклопедия")
        ));

        context.getBean(ReaderRepository.class).getReaders().addAll(List.of(
                new Reader(1L, "Андрей"),
                new Reader(1L, "Владимир"),
                new Reader(1L, "Евгения")
        ));

    }

}
