package com.lrsoluciones.repositories;

import com.lrsoluciones.models.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo,Long> {

    Photo findByPath(String path);
}
