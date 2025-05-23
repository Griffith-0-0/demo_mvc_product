﻿# Demo MVC Products Application

Une application de gestion de produits construite avec Spring Boot, Spring MVC, Spring Data JPA et Spring Security.

## Table des matières

- [Présentation](#présentation)
- [Fonctionnalités](#fonctionnalités)
- [Technologies utilisées](#technologies-utilisées)
- [Configuration requise](#configuration-requise)
- [Installation](#installation)
- [Structure du projet](#structure-du-projet)
- [API REST](#api-rest)
- [Sécurité](#sécurité)
- [Captures d'écran](#captures-décran)
- [Auteurs](#auteurs)
- [Licence](#licence)

## Présentation

Cette application permet de gérer un catalogue de produits avec des opérations CRUD (Create, Read, Update, Delete). Elle intègre une interface utilisateur web basée sur Thymeleaf et une API REST pour l'accès programmatique.

## Fonctionnalités

- **Gestion des produits**:
  - Listage des produits avec pagination
  - Recherche par nom de produit
  - Ajout de nouveaux produits
  - Modification de produits existants
  - Suppression de produits
  - Validation des données (nom, prix, quantité)

- **Interface utilisateur**:
  - Interface responsive avec Bootstrap
  - Formulaires avec validation côté client et serveur
  - Pagination pour la liste des produits
  - Confirmation pour les opérations critiques

- **Sécurité**:
  - Authentification par formulaire
  - Deux niveaux d'accès: utilisateur et administrateur
  - Protection des opérations sensibles (ajout, modification, suppression)

## Technologies utilisées

- **Backend**:
  - Java 21
  - Spring Boot 3.4.4
  - Spring MVC
  - Spring Data JPA
  - Spring Security
  - Hibernate Validator
  - Lombok

- **Frontend**:
  - Thymeleaf
  - Bootstrap 5.3.5
  - HTML/CSS/JavaScript

- **Base de données**:
  - MySQL 8
  - H2 (pour les tests)

## Configuration requise

- JDK 21+
- Maven 3.6+
- MySQL 8+

## Installation

1. **Clonez le dépôt**:
   ```bash
   git clone https://github.com/username/demo-MVC-products.git
   cd demo-MVC-products
   ```

2. **Configurez la base de données**:
   - Créez une base de données MySQL nommée `db_cat_mvc`
   - Modifiez les propriétés de connexion dans `src/main/resources/application.properties` si nécessaire

3. **Construisez et exécutez l'application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Accédez à l'application**:
   - Ouvrez votre navigateur à l'adresse `http://localhost:8080`
   - Utilisez les identifiants par défaut:
     - Admin: `admin` / `1234`
     - User: `user` / `1234`

## Structure du projet

demo-MVC-products/ 
├── src/ 

│ ├── main/ 

│ │ ├── java/ 

│ │ │ └── org/example/demomvcproducts/ 

│ │ │ ├── entities/ # Entités JPA 

│ │ │ ├── repository/ # Repositories Spring Data JPA 

│ │ │ ├── sec/ # Configuration de sécurité 

│ │ │ ├── web/ # Contrôleurs MVC et REST 

│ │ │ └── DemoMvcProductsApplication.java 

│ │ └── resources/ 

│ │ ├── templates/ # Templates Thymeleaf 

│ │ ├── static/ # Ressources statiques

│ │ └── application.properties 

│ └── test/ # Tests unitaires et d'intégration 

└── pom.xml # Configuration Maven


## API REST

L'application expose une API REST pour l'accès programmatique:

- `GET /products` - Liste tous les produits
- `GET /products/{id}` - Récupère un produit par son ID

## Sécurité

L'application utilise Spring Security avec deux rôles:

- **USER**: peut visualiser et rechercher des produits
- **ADMIN**: peut ajouter, modifier et supprimer des produits

Les utilisateurs sont définis en mémoire dans `SecurityConfig.java`:
- Admin: `admin` / `1234` (rôles: ADMIN, USER)
- User: `user` / `1234` (rôle: USER)

Les accès sont contrôlés via des annotations `@PreAuthorize` sur les méthodes du contrôleur.

## Auteurs

- Votre Nom - [GitHub](https://github.com/Griffith-0-0)

## Licence

Ce projet est sous licence [MIT](LICENSE).
