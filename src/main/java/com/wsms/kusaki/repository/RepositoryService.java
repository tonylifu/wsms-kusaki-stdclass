package com.wsms.kusaki.repository;

import com.wsms.kusaki.entity.Student;
import com.wsms.kusaki.entity.AccountBalance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class RepositoryService implements RepositoryServiceI {
    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;

    @Override
    public List<Student> getStudents(String assignedClass) {
        return studentRepository.findByEntryClassAssigned(assignedClass);
    }

    @Override
    public String getStudentBalance(String id) {
        var balance = accountRepository.findById(id).map(AccountBalance::getBalance);
        if (balance.isPresent()) {
            return String.valueOf(balance.get());
        }
        return "processing error";
    }
}
