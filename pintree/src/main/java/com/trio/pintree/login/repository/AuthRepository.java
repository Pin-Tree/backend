package com.trio.pintree.login.repository;

import com.trio.pintree.login.domain.Auth;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<Auth, String> {
}
