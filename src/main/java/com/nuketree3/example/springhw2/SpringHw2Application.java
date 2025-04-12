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
 * 1. В предыдущий проект добавить следующие ресурсы, которые возвращают готовые HTML-страницы:
 * 1.1 /ui/books - на странице должен отобразиться список всех доступных книг в системе
 * 1.2 /ui/reader - аналогично 1.1
 * 1.3 /ui/issue - на странице отображается таблица, в которой есть столбцы (книга, читатель, когда взял, когда вернул (если не вернул, то пустая ячейка)).
 * 1.4 /ui/reader/{id} - страница, где написано имя читателя с идентификатором id и перечислены книги, которые на руках у этого читателя
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
