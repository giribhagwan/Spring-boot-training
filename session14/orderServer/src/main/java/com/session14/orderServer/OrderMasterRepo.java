package com.session14.orderServer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepo extends JpaRepository<OrderMaster,Long> {
}
