
// Java Program Illustrating Configuration of 
// DataSourceConfiguration of DataSource 
  
package com.panther.db; 
  
import javax.sql.DataSource; 
import org.springframework.boot.jdbc.DataSourceBuilder; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
  
// Annotation 
@Configuration
  
// Class 
public class configDataSource { 
  
    @Bean public static DataSource source() 
    { 
  
        DataSourceBuilder<?> dSB 
            = DataSourceBuilder.create(); 
        dSB.driverClassName("com.mysql.jdbc.Driver"); 
  
        // MySQL specific url with database name 
        dSB.url("jdbc:mysql://localhost:3306/senior-project-test?"); 
  
        // MySQL username credential 
        dSB.username("root"); 
  
        // MySQL password credential 
        dSB.password("EEKq3Rq9mc!DW!E"); 
  
        return dSB.build(); 
    } 
}