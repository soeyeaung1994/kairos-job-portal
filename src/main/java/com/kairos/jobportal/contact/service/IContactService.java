package com.kairos.jobportal.contact.service;

import com.kairos.jobportal.dto.ContactRequestDto;
import com.kairos.jobportal.entity.Contact;

/**
 * @Author: Soe Ye Aung
 * @Date: 6/3/26
 * @Time: 5:16 pm
 */
public interface IContactService {

    boolean saveContact(ContactRequestDto contactRequestDto);
}
