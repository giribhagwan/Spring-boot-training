package com.intech.session10.services;

import com.intech.session10.domain.Book;
import com.intech.session10.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "#book")
public class BookService {
    private BookRepository bookRepository;
    private ModelMapper modelMapper;
    public Book save(Book book){
        return bookRepository.save(book);
    }
//    @Cacheable(cacheNames = "#book",key = "#id")
    @Cacheable(key = "#id")
    public Book getById(Long id){
        return bookRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException(MessageFormat.format("Book with id {0} Not found",id)));
    }
//    @CachePut(cacheNames = "#book",key = "#requestedBook.id")
    @CachePut(key = "#requestedBook.id")
    public Book update(Book requestedBook){
        Book databaseBook= bookRepository.findById(requestedBook.getId())
                .orElseThrow( () -> new EntityNotFoundException(MessageFormat.format("Book with id {0} Not found",requestedBook.getId())));
                modelMapper.map(requestedBook,databaseBook);
        return bookRepository.save(databaseBook);
    }
//    @CacheEvict(cacheNames = "#book",key = "#id")
    @CacheEvict(key = "#id")
    public String  delete(Long id){
           bookRepository.deleteById(id);
        return "Deleted";
    }
}
