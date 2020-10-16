# Gestion de fiche de personnage pour Jeu de Rôle

Pour ce projet, nous construirons un petit site web primitif dans le but d'avoir un outil nous permettant de faire une gestion, autant pour les joueurs que pour les maîtres du jeu (MJ), des différentes fiches de personnage.

## Cahier des Charges

### Description

Le site devra répondre aux différentes fonctionalités listées ci-dessous :

- Un utilisateur pourras créer ou supprimer son compte.
- Un utilisateur créer une campagne, ou participer à une campagne.
  - Si l'utilisateur crée une campagne, ce dernier est automatiquement MJ de cette campagne.

- Une joueur peut rejoindre une campagne seulement si la limite de joueur n'as pas été atteinte.
  - Un MJ peut aussi ajouter un joueur à une campagne.

- Le MJ peut ajouter ou supprimer n'importe quel utilisateur à sa campagne. -dans la limite du nombre de place fixé-
- Un MJ ne peut pas être joueur dans sa propre campagne.

- Un administrateur peut supprimer n'importe quel compte.

- Un joueur peut modifier les données de ses fiches de personnages. (Mettre en readonly ?)
- Un MJ peut modifier les fiches des personnages associés à ses campagnes.

- Les fiches de personnage contiennent :
  - Nom du personnage
  - Sa classe
  - Sa race
  - Une description
  - Son nombre de hitpoint (HP) maximum
  - Son nombre de HP actuel
  - Sa quantité de point d'expérience
  - Son niveau
  - Son intelligence
  - Sa force
  - Sa dextérité
  - Son charisme
  - Sa constitution
  - Ses compétences -qui seront différents en fonction de la campagne-

### Base de donnée

Un utilisateur possède :

- __Un nom d'utilisateur__
- Un mot de passe
- Est-il administrateur ?

Une campagne possède un type, celui-ci permettras plus tard de définir la section compétence d'une fiche de joueur.
Celle-ci possède :

- __Un identifiant unique__
- Un nom
- Un template -un bloc text contenant les différentes compétences séparées par des virgules-

L'utilisateur peut créer autant de campagne qu'il veut, en revanche une campagne n'appartient qu'à une seule personne -son MJ-
Celle-ci possède :

- __Un identifiant unique__
- Une limite de joueur -qui sera décrementé lorsqu'un nouveau joueur joindras-
- Un MJ clé étrangère faisant réference à l'identifiant de son créateur
- Un type clé étrangère faisant réference à son type de campagne

L'utilisateur peut créer autant de fiche de personnage qu'il veut, cependant il ne peut en faire qu'une seule par campagne.
Une fiche de personnage contient :

- __idcampagne__ clé étrangère faisant réference à la campagne à laquelle le personnage appartient
- __nommcreateur__ clé étrangère faisant référence au créateur de cette fiche de personnage
- Les différent composant d'une fiche de personnage vu dans la section prédédente

Note : Les compétences seront enregistré en JSON dans un format texte, par exemple :
`"{\"c1\" : 1, \"c2\" : 3, \"c3\" : 10}"`

Vous trouverez ci-dessous un schéma représentant le base de donnée (voir API):

![Schéma de la base de donné](doc/images/schemabdd.png?raw=true "Schéma de la BDD")

### API

TODO

### Interface Web

TODO

## Technologies utilisées

TODOEVENTUELLEMENT
