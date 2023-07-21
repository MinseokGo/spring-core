package com.example.core.singleton;

public class SingletonService {
    //싱글톤 객체
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //private이라 다른 클래스에서 생성하지 못함
    private SingletonService() {
    }

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
