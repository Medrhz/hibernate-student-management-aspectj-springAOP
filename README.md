# Student Management App with Service Layer & AOP (Spring AOP + AspectJ)

## Description du projet

Cette application Java simple permet de gérer des étudiants (CRUD : création, lecture, mise à jour, suppression) en utilisant le framework **Hibernate ORM** pour interagir avec une base de données relationnelle PostgreSQL.

Le projet a été étendu avec une **couche service** pour une meilleure organisation du code ainsi qu'une **gestion des transactions et du logging via la programmation orientée aspects (AOP)**, combinant **Spring AOP** et **AspectJ**.

## Objectifs

- Maîtriser les bases de **Hibernate** pour la gestion d’entités persistées en base.  
- Organiser le projet en couches (DAO, Service, Aspect) pour une architecture claire et maintenable.  
- Implémenter les opérations CRUD classiques sur une entité `Student`.  
- Appliquer la gestion des transactions et du logging via **AspectJ** et **Spring AOP** pour séparer les préoccupations transversales.  
- Utiliser un système de **logging** performant avec **SLF4J/Logback**.  

## Fonctionnalités / Opérations

- **Créer un étudiant**  
- **Lire tous les étudiants**  
- **Lire un étudiant par ID**  
- **Mettre à jour un étudiant**  
- **Supprimer un étudiant**  
- **Gestion transactionnelle automatique via AOP** (AspectJ + Spring AOP)  
- **Logging des opérations CRUD**  
- **Démonstrations simples** pour chaque opération  

## Architecture & Organisation

- **DAO Layer** : Accès direct aux données avec Hibernate.  
- **Service Layer** : Logique métier, appel aux DAO.  
- **Aspect Layer (AOP)** : Gestion des transactions et logging avant/après les appels, implémentée avec **AspectJ** et intégrée via **Spring AOP**.  

## Technologies utilisées

- **Java 21**  
- **Hibernate ORM 7**  
- **Spring AOP**  
- **AspectJ** (compile-time & load-time weaving support)  
- **PostgreSQL**  
- **Lombok**  
- **SLF4J + Logback**  
- **Maven**

---

*Projet développé pour apprendre et maîtriser les concepts avancés de la persistence en Java, architecture en couches, et programmation orientée aspects avec AspectJ et Spring AOP.*
