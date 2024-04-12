package edu.miu.cs.cs489.lesson6.citylibraryapp.dao;

import edu.miu.cs.cs489.lesson6.citylibraryapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
