package services;

import model.dao.UserDAO;
import model.entity.User;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;

    }

    public User createUser(User user) {

        if (user == null || user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email do usuário é obrigatório");
        }
        if (!user.getEmail().contains("@") || !user.getEmail().contains("."))  {
            throw new IllegalArgumentException("Email inválido.");
        }

        if (userDAO.FindByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Usuário com esse email já está cadastrado");
        }



        return userDAO.Create(user);
        
    }

    public User updateUser(User user){
        if(user == null){
            throw new IllegalArgumentException("Usuario está nulo");

        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email do usuário é obrigatório");
        }
        if(userDAO.FindByEmail(user.getEmail()) == null){
            throw new IllegalArgumentException("Usuario não cadastrado ainda");

        }
        User dao = userDAO.FindByEmail(user.getEmail());
        if(!dao.getName().equals(user.getName())){
            dao.setName(user.getName());
            userDAO.Update(dao);
        }
        return dao;
    }

    public User deleteUser(User user){
        if(user == null){
            throw new IllegalArgumentException("Usuario está nulo");

        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email do usuário é obrigatório");
        }
        return userDAO.Delete(user.getEmail());
    }

    public User findUser(User user){
        if(user == null){
            throw new IllegalArgumentException("Usuario está nulo");

        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email do usuário é obrigatório");
        }
        return userDAO.FindByEmail(user.getEmail());
    }

    public Iterable<User> findAllUsers(){
        return userDAO.FindAll();  

    }


}
