package kg.nsi.crm.repository;


import kg.nsi.crm.entity.Stack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StackRepository extends JpaRepository<Stack, Long> {
    Stack findByName(String name);
    Stack getById(Long id);

    Stack getByName(String stackName);
}

