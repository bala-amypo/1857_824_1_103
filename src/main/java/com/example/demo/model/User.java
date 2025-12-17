package com.example.demo.model;

@Entity
public class User{
   private String username;
   private String email;
   private int age;

   public User(){

   }

   public User(String username, String email, int age){
    this.username=username;
    this.email=email;
    this.age=age;
   }

   public String getUsername(){
    return username;
   }
   public void setUsername(Stringusername){
    this.username=username;
   }
   public String getEmail(){
    return email;
   }
   public void setEmail(String email){
    this.email=email;
   }
   public int getAge(){
    return age;
   }
   public 
}