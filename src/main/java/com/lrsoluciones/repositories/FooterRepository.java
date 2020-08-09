package com.lrsoluciones.repositories;
import com.lrsoluciones.models.FooterImg;
import org.springframework.data.repository.CrudRepository;

public interface FooterRepository extends CrudRepository<FooterImg, Long> {

    FooterImg findByFoto(String foto);
}
