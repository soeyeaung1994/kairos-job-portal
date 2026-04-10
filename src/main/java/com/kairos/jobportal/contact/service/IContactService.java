package com.kairos.jobportal.contact.service;

import com.kairos.jobportal.dto.ContactRequestDto;
import com.kairos.jobportal.dto.ContactResponseDto;
import com.kairos.jobportal.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 6/3/26
 * @Time: 5:16 pm
 */
public interface IContactService {

    boolean saveContact(ContactRequestDto contactRequestDto);

    List<ContactResponseDto> fetchNewContactMsgs();

    List<ContactResponseDto> fetchNewContactMsgsWithSort(String sortBy, String sortDir);

    Page<ContactResponseDto> fetchNewContactMsgsWithPaginationAndSort(int pageNumber, int pageSize, String sortBy, String sortDir);

    boolean closeContactMsg(Long id, String status);
}
