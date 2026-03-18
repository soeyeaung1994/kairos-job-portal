package com.kairos.jobportal.contact.service.impl;

import com.kairos.jobportal.contact.service.IContactService;
import com.kairos.jobportal.dto.ContactRequestDto;
import com.kairos.jobportal.entity.Contact;
import com.kairos.jobportal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @Author: Soe Ye Aung
 * @Date: 6/3/26
 * @Time: 5:16 pm
 */
@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        boolean result = false;
        Contact contact =contactRepository.save(transformToEntity(contactRequestDto));
        if(contact != null && contact.getId() != null){
            result = true;
        }
        return result;
    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto){
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        contact.setStatus("NEW");
        return contact;
    }
}
