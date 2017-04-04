public class GuitarHero {

	private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

	public static void main(String[] args) {
		synthesizer.GuitarString[] strings = new synthesizer.GuitarString[37];
		for (int i = 0; i < 37; i++) {
			double concert = 440 * Math.pow(2, ((i - 24) / 12.0));
			strings[i] = new synthesizer.GuitarString(concert);
		}

		while (true) {
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				int index = keyboard.indexOf(key);
				strings[index].pluck();
			}

			double sample = 0;
			for (int i = 0; i < 37; i++) {
				sample = sample + strings[i].sample();
			}

			StdAudio.play(sample);

			for (int i = 0; i < 37; i++) {
				strings[i].tic();
			}
		}
	}

}