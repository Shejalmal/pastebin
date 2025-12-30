package com.pastebin.demo.repository;

import com.pastebin.demo.model.Paste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasteRepository extends JpaRepository<Paste, String> {
    // Spring will automatically implement the database methods (save, findById, etc.)
}