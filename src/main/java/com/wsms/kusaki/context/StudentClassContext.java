//package com.wsms.kusaki.context;
//
//import com.websms.app.lib.model.StudentClassModel;
//import com.websms.app.model.repository.AccountRepository;
//import com.websms.app.model.repository.RepositoryService;
//import com.websms.app.model.repository.RepositoryServiceI;
//import com.websms.app.model.repository.StudentRepository;
//import com.websms.app.model.service.StudentClassService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class StudentClassContext {
//
//    @Bean
//    public RepositoryServiceI getRepositoryService(final StudentRepository studentRepository, final AccountRepository accountRepository) {
//        return new RepositoryService(studentRepository, accountRepository);
//    }
//    @Bean
//    public StudentClassModel getStudentClassService(final RepositoryServiceI repositoryService) {
//        return new StudentClassService(repositoryService);
//    }
//}
