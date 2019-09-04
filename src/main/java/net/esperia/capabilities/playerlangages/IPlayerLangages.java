package net.esperia.capabilities.playerlangages;

public interface IPlayerLangages {
	
	public void setLangages(int langage, int value);
	
	public void setLangages(int[] langages);
	
	public int[] getLangages();

	public int getLangages(int langage);

}
