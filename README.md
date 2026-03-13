# Todo Application - Spring Boot


![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.4-brightgreen?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-Build-red?logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-green)




Application web de gestion de tâches développée avec **Spring Boot**, **Thymeleaf**, **Spring Data JPA** et **PostgreSQL**.

Ce projet permet de gérer une liste de tâches avec une interface web simple et une persistance des données dans une base de données relationnelle.

---

# Technologies

<p align="left">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="50"/>
</p>

* Java 21
* Spring Boot 3.4
* Spring MVC
* Spring Data JPA
* Hibernate
* Thymeleaf
* PostgreSQL
* H2 Database (pour le développement)
* Maven

---

# Fonctionnalités

L'application permet de gérer une liste de tâches avec les opérations CRUD complètes :

* Ajouter une tâche
* Modifier une tâche existante
* Supprimer une tâche
* Lister toutes les tâches
* Marquer une tâche comme terminée

Chaque tâche contient :

* un identifiant
* un titre
* une description
* un statut (`EN_COURS` ou `TERMINE`)

Les données sont persistées grâce à **Spring Data JPA** et **Hibernate**.

---

# Base de données

L'application supporte deux bases de données selon le profil Spring actif.

## Développement

Utilise **H2**, une base en mémoire légère permettant de tester rapidement l'application.

## Production

Utilise **PostgreSQL** pour une persistance durable des données.

La configuration est gérée par les profils Spring :

* `application.properties` → configuration développement (H2)
* `application-prod.properties` → configuration production (PostgreSQL)

---

# Configuration PostgreSQL

L'application utilise la configuration suivante :

```
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
spring.datasource.username=todo_user
spring.datasource.password=todo_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Identifiants PostgreSQL

Pour faciliter le lancement du projet, les identifiants suivants sont utilisés :

| Paramètre       | Valeur        |
| --------------- | ------------- |
| Base de données | todo_db       |
| Utilisateur     | todo_user     |
| Mot de passe    | todo_password |
| Port            | 5432          |

⚠️ Ces identifiants sont fournis uniquement pour un usage **de développement ou de démonstration**.

En production, il est recommandé d'utiliser des identifiants sécurisés.

---

# Installation

### 1. Cloner le projet

```
git clone https://github.com/Ahmed-loum/Todo.git
cd Todo
```

### 2. Créer la base PostgreSQL

Se connecter à PostgreSQL :

```
sudo -i -u postgres
psql
```

Créer la base et l'utilisateur :

```
CREATE DATABASE todo_db;

CREATE USER todo_user WITH PASSWORD 'todo_password';

GRANT ALL PRIVILEGES ON DATABASE todo_db TO todo_user;
```

---

# Lancer l'application

Avec Maven :

```
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

Ou en générant le JAR :

```
mvn package
java -jar target/myToDo-1.0-SNAPSHOT.jar
```

L'application sera accessible sur :

```
http://localhost:8080
```

---

# Structure de la base de données

Table principale : `task`

| Colonne     | Type    | Description             |
| ----------- | ------- | ----------------------- |
| id          | bigint  | Identifiant unique      |
| title       | varchar | Titre de la tâche       |
| description | varchar | Description             |
| status      | varchar | `EN_COURS` ou `TERMINE` |

Les tables sont générées automatiquement grâce à :

```
spring.jpa.hibernate.ddl-auto=update
```

---

# Auteur

Projet réalisé dans le cadre d'un apprentissage de **Spring Boot et PostgreSQL**.

Auteur : **Baye Ahmadou Khary LOUM**
