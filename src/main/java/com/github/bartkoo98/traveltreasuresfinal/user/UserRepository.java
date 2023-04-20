package com.github.bartkoo98.traveltreasuresfinal.user;

import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
