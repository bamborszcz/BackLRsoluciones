package com.lrsoluciones.repositories;

import com.lrsoluciones.models.PortadaWeb;
import org.springframework.data.repository.CrudRepository;

public interface PortadaWebRepository extends CrudRepository<PortadaWeb, Long> {

    PortadaWeb findByFotoWeb(String fotoWeb);

}
