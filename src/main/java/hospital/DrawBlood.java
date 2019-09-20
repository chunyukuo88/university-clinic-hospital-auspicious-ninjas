package hospital;

interface DrawBlood {
	
	int amountDrawnByDoc 	= 4;
	int amountDrawnByNurse  = 2;
	
	void drawBlood(Patient patient);
	
}
