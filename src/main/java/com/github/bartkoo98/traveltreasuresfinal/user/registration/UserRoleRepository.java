package com.github.bartkoo98.traveltreasuresfinal.user.registration;

import com.github.bartkoo98.traveltreasuresfinal.user.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    Optional<UserRole> findByName(String name);
}
