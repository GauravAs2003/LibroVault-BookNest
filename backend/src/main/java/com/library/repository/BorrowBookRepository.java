package com.library.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//import com.library.entity.BorrowBook;

//import java.util.List;

//@Repository
//public interface BorrowBookRepository extends JpaRepository<BorrowBook, Long> {
//    List<BorrowBook> findByUserId(Long userId);
//    List<BorrowBook> findByBookId(int bookId);
//    List<BorrowBook> findByStatus(String status);
//    List<BorrowBook> findByBookNameContainingIgnoreCase(String bookName);
//    
//    // NEW METHOD: Check if book is already borrowed
//    List<BorrowBook> findByBookIdAndStatus(int bookId, String status);
//}
//
//import org.springframework.data.jpa.repository.Query;
//
//public interface BorrowBookRepository extends JpaRepository<BorrowBook, Long> {
//
//    @Query("SELECT COUNT(b) FROM BorrowBook b WHERE b.status = 'BORROWED'")
//    long countBorrowedBooks();
//}

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.entity.BorrowBook;

public interface BorrowBookRepository extends JpaRepository<BorrowBook, Long> {

	long countByStatus(String status);

}
