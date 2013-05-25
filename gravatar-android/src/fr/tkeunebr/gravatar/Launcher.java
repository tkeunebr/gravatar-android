package fr.tkeunebr.gravatar;

public class Launcher {
	public static void main(String[] args) {
		Gravatar g = new Gravatar.Builder().fixedSize(500).build();

		for (int i = 0; i < 3; i++) {
			System.out.println(g.with("tamere" + i + "@gmail.com").forceDefault().build());
			System.out.println();
			System.out.println(Gravatar.init().with("coucou").size(100).build());
			System.out.println();
		}

		System.out.println(Gravatar.init().with("alexandre.masciulli@gmail.com").force404().rating(Gravatar.Rating.x).size(Gravatar.MAX_IMAGE_SIZE_PIXEL).build());
		System.out.println();
		System.out.println();
		final Gravatar grav = new Gravatar.Builder().ssl().build();
		System.out.println(grav.with("thomas.keunebroek@gmail.com").rating(Gravatar.Rating.x).force404().size(500).build());
	}
}
