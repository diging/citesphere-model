package edu.asu.diging.citesphere.user;

public interface IAccessToken {
    
    String getUserId();

    void setUserId(String userId);

    String getToken();

    void setToken(String token);

    IUser getUser();

    void setUser(IUser user);
    
    String getName();
    
    void setName(String name);
}
