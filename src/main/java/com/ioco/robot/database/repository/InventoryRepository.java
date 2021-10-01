package com.ioco.robot.database.repository;

import com.ioco.robot.database.model.Inventory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends PagingAndSortingRepository<Inventory,Long> {
}
