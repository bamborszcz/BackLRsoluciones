package com.lrsoluciones.repositories;

import com.lrsoluciones.models.Mail;
import org.springframework.data.repository.CrudRepository;

public interface MailRepository extends CrudRepository<Mail, Long> {
}
