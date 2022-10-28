package org.binar.challenge_4.repository;

import org.binar.challenge_4.entities.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository {

    Optional<Role> findRoleByName(String name);

}
