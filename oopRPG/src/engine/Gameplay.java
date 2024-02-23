package engine;

import character.Player;
import character.NPC;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Gameplay {
	
	public static void main(String []args) {
		System.out.printf("Game Start%n%n");
		
		boolean playerTurn = true;
		Random rand = new Random();
		
		Player player = new Player("Fighter", 10, 4, 2);
		NPC npcs[] = new NPC[rand.nextInt(4) + 1];
		
		for(int i = 0; i < npcs.length; i++) {
			npcs[i] = new NPC("Goblin " + (i + 1), rand.nextInt(5) + 5, rand.nextInt(3) + 2, rand.nextInt(3) + 2, rand.nextInt(5) + 5);
		}
		
		System.out.printf("You have encoutered %d goldins!%n%n", npcs.length);
		
		while(player.isAlive() && allAlive(npcs)) {
			try {
				TimeUnit.SECONDS.sleep(2);
				if(playerTurn) {
					player.attack(npcs[rand.nextInt(npcs.length)]);
				}else {
					npcs[rand.nextInt(npcs.length)].attack(player);
				}
				
				playerTurn = !playerTurn;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(player.isAlive()) {
			System.out.printf("You have defeated the goldins!%n%n");
		}else {
			System.out.printf("GAME OVER!");
		}
	}
	
	public static boolean allAlive(NPC[] npcs) {
		for (NPC npc : npcs) {
			if(npc.isAlive()) {
				return true;
			}
		}
		
		return false;
	}

}
