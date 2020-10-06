//Rutger Le Jeune


public class Straight extends Tegel {
	
	public Straight()
	{
		//System.out.println("Begint met het maken van een rechte");
		vakjes[0][0] = new Vakje(Tegel.MUUR);
		vakjes[0][1] = new Vakje(Tegel.LEEG);
		vakjes[0][2] = new Vakje(Tegel.MUUR);
		vakjes[1][0] = new Vakje(Tegel.MUUR);
		vakjes[1][1] = new Vakje(Tegel.LEEG);
		vakjes[1][2] = new Vakje(Tegel.MUUR);
		vakjes[2][0] = new Vakje(Tegel.MUUR);
		vakjes[2][1] = new Vakje(Tegel.LEEG);
		vakjes[2][2] = new Vakje(Tegel.MUUR);
	}

}
