import java.util.*;

class Card{
	int num;
	boolean isKwang;

	Card(int num, boolean isKwang){
		
		// 생성자 선언
		this.num = num;
		this.isKwang = isKwang;
	}

	public String toString(){

		// toString 오버라이딩
		return num + (isKwang? "K":"");
	}

}

class CardDeck{
	final int CARD_NUM = 20;
	Card cards[] = new Card[CARD_NUM];

	CardDeck(){

		// Card Add
		for(int i = 0; i < 10; i++){
			if(i+1 == 1 || i+1 == 3 || i+1 == 8){
				cards[i] = new Card(i+1, true);
			}
			else{
				cards[i] = new Card(i+1, false);
			}
		}
		for(int i = 0; i < 10; i++){
			cards[i+10] = new Card(i+1, false);
		}
	}
}

class P02{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CardDeck deck = new CardDeck();

		// Print Result
		for(int i = 0; i < deck.CARD_NUM; i++){
			System.out.print(deck.cards[i].toString()+", ");
		}
		System.out.println();
	}
}