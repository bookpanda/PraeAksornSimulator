# PraeAksornSimulator
<img src="images/gameplay_2.png" alt= "gameplay_2" width="50%">

## Installation
You must have Java and JavaFX installed (preferably jdk-19 with JavaFX-sdk-20 )
- git clone https://github.com/bookpanda/PraeAksornSimulator.git
- go to the root directory (./PraeAksornSimulator)
- java -jar --module-path "C:\Program Files\javafx-sdk-20\lib" --add-modules javafx.base,javafx.controls,javafx.graphics,javafx.media,javafx.fxml PraeAksornSimulator.jar

(this path is just an example path to JavaFX library jar files)

## Introduction
PraeAksorn Simulator is inspired by real-life card stunt, which involves assembling a large number of colored papers together to form an image. The objective of this game is to allow you to experience card stunts and form an image within a time limit.
  
## Rules
There are 5 rounds, each having 90 seconds to complete. In each round, players will receive an image they need to create. The instruction paper is presented in the second slot in the inventory. Players must complete the image by flipping pages of colored paper books within the given time limit while referring to the color codes on the instruction paper. Additionally, they must allocate time for drinking water and eating meals to avoid getting exhausted during the card stunt process.

If the hunger or thirst level is below 100, you cannot flip any pages. Moreover, 100 points are deducted every second thirst is lower than 100. You can pause and resume half-way through the game without penalties.

  
## Gameplay
- When you drag a paper up, it will change to the next page. And when you drag a paper down onto the stack, it will go back to the previous page. You can open multiple pages by pressing Shift (3-5 pages) or Ctrl (7-10 pages).
- When you pull the rubber band far enough away from any notebook, that notebook will close.
- You can use the mouse scroll wheel to select different items. There will be an instruction paper available to view color codes. There are also meals and water available to replenish hunger and thirst.


## Scenes

| Preview      |     |      |
|  :----:  |  :----:  |  :----:  |
| <img src="images/home.png" alt= "home" width="100%"> <p>Home</p> | <img src="images/rules.png" alt= "rules" width="100%"> <p>Rules</p> | <img src="images/gameplay_1.png" alt= "gameplay_1" width="100%"> <p>Gameplay 1</p> |
| <img src="images/gameplay_2.png" alt= "gameplay_2" width="100%"> <p>Gameplay 2</p> | <img src="images/gameplay_3.png" alt= "gameplay_3" width="100%"> <p>Gameplay 3</p> | <img src="images/gameplay_4.png" alt= "gameplay_4" width="100%"> <p>Gameplay 4</p> |


## Codes
These images are created using [AutoPraeAksorn](https://github.com/bookpanda/AutoPraeAksorn)

| Preview      |     |      |
|  :----:  |  :----:  |  :----:  |
| <img src="src/images/amogus_stand.png" alt= "amogus" width="100%"> <p>Amogus</p> | <img src="src/images/attack_on_titan_stand.png" alt= "attack_on_titan" width="100%"> <p>Attack on Titan</p> | <img src="src/images/demon_slayer_stand.png" alt= "demon_slayer" width="100%"> <p>Demon Slayer</p> |
| <img src="src/images/eighty_six_stand.png" alt= "eighty_six" width="100%"> <p>Eighty Six</p> | <img src="src/images/jojo_stand.png" alt= "jojo" width="100%"> <p>Jojo</p> | <img src="src/images/kessoku_stand.png" alt= "kessoku" width="100%"> <p>Kessoku</p> |
| <img src="src/images/one_piece_stand.png" alt= "one_piece" width="100%"> <p>One Piece</p> | <img src="src/images/oshi_no_ko_stand.png" alt= "oshi_no_ko" width="100%"> <p>Oshi No Ko</p> | <img src="src/images/vinland_saga_stand.png" alt= "vinland_saga" width="100%"> <p>Vinland Saga</p> |

