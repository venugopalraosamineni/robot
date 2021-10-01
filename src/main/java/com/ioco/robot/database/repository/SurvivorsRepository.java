package com.ioco.robot.database.repository;

import com.ioco.robot.database.model.Survivor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorsRepository extends PagingAndSortingRepository<Survivor,Long> {
}
