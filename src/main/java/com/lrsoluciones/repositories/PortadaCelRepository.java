package com.lrsoluciones.repositories;

import com.lrsoluciones.models.PortadaCel;
import com.lrsoluciones.models.PortadaWeb;
import org.springframework.data.repository.CrudRepository;

public interface PortadaCelRepository extends CrudRepository <PortadaCel, Long> {

    PortadaCel findByFotoCel(String fotoCel);
}
