public class Exerc2Novo implements Runnable {
	private final int id;

	Exerc2Novo(int id) {
		this.id = id;
	}

	public void run() {
		//System.out.println("[Th" + id + "] Eu sou uma thread, dude...");
		System.out.println( Thread.currentThread().getName() + " Eu sou uma thread, dude..." );
	}

	public static void main (String [] args) {
		if ( args.length != 1 ) {
			System.err.println( "Modo de uso: java Exerc2 <número de threads a criar>" );
			System.exit( 0 );
		}

		final int count = Integer.parseInt( args[0] );

		Thread[] th = new Thread[ count ];

		for (int i = 0; i < count; i++) {
			Exerc2Novo ex2 = new Exerc2Novo( i );
			th[i] = new Thread( ex2, "[Th" + i + "]" );
			//th[i].setName( Integer.toString( i ) );
			th[i].start();

			// numa linha só
			// ( new Thread( new Exerc1() ) ).start();
		}
	}

}
