package pokemon;

public class Eevee extends Pokemon {

	public Eevee() {
		super("Eevee", 0, 90, "eeveePokemon (1).png", new Move[] 
				{new Move("fire punch", 1, 15, 3),
				new Move("blaze kick", 1, 15, 1),
				new Move("blizzard", 2, 15, 0),
				new Move("aqua ring", 2, 15, 3)});
	}
	
	
}