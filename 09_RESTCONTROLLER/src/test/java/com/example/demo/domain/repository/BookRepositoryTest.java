package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    //기본 CRUD TEST
    @Test
    public void t1() throws Exception{
        //INSERT
        Book book =
                Book.builder()
                        .bookCode(1111L)
                        .bookName("이것이리눅스다")
                        .publisher("한빛미디어")
                        .isbn("1111-1111")
                        .build();

        //bookRepository.save(book);
        
//        //UPDATE (북코드가 들어가 있는 상태에서 업데이트가 된다)
//        book.setBookName("JAVA의 정석");
//        book.setPublisher("이지퍼블리싱");
//        book.setIsbn("1111-22-3333");
//        bookRepository.save(book);

        //DELETE
        bookRepository.deleteById(1111L);

    }

    //함수명명규칙 테스트
    @Test
    @Transactional
    @Rollback(false)
    public void t2() throws Exception{
//        Optional<Book> bookOptional = bookRepository.findById(1111L);
//        if(bookOptional.isPresent())
//            System.out.println(bookOptional.get());
//        List<Book> list = bookRepository.findByBookName("이것이리눅스다");
//        list.stream().forEach(System.out::println);
//        List<Book> list = bookRepository.findByPublisher("한빛미디어");
//        list.stream().forEach(System.out::println);

//        Book book = bookRepository.findByBookNameAndIsbn("C언어 기본","3333");
//        System.out.println(book);

        /*List<Book> list = bookRepository.findByBookNameContains("이것");
        list.stream().forEach(System.out::println);*/

        /*int book = bookRepository.countByBookName("이것이리눅스다");
        System.out.println(book);*/

        /*int book = bookRepository.countByBookNameContains("C언어 기본");
        System.out.println(book);*/

        //삭제 부분

        System.out.println("삭제 전");
        bookRepository.findAll().forEach(System.out::println);

        bookRepository.deleteByBookName("이것이리눅스다");

        System.out.println("삭제 후");
        bookRepository.findAll().forEach(System.out::println);

        //롤백으로 인해 값이 삭제 안되는 것을 확인 할 수 있는데 rollback(false)를 추가해주면 값이 사라진것을 확인할 수 있다.

    }
}