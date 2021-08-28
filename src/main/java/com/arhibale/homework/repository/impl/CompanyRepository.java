package com.arhibale.homework.repository.impl;

import com.arhibale.homework.repository.MapRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository implements MapRepository<String> {

    private final Map<Long, String> companyDb = new ConcurrentHashMap<>();
    private final AtomicLong atomicLong = new AtomicLong();

    public CompanyRepository() {
        companyDb.put(atomicLong.incrementAndGet(), "Red Apple");
        companyDb.put(atomicLong.incrementAndGet(), "Cyber Pineapple");
        companyDb.put(atomicLong.incrementAndGet(), "Devil's Banana");
    }

    @Override
    public List<String> findAll() {
        return companyDb.values().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String findById(Long id) {
        return companyDb.get(id);
    }

    @Override
    public void deleteById(Long id) {
        companyDb.remove(id);
    }

    @Override
    public void save(String company) {
        companyDb.put(atomicLong.incrementAndGet(), company);
    }
}