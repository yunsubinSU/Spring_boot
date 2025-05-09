package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
        (
                basePackages ="com.example.demo.domain.repository",
                transactionManagerRef = "jpaTransactionManager"
        )
public class TxConfig {


    @Autowired
    private DataSource dataSource2;

    // 기본 TransactionManager
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager2() {
        //System.out.println("TX dataSrouce2 : " + dataSource2.toString());
        return new DataSourceTransactionManager(dataSource2);
    }


    //    JPA TransactionManager Settings
    @Bean(name="jpaTransactionManager")
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource2);

        return transactionManager;
    }

}

