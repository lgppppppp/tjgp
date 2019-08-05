package cn.com.taiji.security.securitydemo1.repository;

import cn.com.taiji.security.securitydemo1.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
