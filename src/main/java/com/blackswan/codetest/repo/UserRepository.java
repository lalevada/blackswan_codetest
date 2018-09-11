package com.blackswan.codetest.repo;

import com.blackswan.codetest.domain.User;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Mark Andrews
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
