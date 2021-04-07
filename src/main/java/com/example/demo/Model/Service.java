package com.example.demo.Model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository;

    public List<Entry> getAllEntries(){return repository.findAll();}

    public void saveEntry(Entry entry) {this.repository.save(entry);}

    public Entry getEntryById(long id){
        Optional<Entry> optionalEntry = repository.findById(id);
        Entry entry;
        if(optionalEntry.isPresent()){
            entry = optionalEntry.get();
        } else {
            throw new RuntimeException("Not found");
        }
        return entry;
    }

    public void deleteEntryById(long id){
        this.repository.deleteById(id);
    }
}
