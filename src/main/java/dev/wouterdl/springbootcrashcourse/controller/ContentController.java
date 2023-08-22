package dev.wouterdl.springbootcrashcourse.controller;

import dev.wouterdl.springbootcrashcourse.model.Content;
import dev.wouterdl.springbootcrashcourse.model.Status;
import dev.wouterdl.springbootcrashcourse.repository.ContentCollectionRepository;
import dev.wouterdl.springbootcrashcourse.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.Inet4Address;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/content")
@CrossOrigin
public class ContentController {

    private final ContentRepository repository;


    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    //Make request and find all pieces of content in system

    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }

    //CRUD +

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }

        repository.save(content);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);

    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return repository.listByStatus(status);
    }

}
