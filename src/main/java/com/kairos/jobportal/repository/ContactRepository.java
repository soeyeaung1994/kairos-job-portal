package com.kairos.jobportal.repository;

import com.kairos.jobportal.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Soe Ye Aung
 * @Date: 3/3/26
 * @Time: 11:52 am
 */

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
