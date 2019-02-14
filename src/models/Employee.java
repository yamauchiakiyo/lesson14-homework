package models;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="employees")
@NamedQueries({
    @NamedQuery(
            name="getAllEmployees",
            query="SELECT e FROM Employee AS e ORDER BY e.id DESC"
            ),
    @NamedQuery(
            name="getEmployeeCount",
            query="SELECT COUNT (e) FROM Employee AS e"
            ),
    @NamedQuery(
            name="checkRegisteredCode",
            query="SELECT COUNT(e) FROM Employee AS e WHERE e.code= :code"
            ),
    @NamedQuery(
            name="checkLoginCodeAndPassword",
            query="SELECT e FROM Employee AS e WHERE e.delete_flag=0 AND e.code = :code AND e.password = :pass"
            )

})
@Entity

public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="code" , nullable=false, unique=true)
    private String code;

    @Column(name="name",nullable=false)
    private String name;

    @Column(name="password",length = 64 , nullable=false)
    private String password;

    @Column(name="admin_flag",nullable=false)
    private Integer admin_flag;

    @Column(name="created_at",nullable = false)
    private Timestamp created_at;

    @Column(name="updated_at",nullable = false)
    private Timestamp updated_at;

    @Column(name="delete_flag", nullable=false)
    private Integer delete_flag;

    private Integer getId(){
        return id;
    }

    private void setId(Integer id){
        this.id = id;
    }

    private String getCode(){
        return code;
    }

    private void setCode(String code){
        this.code = code;
    }

    private String getName(){
        return name;
    }

    private void setName(String name){
        this.name=name;
    }

    private String getPassword(){
        return password;
    }

    private void setPassword(String password){
        this.password = password;
    }

    private Integer getAdmin_flag(){
        return admin_flag;
    }

    private void setAdmin_flag(Integer admin_flag){
        this.admin_flag=admin_flag;
    }

    private Timestamp getCreated_at(){
        return created_at;
    }

    private void setCreated_at(Timestamp created_at){
        this.created_at=created_at;
    }

    private Timestamp getUpdated_at(){
        return updated_at;
    }

    private void setUpdated_at(Timestamp updated_at){
        this.updated_at=updated_at;
    }

    private Integer getDelete_flag(){
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag){
        this.delete_flag = delete_flag;
    }


}
