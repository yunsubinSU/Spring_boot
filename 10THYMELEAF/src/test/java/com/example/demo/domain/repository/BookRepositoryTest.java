package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BookRepositoryTest {

        @Autowired
        private BookRepository bookRepository;

        @Test
        public void t1() throws Exception{
            //INSERT
//            Book book =
//                    Book.builder()
//                            .bookCode(1111L)
//                            .bookName("이것이리눅스다")
//                            .publisher("한빛미디어")
//                            .isbn("1111-1111")
//                            .build();
//
//            //bookRepository.save(book);
//
//            //UPDATE
//            book.setBookName("JAVA의 정석");
//            book.setPublisher("이지퍼블리싱");
//            book.setIsbn("1111-22-3333");
//            bookRepository.save(book);

            //DELETE
            bookRepository.deleteById(1111L);


        }
        
        //함수명명규칙 테스트
        @Test
        public void t2() throws Exception{
//                Optional<Book> bookOptional = bookRepository.findById(1111L);
//                if(bookOptional.isPresent())
//                        System.out.println(bookOptional.get());
                
//                List<Book> list = bookRepository.findByBookName("이것이리눅스다");
//                list.stream().forEach(System.out::println);
//                List<Book> list = bookRepository.findByPublisher("한빛미디어");
//                list.stream().forEach(System.out::println);

//                Book book =bookRepository.findByBookNameAndIsbn("C언어 기본","3333");
//                System.out.println(book);

                List<Book> list = bookRepository.findByBookNameContains("이것");
                list.stream().forEach(System.out::println);

                int book  = bookRepository.countByBookName("");
                System.out.println(book);
                int book2 =bookRepository.countByBookNameContains("");
                System.out.println(book2);
        }
}