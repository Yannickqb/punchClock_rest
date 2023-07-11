package punchclock.controller;



import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import punchclock.Entry;
import punchclock.service.EntryService;
/*Now simply run the below command in your terminal $ brew install mysql.
        Start the MySQL service $ brew services start mysql.
        Set root MySQL password $ mysqladmin -u root password 'secretpassword'
        Access MySQL on mac $ mysql -u root -p.
        */
 
// https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseStatus.html
// https://www.baeldung.com/spring-response-status
// https://www.baeldung.com/spring-response-entity
@RestController
@RequestMapping("/entries")
public class EntryController {
    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    // https://spring.io/guides/gs/rest-service-cors/
    //  @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAllEntries();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry) {
        return entryService.createEntry(entry);
    }

   // ...

    //..




}
