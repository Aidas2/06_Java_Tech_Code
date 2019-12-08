package com.studio.records.repositories;

import com.studio.records.entities.Performer;
import com.studio.records.entities.RecordStudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordStudioRepo extends JpaRepository<RecordStudio,Long> {

    RecordStudio findByTitle(String title);

    void deleteByTitle(String title);
}
