package com.example.springmodels.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ModelUser {
    public ModelUser() {
    }// Пустой конструктор

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_User; // Уникальный идентификатор пользователя

    private String username; // Имя пользователя
    private String password; // Пароль
    private boolean active; // Флаг активности пользователя

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER) // Коллекция ролей пользователя
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id")) // Таблица для хранения ролей
    @Enumerated(EnumType.STRING) // Перечисление ролей

    private Set<RoleEnum> roles; // Набор ролей пользователя

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Один ко многим, каскадное удаление адресов
    @JoinColumn(name = "address_person_id") // Связь по идентификатору адреса
    private Set<Address> addresses; // Набор адресов пользователя

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Один ко многим, каскадное удаление заявок
    @JoinColumn(name = "application_person_id") // Связь по идентификатору заявки
    private Set<Application> applications; // Набор заявок пользователя

    // Метод для получения ID пользователя
    public Long getID_User() {
        return ID_User;
    }

    // Метод для установки ID пользователя
    public void setID_User(Long ID_User) {
        this.ID_User = ID_User;
    }

    // Метод для получения имени пользователя
    public String getUsername() {
        return username;
    }

    // Метод для установки имени пользователя
    public void setUsername(String username) {
        this.username = username;
    }

    // Метод для получения пароля пользователя
    public String getPassword() {
        return password;
    }

    // Метод для установки пароля пользователя
    public void setPassword(String password) {
        this.password = password;
    }

    // Метод для проверки активности пользователя
    public boolean isActive() {
        return active;
    }

    // Метод для установки активности пользователя
    public void setActive(boolean active) {
        this.active = active;
    }

    // Метод для получения ролей пользователя
    public Set<RoleEnum> getRoles() {
        return roles;
    }

    // Метод для установки ролей пользователя
    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }

    // Объявление конструктора для класса ModelUser с параметрами: username,
    // password, active, roles
    public ModelUser(String username, String password, boolean active, Set<RoleEnum> roles) {
        // Присваивание значений параметров конструктора переменным внутри класса
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }
}
