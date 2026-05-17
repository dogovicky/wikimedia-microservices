package com.capricon.wikimediaconsumer.repository;

import com.capricon.wikimediaconsumer.model.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}
