package com.example.demo.Controller;

import com.example.demo.Model.Entry;
import com.example.demo.Model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @Autowired
    private Service service;

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("showAll", service.getAllEntries());
        return "index";
    }
    @GetMapping("/showAddEntryForm")
    public String showAddEntryForm(Model model){
        Entry entry = new Entry();
        model.addAttribute("addNewEntry", entry);
        return "new_entry";
    }
    @GetMapping("/saveEntry")
    public String saveEntry(Entry entry){
        service.saveEntry(entry);
        return "redirect:/";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateEntryForm(@PathVariable(value = "id") long id, Model model){
        Entry entry = service.getEntryById(id);
        model.addAttribute("updateEntry", entry);
        return "update_entry";
    }
    @GetMapping("/deleteEntry/{id}")
    public String deleteEntry(@PathVariable (value = "id") long id){
        this.service.deleteEntryById(id);
        return "redirect:/";
    }
    @GetMapping("/showEntry/{id}")
    public String showEntry(@PathVariable(value = "id") long id, Model model){
        Entry entry = service.getEntryById(id);
        model.addAttribute("showEntry", entry);
        return "show_entry";
    }
}
