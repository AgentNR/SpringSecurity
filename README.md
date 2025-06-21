# 🔐 Spring Security + JWT Auth

> “Weave your fortress in code,  
> spin tokens like golden threads—  
> secure every heartbeat.”

## 🚀 Project Overview
This is a Spring Boot-powered fortress, snug with Spring Security. Users can **register**, **log in**, and carry a JWT token as their magic key to unlock protected endpoints. No sugar-coating—just rock-solid auth.

## ✨ Key Features
- **User Registration**  
  ✍️ Sign up with username, email & password (BCrypt-hashed, ofc)
- **User Login & JWT Issuance**  
  🛡️ `/api/auth/login` returns a JWT—your ticket to the kingdom
- **Token Validation & Refresh**  
  ⏳ Tokens expire, but you can build a refresh flow if you need it
- **Role-Based Access Control**  
  👑 Grant **USER**, **ADMIN**, or your own special roles

## 🛠️ Tech Stack
- **Java 17+**  
- **Spring Boot 3.x**  
- **Spring Security** & **jjwt** (or **auth0/java-jwt**)  
- **Maven** (or **Gradle**)
- **Mongo DB

## 📋 Prerequisites
- Java 17 or higher  
- Maven 3.6+ (or Gradle 6+)  
- (Optional) Docker for containerized DB



