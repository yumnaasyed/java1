package introJava;

public class ExcitedBot extends ChatBot {

	public ExcitedBot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayHi() {
		// TODO Auto-generated method stub
		System.out.println("Hi! It's so nice to meet you!");

	}

	@Override
	public void sayBye() {
		// TODO Auto-generated method stub
		System.out.println("Ok! Im sorry, I have to go, but it was so nice talking to you! Bye!");

	}

	@Override
	public void startConversation() {
		// TODO Auto-generated method stub
		System.out.println("How are you doing?! Can we talk?");

	}

	@Override
	public void askFirstQuestion() {
		// TODO Auto-generated method stub
		System.out.println("What is your favorite tv show?! I watch a lot of tv!");

	}

	@Override
	public void askSecondQuestion() {
		// TODO Auto-generated method stub
		System.out.println("Thats so cool!, do you like to swim?");

	}

	@Override
	public void askThirdQuestion() {
		// TODO Auto-generated method stub
		System.out.println("me too!, do you mind if I leave?");

	}

}
