package com.studio.records.repositories;

import com.studio.records.entities.Performer;
import com.studio.records.entities.RecordStudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformerRepo extends JpaRepository<Performer,Long> {
    Performer findByTitle(String title);

    void deleteByTitle(String title);
}
