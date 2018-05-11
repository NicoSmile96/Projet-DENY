			RAPPORT PROJET ROGUE-LIKE JAVA

Participants : CHHEANG DENIS, SONNOIS YANN, ANTHENE NICOLAS

Le projet met en scène un guerrier, un mage ou un archer (au choix du joueur) évoluant dans un donjon rempli de monstres. Son but sera d'atteindre la porte du donjon afin d'en atteindre un encore plus dangereux.

Ce qui a été fait :
-L'univers du jeu est généré aléatoirement en debut de partie
-Le jeu permet de faire évoluer un personnage au tour par tour 
-Le joueur peut choisir d'être un mage un guerrier ou un archer
-Le jeu comporte des PNJ (monstres,marchands)
-Le PJ possède des points de vie ainsi que de l'équipement (potion,monnaie)
-Le PJ peut interagir avec son environnement (combattre,ramasser un objet)
-Les PNJ obeissent aux mêmes règles que le joueur mais sont contrôlés par le jeu-Une interface spécifique est proposée pour la création de joueur et l'accès à l'inventaire
-La partie peut être sauvegardée et restituée à tout moment.

Ce qui n'a pas été fait : 
-L'équipement type arme ou armure
-Fenêtre de selection de sort


Description d'un scenario de démonstration :
	Le joueur créer un mage. La particularité du mage est sa capacité à attaquer à une distance de 2 case avec 2 points de degats. La map de 1er niveau se génère aléatoirement. 
	Le joueur évolue alors dans le donjon et a pour but d'atteindre la porte située à l'opposé de ce dernier. 
	Il tue plusieurs monstre sur son passage, gagne de l'experience ainsi que de l'or et gagne par consequent un  niveau, réinitialisant ses points de vie et augmentant ses degats ainsi que sa vie maximum.
	Au niveau 3, il croise un marchand lui proposant des potions moyennant quelques pièces d'or. 
	Le joueur est donc libre d'en acheter la quantité qu'il souhaite.Quelques niveaux plus tard, le joueur decede face aux terribles monstres du donjon et devra alors recommencer du debut.

Manuel d'utilisateur : 
	Le but du jeu est d'atteindre la porte située à l'opposé du personnage. L'etage maximum est fixé à 10 (mais bonne chance pour y arriver !).
	En debut de partie, une interface vous propose de choisir votre classe.
	Tapez guerrier pour Guerrier, mage pour Mage ou archer pour un Archer.

	Le guerrier est un combattant au corps à corps avec beaucoup de points de vie et de degats.
	Le mage est un combattant à distance avec des points de vie intermédiaire et des degats intermediaire.
	L'archer est un combattant à longue distance avec peu de point de vie et peu de degats. 

Commandes en jeu : 
	Déplacement : 
	"z" monter d'une case
	"q" aller à gauche
	"s" descendre
	"d" pour aller à droite

	Inventaire :
	"i" pour accèder à l'inventaire
	"boire potion" pour boire une potion

	Interaction avec les pnjs :
	Attaquer un monstre (si à portée) : "attaquer"
	Parler à un marchand (distance de 1 case maximum) : "parler"

	Sauver partie : "save"
	Charger partie : "load"

Manuel technique :
Implémentation de la carte :
	La carte est donc générée à l'aide de caractères ASCII. Ces caractères sont définis dans une énumération puis générés à l'aide de plusieurs boucles dans le constructeur d'une classe nommée Grille.
	Un objet de type grille est ensuite instancié dans une classe affichage ayant pour fonction d'afficher la carte ainsi que les informations du jeu.

Implémentation des joueurs et des monstres :
	Les joueurs et les monstres sont deux classes qui héritent d'une classe abstraite "Perso". Les variables et methodes communes aux PJ et PNJ sont définies dans cette classe. Les 2 classes "joueur" et "mob"
	incluent quant à elles des constructeurs differents permettant d'instancier ces 2 classes.

Implémentation des classes de personnage :
	Les classes de personnages sont gérées à l'aide d'une énumération implémentant une interface Action. L'énumération redéfinie les attributs de degats,vie,vie maximum et range (portée d'attaque) 
	en fonction de la classe du personnage ou du monstre. 
	Nous avons choisis l'énumération plutôt que les classes car elle nous semblait appropriée pour redefinir seulement 4 attributs. De plus, elle pouvait ainsi être utilisée par les classes de type joueur et de type mob.
	L'interface action permet de redefinir des methodes differentes pour les joueurs et pour les mobs.

Actions Joueur :
	Dans la boucle de jeu principale, à l'aide de l'objet Scanner, nous récupérons une chaîne de caractères saisie par l'utilisateur. La chaîne est alors comparée avec les commandes qu'il est possible d'effectuer.
	Les objets joueur et mobs héritant de l'objet personnage, les méthodes spécifiques qui correspondent à ces classes filles sont redéfinies et les actions réalisables différent donc, d'un type à l'autre.
	De plus, selon le type "Typeclasse" du personnage, les statistiques et les méthodes différeront également. 

Interaction avec les pnjs :
	Si un monstre se trouve à portée d'attaque, la méthode inRange de l'objet joueur le signale à l'utilisateur, via un affichage dans le terminal. Il lui rappelle les commandes possibles pour intéragir avec.
	Si un marchand se trouve à une case directement adjacente, la même méthode surchargée signale sa présence au joueur. Il peut discuter avec lui afin de faire des achats.

Sauvegarde/Chargement :
	A tout moment, l'utilisateur peut taper la commande "save" pour sauvegarder la partie dans un fichier, ou "load" pour recharger à la dernière sauvegarde connue.
	A chaque appel de save, le fichier de sauvegarde est écrasé. Réfléchissez donc bien à votre stratégie avant d'écraser votre sauvegarde !
	Ces commandes stockent les données de l'objet Data dans le fichier "sauvegarde.txt". C'est ce même fichier qui est lu lors d'un appel à "load".
	Les exceptions sont toutes capturées, dans le cas où les fichiers n'existent pas ou si la lecture/écriture a échouée.

Génération des mobs :
	Les mobs sont générés aléatoirement entre 2 valeurs s'incrementants en fonction de l'étage. Ils sont stockés dans une liste de type Arraylist dans laquelle ils sont ajoutés lors de leur génération puis retirer lors de leur mort.

Compilation/Exécution :
	Suivant le modèle imposé, à l'aide de gradlew.
