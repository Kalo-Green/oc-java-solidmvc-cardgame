# 🃏 Card Game - Java, MVC & SOLID

Projet réalisé dans le cadre du cours OpenClassrooms **« Écrivez du code Java maintenable avec MVC et SOLID »**.

L'objectif du projet est de développer un jeu de cartes en Java tout en appliquant des principes de conception permettant d'obtenir un code **maintenable et évolutif**.

## 🎯 Présentation

Card Game est un jeu basé sur un paquet classique de **52 cartes**.

Le projet permet notamment de :

* gérer plusieurs joueurs ;
* distribuer une carte à chaque joueur ;
* déterminer le gagnant selon différentes règles ;
* utiliser différentes interfaces pour afficher le jeu.

## 🏗️ Architecture

Le projet s'appuie sur l'architecture **MVC (Model-View-Controller)** :

```text
src/
└── com/openclassrooms/cardgame/
    ├── model/
    ├── view/
    ├── controller/
    └── games/
```

* **Model** : représente les éléments du jeu et les données.
* **View** : gère l'affichage et les interfaces utilisateur.
* **Controller** : coordonne le déroulement du jeu.
* **Games** : contient les règles d'évaluation du jeu ainsi que le point d'entrée permettant de configurer et lancer une partie.

### Évaluation des parties

L'interface `GameEvaluator` permet de définir différentes règles d'évaluation :

```text
GameEvaluator
├── HighCardGameEvaluator
└── LowCardGameEvaluator
```

Le `GameController` dépend de l'interface `GameEvaluator`, ce qui permet de changer la règle du jeu sans modifier le contrôleur.

## 🧱 Principes et conception

Le projet met en pratique :

* Architecture **MVC**
* Principes **SOLID**
* Programmation orientée objet
* Interfaces et polymorphisme
* Séparation des responsabilités
* Design patterns

## 🖥️ Interfaces

Le projet comprend :

* une interface en ligne de commande ;
* une interface graphique développée avec **Java Swing** ;
* plusieurs vues Swing permettant d'afficher l'état du jeu.

## 🛠️ Technologies

* **Java**
* **Java Swing**
* **Git**
* **GitHub**

## 🚀 Lancer le projet

1. Cloner le dépôt.
2. Importer le projet dans un IDE Java.
3. Exécuter la classe `Games.java`.

## 📚 Compétences mises en pratique

Ce projet m'a permis de renforcer mes compétences en **conception et développement Java**, en mettant en pratique **l'architecture MVC**, les principes **SOLID**, la **programmation orientée objet**, ainsi que les **interfaces et le polymorphisme** pour concevoir une application structurée, maintenable et évolutive.
