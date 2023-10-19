package edu.asu.diging.citesphere.user.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.citesphere.user.IAccessToken;
import edu.asu.diging.citesphere.user.IUser;

@Entity
public class AccessToken implements IAccessToken {
    
    @Id
    @GeneratedValue(generator = "access_token_id_generator")
    @GenericGenerator(name = "access_token_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "AT"), 
                    strategy = "edu.asu.diging.citesphere.core.repository.IdGenerator"
            )
    private String id;
    
    private String userId;
    
    private String token;
    
    private String name;
    
    @ManyToOne(targetEntity=User.class)
    private IUser user;
    
    @Override
    public String getUserId() {
        return userId;
    }
    
    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Override
    public String getToken() {
        return token;
    }
    
    @Override
    public void setToken(String token) {
        this.token = token;
    }
    
    @Override
    public IUser getUser() {
        return user;
    }
    
    @Override
    public void setUser(IUser user) {
        this.user = user;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
