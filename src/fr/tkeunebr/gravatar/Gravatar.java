package fr.tkeunebr.gravatar;

public class Gravatar {
	public static final int MIN_IMAGE_SIZE_PIXEL = 1;
	public static final int MAX_IMAGE_SIZE_PIXEL = 2048;
	static Gravatar singleton = null;
	final boolean ssl;
	final boolean extension;
	final int fixedSize;

	private Gravatar(boolean ssl, boolean extension, int fixedSize) {
		this.ssl = ssl;
		this.extension = extension;
		this.fixedSize = fixedSize;
	}

	public static Gravatar init() {
		if (singleton == null) {
			singleton = new Builder().build();
		}
		return singleton;
	}

	public RequestBuilder with(String email) {
		return new RequestBuilder(this, email);
	}

	public static class Builder {
		private boolean ssl = false;
		private boolean extension = false;
		private int fixedSizeInPixel = -1;

		public Builder() {
		}

		public Builder ssl() {
			this.ssl = true;
			return this;
		}

		public Builder showExtension() {
			this.extension = true;
			return this;
		}

		public Builder fixedSize(int fixedSizeInPixel) {
			this.fixedSizeInPixel = fixedSizeInPixel;
			return this;
		}

		public Gravatar build() {
			return new Gravatar(ssl, extension, fixedSizeInPixel);
		}
	}

	public static class DefaultImage {
		public static final int MYSTERY_MAN = 0;
		public static final int IDENTICON = 1;
		public static final int MONSTER = 2;
		public static final int WAVATAR = 3;
		public static final int RETRO = 4;
		public static final int BLANK = 5;
	}

	public static class Rating {
		public static final int g = 0;
		public static final int pg = 1;
		public static final int r = 2;
		public static final int x = 3;
	}
}
