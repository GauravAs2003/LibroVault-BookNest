//package com.library.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.library.entity.Book;
//
//public interface BookRepository extends JpaRepository<Book, Integer> {
//
//    @Query("SELECT COALESCE(SUM(b.availableCopies), 0) FROM Book b")
//    Integer getTotalAvailableBooks();
//}
//

package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	// NO custom query needed
}
