# ser316-spring2022-B-rpg
Basic CLI dungeon crawling game demonstrating various design patterns

I went with the intertwined approach in which the various design patterns interact and are all in a single package. I was not
able to implement the Decorator design pattern as I had intended, so there are only two design patterns used.

# Design Patterns
### Singleton: The dungeon itself is implemented as a Singleton since many classes depend on knowing things about it.
#### Requirements Fulfilled:
- Small/medium/boss enemy encountered every 1/5/10 floors: the Dungeon singleton keeps track of a difficulty scaling multiplier that spikes at the appropriate levels and is referenced by the various Factory classes
- All enemies get harder as you progress: the dungeon floor and level scaling attribute are used to determine enemy stats
### Factory: Used for constructing most of the objects used in the game; characters, enemies, items, etc.
#### Requirements Fulfilled:
- Shops/Chests should have 3 random items: Factory classes EquipmentFactory and ConsumableFactory generate random items scaled to the current floor
- Small/medium/boss enemy encountered every 1/5/10 floors: The EnemyFactory class generates a random enemy scaled to the current floor
- All enemies get harder as you progress: the dungeon floor and level scaling attribute are used to determine enemy stats
#### Requirements Fulfilled by General Code:
- Character can equip 3 unique item types/logic for replacing current equipment
- Small chance of finding shop/chest after each successful battle
- Potions should not give more health than character's maximum
- Player should return to surface if health is below 15%, which restores health
- Character has minimum stats/requirements (Only mana is not used in this implementation, and no skills or magic powers. Everything else for this requirement is implemented)
- Combat is turn based, combatant loses at 0 HP (and loses money/returns to surface if loser is the player), combatant with highest speed goes first, and both combatants can either attack or use an item

#### The locations of all fulfilled requirements in the code are preceeded by a comment starting with "/*REQUIREMENT:", but are mostly located in Main, Dungeon, EnemyFactory, EquipmentFactory, ConsumableFactory, Entity, and Character. 
