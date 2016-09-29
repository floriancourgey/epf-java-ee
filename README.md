# Projet Java EE Florian Courgey
## Environnement
- OS : elementary OS 0.4 (basé sur Ubuntu 16.04)
- IDE : Eclipse neon.1 java EE
- Serveur : Wildfly 8.2.1 (installé via Eclipse)
- Java : jdk 1.8, output de `java -version`
```
java version "1.8.0_101"
Java(TM) SE Runtime Environment (build 1.8.0_101-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.101-b13, mixed mode)
```

## Installation
La racine du projet Eclipse se trouve dans `projet/`

Il faut lancer un `bower install` en ligne de commande dans `projet/WebContent`

Pour vérifier si le frontend est OK : http://localhost:8080/java-ee-0.0.1-SNAPSHOT/index.html

Pour vérifier si les servlets sont OK : http://localhost:8080/java-ee-0.0.1-SNAPSHOT/test

URL d'accueil : http://localhost:8080/java-ee-0.0.1-SNAPSHOT/computers

## Bonus 1 : Google
Sur la page d'accueil (/computers), il est possible de rechercher un ordinateur. Cette recherche fonctionne --presque-- comme google : elle est insensible à la casse, elle utilise un LIKE %...% et elle cherche à la fois dans le nom de l'ordinateur et dans le nom de son entreprise.

Ainsi, la recherche `appl` nous donne par exemple des ordinateurs avec pour nom `Apple III` et des ordinateurs avec pour entreprise `Apple Inc.`

## Bonus 2 : Form generator
Je me suis axé sur la création d'un générateur de formulaire (inspiré de [celui de Symfony](http://symfony.com/doc/current/forms.html))

Un formulaire est composé de plusieurs widgets (input, textarea, select..) qui ont chacun une liste de validateurs (ce sont des règles sur leur value="").

A l'envoi du formulaire, les `value` de chaque widget sont validées par les validateurs. Toute erreur nous ramène sur la page du formulaire, avec le détail des erreurs.

### Création du widget
On crée un widget avec 
```java
FormWidget widget = new FormWidget("name") // correspond aux attributs id="" et name=""
			.setLabel("Name") // nom à afficher dans le <label/>
			.setType(FormWidget.Type.INPUT) // c'est un input
			.setValidators(validators) // liste de validateurs (voir ci-dessous)
			.setAttributes(attributes) // liste d'attributs html supplémentaires (voir ci-dessous)
```

où `validators` est une liste de validateurs qui sera checkée dans la servlet doPost :
```java
ArrayList<FormValidator> validators = new ArrayList<FormValidator>();
validators.add(new FormValidatorMinLength(6)); // taille max 6
validators.add(new FormValidatorMaxLength(15)); // taille max 15
```

et `attributes` une liste d'attributs HTML à écrire dans la JSP
```java
HashMap<String, String> attributes = new HashMap<String, String>();
attributes.put("placeholder", "Enter computer's name");
attributes.put("required", "required");
```

### Création du form
Une fois les widgets créés, on les ajoute au form :

```java
FormGenerator form = new FormGenerator(new FormWidget[]{
  widget1,
	widget2,
	widget3
});
```

## Conventions Git
Les commits sont préfixés par
* + pour un ajout
* - pour une suppression
* * pour une modification
* ! pour un fix

## Todo
* fixer le computerDao#google qui cherche que les computers avec entreprise non null
* finir le FormGenerator (ex : FormWidget.TYPE n'est pas géré)
* computerAdd n'ajoute pas d'entreprise
* changer le format de la date dans computerAdd (et ajouter jquery Calendar)

# Enoncé original

## training-computer-database-template


### Problématique
Un client vous a demandé de développer une application web pour la gestion de son parc d'ordinateur. Il vous fournit une base de données et un template sur lequel s'appuyer pour tout ce qui est graphique.

Il veut pouvoir :
* lister les ordinateurs
* Ajouter un ordinateur

Les ordinateur ont un nom, une date d'entrée dans le parc de l'entreprise et une date de sortie s'ils ne sont plus présents. Ils ont aussi une compagnie, qui correspond à leur constructeur. Il vous a prévenu aussi que la base de données n'est pas consistante : il faudra dons faire attention aux données.

### Contraintes
L'application que vous allez développer doit être en Java/JEE et doit utiliser les technologies correspondantes.

Vous devrez proposer une architecture n-tier et utiliser les tags JSTL dans les JSP.

Vous avez le choix pour l'accès à la BDD et pourrez utiliser soit JDBC soit Hibernate.

### Bonus
Vous pourrez proposer des fontionnalités supplémentaires utiles dans le cadre de la problématique.

Vous pourrez aussi présenter une autre interface que celle proposée.

Si vous avez une autre idée, envoyez moi un mail à malbert@excilys.com et nous verrons ensemble si c'est une bonne idée et si vous pourrez la faire.

### Instructions
Dans le dossier projet, vous avez 2 scripts sql à éxécuter dans l'ordre (1 puis 2) pour créer votre BDD.

Le projet est à rendre avant le 30/09 23h59.

Vous pouvez le rendre soit par git (pull request) soit par mail avec le war zippé (Sous eclipse File -> Export -> Web -> WAR file -> cochez export sources files)
