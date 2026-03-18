package com.kairos.jobportal.contact.controller;

import com.kairos.jobportal.contact.service.IContactService;
import com.kairos.jobportal.dto.ContactRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Soe Ye Aung
 * @Date: 6/3/26
 * @Time: 8:25 pm
 */

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final IContactService contactService;

    @PostMapping(path = "/public", version = "1.0")
    public ResponseEntity<String> saveContactMsg(@RequestBody @Valid ContactRequestDto contactRequestDto){
        boolean isSaved = contactService.saveContact(contactRequestDto);
        if(isSaved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Request processed successfully");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request processed failed");
        }
    }

    @GetMapping(version = "1.0")
    public ResponseEntity<String> fetchOpenStatus(@RequestParam
                                                      @Validated @NotBlank(message = "Status cannot be empty!")
                                                      @Size(min = 4,message = "Status length should be of minimum 4 chars")
                                                      String status){
        return ResponseEntity.ok("Fetching open contact status: " + status);
    }
}
