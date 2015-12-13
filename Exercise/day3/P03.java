import java.util.*;

class Card<T>{
	T num;
	boolean isKwang;

	Card(T num, boolean isKwang){

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
	ArrayList<Card<String>> cards = new ArrayList<Card<String>>();

	CardDeck(){

		// Card Add
		for(int i = 0; i < 10; i++){
			if(i+1 == 1 || i+1 == 3 || i+1 == 8){
				cards.add(new Card<String>("a"+String.valueOf(i+1), true));
			}
			else{
				cards.add(new Card<String>("a"+String.valueOf(i+1), false));
			}
		}
		for(int i = 0; i < 10; i++){
			cards.add(new Card<String>("a"+String.valueOf(i+1), false));
		}
	}
	// 셔플 알고리즘
	public void shuffle(){

		for(int i = 0; i < CARD_NUM; i++){
			Card<String> tmp_card = cards.get(i);
			int rnd_index = (int) (Math.random()*CARD_NUM);
			while(i == rnd_index){
				rnd_index = (int) (Math.random()*CARD_NUM);
			}
			cards.set(i, cards.get(rnd_index));
			cards.set(rnd_index, tmp_card);
		}
	}

	public Card pick(){
		int rnd_index = (int) (Math.random()*CARD_NUM);
		return cards.get(rnd_index);
	}
	// Pick 오버라이딩
	public Card pick(int index){
		return cards.get(index);
	}
}

class P03{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CardDeck deck = new CardDeck();
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();

		// Print Result
		for(int i = 0; i < deck.CARD_NUM; i++){
			System.out.print(deck.cards.get(i).toString()+", ");
		}
		System.out.println();
		System.out.println(deck.pick(0));
	}
}