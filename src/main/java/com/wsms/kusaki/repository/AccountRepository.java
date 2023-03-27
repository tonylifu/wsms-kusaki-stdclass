package com.wsms.kusaki.repository;

import com.wsms.kusaki.entity.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountBalance, String> {
}
