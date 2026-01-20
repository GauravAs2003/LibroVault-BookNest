package com.library.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.library.entity.BorrowHistory;

public interface BorrowHistoryRepository extends JpaRepository<BorrowHistory, Long> {

	List<BorrowHistory> findByUserId(Long userId);
}
