package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.ContentMetadata;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MetadataRepository extends CrudRepository<ContentMetadata, Integer> {

}
