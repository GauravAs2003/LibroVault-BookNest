package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.entity.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
