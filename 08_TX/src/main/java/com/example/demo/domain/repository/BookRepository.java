package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByBookName(String bookName);
    List<Book> findByPublisher(String publisher);
    List<Book> findByIsbn(String isbn);
    //단일이아닌 두개이상을 할때 and를 사용한다.
    Book findByBookNameAndIsbn(String bookName, String isbn);
    //해당 키워드로 검색해보기
    List<Book> findByBookNameContains(String keyword);
    int countByBookName(String bookName);
    int countByBookNameContains(String bookName);
    //삭제
    Book deleteByBookName(String bookName);
}
