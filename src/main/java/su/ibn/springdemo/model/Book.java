package su.ibn.springdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


/*
@Data — это удобная сокращённая аннотация, которая содержит в себе возможности из
@ToString,
@EqualsAndHashCode,
@Getter
@Setter
@RequiredArgsConstructor
 */
@Data
@Entity
public class Book {

    /*
    GenerationType.AUTO — выбор генератора осуществляется на основе диалекта.
    Не самый лучший вариант, так как тут как раз действует правило “явное лучше неявного”.

    GenerationType.IDENTITY — самый простой способ конфигурирования генератора. Он опирается на auto-increment колонку в таблице.
    Следовательно, чтобы получить id при persist-е нам нужно сделать insert.
    Именно поэтому он исключает возможность отложенного persist-а и следовательно batching-а.

    GenerationType.SEQUENCE — наиболее удобный случай, когда id мы получаем из sequence.

    GenerationType.TABLE — в этом случае hibernate эмулирует sequence через дополнительную таблицу.
    Не самый лучший вариант, т.к. в таком решении hibernate приходится юзать отдельную транзакцию и lock на строчку.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String name;
}
