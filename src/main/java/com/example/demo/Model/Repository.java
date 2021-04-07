package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Entry, Long> {
}
